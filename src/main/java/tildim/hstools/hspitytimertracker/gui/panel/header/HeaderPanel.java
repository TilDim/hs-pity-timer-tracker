package tildim.hstools.hspitytimertracker.gui.panel.header;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.Serial;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
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

/**
 * {@code HeaderPanel} is a {@link #JPanel} that contains the program's header sub-panels.
 *
 * @author Tilemachos Dimos
 * @see #createLeftHeaderPanel
 * @see #createTitlePanel
 * @see #createRightHeaderPanel
 */
@Getter
@Slf4j
public class HeaderPanel extends JPanel {

    @Serial
    private static final long serialVersionUID = 7480548580616769390L;

    private HeaderButton help;
    private HeaderButton saveFolder;

    /**
     * Constructs a {@link #JPanel}, sets some of its properties and places in it:
     * <ul>
     *     <li>
     *         the left header {@code JPanel};
     *     </li>
     *     <li>
     *         the title {@code JPanel};
     *     </li>
     *     <li>
     *         the right header {@code JPanel}.
     *     </li>
     * </ul>
     */
    public HeaderPanel() {
        super();

        setLayout(new BorderLayout());
        setBackground(Colors.HEADER_BACKGROUND_COLOR);

        // Icon creation
        BufferedImage[] helpIconPair = new BufferedImage[]{
                createHeaderIcon(IconPaths.HELP_ICON_PATH),
                createHeaderIcon(IconPaths.HELP_HOVER_ICON_PATH)
        };

        BufferedImage titleIcon = createHeaderIcon(IconPaths.TITLE_ICON_PATH);

        BufferedImage[] saveFolderIconPair = new BufferedImage[]{
                createHeaderIcon(IconPaths.SAVE_FOLDER_ICON_PATH),
                createHeaderIcon(IconPaths.SAVE_FOLDER_HOVER_ICON_PATH)
        };

        add(createLeftHeaderPanel(helpIconPair), BorderLayout.WEST);
        add(createTitlePanel(titleIcon), BorderLayout.CENTER);
        add(createRightHeaderPanel(saveFolderIconPair), BorderLayout.EAST);
    }

    /**
     * Creates a header icon.
     *
     * @param iconPath the icon's path from the source root
     * @return the header icon
     */
    private BufferedImage createHeaderIcon(String iconPath) {
        BufferedImage icon = null;

        try {
            icon = IconHelper.createIcon(iconPath);
        } catch (IOException e) {
            log.error("Error while creating header icon", e);
        }

        return icon;
    }

    /**
     * Creates the left header panel, which contains:
     * <ul>
     *     <li>
     *         a <i>Help</i> {@code HeaderButton} that opens a new window displaying a {@code HelpPopupWindowPanel}.
     *     </li>
     * </ul>
     *
     * @param helpIconPair the <i>Help</i> {@code HeaderButton}'s icons when the mouse enters and exits it
     * @return the left header panel
     * @see HeaderButton
     * @see HelpPopupWindowPanel
     */
    private JPanel createLeftHeaderPanel(BufferedImage[] helpIconPair) {
        // Left header panel
        JPanel leftHeaderPanel = new JPanel();
        leftHeaderPanel.setBackground(Colors.HEADER_BACKGROUND_COLOR);
        leftHeaderPanel.setBorder(new EmptyBorder(10, 15, 0, 0));

        // "Help" button
        help = new HeaderButton(helpIconPair, Tooltips.HELP_TOOLTIP);

        leftHeaderPanel.add(help);

        return leftHeaderPanel;
    }

    /**
     * Creates the title panel, which contains the program's title surrounded by the <i>Hearthstone</i> swirl icon.
     *
     * @param titleIcon the title icon
     * @return the title panel
     */
    private JPanel createTitlePanel(BufferedImage titleIcon) {
        // Title panel
        JPanel titlePanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        titlePanel.setBackground(Colors.HEADER_BACKGROUND_COLOR);

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

        titlePanel.add(titleIconLeftLabel);
        titlePanel.add(headerTitle);
        titlePanel.add(titleIconRightLabel);

        return titlePanel;
    }

    /**
     * Creates the right header panel, which contains:
     * <ul>
     *     <li>
     *         a <i>Save folder</i> {@code HeaderButton} that opens the file explorer to show the save file.
     *     </li>
     * </ul>
     *
     * @param saveFolderIconPair the <i>Save folder</i> {@code HeaderButton}'s icons when the mouse enters and exits it
     * @return the right header panel
     * @see HeaderButton
     */
    private JPanel createRightHeaderPanel(BufferedImage[] saveFolderIconPair) {
        // Right header panel
        JPanel rightHeaderPanel = new JPanel();
        rightHeaderPanel.setBackground(Colors.HEADER_BACKGROUND_COLOR);
        rightHeaderPanel.setBorder(new EmptyBorder(10, 0, 0, 15));

        // "Save folder" button
        saveFolder = new HeaderButton(saveFolderIconPair, Tooltips.SAVE_FOLDER_TOOLTIP);

        rightHeaderPanel.add(saveFolder);

        return rightHeaderPanel;
    }

}
