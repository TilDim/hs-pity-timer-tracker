package tildim.hstools.hspitytimertracker.gui.panel.expansion.yearofthedragon;

import tildim.hstools.hspitytimertracker.gui.panel.expansion.AbstractExpansionPanel;
import tildim.hstools.hspitytimertracker.util.Colors;
import tildim.hstools.hspitytimertracker.util.icon.IconPaths;

import java.io.Serial;

/**
 * {@code DescentOfDragonsPanel} is a {@code JPanel} dedicated to the <i>Descent of Dragons</i>
 * expansion.
 *
 * @author Tilemachos Dimos
 * @see AbstractExpansionPanel
 */
public class DescentOfDragonsPanel extends AbstractExpansionPanel {

    @Serial
    private static final long serialVersionUID = -7671788530812981730L;

    /**
     * Constructs a {@link #AbstractExpansionPanel} with all the <i>Descent of Dragons</i>
     * expansion specific properties.
     */
    public DescentOfDragonsPanel() {
        super(IconPaths.DRAGONS_LOGO_ICON_PATH, IconPaths.DRAGONS_CARD_PACK_ICON_PATH,
                Colors.DRAGONS_COLOR, Colors.TEXT_COLOR, Colors.MODIFIERS_COLORS);
    }
}
