package tildim.hstools.hspitytimertracker.gui.panel.year;

import java.io.Serial;
import tildim.hstools.hspitytimertracker.gui.panel.expansion.yearofthephoenix.AshesOfOutlandPanel;
import tildim.hstools.hspitytimertracker.gui.panel.expansion.yearofthephoenix.MadnessAtTheDarkmoonFairePanel;
import tildim.hstools.hspitytimertracker.gui.panel.expansion.yearofthephoenix.ScholomanceAcademyPanel;
import tildim.hstools.hspitytimertracker.util.Text;
import tildim.hstools.hspitytimertracker.util.icon.IconPaths;

/**
 * {@code YearOfThePhoenixPanel} is a {@link #JPanel} that contains all the instances of {@code AbstractExpansionPanel}
 * which belong in the <i>Year of the Phoenix</i>.
 *
 * @author Tilemachos Dimos
 * @see AbstractYearPanel
 * @see MadnessAtTheDarkmoonFairePanel
 * @see ScholomanceAcademyPanel
 * @see AshesOfOutlandPanel
 */
public class YearOfThePhoenixPanel extends AbstractYearPanel {

    @Serial
    private static final long serialVersionUID = -4456634923070688574L;

    /**
     * Constructs a {@link #AbstractYearPanel} with all the <i>Year of the Phoenix</i> specific properties
     * and places in it:
     * <ul>
     *     <li>
     *         a {@code MadnessAtTheDarkmoonFairePanel};
     *     </li>
     *     <li>
     *         a {@code ScholomanceAcademyPanel};
     *     </li>
     *     <li>
     *         a {@code AshesOfOutlandPanel}.
     *     </li>
     * </ul>
     */
    public YearOfThePhoenixPanel() {
        super(IconPaths.PHOENIX_ICON_PATH, Text.PHOENIX_TITLE);

        // Instantiate the year panel's components
        MadnessAtTheDarkmoonFairePanel madnessAtTheDarkmoonFairePanel = new MadnessAtTheDarkmoonFairePanel();
        ScholomanceAcademyPanel scholomanceAcademyPanel = new ScholomanceAcademyPanel();
        AshesOfOutlandPanel ashesOfOutlandPanel = new AshesOfOutlandPanel();

        // Add the expansion panels to a list
        yearExpansionPanels.add(madnessAtTheDarkmoonFairePanel);
        yearExpansionPanels.add(scholomanceAcademyPanel);
        yearExpansionPanels.add(ashesOfOutlandPanel);

        // Add the components to the year panel
        add(madnessAtTheDarkmoonFairePanel);
        add(scholomanceAcademyPanel);
        add(ashesOfOutlandPanel);
    }

}
