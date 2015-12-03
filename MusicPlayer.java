import greenfoot.*;
/**
 * Plays the bgm. Song created by the very talented Mark Yoon.
 * 
 * @author Paulos Liu
 */
public class MusicPlayer  
{
    public static int instances = 0;

    private static final GreenfootSound music =
        new GreenfootSound("sounds/cse8b.mp3");
    /**
     * Constructor for objects of class MusicPlayer
     */
    public MusicPlayer()
    {
        if(instances == 0){
            //so we only play one at a time
            instances++;
            music.playLoop(); 
        }
    }
}
