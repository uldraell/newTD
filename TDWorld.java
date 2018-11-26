import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.*;

/**
 * Write a description of class TDWorld here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 * 
 * TDWorld ist die Welt in der das Spiel stattfindet.
 * 
 * 
 * 
 */
public class TDWorld extends World
{
    /**
     *  Die Enemy´s haben eine Route der sie folgen.
     * Es gibt verschiedene Level, die schwerer werden.
     * Die Enemy´s spawnen in einem gewissen Abstand.
     * Der Spieler hat eine gewisse Anzahl an Geld zur Verfügung.
     * Der Spieler hat eine gewisse Anzahl an Leben.
     * i=0
     * ei=1
     * 
     * 
     */
 
    private Route route;   // Path for the bloons to follow
    private Stage levels = new Stage(); 
    private int delay;   // Counter to delay bloon spawn

    private int money;   // How much money the player has
    private int lives;   // How many lives the player has
    private static int i = 0;
    private static int ei = 1;

    /**
     * Legt die Größe der Welt fest.
     * Legt die Geschwindigkeit des Spieles fest.
     * Legt das Hintergrundbild fest.
     * Erstellt einen Weg den die Enemy´s folgen.
     * 
     * Erstellt einen beweglichen Button der es ermöglicht Turrets zu platzieren.
     * Legt den Startwert für den Abstand der zu spawnenden Gegner fest.
     * Legt das Startgold fest.
     * Legt fest wieviel Leben der Spieler hat.
     * 
     */
    
    
    public TDWorld()
    
    {    
        super(1600, 900, 1); // setzt größe der Welt auf 16:9
        Greenfoot.setSpeed(500); // setzt Geschwindigkeit des Spiels auf 60
        setBackground("weg3.png");
        
        route = new Route(new Wegpunkt[]{ // Create the path for the bloons to follow
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
            new Wegpunkt(1484, 165), 
        });
        TurretButton turb = new TurretButton();
        addObject(turb, 900, 850);
        
        //Stage levels = new Stage();
        
        
        delay = 0; // Set the bloon counter to 0
        //rand = new Random(); // Initialize random

        money = 100000; // Start with 200 money
        lives = 200; // Start with 200 lives
    }
    
    // Act method for World
    
    /**
     * Zeigt das Geld des Spielers an.
     * Zeigt das Leben des Spieler an.
     * Wenn der Spieler kein Leben mehr hat, stoppt das Spiel und wird gefragt ob er nochmal spielen möchte.
     * Wenn er "ja" sagt, wird die Welt resetet und das Spiel beginnt von vorn.
     * int rand
     * Nach einer festgelegten Zeit spawnt zufällig einer der verschiedenen Gegner.
     * 
     */
    
    
    public void act() {
        showText("[ " + money + " ]", 130, 17); // Draw amount of money to screen
        showText("[ " + lives + " ]",  330, 17); // Draw number of lives to screen
        
        

        //showText("x: " + Greenfoot.getMouseInfo().getX(), 500, 10);
        //showText("y: " + Greenfoot.getMouseInfo().getY(), 500, 30);
        
        if(lives < 0) { // If the player is out of lives, show the game over
            Greenfoot.stop(); // Stop the game
            if(Greenfoot.ask("Would you like to play again?").equalsIgnoreCase("yes")) { // Ask to play again
                Greenfoot.setWorld(new TDWorld()); // Reset world
                Greenfoot.start(); // Start game
            }
        }
        
    
        int rand = Greenfoot.getRandomNumber(10);
        
        if(delay > 120 ) { // Check the counter for bloon spawning
            Enemy b = null; // Initialize bloon
            
            try{
            //System.out.println(levels.getEnemy(i));
            switch(levels.getEnemy(i)) { // Randomly choose bloon color
            case 0:
                b = new Bandit(route);
                break;
            case 1:
                b = new Orc(route);
                break;
            case 2:
                b = new Bandit(route);
                break;
            case 3:
                b = new Troll(route, 1);
                break;
                
            }
            i++;
            if (i>4)
            i=0;
            } catch(IllegalStateException e) {
            // Wenn der Gegner schon tot is wird es hier abgefangen - weiß nicht ob hier noch was hin sollte 
            levels.changelevel(ei);
            ei++;
            }
            

            addObject(b, 0, 0); // Add Bloon to world

            delay = 0; // Reset counter
        } else {
            delay++; // Increment counter
        }
    
    }
    
    /**
     * Plaziert eine Balliste an den gewünschten Koordinaten.
     * @param x ist die x-Koordinate an der die Balliste platziert wird.
     * @param y ist die y-Koordiante an der die Balliste platziert wrid.
     * 
     * 
     */
    
    
    public void placeBallistae(int x, int y){
        Ballistae t = new Ballistae();
        addObject(t, x, y);
    }
    
    /**
     * Subtrahiert eine gewisse Anzahl an Leben von dem Spieler.
     * 
     */
    
    // Subtract x number of lives from the scoreboard
    public void decreaseLives(int deaths) {
        lives -= deaths;
    }

    /**
     * Fügt dem Spieler Geld hinzu.
     */
    // Add 1 to the amount of money
    public void addMoney(int amount) {
        money += amount;
    }

    /**
     * Subtrahiert eine gewisse Anzahl an Geld von dem Spieler.
     * 
     */
    // Remove x number of money from the scoreboard
    public void removeMoney(int cash) {
        money -= cash;
    }

    /**
     * Bekommt die Anzahl an Geld.
     * Und wird auf der Spielfläche angezeigt.
     */
    // Get the amount of money on the scoreboard
    public int getMoney() {
        return money;
    }
}
