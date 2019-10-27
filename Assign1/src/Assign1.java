/*
 * Assign1.java
 * Concordia CSC420 - Data Structures
 * Assignment 1 - Random Name Generator - Main program
 * Proof of concept to generate fake names for test environments.
 * By Dean Peterson <petersod8@csp.edu>
 * Instructor James Tucker
 * October 26, 2019
 */

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class Assign1 {
    
    private static final String FIRST_NAME_FILE = "FirstNames.txt";
    private static final String LAST_NAME_FILE = "LastNames.txt";
    private static final int SIZE = 20;

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        printHeading();
        
        // Load first and last names from file.
        // Note: A List structure is used because it is indexable,
        // which is convenient for pulling elements at random later.
        List<String> firstNames = loadNameList(FIRST_NAME_FILE);
        List<String> lastNames = loadNameList(LAST_NAME_FILE);
        
        // Debug only, comment out or remove
        //System.out.println(firstNames);
        //System.out.println(lastNames);
        //System.out.println();
        
        // Generate person names as random combinations of first and last name,
        // displaying them as they are generated.
        // Note: List data structure allows duplicate names like real life.
        System.out.println("Generated Names:");
        List<Person> persons = generatePersons(firstNames, lastNames);
        
        // Sort list of persons by first name and display them.
        System.out.println("Sorted by First Name:");
        persons.sort(new PersonFirstNameComparator());
        printCollection(persons);
        
        // Sort list of persons by last name and display them.
        System.out.println("Sorted by Last Name:");
        persons.sort(null);
        printCollection(persons);
        
        // Display names categorized by first name.
        System.out.println("Combine all names by First Name:");
        System.out.println();
    }
    
    // Print heading identifying author for ease of grading.
    private static void printHeading() {
        System.out.println("Submitted by: Dean Peterson - petersod8@csp.edu\n");
    }
    
    // Print elements of a collection each on their own line, preceded by tabs.
    private static void printCollection(Collection collection) {
        for (Object o: collection) {
            System.out.println("\t" + o);
        }
        System.out.println();
    }
    
    // Load a list of first or last names from a text file listing one per line.
    private static List<String> loadNameList(String filename) {
        List<String> result = new ArrayList<>();
        try (Scanner s = new Scanner(new File(filename))) {
            while (s.hasNext()) {
                result.add(s.next());
            }
        } catch (FileNotFoundException e) {
            System.err.println(e);
        }
        return result;
    }
    
    // Generates random persons from lists of first & last names, & prints them.
    private static List<Person> generatePersons(List<String> firstNames,
                                                List<String> lastNames)
    {
        List<Person> results = new ArrayList<>(SIZE);
        Random random = new Random();
        for (int i = 1; i <= SIZE; i++) {
            // Get random ints between 0 and the name list size minus 1.
            int firstNameIndex = random.nextInt(firstNames.size());
            int lastNameIndex = random.nextInt(lastNames.size());
            // Note: Collections.shuffle() is not used because we want
            // possible duplicates, which a permutation would not give us.
            Person person = new Person(firstNames.get(firstNameIndex), 
                                       lastNames.get(lastNameIndex));
            results.add(person);
            System.out.println("\t" + i + ". " + person);
        }
        System.out.println();
        return results;
    }
}

