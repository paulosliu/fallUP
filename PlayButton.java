import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Starts the game
 * 
 * @author Paulos Liu, Jun Lee
 */
public class PlayButton extends Button
{  
    public PlayButton(){
        super("Play");
    }

    public void action(){
        Level level = (Level)getWorld();
        level.startGameRemoveEverything();  
    }
}
