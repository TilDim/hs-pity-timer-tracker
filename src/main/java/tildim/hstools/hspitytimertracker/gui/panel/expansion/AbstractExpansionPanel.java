package tildim.hstools.hspitytimertracker.gui.panel.expansion;

import lombok.Getter;
import lombok.Setter;
import tildim.hstools.hspitytimertracker.exception.IconCreationException;
import tildim.hstools.hspitytimertracker.exception.TextPaneException;
import tildim.hstools.hspitytimertracker.gui.panel.expansion.button.IconButton;
import tildim.hstools.hspitytimertracker.gui.panel.expansion.modifier.button.AddButton;
import tildim.hstools.hspitytimertracker.gui.panel.expansion.modifier.button.ResModButton;
import tildim.hstools.hspitytimertracker.gui.panel.expansion.modifier.textfield.IncrementField;
import tildim.hstools.hspitytimertracker.util.Fonts;
import tildim.hstools.hspitytimertracker.util.ProbabilityHelper;
import tildim.hstools.hspitytimertracker.util.Text;
import tildim.hstools.hspitytimertracker.util.Tooltips;
import tildim.hstools.hspitytimertracker.util.icon.IconHelper;

import javax.swing.*;
import javax.swing.text.BadLocationException;
import javax.swing.text.SimpleAttributeSet;
import javax.swing.text.StyleConstants;
import javax.swing.text.StyledDocument;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.Serial;
import java.util.List;

/**
 *
 */
@Getter
@Setter
public abstract class AbstractExpansionPanel extends JPanel {

    @Serial
    private static final long serialVersionUID = 4250021228385909895L;

    // Variable for changing text style
    private transient StyledDocument doc;

    // Expansion panel colors
    private Color expansionBackground;
    private Color expansionForeground;

    // Icon panel
    private transient BufferedImage expansionIcon;
    private IconButton expansionButton;

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

    private transient BufferedImage cardPackIcon;
    private IconButton cardPackButton;

    /**
     * Constructor that calls the parent constructor and adds a panel with the expansion's icon, an epic pity timer panel, a legendary pity timer panel
     * and a panel with a total counter and buttons that show the expansion's cards based on their rarity
     *
     * @param expansionIconPath is the expansion icon's path from the source root
     * @param cardPackIconPath  is the card pack icon's path from the source root
     * @param background        is the panel's color
     * @param foreground        is the panel's text color
     * @param modifierColors    is a List with 3 colors for the modifiers: 1) background color, 2) foreground color and 3) hover color
     */
    protected AbstractExpansionPanel(String expansionIconPath, String cardPackIconPath, Color background, Color foreground, List<Color> modifierColors) {
        super();

        // Icon creation
        createExpansionIcon(expansionIconPath);
        createCardPackIcon(cardPackIconPath);

        // Expansion panel colors
        expansionBackground = background;
        expansionForeground = foreground;

        // Expansion panel
        setLayout(new GridLayout(1, 4));
        setBackground(expansionBackground);
        setBorder(BorderFactory.createEmptyBorder(0, 10, 0, 10));

        add(createExpansionIconPanel());
        add(createEpicPanel(modifierColors));
        add(createLegendaryPanel(modifierColors));
        add(createTotalPanel(modifierColors));
    }

    /**
     * Creates the expansion icons
     *
     * @param iconPath is the icon's path from the source root
     * @throws IconCreationException is thrown when the IconUtil.createIcon method fails to create the url of a path to an image
     */
    private void createExpansionIcon(String iconPath) throws IconCreationException {
        try {
            expansionIcon = IconHelper.createIcon(iconPath);
        } catch (IOException e) {
            throw new IconCreationException("Error while creating expansion icon", e.getCause());
        }
    }

    /**
     * Creates the card pack icon
     *
     * @param iconPath is the icon's path from the source root
     * @throws IconCreationException is thrown when the IconUtil.createIcon method fails to create the url of a path to an image
     */
    private void createCardPackIcon(String iconPath) throws IconCreationException {
        try {
            cardPackIcon = IconHelper.createIcon(iconPath);
        } catch (IOException e) {
            throw new IconCreationException("Error while creating card pack icon", e.getCause());
        }
    }

    /**
     * Creates the expansion icon panel
     *
     * @return the expansion icon panel
     */
    private JPanel createExpansionIconPanel() {
        // Expansion icon button panel
        JPanel expansionIconPanel = new JPanel();
        expansionIconPanel.setLayout(new GridBagLayout());
        expansionIconPanel.setBackground(expansionBackground);

        // Expansion icon button
        expansionButton = new IconButton(expansionIcon, Tooltips.EXPANSION_ICON_BUTTON_TOOLTIP);

        expansionIconPanel.add(expansionButton);

        return expansionIconPanel;
    }

