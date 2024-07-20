package repositorios;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import modelos.Driver;

public class DriverRepository {
    private String jdbcUrl = "jdbc:mysql://localhost/formula1";
    private String user = "root";
    private String password = "";

    public List<Driver> getAllDrivers() {
        List<Driver> drivers = new ArrayList<>();

        try (Connection conn = DriverManager.getConnection(jdbcUrl, user, password)) {
            String sql = "SELECT * FROM drivers";  
            PreparedStatement statement = conn.prepareStatement(sql);
            ResultSet rs = statement.executeQuery();

            while (rs.next()) {
                int driverId = rs.getInt("driverId");
                String driverRef = rs.getString("driverRef");
                Integer number = rs.getInt("number"); 
                String code = rs.getString("code");
                String forename = rs.getString("forename");
                String surname = rs.getString("surname");
                Date dob = rs.getDate("dob"); 
                String nationality = rs.getString("nationality");
                String url = rs.getString("url");

                Driver driver = new Driver(driverId, driverRef, number, code, forename, surname, dob, nationality, url);
                drivers.add(driver);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return drivers;
    }
    public List<Integer> getUniqueYears() {
        List<Integer> years = new ArrayList<>();

        try (Connection conn = DriverManager.getConnection(jdbcUrl, user, password)) {
            String sql = "SELECT DISTINCT YEAR(dob) AS year FROM drivers";
            PreparedStatement statement = conn.prepareStatement(sql);
            ResultSet rs = statement.executeQuery();

            while (rs.next()) {
                int year = rs.getInt("year");
                years.add(year);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return years;
    }

    public List<Driver> getDriversByYear(int year) {
        List<Driver> drivers = new ArrayList<>();

        try (Connection conn = DriverManager.getConnection(jdbcUrl, user, password)) {
            String sql = "SELECT * FROM drivers WHERE YEAR(dob) = ?";
            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setInt(1, year);
            ResultSet rs = statement.executeQuery();

            while (rs.next()) {
                int driverId = rs.getInt("driverId");
                String driverRef = rs.getString("driverRef");
                Integer number = rs.getInt("number");
                String code = rs.getString("code");
                String forename = rs.getString("forename");
                String surname = rs.getString("surname");
                Date dob = rs.getDate("dob");
                String nationality = rs.getString("nationality");
                String url = rs.getString("url");

                Driver driver = new Driver(driverId, driverRef, number, code, forename, surname, dob, nationality, url);
                drivers.add(driver);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return drivers;
    }
}

