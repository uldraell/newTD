import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Orc here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Orc extends Enemy
{
    private int hp = 100;
    
    // Simple constructor
    public Orc(Route route)
    {
        super(route); // Call super
        setImage("orc.png"); // Set the correct image
    }

    // Get the number of bloons to create on pop
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
}
