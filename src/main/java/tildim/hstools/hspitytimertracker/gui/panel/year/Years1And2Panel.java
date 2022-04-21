package tildim.hstools.hspitytimertracker.gui.panel.year;

import lombok.Getter;
import tildim.hstools.hspitytimertracker.gui.panel.expansion.years1and2.GoblinsVsGnomesPanel;
import tildim.hstools.hspitytimertracker.gui.panel.expansion.years1and2.TheGrandTournamentPanel;
import tildim.hstools.hspitytimertracker.util.Text;
import tildim.hstools.hspitytimertracker.util.icon.IconPaths;

import java.io.Serial;

/**
 *
 */
@Getter
public class Years1And2Panel extends AbstractYearPanel {

    @Serial
    private static final long serialVersionUID = -6351254928779332037L;

    private final TheGrandTournamentPanel theGrandTournamentPanel;
    private final GoblinsVsGnomesPanel goblinsVsGnomesPanel;

    /**
     *
     */
    public Years1And2Panel() {
        super(IconPaths.YEARS1AND2_ICON_PATH, Text.YEARS1AND2_TITLE);

        theGrandTournamentPanel = new TheGrandTournamentPanel();
        goblinsVsGnomesPanel = new GoblinsVsGnomesPanel();

        add(theGrandTournamentPanel);
        add(goblinsVsGnomesPanel);
    }
}
