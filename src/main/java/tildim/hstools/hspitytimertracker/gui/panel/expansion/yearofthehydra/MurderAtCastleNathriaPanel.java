package tildim.hstools.hspitytimertracker.gui.panel.expansion.yearofthehydra;

import java.io.Serial;
import javax.swing.JPanel;
import tildim.hstools.hspitytimertracker.gui.panel.expansion.AbstractExpansionPanel;
import tildim.hstools.hspitytimertracker.util.Colors;
import tildim.hstools.hspitytimertracker.util.icon.IconPaths;

/**
 * {@code MurderAtCastleNathriaPanel} is a {@link JPanel} dedicated to the <i>Murder at Castle Nathria</i>
 * expansion.
 *
 * @author Tilemachos Dimos
 * @see AbstractExpansionPanel
 */
public class MurderAtCastleNathriaPanel extends AbstractExpansionPanel {

    @Serial
    private static final long serialVersionUID = 7414288483068893995L;

    /**
     * Constructs a {@link #AbstractExpansionPanel} with all the <i>Murder at Castle Nathria</i>
     * expansion specific properties.
     */
    public MurderAtCastleNathriaPanel() {
        super(IconPaths.NATHRIA_LOGO_ICON_PATH, IconPaths.NATHRIA_CARD_PACK_ICON_PATH,
                Colors.NATHRIA_COLOR, Colors.TEXT_DARK_COLOR, Colors.MODIFIERS_DARK_COLORS);
    }

}
