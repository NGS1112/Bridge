package trolls;

import goats.IGoat;

/**
 * @author Nicholas Shinn
 *
 * Implementation of CuteTroll
 */
public class CuteTroll implements ITroll {
    //Maximum happiness troll can reach
    private final int maxHappy;

    //Current happiness for troll
    private int happiness;

    //Tracks if troll is active
    private boolean active = true;

    /**
     * Creates troll for cute game type
     *
     * @param maxHappy maximum happiness troll can reach
     */
    public CuteTroll(int maxHappy){
        this.maxHappy = maxHappy;
    }

    /**
     * Displays troll interact conversation
     *
     * @param goat approaching goat
     */
    public void interact(IGoat goat){
        System.out.println("The troll pets " + goat.toString());
    }

    /**
     * Adjusts troll happiness based on happiness from goat
     *
     * @param num damage/happiness inflicted
     */
    public void adjustPower(int num){
        happiness += num;
        if(happiness>=maxHappy){
            active = false;
        }
    }

    /**
     * Displays troll finishing conversation
     *
     * @param goat finishing goat
     */
    public void finished(IGoat goat){
        System.out.println("The troll falls asleep after petting " + goat.toString());
    }

    /**
     * Checks if troll is still active
     *
     * @return true if active, false otherwise
     */
    public boolean isActive(){
        return active;
    }
}
