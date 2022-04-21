package tildim.hstools.hspitytimertracker.gui.panel.year;

import lombok.Getter;
import tildim.hstools.hspitytimertracker.gui.panel.expansion.yearofthegryphon.ForgedInTheBarrensPanel;
import tildim.hstools.hspitytimertracker.gui.panel.expansion.yearofthegryphon.FracturedInAlteracValleyPanel;
import tildim.hstools.hspitytimertracker.gui.panel.expansion.yearofthegryphon.UnitedInStormwindPanel;
import tildim.hstools.hspitytimertracker.util.Text;
import tildim.hstools.hspitytimertracker.util.icon.IconPaths;

import java.io.Serial;

/**
 *
 */
@Getter
public class YearOfTheGryphonPanel extends AbstractYearPanel {

    @Serial
    private static final long serialVersionUID = -7844871129763202636L;

    private final FracturedInAlteracValleyPanel fracturedInAlteracValleyPanel;
    private final UnitedInStormwindPanel unitedInStormwindPanel;
    private final ForgedInTheBarrensPanel forgedInTheBarrensPanel;

    /**
     *
     */
    public YearOfTheGryphonPanel() {
        super(IconPaths.GRYPHON_ICON_PATH, Text.GRYPHON_TITLE);

        fracturedInAlteracValleyPanel = new FracturedInAlteracValleyPanel();
        unitedInStormwindPanel = new UnitedInStormwindPanel();
        forgedInTheBarrensPanel = new ForgedInTheBarrensPanel();

        add(fracturedInAlteracValleyPanel);
        add(unitedInStormwindPanel);
        add(forgedInTheBarrensPanel);
    }
}
