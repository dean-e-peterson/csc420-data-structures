/*
 * PersonFirstNameComparator.java
 * Concordia CSC420 - Data Structures
 * Assignment 1 - Random Name Generator - Person comparator
 * Compares persons by first name first name, then last, unlike natural order.
 * By Dean Peterson <petersod8@csp.edu>
 * Instructor James Tucker
 * October 26, 2019
 */

import java.util.Comparator;

class PersonFirstNameComparator implements Comparator<Person> {

    @Override
    public int compare(Person p1, Person p2) {
        // Compares first name, then last name, case-insensitively.
        int result = p1.getFirstName().compareToIgnoreCase(p2.getFirstName());
        if (result == 0) {
            result = p1.getLastName().compareToIgnoreCase(p2.getLastName());
        }
        return result;        
    }
    
}

