package tildim.hstools.hspitytimertracker.gui.panel.popup;

import lombok.Getter;
import lombok.extern.slf4j.Slf4j;
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
 * {@code AbstractPopupWindowPanel} is a {@link #JPanel} that is used for displaying the content of a pop-up window.
 *
 * @author Tilemachos Dimos
 */
@Getter
@Slf4j
public abstract class AbstractPopupWindowPanel extends JPanel {

    @Serial
    private static final long serialVersionUID = 4176676159383242908L;

    private JTextPane header;
    private final JTextPane body;

    /**
     * Constructs a {@link #JPanel} and sets its background color and the properties of its components, which are
     * a header (optional) and a body.
     *
     * @param title the title of the {@code AbstractPopupWindowPanel}
     * @param text  the text of the {@code AbstractPopupWindowPanel}
     */
    protected AbstractPopupWindowPanel(String title, String text) {
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
            StyleConstants.setFontFamily(set, Fonts.MAIN_FONT_NAME);
            StyleConstants.setAlignment(set, StyleConstants.ALIGN_CENTER);
            header.setCharacterAttributes(set, true);

            try {
                doc.insertString(doc.getLength(), title.concat(Text.NEXT_LINE), set);
            } catch (BadLocationException e) {
                log.error("Error while setting the title of pop-up window");
                e.printStackTrace();
            }
            doc.setParagraphAttributes(0, doc.getLength(), set, false);

            header.setBackground(Colors.POPUP_BACKGROUND_COLOR);
            header.setEditable(false);
            header.setCursor(Cursor.getPredefinedCursor(Cursor.TEXT_CURSOR));

            add(header);
        }

        body = new JTextPane();

        doc = body.getStyledDocument();
        set = new SimpleAttributeSet();

        StyleConstants.setFontSize(set, Fonts.POPUP_TEXT_FONT_SIZE);
        StyleConstants.setFontFamily(set, Fonts.MAIN_FONT_NAME);
        body.setCharacterAttributes(set, true);

        try {
            doc.insertString(doc.getLength(), text, set);
        } catch (BadLocationException e) {
            log.error("Error while setting the text of pop-up window");
            e.printStackTrace();
        }
        doc.setParagraphAttributes(0, doc.getLength(), set, false);

        body.setBackground(Colors.POPUP_BACKGROUND_COLOR);
        body.setEditable(false);
        body.setCursor(Cursor.getPredefinedCursor(Cursor.TEXT_CURSOR));
        body.setCaretPosition(0);
    }
}
