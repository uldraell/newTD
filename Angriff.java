import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Angriff here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 * 
 * Objekte die das Ziel verfolgen und angreifen.
 * 
 * 
 * 
 */
public abstract class Angriff extends BetterActor
{
    /**
     * Der Gegner der von dem Objekt verfolgt wird.
     * 
     */
    
    protected Enemy target; // The enemy that the projectile/beam is following
    
    /**
     * Legt den Gegner als Ziel fest.
     * 
     */
    
    public Angriff(Enemy target){
        this.target = target;        
    }
    
    /**
    public void act() 
    {
        angreifen();
    }    
    */
    
    public abstract void angreifen();
}
