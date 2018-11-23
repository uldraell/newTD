/**
 * Write a description of class Route here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Route  
{
    private Wegpunkt[] wegpunkte;

    public Route(Wegpunkt[] wegpunkte)
    {
        this.wegpunkte = wegpunkte;
    }

    // Get the points
    public Wegpunkt[] getPoints() {
        return wegpunkte;
    }
}
