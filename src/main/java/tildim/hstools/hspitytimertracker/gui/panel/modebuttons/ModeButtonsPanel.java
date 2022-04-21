package tildim.hstools.hspitytimertracker.gui.panel.modebuttons;

import lombok.Getter;
import tildim.hstools.hspitytimertracker.gui.panel.modebuttons.button.StandardModeButton;
import tildim.hstools.hspitytimertracker.gui.panel.modebuttons.button.WildModeButton;

import javax.swing.*;
import java.awt.*;
import java.io.Serial;

/**
 *
 */
@Getter
public class ModeButtonsPanel extends JPanel {

    @Serial
    private static final long serialVersionUID = -6669699590389190860L;

    private final StandardModeButton standardModeButton;
    private final WildModeButton wildModeButton;

    /**
     *
     */
    public ModeButtonsPanel() {
        super();
        setLayout(new GridLayout(1, 2, 0, 0));

        standardModeButton = new StandardModeButton();
        wildModeButton = new WildModeButton();

        add(standardModeButton);
        add(wildModeButton);
    }
}
