package tildim.hstools.hspitytimertracker.gui.panel.popup;

import java.io.Serial;
import tildim.hstools.hspitytimertracker.util.Text;

/**
 * {@code InputErrorPopupWindowPanel} is a {@link #JPanel} that is used for displaying the content of the pop-up window
 * that pops when attempting to increase a counter after it reaches its limit.
 *
 * @author Tilemachos Dimos
 * @see AbstractPopupWindowPanel
 */
public class InputErrorPopupWindowPanel extends AbstractPopupWindowPanel {

    @Serial
    private static final long serialVersionUID = 2360542949074475893L;

    /**
     * Constructs a {@link #AbstractPopupWindowPanel} and places its body in it.
     */
    public InputErrorPopupWindowPanel() {
        super(null, Text.INPUT_ERROR_MESSAGE_TEXT);

        add(super.getBody());
    }

}
