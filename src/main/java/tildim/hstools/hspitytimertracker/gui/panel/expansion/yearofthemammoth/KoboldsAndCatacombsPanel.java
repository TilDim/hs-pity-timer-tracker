package tildim.hstools.hspitytimertracker.gui.panel.expansion.yearofthemammoth;

import tildim.hstools.hspitytimertracker.gui.panel.expansion.AbstractExpansionPanel;
import tildim.hstools.hspitytimertracker.util.Colors;
import tildim.hstools.hspitytimertracker.util.icon.IconPaths;

import java.io.Serial;

/**
 *
 */
public class KoboldsAndCatacombsPanel extends AbstractExpansionPanel {

    @Serial
    private static final long serialVersionUID = -1849767231307653370L;

    /**
     *
     */
    public KoboldsAndCatacombsPanel() {
        super(IconPaths.KOBOLDS_EXPANSION_ICON_PATH, IconPaths.KOBOLDS_CARD_PACK_ICON_PATH, Colors.KOBOLDS_COLOR, Colors.TEXT_COLOR, Colors.MODIFIERS_COLORS);
    }
}
