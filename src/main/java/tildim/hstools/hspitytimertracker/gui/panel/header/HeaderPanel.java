package tildim.hstools.hspitytimertracker.gui.panel.header;

import lombok.Getter;
import lombok.extern.slf4j.Slf4j;
import tildim.hstools.hspitytimertracker.gui.panel.header.button.HeaderButton;
import tildim.hstools.hspitytimertracker.gui.panel.popup.HelpPopupWindowPanel;
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
 * {@code HeaderPanel} is a {@link #JPanel} that contains the program's title along with {@code HeaderButton}s.
 *
 * @author Tilemachos Dimos
 * @see HeaderButton
 */
@Getter
@Slf4j
public class HeaderPanel extends JPanel {

    @Serial
    private static final long serialVersionUID = 7480548580616769390L;

    private transient BufferedImage titleIcon;

    private transient BufferedImage helpIcon;
    private transient BufferedImage helpHoverIcon;
    private final HeaderButton help;

    private transient BufferedImage saveFolderIcon;
    private transient BufferedImage saveFolderHoverIcon;
    private final HeaderButton saveFolder;

    /**
     * Constructs a {@link #JPanel}, sets its layout and places in it:
     * <ul>
     *     <li>
     *         a <i>Help</i> {@code HeaderButton} that opens a new window displaying a {@code HelpPopupWindowPanel};
     *     </li>
     *     <li>
     *         the program's title surrounded by the <i>Hearthstone</i> swirl icon;
     *     </li>
     *     <li>
     *         a <i>Save folder</i> {@code HeaderButton} that opens the file explorer to show the save file.
     *     </li>
     * </ul>
     *
     * @see HelpPopupWindowPanel
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

        // Title left icon
        JLabel titleIconLeftLabel = new JLabel();
        titleIconLeftLabel.setIcon(new ImageIcon(titleIcon));
        titleIconLeftLabel.setBorder(new EmptyBorder(0, 5, 0, 5));

        // Title
        JLabel headerTitle = new JLabel(Text.TRACKER_TITLE);
        headerTitle.setFont(Fonts.HEADER_FONT);
        headerTitle.setForeground(Colors.HEADER_TITLE_COLOR);
        headerTitle.setBorder(new EmptyBorder(0, 5, 0, 5));

        // Title right icon
        JLabel titleIconRightLabel = new JLabel();
        titleIconRightLabel.setIcon(new ImageIcon(titleIcon));
        titleIconRightLabel.setBorder(new EmptyBorder(0, 5, 0, 5));

        headerTitlePanel.add(titleIconLeftLabel);
        headerTitlePanel.add(headerTitle);
        headerTitlePanel.add(titleIconRightLabel);

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
     * Creates the header icons.
     */
    private void createHeaderIcons() {
        try {
            titleIcon = IconHelper.createIcon(IconPaths.TITLE_ICON_PATH);

            helpIcon = IconHelper.createIcon(IconPaths.HELP_ICON_PATH);
            helpHoverIcon = IconHelper.createIcon(IconPaths.HELP_HOVER_ICON_PATH);

            saveFolderIcon = IconHelper.createIcon(IconPaths.SAVE_FOLDER_ICON_PATH);
            saveFolderHoverIcon = IconHelper.createIcon(IconPaths.SAVE_FOLDER_HOVER_ICON_PATH);
        } catch (IOException e) {
            log.error("Error while creating header icon");
            e.printStackTrace();
        }
    }
}
