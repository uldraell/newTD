import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Alle Angriffe der Tower (Jeder Schuss, usw., wird als einzelnes Objekt dargestellt
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public abstract class Angriff extends BetterActor
{
    protected Enemy target; 
    
    /**
     * Legt den gegner als Ziel fest
    */
    public Angriff(Enemy target){
        this.target = target;        
    }
    
    public abstract void angreifen();
}
