import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Troll here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Troll extends Enemy
{
    // A simple constuctor that takes a path to follow
    public Troll(Route route)
    {
        super(route); // Pass the path on to super
        setImage("troll.png"); // Set the image to a green bloon
    }

    // Get the number of bloons to spawn when popping
    public int numInnerBloons() {
        return 0;
    }    
}
