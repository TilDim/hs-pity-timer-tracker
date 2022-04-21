package tildim.hstools.hspitytimertracker.gui.panel.year;

import lombok.Getter;
import tildim.hstools.hspitytimertracker.gui.panel.expansion.yearofthedragon.DescentOfDragonsPanel;
import tildim.hstools.hspitytimertracker.gui.panel.expansion.yearofthedragon.RiseOfShadowsPanel;
import tildim.hstools.hspitytimertracker.gui.panel.expansion.yearofthedragon.SaviorsOfUldumPanel;
import tildim.hstools.hspitytimertracker.util.Text;
import tildim.hstools.hspitytimertracker.util.icon.IconPaths;

import java.io.Serial;

/**
 *
 */
@Getter
public class YearOfTheDragonPanel extends AbstractYearPanel {

    @Serial
    private static final long serialVersionUID = 4976357851847132871L;

    private final DescentOfDragonsPanel descentOfDragonsPanel;
    private final SaviorsOfUldumPanel saviorsOfUldumPanel;
    private final RiseOfShadowsPanel riseOfShadowsPanel;

    /**
     *
     */
    public YearOfTheDragonPanel() {
        super(IconPaths.DRAGON_ICON_PATH, Text.DRAGON_TITLE);

        descentOfDragonsPanel = new DescentOfDragonsPanel();
        saviorsOfUldumPanel = new SaviorsOfUldumPanel();
        riseOfShadowsPanel = new RiseOfShadowsPanel();

        add(descentOfDragonsPanel);
        add(saviorsOfUldumPanel);
        add(riseOfShadowsPanel);
    }
}
