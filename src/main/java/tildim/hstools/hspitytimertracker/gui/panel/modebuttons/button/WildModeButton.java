package tildim.hstools.hspitytimertracker.gui.panel.modebuttons.button;

import tildim.hstools.hspitytimertracker.util.Colors;
import tildim.hstools.hspitytimertracker.util.Text;
import tildim.hstools.hspitytimertracker.util.Tooltips;
import tildim.hstools.hspitytimertracker.util.icon.IconPaths;

import java.io.Serial;

/**
 *
 */
public class WildModeButton extends AbstractModeButton {

    @Serial
    private static final long serialVersionUID = 7801635731736774583L;

    /**
     *
     */
    public WildModeButton() {
        super(Text.WILD_TITLE, IconPaths.WILD_ICON_PATH, Colors.MODE_UNSELECTED_COLOR, Tooltips.WILD_TOOLTIP);

        addMouseListener(unselectedModeButtonAdapter);
    }
}
