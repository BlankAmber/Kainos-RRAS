package org.kainos.ea.db.service;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.kainos.ea.cli.JobRole;
import org.kainos.ea.api.JobRolesService;
import org.kainos.ea.client.DatabaseConnectionException;
import org.kainos.ea.client.FailedToGetAllJobRolesException;
import org.kainos.ea.client.JobRoleDoesNotExistException;
import org.kainos.ea.db.DatabaseConnector;
import org.kainos.ea.db.JobRolesDao;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.sql.Connection;
import java.sql.SQLException;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;


@ExtendWith(MockitoExtension.class)
public class JobRolesServiceTest {


    DatabaseConnector databaseConnector = Mockito.mock(DatabaseConnector.class);

    JobRolesDao jobRolesDao = Mockito.mock(JobRolesDao.class);
    JobRolesService jobRolesService = new JobRolesService(jobRolesDao, databaseConnector);

    Connection conn;

    @Test
    @DisplayName("Test returning job roles")
    void getJobRoles_shouldReturnJobRoles_whenDaoReturnsJobRoles() throws SQLException, FailedToGetAllJobRolesException {

        List<JobRole> ListOfJobRoles = Arrays.asList(
                Mockito.mock(JobRole.class),
                Mockito.mock(JobRole.class),
                Mockito.mock(JobRole.class),
                Mockito.mock(JobRole.class)
        );

        Mockito.when(databaseConnector.getConnection()).thenReturn(conn);
        Mockito.when(jobRolesDao.getAllJobRoles(conn)).thenReturn(ListOfJobRoles);

        assertEquals(ListOfJobRoles, jobRolesService.getAllJobRoles());

    }

    @Test
    @DisplayName("Test for returning individual job roles")
    void getJobRole_shouldReturnId_whenDaoReturnsId() throws SQLException, JobRoleDoesNotExistException, DatabaseConnectionException, FailedToGetAllJobRolesException {

        Mockito.when(databaseConnector.getConnection()).thenReturn(conn);
        JobRole jobRole = Mockito.mock(JobRole.class);
        Mockito.when(jobRolesDao.getJobRolesById(1)).thenReturn(jobRole);


        assertEquals(jobRole, jobRolesService.getJobRolesById(1));
    }

}

