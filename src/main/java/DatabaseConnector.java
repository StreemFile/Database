import javafx.collections.ObservableList;
import model.Automobile;
import model.Service.Implementations.AutomobileCRUDService;

import java.sql.*;

/**
 * Created by IntelliJ IDEA.
 * Database.DatabaseConnector
 *
 * @Autor: vovamv
 * @DateTime: 12/3/20|3:06 пп
 * @Version DatabaseConnector: 1.0
 */

public class DatabaseConnector {
    final String uri = "jdbc:mysql://localhost:3306/";
    final String dbName = "car_dealership";
    final String login = "root";
    final String password = "15272001";
    AutomobileCRUDService automobileCRUDService = new AutomobileCRUDService();
    Connection connection;

    {
        try {
            connection = DriverManager.getConnection(uri + dbName, login, password);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }


    public void connect(ObservableList<Automobile> autos) throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.cj.jdbc.Driver");
        automobileCRUDService.read(autos, connection);
    }
    public void createItem(ObservableList<Automobile> autos, Automobile auto){
        automobileCRUDService.create(autos, connection, auto);
    }
    public void updateItem(ObservableList<Automobile> autos, Automobile auto){
        automobileCRUDService.update(autos,connection, auto);
    }
    public void deleteItem(int idOfAutoToDelete){
        automobileCRUDService.delete(idOfAutoToDelete, connection);
    }
}
