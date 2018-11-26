import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Angriff here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public abstract class Angriff extends BetterActor
{
    protected Enemy target; // The enemy that the projectile/beam is following
    
    
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
