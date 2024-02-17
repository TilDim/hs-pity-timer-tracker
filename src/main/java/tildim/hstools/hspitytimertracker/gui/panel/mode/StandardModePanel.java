package tildim.hstools.hspitytimertracker.gui.panel.mode;

import java.io.Serial;
import tildim.hstools.hspitytimertracker.gui.panel.year.YearOfThePegasusPanel;
import tildim.hstools.hspitytimertracker.gui.panel.year.YearOfTheWolfPanel;

/**
 * {@code StandardModePanel} is a {@link #JPanel} that contains all the instances of {@code AbstractYearPanel}
 * which belong in the <i>Standard</i> mode.
 *
 * @author Tilemachos Dimos
 * @see AbstractModePanel
 * @see YearOfThePegasusPanel
 * @see YearOfTheWolfPanel
 */
public class StandardModePanel extends AbstractModePanel {

    @Serial
    private static final long serialVersionUID = 7978385555547586738L;

    /**
     * Constructs a {@link #AbstractModePanel} and places in it:
     * <ul>
     *     <li>
     *         a {@code YearOfThePegasusPanel};
     *     </li>
     *     <li>
     *         a {@code YearOfTheWolfPanel}.
     *     </li>
     * </ul>
     */
    public StandardModePanel() {
        super();

        // Instantiate the mode panel's components
        YearOfThePegasusPanel yearOfThePegasusPanel = new YearOfThePegasusPanel();
        YearOfTheWolfPanel yearOfTheWolfPanel = new YearOfTheWolfPanel();

        // Add the year panels to a list
        modeYearPanels.add(yearOfThePegasusPanel);
        modeYearPanels.add(yearOfTheWolfPanel);

        // Add the components to the mode panel
        add(yearOfThePegasusPanel);
        add(yearOfTheWolfPanel);
    }

}
