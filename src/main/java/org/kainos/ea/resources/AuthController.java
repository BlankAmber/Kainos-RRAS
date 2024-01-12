package org.kainos.ea.resources;

import io.swagger.annotations.Api;
import org.kainos.ea.api.AuthService;
import org.kainos.ea.cli.Login;
import org.kainos.ea.client.FailedToGenerateTokenException;
import org.kainos.ea.client.FailedToLoginException;
import org.kainos.ea.client.FailedToValidateLoginException;
import org.kainos.ea.db.AuthDao;
import org.kainos.ea.db.DatabaseConnector;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

@Api("RRAS Auth API")
@Path("/api")
public class AuthController {
    private final AuthService authService = new AuthService(new AuthDao(), new DatabaseConnector());

    public AuthController() {
        // Every 10 seconds the database is pinged.
        // This is a workaround to prevent the problem where if the backend is idle
        // for too long then it stops working temporarily.
        ScheduledExecutorService scheduler = Executors.newSingleThreadScheduledExecutor();
        scheduler.scheduleAtFixedRate(this::ping, 10, 10, TimeUnit.SECONDS);
    }

    @GET
    @Path("/ping")
    @Produces(MediaType.APPLICATION_JSON)
    public Response ping() {
        return Response.ok(authService.ping()).build();
    }

    @POST
    @Path("/login")
    @Produces(MediaType.APPLICATION_JSON)
    public Response login(Login login) {
        try {
            return Response.ok(authService.login(login)).build();
        } catch (FailedToLoginException e) {
            System.err.println(e.getMessage());

            return Response.status(Response.Status.BAD_REQUEST)
                    .entity(e.getMessage()).build();
        } catch (FailedToGenerateTokenException | FailedToValidateLoginException e) {
            System.err.println(e.getMessage());

            return Response.status(Response.Status.INTERNAL_SERVER_ERROR)
                    .entity(e.getMessage()).build();
        }
    }
}
