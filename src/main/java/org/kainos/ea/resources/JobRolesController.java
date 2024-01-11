package org.kainos.ea.resources;

import io.swagger.annotations.Api;
import org.eclipse.jetty.http.HttpStatus;
import org.kainos.ea.api.JobRolesService;
import org.kainos.ea.cli.JobRoleRequest;
import org.kainos.ea.client.FailedToCreateJobRoleException;
import org.kainos.ea.client.FailedToDeleteJobRoleException;
import org.kainos.ea.client.FailedToGetAllBandLevelsException;
import org.kainos.ea.client.FailedToGetAllFamilyGroupsException;
import org.kainos.ea.client.FailedToGetAllJobRolesException;
import org.kainos.ea.client.FailedToGetJobRoleException;
import org.kainos.ea.client.InvalidJobRoleException;
import org.kainos.ea.client.JobRoleDoesNotExistException;
import org.kainos.ea.core.JobRoleValidator;
import org.kainos.ea.db.DatabaseConnector;
import org.kainos.ea.db.JobRolesDao;
import org.kainos.ea.util.ControllerUtil;

import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.HeaderParam;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Api("RRAS Job Roles API")
@Path("/api")
public class JobRolesController {
    private final JobRolesService jobRolesService = new JobRolesService(
            new JobRolesDao(),
            new DatabaseConnector(),
            new JobRoleValidator());

    @GET
    @Path("/all-job-roles")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getAllJobRoles(@HeaderParam("Authorisation") String authHeader) {
        Response response = ControllerUtil.validAuthHeaderAtLeastEmployee(authHeader);
        if (response != null) {
            return response;
        }

        try {
            return Response.ok(jobRolesService.getAllJobRoles()).build();
        } catch (FailedToGetAllJobRolesException e) {
            System.err.println(e.getMessage());
            return Response.serverError().build();
        }
    }

    @GET
    @Path("/all-job-roles/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getJobRoleById(@HeaderParam("Authorisation") String authHeader,
                                   @PathParam("id") int jobRoleId) {
        Response response = ControllerUtil.validAuthHeaderAtLeastEmployee(authHeader);
        if (response != null) {
            return response;
        }

        try {
            return Response.status(HttpStatus.OK_200)
                    .entity(jobRolesService.getJobRoleById(jobRoleId)).build();
        } catch (FailedToGetJobRoleException e)  {
            System.err.println(e.getMessage());
            return Response.serverError().build();
        } catch (JobRoleDoesNotExistException e) {
            System.err.println(e.getMessage());
            return Response.status(Response.Status.BAD_REQUEST).entity(e.getMessage()).build();
        }
    }

    @POST
    @Path("/job-role")
    @Produces(MediaType.APPLICATION_JSON)
    public Response createJobRole(@HeaderParam("Authorisation") String authHeader,
                                  JobRoleRequest jobRoleRequest) {
        Response response = ControllerUtil.validAuthHeaderIsAdmin(authHeader);
        if (response != null) {
            return response;
        }

        try {
            return Response.ok(jobRolesService.createJobRole(jobRoleRequest)).build();
        } catch (FailedToCreateJobRoleException e) {
            System.err.println(e.getMessage());
            return Response.serverError().build();
        } catch (InvalidJobRoleException e) {
            System.err.println(e.getMessage());
            return Response.status(Response.Status.BAD_REQUEST).entity(e.getMessage()).build();
        }
    }

    @GET
    @Path("/job-family-groups")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getAllJobFamilyGroups(@HeaderParam("Authorisation") String authHeader) {
        Response response = ControllerUtil.validAuthHeaderAtLeastEmployee(authHeader);
        if (response != null) {
            return response;
        }

        try {
            return Response.ok(jobRolesService.getAllJobFamilyGroups()).build();
        } catch (FailedToGetAllFamilyGroupsException e) {
            System.err.println(e.getMessage());
            return  Response.serverError().build();
        }
    }

    @GET
    @Path("/band-levels")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getAllJobBandLevels(@HeaderParam("Authorisation") String authHeader) {
        Response response = ControllerUtil.validAuthHeaderAtLeastEmployee(authHeader);
        if (response != null) {
            return response;
        }

        try {
            return Response.ok(jobRolesService.getAllJobBandLevels()).build();
        } catch (FailedToGetAllBandLevelsException e) {
            System.err.println(e.getMessage());
            return  Response.serverError().build();
        }
    }

    @DELETE
    @Path("/all-job-roles/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response deleteJobRoleById(@HeaderParam("Authorisation") String authHeader,
                                      @PathParam("id") int jobRoleId) {
        Response response = ControllerUtil.validAuthHeaderIsAdmin(authHeader);
        if (response != null) {
            return response;
        }

        try {
            jobRolesService.deleteJobRoleById(jobRoleId);
            return Response.status(HttpStatus.OK_200).build();
        } catch (FailedToDeleteJobRoleException e)  {
            System.err.println(e.getMessage());
            return Response.serverError().build();
        } catch (JobRoleDoesNotExistException e) {
            System.err.println(e.getMessage());
            return Response.status(Response.Status.BAD_REQUEST).entity(e.getMessage()).build();
        }
    }
}
