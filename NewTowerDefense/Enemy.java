import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Enemy here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public abstract class Enemy extends BetterActor
{
     // Path to follow
    private Routenplaner rtplaner;

    // Constructor that takes a path to follow
    public Enemy(Route route) {
        rtplaner = new Routenplaner(route);
    }

    // Constructor that takes a path iterator to continue
    public Enemy(Routenplaner rtrtplaner) {
        rtplaner = rtrtplaner;
    }

    // Act method
    public void act()
    {
        Wegpunkt next = rtplaner.next(); // Get the next point
        if(next == null) {
            ((TDWorld) getWorld()).decreaseLives(numInnerBloons() + 1); // delete yourself and decrease lives
            getWorld().removeObject(this);
        } else {
            moveTo(next); // Move to the point
        }
    }

    // Called when this Bloon is hit with a dart
    public void pop() {
        for(int i=0; i<numInnerBloons(); i++) { // Spawn a new RedBloon for every "innerBloon"
            Routenplaner subrtplaner = rtplaner.clone(); // Clone the iterator to follow
            for(int j=0; j<i*10; j++) // Set them all slightly apart by advancing some more than others
                subrtplaner.next();
            getWorld().addObject(new Bandit(subrtplaner), getX(), getY()); // Add the new Bloons
        };
        getWorld().removeObject(this); // Remove yourself
    }

    // Get the number of bloons to release when popped
    public abstract int numInnerBloons();
}
