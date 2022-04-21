package tildim.hstools.hspitytimertracker.gui.panel.yearshortcutbuttons.button;

import tildim.hstools.hspitytimertracker.util.Tooltips;
import tildim.hstools.hspitytimertracker.util.icon.IconPaths;

import java.io.Serial;

/**
 *
 */
public class YearOfTheHydraShortcutButton extends AbstractYearShortcutButton {

    @Serial
    private static final long serialVersionUID = 5154385049389952839L;

    /**
     *
     */
    public YearOfTheHydraShortcutButton() {
        super(IconPaths.HYDRA_SHORTCUT_ICON_PATH, Tooltips.HYDRA_SHORTCUT_TOOLTIP);
    }
}
