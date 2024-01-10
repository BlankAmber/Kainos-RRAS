package org.kainos.ea.db;

import org.kainos.ea.cli.JobResponsibilities;
import org.kainos.ea.cli.JobRole;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class JobRolesDao {
    public List<JobResponsibilities> getAllJobRoles(Connection conn) throws SQLException {
        Statement statement = conn.createStatement();
        ResultSet resultSet = statement.executeQuery(
                "SELECT j.job_role_id, j.job_role_name, jfg.job_family_group_name, "
                + "ml.management_level_name, responsibilities "
                + "FROM job_role j "
                + "JOIN job_family jf ON j.job_family_id = jf.job_family_id "
                + "JOIN job_family_group jfg ON jf.job_family_group_id = jfg.job_family_group_id "
                + "JOIN management_level ml ON j.management_level_id = ml.management_level_id");

        List<JobResponsibilities> jobRolesList = new ArrayList<>();
        while (resultSet.next()) {
            JobResponsibilities jobRoles = new JobResponsibilities(
                    resultSet.getInt("job_role_id"),
                    resultSet.getString("job_role_name"),
                    resultSet.getString("job_family_group_name"),
                    resultSet.getString("management_level_name"),
                    resultSet.getString("responsibilities")
            );
            jobRolesList.add(jobRoles);
        }
        return jobRolesList;
    }

    public JobRole getJobRoleById(Connection conn, int id) throws SQLException {
        Statement statement = conn.createStatement();
        ResultSet resultSet = statement.executeQuery(
                 "SELECT j.job_role_id, j.job_role_name, jfg.job_family_group_name, "
                    + "ml.management_level_name, j.sharepoint_link, j.specification_summary, j.responsibilities "
                    + "FROM job_role j "
                    + "JOIN job_family jf ON j.job_family_id = jf.job_family_id "
                    + "JOIN job_family_group jfg ON jf.job_family_group_id = jfg.job_family_group_id "
                    + "JOIN management_level ml ON j.management_level_id = ml.management_level_id "
                    + "where j.job_role_id = " + id);

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
}
