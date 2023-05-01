package tildim.hstools.hspitytimertracker.gui.panel.expansion.yearoftheraven;

import java.io.Serial;
import javax.swing.JPanel;
import tildim.hstools.hspitytimertracker.gui.panel.expansion.AbstractExpansionPanel;
import tildim.hstools.hspitytimertracker.util.Colors;
import tildim.hstools.hspitytimertracker.util.icon.IconPaths;

/**
 * {@code TheWitchwoodPanel} is a {@link JPanel} dedicated to the <i>The Witchwood</i>
 * expansion.
 *
 * @author Tilemachos Dimos
 * @see AbstractExpansionPanel
 */
public class TheWitchwoodPanel extends AbstractExpansionPanel {

    @Serial
    private static final long serialVersionUID = 5435272674741961330L;

    /**
     * Constructs a {@link #AbstractExpansionPanel} with all the <i>The Witchwood</i>
     * expansion specific properties.
     */
    public TheWitchwoodPanel() {
        super(IconPaths.WITCHWOOD_LOGO_ICON_PATH, IconPaths.WITCHWOOD_CARD_PACK_ICON_PATH,
                Colors.WITCHWOOD_COLOR, Colors.TEXT_COLOR, Colors.MODIFIERS_COLORS);
    }

}
