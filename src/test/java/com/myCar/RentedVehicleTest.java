package com.myCar;

import com.myCar.RentedVehicle;
import com.myCar.Vehicle;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public abstract class RentedVehicleTest {

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
                10 
                
                );
        rentedVehicle = new RentedVehicle(vehicle, "12/12/2022", "15/12/2022");
    }

    @After
    public void tearDown() {
        vehicle = null;
        rentedVehicle = null;
    }
    
          @Test
        ublic void test_calculateDiscountedPrice  () {
    	rentedVehicle.calculateDiscountedPrice();
		assertEquals(280.0, vehicle.getDiscountedPrice(), 0.0);
	}

}
