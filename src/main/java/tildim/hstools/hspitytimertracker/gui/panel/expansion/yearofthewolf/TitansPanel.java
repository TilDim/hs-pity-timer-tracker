package tildim.hstools.hspitytimertracker.gui.panel.expansion.yearofthewolf;

import java.io.Serial;
import javax.swing.JPanel;
import tildim.hstools.hspitytimertracker.gui.panel.expansion.AbstractExpansionPanel;
import tildim.hstools.hspitytimertracker.util.Colors;
import tildim.hstools.hspitytimertracker.util.icon.IconPaths;

/**
 * {@code TitansPanel} is a {@link JPanel} dedicated to the <i>Titans</i>
 * expansion.
 *
 * @author Tilemachos Dimos
 * @see AbstractExpansionPanel
 */
public class TitansPanel extends AbstractExpansionPanel {

    @Serial
    private static final long serialVersionUID = -8488212693079475156L;

    /**
     * Constructs a {@link #AbstractExpansionPanel} with all the <i>Titans</i>
     * expansion specific properties.
     */
    public TitansPanel() {
        super(IconPaths.TITANS_LOGO_ICON_PATH, IconPaths.TITANS_CARD_PACK_ICON_PATH,
                Colors.TITANS_COLOR, Colors.TEXT_COLOR, Colors.MODIFIERS_COLORS);
    }

}
