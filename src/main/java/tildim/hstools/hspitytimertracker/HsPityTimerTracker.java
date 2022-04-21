/**
 * ~ Hearthstone Pity Timer Tracker ~
 *
 * @author Tilemachos Dimos
 * <p>
 * October 2020
 */

package tildim.hstools.hspitytimertracker;

import tildim.hstools.hspitytimertracker.gui.TrackerGUI;
import tildim.hstools.hspitytimertracker.service.TrackerService;

public class HsPityTimerTracker {

    public static void main(String[] args) {
        new TrackerService(new TrackerGUI());
    }
}
