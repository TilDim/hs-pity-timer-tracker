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
    private final StandardYearShortcutButtonsPanel standardYearShortcutButtonsPanel;
    private final WildYearShortcutButtonsPanel wildYearShortcutButtonsPanel;
    private final StandardModePanel standardModePanel;
    private final WildModePanel wildModePanel;
    private final JScrollPane mainPanelContainer;

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

        // 'Standard' year shortcut buttons panel
        standardYearShortcutButtonsPanel = new StandardYearShortcutButtonsPanel();

        // 'Wild' year shortcut buttons panel
        wildYearShortcutButtonsPanel = new WildYearShortcutButtonsPanel();

        // Main panel
        ScrollablePanel mainPanel = new ScrollablePanel();
        mainPanel.setScrollableWidth(ScrollablePanel.ScrollableSizeHint.FIT);
        mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS));

        standardModePanel = new StandardModePanel();
        wildModePanel = new WildModePanel();
        mainPanel.add(standardModePanel);
        mainPanel.add(wildModePanel);

        // Main panel container
        mainPanelContainer = new JScrollPane(mainPanel, ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED, ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        mainPanelContainer.setBorder(BorderFactory.createEmptyBorder());
        mainPanelContainer.getVerticalScrollBar()
                          .setUnitIncrement(25);
        mainPanelContainer.getVerticalScrollBar()
                          .setValue(0);

        add(headerPanel);
        add(modeButtonsPanel);
        add(standardYearShortcutButtonsPanel);
        add(wildYearShortcutButtonsPanel);
        add(mainPanelContainer);
    }
}
