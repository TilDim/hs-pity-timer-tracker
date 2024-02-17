package tildim.hstools.hspitytimertracker.gui.panel.year;

import java.io.Serial;
import tildim.hstools.hspitytimertracker.gui.panel.expansion.yearofthepegasus.WhizbangsWorkshopPanel;
import tildim.hstools.hspitytimertracker.util.Text;
import tildim.hstools.hspitytimertracker.util.icon.IconPaths;

/**
 * {@code YearOfThePegasusPanel} is a {@link #JPanel} that contains all the instances of {@code AbstractExpansionPanel}
 * which belong in the <i>Year of the Pegasus</i>.
 *
 * @author Tilemachos Dimos
 * @see AbstractYearPanel
 * @see WhizbangsWorkshopPanel
 */
public class YearOfThePegasusPanel extends AbstractYearPanel {

    @Serial
    private static final long serialVersionUID = 3523813504945176099L;

    /**
     * Constructs a {@link #AbstractYearPanel} with all the <i>Year of the Pegasus</i> specific properties
     * and places in it:
     * <ul>
     *     <li>
     *         a {@code WhizbangsWorkshopPanel}.
     *     </li>
     * </ul>
     */
    public YearOfThePegasusPanel() {
        super(IconPaths.PEGASUS_ICON_PATH, Text.PEGASUS_TITLE);

        // Instantiate the year panel's components
        WhizbangsWorkshopPanel whizbangsWorkshopPanel = new WhizbangsWorkshopPanel();

        // Add the expansion panels to a list
        yearExpansionPanels.add(whizbangsWorkshopPanel);

        // Add the components to the year panel
        add(whizbangsWorkshopPanel);
    }

}
