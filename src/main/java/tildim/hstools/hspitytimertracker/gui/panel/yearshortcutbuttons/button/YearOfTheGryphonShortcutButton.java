package tildim.hstools.hspitytimertracker.gui.panel.yearshortcutbuttons.button;

import tildim.hstools.hspitytimertracker.util.Tooltips;
import tildim.hstools.hspitytimertracker.util.icon.IconPaths;

import java.io.Serial;

/**
 *
 */
public class YearOfTheGryphonShortcutButton extends AbstractYearShortcutButton {

    @Serial
    private static final long serialVersionUID = -7269471652731708332L;

    /**
     *
     */
    public YearOfTheGryphonShortcutButton() {
        super(IconPaths.GRYPHON_SHORTCUT_ICON_PATH, Tooltips.GRYPHON_SHORTCUT_TOOLTIP);
    }
}
