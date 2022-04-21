package tildim.hstools.hspitytimertracker.gui.panel.yearshortcutbuttons;

import lombok.Getter;
import tildim.hstools.hspitytimertracker.gui.panel.yearshortcutbuttons.button.YearOfTheGryphonShortcutButton;
import tildim.hstools.hspitytimertracker.gui.panel.yearshortcutbuttons.button.YearOfTheHydraShortcutButton;

import java.io.Serial;

/**
 *
 */
@Getter
public class StandardYearShortcutButtonsPanel extends AbstractYearShortcutButtonsPanel {

    @Serial
    private static final long serialVersionUID = 268186717057952183L;

    private final YearOfTheHydraShortcutButton yearOfTheHydraShortcutButton;
    private final YearOfTheGryphonShortcutButton yearOfTheGryphonShortcutButton;

    /**
     *
     */
    public StandardYearShortcutButtonsPanel() {
        super();

        yearOfTheHydraShortcutButton = new YearOfTheHydraShortcutButton();
        yearOfTheGryphonShortcutButton = new YearOfTheGryphonShortcutButton();

        add(yearOfTheHydraShortcutButton);
        add(yearOfTheGryphonShortcutButton);
    }
}
