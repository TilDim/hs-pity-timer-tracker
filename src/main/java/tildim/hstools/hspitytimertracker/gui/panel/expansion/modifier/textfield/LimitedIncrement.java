package tildim.hstools.hspitytimertracker.gui.panel.expansion.modifier.textfield;

import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.PlainDocument;
import java.awt.*;
import java.io.Serial;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 */
public class LimitedIncrement extends PlainDocument {

    @Serial
    private static final long serialVersionUID = 1312107489729947740L;

    private final int limit;

    /**
     * @param limit
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
