package tildim.hstools.hspitytimertracker.util;

/**
 *
 */
public class ProbabilityHelper {

    /**
     * Converts a probability value to String
     *
     * @param probability is the probability value in decimal format
     * @return the probability in String format with a '%' at the end of it
     */
    public static String probabilityToString(double probability) {
        return String.valueOf(probability)
                     .concat("%");
    }

    /**
     * Calculates the probability of finding an epic or a legendary card in the next pack
     *
     * @param counter is the value of an expansion's counter
     * @param pity    is the value of a pity timer ('10' for 'Epic' | '40' for 'Legendary')
     * @return the probability value
     */
    public static double probabilityCalculator(int counter, int pity) {
        return 1.0 / (pity - counter) * 100;
    }

    /**
     * Private constructor to hide the default public one
     */
    private ProbabilityHelper() {
    }
}
