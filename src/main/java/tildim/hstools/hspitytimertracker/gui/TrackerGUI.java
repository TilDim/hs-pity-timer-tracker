package tildim.hstools.hspitytimertracker.gui;

import lombok.Getter;
import lombok.extern.slf4j.Slf4j;
import tildim.hstools.hspitytimertracker.gui.panel.tracker.TrackerPanel;
import tildim.hstools.hspitytimertracker.util.Colors;
import tildim.hstools.hspitytimertracker.util.Fonts;
import tildim.hstools.hspitytimertracker.util.Text;
import tildim.hstools.hspitytimertracker.util.icon.IconHelper;
import tildim.hstools.hspitytimertracker.util.icon.IconPaths;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.Serial;

/**
 * {@code TrackerGUI} is a {@link #JFrame} that contains a {@code TrackerPanel} and comprises the GUI of the program.
 *
 * @author Tilemachos Dimos
 * @see TrackerPanel
 */
@Getter
@Slf4j
public class TrackerGUI extends JFrame {

    @Serial
    private static final long serialVersionUID = -2973290448426684767L;

    private final TrackerPanel trackerPanel;

    /**
     * Constructs a {@link #JFrame}, sets some UI properties, places in the {@code JFrame} a {@code TrackerPanel} and
     * sets some of the {@code JFrame}'s properties.
     */
    public TrackerGUI() {
        super();

        // Tracker look and feel
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException |
                 UnsupportedLookAndFeelException e) {
            log.error("Error while setting the tracker's look and feel");
            e.printStackTrace();
        }

        // Buttons tooltip style
        UIManager.put("ToolTip.background", Colors.TOOLTIP_BACKGROUND_COLOR);
        UIManager.put("ToolTip.font", Fonts.TOOLTIP_FONT);

        // Pop-up window text field font
        UIManager.put("TextField.font", Fonts.POPUP_TEXTFIELD_FONT);

        // Tracker panel
        trackerPanel = new TrackerPanel();
        add(trackerPanel);

        // Tracker frame
        setTitle(Text.TRACKER_TITLE);
        setIconImage(createTrackerWindowIcon());
        setMinimumSize(new Dimension(1150, 540));
        setPreferredSize(new Dimension(1250, 650));
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setResizable(true);
        pack();
        setLocationRelativeTo(null);
        setVisible(true);
    }

    /**
     * Creates the tracker window icon.
     *
     * @return the tracker window icon
     */
    private BufferedImage createTrackerWindowIcon() {
        BufferedImage icon = null;

        try {
            icon = IconHelper.createIcon(IconPaths.TRACKER_ICON_PATH);
        } catch (IOException e) {
            log.error("Error while creating the tracker window icon");
            e.printStackTrace();
        }

        return icon;
    }
}
