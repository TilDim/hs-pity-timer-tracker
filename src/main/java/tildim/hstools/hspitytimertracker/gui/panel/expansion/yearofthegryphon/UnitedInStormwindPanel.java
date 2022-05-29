package tildim.hstools.hspitytimertracker.gui.panel.expansion.yearofthegryphon;

import tildim.hstools.hspitytimertracker.gui.panel.expansion.AbstractExpansionPanel;
import tildim.hstools.hspitytimertracker.util.Colors;
import tildim.hstools.hspitytimertracker.util.icon.IconPaths;

import java.io.Serial;

/**
 * {@code UnitedInStormwindPanel} is a {@code JPanel} dedicated to the <i>United in Stormwind</i>
 * expansion.
 *
 * @author Tilemachos Dimos
 * @see AbstractExpansionPanel
 */
public class UnitedInStormwindPanel extends AbstractExpansionPanel {

    @Serial
    private static final long serialVersionUID = -8532363298371126011L;

    /**
     * Constructs a {@link #AbstractExpansionPanel} with all the <i>United in Stormwind</i>
     * expansion specific properties.
     */
    public UnitedInStormwindPanel() {
        super(IconPaths.STORMWIND_LOGO_ICON_PATH, IconPaths.STORMWIND_CARD_PACK_ICON_PATH,
                Colors.STORMWIND_COLOR, Colors.TEXT_DARK_COLOR, Colors.MODIFIERS_DARK_COLORS);
    }
}
