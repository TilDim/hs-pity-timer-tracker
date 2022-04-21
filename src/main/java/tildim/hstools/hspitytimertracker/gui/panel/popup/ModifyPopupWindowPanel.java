package tildim.hstools.hspitytimertracker.gui.panel.popup;

import tildim.hstools.hspitytimertracker.util.Text;

import java.io.Serial;

/**
 *
 */
public class ModifyPopupWindowPanel extends AbstractPopupWindowPanel {

    @Serial
    private static final long serialVersionUID = -7227122939920907350L;

    /**
     *
     */
    public ModifyPopupWindowPanel() {
        super(null, Text.MODIFY_MESSAGE_TEXT);

        add(super.getContent());
    }
}
