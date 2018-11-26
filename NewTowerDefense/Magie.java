import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class magie here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Magie extends Angriff
{
    private static int projSpeed = 4;
    private static int damage = 50;
    
    public Magie(Enemy target){
        super(target);
        setImage("../images/angriffe/magie.png");
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
