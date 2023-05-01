package tildim.hstools.hspitytimertracker.gui.panel.mode;

import java.io.Serial;
import lombok.Getter;
import tildim.hstools.hspitytimertracker.gui.panel.expansion.ClassicPanel;
import tildim.hstools.hspitytimertracker.gui.panel.year.*;

/**
 * {@code WildModePanel} is a {@link #JPanel} that contains all the instances of {@code AbstractYearPanel}
 * which belong in the <i>Wild</i> mode and a {@code ClassicPanel}.
 *
 * @author Tilemachos Dimos
 * @see AbstractModePanel
 * @see YearOfTheGryphonPanel
 * @see YearOfThePhoenixPanel
 * @see YearOfTheDragonPanel
 * @see YearOfTheRavenPanel
 * @see YearOfTheMammothPanel
 * @see YearOfTheKrakenPanel
 * @see Years1And2Panel
 * @see ClassicPanel
 */
@Getter
public class WildModePanel extends AbstractModePanel {

    @Serial
    private static final long serialVersionUID = -5341838223757909385L;

    private final ClassicPanel classicPanel;

    /**
     * Constructs a {@link #AbstractModePanel} and places in it:
     * <ul>
     *     <li>
     *         a {@code YearOfTheGryphonPanel};
     *     </li>
     *     <li>
     *         a {@code YearOfThePhoenixPanel};
     *     </li>
     *     <li>
     *         a {@code YearOfTheDragonPanel};
     *     </li>
     *     <li>
     *         a {@code YearOfTheRavenPanel};
     *     </li>
     *     <li>
     *         a {@code YearOfTheMammothPanel};
     *     </li>
     *     <li>
     *         a {@code YearOfTheKrakenPanel};
     *     </li>
     *     <li>
     *         a {@code Years1And2Panel};
     *     </li>
     *     <li>
     *         a {@code ClassicPanel}.
     *     </li>
     * </ul>
     */
    public WildModePanel() {
        super();

        // Instantiate the mode panel's components
        YearOfTheGryphonPanel yearOfTheGryphonPanel = new YearOfTheGryphonPanel();
        YearOfThePhoenixPanel yearOfThePhoenixPanel = new YearOfThePhoenixPanel();
        YearOfTheDragonPanel yearOfTheDragonPanel = new YearOfTheDragonPanel();
        YearOfTheRavenPanel yearOfTheRavenPanel = new YearOfTheRavenPanel();
        YearOfTheMammothPanel yearOfTheMammothPanel = new YearOfTheMammothPanel();
        YearOfTheKrakenPanel yearOfTheKrakenPanel = new YearOfTheKrakenPanel();
        Years1And2Panel years1And2Panel = new Years1And2Panel();
        classicPanel = new ClassicPanel();

        // Add the year panels to a list
        modeYearPanels.add(yearOfTheGryphonPanel);
        modeYearPanels.add(yearOfThePhoenixPanel);
        modeYearPanels.add(yearOfTheDragonPanel);
        modeYearPanels.add(yearOfTheRavenPanel);
        modeYearPanels.add(yearOfTheMammothPanel);
        modeYearPanels.add(yearOfTheKrakenPanel);
        modeYearPanels.add(years1And2Panel);

        // Add the components to the mode panel
        add(yearOfTheGryphonPanel);
        add(yearOfThePhoenixPanel);
        add(yearOfTheDragonPanel);
        add(yearOfTheRavenPanel);
        add(yearOfTheMammothPanel);
        add(yearOfTheKrakenPanel);
        add(years1And2Panel);
        add(classicPanel);
    }
}
