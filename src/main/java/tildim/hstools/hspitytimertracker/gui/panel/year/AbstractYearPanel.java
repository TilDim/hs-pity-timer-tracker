package tildim.hstools.hspitytimertracker.gui.panel.year;

import tildim.hstools.hspitytimertracker.exception.IconCreationException;
import tildim.hstools.hspitytimertracker.util.Colors;
import tildim.hstools.hspitytimertracker.util.Fonts;
import tildim.hstools.hspitytimertracker.util.icon.IconHelper;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.Serial;

/**
 *
 */
public abstract class AbstractYearPanel extends JPanel {

    @Serial
    private static final long serialVersionUID = 3204943416650714957L;

    private transient BufferedImage yearIcon;

    /**
     * @param iconPath
     * @param title
     */
    protected AbstractYearPanel(String iconPath, String title) {
        super();

        // Icon creation
        createYearIcon(iconPath);

        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

        JPanel header = new JPanel(new FlowLayout(FlowLayout.CENTER));
        header.setBackground(Colors.YEAR_COLOR);

        JLabel iconLabel = new JLabel(new ImageIcon(yearIcon));
        iconLabel.setBorder(BorderFactory.createEmptyBorder(0, 5, 0, 5));

        JLabel titleLabel = new JLabel(title);
        titleLabel.setFont(Fonts.YEAR_FONT);
        titleLabel.setBorder(BorderFactory.createEmptyBorder(5, 10, 5, 5));

        header.add(iconLabel);
        header.add(titleLabel);

        add(header);
    }

    /**
     * Creates the year icon
     *
     * @param iconPath is the icon's path from the source root
     * @throws IconCreationException is thrown when the IconUtil.createIcon method fails to create the url of a path to an image
     */
    private void createYearIcon(String iconPath) throws IconCreationException {
        try {
            yearIcon = IconHelper.createIcon(iconPath);
        } catch (IOException e) {
            throw new IconCreationException("Error while creating year icon", e.getCause());
        }
    }
}
