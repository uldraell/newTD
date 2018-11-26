/**
 * Write a description of class Wegpunkte here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Wegpunkt  
{
    private int x; // The X coordinate
    private int y; // The Y coordinate
    
    public Wegpunkt(int x, int y)
    {
        this.x = x; // Set X
        this.y = y; // Set Y
    }

    // Get X
    public int getX()  {
        return x;
    }
    
    // Get Y
    public int getY() {
        return y;
    }

    // Check if one point is the same as another
    public boolean equals(Wegpunkt that) {
        return this.getX() == that.getX() && this.getY() == that.getY();
    }
}
