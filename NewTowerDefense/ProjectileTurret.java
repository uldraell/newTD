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
    private int projSpeed = 3;
    
    // Constructor der ein Ziel bekommt
    public ProjectileTurret(Enemy target)
    {
        super(target); // Ziel festlegen
        setImage("stein.png"); // Bild festlegen
    }

    public void shoot(){
        try {
            turnTowards(target.getX(), target.getY()); // Turn towards the target
            move(projSpeed); // Move forward

            if(intersects(target)) { // If it hit the enemy
                target.attack(damage); // damage the enemy
                getWorld().removeObject(this); // Remove the dart
            }
        } catch(IllegalStateException e) {
            getWorld().removeObject(this); // If the bloon doesn't exist anymore, delete yourself
        }
    }
    
}
