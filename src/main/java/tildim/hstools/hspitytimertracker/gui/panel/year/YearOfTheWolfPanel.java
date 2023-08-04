package tildim.hstools.hspitytimertracker.gui.panel.year;

import java.io.Serial;
import tildim.hstools.hspitytimertracker.gui.panel.expansion.yearofthewolf.FestivalOfLegendsPanel;
import tildim.hstools.hspitytimertracker.gui.panel.expansion.yearofthewolf.TitansPanel;
import tildim.hstools.hspitytimertracker.util.Text;
import tildim.hstools.hspitytimertracker.util.icon.IconPaths;

/**
 * {@code YearOfTheWolfPanel} is a {@link #JPanel} that contains all the instances of {@code AbstractExpansionPanel}
 * which belong in the <i>Year of the Wolf</i>.
 *
 * @author Tilemachos Dimos
 * @see AbstractYearPanel
 * @see TitansPanel
 * @see FestivalOfLegendsPanel
 */
public class YearOfTheWolfPanel extends AbstractYearPanel {

    @Serial
    private static final long serialVersionUID = 3955887395595642580L;

    /**
     * Constructs a {@link #AbstractYearPanel} with all the <i>Year of the Wolf</i> specific properties
     * and places in it:
     * <ul>
     *     <li>
     *         a {@code TitansPanel}.
     *     </li>
     *     <li>
     *         a {@code FestivalOfLegendsPanel}.
     *     </li>
     * </ul>
     */
    public YearOfTheWolfPanel() {
        super(IconPaths.WOLF_ICON_PATH, Text.WOLF_TITLE);

        // Instantiate the year panel's components
        TitansPanel titansPanel = new TitansPanel();
        FestivalOfLegendsPanel festivalOfLegendsPanel = new FestivalOfLegendsPanel();

        // Add the expansion panels to a list
        yearExpansionPanels.add(titansPanel);
        yearExpansionPanels.add(festivalOfLegendsPanel);

        // Add the components to the year panel
        add(titansPanel);
        add(festivalOfLegendsPanel);
    }

}
