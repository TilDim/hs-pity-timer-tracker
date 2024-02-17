package tildim.hstools.hspitytimertracker.gui.panel.yearshortcutbuttons.button;

import java.io.Serial;
import tildim.hstools.hspitytimertracker.gui.panel.mode.StandardModePanel;
import tildim.hstools.hspitytimertracker.gui.panel.year.YearOfThePegasusPanel;
import tildim.hstools.hspitytimertracker.gui.panel.yearshortcutbuttons.StandardYearShortcutButtonsPanel;
import tildim.hstools.hspitytimertracker.util.Tooltips;
import tildim.hstools.hspitytimertracker.util.icon.IconPaths;

/**
 * {@code YearOfThePegasusShortcutButton} is a {@link #JButton} located in the {@code StandardYearShortcutButtonsPanel}
 * that moves the scrollbar of the {@code StandardModePanel} to the position of the {@code YearOfThePegasusPanel},
 * when pressed.
 *
 * @author Tilemachos Dimos
 * @see AbstractYearShortcutButton
 * @see StandardYearShortcutButtonsPanel
 * @see StandardModePanel
 * @see YearOfThePegasusPanel
 */
public class YearOfThePegasusShortcutButton extends AbstractYearShortcutButton {

    @Serial
    private static final long serialVersionUID = -4624281707816194687L;

    /**
     * Constructs a {@link #AbstractYearShortcutButton} with all the <i>Year of the Pegasus</i> specific properties.
     */
    public YearOfThePegasusShortcutButton() {
        super(IconPaths.PEGASUS_SHORTCUT_ICON_PATH, Tooltips.PEGASUS_SHORTCUT_TOOLTIP);
    }

}
