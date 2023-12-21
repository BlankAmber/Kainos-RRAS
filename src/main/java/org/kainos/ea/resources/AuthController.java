package org.kainos.ea.resources;

import io.swagger.annotations.Api;
import org.kainos.ea.api.AuthService;
import org.kainos.ea.cli.Login;
import org.kainos.ea.client.FailedToGenerateTokenException;
import org.kainos.ea.client.FailedToLoginException;
<<<<<<< HEAD
=======
import org.kainos.ea.client.FailedToValidateLoginException;
import org.kainos.ea.db.AuthDao;
import org.kainos.ea.db.DatabaseConnector;
>>>>>>> ready-for-signoff

import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Api("RRAS Auth API")
@Path("/api")
public class AuthController {
<<<<<<< HEAD
    private final AuthService authService = new AuthService();
=======
    private final AuthService authService = new AuthService(new AuthDao(), new DatabaseConnector());
>>>>>>> ready-for-signoff

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
<<<<<<< HEAD
        } catch (FailedToGenerateTokenException e) {
=======
        } catch (FailedToGenerateTokenException | FailedToValidateLoginException e) {
>>>>>>> ready-for-signoff
            System.err.println(e.getMessage());

            return Response.status(Response.Status.INTERNAL_SERVER_ERROR)
                    .entity(e.getMessage()).build();
        }
    }
}
