package com.myCar;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class RentedVehicleTest {

    private Vehicle vehicle;
    private RentedVehicle rentedVehicle;

    @Before
    public void setUp() {
        vehicle = new Vehicle(
                "C003",
                "Toyota",
                "Kluger",
                "SUV",
                2019,
                7,
                "Grey",
                70,
                20,
                20,
                "10"

        );
        rentedVehicle = new RentedVehicle(vehicle, "12/12/2022", "15/12/2022");
    }

    @After
    public void tearDown() {
        vehicle = null;
        rentedVehicle = null;
    }

    /*
     * Unit Test for the function "calculateRentDays" which is responsable for
     * calculating the the days of renting the car
     */
    @Test
    public void test_calculateRentDays() {
        String pickUpDate = "12/12/2022";
        String returnDate = "15/12/2022";
        long rentDays = rentedVehicle.calculateRentDays(pickUpDate, returnDate);
        assertEquals(4, rentDays);
    }

    /*
     * Unit Test for the function "calculateRental" which is responsable for
     * calculating the the rental of the car
     */
    @Test
    public void test_calculateRental() {
        float rental = rentedVehicle.calculateRental();
        assertEquals(280.0, rental, 0.0);
    }

    /*
     * Unit Test for the function "calculateDiscountedPrice" which is responsable
     * for calculating the Discounted Price of the car
     */

    @Test
    public void test_calculateDiscountedPrice() {
        float discountedPrice = rentedVehicle.calculateDiscountedPrice();
        assertEquals(280.0, discountedPrice, 0.0);
    }

    /*
     * Unit Test for the function "calculateInsurance" which is responsable for
     * calculating the insurance of the car
     */

    @Test
    public void test_calculateInsurance() {
        float insurance = rentedVehicle.calculateInsurance();
        assertEquals(80.0, insurance, 0.0);
    }

    /*
     * Unit Test for the function "calculateTotal" which is responsable for
     * calculating the total price for renting the car
     */

    @Test
    public void test_calculateTotal() {
        float total = rentedVehicle.calculateTotal();
        assertEquals(380.0, total, 0.0);
    }

}
