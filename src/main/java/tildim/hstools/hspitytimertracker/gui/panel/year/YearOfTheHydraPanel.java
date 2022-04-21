package tildim.hstools.hspitytimertracker.gui.panel.year;

import lombok.Getter;
import tildim.hstools.hspitytimertracker.gui.panel.expansion.yearofthehydra.VoyageToTheSunkenCityPanel;
import tildim.hstools.hspitytimertracker.util.Text;
import tildim.hstools.hspitytimertracker.util.icon.IconPaths;

import java.io.Serial;

/**
 *
 */
@Getter
public class YearOfTheHydraPanel extends AbstractYearPanel {

    @Serial
    private static final long serialVersionUID = -7939839033044679702L;

    private final VoyageToTheSunkenCityPanel voyageToTheSunkenCityPanel;

    /**
     *
     */
    public YearOfTheHydraPanel() {
        super(IconPaths.HYDRA_ICON_PATH, Text.HYDRA_TITLE);

        voyageToTheSunkenCityPanel = new VoyageToTheSunkenCityPanel();

        add(voyageToTheSunkenCityPanel);
    }
}
