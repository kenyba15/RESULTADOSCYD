package repositorios;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import modelos.ConstructorMaxPoint;
import modelos.DriverMaxPoint;

public class QueryRepositorio {

    public List<DriverMaxPoint> getDriversMaxPoint(String jdbcUrl, String user, String password) {
        List<DriverMaxPoint> results = new ArrayList<>();
        String sql = "SELECT CONCAT(d.forename, ' ', d.surname) AS driver_name, \n"
                + "SUM(r.points) AS total_points\n"
                + "FROM results AS r\n"
                + "JOIN drivers AS d ON r.driverid = d.driverid\n"
                + "GROUP BY d.forename, d.surname\n"
                + "ORDER BY total_points DESC\n"
                + "LIMIT 10;";

        try (Connection conn = DriverManager.getConnection(jdbcUrl, user, password);
             PreparedStatement statement = conn.prepareStatement(sql);
             ResultSet rs = statement.executeQuery()) {

            while (rs.next()) {
                String driverName = rs.getString("driver_name");
                float points = rs.getFloat("total_points");
                results.add(new DriverMaxPoint(driverName, points));
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return results;
    }

    public List<ConstructorMaxPoint> getConstructorsMaxPoints(String jdbcUrl, String user, String password) {
        List<ConstructorMaxPoint> results = new ArrayList<>();
        String sql = "SELECT c.name AS constructor_name, SUM(cr.points) AS total_points\n"
                + "FROM constructorresults AS cr\n"
                + "JOIN constructors AS c ON cr.constructorId = c.constructorId\n"
                + "GROUP BY c.name\n"
                + "ORDER BY total_points DESC\n"
                + "LIMIT 10;";

        try (Connection conn = DriverManager.getConnection(jdbcUrl, user, password);
             PreparedStatement statement = conn.prepareStatement(sql);
             ResultSet rs = statement.executeQuery()) {

            while (rs.next()) {
                String constructorName = rs.getString("constructor_name");
                float points = rs.getFloat("total_points");
                results.add(new ConstructorMaxPoint(constructorName, points));
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return results;
    }
}