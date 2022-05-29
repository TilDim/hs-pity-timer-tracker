package tildim.hstools.hspitytimertracker.gui.panel.year;

import lombok.Getter;
import tildim.hstools.hspitytimertracker.gui.panel.expansion.yearoftheraven.RastakhansRumblePanel;
import tildim.hstools.hspitytimertracker.gui.panel.expansion.yearoftheraven.TheBoomsdayProjectPanel;
import tildim.hstools.hspitytimertracker.gui.panel.expansion.yearoftheraven.TheWitchwoodPanel;
import tildim.hstools.hspitytimertracker.util.Text;
import tildim.hstools.hspitytimertracker.util.icon.IconPaths;

import java.io.Serial;

/**
 * {@code YearOfTheRavenPanel} is a {@link #JPanel} that contains all the instances of {@code AbstractExpansionPanel}
 * which belong in the <i>Year of the Raven</i>.
 *
 * @author Tilemachos Dimos
 * @see AbstractYearPanel
 * @see RastakhansRumblePanel
 * @see TheBoomsdayProjectPanel
 * @see TheWitchwoodPanel
 */
@Getter
public class YearOfTheRavenPanel extends AbstractYearPanel {

    @Serial
    private static final long serialVersionUID = -1152369483672239288L;

    private final RastakhansRumblePanel rastakhansRumblePanel;
    private final TheBoomsdayProjectPanel theBoomsdayProjectPanel;
    private final TheWitchwoodPanel theWitchwoodPanel;

    /**
     * Constructs a {@link #AbstractYearPanel} with all the <i>Year of the Raven</i> specific properties
     * and places in it:
     * <ul>
     *     <li>
     *         a {@code RastakhansRumblePanel};
     *     </li>
     *     <li>
     *         a {@code TheBoomsdayProjectPanel};
     *     </li>
     *     <li>
     *         a {@code TheWitchwoodPanel}.
     *     </li>
     * </ul>
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
