package tildim.hstools.hspitytimertracker.gui.panel.expansion.yearofthegryphon;

import tildim.hstools.hspitytimertracker.gui.panel.expansion.AbstractExpansionPanel;
import tildim.hstools.hspitytimertracker.util.Colors;
import tildim.hstools.hspitytimertracker.util.icon.IconPaths;

import java.io.Serial;

/**
 *
 */
public class FracturedInAlteracValleyPanel extends AbstractExpansionPanel {

    @Serial
    private static final long serialVersionUID = 5225690784576420659L;

    /**
     *
     */
    public FracturedInAlteracValleyPanel() {
        super(IconPaths.ALTERAC_EXPANSION_ICON_PATH, IconPaths.ALTERAC_CARD_PACK_ICON_PATH, Colors.ALTERAC_COLOR, Colors.TEXT_COLOR, Colors.MODIFIERS_COLORS);
    }
}
