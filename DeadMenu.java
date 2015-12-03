import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

import java.util.ArrayList;

/**
 * The menu for when you're dead
 *
 * @author Paulos Liu
 * @version (a version number or a date)
 */
public class DeadMenu extends Menu {
    /* change the place since we want a different place */
    private static final int X_INDEX = 300;
    private static final int Y_INDEX = 250;

    /**
     * Creates a DeadMenu
     */
    public DeadMenu() {
        myButtons = new ArrayList<>();
        myButtons.add(new TryAgain());
        myButtons.add(new ResetButton());
    }

    /**
     * Puts in the elements
     *
     * @param world The Greenfoot world this is in
     */
    public void makeButtons(World world) {
        Score highScore = new Score((Level) world);
        world.addObject(highScore, X_INDEX, Y_INDEX - SPACING);
        for (int x = 0; x < myButtons.size(); x++) {
            world.addObject(myButtons.get(x), X_INDEX, Y_INDEX + x * SPACING);
        }
    }
}
