package tildim.hstools.hspitytimertracker.gui.panel.modebuttons.button;

import tildim.hstools.hspitytimertracker.gui.panel.modebuttons.ModeButtonsPanel;
import tildim.hstools.hspitytimertracker.util.Colors;
import tildim.hstools.hspitytimertracker.util.Text;
import tildim.hstools.hspitytimertracker.util.Tooltips;
import tildim.hstools.hspitytimertracker.util.icon.IconPaths;

import java.io.Serial;

/**
 * {@code StandardModeButton} is a {@link #JButton} that shows all the instances of {@code AbstractYearPanel}
 * which belong in the <i>Standard</i> mode, when pressed.
 *
 * @author Tilemachos Dimos
 * @see AbstractModeButton
 * @see ModeButtonsPanel
 */
public class StandardModeButton extends AbstractModeButton {

    @Serial
    private static final long serialVersionUID = -3908647860547386968L;

    /**
     * Constructs a {@link #AbstractModeButton} and sets the selected mode {@code MouseAdapter} as its mouse listener.
     */
    public StandardModeButton() {
        super(Text.STANDARD_TITLE, IconPaths.STANDARD_ICON_PATH, Colors.MODE_SELECTED_COLOR, Tooltips.STANDARD_TOOLTIP);

        addMouseListener(selectedModeButtonAdapter);
    }
}
