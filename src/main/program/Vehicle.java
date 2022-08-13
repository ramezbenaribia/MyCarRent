package main.program;

public class Vehicle {

    private String vehicleID;
    private String brand;
    private String model;
    private String type;
    private int manufactureYear;
    private int seatsNumber;
    private String color;
    private float rentalPerDay;
    private float insurancePerDay;
    private float serviceFee;
    private String discount;

    public Vehicle(
            String vehicleID,
            String brand,
            String model,
            String type,
            int manufactureYear,
            int seatsNumber,
            String color,
            float rentalPerDay,
            float insurancePerDay,
            float serviceFee,
            String discount) {
        this.vehicleID = vehicleID;
        this.brand = brand;
        this.model = model;
        this.type = type;
        this.manufactureYear = manufactureYear;
        this.seatsNumber = seatsNumber;
        this.color = color;
        this.rentalPerDay = rentalPerDay;
        this.insurancePerDay = insurancePerDay;
        this.serviceFee = serviceFee;
        this.discount = discount;
    }

    public String getVehicleID() {
        return vehicleID;
    }

    public void setVehicleID(String vehicleID) {
        this.vehicleID = vehicleID;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getManufactureYear() {
        return manufactureYear;
    }

    public void setManufactureYear(int manufactureYear) {
        this.manufactureYear = manufactureYear;
    }

    public int getSeatsNumber() {
        return seatsNumber;
    }

    public void setSeatsNumber(int seatsNumber) {
        this.seatsNumber = seatsNumber;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public float getRentalPerDay() {
        return rentalPerDay;
    }

    public void setRentalPerDay(float rentalPerDay) {
        this.rentalPerDay = rentalPerDay;
    }

    public float getInsurancePerDay() {
        return insurancePerDay;
    }

    public void setInsurancePerDay(float insurancePerDay) {
        this.insurancePerDay = insurancePerDay;
    }

    public float getServiceFee() {
        return serviceFee;
    }

    public void setServiceFee(float serviceFee) {
        this.serviceFee = serviceFee;
    }

    public String getDiscount() {
        return discount;
    }

    public void setDiscount(String discount) {
        this.discount = discount;
    }

}
