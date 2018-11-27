import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Normaler Gegner.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Orc extends Enemy
{
    private int hp = 100;
    
    /**
     * @see Enemy
     */
    public Orc(Route route)
    {
        super(route);
        setImage("orc.png");
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
