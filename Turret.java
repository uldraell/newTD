import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.List;
import java.util.ListIterator;
/**
 * Bekämpft Gegner.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public abstract class Turret extends BetterActor
{
    protected static int DEFAULT_DELAY = 100;
    protected static int DEFAULT_RANGE = 150;
    protected static int DEFAULT_PRICE = 100;

    private int delay;
    private int range;
    private int time;

    private boolean paid;
    private int price;

    /**
     * Konstrukor nimmt Werte für die Zeit zwischen Schüssen, die Reichweite und den Preis entgegen.
     * Legt das Bild fest.
     * Prüft ob ein Tower bezahlt wurde.
     */    
    public Turret(){
        delay = DEFAULT_DELAY;
        range = DEFAULT_RANGE;
        price = DEFAULT_PRICE;
        setImage("../images/troll/test.png");
        paid = false;
    }
    
    /**
     * Konstruktor der spezielle Werte annimmt.
     */
    public Turret(int delay, int range, int price) {
        this();
        this.delay = delay;
        this.range = range;
        this.price = price;
    }
}
