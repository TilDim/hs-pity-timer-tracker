package tildim.hstools.hspitytimertracker.gui.panel.yearshortcutbuttons.button;

import java.io.Serial;
import tildim.hstools.hspitytimertracker.gui.panel.mode.WildModePanel;
import tildim.hstools.hspitytimertracker.gui.panel.year.Years1And2Panel;
import tildim.hstools.hspitytimertracker.gui.panel.yearshortcutbuttons.WildYearShortcutButtonsPanel;
import tildim.hstools.hspitytimertracker.util.Tooltips;
import tildim.hstools.hspitytimertracker.util.icon.IconPaths;

/**
 * {@code Years1And2ShortcutButton} is a {@link #JButton} located in the {@code WildYearShortcutButtonsPanel}
 * that moves the scrollbar of the {@code WildModePanel} to the position of the {@code Years1And2Panel},
 * when pressed.
 *
 * @author Tilemachos Dimos
 * @see AbstractYearShortcutButton
 * @see WildYearShortcutButtonsPanel
 * @see WildModePanel
 * @see Years1And2Panel
 */
public class Years1And2ShortcutButton extends AbstractYearShortcutButton {

    @Serial
    private static final long serialVersionUID = 8938875690503712477L;

    /**
     * Constructs a {@link #AbstractYearShortcutButton} with all the <i>Years 1 & 2</i> specific properties.
     */
    public Years1And2ShortcutButton() {
        super(IconPaths.YEARS1AND2_SHORTCUT_ICON_PATH, Tooltips.YEARS1AND2_SHORTCUT_TOOLTIP);
    }

}
