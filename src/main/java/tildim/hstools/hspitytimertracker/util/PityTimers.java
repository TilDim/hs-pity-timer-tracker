package tildim.hstools.hspitytimertracker.util;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

/**
 * {@code PityTimers} is a utility class that contains the <i>pity timers</i> used in the program, which are the values
 * that define the maximum number of packs per expansion that may be opened until a card of a specific rarity is found.
 *
 * @author Tilemachos Dimos
 */
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public final class PityTimers {

    public static final int EPIC_PITY_TIMER = 10;
    public static final int LEGENDARY_PITY_TIMER = 40;

}
