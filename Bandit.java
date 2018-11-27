
import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Schwächster Gegner.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Bandit extends Enemy
{
    
     private int hp = 30;
     
     /**
      * @see Enemy
      */
     
     public Bandit(Route route)
     {     
        super(route);
        setImage("bandit.png");
     }
     

     /**
      * @see Enemy
      */   
     public Bandit(Routenplaner route)
     {
         super(route);
         setImage("bandit.png");
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
     /**
      * @see Enemy
      */
      public int getBounty(){
        return 100;
     }
}
