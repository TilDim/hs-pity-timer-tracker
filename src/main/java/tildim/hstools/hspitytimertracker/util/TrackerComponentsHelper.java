package tildim.hstools.hspitytimertracker.util;

import tildim.hstools.hspitytimertracker.gui.panel.expansion.AbstractExpansionPanel;
import tildim.hstools.hspitytimertracker.gui.panel.expansion.button.IconButton;
import tildim.hstools.hspitytimertracker.gui.panel.expansion.modifier.button.AddButton;
import tildim.hstools.hspitytimertracker.gui.panel.expansion.modifier.button.ResModButton;
import tildim.hstools.hspitytimertracker.gui.panel.expansion.modifier.textfield.IncrementField;
import tildim.hstools.hspitytimertracker.gui.panel.tracker.TrackerPanel;
import tildim.hstools.hspitytimertracker.gui.panel.year.AbstractYearPanel;
import tildim.hstools.hspitytimertracker.gui.panel.yearshortcutbuttons.button.AbstractYearShortcutButton;

import java.util.ArrayList;
import java.util.List;

/**
 *
 */
public class TrackerComponentsHelper {

    /**
     * Year shortcut buttons
     *
     * @param trackerPanel is the panel containing the year shortcut buttons
     * @return a list of all the year shortcut buttons in the panel
     */
    public static List<AbstractYearShortcutButton> getYearShortcutButtons(TrackerPanel trackerPanel) {
        List<AbstractYearShortcutButton> yearShortcutButtons = new ArrayList<>();

        yearShortcutButtons.add(trackerPanel.getWildYearShortcutButtonsPanel()
                                            .getYears1And2ShortcutButton());
        yearShortcutButtons.add(trackerPanel.getWildYearShortcutButtonsPanel()
                                            .getYearOfTheKrakenShortcutButton());
        yearShortcutButtons.add(trackerPanel.getWildYearShortcutButtonsPanel()
                                            .getYearOfTheMammothShortcutButton());
        yearShortcutButtons.add(trackerPanel.getWildYearShortcutButtonsPanel()
                                            .getYearOfTheRavenShortcutButton());
        yearShortcutButtons.add(trackerPanel.getWildYearShortcutButtonsPanel()
                                            .getYearOfTheDragonShortcutButton());
        yearShortcutButtons.add(trackerPanel.getWildYearShortcutButtonsPanel()
                                            .getYearOfThePhoenixShortcutButton());
        yearShortcutButtons.add(trackerPanel.getStandardYearShortcutButtonsPanel()
                                            .getYearOfTheGryphonShortcutButton());
        yearShortcutButtons.add(trackerPanel.getStandardYearShortcutButtonsPanel()
                                            .getYearOfTheHydraShortcutButton());

        return yearShortcutButtons;
    }

    /**
     * Year panels
     *
     * @param trackerPanel is the panel containing the year panels
     * @return a list of all the year panels in the panel
     */
    public static List<AbstractYearPanel> getYearPanels(TrackerPanel trackerPanel) {
        List<AbstractYearPanel> yearPanels = new ArrayList<>();

        yearPanels.add(trackerPanel.getWildModePanel()
                                   .getYears1And2Panel());
        yearPanels.add(trackerPanel.getWildModePanel()
                                   .getYearOfTheKrakenPanel());
        yearPanels.add(trackerPanel.getWildModePanel()
                                   .getYearOfTheMammothPanel());
        yearPanels.add(trackerPanel.getWildModePanel()
                                   .getYearOfTheRavenPanel());
        yearPanels.add(trackerPanel.getWildModePanel()
                                   .getYearOfTheDragonPanel());
        yearPanels.add(trackerPanel.getWildModePanel()
                                   .getYearOfThePhoenixPanel());
        yearPanels.add(trackerPanel.getStandardModePanel()
                                   .getYearOfTheGryphonPanel());
        yearPanels.add(trackerPanel.getStandardModePanel()
                                   .getYearOfTheHydraPanel());

        return yearPanels;
    }

    /**
     * Expansion panels
     *
     * @param trackerPanel is the panel containing the expansion panels
     */
    public static List<AbstractExpansionPanel> getExpansionPanels(TrackerPanel trackerPanel) {
        List<AbstractExpansionPanel> expansionPanels = new ArrayList<>();

        expansionPanels.add(trackerPanel.getWildModePanel()
                                        .getClassicPanel());
        expansionPanels.add(trackerPanel.getWildModePanel()
                                        .getYears1And2Panel()
                                        .getGoblinsVsGnomesPanel());
        expansionPanels.add(trackerPanel.getWildModePanel()
                                        .getYears1And2Panel()
                                        .getTheGrandTournamentPanel());
        expansionPanels.add(trackerPanel.getWildModePanel()
                                        .getYearOfTheKrakenPanel()
                                        .getWhispersOfTheOldGodsPanel());
        expansionPanels.add(trackerPanel.getWildModePanel()
                                        .getYearOfTheKrakenPanel()
                                        .getMeanStreetsOfGadgetzanPanel());
        expansionPanels.add(trackerPanel.getWildModePanel()
                                        .getYearOfTheMammothPanel()
                                        .getJourneyToUnGoroPanel());
        expansionPanels.add(trackerPanel.getWildModePanel()
                                        .getYearOfTheMammothPanel()
                                        .getKnightsOfTheFrozenThronePanel());
        expansionPanels.add(trackerPanel.getWildModePanel()
                                        .getYearOfTheMammothPanel()
                                        .getKoboldsAndCatacombsPanel());
        expansionPanels.add(trackerPanel.getWildModePanel()
                                        .getYearOfTheRavenPanel()
                                        .getTheWitchwoodPanel());
        expansionPanels.add(trackerPanel.getWildModePanel()
                                        .getYearOfTheRavenPanel()
                                        .getTheBoomsdayProjectPanel());
        expansionPanels.add(trackerPanel.getWildModePanel()
                                        .getYearOfTheRavenPanel()
                                        .getRastakhansRumblePanel());
        expansionPanels.add(trackerPanel.getWildModePanel()
                                        .getYearOfTheDragonPanel()
                                        .getRiseOfShadowsPanel());
        expansionPanels.add(trackerPanel.getWildModePanel()
                                        .getYearOfTheDragonPanel()
                                        .getSaviorsOfUldumPanel());
        expansionPanels.add(trackerPanel.getWildModePanel()
                                        .getYearOfTheDragonPanel()
                                        .getDescentOfDragonsPanel());
        expansionPanels.add(trackerPanel.getWildModePanel()
                                        .getYearOfThePhoenixPanel()
                                        .getAshesOfOutlandPanel());
        expansionPanels.add(trackerPanel.getWildModePanel()
                                        .getYearOfThePhoenixPanel()
                                        .getScholomanceAcademyPanel());
        expansionPanels.add(trackerPanel.getWildModePanel()
                                        .getYearOfThePhoenixPanel()
                                        .getMadnessAtTheDarkmoonFairePanel());
        expansionPanels.add(trackerPanel.getStandardModePanel()
                                        .getYearOfTheGryphonPanel()
                                        .getForgedInTheBarrensPanel());
        expansionPanels.add(trackerPanel.getStandardModePanel()
                                        .getYearOfTheGryphonPanel()
                                        .getUnitedInStormwindPanel());
        expansionPanels.add(trackerPanel.getStandardModePanel()
                                        .getYearOfTheGryphonPanel()
                                        .getFracturedInAlteracValleyPanel());
        expansionPanels.add(trackerPanel.getStandardModePanel()
                                        .getYearOfTheHydraPanel()
                                        .getVoyageToTheSunkenCityPanel());

        return expansionPanels;
    }

