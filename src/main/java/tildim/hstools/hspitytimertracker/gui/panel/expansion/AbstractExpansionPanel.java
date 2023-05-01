package tildim.hstools.hspitytimertracker.gui.panel.expansion;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.Serial;
import java.util.List;
import javax.swing.*;
import javax.swing.text.BadLocationException;
import javax.swing.text.SimpleAttributeSet;
import javax.swing.text.StyleConstants;
import javax.swing.text.StyledDocument;
import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import tildim.hstools.hspitytimertracker.gui.panel.expansion.button.IconButton;
import tildim.hstools.hspitytimertracker.gui.panel.expansion.modifier.button.AddButton;
import tildim.hstools.hspitytimertracker.gui.panel.expansion.modifier.button.ResModButton;
import tildim.hstools.hspitytimertracker.gui.panel.expansion.modifier.textfield.IncrementField;
import tildim.hstools.hspitytimertracker.util.Fonts;
import tildim.hstools.hspitytimertracker.util.ProbabilityHelper;
import tildim.hstools.hspitytimertracker.util.Text;
import tildim.hstools.hspitytimertracker.util.Tooltips;
import tildim.hstools.hspitytimertracker.util.icon.IconHelper;

/**
 * {@code AbstractExpansionPanel} is a {@link #JPanel} that contains the expansion related sub-panels.
 *
 * @author Tilemachos Dimos
 * @see #createLogoPanel
 * @see #createEpicPanel
 * @see #createLegendaryPanel
 * @see #createTotalPanel
 */
@Getter
@Setter
@Slf4j
public abstract class AbstractExpansionPanel extends JPanel {

    @Serial
    private static final long serialVersionUID = 4250021228385909895L;

    // Expansion panel colors
    private Color expansionBackground;
    private Color expansionForeground;

    // Logo panel
    private IconButton logoButton;

    // Epic panel
    private JTextPane epicPanelCounterText;
    private int epicCounter;

    private ResModButton epicResetButton;
    private AddButton epicAddButton;
    private IncrementField epicIncrementField;

    private JTextPane epicPanelProbabilityText;
    private double epicProbability;

    // Legendary panel
    private JTextPane legendaryPanelCounterText;
    private int legendaryCounter;

    private ResModButton legendaryResetButton;
    private AddButton legendaryAddButton;
    private IncrementField legendaryIncrementField;

    private JTextPane legendaryPanelProbabilityText;
    private double legendaryProbability;

    // Total panel
    private JTextPane totalPanelCounterText;
    private int totalCounter;

    private ResModButton totalModifyButton;
    private AddButton totalAddButton;
    private IncrementField totalIncrementField;

    private IconButton cardPackButton;

    // Variable for changing text style
    private transient StyledDocument doc;

    /**
     * Constructs a {@link #JPanel}, sets some of its properties and places in it:
     * <ul>
     *     <li>
     *         an expansion logo {@code JPanel};
     *     </li>
     *     <li>
     *         an <i>Epic</i> pity timer {@code JPanel};
     *     </li>
     *     <li>
     *         a <i>Legendary</i> pity timer {@code JPanel};
     *     </li>
     *     <li>
     *         a <i>Total</i> card packs {@code JPanel}.
     *     </li>
     * </ul>
     *
     * @param logoIconPath     the logo icon's path from the source root
     * @param cardPackIconPath the card pack icon's path from the source root
     * @param background       the panel's background color
     * @param foreground       the panel's text color
     * @param modifierColors   a list with 3 colors for the modifiers: 1) the background color, 2) the foreground color
     *                         and 3) the hover color
     */
    protected AbstractExpansionPanel(String logoIconPath, String cardPackIconPath,
                                     Color background, Color foreground, List<Color> modifierColors) {
        super();

        // Icon creation
        BufferedImage logoIcon = createExpansionIcon(logoIconPath);
        BufferedImage cardPackIcon = createExpansionIcon(cardPackIconPath);

        // Expansion panel colors
        expansionBackground = background;
        expansionForeground = foreground;

        // Expansion panel
        setLayout(new GridLayout(1, 4));
        setBackground(expansionBackground);
        setBorder(BorderFactory.createEmptyBorder(0, 10, 0, 10));

        add(createLogoPanel(logoIcon));
        add(createEpicPanel(modifierColors));
        add(createLegendaryPanel(modifierColors));
        add(createTotalPanel(modifierColors, cardPackIcon));
    }

