/*
 * MergeSort.java
 * Concordia CSC420 - Data Structures
 * Assignment 2 - Band Coordinator - Merge sort utility class
 * Merge sort for a list of bands.
 * By Dean Peterson <petersod8@csp.edu>
 * Instructor James Tucker
 * October 30, 2019
 */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MergeSort {
    private static List<Band> mainList;
    private static List<Band> mergeList;
    
    
    // Driver to run merge sort as a separate program for testing only.
    public static void main(String[] args) {
        List<Comparable> testList = Arrays.asList("pear", "apple", "date", "banana", "grape", "cumquat", "pomagranet");
        System.out.println(testList);
        // Note: Originally this was intended to be generic.  Change List<Band> 
        // back to List<Comparable> everywhere to run this test program.
        // ### sort(testList);
        System.out.println(testList);
    }
    
    public static void sort(List<Band> list) {
        mainList = list;
        // Copy list as an easy way of getting a same-size list pre-allocated.
        mergeList = new ArrayList<Band>(list);
        sort(0, list.size());
    }
    
    // Recursive helper sorting elements from (inclusive) to to (exclusive).
    private static void sort(int from, int to) {
        // ### Check if this handles empty list, and maybe list of length 1.
        // System.out.println("sort from " + from + " to " + to); 
        
        if (from >= to - 1) {
            // Base case
            return;
        }
        else {
            // Recursive case
            
            // Divide.
            int mid = (from + to) / 2;
            sort(from, mid);
            sort(mid, to);
            
            // Merge.
            int left = from;
            int right = mid;
            int dest = from;
            while (dest < to) {
                if (right != to &&
                    (left == mid || mainList.get(left).compareTo(mainList.get(right)) > 0))
                {
                    mergeList.set(dest, mainList.get(right));
                    // System.out.println("Merge from right " + right + " to dest " + dest);
                    right++;
                }
                else {
                    mergeList.set(dest, mainList.get(left));
                    // System.out.println("Merge from left " + left + " to dest " + dest);
                    left++;
                }
                dest++;
            }
            
            // Copy back.
            // System.out.println("Copy back from " + from + " to " + to);
            for (int i = from; i < to; i++) {
                mainList.set(i, mergeList.get(i));
            }
        }
    }
}
