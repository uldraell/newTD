/**
 * Beschreibt alle Wegpunkte aneinander "gekettet".
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Route  
{
    private Wegpunkt[] wegpunkte;

    /**
     * Nimmt Wegpunkte entgegen.
     */
    public Route(Wegpunkt[] wegpunkte)
    {
        this.wegpunkte = wegpunkte;
    }

    /**
     * Gibt Wegpunkte zurück.
     */    
    public Wegpunkt[] getPoints() {
        return wegpunkte;
    }
}
