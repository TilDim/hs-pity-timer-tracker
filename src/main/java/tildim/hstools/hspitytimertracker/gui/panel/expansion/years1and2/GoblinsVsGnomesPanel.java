package tildim.hstools.hspitytimertracker.gui.panel.expansion.years1and2;

import tildim.hstools.hspitytimertracker.gui.panel.expansion.AbstractExpansionPanel;
import tildim.hstools.hspitytimertracker.util.Colors;
import tildim.hstools.hspitytimertracker.util.icon.IconPaths;

import java.io.Serial;

/**
 *
 */
public class GoblinsVsGnomesPanel extends AbstractExpansionPanel {

    @Serial
    private static final long serialVersionUID = 4732663353018308770L;

    /**
     *
     */
    public GoblinsVsGnomesPanel() {
        super(IconPaths.GOBLINS_EXPANSION_ICON_PATH, IconPaths.GOBLINS_CARD_PACK_ICON_PATH, Colors.GOBLINS_COLOR, Colors.TEXT_COLOR, Colors.MODIFIERS_COLORS);
    }
}
