package tildim.hstools.hspitytimertracker.gui.panel.mode;

import java.io.Serial;
import java.util.ArrayList;
import java.util.List;
import javax.swing.BoxLayout;
import lombok.Getter;
import tildim.hstools.hspitytimertracker.gui.panel.ScrollablePanel;
import tildim.hstools.hspitytimertracker.gui.panel.year.AbstractYearPanel;

/**
 * {@code AbstractModePanel} is a {@link #ScrollablePanel} that contains all the instances of {@code AbstractYearPanel}
 * which belong in a specific mode.
 *
 * @author Tilemachos Dimos
 * @see AbstractYearPanel
 */
@Getter
public abstract class AbstractModePanel extends ScrollablePanel {

    @Serial
    private static final long serialVersionUID = 6416071498040467732L;

    protected final List<AbstractYearPanel> modeYearPanels;

    /**
     * Constructs a {@link #ScrollablePanel} and sets some of its properties.
     */
    protected AbstractModePanel() {
        super();

        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        setScrollableWidth(ScrollablePanel.ScrollableSizeHint.FIT);

        modeYearPanels = new ArrayList<>();
    }

}
