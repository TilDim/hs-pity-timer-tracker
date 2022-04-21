package tildim.hstools.hspitytimertracker.service;

import tildim.hstools.hspitytimertracker.gui.TrackerGUI;
import tildim.hstools.hspitytimertracker.gui.panel.expansion.AbstractExpansionPanel;
import tildim.hstools.hspitytimertracker.gui.panel.expansion.button.IconButton;
import tildim.hstools.hspitytimertracker.gui.panel.expansion.modifier.button.AddButton;
import tildim.hstools.hspitytimertracker.gui.panel.expansion.modifier.button.ResModButton;
import tildim.hstools.hspitytimertracker.gui.panel.expansion.modifier.textfield.IncrementField;
import tildim.hstools.hspitytimertracker.gui.panel.header.button.HeaderButton;
import tildim.hstools.hspitytimertracker.gui.panel.mode.StandardModePanel;
import tildim.hstools.hspitytimertracker.gui.panel.mode.WildModePanel;
import tildim.hstools.hspitytimertracker.gui.panel.modebuttons.button.StandardModeButton;
import tildim.hstools.hspitytimertracker.gui.panel.modebuttons.button.WildModeButton;
import tildim.hstools.hspitytimertracker.gui.panel.popup.HelpPopupWindowPanel;
import tildim.hstools.hspitytimertracker.gui.panel.popup.InputErrorPopupWindowPanel;
import tildim.hstools.hspitytimertracker.gui.panel.popup.ModifyPopupWindowPanel;
import tildim.hstools.hspitytimertracker.gui.panel.tracker.TrackerPanel;
import tildim.hstools.hspitytimertracker.gui.panel.year.AbstractYearPanel;
import tildim.hstools.hspitytimertracker.gui.panel.yearshortcutbuttons.StandardYearShortcutButtonsPanel;
import tildim.hstools.hspitytimertracker.gui.panel.yearshortcutbuttons.WildYearShortcutButtonsPanel;
import tildim.hstools.hspitytimertracker.gui.panel.yearshortcutbuttons.button.AbstractYearShortcutButton;
import tildim.hstools.hspitytimertracker.util.*;
import tildim.hstools.hspitytimertracker.util.uri.URIHelper;

import javax.swing.*;
import java.io.IOException;
import java.net.URI;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.List;

/**
 *
 */
public class TrackerService {

    // Tracker panel
    private final TrackerPanel trackerPanel;

    // Expansion URIs
    private List<URI> expansionURIs;

    // Card pack URIs
    private List<URI> cardPackURIs;

    // "Help" button
    private HeaderButton helpButton;

    // "Save folder" button
    private HeaderButton saveFolderButton;

    // Mode buttons
    private StandardModeButton standardModeButton;
    private WildModeButton wildModeButton;

    // Mode panels
    private StandardModePanel standardModePanel;
    private WildModePanel wildModePanel;

    // Year shortcut buttons panels
    private StandardYearShortcutButtonsPanel standardYearShortcutButtonsPanel;
    private WildYearShortcutButtonsPanel wildYearShortcutButtonsPanel;

    // Year shortcut buttons
    private List<AbstractYearShortcutButton> yearShortcutButtons;

    // Year panels
    private List<AbstractYearPanel> yearPanels;

    // Expansion panels
    private List<AbstractExpansionPanel> expansionPanels;

    // Expansion icon buttons
    private List<IconButton> expansionButtons;

    // Epic counters
    private List<Integer> epicCounters;

    // Epic reset buttons
    private List<ResModButton> epicResetButtons;

    // Epic add buttons
    private List<AddButton> epicAddButtons;

    // Epic increment fields
    private List<IncrementField> epicIncrementFields;

    // Epic probabilities
    private List<Double> epicProbabilities;

    // Legendary counters
    private List<Integer> legendaryCounters;

    // Legendary reset buttons
    private List<ResModButton> legendaryResetButtons;

    // Legendary add buttons
    private List<AddButton> legendaryAddButtons;

    // Legendary increment fields
    private List<IncrementField> legendaryIncrementFields;

