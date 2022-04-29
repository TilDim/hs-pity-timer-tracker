package tildim.hstools.hspitytimertracker.util;

import org.apache.commons.collections4.ListUtils;
import tildim.hstools.hspitytimertracker.exception.TextFileException;
import tildim.hstools.hspitytimertracker.gui.panel.expansion.AbstractExpansionPanel;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.FileAlreadyExistsException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

/**
 * Contains all the necessary methods to process the tracker's text files
 */
public class FileHelper {

    // Save file path in the system
    public static final Path SAVE_FILE_PATH = Path.of(System.getProperty("user.home") + File.separator + "Documents" + File.separator + "HSPityTimerTrackerData.txt");

    private static Path saveFile;

    private static List<String> saveFileData;

    private static List<String> saveFileExpansions;

    /**
     * Creates the save file or updates it with new expansions
     */
    public static void createSaveFile() {
        // Read the base file
        List<String> baseFileData = readResourceFile("text/base_text.txt");

        // Create the save file for the first time
        try {
            saveFile = Files.createFile(SAVE_FILE_PATH);
            writeSaveFile(String.join(Text.NEXT_LINE, baseFileData));
            setReadOnly();

            saveFileData = readSaveFile(saveFile);
        }
        // or update the save file with new expansions if it already exists
        catch (FileAlreadyExistsException e) {
            // Read the save file
            saveFile = SAVE_FILE_PATH;
            saveFileData = readSaveFile(saveFile);

            // Check if the save file's text is different compared to the base text (5 is the index of the line after the '- Expansions' label)
            // If it's not, insert the new expansions in the save file
            if (!saveFileData.get(5)
                             .equals(baseFileData.get(5))) {
                // List with the expansions in the base file
                List<String> baseFileExpansions = findExpansionsInFile(baseFileData);

                // List with the expansions in the save file
                List<String> saveFileExpansions = findExpansionsInFile(saveFileData);

                // Find the new expansions and keep them in a temporary list
                List<String> newExpansions = ListUtils.removeAll(baseFileExpansions, saveFileExpansions);
                Collections.reverse(newExpansions);

                // Insert the new expansions in the save file
                for (int j = 0; j < saveFileData.size(); j++) {
                    // The new expansions in the "Expansions" section of the file
                    addNewExpansions(newExpansions, j, "- Expansions", "");

                    // The new expansions in the "Epic counters" section of the file
                    addNewExpansions(newExpansions, j, "- Epic counters", ": 0");

                    // The new expansions in the "Epic probabilities" section of the file
                    addNewExpansions(newExpansions, j, "- Epic probabilities", ": 0");

                    // The new expansions in the "Legendary counters" section of the file
                    addNewExpansions(newExpansions, j, "- Legendary counters", ": 0");

                    // The new expansions in the "Legendary probabilities" section of the file
                    addNewExpansions(newExpansions, j, "- Legendary probabilities", ": 0");

                    // The new expansions in the "Total counters" section of the file
                    addNewExpansions(newExpansions, j, "- Total counters", ": 0");
                }

                // Write the updated data in the save file
                setWritable();
                writeSaveFile(String.join(Text.NEXT_LINE, saveFileData));
                setReadOnly();
            }
        } catch (IOException e) {
            throw new TextFileException("Error while creating the file", e.getCause());
        }

        saveFileExpansions = findExpansionsInFile(saveFileData);
    }

    /**
     * Reads a resource file
     *
     * @param filePath is the resource file's path from the source root
     * @return a list with all the lines of the resource file
     */
    private static List<String> readResourceFile(String filePath) {
        try (InputStream inputStream = FileHelper.class.getClassLoader()
                                                       .getResourceAsStream(filePath)) {
            return new BufferedReader(
                    new InputStreamReader(Objects.requireNonNull(inputStream),
                            StandardCharsets.UTF_8)).lines()
                                                    .toList();
        } catch (IOException e) {
            throw new TextFileException("Error while reading a resource file", e.getCause());
        }
    }

    /**
     * Finds the expansions in a file and returns them from oldest to newest
     *
     * @param data a list with all the lines of the save file
     * @return a list of all the expansions in the save file
     */
    private static List<String> findExpansionsInFile(List<String> data) {
        List<String> expansions = new ArrayList<>();

        // Add all the lines of the file under the '- Expansions' label until the first empty one
        int i = 5;
        while (!data.get(i)
                    .equals("")) {
            expansions.add(0, data.get(i));
            i++;
        }

        return expansions;
    }

    /**
     * Adds the expansions that came out since the last update of the tracker to the save file
     *
     * @param newExpansions is a list of all the new expansions since the last update
     * @param index         is the index in the list with all the lines of the save file where the new expansions will be inserted
     * @param label         is the label in the save file (e.g. "- Expansions") under which the new expansions will be inserted
     * @param value         is the default value to be inserted next to an expansion's name in the save file
     */
    private static void addNewExpansions(List<String> newExpansions, int index, String label, String value) {
        int numOfNewExpansions = newExpansions.size();

        // Add the new expansions in descending order under the corresponding section of the save file
        if (saveFileData.get(index)
                        .equals(label) && ((index + 1) < saveFileData.size())) {
            while (numOfNewExpansions != 0) {
                saveFileData.add(index + 1, newExpansions.get(numOfNewExpansions - 1) + value);
                numOfNewExpansions--;
            }
        }
    }

    /**
     * Reads the save file
     *
     * @param filePath is the save file's path from the system root
     * @return a list with all the lines of the save file
     */
    private static List<String> readSaveFile(Path filePath) {
        try {
            return Files.readAllLines(filePath);
        } catch (IOException e) {
            throw new TextFileException("Error while reading the save file", e.getCause());
        }
    }

    /**
     * Writes the save file
     *
     * @param data is the data to be written in the file
     */
    private static void writeSaveFile(String data) {
        try {
            Files.writeString(saveFile, data);
        } catch (IOException e) {
            throw new TextFileException("Error while writing the save file", e.getCause());
        }
    }

    /**
     * Sets the save file as read-only
     */
    private static void setReadOnly() {
        saveFile.toFile()
                .setReadOnly();
    }

    /**
     * Sets the save file writable
     */
    private static void setWritable() {
        saveFile.toFile()
                .setWritable(true);
    }

    /**
     * Reads the help text file and sets the help message
     *
     * @return the help message
     */
    public static String setHelpMessageText() {
        return String.join(Text.NEXT_LINE, readResourceFile("text/help_text.txt"));
    }

