package tildim.hstools.hspitytimertracker.gui.panel.expansion.yearofthekraken;

import tildim.hstools.hspitytimertracker.gui.panel.expansion.AbstractExpansionPanel;
import tildim.hstools.hspitytimertracker.util.Colors;
import tildim.hstools.hspitytimertracker.util.icon.IconPaths;

import java.io.Serial;

/**
 *
 */
public class WhispersOfTheOldGodsPanel extends AbstractExpansionPanel {

    @Serial
    private static final long serialVersionUID = 6980868683359124898L;

    /**
     *
     */
    public WhispersOfTheOldGodsPanel() {
        super(IconPaths.OLDGODS_EXPANSION_ICON_PATH, IconPaths.OLDGODS_CARD_PACK_ICON_PATH, Colors.OLDGODS_COLOR, Colors.TEXT_COLOR, Colors.MODIFIERS_COLORS);
    }
}
