import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Troll here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Troll extends Enemy
{
    private GreenfootImage up1 = new GreenfootImage("../images/troll/up1.png");;
    //private GreenfootImage downup2 = new GreenfootImage("../images/troll/downup2.png");
    private GreenfootImage down1 = new GreenfootImage("../images/troll/down1.png");
    private GreenfootImage down2 = new GreenfootImage("../images/troll/down2.png");
    private GreenfootImage down3 = new GreenfootImage("../images/troll/down3.png");
    private GreenfootImage down4 = new GreenfootImage("../images/troll/down4.png");
    
    private GreenfootImage test = new GreenfootImage("../images/troll/test.png");
    private GreenfootImage right1 = new GreenfootImage("../images/troll/right1.png");
    private GreenfootImage left1 = new GreenfootImage("../images/troll/left1.png");
    
    public static int texth = 30;
    
    private int hp = 100;
    
    
    // A simple constuctor that takes a path to follow
    public Troll(Route route, int imgnum)
    {
        super(route); // Pass the path on to super
      
        setImage("../images/troll/down1.png"); // Set the image to a green bloon
    }
    
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
            //setImage(down1);
            animateDown();
        }
           }
       }
       } catch(IllegalStateException e) {
            System.out.println("Troll try except ausgelöst");// nur zusätzliches failsafe falls es probleme mit dem Tot des Trolls gibt
        } 
    }
    
    public void animateDown(){ //animiert den Troll wenn er nach unten läuft
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

    
    public static double calculateDirection(int x, int y, int zx, int zy)
      {
          // calculate the angle theta from the deltaY and deltaX values
          // (atan2 returns radians values from [-PI,PI])
          // 0 currently points EAST.  
          // NOTE: By preserving Y and X param order to atan2,  we are expecting 
          // a CLOCKWISE angle direction.  
        double theta = Math.atan2(zy - y, zx - x);

        // rotate the theta angle clockwise by 90 degrees 
        // (this makes 0 point NORTH)
        // NOTE: adding to an angle rotates it clockwise.  
        // subtracting would rotate it counter-clockwise
        theta += Math.PI/2.0;

        // convert from radians to degrees
        // this will give you an angle from [0->270],[-180,0]
        double angle = Math.toDegrees(theta);

        // convert to positive range [0-360)
        // since we want to prevent negative angles, adjust them now.
        // we can assume that atan2 will not return a negative value
        // greater than one partial rotation
        if (angle < 0) {
        angle += 360;
           }

        return angle;
}
    
    // Get the number of bloons to spawn when popping
    public int numInnerBloons() {
        return 0;
    }  
    
    public int getHP(){
        return hp;
    }
    
    public void setHP(int newHP){
        hp = newHP;
    }
}
