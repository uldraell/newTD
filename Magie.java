import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Objekt welches den Gegner verfolgt, angreift und tötet.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Magie extends Angriff
{
    /**
     * Die Geschwindigkeit mit der das Objekt sich bewegt.
     * Der Schaden welches dieses Objekt anrichtet.
     */
    private static int projSpeed = 4;
    private static int damage = 50;
    
    /**
     * Übergibt den Konstruktor das Ziel.
     * Legt das Bild fest.
     */
    public Magie(Enemy target){
        super(target);
        setImage("../images/angriffe/magie.png");
    }
    
    public void act() 
    {
        angreifen();
    }    
    /**
     * Berechnent die Distanz zum Ziel.
     * Bewegt den Actor in Richtung des Ziels.
     * Falls es auf einen Gegner trifft, bekommt er Schaden und das Objekt wird entfernt.
     * Wenn der Gegner schon tot ist bevor, das Objekt ihn treffen konnte, wird es entfernt.
     */
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
