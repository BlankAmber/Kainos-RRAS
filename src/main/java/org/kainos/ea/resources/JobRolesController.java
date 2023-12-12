package org.kainos.ea.resources;
import io.swagger.annotations.Api;
import org.kainos.ea.api.JobRolesService;
import org.kainos.ea.client.FailedToGetAllJobRolesException;
import org.kainos.ea.db.DatabaseConnector;
import org.kainos.ea.db.JobRolesDao;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Api("RRAS API")
@Path("/api")
public class JobRolesController {


    private static JobRolesService jobRolesService;

    public JobRolesController() {
        DatabaseConnector databaseConnector = new DatabaseConnector();
        jobRolesService = new JobRolesService(new JobRolesDao(), databaseConnector);
    }

    @GET
    @Path("/all-job-roles")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getAllJobRoles() {
        try {
            return Response.ok(jobRolesService.getAllJobRoles()).build();
        } catch (FailedToGetAllJobRolesException e) {
            System.err.println(e.getMessage());

            return  Response.serverError().build();
        }
    }
}
