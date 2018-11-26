import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Turret here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public abstract class Turret extends BetterActor
{
    private static int DART_SPEED = 3;
    protected Enemy target; // The enemy that the projectile/beam is following
      
    protected int projSpeed;
    protected int beamlength;
    protected int damage = 50;

    // Constructor that takes a Bloon to target
    public Turret(Enemy target) {
        this.target = target; // Set the target variable
        setImage("pfeil.png"); // Set the image to a dart
    }

    // Act method to track target
    public void act()
    {
        shoot();
        /**
        try {
            turnTowards(target.getX(), target.getY()); // Turn towards the target
            move(DART_SPEED); // Move forward

            if(intersects(target)) { // If it hit the enemy
                target.attack(damage); // damage the enemy
                getWorld().removeObject(this); // Remove the dart
            }
        } catch(IllegalStateException e) {
            getWorld().removeObject(this); // If the bloon doesn't exist anymore, delete yourself
        }
        */
    }   
    
    public abstract void shoot();
}
