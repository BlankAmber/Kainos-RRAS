package org.kainos.ea.resources;
import io.swagger.annotations.Api;
import org.eclipse.jetty.http.HttpStatus;
import org.kainos.ea.api.JobRolesService;
import org.kainos.ea.cli.JobRoleRequest;
import org.kainos.ea.client.*;
import org.kainos.ea.core.JobRoleValidator;
import org.kainos.ea.db.DatabaseConnector;
import org.kainos.ea.db.JobRolesDao;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.sql.SQLException;

@Api("RRAS API")
@Path("/api")
public class JobRolesController {


    private static JobRolesService jobRolesService;
    private static JobRoleValidator jobRoleValidator;

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

    @POST
    @Path("/job-role")
    @Produces(MediaType.APPLICATION_JSON)
    public Response createJobRole(JobRoleRequest jobRoleRequest) {
        try {
            return Response.ok(jobRolesService.createJobRole(jobRoleRequest)).build();
        }
        catch (FailedToCreateJobRoleException e) {
            System.err.println(e.getMessage());

            return Response.serverError().build();
        }
        catch (InvalidJobRoleException e) {
            System.err.println(e.getMessage());

            return Response.status(Response.Status.BAD_REQUEST).entity(e.getMessage()).build();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @GET
    @Path("/job-family-names")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getAllJobFamilies() {
        try {
            return Response.ok(jobRolesService.getAllFamilyGroups()).build();
        } catch (FailedToGetAllFamilyGroupsException e) {
            System.err.println(e.getMessage());
            return  Response.serverError().build();
        }
    }

    @GET
    @Path("/band-levels")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getAllCapabilities() {
        try {
            return Response.ok(jobRolesService.getAllBandLevels()).build();
        } catch (FailedToGetAllBandLevelsException e) {
            System.err.println(e.getMessage());
            return  Response.serverError().build();
        }
    }


}
