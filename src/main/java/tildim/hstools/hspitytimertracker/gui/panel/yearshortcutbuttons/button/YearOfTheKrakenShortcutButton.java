package tildim.hstools.hspitytimertracker.gui.panel.yearshortcutbuttons.button;

import tildim.hstools.hspitytimertracker.util.Tooltips;
import tildim.hstools.hspitytimertracker.util.icon.IconPaths;

import java.io.Serial;

/**
 *
 */
public class YearOfTheKrakenShortcutButton extends AbstractYearShortcutButton {

    @Serial
    private static final long serialVersionUID = -5751496151501244618L;

    /**
     *
     */
    public YearOfTheKrakenShortcutButton() {
        super(IconPaths.KRAKEN_SHORTCUT_ICON_PATH, Tooltips.KRAKEN_SHORTCUT_TOOLTIP);
    }
}