    // Legendary probabilities
    private List<Double> legendaryProbabilities;

    // Total Packs counters
    private List<Integer> totalCounters;

    // Total modify buttons
    private List<ResModButton> totalModifyButtons;

    // Total add buttons
    private List<AddButton> totalAddButtons;

    // Total increment fields
    private List<IncrementField> totalIncrementFields;

    // Card pack icon buttons
    private List<IconButton> cardPackButtons;

    // Help message
    String helpMessage;

    // Format in which the probabilities' values are displayed
    private final NumberFormat nf = new DecimalFormat("##.##");

    /**
     * Constructor with an instance of TrackerGUI as an argument
     *
     * @param trackerGUI is the instance of TrackerGUI to be given functionality
     */
    public TrackerService(TrackerGUI trackerGUI) {
        // Tracker GUI
        trackerPanel = trackerGUI.getTrackerPanel();

        // Create the save file
        FileHelper.createSaveFile();

        // Tracker URIs
        createTrackerURIs();

        // Tracker components
        setTrackerComponents();

        // Tracker action listeners
        setTrackerActionListeners();
    }

    /**
     * Creates the tracker URIs
     */
    private void createTrackerURIs() {
        // Expansion URIs
        expansionURIs = URIHelper.getExpansionURIs();

        // Card pack URIs
        cardPackURIs = URIHelper.getCardPackURIs();
    }

    /**
     * Sets the tracker components
     */
    private void setTrackerComponents() {
        // "Help" message
        helpMessage = FileHelper.setHelpMessageText();

        // "Help" button
        helpButton = trackerPanel.getHeaderPanel()
                                 .getHelp();

        // "Save folder" button
        saveFolderButton = trackerPanel.getHeaderPanel()
                                       .getSaveFolder();

        // 'Standard' mode button
        standardModeButton = trackerPanel.getModeButtonsPanel()
                                         .getStandardModeButton();

        // 'Wild' mode button
        wildModeButton = trackerPanel.getModeButtonsPanel()
                                     .getWildModeButton();

        // 'Standard' year shortcut buttons panel
        standardYearShortcutButtonsPanel = trackerPanel.getStandardYearShortcutButtonsPanel();

        // 'Wild' year shortcut buttons panel
        wildYearShortcutButtonsPanel = trackerPanel.getWildYearShortcutButtonsPanel();

        // Year shortcut buttons
        yearShortcutButtons = TrackerComponentsHelper.getYearShortcutButtons(trackerPanel);

        // 'Standard' mode panel
        standardModePanel = trackerPanel.getStandardModePanel();

        // 'Wild' mode panel
        wildModePanel = trackerPanel.getWildModePanel();

        // Year panels
        yearPanels = TrackerComponentsHelper.getYearPanels(trackerPanel);

        // Expansion panels
        expansionPanels = TrackerComponentsHelper.getExpansionPanels(trackerPanel);

        // Tracker values
        FileHelper.setTrackerValues(expansionPanels);

        // Expansion buttons
        expansionButtons = TrackerComponentsHelper.getExpansionButtons(expansionPanels);

        // Epic counters
        epicCounters = TrackerComponentsHelper.getEpicCounters(expansionPanels);

        // Epic "Reset" buttons
        epicResetButtons = TrackerComponentsHelper.getEpicResetButtons(expansionPanels);

        // Epic "Add" buttons
        epicAddButtons = TrackerComponentsHelper.getEpicAddButtons(expansionPanels);

        // Epic increment fields
        epicIncrementFields = TrackerComponentsHelper.getEpicIncrementFields(expansionPanels);

        // Epic probabilities
        epicProbabilities = TrackerComponentsHelper.getEpicProbabilities(expansionPanels);

        // Legendary counters
        legendaryCounters = TrackerComponentsHelper.getLegendaryCounters(expansionPanels);

        // Legendary "Reset" buttons
        legendaryResetButtons = TrackerComponentsHelper.getLegendaryResetButtons(expansionPanels);

        // Legendary "Add" buttons
        legendaryAddButtons = TrackerComponentsHelper.getLegendaryAddButtons(expansionPanels);

        // Legendary increment fields
        legendaryIncrementFields = TrackerComponentsHelper.getLegendaryIncrementFields(expansionPanels);

        // Legendary probabilities
        legendaryProbabilities = TrackerComponentsHelper.getLegendaryProbabilities(expansionPanels);

        // Total counters
        totalCounters = TrackerComponentsHelper.getTotalCounters(expansionPanels);

        // Total "Modify" buttons
        totalModifyButtons = TrackerComponentsHelper.getTotalModifyButtons(expansionPanels);

        // Total "Add" buttons
        totalAddButtons = TrackerComponentsHelper.getTotalAddButtons(expansionPanels);

        // Total increment fields
        totalIncrementFields = TrackerComponentsHelper.getTotalIncrementFields(expansionPanels);

        // Card pack buttons
        cardPackButtons = TrackerComponentsHelper.getCardPackButtons(expansionPanels);
    }

