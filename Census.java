package edu.cscc;

import java.io.*;
import java.util.Scanner;

/**
 * @author Md Basher
 *         Date: 10/20/2019
 *         ProjectName: CSCI-2467 Lab 9 – Java File I/O...
 *         SourceNote: The Census class contains a loadCensusData() method you will complete
 *         ...that will read and process the census data file.
 *         The filename of the census data file is passed in as a parameter.
 *         Make sure that you skip the line of the file that only contains column headings.
 *         Read the first one hundred surnames in the file.
 *         Read each line containing a surname as a single String.
 *         Use the String method to split each String into a array of Strings split at the comma delimiter.
 *         Note: you can ignore the cumulative proportion field.
 *         Use the Integer.parseInt() and Double.parseDouble() methods to convert Strings to int and double respectively.
 *         Be sure and catch FileNotFoundException and NumberFormatException.
 *         Output an appropriate error message
 *         ...and have the method return a null.
 *         Once the method has processed the file, it will return an array of 100 Surname objects.
 */

public class Census {
    public static Surname[] loadCensusData(String fname) {

        int line = 0; // Keep track of lines of file we've read
        Surname[] namelist = new Surname[100]; // surname object...

        // Add code to read file and populate array of Surname objects
        /**
         * Fille class which creates the File Object with the given file path...
         */

        File file = new File("Surnames_2010Census.csv");

        Scanner input = null;
        //todo- a lot work to do here....
        try {
            input = new Scanner(file);
            //input.next();
            input.nextLine(); // To skip the first line of data...
            while (input.hasNext() && line < 100) {
                String str = input.nextLine();// data getting as a whole line...


                /**
                 * Data are split by comma, and store into a Srting Array i.e. values
                 */
                String[] values = str.split(",");
                String name = values[0];

/**
 *  use the Integer.parseInt() method...
 *  use the Double.parseDouble() method...
 */

                int rank = Integer.parseInt(values[1]);
                int count = Integer.parseInt(values[2]);
                double prop100K = Double.parseDouble(values[3]);
                //double cum_prop100k = Double.parseDouble(values[4]);
/**
 * Surname [] object reads the first 100 lines excluding the first line  i.e. title...
 */
                namelist[line] = new Surname(name, rank, count, prop100K);
                line++;

            }
        } catch (FileNotFoundException e) { // Catches the FileNotFoundException here...
            System.out.println("Cannot find the file!");

        } catch (NumberFormatException e) { // Cathes the NumberFormateException here...
            System.out.println("Enter the correct format: ");
        } finally {
            if (input != null) input.close();
        }
        return namelist; // It returns the expected values...
    }
}


