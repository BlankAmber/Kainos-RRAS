package org.kainos.ea.db;

import org.kainos.ea.cli.JobBandLevel;
import org.kainos.ea.cli.JobFamilyGroup;
import org.kainos.ea.cli.JobRole;
import org.kainos.ea.cli.JobRoleRequest;
import org.kainos.ea.util.DaoUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class JobRolesDao {
    private static final int JOB_ROLE_NAME_INDEX = 1;
    private static final int JOB_FAMILY_GROUP_ID_INDEX = 2;
    private static final int JOB_BAND_LEVEL_ID_INDEX = 3;
    private static final int JOB_ROLE_LINK_INDEX = 4;
    private static final int JOB_ROLE_SPEC_INDEX = 5;
    private static final int JOB_RESPONSIBILITIES_INDEX = 6;
    private static final int ID_INDEX = 7;
    public List<JobRole> getAllJobRoles(Connection conn) throws SQLException {
        String statement = "SELECT j.job_role_id, j.job_role_name, jfg.job_family_group_name, "
                + "ml.management_level_name, sharepoint_link, specification_summary, "
                + "responsibilities "
                + "FROM job_role j "
                + "JOIN job_family jf ON j.job_family_id = jf.job_family_id "
                + "JOIN job_family_group jfg ON jf.job_family_group_id = jfg.job_family_group_id "
                + "JOIN management_level ml ON j.management_level_id = ml.management_level_id "
                + "ORDER BY job_role_id";
        ResultSet resultSet = DaoUtil.executeStatement(conn, statement, true);

        List<JobRole> jobRolesList = new ArrayList<>();
        while (resultSet.next()) {
            JobRole jobRole = new JobRole(
                    resultSet.getInt("job_role_id"),
                    resultSet.getString("job_role_name"),
                    resultSet.getString("job_family_group_name"),
                    resultSet.getString("management_level_name"),
                    resultSet.getString("sharepoint_link"),
                    resultSet.getString("specification_summary"),
                    resultSet.getString("responsibilities")
            );
            jobRolesList.add(jobRole);
        }
        return jobRolesList;
    }

    public JobRole getJobRoleById(Connection conn, int id) throws SQLException {
        String statement = "SELECT j.job_role_id, j.job_role_name, jfg.job_family_group_name, "
                + "ml.management_level_name, sharepoint_link, specification_summary, "
                + "responsibilities "
                + "FROM job_role j "
                + "JOIN job_family jf ON j.job_family_id = jf.job_family_id "
                + "JOIN job_family_group jfg ON jf.job_family_group_id = jfg.job_family_group_id "
                + "JOIN management_level ml ON j.management_level_id = ml.management_level_id "
                + "WHERE j.job_role_id = ?";
        ResultSet resultSet = DaoUtil.executeStatement(conn, statement, true, id);

        if (resultSet.next()) {
            return new JobRole(
                    resultSet.getInt("job_role_id"),
                    resultSet.getString("job_role_name"),
                    resultSet.getString("job_family_group_name"),
                    resultSet.getString("management_level_name"),
                    resultSet.getString("sharepoint_link"),
                    resultSet.getString("specification_summary"),
                    resultSet.getString("responsibilities")
            );
        }
        return null;
    }
    public int createJobRole(JobRoleRequest jobRoleRequest, Connection conn) throws SQLException {
        String insertStatement = "INSERT INTO job_role "
                + "(job_role_name, job_family_id, management_level_id, "
                + "specification_summary, sharepoint_link, responsibilities) "
                + "VALUES (?,?,?,?,?,?)";
        ResultSet resultSet = DaoUtil.executeStatement(conn, insertStatement, false,
                jobRoleRequest.getJobRoleName(),
                jobRoleRequest.getJobFamilyGroupId(),
                jobRoleRequest.getJobBandLevelId(),
                jobRoleRequest.getJobRoleSpec(),
                jobRoleRequest.getJobRoleLink(),
                jobRoleRequest.getJobRoleName());

        if (resultSet.next()) {
            return resultSet.getInt(1);
        }
        return -1;
    }

    public List<JobFamilyGroup> getAllJobFamilyGroups(Connection conn) throws SQLException {
        String statement = "SELECT job_family_group_id, job_family_group_name "
                + "FROM job_family_group";
        ResultSet resultSet = DaoUtil.executeStatement(conn, statement, true);

        List<JobFamilyGroup> jobFamilyGroupList = new ArrayList<>();
        while (resultSet.next()) {
            JobFamilyGroup jobFamilyGroup = new JobFamilyGroup(
                    resultSet.getInt("job_family_group_id"),
                    resultSet.getString("job_family_group_name"));

            jobFamilyGroupList.add(jobFamilyGroup);
        }
        return jobFamilyGroupList;
    }

    public List<JobBandLevel> getAllJobBandLevels(Connection conn) throws SQLException {
        String statement = "SELECT management_level_id,management_level_name FROM management_level";
        ResultSet resultSet = DaoUtil.executeStatement(conn, statement, true);

        List<JobBandLevel> jobBandLevelList = new ArrayList<>();
        while (resultSet.next()) {
            JobBandLevel jobBandLevel = new JobBandLevel(
                    resultSet.getInt("management_level_id"),
                    resultSet.getString("management_level_name"));

            jobBandLevelList.add(jobBandLevel);
        }
        return jobBandLevelList;
    }

    public void deleteJobRoleById(Connection conn, int id) throws SQLException {
        String statement = "DELETE FROM job_role j WHERE j.job_role_id = ?";
        DaoUtil.executeStatement(conn, statement, false, id);
    }
    public void updateJobRole(int id, JobRoleRequest jobRole, Connection conn) throws SQLException {
        String updateStatement = "UPDATE job_role SET"
                + " job_role_name = ?, job_family_id = ?, management_level_id = ?,"
                + " specification_summary = ?, sharepoint_link = ?, responsibilities = ?"
                + " WHERE job_role_id = ?";
        PreparedStatement s = conn.prepareStatement(updateStatement);
        s.setString(JOB_ROLE_NAME_INDEX, jobRole.getJobRoleName());
        s.setInt(JOB_FAMILY_GROUP_ID_INDEX, jobRole.getJobFamilyGroupId());
        s.setInt(JOB_BAND_LEVEL_ID_INDEX, jobRole.getJobBandLevelId());
        s.setString(JOB_ROLE_LINK_INDEX, jobRole.getJobRoleLink());
        s.setString(JOB_ROLE_SPEC_INDEX, jobRole.getJobRoleSpec());
        s.setString(JOB_RESPONSIBILITIES_INDEX, jobRole.getJobResponsibilities());
        s.setInt(ID_INDEX, id);
        s.executeUpdate();
    }

}