    /**
     * Extracts from the save file and sets the tracker values
     *
     * @param expansionPanels is a list containing all the expansion panels
     */
    public static void setTrackerValues(List<AbstractExpansionPanel> expansionPanels) {
        saveFileData = readSaveFile(saveFile);

        // Epic counters
        expansionPanels.get(Indexes.SUNKEN_INDEX)
                       .setEpicCounter(saveFileData.get(Indexes.SUNKEN_EPIC_COUNTER_ROW_INDEX)
                                                   .substring(Indexes.SUNKEN_COLUMN_INDEX));
        expansionPanels.get(Indexes.ALTERAC_INDEX)
                       .setEpicCounter(saveFileData.get(Indexes.ALTERAC_EPIC_COUNTER_ROW_INDEX)
                                                   .substring(Indexes.ALTERAC_COLUMN_INDEX));
        expansionPanels.get(Indexes.STORMWIND_INDEX)
                       .setEpicCounter(saveFileData.get(Indexes.STORMWIND_EPIC_COUNTER_ROW_INDEX)
                                                   .substring(Indexes.STORMWIND_COLUMN_INDEX));
        expansionPanels.get(Indexes.BARRENS_INDEX)
                       .setEpicCounter(saveFileData.get(Indexes.BARRENS_EPIC_COUNTER_ROW_INDEX)
                                                   .substring(Indexes.BARRENS_COLUMN_INDEX));
        expansionPanels.get(Indexes.DARKMOON_INDEX)
                       .setEpicCounter(saveFileData.get(Indexes.DARKMOON_EPIC_COUNTER_ROW_INDEX)
                                                   .substring(Indexes.DARKMOON_COLUMN_INDEX));
        expansionPanels.get(Indexes.SCHOLOMANCE_INDEX)
                       .setEpicCounter(saveFileData.get(Indexes.SCHOLOMANCE_EPIC_COUNTER_ROW_INDEX)
                                                   .substring(Indexes.SCHOLOMANCE_COLUMN_INDEX));
        expansionPanels.get(Indexes.OUTLAND_INDEX)
                       .setEpicCounter(saveFileData.get(Indexes.OUTLAND_EPIC_COUNTER_ROW_INDEX)
                                                   .substring(Indexes.OUTLAND_COLUMN_INDEX));
        expansionPanels.get(Indexes.DRAGONS_INDEX)
                       .setEpicCounter(saveFileData.get(Indexes.DRAGONS_EPIC_COUNTER_ROW_INDEX)
                                                   .substring(Indexes.DRAGONS_COLUMN_INDEX));
        expansionPanels.get(Indexes.ULDUM_INDEX)
                       .setEpicCounter(saveFileData.get(Indexes.ULDUM_EPIC_COUNTER_ROW_INDEX)
                                                   .substring(Indexes.ULDUM_COLUMN_INDEX));
        expansionPanels.get(Indexes.SHADOWS_INDEX)
                       .setEpicCounter(saveFileData.get(Indexes.SHADOWS_EPIC_COUNTER_ROW_INDEX)
                                                   .substring(Indexes.SHADOWS_COLUMN_INDEX));
        expansionPanels.get(Indexes.RUMBLE_INDEX)
                       .setEpicCounter(saveFileData.get(Indexes.RUMBLE_EPIC_COUNTER_ROW_INDEX)
                                                   .substring(Indexes.RUMBLE_COLUMN_INDEX));
        expansionPanels.get(Indexes.BOOMSDAY_INDEX)
                       .setEpicCounter(saveFileData.get(Indexes.BOOMSDAY_EPIC_COUNTER_ROW_INDEX)
                                                   .substring(Indexes.BOOMSDAY_COLUMN_INDEX));
        expansionPanels.get(Indexes.WITCHWOOD_INDEX)
                       .setEpicCounter(saveFileData.get(Indexes.WITCHWOOD_EPIC_COUNTER_ROW_INDEX)
                                                   .substring(Indexes.WITCHWOOD_COLUMN_INDEX));
        expansionPanels.get(Indexes.KOBOLDS_INDEX)
                       .setEpicCounter(saveFileData.get(Indexes.KOBOLDS_EPIC_COUNTER_ROW_INDEX)
                                                   .substring(Indexes.KOBOLDS_COLUMN_INDEX));
        expansionPanels.get(Indexes.KNIGHTS_INDEX)
                       .setEpicCounter(saveFileData.get(Indexes.KNIGHTS_EPIC_COUNTER_ROW_INDEX)
                                                   .substring(Indexes.KNIGHTS_COLUMN_INDEX));
        expansionPanels.get(Indexes.UNGORO_INDEX)
                       .setEpicCounter(saveFileData.get(Indexes.UNGORO_EPIC_COUNTER_ROW_INDEX)
                                                   .substring(Indexes.UNGORO_COLUMN_INDEX));
        expansionPanels.get(Indexes.GADGETZAN_INDEX)
                       .setEpicCounter(saveFileData.get(Indexes.GADGETZAN_EPIC_COUNTER_ROW_INDEX)
                                                   .substring(Indexes.GADGETZAN_COLUMN_INDEX));
        expansionPanels.get(Indexes.OLDGODS_INDEX)
                       .setEpicCounter(saveFileData.get(Indexes.OLDGODS_EPIC_COUNTER_ROW_INDEX)
                                                   .substring(Indexes.OLDGODS_COLUMN_INDEX));
        expansionPanels.get(Indexes.TOURNAMENT_INDEX)
                       .setEpicCounter(saveFileData.get(Indexes.TOURNAMENT_EPIC_COUNTER_ROW_INDEX)
                                                   .substring(Indexes.TOURNAMENT_COLUMN_INDEX));
        expansionPanels.get(Indexes.GOBLINS_INDEX)
                       .setEpicCounter(saveFileData.get(Indexes.GOBLINS_EPIC_COUNTER_ROW_INDEX)
                                                   .substring(Indexes.GOBLINS_COLUMN_INDEX));
        expansionPanels.get(Indexes.CLASSIC_INDEX)
                       .setEpicCounter(saveFileData.get(Indexes.CLASSIC_EPIC_COUNTER_ROW_INDEX)
                                                   .substring(Indexes.CLASSIC_COLUMN_INDEX));

        // Epic probabilities
        expansionPanels.get(Indexes.SUNKEN_INDEX)
                       .setEpicProbability(saveFileData.get(Indexes.SUNKEN_EPIC_PROBABILITY_ROW_INDEX)
                                                       .substring(Indexes.SUNKEN_COLUMN_INDEX));
        expansionPanels.get(Indexes.ALTERAC_INDEX)
                       .setEpicProbability(saveFileData.get(Indexes.ALTERAC_EPIC_PROBABILITY_ROW_INDEX)
                                                       .substring(Indexes.ALTERAC_COLUMN_INDEX));
        expansionPanels.get(Indexes.STORMWIND_INDEX)
                       .setEpicProbability(saveFileData.get(Indexes.STORMWIND_EPIC_PROBABILITY_ROW_INDEX)
                                                       .substring(Indexes.STORMWIND_COLUMN_INDEX));
        expansionPanels.get(Indexes.BARRENS_INDEX)
                       .setEpicProbability(saveFileData.get(Indexes.BARRENS_EPIC_PROBABILITY_ROW_INDEX)
                                                       .substring(Indexes.BARRENS_COLUMN_INDEX));
        expansionPanels.get(Indexes.DARKMOON_INDEX)
                       .setEpicProbability(saveFileData.get(Indexes.DARKMOON_EPIC_PROBABILITY_ROW_INDEX)
                                                       .substring(Indexes.DARKMOON_COLUMN_INDEX));
        expansionPanels.get(Indexes.SCHOLOMANCE_INDEX)
                       .setEpicProbability(saveFileData.get(Indexes.SCHOLOMANCE_EPIC_PROBABILITY_ROW_INDEX)
                                                       .substring(Indexes.SCHOLOMANCE_COLUMN_INDEX));
        expansionPanels.get(Indexes.OUTLAND_INDEX)
                       .setEpicProbability(saveFileData.get(Indexes.OUTLAND_EPIC_PROBABILITY_ROW_INDEX)
                                                       .substring(Indexes.OUTLAND_COLUMN_INDEX));
        expansionPanels.get(Indexes.DRAGONS_INDEX)
                       .setEpicProbability(saveFileData.get(Indexes.DRAGONS_EPIC_PROBABILITY_ROW_INDEX)
                                                       .substring(Indexes.DRAGONS_COLUMN_INDEX));
        expansionPanels.get(Indexes.ULDUM_INDEX)
                       .setEpicProbability(saveFileData.get(Indexes.ULDUM_EPIC_PROBABILITY_ROW_INDEX)
                                                       .substring(Indexes.ULDUM_COLUMN_INDEX));
        expansionPanels.get(Indexes.SHADOWS_INDEX)
                       .setEpicProbability(saveFileData.get(Indexes.SHADOWS_EPIC_PROBABILITY_ROW_INDEX)
                                                       .substring(Indexes.SHADOWS_COLUMN_INDEX));
        expansionPanels.get(Indexes.RUMBLE_INDEX)
                       .setEpicProbability(saveFileData.get(Indexes.RUMBLE_EPIC_PROBABILITY_ROW_INDEX)
                                                       .substring(Indexes.RUMBLE_COLUMN_INDEX));
        expansionPanels.get(Indexes.BOOMSDAY_INDEX)
                       .setEpicProbability(saveFileData.get(Indexes.BOOMSDAY_EPIC_PROBABILITY_ROW_INDEX)
                                                       .substring(Indexes.BOOMSDAY_COLUMN_INDEX));
        expansionPanels.get(Indexes.WITCHWOOD_INDEX)
                       .setEpicProbability(saveFileData.get(Indexes.WITCHWOOD_EPIC_PROBABILITY_ROW_INDEX)
                                                       .substring(Indexes.WITCHWOOD_COLUMN_INDEX));
        expansionPanels.get(Indexes.KOBOLDS_INDEX)
                       .setEpicProbability(saveFileData.get(Indexes.KOBOLDS_EPIC_PROBABILITY_ROW_INDEX)
                                                       .substring(Indexes.KOBOLDS_COLUMN_INDEX));
        expansionPanels.get(Indexes.KNIGHTS_INDEX)
                       .setEpicProbability(saveFileData.get(Indexes.KNIGHTS_EPIC_PROBABILITY_ROW_INDEX)
                                                       .substring(Indexes.KNIGHTS_COLUMN_INDEX));
        expansionPanels.get(Indexes.UNGORO_INDEX)
                       .setEpicProbability(saveFileData.get(Indexes.UNGORO_EPIC_PROBABILITY_ROW_INDEX)
                                                       .substring(Indexes.UNGORO_COLUMN_INDEX));
        expansionPanels.get(Indexes.GADGETZAN_INDEX)
                       .setEpicProbability(saveFileData.get(Indexes.GADGETZAN_EPIC_PROBABILITY_ROW_INDEX)
                                                       .substring(Indexes.GADGETZAN_COLUMN_INDEX));
        expansionPanels.get(Indexes.OLDGODS_INDEX)
                       .setEpicProbability(saveFileData.get(Indexes.OLDGODS_EPIC_PROBABILITY_ROW_INDEX)
                                                       .substring(Indexes.OLDGODS_COLUMN_INDEX));
        expansionPanels.get(Indexes.TOURNAMENT_INDEX)
                       .setEpicProbability(saveFileData.get(Indexes.TOURNAMENT_EPIC_PROBABILITY_ROW_INDEX)
                                                       .substring(Indexes.TOURNAMENT_COLUMN_INDEX));
        expansionPanels.get(Indexes.GOBLINS_INDEX)
                       .setEpicProbability(saveFileData.get(Indexes.GOBLINS_EPIC_PROBABILITY_ROW_INDEX)
                                                       .substring(Indexes.GOBLINS_COLUMN_INDEX));
        expansionPanels.get(Indexes.CLASSIC_INDEX)
                       .setEpicProbability(saveFileData.get(Indexes.CLASSIC_EPIC_PROBABILITY_ROW_INDEX)
                                                       .substring(Indexes.CLASSIC_COLUMN_INDEX));

        // Legendary counters
        expansionPanels.get(Indexes.SUNKEN_INDEX)
                       .setLegendaryCounter(saveFileData.get(Indexes.SUNKEN_LEGENDARY_COUNTER_ROW_INDEX)
                                                        .substring(Indexes.SUNKEN_COLUMN_INDEX));
        expansionPanels.get(Indexes.ALTERAC_INDEX)
                       .setLegendaryCounter(saveFileData.get(Indexes.ALTERAC_LEGENDARY_COUNTER_ROW_INDEX)
                                                        .substring(Indexes.ALTERAC_COLUMN_INDEX));
        expansionPanels.get(Indexes.STORMWIND_INDEX)
                       .setLegendaryCounter(saveFileData.get(Indexes.STORMWIND_LEGENDARY_COUNTER_ROW_INDEX)
                                                        .substring(Indexes.STORMWIND_COLUMN_INDEX));
        expansionPanels.get(Indexes.BARRENS_INDEX)
                       .setLegendaryCounter(saveFileData.get(Indexes.BARRENS_LEGENDARY_COUNTER_ROW_INDEX)
                                                        .substring(Indexes.BARRENS_COLUMN_INDEX));
        expansionPanels.get(Indexes.DARKMOON_INDEX)
                       .setLegendaryCounter(saveFileData.get(Indexes.DARKMOON_LEGENDARY_COUNTER_ROW_INDEX)
                                                        .substring(Indexes.DARKMOON_COLUMN_INDEX));
        expansionPanels.get(Indexes.SCHOLOMANCE_INDEX)
                       .setLegendaryCounter(saveFileData.get(Indexes.SCHOLOMANCE_LEGENDARY_COUNTER_ROW_INDEX)
                                                        .substring(Indexes.SCHOLOMANCE_COLUMN_INDEX));
        expansionPanels.get(Indexes.OUTLAND_INDEX)
                       .setLegendaryCounter(saveFileData.get(Indexes.OUTLAND_LEGENDARY_COUNTER_ROW_INDEX)
                                                        .substring(Indexes.OUTLAND_COLUMN_INDEX));
        expansionPanels.get(Indexes.DRAGONS_INDEX)
                       .setLegendaryCounter(saveFileData.get(Indexes.DRAGONS_LEGENDARY_COUNTER_ROW_INDEX)
                                                        .substring(Indexes.DRAGONS_COLUMN_INDEX));
        expansionPanels.get(Indexes.ULDUM_INDEX)
                       .setLegendaryCounter(saveFileData.get(Indexes.ULDUM_LEGENDARY_COUNTER_ROW_INDEX)
                                                        .substring(Indexes.ULDUM_COLUMN_INDEX));
        expansionPanels.get(Indexes.SHADOWS_INDEX)
                       .setLegendaryCounter(saveFileData.get(Indexes.SHADOWS_LEGENDARY_COUNTER_ROW_INDEX)
                                                        .substring(Indexes.SHADOWS_COLUMN_INDEX));
        expansionPanels.get(Indexes.RUMBLE_INDEX)
                       .setLegendaryCounter(saveFileData.get(Indexes.RUMBLE_LEGENDARY_COUNTER_ROW_INDEX)
                                                        .substring(Indexes.RUMBLE_COLUMN_INDEX));
        expansionPanels.get(Indexes.BOOMSDAY_INDEX)
                       .setLegendaryCounter(saveFileData.get(Indexes.BOOMSDAY_LEGENDARY_COUNTER_ROW_INDEX)
                                                        .substring(Indexes.BOOMSDAY_COLUMN_INDEX));
        expansionPanels.get(Indexes.WITCHWOOD_INDEX)
                       .setLegendaryCounter(saveFileData.get(Indexes.WITCHWOOD_LEGENDARY_COUNTER_ROW_INDEX)
                                                        .substring(Indexes.WITCHWOOD_COLUMN_INDEX));
        expansionPanels.get(Indexes.KOBOLDS_INDEX)
                       .setLegendaryCounter(saveFileData.get(Indexes.KOBOLDS_LEGENDARY_COUNTER_ROW_INDEX)
                                                        .substring(Indexes.KOBOLDS_COLUMN_INDEX));
        expansionPanels.get(Indexes.KNIGHTS_INDEX)
                       .setLegendaryCounter(saveFileData.get(Indexes.KNIGHTS_LEGENDARY_COUNTER_ROW_INDEX)
                                                        .substring(Indexes.KNIGHTS_COLUMN_INDEX));
        expansionPanels.get(Indexes.UNGORO_INDEX)
                       .setLegendaryCounter(saveFileData.get(Indexes.UNGORO_LEGENDARY_COUNTER_ROW_INDEX)
                                                        .substring(Indexes.UNGORO_COLUMN_INDEX));
        expansionPanels.get(Indexes.GADGETZAN_INDEX)
                       .setLegendaryCounter(saveFileData.get(Indexes.GADGETZAN_LEGENDARY_COUNTER_ROW_INDEX)
                                                        .substring(Indexes.GADGETZAN_COLUMN_INDEX));
        expansionPanels.get(Indexes.OLDGODS_INDEX)
                       .setLegendaryCounter(saveFileData.get(Indexes.OLDGODS_LEGENDARY_COUNTER_ROW_INDEX)
                                                        .substring(Indexes.OLDGODS_COLUMN_INDEX));
        expansionPanels.get(Indexes.TOURNAMENT_INDEX)
                       .setLegendaryCounter(saveFileData.get(Indexes.TOURNAMENT_LEGENDARY_COUNTER_ROW_INDEX)
                                                        .substring(Indexes.TOURNAMENT_COLUMN_INDEX));
        expansionPanels.get(Indexes.GOBLINS_INDEX)
                       .setLegendaryCounter(saveFileData.get(Indexes.GOBLINS_LEGENDARY_COUNTER_ROW_INDEX)
                                                        .substring(Indexes.GOBLINS_COLUMN_INDEX));
        expansionPanels.get(Indexes.CLASSIC_INDEX)
                       .setLegendaryCounter(saveFileData.get(Indexes.CLASSIC_LEGENDARY_COUNTER_ROW_INDEX)
                                                        .substring(Indexes.CLASSIC_COLUMN_INDEX));

        // Legendary probabilities
        expansionPanels.get(Indexes.SUNKEN_INDEX)
                       .setLegendaryProbability(saveFileData.get(Indexes.SUNKEN_LEGENDARY_PROBABILITY_ROW_INDEX)
                                                            .substring(Indexes.SUNKEN_COLUMN_INDEX));
        expansionPanels.get(Indexes.ALTERAC_INDEX)
                       .setLegendaryProbability(saveFileData.get(Indexes.ALTERAC_LEGENDARY_PROBABILITY_ROW_INDEX)
                                                            .substring(Indexes.ALTERAC_COLUMN_INDEX));
        expansionPanels.get(Indexes.STORMWIND_INDEX)
                       .setLegendaryProbability(saveFileData.get(Indexes.STORMWIND_LEGENDARY_PROBABILITY_ROW_INDEX)
                                                            .substring(Indexes.STORMWIND_COLUMN_INDEX));
        expansionPanels.get(Indexes.BARRENS_INDEX)
                       .setLegendaryProbability(saveFileData.get(Indexes.BARRENS_LEGENDARY_PROBABILITY_ROW_INDEX)
                                                            .substring(Indexes.BARRENS_COLUMN_INDEX));
        expansionPanels.get(Indexes.DARKMOON_INDEX)
                       .setLegendaryProbability(saveFileData.get(Indexes.DARKMOON_LEGENDARY_PROBABILITY_ROW_INDEX)
                                                            .substring(Indexes.DARKMOON_COLUMN_INDEX));
        expansionPanels.get(Indexes.SCHOLOMANCE_INDEX)
                       .setLegendaryProbability(saveFileData.get(Indexes.SCHOLOMANCE_LEGENDARY_PROBABILITY_ROW_INDEX)
                                                            .substring(Indexes.SCHOLOMANCE_COLUMN_INDEX));
        expansionPanels.get(Indexes.OUTLAND_INDEX)
                       .setLegendaryProbability(saveFileData.get(Indexes.OUTLAND_LEGENDARY_PROBABILITY_ROW_INDEX)
                                                            .substring(Indexes.OUTLAND_COLUMN_INDEX));
        expansionPanels.get(Indexes.DRAGONS_INDEX)
                       .setLegendaryProbability(saveFileData.get(Indexes.DRAGONS_LEGENDARY_PROBABILITY_ROW_INDEX)
                                                            .substring(Indexes.DRAGONS_COLUMN_INDEX));
        expansionPanels.get(Indexes.ULDUM_INDEX)
                       .setLegendaryProbability(saveFileData.get(Indexes.ULDUM_LEGENDARY_PROBABILITY_ROW_INDEX)
                                                            .substring(Indexes.ULDUM_COLUMN_INDEX));
        expansionPanels.get(Indexes.SHADOWS_INDEX)
                       .setLegendaryProbability(saveFileData.get(Indexes.SHADOWS_LEGENDARY_PROBABILITY_ROW_INDEX)
                                                            .substring(Indexes.SHADOWS_COLUMN_INDEX));
        expansionPanels.get(Indexes.RUMBLE_INDEX)
                       .setLegendaryProbability(saveFileData.get(Indexes.RUMBLE_LEGENDARY_PROBABILITY_ROW_INDEX)
                                                            .substring(Indexes.RUMBLE_COLUMN_INDEX));
        expansionPanels.get(Indexes.BOOMSDAY_INDEX)
                       .setLegendaryProbability(saveFileData.get(Indexes.BOOMSDAY_LEGENDARY_PROBABILITY_ROW_INDEX)
                                                            .substring(Indexes.BOOMSDAY_COLUMN_INDEX));
        expansionPanels.get(Indexes.WITCHWOOD_INDEX)
                       .setLegendaryProbability(saveFileData.get(Indexes.WITCHWOOD_LEGENDARY_PROBABILITY_ROW_INDEX)
                                                            .substring(Indexes.WITCHWOOD_COLUMN_INDEX));
        expansionPanels.get(Indexes.KOBOLDS_INDEX)
                       .setLegendaryProbability(saveFileData.get(Indexes.KOBOLDS_LEGENDARY_PROBABILITY_ROW_INDEX)
                                                            .substring(Indexes.KOBOLDS_COLUMN_INDEX));
        expansionPanels.get(Indexes.KNIGHTS_INDEX)
                       .setLegendaryProbability(saveFileData.get(Indexes.KNIGHTS_LEGENDARY_PROBABILITY_ROW_INDEX)
                                                            .substring(Indexes.KNIGHTS_COLUMN_INDEX));
        expansionPanels.get(Indexes.UNGORO_INDEX)
                       .setLegendaryProbability(saveFileData.get(Indexes.UNGORO_LEGENDARY_PROBABILITY_ROW_INDEX)
                                                            .substring(Indexes.UNGORO_COLUMN_INDEX));
        expansionPanels.get(Indexes.GADGETZAN_INDEX)
                       .setLegendaryProbability(saveFileData.get(Indexes.GADGETZAN_LEGENDARY_PROBABILITY_ROW_INDEX)
                                                            .substring(Indexes.GADGETZAN_COLUMN_INDEX));
        expansionPanels.get(Indexes.OLDGODS_INDEX)
                       .setLegendaryProbability(saveFileData.get(Indexes.OLDGODS_LEGENDARY_PROBABILITY_ROW_INDEX)
                                                            .substring(Indexes.OLDGODS_COLUMN_INDEX));
        expansionPanels.get(Indexes.TOURNAMENT_INDEX)
                       .setLegendaryProbability(saveFileData.get(Indexes.TOURNAMENT_LEGENDARY_PROBABILITY_ROW_INDEX)
                                                            .substring(Indexes.TOURNAMENT_COLUMN_INDEX));
        expansionPanels.get(Indexes.GOBLINS_INDEX)
                       .setLegendaryProbability(saveFileData.get(Indexes.GOBLINS_LEGENDARY_PROBABILITY_ROW_INDEX)
                                                            .substring(Indexes.GOBLINS_COLUMN_INDEX));
        expansionPanels.get(Indexes.CLASSIC_INDEX)
                       .setLegendaryProbability(saveFileData.get(Indexes.CLASSIC_LEGENDARY_PROBABILITY_ROW_INDEX)
                                                            .substring(Indexes.CLASSIC_COLUMN_INDEX));

        // Total counters
        expansionPanels.get(Indexes.SUNKEN_INDEX)
                       .setTotalCounter(saveFileData.get(Indexes.SUNKEN_TOTAL_COUNTER_ROW_INDEX)
                                                    .substring(Indexes.SUNKEN_COLUMN_INDEX));
        expansionPanels.get(Indexes.ALTERAC_INDEX)
                       .setTotalCounter(saveFileData.get(Indexes.ALTERAC_TOTAL_COUNTER_ROW_INDEX)
                                                    .substring(Indexes.ALTERAC_COLUMN_INDEX));
        expansionPanels.get(Indexes.STORMWIND_INDEX)
                       .setTotalCounter(saveFileData.get(Indexes.STORMWIND_TOTAL_COUNTER_ROW_INDEX)
                                                    .substring(Indexes.STORMWIND_COLUMN_INDEX));
        expansionPanels.get(Indexes.BARRENS_INDEX)
                       .setTotalCounter(saveFileData.get(Indexes.BARRENS_TOTAL_COUNTER_ROW_INDEX)
                                                    .substring(Indexes.BARRENS_COLUMN_INDEX));
        expansionPanels.get(Indexes.DARKMOON_INDEX)
                       .setTotalCounter(saveFileData.get(Indexes.DARKMOON_TOTAL_COUNTER_ROW_INDEX)
                                                    .substring(Indexes.DARKMOON_COLUMN_INDEX));
        expansionPanels.get(Indexes.SCHOLOMANCE_INDEX)
                       .setTotalCounter(saveFileData.get(Indexes.SCHOLOMANCE_TOTAL_COUNTER_ROW_INDEX)
                                                    .substring(Indexes.SCHOLOMANCE_COLUMN_INDEX));
        expansionPanels.get(Indexes.OUTLAND_INDEX)
                       .setTotalCounter(saveFileData.get(Indexes.OUTLAND_TOTAL_COUNTER_ROW_INDEX)
                                                    .substring(Indexes.OUTLAND_COLUMN_INDEX));
        expansionPanels.get(Indexes.DRAGONS_INDEX)
                       .setTotalCounter(saveFileData.get(Indexes.DRAGONS_TOTAL_COUNTER_ROW_INDEX)
                                                    .substring(Indexes.DRAGONS_COLUMN_INDEX));
        expansionPanels.get(Indexes.ULDUM_INDEX)
                       .setTotalCounter(saveFileData.get(Indexes.ULDUM_TOTAL_COUNTER_ROW_INDEX)
                                                    .substring(Indexes.ULDUM_COLUMN_INDEX));
        expansionPanels.get(Indexes.SHADOWS_INDEX)
                       .setTotalCounter(saveFileData.get(Indexes.SHADOWS_TOTAL_COUNTER_ROW_INDEX)
                                                    .substring(Indexes.SHADOWS_COLUMN_INDEX));
        expansionPanels.get(Indexes.RUMBLE_INDEX)
                       .setTotalCounter(saveFileData.get(Indexes.RUMBLE_TOTAL_COUNTER_ROW_INDEX)
                                                    .substring(Indexes.RUMBLE_COLUMN_INDEX));
        expansionPanels.get(Indexes.BOOMSDAY_INDEX)
                       .setTotalCounter(saveFileData.get(Indexes.BOOMSDAY_TOTAL_COUNTER_ROW_INDEX)
                                                    .substring(Indexes.BOOMSDAY_COLUMN_INDEX));
        expansionPanels.get(Indexes.WITCHWOOD_INDEX)
                       .setTotalCounter(saveFileData.get(Indexes.WITCHWOOD_TOTAL_COUNTER_ROW_INDEX)
                                                    .substring(Indexes.WITCHWOOD_COLUMN_INDEX));
        expansionPanels.get(Indexes.KOBOLDS_INDEX)
                       .setTotalCounter(saveFileData.get(Indexes.KOBOLDS_TOTAL_COUNTER_ROW_INDEX)
                                                    .substring(Indexes.KOBOLDS_COLUMN_INDEX));
        expansionPanels.get(Indexes.KNIGHTS_INDEX)
                       .setTotalCounter(saveFileData.get(Indexes.KNIGHTS_TOTAL_COUNTER_ROW_INDEX)
                                                    .substring(Indexes.KNIGHTS_COLUMN_INDEX));
        expansionPanels.get(Indexes.UNGORO_INDEX)
                       .setTotalCounter(saveFileData.get(Indexes.UNGORO_TOTAL_COUNTER_ROW_INDEX)
                                                    .substring(Indexes.UNGORO_COLUMN_INDEX));
        expansionPanels.get(Indexes.GADGETZAN_INDEX)
                       .setTotalCounter(saveFileData.get(Indexes.GADGETZAN_TOTAL_COUNTER_ROW_INDEX)
                                                    .substring(Indexes.GADGETZAN_COLUMN_INDEX));
        expansionPanels.get(Indexes.OLDGODS_INDEX)
                       .setTotalCounter(saveFileData.get(Indexes.OLDGODS_TOTAL_COUNTER_ROW_INDEX)
                                                    .substring(Indexes.OLDGODS_COLUMN_INDEX));
        expansionPanels.get(Indexes.TOURNAMENT_INDEX)
                       .setTotalCounter(saveFileData.get(Indexes.TOURNAMENT_TOTAL_COUNTER_ROW_INDEX)
                                                    .substring(Indexes.TOURNAMENT_COLUMN_INDEX));
        expansionPanels.get(Indexes.GOBLINS_INDEX)
                       .setTotalCounter(saveFileData.get(Indexes.GOBLINS_TOTAL_COUNTER_ROW_INDEX)
                                                    .substring(Indexes.GOBLINS_COLUMN_INDEX));
        expansionPanels.get(Indexes.CLASSIC_INDEX)
                       .setTotalCounter(saveFileData.get(Indexes.CLASSIC_TOTAL_COUNTER_ROW_INDEX)
                                                    .substring(Indexes.CLASSIC_COLUMN_INDEX));
    }

