import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot und MouseInfo)

/**
 * Ergänzen Sie hier eine Beschreibung für die Klasse Turretbutton2.
 * 
 * @author (Ihr Name) 
 * @version (eine Versionsnummer oder ein Datum)
 */
public class TurretButton2 extends BetterActor
{
    /**
     * Act - do whatever the TurretButton wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    
    public TurretButton2(){
        setImage("../images/buttons/magierbutton.png");
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
            Actor choice = getOneIntersectingObject(TurretButton2.class);
            ((TDWorld) getWorld()).placeTower2(Greenfoot.getMouseInfo().getX(), Greenfoot.getMouseInfo().getY());            
            ((TDWorld) getWorld()).placeMagier(Greenfoot.getMouseInfo().getX(), Greenfoot.getMouseInfo().getY());
            if (choice != null) setLocation(choice.getX(), choice.getY());
            // optional else block
            else setLocation(723,46);
        }
        
    }    
}