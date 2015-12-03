import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.awt.Color;
/**
 * Shows the current score
 * 
 * @author Paulos Liu
 */
public class Score extends Actor
{
    public static final int REGULAR_TEXT = 25;
    public static final int HIGH_TEXT = 50;

    private boolean act;

    /**
     * Creates a score shower for the current score
     */
    public Score()
    {
        act = true;
    }

    /**
     * Creates score shower for the high score
     * @param level the difficulty of the game
     */
    public Score(Level level){
        int highScore = level.getCurrentHighScore();
        String levelName = level.getDifficultyName();

        String text = levelName + " High Score: ";
        setImage(makeImage(text, highScore, HIGH_TEXT));
        act = false;
    }

    /**
     * Only used by the current score Score instances
     */
    public void act()
    {
        if(act){
            Level level = (Level)getWorld();
            setRegularImage(level.getCurrentScore());
        }
    }

    /**
     * Creates an image for itself
     * @param text The prefix ("High Score: " or something)
     * @param score The actualy number for the score
     * @param size The text size
     * @return The image with all these parameters
     */
    private GreenfootImage makeImage(String text, int score, int size){
        return new GreenfootImage(text+score, size, Color.WHITE, new Color(0, 0, 0, 0));
    }

    /**
     * Sets the image for the current score
     * @param score the number for the score
     */
    private void setRegularImage(int score){
        setImage(makeImage("Score: ", score, REGULAR_TEXT));
    }
}
