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
        DatabaseConnector databaseConnector = new DatabaseConnector();
        Connection connection = databaseConnector.getConnection();

        Statement s = connection.createStatement();

        ResultSet rs = s.executeQuery("SELECT job_role_id, job_role_name, specification_summary, sharepoint_link, job_family_id FROM job_role");

        List<JobRole> jobRolesList = new ArrayList<>();

        while (rs.next()) {
            JobRole jobRoles = new JobRole(
                    rs.getInt("job_role_id"),
                    rs.getString("job_role_name"),
                    rs.getString("specification_summary"),
                    rs.getString("sharepoint_link"),
                    rs.getInt("job_family_id")
            );

            jobRolesList.add(jobRoles);
        }
        return jobRolesList;
    }



    public JobRole getJobRolesById(int id) throws SQLException {
        DatabaseConnector databaseConnector = new DatabaseConnector();
        Connection connection = databaseConnector.getConnection();


        Statement s = connection.createStatement();

        ResultSet rs = s.executeQuery("SELECT job_role_id, job_role_name, specification_summary, sharepoint_link, job_family_id FROM job_role" +
                " where job_role_id = " + id);

        while (rs.next()) {
            return new JobRole(
                    rs.getInt("job_role_id"),
                    rs.getString("job_role_name"),
                    rs.getString("specification_summary"),
                    rs.getString("sharepoint_link"),
                    rs.getInt("job_family_id")
            );
        }
        return null;
    }


    public List<JobRole> getJobRolesByFamilyId(int id) throws SQLException {
        DatabaseConnector databaseConnector = new DatabaseConnector();
        Connection connection = databaseConnector.getConnection();

        Statement s = connection.createStatement();

        ResultSet rs = s.executeQuery("SELECT job_role_id, job_role_name, specification_summary, sharepoint_link, job_family_id FROM job_role" +
                " where job_family_id = " + id);

        List<JobRole> jobRolesList = new ArrayList<>();

        while (rs.next()) {
            JobRole jobRoles = new JobRole(
                    rs.getInt("job_role_id"),
                    rs.getString("job_role_name"),
                    rs.getString("specification_summary"),
                    rs.getString("sharepoint_link"),
                    rs.getInt("job_family_id")
            );

            jobRolesList.add(jobRoles);
        }
        return jobRolesList;
    }
}