    /**
     * Creates the expansion's epic panel
     *
     * @param modifierColors is a List with 3 colors for the modifiers: 1) background color, 2) foreground color and 3) hover color
     * @return the epic panel
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
        epicResetButton = new ResModButton(Text.RESET, Tooltips.RESET_BUTTON_TOOLTIP, modifierColors.get(2), modifierColors.get(0));

        // Blank space between reset and add buttons
        JLabel epicBlank = new JLabel();
        epicBlank.setBackground(expansionBackground);
        epicBlank.setBorder(BorderFactory.createEmptyBorder(0, 20, 0, 20));

        // Add button
        epicAddButton = new AddButton(modifierColors.get(2), modifierColors.get(0));

        // Increment field
        epicIncrementField = new IncrementField(1, 1, 6);

        // Modifiers panel
        JPanel epicModifiersPanel = createModifierPanel(modifierColors, epicBlank, epicResetButton, epicAddButton, epicIncrementField);

        // Packs without epic probability panel
        epicPanelProbabilityText = new JTextPane();
        doc = epicPanelProbabilityText.getStyledDocument();
        changePanelTextStyle(epicPanelProbabilityText, Text.EPIC_PROBABILITY_TEXT, ProbabilityHelper.probabilityToString(epicProbability));

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
     * Creates the expansion's legendary panel
     *
     * @param modifierColors is a List with 3 colors for the modifiers: 1) background color, 2) foreground color and 3) hover color
     * @return the legendary panel
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
        legendaryResetButton = new ResModButton(Text.RESET, Tooltips.RESET_BUTTON_TOOLTIP, modifierColors.get(2), modifierColors.get(0));

        // Blank space between reset and add buttons
        JLabel legendaryBlank = new JLabel();
        legendaryBlank.setBackground(expansionBackground);
        legendaryBlank.setBorder(BorderFactory.createEmptyBorder(0, 20, 0, 20));

        // Add button
        legendaryAddButton = new AddButton(modifierColors.get(2), modifierColors.get(0));

        // Increment field
        legendaryIncrementField = new IncrementField(1, 2, 3);

        // Modifiers panel
        JPanel legendaryModifiersPanel = createModifierPanel(modifierColors, legendaryBlank, legendaryResetButton, legendaryAddButton, legendaryIncrementField);

        // Packs without legendary probability panel
        legendaryPanelProbabilityText = new JTextPane();
        doc = legendaryPanelProbabilityText.getStyledDocument();
        changePanelTextStyle(legendaryPanelProbabilityText, Text.LEGENDARY_PROBABILITY_TEXT, ProbabilityHelper.probabilityToString(legendaryProbability));

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
     * Creates the expansion's total panel
     *
     * @param modifierColors is a List with 3 colors for the modifiers: 1) background color, 2) foreground color and 3) hover color
     * @return the total panel
     */
    private JPanel createTotalPanel(List<Color> modifierColors) {
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
        totalModifyButton = new ResModButton(Text.MODIFY, Tooltips.MODIFY_BUTTON_TOOLTIP, modifierColors.get(2), modifierColors.get(0));

        // Blank space between modify and add buttons
        JLabel totalBlank = new JLabel();
        totalBlank.setBackground(expansionBackground);
        totalBlank.setBorder(BorderFactory.createEmptyBorder(0, 5, 0, 5));

        // Add button
        totalAddButton = new AddButton(modifierColors.get(2), modifierColors.get(0));

        // Increment field
        totalIncrementField = new IncrementField(1, 3, 0);

        // Modifiers panel
        JPanel totalModifiersPanel = createModifierPanel(modifierColors, totalBlank, totalModifyButton, totalAddButton, totalIncrementField);

        // Card pack icon button panel
        JPanel cardPackIconButtonPanel = createCardPackIconPanel();

        gbc.gridy = 0;
        totalPanel.add(totalPanelTitle, gbc);

        gbc.gridy = 1;
        totalPanel.add(totalPanelCounterText, gbc);

        gbc.gridy = 2;
        totalPanel.add(totalModifiersPanel, gbc);

        gbc.gridy = 3;
        totalPanel.add(cardPackIconButtonPanel, gbc);

        return totalPanel;
    }

    /**
     * Creates the card pack icon panel
     *
     * @return the card pack icon panel
     */
    private JPanel createCardPackIconPanel() {
        // Card pack icon button panel
        JPanel cardPackIconPanel = new JPanel();
        cardPackIconPanel.setLayout(new GridBagLayout());
        cardPackIconPanel.setBackground(expansionBackground);

        // Card pack icon button
        cardPackButton = new IconButton(cardPackIcon, Tooltips.CARD_PACK_ICON_BUTTON_TOOLTIP);

        cardPackIconPanel.add(cardPackButton);

        return cardPackIconPanel;
    }

