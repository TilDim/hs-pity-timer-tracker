package tildim.hstools.hspitytimertracker.gui.panel.tracker;

import lombok.Getter;
import tildim.hstools.hspitytimertracker.gui.panel.ScrollablePanel;
import tildim.hstools.hspitytimertracker.gui.panel.header.HeaderPanel;
import tildim.hstools.hspitytimertracker.gui.panel.mode.StandardModePanel;
import tildim.hstools.hspitytimertracker.gui.panel.mode.WildModePanel;
import tildim.hstools.hspitytimertracker.gui.panel.modebuttons.ModeButtonsPanel;
import tildim.hstools.hspitytimertracker.gui.panel.yearshortcutbuttons.StandardYearShortcutButtonsPanel;
import tildim.hstools.hspitytimertracker.gui.panel.yearshortcutbuttons.WildYearShortcutButtonsPanel;

import javax.swing.*;
import java.awt.*;
import java.io.Serial;

/**
 *
 */
@Getter
public class TrackerPanel extends JPanel {

    @Serial
    private static final long serialVersionUID = 7403028887884226194L;

    private final HeaderPanel headerPanel;

    private final ModeButtonsPanel modeButtonsPanel;

    private final JPanel yearShortcutButtonsPanel;
    private final CardLayout yearShortcutButtonsPanelLayout;

    private final StandardYearShortcutButtonsPanel standardYearShortcutButtonsPanel;
    private final WildYearShortcutButtonsPanel wildYearShortcutButtonsPanel;

    private final JPanel mainPanel;
    private final CardLayout mainPanelLayout;

    private final JScrollPane standardModePanelContainer;
    private final JScrollPane wildModePanelContainer;

    private final StandardModePanel standardModePanel;
    private final WildModePanel wildModePanel;

    /**
     *
     */
    public TrackerPanel() {
        super();

        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

        // Header panel
        headerPanel = new HeaderPanel();

        // Mode buttons panel
        modeButtonsPanel = new ModeButtonsPanel();

        // Year shortcut buttons panel
        yearShortcutButtonsPanel = new JPanel();
        yearShortcutButtonsPanelLayout = new CardLayout();
        yearShortcutButtonsPanel.setLayout(yearShortcutButtonsPanelLayout);

        // 'Standard' year shortcut buttons panel
        standardYearShortcutButtonsPanel = new StandardYearShortcutButtonsPanel();

        // 'Wild' year shortcut buttons panel
        wildYearShortcutButtonsPanel = new WildYearShortcutButtonsPanel();

        yearShortcutButtonsPanel.add(standardYearShortcutButtonsPanel, "Standard");
        yearShortcutButtonsPanel.add(wildYearShortcutButtonsPanel, "Wild");

        // Main panel
        mainPanel = new JPanel();
        mainPanelLayout = new CardLayout();
        mainPanel.setLayout(mainPanelLayout);

        // 'Standard' mode panel
        standardModePanel = new StandardModePanel();
        standardModePanel.setScrollableWidth(ScrollablePanel.ScrollableSizeHint.FIT);

        standardModePanelContainer = new JScrollPane(standardModePanel, ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED, ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        standardModePanelContainer.setBorder(BorderFactory.createEmptyBorder());
        standardModePanelContainer.getVerticalScrollBar()
                                  .setUnitIncrement(25);
        standardModePanelContainer.getVerticalScrollBar()
                                  .setValue(0);

        // 'Wild' mode panel
        wildModePanel = new WildModePanel();
        wildModePanel.setScrollableWidth(ScrollablePanel.ScrollableSizeHint.FIT);

        wildModePanelContainer = new JScrollPane(wildModePanel, ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED, ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        wildModePanelContainer.setBorder(BorderFactory.createEmptyBorder());
        wildModePanelContainer.getVerticalScrollBar()
                              .setUnitIncrement(25);
        wildModePanelContainer.getVerticalScrollBar()
                              .setValue(0);

        mainPanel.add(standardModePanelContainer, "Standard");
        mainPanel.add(wildModePanelContainer, "Wild");

        add(headerPanel);
        add(modeButtonsPanel);
        add(yearShortcutButtonsPanel);
        add(mainPanel);
    }
}
