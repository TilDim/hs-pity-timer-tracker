package tildim.hstools.hspitytimertracker.gui.panel.yearshortcutbuttons.button;

import tildim.hstools.hspitytimertracker.gui.panel.mode.StandardModePanel;
import tildim.hstools.hspitytimertracker.gui.panel.year.YearOfTheGryphonPanel;
import tildim.hstools.hspitytimertracker.gui.panel.yearshortcutbuttons.StandardYearShortcutButtonsPanel;
import tildim.hstools.hspitytimertracker.util.Tooltips;
import tildim.hstools.hspitytimertracker.util.icon.IconPaths;

import java.io.Serial;

/**
 * {@code YearOfTheGryphonShortcutButton} is a {@link #JButton} located in the {@code StandardYearShortcutButtonsPanel}
 * that moves the scrollbar of the {@code StandardModePanel} to the position of the {@code YearOfTheGryphonPanel},
 * when pressed.
 *
 * @author Tilemachos Dimos
 * @see AbstractYearShortcutButton
 * @see StandardYearShortcutButtonsPanel
 * @see StandardModePanel
 * @see YearOfTheGryphonPanel
 */
public class YearOfTheGryphonShortcutButton extends AbstractYearShortcutButton {

    @Serial
    private static final long serialVersionUID = -7269471652731708332L;

    /**
     * Constructs a {@link #AbstractYearShortcutButton} with all the <i>Year of the Gryphon</i> specific properties.
     */
    public YearOfTheGryphonShortcutButton() {
        super(IconPaths.GRYPHON_SHORTCUT_ICON_PATH, Tooltips.GRYPHON_SHORTCUT_TOOLTIP);
    }
}
