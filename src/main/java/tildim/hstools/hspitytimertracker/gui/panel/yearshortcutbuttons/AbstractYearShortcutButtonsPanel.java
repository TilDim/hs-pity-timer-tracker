package tildim.hstools.hspitytimertracker.gui.panel.yearshortcutbuttons;

import java.awt.FlowLayout;
import java.io.Serial;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JPanel;
import lombok.Getter;
import tildim.hstools.hspitytimertracker.gui.panel.yearshortcutbuttons.button.AbstractYearShortcutButton;
import tildim.hstools.hspitytimertracker.util.Colors;

/**
 * {@code AbstractYearShortcutButtonsPanel} is a {@link #JPanel} that contains all the instances of
 * {@code AbstractYearShortcutButton} which belong in a specific mode.
 *
 * @author Tilemachos Dimos
 * @see AbstractYearShortcutButton
 */
@Getter
public class AbstractYearShortcutButtonsPanel extends JPanel {

    @Serial
    private static final long serialVersionUID = -8412661119548543604L;

    protected final List<AbstractYearShortcutButton> modeYearShortcutButtons;

    /**
     * Constructs a {@link #JPanel} and sets some of its properties.
     */
    protected AbstractYearShortcutButtonsPanel() {
        super();

        setLayout(new FlowLayout(FlowLayout.CENTER, 20, 3));
        setBackground(Colors.MODE_SELECTED_COLOR);

        modeYearShortcutButtons = new ArrayList<>();
    }

}
