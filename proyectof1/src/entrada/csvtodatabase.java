package entrada;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class csvtodatabase {
//    private static final String CSV_FILE_PATH_RESULTS = "C:\\Users\\User\\eclipse-workspace\\proyectof1\\csv\\results.csv";
//    private static final String CSV_FILE_PATH_STATUS = "C:\\Users\\User\\eclipse-workspace\\proyectof1\\csv\\status.csv";
//    private static final String CSV_FILE_PATH_CONSTRUCTORRESULTS = "C:\\Users\\User\\eclipse-workspace\\proyectof1\\csv\\constructor_results.csv";
//    private static final String CSV_FILE_PATH_CONSTRUCTORSTANDINGS = "C:\\Users\\User\\eclipse-workspace\\proyectof1\\csv\\constructor_standings.csv";
//    private static final String CSV_FILE_PATH_DRIVERSTANDINGS = "C:\\Users\\User\\eclipse-workspace\\proyectof1\\csv\\driver_standings.csv";
      private static final String CSV_FILE_PATH_SPRINTRESULTS = "C:\\Users\\User\\eclipse-workspace\\proyectof1\\csv\\sprint_results.csv";
    private static final String JDBC_URL = "jdbc:mysql://localhost/formula1";
    private static final String JDBC_USER = "root";
    private static final String JDBC_PASSWORD = "";

    public static void main(String[] args) {
        try {
            Connection connection = DriverManager.getConnection(JDBC_URL, JDBC_USER, JDBC_PASSWORD);
            connection.setAutoCommit(false);

//            importResultsData(connection);
//            importStatusData(connection);
//            importconstructorresultsData(connection);
//            importConstructorStandingsData(connection);
//            importDriverStandingsData(connection);
            importSprintResultsData(connection);

            connection.commit();
            connection.close();
            
            System.out.println("Datos importados correctamente.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    private static void importSprintResultsData(Connection connection) {
        String line = "";
        String csvSplitBy = ",";
        int batchSize = 1000;
        int count = 0;

        try (BufferedReader br = new BufferedReader(new FileReader(CSV_FILE_PATH_SPRINTRESULTS));
             PreparedStatement preparedStatement = connection.prepareStatement("INSERT IGNORE INTO sprintresults (sprintResultId, raceId, driverId, constructorId, number, grid, position, positionText, positionOrder, points, laps, time, miliseconds, fastestLap, fastestLapTime, statusId) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)")) {
            br.readLine(); // Saltar la primera línea (encabezados)

            while ((line = br.readLine()) != null) {
                if (line.trim().isEmpty()) continue; // Saltar líneas vacías

                String[] data = line.split(csvSplitBy);

                for (int i = 0; i < data.length; i++) {
                    String value = data[i].trim();
                    if (value.isEmpty() || value.equals("\\N")) {
                        if (i == 0) { // Columna de sprintResultId
                            preparedStatement.setNull(i + 1, java.sql.Types.INTEGER);
                        } else if (i == 1) { // Columna de raceId
                            preparedStatement.setNull(i + 1, java.sql.Types.INTEGER);
                        } else if (i == 2) { // Columna de driverId
                            preparedStatement.setNull(i + 1, java.sql.Types.INTEGER);
                        } else if (i == 3) { // Columna de constructorId
                            preparedStatement.setNull(i + 1, java.sql.Types.INTEGER);
                        } else if (i == 4) { // Columna de number
                            preparedStatement.setNull(i + 1, java.sql.Types.INTEGER);
                        } else if (i == 5) { // Columna de grid
                            preparedStatement.setNull(i + 1, java.sql.Types.INTEGER);
                        } else if (i == 6) { // Columna de position
                            preparedStatement.setNull(i + 1, java.sql.Types.INTEGER);
                        } else if (i == 7) { // Columna de positionText
                            preparedStatement.setString(i + 1, null);
                        } else if (i == 8) { // Columna de positionOrder
                            preparedStatement.setNull(i + 1, java.sql.Types.INTEGER);
                        } else if (i == 9) { // Columna de points
                            preparedStatement.setNull(i + 1, java.sql.Types.FLOAT);
                        } else if (i == 10) { // Columna de laps
                            preparedStatement.setNull(i + 1, java.sql.Types.INTEGER);
                        } else if (i == 11) { // Columna de time
                            preparedStatement.setString(i + 1, null);
                        } else if (i == 12) { // Columna de miliseconds
                            preparedStatement.setNull(i + 1, java.sql.Types.INTEGER);
                        } else if (i == 13) { // Columna de fastestLap
                            preparedStatement.setNull(i + 1, java.sql.Types.INTEGER);
                        } else if (i == 14) { // Columna de fastestLapTime
                            preparedStatement.setString(i + 1, null);
                        } else if (i == 15) { // Columna de statusId
                            preparedStatement.setNull(i + 1, java.sql.Types.INTEGER);
                        }
                    } else if (i == 0) { // Columna de sprintResultId
                        preparedStatement.setInt(i + 1, Integer.parseInt(value));
                    } else if (i == 1) { // Columna de raceId
                        preparedStatement.setInt(i + 1, Integer.parseInt(value));
                    } else if (i == 2) { // Columna de driverId
                        preparedStatement.setInt(i + 1, Integer.parseInt(value));
                    } else if (i == 3) { // Columna de constructorId
                        preparedStatement.setInt(i + 1, Integer.parseInt(value));
                    } else if (i == 4) { // Columna de number
                        preparedStatement.setInt(i + 1, Integer.parseInt(value));
                    } else if (i == 5) { // Columna de grid
                        preparedStatement.setInt(i + 1, Integer.parseInt(value));
                    } else if (i == 6) { // Columna de position
                        preparedStatement.setInt(i + 1, Integer.parseInt(value));
                    } else if (i == 7) { // Columna de positionText
                        preparedStatement.setString(i + 1, value);
                    } else if (i == 8) { // Columna de positionOrder
                        preparedStatement.setInt(i + 1, Integer.parseInt(value));
                    } else if (i == 9) { //Columna de points
                        preparedStatement.setFloat(i + 1, Float.parseFloat(value));
                    } else if (i == 10) { // Columna de laps
                        preparedStatement.setInt(i + 1, Integer.parseInt(value));
                    } else if (i == 11) { // Columna de time
                        preparedStatement.setString(i + 1, value);
                    } else if (i == 12) { // Columna de miliseconds
                        preparedStatement.setInt(i + 1, Integer.parseInt(value));
                    } else if (i == 13) { // Columna de fastestLap
                        preparedStatement.setInt(i + 1, Integer.parseInt(value));
                    } else if (i == 14) { // Columna de fastestLapTime
                        preparedStatement.setString(i + 1, value);
                    } else if (i == 15) { // Columna de statusId
                        preparedStatement.setInt(i + 1, Integer.parseInt(value));
                    }
                }

                preparedStatement.addBatch();

                if (++count % batchSize == 0) {
                    preparedStatement.executeBatch();
                }
            }

            preparedStatement.executeBatch(); // Ejecutar el resto de los datos
        } catch (IOException | SQLException e) {
            e.printStackTrace();
        }
    }
//    private static void importConstructorStandingsData(Connection connection) {
//        String line = "";
//        String csvSplitBy = ",";
//        int batchSize = 1000;
//        int count = 0;
//
//        try (BufferedReader br = new BufferedReader(new FileReader(CSV_FILE_PATH_CONSTRUCTORSTANDINGS));
//             PreparedStatement preparedStatement = connection.prepareStatement("INSERT IGNORE INTO constructorstandings (constructorStandingId, raceId, constructorId, points, position, positionText, wins) VALUES (?,?,?,?,?,?,?)")) {
//            br.readLine(); // Saltar la primera línea (encabezados)
//
//            while ((line = br.readLine()) != null) {
//                if (line.trim().isEmpty()) continue; // Saltar líneas vacías
//
//                String[] data = line.split(csvSplitBy);
//
//                for (int i = 0; i < data.length; i++) {
//                    String value = data[i].trim();
//                    if (value.isEmpty() || value.equals("\\N")) {
//                        if (i == 0) { // Columna de constructorStandingId
//                            preparedStatement.setNull(i + 1, java.sql.Types.INTEGER);
//                        } else if (i == 1) { // Columna de raceId
//                            preparedStatement.setNull(i + 1, java.sql.Types.INTEGER);
//                        } else if (i == 2) { // Columna de constructorId
//                            preparedStatement.setNull(i + 1, java.sql.Types.INTEGER);
//                        } else if (i == 3) { // Columna de points
//                            preparedStatement.setNull(i + 1, java.sql.Types.FLOAT);
//                        } else if (i == 4) { // Columna de position
//                            preparedStatement.setNull(i + 1, java.sql.Types.INTEGER);
//                        } else if (i == 5) { // Columna de positionText
//                            preparedStatement.setString(i + 1, null);
//                        } else if (i == 6) { // Columna de wins
//                            preparedStatement.setNull(i + 1, java.sql.Types.INTEGER);
//                        }
//                    } else if (i == 0) { // Columna de constructorStandingId
//                        preparedStatement.setInt(i + 1, Integer.parseInt(value));
//                    } else if (i == 1) { // Columna de raceId
//                        preparedStatement.setInt(i + 1, Integer.parseInt(value));
//                    } else if (i == 2) { // Columna de constructorId
//                        preparedStatement.setInt(i + 1, Integer.parseInt(value));
//                    } else if (i == 3) { // Columna de points
//                        preparedStatement.setFloat(i + 1, Float.parseFloat(value));
//                    } else if (i == 4) { // Columna de position
//                        preparedStatement.setInt(i + 1, Integer.parseInt(value));
//                    } else if (i == 5) { // Columna de positionText
//                        preparedStatement.setString(i + 1, value);
//                    } else if (i == 6) { // Columna de wins
//                        preparedStatement.setInt(i + 1, Integer.parseInt(value));
//                    }
//                }
//
//                preparedStatement.addBatch();
//
//                if (++count % batchSize == 0) {
//                    preparedStatement.executeBatch();
//                }
//            }
//
//            preparedStatement.executeBatch(); // Ejecutar el resto de los datos
//        } catch (IOException | SQLException e) {
//            e.printStackTrace();
//        }
//    }
//    private static void importDriverStandingsData(Connection connection) {
//        String line = "";
//        String csvSplitBy = ",";
//        int batchSize = 1000;
//        int count = 0;
//
//        try (BufferedReader br = new BufferedReader(new FileReader(CSV_FILE_PATH_DRIVERSTANDINGS));
//             PreparedStatement preparedStatement = connection.prepareStatement("INSERT IGNORE INTO driverstandings (driverStandingId, raceId, driverId, points, position, positionText, wins) VALUES (?,?,?,?,?,?,?)")) {
//            br.readLine(); // Saltar la primera línea (encabezados)
//
//            while ((line = br.readLine()) != null) {
//                if (line.trim().isEmpty()) continue; // Saltar líneas vacías
//
//                String[] data = line.split(csvSplitBy);
//
//                for (int i = 0; i < data.length; i++) {
//                    String value = data[i].trim();
//                    if (value.isEmpty() || value.equals("\\N")) {
//                        if (i == 0) { // Columna de driverStandingId
//                            preparedStatement.setNull(i + 1, java.sql.Types.INTEGER);
//                        } else if (i == 1) { // Columna de raceId
//                            preparedStatement.setNull(i + 1, java.sql.Types.INTEGER);
//                        } else if (i == 2) { // Columna de driverId
//                            preparedStatement.setNull(i + 1, java.sql.Types.INTEGER);
//                        } else if (i == 3) { // Columna de points
//                            preparedStatement.setNull(i + 1, java.sql.Types.FLOAT);
//                        } else if (i == 4) { // Columna de position
//                            preparedStatement.setNull(i + 1, java.sql.Types.INTEGER);
//                        } else if (i == 5) { // Columna de positionText
//                            preparedStatement.setString(i + 1, null);
//                        } else if (i == 6) { // Columna de wins
//                            preparedStatement.setNull(i + 1, java.sql.Types.INTEGER);
//                        }
//                    } else if (i == 0) { // Columna de driverStandingId
//                        preparedStatement.setInt(i + 1, Integer.parseInt(value));
//                    } else if (i == 1) { // Columna de raceId
//                        preparedStatement.setInt(i + 1, Integer.parseInt(value));
//                    } else if (i == 2) { // Columna de driverId
//                        preparedStatement.setInt(i + 1, Integer.parseInt(value));
//                    } else if (i == 3) { // Columna de points
//                        preparedStatement.setFloat(i + 1, Float.parseFloat(value));
//                    } else if (i == 4) { // Columna de position
//                        preparedStatement.setInt(i + 1, Integer.parseInt(value));
//                    } else if (i == 5) { // Columna de positionText
//                        preparedStatement.setString(i + 1, value);
//                    } else if (i == 6) { // Columna de wins
//                        preparedStatement.setInt(i + 1, Integer.parseInt(value));
//                    }
//                }
//
//                preparedStatement.addBatch();
//
//                if (++count % batchSize == 0) {
//                    preparedStatement.executeBatch();
//                }
//            }
//
//            preparedStatement.executeBatch(); // Ejecutar el resto de los datos
//        } catch (IOException | SQLException e) {
//            e.printStackTrace();
//        }
//    }
//    private static boolean isInteger(String s) {
//        try { 
//            Integer.parseInt(s); 
//        } catch(NumberFormatException e) { 
//            return false; 
//        }
//        return true;
//    }
//
//    private static boolean isFloat(String s) {
//        try { 
//            Float.parseFloat(s); 
//        } catch(NumberFormatException e) { 
//            return false; 
//        }
//        return true;
//    }
//
////    private static void importResultsData(Connection connection) {
//        String line = "";
//        String csvSplitBy = ",";
//        int batchSize = 1000;
//        int count = 0;
//
//        try (BufferedReader br = new BufferedReader(new FileReader(CSV_FILE_PATH_RESULTS));
//             PreparedStatement preparedStatement = connection.prepareStatement("INSERT IGNORE INTO results (resultId, raceId, driverId, constructorId, number, grid, position, positionText, positionOrder, points, laps, time, milliseconds, fastestLap, rank, fastestLapTime, fastestLapSpeed, statusId) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)")) {
//            br.readLine(); // Saltar la primera línea (encabezados)
//
//            while ((line = br.readLine()) != null) {
//                if (line.trim().isEmpty()) continue; // Saltar líneas vacías
//
//                String[] data = line.split(csvSplitBy);
//
//                for (int i = 0; i < data.length; i++) {
//                    String value = data[i].trim();
//                    if (value.isEmpty() || value.equals("\\N")) {
//                        preparedStatement.setNull(i + 1, java.sql.Types.INTEGER);
//                    } else if (value.startsWith("\"") && value.endsWith("\"")) {
//                        value = value.substring(1, value.length() - 1); // Remover comillas
//                        if (i == 12) { // Columna de tiempo
//                            preparedStatement.setString(i + 1, value);
//                        } else {
//                            preparedStatement.setString(i + 1, value);
//                        }
//                    } else {
//                        if (i == 12) { // Columna de tiempo
//                            preparedStatement.setString(i + 1, value);
//                        } else if (isInteger(value)) {
//                            preparedStatement.setInt(i + 1, Integer.parseInt(value));
//                        } else if (isFloat(value)) {
//                            preparedStatement.setFloat(i + 1, Float.parseFloat(value));
//                        } else {
//                            preparedStatement.setString(i + 1, value);
//                        }
//                    }
//                }
//
//                preparedStatement.addBatch();
//
//                if (++count % batchSize == 0) {
//                    preparedStatement.executeBatch();
//                }
//            }
//
//            preparedStatement.executeBatch(); // Ejecutar el resto de los datos
//        } catch (IOException | SQLException e) {
//            e.printStackTrace();
//        }
//    }
//    private static void importconstructorresultsData(Connection connection) {
//        String line = "";
//        String csvSplitBy = ",";
//        int batchSize = 1000;
//        int count = 0;
//
//        try (BufferedReader br = new BufferedReader(new FileReader(CSV_FILE_PATH_CONSTRUCTORRESULTS));
//             PreparedStatement preparedStatement = connection.prepareStatement("INSERT IGNORE INTO constructorResults (constructorResultId, raceId, constructorId, points, status) VALUES (?,?,?,?,?)")) {
//            br.readLine(); // Saltar la primera línea (encabezados)
//
//            while ((line = br.readLine()) != null) {
//                if (line.trim().isEmpty()) continue; // Saltar líneas vacías
//
//                String[] data = line.split(csvSplitBy);
//
//                for (int i = 0; i < data.length; i++) {
//                    String value = data[i].trim();
//                    if (value.isEmpty() || value.equals("\\N")) {
//                        if (i == 4) { // Columna de status
//                            preparedStatement.setString(i + 1, null);
//                        } else {
//                            preparedStatement.setNull(i + 1, java.sql.Types.INTEGER);
//                        }
//                    } else if (i == 4) { // Columna de status
//                        preparedStatement.setString(i + 1, value);
//                    } else if (isInteger(value)) {
//                        preparedStatement.setInt(i + 1, Integer.parseInt(value));
//                    } else if (isFloat(value)) {
//                        preparedStatement.setFloat(i + 1, Float.parseFloat(value));
//                    } else {
//                        preparedStatement.setString(i + 1, value);
//                    }
//                }
//
//                preparedStatement.addBatch();
//
//                if (++count % batchSize == 0) {
//                    preparedStatement.executeBatch();
//                }
//            }
//
//            preparedStatement.executeBatch(); // Ejecutar el resto de los datos
//        } catch (IOException | SQLException e) {
//            e.printStackTrace();
//        }
//    }
//
//    private static boolean isInteger(String s) {
//        try { 
//            Integer.parseInt(s); 
//        } catch(NumberFormatException e) { 
//            return false; 
//        }
//        return true;
//    }
//
//    private static boolean isFloat(String s) {
//        try { 
//            Float.parseFloat(s); 
//        } catch(NumberFormatException e) { 
//            return false; 
//        }
//        return true;
//    }

//
//    private static void importStatusData(Connection connection) {
//        String line = "";
//        String csvSplitBy = ",";
//        int batchSize = 1000;
//        int count = 0;
//        
//        try (BufferedReader br = new BufferedReader(new FileReader(CSV_FILE_PATH_STATUS))) {
//            String sql = "INSERT INTO status (statusId, status) VALUES (?, ?)";
//            PreparedStatement preparedStatement = connection.prepareStatement(sql);
//            br.readLine();
//
//            while ((line = br.readLine()) != null) {
//                if (line.trim().isEmpty()) continue; // Saltar líneas vacías
//                
//                String[] data = line.split(csvSplitBy);
//                
//                preparedStatement.setInt(1, Integer.parseInt(data[0]));
//                preparedStatement.setString(2, data[1].replaceAll("\"", "")); // Quitar comillas
//                
//                preparedStatement.addBatch();
//                
//                if (++count % batchSize == 0) {
//                    preparedStatement.executeBatch();
//                }
//            }
//            
//            preparedStatement.executeBatch(); // Ejecutar el resto de los datos
//        } catch (IOException | SQLException e) {
//            e.printStackTrace();
//        }
//    }//
}
