package com.myCar;

import java.util.regex.*;

public class Validators {
    public static final String delimiter = "/";

    public static boolean validateDate(String date) {

        String[] dateSplited = date.split(delimiter);
        int day = 0;
        int month = 0;
        int year = 0;
        try {
            day = Integer.valueOf(dateSplited[0]);
            month = Integer.valueOf(dateSplited[1]);
            year = Integer.valueOf(dateSplited[2]);
        } catch (NumberFormatException e) {
            System.err.println("Please follow this format of date  (dd/mm/yyyy) ");
            return false;

        }

        if (!(day > 0) || !(day < 32)) {
            System.out.println("Please provide a valid day  ");
            return false;
        }
        if (!(month > 0) || !(month < 13)) {
            System.out.println("Please provide a valid month  ");
            return false;
        }
        if (!(year > 2021)) {
            System.out.println("Please provide a valid year  ");
            return false;
        }

        return true;

    }

    public static boolean validateReturnDate(String returnDate, String pickUpDate) {

        String[] returnDateSplited = returnDate.split(delimiter);
        int returnDay = Integer.valueOf(returnDateSplited[0]);
        int returnMonth = Integer.valueOf(returnDateSplited[1]);
        int returnYear = Integer.valueOf(returnDateSplited[2]);

        String[] pickUpDateSplited = pickUpDate.split(delimiter);
        int pickUpDay = Integer.valueOf(pickUpDateSplited[0]);
        int pickUpMonth = Integer.valueOf(pickUpDateSplited[1]);
        int pickUpYear = Integer.valueOf(pickUpDateSplited[2]);

        if (returnYear > pickUpYear) {
            return true;
        } else if (pickUpYear > returnYear) {
            System.out.println("Please provide a valid day! The return day must be after the pick up day  ");
            return false;
        } else if (returnMonth > pickUpMonth) {
            return true;
        } else if (pickUpMonth > returnMonth) {
            System.out.println("Please provide a valid day! The return day must be after the pick up day  ");
            return false;
        }

        else if (pickUpDay > returnDay) {
            System.out.println("Please provide a valid day! The return day must be after the pick up day  ");
            return false;
        }

        return true;

    }

    public static boolean validateName(String name) {
        boolean valid = Pattern.matches(".*", name);
        return valid;
    }

    public static boolean validateEmail(String email) {
        boolean valid = Pattern.matches(".*@.*", email);
        if (!valid) {
            System.out.println("Please provide a valid email like this (yourname@rmit.edu.au) ");
        }
        return valid;
    }

    public static boolean validateNumber(String number) {

        boolean valid = Pattern.matches("[1-9][0-9]*", number);
        if (!valid) {
            System.out.println("Please provide a valid number ");
        }
        return valid;
    }

}
