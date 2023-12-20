package org.kainos.ea.api;

import org.kainos.ea.cli.JobFamilyGroup;
import org.kainos.ea.cli.JobRole;

import org.kainos.ea.client.DatabaseConnectionException;
import org.kainos.ea.client.FailedToGetAllJobRolesException;
import org.kainos.ea.client.JobRoleDoesNotExistException;
import org.kainos.ea.db.DatabaseConnector;
import org.kainos.ea.db.JobRolesDao;

import java.sql.SQLException;
import java.util.List;

public class JobRolesService {

    public JobRolesDao jobRolesDao;

    public DatabaseConnector databaseConnector;

    public JobRolesService(JobRolesDao jobRolesDao, DatabaseConnector databaseConnector) {
        this.jobRolesDao = jobRolesDao;
        this.databaseConnector = databaseConnector;
    }

    public List<JobFamilyGroup> getAllJobRoles() throws FailedToGetAllJobRolesException {
        List<JobFamilyGroup> jobRolesList = null;
        try {
            jobRolesList = jobRolesDao.getAllJobRoles(databaseConnector.getConnection());
        } catch (SQLException e) {
            System.err.println(e.getMessage());

            throw new FailedToGetAllJobRolesException();
        }

        return jobRolesList;
    }


    public JobRole getJobRolesById(int id)
            throws FailedToGetAllJobRolesException, JobRoleDoesNotExistException, DatabaseConnectionException, SQLException {
        try {
            JobRole jobRole = jobRolesDao.getJobRolesById(id);

            if (jobRole == null) {
                throw new JobRoleDoesNotExistException();
            }
            return jobRole;
        } catch (SQLException e) {
            System.err.println(e.getMessage());
            throw new FailedToGetAllJobRolesException();
        }

    }



}