    /**
     * Expansion buttons
     *
     * @param expansionPanels is a list containing all the expansion panels
     * @return a list of all the expansion buttons in the panel
     */
    public static List<IconButton> getExpansionButtons(List<AbstractExpansionPanel> expansionPanels) {
        List<IconButton> expansionButtons = new ArrayList<>();

        expansionButtons.add(expansionPanels.get(Indexes.CLASSIC_INDEX)
                                            .getExpansionButton());
        expansionButtons.add(expansionPanels.get(Indexes.GOBLINS_INDEX)
                                            .getExpansionButton());
        expansionButtons.add(expansionPanels.get(Indexes.TOURNAMENT_INDEX)
                                            .getExpansionButton());
        expansionButtons.add(expansionPanels.get(Indexes.OLDGODS_INDEX)
                                            .getExpansionButton());
        expansionButtons.add(expansionPanels.get(Indexes.GADGETZAN_INDEX)
                                            .getExpansionButton());
        expansionButtons.add(expansionPanels.get(Indexes.UNGORO_INDEX)
                                            .getExpansionButton());
        expansionButtons.add(expansionPanels.get(Indexes.KNIGHTS_INDEX)
                                            .getExpansionButton());
        expansionButtons.add(expansionPanels.get(Indexes.KOBOLDS_INDEX)
                                            .getExpansionButton());
        expansionButtons.add(expansionPanels.get(Indexes.WITCHWOOD_INDEX)
                                            .getExpansionButton());
        expansionButtons.add(expansionPanels.get(Indexes.BOOMSDAY_INDEX)
                                            .getExpansionButton());
        expansionButtons.add(expansionPanels.get(Indexes.RUMBLE_INDEX)
                                            .getExpansionButton());
        expansionButtons.add(expansionPanels.get(Indexes.SHADOWS_INDEX)
                                            .getExpansionButton());
        expansionButtons.add(expansionPanels.get(Indexes.ULDUM_INDEX)
                                            .getExpansionButton());
        expansionButtons.add(expansionPanels.get(Indexes.DRAGONS_INDEX)
                                            .getExpansionButton());
        expansionButtons.add(expansionPanels.get(Indexes.OUTLAND_INDEX)
                                            .getExpansionButton());
        expansionButtons.add(expansionPanels.get(Indexes.SCHOLOMANCE_INDEX)
                                            .getExpansionButton());
        expansionButtons.add(expansionPanels.get(Indexes.DARKMOON_INDEX)
                                            .getExpansionButton());
        expansionButtons.add(expansionPanels.get(Indexes.BARRENS_INDEX)
                                            .getExpansionButton());
        expansionButtons.add(expansionPanels.get(Indexes.STORMWIND_INDEX)
                                            .getExpansionButton());
        expansionButtons.add(expansionPanels.get(Indexes.ALTERAC_INDEX)
                                            .getExpansionButton());
        expansionButtons.add(expansionPanels.get(Indexes.SUNKEN_INDEX)
                                            .getExpansionButton());

        return expansionButtons;
    }

    /**
     * Epic counters
     *
     * @param expansionPanels is a list containing all the expansion panels
     * @return a list of all the epic counters in the panel
     */
    public static List<Integer> getEpicCounters(List<AbstractExpansionPanel> expansionPanels) {
        List<Integer> epicCounters = new ArrayList<>();

        epicCounters.add(expansionPanels.get(Indexes.CLASSIC_INDEX)
                                        .getEpicCounter());
        epicCounters.add(expansionPanels.get(Indexes.GOBLINS_INDEX)
                                        .getEpicCounter());
        epicCounters.add(expansionPanels.get(Indexes.TOURNAMENT_INDEX)
                                        .getEpicCounter());
        epicCounters.add(expansionPanels.get(Indexes.OLDGODS_INDEX)
                                        .getEpicCounter());
        epicCounters.add(expansionPanels.get(Indexes.GADGETZAN_INDEX)
                                        .getEpicCounter());
        epicCounters.add(expansionPanels.get(Indexes.UNGORO_INDEX)
                                        .getEpicCounter());
        epicCounters.add(expansionPanels.get(Indexes.KNIGHTS_INDEX)
                                        .getEpicCounter());
        epicCounters.add(expansionPanels.get(Indexes.KOBOLDS_INDEX)
                                        .getEpicCounter());
        epicCounters.add(expansionPanels.get(Indexes.WITCHWOOD_INDEX)
                                        .getEpicCounter());
        epicCounters.add(expansionPanels.get(Indexes.BOOMSDAY_INDEX)
                                        .getEpicCounter());
        epicCounters.add(expansionPanels.get(Indexes.RUMBLE_INDEX)
                                        .getEpicCounter());
        epicCounters.add(expansionPanels.get(Indexes.SHADOWS_INDEX)
                                        .getEpicCounter());
        epicCounters.add(expansionPanels.get(Indexes.ULDUM_INDEX)
                                        .getEpicCounter());
        epicCounters.add(expansionPanels.get(Indexes.DRAGONS_INDEX)
                                        .getEpicCounter());
        epicCounters.add(expansionPanels.get(Indexes.OUTLAND_INDEX)
                                        .getEpicCounter());
        epicCounters.add(expansionPanels.get(Indexes.SCHOLOMANCE_INDEX)
                                        .getEpicCounter());
        epicCounters.add(expansionPanels.get(Indexes.DARKMOON_INDEX)
                                        .getEpicCounter());
        epicCounters.add(expansionPanels.get(Indexes.BARRENS_INDEX)
                                        .getEpicCounter());
        epicCounters.add(expansionPanels.get(Indexes.STORMWIND_INDEX)
                                        .getEpicCounter());
        epicCounters.add(expansionPanels.get(Indexes.ALTERAC_INDEX)
                                        .getEpicCounter());
        epicCounters.add(expansionPanels.get(Indexes.SUNKEN_INDEX)
                                        .getEpicCounter());

        return epicCounters;
    }

