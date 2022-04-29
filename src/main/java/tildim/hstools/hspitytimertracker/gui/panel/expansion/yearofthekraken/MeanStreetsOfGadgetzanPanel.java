package tildim.hstools.hspitytimertracker.gui.panel.expansion.yearofthekraken;

import tildim.hstools.hspitytimertracker.gui.panel.expansion.AbstractExpansionPanel;
import tildim.hstools.hspitytimertracker.util.Colors;
import tildim.hstools.hspitytimertracker.util.icon.IconPaths;

import java.io.Serial;

/**
 *
 */
public class MeanStreetsOfGadgetzanPanel extends AbstractExpansionPanel {

    @Serial
    private static final long serialVersionUID = 8660099124984405275L;

    /**
     *
     */
    public MeanStreetsOfGadgetzanPanel() {
        super(IconPaths.GADGETZAN_EXPANSION_ICON_PATH, IconPaths.GADGETZAN_CARD_PACK_ICON_PATH, Colors.GADGETZAN_COLOR, Colors.TEXT_COLOR, Colors.MODIFIERS_COLORS);
    }
}