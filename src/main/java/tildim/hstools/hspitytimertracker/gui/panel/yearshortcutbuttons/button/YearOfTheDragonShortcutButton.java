package tildim.hstools.hspitytimertracker.gui.panel.yearshortcutbuttons.button;

import tildim.hstools.hspitytimertracker.gui.panel.mode.WildModePanel;
import tildim.hstools.hspitytimertracker.gui.panel.year.YearOfTheDragonPanel;
import tildim.hstools.hspitytimertracker.gui.panel.yearshortcutbuttons.WildYearShortcutButtonsPanel;
import tildim.hstools.hspitytimertracker.util.Tooltips;
import tildim.hstools.hspitytimertracker.util.icon.IconPaths;

import java.io.Serial;

/**
 * {@code YearOfTheDragonShortcutButton} is a {@link #JButton} located in the {@code WildYearShortcutButtonsPanel}
 * that moves the scrollbar of the {@code WildModePanel} to the position of the {@code YearOfTheDragonPanel},
 * when pressed.
 *
 * @author Tilemachos Dimos
 * @see AbstractYearShortcutButton
 * @see WildYearShortcutButtonsPanel
 * @see WildModePanel
 * @see YearOfTheDragonPanel
 */
public class YearOfTheDragonShortcutButton extends AbstractYearShortcutButton {

    @Serial
    private static final long serialVersionUID = 293809122306760021L;

    /**
     * Constructs a {@link #AbstractYearShortcutButton} with all the <i>Year of the Dragon</i> specific properties.
     */
    public YearOfTheDragonShortcutButton() {
        super(IconPaths.DRAGON_SHORTCUT_ICON_PATH, Tooltips.DRAGON_SHORTCUT_TOOLTIP);
    }
}