    /**
     * Epic reset buttons
     *
     * @param expansionPanels is a list containing all the expansion panels
     * @return a list of all the epic reset buttons in the panel
     */
    public static List<ResModButton> getEpicResetButtons(List<AbstractExpansionPanel> expansionPanels) {
        List<ResModButton> epicResetButtons = new ArrayList<>();

        epicResetButtons.add(expansionPanels.get(Indexes.CLASSIC_INDEX)
                                            .getEpicResetButton());
        epicResetButtons.add(expansionPanels.get(Indexes.GOBLINS_INDEX)
                                            .getEpicResetButton());
        epicResetButtons.add(expansionPanels.get(Indexes.TOURNAMENT_INDEX)
                                            .getEpicResetButton());
        epicResetButtons.add(expansionPanels.get(Indexes.OLDGODS_INDEX)
                                            .getEpicResetButton());
        epicResetButtons.add(expansionPanels.get(Indexes.GADGETZAN_INDEX)
                                            .getEpicResetButton());
        epicResetButtons.add(expansionPanels.get(Indexes.UNGORO_INDEX)
                                            .getEpicResetButton());
        epicResetButtons.add(expansionPanels.get(Indexes.KNIGHTS_INDEX)
                                            .getEpicResetButton());
        epicResetButtons.add(expansionPanels.get(Indexes.KOBOLDS_INDEX)
                                            .getEpicResetButton());
        epicResetButtons.add(expansionPanels.get(Indexes.WITCHWOOD_INDEX)
                                            .getEpicResetButton());
        epicResetButtons.add(expansionPanels.get(Indexes.BOOMSDAY_INDEX)
                                            .getEpicResetButton());
        epicResetButtons.add(expansionPanels.get(Indexes.RUMBLE_INDEX)
                                            .getEpicResetButton());
        epicResetButtons.add(expansionPanels.get(Indexes.SHADOWS_INDEX)
                                            .getEpicResetButton());
        epicResetButtons.add(expansionPanels.get(Indexes.ULDUM_INDEX)
                                            .getEpicResetButton());
        epicResetButtons.add(expansionPanels.get(Indexes.DRAGONS_INDEX)
                                            .getEpicResetButton());
        epicResetButtons.add(expansionPanels.get(Indexes.OUTLAND_INDEX)
                                            .getEpicResetButton());
        epicResetButtons.add(expansionPanels.get(Indexes.SCHOLOMANCE_INDEX)
                                            .getEpicResetButton());
        epicResetButtons.add(expansionPanels.get(Indexes.DARKMOON_INDEX)
                                            .getEpicResetButton());
        epicResetButtons.add(expansionPanels.get(Indexes.BARRENS_INDEX)
                                            .getEpicResetButton());
        epicResetButtons.add(expansionPanels.get(Indexes.STORMWIND_INDEX)
                                            .getEpicResetButton());
        epicResetButtons.add(expansionPanels.get(Indexes.ALTERAC_INDEX)
                                            .getEpicResetButton());
        epicResetButtons.add(expansionPanels.get(Indexes.SUNKEN_INDEX)
                                            .getEpicResetButton());

        return epicResetButtons;
    }

    /**
     * Epic add buttons
     *
     * @param expansionPanels is a list containing all the expansion panels
     * @return a list of all the epic add buttons in the panel
     */
    public static List<AddButton> getEpicAddButtons(List<AbstractExpansionPanel> expansionPanels) {
        List<AddButton> epicAddButtons = new ArrayList<>();

        epicAddButtons.add(expansionPanels.get(Indexes.CLASSIC_INDEX)
                                          .getEpicAddButton());
        epicAddButtons.add(expansionPanels.get(Indexes.GOBLINS_INDEX)
                                          .getEpicAddButton());
        epicAddButtons.add(expansionPanels.get(Indexes.TOURNAMENT_INDEX)
                                          .getEpicAddButton());
        epicAddButtons.add(expansionPanels.get(Indexes.OLDGODS_INDEX)
                                          .getEpicAddButton());
        epicAddButtons.add(expansionPanels.get(Indexes.GADGETZAN_INDEX)
                                          .getEpicAddButton());
        epicAddButtons.add(expansionPanels.get(Indexes.UNGORO_INDEX)
                                          .getEpicAddButton());
        epicAddButtons.add(expansionPanels.get(Indexes.KNIGHTS_INDEX)
                                          .getEpicAddButton());
        epicAddButtons.add(expansionPanels.get(Indexes.KOBOLDS_INDEX)
                                          .getEpicAddButton());
        epicAddButtons.add(expansionPanels.get(Indexes.WITCHWOOD_INDEX)
                                          .getEpicAddButton());
        epicAddButtons.add(expansionPanels.get(Indexes.BOOMSDAY_INDEX)
                                          .getEpicAddButton());
        epicAddButtons.add(expansionPanels.get(Indexes.RUMBLE_INDEX)
                                          .getEpicAddButton());
        epicAddButtons.add(expansionPanels.get(Indexes.SHADOWS_INDEX)
                                          .getEpicAddButton());
        epicAddButtons.add(expansionPanels.get(Indexes.ULDUM_INDEX)
                                          .getEpicAddButton());
        epicAddButtons.add(expansionPanels.get(Indexes.DRAGONS_INDEX)
                                          .getEpicAddButton());
        epicAddButtons.add(expansionPanels.get(Indexes.OUTLAND_INDEX)
                                          .getEpicAddButton());
        epicAddButtons.add(expansionPanels.get(Indexes.SCHOLOMANCE_INDEX)
                                          .getEpicAddButton());
        epicAddButtons.add(expansionPanels.get(Indexes.DARKMOON_INDEX)
                                          .getEpicAddButton());
        epicAddButtons.add(expansionPanels.get(Indexes.BARRENS_INDEX)
                                          .getEpicAddButton());
        epicAddButtons.add(expansionPanels.get(Indexes.STORMWIND_INDEX)
                                          .getEpicAddButton());
        epicAddButtons.add(expansionPanels.get(Indexes.ALTERAC_INDEX)
                                          .getEpicAddButton());
        epicAddButtons.add(expansionPanels.get(Indexes.SUNKEN_INDEX)
                                          .getEpicAddButton());

        return epicAddButtons;
    }

    /**
     * Epic increment fields
     *
     * @param expansionPanels is a list containing all the expansion panels
     * @return a list of all the epic increment fields in the panel
     */
    public static List<IncrementField> getEpicIncrementFields(List<AbstractExpansionPanel> expansionPanels) {
        List<IncrementField> epicIncrementFields = new ArrayList<>();

        epicIncrementFields.add(expansionPanels.get(Indexes.CLASSIC_INDEX)
                                               .getEpicIncrementField());
        epicIncrementFields.add(expansionPanels.get(Indexes.GOBLINS_INDEX)
                                               .getEpicIncrementField());
        epicIncrementFields.add(expansionPanels.get(Indexes.TOURNAMENT_INDEX)
                                               .getEpicIncrementField());
        epicIncrementFields.add(expansionPanels.get(Indexes.OLDGODS_INDEX)
                                               .getEpicIncrementField());
        epicIncrementFields.add(expansionPanels.get(Indexes.GADGETZAN_INDEX)
                                               .getEpicIncrementField());
        epicIncrementFields.add(expansionPanels.get(Indexes.UNGORO_INDEX)
                                               .getEpicIncrementField());
        epicIncrementFields.add(expansionPanels.get(Indexes.KNIGHTS_INDEX)
                                               .getEpicIncrementField());
        epicIncrementFields.add(expansionPanels.get(Indexes.KOBOLDS_INDEX)
                                               .getEpicIncrementField());
        epicIncrementFields.add(expansionPanels.get(Indexes.WITCHWOOD_INDEX)
                                               .getEpicIncrementField());
        epicIncrementFields.add(expansionPanels.get(Indexes.BOOMSDAY_INDEX)
                                               .getEpicIncrementField());
        epicIncrementFields.add(expansionPanels.get(Indexes.RUMBLE_INDEX)
                                               .getEpicIncrementField());
        epicIncrementFields.add(expansionPanels.get(Indexes.SHADOWS_INDEX)
                                               .getEpicIncrementField());
        epicIncrementFields.add(expansionPanels.get(Indexes.ULDUM_INDEX)
                                               .getEpicIncrementField());
        epicIncrementFields.add(expansionPanels.get(Indexes.DRAGONS_INDEX)
                                               .getEpicIncrementField());
        epicIncrementFields.add(expansionPanels.get(Indexes.OUTLAND_INDEX)
                                               .getEpicIncrementField());
        epicIncrementFields.add(expansionPanels.get(Indexes.SCHOLOMANCE_INDEX)
                                               .getEpicIncrementField());
        epicIncrementFields.add(expansionPanels.get(Indexes.DARKMOON_INDEX)
                                               .getEpicIncrementField());
        epicIncrementFields.add(expansionPanels.get(Indexes.BARRENS_INDEX)
                                               .getEpicIncrementField());
        epicIncrementFields.add(expansionPanels.get(Indexes.STORMWIND_INDEX)
                                               .getEpicIncrementField());
        epicIncrementFields.add(expansionPanels.get(Indexes.ALTERAC_INDEX)
                                               .getEpicIncrementField());
        epicIncrementFields.add(expansionPanels.get(Indexes.SUNKEN_INDEX)
                                               .getEpicIncrementField());

        return epicIncrementFields;
    }

