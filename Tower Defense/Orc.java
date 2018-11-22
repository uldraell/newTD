import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Orc here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Orc extends Enemy
{
    // Simple constructor
    public Orc(Route route)
    {
        super(route); // Call super
        setImage("./images/orc.png"); // Set the correct image
    }

    // Get the number of bloons to create on pop
    public int numInnerBloons() {
        return 2;
    }   
}
