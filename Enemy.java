import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

import java.math.*;
/**
 * Oberklasse für alle Gegner.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public abstract class Enemy extends BetterActor
{
    /**
     * Weg den die Gegner folgen.
     */ 
     protected Routenplaner rtplaner;
    

    /**
     * Konstruktor der den Weg entgegennimmt, dem die Gegner folgen.
     */
    public Enemy(Route route) {
        rtplaner = new Routenplaner(route);
    }

    /**
     * 
     * 
     */
    public Enemy(Routenplaner rtrtplaner) {
        rtplaner = rtrtplaner;
    }
    
    /**
     * Act-Methode für alle Gegner.
     * Sorgt dafür das sich alle Gegner bewegen und sie animiert werden.
     */
    public void act()
    {
        Wegpunkt next = rtplaner.next();
        if(next == null) {
            ((TDWorld) getWorld()).decreaseLives(1);
            getWorld().removeObject(this);
            
        } else {
            moveTo(next);
        }
        
        
        try{
        this.switchImage(rtplaner.nechste());
        } catch(IllegalStateException e) {
            boolean dead = true;
        }         
    }

    /**
     * Prüft wenn ein Gegner angegriffen wird ob er stirbt, wenn "Ja" wird Geld hinzugefügt.
     * Bei "Nein" wird das Leben des Gegners reduziert.
     */
    public void attack(int dmg){
        if((this.getHP() - dmg) <= 0){
            ((TDWorld) getWorld()).addMoney(this.getBounty());
            getWorld().removeObject(this);
            //if(){Greenfoot.playSound("../sounds/dieBandit.wav");}
        } else {
            this.setHP(this.getHP() - dmg);
        }
    }
    
    /**
     * Animiert den Gegner.
     */
    public abstract void switchImage(Wegpunkt ziel);


    public abstract int getHP();
    
    public abstract void setHP(int newHP);
    
    /**
     * Gibt den momentanen Wert des Gegners zurück.
     */
    public abstract int getBounty();
}
