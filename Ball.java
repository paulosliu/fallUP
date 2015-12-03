import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * This is the "main character" of the game. The user makes the ball go up and
 * down, trying to avoid the obstacles--the evil objects!
 *
 * @author Paulos Liu, Jun Lee
 */
public class Ball extends Actor {
    private static final String BLUE_DIR = "images/blueBall.png";
    private static final String ORANGE_DIR = "images/orangeBall.png";
    private static final GreenfootSound STATIC_SOUND =
            new GreenfootSound("sounds/electric.mp3");

    private static final int DELAY_FACTOR = 23;
    private static final int REBOUND_SPEED = 5;

    private boolean blue;
    private int velocity;
    private int timeSinceSwitched;
    private boolean justStarted;
    private boolean dead;

    public Ball() {
        dead = false;
        blue = true;
        justStarted = true;

        timeSinceSwitched = 0;
        velocity = 0;

        setImage(BLUE_DIR);
    }

    /**
     * If it touches a "evil object" it dies
     * If space is pressed or hits a wall, it moves to the other side
     * We calculate the speed and move
     * We keep track of the time
     */
    public void act() {
        if (isTouching(EvilObject.class)) {
            die();
        }
        if ((Greenfoot.isKeyDown("space") ||
                isTouching(Wall.class)) && delay() && !dead) {
            changeColor();
        }
        if (justStarted) {
            startVelocity();
        } else {
            calculateVelocity();
        }
        move();
        timeSinceSwitched++;
    }

    /**
     * Calculates the velocity in the beginning
     */
    private void startVelocity() {
        velocity = -timeSinceSwitched / 2;
    }

    /**
     * Sees if enough time passed for the rebound method
     */
    private boolean delay() {
        return timeSinceSwitched > DELAY_FACTOR;
    }

    /**
     * Calculates the velocity of the ball so it looks like gravity.
     */
    private void calculateVelocity() {
        int speed = timeSinceSwitched / 2 - REBOUND_SPEED;
        if (speed > 11) {
            speed = 11;
        }
        if (dead) {
            speed = 0;
        }
        if (blue) {
            velocity = -speed;
        } else {
            velocity = speed;
        }
    }

    /**
     * Moves the ball with velocity
     */
    private void move() {
        setLocation(getX(), getY() + velocity);
    }

    /**
     * Plays a static sound if the ball dies
     * Makes the world make everything else die too
     */
    private void die() {
        if (!dead) {
            //so the sound only plays once
            STATIC_SOUND.play();
        }
        dead = true;
        ((Level) getWorld()).die();
    }

    /**
     * Changes the color of the ball and changes the
     * direction of movement
     */
    private void changeColor() {
        blue = !blue;
        if (blue) {
            setImage(BLUE_DIR);
        } else {
            setImage(ORANGE_DIR);
        }
        timeSinceSwitched = 0;
        justStarted = false;
    }
}
