package tildim.hstools.hspitytimertracker.util.index;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * {@code IndexType} is an enumeration of the types of values the indexes used by the program may point to.
 * <p>
 * These types are used by the {@link IndexHelper} to calculate indexes in lists, such as the list of expansions in the
 * save file.
 *
 * @author Tilemachos Dimos
 */
@Getter
@AllArgsConstructor
public enum IndexType {

    EPIC_COUNTER(1),
    EPIC_PROBABILITY(2),
    LEGENDARY_COUNTER(3),
    LEGENDARY_PROBABILITY(4),
    TOTAL_COUNTER(5);

    private final int indexTypeSN;

}
