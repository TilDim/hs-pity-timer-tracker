package tildim.hstools.hspitytimertracker.service;

import lombok.extern.slf4j.Slf4j;
import tildim.hstools.hspitytimertracker.gui.TrackerGUI;
import tildim.hstools.hspitytimertracker.gui.panel.expansion.AbstractExpansionPanel;
import tildim.hstools.hspitytimertracker.gui.panel.expansion.button.IconButton;
import tildim.hstools.hspitytimertracker.gui.panel.expansion.modifier.button.AddButton;
import tildim.hstools.hspitytimertracker.gui.panel.expansion.modifier.button.ResModButton;
import tildim.hstools.hspitytimertracker.gui.panel.expansion.modifier.textfield.IncrementField;
import tildim.hstools.hspitytimertracker.gui.panel.header.button.HeaderButton;
import tildim.hstools.hspitytimertracker.gui.panel.mode.AllModesPanel;
import tildim.hstools.hspitytimertracker.gui.panel.modebuttons.button.StandardModeButton;
import tildim.hstools.hspitytimertracker.gui.panel.modebuttons.button.WildModeButton;
import tildim.hstools.hspitytimertracker.gui.panel.popup.HelpPopupWindowPanel;
import tildim.hstools.hspitytimertracker.gui.panel.popup.InputErrorPopupWindowPanel;
import tildim.hstools.hspitytimertracker.gui.panel.popup.ModifyPopupWindowPanel;
import tildim.hstools.hspitytimertracker.gui.panel.tracker.TrackerPanel;
import tildim.hstools.hspitytimertracker.gui.panel.year.AbstractYearPanel;
import tildim.hstools.hspitytimertracker.gui.panel.yearshortcutbuttons.AllYearShortcutButtonsPanel;
import tildim.hstools.hspitytimertracker.gui.panel.yearshortcutbuttons.button.AbstractYearShortcutButton;
import tildim.hstools.hspitytimertracker.util.*;
import tildim.hstools.hspitytimertracker.util.uri.URIHelper;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;
import java.net.URI;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.List;

/**
 * {@code TrackerService} is a service class that gives functionality to the components of the {@code TrackerGUI}.
 *
 * @author Tilemachos Dimos
 * @see TrackerGUI
 */
