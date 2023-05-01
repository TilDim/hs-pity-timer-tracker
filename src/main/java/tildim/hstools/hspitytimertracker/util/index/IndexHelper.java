package tildim.hstools.hspitytimertracker.util.index;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import tildim.hstools.hspitytimertracker.util.TextFileHelper;

/**
 * {@code IndexHelper} is a utility class that contains all the necessary methods to process the indexes of lists used
 * by the program, such as the list of expansions in the save file.
 *
 * @author Tilemachos Dimos
 * @see IndexType
 * @see TextFileHelper
 */
@Slf4j
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class IndexHelper {

    public static final int FIRST_EXPANSION_IN_FILE_ROW_INDEX = 5;

    // The number of lines between a counter and the previous value in the save file
    private static final int ROWS_UNTIL_COUNTER = 4;

    // The number of lines between a probability and the previous value in the save file
    private static final int ROWS_UNTIL_PROBABILITY = 2;

    /**
     * Calculates the row of a value in the save file, which is also the index in the list of the save file data, based
     * on the {@code IndexType} of the value and the index of the expansion it corresponds to in the expansion panels
     * list.
     *
     * @param indexType the type of value that the row index to be calculated points to
     * @param expIndex  the index of the expansion in the expansion panels list
     * @return the calculated row index in the save file data list
     */
    public static int calculateRowIndex(IndexType indexType, int expIndex) {
        return switch (indexType) {
            case EPIC_COUNTER -> calculateRowIndex(indexType.getIndexTypeSN(), 1, 0, expIndex);
            case EPIC_PROBABILITY -> calculateRowIndex(indexType.getIndexTypeSN(), 1, 1, expIndex);
            case LEGENDARY_COUNTER -> calculateRowIndex(indexType.getIndexTypeSN(), 2, 1, expIndex);
            case LEGENDARY_PROBABILITY -> calculateRowIndex(indexType.getIndexTypeSN(), 2, 2, expIndex);
            case TOTAL_COUNTER -> calculateRowIndex(indexType.getIndexTypeSN(), 3, 2, expIndex);
        };
    }

    /**
     * Calculates the row of a value in the save file, which is also the index in the list of the save file data, based
     * on the {@code IndexType} serial number of the value, the number of counter and probability value rows until this
     * and the index of the expansion it corresponds to in the expansion panels list.
     *
     * @param indexTypeSN the {@code IndexType} serial number
     * @param cRows       the number of counter value rows until the row index to be calculated
     * @param pRows       the number of probability value rows until the row index to be calculated
     * @param expIndex    the index of the expansion in the expansion panels list
     * @return the calculated row index in the save file data list
     */
    private static int calculateRowIndex(int indexTypeSN, int cRows, int pRows, int expIndex) {
        return FIRST_EXPANSION_IN_FILE_ROW_INDEX
                + indexTypeSN * TextFileHelper.numberOfExpansions()
                + cRows * ROWS_UNTIL_COUNTER
                + pRows * ROWS_UNTIL_PROBABILITY
                + expIndex;
    }

}