    /**
     * Epic probabilities
     *
     * @param expansionPanels is a list containing all the expansion panels
     * @return a list of all the epic probabilities in the panel
     */
    public static List<Double> getEpicProbabilities(List<AbstractExpansionPanel> expansionPanels) {
        List<Double> epicProbabilities = new ArrayList<>();

        epicProbabilities.add(expansionPanels.get(Indexes.CLASSIC_INDEX)
                                             .getEpicProbability());
        epicProbabilities.add(expansionPanels.get(Indexes.GOBLINS_INDEX)
                                             .getEpicProbability());
        epicProbabilities.add(expansionPanels.get(Indexes.TOURNAMENT_INDEX)
                                             .getEpicProbability());
        epicProbabilities.add(expansionPanels.get(Indexes.OLDGODS_INDEX)
                                             .getEpicProbability());
        epicProbabilities.add(expansionPanels.get(Indexes.GADGETZAN_INDEX)
                                             .getEpicProbability());
        epicProbabilities.add(expansionPanels.get(Indexes.UNGORO_INDEX)
                                             .getEpicProbability());
        epicProbabilities.add(expansionPanels.get(Indexes.KNIGHTS_INDEX)
                                             .getEpicProbability());
        epicProbabilities.add(expansionPanels.get(Indexes.KOBOLDS_INDEX)
                                             .getEpicProbability());
        epicProbabilities.add(expansionPanels.get(Indexes.WITCHWOOD_INDEX)
                                             .getEpicProbability());
        epicProbabilities.add(expansionPanels.get(Indexes.BOOMSDAY_INDEX)
                                             .getEpicProbability());
        epicProbabilities.add(expansionPanels.get(Indexes.RUMBLE_INDEX)
                                             .getEpicProbability());
        epicProbabilities.add(expansionPanels.get(Indexes.SHADOWS_INDEX)
                                             .getEpicProbability());
        epicProbabilities.add(expansionPanels.get(Indexes.ULDUM_INDEX)
                                             .getEpicProbability());
        epicProbabilities.add(expansionPanels.get(Indexes.DRAGONS_INDEX)
                                             .getEpicProbability());
        epicProbabilities.add(expansionPanels.get(Indexes.OUTLAND_INDEX)
                                             .getEpicProbability());
        epicProbabilities.add(expansionPanels.get(Indexes.SCHOLOMANCE_INDEX)
                                             .getEpicProbability());
        epicProbabilities.add(expansionPanels.get(Indexes.DARKMOON_INDEX)
                                             .getEpicProbability());
        epicProbabilities.add(expansionPanels.get(Indexes.BARRENS_INDEX)
                                             .getEpicProbability());
        epicProbabilities.add(expansionPanels.get(Indexes.STORMWIND_INDEX)
                                             .getEpicProbability());
        epicProbabilities.add(expansionPanels.get(Indexes.ALTERAC_INDEX)
                                             .getEpicProbability());
        epicProbabilities.add(expansionPanels.get(Indexes.SUNKEN_INDEX)
                                             .getEpicProbability());

        return epicProbabilities;
    }

    /**
     * Legendary counters
     *
     * @param expansionPanels is a list containing all the expansion panels
     * @return a list of all the legendary counters in the panel
     */
    public static List<Integer> getLegendaryCounters(List<AbstractExpansionPanel> expansionPanels) {
        List<Integer> legendaryCounters = new ArrayList<>();

        legendaryCounters.add(expansionPanels.get(Indexes.CLASSIC_INDEX)
                                             .getLegendaryCounter());
        legendaryCounters.add(expansionPanels.get(Indexes.GOBLINS_INDEX)
                                             .getLegendaryCounter());
        legendaryCounters.add(expansionPanels.get(Indexes.TOURNAMENT_INDEX)
                                             .getLegendaryCounter());
        legendaryCounters.add(expansionPanels.get(Indexes.OLDGODS_INDEX)
                                             .getLegendaryCounter());
        legendaryCounters.add(expansionPanels.get(Indexes.GADGETZAN_INDEX)
                                             .getLegendaryCounter());
        legendaryCounters.add(expansionPanels.get(Indexes.UNGORO_INDEX)
                                             .getLegendaryCounter());
        legendaryCounters.add(expansionPanels.get(Indexes.KNIGHTS_INDEX)
                                             .getLegendaryCounter());
        legendaryCounters.add(expansionPanels.get(Indexes.KOBOLDS_INDEX)
                                             .getLegendaryCounter());
        legendaryCounters.add(expansionPanels.get(Indexes.WITCHWOOD_INDEX)
                                             .getLegendaryCounter());
        legendaryCounters.add(expansionPanels.get(Indexes.BOOMSDAY_INDEX)
                                             .getLegendaryCounter());
        legendaryCounters.add(expansionPanels.get(Indexes.RUMBLE_INDEX)
                                             .getLegendaryCounter());
        legendaryCounters.add(expansionPanels.get(Indexes.SHADOWS_INDEX)
                                             .getLegendaryCounter());
        legendaryCounters.add(expansionPanels.get(Indexes.ULDUM_INDEX)
                                             .getLegendaryCounter());
        legendaryCounters.add(expansionPanels.get(Indexes.DRAGONS_INDEX)
                                             .getLegendaryCounter());
        legendaryCounters.add(expansionPanels.get(Indexes.OUTLAND_INDEX)
                                             .getLegendaryCounter());
        legendaryCounters.add(expansionPanels.get(Indexes.SCHOLOMANCE_INDEX)
                                             .getLegendaryCounter());
        legendaryCounters.add(expansionPanels.get(Indexes.DARKMOON_INDEX)
                                             .getLegendaryCounter());
        legendaryCounters.add(expansionPanels.get(Indexes.BARRENS_INDEX)
                                             .getLegendaryCounter());
        legendaryCounters.add(expansionPanels.get(Indexes.STORMWIND_INDEX)
                                             .getLegendaryCounter());
        legendaryCounters.add(expansionPanels.get(Indexes.ALTERAC_INDEX)
                                             .getLegendaryCounter());
        legendaryCounters.add(expansionPanels.get(Indexes.SUNKEN_INDEX)
                                             .getLegendaryCounter());

        return legendaryCounters;
    }

