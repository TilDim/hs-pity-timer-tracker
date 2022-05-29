package tildim.hstools.hspitytimertracker.gui.panel.yearshortcutbuttons;

import lombok.Getter;
import tildim.hstools.hspitytimertracker.gui.panel.yearshortcutbuttons.button.*;

import java.io.Serial;

/**
 * {@code WildYearShortcutButtonsPanel} is a {@link #JPanel} that contains all the instances of
 * {@code AbstractYearShortcutButton} which belong in the <i>Wild</i> mode.
 *
 * @author Tilemachos Dimos
 * @see AbstractYearShortcutButtonsPanel
 */
@Getter
public class WildYearShortcutButtonsPanel extends AbstractYearShortcutButtonsPanel {

    @Serial
    private static final long serialVersionUID = -5031717524168654726L;

    private final YearOfThePhoenixShortcutButton yearOfThePhoenixShortcutButton;
    private final YearOfTheDragonShortcutButton yearOfTheDragonShortcutButton;
    private final YearOfTheRavenShortcutButton yearOfTheRavenShortcutButton;
    private final YearOfTheMammothShortcutButton yearOfTheMammothShortcutButton;
    private final YearOfTheKrakenShortcutButton yearOfTheKrakenShortcutButton;
    private final Years1And2ShortcutButton years1And2ShortcutButton;

    /**
     * Constructs a {@link #AbstractYearShortcutButtonsPanel} and places in it the instances of
     * {@code AbstractYearShortcutButton} which belong in the <i>Wild</i> mode.
     */
    public WildYearShortcutButtonsPanel() {
        super();

        yearOfThePhoenixShortcutButton = new YearOfThePhoenixShortcutButton();
        yearOfTheDragonShortcutButton = new YearOfTheDragonShortcutButton();
        yearOfTheRavenShortcutButton = new YearOfTheRavenShortcutButton();
        yearOfTheMammothShortcutButton = new YearOfTheMammothShortcutButton();
        yearOfTheKrakenShortcutButton = new YearOfTheKrakenShortcutButton();
        years1And2ShortcutButton = new Years1And2ShortcutButton();

        add(yearOfThePhoenixShortcutButton);
        add(yearOfTheDragonShortcutButton);
        add(yearOfTheRavenShortcutButton);
        add(yearOfTheMammothShortcutButton);
        add(yearOfTheKrakenShortcutButton);
        add(years1And2ShortcutButton);
    }
}
