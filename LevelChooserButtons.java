import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * These buttons choose worlds. We're so good at polymorphism eh?
 *
 * @author Paulos Liu, Jun Lee
 */
public abstract class LevelChooserButtons extends Button {

    public LevelChooserButtons(String name) {
        super(name);
    }

    /**
     * These buttons change the world. So cool.
     */
    public void action() {
        setWorld();
    }

    /**
     * subclasses of button will override this method
     * all buttons will set the world back to their assigned level
     *
     * we're showing off our extensive knowledge of polymorphism and
     * abstract classes here
     */
    public abstract void setWorld();
}
