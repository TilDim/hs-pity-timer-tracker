package tildim.hstools.hspitytimertracker.gui.panel.yearshortcutbuttons;

import lombok.Getter;
import tildim.hstools.hspitytimertracker.gui.panel.yearshortcutbuttons.button.YearOfTheGryphonShortcutButton;
import tildim.hstools.hspitytimertracker.gui.panel.yearshortcutbuttons.button.YearOfTheHydraShortcutButton;

import java.io.Serial;

/**
 * {@code StandardYearShortcutButtonsPanel} is a {@link #JPanel} that contains all the instances of
 * {@code AbstractYearShortcutButton} which belong in the <i>Standard</i> mode.
 *
 * @author Tilemachos Dimos
 * @see AbstractYearShortcutButtonsPanel
 */
@Getter
public class StandardYearShortcutButtonsPanel extends AbstractYearShortcutButtonsPanel {

    @Serial
    private static final long serialVersionUID = 268186717057952183L;

    private final YearOfTheHydraShortcutButton yearOfTheHydraShortcutButton;
    private final YearOfTheGryphonShortcutButton yearOfTheGryphonShortcutButton;

    /**
     * Constructs a {@link #AbstractYearShortcutButtonsPanel} and places in it the instances of
     * {@code AbstractYearShortcutButton} which belong in the <i>Standard</i> mode.
     */
    public StandardYearShortcutButtonsPanel() {
        super();

        yearOfTheHydraShortcutButton = new YearOfTheHydraShortcutButton();
        yearOfTheGryphonShortcutButton = new YearOfTheGryphonShortcutButton();

        add(yearOfTheHydraShortcutButton);
        add(yearOfTheGryphonShortcutButton);
    }
}
