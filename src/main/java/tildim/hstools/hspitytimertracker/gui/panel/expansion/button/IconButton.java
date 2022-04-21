package tildim.hstools.hspitytimertracker.gui.panel.expansion.button;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.Serial;

/**
 *
 */
public class IconButton extends JButton {

    @Serial
    private static final long serialVersionUID = 4234518202156599061L;

    /**
     * @param icon
     * @param tooltip
     */
    public IconButton(BufferedImage icon, String tooltip) {
        super();

        setIcon(new ImageIcon(icon));
        setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 0));

        setToolTipText(tooltip);
        setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));

        setContentAreaFilled(false);
        setFocusPainted(false);
    }
}
