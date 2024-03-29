package tildim.hstools.hspitytimertracker.gui.panel.tracker;

import java.io.Serial;
import javax.swing.BoxLayout;
import javax.swing.JPanel;
import lombok.Getter;
import tildim.hstools.hspitytimertracker.gui.panel.header.HeaderPanel;
import tildim.hstools.hspitytimertracker.gui.panel.mode.AllModesPanel;
import tildim.hstools.hspitytimertracker.gui.panel.modebuttons.ModeButtonsPanel;
import tildim.hstools.hspitytimertracker.gui.panel.yearshortcutbuttons.AllYearShortcutButtonsPanel;

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

        headerPanel = new HeaderPanel();
        modeButtonsPanel = new ModeButtonsPanel();
        allYearShortcutButtonsPanel = new AllYearShortcutButtonsPanel();
        allModesPanel = new AllModesPanel();

        add(headerPanel);
        add(modeButtonsPanel);
        add(allYearShortcutButtonsPanel);
        add(allModesPanel);
    }

}
