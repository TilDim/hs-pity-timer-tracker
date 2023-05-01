package tildim.hstools.hspitytimertracker.gui.panel.expansion.yearofthehydra;

import java.io.Serial;
import javax.swing.JPanel;
import tildim.hstools.hspitytimertracker.gui.panel.expansion.AbstractExpansionPanel;
import tildim.hstools.hspitytimertracker.util.Colors;
import tildim.hstools.hspitytimertracker.util.icon.IconPaths;

/**
 * {@code VoyageToTheSunkenCityPanel} is a {@link JPanel} dedicated to the <i>Voyage to the Sunken City</i>
 * expansion.
 *
 * @author Tilemachos Dimos
 * @see AbstractExpansionPanel
 */
public class VoyageToTheSunkenCityPanel extends AbstractExpansionPanel {

    @Serial
    private static final long serialVersionUID = -6171044758608964307L;

    /**
     * Constructs a {@link #AbstractExpansionPanel} with all the <i>Voyage to the Sunken City</i>
     * expansion specific properties.
     */
    public VoyageToTheSunkenCityPanel() {
        super(IconPaths.SUNKEN_LOGO_ICON_PATH, IconPaths.SUNKEN_CARD_PACK_ICON_PATH,
                Colors.SUNKEN_COLOR, Colors.TEXT_COLOR, Colors.MODIFIERS_COLORS);
    }

}
