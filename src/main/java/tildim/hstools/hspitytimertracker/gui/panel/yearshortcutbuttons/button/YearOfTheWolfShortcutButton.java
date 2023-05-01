package tildim.hstools.hspitytimertracker.gui.panel.yearshortcutbuttons.button;

import java.io.Serial;
import tildim.hstools.hspitytimertracker.gui.panel.mode.StandardModePanel;
import tildim.hstools.hspitytimertracker.gui.panel.year.YearOfTheWolfPanel;
import tildim.hstools.hspitytimertracker.gui.panel.yearshortcutbuttons.StandardYearShortcutButtonsPanel;
import tildim.hstools.hspitytimertracker.util.Tooltips;
import tildim.hstools.hspitytimertracker.util.icon.IconPaths;

/**
 * {@code YearOfTheWolfShortcutButton} is a {@link #JButton} located in the {@code StandardYearShortcutButtonsPanel}
 * that moves the scrollbar of the {@code StandardModePanel} to the position of the {@code YearOfTheWolfPanel},
 * when pressed.
 *
 * @author Tilemachos Dimos
 * @see AbstractYearShortcutButton
 * @see StandardYearShortcutButtonsPanel
 * @see StandardModePanel
 * @see YearOfTheWolfPanel
 */
public class YearOfTheWolfShortcutButton extends AbstractYearShortcutButton {

    @Serial
    private static final long serialVersionUID = 8389079423502458897L;

    /**
     * Constructs a {@link #AbstractYearShortcutButton} with all the <i>Year of the Wolf</i> specific properties.
     */
    public YearOfTheWolfShortcutButton() {
        super(IconPaths.WOLF_SHORTCUT_ICON_PATH, Tooltips.WOLF_SHORTCUT_TOOLTIP);
    }

}
