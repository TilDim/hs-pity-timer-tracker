package tildim.hstools.hspitytimertracker.gui.panel.mode;

import lombok.Getter;

import javax.swing.*;
import java.awt.*;
import java.io.Serial;

/**
 * {@code AllModesPanel} is a {@link #JPanel} that contains all the instances of {@code AbstractModePanel}.
 *
 * @author Tilemachos Dimos
 * @see AbstractModePanel
 */
@Getter
public class AllModesPanel extends JPanel {

    @Serial
    private static final long serialVersionUID = 2956003464546589251L;

    private final CardLayout layout;

    private final StandardModePanel standardModePanel;
    private final JScrollPane standardModePanelScrollPane;

    private final WildModePanel wildModePanel;
    private final JScrollPane wildModePanelScrollPane;

    /**
     * Constructs a {@link #JPanel}, sets its layout and places in it:
     * <ul>
     *     <li>
     *         a {@code JScrollPane} containing a {@code StandardModePanel};
     *     </li>
     *     <li>
     *         a {@code JScrollPane} containing a {@code WildModePanel}.
     *     </li>
     * </ul>
     *
     * @see JScrollPane
     */
    public AllModesPanel() {
        super();

        layout = new CardLayout();
        setLayout(layout);

        // 'Standard' mode panel
        standardModePanel = new StandardModePanel();
        standardModePanelScrollPane = createModePanelScrollPane(standardModePanel);

        // 'Wild' mode panel
        wildModePanel = new WildModePanel();
        wildModePanelScrollPane = createModePanelScrollPane(wildModePanel);

        add(standardModePanelScrollPane, "Standard");
        add(wildModePanelScrollPane, "Wild");
    }

    /**
     * Creates a mode panel {@code JScrollPane}.
     *
     * @param modePanel the instance of {@code AbstractModePanel} to be placed in the {@code JScrollPane}
     * @return the mode panel {@code JScrollPane}
     * @see JScrollPane
     */
    private JScrollPane createModePanelScrollPane(AbstractModePanel modePanel) {
        JScrollPane modePanelScrollPane = new JScrollPane(modePanel,
                ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED, ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED);

        modePanelScrollPane.setBorder(BorderFactory.createEmptyBorder());
        modePanelScrollPane.getVerticalScrollBar()
                           .setUnitIncrement(25);
        modePanelScrollPane.getVerticalScrollBar()
                           .setValue(0);

        return modePanelScrollPane;
    }
}
