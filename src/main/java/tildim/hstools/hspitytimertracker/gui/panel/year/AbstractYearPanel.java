package tildim.hstools.hspitytimertracker.gui.panel.year;

import java.awt.FlowLayout;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.Serial;
import java.util.ArrayList;
import java.util.List;
import javax.swing.*;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;
import tildim.hstools.hspitytimertracker.gui.panel.expansion.AbstractExpansionPanel;
import tildim.hstools.hspitytimertracker.util.Colors;
import tildim.hstools.hspitytimertracker.util.Fonts;
import tildim.hstools.hspitytimertracker.util.icon.IconHelper;

/**
 * {@code AbstractYearPanel} is a {@link #JPanel} that contains all the instances of {@code AbstractExpansionPanel}
 * which belong in a specific year.
 *
 * @author Tilemachos Dimos
 * @see AbstractExpansionPanel
 */
@Getter
@Slf4j
public abstract class AbstractYearPanel extends JPanel {

    @Serial
    private static final long serialVersionUID = 3204943416650714957L;

    protected final List<AbstractExpansionPanel> yearExpansionPanels;

    /**
     * Constructs a {@link #JPanel}, sets its layout and places in it the {@code AbstractYearPanel}'s header.
     *
     * @param iconPath the icon's path from the source root
     * @param title    the title of the {@code AbstractYearPanel}
     * @see #createYearPanelHeader
     */
    protected AbstractYearPanel(String iconPath, String title) {
        super();

        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

        yearExpansionPanels = new ArrayList<>();

        // Icon creation
        BufferedImage icon = createYearIcon(iconPath);

        add(createYearPanelHeader(icon, title));
    }

    /**
     * Creates a year icon.
     *
     * @param iconPath the icon's path from the source root
     * @return the year icon
     */
    private BufferedImage createYearIcon(String iconPath) {
        BufferedImage icon = null;

        try {
            icon = IconHelper.createIcon(iconPath);
        } catch (IOException e) {
            log.error("Error while creating year icon", e);
        }

        return icon;
    }

    /**
     * Creates the {@code AbstractYearPanel}'s header, which contains:
     * <ul>
     *     <li>
     *         the {@code AbstractYearPanel}'s icon;
     *     </li>
     *     <li>
     *         the {@code AbstractYearPanel}'s title.
     *     </li>
     * </ul>
     *
     * @param icon  the icon of the {@code AbstractYearPanel}
     * @param title the title of the {@code AbstractYearPanel}
     * @return the year panel header
     */
    private JPanel createYearPanelHeader(BufferedImage icon, String title) {
        // Year panel header
        JPanel yearPanelHeader = new JPanel(new FlowLayout(FlowLayout.CENTER));
        yearPanelHeader.setBackground(Colors.YEAR_COLOR);

        // Icon label
        JLabel iconLabel = new JLabel();
        iconLabel.setIcon(new ImageIcon(icon));
        iconLabel.setBorder(BorderFactory.createEmptyBorder(0, 5, 0, 5));

        // Title label
        JLabel titleLabel = new JLabel(title);
        titleLabel.setFont(Fonts.YEAR_FONT);
        titleLabel.setBorder(BorderFactory.createEmptyBorder(5, 10, 5, 5));

        yearPanelHeader.add(iconLabel);
        yearPanelHeader.add(titleLabel);

        return yearPanelHeader;
    }

}
