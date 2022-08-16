package com.myCar;

import static org.junit.Assert.*;

import org.junit.Test;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.Arrays;

public class CSVReaderTest {

    @Test
    public void test_readFunction_FileNotFound() {
        String csvFile = "";
        ArrayList<String[]> lines = CSVReader.read(csvFile);
        ArrayList<String[]> expectedArray = new ArrayList<String[]>();
        assertEquals(expectedArray, lines);
    }

    @Test
    public void test_readFunction_validTest() {
        String csvFile = "FleetTest.csv";
        ArrayList<String[]> lines = CSVReader.read(csvFile);

        String[] expectedline = "C001,Toyota,Yaris,Sedan,2012,4,Blue,50,15,10,10".split(",");
        String[] line = lines.get(0);

        boolean valid2 = Arrays.deepEquals(expectedline, line);

        assertEquals(true, valid2);
    }

}
