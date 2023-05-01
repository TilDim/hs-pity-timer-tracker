package tildim.hstools.hspitytimertracker.gui.panel.expansion.yearofthemammoth;

import java.io.Serial;
import javax.swing.JPanel;
import tildim.hstools.hspitytimertracker.gui.panel.expansion.AbstractExpansionPanel;
import tildim.hstools.hspitytimertracker.util.Colors;
import tildim.hstools.hspitytimertracker.util.icon.IconPaths;

/**
 * {@code KoboldsAndCatacombsPanel} is a {@link JPanel} dedicated to the <i>Kobolds & Catacombs</i>
 * expansion.
 *
 * @author Tilemachos Dimos
 * @see AbstractExpansionPanel
 */
public class KoboldsAndCatacombsPanel extends AbstractExpansionPanel {

    @Serial
    private static final long serialVersionUID = -1849767231307653370L;

    /**
     * Constructs a {@link #AbstractExpansionPanel} with all the <i>Kobolds & Catacombs</i>
     * expansion specific properties.
     */
    public KoboldsAndCatacombsPanel() {
        super(IconPaths.KOBOLDS_LOGO_ICON_PATH, IconPaths.KOBOLDS_CARD_PACK_ICON_PATH,
                Colors.KOBOLDS_COLOR, Colors.TEXT_COLOR, Colors.MODIFIERS_COLORS);
    }

}
