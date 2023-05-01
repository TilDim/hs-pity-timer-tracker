package tildim.hstools.hspitytimertracker.gui.panel.expansion.years1and2;

import java.io.Serial;
import javax.swing.JPanel;
import tildim.hstools.hspitytimertracker.gui.panel.expansion.AbstractExpansionPanel;
import tildim.hstools.hspitytimertracker.util.Colors;
import tildim.hstools.hspitytimertracker.util.icon.IconPaths;

/**
 * {@code TheGrandTournamentPanel} is a {@link JPanel} dedicated to the <i>The Grand Tournament</i>
 * expansion.
 *
 * @author Tilemachos Dimos
 * @see AbstractExpansionPanel
 */
public class TheGrandTournamentPanel extends AbstractExpansionPanel {

    @Serial
    private static final long serialVersionUID = 2659337457099576097L;

    /**
     * Constructs a {@link #AbstractExpansionPanel} with all the <i>The Grand Tournament</i>
     * expansion specific properties.
     */
    public TheGrandTournamentPanel() {
        super(IconPaths.TOURNAMENT_LOGO_ICON_PATH, IconPaths.TOURNAMENT_CARD_PACK_ICON_PATH,
                Colors.TOURNAMENT_COLOR, Colors.TEXT_DARK_COLOR, Colors.MODIFIERS_DARK_COLORS);
    }

}
