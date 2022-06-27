package trolls;

import goats.IGoat;

/**
 * @author Nicholas Shinn
 *
 * Class for implementing battle version of troll
 */
public class BattleTroll implements ITroll {
    //Health points for troll
    private int HP;

    //Tracks if troll is still active
    private boolean active = true;

    /**
     * Creates BattleTroll
     *
     * @param HP Battle troll's health
     */
    public BattleTroll(int HP){
        this.HP = HP;
    }

    /**
     * Displays troll interact message, removes goat from queue
     *
     * @param goat approaching goat
     */
    public void interact(IGoat goat){
        System.out.println("The troll devours " + goat.toString() + "!");
        goat.setActive(false);
    }

    /**
     * Adjusts the health of the troll
     *
     * @param num damage/happiness inflicted
     */
    public void adjustPower(int num){
        HP -= num;
        if(HP<=0){
            active = false;
        }
    }

    /**
     * Displays troll's finishing conversation
     *
     * @param goat finishing goat
     */
    public void finished(IGoat goat){
        System.out.println("The troll is exterminated by " + goat.toString() + "!");
    }

    /**
     * Checks if troll is active
     *
     * @return true if active, false otherwise
     */
    public boolean isActive(){
        return active;
    }
}