    /**
     * Changes the style of the title in a panel
     *
     * @param textPane is the current text pane
     * @param text     is the text of the panel's title
     */
    private void changePanelTitleStyle(JTextPane textPane, String text) {
        textPane.setBackground(expansionBackground);
        textPane.setForeground(expansionForeground);

        SimpleAttributeSet set = new SimpleAttributeSet();
        StyleConstants.setFontSize(set, Fonts.PANEL_TITLE_FONT_SIZE);
        StyleConstants.setFontFamily(set, Fonts.FONT_NAME);
        StyleConstants.setBold(set, true);
        StyleConstants.setAlignment(set, StyleConstants.ALIGN_CENTER);
        textPane.setCharacterAttributes(set, true);
        try {
            doc.insertString(doc.getLength(), text, set);
        } catch (BadLocationException e) {
            throw new TextPaneException("Error while setting this panel's title", e.getCause());
        }
        doc.setParagraphAttributes(0, doc.getLength(), set, false);

        textPane.setEditable(false);
        textPane.setHighlighter(null);
    }

    /**
     * Changes the style of the text in a panel
     *
     * @param textPane is the current text pane
     * @param text     is the text of the panel
     * @param number   is a value in a panel (counter or probability)
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
            throw new TextPaneException("Error while setting this panel's text", e.getCause());
        }

        set = new SimpleAttributeSet();
        StyleConstants.setBold(set, true);
        StyleConstants.setFontSize(set, Fonts.PANEL_NUMBER_FONT_SIZE);
        textPane.setCharacterAttributes(set, true);
        try {
            doc.insertString(doc.getLength(), number, set);
        } catch (BadLocationException e) {
            throw new TextPaneException("Error while setting this panel's number", e.getCause());
        }

        set = new SimpleAttributeSet();
        StyleConstants.setFontFamily(set, Fonts.FONT_NAME);
        StyleConstants.setAlignment(set, StyleConstants.ALIGN_CENTER);
        doc.setParagraphAttributes(0, doc.getLength(), set, false);

        textPane.setEditable(false);
        textPane.setCursor(Cursor.getPredefinedCursor(Cursor.TEXT_CURSOR));
    }

    /**
     * Creates the modifiers of a panel
     *
     * @param modifierColors is a List with 3 colors for the modifiers: 1) background color, 2) foreground color and 3) hover color
     * @param blank          is a blank panel to create some space between the reset/modify and add buttons
     * @param resMod         is the reset/modify button
     * @param add            is the add button
     * @param increment      is the increment field
     * @return a panel with the modifiers
     */
    private JPanel createModifierPanel(List<Color> modifierColors, JLabel blank, ResModButton resMod, AddButton add, JTextArea increment) {
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
     * Sets the value of the epic counter
     *
     * @param value is the String value of the counter
     */
    public void setEpicCounter(String value) {
        epicCounter = Integer.parseInt(value);
        epicPanelCounterText.setText("");
        doc = epicPanelCounterText.getStyledDocument();
        changePanelTextStyle(epicPanelCounterText, Text.EPIC_COUNTER_TEXT, value);
    }

    /**
     * Sets the value of the epic probability
     *
     * @param value is the String value of the probability
     */
    public void setEpicProbability(String value) {
        epicProbability = Double.parseDouble(value.replace(',', '.'));
        epicPanelProbabilityText.setText("");
        doc = epicPanelProbabilityText.getStyledDocument();
        changePanelTextStyle(epicPanelProbabilityText, Text.EPIC_PROBABILITY_TEXT, ProbabilityHelper.probabilityToString(epicProbability));
    }

    /**
     * Sets the value of the legendary counter
     *
     * @param value is the String value of the counter
     */
    public void setLegendaryCounter(String value) {
        legendaryCounter = Integer.parseInt(value);
        legendaryPanelCounterText.setText("");
        doc = legendaryPanelCounterText.getStyledDocument();
        changePanelTextStyle(legendaryPanelCounterText, Text.LEGENDARY_COUNTER_TEXT, value);
    }

    /**
     * Sets the value of the legendary probability
     *
     * @param value is the String value of the probability
     */
    public void setLegendaryProbability(String value) {
        legendaryProbability = Double.parseDouble(value.replace(',', '.'));
        legendaryPanelProbabilityText.setText("");
        doc = legendaryPanelProbabilityText.getStyledDocument();
        changePanelTextStyle(legendaryPanelProbabilityText, Text.LEGENDARY_PROBABILITY_TEXT, ProbabilityHelper.probabilityToString(legendaryProbability));
    }

    /**
     * Sets the value of the total counter
     *
     * @param value is the String value of the counter
     */
    public void setTotalCounter(String value) {
        totalCounter = Integer.parseInt(value);
        totalPanelCounterText.setText("");
        doc = totalPanelCounterText.getStyledDocument();
        changePanelTextStyle(totalPanelCounterText, Text.TOTAL_COUNTER_TEXT, value);
    }
}
