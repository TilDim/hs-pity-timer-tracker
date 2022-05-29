package tildim.hstools.hspitytimertracker.util;

import java.awt.*;

/**
 * {@code Fonts} is a utility class that contains all the fonts used in the program as {@code Font} objects as well as
 * the font names and sizes.
 *
 * @author Tilemachos Dimos
 * @see Font
 */
public final class Fonts {

    public static final String MAIN_FONT_NAME = "Comic Sans MS";

    public static final int PANEL_TITLE_FONT_SIZE = 24;
    public static final int PANEL_TEXT_FONT_SIZE = 20;
    public static final int PANEL_NUMBER_FONT_SIZE = 28;
    public static final int POPUP_TITLE_FONT_SIZE = 24;
    public static final int POPUP_TEXT_FONT_SIZE = 18;

    public static final Font HEADER_FONT = new Font(MAIN_FONT_NAME, Font.BOLD, 36);
    public static final Font MODE_FONT = new Font(MAIN_FONT_NAME, Font.BOLD, 30);
    public static final Font YEAR_FONT = new Font(MAIN_FONT_NAME, Font.BOLD, 26);
    public static final Font BUTTON_FONT = new Font(MAIN_FONT_NAME, Font.BOLD, 22);
    public static final Font ADD_BUTTON_FONT = new Font("Arial Black", Font.BOLD, 32);
    public static final Font INCREMENT_FONT = new Font(MAIN_FONT_NAME, Font.PLAIN, 24);
    public static final Font TOOLTIP_FONT = new Font(Fonts.MAIN_FONT_NAME, Font.PLAIN, 14);
    public static final Font POPUP_TEXTFIELD_FONT = new Font(Fonts.MAIN_FONT_NAME, Font.PLAIN, 20);

    /**
     * Private constructor to hide the default public one.
     */
    private Fonts() {
    }
}
