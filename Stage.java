import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.*;
/**
 * Konzept für interessantes Leveldesign.
 * Ausbalanciertes Power-system.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Stage extends BetterActor
{

    private static List<Integer> wellen = new ArrayList<>();
    private static int levelindex;
    
    /**
     * Initialisiert die Gegnerreihenfolge des ersten Levels.
     */
    public Stage()
    {
        startlevel1();  
        
    }
    
    /**
     * Soll zum nächsten Level wechseln, wenn das erste fertig ist.
     */
    public int changelevel(int levelindex){
        try{
                
            switch(levelindex) { 
            case 0:
                levelindex = 1;
                break;
            case 1:
                startlevel1();
                break;
            case 2:
                startlevel2();
                break;
            case 3:
                startlevel3();
                break;
                
            }
            } catch(IllegalStateException e) {
            startlevel1();
            }
            return levelindex;
            
    }
    
    /**
     * Gibt die Nummer des Gegners an der Indexstelle des Arrays zurück.
     */
    public int getEnemy(int index){
        try{
            return wellen.get(index);
            } catch(IllegalStateException e) {
            return 99;
            }
    }
    
    /**
     * Löscht bisherige Gegnerreihenfolge aus dem Array und fügt die für dieses Level passende ein.
     */
    public void startlevel1(){
       wellen.clear();
       levelindex = 1;
       
       wellen.add(2);
       wellen.add(3);
       wellen.add(1);
       wellen.add(3);
       wellen.add(1);
    }
    
    /**
     * Löscht bisherige Gegnerreihenfolge aus dem Array und fügt die für dieses Level passende ein.
     */    
    public void startlevel2(){
        wellen.clear();
        levelindex = 2;
        
        wellen.add(2);
        wellen.add(2);
        wellen.add(2);
        wellen.add(2);
        wellen.add(2);
    }
    
    /**
     * Löscht bisherige Gegnerreihenfolge aus dem Array und fügt die für dieses Level passende ein.
     */   
    public void startlevel3(){
        wellen.clear();
        levelindex = 3;
        
        wellen.add(3);
        wellen.add(3);
        wellen.add(3);
        wellen.add(3);
        wellen.add(3);
    }
}
