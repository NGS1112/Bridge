import queues.IQueue;
import queues.ArrayQueue;
import queues.LinkedQueue;

import trolls.ITroll;
import trolls.CuteTroll;
import trolls.BattleTroll;

import goats.IGoat;
import goats.CuteGoat;
import goats.BattleGoat;

/**
 * @author Bruce Herring
 *
 * Main class for the Goats Vs Troll demo. Creates the goats' queue,
 * the troll, and the bridge. Simulates the goats trying to cross
 * the bridge.

 * Usage: (Cute Version)   - java bridge
 *        (Battle Version) - java bridge <num goats>
 */
public class Bridge {
    private IQueue<IGoat> goatQueue;
    private ITroll troll;
    private enum GameType {
        CUTE, BATTLE
    }

    private final GameType type;
    private static final int CUTE_SIZE = 10;
    private static final int GOAT_MAX_POWER = 100;

    // The modifier should cause the troll to defeat 2/3rds of the goats
    // on average.
    private static final int TROLL_HP_MODIFIER = GOAT_MAX_POWER * 2 / 6;

    /**
     * Constructor for cute game bridge.
     */
    private Bridge ()
    {
        // Set the game type
        type = GameType.CUTE;
        // Create the Queue (Array based) to hold the goats
        goatQueue = new ArrayQueue<>();
        // Create the troll with hp based on the number of 
        // goats and the hp modifier.
        int trollHealth = TROLL_HP_MODIFIER*goatQueue.size();
        troll = new CuteTroll(trollHealth);
    }

    /**
     * Constructor for battle game bridge.
     * @param size Number of goats that are trying to cross the bridge.
     */
    private Bridge (int size) {
        // Set the game type
        type = GameType.BATTLE;
        // Create the Queue (Array based) to hold the goats
        goatQueue = new LinkedQueue<>();
        // Create the troll with hp based on the number of 
        // goats and the hp modifier.
        int trollHealth = TROLL_HP_MODIFIER*size;
        troll = new BattleTroll(trollHealth);
    }


    /**
     * Adds a goat to the waiting line for crossing the bridge.
     *
     * @param goat Name of the goat that will be added to the line
     */
    private void addGoat (IGoat goat) {
        goatQueue.enqueue(goat);
    }


    /**
     * Simulates goats trying to cross a bridge that is guarded by
     * a troll.
     */
    private void runSimulation () {
        System.out.println("Welcome to Goats Vs Troll - " + type + " Edition!");

        // While there are still goats waiting to cross.
        while (!goatQueue.isEmpty()) {


            // Get the first goat
            IGoat goat = goatQueue.front();
            goatQueue.dequeue();

            // Display the goat's approach conversation
            System.out.println(goat.approach());

            // If the troll is still active
            if (troll.isActive()) {

                System.out.println("A troll stands guard.");
                // Adjust the troll's power by the goat's impact amount
                troll.adjustPower(goat.impact());

                // If the troll survived the goat interaction ...
                if (troll.isActive()) {
                    // The troll displays its interaction conversation
                    troll.interact(goat);

                    // If the goat is still active after the troll interaction,
                    // add it to the back of the line to try again.
                    if (goat.isActive()) { goatQueue.enqueue(goat); }
                }
                // Else the troll is finished
                // Display the troll finished conversation.
                else { troll.finished(goat); }
            }
            // Else
            // Happy day, the troll has stopped guarding the bridge.
            else {
                System.out.println("The path is clear and " + goat.toString() + " crosses the bridge.");
            }
        }
        System.out.println("Simulation complete.");
    }

    /**
     * Main method. Creates the bridges, populates them with goats,
     * and runs the simulation.
     *
     * @param args Array of command line arguments.
     */
    public static void main (String[] args) {

        java.util.Random ran = new java.util.Random();
        
        // Based on the game type, execute the correct version.

        if (args.length == 1) {
            int size = Integer.parseInt(args[0]);

            Bridge myBridge = new Bridge(size);

            // For the battle version, give the goats string names.
            for (char c = 'A'; c < size + 'A'; c++) {
                int damage = ran.nextInt (GOAT_MAX_POWER);
                IGoat bg = new BattleGoat (c + "opsy", damage);
                myBridge.addGoat(bg);
            }

            myBridge.runSimulation();
        }
        else {
            Bridge myBridge = new Bridge ();

            // For the cute version, name the goats after integers.
            for (int i = 1; i <= CUTE_SIZE; i++) {
                int happiness = ran.nextInt (GOAT_MAX_POWER);
                IGoat cg = new CuteGoat (i, happiness);
                myBridge.addGoat(cg);
            }

            myBridge.runSimulation ();
        }

    }
}
