import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Bossgegner
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Troll extends Enemy
{
    private GreenfootImage up1 = new GreenfootImage("../images/troll/up1.png");;
    private GreenfootImage down1 = new GreenfootImage("../images/troll/down1.png");
    private GreenfootImage down2 = new GreenfootImage("../images/troll/down2.png");
    private GreenfootImage down3 = new GreenfootImage("../images/troll/down3.png");
    private GreenfootImage down4 = new GreenfootImage("../images/troll/down4.png");
    private GreenfootImage test = new GreenfootImage("../images/troll/test.png");
    private GreenfootImage right1 = new GreenfootImage("../images/troll/right1.png");
    private GreenfootImage left1 = new GreenfootImage("../images/troll/left1.png");
    
    public static int texth = 30;
    private int hp = 200;
    
    
    /**
     * Animation des Bossgegners
     */
    public Troll(Route route)
    {
      super(route);
      setImage("../images/troll/down1.png");
    }

    /**
     * Animation des Bossgegners.
     */
    public void switchImage(Wegpunkt ziel){
        double dir = calculateDirection(this.getX(),this.getY(),ziel.getX(),ziel.getY());
        boolean down = true;
        boolean right = false;
        boolean left = false;
        boolean up = false;
        
        int rot = (int) dir;
        try{
        if ((rot >= 45) && (rot <= 135)){ 
            setImage(right1);
        } else {
        
        if ((rot >= 225) && (rot <= 315)){ 
            setImage(left1);
        } else {
        
        if ((rot > 315) && (rot < 45)){ 
            setImage(up1);
        } else{
            animateDown();
        }
           }
       }
       } catch(IllegalStateException e) {
            System.out.println("Troll try except ausgelöst");// nur zusätzliches failsafe falls es probleme mit dem Tot des Trolls gibt
        } 
    }
    
    /**
     * Animation des Bossgegners.
     */    
    public void animateDown(){
        if (getImage() == down1) 
        {
            this.setImage(down2);
            
        } else {
            if (getImage() == down2) 
            {
                this.setImage(down3);
                
            }else { 
               if (getImage() == down3) 
               {
                   this.setImage(down4);
                   
               }else {
                    this.setImage(down1);
                    }
                }
            }
        
    }

    /**
     * Berechnung der Rotation für die Animation.
     */
    public static double calculateDirection(int x, int y, int zx, int zy)
      {
        double theta = Math.atan2(zy - y, zx - x);
        theta += Math.PI/2.0;
        double angle = Math.toDegrees(theta);
        
        if (angle < 0) {
        angle += 360;
           }

        return angle;
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
