package tildim.hstools.hspitytimertracker.gui.panel.modebuttons.button;

import tildim.hstools.hspitytimertracker.util.Colors;
import tildim.hstools.hspitytimertracker.util.Text;
import tildim.hstools.hspitytimertracker.util.Tooltips;
import tildim.hstools.hspitytimertracker.util.icon.IconPaths;

import java.io.Serial;

/**
 *
 */
public class StandardModeButton extends AbstractModeButton {

    @Serial
    private static final long serialVersionUID = -3908647860547386968L;

    /**
     *
     */
    public StandardModeButton() {
        super(Text.STANDARD_TITLE, IconPaths.STANDARD_ICON_PATH, Colors.MODE_SELECTED_COLOR, Tooltips.STANDARD_TOOLTIP);

        addMouseListener(selectedModeButtonAdapter);
    }
}
