package tildim.hstools.hspitytimertracker.util.icon;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.URL;

/**
 * {@code IconHelper} is a utility class that contains all the necessary methods to process the icons used by the
 * program.
 *
 * @author Tilemachos Dimos
 * @see IconPaths
 */
public class IconHelper {

    /**
     * Creates an icon.
     *
     * @param iconPath the icon's path from the source root
     * @return a {@code BufferedImage} of the provided icon
     * @throws IOException if the file cannot be opened
     * @see BufferedImage
     */
    public static BufferedImage createIcon(String iconPath) throws IOException {
        URL iconURL = IconHelper.class.getClassLoader()
                                      .getResource(iconPath);

        if (iconURL != null) {
            return ImageIO.read(iconURL);
        }

        return null;
    }

    /**
     * Private constructor to hide the default public one.
     */
    private IconHelper() {
    }
}
