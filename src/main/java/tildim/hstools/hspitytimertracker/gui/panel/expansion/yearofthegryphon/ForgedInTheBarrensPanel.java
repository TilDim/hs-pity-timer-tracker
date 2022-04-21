package tildim.hstools.hspitytimertracker.gui.panel.expansion.yearofthegryphon;

import tildim.hstools.hspitytimertracker.gui.panel.expansion.AbstractExpansionPanel;
import tildim.hstools.hspitytimertracker.util.Colors;
import tildim.hstools.hspitytimertracker.util.icon.IconPaths;

import java.io.Serial;

/**
 *
 */
public class ForgedInTheBarrensPanel extends AbstractExpansionPanel {

    @Serial
    private static final long serialVersionUID = 970484060814749589L;

    /**
     *
     */
    public ForgedInTheBarrensPanel() {
        super(IconPaths.BARRENS_EXPANSION_ICON_PATH, IconPaths.BARRENS_CARD_PACK_ICON_PATH, Colors.BARRENS_COLOR, Colors.TEXT_DARK_COLOR, Colors.MODIFIERS_DARK_COLORS);
    }
}
