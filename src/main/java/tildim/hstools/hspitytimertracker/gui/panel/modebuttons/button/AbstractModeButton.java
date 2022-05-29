package tildim.hstools.hspitytimertracker.gui.panel.modebuttons.button;

import lombok.Getter;
import lombok.extern.slf4j.Slf4j;
import tildim.hstools.hspitytimertracker.gui.panel.modebuttons.ModeButtonsPanel;
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
 * {@code AbstractModeButton} is a {@link #JButton} located in the {@code ModeButtonsPanel} that shows
 * all the instances of {@code AbstractYearPanel} which belong in a specific mode, when pressed.
 *
 * @author Tilemachos Dimos
 * @see ModeButtonsPanel
 */
@Slf4j
public abstract class AbstractModeButton extends JButton {

    @Serial
    private static final long serialVersionUID = 6044135139600565685L;

    private transient BufferedImage modeIcon;

    @Getter
    protected final transient MouseAdapter selectedModeButtonAdapter;

    @Getter
    protected final transient MouseAdapter unselectedModeButtonAdapter;

    /**
     * Constructs a {@link #JButton}, sets some of its properties and initializes two {@code MouseAdapter}s
     * (one for the selected mode and one for the unselected one).
     *
     * @param label      the label of the {@code AbstractModeButton}
     * @param iconPath   the icon's path from the source root
     * @param background the button's color
     * @param tooltip    the tooltip text displayed when hovering over the {@code AbstractModeButton}
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
     * Creates the mode icon.
     *
     * @param iconPath the icon's path from the source root
     */
    private void createModeIcon(String iconPath) {
        try {
            modeIcon = IconHelper.createIcon(iconPath);
        } catch (IOException e) {
            log.error("Error while creating mode icon");
            e.printStackTrace();
        }
    }
}
