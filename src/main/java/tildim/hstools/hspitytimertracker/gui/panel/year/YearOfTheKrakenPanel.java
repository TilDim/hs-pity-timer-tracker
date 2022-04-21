package tildim.hstools.hspitytimertracker.gui.panel.year;

import lombok.Getter;
import tildim.hstools.hspitytimertracker.gui.panel.expansion.yearofthekraken.MeanStreetsOfGadgetzanPanel;
import tildim.hstools.hspitytimertracker.gui.panel.expansion.yearofthekraken.WhispersOfTheOldGodsPanel;
import tildim.hstools.hspitytimertracker.util.Text;
import tildim.hstools.hspitytimertracker.util.icon.IconPaths;

import java.io.Serial;

/**
 *
 */
@Getter
public class YearOfTheKrakenPanel extends AbstractYearPanel {

    @Serial
    private static final long serialVersionUID = -5252430689754613365L;

    private final MeanStreetsOfGadgetzanPanel meanStreetsOfGadgetzanPanel;
    private final WhispersOfTheOldGodsPanel whispersOfTheOldGodsPanel;

    /**
     *
     */
    public YearOfTheKrakenPanel() {
        super(IconPaths.KRAKEN_ICON_PATH, Text.KRAKEN_TITLE);

        meanStreetsOfGadgetzanPanel = new MeanStreetsOfGadgetzanPanel();
        whispersOfTheOldGodsPanel = new WhispersOfTheOldGodsPanel();

        add(meanStreetsOfGadgetzanPanel);
        add(whispersOfTheOldGodsPanel);
    }
}
