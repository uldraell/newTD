import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.List;
import java.util.ListIterator;
/**
 * Write a description of class Magier here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Magier extends Turret
{
    private int delay; // The time between throws
    private int range; // How far the monkey can throw
    private int time;  // The counter that ticks toward the `delay`

    private boolean paid; // If the monkey has been paid for
    private int price; // How expensive the monkey is
    
     public Magier(){
        delay = DEFAULT_DELAY; // 100 ticks of delay
        range = DEFAULT_RANGE; // Range of 150
        price = DEFAULT_PRICE; // Costs $100
        setImage("../images/turrets/mage_high2.png"); // Set the image to a simple monkey
        paid = false; // This unit has not yet been paid for
    }
    
    public void act() 
    {
        
        if(!paid) { // If this unit hasn't been paid for yet
            if(price <= ((TDWorld) getWorld()).getMoney()) { // If the player has enough
                ((TDWorld) getWorld()).removeMoney(price); // Subtract the price from money count
                paid = true; // The unit has been paid for
            } else {
                 getWorld().removeObject(this); // Unit can't be paid for, delete it
            }
        }

        if(delay < time) { // If it's time to throw a dart
            List<Actor> possible = getObjectsInRange(range, Actor.class); // Look for possible targets

            ListIterator<Actor> itr = possible.listIterator();
            while (itr.hasNext()) {
                if(!(itr.next() instanceof Enemy)) {
                    itr.remove();
                }
            }
            
            if(possible.size() == 0) // If there is none, give up
                return;

            Enemy target = (Enemy) possible.get(0); // Get the first possible target
            turnTowards(target.getX(), target.getY()); // Turn towards it
            getWorld().addObject(new Magie(target), getX(), getY()); // Spawn a dart targeting it

            time = 0; // Reset timer
        }else {
            time++; // Increment timer
        }
    }    
}
