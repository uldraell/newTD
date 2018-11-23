import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Tower1 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Tower1 extends Tower
{
    /**
     * Act - do whatever the Tower1 wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public Tower1() 
    {
        // Add your action code here
        super(100, 150, 100);
        setImage("zauberer.png");
        
    }  
    
    public void act()
    {
        @Override
        getWorld().addObject(new Turret(target), getX(), getY());
        
        
        
        
    }
}
