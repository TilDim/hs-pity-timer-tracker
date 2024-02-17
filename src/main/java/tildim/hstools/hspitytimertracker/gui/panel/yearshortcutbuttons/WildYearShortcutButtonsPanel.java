package tildim.hstools.hspitytimertracker.gui.panel.yearshortcutbuttons;

import java.io.Serial;
import lombok.Getter;
import tildim.hstools.hspitytimertracker.gui.panel.yearshortcutbuttons.button.*;

/**
 * {@code WildYearShortcutButtonsPanel} is a {@link #JPanel} that contains all the instances of
 * {@code AbstractYearShortcutButton} which belong in the <i>Wild</i> mode.
 *
 * @author Tilemachos Dimos
 * @see AbstractYearShortcutButtonsPanel
 * @see YearOfTheHydraShortcutButton
 * @see YearOfTheGryphonShortcutButton
 * @see YearOfThePhoenixShortcutButton
 * @see YearOfTheDragonShortcutButton
 * @see YearOfTheRavenShortcutButton
 * @see YearOfTheMammothShortcutButton
 * @see YearOfTheKrakenShortcutButton
 * @see Years1And2ShortcutButton
 */
@Getter
public class WildYearShortcutButtonsPanel extends AbstractYearShortcutButtonsPanel {

    @Serial
    private static final long serialVersionUID = -5031717524168654726L;

    /**
     * Constructs a {@link #AbstractYearShortcutButtonsPanel} and places in it:
     * <ul>
     *     <li>
     *         a {@code YearOfTheHydraShortcutButton};
     *     </li>
     *     <li>
     *         a {@code YearOfTheGryphonShortcutButton};
     *     </li>
     *     <li>
     *         a {@code YearOfThePhoenixShortcutButton};
     *     </li>
     *     <li>
     *         a {@code YearOfTheDragonShortcutButton};
     *     </li>
     *     <li>
     *         a {@code YearOfTheRavenShortcutButton};
     *     </li>
     *     <li>
     *         a {@code YearOfTheMammothShortcutButton};
     *     </li>
     *     <li>
     *         a {@code YearOfTheKrakenShortcutButton};
     *     </li>
     *     <li>
     *         a {@code Years1And2ShortcutButton}.
     *     </li>
     * </ul>
     */
    public WildYearShortcutButtonsPanel() {
        super();

        // Instantiate the year shortcut buttons panel's components
        YearOfTheHydraShortcutButton yearOfTheHydraShortcutButton = new YearOfTheHydraShortcutButton();
        YearOfTheGryphonShortcutButton yearOfTheGryphonShortcutButton = new YearOfTheGryphonShortcutButton();
        YearOfThePhoenixShortcutButton yearOfThePhoenixShortcutButton = new YearOfThePhoenixShortcutButton();
        YearOfTheDragonShortcutButton yearOfTheDragonShortcutButton = new YearOfTheDragonShortcutButton();
        YearOfTheRavenShortcutButton yearOfTheRavenShortcutButton = new YearOfTheRavenShortcutButton();
        YearOfTheMammothShortcutButton yearOfTheMammothShortcutButton = new YearOfTheMammothShortcutButton();
        YearOfTheKrakenShortcutButton yearOfTheKrakenShortcutButton = new YearOfTheKrakenShortcutButton();
        Years1And2ShortcutButton years1And2ShortcutButton = new Years1And2ShortcutButton();

        // Add the year shortcut buttons to a list
        modeYearShortcutButtons.add(yearOfTheHydraShortcutButton);
        modeYearShortcutButtons.add(yearOfTheGryphonShortcutButton);
        modeYearShortcutButtons.add(yearOfThePhoenixShortcutButton);
        modeYearShortcutButtons.add(yearOfTheDragonShortcutButton);
        modeYearShortcutButtons.add(yearOfTheRavenShortcutButton);
        modeYearShortcutButtons.add(yearOfTheMammothShortcutButton);
        modeYearShortcutButtons.add(yearOfTheKrakenShortcutButton);
        modeYearShortcutButtons.add(years1And2ShortcutButton);

        // Add the components to the year shortcut buttons panel
        add(yearOfTheHydraShortcutButton);
        add(yearOfTheGryphonShortcutButton);
        add(yearOfThePhoenixShortcutButton);
        add(yearOfTheDragonShortcutButton);
        add(yearOfTheRavenShortcutButton);
        add(yearOfTheMammothShortcutButton);
        add(yearOfTheKrakenShortcutButton);
        add(years1And2ShortcutButton);
    }

}
