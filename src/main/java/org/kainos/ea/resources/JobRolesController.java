package org.kainos.ea.resources;

import com.auth0.jwt.exceptions.JWTVerificationException;
import io.swagger.annotations.Api;
import org.kainos.ea.api.JobRolesService;
import org.kainos.ea.client.FailedToGetAllJobRolesException;
import org.kainos.ea.client.JWTExpiredException;
import org.kainos.ea.db.DatabaseConnector;
import org.kainos.ea.db.JobRolesDao;
import org.kainos.ea.util.JWTUtil;

import javax.ws.rs.GET;
import javax.ws.rs.HeaderParam;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Api("RRAS Job Roles API")
@Path("/api")
public class JobRolesController {
    private final JobRolesService jobRolesService
            = new JobRolesService(new JobRolesDao(), new DatabaseConnector());

    @GET
    @Path("/all-job-roles")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getAllJobRoles(@HeaderParam("Authorisation") String authHeader) {
        try {
            if (authHeader == null || !authHeader.startsWith("Bearer ")) {
                return Response.status(Response.Status.BAD_REQUEST)
                        .entity("Invalid or missing Authorisation header").build();
            }

            String jwt = authHeader.substring("Bearer ".length());
            if (!JWTUtil.isAtLeastEmployee(jwt)) {
                return Response.status(Response.Status.FORBIDDEN).build();
            }
        } catch (JWTExpiredException e) {
            return Response.status(Response.Status.FORBIDDEN).entity(e.getMessage()).build();
        } catch (JWTVerificationException e) {
            return Response.status(Response.Status.BAD_REQUEST).entity(e.getMessage()).build();
        }

        try {
            return Response.ok(jobRolesService.getAllJobRoles()).build();
        } catch (FailedToGetAllJobRolesException e) {
            System.err.println(e.getMessage());

            return Response.serverError().build();
        }
    }
}