    /**
     * Creates an expansion icon.
     *
     * @param iconPath the icon's path from the source root
     * @return the expansion icon
     * @see #createLogoPanel
     * @see #createCardPackPanel
     */
    private BufferedImage createExpansionIcon(String iconPath) {
        BufferedImage icon = null;

        try {
            icon = IconHelper.createIcon(iconPath);
        } catch (IOException e) {
            log.error("Error while creating expansion icon");
            e.printStackTrace();
        }

        return icon;
    }

    /**
     * Creates the logo panel.
     *
     * @param icon the logo icon
     * @return the logo panel
     * @see #createExpansionIcon
     */
    private JPanel createLogoPanel(BufferedImage icon) {
        // Logo panel
        JPanel logoPanel = new JPanel();
        logoPanel.setLayout(new GridBagLayout());
        logoPanel.setBackground(expansionBackground);

        // Logo button
        logoButton = new IconButton(icon, Tooltips.LOGO_BUTTON_TOOLTIP);

        logoPanel.add(logoButton);

        return logoPanel;
    }

    /**
     * Creates the epic panel.
     *
     * @param modifierColors a list with 3 colors for the modifiers: 1) the background color, 2) the foreground color
     *                       and 3) the hover color
     * @return the epic panel
     * @see ProbabilityHelper#probabilityToString
     */
    private JPanel createEpicPanel(List<Color> modifierColors) {
        // Packs without epic panel
        JPanel epicPanel = new JPanel();
        epicPanel.setBackground(expansionBackground);
        epicPanel.setLayout(new GridBagLayout());

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.insets = new Insets(10, 0, 10, 0);
        gbc.weightx = 1;

        // Packs without epic panel title
        JTextPane epicPanelTitle = new JTextPane();
        doc = epicPanelTitle.getStyledDocument();
        changePanelTitleStyle(epicPanelTitle, Text.EPIC_PANEL_TITLE);

        // Packs without epic counter panel
        epicPanelCounterText = new JTextPane();
        doc = epicPanelCounterText.getStyledDocument();
        changePanelTextStyle(epicPanelCounterText, Text.EPIC_COUNTER_TEXT, String.valueOf(epicCounter));

        // Reset button
        epicResetButton = new ResModButton(Text.RESET, Tooltips.RESET_BUTTON_TOOLTIP,
                modifierColors.get(2), modifierColors.get(0));

        // Blank space between reset and add buttons
        JLabel epicBlank = new JLabel();
        epicBlank.setBackground(expansionBackground);
        epicBlank.setBorder(BorderFactory.createEmptyBorder(0, 20, 0, 20));

        // Add button
        epicAddButton = new AddButton(modifierColors.get(2), modifierColors.get(0));

        // Increment field
        epicIncrementField = new IncrementField(1, 1, 6);

        // Modifiers panel
        JPanel epicModifiersPanel = createModifierPanel(modifierColors, epicBlank,
                epicResetButton, epicAddButton, epicIncrementField);

        // Packs without epic probability panel
        epicPanelProbabilityText = new JTextPane();
        doc = epicPanelProbabilityText.getStyledDocument();
        changePanelTextStyle(epicPanelProbabilityText, Text.EPIC_PROBABILITY_TEXT,
                ProbabilityHelper.probabilityToString(epicProbability));

        gbc.gridy = 0;
        epicPanel.add(epicPanelTitle, gbc);

        gbc.gridy = 1;
        epicPanel.add(epicPanelCounterText, gbc);

        gbc.gridy = 2;
        epicPanel.add(epicModifiersPanel, gbc);

        gbc.gridy = 3;
        epicPanel.add(epicPanelProbabilityText, gbc);

        return epicPanel;
    }

