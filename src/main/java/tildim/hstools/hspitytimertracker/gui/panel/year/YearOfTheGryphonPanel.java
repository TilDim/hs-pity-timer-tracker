package tildim.hstools.hspitytimertracker.gui.panel.year;

import lombok.Getter;
import tildim.hstools.hspitytimertracker.gui.panel.expansion.yearofthegryphon.ForgedInTheBarrensPanel;
import tildim.hstools.hspitytimertracker.gui.panel.expansion.yearofthegryphon.FracturedInAlteracValleyPanel;
import tildim.hstools.hspitytimertracker.gui.panel.expansion.yearofthegryphon.UnitedInStormwindPanel;
import tildim.hstools.hspitytimertracker.util.Text;
import tildim.hstools.hspitytimertracker.util.icon.IconPaths;

import java.io.Serial;

/**
 * {@code YearOfTheGryphonPanel} is a {@link #JPanel} that contains all the instances of {@code AbstractExpansionPanel}
 * which belong in the <i>Year of the Gryphon</i>.
 *
 * @author Tilemachos Dimos
 * @see AbstractYearPanel
 * @see FracturedInAlteracValleyPanel
 * @see UnitedInStormwindPanel
 * @see ForgedInTheBarrensPanel
 */
@Getter
public class YearOfTheGryphonPanel extends AbstractYearPanel {

    @Serial
    private static final long serialVersionUID = -7844871129763202636L;

    private final FracturedInAlteracValleyPanel fracturedInAlteracValleyPanel;
    private final UnitedInStormwindPanel unitedInStormwindPanel;
    private final ForgedInTheBarrensPanel forgedInTheBarrensPanel;

    /**
     * Constructs a {@link #AbstractYearPanel} with all the <i>Year of the Gryphon</i> specific properties
     * and places in it:
     * <ul>
     *     <li>
     *         a {@code FracturedInAlteracValleyPanel};
     *     </li>
     *     <li>
     *         a {@code UnitedInStormwindPanel};
     *     </li>
     *     <li>
     *         a {@code ForgedInTheBarrensPanel}.
     *     </li>
     * </ul>
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
