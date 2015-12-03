import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * This button resets everything to as it was in the beginning
 * 
 * @author Paulos Liu, Jun Lee
 */
public class ResetButton extends LevelChooserButtons
{
    public ResetButton(){
        super("Main Menu");
    }

    public void setWorld(){
        Greenfoot.setWorld(new Level());
    }
}
