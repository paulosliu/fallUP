import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * A button that creates a Level with the given difficulty level
 * 
 * @author Paulos Liu, Jun Lee
 */
public class RegularLevelButton extends LevelChooserButtons
{
    private int level;
    /**
     * Creates buttons that access different levels
     * @param levelNumber The level you want to play, where 0 is easy
     */
    public RegularLevelButton(String name, int level){
        super(name);
        this.level = level;
    }

    /**
     * Set a world with the defined level
     */
    public void setWorld(){
        Greenfoot.setWorld(new Level(level));
    }
}
