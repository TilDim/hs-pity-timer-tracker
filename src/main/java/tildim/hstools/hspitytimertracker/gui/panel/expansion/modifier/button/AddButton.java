package tildim.hstools.hspitytimertracker.gui.panel.expansion.modifier.button;

import tildim.hstools.hspitytimertracker.gui.panel.expansion.AbstractExpansionPanel;
import tildim.hstools.hspitytimertracker.gui.panel.expansion.modifier.textfield.IncrementField;
import tildim.hstools.hspitytimertracker.util.Colors;
import tildim.hstools.hspitytimertracker.util.Fonts;
import tildim.hstools.hspitytimertracker.util.Text;
import tildim.hstools.hspitytimertracker.util.Tooltips;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.geom.Ellipse2D;
import java.io.Serial;

/**
 * {@code AddButton} is a {@link #JButton} that increases a counter in a {@code AbstractExpansionPanel}
 * by a number defined in the {@code IncrementField}.
 *
 * @author Tilemachos Dimos
 * @see AbstractExpansionPanel
 * @see IncrementField
 */
public class AddButton extends JButton {

    @Serial
    private static final long serialVersionUID = -4925218753162885452L;

    transient Shape shape;

    /**
     * Constructs a round {@link #JButton} and sets some of its properties.
     *
     * @param enterColor the color when the mouse enters the {@code AddButton}
     * @param exitColor  the color when the mouse exits the {@code AddButton}
     */
    public AddButton(Color enterColor, Color exitColor) {
        super(Text.ADD);

        setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 0));
        setFont(Fonts.ADD_BUTTON_FONT);

        setToolTipText(Tooltips.ADD_BUTTON_TOOLTIP);
        setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));

        setFocusPainted(false);
        setContentAreaFilled(false);

        Dimension size = getPreferredSize();
        size.width = size.height = Math.max(size.width, size.height);
        setPreferredSize(size);

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

        g.fillOval(0, 0, getSize().width - 1, getSize().height - 1);

        super.paintComponent(g);
    }

    @Override
    public boolean contains(int x, int y) {
        if (shape == null || !shape.getBounds()
                                   .equals(getBounds())) {
            shape = new Ellipse2D.Float(0, 0, getWidth(), getHeight());
        }

        return shape.contains(x, y);
    }
}
