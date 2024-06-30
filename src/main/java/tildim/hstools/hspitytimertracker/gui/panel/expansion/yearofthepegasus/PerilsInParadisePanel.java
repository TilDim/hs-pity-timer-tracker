package tildim.hstools.hspitytimertracker.gui.panel.expansion.yearofthepegasus;

import java.io.Serial;
import javax.swing.JPanel;
import tildim.hstools.hspitytimertracker.gui.panel.expansion.AbstractExpansionPanel;
import tildim.hstools.hspitytimertracker.util.Colors;
import tildim.hstools.hspitytimertracker.util.icon.IconPaths;

/**
 * {@code PerilsInParadisePanel} is a {@link JPanel} dedicated to the <i>Perils in Paradise</i>
 * expansion.
 *
 * @author Tilemachos Dimos
 * @see AbstractExpansionPanel
 */
public class PerilsInParadisePanel extends AbstractExpansionPanel {

    @Serial
    private static final long serialVersionUID = 6261132617314546244L;

    /**
     * Constructs a {@link #AbstractExpansionPanel} with all the <i>Perils in Paradise</i>
     * expansion specific properties.
     */
    public PerilsInParadisePanel() {
        super(IconPaths.PARADISE_LOGO_ICON_PATH, IconPaths.PARADISE_CARD_PACK_ICON_PATH,
                Colors.PARADISE_COLOR, Colors.TEXT_COLOR, Colors.MODIFIERS_COLORS);
    }

}
