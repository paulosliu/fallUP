import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Objects that are part of gameplay that are not the ball
 *
 * @author Paulos Liu
 * @version (a version number or a date)
 */
public abstract class GameObject extends Actor {
    public static int SPEED = 4;
    //movement speed of all of the objects

    /**
     * moves the object with the speed
     */
    public void move() {
        setLocation(getX() - SPEED, getY());
        if (getX() < 10) {
            getWorld().removeObject(this);
        }
    }

    /**
     * Generates a random number x where min < x < max
     * @param min the min the number can be
     * @param max the max the number can be
     * @return the random number
     */
    public int generateRandomNumber(int min, int max) {
        return min + (int) (Math.random() * (max - min));
    }
}
