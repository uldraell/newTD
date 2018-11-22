
import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Bandit here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Bandit extends Enemy
{
    
    
        // Constructor takes a path to follow
       public Bandit(Route route)
        {
        super(route); // Pass a path to follow
        setImage("./images/redbloon_sm.png"); // Set the image to a red bloon
        }
     

        // Constructor takes a path iterator to continue
        public Bandit(Routenplaner route)
        {
        super(route); // Pass a pathiterator to continue
        setImage("./images/bandit.png"); // Set the image to a red bloon
     }

        // When it is popped, only delete yourself
        public void pop() {
        getWorld().removeObject(this);
     }

        // get the number of bloons to be spawned when popped
        public int numInnerBloons() {
        return 0;
     }
        
}
