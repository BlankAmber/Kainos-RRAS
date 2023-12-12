package org.kainos.ea.db.service;


import org.junit.jupiter.api.Test;
import org.kainos.ea.cli.JobRole;
import org.kainos.ea.api.JobRolesService;
import org.kainos.ea.client.FailedToGetAllJobRolesException;
import org.kainos.ea.db.DatabaseConnector;
import org.kainos.ea.db.JobRolesDao;
import org.mockito.Mockito;


import java.sql.Connection;
import java.sql.SQLException;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;


public class JobRolesServiceTest {

    JobRolesDao jobRolesDao = Mockito.mock(JobRolesDao.class);
    DatabaseConnector databaseConnector = Mockito.mock(DatabaseConnector.class);

    JobRolesService jobRolesService = new JobRolesService(jobRolesDao, databaseConnector);

    Connection conn;


    @Test
    void getJobRoles_shouldReturnJobRoles_whenDaoReturnsEmployees() throws FailedToGetAllJobRolesException, SQLException {

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

}
