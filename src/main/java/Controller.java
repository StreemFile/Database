import javafx.beans.property.SimpleObjectProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.input.MouseEvent;
import model.Automobile;
import model.Service.Implementations.AutomobileCRUDService;

import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by IntelliJ IDEA.
 * Database.Controller
 *
 * @Autor: vovamv
 * @DateTime: 12/3/20|2:30 пп
 * @Version Controller: 1.0
 */

public class Controller {
    @FXML
    private TableView<Automobile> volkswagen;
    @FXML
    private TableColumn<Automobile, Integer> id;
    @FXML
    private TableColumn<Automobile, String> make;
    @FXML
    private TableColumn<Automobile, String> vehicleType;
    @FXML
    private TableColumn<Automobile, String> model;
    @FXML
    private TableColumn<Automobile, String> transmission;
    @FXML
    private TableColumn<Automobile, String> fuel;
    @FXML
    private TableColumn<Automobile, String> capacity;
    @FXML
    private TableColumn<Automobile, String> kwAndPs;
    @FXML
    private TableColumn<Automobile, String> headlights;
    @FXML
    private TableColumn<Automobile, String> color;
    @FXML
    private TableColumn<Automobile, String> wheels;
    @FXML
    private TableColumn<Automobile, String> tyres;
    @FXML
    private TableColumn<Automobile, String> price;
    @FXML
    private TableColumn<Automobile, String> description;
    @FXML
    private TableColumn<Automobile, String> created_at;
    @FXML
    private TableColumn<Automobile, String> modified_at;


    ObservableList<Automobile> autos = FXCollections.observableArrayList();

    DatabaseConnector databaseConnector = new DatabaseConnector();
    @FXML
    public void initialize() throws SQLException, ClassNotFoundException {
        databaseConnector.connect(autos);
        volkswagen.itemsProperty().setValue(autos);
        contextMenu();
        showAutoInfo();
        addAuto();
        deleteAutomobile();
        updateButtonPress();
    }

    public void contextMenu(){
        volkswagen.setRowFactory(param -> {
            TableRow<Automobile> rows = new TableRow<>();
            MenuItem deleteMenu = new MenuItem("Delete");
            MenuItem updateMenu = new MenuItem("Update");
            deleteMenu.setOnAction(event -> deleteAutomobile());
            updateMenu.setOnAction(event -> updateAutomobile());
            ContextMenu menu = new ContextMenu(deleteMenu,updateMenu);
            rows.contextMenuProperty().setValue(menu);
            return rows;
        });
    }

    @FXML
    public void deleteAutomobile(){
        volkswagen.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
        ObservableList<Automobile> selectedRows =
                volkswagen.getSelectionModel().getSelectedItems();
        List<Automobile> rowToDelete = new ArrayList<>(selectedRows);
        for (Automobile deleteRow : rowToDelete) {
            databaseConnector.deleteItem(deleteRow.getId());
            volkswagen.getItems().remove(deleteRow);
        }
    }

    @FXML
    public void updateAutomobile(){
        vehicleTypeComboBox.setValue(volkswagen.getSelectionModel()
                .getSelectedItem()
                .getVehicleType());
        modelComboBox.setValue(volkswagen.getSelectionModel()
                .getSelectedItem()
                .getModel());
        capacityComboBox.setValue(volkswagen.getSelectionModel()
                .getSelectedItem()
                .getCapacity());
        fuelComboBox.setValue(volkswagen.getSelectionModel()
                .getSelectedItem()
                .getFuel());
        kwComboBox.setValue(volkswagen.getSelectionModel()
                .getSelectedItem()
                .getKwAndPs());
        transmissionComboBox.setValue(volkswagen.getSelectionModel()
                .getSelectedItem()
                .getTransmission());
        headlightsComboBox.setValue(volkswagen.getSelectionModel()
                .getSelectedItem()
                .getHeadlights());
        colorComboBox.setValue(volkswagen.getSelectionModel()
                .getSelectedItem()
                .getColor());
        tyresComboBox.setValue(volkswagen.getSelectionModel()
                .getSelectedItem()
                .getTyres());
        wheelsComboBox.setValue(volkswagen.getSelectionModel()
                .getSelectedItem()
                .getWheels());
        priceSetter.setText(volkswagen.getSelectionModel()
                .getSelectedItem()
                .getPrice());
        description.setText(volkswagen.getSelectionModel()
                .getSelectedItem()
                .getPrice());
        databaseConnector.updateItem(autos,automobile);
        updateButtonPress();
    }

    @FXML
    Button updateButton = new Button();

