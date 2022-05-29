package tildim.hstools.hspitytimertracker.gui.panel.header.button;

import tildim.hstools.hspitytimertracker.gui.panel.header.HeaderPanel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.io.Serial;

/**
 * {@code HeaderButton} is a {@link #JButton} located in the {@code HeaderPanel} that provides assisting functionality.
 *
 * @author Tilemachos Dimos
 * @see HeaderPanel
 */
public class HeaderButton extends JButton {

    @Serial
    private static final long serialVersionUID = 217934912304797685L;

    /**
     * Constructs a {@link #JButton} and sets some of its properties.
     *
     * @param icon      a {@code BufferedImage} used as the {@code HeaderButton}'s icon
     * @param hoverIcon a {@code BufferedImage} used as the {@code HeaderButton}'s icon when hovering over it
     * @param tooltip   the tooltip text displayed when hovering over the {@code HeaderButton}
     */
    public HeaderButton(BufferedImage icon, BufferedImage hoverIcon, String tooltip) {
        super();

        setIcon(new ImageIcon(icon));
        setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 0));

        setToolTipText(tooltip);
        setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));

        setFocusPainted(false);
        setContentAreaFilled(false);

        addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent evt) {
                setIcon(new ImageIcon(hoverIcon));
            }

            @Override
            public void mouseExited(MouseEvent evt) {
                setIcon(new ImageIcon(icon));
            }
        });
    }
}
