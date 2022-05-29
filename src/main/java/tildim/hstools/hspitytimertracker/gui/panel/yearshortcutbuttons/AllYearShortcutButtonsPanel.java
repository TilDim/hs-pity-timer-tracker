package tildim.hstools.hspitytimertracker.gui.panel.yearshortcutbuttons;

import lombok.Getter;

import javax.swing.*;
import java.awt.*;
import java.io.Serial;

/**
 * {@code AllYearShortcutButtonsPanel} is a {@link #JPanel} that contains all the instances of
 * {@code AbstractYearShortcutButtonsPanel}.
 *
 * @author Tilemachos Dimos
 * @see AbstractYearShortcutButtonsPanel
 */
@Getter
public class AllYearShortcutButtonsPanel extends JPanel {

    @Serial
    private static final long serialVersionUID = 3695342663979759480L;

    private final CardLayout layout;

    private final StandardYearShortcutButtonsPanel standardYearShortcutButtonsPanel;
    private final WildYearShortcutButtonsPanel wildYearShortcutButtonsPanel;

    /**
     * Constructs a {@link #JPanel}, sets its layout and places in it:
     * <ul>
     *     <li>
     *         a {@code StandardYearShortcutButtonsPanel};
     *     </li>
     *     <li>
     *         a {@code WildYearShortcutButtonsPanel}.
     *     </li>
     * </ul>
     */
    public AllYearShortcutButtonsPanel() {
        super();

        layout = new CardLayout();
        setLayout(layout);

        // 'Standard' year shortcut buttons panel
        standardYearShortcutButtonsPanel = new StandardYearShortcutButtonsPanel();

        // 'Wild' year shortcut buttons panel
        wildYearShortcutButtonsPanel = new WildYearShortcutButtonsPanel();

        add(standardYearShortcutButtonsPanel, "Standard");
        add(wildYearShortcutButtonsPanel, "Wild");
    }
}
