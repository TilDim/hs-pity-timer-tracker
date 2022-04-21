package tildim.hstools.hspitytimertracker.gui.panel.year;

import lombok.Getter;
import tildim.hstools.hspitytimertracker.gui.panel.expansion.yearofthephoenix.AshesOfOutlandPanel;
import tildim.hstools.hspitytimertracker.gui.panel.expansion.yearofthephoenix.MadnessAtTheDarkmoonFairePanel;
import tildim.hstools.hspitytimertracker.gui.panel.expansion.yearofthephoenix.ScholomanceAcademyPanel;
import tildim.hstools.hspitytimertracker.util.Text;
import tildim.hstools.hspitytimertracker.util.icon.IconPaths;

import java.io.Serial;

/**
 *
 */
@Getter
public class YearOfThePhoenixPanel extends AbstractYearPanel {

    @Serial
    private static final long serialVersionUID = -4456634923070688574L;

    private final MadnessAtTheDarkmoonFairePanel madnessAtTheDarkmoonFairePanel;
    private final ScholomanceAcademyPanel scholomanceAcademyPanel;
    private final AshesOfOutlandPanel ashesOfOutlandPanel;

    /**
     *
     */
    public YearOfThePhoenixPanel() {
        super(IconPaths.PHOENIX_ICON_PATH, Text.PHOENIX_TITLE);

        madnessAtTheDarkmoonFairePanel = new MadnessAtTheDarkmoonFairePanel();
        scholomanceAcademyPanel = new ScholomanceAcademyPanel();
        ashesOfOutlandPanel = new AshesOfOutlandPanel();

        add(madnessAtTheDarkmoonFairePanel);
        add(scholomanceAcademyPanel);
        add(ashesOfOutlandPanel);
    }
}
