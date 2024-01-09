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
    public Response createJobRole(JobRoleRequest jobRoleRequest) throws JobRoleLinkLengthException, JobRoleSpecLengthException, JobBandLevelIdException, JobRoleNameLengthException, JobFamilyGroupIdException, JobResponsibilitiesLengthException {
        if (jobRoleValidator.isValidJobRole(jobRoleRequest)) {
            try {
                int id = jobRolesService.createJobRole(jobRoleRequest);
                return Response.status(HttpStatus.CREATED_201).entity(id).build();
            } catch (Exception | FailedToCreateJobRoleException | InvalidJobRoleException e) {
                System.out.println(e);
                return Response.status(HttpStatus.INTERNAL_SERVER_ERROR_500).build();
            }
        } else {
            return Response.status(HttpStatus.BAD_REQUEST_400).build();
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
