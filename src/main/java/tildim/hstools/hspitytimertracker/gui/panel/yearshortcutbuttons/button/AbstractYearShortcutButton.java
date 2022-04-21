package tildim.hstools.hspitytimertracker.gui.panel.yearshortcutbuttons.button;

import tildim.hstools.hspitytimertracker.exception.IconCreationException;
import tildim.hstools.hspitytimertracker.util.Colors;
import tildim.hstools.hspitytimertracker.util.icon.IconHelper;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.Serial;

/**
 *
 */
public class AbstractYearShortcutButton extends JButton {

    @Serial
    private static final long serialVersionUID = 4179431845956576843L;

    private transient BufferedImage yearShortcutIcon;

    /**
     * @param iconPath
     * @param tooltip
     */
    protected AbstractYearShortcutButton(String iconPath, String tooltip) {
        super();

        // Icon creation
        createYearShortcutIcon(iconPath);

        setIcon(new ImageIcon(yearShortcutIcon));
        setBackground(Colors.MODE_SELECTED_COLOR);
        setBorder(BorderFactory.createEmptyBorder(2, 2, 2, 2));

        setToolTipText(tooltip);
        setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        setFocusPainted(false);
        setContentAreaFilled(false);

        addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent evt) {
                setBackground(Colors.MODE_UNSELECTED_COLOR);
            }

            @Override
            public void mouseExited(MouseEvent evt) {
                setBackground(Colors.MODE_SELECTED_COLOR);
            }
        });
    }

    @Override
    protected void paintComponent(Graphics g) {
        if (getModel().isArmed()) {
            g.setColor(Colors.MODE_MOUSE_HOVER_COLOR);
        } else {
            g.setColor(getBackground());
        }

        g.fillRect(0, 0, getWidth(), getHeight());

        super.paintComponent(g);
    }

    /**
     * Creates the year shortcut icon
     *
     * @param iconPath is the icon's path from the source root
     * @throws IconCreationException is thrown when the IconUtil.createIcon method fails to create the url of a path to an image
     */
    private void createYearShortcutIcon(String iconPath) throws IconCreationException {
        try {
            yearShortcutIcon = IconHelper.createIcon(iconPath);
        } catch (IOException e) {
            throw new IconCreationException("Error while creating year shortcut icon", e.getCause());
        }
    }
}
