import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

import java.awt.Color;

/**
 * This is a abstract class that defines what a Button is in the game
 * Since all of the buttons are text based, the setImage takes in text.
 *
 * @author Paulos Liu, Jun lee
 */
public abstract class Button extends Actor {
    private static final int DEFAULT_SIZE = 40;

    /**
     * Creates a button with name
     *
     * @param name The text of the button
     */
    public Button(String name) {
        setImage(name);
    }

    /**
     * If the button is clicked, do the action defined in the subclasses
     */
    public void act() {
        if (Greenfoot.mouseClicked(this)) {
            action();
        }
    }

    /**
     * Creates the image for the button with the the given text and text size
     *
     * @param text the text you want on the button
     * @param size the text size
     */
    public void setImage(String text, int size) {
        setImage(new GreenfootImage(text, size, Color.WHITE, 
                    new Color(0,0,0,0)));
    }

    /**
     * Creates the image for the button with the the given
     * text and default text size
     *
     * @param text the text you want on the button
     */
    public void setImage(String text) {
        setImage(text, DEFAULT_SIZE);
    }

    /**
     * the unique actions of the subclasses
     */
    public abstract void action();
}
