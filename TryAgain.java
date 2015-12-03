import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Resets world with current difficulty
 * 
 * @author Paulos Liu, Jun Lee
 */
public class TryAgain extends LevelChooserButtons
{
    public TryAgain(){
        super("Try Again");
    }
    
    public void setWorld(){
        int difficulty = ((Level)getWorld()).getDifficulty();
        Greenfoot.setWorld(new Level(difficulty));
    }
}
