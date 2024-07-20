package demo;

import java.util.List;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import modelos.ConstructorMaxPoint;
import modelos.DriverMaxPoint;
import repositorios.QueryRepositorio;

public class MaxPointTableView extends Application {

    @Override
    public void start(Stage primaryStage) {
        QueryRepositorio queryRepositorio = new QueryRepositorio();

        // Crear tabla para drivers
        List<DriverMaxPoint> driverResults = queryRepositorio.getDriversMaxPoint("jdbc:mysql://localhost/formula1", "root", "");
        ObservableList<DriverMaxPoint> driverData = FXCollections.observableArrayList(driverResults);

        TableView<DriverMaxPoint> driverTableView = new TableView<>();
        driverTableView.setItems(driverData);

        TableColumn<DriverMaxPoint, String> driverNameColumn = new TableColumn<>("Driver Name");
        driverNameColumn.setCellValueFactory(new PropertyValueFactory<>("driverName"));
        driverTableView.getColumns().add(driverNameColumn);

        TableColumn<DriverMaxPoint, Float> driverPointsColumn = new TableColumn<>("Points");
        driverPointsColumn.setCellValueFactory(new PropertyValueFactory<>("points"));
        driverTableView.getColumns().add(driverPointsColumn);

        // Crear escena para drivers
        Scene driverScene = new Scene(driverTableView, 800, 300);

        // Crear ventana para drivers
        Stage driverStage = new Stage();
        driverStage.setTitle("Drivers");
        driverStage.setScene(driverScene);
        driverStage.show();

        // Crear tabla para constructors
        List<ConstructorMaxPoint> constructorResults = queryRepositorio.getConstructorsMaxPoints("jdbc:mysql://localhost/formula1", "root", "");
        ObservableList<ConstructorMaxPoint> constructorData = FXCollections.observableArrayList(constructorResults);

        TableView<ConstructorMaxPoint> constructorTableView = new TableView<>();
        constructorTableView.setItems(constructorData);

        TableColumn<ConstructorMaxPoint, String> constructorNameColumn = new TableColumn<>("Constructor Name");
        constructorNameColumn.setCellValueFactory(new PropertyValueFactory<>("Constructorname"));
        constructorTableView.getColumns().add(constructorNameColumn);

        TableColumn<ConstructorMaxPoint, Float> constructorPointsColumn = new TableColumn<>("Points");
        constructorPointsColumn.setCellValueFactory(new PropertyValueFactory<>("points"));
        constructorTableView.getColumns().add(constructorPointsColumn);

        // Crear escena para constructors
        Scene constructorScene = new Scene(constructorTableView, 800, 300);

        // Crear ventana para constructors
        Stage constructorStage = new Stage();
        constructorStage.setTitle("Constructors");
        constructorStage.setScene(constructorScene);
        constructorStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
