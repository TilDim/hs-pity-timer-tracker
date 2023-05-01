package tildim.hstools.hspitytimertracker.gui.panel.expansion.yearofthedragon;

import java.io.Serial;
import javax.swing.JPanel;
import tildim.hstools.hspitytimertracker.gui.panel.expansion.AbstractExpansionPanel;
import tildim.hstools.hspitytimertracker.util.Colors;
import tildim.hstools.hspitytimertracker.util.icon.IconPaths;

/**
 * {@code RiseOfShadowsPanel} is a {@link JPanel} dedicated to the <i>Rise of Shadows</i>
 * expansion.
 *
 * @author Tilemachos Dimos
 * @see AbstractExpansionPanel
 */
public class RiseOfShadowsPanel extends AbstractExpansionPanel {

    @Serial
    private static final long serialVersionUID = 6494724314890068439L;

    /**
     * Constructs a {@link #AbstractExpansionPanel} with all the <i>Rise of Shadows</i>
     * expansion specific properties.
     */
    public RiseOfShadowsPanel() {
        super(IconPaths.SHADOWS_LOGO_ICON_PATH, IconPaths.SHADOWS_CARD_PACK_ICON_PATH,
                Colors.SHADOWS_COLOR, Colors.TEXT_DARK_COLOR, Colors.MODIFIERS_DARK_COLORS);
    }

}
