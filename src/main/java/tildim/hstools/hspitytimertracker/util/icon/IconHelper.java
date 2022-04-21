package tildim.hstools.hspitytimertracker.util.icon;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.URL;

/**
 *
 */
public class IconHelper {

    /**
     * Creates an icon
     *
     * @param iconPath is the icon's path from the source root
     * @return a BufferedImage of the provided icon
     * @throws IOException if the file cannot be opened
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
     * Private constructor to hide the default public one
     */
    private IconHelper() {
    }
}
