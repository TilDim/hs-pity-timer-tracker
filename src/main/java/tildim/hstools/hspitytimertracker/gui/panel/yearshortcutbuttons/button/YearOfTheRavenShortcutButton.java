package tildim.hstools.hspitytimertracker.gui.panel.yearshortcutbuttons.button;

import tildim.hstools.hspitytimertracker.gui.panel.mode.WildModePanel;
import tildim.hstools.hspitytimertracker.gui.panel.year.YearOfTheRavenPanel;
import tildim.hstools.hspitytimertracker.gui.panel.yearshortcutbuttons.WildYearShortcutButtonsPanel;
import tildim.hstools.hspitytimertracker.util.Tooltips;
import tildim.hstools.hspitytimertracker.util.icon.IconPaths;

import java.io.Serial;

/**
 * {@code YearOfTheRavenShortcutButton} is a {@link #JButton} located in the {@code WildYearShortcutButtonsPanel}
 * that moves the scrollbar of the {@code WildModePanel} to the position of the {@code YearOfTheRavenPanel},
 * when pressed.
 *
 * @author Tilemachos Dimos
 * @see AbstractYearShortcutButton
 * @see WildYearShortcutButtonsPanel
 * @see WildModePanel
 * @see YearOfTheRavenPanel
 */
public class YearOfTheRavenShortcutButton extends AbstractYearShortcutButton {

    @Serial
    private static final long serialVersionUID = 6254002134210782425L;

    /**
     * Constructs a {@link #AbstractYearShortcutButton} with all the <i>Year of the Raven</i> specific properties.
     */
    public YearOfTheRavenShortcutButton() {
        super(IconPaths.RAVEN_SHORTCUT_ICON_PATH, Tooltips.RAVEN_SHORTCUT_TOOLTIP);
    }
}
