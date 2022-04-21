package tildim.hstools.hspitytimertracker.util;

import java.awt.*;

/**
 *
 */
public final class Fonts {

    public static final String FONT_NAME = "Comic Sans MS";

    public static final int PANEL_TITLE_FONT_SIZE = 24;
    public static final int PANEL_TEXT_FONT_SIZE = 20;
    public static final int PANEL_NUMBER_FONT_SIZE = 28;
    public static final int PANEL_TOOLTIP_FONT_SIZE = 14;
    public static final int POPUP_TITLE_FONT_SIZE = 24;
    public static final int POPUP_TEXT_FONT_SIZE = 18;

    public static final Font HEADER_FONT = new Font(FONT_NAME, Font.BOLD, 36);
    public static final Font MODE_FONT = new Font(FONT_NAME, Font.BOLD, 30);
    public static final Font YEAR_FONT = new Font(FONT_NAME, Font.BOLD, 26);
    public static final Font BUTTON_FONT = new Font(FONT_NAME, Font.BOLD, 22);
    public static final Font ADD_BUTTON_FONT = new Font("Arial Black", Font.BOLD, 32);
    public static final Font INCREMENT_FONT = new Font(FONT_NAME, Font.PLAIN, 24);

    /**
     * Private constructor to hide the default public one
     */
    private Fonts() {
    }
}
