package tildim.hstools.hspitytimertracker.gui.panel.expansion.yearoftheraven;

import tildim.hstools.hspitytimertracker.gui.panel.expansion.AbstractExpansionPanel;
import tildim.hstools.hspitytimertracker.util.Colors;
import tildim.hstools.hspitytimertracker.util.icon.IconPaths;

import java.io.Serial;

/**
 *
 */
public class TheBoomsdayProjectPanel extends AbstractExpansionPanel {

    @Serial
    private static final long serialVersionUID = -9055816168487537718L;

    /**
     *
     */
    public TheBoomsdayProjectPanel() {
        super(IconPaths.BOOMSDAY_EXPANSION_ICON_PATH, IconPaths.BOOMSDAY_CARD_PACK_ICON_PATH, Colors.BOOMSDAY_COLOR, Colors.TEXT_DARK_COLOR, Colors.MODIFIERS_DARK_COLORS);
    }
}
