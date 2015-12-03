import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * The "Bomb" is just a floating block that the ball has to avoid
 *
 * @author Paulos Liu
 */
public class Bomb extends EvilObject {
    private static final String dir = "images/bomb.png";

    /**
     * Creates a bomb
     * @param top if the bomb is the very top one
     *            to avoid adding multiple points.
     */
    public Bomb(boolean top) {
        super.top = top;
        setImage(dir);
    }
}
