package tildim.hstools.hspitytimertracker.gui.panel.expansion.yearofthekraken;

import tildim.hstools.hspitytimertracker.gui.panel.expansion.AbstractExpansionPanel;
import tildim.hstools.hspitytimertracker.util.Colors;
import tildim.hstools.hspitytimertracker.util.icon.IconPaths;

import java.io.Serial;

/**
 * {@code WhispersOfTheOldGodsPanel} is a {@code JPanel} dedicated to the <i>Whispers of the Old Gods</i>
 * expansion.
 *
 * @author Tilemachos Dimos
 * @see AbstractExpansionPanel
 */
public class WhispersOfTheOldGodsPanel extends AbstractExpansionPanel {

    @Serial
    private static final long serialVersionUID = 6980868683359124898L;

    /**
     * Constructs a {@link #AbstractExpansionPanel} with all the <i>Whispers of the Old Gods</i>
     * expansion specific properties.
     */
    public WhispersOfTheOldGodsPanel() {
        super(IconPaths.OLDGODS_LOGO_ICON_PATH, IconPaths.OLDGODS_CARD_PACK_ICON_PATH,
                Colors.OLDGODS_COLOR, Colors.TEXT_COLOR, Colors.MODIFIERS_COLORS);
    }
}
