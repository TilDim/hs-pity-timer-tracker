package tildim.hstools.hspitytimertracker.gui.panel.expansion.modifier.textfield;

import tildim.hstools.hspitytimertracker.util.Fonts;
import tildim.hstools.hspitytimertracker.util.Tooltips;

import javax.swing.*;
import java.io.Serial;

/**
 *
 */
public class IncrementField extends JTextArea {

    @Serial
    private static final long serialVersionUID = -8948518805156701041L;

    /**
     * @param rows
     * @param columns
     * @param right
     */
    public IncrementField(int rows, int columns, int right) {
        super(rows, columns);

        setBorder(BorderFactory.createEmptyBorder(0, 9, 0, right));
        setFont(Fonts.INCREMENT_FONT);

        setDocument(new LimitedIncrement(columns));
        getDocument().putProperty("filterNewlines", Boolean.TRUE);

        setText("1");
        setToolTipText(Tooltips.INCREMENT_BUTTON_TOOLTIP);
    }
}
