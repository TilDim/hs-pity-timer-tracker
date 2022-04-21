package tildim.hstools.hspitytimertracker.gui.panel.expansion.yearofthegryphon;

import tildim.hstools.hspitytimertracker.gui.panel.expansion.AbstractExpansionPanel;
import tildim.hstools.hspitytimertracker.util.Colors;
import tildim.hstools.hspitytimertracker.util.icon.IconPaths;

import java.io.Serial;

/**
 *
 */
public class UnitedInStormwindPanel extends AbstractExpansionPanel {

    @Serial
    private static final long serialVersionUID = -8532363298371126011L;

    /**
     *
     */
    public UnitedInStormwindPanel() {
        super(IconPaths.STORMWIND_EXPANSION_ICON_PATH, IconPaths.STORMWIND_CARD_PACK_ICON_PATH, Colors.STORMWIND_COLOR, Colors.TEXT_DARK_COLOR, Colors.MODIFIERS_DARK_COLORS);
    }
}
