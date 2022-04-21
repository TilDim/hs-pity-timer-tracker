package tildim.hstools.hspitytimertracker.gui.panel.popup;

import tildim.hstools.hspitytimertracker.util.Text;

import java.io.Serial;

/**
 *
 */
public class InputErrorPopupWindowPanel extends AbstractPopupWindowPanel {

    @Serial
    private static final long serialVersionUID = 2360542949074475893L;

    /**
     *
     */
    public InputErrorPopupWindowPanel() {
        super(null, Text.INPUT_ERROR_MESSAGE_TEXT);

        add(super.getContent());
    }
}
