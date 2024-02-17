package tildim.hstools.hspitytimertracker.gui.panel.expansion.yearofthepegasus;

import java.io.Serial;
import javax.swing.JPanel;
import tildim.hstools.hspitytimertracker.gui.panel.expansion.AbstractExpansionPanel;
import tildim.hstools.hspitytimertracker.util.Colors;
import tildim.hstools.hspitytimertracker.util.icon.IconPaths;

/**
 * {@code WhizbangsWorkshopPanel} is a {@link JPanel} dedicated to the <i>Whizbang’s Workshop</i>
 * expansion.
 *
 * @author Tilemachos Dimos
 * @see AbstractExpansionPanel
 */
public class WhizbangsWorkshopPanel extends AbstractExpansionPanel {

    @Serial
    private static final long serialVersionUID = 8901003649798530285L;

    /**
     * Constructs a {@link #AbstractExpansionPanel} with all the <i>Whizbang’s Workshop</i>
     * expansion specific properties.
     */
    public WhizbangsWorkshopPanel() {
        super(IconPaths.WORKSHOP_LOGO_ICON_PATH, IconPaths.WORKSHOP_CARD_PACK_ICON_PATH,
                Colors.WORKSHOP_COLOR, Colors.TEXT_DARK_COLOR, Colors.MODIFIERS_DARK_COLORS);
    }

}
