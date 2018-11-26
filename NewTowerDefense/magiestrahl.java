import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot und MouseInfo)

/**
 * Ergänzen Sie hier eine Beschreibung für die Klasse magiestrahl.
 * 
 * @author (Ihr Name) 
 * @version (eine Versionsnummer oder ein Datum)
 */
public class magiestrahl extends Turret
{
    /**
     * Act - tut, was auch immer magiestrahl tun will. Diese Methode wird aufgerufen, 
     * sobald der 'Act' oder 'Run' Button in der Umgebung angeklickt werden. 
     */
    private int beamlength = 20;
     public magiestrahl(Enemy target)
    {
        super(target); // Ziel festlegen
        setImage("../images/attacks/beam.png"); // Bild festlegen
        
        
        
    }
    
    public void shoot(){
        try {
            turnTowards(target.getX(), target.getY()); // Turn towards the target
            move(beamlength); // Move forward

            if(intersects(target)) { // If it hit the enemy
                target.attack(damage); // damage the enemy
                getWorld().removeObject(this); // Remove the dart
            }
        } catch(IllegalStateException e) {
            getWorld().removeObject(this); // If the bloon doesn't exist anymore, delete yourself
        }
    }

}