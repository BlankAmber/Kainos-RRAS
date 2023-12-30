package org.kainos.ea.db;

import org.kainos.ea.cli.JobBandLevel;
import org.kainos.ea.cli.JobFamilyGroup;
import org.kainos.ea.cli.JobRole;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class JobRolesDao {
    public List<JobBandLevel> getAllJobRoles(Connection conn) throws SQLException {
        Statement statement = conn.createStatement();
        ResultSet resultSet = statement.executeQuery(
                "SELECT j.job_role_id, j.job_role_name, jfg.job_family_group_name, "
                        + "ml.management_level_name "
                        + "FROM job_role j "
                        + "JOIN job_family jf ON j.job_family_id = jf.job_family_id "
                        + "JOIN job_family_group jfg ON jf.job_family_group_id = jfg.job_family_group_id "
                        + "JOIN management_level ml ON j.management_level_id = ml.management_level_id;");

        List<JobBandLevel> jobRolesList = new ArrayList<>();
        while (resultSet.next()) {
            JobBandLevel jobRoles = new JobBandLevel(
                    resultSet.getInt("job_role_id"),
                    resultSet.getString("job_role_name"),
                    resultSet.getString("job_family_group_name"),
                    resultSet.getString("management_level_name")
            );
            jobRolesList.add(jobRoles);
        }
        return jobRolesList;
    }

    public JobRole getJobRoleById(Connection conn, int id) throws SQLException {
        Statement statement = conn.createStatement();
        ResultSet resultSet = statement.executeQuery(
                "SELECT job_role_id, job_role_name, "
                    + "specification_summary, sharepoint_link FROM job_role "
                    + "where job_role_id = " + id);

        if (resultSet.next()) {
            return new JobRole(
                    resultSet.getInt("job_role_id"),
                    resultSet.getString("job_role_name"),
                    resultSet.getString("specification_summary"),
                    resultSet.getString("sharepoint_link")
            );
        }
        return null;
    }
}
