import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.List;

/**
 * These buttons remove remove previous menus and create their menu
 * 
 * @author Paulos Liu, Jun Lee
 */
public abstract class MenuButton extends Button
{
    public MenuButton(String name){
        super(name);
    }

    public void removePreviousMenus(){
        Level level = (Level)getWorld();
        level.removeMenu();
    }
}
