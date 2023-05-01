package tildim.hstools.hspitytimertracker.gui.panel.popup;

import java.io.Serial;
import tildim.hstools.hspitytimertracker.gui.panel.expansion.modifier.button.ResModButton;
import tildim.hstools.hspitytimertracker.util.Text;

/**
 * {@code ModifyPopupWindowPanel} is a {@link #JPanel} that is used for displaying the content of the pop-up window
 * that pops after the <i>Modify</i> {@code ResModButton} is pressed.
 *
 * @author Tilemachos Dimos
 * @see AbstractPopupWindowPanel
 * @see ResModButton
 */
public class ModifyPopupWindowPanel extends AbstractPopupWindowPanel {

    @Serial
    private static final long serialVersionUID = -7227122939920907350L;

    /**
     * Constructs a {@link #AbstractPopupWindowPanel} and places its body in it.
     */
    public ModifyPopupWindowPanel() {
        super(null, Text.MODIFY_MESSAGE_TEXT);

        add(super.getBody());
    }

}
