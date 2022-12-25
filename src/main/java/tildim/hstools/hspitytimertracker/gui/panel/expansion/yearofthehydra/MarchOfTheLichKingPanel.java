package tildim.hstools.hspitytimertracker.gui.panel.expansion.yearofthehydra;

import tildim.hstools.hspitytimertracker.gui.panel.expansion.AbstractExpansionPanel;
import tildim.hstools.hspitytimertracker.util.Colors;
import tildim.hstools.hspitytimertracker.util.icon.IconPaths;

import java.io.Serial;

/**
 * {@code MarchOfTheLichKingPanel} is a {@code JPanel} dedicated to the <i>March of the Lich King</i>
 * expansion.
 *
 * @author Tilemachos Dimos
 * @see AbstractExpansionPanel
 */
public class MarchOfTheLichKingPanel extends AbstractExpansionPanel {

    @Serial
    private static final long serialVersionUID = 1700148399887705245L;

    /**
     * Constructs a {@link #AbstractExpansionPanel} with all the <i>March of the Lich King</i>
     * expansion specific properties.
     */
    public MarchOfTheLichKingPanel() {
        super(IconPaths.LICHKING_LOGO_ICON_PATH, IconPaths.LICHKING_CARD_PACK_ICON_PATH,
                Colors.LICHKING_COLOR, Colors.TEXT_DARK_COLOR, Colors.MODIFIERS_DARK_COLORS);
    }
}
