package tildim.hstools.hspitytimertracker.gui.panel.year;

import lombok.extern.slf4j.Slf4j;
import tildim.hstools.hspitytimertracker.gui.panel.expansion.AbstractExpansionPanel;
import tildim.hstools.hspitytimertracker.util.Colors;
import tildim.hstools.hspitytimertracker.util.Fonts;
import tildim.hstools.hspitytimertracker.util.icon.IconHelper;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.Serial;

/**
 * {@code AbstractYearPanel} is a {@link #JPanel} that contains all the instances of {@code AbstractExpansionPanel}
 * which belong in a specific year.
 *
 * @author Tilemachos Dimos
 * @see AbstractExpansionPanel
 */
@Slf4j
public abstract class AbstractYearPanel extends JPanel {

    @Serial
    private static final long serialVersionUID = 3204943416650714957L;

    private transient BufferedImage yearIcon;

    /**
     * Constructs a {@link #JPanel}, sets its layout and places in it a header, which consists of:
     * <ul>
     *     <li>
     *         the {@code AbstractYearPanel}'s icon;
     *     </li>
     *     <li>
     *         the {@code AbstractYearPanel}'s title.
     *     </li>
     * </ul>
     *
     * @param iconPath the icon's path from the source root
     * @param title    the title of the {@code AbstractYearPanel}
     */
    protected AbstractYearPanel(String iconPath, String title) {
        super();

        // Icon creation
        createYearIcon(iconPath);

        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

        JPanel header = new JPanel(new FlowLayout(FlowLayout.CENTER));
        header.setBackground(Colors.YEAR_COLOR);

        JLabel iconLabel = new JLabel();
        iconLabel.setIcon(new ImageIcon(yearIcon));
        iconLabel.setBorder(BorderFactory.createEmptyBorder(0, 5, 0, 5));

        JLabel titleLabel = new JLabel(title);
        titleLabel.setFont(Fonts.YEAR_FONT);
        titleLabel.setBorder(BorderFactory.createEmptyBorder(5, 10, 5, 5));

        header.add(iconLabel);
        header.add(titleLabel);

        add(header);
    }

    /**
     * Creates the year icon.
     *
     * @param iconPath the icon's path from the source root
     */
    private void createYearIcon(String iconPath) {
        try {
            yearIcon = IconHelper.createIcon(iconPath);
        } catch (IOException e) {
            log.error("Error while creating year icon");
            e.printStackTrace();
        }
    }
}
