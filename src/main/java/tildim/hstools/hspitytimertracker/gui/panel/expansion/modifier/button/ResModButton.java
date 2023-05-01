package tildim.hstools.hspitytimertracker.gui.panel.expansion.modifier.button;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Graphics;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.Serial;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import tildim.hstools.hspitytimertracker.gui.panel.expansion.AbstractExpansionPanel;
import tildim.hstools.hspitytimertracker.util.Colors;
import tildim.hstools.hspitytimertracker.util.Fonts;

/**
 * {@code ResModButton} is a {@link #JButton} that either resets or modifies a counter in a
 * {@code AbstractExpansionPanel}.
 *
 * @author Tilemachos Dimos
 * @see AbstractExpansionPanel
 */
public class ResModButton extends JButton {

    @Serial
    private static final long serialVersionUID = -354653197514627820L;

    /**
     * Constructs a {@link #JButton} and sets some of its properties.
     *
     * @param label      the label of the {@code ResModButton}
     * @param tooltip    the tooltip text displayed when hovering over the {@code ResModButton}
     * @param enterColor the color when the mouse enters the {@code ResModButton}
     * @param exitColor  the color when the mouse exits the {@code ResModButton}
     */
    public ResModButton(String label, String tooltip, Color enterColor, Color exitColor) {
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
                setBackground(enterColor);
            }

            @Override
            public void mouseExited(MouseEvent evt) {
                setBackground(exitColor);
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
