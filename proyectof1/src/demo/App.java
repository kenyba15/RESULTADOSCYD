package demo;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import modelos.Driver;
import modelos.Constructors;
import repositorios.DriverRepository;
import repositorios.ConstructorsRepository;

import java.util.Collections;
import java.util.List;

public class App extends Application {
    private DriverRepository driverRepository = new DriverRepository();
    private ConstructorsRepository constructorsRepository = new ConstructorsRepository();

    private ObservableList<Driver> driversData = FXCollections.observableArrayList();
    private ObservableList<Constructors> constructorsData = FXCollections.observableArrayList();

    private TableView<Driver> driverTableView = new TableView<>();
    private TableView<Constructors> constructorsTableView = new TableView<>();

    private ComboBox<Integer> driverYearComboBox = new ComboBox<>();
    private Button driverFilterButton = new Button("Filtrar por Año");

    @Override
    public void start(Stage primaryStage) throws Exception {
        VBox driverVBox = new VBox();
        driverVBox.getChildren().addAll(driverYearComboBox, driverFilterButton, driverTableView);
        Scene driverScene = new Scene(driverVBox, 800, 600);
        driverScene.getRoot().setStyle(
            "-fx-background-color: linear-gradient(from 25% 25% to 100% 100%, #8e44ad, #3498db);" +
            "-fx-padding: 20px;"
        );
        VBox constructorsVBox = new VBox();
        constructorsVBox.getChildren().addAll(constructorsTableView);
        Scene constructorsScene = new Scene(constructorsVBox, 800, 600);
        constructorsScene.getRoot().setStyle(
            "-fx-background-color: linear-gradient(from 25% 25% to 100% 100%, #2ecc71, #27ae60);" +
            "-fx-padding: 20px;"
        );
        configureDriversTableView();
        configureConstructorsTableView();

        List<Integer> uniqueDriverYears = driverRepository.getUniqueYears();
        Collections.sort(uniqueDriverYears);
        driverYearComboBox.getItems().addAll(uniqueDriverYears);

        driverYearComboBox.setStyle(
            "-fx-background-color: #ffffff;" +
            "-fx-border-color: #ddd;" +
            "-fx-border-width: 1px;" +
            "-fx-padding: 5px;"
        );
        driverFilterButton.setStyle(
            "-fx-background-color: #3498db;" +
            "-fx-text-fill: #ffffff;" +
            "-fx-padding: 10px 20px;" +
            "-fx-font-size: 14px;" +
            "-fx-border-radius: 5px;" +
            "-fx-background-radius: 5px;"
        );
        driverFilterButton.setOnAction(event -> {
            Integer selectedYear = driverYearComboBox.getValue();
            if (selectedYear != null) {
                filterDriversByYear(selectedYear);
            }
        });
        primaryStage.setScene(driverScene);
        primaryStage.setTitle("Drivers Fórmula 1");
        primaryStage.show();

        Stage constructorsStage = new Stage();
        constructorsStage.setScene(constructorsScene);
        constructorsStage.setTitle("Constructores Fórmula 1");
        constructorsStage.show();
    }

    private void configureDriversTableView() {
        TableColumn<Driver, Integer> idColumn = new TableColumn<>("ID");
        idColumn.setCellValueFactory(new PropertyValueFactory<>("driverId"));

        TableColumn<Driver, Integer> numberColumn = new TableColumn<>("WINS");
        numberColumn.setCellValueFactory(new PropertyValueFactory<>("number"));

        TableColumn<Driver, String> codeColumn = new TableColumn<>("Código");
        codeColumn.setCellValueFactory(new PropertyValueFactory<>("code"));

        TableColumn<Driver, String> forenameColumn = new TableColumn<>("Nombre");
        forenameColumn.setCellValueFactory(new PropertyValueFactory<>("forename"));

        TableColumn<Driver, String> surnameColumn = new TableColumn<>("Apellido");
        surnameColumn.setCellValueFactory(new PropertyValueFactory<>("surname"));

        TableColumn<Driver, String> nationalityColumn = new TableColumn<>("Nacionalidad");
        nationalityColumn.setCellValueFactory(new PropertyValueFactory<>("nationality"));

        TableColumn<Driver, String> urlColumn = new TableColumn<>("URL");
        urlColumn.setCellValueFactory(new PropertyValueFactory<>("url"));

        driverTableView.getColumns().addAll(idColumn, numberColumn, codeColumn, forenameColumn, surnameColumn, nationalityColumn, urlColumn);
        driversData.addAll(driverRepository.getAllDrivers());
        driverTableView.setItems(driversData);
        driverTableView.setStyle(
            "-fx-background-color: #ffffff;" +
            "-fx-border-color: #ddd;" +
            "-fx-border-width: 1px;"
        );
    }

    private void configureConstructorsTableView() {
        TableColumn<Constructors, Integer> constructorIdColumn = new TableColumn<>("ID");
        constructorIdColumn.setCellValueFactory(new PropertyValueFactory<>("constructorId"));

        TableColumn<Constructors, String> constructorRefColumn = new TableColumn<>("Referencia");
        constructorRefColumn.setCellValueFactory(new PropertyValueFactory<>("constructorRef"));

        TableColumn<Constructors, String> nameColumn = new TableColumn<>("Nombre");
        nameColumn.setCellValueFactory(new PropertyValueFactory<>("name"));

        TableColumn<Constructors, String> constructorNationalityColumn = new TableColumn<>("Nacionalidad");
        constructorNationalityColumn.setCellValueFactory(new PropertyValueFactory<>("nationality"));

        TableColumn<Constructors, String> constructorUrlColumn = new TableColumn<>("URL");
        constructorUrlColumn.setCellValueFactory(new PropertyValueFactory<>("url"));

        constructorsTableView.getColumns().addAll(constructorIdColumn, constructorRefColumn, nameColumn, constructorNationalityColumn, constructorUrlColumn);
        constructorsData.addAll(constructorsRepository.getAllConstructors());
        constructorsTableView.setItems(constructorsData);
        constructorsTableView.setStyle(
            "-fx-background-color: #ffffff;" +
            "-fx-border-color: #ddd;" +
            "-fx-border-width: 1px;"
        );
    }

    private void filterDriversByYear(Integer year) {
        List<Driver> filteredDrivers = driverRepository.getDriversByYear(year);
        driversData.clear();
        driversData.addAll(filteredDrivers);
    }

    public static void main(String[] args) {
        launch(args);
    }
}
