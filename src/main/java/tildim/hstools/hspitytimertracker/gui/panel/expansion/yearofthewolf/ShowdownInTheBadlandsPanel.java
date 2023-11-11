package tildim.hstools.hspitytimertracker.gui.panel.expansion.yearofthewolf;

import java.io.Serial;
import javax.swing.JPanel;
import tildim.hstools.hspitytimertracker.gui.panel.expansion.AbstractExpansionPanel;
import tildim.hstools.hspitytimertracker.util.Colors;
import tildim.hstools.hspitytimertracker.util.icon.IconPaths;

/**
 * {@code ShowdownInTheBadlandsPanel} is a {@link JPanel} dedicated to the <i>Showdown in the Badlands</i>
 * expansion.
 *
 * @author Tilemachos Dimos
 * @see AbstractExpansionPanel
 */
public class ShowdownInTheBadlandsPanel extends AbstractExpansionPanel {

    @Serial
    private static final long serialVersionUID = -1716570880059870123L;

    /**
     * Constructs a {@link #AbstractExpansionPanel} with all the <i>Showdown in the Badlands</i>
     * expansion specific properties.
     */
    public ShowdownInTheBadlandsPanel() {
        super(IconPaths.BADLANDS_LOGO_ICON_PATH, IconPaths.BADLANDS_CARD_PACK_ICON_PATH,
                Colors.BADLANDS_COLOR, Colors.TEXT_COLOR, Colors.MODIFIERS_COLORS);
    }

}
