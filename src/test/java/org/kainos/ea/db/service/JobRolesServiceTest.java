package org.kainos.ea.db.service;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.kainos.ea.cli.*;
import org.kainos.ea.api.JobRolesService;
import org.kainos.ea.client.*;
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
    JobRoleRequest jobRoleRequest = new JobRoleRequest(
            "Test Engineer",
            1,
            8,
            "As a Test Engineer (Apprentice) in Kainos, you’ll work within a multi-skilled agile team, developing and executing functional automated and manual tests to help the team deliver working application software that meets user needs. You’ll do this whilst learning about new technologies and approaches, with talented colleagues who will help you learn, develop and grow.",
            "https://kainossoftwareltd.sharepoint.com/people/Job%20Specifications/Forms/AllItems.aspx?id=%2Fpeople%2FJob%20Specifications%2FEngineering%2FJob%20profile%20Trainee%20Test%20Engineer%20%28Trainee%29%2Epdf&parent=%2Fpeople%2FJob%20Specifications%2FEngineering",
            "Good technical ability including experience of an Object Oriented programming language and has a desire to develop their technical/test automation skills further. Good problem solving and analytical skills. We all work in teams here in Kainos – a proven ability of strong team skills, is crucial. Ability to carry out responsibilities in accordance with company policies, procedures and processes. Ability to deliver tasks within a given timeframe."

    );
    Connection conn;

    @Test
    void insertJobRole_shouldReturnId_whenDaoReturnsId() throws SQLException, InvalidJobRoleException, FailedToCreateJobRoleException {
        int expectedResult = 1;
        Mockito.when(databaseConnector.getConnection()).thenReturn(conn);
        Mockito.when(jobRolesDao.createJobRole(jobRoleRequest, conn)).thenReturn(expectedResult);

        int result = jobRolesService.createJobRole(jobRoleRequest);

        assertEquals(result, expectedResult);
    }

    @Test
    void insertJobRole_shouldThrowSqlException_whenDaoThrowsSqlException() throws SQLException, DatabaseConnectionException {
        Mockito.when(databaseConnector.getConnection()).thenReturn(conn);
        Mockito.when(jobRolesDao.createJobRole(jobRoleRequest, conn)).thenThrow(SQLException.class);

        assertThrows(FailedToCreateJobRoleException.class,
                () -> jobRolesService.createJobRole(jobRoleRequest));
    }

    @Test
    @DisplayName("Test returning job roles")
    void getJobRoles_shouldReturnJobRoles_whenDaoReturnsJobRoles() throws SQLException, FailedToGetAllJobRolesException {
        List<JobResponsibilities> ListOfJobRoles = Arrays.asList(
                Mockito.mock(JobResponsibilities.class),
                Mockito.mock(JobResponsibilities.class),
                Mockito.mock(JobResponsibilities.class),
                Mockito.mock(JobResponsibilities.class)

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

    @Test
    @DisplayName("Test returning job family groups")
    void getJobFamilies_shouldReturnJobFamilies_whenDaoReturnsJobFamilies() throws SQLException, FailedToGetAllFamilyGroupsException {
        List<JobFamilyGroup> ListOfJobFamilies = Arrays.asList(
                Mockito.mock(JobFamilyGroup.class),
                Mockito.mock(JobFamilyGroup.class),
                Mockito.mock(JobFamilyGroup.class),
                Mockito.mock(JobFamilyGroup.class)

        );
        Mockito.when(databaseConnector.getConnection()).thenReturn(conn);
        Mockito.when(jobRolesDao.getAllJobFamilies(conn)).thenReturn(ListOfJobFamilies);
        assertEquals(ListOfJobFamilies, jobRolesService.getAllFamilyGroups());
    }

    @Test
    @DisplayName("Test returning job band level")
    void getJobBand_shouldReturnJobBand_whenDaoReturnsJobBand() throws SQLException, FailedToGetAllBandLevelsException {
        List<JobBandLevel> ListOfJobBand = Arrays.asList(
                Mockito.mock(JobBandLevel.class),
                Mockito.mock(JobBandLevel.class),
                Mockito.mock(JobBandLevel.class),
                Mockito.mock(JobBandLevel.class)

        );
        Mockito.when(databaseConnector.getConnection()).thenReturn(conn);
        Mockito.when(jobRolesDao.getAllJobBandLevels(conn)).thenReturn(ListOfJobBand);
        assertEquals(ListOfJobBand, jobRolesService.getAllBandLevels());
    }

}

