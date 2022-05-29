package tildim.hstools.hspitytimertracker.gui.panel.expansion.yearoftheraven;

import tildim.hstools.hspitytimertracker.gui.panel.expansion.AbstractExpansionPanel;
import tildim.hstools.hspitytimertracker.util.Colors;
import tildim.hstools.hspitytimertracker.util.icon.IconPaths;

import java.io.Serial;

/**
 * {@code RastakhansRumblePanel} is a {@code JPanel} dedicated to the <i>Rastakhan's Rumble</i>
 * expansion.
 *
 * @author Tilemachos Dimos
 * @see AbstractExpansionPanel
 */
public class RastakhansRumblePanel extends AbstractExpansionPanel {

    @Serial
    private static final long serialVersionUID = -3933022213884052799L;

    /**
     * Constructs a {@link #AbstractExpansionPanel} with all the <i>Rastakhan's Rumble</i>
     * expansion specific properties.
     */
    public RastakhansRumblePanel() {
        super(IconPaths.RUMBLE_LOGO_ICON_PATH, IconPaths.RUMBLE_CARD_PACK_ICON_PATH,
                Colors.RUMBLE_COLOR, Colors.TEXT_COLOR, Colors.MODIFIERS_COLORS);
    }
}
