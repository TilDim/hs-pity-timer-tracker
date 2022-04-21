package tildim.hstools.hspitytimertracker.gui.panel.expansion.yearofthemammoth;

import tildim.hstools.hspitytimertracker.gui.panel.expansion.AbstractExpansionPanel;
import tildim.hstools.hspitytimertracker.util.Colors;
import tildim.hstools.hspitytimertracker.util.icon.IconPaths;

import java.io.Serial;

/**
 *
 */
public class JourneyToUnGoroPanel extends AbstractExpansionPanel {

    @Serial
    private static final long serialVersionUID = -7912834609797310730L;

    /**
     *
     */
    public JourneyToUnGoroPanel() {
        super(IconPaths.UNGORO_EXPANSION_ICON_PATH, IconPaths.UNGORO_CARD_PACK_ICON_PATH, Colors.UNGORO_COLOR, Colors.TEXT_COLOR, Colors.MODIFIERS_COLORS);
    }
}
