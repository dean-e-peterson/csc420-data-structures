/*
 * Person.java
 * Concordia CSC420 - Data Structures
 * Assignment 1 - Random Name Generator - Person class
 * Holds first and last names.
 * By Dean Peterson <petersod8@csp.edu>
 * Instructor James Tucker
 * October 26, 2019
 */

class Person implements Comparable<Person> {
    
    private String firstName;
    private String lastName;

    public Person(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }
    
    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
    
    @Override
    public String toString() {
        return firstName + " " + lastName;
    }
    
    @Override
    public int compareTo(Person p) {
        // Compares last name, then first name, case-insensitively.
        int result = this.lastName.compareToIgnoreCase(p.lastName);
        if (result == 0) {
            result = this.firstName.compareToIgnoreCase(p.firstName);
        }
        return result;
    }
}

