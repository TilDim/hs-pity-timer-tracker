package tildim.hstools.hspitytimertracker.gui.panel.expansion.yearofthedragon;

import tildim.hstools.hspitytimertracker.gui.panel.expansion.AbstractExpansionPanel;
import tildim.hstools.hspitytimertracker.util.Colors;
import tildim.hstools.hspitytimertracker.util.icon.IconPaths;

import java.io.Serial;

/**
 *
 */
public class DescentOfDragonsPanel extends AbstractExpansionPanel {

    @Serial
    private static final long serialVersionUID = -7671788530812981730L;

    /**
     *
     */
    public DescentOfDragonsPanel() {
        super(IconPaths.DRAGONS_EXPANSION_ICON_PATH, IconPaths.DRAGONS_CARD_PACK_ICON_PATH, Colors.DRAGONS_COLOR, Colors.TEXT_COLOR, Colors.MODIFIERS_COLORS);
    }
}
