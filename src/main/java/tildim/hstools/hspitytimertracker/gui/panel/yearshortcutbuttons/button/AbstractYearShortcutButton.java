package tildim.hstools.hspitytimertracker.gui.panel.yearshortcutbuttons.button;

import java.awt.Cursor;
import java.awt.Graphics;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.Serial;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import lombok.extern.slf4j.Slf4j;
import tildim.hstools.hspitytimertracker.gui.panel.mode.AbstractModePanel;
import tildim.hstools.hspitytimertracker.gui.panel.year.AbstractYearPanel;
import tildim.hstools.hspitytimertracker.gui.panel.yearshortcutbuttons.AbstractYearShortcutButtonsPanel;
import tildim.hstools.hspitytimertracker.util.Colors;
import tildim.hstools.hspitytimertracker.util.icon.IconHelper;

/**
 * {@code AbstractYearShortcutButton} is a {@link #JButton} located in a {@code AbstractYearShortcutButtonsPanel}
 * that moves the scrollbar of a {@code AbstractModePanel} to the position of the corresponding
 * {@code AbstractYearPanel}, when pressed.
 *
 * @author Tilemachos Dimos
 * @see AbstractYearShortcutButtonsPanel
 * @see AbstractModePanel
 * @see AbstractYearPanel
 */
@Slf4j
public class AbstractYearShortcutButton extends JButton {

    @Serial
    private static final long serialVersionUID = 4179431845956576843L;

    /**
     * Constructs a {@link #JButton} and sets some of its properties.
     *
     * @param iconPath the icon's path from the source root
     * @param tooltip  the tooltip text displayed when hovering over the {@code AbstractYearShortcutButton}
     */
    protected AbstractYearShortcutButton(String iconPath, String tooltip) {
        super();

        setIcon(new ImageIcon(createYearShortcutIcon(iconPath)));
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
     * Creates a year shortcut icon.
     *
     * @param iconPath the icon's path from the source root
     * @return the year shortcut icon
     */
    private BufferedImage createYearShortcutIcon(String iconPath) {
        BufferedImage icon = null;

        try {
            icon = IconHelper.createIcon(iconPath);
        } catch (IOException e) {
            log.error("Error while creating year shortcut icon", e);
        }

        return icon;
    }

}
