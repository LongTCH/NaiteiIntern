package com.example;
import jakarta.persistence.*;

@Entity
@Table(name = "Vehicle")
public class Vehicle {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String vehicleNumber;
    private String manufacturer;
    private int yearOfManufacture;
    private String color;
    @Version
    private int version ;

    @ManyToOne
    @JoinColumn(name = "owner_id")
    private VehicleOwner owner;
    // Getters and Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getVehicleNumber() {
        return vehicleNumber;
    }

    public void setVehicleNumber(String vehicleNumber) {
        this.vehicleNumber = vehicleNumber;
    }
    public String getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    public int getYearOfManufacture() {
        return yearOfManufacture;
    }
    public void setYearOfManufacture(int yearOfManufacture) {
        this.yearOfManufacture = yearOfManufacture;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public VehicleOwner getOwner() {
        return owner;
    }

    public void setOwner(VehicleOwner owner) {
        this.owner = owner;
    }
    public int getVersion() { return version; }
    public void setVersion(int version) { this.version = version; }
    @Override
    public String toString() {
        return "Vehicle [id=" + id + ", vehicleNumber=" + vehicleNumber + ", manufacturer=" + manufacturer +
                ", yearOfManufacture=" + yearOfManufacture + ", color=" + color + ", version=" + version + "]";
    }
}
