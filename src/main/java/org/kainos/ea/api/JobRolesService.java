package org.kainos.ea.api;

import org.kainos.ea.cli.*;

import org.kainos.ea.client.*;
import org.kainos.ea.db.DatabaseConnector;
import org.kainos.ea.db.JobRolesDao;
import org.kainos.ea.core.JobRoleValidator;
import java.sql.SQLException;
import java.util.List;

public class JobRolesService {

    public JobRolesDao jobRolesDao;

    public DatabaseConnector databaseConnector;
    JobRoleValidator jobRoleValidator = new JobRoleValidator();

    public JobRolesService(JobRolesDao jobRolesDao, DatabaseConnector databaseConnector) {
        this.jobRolesDao = jobRolesDao;
        this.databaseConnector = databaseConnector;
    }

    public List<JobResponsibilities> getAllJobRoles() throws FailedToGetAllJobRolesException {
        List<JobResponsibilities> jobRolesList = null;
        try {
            jobRolesList = jobRolesDao.getAllJobRoles(databaseConnector.getConnection());
        } catch (SQLException e) {
            System.err.println(e.getMessage());

            throw new FailedToGetAllJobRolesException();
        }

        return jobRolesList;
    }

    public List<JobFamilyGroup> getAllFamilyGroups() throws FailedToGetAllFamilyGroupsException {
        List<JobFamilyGroup> jobFamilyGroupList = null;
        try{
            jobFamilyGroupList = jobRolesDao.getAllJobFamilies(databaseConnector.getConnection());

        }catch (SQLException e) {
            System.err.println(e.getMessage());

            throw new FailedToGetAllFamilyGroupsException();
        }
        return jobFamilyGroupList;
    }

    public List<JobBandLevel> getAllBandLevels() throws FailedToGetAllBandLevelsException {
        List<JobBandLevel> jobBandLevelList = null;
        try{
            jobBandLevelList = jobRolesDao.getAllJobBandLevels(databaseConnector.getConnection());

        }catch (SQLException e) {
            System.err.println(e.getMessage());

            throw new FailedToGetAllBandLevelsException();
        }
        return jobBandLevelList;
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

    public int createJobRole(JobRoleRequest jobRoleRequest) throws FailedToCreateJobRoleException, InvalidJobRoleException {
        try {
            String validation = jobRoleValidator.isValidJobRole(jobRoleRequest);

            if (validation != null) {
                throw new InvalidJobRoleException(validation);
            }

            int id = jobRolesDao.createJobRole(jobRoleRequest);

            if (id == -1) {
                throw new FailedToCreateJobRoleException();
            }

            return id;
        }
        catch (SQLException e) {
            System.err.println(e.getMessage());

            throw new FailedToCreateJobRoleException();
        } catch (JobRoleLinkLengthException e) {
            throw new RuntimeException(e);
        } catch (JobRoleSpecLengthException e) {
            throw new RuntimeException(e);
        } catch (JobBandLevelIdException e) {
            throw new RuntimeException(e);
        } catch (JobRoleNameLengthException e) {
            throw new RuntimeException(e);
        } catch (JobFamilyGroupIdException e) {
            throw new RuntimeException(e);
        } catch (JobResponsibilitiesLengthException e) {
            throw new RuntimeException(e);
        }
    }


}
