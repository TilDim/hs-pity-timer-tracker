package tildim.hstools.hspitytimertracker.gui.panel.expansion.yearofthehydra;

import tildim.hstools.hspitytimertracker.gui.panel.expansion.AbstractExpansionPanel;
import tildim.hstools.hspitytimertracker.util.Colors;
import tildim.hstools.hspitytimertracker.util.icon.IconPaths;

import java.io.Serial;

/**
 *
 */
public class VoyageToTheSunkenCityPanel extends AbstractExpansionPanel {

    @Serial
    private static final long serialVersionUID = -6171044758608964307L;

    /**
     *
     */
    public VoyageToTheSunkenCityPanel() {
        super(IconPaths.SUNKEN_EXPANSION_ICON_PATH, IconPaths.SUNKEN_CARD_PACK_ICON_PATH, Colors.SUNKEN_COLOR, Colors.TEXT_COLOR, Colors.MODIFIERS_COLORS);
    }
}
