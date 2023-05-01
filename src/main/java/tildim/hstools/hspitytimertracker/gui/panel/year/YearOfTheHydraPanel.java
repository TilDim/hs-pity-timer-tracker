package tildim.hstools.hspitytimertracker.gui.panel.year;

import java.io.Serial;
import tildim.hstools.hspitytimertracker.gui.panel.expansion.yearofthehydra.MarchOfTheLichKingPanel;
import tildim.hstools.hspitytimertracker.gui.panel.expansion.yearofthehydra.MurderAtCastleNathriaPanel;
import tildim.hstools.hspitytimertracker.gui.panel.expansion.yearofthehydra.VoyageToTheSunkenCityPanel;
import tildim.hstools.hspitytimertracker.util.Text;
import tildim.hstools.hspitytimertracker.util.icon.IconPaths;

/**
 * {@code YearOfTheHydraPanel} is a {@link #JPanel} that contains all the instances of {@code AbstractExpansionPanel}
 * which belong in the <i>Year of the Hydra</i>.
 *
 * @author Tilemachos Dimos
 * @see AbstractYearPanel
 * @see MarchOfTheLichKingPanel
 * @see MurderAtCastleNathriaPanel
 * @see VoyageToTheSunkenCityPanel
 */
public class YearOfTheHydraPanel extends AbstractYearPanel {

    @Serial
    private static final long serialVersionUID = -7939839033044679702L;

    /**
     * Constructs a {@link #AbstractYearPanel} with all the <i>Year of the Hydra</i> specific properties
     * and places in it:
     * <ul>
     *     <li>
     *         a {@code MarchOfTheLichKingPanel};
     *     </li>
     *     <li>
     *         a {@code MurderAtCastleNathriaPanel};
     *     </li>
     *     <li>
     *         a {@code VoyageToTheSunkenCityPanel}.
     *     </li>
     * </ul>
     */
    public YearOfTheHydraPanel() {
        super(IconPaths.HYDRA_ICON_PATH, Text.HYDRA_TITLE);

        // Instantiate the year panel's components
        MarchOfTheLichKingPanel marchOfTheLichKingPanel = new MarchOfTheLichKingPanel();
        MurderAtCastleNathriaPanel murderAtCastleNathriaPanel = new MurderAtCastleNathriaPanel();
        VoyageToTheSunkenCityPanel voyageToTheSunkenCityPanel = new VoyageToTheSunkenCityPanel();

        // Add the expansion panels to a list
        yearExpansionPanels.add(marchOfTheLichKingPanel);
        yearExpansionPanels.add(murderAtCastleNathriaPanel);
        yearExpansionPanels.add(voyageToTheSunkenCityPanel);

        // Add the components to the year panel
        add(marchOfTheLichKingPanel);
        add(murderAtCastleNathriaPanel);
        add(voyageToTheSunkenCityPanel);
    }

}
