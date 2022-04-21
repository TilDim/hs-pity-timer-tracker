package tildim.hstools.hspitytimertracker.gui.panel.popup;

import tildim.hstools.hspitytimertracker.util.Text;

import javax.swing.*;
import java.awt.*;
import java.io.Serial;

/**
 *
 */
public class HelpPopupWindowPanel extends AbstractPopupWindowPanel {

    @Serial
    private static final long serialVersionUID = 791660118665287111L;

    /**
     * @param message
     */
    public HelpPopupWindowPanel(String message) {
        super(Text.TRACKER_TITLE, message);

        // "Help" message container
        JScrollPane helpMessagePanel = new JScrollPane(super.getContent(), ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED, ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        helpMessagePanel.setPreferredSize(new Dimension(900, 450));
        helpMessagePanel.setBorder(BorderFactory.createEmptyBorder());
        helpMessagePanel.getVerticalScrollBar()
                        .setUnitIncrement(15);
        helpMessagePanel.getVerticalScrollBar()
                        .setValue(0);

        add(helpMessagePanel);
    }
}
