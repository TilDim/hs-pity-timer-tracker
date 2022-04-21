package tildim.hstools.hspitytimertracker.gui.panel.expansion.modifier.button;

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
 *
 */
public class AddButton extends JButton {

    @Serial
    private static final long serialVersionUID = -4925218753162885452L;

    transient Shape shape;

    /**
     * @param hover
     * @param release
     */
    public AddButton(Color hover, Color release) {
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
