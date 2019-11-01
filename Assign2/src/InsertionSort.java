/*
 * InsertionSort.java
 * Concordia CSC420 - Data Structures
 * Assignment 2 - Band Coordinator - Insertion sort utility class
 * Insertion sort for a list of bands sorting by set time.
 * By Dean Peterson <petersod8@csp.edu>
 * Instructor James Tucker
 * November 1, 2019
 */

import java.util.List;

public class InsertionSort {
    
    public static void sort(List<Band> list) {
        if (list.size() <= 1) {
            return;
        }
        
        // div is the division between sorted and unsorted portions of the list.
        // specifically, it is the index of the first unsorted element.
        for (int div = 1; div < list.size(); div++) {
            Band divBand = list.get(div);
            // i is the index of the sorted portion being tested.
            int i = div - 1;
            // Search right to left through sorted part to find insertion point.
            while (i >= 0 && divBand.getSetTime() < list.get(i).getSetTime()) {
                i--;
            }
            // Adjust for last, extra i--.  ### Fix this.
            i++;
            
            // Move the sorted portion right of insertion point over.
            // j is the index of the sorted portion being moved to the right.
            for (int j = div; j > i; j--) {
                list.set(j, list.get(j - 1));
            }
            // Put first unsorted element in the proper insertion point
            list.set(i, divBand);
        }
    }
    
}
