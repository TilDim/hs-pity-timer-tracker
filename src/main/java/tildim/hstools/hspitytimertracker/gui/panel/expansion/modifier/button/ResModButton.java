package tildim.hstools.hspitytimertracker.gui.panel.expansion.modifier.button;

import tildim.hstools.hspitytimertracker.util.Colors;
import tildim.hstools.hspitytimertracker.util.Fonts;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.Serial;

/**
 *
 */
public class ResModButton extends JButton {

    @Serial
    private static final long serialVersionUID = -354653197514627820L;

    /**
     * @param label
     * @param tooltip
     * @param hover
     * @param release
     */
    public ResModButton(String label, String tooltip, Color hover, Color release) {
        super(label);

        setBorder(BorderFactory.createEmptyBorder(5, 10, 5, 10));
        setFont(Fonts.BUTTON_FONT);

        setToolTipText(tooltip);
        setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));

        setFocusPainted(false);
        setContentAreaFilled(false);

        addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent evt) {
                setBackground(hover);
            }

            @Override
            public void mouseExited(MouseEvent evt) {
                setBackground(release);
            }
        });
    }

    @Override
    protected void paintComponent(Graphics g) {
        if (getModel().isArmed()) {
            g.setColor(Colors.BUTTON_PRESSED_COLOR);
        } else {
            g.setColor(getBackground());
        }

        g.fillRect(0, 0, getWidth(), getHeight());

        super.paintComponent(g);
    }
}
