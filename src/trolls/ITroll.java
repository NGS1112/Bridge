package trolls;

import goats.IGoat;

/**
 * @author Nicholas Shinn
 * Interface for troll character
 */

public interface ITroll {
    /**
     * Troll conversation when goat approaches
     *
     * @param goat approaching goat
     */
    void interact(IGoat goat);

    /**
     * Changes the health/happiness of troll
     *
     * @param num damage/happiness inflicted
     */
    void adjustPower(int num);

    /**
     * Displays finished conversation when troll is beat
     *
     * @param goat finishing goat
     */
    void finished(IGoat goat);

    /**
     * Checks if troll is still active
     *
     * @return true if active, otherwise false
     */
    boolean isActive();

}
