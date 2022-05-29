package tildim.hstools.hspitytimertracker.gui.panel.expansion.yearofthephoenix;

import tildim.hstools.hspitytimertracker.gui.panel.expansion.AbstractExpansionPanel;
import tildim.hstools.hspitytimertracker.util.Colors;
import tildim.hstools.hspitytimertracker.util.icon.IconPaths;

import java.io.Serial;

/**
 * {@code AshesOfOutlandPanel} is a {@code JPanel} dedicated to the <i>Ashes of Outland</i>
 * expansion.
 *
 * @author Tilemachos Dimos
 * @see AbstractExpansionPanel
 */
public class AshesOfOutlandPanel extends AbstractExpansionPanel {

    @Serial
    private static final long serialVersionUID = 4535033910241882340L;

    /**
     * Constructs a {@link #AbstractExpansionPanel} with all the <i>Ashes of Outland</i>
     * expansion specific properties.
     */
    public AshesOfOutlandPanel() {
        super(IconPaths.OUTLAND_LOGO_ICON_PATH, IconPaths.OUTLAND_CARD_PACK_ICON_PATH,
                Colors.OUTLAND_COLOR, Colors.TEXT_DARK_COLOR, Colors.MODIFIERS_DARK_COLORS);
    }
}
