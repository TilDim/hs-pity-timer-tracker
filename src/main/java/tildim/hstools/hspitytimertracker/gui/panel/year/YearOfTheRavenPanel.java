package tildim.hstools.hspitytimertracker.gui.panel.year;

import java.io.Serial;
import tildim.hstools.hspitytimertracker.gui.panel.expansion.yearoftheraven.RastakhansRumblePanel;
import tildim.hstools.hspitytimertracker.gui.panel.expansion.yearoftheraven.TheBoomsdayProjectPanel;
import tildim.hstools.hspitytimertracker.gui.panel.expansion.yearoftheraven.TheWitchwoodPanel;
import tildim.hstools.hspitytimertracker.util.Text;
import tildim.hstools.hspitytimertracker.util.icon.IconPaths;

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
public class YearOfTheRavenPanel extends AbstractYearPanel {

    @Serial
    private static final long serialVersionUID = -1152369483672239288L;

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

        // Instantiate the year panel's components
        RastakhansRumblePanel rastakhansRumblePanel = new RastakhansRumblePanel();
        TheBoomsdayProjectPanel theBoomsdayProjectPanel = new TheBoomsdayProjectPanel();
        TheWitchwoodPanel theWitchwoodPanel = new TheWitchwoodPanel();

        // Add the expansion panels to a list
        yearExpansionPanels.add(rastakhansRumblePanel);
        yearExpansionPanels.add(theBoomsdayProjectPanel);
        yearExpansionPanels.add(theWitchwoodPanel);

        // Add the components to the year panel
        add(rastakhansRumblePanel);
        add(theBoomsdayProjectPanel);
        add(theWitchwoodPanel);
    }

}
