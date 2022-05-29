package tildim.hstools.hspitytimertracker.gui.panel.year;

import lombok.Getter;
import tildim.hstools.hspitytimertracker.gui.panel.expansion.yearofthekraken.MeanStreetsOfGadgetzanPanel;
import tildim.hstools.hspitytimertracker.gui.panel.expansion.yearofthekraken.WhispersOfTheOldGodsPanel;
import tildim.hstools.hspitytimertracker.util.Text;
import tildim.hstools.hspitytimertracker.util.icon.IconPaths;

import java.io.Serial;

/**
 * {@code YearOfTheKrakenPanel} is a {@link #JPanel} that contains all the instances of {@code AbstractExpansionPanel}
 * which belong in the <i>Year of the Kraken</i>.
 *
 * @author Tilemachos Dimos
 * @see AbstractYearPanel
 * @see MeanStreetsOfGadgetzanPanel
 * @see WhispersOfTheOldGodsPanel
 */
@Getter
public class YearOfTheKrakenPanel extends AbstractYearPanel {

    @Serial
    private static final long serialVersionUID = -5252430689754613365L;

    private final MeanStreetsOfGadgetzanPanel meanStreetsOfGadgetzanPanel;
    private final WhispersOfTheOldGodsPanel whispersOfTheOldGodsPanel;

    /**
     * Constructs a {@link #AbstractYearPanel} with all the <i>Year of the Kraken</i> specific properties
     * and places in it:
     * <ul>
     *     <li>
     *         a {@code MeanStreetsOfGadgetzanPanel};
     *     </li>
     *     <li>
     *         a {@code WhispersOfTheOldGodsPanel}.
     *     </li>
     * </ul>
     */
    public YearOfTheKrakenPanel() {
        super(IconPaths.KRAKEN_ICON_PATH, Text.KRAKEN_TITLE);

        meanStreetsOfGadgetzanPanel = new MeanStreetsOfGadgetzanPanel();
        whispersOfTheOldGodsPanel = new WhispersOfTheOldGodsPanel();

        add(meanStreetsOfGadgetzanPanel);
        add(whispersOfTheOldGodsPanel);
    }
}
