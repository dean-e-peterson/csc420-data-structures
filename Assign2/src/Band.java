/*
 * Band.java
 * Concordia CSC420 - Data Structures
 * Assignment 2 - Band Coordinator - Band class
 * Represents a band tracked by the application, holding name and set length.
 * By Dean Peterson <petersod8@csp.edu>
 * Instructor James Tucker
 * October 29, 2019
 */

class Band {
    
    private static final char DELIMITER = '|';
    
    private String bandName;
    private float setTime; // Length of band's musical set in minutes.
    
    public Band(String bandName, float setTime) {
        this.bandName = bandName;
        this.setTime = setTime;
    }
    
    public static Band deserialize(String bandString) {
        int delimiterPos = bandString.indexOf(DELIMITER);
        if (delimiterPos == -1) {
            throw new IllegalArgumentException("Band deserialize input has no pipe symbol: " + bandString);
        }
        String bandName = bandString.substring(0, delimiterPos);
        String setTime = bandString.substring(delimiterPos + 1, bandString.length());
        return new Band(bandName, Float.valueOf(setTime));
    }

    public String getBandName() {
        return bandName;
    }
    public float getSetTime() {
        return setTime;
    }
    public void setBandName(String bandName) {
        this.bandName = bandName;
    }
    public void setSetTime(float setTime) {
        this.setTime = setTime;
    }
    
    @Override
    public String toString() {
        return bandName + " has a set time of " + setTime + " minutes";
    }
    
}
