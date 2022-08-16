
package com.myCar;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class CSVReader {
    public static final String delimiter = ",";

    public static ArrayList<String[]> read(String csvFile) {

        Scanner sc;
        ArrayList<String[]> lines = new ArrayList<String[]>();

        try {
            sc = new Scanner(new File(csvFile));
            String[] record;
            // we are going to ignore the first line because it containes the header of our
            // csv
            sc.nextLine();

            while (sc.hasNextLine()) {
                record = sc.nextLine().split(delimiter);
                lines.add(record);
            }
            sc.close();

        } catch (NullPointerException e) {
            System.err.println("File is null.");
        } catch (FileNotFoundException e) {
            System.err.println("File not found.");
        }
        return lines;
    }
}