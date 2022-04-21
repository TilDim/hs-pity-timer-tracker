package tildim.hstools.hspitytimertracker.gui.panel.yearshortcutbuttons;

import tildim.hstools.hspitytimertracker.util.Colors;

import javax.swing.*;
import java.awt.*;
import java.io.Serial;

/**
 *
 */
public class AbstractYearShortcutButtonsPanel extends JPanel {

    @Serial
    private static final long serialVersionUID = -8412661119548543604L;

    /**
     *
     */
    protected AbstractYearShortcutButtonsPanel() {
        super();
        setLayout(new FlowLayout(FlowLayout.CENTER, 20, 3));
        setBackground(Colors.MODE_SELECTED_COLOR);
    }
}