    /**
     * Legendary reset buttons
     *
     * @param expansionPanels is a list containing all the expansion panels
     * @return a list of all the legendary reset buttons in the panel
     */
    public static List<ResModButton> getLegendaryResetButtons(List<AbstractExpansionPanel> expansionPanels) {
        List<ResModButton> legendaryResetButtons = new ArrayList<>();

        legendaryResetButtons.add(expansionPanels.get(Indexes.CLASSIC_INDEX)
                                                 .getLegendaryResetButton());
        legendaryResetButtons.add(expansionPanels.get(Indexes.GOBLINS_INDEX)
                                                 .getLegendaryResetButton());
        legendaryResetButtons.add(expansionPanels.get(Indexes.TOURNAMENT_INDEX)
                                                 .getLegendaryResetButton());
        legendaryResetButtons.add(expansionPanels.get(Indexes.OLDGODS_INDEX)
                                                 .getLegendaryResetButton());
        legendaryResetButtons.add(expansionPanels.get(Indexes.GADGETZAN_INDEX)
                                                 .getLegendaryResetButton());
        legendaryResetButtons.add(expansionPanels.get(Indexes.UNGORO_INDEX)
                                                 .getLegendaryResetButton());
        legendaryResetButtons.add(expansionPanels.get(Indexes.KNIGHTS_INDEX)
                                                 .getLegendaryResetButton());
        legendaryResetButtons.add(expansionPanels.get(Indexes.KOBOLDS_INDEX)
                                                 .getLegendaryResetButton());
        legendaryResetButtons.add(expansionPanels.get(Indexes.WITCHWOOD_INDEX)
                                                 .getLegendaryResetButton());
        legendaryResetButtons.add(expansionPanels.get(Indexes.BOOMSDAY_INDEX)
                                                 .getLegendaryResetButton());
        legendaryResetButtons.add(expansionPanels.get(Indexes.RUMBLE_INDEX)
                                                 .getLegendaryResetButton());
        legendaryResetButtons.add(expansionPanels.get(Indexes.SHADOWS_INDEX)
                                                 .getLegendaryResetButton());
        legendaryResetButtons.add(expansionPanels.get(Indexes.ULDUM_INDEX)
                                                 .getLegendaryResetButton());
        legendaryResetButtons.add(expansionPanels.get(Indexes.DRAGONS_INDEX)
                                                 .getLegendaryResetButton());
        legendaryResetButtons.add(expansionPanels.get(Indexes.OUTLAND_INDEX)
                                                 .getLegendaryResetButton());
        legendaryResetButtons.add(expansionPanels.get(Indexes.SCHOLOMANCE_INDEX)
                                                 .getLegendaryResetButton());
        legendaryResetButtons.add(expansionPanels.get(Indexes.DARKMOON_INDEX)
                                                 .getLegendaryResetButton());
        legendaryResetButtons.add(expansionPanels.get(Indexes.BARRENS_INDEX)
                                                 .getLegendaryResetButton());
        legendaryResetButtons.add(expansionPanels.get(Indexes.STORMWIND_INDEX)
                                                 .getLegendaryResetButton());
        legendaryResetButtons.add(expansionPanels.get(Indexes.ALTERAC_INDEX)
                                                 .getLegendaryResetButton());
        legendaryResetButtons.add(expansionPanels.get(Indexes.SUNKEN_INDEX)
                                                 .getLegendaryResetButton());

        return legendaryResetButtons;
    }

    /**
     * Legendary add buttons
     *
     * @param expansionPanels is a list containing all the expansion panels
     * @return a list of all the legendary add buttons in the panel
     */
    public static List<AddButton> getLegendaryAddButtons(List<AbstractExpansionPanel> expansionPanels) {
        List<AddButton> legendaryAddButtons = new ArrayList<>();

        legendaryAddButtons.add(expansionPanels.get(Indexes.CLASSIC_INDEX)
                                               .getLegendaryAddButton());
        legendaryAddButtons.add(expansionPanels.get(Indexes.GOBLINS_INDEX)
                                               .getLegendaryAddButton());
        legendaryAddButtons.add(expansionPanels.get(Indexes.TOURNAMENT_INDEX)
                                               .getLegendaryAddButton());
        legendaryAddButtons.add(expansionPanels.get(Indexes.OLDGODS_INDEX)
                                               .getLegendaryAddButton());
        legendaryAddButtons.add(expansionPanels.get(Indexes.GADGETZAN_INDEX)
                                               .getLegendaryAddButton());
        legendaryAddButtons.add(expansionPanels.get(Indexes.UNGORO_INDEX)
                                               .getLegendaryAddButton());
        legendaryAddButtons.add(expansionPanels.get(Indexes.KNIGHTS_INDEX)
                                               .getLegendaryAddButton());
        legendaryAddButtons.add(expansionPanels.get(Indexes.KOBOLDS_INDEX)
                                               .getLegendaryAddButton());
        legendaryAddButtons.add(expansionPanels.get(Indexes.WITCHWOOD_INDEX)
                                               .getLegendaryAddButton());
        legendaryAddButtons.add(expansionPanels.get(Indexes.BOOMSDAY_INDEX)
                                               .getLegendaryAddButton());
        legendaryAddButtons.add(expansionPanels.get(Indexes.RUMBLE_INDEX)
                                               .getLegendaryAddButton());
        legendaryAddButtons.add(expansionPanels.get(Indexes.SHADOWS_INDEX)
                                               .getLegendaryAddButton());
        legendaryAddButtons.add(expansionPanels.get(Indexes.ULDUM_INDEX)
                                               .getLegendaryAddButton());
        legendaryAddButtons.add(expansionPanels.get(Indexes.DRAGONS_INDEX)
                                               .getLegendaryAddButton());
        legendaryAddButtons.add(expansionPanels.get(Indexes.OUTLAND_INDEX)
                                               .getLegendaryAddButton());
        legendaryAddButtons.add(expansionPanels.get(Indexes.SCHOLOMANCE_INDEX)
                                               .getLegendaryAddButton());
        legendaryAddButtons.add(expansionPanels.get(Indexes.DARKMOON_INDEX)
                                               .getLegendaryAddButton());
        legendaryAddButtons.add(expansionPanels.get(Indexes.BARRENS_INDEX)
                                               .getLegendaryAddButton());
        legendaryAddButtons.add(expansionPanels.get(Indexes.STORMWIND_INDEX)
                                               .getLegendaryAddButton());
        legendaryAddButtons.add(expansionPanels.get(Indexes.ALTERAC_INDEX)
                                               .getLegendaryAddButton());
        legendaryAddButtons.add(expansionPanels.get(Indexes.SUNKEN_INDEX)
                                               .getLegendaryAddButton());

        return legendaryAddButtons;
    }

