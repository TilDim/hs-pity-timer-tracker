package tildim.hstools.hspitytimertracker.gui.panel.header.button;

import java.awt.Cursor;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.io.Serial;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import tildim.hstools.hspitytimertracker.gui.panel.header.HeaderPanel;

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
     * @param iconPair an array containing the {@code BufferedImage}s used as the {@code HeaderButton}'s icons
     *                 when the mouse enters and exits it
     * @param tooltip  the tooltip text displayed when hovering over the {@code HeaderButton}
     */
    public HeaderButton(BufferedImage[] iconPair, String tooltip) {
        super();

        setIcon(new ImageIcon(iconPair[0]));
        setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 0));

        setToolTipText(tooltip);
        setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));

        setFocusPainted(false);
        setContentAreaFilled(false);

        addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent evt) {
                setIcon(new ImageIcon(iconPair[1]));
            }

            @Override
            public void mouseExited(MouseEvent evt) {
                setIcon(new ImageIcon(iconPair[0]));
            }
        });
    }

}
