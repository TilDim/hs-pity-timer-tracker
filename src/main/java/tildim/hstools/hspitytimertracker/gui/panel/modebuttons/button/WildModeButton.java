package tildim.hstools.hspitytimertracker.gui.panel.modebuttons.button;

import tildim.hstools.hspitytimertracker.gui.panel.modebuttons.ModeButtonsPanel;
import tildim.hstools.hspitytimertracker.util.Colors;
import tildim.hstools.hspitytimertracker.util.Text;
import tildim.hstools.hspitytimertracker.util.Tooltips;
import tildim.hstools.hspitytimertracker.util.icon.IconPaths;

import java.io.Serial;

/**
 * {@code WildModeButton} is a {@link #JButton} that shows all the instances of {@code AbstractYearPanel}
 * which belong in the <i>Wild</i> mode, when pressed.
 *
 * @author Tilemachos Dimos
 * @see AbstractModeButton
 * @see ModeButtonsPanel
 */
public class WildModeButton extends AbstractModeButton {

    @Serial
    private static final long serialVersionUID = 7801635731736774583L;

    /**
     * Constructs a {@link #AbstractModeButton} and sets the unselected mode {@code MouseAdapter} as its mouse listener.
     */
    public WildModeButton() {
        super(Text.WILD_TITLE, IconPaths.WILD_ICON_PATH, Colors.MODE_UNSELECTED_COLOR, Tooltips.WILD_TOOLTIP);

        addMouseListener(unselectedModeButtonAdapter);
    }
}