    /**
     * Legendary increment fields
     *
     * @param expansionPanels is a list containing all the expansion panels
     * @return a list of all the legendary increment fields in the panel
     */
    public static List<IncrementField> getLegendaryIncrementFields(List<AbstractExpansionPanel> expansionPanels) {
        List<IncrementField> legendaryIncrementFields = new ArrayList<>();

        legendaryIncrementFields.add(expansionPanels.get(Indexes.CLASSIC_INDEX)
                                                    .getLegendaryIncrementField());
        legendaryIncrementFields.add(expansionPanels.get(Indexes.GOBLINS_INDEX)
                                                    .getLegendaryIncrementField());
        legendaryIncrementFields.add(expansionPanels.get(Indexes.TOURNAMENT_INDEX)
                                                    .getLegendaryIncrementField());
        legendaryIncrementFields.add(expansionPanels.get(Indexes.OLDGODS_INDEX)
                                                    .getLegendaryIncrementField());
        legendaryIncrementFields.add(expansionPanels.get(Indexes.GADGETZAN_INDEX)
                                                    .getLegendaryIncrementField());
        legendaryIncrementFields.add(expansionPanels.get(Indexes.UNGORO_INDEX)
                                                    .getLegendaryIncrementField());
        legendaryIncrementFields.add(expansionPanels.get(Indexes.KNIGHTS_INDEX)
                                                    .getLegendaryIncrementField());
        legendaryIncrementFields.add(expansionPanels.get(Indexes.KOBOLDS_INDEX)
                                                    .getLegendaryIncrementField());
        legendaryIncrementFields.add(expansionPanels.get(Indexes.WITCHWOOD_INDEX)
                                                    .getLegendaryIncrementField());
        legendaryIncrementFields.add(expansionPanels.get(Indexes.BOOMSDAY_INDEX)
                                                    .getLegendaryIncrementField());
        legendaryIncrementFields.add(expansionPanels.get(Indexes.RUMBLE_INDEX)
                                                    .getLegendaryIncrementField());
        legendaryIncrementFields.add(expansionPanels.get(Indexes.SHADOWS_INDEX)
                                                    .getLegendaryIncrementField());
        legendaryIncrementFields.add(expansionPanels.get(Indexes.ULDUM_INDEX)
                                                    .getLegendaryIncrementField());
        legendaryIncrementFields.add(expansionPanels.get(Indexes.DRAGONS_INDEX)
                                                    .getLegendaryIncrementField());
        legendaryIncrementFields.add(expansionPanels.get(Indexes.OUTLAND_INDEX)
                                                    .getLegendaryIncrementField());
        legendaryIncrementFields.add(expansionPanels.get(Indexes.SCHOLOMANCE_INDEX)
                                                    .getLegendaryIncrementField());
        legendaryIncrementFields.add(expansionPanels.get(Indexes.DARKMOON_INDEX)
                                                    .getLegendaryIncrementField());
        legendaryIncrementFields.add(expansionPanels.get(Indexes.BARRENS_INDEX)
                                                    .getLegendaryIncrementField());
        legendaryIncrementFields.add(expansionPanels.get(Indexes.STORMWIND_INDEX)
                                                    .getLegendaryIncrementField());
        legendaryIncrementFields.add(expansionPanels.get(Indexes.ALTERAC_INDEX)
                                                    .getLegendaryIncrementField());
        legendaryIncrementFields.add(expansionPanels.get(Indexes.SUNKEN_INDEX)
                                                    .getLegendaryIncrementField());

        return legendaryIncrementFields;
    }

    /**
     * Legendary probabilities
     *
     * @param expansionPanels is a list containing all the expansion panels
     * @return a list of all the legendary probabilities in the panel
     */
    public static List<Double> getLegendaryProbabilities(List<AbstractExpansionPanel> expansionPanels) {
        List<Double> legendaryProbabilities = new ArrayList<>();

        legendaryProbabilities.add(expansionPanels.get(Indexes.CLASSIC_INDEX)
                                                  .getLegendaryProbability());
        legendaryProbabilities.add(expansionPanels.get(Indexes.GOBLINS_INDEX)
                                                  .getLegendaryProbability());
        legendaryProbabilities.add(expansionPanels.get(Indexes.TOURNAMENT_INDEX)
                                                  .getLegendaryProbability());
        legendaryProbabilities.add(expansionPanels.get(Indexes.OLDGODS_INDEX)
                                                  .getLegendaryProbability());
        legendaryProbabilities.add(expansionPanels.get(Indexes.GADGETZAN_INDEX)
                                                  .getLegendaryProbability());
        legendaryProbabilities.add(expansionPanels.get(Indexes.UNGORO_INDEX)
                                                  .getLegendaryProbability());
        legendaryProbabilities.add(expansionPanels.get(Indexes.KNIGHTS_INDEX)
                                                  .getLegendaryProbability());
        legendaryProbabilities.add(expansionPanels.get(Indexes.KOBOLDS_INDEX)
                                                  .getLegendaryProbability());
        legendaryProbabilities.add(expansionPanels.get(Indexes.WITCHWOOD_INDEX)
                                                  .getLegendaryProbability());
        legendaryProbabilities.add(expansionPanels.get(Indexes.BOOMSDAY_INDEX)
                                                  .getLegendaryProbability());
        legendaryProbabilities.add(expansionPanels.get(Indexes.RUMBLE_INDEX)
                                                  .getLegendaryProbability());
        legendaryProbabilities.add(expansionPanels.get(Indexes.SHADOWS_INDEX)
                                                  .getLegendaryProbability());
        legendaryProbabilities.add(expansionPanels.get(Indexes.ULDUM_INDEX)
                                                  .getLegendaryProbability());
        legendaryProbabilities.add(expansionPanels.get(Indexes.DRAGONS_INDEX)
                                                  .getLegendaryProbability());
        legendaryProbabilities.add(expansionPanels.get(Indexes.OUTLAND_INDEX)
                                                  .getLegendaryProbability());
        legendaryProbabilities.add(expansionPanels.get(Indexes.SCHOLOMANCE_INDEX)
                                                  .getLegendaryProbability());
        legendaryProbabilities.add(expansionPanels.get(Indexes.DARKMOON_INDEX)
                                                  .getLegendaryProbability());
        legendaryProbabilities.add(expansionPanels.get(Indexes.BARRENS_INDEX)
                                                  .getLegendaryProbability());
        legendaryProbabilities.add(expansionPanels.get(Indexes.STORMWIND_INDEX)
                                                  .getLegendaryProbability());
        legendaryProbabilities.add(expansionPanels.get(Indexes.ALTERAC_INDEX)
                                                  .getLegendaryProbability());
        legendaryProbabilities.add(expansionPanels.get(Indexes.SUNKEN_INDEX)
                                                  .getLegendaryProbability());

        return legendaryProbabilities;
    }

