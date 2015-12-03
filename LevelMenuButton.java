import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.ArrayList;

/**
 * This button removes the previous menus and creates a level menu
 * 
 * @author Paulos Liu, Jun Lee
 */
public class LevelMenuButton extends MenuButton
{
    public static final int LEVEL_AMOUNT = 4;
    
    public LevelMenuButton(){
        super("Levels");
    }
    
    /**
     * This button removes the previous menus and creates a level menu
     */
    public void action() 
    {
        Level level = (Level)getWorld();
        removePreviousMenus();
        Menu levelMenu = new LevelMenu();
        level.setMenu(levelMenu);
        levelMenu.makeButtons(level);
    }    
}