    /**
     * Creates the legendary panel.
     *
     * @param modifierColors a list with 3 colors for the modifiers: 1) the background color, 2) the foreground color
     *                       and 3) the hover color
     * @return the legendary panel
     * @see ProbabilityHelper#probabilityToString
     */
    private JPanel createLegendaryPanel(List<Color> modifierColors) {
        // Packs without legendary panel
        JPanel legendaryPanel = new JPanel();
        legendaryPanel.setBackground(expansionBackground);
        legendaryPanel.setLayout(new GridBagLayout());

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.insets = new Insets(10, 0, 10, 0);
        gbc.weightx = 1;

        // Packs without legendary panel title
        JTextPane legendaryPanelTitle = new JTextPane();
        doc = legendaryPanelTitle.getStyledDocument();
        changePanelTitleStyle(legendaryPanelTitle, Text.LEGENDARY_PANEL_TITLE);

        // Packs without legendary counter panel
        legendaryPanelCounterText = new JTextPane();
        doc = legendaryPanelCounterText.getStyledDocument();
        changePanelTextStyle(legendaryPanelCounterText, Text.LEGENDARY_COUNTER_TEXT, String.valueOf(legendaryCounter));

        // Reset button
        legendaryResetButton = new ResModButton(Text.RESET, Tooltips.RESET_BUTTON_TOOLTIP,
                modifierColors.get(2), modifierColors.get(0));

        // Blank space between reset and add buttons
        JLabel legendaryBlank = new JLabel();
        legendaryBlank.setBackground(expansionBackground);
        legendaryBlank.setBorder(BorderFactory.createEmptyBorder(0, 20, 0, 20));

        // Add button
        legendaryAddButton = new AddButton(modifierColors.get(2), modifierColors.get(0));

        // Increment field
        legendaryIncrementField = new IncrementField(1, 2, 3);

        // Modifiers panel
        JPanel legendaryModifiersPanel = createModifierPanel(modifierColors, legendaryBlank,
                legendaryResetButton, legendaryAddButton, legendaryIncrementField);

        // Packs without legendary probability panel
        legendaryPanelProbabilityText = new JTextPane();
        doc = legendaryPanelProbabilityText.getStyledDocument();
        changePanelTextStyle(legendaryPanelProbabilityText, Text.LEGENDARY_PROBABILITY_TEXT,
                ProbabilityHelper.probabilityToString(legendaryProbability));

        gbc.gridy = 0;
        legendaryPanel.add(legendaryPanelTitle, gbc);

        gbc.gridy = 1;
        legendaryPanel.add(legendaryPanelCounterText, gbc);

        gbc.gridy = 2;
        legendaryPanel.add(legendaryModifiersPanel, gbc);

        gbc.gridy = 3;
        legendaryPanel.add(legendaryPanelProbabilityText, gbc);

        return legendaryPanel;
    }

    /**
     * Creates the total panel.
     *
     * @param modifierColors a list with 3 colors for the modifiers: 1) the background color, 2) the foreground color
     *                       and 3) the hover color
     * @param icon           the card pack icon
     * @return the total panel
     */
    private JPanel createTotalPanel(List<Color> modifierColors, BufferedImage icon) {
        // Total amount of packs opened panel
        JPanel totalPanel = new JPanel();
        totalPanel.setBackground(expansionBackground);
        totalPanel.setLayout(new GridBagLayout());

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.insets = new Insets(10, 0, 10, 0);
        gbc.weightx = 1;

        // Total amount of packs opened panel title
        JTextPane totalPanelTitle = new JTextPane();
        doc = totalPanelTitle.getStyledDocument();
        changePanelTitleStyle(totalPanelTitle, Text.TOTAL_PANEL_TITLE);

        // Total amount of packs opened counter panel
        totalPanelCounterText = new JTextPane();
        doc = totalPanelCounterText.getStyledDocument();
        changePanelTextStyle(totalPanelCounterText, Text.TOTAL_COUNTER_TEXT, String.valueOf(totalCounter));

        // Modify button
        totalModifyButton = new ResModButton(Text.MODIFY, Tooltips.MODIFY_BUTTON_TOOLTIP,
                modifierColors.get(2), modifierColors.get(0));

        // Blank space between modify and add buttons
        JLabel totalBlank = new JLabel();
        totalBlank.setBackground(expansionBackground);
        totalBlank.setBorder(BorderFactory.createEmptyBorder(0, 5, 0, 5));

        // Add button
        totalAddButton = new AddButton(modifierColors.get(2), modifierColors.get(0));

        // Increment field
        totalIncrementField = new IncrementField(1, 3, 0);

        // Modifiers panel
        JPanel totalModifiersPanel = createModifierPanel(modifierColors, totalBlank,
                totalModifyButton, totalAddButton, totalIncrementField);

        // Card pack panel
        JPanel cardPackPanel = createCardPackPanel(icon);

        gbc.gridy = 0;
        totalPanel.add(totalPanelTitle, gbc);

        gbc.gridy = 1;
        totalPanel.add(totalPanelCounterText, gbc);

        gbc.gridy = 2;
        totalPanel.add(totalModifiersPanel, gbc);

        gbc.gridy = 3;
        totalPanel.add(cardPackPanel, gbc);

        return totalPanel;
    }