    /**
     * Updates and writes the epic values in the save file
     *
     * @param expansionPanels is a list containing all the expansion panels
     * @param index           is the position of an expansion in the corresponding list
     * @param counter         is the value of the counter to be updated
     * @param probability     is the value of the probability to be updated
     */
    public static void updateEpicValues(List<AbstractExpansionPanel> expansionPanels, int index, String counter, String probability) {
        switch (index) {
            case 0 -> {
                expansionPanels.get(Indexes.CLASSIC_INDEX)
                               .setEpicCounter(counter);
                saveFileData.set(Indexes.CLASSIC_EPIC_COUNTER_ROW_INDEX, saveFileExpansions.get(index) + ": " + counter);

                expansionPanels.get(Indexes.CLASSIC_INDEX)
                               .setEpicProbability(probability);
                saveFileData.set(Indexes.CLASSIC_EPIC_PROBABILITY_ROW_INDEX, saveFileExpansions.get(index) + ": " + probability);
            }
            case 1 -> {
                expansionPanels.get(Indexes.GOBLINS_INDEX)
                               .setEpicCounter(counter);
                saveFileData.set(Indexes.GOBLINS_EPIC_COUNTER_ROW_INDEX, saveFileExpansions.get(index) + ": " + counter);

                expansionPanels.get(Indexes.GOBLINS_INDEX)
                               .setEpicProbability(probability);
                saveFileData.set(Indexes.GOBLINS_EPIC_PROBABILITY_ROW_INDEX, saveFileExpansions.get(index) + ": " + probability);
            }
            case 2 -> {
                expansionPanels.get(Indexes.TOURNAMENT_INDEX)
                               .setEpicCounter(counter);
                saveFileData.set(Indexes.TOURNAMENT_EPIC_COUNTER_ROW_INDEX, saveFileExpansions.get(index) + ": " + counter);

                expansionPanels.get(Indexes.TOURNAMENT_INDEX)
                               .setEpicProbability(probability);
                saveFileData.set(Indexes.TOURNAMENT_EPIC_PROBABILITY_ROW_INDEX, saveFileExpansions.get(index) + ": " + probability);
            }
            case 3 -> {
                expansionPanels.get(Indexes.OLDGODS_INDEX)
                               .setEpicCounter(counter);
                saveFileData.set(Indexes.OLDGODS_EPIC_COUNTER_ROW_INDEX, saveFileExpansions.get(index) + ": " + counter);

                expansionPanels.get(Indexes.OLDGODS_INDEX)
                               .setEpicProbability(probability);
                saveFileData.set(Indexes.OLDGODS_EPIC_PROBABILITY_ROW_INDEX, saveFileExpansions.get(index) + ": " + probability);
            }
            case 4 -> {
                expansionPanels.get(Indexes.GADGETZAN_INDEX)
                               .setEpicCounter(counter);
                saveFileData.set(Indexes.GADGETZAN_EPIC_COUNTER_ROW_INDEX, saveFileExpansions.get(index) + ": " + counter);

                expansionPanels.get(Indexes.GADGETZAN_INDEX)
                               .setEpicProbability(probability);
                saveFileData.set(Indexes.GADGETZAN_EPIC_PROBABILITY_ROW_INDEX, saveFileExpansions.get(index) + ": " + probability);
            }
            case 5 -> {
                expansionPanels.get(Indexes.UNGORO_INDEX)
                               .setEpicCounter(counter);
                saveFileData.set(Indexes.UNGORO_EPIC_COUNTER_ROW_INDEX, saveFileExpansions.get(index) + ": " + counter);

                expansionPanels.get(Indexes.UNGORO_INDEX)
                               .setEpicProbability(probability);
                saveFileData.set(Indexes.UNGORO_EPIC_PROBABILITY_ROW_INDEX, saveFileExpansions.get(index) + ": " + probability);
            }
            case 6 -> {
                expansionPanels.get(Indexes.KNIGHTS_INDEX)
                               .setEpicCounter(counter);
                saveFileData.set(Indexes.KNIGHTS_EPIC_COUNTER_ROW_INDEX, saveFileExpansions.get(index) + ": " + counter);

                expansionPanels.get(Indexes.KNIGHTS_INDEX)
                               .setEpicProbability(probability);
                saveFileData.set(Indexes.KNIGHTS_EPIC_PROBABILITY_ROW_INDEX, saveFileExpansions.get(index) + ": " + probability);
            }
            case 7 -> {
                expansionPanels.get(Indexes.KOBOLDS_INDEX)
                               .setEpicCounter(counter);
                saveFileData.set(Indexes.KOBOLDS_EPIC_COUNTER_ROW_INDEX, saveFileExpansions.get(index) + ": " + counter);

                expansionPanels.get(Indexes.KOBOLDS_INDEX)
                               .setEpicProbability(probability);
                saveFileData.set(Indexes.KOBOLDS_EPIC_PROBABILITY_ROW_INDEX, saveFileExpansions.get(index) + ": " + probability);
            }
            case 8 -> {
                expansionPanels.get(Indexes.WITCHWOOD_INDEX)
                               .setEpicCounter(counter);
                saveFileData.set(Indexes.WITCHWOOD_EPIC_COUNTER_ROW_INDEX, saveFileExpansions.get(index) + ": " + counter);

                expansionPanels.get(Indexes.WITCHWOOD_INDEX)
                               .setEpicProbability(probability);
                saveFileData.set(Indexes.WITCHWOOD_EPIC_PROBABILITY_ROW_INDEX, saveFileExpansions.get(index) + ": " + probability);
            }
            case 9 -> {
                expansionPanels.get(Indexes.BOOMSDAY_INDEX)
                               .setEpicCounter(counter);
                saveFileData.set(Indexes.BOOMSDAY_EPIC_COUNTER_ROW_INDEX, saveFileExpansions.get(index) + ": " + counter);

                expansionPanels.get(Indexes.BOOMSDAY_INDEX)
                               .setEpicProbability(probability);
                saveFileData.set(Indexes.BOOMSDAY_EPIC_PROBABILITY_ROW_INDEX, saveFileExpansions.get(index) + ": " + probability);
            }
            case 10 -> {
                expansionPanels.get(Indexes.RUMBLE_INDEX)
                               .setEpicCounter(counter);
                saveFileData.set(Indexes.RUMBLE_EPIC_COUNTER_ROW_INDEX, saveFileExpansions.get(index) + ": " + counter);

                expansionPanels.get(Indexes.RUMBLE_INDEX)
                               .setEpicProbability(probability);
                saveFileData.set(Indexes.RUMBLE_EPIC_PROBABILITY_ROW_INDEX, saveFileExpansions.get(index) + ": " + probability);
            }
            case 11 -> {
                expansionPanels.get(Indexes.SHADOWS_INDEX)
                               .setEpicCounter(counter);
                saveFileData.set(Indexes.SHADOWS_EPIC_COUNTER_ROW_INDEX, saveFileExpansions.get(index) + ": " + counter);

                expansionPanels.get(Indexes.SHADOWS_INDEX)
                               .setEpicProbability(probability);
                saveFileData.set(Indexes.SHADOWS_EPIC_PROBABILITY_ROW_INDEX, saveFileExpansions.get(index) + ": " + probability);
            }
            case 12 -> {
                expansionPanels.get(Indexes.ULDUM_INDEX)
                               .setEpicCounter(counter);
                saveFileData.set(Indexes.ULDUM_EPIC_COUNTER_ROW_INDEX, saveFileExpansions.get(index) + ": " + counter);

                expansionPanels.get(Indexes.ULDUM_INDEX)
                               .setEpicProbability(probability);
                saveFileData.set(Indexes.ULDUM_EPIC_PROBABILITY_ROW_INDEX, saveFileExpansions.get(index) + ": " + probability);
            }
            case 13 -> {
                expansionPanels.get(Indexes.DRAGONS_INDEX)
                               .setEpicCounter(counter);
                saveFileData.set(Indexes.DRAGONS_EPIC_COUNTER_ROW_INDEX, saveFileExpansions.get(index) + ": " + counter);

                expansionPanels.get(Indexes.DRAGONS_INDEX)
                               .setEpicProbability(probability);
                saveFileData.set(Indexes.DRAGONS_EPIC_PROBABILITY_ROW_INDEX, saveFileExpansions.get(index) + ": " + probability);
            }
            case 14 -> {
                expansionPanels.get(Indexes.OUTLAND_INDEX)
                               .setEpicCounter(counter);
                saveFileData.set(Indexes.OUTLAND_EPIC_COUNTER_ROW_INDEX, saveFileExpansions.get(index) + ": " + counter);

                expansionPanels.get(Indexes.OUTLAND_INDEX)
                               .setEpicProbability(probability);
                saveFileData.set(Indexes.OUTLAND_EPIC_PROBABILITY_ROW_INDEX, saveFileExpansions.get(index) + ": " + probability);
            }
            case 15 -> {
                expansionPanels.get(Indexes.SCHOLOMANCE_INDEX)
                               .setEpicCounter(counter);
                saveFileData.set(Indexes.SCHOLOMANCE_EPIC_COUNTER_ROW_INDEX, saveFileExpansions.get(index) + ": " + counter);

                expansionPanels.get(Indexes.SCHOLOMANCE_INDEX)
                               .setEpicProbability(probability);
                saveFileData.set(Indexes.SCHOLOMANCE_EPIC_PROBABILITY_ROW_INDEX, saveFileExpansions.get(index) + ": " + probability);
            }
            case 16 -> {
                expansionPanels.get(Indexes.DARKMOON_INDEX)
                               .setEpicCounter(counter);
                saveFileData.set(Indexes.DARKMOON_EPIC_COUNTER_ROW_INDEX, saveFileExpansions.get(index) + ": " + counter);

                expansionPanels.get(Indexes.DARKMOON_INDEX)
                               .setEpicProbability(probability);
                saveFileData.set(Indexes.DARKMOON_EPIC_PROBABILITY_ROW_INDEX, saveFileExpansions.get(index) + ": " + probability);
            }
            case 17 -> {
                expansionPanels.get(Indexes.BARRENS_INDEX)
                               .setEpicCounter(counter);
                saveFileData.set(Indexes.BARRENS_EPIC_COUNTER_ROW_INDEX, saveFileExpansions.get(index) + ": " + counter);

                expansionPanels.get(Indexes.BARRENS_INDEX)
                               .setEpicProbability(probability);
                saveFileData.set(Indexes.BARRENS_EPIC_PROBABILITY_ROW_INDEX, saveFileExpansions.get(index) + ": " + probability);
            }
            case 18 -> {
                expansionPanels.get(Indexes.STORMWIND_INDEX)
                               .setEpicCounter(counter);
                saveFileData.set(Indexes.STORMWIND_EPIC_COUNTER_ROW_INDEX, saveFileExpansions.get(index) + ": " + counter);

                expansionPanels.get(Indexes.STORMWIND_INDEX)
                               .setEpicProbability(probability);
                saveFileData.set(Indexes.STORMWIND_EPIC_PROBABILITY_ROW_INDEX, saveFileExpansions.get(index) + ": " + probability);
            }
            case 19 -> {
                expansionPanels.get(Indexes.ALTERAC_INDEX)
                               .setEpicCounter(counter);
                saveFileData.set(Indexes.ALTERAC_EPIC_COUNTER_ROW_INDEX, saveFileExpansions.get(index) + ": " + counter);

                expansionPanels.get(Indexes.ALTERAC_INDEX)
                               .setEpicProbability(probability);
                saveFileData.set(Indexes.ALTERAC_EPIC_PROBABILITY_ROW_INDEX, saveFileExpansions.get(index) + ": " + probability);
            }
            default -> {
                expansionPanels.get(Indexes.SUNKEN_INDEX)
                               .setEpicCounter(counter);
                saveFileData.set(Indexes.SUNKEN_EPIC_COUNTER_ROW_INDEX, saveFileExpansions.get(index) + ": " + counter);

                expansionPanels.get(Indexes.SUNKEN_INDEX)
                               .setEpicProbability(probability);
                saveFileData.set(Indexes.SUNKEN_EPIC_PROBABILITY_ROW_INDEX, saveFileExpansions.get(index) + ": " + probability);
            }
        }

        // Write the updated data in the save file
        setWritable();
        writeSaveFile(String.join(Text.NEXT_LINE, saveFileData));
        setReadOnly();
    }

