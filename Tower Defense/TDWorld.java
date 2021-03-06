import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)


/**
 * Write a description of class TDWorld here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class TDWorld extends World
{
    private Route route;   // Path for the bloons to follow
    private int delay;   // Counter to delay bloon spawn

    private int money;   // How much money the player has
    private int lives;   // How many lives the player has

    public TDWorld()
    {    
        super(1600, 900, 1); // setzt größe der Welt auf 16:9
        Greenfoot.setSpeed(60); // setzt Geschwindigkeit des Spiels auf 60
        setBackground("weg.png");
        
        route = new Route(new Wegpunkt[]{ // Create the path for the bloons to follow
            new Wegpunkt(56, 21),
            new Wegpunkt(56, 217),
            new Wegpunkt(646, 217),
            new Wegpunkt(646, 618),
            new Wegpunkt(1160, 618),
            new Wegpunkt(1160, 830),
            new Wegpunkt(1520, 830),
            new Wegpunkt(1520, 725),
      
        });
        
        delay = 0; // Set the bloon counter to 0
        //rand = new Random(); // Initialize random

        money = 100000; // Start with 200 money
        lives = 200; // Start with 200 lives
    }
    
    // Act method for World
    public void act() {
        showText("Lives: " + lives,  70, 10); // Draw number of lives to screen
        showText("Money: $" + money, 70, 30); // Draw amount of money to screen

        if(lives < 0) { // If the player is out of lives, show the game over
            Greenfoot.stop(); // Stop the game
            if(Greenfoot.ask("Would you like to play again?").equalsIgnoreCase("yes")) { // Ask to play again
                Greenfoot.setWorld(new TDWorld()); // Reset world
                Greenfoot.start(); // Start game
            }
        }
        /**
        if(delay > 120) { // Check the counter for bloon spawning
            Bloon b = null; // Initialize bloon

            switch(rand.nextInt(3)) { // Randomly choose bloon color
            case 0:
                b = new RedBloon(path);
                break;
            case 1:
                b = new BlueBloon(path);
                break;
            case 2:
                b = new GreenBloon(path);
                break;
            }

            addObject(b, 0, 0); // Add Bloon to world

            delay = 0; // Reset counter
        } else {
            delay++; // Increment counter
        }
    */
    }
    
    
    // Subtract x number of lives from the scoreboard
    public void decreaseLives(int deaths) {
        lives -= deaths;
    }

    // Add 1 to the amount of money
    public void addMoney() {
        money++;
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
