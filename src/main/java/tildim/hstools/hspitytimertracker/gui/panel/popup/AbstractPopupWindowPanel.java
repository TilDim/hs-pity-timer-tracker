package tildim.hstools.hspitytimertracker.gui.panel.popup;

import lombok.Getter;
import tildim.hstools.hspitytimertracker.exception.TextPaneException;
import tildim.hstools.hspitytimertracker.util.Colors;
import tildim.hstools.hspitytimertracker.util.Fonts;
import tildim.hstools.hspitytimertracker.util.Text;

import javax.swing.*;
import javax.swing.text.BadLocationException;
import javax.swing.text.SimpleAttributeSet;
import javax.swing.text.StyleConstants;
import javax.swing.text.StyledDocument;
import java.awt.*;
import java.io.Serial;

/**
 *
 */
@Getter
public abstract class AbstractPopupWindowPanel extends JPanel {

    @Serial
    private static final long serialVersionUID = 4176676159383242908L;

    private JTextPane header;
    private final JTextPane content;

    /**
     * @param title
     * @param message
     */
    protected AbstractPopupWindowPanel(String title, String message) {
        super();
        setBackground(Colors.POPUP_BACKGROUND_COLOR);

        StyledDocument doc;
        SimpleAttributeSet set;

        if (title != null) {
            setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

            header = new JTextPane();

            doc = header.getStyledDocument();
            set = new SimpleAttributeSet();

            StyleConstants.setBold(set, true);
            StyleConstants.setFontSize(set, Fonts.POPUP_TITLE_FONT_SIZE);
            StyleConstants.setFontFamily(set, Fonts.FONT_NAME);
            StyleConstants.setAlignment(set, StyleConstants.ALIGN_CENTER);
            header.setCharacterAttributes(set, true);

            try {
                doc.insertString(doc.getLength(), title.concat(Text.NEXT_LINE), set);
            } catch (BadLocationException e) {
                throw new TextPaneException("Error while setting the title of this pop-up window", e.getCause());
            }
            doc.setParagraphAttributes(0, doc.getLength(), set, false);

            header.setBackground(Colors.POPUP_BACKGROUND_COLOR);
            header.setEditable(false);
            header.setCursor(Cursor.getPredefinedCursor(Cursor.TEXT_CURSOR));

            add(header);
        }

        content = new JTextPane();

        doc = content.getStyledDocument();
        set = new SimpleAttributeSet();

        StyleConstants.setFontSize(set, Fonts.POPUP_TEXT_FONT_SIZE);
        StyleConstants.setFontFamily(set, Fonts.FONT_NAME);
        content.setCharacterAttributes(set, true);

        try {
            doc.insertString(doc.getLength(), message, set);
        } catch (BadLocationException e) {
            throw new TextPaneException("Error while setting the text of this pop-up window", e.getCause());
        }
        doc.setParagraphAttributes(0, doc.getLength(), set, false);

        content.setBackground(Colors.POPUP_BACKGROUND_COLOR);
        content.setEditable(false);
        content.setCursor(Cursor.getPredefinedCursor(Cursor.TEXT_CURSOR));
        content.setCaretPosition(0);
    }
}
