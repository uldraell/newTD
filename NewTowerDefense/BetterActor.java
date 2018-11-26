import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

import java.lang.*;
/**
 * Write a description of class BetterActor here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class BetterActor extends Actor
{
    // Set the actor's X coordinate
    public void setX(int x) {
        int rot = getRotation(); // Get initial rotation
        int deltaX = x- getX();  // Find distance from target
        setRotation(0);          // Turn towards target
        move(deltaX);            // Move correct distance
        setRotation(rot);        // Reset rotation
    }

    // Set the actor's Y coordinate
    public void setY(int y) {
        int rot = getRotation(); // Get initial rotation
        int deltaY = y - getY(); // Find distance from target
        setRotation(90);         // Turn towards target
        move(deltaY);            // Move correct distance
        setRotation(rot);        // Reset rotation
    }

    // Set the actor's X and Y coordinates to that of a Point
    public void moveTo(Wegpunkt wegpunkt) {
        setX(wegpunkt.getX()); // Set X coordinate
        setY(wegpunkt.getY()); // Set Y coordinate
    }
}
