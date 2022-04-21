package tildim.hstools.hspitytimertracker.gui.panel.yearshortcutbuttons.button;

import tildim.hstools.hspitytimertracker.util.Tooltips;
import tildim.hstools.hspitytimertracker.util.icon.IconPaths;

import java.io.Serial;

/**
 *
 */
public class YearOfTheDragonShortcutButton extends AbstractYearShortcutButton {

    @Serial
    private static final long serialVersionUID = 293809122306760021L;

    /**
     *
     */
    public YearOfTheDragonShortcutButton() {
        super(IconPaths.DRAGON_SHORTCUT_ICON_PATH, Tooltips.DRAGON_SHORTCUT_TOOLTIP);
    }
}
