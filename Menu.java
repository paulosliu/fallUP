import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.ArrayList;

/**
 * Menus hold buttons, and sometimes logs
 * Has A LOT of subclasses. Much polymorphism.
 * 
 * @author Paulos Liu
 */
public abstract class Menu 
{
    public static final int X_INDEX = 400;
    public static final int Y_INDEX = 350;
    //where menus are generally
    
    public static final int SPACING = 60;
    //Distance between the centers of the buttons
    
    public ArrayList<Button> myButtons;

    /**
     * Puts the buttons in order
     * @param world The world we put the buttons in
     */
    public void makeButtons(World world){
        for(int x = 0; x < myButtons.size(); x++){
            world.addObject(myButtons.get(x), X_INDEX, Y_INDEX + x*SPACING);
        }
    }

    /**
     * Gets the list of buttons in the menu
     * @return the list of buttons in the menu
     */
    public ArrayList<Button> getButtons(){
        return myButtons;
    }

}
