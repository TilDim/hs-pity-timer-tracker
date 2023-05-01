package tildim.hstools.hspitytimertracker.gui.panel.expansion.yearofthemammoth;

import java.io.Serial;
import javax.swing.JPanel;
import tildim.hstools.hspitytimertracker.gui.panel.expansion.AbstractExpansionPanel;
import tildim.hstools.hspitytimertracker.util.Colors;
import tildim.hstools.hspitytimertracker.util.icon.IconPaths;

/**
 * {@code KnightsOfTheFrozenThronePanel} is a {@link JPanel} dedicated to the <i>Knights of the Frozen Throne</i>
 * expansion.
 *
 * @author Tilemachos Dimos
 * @see AbstractExpansionPanel
 */
public class KnightsOfTheFrozenThronePanel extends AbstractExpansionPanel {

    @Serial
    private static final long serialVersionUID = 7605709907104558272L;

    /**
     * Constructs a {@link #AbstractExpansionPanel} with all the <i>Knights of the Frozen Throne</i>
     * expansion specific properties.
     */
    public KnightsOfTheFrozenThronePanel() {
        super(IconPaths.KNIGHTS_LOGO_ICON_PATH, IconPaths.KNIGHTS_CARD_PACK_ICON_PATH,
                Colors.KNIGHTS_COLOR, Colors.TEXT_COLOR, Colors.MODIFIERS_COLORS);
    }

}
