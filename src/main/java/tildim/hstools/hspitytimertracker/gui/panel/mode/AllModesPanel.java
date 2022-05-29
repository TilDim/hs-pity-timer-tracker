package tildim.hstools.hspitytimertracker.gui.panel.mode;

import lombok.Getter;
import tildim.hstools.hspitytimertracker.gui.panel.ScrollablePanel;

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
     *         a {@code StandardModePanel};
     *     </li>
     *     <li>
     *         a {@code WildModePanel}.
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
        standardModePanel.setScrollableWidth(ScrollablePanel.ScrollableSizeHint.FIT);

        standardModePanelScrollPane = new JScrollPane(standardModePanel,
                ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED, ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        standardModePanelScrollPane.setBorder(BorderFactory.createEmptyBorder());
        standardModePanelScrollPane.getVerticalScrollBar()
                                   .setUnitIncrement(25);
        standardModePanelScrollPane.getVerticalScrollBar()
                                   .setValue(0);

        // 'Wild' mode panel
        wildModePanel = new WildModePanel();
        wildModePanel.setScrollableWidth(ScrollablePanel.ScrollableSizeHint.FIT);

        wildModePanelScrollPane = new JScrollPane(wildModePanel,
                ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED, ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        wildModePanelScrollPane.setBorder(BorderFactory.createEmptyBorder());
        wildModePanelScrollPane.getVerticalScrollBar()
                               .setUnitIncrement(25);
        wildModePanelScrollPane.getVerticalScrollBar()
                               .setValue(0);

        add(standardModePanelScrollPane, "Standard");
        add(wildModePanelScrollPane, "Wild");
    }
}
