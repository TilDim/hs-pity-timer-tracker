package tildim.hstools.hspitytimertracker.gui.panel.year;

import java.io.Serial;
import tildim.hstools.hspitytimertracker.gui.panel.expansion.yearofthemammoth.JourneyToUnGoroPanel;
import tildim.hstools.hspitytimertracker.gui.panel.expansion.yearofthemammoth.KnightsOfTheFrozenThronePanel;
import tildim.hstools.hspitytimertracker.gui.panel.expansion.yearofthemammoth.KoboldsAndCatacombsPanel;
import tildim.hstools.hspitytimertracker.util.Text;
import tildim.hstools.hspitytimertracker.util.icon.IconPaths;

/**
 * {@code YearOfTheMammothPanel} is a {@link #JPanel} that contains all the instances of {@code AbstractExpansionPanel}
 * which belong in the <i>Year of the Mammoth</i>.
 *
 * @author Tilemachos Dimos
 * @see AbstractYearPanel
 * @see KoboldsAndCatacombsPanel
 * @see KnightsOfTheFrozenThronePanel
 * @see JourneyToUnGoroPanel
 */
public class YearOfTheMammothPanel extends AbstractYearPanel {

    @Serial
    private static final long serialVersionUID = 3972022712238641127L;

    /**
     * Constructs a {@link #AbstractYearPanel} with all the <i>Year of the Mammoth</i> specific properties
     * and places in it:
     * <ul>
     *     <li>
     *         a {@code KoboldsAndCatacombsPanel};
     *     </li>
     *     <li>
     *         a {@code KnightsOfTheFrozenThronePanel};
     *     </li>
     *     <li>
     *         a {@code JourneyToUnGoroPanel}.
     *     </li>
     * </ul>
     */
    public YearOfTheMammothPanel() {
        super(IconPaths.MAMMOTH_ICON_PATH, Text.MAMMOTH_TITLE);

        // Instantiate the year panel's components
        KoboldsAndCatacombsPanel koboldsAndCatacombsPanel = new KoboldsAndCatacombsPanel();
        KnightsOfTheFrozenThronePanel knightsOfTheFrozenThronePanel = new KnightsOfTheFrozenThronePanel();
        JourneyToUnGoroPanel journeyToUnGoroPanel = new JourneyToUnGoroPanel();

        // Add the expansion panels to a list
        yearExpansionPanels.add(koboldsAndCatacombsPanel);
        yearExpansionPanels.add(knightsOfTheFrozenThronePanel);
        yearExpansionPanels.add(journeyToUnGoroPanel);

        // Add the components to the year panel
        add(koboldsAndCatacombsPanel);
        add(knightsOfTheFrozenThronePanel);
        add(journeyToUnGoroPanel);
    }

}