    /**
     * Adds action listeners to the tracker buttons
     */
    private void setTrackerActionListeners() {
        // "Help" button
        helpButton.addActionListener(e ->
                JOptionPane.showMessageDialog(trackerPanel, new HelpPopupWindowPanel(helpMessage), Text.HELP_MESSAGE_TITLE, JOptionPane.INFORMATION_MESSAGE));

        // "Save folder" button
        saveFolderButton.addActionListener(e -> {
            try {
                Runtime.getRuntime()
                       .exec("explorer.exe /select," + FileHelper.SAVE_FILE_PATH);
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        });

        // Mode buttons
        standardModeButton.addActionListener(e -> standardModeButtonAction());
        wildModeButton.addActionListener(e -> wildModeButtonAction());

        // Year shortcut buttons
        for (int i = 0; i < yearShortcutButtons.size(); i++) {
            int index = i;
            yearShortcutButtons.get(i)
                               .addActionListener(e -> trackerPanel.getMainPanelContainer()
                                                                   .getVerticalScrollBar()
                                                                   .setValue(yearPanels.get(index)
                                                                                       .getY()));
        }

        // Expansion buttons
        for (int i = 0; i < expansionButtons.size(); i++) {
            int index = i;
            if (index != 0) {
                expansionButtons.get(i)
                                .addActionListener(e -> URIHelper.openURI(expansionURIs.get(index)));
            }
        }

        // Epic "Reset" buttons
        for (int i = 0; i < epicResetButtons.size(); i++) {
            int index = i;
            epicResetButtons.get(i)
                            .addActionListener(e -> epicResetAction(index));
        }

        // Epic "Add" buttons
        for (int i = 0; i < epicAddButtons.size(); i++) {
            int index = i;
            epicAddButtons.get(i)
                          .addActionListener(e -> epicAddAction(index));
        }

        // Legendary "Reset" buttons
        for (int i = 0; i < legendaryResetButtons.size(); i++) {
            int index = i;
            legendaryResetButtons.get(i)
                                 .addActionListener(e -> legendaryResetAction(index));
        }

        // Legendary "Add" buttons
        for (int i = 0; i < legendaryAddButtons.size(); i++) {
            int index = i;
            legendaryAddButtons.get(i)
                               .addActionListener(e -> legendaryAddAction(index));
        }

        // Total "Modify" buttons
        for (int i = 0; i < totalModifyButtons.size(); i++) {
            int index = i;
            totalModifyButtons.get(i)
                              .addActionListener(e -> totalModifyAction(index));
        }

        // Total "Add" buttons
        for (int i = 0; i < totalAddButtons.size(); i++) {
            int index = i;
            totalAddButtons.get(i)
                           .addActionListener(e -> totalAddAction(index));
        }

        // Card pack buttons
        for (int i = 0; i < cardPackButtons.size(); i++) {
            int index = i;
            cardPackButtons.get(i)
                           .addActionListener(e -> URIHelper.openURI(cardPackURIs.get(index)));
        }
    }

    /**
     * Action performed when the 'Standard' mode button is pressed
     */
    private void standardModeButtonAction() {
        // Show Standard sets
        standardModePanel.setVisible(true);

        // Hide Wild sets
        wildModePanel.setVisible(false);

        // Selected Mode button customization
        standardModeButton.setBackground(Colors.MODE_SELECTED_COLOR);
        standardModeButton.addMouseListener(standardModeButton.getSelectedModeButtonAdapter());

        // Unselected Mode button customization
        wildModeButton.setBackground(Colors.MODE_UNSELECTED_COLOR);
        wildModeButton.addMouseListener(wildModeButton.getUnselectedModeButtonAdapter());

        // Show Standard Years shortcut buttons panel
        standardYearShortcutButtonsPanel.setVisible(true);

        // Hide Wild Years shortcut buttons panel
        wildYearShortcutButtonsPanel.setVisible(false);

        // Move the scrollbar to the top
        trackerPanel.getMainPanelContainer()
                    .getVerticalScrollBar()
                    .setValue(0);
    }

    /**
     * Action performed when the 'Wild' mode button is pressed
     */
    private void wildModeButtonAction() {
        // Hide Standard sets
        standardModePanel.setVisible(false);

        // Show Wild sets
        wildModePanel.setVisible(true);

        // Unselected Mode button customization
        standardModeButton.setBackground(Colors.MODE_UNSELECTED_COLOR);
        standardModeButton.addMouseListener(standardModeButton.getUnselectedModeButtonAdapter());

        // Selected Mode button customization
        wildModeButton.setBackground(Colors.MODE_SELECTED_COLOR);
        wildModeButton.addMouseListener(wildModeButton.getSelectedModeButtonAdapter());

        // Hide Standard Years shortcut buttons panel
        standardYearShortcutButtonsPanel.setVisible(false);

        // Show Wild Years shortcut buttons panel
        wildYearShortcutButtonsPanel.setVisible(true);

        // Move the scrollbar to the top
        trackerPanel.getMainPanelContainer()
                    .getVerticalScrollBar()
                    .setValue(0);
    }

    /**
     * Action performed when an epic reset button is pressed
     *
     * @param index is the position of an expansion in the corresponding list
     */
    private void epicResetAction(int index) {
        // Set the counter's value to '0'
        epicCounters.set(index, 0);

        // Reset the increment field's value to '1'
        epicIncrementFields.get(index)
                           .setText("1");

        // Calculate the probability
        epicProbabilities.set(index, ProbabilityHelper.probabilityCalculator(epicCounters.get(index), PityTimers.EPIC_PITY_TIMER));

        // Update the displayed values and the save file
        String counter = Integer.toString(epicCounters.get(index));
        String probability = nf.format(epicProbabilities.get(index));
        FileHelper.updateEpicValues(expansionPanels, index, counter, probability);
    }

    /**
     * Action performed when an epic add button is pressed
     *
     * @param index is the position of an expansion in the corresponding list
     */
    private void epicAddAction(int index) {
        // Value of the counter after the increment field's value is added to the current counter's value
        int newCounterValue = epicCounters.get(index) + Integer.parseInt(epicIncrementFields.get(index)
                                                                                            .getText());

        // Check if the increment is valid and then add, otherwise "beep" and show pop-up error message
        if (newCounterValue < PityTimers.EPIC_PITY_TIMER) {
            // Set the counter's value to the new value
            epicCounters.set(index, newCounterValue);

            // Reset the increment field's value to '1'
            epicIncrementFields.get(index)
                               .setText("1");

            // Calculate the probability
            epicProbabilities.set(index, ProbabilityHelper.probabilityCalculator(epicCounters.get(index), PityTimers.EPIC_PITY_TIMER));

            // Update the displayed values and the save file
            String counter = Integer.toString(epicCounters.get(index));
            String probability = nf.format(epicProbabilities.get(index));
            FileHelper.updateEpicValues(expansionPanels, index, counter, probability);
        } else {
            java.awt.Toolkit.getDefaultToolkit()
                            .beep();
            JOptionPane.showMessageDialog(trackerPanel, new InputErrorPopupWindowPanel(), Text.INPUT_ERROR_MESSAGE_TITLE, JOptionPane.ERROR_MESSAGE);
        }
    }

    /**
     * Action performed when a legendary reset button is pressed
     *
     * @param index is the position of an expansion in the corresponding list
     */
    private void legendaryResetAction(int index) {
        // Set the counter's value to '0'
        legendaryCounters.set(index, 0);

        // Reset the increment field's value to '1'
        legendaryIncrementFields.get(index)
                                .setText("1");

        // Calculate the probability
        legendaryProbabilities.set(index, ProbabilityHelper.probabilityCalculator(legendaryCounters.get(index), PityTimers.LEGENDARY_PITY_TIMER));

        // Update the displayed values and the save file
        String counter = Integer.toString(legendaryCounters.get(index));
        String probability = nf.format(legendaryProbabilities.get(index));
        FileHelper.updateLegendaryValues(expansionPanels, index, counter, probability);
    }

    /**
     * Action performed when a legendary add button is pressed
     *
     * @param index is the position of an expansion in the corresponding list
     */
    private void legendaryAddAction(int index) {
        // Value of the counter after the increment field's value is added to the current counter's value
        int newCounterValue = legendaryCounters.get(index) + Integer.parseInt(legendaryIncrementFields.get(index)
                                                                                                      .getText());

        // Check if the increment is valid and then add, otherwise "beep" and show pop-up error message
        if (newCounterValue < PityTimers.LEGENDARY_PITY_TIMER) {
            // Set the counter's value to the new value
            legendaryCounters.set(index, newCounterValue);

            // Reset the increment field's value to '1'
            legendaryIncrementFields.get(index)
                                    .setText("1");

            // Calculate the probability
            legendaryProbabilities.set(index, ProbabilityHelper.probabilityCalculator(legendaryCounters.get(index), PityTimers.LEGENDARY_PITY_TIMER));

            // Update the displayed values and the save file
            String counter = Integer.toString(legendaryCounters.get(index));
            String probability = nf.format(legendaryProbabilities.get(index));
            FileHelper.updateLegendaryValues(expansionPanels, index, counter, probability);
        } else {
            java.awt.Toolkit.getDefaultToolkit()
                            .beep();
            JOptionPane.showMessageDialog(trackerPanel, new InputErrorPopupWindowPanel(), Text.INPUT_ERROR_MESSAGE_TITLE, JOptionPane.ERROR_MESSAGE);
        }
    }

    /**
     * Action performed when a total modify button is pressed
     *
     * @param index is the position of an expansion in the corresponding list
     */
    private void totalModifyAction(int index) {
        int modifyValue = -1;
        // Open modify pop-up window to modify the counter's value
        try {
            modifyValue = Integer.parseInt(JOptionPane.showInputDialog(trackerPanel, new ModifyPopupWindowPanel(), totalCounters.get(index)));
        }
        // "Beep" if the value is not a number
        catch (NumberFormatException e) {
            java.awt.Toolkit.getDefaultToolkit()
                            .beep();
        }

        // Check if the input is valid and then add, otherwise "beep"
        if (modifyValue >= 0) {
            totalCounters.set(index, modifyValue);
        } else {
            java.awt.Toolkit.getDefaultToolkit()
                            .beep();
        }

        // Reset the increment field's value to '1'
        totalIncrementFields.get(index)
                            .setText("1");

        // Update the displayed values and the save file
        String counter = Integer.toString(totalCounters.get(index));
        FileHelper.updateTotalValues(expansionPanels, index, counter);
    }

    /**
     * Action performed when a total add button is pressed
     *
     * @param index is the position of an expansion in the corresponding list
     */
    private void totalAddAction(int index) {
        // Value of the counter after the increment field's value is added to the current counter' value
        int newCounterValue = totalCounters.get(index) + Integer.parseInt(totalIncrementFields.get(index)
                                                                                              .getText());

        // Set the counter's value to the new value
        totalCounters.set(index, newCounterValue);

        // Reset the increment field's value to '1'
        totalIncrementFields.get(index)
                            .setText("1");

        // Update the displayed values and the save file
        String counter = Integer.toString(totalCounters.get(index));
        FileHelper.updateTotalValues(expansionPanels, index, counter);
    }
}
