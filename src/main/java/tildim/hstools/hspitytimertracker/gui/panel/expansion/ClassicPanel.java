package tildim.hstools.hspitytimertracker.gui.panel.expansion;

import java.io.Serial;
import javax.swing.JPanel;
import tildim.hstools.hspitytimertracker.util.Colors;
import tildim.hstools.hspitytimertracker.util.icon.IconPaths;

/**
 * {@code ClassicPanel} is a {@link JPanel} dedicated to the <i>Classic</i>
 * set.
 *
 * @author Tilemachos Dimos
 * @see AbstractExpansionPanel
 */
public class ClassicPanel extends AbstractExpansionPanel {

    @Serial
    private static final long serialVersionUID = 4880149430348525057L;

    /**
     * Constructs a {@link #AbstractExpansionPanel} with all the <i>Classic</i>
     * set specific properties.
     */
    public ClassicPanel() {
        super(IconPaths.CLASSIC_LOGO_ICON_PATH, IconPaths.CLASSIC_CARD_PACK_ICON_PATH,
                Colors.CLASSIC_COLOR, Colors.TEXT_COLOR, Colors.MODIFIERS_COLORS);
    }

}
