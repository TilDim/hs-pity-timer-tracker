package tildim.hstools.hspitytimertracker.gui.panel.year;

import lombok.Getter;
import tildim.hstools.hspitytimertracker.gui.panel.expansion.yearofthehydra.VoyageToTheSunkenCityPanel;
import tildim.hstools.hspitytimertracker.util.Text;
import tildim.hstools.hspitytimertracker.util.icon.IconPaths;

import java.io.Serial;

/**
 * {@code YearOfTheHydraPanel} is a {@link #JPanel} that contains all the instances of {@code AbstractExpansionPanel}
 * which belong in the <i>Year of the Hydra</i>.
 *
 * @author Tilemachos Dimos
 * @see AbstractYearPanel
 * @see VoyageToTheSunkenCityPanel
 */
@Getter
public class YearOfTheHydraPanel extends AbstractYearPanel {

    @Serial
    private static final long serialVersionUID = -7939839033044679702L;

    private final VoyageToTheSunkenCityPanel voyageToTheSunkenCityPanel;

    /**
     * Constructs a {@link #AbstractYearPanel} with all the <i>Year of the Hydra</i> specific properties
     * and places in it:
     * <ul>
     *     <li>
     *         a {@code VoyageToTheSunkenCityPanel}.
     *     </li>
     * </ul>
     */
    public YearOfTheHydraPanel() {
        super(IconPaths.HYDRA_ICON_PATH, Text.HYDRA_TITLE);

        voyageToTheSunkenCityPanel = new VoyageToTheSunkenCityPanel();

        add(voyageToTheSunkenCityPanel);
    }
}
