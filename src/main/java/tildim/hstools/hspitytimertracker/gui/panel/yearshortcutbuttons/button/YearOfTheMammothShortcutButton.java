package tildim.hstools.hspitytimertracker.gui.panel.yearshortcutbuttons.button;

import java.io.Serial;
import tildim.hstools.hspitytimertracker.gui.panel.mode.WildModePanel;
import tildim.hstools.hspitytimertracker.gui.panel.year.YearOfTheMammothPanel;
import tildim.hstools.hspitytimertracker.gui.panel.yearshortcutbuttons.WildYearShortcutButtonsPanel;
import tildim.hstools.hspitytimertracker.util.Tooltips;
import tildim.hstools.hspitytimertracker.util.icon.IconPaths;

/**
 * {@code YearOfTheMammothShortcutButton} is a {@link #JButton} located in the {@code WildYearShortcutButtonsPanel}
 * that moves the scrollbar of the {@code WildModePanel} to the position of the {@code YearOfTheMammothPanel},
 * when pressed.
 *
 * @author Tilemachos Dimos
 * @see AbstractYearShortcutButton
 * @see WildYearShortcutButtonsPanel
 * @see WildModePanel
 * @see YearOfTheMammothPanel
 */
public class YearOfTheMammothShortcutButton extends AbstractYearShortcutButton {

    @Serial
    private static final long serialVersionUID = -5880720186681552994L;

    /**
     * Constructs a {@link #AbstractYearShortcutButton} with all the <i>Year of the Mammoth</i> specific properties.
     */
    public YearOfTheMammothShortcutButton() {
        super(IconPaths.MAMMOTH_SHORTCUT_ICON_PATH, Tooltips.MAMMOTH_SHORTCUT_TOOLTIP);
    }

}
