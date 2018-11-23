import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class ProjectileTurret here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class ProjectileTurret extends Turret
{
    /**
     * Act - do whatever the ProjectileTurret wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    
    // Constructor der ein Ziel bekommt
    public ProjectileTurret(Enemy target)
    {
        super(target); // Ziel festlegen
        setImage("stein.png"); // Bild festlegen
        
        
        
    }

    
    
}
