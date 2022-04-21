package tildim.hstools.hspitytimertracker.gui.panel.expansion.years1and2;

import tildim.hstools.hspitytimertracker.gui.panel.expansion.AbstractExpansionPanel;
import tildim.hstools.hspitytimertracker.util.Colors;
import tildim.hstools.hspitytimertracker.util.icon.IconPaths;

import java.io.Serial;

/**
 *
 */
public class TheGrandTournamentPanel extends AbstractExpansionPanel {

    @Serial
    private static final long serialVersionUID = 2659337457099576097L;

    /**
     *
     */
    public TheGrandTournamentPanel() {
        super(IconPaths.TOURNAMENT_EXPANSION_ICON_PATH, IconPaths.TOURNAMENT_CARD_PACK_ICON_PATH, Colors.TOURNAMENT_COLOR, Colors.TEXT_DARK_COLOR, Colors.MODIFIERS_DARK_COLORS);
    }
}
