package tildim.hstools.hspitytimertracker.util;

/**
 *
 */
public final class Text {

    // System new line escape character
    public static final String NEXT_LINE = System.getProperty("line.separator");

    // TRACKER
    public static final String TRACKER_TITLE = "Hearthstone Pity Timer Tracker";

    // MODE
    public static final String STANDARD_TITLE = "Standard Sets";
    public static final String WILD_TITLE = "Wild Sets";

    // YEAR
    public static final String HYDRA_TITLE = "Year of the Hydra (2022)";
    public static final String GRYPHON_TITLE = "Year of the Gryphon (2021)";
    public static final String PHOENIX_TITLE = "Year of the Phoenix (2020)";
    public static final String DRAGON_TITLE = "Year of the Dragon (2019)";
    public static final String RAVEN_TITLE = "Year of the Raven (2018)";
    public static final String MAMMOTH_TITLE = "Year of the Mammoth (2017)";
    public static final String KRAKEN_TITLE = "Year of the Kraken (2016)";
    public static final String YEARS1AND2_TITLE = "Years 1 & 2 (2014-2015)";

    // EXPANSION
    public static final String EPIC_PANEL_TITLE = "Epic Pity Timer";
    public static final String EPIC_COUNTER_TEXT = "Card packs opened without an epic card:   ";
    public static final String EPIC_PROBABILITY_TEXT = "Probability of finding an epic card in the next card pack:   ";

    public static final String LEGENDARY_PANEL_TITLE = "Legendary Pity Timer";
    public static final String LEGENDARY_COUNTER_TEXT = "Card packs opened without a legendary card:   ";
    public static final String LEGENDARY_PROBABILITY_TEXT = "Probability of finding a legendary card in the next card pack:   ";

    public static final String TOTAL_PANEL_TITLE = "Total Card Packs";
    public static final String TOTAL_COUNTER_TEXT = "Total amount of card packs opened:   ";

    public static final String RESET = "Reset";
    public static final String ADD = "+";
    public static final String MODIFY = "Modify";

    // POP-UP
    public static final String HELP_MESSAGE_TITLE = "Help";

    public static final String INPUT_ERROR_MESSAGE_TITLE = "Input error";
    public static final String INPUT_ERROR_MESSAGE_TEXT = "The counter exceeded the pity timer while trying to add the number you entered" +
            NEXT_LINE + NEXT_LINE +
            "Try the following:" + NEXT_LINE +
            "1) Check if the number you entered is correct" + NEXT_LINE +
            "2) Reset the counter, if this is the number you want to enter";

    public static final String MODIFY_MESSAGE_TEXT = "Total amount of card packs opened:";

    /**
     * Private constructor to hide the default public one
     */
    private Text() {
    }
}
