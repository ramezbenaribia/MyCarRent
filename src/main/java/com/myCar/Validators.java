package com.myCar;

import java.util.*;
import java.util.regex.*;

public class Validators {
    public static final String delimiter = "/";
    public static final Date today = new Date();
    public static final Calendar calendar = new GregorianCalendar();

    /*
     * This function is responsable for
     * validating the the input day
     */
    public static boolean validateDate(String date) {

        String[] dateSplited = date.split(delimiter);
        int day = 0;
        int month = 0;
        int year = 0;

        calendar.setTime(today);
        int currentYear = calendar.get(Calendar.YEAR);
        int currentMonth = calendar.get(Calendar.MONTH) + 1;
        int currentDay = calendar.get(Calendar.DAY_OF_MONTH);

        try {
            day = Integer.valueOf(dateSplited[0]);
            month = Integer.valueOf(dateSplited[1]);
            year = Integer.valueOf(dateSplited[2]);
        } catch (NumberFormatException e) {
            System.err.println("Please follow this format of date  (dd/mm/yyyy) ");
            return false;

        } catch (ArrayIndexOutOfBoundsException e) {
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
        if (currentYear > year) {
            System.out.println("Please provide a valid year !  it must be in the future and not in the past ");
            return false;
        } else if (currentMonth > month && currentYear == year) {
            System.out.println("Please provide a valid month !  it must be in the future and not in the past ");
            return false;
        } else if (currentDay > day && currentYear == year && currentMonth == month) {
            System.out.println("Please provide a valid day !  it must be in the future and not in the past ");
            return false;
        }

        return true;

    }

    /*
     * This function is responsable for
     * validating the the return date of rented car which must be after the pickup
     * date day
     */
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

    /*
     * This function "validateName" is responsable for
     * validating the name format.It must not be empty
     */
    public static boolean validateName(String name) {
        boolean valid = Pattern.matches(".+", name);
        if (!valid) {
            System.out.println("Please provide a valid name. It must not be empty");
        }
        return valid;
    }

    /*
     * This function "validateEmail" is responsable for
     * validating the the email format
     */
    public static boolean validateEmail(String email) {
        boolean valid = Pattern.matches(".*@.*", email);
        if (!valid) {
            System.out.println("Please provide a valid email like this (yourname@rmit.edu.au) ");
        }
        return valid;
    }

    /*
     * This function "validateNumber" is responsable for
     * validating the the number format
     */

    public static boolean validateNumber(String number, int numberOfPassangers) {

        boolean valid = Pattern.matches("[1-9]", number);
        if (!valid) {
            System.out.println("Please provide a valid number ");
        }
        if (Integer.valueOf(number) > numberOfPassangers) {
            System.out.println(
                    "Please provide a valid  number of passengers.the number of passengers provided should be smaller than the number of seats  ");

            valid = false;
        }

        return valid;
    }

}
