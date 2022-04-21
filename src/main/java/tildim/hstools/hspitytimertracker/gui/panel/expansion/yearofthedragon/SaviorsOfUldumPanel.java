package tildim.hstools.hspitytimertracker.gui.panel.expansion.yearofthedragon;

import tildim.hstools.hspitytimertracker.gui.panel.expansion.AbstractExpansionPanel;
import tildim.hstools.hspitytimertracker.util.Colors;
import tildim.hstools.hspitytimertracker.util.icon.IconPaths;

import java.io.Serial;

/**
 *
 */
public class SaviorsOfUldumPanel extends AbstractExpansionPanel {

    @Serial
    private static final long serialVersionUID = -7489407411047314557L;

    /**
     *
     */
    public SaviorsOfUldumPanel() {
        super(IconPaths.ULDUM_EXPANSION_ICON_PATH, IconPaths.ULDUM_CARD_PACK_ICON_PATH, Colors.ULDUM_COLOR, Colors.TEXT_COLOR, Colors.MODIFIERS_COLORS);
    }
}
