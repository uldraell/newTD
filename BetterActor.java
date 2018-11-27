import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

import java.lang.*;
/**
 * Diese Klasse dient zur besseren Berechnung der Bewegungen der Actoren
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class BetterActor extends Actor
{
    /**
     * berechnent die Distanz zum Ziel
     * bewegt den Actor in Richtung des Ziels
     */
    public void setX(int x) {
        int rot = getRotation(); 
        int deltaX = x- getX();  
        setRotation(0);          
        move(deltaX);            
        setRotation(rot);        
    }

    /**
     * berechnent die Distanz zum Ziel
     * bewegt den Actor in Richtung des Ziels
     */
    public void setY(int y) {
        int rot = getRotation(); 
        int deltaY = y - getY(); 
        setRotation(90);         
        move(deltaY);            
        setRotation(rot);        
    }

    
    /**
     * Ein Actor bekommt die x und y Koordinaten als Punkt übergeben
     * und wird dann an diese Koordinaten platziert
     */
    public void moveTo(Wegpunkt wegpunkt) {
        setX(wegpunkt.getX()); 
        setY(wegpunkt.getY()); 
    }
}
