package tildim.hstools.hspitytimertracker.gui.panel.expansion.yearofthepegasus;

import java.io.Serial;
import javax.swing.JPanel;
import tildim.hstools.hspitytimertracker.gui.panel.expansion.AbstractExpansionPanel;
import tildim.hstools.hspitytimertracker.util.Colors;
import tildim.hstools.hspitytimertracker.util.icon.IconPaths;

/**
 * {@code TheGreatDarkBeyondPanel} is a {@link JPanel} dedicated to the <i>The Great Dark Beyond</i>
 * expansion.
 *
 * @author Tilemachos Dimos
 * @see AbstractExpansionPanel
 */
public class TheGreatDarkBeyondPanel extends AbstractExpansionPanel {

    @Serial
    private static final long serialVersionUID = -7100996094494832212L;

    /**
     * Constructs a {@link #AbstractExpansionPanel} with all the <i>The Great Dark Beyond</i>
     * expansion specific properties.
     */
    public TheGreatDarkBeyondPanel() {
        super(IconPaths.GREAT_DARK_LOGO_ICON_PATH, IconPaths.GREAT_DARK_CARD_PACK_ICON_PATH,
                Colors.GREAT_DARK_COLOR, Colors.TEXT_DARK_COLOR, Colors.MODIFIERS_DARK_COLORS);
    }

}
