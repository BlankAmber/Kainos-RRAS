package org.kainos.ea.service;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.kainos.ea.api.JobRolesService;
import org.kainos.ea.cli.JobBandLevel;
import org.kainos.ea.cli.JobFamilyGroup;
import org.kainos.ea.cli.JobRole;
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
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

@ExtendWith(MockitoExtension.class)
public class JobRolesServiceTest {
    private final DatabaseConnector databaseConnector = Mockito.mock(DatabaseConnector.class);
    private final JobRolesDao jobRolesDao = Mockito.mock(JobRolesDao.class);
    private final JobRoleValidator jobRoleValidator = Mockito.mock(JobRoleValidator.class);
    private final Connection conn = Mockito.mock(Connection.class);

    private final JobRolesService jobRolesService
            = new JobRolesService(jobRolesDao, databaseConnector, jobRoleValidator);

    private final JobRoleRequest jobRoleRequest = new JobRoleRequest(
            "Test Engineer",
            1,
            8,
            "Spec",
            "Link",
            "Responsibilities"
    );

    @Test
    @DisplayName("Test successful returning job roles")
    void getJobRoles_whenDaoReturnsJobRoles_shouldReturnJobRoles()
            throws SQLException, FailedToGetAllJobRolesException {
        List<JobRole> listOfJobRoles = Arrays.asList(
                Mockito.mock(JobRole.class),
                Mockito.mock(JobRole.class),
                Mockito.mock(JobRole.class),
                Mockito.mock(JobRole.class)
        );

        Mockito.when(databaseConnector.getConnection()).thenReturn(conn);
        Mockito.when(jobRolesDao.getAllJobRoles(conn)).thenReturn(listOfJobRoles);

        assertEquals(listOfJobRoles, jobRolesService.getAllJobRoles());
    }

    @Test
    @DisplayName("Test getJobRoles FailedToGetAllJobRolesException")
    void getJobRoles_whenDaoThrowsSQLException_shouldThrowFailedToGetAllJobRolesException()
            throws SQLException {
        Mockito.when(databaseConnector.getConnection()).thenReturn(conn);
        Mockito.when(jobRolesDao.getAllJobRoles(conn)).thenThrow(SQLException.class);

        assertThrows(FailedToGetAllJobRolesException.class, jobRolesService::getAllJobRoles);
    }

    @Test
    @DisplayName("Test for returning individual job roles")
    void getJobRole_whenDaoReturnsId_shouldReturnId()
            throws SQLException, JobRoleDoesNotExistException, FailedToGetJobRoleException {
        Mockito.when(databaseConnector.getConnection()).thenReturn(conn);
        JobRole jobRole = Mockito.mock(JobRole.class);
        Mockito.when(jobRolesDao.getJobRoleById(conn, 1)).thenReturn(jobRole);

        assertEquals(jobRole, jobRolesService.getJobRoleById(1));
    }

    @Test
    @DisplayName("Test for deleting a specific job role")
    void deleteJobRole_whenDaoReturnsVoid_shouldReturnVoid()
            throws SQLException, JobRoleDoesNotExistException, FailedToDeleteJobRoleException {
        Mockito.when(databaseConnector.getConnection()).thenReturn(conn);
        JobRole jobRole = Mockito.mock(JobRole.class);
        Mockito.when(jobRolesDao.getJobRoleById(conn, 1)).thenReturn(jobRole);
        Mockito.doNothing().when(jobRolesDao).deleteJobRoleById(conn, 1);
        jobRolesService.deleteJobRoleById(1);
    }

    @Test
    @DisplayName("Test for returning job family groups")
    void getJobFamilyGroups_whenDaoReturnsJobFamilyGroups_shouldReturnJobFamilyGroups()
            throws SQLException, FailedToGetAllFamilyGroupsException {
        List<JobFamilyGroup> listOfJobFamilies = Arrays.asList(
                Mockito.mock(JobFamilyGroup.class),
                Mockito.mock(JobFamilyGroup.class),
                Mockito.mock(JobFamilyGroup.class),
                Mockito.mock(JobFamilyGroup.class)

        );
        Mockito.when(databaseConnector.getConnection()).thenReturn(conn);
        Mockito.when(jobRolesDao.getAllJobFamilyGroups(conn)).thenReturn(listOfJobFamilies);
        assertEquals(listOfJobFamilies, jobRolesService.getAllJobFamilyGroups());
    }

    @Test
    @DisplayName("Test for returning job band levels")
    void getAllJobBandLevels_whenDaoReturnsBandLevels_shouldReturnBandLevels()
            throws SQLException, FailedToGetAllBandLevelsException {
        List<JobBandLevel> listOfJobBands = Arrays.asList(
                Mockito.mock(JobBandLevel.class),
                Mockito.mock(JobBandLevel.class),
                Mockito.mock(JobBandLevel.class),
                Mockito.mock(JobBandLevel.class)

        );
        Mockito.when(databaseConnector.getConnection()).thenReturn(conn);
        Mockito.when(jobRolesDao.getAllJobBandLevels(conn)).thenReturn(listOfJobBands);
        assertEquals(listOfJobBands, jobRolesService.getAllJobBandLevels());
    }

    @Test
    void createJobRole_whenDaoReturnsId_shouldReturnId()
            throws SQLException, InvalidJobRoleException, FailedToCreateJobRoleException {
        int expectedResult = 1;
        Mockito.when(databaseConnector.getConnection()).thenReturn(conn);
        Mockito.when(jobRolesDao.createJobRole(jobRoleRequest, conn)).thenReturn(expectedResult);

        int result = jobRolesService.createJobRole(jobRoleRequest);
        assertEquals(result, expectedResult);
    }

    @Test
    void createJobRole_whenDaoThrowsSqlException_shouldThrowSqlException() throws SQLException {
        Mockito.when(databaseConnector.getConnection()).thenReturn(conn);
        Mockito.when(jobRolesDao.createJobRole(jobRoleRequest, conn)).thenThrow(SQLException.class);

        assertThrows(FailedToCreateJobRoleException.class,
                () -> jobRolesService.createJobRole(jobRoleRequest));
    }
}
