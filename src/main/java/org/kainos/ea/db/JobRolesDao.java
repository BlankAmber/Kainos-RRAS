package org.kainos.ea.db;

import org.kainos.ea.cli.JobRole;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class JobRolesDao {
    public List<JobRole> getAllJobRoles(Connection c) throws SQLException {
        Connection connection = DatabaseConnector.getConnection();

        Statement s = connection.createStatement();

        ResultSet rs = s.executeQuery("SELECT job_role_id, job_role_name FROM job_roles");

        List<JobRole> jobRolesList = new ArrayList<>();

        while (rs.next()) {
            JobRole jobRoles = new JobRole(
                    rs.getInt("job_role_id"),
                    rs.getString("job_role_name")

            );

            jobRolesList.add(jobRoles);
        }
        return jobRolesList;
    }
}
