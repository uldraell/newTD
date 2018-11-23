import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot und MouseInfo)

/**
 * Ergänzen Sie hier eine Beschreibung für die Klasse magiestrahl.
 * 
 * @author (Ihr Name) 
 * @version (eine Versionsnummer oder ein Datum)
 */
public class magiestrahl extends Turret
{
    /**
     * Act - tut, was auch immer magiestrahl tun will. Diese Methode wird aufgerufen, 
     * sobald der 'Act' oder 'Run' Button in der Umgebung angeklickt werden. 
     */
     public magiestrahl(Enemy target)
    {
        super(target); // Ziel festlegen
        setImage("magiestrahl.png"); // Bild festlegen
        
        
        
    }

}