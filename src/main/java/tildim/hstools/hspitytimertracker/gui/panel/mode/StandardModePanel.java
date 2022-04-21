package tildim.hstools.hspitytimertracker.gui.panel.mode;

import lombok.Getter;
import tildim.hstools.hspitytimertracker.gui.panel.year.YearOfTheGryphonPanel;
import tildim.hstools.hspitytimertracker.gui.panel.year.YearOfTheHydraPanel;

import java.io.Serial;

/**
 *
 */
@Getter
public class StandardModePanel extends AbstractModePanel {

    @Serial
    private static final long serialVersionUID = 7978385555547586738L;

    private final YearOfTheHydraPanel yearOfTheHydraPanel;
    private final YearOfTheGryphonPanel yearOfTheGryphonPanel;

    /**
     * Constructor with no arguments that calls the parent constructor and adds the standard year panels
     */
    public StandardModePanel() {
        super();

        yearOfTheHydraPanel = new YearOfTheHydraPanel();
        yearOfTheGryphonPanel = new YearOfTheGryphonPanel();

        add(yearOfTheHydraPanel);
        add(yearOfTheGryphonPanel);
    }
}
