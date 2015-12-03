import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.*;

/**
 * This class removes previous menus and makes a main menu
 * 
 * @author Paulos Liu, Jun Lee
 */
public class MainMenuButton extends MenuButton
{
    public MainMenuButton(){
        super("Main Menu");
    }
    
    /**
     * This class removes previous menus and makes a main menu
     */
    public void action() 
    {
        Level level = (Level)getWorld();
        removePreviousMenus();
        Menu mainMenu = new MainMenu();
        level.setMenu(mainMenu);
        mainMenu.makeButtons(level);
    }    
}
