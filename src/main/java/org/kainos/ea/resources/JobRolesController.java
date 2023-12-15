package org.kainos.ea.resources;
import io.swagger.annotations.Api;
import org.kainos.ea.api.AuthService;
import org.kainos.ea.api.JobRolesService;
import org.kainos.ea.client.FailedToGetAllJobRolesException;
import org.kainos.ea.db.AuthDao;
import org.kainos.ea.db.DatabaseConnector;
import org.kainos.ea.db.JobRolesDao;

import javax.ws.rs.GET;
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
    public Response getAllJobRoles() {
        try {
            return Response.ok(jobRolesService.getAllJobRoles()).build();
        } catch (FailedToGetAllJobRolesException e) {
            System.err.println(e.getMessage());

            return Response.serverError().build();
        }
    }
}
