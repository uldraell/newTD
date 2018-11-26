import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Stein here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Stein extends Angriff
{
    private static int projSpeed = 2;
    private static int damage = 90;
    
    public Stein(Enemy target){
        super(target);
        setImage("stein.png");
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