    /**
     * Updates and writes the legendary values in the save file
     *
     * @param expansionPanels is a list containing all the expansion panels
     * @param index           is the position of an expansion in the corresponding list
     * @param counter         is the value of the counter to be updated
     * @param probability     is the value of the probability to be updated
     */
    public static void updateLegendaryValues(List<AbstractExpansionPanel> expansionPanels, int index, String counter, String probability) {
        switch (index) {
            case 0 -> {
                expansionPanels.get(Indexes.CLASSIC_INDEX)
                               .setLegendaryCounter(counter);
                saveFileData.set(Indexes.CLASSIC_LEGENDARY_COUNTER_ROW_INDEX, saveFileExpansions.get(index) + ": " + counter);

                expansionPanels.get(Indexes.CLASSIC_INDEX)
                               .setLegendaryProbability(probability);
                saveFileData.set(Indexes.CLASSIC_LEGENDARY_PROBABILITY_ROW_INDEX, saveFileExpansions.get(index) + ": " + probability);
            }
            case 1 -> {
                expansionPanels.get(Indexes.GOBLINS_INDEX)
                               .setLegendaryCounter(counter);
                saveFileData.set(Indexes.GOBLINS_LEGENDARY_COUNTER_ROW_INDEX, saveFileExpansions.get(index) + ": " + counter);

                expansionPanels.get(Indexes.GOBLINS_INDEX)
                               .setLegendaryProbability(probability);
                saveFileData.set(Indexes.GOBLINS_LEGENDARY_PROBABILITY_ROW_INDEX, saveFileExpansions.get(index) + ": " + probability);
            }
            case 2 -> {
                expansionPanels.get(Indexes.TOURNAMENT_INDEX)
                               .setLegendaryCounter(counter);
                saveFileData.set(Indexes.TOURNAMENT_LEGENDARY_COUNTER_ROW_INDEX, saveFileExpansions.get(index) + ": " + counter);

                expansionPanels.get(Indexes.TOURNAMENT_INDEX)
                               .setLegendaryProbability(probability);
                saveFileData.set(Indexes.TOURNAMENT_LEGENDARY_PROBABILITY_ROW_INDEX, saveFileExpansions.get(index) + ": " + probability);
            }
            case 3 -> {
                expansionPanels.get(Indexes.OLDGODS_INDEX)
                               .setLegendaryCounter(counter);
                saveFileData.set(Indexes.OLDGODS_LEGENDARY_COUNTER_ROW_INDEX, saveFileExpansions.get(index) + ": " + counter);

                expansionPanels.get(Indexes.OLDGODS_INDEX)
                               .setLegendaryProbability(probability);
                saveFileData.set(Indexes.OLDGODS_LEGENDARY_PROBABILITY_ROW_INDEX, saveFileExpansions.get(index) + ": " + probability);
            }
            case 4 -> {
                expansionPanels.get(Indexes.GADGETZAN_INDEX)
                               .setLegendaryCounter(counter);
                saveFileData.set(Indexes.GADGETZAN_LEGENDARY_COUNTER_ROW_INDEX, saveFileExpansions.get(index) + ": " + counter);

                expansionPanels.get(Indexes.GADGETZAN_INDEX)
                               .setLegendaryProbability(probability);
                saveFileData.set(Indexes.GADGETZAN_LEGENDARY_PROBABILITY_ROW_INDEX, saveFileExpansions.get(index) + ": " + probability);
            }
            case 5 -> {
                expansionPanels.get(Indexes.UNGORO_INDEX)
                               .setLegendaryCounter(counter);
                saveFileData.set(Indexes.UNGORO_LEGENDARY_COUNTER_ROW_INDEX, saveFileExpansions.get(index) + ": " + counter);

                expansionPanels.get(Indexes.UNGORO_INDEX)
                               .setLegendaryProbability(probability);
                saveFileData.set(Indexes.UNGORO_LEGENDARY_PROBABILITY_ROW_INDEX, saveFileExpansions.get(index) + ": " + probability);
            }
            case 6 -> {
                expansionPanels.get(Indexes.KNIGHTS_INDEX)
                               .setLegendaryCounter(counter);
                saveFileData.set(Indexes.KNIGHTS_LEGENDARY_COUNTER_ROW_INDEX, saveFileExpansions.get(index) + ": " + counter);

                expansionPanels.get(Indexes.KNIGHTS_INDEX)
                               .setLegendaryProbability(probability);
                saveFileData.set(Indexes.KNIGHTS_LEGENDARY_PROBABILITY_ROW_INDEX, saveFileExpansions.get(index) + ": " + probability);
            }
            case 7 -> {
                expansionPanels.get(Indexes.KOBOLDS_INDEX)
                               .setLegendaryCounter(counter);
                saveFileData.set(Indexes.KOBOLDS_LEGENDARY_COUNTER_ROW_INDEX, saveFileExpansions.get(index) + ": " + counter);

                expansionPanels.get(Indexes.KOBOLDS_INDEX)
                               .setLegendaryProbability(probability);
                saveFileData.set(Indexes.KOBOLDS_LEGENDARY_PROBABILITY_ROW_INDEX, saveFileExpansions.get(index) + ": " + probability);
            }
            case 8 -> {
                expansionPanels.get(Indexes.WITCHWOOD_INDEX)
                               .setLegendaryCounter(counter);
                saveFileData.set(Indexes.WITCHWOOD_LEGENDARY_COUNTER_ROW_INDEX, saveFileExpansions.get(index) + ": " + counter);

                expansionPanels.get(Indexes.WITCHWOOD_INDEX)
                               .setLegendaryProbability(probability);
                saveFileData.set(Indexes.WITCHWOOD_LEGENDARY_PROBABILITY_ROW_INDEX, saveFileExpansions.get(index) + ": " + probability);
            }
            case 9 -> {
                expansionPanels.get(Indexes.BOOMSDAY_INDEX)
                               .setLegendaryCounter(counter);
                saveFileData.set(Indexes.BOOMSDAY_LEGENDARY_COUNTER_ROW_INDEX, saveFileExpansions.get(index) + ": " + counter);

                expansionPanels.get(Indexes.BOOMSDAY_INDEX)
                               .setLegendaryProbability(probability);
                saveFileData.set(Indexes.BOOMSDAY_LEGENDARY_PROBABILITY_ROW_INDEX, saveFileExpansions.get(index) + ": " + probability);
            }
            case 10 -> {
                expansionPanels.get(Indexes.RUMBLE_INDEX)
                               .setLegendaryCounter(counter);
                saveFileData.set(Indexes.RUMBLE_LEGENDARY_COUNTER_ROW_INDEX, saveFileExpansions.get(index) + ": " + counter);

                expansionPanels.get(Indexes.RUMBLE_INDEX)
                               .setLegendaryProbability(probability);
                saveFileData.set(Indexes.RUMBLE_LEGENDARY_PROBABILITY_ROW_INDEX, saveFileExpansions.get(index) + ": " + probability);
            }
            case 11 -> {
                expansionPanels.get(Indexes.SHADOWS_INDEX)
                               .setLegendaryCounter(counter);
                saveFileData.set(Indexes.SHADOWS_LEGENDARY_COUNTER_ROW_INDEX, saveFileExpansions.get(index) + ": " + counter);

                expansionPanels.get(Indexes.SHADOWS_INDEX)
                               .setLegendaryProbability(probability);
                saveFileData.set(Indexes.SHADOWS_LEGENDARY_PROBABILITY_ROW_INDEX, saveFileExpansions.get(index) + ": " + probability);
            }
            case 12 -> {
                expansionPanels.get(Indexes.ULDUM_INDEX)
                               .setLegendaryCounter(counter);
                saveFileData.set(Indexes.ULDUM_LEGENDARY_COUNTER_ROW_INDEX, saveFileExpansions.get(index) + ": " + counter);

                expansionPanels.get(Indexes.ULDUM_INDEX)
                               .setLegendaryProbability(probability);
                saveFileData.set(Indexes.ULDUM_LEGENDARY_PROBABILITY_ROW_INDEX, saveFileExpansions.get(index) + ": " + probability);
            }
            case 13 -> {
                expansionPanels.get(Indexes.DRAGONS_INDEX)
                               .setLegendaryCounter(counter);
                saveFileData.set(Indexes.DRAGONS_LEGENDARY_COUNTER_ROW_INDEX, saveFileExpansions.get(index) + ": " + counter);

                expansionPanels.get(Indexes.DRAGONS_INDEX)
                               .setLegendaryProbability(probability);
                saveFileData.set(Indexes.DRAGONS_LEGENDARY_PROBABILITY_ROW_INDEX, saveFileExpansions.get(index) + ": " + probability);
            }
            case 14 -> {
                expansionPanels.get(Indexes.OUTLAND_INDEX)
                               .setLegendaryCounter(counter);
                saveFileData.set(Indexes.OUTLAND_LEGENDARY_COUNTER_ROW_INDEX, saveFileExpansions.get(index) + ": " + counter);

                expansionPanels.get(Indexes.OUTLAND_INDEX)
                               .setLegendaryProbability(probability);
                saveFileData.set(Indexes.OUTLAND_LEGENDARY_PROBABILITY_ROW_INDEX, saveFileExpansions.get(index) + ": " + probability);
            }
            case 15 -> {
                expansionPanels.get(Indexes.SCHOLOMANCE_INDEX)
                               .setLegendaryCounter(counter);
                saveFileData.set(Indexes.SCHOLOMANCE_LEGENDARY_COUNTER_ROW_INDEX, saveFileExpansions.get(index) + ": " + counter);

                expansionPanels.get(Indexes.SCHOLOMANCE_INDEX)
                               .setLegendaryProbability(probability);
                saveFileData.set(Indexes.SCHOLOMANCE_LEGENDARY_PROBABILITY_ROW_INDEX, saveFileExpansions.get(index) + ": " + probability);
            }
            case 16 -> {
                expansionPanels.get(Indexes.DARKMOON_INDEX)
                               .setLegendaryCounter(counter);
                saveFileData.set(Indexes.DARKMOON_LEGENDARY_COUNTER_ROW_INDEX, saveFileExpansions.get(index) + ": " + counter);

                expansionPanels.get(Indexes.DARKMOON_INDEX)
                               .setLegendaryProbability(probability);
                saveFileData.set(Indexes.DARKMOON_LEGENDARY_PROBABILITY_ROW_INDEX, saveFileExpansions.get(index) + ": " + probability);
            }
            case 17 -> {
                expansionPanels.get(Indexes.BARRENS_INDEX)
                               .setLegendaryCounter(counter);
                saveFileData.set(Indexes.BARRENS_LEGENDARY_COUNTER_ROW_INDEX, saveFileExpansions.get(index) + ": " + counter);

                expansionPanels.get(Indexes.BARRENS_INDEX)
                               .setLegendaryProbability(probability);
                saveFileData.set(Indexes.BARRENS_LEGENDARY_PROBABILITY_ROW_INDEX, saveFileExpansions.get(index) + ": " + probability);
            }
            case 18 -> {
                expansionPanels.get(Indexes.STORMWIND_INDEX)
                               .setLegendaryCounter(counter);
                saveFileData.set(Indexes.STORMWIND_LEGENDARY_COUNTER_ROW_INDEX, saveFileExpansions.get(index) + ": " + counter);

                expansionPanels.get(Indexes.STORMWIND_INDEX)
                               .setLegendaryProbability(probability);
                saveFileData.set(Indexes.STORMWIND_LEGENDARY_PROBABILITY_ROW_INDEX, saveFileExpansions.get(index) + ": " + probability);
            }
            case 19 -> {
                expansionPanels.get(Indexes.ALTERAC_INDEX)
                               .setLegendaryCounter(counter);
                saveFileData.set(Indexes.ALTERAC_LEGENDARY_COUNTER_ROW_INDEX, saveFileExpansions.get(index) + ": " + counter);

                expansionPanels.get(Indexes.ALTERAC_INDEX)
                               .setLegendaryProbability(probability);
                saveFileData.set(Indexes.ALTERAC_LEGENDARY_PROBABILITY_ROW_INDEX, saveFileExpansions.get(index) + ": " + probability);
            }
            default -> {
                expansionPanels.get(Indexes.SUNKEN_INDEX)
                               .setLegendaryCounter(counter);
                saveFileData.set(Indexes.SUNKEN_LEGENDARY_COUNTER_ROW_INDEX, saveFileExpansions.get(index) + ": " + counter);

                expansionPanels.get(Indexes.SUNKEN_INDEX)
                               .setLegendaryProbability(probability);
                saveFileData.set(Indexes.SUNKEN_LEGENDARY_PROBABILITY_ROW_INDEX, saveFileExpansions.get(index) + ": " + probability);
            }
        }

        // Write the updated data in the save file
        setWritable();
        writeSaveFile(String.join(Text.NEXT_LINE, saveFileData));
        setReadOnly();
    }

