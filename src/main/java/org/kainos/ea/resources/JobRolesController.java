package org.kainos.ea.resources;
import io.swagger.annotations.Api;
import org.eclipse.jetty.http.HttpStatus;
import org.kainos.ea.api.JobRolesService;
import org.kainos.ea.client.DatabaseConnectionException;
import org.kainos.ea.client.FailedToGetAllJobRolesException;
import org.kainos.ea.client.JobRoleDoesNotExistException;
import org.kainos.ea.db.DatabaseConnector;
import org.kainos.ea.db.JobRolesDao;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.sql.SQLException;

@Api("RRAS API")
@Path("/api")
public class JobRolesController {


    private static JobRolesService jobRolesService;

    public JobRolesController() {
        DatabaseConnector databaseConnector = new DatabaseConnector();
        jobRolesService = new JobRolesService(new JobRolesDao()
                , databaseConnector);
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

    @GET
    @Path("/all-job-roles/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getJobRolesById(@PathParam("id") int jobRoleId) {
        try {
            return Response.status(HttpStatus.OK_200)
                    .entity(jobRolesService.getJobRolesById(jobRoleId)).build();
        } catch (SQLException | DatabaseConnectionException
                 | JobRoleDoesNotExistException
                 | FailedToGetAllJobRolesException e)  {
            System.out.println(e);
            return Response.status(HttpStatus.INTERNAL_SERVER_ERROR_500).build();
        }
    }

    @GET
    @Path("/job-roles-by-family-id/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getJobRolesByFamilyId(@PathParam("id") int jobFamilyId) {
        try {
            return Response.status(HttpStatus.OK_200)
                    .entity(jobRolesService.getJobRolesByFamilyId(jobFamilyId)).build();
        } catch (SQLException | DatabaseConnectionException
                 | JobRoleDoesNotExistException
                 | FailedToGetAllJobRolesException e)  {
            System.out.println(e);
            return Response.status(HttpStatus.INTERNAL_SERVER_ERROR_500).build();
        }
    }
}
