import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.List;
import java.util.ListIterator;
/**
 * Write a description of class Turret here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public abstract class Turret extends BetterActor
{
    protected static int DEFAULT_DELAY = 100;
    protected static int DEFAULT_RANGE = 150;
    protected static int DEFAULT_PRICE = 100;

    private int delay; // The time between throws
    private int range; // How far the monkey can throw
    private int time;  // The counter that ticks toward the `delay`

    private boolean paid; // If the monkey has been paid for
    private int price; // How expensive the monkey is

    // Constuctor for a basic Monkey
    public Turret(){
        delay = DEFAULT_DELAY; // 100 ticks of delay
        range = DEFAULT_RANGE; // Range of 150
        price = DEFAULT_PRICE; // Costs $100
        setImage("archer.png"); // Set the image to a simple monkey
        paid = false; // This unit has not yet been paid for
    }
    
     // Constuctor for a Monkey with the given stats
    public Turret(int delay, int range, int price) {
        this(); // Call basic constructor to set defaults
        this.delay = delay; // Set delay
        this.range = range; // Set range
        this.price = price; // Set price
    }
    public void act() 
    {
        // Add your action code here.
    }    
}