    /**
     * Updates and writes the total values in the save file
     *
     * @param expansionPanels is a list containing all the expansion panels
     * @param index           is the position of an expansion in the corresponding list
     * @param counter         is the value of the counter to be updated
     */
    public static void updateTotalValues(List<AbstractExpansionPanel> expansionPanels, int index, String counter) {
        switch (index) {
            case 0 -> {
                expansionPanels.get(Indexes.CLASSIC_INDEX)
                               .setTotalCounter(counter);
                saveFileData.set(Indexes.CLASSIC_TOTAL_COUNTER_ROW_INDEX, saveFileExpansions.get(index) + ": " + counter);
            }
            case 1 -> {
                expansionPanels.get(Indexes.GOBLINS_INDEX)
                               .setTotalCounter(counter);
                saveFileData.set(Indexes.GOBLINS_TOTAL_COUNTER_ROW_INDEX, saveFileExpansions.get(index) + ": " + counter);
            }
            case 2 -> {
                expansionPanels.get(Indexes.TOURNAMENT_INDEX)
                               .setTotalCounter(counter);
                saveFileData.set(Indexes.TOURNAMENT_TOTAL_COUNTER_ROW_INDEX, saveFileExpansions.get(index) + ": " + counter);
            }
            case 3 -> {
                expansionPanels.get(Indexes.OLDGODS_INDEX)
                               .setTotalCounter(counter);
                saveFileData.set(Indexes.OLDGODS_TOTAL_COUNTER_ROW_INDEX, saveFileExpansions.get(index) + ": " + counter);
            }
            case 4 -> {
                expansionPanels.get(Indexes.GADGETZAN_INDEX)
                               .setTotalCounter(counter);
                saveFileData.set(Indexes.GADGETZAN_TOTAL_COUNTER_ROW_INDEX, saveFileExpansions.get(index) + ": " + counter);
            }
            case 5 -> {
                expansionPanels.get(Indexes.UNGORO_INDEX)
                               .setTotalCounter(counter);
                saveFileData.set(Indexes.UNGORO_TOTAL_COUNTER_ROW_INDEX, saveFileExpansions.get(index) + ": " + counter);
            }
            case 6 -> {
                expansionPanels.get(Indexes.KNIGHTS_INDEX)
                               .setTotalCounter(counter);
                saveFileData.set(Indexes.KNIGHTS_TOTAL_COUNTER_ROW_INDEX, saveFileExpansions.get(index) + ": " + counter);
            }
            case 7 -> {
                expansionPanels.get(Indexes.KOBOLDS_INDEX)
                               .setTotalCounter(counter);
                saveFileData.set(Indexes.KOBOLDS_TOTAL_COUNTER_ROW_INDEX, saveFileExpansions.get(index) + ": " + counter);
            }
            case 8 -> {
                expansionPanels.get(Indexes.WITCHWOOD_INDEX)
                               .setTotalCounter(counter);
                saveFileData.set(Indexes.WITCHWOOD_TOTAL_COUNTER_ROW_INDEX, saveFileExpansions.get(index) + ": " + counter);
            }
            case 9 -> {
                expansionPanels.get(Indexes.BOOMSDAY_INDEX)
                               .setTotalCounter(counter);
                saveFileData.set(Indexes.BOOMSDAY_TOTAL_COUNTER_ROW_INDEX, saveFileExpansions.get(index) + ": " + counter);
            }
            case 10 -> {
                expansionPanels.get(Indexes.RUMBLE_INDEX)
                               .setTotalCounter(counter);
                saveFileData.set(Indexes.RUMBLE_TOTAL_COUNTER_ROW_INDEX, saveFileExpansions.get(index) + ": " + counter);
            }
            case 11 -> {
                expansionPanels.get(Indexes.SHADOWS_INDEX)
                               .setTotalCounter(counter);
                saveFileData.set(Indexes.SHADOWS_TOTAL_COUNTER_ROW_INDEX, saveFileExpansions.get(index) + ": " + counter);
            }
            case 12 -> {
                expansionPanels.get(Indexes.ULDUM_INDEX)
                               .setTotalCounter(counter);
                saveFileData.set(Indexes.ULDUM_TOTAL_COUNTER_ROW_INDEX, saveFileExpansions.get(index) + ": " + counter);
            }
            case 13 -> {
                expansionPanels.get(Indexes.DRAGONS_INDEX)
                               .setTotalCounter(counter);
                saveFileData.set(Indexes.DRAGONS_TOTAL_COUNTER_ROW_INDEX, saveFileExpansions.get(index) + ": " + counter);
            }
            case 14 -> {
                expansionPanels.get(Indexes.OUTLAND_INDEX)
                               .setTotalCounter(counter);
                saveFileData.set(Indexes.OUTLAND_TOTAL_COUNTER_ROW_INDEX, saveFileExpansions.get(index) + ": " + counter);
            }
            case 15 -> {
                expansionPanels.get(Indexes.SCHOLOMANCE_INDEX)
                               .setTotalCounter(counter);
                saveFileData.set(Indexes.SCHOLOMANCE_TOTAL_COUNTER_ROW_INDEX, saveFileExpansions.get(index) + ": " + counter);
            }
            case 16 -> {
                expansionPanels.get(Indexes.DARKMOON_INDEX)
                               .setTotalCounter(counter);
                saveFileData.set(Indexes.DARKMOON_TOTAL_COUNTER_ROW_INDEX, saveFileExpansions.get(index) + ": " + counter);
            }
            case 17 -> {
                expansionPanels.get(Indexes.BARRENS_INDEX)
                               .setTotalCounter(counter);
                saveFileData.set(Indexes.BARRENS_TOTAL_COUNTER_ROW_INDEX, saveFileExpansions.get(index) + ": " + counter);
            }
            case 18 -> {
                expansionPanels.get(Indexes.STORMWIND_INDEX)
                               .setTotalCounter(counter);
                saveFileData.set(Indexes.STORMWIND_TOTAL_COUNTER_ROW_INDEX, saveFileExpansions.get(index) + ": " + counter);
            }
            case 19 -> {
                expansionPanels.get(Indexes.ALTERAC_INDEX)
                               .setTotalCounter(counter);
                saveFileData.set(Indexes.ALTERAC_TOTAL_COUNTER_ROW_INDEX, saveFileExpansions.get(index) + ": " + counter);
            }
            default -> {
                expansionPanels.get(Indexes.SUNKEN_INDEX)
                               .setTotalCounter(counter);
                saveFileData.set(Indexes.SUNKEN_TOTAL_COUNTER_ROW_INDEX, saveFileExpansions.get(index) + ": " + counter);
            }
        }

        // Write the updated data in the save file
        setWritable();
        writeSaveFile(String.join(Text.NEXT_LINE, saveFileData));
        setReadOnly();
    }

    /**
     * Private constructor to hide the default public one
     */
    private FileHelper() {
    }
}
