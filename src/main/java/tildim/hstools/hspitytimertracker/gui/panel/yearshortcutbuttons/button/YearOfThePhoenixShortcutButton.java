package tildim.hstools.hspitytimertracker.gui.panel.yearshortcutbuttons.button;

import java.io.Serial;
import tildim.hstools.hspitytimertracker.gui.panel.mode.WildModePanel;
import tildim.hstools.hspitytimertracker.gui.panel.year.YearOfThePhoenixPanel;
import tildim.hstools.hspitytimertracker.gui.panel.yearshortcutbuttons.WildYearShortcutButtonsPanel;
import tildim.hstools.hspitytimertracker.util.Tooltips;
import tildim.hstools.hspitytimertracker.util.icon.IconPaths;

/**
 * {@code YearOfThePhoenixShortcutButton} is a {@link #JButton} located in the {@code WildYearShortcutButtonsPanel}
 * that moves the scrollbar of the {@code WildModePanel} to the position of the {@code YearOfThePhoenixPanel},
 * when pressed.
 *
 * @author Tilemachos Dimos
 * @see AbstractYearShortcutButton
 * @see WildYearShortcutButtonsPanel
 * @see WildModePanel
 * @see YearOfThePhoenixPanel
 */
public class YearOfThePhoenixShortcutButton extends AbstractYearShortcutButton {

    @Serial
    private static final long serialVersionUID = -4263026835747312567L;

    /**
     * Constructs a {@link #AbstractYearShortcutButton} with all the <i>Year of the Phoenix</i> specific properties.
     */
    public YearOfThePhoenixShortcutButton() {
        super(IconPaths.PHOENIX_SHORTCUT_ICON_PATH, Tooltips.PHOENIX_SHORTCUT_TOOLTIP);
    }

}
