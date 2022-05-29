package tildim.hstools.hspitytimertracker.gui.panel.yearshortcutbuttons.button;

import lombok.extern.slf4j.Slf4j;
import tildim.hstools.hspitytimertracker.gui.panel.mode.AbstractModePanel;
import tildim.hstools.hspitytimertracker.gui.panel.year.AbstractYearPanel;
import tildim.hstools.hspitytimertracker.gui.panel.yearshortcutbuttons.AbstractYearShortcutButtonsPanel;
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

    private transient BufferedImage yearShortcutIcon;

    /**
     * Constructs a {@link #JButton} and sets some of its properties.
     *
     * @param iconPath the icon's path from the source root
     * @param tooltip  the tooltip text displayed when hovering over the {@code AbstractYearShortcutButton}
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
     * Creates the year shortcut icon.
     *
     * @param iconPath the icon's path from the source root
     */
    private void createYearShortcutIcon(String iconPath) {
        try {
            yearShortcutIcon = IconHelper.createIcon(iconPath);
        } catch (IOException e) {
            log.error("Error while creating year shortcut icon");
            e.printStackTrace();
        }
    }
}
