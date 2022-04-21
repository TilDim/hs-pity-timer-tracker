package tildim.hstools.hspitytimertracker.gui.panel.expansion.yearofthemammoth;

import tildim.hstools.hspitytimertracker.gui.panel.expansion.AbstractExpansionPanel;
import tildim.hstools.hspitytimertracker.util.Colors;
import tildim.hstools.hspitytimertracker.util.icon.IconPaths;

import java.io.Serial;

/**
 *
 */
public class KnightsOfTheFrozenThronePanel extends AbstractExpansionPanel {

    @Serial
    private static final long serialVersionUID = 7605709907104558272L;

    /**
     *
     */
    public KnightsOfTheFrozenThronePanel() {
        super(IconPaths.KNIGHTS_EXPANSION_ICON_PATH, IconPaths.KNIGHTS_CARD_PACK_ICON_PATH, Colors.KNIGHTS_COLOR, Colors.TEXT_COLOR, Colors.MODIFIERS_COLORS);
    }
}
