import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.List;
import java.util.ListIterator;
/**
 * Bekämpft Gegner.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Ballistae extends Turret
{
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
     public Ballistae(){
        delay = DEFAULT_DELAY;
        range = DEFAULT_RANGE;
        price = DEFAULT_PRICE;
        setImage("../images/turrets/crossbow.png");
        paid = false;
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
            getWorld().addObject(new Pfeil(target), getX(), getY());
            Greenfoot.playSound("../sounds/crossbow.wav");

            time = 0;
        }else {
            time++;
        }
    }    
}
