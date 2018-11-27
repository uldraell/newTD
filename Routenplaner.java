/**
 * Das Werkzeug um die Route zu nutzen.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Routenplaner  
{
     private Route route;
     private Wegpunkt ziel;
     private int zielnummer;
     private Wegpunkt vorher;

     /**
      * Konstruktor nimmt einen Weg an, dem er dann folgt.
      */
     public Routenplaner(Route route) {
         this.route = route;
         this.zielnummer = 0;
         this.ziel = route.getPoints()[zielnummer];
         this.vorher = route.getPoints()[zielnummer];
     }

     /**
      * Berechnet den nächsten Schritt zum nächsten Zielpunkt.
      */
     public Wegpunkt next() {
         if(vorher.equals(ziel)) {
             zielnummer++;
             if(zielnummer == route.getPoints().length)
                 return null;
             ziel = route.getPoints()[zielnummer];
         }

         int x = vorher.getX();
         int y = vorher.getY();
        
         if(ziel.getX() > vorher.getX())
             x++;
         if(ziel.getX() < vorher.getX())
             x--;
         if(ziel.getY() > vorher.getY())
             y++;
         if(ziel.getY() < vorher.getY())
             y--;

         return (vorher = new Wegpunkt(x, y));
     }
     
     /**
      * Gibt den nächsten Wegpunkt auf der Route zurück.
      */
     public Wegpunkt nechste(){
         if(zielnummer == route.getPoints().length)
                 return ziel = route.getPoints()[zielnummer-1];;
         ziel = route.getPoints()[zielnummer];
         
         return ziel;
        }
}
