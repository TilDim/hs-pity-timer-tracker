package tildim.hstools.hspitytimertracker.gui.panel.yearshortcutbuttons;

import tildim.hstools.hspitytimertracker.gui.panel.yearshortcutbuttons.button.AbstractYearShortcutButton;
import tildim.hstools.hspitytimertracker.util.Colors;

import javax.swing.*;
import java.awt.*;
import java.io.Serial;

/**
 * {@code AbstractYearShortcutButtonsPanel} is a {@link #JPanel} that contains all the instances of
 * {@code AbstractYearShortcutButton} which belong in a specific mode.
 *
 * @author Tilemachos Dimos
 * @see AbstractYearShortcutButton
 */
public class AbstractYearShortcutButtonsPanel extends JPanel {

    @Serial
    private static final long serialVersionUID = -8412661119548543604L;

    /**
     * Constructs a {@link #JPanel} and sets its layout and background color.
     */
    protected AbstractYearShortcutButtonsPanel() {
        super();

        setLayout(new FlowLayout(FlowLayout.CENTER, 20, 3));
        setBackground(Colors.MODE_SELECTED_COLOR);
    }
}
