package repositorios;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import modelos.Constructors;

public class ConstructorsRepository {
    private String jdbcUrl = "jdbc:mysql://localhost/formula1";
    private String user = "root";
    private String password = "";
    
    public List<Constructors> getAllConstructors() {
        List<Constructors> constructors = new ArrayList<>();

        try (Connection conn = DriverManager.getConnection(jdbcUrl, user, password)) {
            String sql = "SELECT * FROM constructors";  
            PreparedStatement statement = conn.prepareStatement(sql);
            ResultSet rs = statement.executeQuery();

            while (rs.next()) {
                int constructorId = rs.getInt("constructorId");
                String constructorRef = rs.getString("constructorRef");
                String name = rs.getString("name");
                String nationality = rs.getString("nationality");
                String url = rs.getString("url");

                Constructors constructor = new Constructors(constructorId, constructorRef, name, nationality, url);
                constructors.add(constructor);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return constructors;
    }
}