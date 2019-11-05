package edu.cscc;

/**
 * @author Md Basher
 *         Date: 10/20/2019
 *         ProjectName: CSCI-2467 Lab 9 – Java File I/O...
 */

public class Main {
    private final static String CENSUSDATAFNAME = "Surnames_2010Census.csv"; // To use the file path as a constant...

    public static void main(String[] args) {

        Surname[] namelist = Census.loadCensusData(CENSUSDATAFNAME);

        if (namelist != null) { // To make sure namelist gets the real values...
            System.out.println("Rank\tName");
            for (Surname name : namelist) { // Using for...loop to produce the expected results...
                System.out.println(name.getRank() + "\t\t" + name.getName());
            }
        }
    }
}