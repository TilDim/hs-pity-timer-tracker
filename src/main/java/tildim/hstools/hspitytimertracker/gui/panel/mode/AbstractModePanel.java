package tildim.hstools.hspitytimertracker.gui.panel.mode;

import javax.swing.*;
import java.io.Serial;

/**
 *
 */
public abstract class AbstractModePanel extends JPanel {

    @Serial
    private static final long serialVersionUID = 6416071498040467732L;

    /**
     * Constructor with no arguments that calls the parent constructor
     */
    protected AbstractModePanel() {
        super();
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
    }
}
