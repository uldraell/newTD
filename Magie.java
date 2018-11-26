import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class magie here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 * 
 * Objekt welches den Gegner verfolgt, angreift und tötet.
 * 
 * 
 */
public class Magie extends Angriff
{
    /**
     * Die Geschwindigkeit mit der das Objekt sich bewegt.
     * Der Schaden welches dieses Objekt anrichtet.
     * 
     */
    
 
    private static int projSpeed = 4;
    private static int damage = 50;
    
    
    /**
     * Übergibt den Konstruktor das Ziel.
     * Legt das Bild fest.
     * 
     */
    public Magie(Enemy target){
        super(target);
        setImage("../images/angriffe/magie.png");
    }
    
    /**
     * Die Methode wird ständig ausgeführt
     * 
     */
    public void act() 
    {
        angreifen();
    }    
    
    /**
     * Das Objekt dreht sich in Richtung des Ziels.
     * Und bewegt sich in die Richtung.
     * Falls es auf einen Gegner trifft, bekommt er Schaden und das Objekt wird entfernt.
     * Wenn der Gegner schon tot ist bevor, das Objekt ihn treffen konnte, wirdes entfernt.
     * 
     */
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
