import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

import java.util.ArrayList;
import java.util.Scanner;
import java.io.*;

/**
 * Write a description of class MyWorld here.
 *
 * @author Paulos Liu
 * @version 0.0.1
 */
public class Level extends World {
    public static final int SIZE = 600;

    private static int easyHighScore;
    private static int medHighScore;
    private static int hardHighScore;
    private static final File scores = new File("scores.txt");

    private int currentScore;
    private Spawner spawner;
    private Menu menu;
    private Logo logo;

    private int difficulty;
    // 0 is easy, 1 is med, 2 is hard

    /**
     * Creates a level with the start menu and with medium difficulty
     */
    public Level() {
        super(SIZE, SIZE, 1);

        new MusicPlayer();

        currentScore = 0;
        difficulty = 1;
        spawner = new Spawner(difficulty);
        logo = new Logo();

        menu = new MainMenu();
        menu.makeButtons(this);

        addPermanentObjects();
        readScoresSafely();

        addObject(logo, SIZE * 2 / 3, SIZE / 3);

        GameObject.SPEED = 4;
    }

    /**
     * Creates a level that instantly starts with the defined difficulty
     *
     * @param levelNumber The difficulty
     */
    public Level(int levelNumber) {
        super(SIZE, SIZE, 1);

        new MusicPlayer();

        currentScore = 0;
        this.difficulty = levelNumber;

        spawner = new Spawner(levelNumber);
        addPermanentObjects();
        startGame();

        GameObject.SPEED = 4;
    }

    /**
     * Removes the current menu (there is only one at a time, hopefully)
     */
    public void removeMenu() {
        removeObjects(menu.getButtons());
    }

    /**
     * Returns the difficulty level
     *
     * @return The difficulty level
     */
    public int getDifficulty() {
        return difficulty;
    }

    public String getDifficultyName() {
        switch (difficulty) {
            case 0:
                return "Easy";
            case 1:
                return "Medium";
            case 2:
                return "Hard";
        }
        return null;
    }

    /**
     * Gets the current menu
     **/
    public Menu getMenu() {
        return menu;
    }

    /**
     * Sets the menu to the one provided
     *
     * @param menu The new menu
     */
    public void setMenu(Menu menu) {
        this.menu = menu;
    }

    /**
     * Stops all objects, updates the high score, and makes a dead menu
     */
    public void die() {
        GameObject.SPEED = 0;
        removeObject(spawner);
        updateHighScore();
        saveScores();
        menu = new DeadMenu();
        menu.makeButtons(this);
    }

    /**
     * Adds a ball, and two walls
     */
    public void addPermanentObjects() {
        addObject(new Ball(), SIZE * 7 / 24, SIZE / 2);
        addObject(new Wall("orange"), SIZE / 2, 0);
        addObject(new Wall("blue"), SIZE / 2, SIZE);
    }

    /**
     * Starts the game and removes previous objects
     */
    public void startGameRemoveEverything() {
        startGame();
        removeMenu();
        removeObject(logo);
    }

    /**
     * Starts the game by adding a spawner and a scorekeeper
     */
    public void startGame() {
        addObject(new Score(), 50, 14);
        addObject(spawner, 0, 0);
    }

    /**
     * Returns current score
     *
     * @return current score
     */
    public int getCurrentScore() {
        return currentScore;
    }

    /**
     * adds one to the current score
     */
    public void incrementCurrentScore() {
        currentScore++;
    }

    /**
     * Updates the high score if the current score is larger
     */
    private void updateHighScore() {
        switch (difficulty) {
            case 0:
                easyHighScore = Math.max(easyHighScore, currentScore);
                break;
            case 1:
                medHighScore = Math.max(medHighScore, currentScore);
                break;
            case 2:
                hardHighScore = Math.max(hardHighScore, currentScore);
                break;
        }
    }

    /**
     * Gets the high score in the current difficulty
     *
     * @return high score in the current difficulty
     */
    public int getCurrentHighScore() {
        switch (difficulty) {
            case 0:
                return easyHighScore;
            case 1:
                return medHighScore;
            case 2:
                return hardHighScore;
        }
        return 0;
    }

    /**
     * Reads scores from scores.txt
     * if scores.txt doesn't exits, then it creates scores.txt
     * with high scores = 0
     */
    private void readScoresSafely() {
        try {
            readScores();
        } catch (IOException e) {
            makeNewFile();
        }
    }

    /**
     * Creates a new scores.txt if one isn't found
     */
    private void makeNewFile(){
        try {
            PrintWriter emptyDatabase = new PrintWriter(scores);
            emptyDatabase.println("0");
            emptyDatabase.println("0");
            emptyDatabase.println("0");
            emptyDatabase.close();
        } catch (Exception e){
            System.err.print("Error 222: donezo");
        }
    }

    /**
     * Reads the high scores from scores.txt
     * @throws IOException Dies if the file isn't there
     */
    private void readScores() throws IOException {
        Scanner scoreReader = new Scanner(scores);
        int counter = 0;
        while (scoreReader.hasNext()) {
            if (counter == 0) {
                easyHighScore = scoreReader.nextInt();
            } else if (counter == 1) {
                medHighScore = scoreReader.nextInt();
            } else if (counter == 2) {
                hardHighScore = scoreReader.nextInt();
            }
            counter++;
        }
    }

    /**
     * Saves the high scores to a new scores.txt
     * (scores.txt is overwritten)
     */
    private void saveScores() {
        try {
            scores.delete();
            if (scores == null) {
                scores.createNewFile();
            }
            PrintWriter scoreWriter = new PrintWriter(scores);
            scoreWriter.println("" + easyHighScore);
            scoreWriter.println("" + medHighScore);
            scoreWriter.println("" + hardHighScore);
            scoreWriter.close();
        } catch (IOException e) {
            System.err.println("Error 163. Go demand a refund or something");
        }
    }
}
