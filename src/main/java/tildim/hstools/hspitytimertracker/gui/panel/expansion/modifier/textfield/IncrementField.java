package tildim.hstools.hspitytimertracker.gui.panel.expansion.modifier.textfield;

import java.io.Serial;
import javax.swing.BorderFactory;
import javax.swing.JTextArea;
import tildim.hstools.hspitytimertracker.gui.panel.expansion.AbstractExpansionPanel;
import tildim.hstools.hspitytimertracker.util.Fonts;
import tildim.hstools.hspitytimertracker.util.Tooltips;

/**
 * {@code IncrementField} is a {@link #JTextArea} that specifies the number by which a counter in a
 * {@code AbstractExpansionPanel} will be incremented.
 *
 * <p> The number and its digits are limited by an instance of {@code LimitedIncrement} depending on the counter
 * it increments.
 *
 * @author Tilemachos Dimos
 * @see AbstractExpansionPanel
 * @see LimitedIncrement
 */
public class IncrementField extends JTextArea {

    @Serial
    private static final long serialVersionUID = -8948518805156701041L;

    /**
     * Constructs a {@link #JTextArea} and sets some of its properties.
     *
     * @param rows    the displayed number of rows of the {@code IncrementField}
     * @param columns the displayed number of columns of the {@code IncrementField}
     * @param right   the number of pixels to be used as the right border of the {@code IncrementField}
     */
    public IncrementField(int rows, int columns, int right) {
        super(rows, columns);

        setBorder(BorderFactory.createEmptyBorder(0, 9, 0, right));
        setFont(Fonts.INCREMENT_FONT);

        setDocument(new LimitedIncrement(columns));
        getDocument().putProperty("filterNewlines", Boolean.TRUE);

        setText("1");
        setToolTipText(Tooltips.INCREMENT_FIELD_TOOLTIP);
    }

}
