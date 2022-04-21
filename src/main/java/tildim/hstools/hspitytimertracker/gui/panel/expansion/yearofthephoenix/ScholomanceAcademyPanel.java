package tildim.hstools.hspitytimertracker.gui.panel.expansion.yearofthephoenix;

import tildim.hstools.hspitytimertracker.gui.panel.expansion.AbstractExpansionPanel;
import tildim.hstools.hspitytimertracker.util.Colors;
import tildim.hstools.hspitytimertracker.util.icon.IconPaths;

import java.io.Serial;

/**
 *
 */
public class ScholomanceAcademyPanel extends AbstractExpansionPanel {

    @Serial
    private static final long serialVersionUID = -8939192302387288996L;

    /**
     *
     */
    public ScholomanceAcademyPanel() {
        super(IconPaths.SCHOLOMANCE_EXPANSION_ICON_PATH, IconPaths.SCHOLOMANCE_CARD_PACK_ICON_PATH, Colors.SCHOLOMANCE_COLOR, Colors.TEXT_DARK_COLOR, Colors.MODIFIERS_DARK_COLORS);
    }
}
