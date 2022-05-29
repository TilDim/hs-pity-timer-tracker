package tildim.hstools.hspitytimertracker.gui.panel.expansion.button;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.Serial;

/**
 * {@code IconButton} is a {@link #JButton} with an icon and no text that is used in a {@code AbstractExpansionPanel}
 * to give an image some functionality (e.g. act as a link to a webpage).
 *
 * @author Tilemachos Dimos
 */
public class IconButton extends JButton {

    @Serial
    private static final long serialVersionUID = 4234518202156599061L;

    /**
     * Constructs a {@link #JButton} and sets some of its properties.
     *
     * @param icon    a {@code BufferedImage} used as the {@code IconButton}'s icon
     * @param tooltip the tooltip text displayed when hovering over the {@code IconButton}
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