    /**
     * Creates the card pack panel.
     *
     * @param icon the card pack icon
     * @return the card pack panel
     * @see #createExpansionIcon
     */
    private JPanel createCardPackPanel(BufferedImage icon) {
        // Card pack panel
        JPanel cardPackPanel = new JPanel();
        cardPackPanel.setLayout(new GridBagLayout());
        cardPackPanel.setBackground(expansionBackground);

        // Card pack button
        cardPackButton = new IconButton(icon, Tooltips.CARD_PACK_BUTTON_TOOLTIP);

        cardPackPanel.add(cardPackButton);

        return cardPackPanel;
    }

    /**
     * Changes the style of the title in a panel.
     *
     * @param textPane the current text pane
     * @param text     the text of the panel's title
     */
    private void changePanelTitleStyle(JTextPane textPane, String text) {
        textPane.setBackground(expansionBackground);
        textPane.setForeground(expansionForeground);

        SimpleAttributeSet set = new SimpleAttributeSet();
        StyleConstants.setFontSize(set, Fonts.PANEL_TITLE_FONT_SIZE);
        StyleConstants.setFontFamily(set, Fonts.MAIN_FONT_NAME);
        StyleConstants.setBold(set, true);
        StyleConstants.setAlignment(set, StyleConstants.ALIGN_CENTER);
        textPane.setCharacterAttributes(set, true);
        try {
            doc.insertString(doc.getLength(), text, set);
        } catch (BadLocationException e) {
            log.error("Error while setting this panel's title");
            e.printStackTrace();
        }
        doc.setParagraphAttributes(0, doc.getLength(), set, false);

        textPane.setEditable(false);
        textPane.setHighlighter(null);
    }

    /**
     * Changes the style of the text in a panel.
     *
     * @param textPane the current text pane
     * @param text     the text of the panel
     * @param number   a value in a panel (counter or probability)
     */
    private void changePanelTextStyle(JTextPane textPane, String text, String number) {
        textPane.setBackground(expansionBackground);
        textPane.setForeground(expansionForeground);

        SimpleAttributeSet set = new SimpleAttributeSet();
        StyleConstants.setFontSize(set, Fonts.PANEL_TEXT_FONT_SIZE);
        textPane.setCharacterAttributes(set, true);
        try {
            doc.insertString(doc.getLength(), text, set);
        } catch (BadLocationException e) {
            log.error("Error while setting this panel's text");
            e.printStackTrace();
        }

        set = new SimpleAttributeSet();
        StyleConstants.setBold(set, true);
        StyleConstants.setFontSize(set, Fonts.PANEL_NUMBER_FONT_SIZE);
        textPane.setCharacterAttributes(set, true);
        try {
            doc.insertString(doc.getLength(), number, set);
        } catch (BadLocationException e) {
            log.error("Error while setting this panel's number");
            e.printStackTrace();
        }

        set = new SimpleAttributeSet();
        StyleConstants.setFontFamily(set, Fonts.MAIN_FONT_NAME);
        StyleConstants.setAlignment(set, StyleConstants.ALIGN_CENTER);
        doc.setParagraphAttributes(0, doc.getLength(), set, false);

        textPane.setEditable(false);
        textPane.setCursor(Cursor.getPredefinedCursor(Cursor.TEXT_CURSOR));
    }

