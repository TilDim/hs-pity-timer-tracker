package tildim.hstools.hspitytimertracker.gui.panel.header;

import lombok.Getter;
import tildim.hstools.hspitytimertracker.exception.IconCreationException;
import tildim.hstools.hspitytimertracker.gui.panel.header.button.HeaderButton;
import tildim.hstools.hspitytimertracker.util.Colors;
import tildim.hstools.hspitytimertracker.util.Fonts;
import tildim.hstools.hspitytimertracker.util.Text;
import tildim.hstools.hspitytimertracker.util.Tooltips;
import tildim.hstools.hspitytimertracker.util.icon.IconHelper;
import tildim.hstools.hspitytimertracker.util.icon.IconPaths;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.Serial;

/**
 *
 */
@Getter
public class HeaderPanel extends JPanel {

    @Serial
    private static final long serialVersionUID = 7480548580616769390L;

    private transient BufferedImage headerIcon;

    private transient BufferedImage helpIcon;
    private transient BufferedImage helpHoverIcon;
    private final HeaderButton help;

    private transient BufferedImage saveFolderIcon;
    private transient BufferedImage saveFolderHoverIcon;
    private final HeaderButton saveFolder;

    /**
     *
     */
    public HeaderPanel() {
        super();

        createHeaderIcons();

        setLayout(new BorderLayout());
        setBackground(Colors.HEADER_BACKGROUND_COLOR);

        // "Help" button panel
        JPanel helpButtonPanel = new JPanel();
        helpButtonPanel.setBackground(Colors.HEADER_BACKGROUND_COLOR);
        helpButtonPanel.setBorder(new EmptyBorder(10, 15, 0, 0));

        // "Help" button
        help = new HeaderButton(helpIcon, helpHoverIcon, Tooltips.HELP_TOOLTIP);

        helpButtonPanel.add(help);

        // Title panel
        JPanel headerTitlePanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        headerTitlePanel.setBackground(Colors.HEADER_BACKGROUND_COLOR);

        // Title image
        JLabel headerImageLabel = new JLabel(new ImageIcon(headerIcon));
        headerImageLabel.setBorder(new EmptyBorder(0, 5, 0, 5));

        // Title
        JLabel headerTitle = new JLabel(Text.TRACKER_TITLE);
        headerTitle.setFont(Fonts.HEADER_FONT);
        headerTitle.setForeground(Colors.HEADER_TITLE_COLOR);
        headerTitle.setBorder(new EmptyBorder(0, 5, 0, 5));

        // Title image #2
        JLabel headerImageTwoLabel = new JLabel(new ImageIcon(headerIcon));
        headerImageTwoLabel.setBorder(new EmptyBorder(0, 5, 0, 5));

        headerTitlePanel.add(headerImageLabel);
        headerTitlePanel.add(headerTitle);
        headerTitlePanel.add(headerImageTwoLabel);

        // "Save folder" button panel
        JPanel saveFolderPanel = new JPanel();
        saveFolderPanel.setBackground(Colors.HEADER_BACKGROUND_COLOR);
        saveFolderPanel.setBorder(new EmptyBorder(10, 0, 0, 15));

        // "Save folder" button
        saveFolder = new HeaderButton(saveFolderIcon, saveFolderHoverIcon, Tooltips.SAVE_FOLDER_TOOLTIP);

        saveFolderPanel.add(saveFolder);

        add(helpButtonPanel, BorderLayout.WEST);
        add(headerTitlePanel, BorderLayout.CENTER);
        add(saveFolderPanel, BorderLayout.EAST);
    }

    /**
     * Creates the header icons
     *
     * @throws IconCreationException is thrown when the IconUtil.createIcon method fails to create the url of a path to an image
     */
    private void createHeaderIcons() throws IconCreationException {
        try {
            headerIcon = IconHelper.createIcon(IconPaths.HEADER_ICON_PATH);

            helpIcon = IconHelper.createIcon(IconPaths.HELP_ICON_PATH);
            helpHoverIcon = IconHelper.createIcon(IconPaths.HELP_HOVER_ICON_PATH);

            saveFolderIcon = IconHelper.createIcon(IconPaths.SAVE_FOLDER_ICON_PATH);
            saveFolderHoverIcon = IconHelper.createIcon(IconPaths.SAVE_FOLDER_HOVER_ICON_PATH);
        } catch (IOException e) {
            throw new IconCreationException("Error while creating header icon", e.getCause());
        }
    }
}
