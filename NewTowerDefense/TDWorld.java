import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.*;

/**
 * Write a description of class TDWorld here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class TDWorld extends World
{
    private Route route;   // Path for the bloons to follow
    private Stage levels = new Stage(); 
    private int delay;   // Counter to delay bloon spawn

    private int money;   // How much money the player has
    private int lives;   // How many lives the player has
    private static int i = 0;
    private static int ei = 1;

    public TDWorld()
    
    {    
        super(1600, 900, 1); // setzt größe der Welt auf 16:9
        Greenfoot.setSpeed(500); // setzt Geschwindigkeit des Spiels auf 60
        setBackground("weg3.png");
        
        route = new Route(new Wegpunkt[]{ // Create the path for the bloons to follow
            new Wegpunkt(140, 145),
            new Wegpunkt(140, 640),
            new Wegpunkt(490, 640),
            new Wegpunkt(490, 450),
            new Wegpunkt(305, 450),
            new Wegpunkt(305, 195),
            new Wegpunkt(775, 195),
            new Wegpunkt(775, 665),
            new Wegpunkt(940, 665),
            new Wegpunkt(940, 505),
            new Wegpunkt(1110, 505),
            new Wegpunkt(1110, 755),
            new Wegpunkt(1380, 755),
            new Wegpunkt(1380, 340),
            new Wegpunkt(935, 340),         
            new Wegpunkt(935, 155),
            new Wegpunkt(1360, 155)      
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
    
    public void placeBallistae(int x, int y){
        Ballistae t = new Ballistae();
        addObject(t, x, y);
    }
    
    
    // Subtract x number of lives from the scoreboard
    public void decreaseLives(int deaths) {
        lives -= deaths;
    }

    // Add 1 to the amount of money
    public void addMoney(int amount) {
        money += amount;
    }


    // Remove x number of money from the scoreboard
    public void removeMoney(int cash) {
        money -= cash;
    }

    // Get the amount of money on the scoreboard
    public int getMoney() {
        return money;
    }
}
