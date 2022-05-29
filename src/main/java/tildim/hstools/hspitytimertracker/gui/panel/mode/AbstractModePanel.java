package tildim.hstools.hspitytimertracker.gui.panel.mode;

import tildim.hstools.hspitytimertracker.gui.panel.ScrollablePanel;
import tildim.hstools.hspitytimertracker.gui.panel.year.AbstractYearPanel;

import javax.swing.*;
import java.io.Serial;

/**
 * {@code AbstractModePanel} is a {@link #ScrollablePanel} that contains all the instances of {@code AbstractYearPanel}
 * which belong in a specific mode.
 *
 * @author Tilemachos Dimos
 * @see AbstractYearPanel
 */
public abstract class AbstractModePanel extends ScrollablePanel {

    @Serial
    private static final long serialVersionUID = 6416071498040467732L;

    /**
     * Constructs a {@link #ScrollablePanel} and sets its layout.
     */
    protected AbstractModePanel() {
        super();

        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
    }
}
