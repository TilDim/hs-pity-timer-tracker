package tildim.hstools.hspitytimertracker.gui;

import lombok.Getter;
import tildim.hstools.hspitytimertracker.exception.IconCreationException;
import tildim.hstools.hspitytimertracker.exception.LookAndFeelException;
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
 *
 */
@Getter
public class TrackerGUI extends JFrame {

    @Serial
    private static final long serialVersionUID = -2973290448426684767L;

    private final TrackerPanel trackerPanel;
    private transient BufferedImage trackerIcon;

    /**
     *
     */
    public TrackerGUI() {
        super();

        // Icon creation
        createTrackerIcon();

        // Tracker look and feel
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException |
                 UnsupportedLookAndFeelException e) {
            throw new LookAndFeelException("Error while setting the tracker's look and feel", e.getCause());
        }

        // Buttons tooltip style
        UIManager.put("ToolTip.background", Colors.TOOLTIP_BACKGROUND_COLOR);
        UIManager.put("ToolTip.font", new Font(Fonts.FONT_NAME, Font.PLAIN, Fonts.PANEL_TOOLTIP_FONT_SIZE));

        // Pop-up window text field font
        UIManager.put("TextField.font", new Font(Fonts.FONT_NAME, Font.PLAIN, Fonts.PANEL_TEXT_FONT_SIZE));

        // Tracker components
        trackerPanel = new TrackerPanel();
        add(trackerPanel);

        // Tracker frame
        setTitle(Text.TRACKER_TITLE);
        setIconImage(trackerIcon);
        setMinimumSize(new Dimension(1150, 540));
        setPreferredSize(new Dimension(1250, 650));
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setResizable(true);
        pack();
        setLocationRelativeTo(null);
        setVisible(true);
    }

    /**
     * Creates the tracker icon
     *
     * @throws IconCreationException is thrown when the IconUtil.createIcon method fails to create the url of a path to an image
     */
    private void createTrackerIcon() throws IconCreationException {
        try {
            trackerIcon = IconHelper.createIcon(IconPaths.TRACKER_ICON_PATH);
        } catch (IOException e) {
            throw new IconCreationException("Error while creating the tracker's icon", e.getCause());
        }
    }
}
