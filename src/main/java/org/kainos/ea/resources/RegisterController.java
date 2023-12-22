package org.kainos.ea.resources;

import io.swagger.annotations.Api;
import org.kainos.ea.api.RegisterService;
import org.kainos.ea.cli.RegisterDetails;
import org.kainos.ea.client.FailedToRegisterException;
import org.kainos.ea.client.InvalidRegisterException;
import org.kainos.ea.client.RegisterEmailAlreadyExistsException;
import org.kainos.ea.core.RegisterValidator;
import org.kainos.ea.db.DatabaseConnector;
import org.kainos.ea.db.RegisterDao;
import org.kainos.ea.util.ControllerUtil;

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
        Response response = ControllerUtil.validAuthHeaderIsAdmin(authHeader);
        if (response != null) {
            return response;
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