    @FXML
    public void updateButtonPress(){
        updateButton.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                databaseConnector.updateItem(autos,automobile);
                updateButton.setOpacity(0);
            }
        });
        updateButton.setOpacity(1);
    }

    public void showAutoInfo(){
        id.setCellValueFactory(param -> new SimpleObjectProperty<>(param.getValue().getId()));
        make.setCellValueFactory(param -> new SimpleObjectProperty<>(param.getValue().getMake()));
        vehicleType.setCellValueFactory(param -> new SimpleObjectProperty<>(param.getValue().getVehicleType()));
        model.setCellValueFactory(param -> new SimpleObjectProperty<>(param.getValue().getModel()));
        transmission.setCellValueFactory(param -> new SimpleObjectProperty<>(param.getValue().getTransmission()));
        fuel.setCellValueFactory(param -> new SimpleObjectProperty<>(param.getValue().getFuel()));
        capacity.setCellValueFactory(param -> new SimpleObjectProperty<>(param.getValue().getCapacity()));
        kwAndPs.setCellValueFactory(param -> new SimpleObjectProperty<>(param.getValue().getKwAndPs()));
        headlights.setCellValueFactory(param -> new SimpleObjectProperty<>(param.getValue().getHeadlights()));
        color.setCellValueFactory(param -> new SimpleObjectProperty<>(param.getValue().getColor()));
        wheels.setCellValueFactory(param -> new SimpleObjectProperty<>(param.getValue().getWheels()));
        tyres.setCellValueFactory(param -> new SimpleObjectProperty<>(param.getValue().getTyres()));
        price.setCellValueFactory(param -> new SimpleObjectProperty<>(param.getValue().getPrice()));
        description.setCellValueFactory(param -> new SimpleObjectProperty<>(param.getValue().getDescription()));
        created_at.setCellValueFactory(param -> new SimpleObjectProperty<>(param.getValue().getCreated_at()));
        modified_at.setCellValueFactory(param -> new SimpleObjectProperty<>(param.getValue().getModified_at()));
    }

    Automobile automobile = new Automobile();
    public void addAuto(){
        selectVehicleType();
        selectHeadlights();
        selectColor();
        selectWheels();
        selectTyres();
        setPrice();
        setDescription();
        addButtonPress();
    }

    @FXML
    private ComboBox<String> vehicleTypeComboBox = new ComboBox<>();

    @FXML
    public void selectVehicleType(){
        ObservableList vehicleTypeItems = FXCollections.observableArrayList("Hatchback","Saloon","Van/Minibus","Pickup/Off-Road");
        vehicleTypeComboBox.setItems(vehicleTypeItems);
        automobile.setVehicleType(vehicleTypeComboBox.getValue());
        if(vehicleTypeComboBox.getValue() != null) {
            selectModel();
        }
    }

    @FXML
    private ComboBox<String> modelComboBox = new ComboBox();

    @FXML
    public void selectModel(){
        modelComboBox.setDisable(true);
        if(automobile.getVehicleType() == "Hatchback"){
            modelComboBox.setDisable(false);
            ObservableList modelItems = FXCollections.observableArrayList("Golf");
            modelComboBox.setItems(modelItems);
            automobile.setModel(modelComboBox.getValue());
            if (modelComboBox.getValue() != null) {
                selectCapacity();
            }
        }
    }
    @FXML
    private ComboBox<String> capacityComboBox = new ComboBox();

    @FXML
    public void selectCapacity(){
        capacityComboBox.setDisable(true);
        if(automobile.getModel().equals("Golf")) {
            capacityComboBox.setDisable(false);
            ObservableList capacityItems = FXCollections.observableArrayList("1.0","1.4","2.0");
            capacityComboBox.setItems(capacityItems);
            automobile.setCapacity(capacityComboBox.getValue());
        }
        if (capacityComboBox.getValue() != null) {
            selectKW();
            selectTransmission();
            selectFuel();
        }
    }

    @FXML
    private ComboBox<String> kwComboBox = new ComboBox();

    @FXML
    public void selectKW(){
        kwComboBox.setDisable(true);
        if(automobile.getCapacity() == "1.0" && automobile.getModel() == "Golf") {
            kwComboBox.setDisable(false);
            ObservableList kwItems = FXCollections.observableArrayList("63(85)","81(110)");
            kwComboBox.setItems(kwItems);
            automobile.setKwAndPs(kwComboBox.getValue());
        }
        else if(automobile.getCapacity() == "1.4" && automobile.getModel() == "Golf") {
            kwComboBox.setDisable(false);
            ObservableList kwItems = FXCollections.observableArrayList("92(125)","110(150)");
            kwComboBox.setItems(kwItems);
            automobile.setKwAndPs(kwComboBox.getValue());
        }
        else if(automobile.getCapacity() == "2.0" && automobile.getModel() == "Golf") {
            kwComboBox.setDisable(false);
            ObservableList kwItems = FXCollections.observableArrayList("228(310)","170(230)","180(245)");
            kwComboBox.setItems(kwItems);
            automobile.setKwAndPs(kwComboBox.getValue());
        }
    }

    @FXML
    private ComboBox<String> fuelComboBox = new ComboBox();
    @FXML
    public void selectFuel(){
        fuelComboBox.setDisable(true);
        if(automobile.getModel() == "Golf") {
            fuelComboBox.setDisable(false);
            ObservableList fuelItems = FXCollections.observableArrayList("Petrol");
            fuelComboBox.setItems(fuelItems);
            automobile.setFuel(fuelComboBox.getValue());
        }
    }

    @FXML
    private ComboBox<String> transmissionComboBox = new ComboBox();
    @FXML
    public void selectTransmission(){
        transmissionComboBox.setDisable(true);
        if((automobile.getModel() == "Golf" && automobile.getCapacity() == "1.0")
        || automobile.getModel() == "Golf" && automobile.getCapacity() == "1.4") {
            transmissionComboBox.setDisable(false);
            ObservableList transmissionItems = FXCollections.observableArrayList("Automatic", "Manual");
            transmissionComboBox.setItems(transmissionItems);
            automobile.setTransmission(transmissionComboBox.getValue());
        }
        else if(automobile.getModel() == "Golf" && automobile.getCapacity() == "2.0") {
            transmissionComboBox.setDisable(false);
            ObservableList transmissionItems = FXCollections.observableArrayList("Automatic");
            transmissionComboBox.setItems(transmissionItems);
            automobile.setTransmission(transmissionComboBox.getValue());
        }
    }

    @FXML
    private ComboBox<String> headlightsComboBox = new ComboBox();
    @FXML
    public void selectHeadlights(){
        ObservableList headlightsItems = FXCollections.observableArrayList("Usual","Xenon","Bi-Xenon","LED", "Laser");
        headlightsComboBox.setItems(headlightsItems);
        automobile.setHeadlights(headlightsComboBox.getValue());
    }



    @FXML
    private ComboBox<String> colorComboBox = new ComboBox();
    @FXML
    public void selectColor(){
        ObservableList colorItems = FXCollections.observableArrayList("Black","White","Grey","Blue","Brown","Green");
        colorComboBox.setItems(colorItems);
        automobile.setColor(colorComboBox.getValue());
    }

    @FXML
    private ComboBox<String> wheelsComboBox = new ComboBox();
    @FXML
    public void selectWheels(){
        ObservableList wheelsItems = FXCollections.observableArrayList("Alloy","Steel");
        wheelsComboBox.setItems(wheelsItems);
        automobile.setWheels(wheelsComboBox.getValue());
    }
    @FXML
    private ComboBox<String> tyresComboBox = new ComboBox();
    @FXML
    public void selectTyres(){
        ObservableList tyresItems = FXCollections.observableArrayList("Winter","Summer","All season");
        tyresComboBox.setItems(tyresItems);
        automobile.setTyres(tyresComboBox.getValue());
    }

    @FXML
    private TextField priceSetter = new TextField();

    @FXML
    public void setPrice(){
        automobile.setPrice(priceSetter.getText());
    }

    @FXML
    private TextField descriptionSetter = new TextField();
    @FXML
    public void setDescription(){
        automobile.setDescription(descriptionSetter.getText());
    }

    @FXML
    private Button addButton = new Button("Add");

    @FXML
    public void addButtonPress(){
        addButton.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                automobile.setDescription(descriptionSetter.getText());
                automobile.setPrice(priceSetter.getText());
                databaseConnector.createItem(autos,automobile);
                vehicleTypeComboBox.getSelectionModel().clearSelection();
                modelComboBox.getSelectionModel().clearSelection();
                modelComboBox.setDisable(true);
                capacityComboBox.getSelectionModel().clearSelection();
                capacityComboBox.setDisable(true);
                fuelComboBox.getSelectionModel().clearSelection();
                fuelComboBox.setDisable(true);
                kwComboBox.getSelectionModel().clearSelection();
                kwComboBox.setDisable(true);
                transmissionComboBox.getSelectionModel().clearSelection();
                transmissionComboBox.setDisable(true);
                headlightsComboBox.getSelectionModel().clearSelection();
                tyresComboBox.getSelectionModel().clearSelection();
                wheelsComboBox.getSelectionModel().clearSelection();
                colorComboBox.getSelectionModel().clearSelection();
                priceSetter.clear();
                descriptionSetter.clear();
                automobile.setVehicleType(null);
                automobile.setModel(null);
                automobile.setCapacity(null);
                automobile.setFuel(null);
                automobile.setKwAndPs(null);
                automobile.setTransmission(null);
                automobile.setHeadlights(null);
                automobile.setColor(null);
                automobile.setTyres(null);
                automobile.setWheels(null);
                automobile.setPrice(null);
                automobile.setDescription(null);
                automobile.setCreated_at(null);
                automobile.setModified_at(null);
            }
        });
    }
}



