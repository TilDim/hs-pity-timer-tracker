package tildim.hstools.hspitytimertracker.util;

import java.awt.Color;
import java.util.List;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

/**
 * {@code Colors} is a utility class that contains all the colors used in the program as {@code Color} objects.
 *
 * @author Tilemachos Dimos
 * @see Color
 */
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public final class Colors {

    // ++++++++++   HEADER   ++++++++++
    public static final Color HEADER_TITLE_COLOR = new Color(255, 255, 255);
    public static final Color HEADER_BACKGROUND_COLOR = new Color(50, 50, 50);
    // ----------   HEADER   ----------

    // ++++++++++   MODE   ++++++++++
    public static final Color MODE_SELECTED_COLOR = new Color(220, 170, 85);
    public static final Color MODE_UNSELECTED_COLOR = new Color(240, 215, 105);
    public static final Color MODE_MOUSE_HOVER_COLOR = new Color(240, 200, 95);
    // ----------   MODE   ----------

    // ++++++++++   YEAR   ++++++++++
    public static final Color YEAR_COLOR = new Color(245, 220, 160);
    // ----------   YEAR   ----------

    // ++++++++++   EXPANSION   ++++++++++
    // Year of the Pegasus
    public static final Color PARADISE_COLOR = new Color(30, 140, 190);
    public static final Color WORKSHOP_COLOR = new Color(125, 5, 55);

    // Year of the Wolf
    public static final Color BADLANDS_COLOR = new Color(230, 140, 70);
    public static final Color TITANS_COLOR = new Color(210, 210, 215);
    public static final Color FESTIVAL_COLOR = new Color(245, 200, 40);

    // Year of the Hydra
    public static final Color LICHKING_COLOR = new Color(25, 50, 60);
    public static final Color NATHRIA_COLOR = new Color(85, 25, 30);
    public static final Color SUNKEN_COLOR = new Color(20, 185, 155);

    // Year of the Gryphon
    public static final Color ALTERAC_COLOR = new Color(245, 245, 250);
    public static final Color STORMWIND_COLOR = new Color(0, 0, 180);
    public static final Color BARRENS_COLOR = new Color(175, 0, 0);

    // Year of the Phoenix
    public static final Color DARKMOON_COLOR = new Color(175, 200, 20);
    public static final Color SCHOLOMANCE_COLOR = new Color(160, 30, 110);
    public static final Color OUTLAND_COLOR = new Color(0, 60, 30);

    // Year of the Dragon
    public static final Color DRAGONS_COLOR = new Color(235, 155, 20);
    public static final Color ULDUM_COLOR = new Color(10, 210, 220);
    public static final Color SHADOWS_COLOR = new Color(115, 25, 170);

    // Year of the Raven
    public static final Color RUMBLE_COLOR = new Color(10, 220, 185);
    public static final Color BOOMSDAY_COLOR = new Color(220, 75, 50);
    public static final Color WITCHWOOD_COLOR = new Color(115, 185, 165);

    // Year of the Mammoth
    public static final Color KOBOLDS_COLOR = new Color(165, 115, 80);
    public static final Color KNIGHTS_COLOR = new Color(150, 190, 210);
    public static final Color UNGORO_COLOR = new Color(95, 115, 40);

    // Year of the Kraken
    public static final Color GADGETZAN_COLOR = new Color(210, 165, 25);
    public static final Color OLDGODS_COLOR = new Color(145, 60, 145);

    // Years 1 & 2
    public static final Color TOURNAMENT_COLOR = new Color(95, 70, 50);
    public static final Color GOBLINS_COLOR = new Color(220, 95, 10);

    // Classic
    public static final Color CLASSIC_COLOR = new Color(115, 165, 235);
    // ----------   EXPANSION   ----------

    // ++++++++++   BUTTON   ++++++++++
    // Light background
    public static final Color BUTTON_COLOR = new Color(0, 0, 0);
    public static final Color BUTTON_HOVER_COLOR = new Color(50, 50, 50);

    // Dark background
    public static final Color BUTTON_DARK_COLOR = new Color(255, 255, 255);
    public static final Color BUTTON_DARK_HOVER_COLOR = new Color(205, 205, 205);

    public static final Color BUTTON_PRESSED_COLOR = new Color(150, 150, 150);
    // ----------   BUTTON   ----------

    // ++++++++++   TEXT   ++++++++++
    public static final Color TEXT_COLOR = new Color(0, 0, 0);
    public static final Color TEXT_DARK_COLOR = new Color(255, 255, 255);
    // ----------   TEXT   ----------

    // ++++++++++   MODIFIERS COLOR LIST   ++++++++++
    public static final List<Color> MODIFIERS_COLORS = List.of(BUTTON_COLOR, TEXT_DARK_COLOR, BUTTON_HOVER_COLOR);
    public static final List<Color> MODIFIERS_DARK_COLORS = List.of(BUTTON_DARK_COLOR, TEXT_COLOR, BUTTON_DARK_HOVER_COLOR);
    // ----------   MODIFIERS COLOR LIST   ----------

    // ++++++++++   TOOLTIP   ++++++++++
    public static final Color TOOLTIP_BACKGROUND_COLOR = new Color(255, 255, 255);
    // ----------   TOOLTIP   ----------

    // ++++++++++   POP-UP WINDOW   ++++++++++
    public static final Color POPUP_BACKGROUND_COLOR = new Color(240, 240, 240);
    // ----------   POP-UP WINDOW   ----------

}
