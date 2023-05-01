package tildim.hstools.hspitytimertracker.util;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

/**
 * {@code ProbabilityHelper} is a utility class that contains all the necessary methods to process the probability
 * values used by the program.
 *
 * @author Tilemachos Dimos
 */
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class ProbabilityHelper {

    /**
     * Converts a probability value to {@code String} format.
     *
     * @param probability is the probability value in decimal format
     * @return the probability in String format with a '%' at the end of it
     */
    public static String probabilityToString(double probability) {
        return String.valueOf(probability)
                     .concat("%");
    }

    /**
     * Calculates the probability of finding a card of a specific rarity in the next pack.
     *
     * @param counter is the value of an expansion's counter
     * @param pity    is the value of a pity timer
     * @return the probability value
     * @see PityTimers
     */
    public static double probabilityCalculator(int counter, int pity) {
        return 1.0 / (pity - counter) * 100;
    }

}
