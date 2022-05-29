package tildim.hstools.hspitytimertracker.gui.panel.mode;

import lombok.Getter;
import tildim.hstools.hspitytimertracker.gui.panel.year.YearOfTheGryphonPanel;
import tildim.hstools.hspitytimertracker.gui.panel.year.YearOfTheHydraPanel;

import java.io.Serial;

/**
 * {@code StandardModePanel} is a {@link #JPanel} that contains all the instances of {@code AbstractYearPanel}
 * which belong in the <i>Standard</i> mode.
 *
 * @author Tilemachos Dimos
 * @see AbstractModePanel
 */
@Getter
public class StandardModePanel extends AbstractModePanel {

    @Serial
    private static final long serialVersionUID = 7978385555547586738L;

    private final YearOfTheHydraPanel yearOfTheHydraPanel;
    private final YearOfTheGryphonPanel yearOfTheGryphonPanel;

    /**
     * Constructs a {@link #AbstractModePanel} and places in it the instances of {@code AbstractYearPanel}
     * which belong in the <i>Standard</i> mode.
     */
    public StandardModePanel() {
        super();

        yearOfTheHydraPanel = new YearOfTheHydraPanel();
        yearOfTheGryphonPanel = new YearOfTheGryphonPanel();

        add(yearOfTheHydraPanel);
        add(yearOfTheGryphonPanel);
    }
}
