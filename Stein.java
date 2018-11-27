import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Objekt welches den Gegner verfolgt, angreift und tötet.
 *
 * Kann später noch erweitert werden!
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
            turnTowards(target.getX(), target.getY());
            move(projSpeed);

            if(intersects(target)) {
                target.attack(damage);
                getWorld().removeObject(this);
            }
        } catch(IllegalStateException e) {
            getWorld().removeObject(this);
        }
    }   
}
