/*
 * BandList.java
 * Concordia CSC420 - Data Structures
 * Assignment 2 - Band Coordinator - Band list class
 * Represents a list of bands tracked by the application,
 * with methods for loading, sorting, and searching the list.
 * By Dean Peterson <petersod8@csp.edu>
 * Instructor James Tucker
 * October 30, 2019
 */

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class BandList {
    
    List<Band> innerList;
    
    private BandList() {
        innerList = new ArrayList<Band>();
    }
    
    // Constructor that loads the list of bands from a file.
    public BandList(String filename) {
        this();
        
        try (Scanner s = new Scanner(new File(filename))) {
            while (s.hasNext()) {
                innerList.add(Band.deserialize(s.nextLine()));
            }
        } catch (FileNotFoundException e) {
            System.err.println(e);
        }
    }
    
    // For debugging use.
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (Band b: innerList) {
            sb.append(b + "\n");
        }
        return sb.toString();
    }
}
