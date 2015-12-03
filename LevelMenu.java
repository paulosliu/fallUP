import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.ArrayList;

/**
 * Creates a Menu with the amount of levels there are (3)
 * 
 * @author Paulos Liu
 */
public class LevelMenu extends Menu
{
    public static final int LEVEL_AMOUNT = 3;
    private static final String[] LEVEL_NAMES = 
        new String[]{"Easy", "Medium", "Hard"};

    public LevelMenu(){
        myButtons = new ArrayList<>();
        for(int x=0; x<LEVEL_AMOUNT; x++){
            myButtons.add(new RegularLevelButton(LEVEL_NAMES[x], x));
        }
        myButtons.add(new MainMenuButton());
    }
}    

