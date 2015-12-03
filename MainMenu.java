import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.ArrayList;

/**
 * A menu with a play and level button
 * 
 * @author Paulos Liu
 * @version (a version number or a date)
 */
public class MainMenu extends Menu
{
    
    public MainMenu(){
        myButtons = new ArrayList<>();
        myButtons.add(new PlayButton());
        myButtons.add(new LevelMenuButton());
    }
}
