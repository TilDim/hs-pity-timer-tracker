package tildim.hstools.hspitytimertracker.util;

import java.util.ArrayList;
import java.util.List;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import tildim.hstools.hspitytimertracker.gui.panel.expansion.AbstractExpansionPanel;
import tildim.hstools.hspitytimertracker.gui.panel.expansion.button.IconButton;
import tildim.hstools.hspitytimertracker.gui.panel.expansion.modifier.button.AddButton;
import tildim.hstools.hspitytimertracker.gui.panel.expansion.modifier.button.ResModButton;
import tildim.hstools.hspitytimertracker.gui.panel.expansion.modifier.textfield.IncrementField;
import tildim.hstools.hspitytimertracker.gui.panel.mode.AllModesPanel;
import tildim.hstools.hspitytimertracker.gui.panel.year.AbstractYearPanel;
import tildim.hstools.hspitytimertracker.gui.panel.yearshortcutbuttons.AllYearShortcutButtonsPanel;
import tildim.hstools.hspitytimertracker.gui.panel.yearshortcutbuttons.button.AbstractYearShortcutButton;

/**
 * {@code TrackerComponentsHelper} is a utility class that contains all the necessary methods to process the tracker
 * components used by the program, such as {@code JPanel}s, {@code JButton}s and {@code IncrementField}s.
 *
 * @author Tilemachos Dimos
 */
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class TrackerComponentsHelper {

    /**
     * Adds the instances of {@code AbstractYearShortcutButton} to a list.
     *
     * @param allYrStBnsPanel the {@code JPanel} containing the instances of {@code AbstractYearShortcutButtonsPanel}
     * @return a list of all the instances of {@code AbstractYearShortcutButton}
     */
    public static List<AbstractYearShortcutButton> getYearShortcutButtons(AllYearShortcutButtonsPanel allYrStBnsPanel) {
        List<AbstractYearShortcutButton> yearShortcutButtons = new ArrayList<>();

        yearShortcutButtons.addAll(allYrStBnsPanel.getStandardYearShortcutButtonsPanel()
                                                  .getModeYearShortcutButtons());
        yearShortcutButtons.addAll(allYrStBnsPanel.getWildYearShortcutButtonsPanel()
                                                  .getModeYearShortcutButtons());

        return yearShortcutButtons;
    }

    /**
     * Adds the instances of {@code AbstractYearPanel} to a list.
     *
     * @param allModesPanel the {@code JPanel} containing the instances of {@code AbstractModePanel}
     * @return a list of all the instances of {@code AbstractYearPanel}
     */
    public static List<AbstractYearPanel> getYearPanels(AllModesPanel allModesPanel) {
        List<AbstractYearPanel> yearPanels = new ArrayList<>();

        yearPanels.addAll(allModesPanel.getStandardModePanel()
                                       .getModeYearPanels());
        yearPanels.addAll(allModesPanel.getWildModePanel()
                                       .getModeYearPanels());

        return yearPanels;
    }

    /**
     * Adds the instances of {@code AbstractExpansionPanel} to a list.
     *
     * @param allModesPanel the {@code JPanel} containing the instances of {@code AbstractModePanel}
     * @return a list of all the instances of {@code AbstractExpansionPanel}
     */
    public static List<AbstractExpansionPanel> getExpansionPanels(AllModesPanel allModesPanel) {
        List<AbstractExpansionPanel> expansionPanels = new ArrayList<>();

        allModesPanel.getStandardModePanel()
                     .getModeYearPanels()
                     .forEach(year -> expansionPanels.addAll(year.getYearExpansionPanels()));
        allModesPanel.getWildModePanel()
                     .getModeYearPanels()
                     .forEach(year -> expansionPanels.addAll(year.getYearExpansionPanels()));
        expansionPanels.add(allModesPanel.getWildModePanel()
                                         .getClassicPanel());

        return expansionPanels;
    }

    /**
     * Adds the logo buttons to a list.
     *
     * @param expansionPanels a list of all the instances of {@code AbstractExpansionPanel}
     * @return a list of all the logo buttons
     */
    public static List<IconButton> getLogoButtons(List<AbstractExpansionPanel> expansionPanels) {
        List<IconButton> logoButtons = new ArrayList<>();

        expansionPanels.forEach(exp -> logoButtons.add(exp.getLogoButton()));

        return logoButtons;
    }

    /**
     * Adds the epic counters to a list.
     *
     * @param expansionPanels a list of all the instances of {@code AbstractExpansionPanel}
     * @return a list of all the epic counters
     */
    public static List<Integer> getEpicCounters(List<AbstractExpansionPanel> expansionPanels) {
        List<Integer> epicCounters = new ArrayList<>();

        expansionPanels.forEach(exp -> epicCounters.add(exp.getEpicCounter()));

        return epicCounters;
    }

    /**
     * Adds the epic reset buttons to a list.
     *
     * @param expansionPanels a list of all the instances of {@code AbstractExpansionPanel}
     * @return a list of all the epic reset buttons
     */
    public static List<ResModButton> getEpicResetButtons(List<AbstractExpansionPanel> expansionPanels) {
        List<ResModButton> epicResetButtons = new ArrayList<>();

        expansionPanels.forEach(exp -> epicResetButtons.add(exp.getEpicResetButton()));

        return epicResetButtons;
    }

    /**
     * Adds the epic add buttons to a list.
     *
     * @param expansionPanels a list of all the instances of {@code AbstractExpansionPanel}
     * @return a list of all the epic add buttons
     */
    public static List<AddButton> getEpicAddButtons(List<AbstractExpansionPanel> expansionPanels) {
        List<AddButton> epicAddButtons = new ArrayList<>();

        expansionPanels.forEach(exp -> epicAddButtons.add(exp.getEpicAddButton()));

        return epicAddButtons;
    }

    /**
     * Adds the epic increment fields to a list.
     *
     * @param expansionPanels a list of all the instances of {@code AbstractExpansionPanel}
     * @return a list of all the epic increment fields
     */
    public static List<IncrementField> getEpicIncrementFields(List<AbstractExpansionPanel> expansionPanels) {
        List<IncrementField> epicIncrementFields = new ArrayList<>();

        expansionPanels.forEach(exp -> epicIncrementFields.add(exp.getEpicIncrementField()));

        return epicIncrementFields;
    }

    /**
     * Adds the epic probabilities to a list.
     *
     * @param expansionPanels a list of all the instances of {@code AbstractExpansionPanel}
     * @return a list of all the epic probabilities
     */
    public static List<Double> getEpicProbabilities(List<AbstractExpansionPanel> expansionPanels) {
        List<Double> epicProbabilities = new ArrayList<>();

        expansionPanels.forEach(exp -> epicProbabilities.add(exp.getEpicProbability()));

        return epicProbabilities;
    }

    /**
     * Adds the legendary counters to a list.
     *
     * @param expansionPanels a list of all the instances of {@code AbstractExpansionPanel}
     * @return a list of all the legendary counters
     */
    public static List<Integer> getLegendaryCounters(List<AbstractExpansionPanel> expansionPanels) {
        List<Integer> legendaryCounters = new ArrayList<>();

        expansionPanels.forEach(exp -> legendaryCounters.add(exp.getLegendaryCounter()));

        return legendaryCounters;
    }

    /**
     * Adds the legendary reset buttons to a list.
     *
     * @param expansionPanels a list of all the instances of {@code AbstractExpansionPanel}
     * @return a list of all the legendary reset buttons
     */
    public static List<ResModButton> getLegendaryResetButtons(List<AbstractExpansionPanel> expansionPanels) {
        List<ResModButton> legendaryResetButtons = new ArrayList<>();

        expansionPanels.forEach(exp -> legendaryResetButtons.add(exp.getLegendaryResetButton()));

        return legendaryResetButtons;
    }

    /**
     * Adds the legendary add buttons to a list.
     *
     * @param expansionPanels a list of all the instances of {@code AbstractExpansionPanel}
     * @return a list of all the legendary add buttons
     */
    public static List<AddButton> getLegendaryAddButtons(List<AbstractExpansionPanel> expansionPanels) {
        List<AddButton> legendaryAddButtons = new ArrayList<>();

        expansionPanels.forEach(exp -> legendaryAddButtons.add(exp.getLegendaryAddButton()));

        return legendaryAddButtons;
    }

    /**
     * Adds the legendary increment fields to a list.
     *
     * @param expansionPanels a list of all the instances of {@code AbstractExpansionPanel}
     * @return a list of all the legendary increment fields
     */
    public static List<IncrementField> getLegendaryIncrementFields(List<AbstractExpansionPanel> expansionPanels) {
        List<IncrementField> legendaryIncrementFields = new ArrayList<>();

        expansionPanels.forEach(exp -> legendaryIncrementFields.add(exp.getLegendaryIncrementField()));

        return legendaryIncrementFields;
    }

    /**
     * Adds the legendary probabilities to a list.
     *
     * @param expansionPanels a list of all the instances of {@code AbstractExpansionPanel}
     * @return a list of all the legendary probabilities
     */
    public static List<Double> getLegendaryProbabilities(List<AbstractExpansionPanel> expansionPanels) {
        List<Double> legendaryProbabilities = new ArrayList<>();

        expansionPanels.forEach(exp -> legendaryProbabilities.add(exp.getLegendaryProbability()));

        return legendaryProbabilities;
    }

    /**
     * Adds the total counters to a list.
     *
     * @param expansionPanels a list of all the instances of {@code AbstractExpansionPanel}
     * @return a list of all the total counters
     */
    public static List<Integer> getTotalCounters(List<AbstractExpansionPanel> expansionPanels) {
        List<Integer> totalCounters = new ArrayList<>();

        expansionPanels.forEach(exp -> totalCounters.add(exp.getTotalCounter()));

        return totalCounters;
    }

    /**
     * Adds the total modify buttons to a list.
     *
     * @param expansionPanels a list of all the instances of {@code AbstractExpansionPanel}
     * @return a list of all the total modify buttons
     */
    public static List<ResModButton> getTotalModifyButtons(List<AbstractExpansionPanel> expansionPanels) {
        List<ResModButton> totalModifyButtons = new ArrayList<>();

        expansionPanels.forEach(exp -> totalModifyButtons.add(exp.getTotalModifyButton()));

        return totalModifyButtons;
    }

    /**
     * Adds the total add buttons to a list.
     *
     * @param expansionPanels a list of all the instances of {@code AbstractExpansionPanel}
     * @return a list of all the total add buttons
     */
    public static List<AddButton> getTotalAddButtons(List<AbstractExpansionPanel> expansionPanels) {
        List<AddButton> totalAddButtons = new ArrayList<>();

        expansionPanels.forEach(exp -> totalAddButtons.add(exp.getTotalAddButton()));

        return totalAddButtons;
    }

    /**
     * Adds the total increment fields to a list.
     *
     * @param expansionPanels a list of all the instances of {@code AbstractExpansionPanel}
     * @return a list of all the total increment fields
     */
    public static List<IncrementField> getTotalIncrementFields(List<AbstractExpansionPanel> expansionPanels) {
        List<IncrementField> totalIncrementFields = new ArrayList<>();

        expansionPanels.forEach(exp -> totalIncrementFields.add(exp.getTotalIncrementField()));

        return totalIncrementFields;
    }

    /**
     * Adds the card pack buttons to a list.
     *
     * @param expansionPanels a list of all the instances of {@code AbstractExpansionPanel}
     * @return a list of all the card pack buttons
     */
    public static List<IconButton> getCardPackButtons(List<AbstractExpansionPanel> expansionPanels) {
        List<IconButton> cardPackButtons = new ArrayList<>();

        expansionPanels.forEach(exp -> cardPackButtons.add(exp.getCardPackButton()));

        return cardPackButtons;
    }

}
