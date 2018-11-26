import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

import java.math.*;
/**
 * Write a description of class Enemy here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 * 
 * Ist der Gegner, den man bekämpfen muss.
 * 
 */
public abstract class Enemy extends BetterActor
{
    /**
     * Weg den die Gegner folgen.
     */ 
    
    
    // Path to follow
     protected Routenplaner rtplaner;
     //private int hp = 100;

    // Constructor that takes a path to follow
    /**
     * Konstruktor der Werte für einen Weg entgegen nimmt, den die Gegner folgen.
     */
    
    public Enemy(Route route) {
        rtplaner = new Routenplaner(route);
    }
    
    /**
     * ....Konstruktor der einen Weg iterator bekommt zum weitermachen
     */
    // Constructor that takes a path iterator to continue
    public Enemy(Routenplaner rtrtplaner) {
        rtplaner = rtrtplaner;
    }

    // Act method
    /**
     * Die Gegner bekommen den nächsten Punkt übergeben.
     * Wenn es keinen 
     * 
     * 
     * 
     */
    public void act()
    {
        Wegpunkt next = rtplaner.next(); // Get the next point
        if(next == null) {
            ((TDWorld) getWorld()).decreaseLives(1); // delete yourself and decrease lives
            getWorld().removeObject(this);
        } else {
            moveTo(next); // Move to the point
        }
        
        
        try{
        this.switchImage(rtplaner.nechste()); // Methode zu "animieren" der Gegner
        } catch(IllegalStateException e) {
            //System.out.println("Enemy try except ausgelöst");// Wenn der Gegner schon tot is wird es hier abgefangen - weiß nicht ob hier noch was hin sollte 
            boolean dead = true;
        }         
    }

    // Called when this Bloon is hit with a dart
    public void pop() {
        for(int i=0; i<numInnerBloons(); i++) { // Spawn a new RedBloon for every "innerBloon"
            Routenplaner subrtplaner = rtplaner.clone(); // Clone the iterator to follow
            for(int j=0; j<i*10; j++) // Set them all slightly apart by advancing some more than others
                subrtplaner.next();
            getWorld().addObject(new Bandit(subrtplaner), getX(), getY()); // Add the new Bloons
        };
        getWorld().removeObject(this); // Remove yourself
    }
    
    public void attack(int dmg){
        if((this.getHP() - dmg) <= 0){
            ((TDWorld) getWorld()).addMoney(this.getBounty()); // Increment the money counter
            getWorld().removeObject(this);
        } else {
            this.setHP(this.getHP() - dmg);
        }
    }
    
    public abstract void switchImage(Wegpunkt ziel);

    // Get the number of bloons to release when popped
    public abstract int numInnerBloons();
    
    public abstract int getHP();
    
    public abstract void setHP(int newHP);
    
    public abstract int getBounty();
}
