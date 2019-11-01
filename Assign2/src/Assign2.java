/*
 * Assign2.java
 * Concordia CSC420 - Data Structures
 * Assignment 2 - Band Coordinator - Main program
 * App to search bands by set length.
 * By Dean Peterson <petersod8@csp.edu>
 * Instructor James Tucker
 * October 29, 2019
 */

import java.util.Scanner;

public class Assign2 {

    private static final String BANDFILE = "bandinfo.txt";
    private static Scanner in = new Scanner(System.in);
    private static BandList bands;
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        System.out.println("Submitted by: Dean Peterson - petersod8@csp.edu");
        bands = new BandList(BANDFILE);
        
        // Debug
        System.out.println();        
        System.out.println(bands);
        bands.sortByName();
        System.out.println();
        System.out.println(bands);
        bands.sortBySetTime();
        System.out.println();
        System.out.println(bands);
        
        while (true) {
            System.out.println("\nSearch by Band Name (1) or Set List (2): ");
            int menuChoice = in.nextInt();
            in.nextLine(); // Clear remainer of input line from buffer.
            switch (menuChoice) {
                case 1: searchBandName();
                        break;
                case 2: searchSetTime();
                        break;
                default:System.out.println("\nGoodbye!");
                        return;
            }
        }
    }
    
    private static void searchBandName() {
        System.out.println("Enter Band Name you are looking for:");
        String name = in.nextLine();
        bands.sortByName();
        System.out.println(bands.searchByName(name));
    }
    
    private static void searchSetTime() {
        System.out.println("Enter the Set Time you are looking for:");
        float time = in.nextFloat();
        in.nextLine(); // Clear remainer of input line from buffer.        
    }
}
