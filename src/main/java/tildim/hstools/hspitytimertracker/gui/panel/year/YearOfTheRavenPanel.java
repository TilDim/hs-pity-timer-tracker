package tildim.hstools.hspitytimertracker.gui.panel.year;

import lombok.Getter;
import tildim.hstools.hspitytimertracker.gui.panel.expansion.yearoftheraven.RastakhansRumblePanel;
import tildim.hstools.hspitytimertracker.gui.panel.expansion.yearoftheraven.TheBoomsdayProjectPanel;
import tildim.hstools.hspitytimertracker.gui.panel.expansion.yearoftheraven.TheWitchwoodPanel;
import tildim.hstools.hspitytimertracker.util.Text;
import tildim.hstools.hspitytimertracker.util.icon.IconPaths;

import java.io.Serial;

/**
 *
 */
@Getter
public class YearOfTheRavenPanel extends AbstractYearPanel {

    @Serial
    private static final long serialVersionUID = -1152369483672239288L;

    private final RastakhansRumblePanel rastakhansRumblePanel;
    private final TheBoomsdayProjectPanel theBoomsdayProjectPanel;
    private final TheWitchwoodPanel theWitchwoodPanel;

    /**
     *
     */
    public YearOfTheRavenPanel() {
        super(IconPaths.RAVEN_ICON_PATH, Text.RAVEN_TITLE);

        rastakhansRumblePanel = new RastakhansRumblePanel();
        theBoomsdayProjectPanel = new TheBoomsdayProjectPanel();
        theWitchwoodPanel = new TheWitchwoodPanel();

        add(rastakhansRumblePanel);
        add(theBoomsdayProjectPanel);
        add(theWitchwoodPanel);
    }
}
