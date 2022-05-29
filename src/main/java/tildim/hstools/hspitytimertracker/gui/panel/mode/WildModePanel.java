package tildim.hstools.hspitytimertracker.gui.panel.mode;

import lombok.Getter;
import tildim.hstools.hspitytimertracker.gui.panel.expansion.ClassicPanel;
import tildim.hstools.hspitytimertracker.gui.panel.year.*;

import java.io.Serial;

/**
 * {@code WildModePanel} is a {@link #JPanel} that contains all the instances of {@code AbstractYearPanel}
 * which belong in the <i>Wild</i> mode and a <i>Classic</i> {@code AbstractExpansionPanel}.
 *
 * @author Tilemachos Dimos
 * @see AbstractModePanel
 */
@Getter
public class WildModePanel extends AbstractModePanel {

    @Serial
    private static final long serialVersionUID = -5341838223757909385L;

    private final YearOfThePhoenixPanel yearOfThePhoenixPanel;
    private final YearOfTheDragonPanel yearOfTheDragonPanel;
    private final YearOfTheRavenPanel yearOfTheRavenPanel;
    private final YearOfTheMammothPanel yearOfTheMammothPanel;
    private final YearOfTheKrakenPanel yearOfTheKrakenPanel;
    private final Years1And2Panel years1And2Panel;
    private final ClassicPanel classicPanel;

    /**
     * Constructs a {@link #AbstractModePanel} and places in it the instances of {@code AbstractYearPanel}
     * which belong in the <i>Wild</i> mode.
     */
    public WildModePanel() {
        super();

        yearOfThePhoenixPanel = new YearOfThePhoenixPanel();
        yearOfTheDragonPanel = new YearOfTheDragonPanel();
        yearOfTheRavenPanel = new YearOfTheRavenPanel();
        yearOfTheMammothPanel = new YearOfTheMammothPanel();
        yearOfTheKrakenPanel = new YearOfTheKrakenPanel();
        years1And2Panel = new Years1And2Panel();
        classicPanel = new ClassicPanel();

        add(yearOfThePhoenixPanel);
        add(yearOfTheDragonPanel);
        add(yearOfTheRavenPanel);
        add(yearOfTheMammothPanel);
        add(yearOfTheKrakenPanel);
        add(years1And2Panel);
        add(classicPanel);
    }
}
