package tildim.hstools.hspitytimertracker.gui.panel.expansion;

import tildim.hstools.hspitytimertracker.util.Colors;
import tildim.hstools.hspitytimertracker.util.icon.IconPaths;

import java.io.Serial;

/**
 *
 */
public class ClassicPanel extends AbstractExpansionPanel {

    @Serial
    private static final long serialVersionUID = 4880149430348525057L;

    /**
     *
     */
    public ClassicPanel() {
        super(IconPaths.CLASSIC_EXPANSION_ICON_PATH, IconPaths.CLASSIC_CARD_PACK_ICON_PATH, Colors.CLASSIC_COLOR, Colors.TEXT_COLOR, Colors.MODIFIERS_COLORS);
    }
}
