package tildim.hstools.hspitytimertracker.gui.panel.expansion.modifier.textfield;

import java.awt.Toolkit;
import java.io.Serial;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.PlainDocument;

/**
 * {@code LimitedIncrement} is {@link #PlainDocument} that is used as a limit to an instance of {@code IncrementField}.
 *
 * <p> The limit depends on the counter the {@code IncrementField} corresponds to.
 * <p> More specifically:
 * <ul>
 *     <li>
 *         the {@code IncrementField} of the <i>Epic</i> counter is limited to one digit and must be between
 *         '1' and '9';
 *     </li>
 *     <li>
 *         the {@code IncrementField} of the <i>Legendary</i> counter is limited to two digits and must be between
 *         '1' and '39';
 *     </li>
 *     <li>
 *         the {@code IncrementField} of the <i>Total</i> counter is limited to three digits.
 *     </li>
 * </ul>
 *
 * @see IncrementField
 */
public class LimitedIncrement extends PlainDocument {

    @Serial
    private static final long serialVersionUID = 1312107489729947740L;

    private final int limit;

    /**
     * Constructs a {@link #PlainDocument} and sets its character limit.
     *
     * @param limit the allowed length of the {@code IncrementField} in characters
     */
    public LimitedIncrement(int limit) {
        super();
        this.limit = limit;
    }

    @Override
    public void insertString(int offset, String str, AttributeSet attr) throws BadLocationException {
        if (str == null || str.length() > limit) {
            Toolkit.getDefaultToolkit()
                   .beep();

            return;
        }

        int length = str.length();
        boolean isValidInteger = true;

        for (int i = 0; i < length; i++) {
            if (!Character.isDigit(str.charAt(i))) {
                isValidInteger = false;
                break;
            }
        }

        if (isValidInteger && ((getLength() + str.length()) <= limit)) {
            super.insertString(offset, str, attr);
        } else {
            Toolkit.getDefaultToolkit()
                   .beep();
        }

        if (Integer.parseInt(getContent().getString(0, getLength())) > 39 && limit == 2) {
            super.replace(0, getLength(), "1", attr);

            Toolkit.getDefaultToolkit()
                   .beep();
        }

        Pattern p = Pattern.compile("^0");
        Matcher m = p.matcher(getContent().getString(0, getLength()));

        if (m.find()) {
            super.replace(0, getLength(), "1", attr);

            Toolkit.getDefaultToolkit()
                   .beep();
        }
    }

    @Override
    public void replace(int offset, int len, String str, AttributeSet attr) throws BadLocationException {
        if (str == null || str.length() > limit) {
            Toolkit.getDefaultToolkit()
                   .beep();

            return;
        }

        int length = str.length();
        boolean isValidInteger = true;

        for (int i = 0; i < length; i++) {
            if (!Character.isDigit(str.charAt(i))) {
                isValidInteger = false;
                break;
            }
        }

        if (isValidInteger) {
            super.replace(offset, len, str, attr);
        } else {
            Toolkit.getDefaultToolkit()
                   .beep();
        }
    }

}