@Slf4j
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

    // All year shortcut buttons panel
    private AllYearShortcutButtonsPanel allYearShortcutButtonsPanel;
    private CardLayout allYearShortcutButtonsPanelLayout;

    // Year shortcut buttons
    private List<AbstractYearShortcutButton> yearShortcutButtons;

    // All modes panel
    private AllModesPanel allModesPanel;
    private CardLayout allModesPanelLayout;

    // 'Standard' mode panel scroll pane
    private JScrollPane standardModePanelScrollPane;

    // 'Wild' mode panel scroll pane
    private JScrollPane wildModePanelScrollPane;

    // Year panels
    private List<AbstractYearPanel> yearPanels;

    // Expansion panels
    private List<AbstractExpansionPanel> expansionPanels;

    // Logo buttons
    private List<IconButton> logoButtons;

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

    // Card pack buttons
    private List<IconButton> cardPackButtons;

    // Help message
    private String helpMessage;

    // Format in which the probability values are displayed and saved
    private final NumberFormat decimalFormat = new DecimalFormat("##.##");

    /**
     * Creates and sets all the necessary components for the {@code TrackerService} to work.
     *
     * @param trackerGUI is the instance of {@code TrackerGUI} to be given functionality
     * @see TextFileHelper#createSaveFile
     */
    public TrackerService(TrackerGUI trackerGUI) {
        // Tracker GUI
        trackerPanel = trackerGUI.getTrackerPanel();

        // Create the save file
        TextFileHelper.createSaveFile();

        // Tracker URIs
        setTrackerURIs();

        // Tracker components
        setTrackerComponents();

        // Tracker action listeners
        setTrackerActionListeners();
    }

    /**
     * Sets the tracker URIs.
     *
     * @see URIHelper
     */
    private void setTrackerURIs() {
        // Expansion URIs
        expansionURIs = URIHelper.getExpansionURIs();

        // Card pack URIs
        cardPackURIs = URIHelper.getCardPackURIs();
    }

    /**
     * Sets the tracker components.
     *
     * @see TextFileHelper#setHelpMessageText
     * @see TextFileHelper#setTrackerValues
     * @see TrackerComponentsHelper
     */
    private void setTrackerComponents() {
        // "Help" message
        helpMessage = TextFileHelper.setHelpMessageText();

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

        // Year shortcut buttons panel
        allYearShortcutButtonsPanel = trackerPanel.getAllYearShortcutButtonsPanel();
        allYearShortcutButtonsPanelLayout = trackerPanel.getAllYearShortcutButtonsPanel()
                                                        .getLayout();

        // Year shortcut buttons
        yearShortcutButtons = TrackerComponentsHelper.getYearShortcutButtons(trackerPanel);

        // Main panel
        allModesPanel = trackerPanel.getAllModesPanel();
        allModesPanelLayout = trackerPanel.getAllModesPanel()
                                          .getLayout();

        // 'Standard' mode panel
        standardModePanelScrollPane = trackerPanel.getAllModesPanel()
                                                  .getStandardModePanelScrollPane();

        // 'Wild' mode panel
        wildModePanelScrollPane = trackerPanel.getAllModesPanel()
                                              .getWildModePanelScrollPane();

        // Year panels
        yearPanels = TrackerComponentsHelper.getYearPanels(trackerPanel);

        // Expansion panels
        expansionPanels = TrackerComponentsHelper.getExpansionPanels(trackerPanel);

        // Tracker values
        TextFileHelper.setTrackerValues(expansionPanels);

        // Logo buttons
        logoButtons = TrackerComponentsHelper.getLogoButtons(expansionPanels);

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
     * Adds action listeners to the tracker buttons.
     */
    private void setTrackerActionListeners() {
        // "Help" button
        helpButton.addActionListener(e ->
                JOptionPane.showMessageDialog(trackerPanel, new HelpPopupWindowPanel(helpMessage),
                        Text.HELP_MESSAGE_TITLE, JOptionPane.INFORMATION_MESSAGE));

        // "Save folder" button
        saveFolderButton.addActionListener(e -> {
            try {
                Runtime.getRuntime()
                       .exec("explorer.exe /select," + TextFileHelper.SAVE_FILE_PATH);
            } catch (IOException ex) {
                log.error("Error while opening the file explorer");
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
                               .addActionListener(e -> yearShortcutButtonAction(index));
        }

        // Logo buttons
        for (int i = 0; i < logoButtons.size(); i++) {
            int index = i;
            if (index != 0) {
                logoButtons.get(i)
                           .addActionListener(e -> URIHelper.showURI(expansionURIs.get(index)));
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
                           .addActionListener(e -> URIHelper.showURI(cardPackURIs.get(index)));
        }
    }

    /**
     * Action performed when the 'Standard' mode button is pressed.
     */
    private void standardModeButtonAction() {
        // Show 'Standard' sets
        allModesPanelLayout.show(allModesPanel, "Standard");

        // Selected Mode button customization
        standardModeButton.setBackground(Colors.MODE_SELECTED_COLOR);
        standardModeButton.addMouseListener(standardModeButton.getSelectedModeButtonAdapter());

        // Unselected Mode button customization
        wildModeButton.setBackground(Colors.MODE_UNSELECTED_COLOR);
        wildModeButton.addMouseListener(wildModeButton.getUnselectedModeButtonAdapter());

        // Show 'Standard' year shortcut buttons panel
        allYearShortcutButtonsPanelLayout.show(allYearShortcutButtonsPanel, "Standard");

        // Move the scrollbar to the top
        standardModePanelScrollPane.getVerticalScrollBar()
                                   .setValue(0);
    }

    /**
     * Action performed when the 'Wild' mode button is pressed.
     */
    private void wildModeButtonAction() {
        // Show 'Wild' sets
        allModesPanelLayout.show(allModesPanel, "Wild");

        // Unselected Mode button customization
        standardModeButton.setBackground(Colors.MODE_UNSELECTED_COLOR);
        standardModeButton.addMouseListener(standardModeButton.getUnselectedModeButtonAdapter());

        // Selected Mode button customization
        wildModeButton.setBackground(Colors.MODE_SELECTED_COLOR);
        wildModeButton.addMouseListener(wildModeButton.getSelectedModeButtonAdapter());

        // Show 'Wild' year shortcut buttons panel
        allYearShortcutButtonsPanelLayout.show(allYearShortcutButtonsPanel, "Wild");

        // Move the scrollbar to the top
        wildModePanelScrollPane.getVerticalScrollBar()
                               .setValue(0);
    }

    /**
     * Action performed when a year shortcut button is pressed.
     */
    private void yearShortcutButtonAction(int index) {
        if (index < yearShortcutButtons.size() - 2) {
            wildModePanelScrollPane.getVerticalScrollBar()
                                   .setValue(yearPanels.get(index)
                                                       .getY());
        } else {
            standardModePanelScrollPane.getVerticalScrollBar()
                                       .setValue(yearPanels.get(index)
                                                           .getY());
        }
    }

    /**
     * Action performed when an epic reset button is pressed.
     *
     * @param index is the position of an expansion in the corresponding list
     * @see ProbabilityHelper#probabilityCalculator
     * @see TextFileHelper#updateEpicValues
     */
    private void epicResetAction(int index) {
        // Set the counter's value to '0'
        epicCounters.set(index, 0);

        // Calculate the probability
        epicProbabilities.set(index, ProbabilityHelper.probabilityCalculator(epicCounters.get(index),
                PityTimers.EPIC_PITY_TIMER));

        // Update the displayed values and the save file
        String counter = Integer.toString(epicCounters.get(index));
        String probability = decimalFormat.format(epicProbabilities.get(index));
        TextFileHelper.updateEpicValues(expansionPanels, index, counter, probability);

        // Reset the increment field's value to '1'
        epicIncrementFields.get(index)
                           .setText("1");
    }

    /**
     * Action performed when an epic add button is pressed.
     *
     * @param index is the position of an expansion in the corresponding list
     * @see ProbabilityHelper#probabilityCalculator
     * @see TextFileHelper#updateEpicValues
     */
    private void epicAddAction(int index) {
        // Value of the counter after the increment field's value is added to the current counter's value
        int newCounterValue = epicCounters.get(index) + Integer.parseInt(epicIncrementFields.get(index)
                                                                                            .getText());

        // Check if the increment is valid and then add, otherwise "beep" and show pop-up error message
        if (newCounterValue < PityTimers.EPIC_PITY_TIMER) {
            // Set the counter's value to the new value
            epicCounters.set(index, newCounterValue);

            // Calculate the probability
            epicProbabilities.set(index, ProbabilityHelper.probabilityCalculator(epicCounters.get(index),
                    PityTimers.EPIC_PITY_TIMER));

            // Update the displayed values and the save file
            String counter = Integer.toString(epicCounters.get(index));
            String probability = decimalFormat.format(epicProbabilities.get(index));
            TextFileHelper.updateEpicValues(expansionPanels, index, counter, probability);
        } else {
            Toolkit.getDefaultToolkit()
                   .beep();
            JOptionPane.showMessageDialog(trackerPanel, new InputErrorPopupWindowPanel(),
                    Text.INPUT_ERROR_MESSAGE_TITLE, JOptionPane.ERROR_MESSAGE);
        }

        // Reset the increment field's value to '1'
        epicIncrementFields.get(index)
                           .setText("1");
    }

    /**
     * Action performed when a legendary reset button is pressed.
     *
     * @param index is the position of an expansion in the corresponding list
     * @see ProbabilityHelper#probabilityCalculator
     * @see TextFileHelper#updateLegendaryValues
     */
    private void legendaryResetAction(int index) {
        // Set the counter's value to '0'
        legendaryCounters.set(index, 0);

        // Calculate the probability
        legendaryProbabilities.set(index, ProbabilityHelper.probabilityCalculator(legendaryCounters.get(index),
                PityTimers.LEGENDARY_PITY_TIMER));

        // Update the displayed values and the save file
        String counter = Integer.toString(legendaryCounters.get(index));
        String probability = decimalFormat.format(legendaryProbabilities.get(index));
        TextFileHelper.updateLegendaryValues(expansionPanels, index, counter, probability);

        // Reset the increment field's value to '1'
        legendaryIncrementFields.get(index)
                                .setText("1");
    }

    /**
     * Action performed when a legendary add button is pressed.
     *
     * @param index is the position of an expansion in the corresponding list
     * @see ProbabilityHelper#probabilityCalculator
     * @see TextFileHelper#updateLegendaryValues
     */
    private void legendaryAddAction(int index) {
        // Value of the counter after the increment field's value is added to the current counter's value
        int newCounterValue = legendaryCounters.get(index) + Integer.parseInt(legendaryIncrementFields.get(index)
                                                                                                      .getText());

        // Check if the increment is valid and then add, otherwise "beep" and show pop-up error message
        if (newCounterValue < PityTimers.LEGENDARY_PITY_TIMER) {
            // Set the counter's value to the new value
            legendaryCounters.set(index, newCounterValue);

            // Calculate the probability
            legendaryProbabilities.set(index, ProbabilityHelper.probabilityCalculator(legendaryCounters.get(index),
                    PityTimers.LEGENDARY_PITY_TIMER));

            // Update the displayed values and the save file
            String counter = Integer.toString(legendaryCounters.get(index));
            String probability = decimalFormat.format(legendaryProbabilities.get(index));
            TextFileHelper.updateLegendaryValues(expansionPanels, index, counter, probability);
        } else {
            Toolkit.getDefaultToolkit()
                   .beep();
            JOptionPane.showMessageDialog(trackerPanel, new InputErrorPopupWindowPanel(),
                    Text.INPUT_ERROR_MESSAGE_TITLE, JOptionPane.ERROR_MESSAGE);
        }

        // Reset the increment field's value to '1'
        legendaryIncrementFields.get(index)
                                .setText("1");
    }

    /**
     * Action performed when a total modify button is pressed.
     *
     * @param index is the position of an expansion in the corresponding list
     * @see TextFileHelper#updateTotalValues
     */
    private void totalModifyAction(int index) {
        int modifyValue = -1;
        // Open modify pop-up window to modify the counter's value
        try {
            modifyValue = Integer.parseInt(JOptionPane.showInputDialog(trackerPanel, new ModifyPopupWindowPanel(),
                    totalCounters.get(index)));
        }
        // "Beep" if the value is not a number
        catch (NumberFormatException e) {
            Toolkit.getDefaultToolkit()
                   .beep();
        }

        // Check if the input is valid and then add, otherwise "beep"
        if (modifyValue >= 0) {
            totalCounters.set(index, modifyValue);
        } else {
            Toolkit.getDefaultToolkit()
                   .beep();
        }

        // Update the displayed values and the save file
        String counter = Integer.toString(totalCounters.get(index));
        TextFileHelper.updateTotalValues(expansionPanels, index, counter);

        // Reset the increment field's value to '1'
        totalIncrementFields.get(index)
                            .setText("1");
    }

    /**
     * Action performed when a total add button is pressed.
     *
     * @param index is the position of an expansion in the corresponding list
     * @see TextFileHelper#updateTotalValues
     */
    private void totalAddAction(int index) {
        // Value of the counter after the increment field's value is added to the current counter' value
        int newCounterValue = totalCounters.get(index) + Integer.parseInt(totalIncrementFields.get(index)
                                                                                              .getText());

        // Set the counter's value to the new value
        totalCounters.set(index, newCounterValue);

        // Update the displayed values and the save file
        String counter = Integer.toString(totalCounters.get(index));
        TextFileHelper.updateTotalValues(expansionPanels, index, counter);

        // Reset the increment field's value to '1'
        totalIncrementFields.get(index)
                            .setText("1");
    }
}
