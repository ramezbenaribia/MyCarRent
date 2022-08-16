package com.myCar;

import java.text.*;
import java.util.*;
import java.util.concurrent.TimeUnit;

public class RentedVehicle extends Vehicle {
    public static final String delimiter = "/";

    private String pickUpDate;
    private String returnDate;
    private long rentDays;
    private float rental;
    private float discountedPrice;
    private float insurance;
    private float total;
    private String clientName;
    private String clientSurname;
    private String clientEmail;
    private String clientPassengersChoice;

    /*
     * This constructor of RentedVehicle must be given the vehicle to rent with the
     * pickup date and return date
     * the other attributes (like
     * clientName,clientSurname,clientEmail,clientPassengersChoice)
     * can be set after
     */
    public RentedVehicle(Vehicle vehicle, String pickUpDate, String returnDate) {
        super(
                vehicle.getVehicleID(),
                vehicle.getBrand(),
                vehicle.getModel(),
                vehicle.getType(),
                vehicle.getManufactureYear(),
                vehicle.getSeatsNumber(),
                vehicle.getColor(),
                vehicle.getRentalPerDay(),
                vehicle.getInsurancePerDay(),
                vehicle.getServiceFee(),
                vehicle.getDiscount());

        this.pickUpDate = pickUpDate.replace("/", "-");
        this.returnDate = returnDate.replace("/", "-");
        this.rentDays = this.calculateRentDays(pickUpDate, returnDate);
        this.rental = this.calculateRental();

        this.discountedPrice = this.calculateDiscountedPrice();

        this.insurance = this.calculateInsurance();
        this.total = this.calculateTotal();

    }

    /*
     * This function is responsable for calculating the rent days of the car
     */
    public long calculateRentDays(String pickUpDate, String returnDate) {
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        Date firstDate;
        Date secondDate;
        long rentDays = 0;
        try {
            firstDate = sdf.parse(pickUpDate);

            secondDate = sdf.parse(returnDate);
            long diffInMillies = Math.abs(secondDate.getTime() - firstDate.getTime());
            rentDays = TimeUnit.DAYS.convert(diffInMillies, TimeUnit.MILLISECONDS);

        } catch (ParseException e) {
            e.printStackTrace();
        }

        return rentDays + 1;
    }

    /*
     * This function is responsable for calculating discounted price of the car
     */
    public float calculateDiscountedPrice() {

        float discountedPrice = 0;
        if (this.getDiscount().equals("N/A")) {
            discountedPrice = this.rental;
        } else if (this.rentDays > 7) {
            int discount = Integer.valueOf(this.getDiscount());
            discountedPrice = this.getRentalPerDay() * (100 - discount) / 100 * this.rentDays;
        } else {
            discountedPrice = this.rental;
        }

        return discountedPrice;
    }

    /*
     * This function is responsable for calculating total rental days of the car
     */
    public float calculateRental() {
        return this.getRentalPerDay() * this.rentDays;
    }

    /*
     * This function is responsable for calculating total insurance days of the car
     */
    public float calculateInsurance() {
        return this.getInsurancePerDay() * this.rentDays;
    }

    /*
     * This function is responsable for calculating total price for renting the car
     */
    public float calculateTotal() {
        return this.discountedPrice + this.insurance + this.getServiceFee();
    }

    public String getPickUpDate() {
        return pickUpDate;
    }

    public void setPickUpDate(String pickUpDate) {
        this.pickUpDate = pickUpDate;
    }

    public String getReturnDate() {
        return this.returnDate;
    }

    public void setReturnDate(String returnDate) {
        this.returnDate = returnDate;
    }

    public long getRentDays() {
        return this.rentDays;
    }

    public void setRentDays(long rentDays) {
        this.rentDays = rentDays;
    }

    public float getRental() {
        return rental;
    }

    public void setRental(float rental) {
        this.rental = rental;
    }

    public float getDiscountedPrice() {
        return discountedPrice;
    }

    public void setDiscountedPrice(float discountedPrice) {
        this.discountedPrice = discountedPrice;
    }

    public float getInsurance() {
        return insurance;
    }

    public void setInsurance(float insurance) {
        this.insurance = insurance;
    }

    public float getTotal() {
        return total;
    }

    public void setTotal(float total) {
        this.total = total;
    }

    public String getClientName() {
        return clientName;
    }

    public void setClientName(String clientName) {
        this.clientName = clientName;
    }

    public String getClientSurname() {
        return clientSurname;
    }

    public void setClientSurname(String clientSurname) {
        this.clientSurname = clientSurname;
    }

    public String getClientEmail() {
        return clientEmail;
    }

    public void setClientEmail(String clientEmail) {
        this.clientEmail = clientEmail;
    }

    public String getClientPassengersChoice() {
        return clientPassengersChoice;
    }

    public void setClientPassengersChoice(String clientPassengersChoice) {
        this.clientPassengersChoice = clientPassengersChoice;
    }

}
