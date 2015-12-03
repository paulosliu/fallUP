import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

import java.util.ArrayList;

/**
 * Write a description of class Spawner here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Spawner extends GameObject {
    private static final int DELAY = 70;
    private static final int BUFFER = 31;

    /*for both rectangles and bombs */
    private static final int SPAWN_X = 650;

    /* for generating rectangles */
    private static final int GAP_MIN = 90;
    private static final int GAP_MAX = 170;
    private static final int MIN_SIZE = 25;

    /* for generating bombs */
    private static final int TWO_GAP = 190;
    private static final int THREE_GAP = 142;

    private int counter;
    private int chances;

    public Spawner() {
        this(2);
    }

    public Spawner(int difficulty) {
        setImage(new GreenfootImage(1, 1));
        //makes an invisible actor
        counter = 0;
        //counts and compared to the DELAY to spawn evil objects
        switch (difficulty) {
            case 0:
                // easy = 100% chances of bombs
                chances = 1;
                break;
            case 1:
                // medium = 1/7 chance of bombs
                chances = 7;
                break;
            case 2:
                // hard = almost 0 chance of bombs
                chances = Integer.MAX_VALUE;
        }
    }

    /**
     * Creates either rectangles or bombs every DELAY iterations
     */
    public void act() {
        if (counter % DELAY == 0) {
            generateObjects();
        }
        counter++;
    }

    /**
     * Has a 1/CHANCE chance of generating a bombs.
     */
    private void generateObjects() {
        int objectChooser = (int) (Math.random() * chances);
        if (objectChooser == 0) {
            generateBombs();
        } else {
            generateRectangles();
        }
    }

    /**
     * Generates the number of bombs and uses createBombs()
     */
    private void generateBombs() {
        Level level = (Level) getWorld();
        int numberOfBombs = 2 + (int) (Math.random() * 2);
        //generates 2 or 3 bombs
        if (numberOfBombs == 2) {
            createBombs(numberOfBombs, TWO_GAP);
        } else {
            createBombs(numberOfBombs, THREE_GAP);
        }
    }

    /**
     * Creates the bombs
     *
     * @param num number of bombs
     * @param gap gap betweeen bombs
     */
    private void createBombs(int num, int gap) {
        World world = getWorld();
        for (int x = 1; x <= num; x++) {
            boolean first = x == 1;
            Bomb bomb = new Bomb(first);
            world.addObject(bomb, SPAWN_X, BUFFER / 2 + x * gap);
        }
    }

    /**
     * Generates the rectangles
     */
    private void generateRectangles() {
        Level level = (Level) getWorld();

        /* Generate random gap size and random middle index */
        int gap = generateRandomNumber(GAP_MIN, GAP_MAX);
        int halfGap = gap / 2;
        int middle = generateRandomNumber(gap + BUFFER, level.SIZE - BUFFER - gap);

        /* generate the sizes and the places the rectangles will go */
        int topSize = middle - halfGap - BUFFER;
        int topY = topSize / 2 + BUFFER;

        int bottomSize = level.SIZE - middle - halfGap - BUFFER;
        int bottomY = (2 * level.SIZE - bottomSize) / 2 - BUFFER;

        /* Add the rectangles if they're big enough */
        if (topSize > MIN_SIZE) {
            level.addObject(new Rectangle(topSize, true), SPAWN_X, topY);
        }
        if (bottomSize > MIN_SIZE){
            level.addObject(new Rectangle(bottomSize, false), SPAWN_X, bottomY);
        }
    }
}