    /**
     * Total counters
     *
     * @param expansionPanels is a list containing all the expansion panels
     * @return a list of all the total counters in the panel
     */
    public static List<Integer> getTotalCounters(List<AbstractExpansionPanel> expansionPanels) {
        List<Integer> totalCounters = new ArrayList<>();

        totalCounters.add(expansionPanels.get(Indexes.CLASSIC_INDEX)
                                         .getTotalCounter());
        totalCounters.add(expansionPanels.get(Indexes.GOBLINS_INDEX)
                                         .getTotalCounter());
        totalCounters.add(expansionPanels.get(Indexes.TOURNAMENT_INDEX)
                                         .getTotalCounter());
        totalCounters.add(expansionPanels.get(Indexes.OLDGODS_INDEX)
                                         .getTotalCounter());
        totalCounters.add(expansionPanels.get(Indexes.GADGETZAN_INDEX)
                                         .getTotalCounter());
        totalCounters.add(expansionPanels.get(Indexes.UNGORO_INDEX)
                                         .getTotalCounter());
        totalCounters.add(expansionPanels.get(Indexes.KNIGHTS_INDEX)
                                         .getTotalCounter());
        totalCounters.add(expansionPanels.get(Indexes.KOBOLDS_INDEX)
                                         .getTotalCounter());
        totalCounters.add(expansionPanels.get(Indexes.WITCHWOOD_INDEX)
                                         .getTotalCounter());
        totalCounters.add(expansionPanels.get(Indexes.BOOMSDAY_INDEX)
                                         .getTotalCounter());
        totalCounters.add(expansionPanels.get(Indexes.RUMBLE_INDEX)
                                         .getTotalCounter());
        totalCounters.add(expansionPanels.get(Indexes.SHADOWS_INDEX)
                                         .getTotalCounter());
        totalCounters.add(expansionPanels.get(Indexes.ULDUM_INDEX)
                                         .getTotalCounter());
        totalCounters.add(expansionPanels.get(Indexes.DRAGONS_INDEX)
                                         .getTotalCounter());
        totalCounters.add(expansionPanels.get(Indexes.OUTLAND_INDEX)
                                         .getTotalCounter());
        totalCounters.add(expansionPanels.get(Indexes.SCHOLOMANCE_INDEX)
                                         .getTotalCounter());
        totalCounters.add(expansionPanels.get(Indexes.DARKMOON_INDEX)
                                         .getTotalCounter());
        totalCounters.add(expansionPanels.get(Indexes.BARRENS_INDEX)
                                         .getTotalCounter());
        totalCounters.add(expansionPanels.get(Indexes.STORMWIND_INDEX)
                                         .getTotalCounter());
        totalCounters.add(expansionPanels.get(Indexes.ALTERAC_INDEX)
                                         .getTotalCounter());
        totalCounters.add(expansionPanels.get(Indexes.SUNKEN_INDEX)
                                         .getTotalCounter());

        return totalCounters;
    }

    /**
     * Total modify buttons
     *
     * @param expansionPanels is a list containing all the expansion panels
     * @return a list of all the total modify buttons in the panel
     */
    public static List<ResModButton> getTotalModifyButtons(List<AbstractExpansionPanel> expansionPanels) {
        List<ResModButton> totalModifyButtons = new ArrayList<>();

        totalModifyButtons.add(expansionPanels.get(Indexes.CLASSIC_INDEX)
                                              .getTotalModifyButton());
        totalModifyButtons.add(expansionPanels.get(Indexes.GOBLINS_INDEX)
                                              .getTotalModifyButton());
        totalModifyButtons.add(expansionPanels.get(Indexes.TOURNAMENT_INDEX)
                                              .getTotalModifyButton());
        totalModifyButtons.add(expansionPanels.get(Indexes.OLDGODS_INDEX)
                                              .getTotalModifyButton());
        totalModifyButtons.add(expansionPanels.get(Indexes.GADGETZAN_INDEX)
                                              .getTotalModifyButton());
        totalModifyButtons.add(expansionPanels.get(Indexes.UNGORO_INDEX)
                                              .getTotalModifyButton());
        totalModifyButtons.add(expansionPanels.get(Indexes.KNIGHTS_INDEX)
                                              .getTotalModifyButton());
        totalModifyButtons.add(expansionPanels.get(Indexes.KOBOLDS_INDEX)
                                              .getTotalModifyButton());
        totalModifyButtons.add(expansionPanels.get(Indexes.WITCHWOOD_INDEX)
                                              .getTotalModifyButton());
        totalModifyButtons.add(expansionPanels.get(Indexes.BOOMSDAY_INDEX)
                                              .getTotalModifyButton());
        totalModifyButtons.add(expansionPanels.get(Indexes.RUMBLE_INDEX)
                                              .getTotalModifyButton());
        totalModifyButtons.add(expansionPanels.get(Indexes.SHADOWS_INDEX)
                                              .getTotalModifyButton());
        totalModifyButtons.add(expansionPanels.get(Indexes.ULDUM_INDEX)
                                              .getTotalModifyButton());
        totalModifyButtons.add(expansionPanels.get(Indexes.DRAGONS_INDEX)
                                              .getTotalModifyButton());
        totalModifyButtons.add(expansionPanels.get(Indexes.OUTLAND_INDEX)
                                              .getTotalModifyButton());
        totalModifyButtons.add(expansionPanels.get(Indexes.SCHOLOMANCE_INDEX)
                                              .getTotalModifyButton());
        totalModifyButtons.add(expansionPanels.get(Indexes.DARKMOON_INDEX)
                                              .getTotalModifyButton());
        totalModifyButtons.add(expansionPanels.get(Indexes.BARRENS_INDEX)
                                              .getTotalModifyButton());
        totalModifyButtons.add(expansionPanels.get(Indexes.STORMWIND_INDEX)
                                              .getTotalModifyButton());
        totalModifyButtons.add(expansionPanels.get(Indexes.ALTERAC_INDEX)
                                              .getTotalModifyButton());
        totalModifyButtons.add(expansionPanels.get(Indexes.SUNKEN_INDEX)
                                              .getTotalModifyButton());

        return totalModifyButtons;
    }

    /**
     * Total add buttons
     *
     * @param expansionPanels is a list containing all the expansion panels
     * @return a list of all the total add buttons in the panel
     */
    public static List<AddButton> getTotalAddButtons(List<AbstractExpansionPanel> expansionPanels) {
        List<AddButton> totalAddButtons = new ArrayList<>();

        totalAddButtons.add(expansionPanels.get(Indexes.CLASSIC_INDEX)
                                           .getTotalAddButton());
        totalAddButtons.add(expansionPanels.get(Indexes.GOBLINS_INDEX)
                                           .getTotalAddButton());
        totalAddButtons.add(expansionPanels.get(Indexes.TOURNAMENT_INDEX)
                                           .getTotalAddButton());
        totalAddButtons.add(expansionPanels.get(Indexes.OLDGODS_INDEX)
                                           .getTotalAddButton());
        totalAddButtons.add(expansionPanels.get(Indexes.GADGETZAN_INDEX)
                                           .getTotalAddButton());
        totalAddButtons.add(expansionPanels.get(Indexes.UNGORO_INDEX)
                                           .getTotalAddButton());
        totalAddButtons.add(expansionPanels.get(Indexes.KNIGHTS_INDEX)
                                           .getTotalAddButton());
        totalAddButtons.add(expansionPanels.get(Indexes.KOBOLDS_INDEX)
                                           .getTotalAddButton());
        totalAddButtons.add(expansionPanels.get(Indexes.WITCHWOOD_INDEX)
                                           .getTotalAddButton());
        totalAddButtons.add(expansionPanels.get(Indexes.BOOMSDAY_INDEX)
                                           .getTotalAddButton());
        totalAddButtons.add(expansionPanels.get(Indexes.RUMBLE_INDEX)
                                           .getTotalAddButton());
        totalAddButtons.add(expansionPanels.get(Indexes.SHADOWS_INDEX)
                                           .getTotalAddButton());
        totalAddButtons.add(expansionPanels.get(Indexes.ULDUM_INDEX)
                                           .getTotalAddButton());
        totalAddButtons.add(expansionPanels.get(Indexes.DRAGONS_INDEX)
                                           .getTotalAddButton());
        totalAddButtons.add(expansionPanels.get(Indexes.OUTLAND_INDEX)
                                           .getTotalAddButton());
        totalAddButtons.add(expansionPanels.get(Indexes.SCHOLOMANCE_INDEX)
                                           .getTotalAddButton());
        totalAddButtons.add(expansionPanels.get(Indexes.DARKMOON_INDEX)
                                           .getTotalAddButton());
        totalAddButtons.add(expansionPanels.get(Indexes.BARRENS_INDEX)
                                           .getTotalAddButton());
        totalAddButtons.add(expansionPanels.get(Indexes.STORMWIND_INDEX)
                                           .getTotalAddButton());
        totalAddButtons.add(expansionPanels.get(Indexes.ALTERAC_INDEX)
                                           .getTotalAddButton());
        totalAddButtons.add(expansionPanels.get(Indexes.SUNKEN_INDEX)
                                           .getTotalAddButton());

        return totalAddButtons;
    }

