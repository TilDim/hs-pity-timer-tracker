package tildim.hstools.hspitytimertracker.gui.panel.modebuttons.button;

import java.awt.Color;
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
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;
import tildim.hstools.hspitytimertracker.gui.panel.modebuttons.ModeButtonsPanel;
import tildim.hstools.hspitytimertracker.util.Colors;
import tildim.hstools.hspitytimertracker.util.Fonts;
import tildim.hstools.hspitytimertracker.util.icon.IconHelper;

/**
 * {@code AbstractModeButton} is a {@link #JButton} located in the {@code ModeButtonsPanel} that shows
 * all the instances of {@code AbstractYearPanel} which belong in a specific mode, when pressed.
 *
 * @author Tilemachos Dimos
 * @see ModeButtonsPanel
 */
@Getter
@Slf4j
public abstract class AbstractModeButton extends JButton {

    @Serial
    private static final long serialVersionUID = 6044135139600565685L;

    protected MouseAdapter selectedModeButtonAdapter;

    protected MouseAdapter unselectedModeButtonAdapter;

    /**
     * Constructs a {@link #JButton}, sets some of its properties and creates two {@code MouseAdapter}s
     * (one for the selected mode and one for the unselected one).
     *
     * @param label      the label of the {@code AbstractModeButton}
     * @param iconPath   the icon's path from the source root
     * @param background the button's color
     * @param tooltip    the tooltip text displayed when hovering over the {@code AbstractModeButton}
     */
    protected AbstractModeButton(String label, String iconPath, Color background, String tooltip) {
        super(" " + label);

        setIcon(new ImageIcon(createModeIcon(iconPath)));
        setBackground(background);
        setFont(Fonts.MODE_FONT);
        setBorder(BorderFactory.createEmptyBorder(5, 0, 5, 0));

        setToolTipText(tooltip);
        setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        setFocusPainted(false);
        setContentAreaFilled(false);

        // Mouse adapters creation
        selectedModeButtonAdapter =
                createModeButtonMouseAdapter(Colors.MODE_SELECTED_COLOR, Colors.MODE_SELECTED_COLOR);
        unselectedModeButtonAdapter =
                createModeButtonMouseAdapter(Colors.MODE_MOUSE_HOVER_COLOR, Colors.MODE_UNSELECTED_COLOR);
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
     * Creates a mode icon.
     *
     * @param iconPath the icon's path from the source root
     * @return the mode icon
     */
    private BufferedImage createModeIcon(String iconPath) {
        BufferedImage icon = null;

        try {
            icon = IconHelper.createIcon(iconPath);
        } catch (IOException e) {
            log.error("Error while creating mode icon");
            e.printStackTrace();
        }

        return icon;
    }

    /**
     * Creates a {@code AbstractModeButton} mouse adapter.
     *
     * @param enterColor the color when the mouse enters the {@code AbstractModeButton}
     * @param exitColor  the color when the mouse exits the {@code AbstractModeButton}
     * @return the {@code AbstractModeButton} mouse adapter
     */
    private MouseAdapter createModeButtonMouseAdapter(Color enterColor, Color exitColor) {
        return new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent evt) {
                setBackground(enterColor);
            }

            @Override
            public void mouseExited(MouseEvent evt) {
                setBackground(exitColor);
            }
        };
    }

}
