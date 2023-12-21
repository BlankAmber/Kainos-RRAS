package org.kainos.ea.db;

import org.kainos.ea.cli.JobRole;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class JobRolesDao {
    public List<JobRole> getAllJobRoles(Connection conn) throws SQLException {
        Statement statement = conn.createStatement();

        ResultSet resultSet = statement.executeQuery(
                "SELECT job_role_id, job_role_name, " +
                    "specification_summary, sharepoint_link " +
                    "FROM job_roles");

        List<JobRole> jobRolesList = new ArrayList<>();

        while (resultSet.next()) {
            JobRole jobRoles = new JobRole(
                    resultSet.getInt("job_role_id"),
                    resultSet.getString("job_role_name"),
                    resultSet.getString("specification_summary"),
                    resultSet.getString("sharepoint_link")
            );

            jobRolesList.add(jobRoles);
        }
        return jobRolesList;
    }

    public JobRole getJobRolesById(Connection conn, int id) throws SQLException {
        Statement statement = conn.createStatement();

        ResultSet resultSet = statement.executeQuery("SELECT job_role_id, job_role_name, specification_summary, sharepoint_link FROM job_roles" +
                " where job_role_id = " + id);

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
