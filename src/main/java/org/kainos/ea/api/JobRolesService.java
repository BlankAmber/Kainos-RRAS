package org.kainos.ea.api;

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

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public class JobRolesService {
    private final JobRolesDao jobRolesDao;
    private final DatabaseConnector databaseConnector;
    private final JobRoleValidator jobRoleValidator;

    public JobRolesService(
            JobRolesDao jobRolesDao, DatabaseConnector databaseConnector,
            JobRoleValidator jobRoleValidator) {
        this.jobRolesDao = jobRolesDao;
        this.databaseConnector = databaseConnector;
        this.jobRoleValidator = jobRoleValidator;
    }

    public List<JobRole> getAllJobRoles() throws FailedToGetAllJobRolesException {
        List<JobRole> jobRolesList = null;
        try {
            jobRolesList = jobRolesDao.getAllJobRoles(databaseConnector.getConnection());
        } catch (SQLException e) {
            System.err.println(e.getMessage());
            throw new FailedToGetAllJobRolesException();
        }
        return jobRolesList;
    }

    public List<JobFamilyGroup> getAllJobFamilyGroups() throws FailedToGetAllFamilyGroupsException {
        List<JobFamilyGroup> jobFamilyGroupList = null;
        try {
            Connection conn = databaseConnector.getConnection();
            jobFamilyGroupList = jobRolesDao.getAllJobFamilyGroups(conn);

        } catch (SQLException e) {
            System.err.println(e.getMessage());

            throw new FailedToGetAllFamilyGroupsException();
        }
        return jobFamilyGroupList;
    }

    public List<JobBandLevel> getAllJobBandLevels() throws FailedToGetAllBandLevelsException {
        List<JobBandLevel> jobBandLevelList = null;
        try {
            jobBandLevelList = jobRolesDao.getAllJobBandLevels(databaseConnector.getConnection());

        } catch (SQLException e) {
            System.err.println(e.getMessage());

            throw new FailedToGetAllBandLevelsException();
        }
        return jobBandLevelList;
    }


    public JobRole getJobRoleById(int id)
            throws FailedToGetJobRoleException, JobRoleDoesNotExistException {
        try {
            JobRole jobRole = jobRolesDao.getJobRoleById(databaseConnector.getConnection(), id);
            if (jobRole == null) {
                throw new JobRoleDoesNotExistException();
            }
            return jobRole;
        } catch (SQLException e) {
            System.err.println(e.getMessage());
            throw new FailedToGetJobRoleException();
        }
    }

    public int createJobRole(JobRoleRequest jobRoleRequest)
            throws FailedToCreateJobRoleException, InvalidJobRoleException {
        try {
            String validation = jobRoleValidator.isValidJobRole(jobRoleRequest);
            if (validation != null) {
                throw new InvalidJobRoleException(validation);
            }

            int id = jobRolesDao.createJobRole(jobRoleRequest, databaseConnector.getConnection());

            if (id == -1) {
                throw new FailedToCreateJobRoleException();
            }

            return id;
        } catch (SQLException e) {
            System.err.println(e.getMessage());

            throw new FailedToCreateJobRoleException();
        }
    }

    public void deleteJobRoleById(int id)
            throws FailedToDeleteJobRoleException, JobRoleDoesNotExistException {
        try {
            JobRole jobRole = jobRolesDao.getJobRoleById(databaseConnector.getConnection(), id);
            if (jobRole == null) {
                throw new JobRoleDoesNotExistException();
            }
            jobRolesDao.deleteJobRoleById(databaseConnector.getConnection(), id);
        } catch (SQLException e) {
            System.err.println(e.getMessage());
            throw new FailedToDeleteJobRoleException();
        }
    }
}
