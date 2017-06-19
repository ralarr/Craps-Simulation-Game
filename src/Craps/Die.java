package Craps;

/**
 * Die.java
 * A class that represents the essential features and functionality of a
 * single six-sided die.
 * @author      Rafael Larrea
 * @version     1.0
 * 
 * Created on November 27, 2014 5:38 PM.
 * 
 */

public class Die 
{
     // Class instance variables.
    private static int number = 6;     //six sided die
    private int face = 1;        //default face for a die
    
    /**
     * Default constructor
     */
    
    public Die()
    {
        int number = 6;
        int face = 1;
    }
    
    /**
     * Overloaded constructor
     * @param: face--int: the face showing on the die
     */
    
    public Die(int face)
    {
        this.face = face;
    }
    //more constructors to instatiate dice with different number of faces
    
    /**
     * Method to roll a single die and return 1-6 for 6 faced die
     * @return: int--face of the die that was rolled
     */
    public static int roll()
    {
        return (int) Math.floor(number * Math.random() + 1);
    }
    /**
     * Method to return the current face
     * @param: none
     * @return: int -- the face of the die.
     */
    public int getSide()
    {
        return face;
    }
    /**
     * Method to set the face of a die
     * @param: int ==  value to set
     * @return: void
     */
    public void setSide(int face)
    {
        this.face = face;
    }
    /**
     * Override the toString method from the object class
     * @return: string that describes the die
     */
    
    @Override
    public String toString()
    {
        return "The face of the " + number + "-sided die is: " + face;
    }
}
