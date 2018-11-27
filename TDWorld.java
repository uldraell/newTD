import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.*;

/**
 * TDWorld ist für die Entstehung der Spielwelt und das spawnen der Gegner zuständig.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class TDWorld extends World
{
    private Route route;   // Route für die Gegner
    private Stage levels = new Stage(); //Eine Stage enthält mehrere level, hier wird das derzeitige level geladen
    private int delay;   // Zeitabstand in dem die Gegner spawnen

    private int geld;   // Geld des Spielers
    private int leben;   // Lebenspunkte des Spielers
    private static int i = 0; //Zählervariable 
    private static int ei = 1; //Zählervariable

    /**
     * Legt die Größe der Welt fest. (16:9)
     * Legt die Geschwindigkeit des Spieles fest.
     * Legt das Hintergrundbild fest.
     * Erstellt einen Weg dem die Enemy´s folgen.
     * 
     * Erstellt einen beweglichen Button der es ermöglicht Turrets zu platzieren.
     * Legt den Startwert für den Abstand der zu spawnenden Gegner fest.
     * Legt das Startgold fest.
     * Legt fest wieviel Leben der Spieler hat.
     * 
     */

    public TDWorld()

    {    
        super(1600, 900, 1); 
        Greenfoot.setSpeed(100); 
        setBackground("weg3.png"); 

        route = new Route(new Wegpunkt[]{ 
                new Wegpunkt(157, 153),
                new Wegpunkt(157, 687),
                new Wegpunkt(547, 687),
                new Wegpunkt(547, 481),
                new Wegpunkt(335, 481),
                new Wegpunkt(335, 203),
                new Wegpunkt(860, 203),
                new Wegpunkt(860, 713),
                new Wegpunkt(1047, 713),
                new Wegpunkt(1047, 538),
                new Wegpunkt(1232, 538),
                new Wegpunkt(1232, 812),
                new Wegpunkt(1531, 812),
                new Wegpunkt(1531, 365),
                new Wegpunkt(1040, 365),
                new Wegpunkt(1040, 165),
                new Wegpunkt(1484, 165)      
            });
            
        TurretButton turb = new TurretButton();
        addObject(turb, 823, 46);
        
        TurretButton2 turb2 = new TurretButton2();
        addObject(turb2, 723, 46);
        
        delay = 0;
        geld = 999999;
        leben = 1; 
    }

    /**
     * Zeigt das Geld des Spielers an.
     * Zeigt das Leben des Spielers an.
     * Wenn der Spieler kein Leben mehr hat, stoppt das Spiel
     * Nach einer festgelegten Zeit spawnt einer der verschiedenen Gegner wie in den levels vorgegeben.
     * 
     */
    public void act() {
        showText("[ " + geld + " ]", 135, 15); 
        showText("[ " + leben + " ]",  360, 15); 

        if(leben < 0) { 
            Greenfoot.playSound("../sounds/gameover.wav");
            Greenfoot.stop(); 
        }

        if(delay > 120 ) { 
            Enemy enemy = null; 
            try{
                switch(levels.getEnemy(i)) { 
                    case 0:
                    enemy = new Bandit(route);
                    break;
                    case 1:
                    enemy = new Orc(route);
                    break;
                    case 2:
                    enemy = new Bandit(route);
                    break;
                    case 3:
                    enemy = new Troll(route);
                    break;

                }
                i++;
                if (i>4)
                    i=0;
            } catch(IllegalStateException e) {
                levels.changelevel(ei);
                ei++;
            }

            addObject(enemy, 0, 0); 
            
            delay = 0; 
        } else {
            delay++;
        }

    }

    /**
     * Plaziert eine Balliste an den gewünschten Koordinaten.
     */
    public void placeBallistae(int x, int y){
        Ballistae b = new Ballistae();
        addObject(b, x, y);
    }
    
    public void placeTower1(int x, int y){
        Tower1 t1 = new Tower1();
        addObject(t1, x, y);
    }
   
        public void placeTower2(int x, int y){
        Tower2 t2 = new Tower2();
        addObject(t2, x, y);
    }
    
    public void placeMagier(int x, int y){
        Magier m = new Magier();
        addObject(m, x, y);
    }

    public void decreaseLives(int deaths) {
        leben -= deaths;
    }

    public void addMoney(int amount) {
        geld += amount;
    }

    public void removeMoney(int abzug) {
        geld -= abzug;
    }

    public int getMoney() {
        return geld;
    }
}
