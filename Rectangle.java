import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

import java.awt.Color;

/**
 * Rectangles that hurt the ball
 *
 * @author Paulos Liu
 * @version (a version number or a date)
 */
public class Rectangle extends EvilObject {
    /* The directories for the images for the different sides */
    private static final String TOP_DIR = "images/topRect.png";
    private static final String BOT_DIR = "images/botRect.png";

    private int length;
    private GreenfootImage myImage;

    /**
     * Creates a rectangle with defined length
     *
     * @param length The wanted length for the rectangle
     * @param top    Whether this is the top one (since there is a bottom one)
     */
    public Rectangle(int length, boolean top) {
        this.length = length;
        super.top = top;

        initializeImage();
        setImage(myImage);
    }

    private void initializeImage() {
        if (top) {
            myImage = new GreenfootImage(TOP_DIR);
        } else {
            myImage = new GreenfootImage(BOT_DIR);
        }
        myImage.scale(WIDTH, length);
    }
}
