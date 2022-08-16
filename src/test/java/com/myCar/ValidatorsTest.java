package com.myCar;

import com.myCar.Validators;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class ValidatorsTest {

    /*
     * Unit Tests for the function "validateDate" which is responsable for
     * validating the the input day
     */
    @Test
    public void test_validateDate_incorrectDate() {
        String date = "32/12/2022";
        boolean valid = Validators.validateDate(date);
        assertEquals(false, valid);
    }

    @Test
    public void test_validateDate_incorrectMonth() {
        String date = "31/13/2022";
        boolean valid = Validators.validateDate(date);
        assertEquals(false, valid);
    }

    @Test
    public void test_validateDate_incorrectYear() {
        String date = "31/12/2021";
        boolean valid = Validators.validateDate(date);
        assertEquals(false, valid);
    }

    @Test
    public void test_validateDate_correctDate() {
        String date = "12/12/2022";
        boolean valid = Validators.validateDate(date);
        assertEquals(true, valid);
    }

    /*
     * Unit Tests for the function "validateReturnDate" which is responsable for
     * validating the the return date of rented car which must be after the pickup
     * date day
     */
    @Test
    public void test_validateReturnDate_correctDate() {
        String returnDate = "15/12/2022";
        String pickUpDate = "12/12/2022";
        boolean valid = Validators.validateReturnDate(returnDate, pickUpDate);
        assertEquals(true, valid);
    }

    @Test
    public void test_validateReturnDate_incorrectDate() {
        String returnDate = "02/12/2022";
        String pickUpDate = "12/12/2022";
        boolean valid = Validators.validateReturnDate(returnDate, pickUpDate);
        assertEquals(false, valid);
    }

    /*
     * Unit Tests for the function "validateName" which is responsable for
     * validating the name format.It must not be empty
     */
    @Test
    public void test_validateName_incorrectName() {
        String name = "";
        boolean valid = Validators.validateName(name);
        assertEquals(false, valid);
    }

    @Test
    public void test_validateName_correctName() {
        String name = "Estrid";
        boolean valid = Validators.validateName(name);
        assertEquals(true, valid);
    }

    /*
     * Unit Tests for the function "validateEmail" which is responsable for
     * validating the email format
     */
    @Test
    public void test_validateEmail_incorrectEmail() {
        String email = " estrid.hermitedu.au";
        boolean valid = Validators.validateEmail(email);
        assertEquals(false, valid);
    }

    @Test
    public void test_validateEmail_correctEmail() {
        String email = " estrid.he@rmit.edu.au";
        boolean valid = Validators.validateEmail(email);
        assertEquals(true, valid);
    }

    /*
     * Unit Tests for the function "validateNumber" which is responsable for
     * validating the the number format
     */
    @Test
    public void test_validateNumber_correctNumber() {
        String number = "2";
        int numberOfPassangers = 3;
        boolean valid = Validators.validateNumber(number, numberOfPassangers);
        assertEquals(true, valid);
    }

    @Test
    public void test_validateNumber_incorrectNumber() {
        String number = "02";
        int numberOfPassangers = 3;
        boolean valid = Validators.validateNumber(number, numberOfPassangers);
        assertEquals(false, valid);
    }

    @Test
    public void test_validateNumber_incorrectNumberOfPassangers() {
        String number = "5";
        int numberOfPassangers = 3;
        boolean valid = Validators.validateNumber(number, numberOfPassangers);
        assertEquals(false, valid);
    }

}
