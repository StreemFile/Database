import java.sql.*;

import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.CacheHint;
import javafx.scene.Scene;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.ComboBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;


//public class Main{
//
//    public static void main(String[] args) throws ClassNotFoundException, SQLException {
//        Class.forName("com.mysql.cj.jdbc.Driver");
//
//        final String uri = "jdbc:mysql://localhost:3306/";
//        final String dbName = "car_dealership";
//        final String login = "root";
//        final String password = "15272001";
//
//        Connection connection = DriverManager.getConnection(uri + dbName, login, password);
//
//        Statement statement = connection.createStatement();
//
//        String queryGetAll = "select * from Automobile";
//
//        ResultSet resultSet = statement.executeQuery(queryGetAll);
//        System.out.println("id " + "Make " + "VehicleType " + "Model "
//                + " Engine " + "ExteriorColor " + "InteriorColor "
//                + "InteriorMaterial " + "NumberOfDoors " + "NumberOfSeats "
//                + "TyresType " + "WheelsType " + "HeadlightsType "
//                + "ProducingCountry " + "DealershipID " + "Price"
//                + "    Availability");
//
//        while(resultSet.next()){
//            System.out.printf("%2d", resultSet.getInt(1));
//            System.out.printf("%4d", resultSet.getInt(12));
//            System.out.printf("%9d", resultSet.getInt(7));
//            System.out.printf("%8d", resultSet.getInt(6));
//            System.out.printf("%8d", resultSet.getInt(5));
//            System.out.printf("%10d", resultSet.getInt(13));
//            System.out.printf("%14d", resultSet.getInt(9));
//            System.out.printf("%15d", resultSet.getInt(8));
//            System.out.printf("%17d", resultSet.getInt(2));
//            System.out.printf("%14d", resultSet.getInt(3));
//            System.out.printf("%12d", resultSet.getInt(14));
//            System.out.printf("%10d", resultSet.getInt(15));
//            System.out.printf("%12d", resultSet.getInt(17));
//            System.out.printf("%16d", resultSet.getInt(11));
//            System.out.printf("%17d", resultSet.getInt(10));
//            System.out.printf("%13.2f", resultSet.getDouble(16));
//            System.out.printf("%10s %n", resultSet.getString(4));
//        }
//    }
//}


public class Main extends Application {
    private Stage stage;
    private Scene scene;
    private VBox vBox;

    public static void main(String[] args){
        launch(args);
    }


    @Override
    public void start(Stage primaryStage) throws Exception {
        this.stage = primaryStage;
        vBox = FXMLLoader.load(Main.class.getResource("database.fxml"));
        scene = new Scene(vBox, 1280,720);
        stage.setScene(scene);
        stage.show();
    }
}
