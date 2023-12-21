package org.kainos.ea.db;

import org.kainos.ea.cli.JobBandLevel;
import org.kainos.ea.cli.JobFamilyGroup;
import org.kainos.ea.cli.JobResponsibilities;
import org.kainos.ea.cli.JobRole;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class JobRolesDao {
    public List<JobResponsibilities> getAllJobRoles(Connection c) throws SQLException {
        DatabaseConnector databaseConnector = new DatabaseConnector();
        Connection connection = databaseConnector.getConnection();

        Statement s = connection.createStatement();

        ResultSet rs = s.executeQuery("SELECT j.job_role_id, j.job_role_name, jfg.job_family_group_name, ml.management_level_name, responsibilities\n" +
                "FROM job_role j\n" +
                "JOIN job_family jf ON j.job_family_id = jf.job_family_id\n" +
                "JOIN job_family_group jfg ON jf.job_family_group_id = jfg.job_family_group_id\n" +
                "JOIN management_level ml ON j.management_level_id = ml.management_level_id;");

        List<JobResponsibilities> jobRolesList = new ArrayList<>();

        while (rs.next()) {
            JobResponsibilities jobRoles = new JobResponsibilities(
                    rs.getInt("job_role_id"),
                    rs.getString("job_role_name"),
                    rs.getString("job_family_group_name"),
                    rs.getString("management_level_name"),
                    rs.getString("responsibilities")
            );

            jobRolesList.add(jobRoles);
        }
        return jobRolesList;
    }



    public JobRole getJobRolesById(int id) throws SQLException {
        DatabaseConnector databaseConnector = new DatabaseConnector();
        Connection connection = databaseConnector.getConnection();


        Statement s = connection.createStatement();

        ResultSet rs = s.executeQuery("SELECT job_role_id, job_role_name, specification_summary, sharepoint_link FROM job_role" +
                " where job_role_id = " + id);

        while (rs.next()) {
            return new JobRole(
                    rs.getInt("job_role_id"),
                    rs.getString("job_role_name"),
                    rs.getString("specification_summary"),
                    rs.getString("sharepoint_link")
            );
        }
        return null;
    }

}
