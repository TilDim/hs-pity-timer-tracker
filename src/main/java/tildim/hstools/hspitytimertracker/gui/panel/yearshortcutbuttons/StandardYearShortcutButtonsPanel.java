package tildim.hstools.hspitytimertracker.gui.panel.yearshortcutbuttons;

import java.io.Serial;
import lombok.Getter;
import tildim.hstools.hspitytimertracker.gui.panel.yearshortcutbuttons.button.YearOfThePegasusShortcutButton;
import tildim.hstools.hspitytimertracker.gui.panel.yearshortcutbuttons.button.YearOfTheWolfShortcutButton;

/**
 * {@code StandardYearShortcutButtonsPanel} is a {@link #JPanel} that contains all the instances of
 * {@code AbstractYearShortcutButton} which belong in the <i>Standard</i> mode.
 *
 * @author Tilemachos Dimos
 * @see AbstractYearShortcutButtonsPanel
 * @see YearOfThePegasusShortcutButton
 * @see YearOfTheWolfShortcutButton
 */
@Getter
public class StandardYearShortcutButtonsPanel extends AbstractYearShortcutButtonsPanel {

    @Serial
    private static final long serialVersionUID = 268186717057952183L;

    /**
     * Constructs a {@link #AbstractYearShortcutButtonsPanel} and places in it:
     * <ul>
     *     <li>
     *         a {@code YearOfThePegasusShortcutButton};
     *     </li>
     *     <li>
     *         a {@code YearOfTheWolfShortcutButton}.
     *     </li>
     * </ul>
     */
    public StandardYearShortcutButtonsPanel() {
        super();

        // Instantiate the year shortcut buttons panel's components
        YearOfThePegasusShortcutButton yearOfThePegasusShortcutButton = new YearOfThePegasusShortcutButton();
        YearOfTheWolfShortcutButton yearOfTheWolfShortcutButton = new YearOfTheWolfShortcutButton();

        // Add the year shortcut buttons to a list
        modeYearShortcutButtons.add(yearOfThePegasusShortcutButton);
        modeYearShortcutButtons.add(yearOfTheWolfShortcutButton);

        // Add the components to the year shortcut buttons panel
        add(yearOfThePegasusShortcutButton);
        add(yearOfTheWolfShortcutButton);
    }

}
