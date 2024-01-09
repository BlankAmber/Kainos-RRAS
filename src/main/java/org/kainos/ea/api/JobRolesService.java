package org.kainos.ea.api;

import org.kainos.ea.cli.JobRole;
import org.kainos.ea.client.FailedToGetAllJobRolesException;
import org.kainos.ea.client.FailedToGetJobRoleException;
import org.kainos.ea.client.JobRoleDoesNotExistException;
import org.kainos.ea.db.DatabaseConnector;
import org.kainos.ea.db.JobRolesDao;

import java.sql.SQLException;
import java.util.List;

public class JobRolesService {
    private final JobRolesDao jobRolesDao;
    private final DatabaseConnector databaseConnector;

    public JobRolesService(JobRolesDao jobRolesDao, DatabaseConnector databaseConnector) {
        this.jobRolesDao = jobRolesDao;
        this.databaseConnector = databaseConnector;
    }

    public List<JobRole> getAllJobRoles() throws FailedToGetAllJobRolesException {
        List<JobRole> jobRolesList;
        try {
            jobRolesList = jobRolesDao.getAllJobRoles(databaseConnector.getConnection());
        } catch (SQLException e) {
            System.err.println(e.getMessage());
            throw new FailedToGetAllJobRolesException();
        }

        return jobRolesList;
    }

    public JobRole getJobRolesById(int id)
            throws FailedToGetJobRoleException, JobRoleDoesNotExistException {
        try {
            JobRole jobRole = jobRolesDao.getJobRolesById(databaseConnector.getConnection(), id);

            if (jobRole == null) {
                throw new JobRoleDoesNotExistException();
            }
            return jobRole;
        } catch (SQLException e) {
            System.err.println(e.getMessage());
            throw new FailedToGetJobRoleException();
        }
    }
}
