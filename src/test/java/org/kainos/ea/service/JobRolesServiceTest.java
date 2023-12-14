package org.kainos.ea.service;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.kainos.ea.cli.JobRole;
import org.kainos.ea.api.JobRolesService;
import org.kainos.ea.client.FailedToGetAllJobRolesException;
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
}