    /**
     * Total increment fields
     *
     * @param expansionPanels is a list containing all the expansion panels
     * @return a list of all the total increment fields in the panel
     */
    public static List<IncrementField> getTotalIncrementFields(List<AbstractExpansionPanel> expansionPanels) {
        List<IncrementField> totalIncrementFields = new ArrayList<>();

        totalIncrementFields.add(expansionPanels.get(Indexes.CLASSIC_INDEX)
                                                .getTotalIncrementField());
        totalIncrementFields.add(expansionPanels.get(Indexes.GOBLINS_INDEX)
                                                .getTotalIncrementField());
        totalIncrementFields.add(expansionPanels.get(Indexes.TOURNAMENT_INDEX)
                                                .getTotalIncrementField());
        totalIncrementFields.add(expansionPanels.get(Indexes.OLDGODS_INDEX)
                                                .getTotalIncrementField());
        totalIncrementFields.add(expansionPanels.get(Indexes.GADGETZAN_INDEX)
                                                .getTotalIncrementField());
        totalIncrementFields.add(expansionPanels.get(Indexes.UNGORO_INDEX)
                                                .getTotalIncrementField());
        totalIncrementFields.add(expansionPanels.get(Indexes.KNIGHTS_INDEX)
                                                .getTotalIncrementField());
        totalIncrementFields.add(expansionPanels.get(Indexes.KOBOLDS_INDEX)
                                                .getTotalIncrementField());
        totalIncrementFields.add(expansionPanels.get(Indexes.WITCHWOOD_INDEX)
                                                .getTotalIncrementField());
        totalIncrementFields.add(expansionPanels.get(Indexes.BOOMSDAY_INDEX)
                                                .getTotalIncrementField());
        totalIncrementFields.add(expansionPanels.get(Indexes.RUMBLE_INDEX)
                                                .getTotalIncrementField());
        totalIncrementFields.add(expansionPanels.get(Indexes.SHADOWS_INDEX)
                                                .getTotalIncrementField());
        totalIncrementFields.add(expansionPanels.get(Indexes.ULDUM_INDEX)
                                                .getTotalIncrementField());
        totalIncrementFields.add(expansionPanels.get(Indexes.DRAGONS_INDEX)
                                                .getTotalIncrementField());
        totalIncrementFields.add(expansionPanels.get(Indexes.OUTLAND_INDEX)
                                                .getTotalIncrementField());
        totalIncrementFields.add(expansionPanels.get(Indexes.SCHOLOMANCE_INDEX)
                                                .getTotalIncrementField());
        totalIncrementFields.add(expansionPanels.get(Indexes.DARKMOON_INDEX)
                                                .getTotalIncrementField());
        totalIncrementFields.add(expansionPanels.get(Indexes.BARRENS_INDEX)
                                                .getTotalIncrementField());
        totalIncrementFields.add(expansionPanels.get(Indexes.STORMWIND_INDEX)
                                                .getTotalIncrementField());
        totalIncrementFields.add(expansionPanels.get(Indexes.ALTERAC_INDEX)
                                                .getTotalIncrementField());
        totalIncrementFields.add(expansionPanels.get(Indexes.SUNKEN_INDEX)
                                                .getTotalIncrementField());

        return totalIncrementFields;
    }

    /**
     * Card pack buttons
     *
     * @param expansionPanels is a list containing all the expansion panels
     * @return a list of all the card pack buttons in the panel
     */
    public static List<IconButton> getCardPackButtons(List<AbstractExpansionPanel> expansionPanels) {
        List<IconButton> cardPackButtons = new ArrayList<>();

        cardPackButtons.add(expansionPanels.get(Indexes.CLASSIC_INDEX)
                                           .getCardPackButton());
        cardPackButtons.add(expansionPanels.get(Indexes.GOBLINS_INDEX)
                                           .getCardPackButton());
        cardPackButtons.add(expansionPanels.get(Indexes.TOURNAMENT_INDEX)
                                           .getCardPackButton());
        cardPackButtons.add(expansionPanels.get(Indexes.OLDGODS_INDEX)
                                           .getCardPackButton());
        cardPackButtons.add(expansionPanels.get(Indexes.GADGETZAN_INDEX)
                                           .getCardPackButton());
        cardPackButtons.add(expansionPanels.get(Indexes.UNGORO_INDEX)
                                           .getCardPackButton());
        cardPackButtons.add(expansionPanels.get(Indexes.KNIGHTS_INDEX)
                                           .getCardPackButton());
        cardPackButtons.add(expansionPanels.get(Indexes.KOBOLDS_INDEX)
                                           .getCardPackButton());
        cardPackButtons.add(expansionPanels.get(Indexes.WITCHWOOD_INDEX)
                                           .getCardPackButton());
        cardPackButtons.add(expansionPanels.get(Indexes.BOOMSDAY_INDEX)
                                           .getCardPackButton());
        cardPackButtons.add(expansionPanels.get(Indexes.RUMBLE_INDEX)
                                           .getCardPackButton());
        cardPackButtons.add(expansionPanels.get(Indexes.SHADOWS_INDEX)
                                           .getCardPackButton());
        cardPackButtons.add(expansionPanels.get(Indexes.ULDUM_INDEX)
                                           .getCardPackButton());
        cardPackButtons.add(expansionPanels.get(Indexes.DRAGONS_INDEX)
                                           .getCardPackButton());
        cardPackButtons.add(expansionPanels.get(Indexes.OUTLAND_INDEX)
                                           .getCardPackButton());
        cardPackButtons.add(expansionPanels.get(Indexes.SCHOLOMANCE_INDEX)
                                           .getCardPackButton());
        cardPackButtons.add(expansionPanels.get(Indexes.DARKMOON_INDEX)
                                           .getCardPackButton());
        cardPackButtons.add(expansionPanels.get(Indexes.BARRENS_INDEX)
                                           .getCardPackButton());
        cardPackButtons.add(expansionPanels.get(Indexes.STORMWIND_INDEX)
                                           .getCardPackButton());
        cardPackButtons.add(expansionPanels.get(Indexes.ALTERAC_INDEX)
                                           .getCardPackButton());
        cardPackButtons.add(expansionPanels.get(Indexes.SUNKEN_INDEX)
                                           .getCardPackButton());

        return cardPackButtons;
    }

    /**
     * Private constructor to hide the default public one
     */
    private TrackerComponentsHelper() {
    }
}
