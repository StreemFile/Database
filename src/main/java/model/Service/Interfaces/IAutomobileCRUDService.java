package model.Service.Interfaces;

import javafx.collections.ObservableList;
import model.Automobile;

import java.sql.Connection;
import java.util.Map;

/**
 * Created by IntelliJ IDEA.
 * Database.AutomobileCRUDService
 *
 * @Autor: vovamv
 * @DateTime: 07.12.2020|18:43
 * @Version AutomobileCRUDService: 1.0
 */

public interface IAutomobileCRUDService {
    void create(ObservableList<Automobile> autos, Connection connection, Automobile auto);
    void read(ObservableList<Automobile> autos, Connection connection);
    void update(ObservableList<Automobile> autos,Connection connection, Automobile auto);
    void delete(int idOfAutoToDelete, Connection connection);
}
