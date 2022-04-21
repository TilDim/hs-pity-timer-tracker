package tildim.hstools.hspitytimertracker.gui.panel.expansion.yearoftheraven;

import tildim.hstools.hspitytimertracker.gui.panel.expansion.AbstractExpansionPanel;
import tildim.hstools.hspitytimertracker.util.Colors;
import tildim.hstools.hspitytimertracker.util.icon.IconPaths;

import java.io.Serial;

/**
 *
 */
public class RastakhansRumblePanel extends AbstractExpansionPanel {

    @Serial
    private static final long serialVersionUID = -3933022213884052799L;

    /**
     *
     */
    public RastakhansRumblePanel() {
        super(IconPaths.RUMBLE_EXPANSION_ICON_PATH, IconPaths.RUMBLE_CARD_PACK_ICON_PATH, Colors.RUMBLE_COLOR, Colors.TEXT_COLOR, Colors.MODIFIERS_COLORS);
    }
}
