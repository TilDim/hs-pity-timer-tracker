package tildim.hstools.hspitytimertracker.gui.panel.tracker;

import lombok.Getter;
import tildim.hstools.hspitytimertracker.gui.panel.header.HeaderPanel;
import tildim.hstools.hspitytimertracker.gui.panel.mode.AllModesPanel;
import tildim.hstools.hspitytimertracker.gui.panel.modebuttons.ModeButtonsPanel;
import tildim.hstools.hspitytimertracker.gui.panel.yearshortcutbuttons.AllYearShortcutButtonsPanel;

import javax.swing.*;
import java.io.Serial;

/**
 * {@code TrackerPanel} is a {@link #JPanel} that contains the program's main sub-panels.
 *
 * @author Tilemachos Dimos
 * @see HeaderPanel
 * @see ModeButtonsPanel
 * @see AllYearShortcutButtonsPanel
 * @see AllModesPanel
 */
@Getter
public class TrackerPanel extends JPanel {

    @Serial
    private static final long serialVersionUID = 7403028887884226194L;

    private final HeaderPanel headerPanel;

    private final ModeButtonsPanel modeButtonsPanel;

    private final AllYearShortcutButtonsPanel allYearShortcutButtonsPanel;

    private final AllModesPanel allModesPanel;

    /**
     * Constructs a {@link #JPanel}, sets its layout and places in it:
     * <ul>
     *     <li>
     *         a {@code HeaderPanel};
     *     </li>
     *     <li>
     *         a {@code ModeButtonsPanel};
     *     </li>
     *     <li>
     *         a {@code AllYearShortcutButtonsPanel};
     *     </li>
     *     <li>
     *         a {@code AllModesPanel}.
     *     </li>
     * </ul>
     */
    public TrackerPanel() {
        super();

        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

        // Header panel
        headerPanel = new HeaderPanel();

        // Mode buttons panel
        modeButtonsPanel = new ModeButtonsPanel();

        // All year shortcut buttons panel
        allYearShortcutButtonsPanel = new AllYearShortcutButtonsPanel();

        // All modes panel
        allModesPanel = new AllModesPanel();

        add(headerPanel);
        add(modeButtonsPanel);
        add(allYearShortcutButtonsPanel);
        add(allModesPanel);
    }
}
