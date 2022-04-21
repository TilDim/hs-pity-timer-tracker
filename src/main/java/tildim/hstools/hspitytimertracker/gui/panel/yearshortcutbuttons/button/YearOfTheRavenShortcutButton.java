package tildim.hstools.hspitytimertracker.gui.panel.yearshortcutbuttons.button;

import tildim.hstools.hspitytimertracker.util.Tooltips;
import tildim.hstools.hspitytimertracker.util.icon.IconPaths;

import java.io.Serial;

/**
 *
 */
public class YearOfTheRavenShortcutButton extends AbstractYearShortcutButton {

    @Serial
    private static final long serialVersionUID = 6254002134210782425L;

    /**
     *
     */
    public YearOfTheRavenShortcutButton() {
        super(IconPaths.RAVEN_SHORTCUT_ICON_PATH, Tooltips.RAVEN_SHORTCUT_TOOLTIP);
    }
}
