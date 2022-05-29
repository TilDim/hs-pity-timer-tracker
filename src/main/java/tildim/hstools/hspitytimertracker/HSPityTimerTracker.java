package tildim.hstools.hspitytimertracker;

import tildim.hstools.hspitytimertracker.gui.TrackerGUI;
import tildim.hstools.hspitytimertracker.service.TrackerService;

/**
 * ~ Hearthstone Pity Timer Tracker ~
 * <p>
 * Helps you keep track of the pity timers in Hearthstone.
 * <p>
 * More info at the program's <a href="https://github.com/TilDim/hs-pity-timer-tracker">GitHub</a> page.
 *
 * @author Tilemachos Dimos
 */
public class HSPityTimerTracker {

    /**
     * Initializes the {@code TrackerService} with an instance of {@code TrackerGUI} as its argument.
     *
     * @param args (this program takes no command-line arguments)
     */
    public static void main(String[] args) {
        new TrackerService(new TrackerGUI());
    }
}
