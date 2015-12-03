import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Objects that kill the ball
 *
 * @author Paulos Liu
 */
public abstract class EvilObject extends GameObject {
    public static final int WIDTH = 50;
    public static final int RADIUS = 25;
    public boolean ballPassed;
    public boolean top;

    public EvilObject() {
        ballPassed = false;
    }

    /**
     * If this is the top object and this has passed the ball
     * then we add one point
     */
    public void updateScore() {
        if (top && !ballPassed) {
            Level level = (Level) getWorld();
            if (getX() < level.SIZE / 3 - RADIUS) {
                ballPassed = true;
                level.incrementCurrentScore();
            }
        }
    }

    /**
     * EvilObjects pretty much just move around and update the score
     */
    public void act() {
        move();
        updateScore();
    }
}
