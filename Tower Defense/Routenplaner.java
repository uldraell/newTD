/**
 * Write a description of class Routenplaner here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Routenplaner  
{
     private Route route; // The path to follow
     private Wegpunkt ziel; // The point currently working towards
     private int zielnummer; // The index of the target
     private Wegpunkt vorher; // The last point returned

     // Constructor, accepts a path to follow
     public Routenplaner(Route route) {
         this.route = route; // Set the path
         this.zielnummer = 0; // Set the target index
         this.ziel = route.getPoints()[zielnummer]; // Set the target to the first point
         this.vorher = route.getPoints()[zielnummer]; // Set the last point to be the first point
     }

     // Get the next point on the path
     public Wegpunkt next() {
         if(vorher.equals(ziel)) { // If the last one returned was the target
             zielnummer++; // Increment the targetIndex
             if(zielnummer == route.getPoints().length) // Check if it was the final point
                 return null;
             ziel = route.getPoints()[zielnummer]; // Set the new target
         }

         int x = vorher.getX(); // Get X from the last point
         int y = vorher.getY(); // Get Y from the last point

         // Add or subtract one to bring the point a step closer
         if(ziel.getX() > vorher.getX())
             x++;
         if(ziel.getX() < vorher.getX())
             x--;
         if(ziel.getY() > vorher.getY())
             y++;
         if(ziel.getY() < vorher.getY())
             y--;

         return (vorher = new Wegpunkt(x, y)); // Return a point with the new cooridnates
     }

     // Return a duplicate of itself
     public Routenplaner clone() {
         Routenplaner n = new Routenplaner(route); // Create a new PathIterator
         n.route = route; // Set path
         n.ziel = ziel; // Set target
         n.zielnummer = zielnummer; // Set targetIndex
         n.vorher = vorher; // Set last
         return n; // return it
     }
}
