import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Pfeil here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Pfeil extends Angriff
{
    /**
     * Act - do whatever the Pfeil wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    private static int projSpeed = 4;
    private static int damage = 50;
    
    public Pfeil(Enemy target){
        super(target);
        setImage("pfeil.png");
    }
    public void act() 
    {
        angreifen();
    }    
    
    public  void angreifen(){
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
