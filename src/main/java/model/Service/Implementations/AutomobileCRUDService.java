package model.Service.Implementations;

import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import model.Automobile;
import model.Service.Interfaces.IAutomobileCRUDService;

import java.awt.*;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDateTime;
import java.util.stream.IntStream;


/**
 * Created by IntelliJ IDEA.
 * Database.AutomobileCRUDService
 *
 * @Autor: vovamv
 * @DateTime: 07.12.2020|18:45
 * @Version AutomobileCRUDService: 1.0
 */

public class AutomobileCRUDService implements IAutomobileCRUDService {
    @Override
    public void create(ObservableList<Automobile> autos, Connection connection,
                       Automobile auto) {
        try {
            Statement statement = connection.createStatement();
            String queryCreate = "INSERT INTO Volkswagen(make, vehicleType, "
                    + "model, transmission, fuel, capacity, KWandPS, headlights,"
                    +" color, wheels, tyres, price, description, created_at, modified_at)"
                    + "VALUES ('Volkswagen', '" + auto.getVehicleType() + "', '"
                    + auto.getModel() + "', '" + auto.getTransmission()  + "', '"
                    + auto.getFuel()  + "', '" + auto.getCapacity() + "', '"
                    + auto.getKwAndPs()  + "', '" + auto.getHeadlights()
                    + "', '" + auto.getColor() + "', '" + auto.getWheels()
                    + "', '" + auto.getTyres() + "', '" + auto.getPrice()
                    + "', '" + auto.getDescription() + "', '" + LocalDateTime.now().toString()
                    + "', '" + auto.getModified_at() + "')";
            int resultSet = statement.executeUpdate(queryCreate);
            if (resultSet >= 0) {
                autos.clear();
                read(autos,connection);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

    }

    @Override
    public void read(ObservableList<Automobile> autos, Connection connection) {
        try {
            Statement statement = connection.createStatement();
            String queryReadAll = "select * from Volkswagen";
            ResultSet resultSet = statement.executeQuery(queryReadAll);
            while (resultSet.next()){
                autos.add(new Automobile(
                   resultSet.getInt(1),
                   resultSet.getString(2),
                   resultSet.getString(3),
                   resultSet.getString(4),
                   resultSet.getString(5),
                   resultSet.getString(6),
                   resultSet.getString(7),
                   resultSet.getString(8),
                   resultSet.getString(9),
                   resultSet.getString(10),
                   resultSet.getString(11),
                   resultSet.getString(12),
                   resultSet.getString(13),
                   resultSet.getString(14),
                   resultSet.getString(15),
                   resultSet.getString(16)
                ));
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

    }

    @Override
    public void update(ObservableList<Automobile> autos, Connection connection, Automobile auto) {
        try {
            Statement statement = connection.createStatement();
            String queryUpdate = "update Volkswagen \n" +
                    "set\n" +
                    "vehicleType = '" + auto.getVehicleType() + "',\n" +
                    "model='" + auto.getModel() + "', \n" +
                    "capacity=' "+ auto.getCapacity() + "',\n" +
                    "KWandPS = '"+ auto.getKwAndPs()+"',\n" +
                    "fuel = '"+auto.getFuel()+"',\n" +
                    "transmission = '"+auto.getTransmission()+"',\n" +
                    "headlights = '"+auto.getHeadlights()+"',\n" +
                    "color = '"+auto.getColor()+"',\n" +
                    "tyres = '"+auto.getTyres()+"',\n" +
                    "wheels = '"+auto.getWheels()+"',\n" +
                    "price = '"+auto.getPrice()+"',\n" +
                    "description = '"+auto.getDescription()+"',\n" +
                    "modified_at = '"+auto.getModified_at()+"'\n" +
                    "WHERE id = "+auto.getId()+";";
            statement.executeUpdate(queryUpdate);
            int id = 0;
            for (Automobile automobileToUpdate : autos) {
                if(automobileToUpdate.getId() == auto.getId())
                    id = auto.getId();
            }
            autos.clear();
            read(autos,connection);
            autos.get(id).setVehicleType(auto.getVehicleType());
            autos.get(id).setModel(auto.getModel());
            autos.get(id).setCapacity(auto.getCapacity());
            autos.get(id).setFuel(auto.getFuel());
            autos.get(id).setKwAndPs(auto.getKwAndPs());
            autos.get(id).setTransmission(auto.getTransmission());
            autos.get(id).setHeadlights(auto.getHeadlights());
            autos.get(id).setColor(auto.getColor());
            autos.get(id).setTyres(auto.getTyres());
            autos.get(id).setWheels(auto.getWheels());
            autos.get(id).setPrice(auto.getPrice());
            autos.get(id).setDescription(auto.getDescription());
            autos.get(id).setModified_at(auto.getModified_at());
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
    @Override
    public void delete(int idOfAutoToDelete, Connection connection) {
        try {
            Statement statement = connection.createStatement();
            String queryDelete = "delete from Volkswagen where id = " + idOfAutoToDelete;
            int result = statement.executeUpdate(queryDelete);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }


    }
}
