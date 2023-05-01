package tildim.hstools.hspitytimertracker.gui.panel.mode;

import java.io.Serial;
import tildim.hstools.hspitytimertracker.gui.panel.year.YearOfTheHydraPanel;
import tildim.hstools.hspitytimertracker.gui.panel.year.YearOfTheWolfPanel;

/**
 * {@code StandardModePanel} is a {@link #JPanel} that contains all the instances of {@code AbstractYearPanel}
 * which belong in the <i>Standard</i> mode.
 *
 * @author Tilemachos Dimos
 * @see AbstractModePanel
 * @see YearOfTheWolfPanel
 * @see YearOfTheHydraPanel
 */
public class StandardModePanel extends AbstractModePanel {

    @Serial
    private static final long serialVersionUID = 7978385555547586738L;

    /**
     * Constructs a {@link #AbstractModePanel} and places in it:
     * <ul>
     *     <li>
     *         a {@code YearOfTheWolfPanel};
     *     </li>
     *     <li>
     *         a {@code YearOfTheHydraPanel}.
     *     </li>
     * </ul>
     */
    public StandardModePanel() {
        super();

        // Instantiate the mode panel's components
        YearOfTheWolfPanel yearOfTheWolfPanel = new YearOfTheWolfPanel();
        YearOfTheHydraPanel yearOfTheHydraPanel = new YearOfTheHydraPanel();

        // Add the year panels to a list
        modeYearPanels.add(yearOfTheWolfPanel);
        modeYearPanels.add(yearOfTheHydraPanel);

        // Add the components to the mode panel
        add(yearOfTheWolfPanel);
        add(yearOfTheHydraPanel);
    }

}
