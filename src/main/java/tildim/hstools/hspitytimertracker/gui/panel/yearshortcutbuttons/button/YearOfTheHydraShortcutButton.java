package tildim.hstools.hspitytimertracker.gui.panel.yearshortcutbuttons.button;

import java.io.Serial;
import tildim.hstools.hspitytimertracker.gui.panel.mode.WildModePanel;
import tildim.hstools.hspitytimertracker.gui.panel.year.YearOfTheHydraPanel;
import tildim.hstools.hspitytimertracker.gui.panel.yearshortcutbuttons.WildYearShortcutButtonsPanel;
import tildim.hstools.hspitytimertracker.util.Tooltips;
import tildim.hstools.hspitytimertracker.util.icon.IconPaths;

/**
 * {@code YearOfTheHydraShortcutButton} is a {@link #JButton} located in the {@code WildYearShortcutButtonsPanel}
 * that moves the scrollbar of the {@code WildModePanel} to the position of the {@code YearOfTheHydraPanel},
 * when pressed.
 *
 * @author Tilemachos Dimos
 * @see AbstractYearShortcutButton
 * @see WildYearShortcutButtonsPanel
 * @see WildModePanel
 * @see YearOfTheHydraPanel
 */
public class YearOfTheHydraShortcutButton extends AbstractYearShortcutButton {

    @Serial
    private static final long serialVersionUID = 5154385049389952839L;

    /**
     * Constructs a {@link #AbstractYearShortcutButton} with all the <i>Year of the Hydra</i> specific properties.
     */
    public YearOfTheHydraShortcutButton() {
        super(IconPaths.HYDRA_SHORTCUT_ICON_PATH, Tooltips.HYDRA_SHORTCUT_TOOLTIP);
    }

}
