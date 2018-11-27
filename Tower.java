import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.List;
import java.util.ListIterator;


/**
 * Oberklasse der Türme.
 * Türme bekämpfen Gegner.
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
    public Tower() {
        delay = DEFAULT_DELAY;
        range = DEFAULT_RANGE;
        price = DEFAULT_PRICE;
        setImage("../images/troll/test.png");
        paid = false;
    }

    /**
     * Konstruktor der spezielle Werte annimmt.
     */
    public Tower(int delay, int range, int price) {
        this();
        this.delay = delay;
        this.range = range;
        this.price = price;
    }

    /**
     * Prüft ob sich der Spieler das platzieren der Türme leisten kann.
     * Sucht nächst-besten Gegner raus.
     * Greift den Gegner an.
     * Resetet den Timer.
     */
    public void act()
    {

        if(!paid) { 
            if(price <= ((TDWorld) getWorld()).getMoney()) { 
                ((TDWorld) getWorld()).removeMoney(price); 
                paid = true;
            } else {
                 getWorld().removeObject(this);
            }
        }

        if(delay < time) {
            List<Actor> possible = getObjectsInRange(range, Actor.class);

            ListIterator<Actor> itr = possible.listIterator();
            while (itr.hasNext()) {
                if(!(itr.next() instanceof Enemy)) {
                    itr.remove();
                }
            }
            
            if(possible.size() == 0)
                return;

            Enemy target = (Enemy) possible.get(0);
            turnTowards(target.getX(), target.getY());
            getWorld().addObject(new Magie(target), getX(), getY());

            time = 0;
        }else {
            time++;
        }
    }
}
