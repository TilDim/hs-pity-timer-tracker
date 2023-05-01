package tildim.hstools.hspitytimertracker.gui.panel.modebuttons;

import java.awt.GridLayout;
import java.io.Serial;
import javax.swing.JPanel;
import lombok.Getter;
import tildim.hstools.hspitytimertracker.gui.panel.modebuttons.button.AbstractModeButton;
import tildim.hstools.hspitytimertracker.gui.panel.modebuttons.button.StandardModeButton;
import tildim.hstools.hspitytimertracker.gui.panel.modebuttons.button.WildModeButton;

/**
 * {@code ModeButtonsPanel} is a {@link #JPanel} that contains all the instances of {@code AbstractModeButton}.
 *
 * @author Tilemachos Dimos
 * @see AbstractModeButton
 */
@Getter
public class ModeButtonsPanel extends JPanel {

    @Serial
    private static final long serialVersionUID = -6669699590389190860L;

    private final StandardModeButton standardModeButton;
    private final WildModeButton wildModeButton;

    /**
     * Constructs a {@link #JPanel}, sets its layout and places in it:
     * <ul>
     *     <li>
     *         a {@code StandardModeButton};
     *     </li>
     *     <li>
     *         a {@code WildModeButton}.
     *     </li>
     * </ul>
     *
     * @see StandardModeButton
     * @see WildModeButton
     */
    public ModeButtonsPanel() {
        super();

        setLayout(new GridLayout(1, 2, 0, 0));

        standardModeButton = new StandardModeButton();
        wildModeButton = new WildModeButton();

        add(standardModeButton);
        add(wildModeButton);
    }

}
