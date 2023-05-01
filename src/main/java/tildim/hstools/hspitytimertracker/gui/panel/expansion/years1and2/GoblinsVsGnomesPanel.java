package tildim.hstools.hspitytimertracker.gui.panel.expansion.years1and2;

import java.io.Serial;
import javax.swing.JPanel;
import tildim.hstools.hspitytimertracker.gui.panel.expansion.AbstractExpansionPanel;
import tildim.hstools.hspitytimertracker.util.Colors;
import tildim.hstools.hspitytimertracker.util.icon.IconPaths;

/**
 * {@code GoblinsVsGnomesPanel} is a {@link JPanel} dedicated to the <i>Goblins vs Gnomes</i>
 * expansion.
 *
 * @author Tilemachos Dimos
 * @see AbstractExpansionPanel
 */
public class GoblinsVsGnomesPanel extends AbstractExpansionPanel {

    @Serial
    private static final long serialVersionUID = 4732663353018308770L;

    /**
     * Constructs a {@link #AbstractExpansionPanel} with all the <i>Goblins vs Gnomes</i>
     * expansion specific properties.
     */
    public GoblinsVsGnomesPanel() {
        super(IconPaths.GOBLINS_LOGO_ICON_PATH, IconPaths.GOBLINS_CARD_PACK_ICON_PATH,
                Colors.GOBLINS_COLOR, Colors.TEXT_COLOR, Colors.MODIFIERS_COLORS);
    }

}
