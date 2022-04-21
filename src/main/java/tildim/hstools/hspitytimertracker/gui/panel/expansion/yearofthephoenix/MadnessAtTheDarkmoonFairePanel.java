package tildim.hstools.hspitytimertracker.gui.panel.expansion.yearofthephoenix;

import tildim.hstools.hspitytimertracker.gui.panel.expansion.AbstractExpansionPanel;
import tildim.hstools.hspitytimertracker.util.Colors;
import tildim.hstools.hspitytimertracker.util.icon.IconPaths;

import java.io.Serial;

/**
 *
 */
public class MadnessAtTheDarkmoonFairePanel extends AbstractExpansionPanel {

    @Serial
    private static final long serialVersionUID = -6912448870003798797L;

    /**
     *
     */
    public MadnessAtTheDarkmoonFairePanel() {
        super(IconPaths.DARKMOON_EXPANSION_ICON_PATH, IconPaths.DARKMOON_CARD_PACK_ICON_PATH, Colors.DARKMOON_COLOR, Colors.TEXT_COLOR, Colors.MODIFIERS_COLORS);
    }
}
