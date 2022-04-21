package tildim.hstools.hspitytimertracker.gui.panel.yearshortcutbuttons.button;

import tildim.hstools.hspitytimertracker.util.Tooltips;
import tildim.hstools.hspitytimertracker.util.icon.IconPaths;

import java.io.Serial;

/**
 *
 */
public class YearOfTheMammothShortcutButton extends AbstractYearShortcutButton {

    @Serial
    private static final long serialVersionUID = -5880720186681552994L;

    /**
     *
     */
    public YearOfTheMammothShortcutButton() {
        super(IconPaths.MAMMOTH_SHORTCUT_ICON_PATH, Tooltips.MAMMOTH_SHORTCUT_TOOLTIP);
    }
}
