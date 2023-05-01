package tildim.hstools.hspitytimertracker.gui.panel.expansion.yearofthegryphon;

import java.io.Serial;
import javax.swing.JPanel;
import tildim.hstools.hspitytimertracker.gui.panel.expansion.AbstractExpansionPanel;
import tildim.hstools.hspitytimertracker.util.Colors;
import tildim.hstools.hspitytimertracker.util.icon.IconPaths;

/**
 * {@code FracturedInAlteracValleyPanel} is a {@link JPanel} dedicated to the <i>Fractured in Alterac Valley</i>
 * expansion.
 *
 * @author Tilemachos Dimos
 * @see AbstractExpansionPanel
 */
public class FracturedInAlteracValleyPanel extends AbstractExpansionPanel {

    @Serial
    private static final long serialVersionUID = 5225690784576420659L;

    /**
     * Constructs a {@link #AbstractExpansionPanel} with all the <i>Fractured in Alterac Valley</i>
     * expansion specific properties.
     */
    public FracturedInAlteracValleyPanel() {
        super(IconPaths.ALTERAC_LOGO_ICON_PATH, IconPaths.ALTERAC_CARD_PACK_ICON_PATH,
                Colors.ALTERAC_COLOR, Colors.TEXT_COLOR, Colors.MODIFIERS_COLORS);
    }

}
