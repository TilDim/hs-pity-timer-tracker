package tildim.hstools.hspitytimertracker.util;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.FileAlreadyExistsException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.collections4.ListUtils;
import tildim.hstools.hspitytimertracker.gui.panel.expansion.AbstractExpansionPanel;
import tildim.hstools.hspitytimertracker.util.index.IndexHelper;
import tildim.hstools.hspitytimertracker.util.index.IndexType;

/**
 * {@code TextFileHelper} is a utility class that contains all the necessary methods to process the text files used by
 * the program.
 *
 * @author Tilemachos Dimos
 * @see Path
 * @see IndexHelper
 */
@Slf4j
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class TextFileHelper {

    // Save file path in the system
    public static final Path SAVE_FILE_PATH = Path.of(System.getProperty("user.home") + File.separator
            + "Documents" + File.separator + "HSPityTimerTrackerData.txt");

    private static Path saveFile;

    private static List<String> saveFileData;

    private static List<String> saveFileExpansions;

    /**
     * Creates the save file or updates it with new expansions.
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

            /* Check if the save file's text is different compared to the base text
             * If it's not, insert the new expansions in the save file
             * (Expansions are stored in descending chronological order)
             * (The names of the currently stored expansions are located after the '- Expansions' label)
             */
            if (!saveFileData.get(IndexHelper.FIRST_EXPANSION_IN_FILE_ROW_INDEX)
                             .equals(baseFileData.get(IndexHelper.FIRST_EXPANSION_IN_FILE_ROW_INDEX))) {
                // List with the expansions in the base file
                List<String> baseFileExpansions = findExpansionsInSaveFile(baseFileData);

                // List with the expansions in the save file
                List<String> saveFileExpansions = findExpansionsInSaveFile(saveFileData);

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
            log.error("Error while creating the save file");
            e.printStackTrace();
        }

        // Get the final list of the expansions in the save file (to be used for updates in the save file)
        saveFileExpansions = findExpansionsInSaveFile(saveFileData);
        // Reverse the list so the order is from newest to oldest
        Collections.reverse(saveFileExpansions);
    }

    /**
     * Reads a resource file.
     *
     * @param filePath is the resource file's path from the source root
     * @return a list with all the lines of the resource file
     */
    private static List<String> readResourceFile(String filePath) {
        try (InputStream inputStream = TextFileHelper.class.getClassLoader()
                                                           .getResourceAsStream(filePath)) {
            return new BufferedReader(
                    new InputStreamReader(Objects.requireNonNull(inputStream),
                            StandardCharsets.UTF_8)).lines()
                                                    .toList();
        } catch (IOException e) {
            log.error("Error while reading a resource file");
            e.printStackTrace();
        }

        return Collections.emptyList();
    }

    /**
     * Finds the expansions in the save file and returns them from oldest to newest.
     *
     * @param data a list with all the lines of the save file
     * @return a list of all the expansions in the save file
     */
    private static List<String> findExpansionsInSaveFile(List<String> data) {
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
     * Adds the expansions that came out since the last update of the tracker to the save file.
     *
     * @param newExpansions is a list of all the new expansions since the last update
     * @param index         is the index in the list with all the lines of the save file where the new expansions
     *                      will be inserted
     * @param label         is the label in the save file (e.g. "- Expansions") under which the new expansions
     *                      will be inserted
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
     * Returns the number of the expansions in the save file.
     *
     * @return the size of the save file expansions list
     */
    public static int numberOfExpansions() {
        return saveFileExpansions.size();
    }

    /**
     * Reads the save file.
     *
     * @param filePath is the save file's path from the system root
     * @return a list with all the lines of the save file
     */
    private static List<String> readSaveFile(Path filePath) {
        try {
            return Files.readAllLines(filePath);
        } catch (IOException e) {
            log.error("Error while reading the save file");
            e.printStackTrace();
        }

        return Collections.emptyList();
    }

    /**
     * Writes the save file.
     *
     * @param data is the data to be written in the file
     */
    private static void writeSaveFile(String data) {
        try {
            Files.writeString(saveFile, data);
        } catch (IOException e) {
            log.error("Error while writing the save file");
            e.printStackTrace();
        }
    }

    /**
     * Sets the save file as read-only.
     */
    private static void setReadOnly() {
        saveFile.toFile()
                .setReadOnly();
    }

    /**
     * Sets the save file as writable.
     */
    private static void setWritable() {
        saveFile.toFile()
                .setWritable(true);
    }

    /**
     * Reads the help text file and sets the help message.
     *
     * @return the help message
     */
    public static String setHelpMessageText() {
        return String.join(Text.NEXT_LINE, readResourceFile("text/help_text.txt"));
    }

    /**
     * Extracts from the save file and sets the tracker values.
     *
     * @param expansionPanels is a list containing all the expansion panels
     */
    public static void setTrackerValues(List<AbstractExpansionPanel> expansionPanels) {
        saveFileData = readSaveFile(saveFile);

        for (int i = 0; i < expansionPanels.size(); i++) {
            // Find the row containing the Epic counter in the save file and extract the value after ': '
            String epicCntRow = saveFileData.get(IndexHelper.calculateRowIndex(IndexType.EPIC_COUNTER, i));
            expansionPanels.get(i)
                           .setEpicCounter(epicCntRow.substring(epicCntRow.indexOf(':') + 2));

            // Find the row containing the Epic probability in the save file and extract the value after ': '
            String epicPrbRow = saveFileData.get(IndexHelper.calculateRowIndex(IndexType.EPIC_PROBABILITY, i));
            expansionPanels.get(i)
                           .setEpicProbability(epicPrbRow.substring(epicPrbRow.indexOf(':') + 2));

            // Find the row containing the Legendary counter in the save file and extract the value after ': '
            String legCntRow = saveFileData.get(IndexHelper.calculateRowIndex(IndexType.LEGENDARY_COUNTER, i));
            expansionPanels.get(i)
                           .setLegendaryCounter(legCntRow.substring(legCntRow.indexOf(':') + 2));

            // Find the row containing the Legendary probability in the save file and extract the value after ': '
            String legPrbRow = saveFileData.get(IndexHelper.calculateRowIndex(IndexType.LEGENDARY_PROBABILITY, i));
            expansionPanels.get(i)
                           .setLegendaryProbability(legPrbRow.substring(legPrbRow.indexOf(':') + 2));

            // Find the row containing the Total counter in the save file and extract the value after ': '
            String totalCntRow = saveFileData.get(IndexHelper.calculateRowIndex(IndexType.TOTAL_COUNTER, i));
            expansionPanels.get(i)
                           .setTotalCounter(totalCntRow.substring(totalCntRow.indexOf(':') + 2));
        }
    }

    /**
     * Updates and writes the epic values in the save file.
     *
     * @param expansionPanels is a list containing all the expansion panels
     * @param index           is the position of an expansion in the corresponding list
     * @param counter         is the value of the counter to be updated
     * @param probability     is the value of the probability to be updated
     */
    public static void updateEpicValues(List<AbstractExpansionPanel> expansionPanels,
                                        int index, String counter, String probability) {
        int[] rowIndexes = new int[2];

        // Select the expansion to be updated in the save file according to its index and set the save file row indexes
        rowIndexes[0] = IndexHelper.calculateRowIndex(IndexType.EPIC_COUNTER, index);
        rowIndexes[1] = IndexHelper.calculateRowIndex(IndexType.EPIC_PROBABILITY, index);

        // Update the counters
        expansionPanels.get(index)
                       .setEpicCounter(counter);
        saveFileData.set(rowIndexes[0], saveFileExpansions.get(index) + ": " + counter);

        // Update the probabilities
        expansionPanels.get(index)
                       .setEpicProbability(probability);
        saveFileData.set(rowIndexes[1], saveFileExpansions.get(index) + ": " + probability);

        // Write the updated data in the save file
        setWritable();
        writeSaveFile(String.join(Text.NEXT_LINE, saveFileData));
        setReadOnly();
    }

    /**
     * Updates and writes the legendary values in the save file.
     *
     * @param expansionPanels is a list containing all the expansion panels
     * @param index           is the position of an expansion in the corresponding list
     * @param counter         is the value of the counter to be updated
     * @param probability     is the value of the probability to be updated
     */
    public static void updateLegendaryValues(List<AbstractExpansionPanel> expansionPanels, int index,
                                             String counter, String probability) {
        int[] rowIndexes = new int[2];

        // Select the expansion to be updated in the save file according to its index and set the save file row indexes
        rowIndexes[0] = IndexHelper.calculateRowIndex(IndexType.LEGENDARY_COUNTER, index);
        rowIndexes[1] = IndexHelper.calculateRowIndex(IndexType.LEGENDARY_PROBABILITY, index);

        // Update the counters
        expansionPanels.get(index)
                       .setLegendaryCounter(counter);
        saveFileData.set(rowIndexes[0], saveFileExpansions.get(index) + ": " + counter);

        // Update the probabilities
        expansionPanels.get(index)
                       .setLegendaryProbability(probability);
        saveFileData.set(rowIndexes[1], saveFileExpansions.get(index) + ": " + probability);

        // Write the updated data in the save file
        setWritable();
        writeSaveFile(String.join(Text.NEXT_LINE, saveFileData));
        setReadOnly();
    }

    /**
     * Updates and writes the total values in the save file.
     *
     * @param expansionPanels is a list containing all the expansion panels
     * @param index           is the position of an expansion in the corresponding list
     * @param counter         is the value of the counter to be updated
     */
    public static void updateTotalValues(List<AbstractExpansionPanel> expansionPanels, int index, String counter) {
        // Select the expansion to be updated in the save file according to its index and set the save file row indexes
        int rowIndex = IndexHelper.calculateRowIndex(IndexType.TOTAL_COUNTER, index);

        // Update the counters
        expansionPanels.get(index)
                       .setTotalCounter(counter);
        saveFileData.set(rowIndex, saveFileExpansions.get(index) + ": " + counter);

        // Write the updated data in the save file
        setWritable();
        writeSaveFile(String.join(Text.NEXT_LINE, saveFileData));
        setReadOnly();
    }

}
