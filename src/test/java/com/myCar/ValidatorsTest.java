package com.myCar;

import com.myCar.Validators;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class ValidatorsTest {

    /*
     * Unit Test for the function "validateDate" which is responsable for
     * validating the the input day
     */
    @Test
    public void test_validateDate_incorrectDate() {
        String date = "32/12/2022";
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
     * Unit Test for the function "validateReturnDate" which is responsable for
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

    @Test
    public void test_validateNumber_correctNumber() {
        String number = "20";
        boolean valid = Validators.validateNumber(number);
        assertEquals(true, valid);
    }

    @Test
    public void test_validateNumber_incorrectNumber() {
        String number = "02";
        boolean valid = Validators.validateNumber(number);
        assertEquals(false, valid);
    }

}
