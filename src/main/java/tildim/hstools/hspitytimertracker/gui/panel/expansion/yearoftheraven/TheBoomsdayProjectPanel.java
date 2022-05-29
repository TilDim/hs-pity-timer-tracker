package tildim.hstools.hspitytimertracker.gui.panel.expansion.yearoftheraven;

import tildim.hstools.hspitytimertracker.gui.panel.expansion.AbstractExpansionPanel;
import tildim.hstools.hspitytimertracker.util.Colors;
import tildim.hstools.hspitytimertracker.util.icon.IconPaths;

import java.io.Serial;

/**
 * {@code TheBoomsdayProjectPanel} is a {@code JPanel} dedicated to the <i>The Boomsday Project</i>
 * expansion.
 *
 * @author Tilemachos Dimos
 * @see AbstractExpansionPanel
 */
public class TheBoomsdayProjectPanel extends AbstractExpansionPanel {

    @Serial
    private static final long serialVersionUID = -9055816168487537718L;

    /**
     * Constructs a {@link #AbstractExpansionPanel} with all the <i>The Boomsday Project</i>
     * expansion specific properties.
     */
    public TheBoomsdayProjectPanel() {
        super(IconPaths.BOOMSDAY_LOGO_ICON_PATH, IconPaths.BOOMSDAY_CARD_PACK_ICON_PATH,
                Colors.BOOMSDAY_COLOR, Colors.TEXT_DARK_COLOR, Colors.MODIFIERS_DARK_COLORS);
    }
}
