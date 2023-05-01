package tildim.hstools.hspitytimertracker.gui.panel.yearshortcutbuttons;

import java.io.Serial;
import lombok.Getter;
import tildim.hstools.hspitytimertracker.gui.panel.yearshortcutbuttons.button.YearOfTheHydraShortcutButton;
import tildim.hstools.hspitytimertracker.gui.panel.yearshortcutbuttons.button.YearOfTheWolfShortcutButton;

/**
 * {@code StandardYearShortcutButtonsPanel} is a {@link #JPanel} that contains all the instances of
 * {@code AbstractYearShortcutButton} which belong in the <i>Standard</i> mode.
 *
 * @author Tilemachos Dimos
 * @see AbstractYearShortcutButtonsPanel
 * @see YearOfTheWolfShortcutButton
 * @see YearOfTheHydraShortcutButton
 */
@Getter
public class StandardYearShortcutButtonsPanel extends AbstractYearShortcutButtonsPanel {

    @Serial
    private static final long serialVersionUID = 268186717057952183L;

    /**
     * Constructs a {@link #AbstractYearShortcutButtonsPanel} and places in it:
     * <ul>
     *     <li>
     *         a {@code YearOfTheWolfShortcutButton};
     *     </li>
     *     <li>
     *         a {@code YearOfTheHydraShortcutButton}.
     *     </li>
     * </ul>
     */
    public StandardYearShortcutButtonsPanel() {
        super();

        // Instantiate the year shortcut buttons panel's components
        YearOfTheWolfShortcutButton yearOfTheWolfShortcutButton = new YearOfTheWolfShortcutButton();
        YearOfTheHydraShortcutButton yearOfTheHydraShortcutButton = new YearOfTheHydraShortcutButton();

        // Add the year shortcut buttons to a list
        modeYearShortcutButtons.add(yearOfTheWolfShortcutButton);
        modeYearShortcutButtons.add(yearOfTheHydraShortcutButton);

        // Add the components to the year shortcut buttons panel
        add(yearOfTheWolfShortcutButton);
        add(yearOfTheHydraShortcutButton);
    }

}
