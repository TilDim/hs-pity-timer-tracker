package tildim.hstools.hspitytimertracker.gui.panel.expansion.yearofthephoenix;

import tildim.hstools.hspitytimertracker.gui.panel.expansion.AbstractExpansionPanel;
import tildim.hstools.hspitytimertracker.util.Colors;
import tildim.hstools.hspitytimertracker.util.icon.IconPaths;

import java.io.Serial;

/**
 *
 */
public class AshesOfOutlandPanel extends AbstractExpansionPanel {

    @Serial
    private static final long serialVersionUID = 4535033910241882340L;

    /**
     *
     */
    public AshesOfOutlandPanel() {
        super(IconPaths.OUTLAND_EXPANSION_ICON_PATH, IconPaths.OUTLAND_CARD_PACK_ICON_PATH, Colors.OUTLAND_COLOR, Colors.TEXT_DARK_COLOR, Colors.MODIFIERS_DARK_COLORS);
    }
}
