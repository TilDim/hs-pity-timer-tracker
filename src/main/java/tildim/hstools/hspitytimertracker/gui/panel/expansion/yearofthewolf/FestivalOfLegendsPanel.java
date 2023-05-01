package tildim.hstools.hspitytimertracker.gui.panel.expansion.yearofthewolf;

import java.io.Serial;
import javax.swing.JPanel;
import tildim.hstools.hspitytimertracker.gui.panel.expansion.AbstractExpansionPanel;
import tildim.hstools.hspitytimertracker.util.Colors;
import tildim.hstools.hspitytimertracker.util.icon.IconPaths;

/**
 * {@code FestivalOfLegendsPanel} is a {@link JPanel} dedicated to the <i>Festival of Legends</i>
 * expansion.
 *
 * @author Tilemachos Dimos
 * @see AbstractExpansionPanel
 */
public class FestivalOfLegendsPanel extends AbstractExpansionPanel {

    @Serial
    private static final long serialVersionUID = -7267937769364750307L;

    /**
     * Constructs a {@link #AbstractExpansionPanel} with all the <i>Festival of Legends</i>
     * expansion specific properties.
     */
    public FestivalOfLegendsPanel() {
        super(IconPaths.FESTIVAL_LOGO_ICON_PATH, IconPaths.FESTIVAL_CARD_PACK_ICON_PATH,
                Colors.FESTIVAL_COLOR, Colors.TEXT_COLOR, Colors.MODIFIERS_COLORS);
    }

}
