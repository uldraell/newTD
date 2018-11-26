import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.List;
import java.util.ListIterator;


/**
 * Write a description of class Tower here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Tower extends BetterActor
{
    /**
     * Act - do whatever the Tower wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    
    
    private static int DEFAULT_DELAY = 100;
    private static int DEFAULT_RANGE = 150;
    private static int DEFAULT_PRICE = 100;

    private int delay; // The time between throws
    private int range; // How far the monkey can throw
    private int time;  // The counter that ticks toward the `delay`

    private boolean paid; // If the monkey has been paid for
    private int price; // How expensive the monkey is

    // Constuctor for a basic Monkey
    public Tower() {
        delay = DEFAULT_DELAY; // 100 ticks of delay
        range = DEFAULT_RANGE; // Range of 150
        price = DEFAULT_PRICE; // Costs $100
        setImage("archer.png"); // Set the image to a simple monkey
        paid = false; // This unit has not yet been paid for
    }

    // Constuctor for a Monkey with the given stats
    public Tower(int delay, int range, int price) {
        this(); // Call basic constructor to set defaults
        this.delay = delay; // Set delay
        this.range = range; // Set range
        this.price = price; // Set price
    }

    // Act method to throw darts
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
