package tildim.hstools.hspitytimertracker.gui.panel.popup;

import tildim.hstools.hspitytimertracker.gui.panel.header.button.HeaderButton;
import tildim.hstools.hspitytimertracker.util.Text;

import javax.swing.*;
import java.awt.*;
import java.io.Serial;

/**
 * {@code HelpPopupWindowPanel} is a {@link #JPanel} that is used for displaying the content of the pop-up window
 * that pops after the <i>Help</i> {@code HeaderButton} is pressed.
 *
 * @author Tilemachos Dimos
 * @see AbstractPopupWindowPanel
 * @see HeaderButton
 */
public class HelpPopupWindowPanel extends AbstractPopupWindowPanel {

    @Serial
    private static final long serialVersionUID = 791660118665287111L;

    /**
     * Constructs a {@link #AbstractPopupWindowPanel} and places in it a {@code JScrollPane} containing its body.
     *
     * @param text the text of the {@code HelpPopupWindowPanel}
     * @see JScrollPane
     */
    public HelpPopupWindowPanel(String text) {
        super(Text.TRACKER_TITLE, text);

        // "Help" text container
        JScrollPane helpMessagePanel = new JScrollPane(super.getBody(),
                ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED, ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        helpMessagePanel.setPreferredSize(new Dimension(640, 360));
        helpMessagePanel.setBorder(BorderFactory.createEmptyBorder());
        helpMessagePanel.getVerticalScrollBar()
                        .setUnitIncrement(15);
        helpMessagePanel.getVerticalScrollBar()
                        .setValue(0);

        add(helpMessagePanel);
    }
}
