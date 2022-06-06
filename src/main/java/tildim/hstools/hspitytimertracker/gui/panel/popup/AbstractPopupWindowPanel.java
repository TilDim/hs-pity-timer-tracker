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
    private JTextPane body;

    /**
     * Constructs a {@link #JPanel}, sets its background color and creates its components, which are:
     * <ul>
     *     <li>
     *         a header {@code JTextPane} (optional);
     *     </li>
     *     <li>
     *         a body {@code JTextPane}.
     *     </li>
     * </ul>
     *
     * @param title the title of the {@code AbstractPopupWindowPanel}
     * @param text  the text of the {@code AbstractPopupWindowPanel}
     * @see JTextPane
     */
    protected AbstractPopupWindowPanel(String title, String text) {
        super();

        setBackground(Colors.POPUP_BACKGROUND_COLOR);

        if (title != null) {
            setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

            createPopupWindowPanelHeader(title);
            add(header);
        }

        createPopupWindowPanelBody(text);
    }

    /**
     * Creates the {@code AbstractPopupWindowPanel}'s' header.
     *
     * @param title the title of the {@code AbstractPopupWindowPanel}
     */
    private void createPopupWindowPanelHeader(String title) {
        header = new JTextPane();

        StyledDocument doc = header.getStyledDocument();
        SimpleAttributeSet set = new SimpleAttributeSet();

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
    }

    /**
     * Creates the {@code AbstractPopupWindowPanel}'s body.
     *
     * @param text the text of the {@code AbstractPopupWindowPanel}
     */
    private void createPopupWindowPanelBody(String text) {
        body = new JTextPane();

        StyledDocument doc = body.getStyledDocument();
        SimpleAttributeSet set = new SimpleAttributeSet();

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
