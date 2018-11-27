/**
 * Ist ein Ort auf der Spielwelt.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Wegpunkt  
{
    private int x;
    private int y;
    
    /**
     * Ist ein Punkt mit Koordinaten.
     */
    public Wegpunkt(int x, int y)
    {
        this.x = x;
        this.y = y;
    }
    
    public int getX()  {
        return x;
    }
        
    public int getY() {
        return y;
    }

    /**
     * Prüft ob die Koordinaten gleich sind.
     */
    public boolean equals(Wegpunkt that) {
        return this.getX() == that.getX() && this.getY() == that.getY();
    }
}
