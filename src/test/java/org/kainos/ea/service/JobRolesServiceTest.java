package org.kainos.ea.service;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.kainos.ea.cli.JobBandLevel;
import org.kainos.ea.cli.JobFamilyGroup;
import org.kainos.ea.cli.JobRole;
import org.kainos.ea.api.JobRolesService;
import org.kainos.ea.client.FailedToGetAllJobRolesException;
import org.kainos.ea.client.FailedToGetJobRoleException;
import org.kainos.ea.client.JobRoleDoesNotExistException;
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
    private final Connection conn = Mockito.mock(Connection.class);

    private final JobRolesService jobRolesService
            = new JobRolesService(jobRolesDao, databaseConnector);

    @Test
    @DisplayName("Test successful returning job roles")
    void getJobRoles_whenDaoReturnsJobRoles_shouldReturnJobRoles()
            throws SQLException, FailedToGetAllJobRolesException {
        List<JobBandLevel> listOfJobRoles = Arrays.asList(
                Mockito.mock(JobBandLevel.class),
                Mockito.mock(JobBandLevel.class),
                Mockito.mock(JobBandLevel.class),
                Mockito.mock(JobBandLevel.class)

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
}