    /**
     * Creates the modifiers of a panel.
     *
     * @param modifierColors a list with 3 colors for the modifiers: 1) the background color, 2) the foreground color
     *                       and 3) the hover color
     * @param blank          a blank panel to create some space between the reset/modify and add buttons
     * @param resMod         the reset/modify button
     * @param add            the add button
     * @param increment      the increment field
     * @return a panel with the modifiers
     */
    private JPanel createModifierPanel(List<Color> modifierColors, JLabel blank,
                                       ResModButton resMod, AddButton add, JTextArea increment) {
        // Modifiers panel
        JPanel modifiersPanel = new JPanel();
        modifiersPanel.setBackground(expansionBackground);
        modifiersPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 15, 0));

        // "Reset" / "Modify" button
        resMod.setBackground(modifierColors.get(0));
        resMod.setForeground(modifierColors.get(1));

        // "Add" button
        add.setBackground(modifierColors.get(0));
        add.setForeground(modifierColors.get(1));

        // Increment field
        increment.setBackground(modifierColors.get(0));
        increment.setForeground(modifierColors.get(1));
        increment.setCaretColor(modifierColors.get(1));

        modifiersPanel.add(resMod);
        modifiersPanel.add(blank);
        modifiersPanel.add(add);
        modifiersPanel.add(increment);

        return modifiersPanel;
    }

    /**
     * Sets the value of the epic counter.
     *
     * @param value the String value of the counter
     */
    public void setEpicCounter(String value) {
        epicCounter = Integer.parseInt(value);
        epicPanelCounterText.setText("");
        doc = epicPanelCounterText.getStyledDocument();
        changePanelTextStyle(epicPanelCounterText, Text.EPIC_COUNTER_TEXT, value);
    }

    /**
     * Sets the value of the epic probability.
     *
     * @param value the String value of the probability
     * @see ProbabilityHelper#probabilityToString
     */
    public void setEpicProbability(String value) {
        epicProbability = Double.parseDouble(value.replace(',', '.'));
        epicPanelProbabilityText.setText("");
        doc = epicPanelProbabilityText.getStyledDocument();
        changePanelTextStyle(epicPanelProbabilityText, Text.EPIC_PROBABILITY_TEXT,
                ProbabilityHelper.probabilityToString(epicProbability));
    }

    /**
     * Sets the value of the legendary counter.
     *
     * @param value the String value of the counter
     */
    public void setLegendaryCounter(String value) {
        legendaryCounter = Integer.parseInt(value);
        legendaryPanelCounterText.setText("");
        doc = legendaryPanelCounterText.getStyledDocument();
        changePanelTextStyle(legendaryPanelCounterText, Text.LEGENDARY_COUNTER_TEXT, value);
    }

    /**
     * Sets the value of the legendary probability.
     *
     * @param value the String value of the probability
     * @see ProbabilityHelper#probabilityToString
     */
    public void setLegendaryProbability(String value) {
        legendaryProbability = Double.parseDouble(value.replace(',', '.'));
        legendaryPanelProbabilityText.setText("");
        doc = legendaryPanelProbabilityText.getStyledDocument();
        changePanelTextStyle(legendaryPanelProbabilityText, Text.LEGENDARY_PROBABILITY_TEXT,
                ProbabilityHelper.probabilityToString(legendaryProbability));
    }

    /**
     * Sets the value of the total counter.
     *
     * @param value the String value of the counter
     */
    public void setTotalCounter(String value) {
        totalCounter = Integer.parseInt(value);
        totalPanelCounterText.setText("");
        doc = totalPanelCounterText.getStyledDocument();
        changePanelTextStyle(totalPanelCounterText, Text.TOTAL_COUNTER_TEXT, value);
    }

}
