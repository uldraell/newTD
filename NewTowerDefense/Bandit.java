
import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Bandit here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Bandit extends Enemy
{
    
     private int hp = 100;
     
        // Constructor takes a path to follow
     public Bandit(Route route)
     {     
        super(route); // Pass a path to follow
        setImage("bandit.png"); // Set the image to a red bloon
     }
     

        // Constructor takes a path iterator to continue
     public Bandit(Routenplaner route)
     {
         super(route); // Pass a pathiterator to continue
         setImage("bandit.png"); // Set the image to a red bloon
     }

        // When it is popped, only delete yourself
     public void pop() {
         getWorld().removeObject(this);
     }

        // get the number of bloons to be spawned when popped
     public int numInnerBloons() {
         return 0;
     }
     
     public  void switchImage(Wegpunkt ziel){
        /**
        if (getImage() == downup1) 
        {
            setImage(downup2);
        }
        else
        {
            setImage(downup1);
        }*/
     }
        
     public int getHP(){
        return hp;
     }
     
     public void setHP(int newHP){
        hp = newHP;
     }
     
     public int getBounty(){
        return 100;
    }
}
