package org.kainos.ea.resources;

import com.auth0.jwt.exceptions.JWTVerificationException;
import io.swagger.annotations.Api;
import org.kainos.ea.api.RegisterService;
import org.kainos.ea.cli.RegisterDetails;
import org.kainos.ea.client.FailedToRegisterException;
import org.kainos.ea.client.InvalidRegisterException;
import org.kainos.ea.client.JWTExpiredException;
import org.kainos.ea.client.RegisterEmailAlreadyExistsException;
import org.kainos.ea.core.RegisterValidator;
import org.kainos.ea.db.DatabaseConnector;
import org.kainos.ea.db.RegisterDao;
import org.kainos.ea.util.JWTUtil;

import javax.ws.rs.HeaderParam;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Api("RRAS Register API")
@Path("/api")
public class RegisterController {
    private final RegisterService registerService = new RegisterService(
            new RegisterDao(), new DatabaseConnector(), new RegisterValidator());

    @POST
    @Path("/register")
    @Produces(MediaType.APPLICATION_JSON)
    public Response register(@HeaderParam("Authorisation") String authHeader,
                             RegisterDetails registerDetails) {
        try {
            if (authHeader == null || !authHeader.startsWith("Bearer ")) {
                return Response.status(Response.Status.BAD_REQUEST)
                        .entity("Invalid or missing Authorisation header").build();
            }

            String jwt = authHeader.substring("Bearer ".length());
            if (!JWTUtil.isAdmin(jwt)) {
                return Response.status(Response.Status.FORBIDDEN).build();
            }
        } catch (JWTExpiredException e) {
            return Response.status(Response.Status.FORBIDDEN).entity(e.getMessage()).build();
        } catch (JWTVerificationException e) {
            return Response.status(Response.Status.BAD_REQUEST).entity(e.getMessage()).build();
        }

        try {
            registerService.register(registerDetails);
            return Response.ok().build();
        } catch (RegisterEmailAlreadyExistsException | InvalidRegisterException e) {
            return Response.status(Response.Status.BAD_REQUEST).entity(e.getMessage()).build();
        } catch (FailedToRegisterException e) {
            return Response.serverError().build();
        }
    }
}