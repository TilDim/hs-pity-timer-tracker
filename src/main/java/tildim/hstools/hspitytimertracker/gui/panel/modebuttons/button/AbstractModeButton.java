package tildim.hstools.hspitytimertracker.gui.panel.modebuttons.button;

import lombok.Getter;
import tildim.hstools.hspitytimertracker.exception.IconCreationException;
import tildim.hstools.hspitytimertracker.util.Colors;
import tildim.hstools.hspitytimertracker.util.Fonts;
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
public abstract class AbstractModeButton extends JButton {

    @Serial
    private static final long serialVersionUID = 6044135139600565685L;

    private transient BufferedImage modeIcon;

    @Getter
    protected final transient MouseAdapter selectedModeButtonAdapter;

    @Getter
    protected final transient MouseAdapter unselectedModeButtonAdapter;

    /**
     * @param label
     * @param iconPath
     * @param background
     * @param tooltip
     */
    protected AbstractModeButton(String label, String iconPath, Color background, String tooltip) {
        super(" " + label);

        // Icon creation
        createModeIcon(iconPath);

        setIcon(new ImageIcon(modeIcon));
        setBackground(background);
        setFont(Fonts.MODE_FONT);
        setBorder(BorderFactory.createEmptyBorder(5, 0, 5, 0));

        setToolTipText(tooltip);
        setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        setFocusPainted(false);
        setContentAreaFilled(false);

        selectedModeButtonAdapter = new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent evt) {
                setBackground(Colors.MODE_SELECTED_COLOR);
            }

            @Override
            public void mouseExited(MouseEvent evt) {
                setBackground(Colors.MODE_SELECTED_COLOR);
            }
        };

        unselectedModeButtonAdapter = new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent evt) {
                setBackground(Colors.MODE_MOUSE_HOVER_COLOR);
            }

            @Override
            public void mouseExited(MouseEvent evt) {
                setBackground(Colors.MODE_UNSELECTED_COLOR);
            }
        };
    }

    @Override
    protected void paintComponent(Graphics g) {
        if (getModel().isArmed()) {
            g.setColor(Colors.MODE_SELECTED_COLOR);
        } else {
            g.setColor(getBackground());
        }

        g.fillRect(0, 0, getWidth(), getHeight());

        super.paintComponent(g);
    }

    /**
     * Creates the mode icon
     *
     * @param iconPath is the icon's path from the source root
     * @throws IconCreationException is thrown when the IconUtil.createIcon method fails to create the url of a path to an image
     */
    private void createModeIcon(String iconPath) throws IconCreationException {
        try {
            modeIcon = IconHelper.createIcon(iconPath);
        } catch (IOException e) {
            throw new IconCreationException("Error while creating mode icon", e.getCause());
        }
    }
}
