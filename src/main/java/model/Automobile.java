package model;

/**
 * Created by IntelliJ IDEA.
 * Database.Automobile
 *
 * @Autor: vovamv
 * @DateTime: 12/3/20|2:32 пп
 * @Version Automobile: 1.0
 */

public class Automobile {
    private int id;
    private String make;
    private String vehicleType;
    private String model;
    private String transmission;
    private String fuel;
    private String capacity;
    private String kwAndPs;
    private String headlights;
    private String color;
    private String wheels;
    private String tyres;
    private String price;
    private String description;
    private String created_at;
    private String modified_at;

    public Automobile() {
    }

    public Automobile(int id, String make, String vehicleType, String model,
                      String transmission, String fuel, String capacity,
                      String kwAndPs, String headlights, String color,
                      String wheels, String tyres, String price,
                      String description, String created_at,
                      String modified_at) {
        this.id = id;
        this.make = make;
        this.vehicleType = vehicleType;
        this.model = model;
        this.transmission = transmission;
        this.fuel = fuel;
        this.capacity = capacity;
        this.kwAndPs = kwAndPs;
        this.headlights = headlights;
        this.color = color;
        this.wheels = wheels;
        this.tyres = tyres;
        this.price = price;
        this.description = description;
        this.created_at = created_at;
        this.modified_at = modified_at;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getMake() {
        return make;
    }

    public void setMake(String make) {
        this.make = make;
    }

    public String getVehicleType() {
        return vehicleType;
    }

    public void setVehicleType(String vehicleType) {
        this.vehicleType = vehicleType;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getTransmission() {
        return transmission;
    }

    public void setTransmission(String transmission) {
        this.transmission = transmission;
    }

    public String getFuel() {
        return fuel;
    }

    public void setFuel(String fuel) {
        this.fuel = fuel;
    }

    public String getCapacity() {
        return capacity;
    }

    public void setCapacity(String capacity) {
        this.capacity = capacity;
    }

    public String getKwAndPs() {
        return kwAndPs;
    }

    public void setKwAndPs(String kwAndPs) {
        this.kwAndPs = kwAndPs;
    }

    public String getHeadlights() {
        return headlights;
    }

    public void setHeadlights(String headlights) {
        this.headlights = headlights;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getWheels() {
        return wheels;
    }

    public void setWheels(String wheels) {
        this.wheels = wheels;
    }

    public String getTyres() {
        return tyres;
    }

    public void setTyres(String tyres) {
        this.tyres = tyres;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getCreated_at() {
        return created_at;
    }

    public void setCreated_at(String created_at) {
        this.created_at = created_at;
    }

    public String getModified_at() {
        return modified_at;
    }

    public void setModified_at(String modified_at) {
        this.modified_at = modified_at;
    }
}
