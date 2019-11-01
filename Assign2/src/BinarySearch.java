/*
 * BinarySearch.java
 * Concordia CSC420 - Data Structures
 * Assignment 2 - Band Coordinator - Binary search utility class
 * Binary search for a list of bands.
 * By Dean Peterson <petersod8@csp.edu>
 * Instructor James Tucker
 * November 1, 2019
 */

import java.util.List;

public class BinarySearch {
    
    // Returns Band whose name matches case-insensitively, or null if no match.
    public static Band search(List<Band> list, String name) {
        return search(list, name, 0, list.size());
    }

    // Recursive helper searching elements from (inclusive) to to (exclusive).
    public static Band search(List<Band> list, String name, int from, int to) {
        if (from == to) {
            return null; // Not found, base case
        }
        
        Band result;
        int mid = (from + to) / 2;
        int comparison = name.compareToIgnoreCase(list.get(mid).getBandName());
        if (comparison == 0) {
            result = list.get(mid); // Found.
        }
        else if (comparison < 0) {
            result = search(list, name, from, mid); // Look lower.
        }
        else { // comparison > 0
            result = search(list, name, mid + 1, to); // Look higher.
        }
        return result;
    }
}
