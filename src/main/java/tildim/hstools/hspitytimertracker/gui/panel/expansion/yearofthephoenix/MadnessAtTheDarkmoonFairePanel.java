package tildim.hstools.hspitytimertracker.gui.panel.expansion.yearofthephoenix;

import tildim.hstools.hspitytimertracker.gui.panel.expansion.AbstractExpansionPanel;
import tildim.hstools.hspitytimertracker.util.Colors;
import tildim.hstools.hspitytimertracker.util.icon.IconPaths;

import java.io.Serial;

/**
 * {@code MadnessAtTheDarkmoonFairePanel} is a {@code JPanel} dedicated to the <i>Madness at the Darkmoon Faire</i>
 * expansion.
 *
 * @author Tilemachos Dimos
 * @see AbstractExpansionPanel
 */
public class MadnessAtTheDarkmoonFairePanel extends AbstractExpansionPanel {

    @Serial
    private static final long serialVersionUID = -6912448870003798797L;

    /**
     * Constructs a {@link #AbstractExpansionPanel} with all the <i>Madness at the Darkmoon Faire</i>
     * expansion specific properties.
     */
    public MadnessAtTheDarkmoonFairePanel() {
        super(IconPaths.DARKMOON_LOGO_ICON_PATH, IconPaths.DARKMOON_CARD_PACK_ICON_PATH,
                Colors.DARKMOON_COLOR, Colors.TEXT_COLOR, Colors.MODIFIERS_COLORS);
    }
}
