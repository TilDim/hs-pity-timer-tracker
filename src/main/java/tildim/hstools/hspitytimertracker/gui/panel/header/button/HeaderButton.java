package tildim.hstools.hspitytimertracker.gui.panel.header.button;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.io.Serial;

/**
 *
 */
public class HeaderButton extends JButton {

    @Serial
    private static final long serialVersionUID = 217934912304797685L;

    /**
     * @param icon
     * @param hoverIcon
     */
    public HeaderButton(BufferedImage icon, BufferedImage hoverIcon, String tooltip) {
        super(new ImageIcon(icon));

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
