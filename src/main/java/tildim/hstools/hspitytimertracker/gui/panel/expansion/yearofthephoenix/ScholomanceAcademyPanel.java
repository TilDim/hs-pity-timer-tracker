package tildim.hstools.hspitytimertracker.gui.panel.expansion.yearofthephoenix;

import tildim.hstools.hspitytimertracker.gui.panel.expansion.AbstractExpansionPanel;
import tildim.hstools.hspitytimertracker.util.Colors;
import tildim.hstools.hspitytimertracker.util.icon.IconPaths;

import java.io.Serial;

/**
 * {@code ScholomanceAcademyPanel} is a {@code JPanel} dedicated to the <i>Scholomance Academy</i>
 * expansion.
 *
 * @author Tilemachos Dimos
 * @see AbstractExpansionPanel
 */
public class ScholomanceAcademyPanel extends AbstractExpansionPanel {

    @Serial
    private static final long serialVersionUID = -8939192302387288996L;

    /**
     * Constructs a {@link #AbstractExpansionPanel} with all the <i>Scholomance Academy</i>
     * expansion specific properties.
     */
    public ScholomanceAcademyPanel() {
        super(IconPaths.SCHOLOMANCE_LOGO_ICON_PATH, IconPaths.SCHOLOMANCE_CARD_PACK_ICON_PATH,
                Colors.SCHOLOMANCE_COLOR, Colors.TEXT_DARK_COLOR, Colors.MODIFIERS_DARK_COLORS);
    }
}
