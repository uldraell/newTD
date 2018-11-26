import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class TurretButton here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class TurretButton extends BetterActor
{
    /**
     * Act - do whatever the TurretButton wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    
    public TurretButton(){
        setImage("../images/buttons/turret1.png");
    }
    
    public void act() 
    {
            // mouse dragging
        if (Greenfoot.mouseDragged(this))
        {
            MouseInfo mouse = Greenfoot.getMouseInfo();
            setLocation(mouse.getX(), mouse.getY());
        }
        // locking onto selection (or not)
        if (Greenfoot.mouseDragEnded(this))
        {
            Actor choice = getOneIntersectingObject(TurretButton.class);
            ((TDWorld) getWorld()).placeTurret(Greenfoot.getMouseInfo().getX(), Greenfoot.getMouseInfo().getY());
            if (choice != null) setLocation(choice.getX(), choice.getY());
            // optional else block
            else setLocation(900,850);
        }
        
    }    
}
