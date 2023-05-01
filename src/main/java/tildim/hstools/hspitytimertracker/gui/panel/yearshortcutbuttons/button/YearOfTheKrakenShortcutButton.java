package tildim.hstools.hspitytimertracker.gui.panel.yearshortcutbuttons.button;

import java.io.Serial;
import tildim.hstools.hspitytimertracker.gui.panel.mode.WildModePanel;
import tildim.hstools.hspitytimertracker.gui.panel.year.YearOfTheKrakenPanel;
import tildim.hstools.hspitytimertracker.gui.panel.yearshortcutbuttons.WildYearShortcutButtonsPanel;
import tildim.hstools.hspitytimertracker.util.Tooltips;
import tildim.hstools.hspitytimertracker.util.icon.IconPaths;

/**
 * {@code YearOfTheKrakenShortcutButton} is a {@link #JButton} located in the {@code WildYearShortcutButtonsPanel}
 * that moves the scrollbar of the {@code WildModePanel} to the position of the {@code YearOfTheKrakenPanel},
 * when pressed.
 *
 * @author Tilemachos Dimos
 * @see AbstractYearShortcutButton
 * @see WildYearShortcutButtonsPanel
 * @see WildModePanel
 * @see YearOfTheKrakenPanel
 */
public class YearOfTheKrakenShortcutButton extends AbstractYearShortcutButton {

    @Serial
    private static final long serialVersionUID = -5751496151501244618L;

    /**
     * Constructs a {@link #AbstractYearShortcutButton} with all the <i>Year of the Kraken</i> specific properties.
     */
    public YearOfTheKrakenShortcutButton() {
        super(IconPaths.KRAKEN_SHORTCUT_ICON_PATH, Tooltips.KRAKEN_SHORTCUT_TOOLTIP);
    }

}
