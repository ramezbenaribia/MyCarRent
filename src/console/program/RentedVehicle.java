package console.program;

import java.text.*;
import java.util.*;
import java.util.concurrent.TimeUnit;

public class RentedVehicle extends Vehicle {
    public static final String delimiter = "/";

    String pickUpDate;
    String returnDate;
    long rentDays;
    float rental;
    float discountedPrice;
    float insurance;
    float total;
    String clientName;
    String clientSurname;
    String clientEmail;
    String clientPassengersChoice;

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

        String[] returnDateSplited = returnDate.split(delimiter);
        int returnDay = Integer.valueOf(returnDateSplited[0]);
        int returnMonth = Integer.valueOf(returnDateSplited[1]);
        int returnYear = Integer.valueOf(returnDateSplited[2]);

        this.pickUpDate = pickUpDate;
        this.returnDate = returnDate;
        this.rentDays = this.calculateRentDays(pickUpDate, returnDate);
        this.rental = this.getRentalPerDay() * this.rentDays;

        if (this.getDiscount().equals("N/A")) {
            this.discountedPrice = this.rental;
        } else if (this.rentDays > 7) {
            int discount = Integer.valueOf(this.getDiscount());
            this.discountedPrice = this.getRentalPerDay() * (100 - discount) / 100 * this.rentDays;
        } else {
            this.discountedPrice = this.rental;
        }
        this.insurance = this.getInsurancePerDay() * this.rentDays;
        this.total = this.discountedPrice + this.insurance + this.getServiceFee();

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
}
