package tildim.hstools.hspitytimertracker.gui.panel.year;

import lombok.Getter;
import tildim.hstools.hspitytimertracker.gui.panel.expansion.yearofthemammoth.JourneyToUnGoroPanel;
import tildim.hstools.hspitytimertracker.gui.panel.expansion.yearofthemammoth.KnightsOfTheFrozenThronePanel;
import tildim.hstools.hspitytimertracker.gui.panel.expansion.yearofthemammoth.KoboldsAndCatacombsPanel;
import tildim.hstools.hspitytimertracker.util.Text;
import tildim.hstools.hspitytimertracker.util.icon.IconPaths;

import java.io.Serial;

/**
 *
 */
@Getter
public class YearOfTheMammothPanel extends AbstractYearPanel {

    @Serial
    private static final long serialVersionUID = 3972022712238641127L;

    private final KoboldsAndCatacombsPanel koboldsAndCatacombsPanel;
    private final KnightsOfTheFrozenThronePanel knightsOfTheFrozenThronePanel;
    private final JourneyToUnGoroPanel journeyToUnGoroPanel;

    /**
     *
     */
    public YearOfTheMammothPanel() {
        super(IconPaths.MAMMOTH_ICON_PATH, Text.MAMMOTH_TITLE);

        koboldsAndCatacombsPanel = new KoboldsAndCatacombsPanel();
        knightsOfTheFrozenThronePanel = new KnightsOfTheFrozenThronePanel();
        journeyToUnGoroPanel = new JourneyToUnGoroPanel();

        add(koboldsAndCatacombsPanel);
        add(knightsOfTheFrozenThronePanel);
        add(journeyToUnGoroPanel);
    }
}
