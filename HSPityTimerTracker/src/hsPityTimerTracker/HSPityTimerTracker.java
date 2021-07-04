/* ~ Hearthstone Pity Timer Tracker ~
 * 
 * Created by: Tilemachos D
 * October 2020
 */

package hsPityTimerTracker;

import java.awt.Color;
import java.awt.Container;
import java.awt.Cursor;
import java.awt.Desktop;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.net.URI;
import java.net.URL;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Scanner;

import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextPane;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.text.BadLocationException;
import javax.swing.text.SimpleAttributeSet;
import javax.swing.text.StyleConstants;
import javax.swing.text.StyledDocument;

public class HSPityTimerTracker implements ActionListener
{
	// Variables
	
	// Task bar icon
	private static BufferedImage trackerIcon;
	private static URL trackerIconURL;
	private final static String trackerIconPath = "counter_icon.png";
	
	// Tracker Window
	private static JFrame trackerWindow;
	private static Container contentPane;
	private static TrackerGUI tracker;
	private static JPanel trackerWindowContentPanel;
	
	// Tracker Window title
	private final static String trackerTitle = "Hearthstone Pity Timer Tracker";
	
	// Save file
	private String saveFilePath;
	private final String saveFileFolder = System.getProperty("user.home") + File.separator + "Documents";
	private final String saveFileName = "HSPityTimerTrackerData.txt";
	
	private File saveFile;
	
	private FileWriter saveFileWriter;
	private Scanner saveFileReader;
	
	private String saveFileData;
	private String[] saveFileTokens;
	
	private final String nextLine = System.getProperty("line.separator");
	
	// Base text (The text written in the save file when it is created for the first time)
	private final String baseText = "(WARNING! DO NOT MODIFY THIS FILE BY YOURSELF OR THE PROGRAM MIGHT NOT WORK PROPERLY AND YOU MAY LOSE YOUR TRACKER'S DATA)" + nextLine + 
			nextLine + 
			"~ Hearthstone Pity Timer Tracker ~" + nextLine + 
			nextLine + 
			"- Expansions" + nextLine + 
			"United in Stormwind" + nextLine + 
			"Forged in the Barrens" + nextLine + 
			"Madness at the Darkmoon Faire" + nextLine + 
			"Scholomance Academy" + nextLine + 
			"Ashes of Outland" + nextLine + 
			"Descent of Dragons" + nextLine + 
			"Saviors of Uldum" + nextLine + 
			"Rise of Shadows" + nextLine + 
			"Rastakhan's Rumble" + nextLine + 
			"The Boomsday Project" + nextLine + 
			"The Witchwood" + nextLine + 
			"Kobolds & Catacombs" + nextLine + 
			"Knights of the Frozen Throne" + nextLine + 
			"Journey to Un'Goro" + nextLine + 
			"Mean Streets of Gadgetzan" + nextLine + 
			"Whispers of the Old Gods" + nextLine + 
			"The Grand Tournament" + nextLine + 
			"Goblins vs Gnomes" + nextLine + 
			"Classic" + nextLine + 
			nextLine + 
			"----------" + nextLine + 
			nextLine + 
			"- Epic counters" + nextLine + 
			"United in Stormwind: 0" + nextLine + 
			"Forged in the Barrens: 0" + nextLine + 
			"Madness at the Darkmoon Faire: 0" + nextLine + 
			"Scholomance Academy: 0" + nextLine + 
			"Ashes of Outland: 0" + nextLine + 
			"Descent of Dragons: 0" + nextLine + 
			"Saviors of Uldum: 0" + nextLine + 
			"Rise of Shadows: 0" + nextLine + 
			"Rastakhan's Rumble: 0" + nextLine + 
			"The Boomsday Project: 0" + nextLine + 
			"The Witchwood: 0" + nextLine + 
			"Kobolds & Catacombs: 0" + nextLine + 
			"Knights of the Frozen Throne: 0" + nextLine + 
			"Journey to Un'Goro: 0" + nextLine + 
			"Mean Streets of Gadgetzan: 0" + nextLine + 
			"Whispers of the Old Gods: 0" + nextLine + 
			"The Grand Tournament: 0" + nextLine + 
			"Goblins vs Gnomes: 0" + nextLine + 
			"Classic: 0" + nextLine + 
			nextLine + 
			"- Epic probabilities" + nextLine + 
			"United in Stormwind: 0" + nextLine + 
			"Forged in the Barrens: 0" + nextLine + 
			"Madness at the Darkmoon Faire: 0" + nextLine + 
			"Scholomance Academy: 0" + nextLine + 
			"Ashes of Outland: 0" + nextLine + 
			"Descent of Dragons: 0" + nextLine + 
			"Saviors of Uldum: 0" + nextLine + 
			"Rise of Shadows: 0" + nextLine + 
			"Rastakhan's Rumble: 0" + nextLine + 
			"The Boomsday Project: 0" + nextLine + 
			"The Witchwood: 0" + nextLine + 
			"Kobolds & Catacombs: 0" + nextLine + 
			"Knights of the Frozen Throne: 0" + nextLine + 
			"Journey to Un'Goro: 0" + nextLine + 
			"Mean Streets of Gadgetzan: 0" + nextLine + 
			"Whispers of the Old Gods: 0" + nextLine + 
			"The Grand Tournament: 0" + nextLine + 
			"Goblins vs Gnomes: 0" + nextLine + 
			"Classic: 0" + nextLine + 
			nextLine + 
			"----------" + nextLine + 
			nextLine + 
			"- Legendary counters" + nextLine + 
			"United in Stormwind: 0" + nextLine + 
			"Forged in the Barrens: 0" + nextLine + 
			"Madness at the Darkmoon Faire: 0" + nextLine + 
			"Scholomance Academy: 0" + nextLine + 
			"Ashes of Outland: 0" + nextLine + 
			"Descent of Dragons: 0" + nextLine + 
			"Saviors of Uldum: 0" + nextLine + 
			"Rise of Shadows: 0" + nextLine + 
			"Rastakhan's Rumble: 0" + nextLine + 
			"The Boomsday Project: 0" + nextLine + 
			"The Witchwood: 0" + nextLine + 
			"Kobolds & Catacombs: 0" + nextLine + 
			"Knights of the Frozen Throne: 0" + nextLine + 
			"Journey to Un'Goro: 0" + nextLine + 
			"Mean Streets of Gadgetzan: 0" + nextLine + 
			"Whispers of the Old Gods: 0" + nextLine + 
			"The Grand Tournament: 0" + nextLine + 
			"Goblins vs Gnomes: 0" + nextLine + 
			"Classic: 0" + nextLine + 
			nextLine + 
			"- Legendary probabilities" + nextLine + 
			"United in Stormwind: 0" + nextLine + 
			"Forged in the Barrens: 0" + nextLine + 
			"Madness at the Darkmoon Faire: 0" + nextLine + 
			"Scholomance Academy: 0" + nextLine + 
			"Ashes of Outland: 0" + nextLine + 
			"Descent of Dragons: 0" + nextLine + 
			"Saviors of Uldum: 0" + nextLine + 
			"Rise of Shadows: 0" + nextLine + 
			"Rastakhan's Rumble: 0" + nextLine + 
			"The Boomsday Project: 0" + nextLine + 
			"The Witchwood: 0" + nextLine + 
			"Kobolds & Catacombs: 0" + nextLine + 
			"Knights of the Frozen Throne: 0" + nextLine + 
			"Journey to Un'Goro: 0" + nextLine + 
			"Mean Streets of Gadgetzan: 0" + nextLine + 
			"Whispers of the Old Gods: 0" + nextLine + 
			"The Grand Tournament: 0" + nextLine + 
			"Goblins vs Gnomes: 0" + nextLine + 
			"Classic: 0" + nextLine + 
			nextLine + 
			"----------" + nextLine + 
			nextLine + 
			"- Total counters" + nextLine + 
			"United in Stormwind: 0" + nextLine + 
			"Forged in the Barrens: 0" + nextLine + 
			"Madness at the Darkmoon Faire: 0" + nextLine + 
			"Scholomance Academy: 0" + nextLine + 
			"Ashes of Outland: 0" + nextLine + 
			"Descent of Dragons: 0" + nextLine + 
			"Saviors of Uldum: 0" + nextLine + 
			"Rise of Shadows: 0" + nextLine + 
			"Rastakhan's Rumble: 0" + nextLine + 
			"The Boomsday Project: 0" + nextLine + 
			"The Witchwood: 0" + nextLine + 
			"Kobolds & Catacombs: 0" + nextLine + 
			"Knights of the Frozen Throne: 0" + nextLine + 
			"Journey to Un'Goro: 0" + nextLine + 
			"Mean Streets of Gadgetzan: 0" + nextLine + 
			"Whispers of the Old Gods: 0" + nextLine + 
			"The Grand Tournament: 0" + nextLine + 
			"Goblins vs Gnomes: 0" + nextLine + 
			"Classic: 0";
	
	// Format in which the probabilities values are displayed
	NumberFormat nf;
	
	// Pop-up windows background color
	private Color popUpColor;
	
	// Variables for changing text style of the pop-up windows
	private StyledDocument doc;
	private SimpleAttributeSet set;
	
	// "Help" pop-up window
	private JPanel helpPanel;
	private JScrollPane helpMessagePanel;
	private final String helpTitle = "Help";
	private JTextPane helpMessageTitle;
	private JTextPane helpMessage;
	private final String helpMessageTitleText = "Hearthstone Pity Timer Tracker" + nextLine;
	private final String helpMessageText = "What is a pity timer?" + nextLine
			+ "When you open card packs in Hearthstone, you are guaranteed to find an epic card within 10 packs and a legendary one within 40. "
			+ "This is called a pity timer and there is one for each expansion." + nextLine + nextLine
			+ "This program has a pity timer tracker for both epic and legendary cards of every expansion "
			+ "and a total card packs counter for each expansion to keep track of how many packs you have opened." + nextLine + nextLine
			+ "How it works:" + nextLine + nextLine
			+ "For each expansion there is a dedicated panel containing:" + nextLine
			+ "1) The icon of the expansion, which is a link to the expansion's official webpage (except 'Classic')" + nextLine
			+ "2) A pity timer tracker for epic cards with buttons to modify the tracker "
			+ "and a label displaying the probability of finding an epic card in the next pack" + nextLine
			+ "3) A pity timer tracker for legendary cards with buttons to modify the tracker "
			+ "and a label displaying the probability of finding a legendary card in the next pack" + nextLine
			+ "4) A total card packs counter with buttons and fields to modify the counter "
			+ "and four buttons, each one being a link to the expansion's 'Common', 'Rare', 'Epic' and 'Legendary' cards webpage respectively" + nextLine + nextLine
			+ "'Wild' sets are hidden by default. You can switch between 'Standard' and 'Wild' sets by pressing the 'Standard Sets' and 'Wild Sets' "
			+ "buttons respectively." + nextLine
			+ "Whenever either of these buttons is pressed, some buttons corresponding to the Hearthstone years will be displayed. "
			+ "These buttons work as shortcuts and when you press them, you are instantly shown the respective year's expansions. "
			+ "(This is especially helpful in 'Wild', where there are many more sets and it takes a bit longer to navigate through the panels.)"  + nextLine + nextLine
			+ "Every number on the tracker (pity timers, probabilities, pack totals) is stored in a file located in the 'Documents' folder "
			+ "and you can locate it easily in your system by pressing the folder icon on the top right." + nextLine
			+ "If you want to back up the data of your tracker or move it to another system, just copy this file." + nextLine
			+ "It is also very important to keep a back-up of this file in another folder on your system in case the file is overwritten improperly "
			+ "when a newer version of the program is executed for the first time. This is a rare case, but it could happen due to a bug "
			+ "or a change in the structure of the file. In the latter case, you will be notified in time." + nextLine
			+ "(Warning! Do not modify this file by yourself or the program might not work properly and you may lose your tracker's data. "
			+ "For this reason, the file is in read-only mode.)" + nextLine 
			+ "(Attention! This program will not open if you have changed the default 'Documents' folder in your system.)" + nextLine + nextLine
			+ "More details on the modify buttons and fields:" + nextLine
			+ "Reset:   Sets the tracker value to '0'" + nextLine
			+ "+:   Sets the tracker value according to the value of the field on its right" + nextLine
			+ "Number field:   The number of packs to be added to the tracker when pressing '+' (deafult is 1)" + nextLine
			+ "Modify:   Opens a pop-up window in which you can enter the number of packs you have opened manually" + nextLine
			+ "               (it does not add to the counter, it sets the counter value to the input number)" + nextLine + nextLine
			+ "Note: " + nextLine
			+ "The probability of finding an epic or a legendary card in the next pack is not calculated based on statistical data from Hearthstone or other users, "
			+ "so it might not be so accurate. " + nextLine
			+ "It is just the result of this probability formula: 1 / (pity - counter) * 100, " + nextLine
			+ "where pity is the pity timer and counter the number of packs currently opened. " + nextLine
			+ "For example, if you have opened 6 packs and have not found a legendary card, the probability of finding one in the next pack is "
			+ "1 / (40 - 6) * 100 = 2.94%." + nextLine + nextLine
			+ "Created by: Tilemachos D                                                                                                    October 2020";
	
	// Increment error message pop-up window
	private final String incrementErrorTitle = "Input error";
	private JTextPane incrementErrorMessage;
	private final String incrementErrorMessageText = "The counter exceeded the pity timer while trying to add the number you entered" + nextLine + nextLine
			+ "Try the following:" + nextLine
			+ "1) Check if the number you entered is correct" + nextLine
			+ "2) Reset the counter, if this is the number you want to enter";
	
	// Modify pop-up window
	private JTextPane modifyWindow;
	private final String modifyWindowText = "Total amount of card packs opened:";
	private String modifyValue;
	
	// "Help" button
	private JButton help;
		
	// "Show save file" button
	private JButton showSaveFileFolder;
	
	// Game Modes switch buttons
	private JButton standardButton;
	private JButton wildButton;
	
	// Mode buttons colors
	private Color setsColor;
	private Color setsHoverColor;
	private Color setsSelectedColor;
	
	// Mode panels
	private JPanel standard;
	private JPanel wild;
	
	// Years shortcut buttons panels
	private JPanel standardYearsShortcutsPanel;
	private JPanel wildYearsShortcutsPanel;
	
	// Years shortcut buttons
	ArrayList<JButton> shortcutButtons;
	
	private JButton gryphonShortcut;
	private JButton phoenixShortcut;
	private JButton dragonShortcut;
	private JButton ravenShortcut;
	private JButton mammothShortcut;
	private JButton krakenShortcut;
	private JButton classicSetsShortcut;
	
	// Years panels
	private JPanel gryphon;
	private JPanel phoenix;
	private JPanel dragon;
	private JPanel raven;
	private JPanel mammoth;
	private JPanel kraken;
	private JPanel classicSets;
	
	// Expansions image buttons
	ArrayList<JButton> imageButtons;
	
	private JButton stormwindImage;
	private JButton barrensImage;
	private JButton darkmoonImage;
	private JButton scholomanceImage;
	private JButton outlandImage;
	private JButton dragonsImage;
	private JButton uldumImage;
	private JButton shadowsImage;
	private JButton rumbleImage;
	private JButton boomsdayImage;
	private JButton witchwoodImage;
	private JButton koboldsImage;
	private JButton knightsImage;
	private JButton ungoroImage;
	private JButton gadgetzanImage;
	private JButton oldGodsImage;
	private JButton tournamentImage;
	private JButton goblinsImage;
	
	// Expansions webpages links
	ArrayList<URI> imageButtonsUrls;
	
	private URI stormwindUrl;
	private URI barrensUrl;
	private URI darkmoonUrl;
	private URI scholomanceUrl;
	private URI outlandUrl;
	private URI dragonsUrl;
	private URI uldumUrl;
	private URI shadowsUrl;
	private URI rumbleUrl;
	private URI boomsdayUrl;
	private URI witchwoodUrl;
	private URI koboldsUrl;
	private URI knightsUrl;
	private URI ungoroUrl;
	private URI gadgetzanUrl;
	private URI oldGodsUrl;
	private URI tournamentUrl;
	private URI goblinsUrl;
	
	private final String stormwindUrlText = "https://playhearthstone.com/en-us/expansions-adventures/united-in-stormwind";
	private final String barrensUrlText = "https://playhearthstone.com/en-us/expansions-adventures/forged-in-the-barrens";
	private final String darkmoonUrlText = "https://playhearthstone.com/en-us/expansions-adventures/madness-at-the-darkmoon-faire";
	private final String scholomanceUrlText = "https://playhearthstone.com/en-us/expansions-adventures/scholomance-academy";
	private final String outlandUrlText = "https://playhearthstone.com/en-us/expansions-adventures/ashes-of-outland";
	private final String dragonsUrlText = "https://playhearthstone.com/en-us/expansions-adventures/descent-of-dragons";
	private final String uldumUrlText = "https://playhearthstone.com/en-us/expansions-adventures/saviors-of-uldum";
	private final String shadowsUrlText = "https://playhearthstone.com/en-us/expansions-adventures/rise-of-shadows";
	private final String rumbleUrlText = "https://playhearthstone.com/en-us/expansions-adventures/rastakhans-rumble";
	private final String boomsdayUrlText = "https://playhearthstone.com/en-us/expansions-adventures/the-boomsday-project";
	private final String witchwoodUrlText = "https://playhearthstone.com/en-us/expansions-adventures/the-witchwood";
	private final String koboldsUrlText = "https://playhearthstone.com/en-us/expansions-adventures/kobolds-and-catacombs";
	private final String knightsUrlText = "https://playhearthstone.com/en-us/expansions-adventures/knights-of-the-frozen-throne";
	private final String ungoroUrlText = "https://playhearthstone.com/en-us/expansions-adventures/journey-to-ungoro";
	private final String gadgetzanUrlText = "https://playhearthstone.com/en-us/expansions-adventures/mean-streets-of-gadgetzan";
	private final String oldGodsUrlText = "https://playhearthstone.com/en-us/expansions-adventures/whispers-of-the-old-gods";
	private final String tournamentUrlText = "https://playhearthstone.com/en-us/expansions-adventures/the-grand-tournament";
	private final String goblinsUrlText = "https://playhearthstone.com/en-us/expansions-adventures/goblins-vs-gnomes";
	
	// Epic packs counters (Labels showing the current amount of packs opened without finding an epic card from each expansion)
	private int stormwindEpicCounter;
	private int barrensEpicCounter;
	private int darkmoonEpicCounter;
	private int scholomanceEpicCounter;
	private int outlandEpicCounter;
	private int dragonsEpicCounter;
	private int uldumEpicCounter;
	private int shadowsEpicCounter;
	private int rumbleEpicCounter;
	private int boomsdayEpicCounter;
	private int witchwoodEpicCounter;
	private int koboldsEpicCounter;
	private int knightsEpicCounter;
	private int ungoroEpicCounter;
	private int gadgetzanEpicCounter;
	private int oldGodsEpicCounter;
	private int tournamentEpicCounter;
	private int goblinsEpicCounter;
	private int classicEpicCounter;
	
	// Epic probabilities (Labels showing the probability of finding an epic card from each expansion)
	private double stormwindEpicProbability;
	private double barrensEpicProbability;
	private double darkmoonEpicProbability;
	private double scholomanceEpicProbability;
	private double outlandEpicProbability;
	private double dragonsEpicProbability;
	private double uldumEpicProbability;
	private double shadowsEpicProbability;
	private double rumbleEpicProbability;
	private double boomsdayEpicProbability;
	private double witchwoodEpicProbability;
	private double koboldsEpicProbability;
	private double knightsEpicProbability;
	private double ungoroEpicProbability;
	private double gadgetzanEpicProbability;
	private double oldGodsEpicProbability;
	private double tournamentEpicProbability;
	private double goblinsEpicProbability;
	private double classicEpicProbability;
	
	// Epic counters modify buttons
	// Reset buttons
	ArrayList<ModifierButton> epicResetButtons;
	
	private ModifierButton stormwindEpicReset;
	private ModifierButton barrensEpicReset;
	private ModifierButton darkmoonEpicReset;
	private ModifierButton scholomanceEpicReset;
	private ModifierButton outlandEpicReset;
	private ModifierButton dragonsEpicReset;
	private ModifierButton uldumEpicReset;
	private ModifierButton shadowsEpicReset;
	private ModifierButton rumbleEpicReset;
	private ModifierButton boomsdayEpicReset;
	private ModifierButton witchwoodEpicReset;
	private ModifierButton koboldsEpicReset;
	private ModifierButton knightsEpicReset;
	private ModifierButton ungoroEpicReset;
	private ModifierButton gadgetzanEpicReset;
	private ModifierButton oldGodsEpicReset;
	private ModifierButton tournamentEpicReset;
	private ModifierButton goblinsEpicReset;
	private ModifierButton classicEpicReset;
	
	// Add buttons
	ArrayList<RoundButton> epicAddButtons;
	
	private RoundButton stormwindEpicAdd;
	private RoundButton barrensEpicAdd;
	private RoundButton darkmoonEpicAdd;
	private RoundButton scholomanceEpicAdd;
	private RoundButton outlandEpicAdd;
	private RoundButton dragonsEpicAdd;
	private RoundButton uldumEpicAdd;
	private RoundButton shadowsEpicAdd;
	private RoundButton rumbleEpicAdd;
	private RoundButton boomsdayEpicAdd;
	private RoundButton witchwoodEpicAdd;
	private RoundButton koboldsEpicAdd;
	private RoundButton knightsEpicAdd;
	private RoundButton ungoroEpicAdd;
	private RoundButton gadgetzanEpicAdd;
	private RoundButton oldGodsEpicAdd;
	private RoundButton tournamentEpicAdd;
	private RoundButton goblinsEpicAdd;
	private RoundButton classicEpicAdd;
	
	// Increment fields
	private JTextArea stormwindEpicIncrement;
	private JTextArea barrensEpicIncrement;
	private JTextArea darkmoonEpicIncrement;
	private JTextArea scholomanceEpicIncrement;
	private JTextArea outlandEpicIncrement;
	private JTextArea dragonsEpicIncrement;
	private JTextArea uldumEpicIncrement;
	private JTextArea shadowsEpicIncrement;
	private JTextArea rumbleEpicIncrement;
	private JTextArea boomsdayEpicIncrement;
	private JTextArea witchwoodEpicIncrement;
	private JTextArea koboldsEpicIncrement;
	private JTextArea knightsEpicIncrement;
	private JTextArea ungoroEpicIncrement;
	private JTextArea gadgetzanEpicIncrement;
	private JTextArea oldGodsEpicIncrement;
	private JTextArea tournamentEpicIncrement;
	private JTextArea goblinsEpicIncrement;
	private JTextArea classicEpicIncrement;
	
	// Legendary packs counters (Labels showing the current amount of packs opened without finding a legendary card from each expansion)
	private int stormwindLegendaryCounter;
	private int barrensLegendaryCounter;
	private int darkmoonLegendaryCounter;
	private int scholomanceLegendaryCounter;
	private int outlandLegendaryCounter;
	private int dragonsLegendaryCounter;
	private int uldumLegendaryCounter;
	private int shadowsLegendaryCounter;
	private int rumbleLegendaryCounter;
	private int boomsdayLegendaryCounter;
	private int witchwoodLegendaryCounter;
	private int koboldsLegendaryCounter;
	private int knightsLegendaryCounter;
	private int ungoroLegendaryCounter;
	private int gadgetzanLegendaryCounter;
	private int oldGodsLegendaryCounter;
	private int tournamentLegendaryCounter;
	private int goblinsLegendaryCounter;
	private int classicLegendaryCounter;
	
	// Legendary probabilities (Labels showing the probability of finding a legendary card from each expansion)
	private double stormwindLegendaryProbability;
	private double barrensLegendaryProbability;
	private double darkmoonLegendaryProbability;
	private double scholomanceLegendaryProbability;
	private double outlandLegendaryProbability;
	private double dragonsLegendaryProbability;
	private double uldumLegendaryProbability;
	private double shadowsLegendaryProbability;
	private double rumbleLegendaryProbability;
	private double boomsdayLegendaryProbability;
	private double witchwoodLegendaryProbability;
	private double koboldsLegendaryProbability;
	private double knightsLegendaryProbability;
	private double ungoroLegendaryProbability;
	private double gadgetzanLegendaryProbability;
	private double oldGodsLegendaryProbability;
	private double tournamentLegendaryProbability;
	private double goblinsLegendaryProbability;
	private double classicLegendaryProbability;
	
	// Legendary counters modify buttons
	// Reset buttons
	ArrayList<ModifierButton> legendaryResetButtons;
	
	private ModifierButton stormwindLegendaryReset;
	private ModifierButton barrensLegendaryReset;
	private ModifierButton darkmoonLegendaryReset;
	private ModifierButton scholomanceLegendaryReset;
	private ModifierButton outlandLegendaryReset;
	private ModifierButton dragonsLegendaryReset;
	private ModifierButton uldumLegendaryReset;
	private ModifierButton shadowsLegendaryReset;
	private ModifierButton rumbleLegendaryReset;
	private ModifierButton boomsdayLegendaryReset;
	private ModifierButton witchwoodLegendaryReset;
	private ModifierButton koboldsLegendaryReset;
	private ModifierButton knightsLegendaryReset;
	private ModifierButton ungoroLegendaryReset;
	private ModifierButton gadgetzanLegendaryReset;
	private ModifierButton oldGodsLegendaryReset;
	private ModifierButton tournamentLegendaryReset;
	private ModifierButton goblinsLegendaryReset;
	private ModifierButton classicLegendaryReset;
	
	// Add buttons
	ArrayList<RoundButton> legendaryAddButtons;
	
	private RoundButton stormwindLegendaryAdd;
	private RoundButton barrensLegendaryAdd;
	private RoundButton darkmoonLegendaryAdd;
	private RoundButton scholomanceLegendaryAdd;
	private RoundButton outlandLegendaryAdd;
	private RoundButton dragonsLegendaryAdd;
	private RoundButton uldumLegendaryAdd;
	private RoundButton shadowsLegendaryAdd;
	private RoundButton rumbleLegendaryAdd;
	private RoundButton boomsdayLegendaryAdd;
	private RoundButton witchwoodLegendaryAdd;
	private RoundButton koboldsLegendaryAdd;
	private RoundButton knightsLegendaryAdd;
	private RoundButton ungoroLegendaryAdd;
	private RoundButton gadgetzanLegendaryAdd;
	private RoundButton oldGodsLegendaryAdd;
	private RoundButton tournamentLegendaryAdd;
	private RoundButton goblinsLegendaryAdd;
	private RoundButton classicLegendaryAdd;
	
	// Increment fields
	private JTextArea stormwindLegendaryIncrement;
	private JTextArea barrensLegendaryIncrement;
	private JTextArea darkmoonLegendaryIncrement;
	private JTextArea scholomanceLegendaryIncrement;
	private JTextArea outlandLegendaryIncrement;
	private JTextArea dragonsLegendaryIncrement;
	private JTextArea uldumLegendaryIncrement;
	private JTextArea shadowsLegendaryIncrement;
	private JTextArea rumbleLegendaryIncrement;
	private JTextArea boomsdayLegendaryIncrement;
	private JTextArea witchwoodLegendaryIncrement;
	private JTextArea koboldsLegendaryIncrement;
	private JTextArea knightsLegendaryIncrement;
	private JTextArea ungoroLegendaryIncrement;
	private JTextArea gadgetzanLegendaryIncrement;
	private JTextArea oldGodsLegendaryIncrement;
	private JTextArea tournamentLegendaryIncrement;
	private JTextArea goblinsLegendaryIncrement;
	private JTextArea classicLegendaryIncrement;
	
	// Total Packs counters (Labels showing the total amount of packs opened from each expansion)
	private int stormwindTotalCounter;
	private int barrensTotalCounter;
	private int darkmoonTotalCounter;
	private int scholomanceTotalCounter;
	private int outlandTotalCounter;
	private int dragonsTotalCounter;
	private int uldumTotalCounter;
	private int shadowsTotalCounter;
	private int rumbleTotalCounter;
	private int boomsdayTotalCounter;
	private int witchwoodTotalCounter;
	private int koboldsTotalCounter;
	private int knightsTotalCounter;
	private int ungoroTotalCounter;
	private int gadgetzanTotalCounter;
	private int oldGodsTotalCounter;
	private int tournamentTotalCounter;
	private int goblinsTotalCounter;
	private int classicTotalCounter;
	
	// Total counters modify buttons
	// Modify buttons
	ArrayList<ModifierButton> totalModifyButtons;
	
	private ModifierButton stormwindTotalModify;
	private ModifierButton barrensTotalModify;
	private ModifierButton darkmoonTotalModify;
	private ModifierButton scholomanceTotalModify;
	private ModifierButton outlandTotalModify;
	private ModifierButton dragonsTotalModify;
	private ModifierButton uldumTotalModify;
	private ModifierButton shadowsTotalModify;
	private ModifierButton rumbleTotalModify;
	private ModifierButton boomsdayTotalModify;
	private ModifierButton witchwoodTotalModify;
	private ModifierButton koboldsTotalModify;
	private ModifierButton knightsTotalModify;
	private ModifierButton ungoroTotalModify;
	private ModifierButton gadgetzanTotalModify;
	private ModifierButton oldGodsTotalModify;
	private ModifierButton tournamentTotalModify;
	private ModifierButton goblinsTotalModify;
	private ModifierButton classicTotalModify;
	
	// Add buttons
	ArrayList<RoundButton> totalAddButtons;
	
	private RoundButton stormwindTotalAdd;
	private RoundButton barrensTotalAdd;
	private RoundButton darkmoonTotalAdd;
	private RoundButton scholomanceTotalAdd;
	private RoundButton outlandTotalAdd;
	private RoundButton dragonsTotalAdd;
	private RoundButton uldumTotalAdd;
	private RoundButton shadowsTotalAdd;
	private RoundButton rumbleTotalAdd;
	private RoundButton boomsdayTotalAdd;
	private RoundButton witchwoodTotalAdd;
	private RoundButton koboldsTotalAdd;
	private RoundButton knightsTotalAdd;
	private RoundButton ungoroTotalAdd;
	private RoundButton gadgetzanTotalAdd;
	private RoundButton oldGodsTotalAdd;
	private RoundButton tournamentTotalAdd;
	private RoundButton goblinsTotalAdd;
	private RoundButton classicTotalAdd;
	
	// Increment fields
	private JTextArea stormwindTotalIncrement;
	private JTextArea barrensTotalIncrement;
	private JTextArea darkmoonTotalIncrement;
	private JTextArea scholomanceTotalIncrement;
	private JTextArea outlandTotalIncrement;
	private JTextArea dragonsTotalIncrement;
	private JTextArea uldumTotalIncrement;
	private JTextArea shadowsTotalIncrement;
	private JTextArea rumbleTotalIncrement;
	private JTextArea boomsdayTotalIncrement;
	private JTextArea witchwoodTotalIncrement;
	private JTextArea koboldsTotalIncrement;
	private JTextArea knightsTotalIncrement;
	private JTextArea ungoroTotalIncrement;
	private JTextArea gadgetzanTotalIncrement;
	private JTextArea oldGodsTotalIncrement;
	private JTextArea tournamentTotalIncrement;
	private JTextArea goblinsTotalIncrement;
	private JTextArea classicTotalIncrement;
	
	// Rarity buttons
	// Common buttons
	ArrayList<IconButton> commonButtons;
	
	private IconButton stormwindCommonButton;
	private IconButton barrensCommonButton;
	private IconButton darkmoonCommonButton;
	private IconButton scholomanceCommonButton;
	private IconButton outlandCommonButton;
	private IconButton dragonsCommonButton;
	private IconButton uldumCommonButton;
	private IconButton shadowsCommonButton;
	private IconButton rumbleCommonButton;
	private IconButton boomsdayCommonButton;
	private IconButton witchwoodCommonButton;
	private IconButton koboldsCommonButton;
	private IconButton knightsCommonButton;
	private IconButton ungoroCommonButton;
	private IconButton gadgetzanCommonButton;
	private IconButton oldGodsCommonButton;
	private IconButton tournamentCommonButton;
	private IconButton goblinsCommonButton;
	private IconButton classicCommonButton;
	
	// Expansions common cards webpages links
	ArrayList<URI> commonButtonsUrls;
	
	private URI stormwindCommonUrl;
	private URI barrensCommonUrl;
	private URI darkmoonCommonUrl;
	private URI scholomanceCommonUrl;
	private URI outlandCommonUrl;
	private URI dragonsCommonUrl;
	private URI uldumCommonUrl;
	private URI shadowsCommonUrl;
	private URI rumbleCommonUrl;
	private URI boomsdayCommonUrl;
	private URI witchwoodCommonUrl;
	private URI koboldsCommonUrl;
	private URI knightsCommonUrl;
	private URI ungoroCommonUrl;
	private URI gadgetzanCommonUrl;
	private URI oldGodsCommonUrl;
	private URI tournamentCommonUrl;
	private URI goblinsCommonUrl;
	private URI classicCommonUrl;
	
	private final String stormwindCommonUrlText = "https://playhearthstone.com/en-us/cards?rarity=common&set=united-in-stormwind";
	private final String barrensCommonUrlText = "https://playhearthstone.com/en-us/cards?rarity=common&set=forged-in-the-barrens";
	private final String darkmoonCommonUrlText = "https://playhearthstone.com/en-us/cards?rarity=common&set=madness-at-the-darkmoon-faire";
	private final String scholomanceCommonUrlText = "https://playhearthstone.com/en-us/cards?rarity=common&set=scholomance-academy";
	private final String outlandCommonUrlText = "https://playhearthstone.com/en-us/cards?rarity=common&set=ashes-of-outland";
	private final String dragonsCommonUrlText = "https://playhearthstone.com/en-us/cards?rarity=common&set=descent-of-dragons";
	private final String uldumCommonUrlText = "https://playhearthstone.com/en-us/cards?rarity=common&set=saviors-of-uldum";
	private final String shadowsCommonUrlText = "https://playhearthstone.com/en-us/cards?rarity=common&set=rise-of-shadows";
	private final String rumbleCommonUrlText = "https://playhearthstone.com/en-us/cards?rarity=common&set=rastakhans-rumble";
	private final String boomsdayCommonUrlText = "https://playhearthstone.com/en-us/cards?rarity=common&set=the-boomsday-project";
	private final String witchwoodCommonUrlText = "https://playhearthstone.com/en-us/cards?rarity=common&set=the-witchwood";
	private final String koboldsCommonUrlText = "https://playhearthstone.com/en-us/cards?rarity=common&set=kobolds-and-catacombs";
	private final String knightsCommonUrlText = "https://playhearthstone.com/en-us/cards?rarity=common&set=knights-of-the-frozen-throne";
	private final String ungoroCommonUrlText = "https://playhearthstone.com/en-us/cards?rarity=common&set=journey-to-ungoro";
	private final String gadgetzanCommonUrlText = "https://playhearthstone.com/en-us/cards?rarity=common&set=mean-streets-of-gadgetzan";
	private final String oldGodsCommonUrlText = "https://playhearthstone.com/en-us/cards?rarity=common&set=whispers-of-the-old-gods";
	private final String tournamentCommonUrlText = "https://playhearthstone.com/en-us/cards?rarity=common&set=the-grand-tournament";
	private final String goblinsCommonUrlText = "https://playhearthstone.com/en-us/cards?rarity=common&set=goblins-vs-gnomes";
	private final String classicCommonUrlText = "https://playhearthstone.com/en-us/cards?rarity=common&set=legacy";
	
	// Rare buttons
	ArrayList<IconButton> rareButtons;
	
	private IconButton stormwindRareButton;
	private IconButton barrensRareButton;
	private IconButton darkmoonRareButton;
	private IconButton scholomanceRareButton;
	private IconButton outlandRareButton;
	private IconButton dragonsRareButton;
	private IconButton uldumRareButton;
	private IconButton shadowsRareButton;
	private IconButton rumbleRareButton;
	private IconButton boomsdayRareButton;
	private IconButton witchwoodRareButton;
	private IconButton koboldsRareButton;
	private IconButton knightsRareButton;
	private IconButton ungoroRareButton;
	private IconButton gadgetzanRareButton;
	private IconButton oldGodsRareButton;
	private IconButton tournamentRareButton;
	private IconButton goblinsRareButton;
	private IconButton classicRareButton;
	
	// Expansions rare cards webpages links
	ArrayList<URI> rareButtonsUrls;
	
	private URI stormwindRareUrl;
	private URI barrensRareUrl;
	private URI darkmoonRareUrl;
	private URI scholomanceRareUrl;
	private URI outlandRareUrl;
	private URI dragonsRareUrl;
	private URI uldumRareUrl;
	private URI shadowsRareUrl;
	private URI rumbleRareUrl;
	private URI boomsdayRareUrl;
	private URI witchwoodRareUrl;
	private URI koboldsRareUrl;
	private URI knightsRareUrl;
	private URI ungoroRareUrl;
	private URI gadgetzanRareUrl;
	private URI oldGodsRareUrl;
	private URI tournamentRareUrl;
	private URI goblinsRareUrl;
	private URI classicRareUrl;
	
	private final String stormwindRareUrlText = "https://playhearthstone.com/en-us/cards?rarity=rare&set=united-in-stormwind";
	private final String barrensRareUrlText = "https://playhearthstone.com/en-us/cards?rarity=rare&set=forged-in-the-barrens";
	private final String darkmoonRareUrlText = "https://playhearthstone.com/en-us/cards?rarity=rare&set=madness-at-the-darkmoon-faire";
	private final String scholomanceRareUrlText = "https://playhearthstone.com/en-us/cards?rarity=rare&set=scholomance-academy";
	private final String outlandRareUrlText = "https://playhearthstone.com/en-us/cards?rarity=rare&set=ashes-of-outland";
	private final String dragonsRareUrlText = "https://playhearthstone.com/en-us/cards?rarity=rare&set=descent-of-dragons";
	private final String uldumRareUrlText = "https://playhearthstone.com/en-us/cards?rarity=rare&set=saviors-of-uldum";
	private final String shadowsRareUrlText = "https://playhearthstone.com/en-us/cards?rarity=rare&set=rise-of-shadows";
	private final String rumbleRareUrlText = "https://playhearthstone.com/en-us/cards?rarity=rare&set=rastakhans-rumble";
	private final String boomsdayRareUrlText = "https://playhearthstone.com/en-us/cards?rarity=rare&set=the-boomsday-project";
	private final String witchwoodRareUrlText = "https://playhearthstone.com/en-us/cards?rarity=rare&set=the-witchwood";
	private final String koboldsRareUrlText = "https://playhearthstone.com/en-us/cards?rarity=rare&set=kobolds-and-catacombs";
	private final String knightsRareUrlText = "https://playhearthstone.com/en-us/cards?rarity=rare&set=knights-of-the-frozen-throne";
	private final String ungoroRareUrlText = "https://playhearthstone.com/en-us/cards?rarity=rare&set=journey-to-ungoro";
	private final String gadgetzanRareUrlText = "https://playhearthstone.com/en-us/cards?rarity=rare&set=mean-streets-of-gadgetzan";
	private final String oldGodsRareUrlText = "https://playhearthstone.com/en-us/cards?rarity=rare&set=whispers-of-the-old-gods";
	private final String tournamentRareUrlText = "https://playhearthstone.com/en-us/cards?rarity=rare&set=the-grand-tournament";
	private final String goblinsRareUrlText = "https://playhearthstone.com/en-us/cards?rarity=rare&set=goblins-vs-gnomes";
	private final String classicRareUrlText = "https://playhearthstone.com/en-us/cards?rarity=rare&set=legacy";
	
	// Epic buttons
	ArrayList<IconButton> epicButtons;
	
	private IconButton stormwindEpicButton;
	private IconButton barrensEpicButton;
	private IconButton darkmoonEpicButton;
	private IconButton scholomanceEpicButton;
	private IconButton outlandEpicButton;
	private IconButton dragonsEpicButton;
	private IconButton uldumEpicButton;
	private IconButton shadowsEpicButton;
	private IconButton rumbleEpicButton;
	private IconButton boomsdayEpicButton;
	private IconButton witchwoodEpicButton;
	private IconButton koboldsEpicButton;
	private IconButton knightsEpicButton;
	private IconButton ungoroEpicButton;
	private IconButton gadgetzanEpicButton;
	private IconButton oldGodsEpicButton;
	private IconButton tournamentEpicButton;
	private IconButton goblinsEpicButton;
	private IconButton classicEpicButton;
	
	// Expansions epic cards webpages links
	ArrayList<URI> epicButtonsUrls;
	
	private URI stormwindEpicUrl;
	private URI barrensEpicUrl;
	private URI darkmoonEpicUrl;
	private URI scholomanceEpicUrl;
	private URI outlandEpicUrl;
	private URI dragonsEpicUrl;
	private URI uldumEpicUrl;
	private URI shadowsEpicUrl;
	private URI rumbleEpicUrl;
	private URI boomsdayEpicUrl;
	private URI witchwoodEpicUrl;
	private URI koboldsEpicUrl;
	private URI knightsEpicUrl;
	private URI ungoroEpicUrl;
	private URI gadgetzanEpicUrl;
	private URI oldGodsEpicUrl;
	private URI tournamentEpicUrl;
	private URI goblinsEpicUrl;
	private URI classicEpicUrl;
	
	private final String stormwindEpicUrlText = "https://playhearthstone.com/en-us/cards?rarity=epic&set=united-in-stormwind";
	private final String barrensEpicUrlText = "https://playhearthstone.com/en-us/cards?rarity=epic&set=forged-in-the-barrens";
	private final String darkmoonEpicUrlText = "https://playhearthstone.com/en-us/cards?rarity=epic&set=madness-at-the-darkmoon-faire";
	private final String scholomanceEpicUrlText = "https://playhearthstone.com/en-us/cards?rarity=epic&set=scholomance-academy";
	private final String outlandEpicUrlText = "https://playhearthstone.com/en-us/cards?rarity=epic&set=ashes-of-outland";
	private final String dragonsEpicUrlText = "https://playhearthstone.com/en-us/cards?rarity=epic&set=descent-of-dragons";
	private final String uldumEpicUrlText = "https://playhearthstone.com/en-us/cards?rarity=epic&set=saviors-of-uldum";
	private final String shadowsEpicUrlText = "https://playhearthstone.com/en-us/cards?rarity=epic&set=rise-of-shadows";
	private final String rumbleEpicUrlText = "https://playhearthstone.com/en-us/cards?rarity=epic&set=rastakhans-rumble";
	private final String boomsdayEpicUrlText = "https://playhearthstone.com/en-us/cards?rarity=epic&set=the-boomsday-project";
	private final String witchwoodEpicUrlText = "https://playhearthstone.com/en-us/cards?rarity=epic&set=the-witchwood";
	private final String koboldsEpicUrlText = "https://playhearthstone.com/en-us/cards?rarity=epic&set=kobolds-and-catacombs";
	private final String knightsEpicUrlText = "https://playhearthstone.com/en-us/cards?rarity=epic&set=knights-of-the-frozen-throne";
	private final String ungoroEpicUrlText = "https://playhearthstone.com/en-us/cards?rarity=epic&set=journey-to-ungoro";
	private final String gadgetzanEpicUrlText = "https://playhearthstone.com/en-us/cards?rarity=epic&set=mean-streets-of-gadgetzan";
	private final String oldGodsEpicUrlText = "https://playhearthstone.com/en-us/cards?rarity=epic&set=whispers-of-the-old-gods";
	private final String tournamentEpicUrlText = "https://playhearthstone.com/en-us/cards?rarity=epic&set=the-grand-tournament";
	private final String goblinsEpicUrlText = "https://playhearthstone.com/en-us/cards?rarity=epic&set=goblins-vs-gnomes";
	private final String classicEpicUrlText = "https://playhearthstone.com/en-us/cards?rarity=epic&set=legacy";
	
	// Legendary buttons
	ArrayList<IconButton> legendaryButtons;
	
	private IconButton stormwindLegendaryButton;
	private IconButton barrensLegendaryButton;
	private IconButton darkmoonLegendaryButton;
	private IconButton scholomanceLegendaryButton;
	private IconButton outlandLegendaryButton;
	private IconButton dragonsLegendaryButton;
	private IconButton uldumLegendaryButton;
	private IconButton shadowsLegendaryButton;
	private IconButton rumbleLegendaryButton;
	private IconButton boomsdayLegendaryButton;
	private IconButton witchwoodLegendaryButton;
	private IconButton koboldsLegendaryButton;
	private IconButton knightsLegendaryButton;
	private IconButton ungoroLegendaryButton;
	private IconButton gadgetzanLegendaryButton;
	private IconButton oldGodsLegendaryButton;
	private IconButton tournamentLegendaryButton;
	private IconButton goblinsLegendaryButton;
	private IconButton classicLegendaryButton;
	
	// Expansions legendary cards webpages links
	ArrayList<URI> legendaryButtonsUrls;
	
	private URI stormwindLegendaryUrl;
	private URI barrensLegendaryUrl;
	private URI darkmoonLegendaryUrl;
	private URI scholomanceLegendaryUrl;
	private URI outlandLegendaryUrl;
	private URI dragonsLegendaryUrl;
	private URI uldumLegendaryUrl;
	private URI shadowsLegendaryUrl;
	private URI rumbleLegendaryUrl;
	private URI boomsdayLegendaryUrl;
	private URI witchwoodLegendaryUrl;
	private URI koboldsLegendaryUrl;
	private URI knightsLegendaryUrl;
	private URI ungoroLegendaryUrl;
	private URI gadgetzanLegendaryUrl;
	private URI oldGodsLegendaryUrl;
	private URI tournamentLegendaryUrl;
	private URI goblinsLegendaryUrl;
	private URI classicLegendaryUrl;
	
	private final String stormwindLegendaryUrlText = "https://playhearthstone.com/en-us/cards?rarity=legendary&set=united-in-stormwind";
	private final String barrensLegendaryUrlText = "https://playhearthstone.com/en-us/cards?rarity=legendary&set=forged-in-the-barrens";
	private final String darkmoonLegendaryUrlText = "https://playhearthstone.com/en-us/cards?rarity=legendary&set=madness-at-the-darkmoon-faire";
	private final String scholomanceLegendaryUrlText = "https://playhearthstone.com/en-us/cards?rarity=legendary&set=scholomance-academy";
	private final String outlandLegendaryUrlText = "https://playhearthstone.com/en-us/cards?rarity=legendary&set=ashes-of-outland";
	private final String dragonsLegendaryUrlText = "https://playhearthstone.com/en-us/cards?rarity=legendary&set=descent-of-dragons";
	private final String uldumLegendaryUrlText = "https://playhearthstone.com/en-us/cards?rarity=legendary&set=saviors-of-uldum";
	private final String shadowsLegendaryUrlText = "https://playhearthstone.com/en-us/cards?rarity=legendary&set=rise-of-shadows";
	private final String rumbleLegendaryUrlText = "https://playhearthstone.com/en-us/cards?rarity=legendary&set=rastakhans-rumble";
	private final String boomsdayLegendaryUrlText = "https://playhearthstone.com/en-us/cards?rarity=legendary&set=the-boomsday-project";
	private final String witchwoodLegendaryUrlText = "https://playhearthstone.com/en-us/cards?rarity=legendary&set=the-witchwood";
	private final String koboldsLegendaryUrlText = "https://playhearthstone.com/en-us/cards?rarity=legendary&set=kobolds-and-catacombs";
	private final String knightsLegendaryUrlText = "https://playhearthstone.com/en-us/cards?rarity=legendary&set=knights-of-the-frozen-throne";
	private final String ungoroLegendaryUrlText = "https://playhearthstone.com/en-us/cards?rarity=legendary&set=journey-to-ungoro";
	private final String gadgetzanLegendaryUrlText = "https://playhearthstone.com/en-us/cards?rarity=legendary&set=mean-streets-of-gadgetzan";
	private final String oldGodsLegendaryUrlText = "https://playhearthstone.com/en-us/cards?rarity=legendary&set=whispers-of-the-old-gods";
	private final String tournamentLegendaryUrlText = "https://playhearthstone.com/en-us/cards?rarity=legendary&set=the-grand-tournament";
	private final String goblinsLegendaryUrlText = "https://playhearthstone.com/en-us/cards?rarity=legendary&set=goblins-vs-gnomes";
	private final String classicLegendaryUrlText = "https://playhearthstone.com/en-us/cards?rarity=legendary&set=legacy";
	
	// Constructor
	public HSPityTimerTracker() 
	{
		// Create the save file or check if a new expansion exists in the save file, if there is already one
		createSaveFile();
		
		// Format in which the probabilities values are displayed
		nf = new DecimalFormat("##.##");
		
		// Pop-up windows background color
		popUpColor = new Color(240, 240, 240);
		// Modify pop-up window text field font
		UIManager.put("TextField.font", new Font("Comic Sans MS", Font.PLAIN, 20));
		
		// Game Mode buttons colors
		setsColor = new Color(240, 215, 105);
		setsHoverColor = new Color(240, 200, 95);
		setsSelectedColor = new Color(220, 170, 85);
		
		// Help pop-up window
		createHelpPopUpWindow(popUpColor);
		
		// Input error pop-up window
		createInputErrorPopUpWindow(popUpColor);
		
		// Modify button pop-up window
		createModifyButtonPopUpWindow(popUpColor);
		
		// Tracker links
		createExpansionsURIs();
		
		// Tracker elements initialization
		trackerInitialization();
		
		// Tracker elements action listeners
		trackerActionListeners();
	}
	
	// Creates the save file or updates it with new expansions
	private void createSaveFile() 
	{
		saveFilePath = saveFileFolder + File.separator + saveFileName;
		
		String[] baseTextTokens;
		
		ArrayList<String> baseTextExpansionTokens = new ArrayList<String>();
		ArrayList<String> saveFileExpansionTokens = new ArrayList<String>();
		ArrayList<String> newExpansions = new ArrayList<String>();
		ArrayList<String> newSaveFileTokens = new ArrayList<String>();
		
		try {
			saveFile = new File(saveFilePath);
			
			// Create the file for the first time
			if (saveFile.createNewFile()) {
				// Initialize the file's content
				writeSaveFile(baseText);
				// Make the file read-only
				saveFile.setReadOnly();
			}
			// Update the file with new expansions
			else {
				readSaveFile();
				
				baseTextTokens = baseText.split(nextLine);
				saveFileTokens = saveFileData.split(nextLine);
				
				// Check if the file's text is different compared to the base text (5 is the position in the tokens array list after '- Expansions')
				if (saveFileTokens[5].equals(baseTextTokens[5])) 
					return;
				// If it's not, insert the new expansions in the file
				else {
					// Array containing the expansions in the base text
					int i = 5;
					while (!baseTextTokens[i].equals("")) {
						baseTextExpansionTokens.add(baseTextTokens[i]);
						i++;
					}
					// Array containing the expansions in the save file
					i = 5;
					while (!saveFileTokens[i].equals("")) {
						saveFileExpansionTokens.add(saveFileTokens[i]);
						i++;
					}
					
					// Find the new expansions and keep them in a temporary array list (from oldest to newest)
					for (int j = 0; j < baseTextExpansionTokens.size(); j++) {
						if (!baseTextExpansionTokens.get(j).equals(saveFileExpansionTokens.get(j))) {
							newExpansions.add(0, baseTextExpansionTokens.get(j));
							saveFileExpansionTokens.add(j, baseTextExpansionTokens.get(j));
						}
					}
					
					// Copy the save file tokens to a new array list
					for (int j = 0; j < saveFileTokens.length; j++) {
						newSaveFileTokens.add(saveFileTokens[j]);
					}
					
					// Insert the new expansions in the save file tokens array list
					int newExpansionsNo;
					for (int j = 0; j < newSaveFileTokens.size(); j++) {
						// The new expansions in the "Expansions" section of the file
						newExpansionsNo = newExpansions.size();
						if (newSaveFileTokens.get(j).equals("- Expansions") && ((j + 1) < newSaveFileTokens.size())) {
							while (newExpansionsNo != 0) {
								newSaveFileTokens.add(j+1, newExpansions.get(newExpansions.size() - newExpansionsNo));
								newExpansionsNo--;
							}
						}
						
						// The new expansions in the "Epic counters" section of the file
						newExpansionsNo = newExpansions.size();
						if (newSaveFileTokens.get(j).equals("- Epic counters") && ((j + 1) < newSaveFileTokens.size())) {
							while (newExpansionsNo != 0) {
								newSaveFileTokens.add(j+1, newExpansions.get(newExpansions.size() - newExpansionsNo) + ": 0");
								newExpansionsNo--;
							}
						}
						
						// The new expansions in the "Epic probabilities" section of the file
						newExpansionsNo = newExpansions.size();
						if (newSaveFileTokens.get(j).equals("- Epic probabilities") && ((j + 1) < newSaveFileTokens.size())) {
							while (newExpansionsNo != 0) {
								newSaveFileTokens.add(j+1, newExpansions.get(newExpansions.size() - newExpansionsNo) + ": 0");
								newExpansionsNo--;
							}
						}
						
						// The new expansions in the "Legendary counters" section of the file
						newExpansionsNo = newExpansions.size();
						if (newSaveFileTokens.get(j).equals("- Legendary counters") && ((j + 1) < newSaveFileTokens.size())) {
							while (newExpansionsNo != 0) {
								newSaveFileTokens.add(j+1, newExpansions.get(newExpansions.size() - newExpansionsNo) + ": 0");
								newExpansionsNo--;
							}
						}
						
						// The new expansions in the "Legendary probabilities" section of the file
						newExpansionsNo = newExpansions.size();
						if (newSaveFileTokens.get(j).equals("- Legendary probabilities") && ((j + 1) < newSaveFileTokens.size())) {
							while (newExpansionsNo != 0) {
								newSaveFileTokens.add(j+1, newExpansions.get(newExpansions.size() - newExpansionsNo) + ": 0");
								newExpansionsNo--;
							}
						}
						
						// The new expansions in the "Total counters" section of the file
						newExpansionsNo = newExpansions.size();
						if (newSaveFileTokens.get(j).equals("- Total counters") && ((j + 1) < newSaveFileTokens.size())) {
							while (newExpansionsNo != 0) {
								newSaveFileTokens.add(j+1, newExpansions.get(newExpansions.size() - newExpansionsNo) + ": 0");
								newExpansionsNo--;
							}
						}
					}
					
					// Copy the array list to a String so the writeSaveFile method can be called
					String newSaveFileData = "";
					for (int j = 0; j < newSaveFileTokens.size(); j++) {
						if (j != newSaveFileTokens.size() - 1)
							newSaveFileData = newSaveFileData + newSaveFileTokens.get(j) + nextLine;
						else
							newSaveFileData = newSaveFileData + newSaveFileTokens.get(j);
					}
					
					// Write the new save file data in the file
					saveFile.setWritable(true);
					writeSaveFile(newSaveFileData);
					saveFile.setReadOnly();
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	//Writes the save file with the values of counters' variables
	private void writeSaveFile(String data) 
	{
		try {
			saveFileWriter = new FileWriter(saveFilePath);
			saveFileWriter.write(data);
			saveFileWriter.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	// Reads the save file and inserts values to counters' variables
	private void readSaveFile() 
	{
		saveFileData = "";
		try {
			saveFileReader = new Scanner(saveFile);
			while (saveFileReader.hasNextLine()) {
				saveFileData = saveFileData + saveFileReader.nextLine() + nextLine;
			}
			saveFileReader.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	// "Help" pop-up window
	private void createHelpPopUpWindow(Color backgroundColor) 
	{
		helpPanel = new JPanel();
		helpPanel.setLayout(new BoxLayout(helpPanel, BoxLayout.Y_AXIS));
		
		helpMessageTitle = new JTextPane();
		doc = helpMessageTitle.getStyledDocument();
		set = new SimpleAttributeSet();
		StyleConstants.setBold(set, true);
		StyleConstants.setFontSize(set, 24);
		StyleConstants.setFontFamily(set, "Comic Sans MS");
		StyleConstants.setAlignment(set, StyleConstants.ALIGN_CENTER);
		helpMessageTitle.setCharacterAttributes(set, true);
		try {
			doc.insertString(doc.getLength(), helpMessageTitleText, set);
		} catch (BadLocationException e) {
			e.printStackTrace();
		}
		doc.setParagraphAttributes(0, doc.getLength(), set, false);
		
		helpMessageTitle.setBackground(backgroundColor);
		helpMessageTitle.setEditable(false);
		helpMessageTitle.setCursor(Cursor.getPredefinedCursor(Cursor.TEXT_CURSOR));
		
		helpMessage = new JTextPane();
		doc = helpMessage.getStyledDocument();
		set = new SimpleAttributeSet();
		StyleConstants.setFontSize(set, 18);
		StyleConstants.setFontFamily(set, "Comic Sans MS");
		helpMessage.setCharacterAttributes(set, true);
		try {
			doc.insertString(doc.getLength(), helpMessageText, set);
		} catch (BadLocationException e) {
			e.printStackTrace();
		}
		doc.setParagraphAttributes(0, doc.getLength(), set, false);
		
		helpMessage.setBackground(backgroundColor);
		helpMessage.setEditable(false);
		helpMessage.setCursor(Cursor.getPredefinedCursor(Cursor.TEXT_CURSOR));
		
		// "Help" pop-up window scroll bar
		helpMessagePanel = new JScrollPane(helpMessage);
		helpMessagePanel.getVerticalScrollBar().setUnitIncrement(15);
		helpMessagePanel.setPreferredSize(new Dimension(900, 450));
		helpMessagePanel.setBorder(BorderFactory.createEmptyBorder());
		
		helpPanel.add(helpMessageTitle);
		helpPanel.add(helpMessagePanel);
	}
	
	// Input error pop-up window
	private void createInputErrorPopUpWindow(Color backgroundColor) 
	{
		incrementErrorMessage = new JTextPane();
		doc = incrementErrorMessage.getStyledDocument();
		set = new SimpleAttributeSet();
		StyleConstants.setFontSize(set, 18);
		StyleConstants.setFontFamily(set, "Comic Sans MS");
		incrementErrorMessage.setCharacterAttributes(set, true);
		try {
			doc.insertString(doc.getLength(), incrementErrorMessageText, set);
		} catch (BadLocationException e) {
			e.printStackTrace();
		}
		doc.setParagraphAttributes(0, doc.getLength(), set, false);
		
		incrementErrorMessage.setBackground(backgroundColor);
		incrementErrorMessage.setEditable(false);
		incrementErrorMessage.setCursor(Cursor.getPredefinedCursor(Cursor.TEXT_CURSOR));
	}
	
	// Modify button pop-up window
	private void createModifyButtonPopUpWindow(Color backgroundColor) 
	{
		modifyWindow = new JTextPane();
		doc = modifyWindow.getStyledDocument();
		set = new SimpleAttributeSet();
		StyleConstants.setFontSize(set, 18);
		StyleConstants.setFontFamily(set, "Comic Sans MS");
		modifyWindow.setCharacterAttributes(set, true);
		try {
			doc.insertString(doc.getLength(), modifyWindowText, set);
		} catch (BadLocationException e) {
			e.printStackTrace();
		}
		doc.setParagraphAttributes(0, doc.getLength(), set, false);
		
		modifyWindow.setBackground(backgroundColor);
		modifyWindow.setEditable(false);
		modifyWindow.setCursor(Cursor.getPredefinedCursor(Cursor.TEXT_CURSOR));
	}
	
	// Checks if the modify window input is an integer number
	private boolean isInteger(String strNum) 
	{
		if (strNum == null) {
	    	return false;
	    }
	    try {
	    	Integer.parseInt(strNum);
	    } catch (NumberFormatException nfe) {
	    	return false;
	    }
	    return true;
	}
	
	// Creates links to all of the expansions webpages
	private void createExpansionsURIs() 
	{
		// Links to expansions webpages
		stormwindUrl = URI.create(stormwindUrlText);
		barrensUrl = URI.create(barrensUrlText);
		darkmoonUrl = URI.create(darkmoonUrlText);
		scholomanceUrl = URI.create(scholomanceUrlText);
		outlandUrl = URI.create(outlandUrlText);
		dragonsUrl = URI.create(dragonsUrlText);
		uldumUrl = URI.create(uldumUrlText);
		shadowsUrl = URI.create(shadowsUrlText);
		rumbleUrl = URI.create(rumbleUrlText);
		boomsdayUrl = URI.create(boomsdayUrlText);
		witchwoodUrl = URI.create(witchwoodUrlText);
		koboldsUrl = URI.create(koboldsUrlText);
		knightsUrl = URI.create(knightsUrlText);
		ungoroUrl = URI.create(ungoroUrlText);
		gadgetzanUrl = URI.create(gadgetzanUrlText);
		oldGodsUrl = URI.create(oldGodsUrlText);
		tournamentUrl = URI.create(tournamentUrlText);
		goblinsUrl = URI.create(goblinsUrlText);
		
		imageButtonsUrls = new ArrayList<URI>();
		
		imageButtonsUrls.add(goblinsUrl);
		imageButtonsUrls.add(tournamentUrl);
		imageButtonsUrls.add(oldGodsUrl);
		imageButtonsUrls.add(gadgetzanUrl);
		imageButtonsUrls.add(ungoroUrl);
		imageButtonsUrls.add(knightsUrl);
		imageButtonsUrls.add(koboldsUrl);
		imageButtonsUrls.add(witchwoodUrl);
		imageButtonsUrls.add(boomsdayUrl);
		imageButtonsUrls.add(rumbleUrl);
		imageButtonsUrls.add(shadowsUrl);
		imageButtonsUrls.add(uldumUrl);
		imageButtonsUrls.add(dragonsUrl);
		imageButtonsUrls.add(outlandUrl);
		imageButtonsUrls.add(scholomanceUrl);
		imageButtonsUrls.add(darkmoonUrl);
		imageButtonsUrls.add(barrensUrl);
		imageButtonsUrls.add(stormwindUrl);
		
		// Links to expansions common cards
		stormwindCommonUrl = URI.create(stormwindCommonUrlText);
		barrensCommonUrl = URI.create(barrensCommonUrlText);
		darkmoonCommonUrl = URI.create(darkmoonCommonUrlText);
		scholomanceCommonUrl = URI.create(scholomanceCommonUrlText);
		outlandCommonUrl = URI.create(outlandCommonUrlText);
		dragonsCommonUrl = URI.create(dragonsCommonUrlText);
		uldumCommonUrl = URI.create(uldumCommonUrlText);
		shadowsCommonUrl = URI.create(shadowsCommonUrlText);
		rumbleCommonUrl = URI.create(rumbleCommonUrlText);
		boomsdayCommonUrl = URI.create(boomsdayCommonUrlText);
		witchwoodCommonUrl = URI.create(witchwoodCommonUrlText);
		koboldsCommonUrl = URI.create(koboldsCommonUrlText);
		knightsCommonUrl = URI.create(knightsCommonUrlText);
		ungoroCommonUrl = URI.create(ungoroCommonUrlText);
		gadgetzanCommonUrl = URI.create(gadgetzanCommonUrlText);
		oldGodsCommonUrl = URI.create(oldGodsCommonUrlText);
		tournamentCommonUrl = URI.create(tournamentCommonUrlText);
		goblinsCommonUrl = URI.create(goblinsCommonUrlText);
		classicCommonUrl = URI.create(classicCommonUrlText);
		
		commonButtonsUrls = new ArrayList<URI>();
		
		commonButtonsUrls.add(classicCommonUrl);
		commonButtonsUrls.add(goblinsCommonUrl);
		commonButtonsUrls.add(tournamentCommonUrl);
		commonButtonsUrls.add(oldGodsCommonUrl);
		commonButtonsUrls.add(gadgetzanCommonUrl);
		commonButtonsUrls.add(ungoroCommonUrl);
		commonButtonsUrls.add(knightsCommonUrl);
		commonButtonsUrls.add(koboldsCommonUrl);
		commonButtonsUrls.add(witchwoodCommonUrl);
		commonButtonsUrls.add(boomsdayCommonUrl);
		commonButtonsUrls.add(rumbleCommonUrl);
		commonButtonsUrls.add(shadowsCommonUrl);
		commonButtonsUrls.add(uldumCommonUrl);
		commonButtonsUrls.add(dragonsCommonUrl);
		commonButtonsUrls.add(outlandCommonUrl);
		commonButtonsUrls.add(scholomanceCommonUrl);
		commonButtonsUrls.add(darkmoonCommonUrl);
		commonButtonsUrls.add(barrensCommonUrl);
		commonButtonsUrls.add(stormwindCommonUrl);
		
		// Links to expansions rare cards
		stormwindRareUrl = URI.create(stormwindRareUrlText);
		barrensRareUrl = URI.create(barrensRareUrlText);
		darkmoonRareUrl = URI.create(darkmoonRareUrlText);
		scholomanceRareUrl = URI.create(scholomanceRareUrlText);
		outlandRareUrl = URI.create(outlandRareUrlText);
		dragonsRareUrl = URI.create(dragonsRareUrlText);
		uldumRareUrl = URI.create(uldumRareUrlText);
		shadowsRareUrl = URI.create(shadowsRareUrlText);
		rumbleRareUrl = URI.create(rumbleRareUrlText);
		boomsdayRareUrl = URI.create(boomsdayRareUrlText);
		witchwoodRareUrl = URI.create(witchwoodRareUrlText);
		koboldsRareUrl = URI.create(koboldsRareUrlText);
		knightsRareUrl = URI.create(knightsRareUrlText);
		ungoroRareUrl = URI.create(ungoroRareUrlText);
		gadgetzanRareUrl = URI.create(gadgetzanRareUrlText);
		oldGodsRareUrl = URI.create(oldGodsRareUrlText);
		tournamentRareUrl = URI.create(tournamentRareUrlText);
		goblinsRareUrl = URI.create(goblinsRareUrlText);
		classicRareUrl = URI.create(classicRareUrlText);
		
		rareButtonsUrls = new ArrayList<URI>();
		
		rareButtonsUrls.add(classicRareUrl);
		rareButtonsUrls.add(goblinsRareUrl);
		rareButtonsUrls.add(tournamentRareUrl);
		rareButtonsUrls.add(oldGodsRareUrl);
		rareButtonsUrls.add(gadgetzanRareUrl);
		rareButtonsUrls.add(ungoroRareUrl);
		rareButtonsUrls.add(knightsRareUrl);
		rareButtonsUrls.add(koboldsRareUrl);
		rareButtonsUrls.add(witchwoodRareUrl);
		rareButtonsUrls.add(boomsdayRareUrl);
		rareButtonsUrls.add(rumbleRareUrl);
		rareButtonsUrls.add(shadowsRareUrl);
		rareButtonsUrls.add(uldumRareUrl);
		rareButtonsUrls.add(dragonsRareUrl);
		rareButtonsUrls.add(outlandRareUrl);
		rareButtonsUrls.add(scholomanceRareUrl);
		rareButtonsUrls.add(darkmoonRareUrl);
		rareButtonsUrls.add(barrensRareUrl);
		rareButtonsUrls.add(stormwindRareUrl);
		
		// Links to expansions epic cards
		stormwindEpicUrl = URI.create(stormwindEpicUrlText);
		barrensEpicUrl = URI.create(barrensEpicUrlText);
		darkmoonEpicUrl = URI.create(darkmoonEpicUrlText);
		scholomanceEpicUrl = URI.create(scholomanceEpicUrlText);
		outlandEpicUrl = URI.create(outlandEpicUrlText);
		dragonsEpicUrl = URI.create(dragonsEpicUrlText);
		uldumEpicUrl = URI.create(uldumEpicUrlText);
		shadowsEpicUrl = URI.create(shadowsEpicUrlText);
		rumbleEpicUrl = URI.create(rumbleEpicUrlText);
		boomsdayEpicUrl = URI.create(boomsdayEpicUrlText);
		witchwoodEpicUrl = URI.create(witchwoodEpicUrlText);
		koboldsEpicUrl = URI.create(koboldsEpicUrlText);
		knightsEpicUrl = URI.create(knightsEpicUrlText);
		ungoroEpicUrl = URI.create(ungoroEpicUrlText);
		gadgetzanEpicUrl = URI.create(gadgetzanEpicUrlText);
		oldGodsEpicUrl = URI.create(oldGodsEpicUrlText);
		tournamentEpicUrl = URI.create(tournamentEpicUrlText);
		goblinsEpicUrl = URI.create(goblinsEpicUrlText);
		classicEpicUrl = URI.create(classicEpicUrlText);
		
		epicButtonsUrls = new ArrayList<URI>();
		
		epicButtonsUrls.add(classicEpicUrl);
		epicButtonsUrls.add(goblinsEpicUrl);
		epicButtonsUrls.add(tournamentEpicUrl);
		epicButtonsUrls.add(oldGodsEpicUrl);
		epicButtonsUrls.add(gadgetzanEpicUrl);
		epicButtonsUrls.add(ungoroEpicUrl);
		epicButtonsUrls.add(knightsEpicUrl);
		epicButtonsUrls.add(koboldsEpicUrl);
		epicButtonsUrls.add(witchwoodEpicUrl);
		epicButtonsUrls.add(boomsdayEpicUrl);
		epicButtonsUrls.add(rumbleEpicUrl);
		epicButtonsUrls.add(shadowsEpicUrl);
		epicButtonsUrls.add(uldumEpicUrl);
		epicButtonsUrls.add(dragonsEpicUrl);
		epicButtonsUrls.add(outlandEpicUrl);
		epicButtonsUrls.add(scholomanceEpicUrl);
		epicButtonsUrls.add(darkmoonEpicUrl);
		epicButtonsUrls.add(barrensEpicUrl);
		epicButtonsUrls.add(stormwindEpicUrl);
		
		// Links to expansions legendary cards
		stormwindLegendaryUrl = URI.create(stormwindLegendaryUrlText);
		barrensLegendaryUrl = URI.create(barrensLegendaryUrlText);
		darkmoonLegendaryUrl = URI.create(darkmoonLegendaryUrlText);
		scholomanceLegendaryUrl = URI.create(scholomanceLegendaryUrlText);
		outlandLegendaryUrl = URI.create(outlandLegendaryUrlText);
		dragonsLegendaryUrl = URI.create(dragonsLegendaryUrlText);
		uldumLegendaryUrl = URI.create(uldumLegendaryUrlText);
		shadowsLegendaryUrl = URI.create(shadowsLegendaryUrlText);
		rumbleLegendaryUrl = URI.create(rumbleLegendaryUrlText);
		boomsdayLegendaryUrl = URI.create(boomsdayLegendaryUrlText);
		witchwoodLegendaryUrl = URI.create(witchwoodLegendaryUrlText);
		koboldsLegendaryUrl = URI.create(koboldsLegendaryUrlText);
		knightsLegendaryUrl = URI.create(knightsLegendaryUrlText);
		ungoroLegendaryUrl = URI.create(ungoroLegendaryUrlText);
		gadgetzanLegendaryUrl = URI.create(gadgetzanLegendaryUrlText);
		oldGodsLegendaryUrl = URI.create(oldGodsLegendaryUrlText);
		tournamentLegendaryUrl = URI.create(tournamentLegendaryUrlText);
		goblinsLegendaryUrl = URI.create(goblinsLegendaryUrlText);
		classicLegendaryUrl = URI.create(classicLegendaryUrlText);
		
		legendaryButtonsUrls = new ArrayList<URI>();
		
		legendaryButtonsUrls.add(classicLegendaryUrl);
		legendaryButtonsUrls.add(goblinsLegendaryUrl);
		legendaryButtonsUrls.add(tournamentLegendaryUrl);
		legendaryButtonsUrls.add(oldGodsLegendaryUrl);
		legendaryButtonsUrls.add(gadgetzanLegendaryUrl);
		legendaryButtonsUrls.add(ungoroLegendaryUrl);
		legendaryButtonsUrls.add(knightsLegendaryUrl);
		legendaryButtonsUrls.add(koboldsLegendaryUrl);
		legendaryButtonsUrls.add(witchwoodLegendaryUrl);
		legendaryButtonsUrls.add(boomsdayLegendaryUrl);
		legendaryButtonsUrls.add(rumbleLegendaryUrl);
		legendaryButtonsUrls.add(shadowsLegendaryUrl);
		legendaryButtonsUrls.add(uldumLegendaryUrl);
		legendaryButtonsUrls.add(dragonsLegendaryUrl);
		legendaryButtonsUrls.add(outlandLegendaryUrl);
		legendaryButtonsUrls.add(scholomanceLegendaryUrl);
		legendaryButtonsUrls.add(darkmoonLegendaryUrl);
		legendaryButtonsUrls.add(barrensLegendaryUrl);
		legendaryButtonsUrls.add(stormwindLegendaryUrl);
	}
	
	// Initializes the tracker variables
	private void trackerInitialization() 
	{
		// "Help" button
		help = tracker.getHelp();
		
		// "Show save file" button
		showSaveFileFolder = tracker.getShowSaveFileFolder();
		
		// Mode panels
		standard = tracker.getStandard();
		wild = tracker.getWild();
		
		// Game Mode buttons
		standardButton = tracker.getStandardButton();
		wildButton = tracker.getWildButton();
		
		// Years shortcut buttons panels
		standardYearsShortcutsPanel = tracker.getStandardYearsShortcutsPanel();
		wildYearsShortcutsPanel = tracker.getWildYearsShortcutsPanel();
		
		// Years shortcut buttons
		shortcutButtonsInitialization();
		
		// Standard sets
		gryphon = tracker.getYearOfTheGryphon();
		phoenix = tracker.getYearOfThePhoenix();
		
		// Wild sets
		dragon = tracker.getYearOfTheDragon();
		raven = tracker.getYearOfTheRaven();
		mammoth = tracker.getYearOfTheMammoth();
		kraken = tracker.getYearOfTheKraken();
		classicSets = tracker.getClassicSets();
		
		// Image buttons
		imageButtonsInitialization();
		
		// Counters' values
		readSaveFile();
		countersValuesInitialization();
		
		// Modify Buttons
		modifyButtonsInitialization();
		
		// Rarity buttons
		rarityButtonsInitialization();
	}
	
	// Initializes the image buttons
	private void imageButtonsInitialization() 
	{
		// Image buttons
		stormwindImage = tracker.getStormwindImage();
		barrensImage = tracker.getBarrensImage();
		darkmoonImage = tracker.getDarkmoonImage();
		scholomanceImage = tracker.getScholomanceImage();
		outlandImage = tracker.getOutlandImage();
		dragonsImage = tracker.getDragonsImage();
		uldumImage = tracker.getUldumImage();
		shadowsImage = tracker.getShadowsImage();
		rumbleImage = tracker.getRumbleImage();
		boomsdayImage = tracker.getBoomsdayImage();
		witchwoodImage = tracker.getWitchwoodImage();
		koboldsImage = tracker.getKoboldsImage();
		knightsImage = tracker.getKnightsImage();
		ungoroImage = tracker.getUngoroImage();
		gadgetzanImage = tracker.getGadgetzanImage();
		oldGodsImage = tracker.getOldGodsImage();
		tournamentImage = tracker.getTournamentImage();
		goblinsImage = tracker.getGoblinsImage();
		
		imageButtons = new ArrayList<JButton>();
		
		imageButtons.add(goblinsImage);
		imageButtons.add(tournamentImage);
		imageButtons.add(oldGodsImage);
		imageButtons.add(gadgetzanImage);
		imageButtons.add(ungoroImage);
		imageButtons.add(knightsImage);
		imageButtons.add(koboldsImage);
		imageButtons.add(witchwoodImage);
		imageButtons.add(boomsdayImage);
		imageButtons.add(rumbleImage);
		imageButtons.add(shadowsImage);
		imageButtons.add(uldumImage);
		imageButtons.add(dragonsImage);
		imageButtons.add(outlandImage);
		imageButtons.add(scholomanceImage);
		imageButtons.add(darkmoonImage);
		imageButtons.add(barrensImage);
		imageButtons.add(stormwindImage);
	}
	
	// Initializes the Years shortcut buttons
	private void shortcutButtonsInitialization() 
	{
		// Years shortcut buttons
		gryphonShortcut = tracker.getGryphonShortcut();
		phoenixShortcut = tracker.getPhoenixShortcut();
		dragonShortcut = tracker.getDragonShortcut();
		ravenShortcut = tracker.getRavenShortcut();
		mammothShortcut = tracker.getMammothShortcut();
		krakenShortcut = tracker.getKrakenShortcut();
		classicSetsShortcut = tracker.getClassicSetsShortcut();
		
		shortcutButtons = new ArrayList<JButton>();
		
		shortcutButtons.add(classicSetsShortcut);
		shortcutButtons.add(krakenShortcut);
		shortcutButtons.add(mammothShortcut);
		shortcutButtons.add(ravenShortcut);
		shortcutButtons.add(dragonShortcut);
		shortcutButtons.add(phoenixShortcut);
		shortcutButtons.add(gryphonShortcut);
	}
	
	// Initializes the counters
	private void countersValuesInitialization() 
	{
		// Tokenize the save file data
		saveFileTokens = saveFileData.split(nextLine);
		
		// Epic counters (displayed values)
		tracker.setStormwindEpicCounter(saveFileTokens[28].substring(21));
		tracker.setBarrensEpicCounter(saveFileTokens[29].substring(23));
		tracker.setDarkmoonEpicCounter(saveFileTokens[30].substring(31));
		tracker.setScholomanceEpicCounter(saveFileTokens[31].substring(21));
		tracker.setOutlandEpicCounter(saveFileTokens[32].substring(18));
		tracker.setDragonsEpicCounter(saveFileTokens[33].substring(20));
		tracker.setUldumEpicCounter(saveFileTokens[34].substring(18));
		tracker.setShadowsEpicCounter(saveFileTokens[35].substring(17));
		tracker.setRumbleEpicCounter(saveFileTokens[36].substring(20));
		tracker.setBoomsdayEpicCounter(saveFileTokens[37].substring(22));
		tracker.setWitchwoodEpicCounter(saveFileTokens[38].substring(15));
		tracker.setKoboldsEpicCounter(saveFileTokens[39].substring(21));
		tracker.setKnightsEpicCounter(saveFileTokens[40].substring(30));
		tracker.setUngoroEpicCounter(saveFileTokens[41].substring(20));
		tracker.setGadgetzanEpicCounter(saveFileTokens[42].substring(27));
		tracker.setOldGodsEpicCounter(saveFileTokens[43].substring(26));
		tracker.setTournamentEpicCounter(saveFileTokens[44].substring(22));
		tracker.setGoblinsEpicCounter(saveFileTokens[45].substring(19));
		tracker.setClassicEpicCounter(saveFileTokens[46].substring(9));
		
		// Epic counters (internal values)
		stormwindEpicCounter = Integer.valueOf(tracker.getStormwindEpicCounter());
		barrensEpicCounter = Integer.valueOf(tracker.getBarrensEpicCounter());
		darkmoonEpicCounter = Integer.valueOf(tracker.getDarkmoonEpicCounter());
		scholomanceEpicCounter = Integer.valueOf(tracker.getScholomanceEpicCounter());
		outlandEpicCounter = Integer.valueOf(tracker.getOutlandEpicCounter());
		dragonsEpicCounter = Integer.valueOf(tracker.getDragonsEpicCounter());
		uldumEpicCounter = Integer.valueOf(tracker.getUldumEpicCounter());
		shadowsEpicCounter = Integer.valueOf(tracker.getShadowsEpicCounter());
		rumbleEpicCounter = Integer.valueOf(tracker.getRumbleEpicCounter());
		boomsdayEpicCounter = Integer.valueOf(tracker.getBoomsdayEpicCounter());
		witchwoodEpicCounter = Integer.valueOf(tracker.getWitchwoodEpicCounter());
		koboldsEpicCounter = Integer.valueOf(tracker.getKoboldsEpicCounter());
		knightsEpicCounter = Integer.valueOf(tracker.getKnightsEpicCounter());
		ungoroEpicCounter = Integer.valueOf(tracker.getUngoroEpicCounter());
		gadgetzanEpicCounter = Integer.valueOf(tracker.getGadgetzanEpicCounter());
		oldGodsEpicCounter = Integer.valueOf(tracker.getOldGodsEpicCounter());
		tournamentEpicCounter = Integer.valueOf(tracker.getTournamentEpicCounter());
		goblinsEpicCounter = Integer.valueOf(tracker.getGoblinsEpicCounter());
		classicEpicCounter = Integer.valueOf(tracker.getClassicEpicCounter());
		
		// Epic probabilities (displayed values)
		tracker.setStormwindEpicProbability(nf.format(Double.valueOf(saveFileTokens[49].substring(21))));
		tracker.setBarrensEpicProbability(nf.format(Double.valueOf(saveFileTokens[50].substring(23))));
		tracker.setDarkmoonEpicProbability(nf.format(Double.valueOf(saveFileTokens[51].substring(31))));
		tracker.setScholomanceEpicProbability(nf.format(Double.valueOf(saveFileTokens[52].substring(21))));
		tracker.setOutlandEpicProbability(nf.format(Double.valueOf(saveFileTokens[53].substring(18))));
		tracker.setDragonsEpicProbability(nf.format(Double.valueOf(saveFileTokens[54].substring(20))));
		tracker.setUldumEpicProbability(nf.format(Double.valueOf(saveFileTokens[55].substring(18))));
		tracker.setShadowsEpicProbability(nf.format(Double.valueOf(saveFileTokens[56].substring(17))));
		tracker.setRumbleEpicProbability(nf.format(Double.valueOf(saveFileTokens[57].substring(20))));
		tracker.setBoomsdayEpicProbability(nf.format(Double.valueOf(saveFileTokens[58].substring(22))));
		tracker.setWitchwoodEpicProbability(nf.format(Double.valueOf(saveFileTokens[59].substring(15))));
		tracker.setKoboldsEpicProbability(nf.format(Double.valueOf(saveFileTokens[60].substring(21))));
		tracker.setKnightsEpicProbability(nf.format(Double.valueOf(saveFileTokens[61].substring(30))));
		tracker.setUngoroEpicProbability(nf.format(Double.valueOf(saveFileTokens[62].substring(20))));
		tracker.setGadgetzanEpicProbability(nf.format(Double.valueOf(saveFileTokens[63].substring(27))));
		tracker.setOldGodsEpicProbability(nf.format(Double.valueOf(saveFileTokens[64].substring(26))));
		tracker.setTournamentEpicProbability(nf.format(Double.valueOf(saveFileTokens[65].substring(22))));
		tracker.setGoblinsEpicProbability(nf.format(Double.valueOf(saveFileTokens[66].substring(19))));
		tracker.setClassicEpicProbability(nf.format(Double.valueOf(saveFileTokens[67].substring(9))));
		
		// Epic probabilities (internal values)
		stormwindEpicProbability = Double.valueOf(tracker.getStormwindEpicProbability());
		barrensEpicProbability = Double.valueOf(tracker.getBarrensEpicProbability());
		darkmoonEpicProbability = Double.valueOf(tracker.getDarkmoonEpicProbability());
		scholomanceEpicProbability = Double.valueOf(tracker.getScholomanceEpicProbability());
		outlandEpicProbability = Double.valueOf(tracker.getOutlandEpicProbability());
		dragonsEpicProbability = Double.valueOf(tracker.getDragonsEpicProbability());
		uldumEpicProbability = Double.valueOf(tracker.getUldumEpicProbability());
		shadowsEpicProbability = Double.valueOf(tracker.getShadowsEpicProbability());
		rumbleEpicProbability = Double.valueOf(tracker.getRumbleEpicProbability());
		boomsdayEpicProbability = Double.valueOf(tracker.getBoomsdayEpicProbability());
		witchwoodEpicProbability = Double.valueOf(tracker.getWitchwoodEpicProbability());
		koboldsEpicProbability = Double.valueOf(tracker.getKoboldsEpicProbability());
		knightsEpicProbability = Double.valueOf(tracker.getKnightsEpicProbability());
		ungoroEpicProbability = Double.valueOf(tracker.getUngoroEpicProbability());
		gadgetzanEpicProbability = Double.valueOf(tracker.getGadgetzanEpicProbability());
		oldGodsEpicProbability = Double.valueOf(tracker.getOldGodsEpicProbability());
		tournamentEpicProbability = Double.valueOf(tracker.getTournamentEpicProbability());
		goblinsEpicProbability = Double.valueOf(tracker.getGoblinsEpicProbability());
		classicEpicProbability = Double.valueOf(tracker.getClassicEpicProbability());
		
		// Legendary counters (displayed values)
		tracker.setStormwindLegendaryCounter(saveFileTokens[72].substring(21));
		tracker.setBarrensLegendaryCounter(saveFileTokens[73].substring(23));
		tracker.setDarkmoonLegendaryCounter(saveFileTokens[74].substring(31));
		tracker.setScholomanceLegendaryCounter(saveFileTokens[75].substring(21));
		tracker.setOutlandLegendaryCounter(saveFileTokens[76].substring(18));
		tracker.setDragonsLegendaryCounter(saveFileTokens[77].substring(20));
		tracker.setUldumLegendaryCounter(saveFileTokens[78].substring(18));
		tracker.setShadowsLegendaryCounter(saveFileTokens[79].substring(17));
		tracker.setRumbleLegendaryCounter(saveFileTokens[80].substring(20));
		tracker.setBoomsdayLegendaryCounter(saveFileTokens[81].substring(22));
		tracker.setWitchwoodLegendaryCounter(saveFileTokens[82].substring(15));
		tracker.setKoboldsLegendaryCounter(saveFileTokens[83].substring(21));
		tracker.setKnightsLegendaryCounter(saveFileTokens[84].substring(30));
		tracker.setUngoroLegendaryCounter(saveFileTokens[85].substring(20));
		tracker.setGadgetzanLegendaryCounter(saveFileTokens[86].substring(27));
		tracker.setOldGodsLegendaryCounter(saveFileTokens[87].substring(26));
		tracker.setTournamentLegendaryCounter(saveFileTokens[88].substring(22));
		tracker.setGoblinsLegendaryCounter(saveFileTokens[89].substring(19));
		tracker.setClassicLegendaryCounter(saveFileTokens[90].substring(9));
		
		// Legendary counters (internal values)
		stormwindLegendaryCounter = Integer.valueOf(tracker.getStormwindLegendaryCounter());
		barrensLegendaryCounter = Integer.valueOf(tracker.getBarrensLegendaryCounter());
		darkmoonLegendaryCounter = Integer.valueOf(tracker.getDarkmoonLegendaryCounter());
		scholomanceLegendaryCounter = Integer.valueOf(tracker.getScholomanceLegendaryCounter());
		outlandLegendaryCounter = Integer.valueOf(tracker.getOutlandLegendaryCounter());
		dragonsLegendaryCounter = Integer.valueOf(tracker.getDragonsLegendaryCounter());
		uldumLegendaryCounter = Integer.valueOf(tracker.getUldumLegendaryCounter());
		shadowsLegendaryCounter = Integer.valueOf(tracker.getShadowsLegendaryCounter());
		rumbleLegendaryCounter = Integer.valueOf(tracker.getRumbleLegendaryCounter());
		boomsdayLegendaryCounter = Integer.valueOf(tracker.getBoomsdayLegendaryCounter());
		witchwoodLegendaryCounter = Integer.valueOf(tracker.getWitchwoodLegendaryCounter());
		koboldsLegendaryCounter = Integer.valueOf(tracker.getKoboldsLegendaryCounter());
		knightsLegendaryCounter = Integer.valueOf(tracker.getKnightsLegendaryCounter());
		ungoroLegendaryCounter = Integer.valueOf(tracker.getUngoroLegendaryCounter());
		gadgetzanLegendaryCounter = Integer.valueOf(tracker.getGadgetzanLegendaryCounter());
		oldGodsLegendaryCounter = Integer.valueOf(tracker.getOldGodsLegendaryCounter());
		tournamentLegendaryCounter = Integer.valueOf(tracker.getTournamentLegendaryCounter());
		goblinsLegendaryCounter = Integer.valueOf(tracker.getGoblinsLegendaryCounter());
		classicLegendaryCounter = Integer.valueOf(tracker.getClassicLegendaryCounter());
		
		// Legendary probabilities (displayed values)
		tracker.setStormwindLegendaryProbability(nf.format(Double.valueOf(saveFileTokens[93].substring(21))));
		tracker.setBarrensLegendaryProbability(nf.format(Double.valueOf(saveFileTokens[94].substring(23))));
		tracker.setDarkmoonLegendaryProbability(nf.format(Double.valueOf(saveFileTokens[95].substring(31))));
		tracker.setScholomanceLegendaryProbability(nf.format(Double.valueOf(saveFileTokens[96].substring(21))));
		tracker.setOutlandLegendaryProbability(nf.format(Double.valueOf(saveFileTokens[97].substring(18))));
		tracker.setDragonsLegendaryProbability(nf.format(Double.valueOf(saveFileTokens[98].substring(20))));
		tracker.setUldumLegendaryProbability(nf.format(Double.valueOf(saveFileTokens[99].substring(18))));
		tracker.setShadowsLegendaryProbability(nf.format(Double.valueOf(saveFileTokens[100].substring(17))));
		tracker.setRumbleLegendaryProbability(nf.format(Double.valueOf(saveFileTokens[101].substring(20))));
		tracker.setBoomsdayLegendaryProbability(nf.format(Double.valueOf(saveFileTokens[102].substring(22))));
		tracker.setWitchwoodLegendaryProbability(nf.format(Double.valueOf(saveFileTokens[103].substring(15))));
		tracker.setKoboldsLegendaryProbability(nf.format(Double.valueOf(saveFileTokens[104].substring(21))));
		tracker.setKnightsLegendaryProbability(nf.format(Double.valueOf(saveFileTokens[105].substring(30))));
		tracker.setUngoroLegendaryProbability(nf.format(Double.valueOf(saveFileTokens[106].substring(20))));
		tracker.setGadgetzanLegendaryProbability(nf.format(Double.valueOf(saveFileTokens[107].substring(27))));
		tracker.setOldGodsLegendaryProbability(nf.format(Double.valueOf(saveFileTokens[108].substring(26))));
		tracker.setTournamentLegendaryProbability(nf.format(Double.valueOf(saveFileTokens[109].substring(22))));
		tracker.setGoblinsLegendaryProbability(nf.format(Double.valueOf(saveFileTokens[110].substring(19))));
		tracker.setClassicLegendaryProbability(nf.format(Double.valueOf(saveFileTokens[111].substring(9))));
		
		// Legendary probabilities (internal values)
		stormwindLegendaryProbability = Double.valueOf(tracker.getStormwindLegendaryProbability());
		barrensLegendaryProbability = Double.valueOf(tracker.getBarrensLegendaryProbability());
		darkmoonLegendaryProbability = Double.valueOf(tracker.getDarkmoonLegendaryProbability());
		scholomanceLegendaryProbability = Double.valueOf(tracker.getScholomanceLegendaryProbability());
		outlandLegendaryProbability = Double.valueOf(tracker.getOutlandLegendaryProbability());
		dragonsLegendaryProbability = Double.valueOf(tracker.getDragonsLegendaryProbability());
		uldumLegendaryProbability = Double.valueOf(tracker.getUldumLegendaryProbability());
		shadowsLegendaryProbability = Double.valueOf(tracker.getShadowsLegendaryProbability());
		rumbleLegendaryProbability = Double.valueOf(tracker.getRumbleLegendaryProbability());
		boomsdayLegendaryProbability = Double.valueOf(tracker.getBoomsdayLegendaryProbability());
		witchwoodLegendaryProbability = Double.valueOf(tracker.getWitchwoodLegendaryProbability());
		koboldsLegendaryProbability = Double.valueOf(tracker.getKoboldsLegendaryProbability());
		knightsLegendaryProbability = Double.valueOf(tracker.getKnightsLegendaryProbability());
		ungoroLegendaryProbability = Double.valueOf(tracker.getUngoroLegendaryProbability());
		gadgetzanLegendaryProbability = Double.valueOf(tracker.getGadgetzanLegendaryProbability());
		oldGodsLegendaryProbability = Double.valueOf(tracker.getOldGodsLegendaryProbability());
		tournamentLegendaryProbability = Double.valueOf(tracker.getTournamentLegendaryProbability());
		goblinsLegendaryProbability = Double.valueOf(tracker.getGoblinsLegendaryProbability());
		classicLegendaryProbability = Double.valueOf(tracker.getClassicLegendaryProbability());
		
		// Total counters (displayed values)
		tracker.setStormwindTotalCounter(saveFileTokens[116].substring(21));
		tracker.setBarrensTotalCounter(saveFileTokens[117].substring(23));
		tracker.setDarkmoonTotalCounter(saveFileTokens[118].substring(31));
		tracker.setScholomanceTotalCounter(saveFileTokens[119].substring(21));
		tracker.setOutlandTotalCounter(saveFileTokens[120].substring(18));
		tracker.setDragonsTotalCounter(saveFileTokens[121].substring(20));
		tracker.setUldumTotalCounter(saveFileTokens[122].substring(18));
		tracker.setShadowsTotalCounter(saveFileTokens[123].substring(17));
		tracker.setRumbleTotalCounter(saveFileTokens[124].substring(20));
		tracker.setBoomsdayTotalCounter(saveFileTokens[125].substring(22));
		tracker.setWitchwoodTotalCounter(saveFileTokens[126].substring(15));
		tracker.setKoboldsTotalCounter(saveFileTokens[127].substring(21));
		tracker.setKnightsTotalCounter(saveFileTokens[128].substring(30));
		tracker.setUngoroTotalCounter(saveFileTokens[129].substring(20));
		tracker.setGadgetzanTotalCounter(saveFileTokens[130].substring(27));
		tracker.setOldGodsTotalCounter(saveFileTokens[131].substring(26));
		tracker.setTournamentTotalCounter(saveFileTokens[132].substring(22));
		tracker.setGoblinsTotalCounter(saveFileTokens[133].substring(19));
		tracker.setClassicTotalCounter(saveFileTokens[134].substring(9));
		
		// Total counters (internal values)
		stormwindTotalCounter = Integer.valueOf(tracker.getStormwindTotalCounter());
		barrensTotalCounter = Integer.valueOf(tracker.getBarrensTotalCounter());
		darkmoonTotalCounter = Integer.valueOf(tracker.getDarkmoonTotalCounter());
		scholomanceTotalCounter = Integer.valueOf(tracker.getScholomanceTotalCounter());
		outlandTotalCounter = Integer.valueOf(tracker.getOutlandTotalCounter());
		dragonsTotalCounter = Integer.valueOf(tracker.getDragonsTotalCounter());
		uldumTotalCounter = Integer.valueOf(tracker.getUldumTotalCounter());
		shadowsTotalCounter = Integer.valueOf(tracker.getShadowsTotalCounter());
		rumbleTotalCounter = Integer.valueOf(tracker.getRumbleTotalCounter());
		boomsdayTotalCounter = Integer.valueOf(tracker.getBoomsdayTotalCounter());
		witchwoodTotalCounter = Integer.valueOf(tracker.getWitchwoodTotalCounter());
		koboldsTotalCounter = Integer.valueOf(tracker.getKoboldsTotalCounter());
		knightsTotalCounter = Integer.valueOf(tracker.getKnightsTotalCounter());
		ungoroTotalCounter = Integer.valueOf(tracker.getUngoroTotalCounter());
		gadgetzanTotalCounter = Integer.valueOf(tracker.getGadgetzanTotalCounter());
		oldGodsTotalCounter = Integer.valueOf(tracker.getOldGodsTotalCounter());
		tournamentTotalCounter = Integer.valueOf(tracker.getTournamentTotalCounter());
		goblinsTotalCounter = Integer.valueOf(tracker.getGoblinsTotalCounter());
		classicTotalCounter = Integer.valueOf(tracker.getClassicTotalCounter());
	}
	
	// Initializes the modify buttons
	private void modifyButtonsInitialization() 
	{
		// Epic reset buttons
		stormwindEpicReset = tracker.getStormwindEpicReset();
		barrensEpicReset = tracker.getBarrensEpicReset();
		darkmoonEpicReset = tracker.getDarkmoonEpicReset();
		scholomanceEpicReset = tracker.getScholomanceEpicReset();
		outlandEpicReset = tracker.getOutlandEpicReset();
		dragonsEpicReset = tracker.getDragonsEpicReset();
		uldumEpicReset = tracker.getUldumEpicReset();
		shadowsEpicReset = tracker.getShadowsEpicReset();
		rumbleEpicReset = tracker.getRumbleEpicReset();
		boomsdayEpicReset = tracker.getBoomsdayEpicReset();
		witchwoodEpicReset = tracker.getWitchwoodEpicReset();
		koboldsEpicReset = tracker.getKoboldsEpicReset();
		knightsEpicReset = tracker.getKnightsEpicReset();
		ungoroEpicReset = tracker.getUngoroEpicReset();
		gadgetzanEpicReset = tracker.getGadgetzanEpicReset();
		oldGodsEpicReset = tracker.getOldGodsEpicReset();
		tournamentEpicReset = tracker.getTournamentEpicReset();
		goblinsEpicReset = tracker.getGoblinsEpicReset();
		classicEpicReset = tracker.getClassicEpicReset();
		
		epicResetButtons = new ArrayList<ModifierButton>();
		
		epicResetButtons.add(classicEpicReset);
		epicResetButtons.add(goblinsEpicReset);
		epicResetButtons.add(tournamentEpicReset);
		epicResetButtons.add(oldGodsEpicReset);
		epicResetButtons.add(gadgetzanEpicReset);
		epicResetButtons.add(ungoroEpicReset);
		epicResetButtons.add(knightsEpicReset);
		epicResetButtons.add(koboldsEpicReset);
		epicResetButtons.add(witchwoodEpicReset);
		epicResetButtons.add(boomsdayEpicReset);
		epicResetButtons.add(rumbleEpicReset);
		epicResetButtons.add(shadowsEpicReset);
		epicResetButtons.add(uldumEpicReset);
		epicResetButtons.add(dragonsEpicReset);
		epicResetButtons.add(outlandEpicReset);
		epicResetButtons.add(scholomanceEpicReset);
		epicResetButtons.add(darkmoonEpicReset);
		epicResetButtons.add(barrensEpicReset);
		epicResetButtons.add(stormwindEpicReset);
		
		// Epic add buttons
		stormwindEpicAdd = tracker.getStormwindEpicAdd();
		barrensEpicAdd = tracker.getBarrensEpicAdd();
		darkmoonEpicAdd = tracker.getDarkmoonEpicAdd();
		scholomanceEpicAdd = tracker.getScholomanceEpicAdd();
		outlandEpicAdd = tracker.getOutlandEpicAdd();
		dragonsEpicAdd = tracker.getDragonsEpicAdd();
		uldumEpicAdd = tracker.getUldumEpicAdd();
		shadowsEpicAdd = tracker.getShadowsEpicAdd();
		rumbleEpicAdd = tracker.getRumbleEpicAdd();
		boomsdayEpicAdd = tracker.getBoomsdayEpicAdd();
		witchwoodEpicAdd = tracker.getWitchwoodEpicAdd();
		koboldsEpicAdd = tracker.getKoboldsEpicAdd();
		knightsEpicAdd = tracker.getKnightsEpicAdd();
		ungoroEpicAdd = tracker.getUngoroEpicAdd();
		gadgetzanEpicAdd = tracker.getGadgetzanEpicAdd();
		oldGodsEpicAdd = tracker.getOldGodsEpicAdd();
		tournamentEpicAdd = tracker.getTournamentEpicAdd();
		goblinsEpicAdd = tracker.getGoblinsEpicAdd();
		classicEpicAdd = tracker.getClassicEpicAdd();
		
		epicAddButtons = new ArrayList<RoundButton>();
		
		epicAddButtons.add(classicEpicAdd);
		epicAddButtons.add(goblinsEpicAdd);
		epicAddButtons.add(tournamentEpicAdd);
		epicAddButtons.add(oldGodsEpicAdd);
		epicAddButtons.add(gadgetzanEpicAdd);
		epicAddButtons.add(ungoroEpicAdd);
		epicAddButtons.add(knightsEpicAdd);
		epicAddButtons.add(koboldsEpicAdd);
		epicAddButtons.add(witchwoodEpicAdd);
		epicAddButtons.add(boomsdayEpicAdd);
		epicAddButtons.add(rumbleEpicAdd);
		epicAddButtons.add(shadowsEpicAdd);
		epicAddButtons.add(uldumEpicAdd);
		epicAddButtons.add(dragonsEpicAdd);
		epicAddButtons.add(outlandEpicAdd);
		epicAddButtons.add(scholomanceEpicAdd);
		epicAddButtons.add(darkmoonEpicAdd);
		epicAddButtons.add(barrensEpicAdd);
		epicAddButtons.add(stormwindEpicAdd);
		
		// Epic increment fields
		stormwindEpicIncrement = tracker.getStormwindEpicIncrement();
		barrensEpicIncrement = tracker.getBarrensEpicIncrement();
		darkmoonEpicIncrement = tracker.getDarkmoonEpicIncrement();
		scholomanceEpicIncrement = tracker.getScholomanceEpicIncrement();
		outlandEpicIncrement = tracker.getOutlandEpicIncrement();
		dragonsEpicIncrement = tracker.getDragonsEpicIncrement();
		uldumEpicIncrement = tracker.getUldumEpicIncrement();
		shadowsEpicIncrement = tracker.getShadowsEpicIncrement();
		rumbleEpicIncrement = tracker.getRumbleEpicIncrement();
		boomsdayEpicIncrement = tracker.getBoomsdayEpicIncrement();
		witchwoodEpicIncrement = tracker.getWitchwoodEpicIncrement();
		koboldsEpicIncrement = tracker.getKoboldsEpicIncrement();
		knightsEpicIncrement = tracker.getKnightsEpicIncrement();
		ungoroEpicIncrement = tracker.getUngoroEpicIncrement();
		gadgetzanEpicIncrement = tracker.getGadgetzanEpicIncrement();
		oldGodsEpicIncrement = tracker.getOldGodsEpicIncrement();
		tournamentEpicIncrement = tracker.getTournamentEpicIncrement();
		goblinsEpicIncrement = tracker.getGoblinsEpicIncrement();
		classicEpicIncrement = tracker.getClassicEpicIncrement();
		
		// Legendary reset buttons
		stormwindLegendaryReset = tracker.getStormwindLegendaryReset();
		barrensLegendaryReset = tracker.getBarrensLegendaryReset();
		darkmoonLegendaryReset = tracker.getDarkmoonLegendaryReset();
		scholomanceLegendaryReset = tracker.getScholomanceLegendaryReset();
		outlandLegendaryReset = tracker.getOutlandLegendaryReset();
		dragonsLegendaryReset = tracker.getDragonsLegendaryReset();
		uldumLegendaryReset = tracker.getUldumLegendaryReset();
		shadowsLegendaryReset = tracker.getShadowsLegendaryReset();
		rumbleLegendaryReset = tracker.getRumbleLegendaryReset();
		boomsdayLegendaryReset = tracker.getBoomsdayLegendaryReset();
		witchwoodLegendaryReset = tracker.getWitchwoodLegendaryReset();
		koboldsLegendaryReset = tracker.getKoboldsLegendaryReset();
		knightsLegendaryReset = tracker.getKnightsLegendaryReset();
		ungoroLegendaryReset = tracker.getUngoroLegendaryReset();
		gadgetzanLegendaryReset = tracker.getGadgetzanLegendaryReset();
		oldGodsLegendaryReset = tracker.getOldGodsLegendaryReset();
		tournamentLegendaryReset = tracker.getTournamentLegendaryReset();
		goblinsLegendaryReset = tracker.getGoblinsLegendaryReset();
		classicLegendaryReset = tracker.getClassicLegendaryReset();
		
		legendaryResetButtons = new ArrayList<ModifierButton>();
		
		legendaryResetButtons.add(classicLegendaryReset);
		legendaryResetButtons.add(goblinsLegendaryReset);
		legendaryResetButtons.add(tournamentLegendaryReset);
		legendaryResetButtons.add(oldGodsLegendaryReset);
		legendaryResetButtons.add(gadgetzanLegendaryReset);
		legendaryResetButtons.add(ungoroLegendaryReset);
		legendaryResetButtons.add(knightsLegendaryReset);
		legendaryResetButtons.add(koboldsLegendaryReset);
		legendaryResetButtons.add(witchwoodLegendaryReset);
		legendaryResetButtons.add(boomsdayLegendaryReset);
		legendaryResetButtons.add(rumbleLegendaryReset);
		legendaryResetButtons.add(shadowsLegendaryReset);
		legendaryResetButtons.add(uldumLegendaryReset);
		legendaryResetButtons.add(dragonsLegendaryReset);
		legendaryResetButtons.add(outlandLegendaryReset);
		legendaryResetButtons.add(scholomanceLegendaryReset);
		legendaryResetButtons.add(darkmoonLegendaryReset);
		legendaryResetButtons.add(barrensLegendaryReset);
		legendaryResetButtons.add(stormwindLegendaryReset);
		
		// Legendary add buttons
		stormwindLegendaryAdd = tracker.getStormwindLegendaryAdd();
		barrensLegendaryAdd = tracker.getBarrensLegendaryAdd();
		darkmoonLegendaryAdd = tracker.getDarkmoonLegendaryAdd();
		scholomanceLegendaryAdd = tracker.getScholomanceLegendaryAdd();
		outlandLegendaryAdd = tracker.getOutlandLegendaryAdd();
		dragonsLegendaryAdd = tracker.getDragonsLegendaryAdd();
		uldumLegendaryAdd = tracker.getUldumLegendaryAdd();
		shadowsLegendaryAdd = tracker.getShadowsLegendaryAdd();
		rumbleLegendaryAdd = tracker.getRumbleLegendaryAdd();
		boomsdayLegendaryAdd = tracker.getBoomsdayLegendaryAdd();
		witchwoodLegendaryAdd = tracker.getWitchwoodLegendaryAdd();
		koboldsLegendaryAdd = tracker.getKoboldsLegendaryAdd();
		knightsLegendaryAdd = tracker.getKnightsLegendaryAdd();
		ungoroLegendaryAdd = tracker.getUngoroLegendaryAdd();
		gadgetzanLegendaryAdd = tracker.getGadgetzanLegendaryAdd();
		oldGodsLegendaryAdd = tracker.getOldGodsLegendaryAdd();
		tournamentLegendaryAdd = tracker.getTournamentLegendaryAdd();
		goblinsLegendaryAdd = tracker.getGoblinsLegendaryAdd();
		classicLegendaryAdd = tracker.getClassicLegendaryAdd();
		
		legendaryAddButtons = new ArrayList<RoundButton>();
		
		legendaryAddButtons.add(classicLegendaryAdd);
		legendaryAddButtons.add(goblinsLegendaryAdd);
		legendaryAddButtons.add(tournamentLegendaryAdd);
		legendaryAddButtons.add(oldGodsLegendaryAdd);
		legendaryAddButtons.add(gadgetzanLegendaryAdd);
		legendaryAddButtons.add(ungoroLegendaryAdd);
		legendaryAddButtons.add(knightsLegendaryAdd);
		legendaryAddButtons.add(koboldsLegendaryAdd);
		legendaryAddButtons.add(witchwoodLegendaryAdd);
		legendaryAddButtons.add(boomsdayLegendaryAdd);
		legendaryAddButtons.add(rumbleLegendaryAdd);
		legendaryAddButtons.add(shadowsLegendaryAdd);
		legendaryAddButtons.add(uldumLegendaryAdd);
		legendaryAddButtons.add(dragonsLegendaryAdd);
		legendaryAddButtons.add(outlandLegendaryAdd);
		legendaryAddButtons.add(scholomanceLegendaryAdd);
		legendaryAddButtons.add(darkmoonLegendaryAdd);
		legendaryAddButtons.add(barrensLegendaryAdd);
		legendaryAddButtons.add(stormwindLegendaryAdd);
		
		// Legendary increment fields
		stormwindLegendaryIncrement = tracker.getStormwindLegendaryIncrement();
		barrensLegendaryIncrement = tracker.getBarrensLegendaryIncrement();
		darkmoonLegendaryIncrement = tracker.getDarkmoonLegendaryIncrement();
		scholomanceLegendaryIncrement = tracker.getScholomanceLegendaryIncrement();
		outlandLegendaryIncrement = tracker.getOutlandLegendaryIncrement();
		dragonsLegendaryIncrement = tracker.getDragonsLegendaryIncrement();
		uldumLegendaryIncrement = tracker.getUldumLegendaryIncrement();
		shadowsLegendaryIncrement = tracker.getShadowsLegendaryIncrement();
		rumbleLegendaryIncrement = tracker.getRumbleLegendaryIncrement();
		boomsdayLegendaryIncrement = tracker.getBoomsdayLegendaryIncrement();
		witchwoodLegendaryIncrement = tracker.getWitchwoodLegendaryIncrement();
		koboldsLegendaryIncrement = tracker.getKoboldsLegendaryIncrement();
		knightsLegendaryIncrement = tracker.getKnightsLegendaryIncrement();
		ungoroLegendaryIncrement = tracker.getUngoroLegendaryIncrement();
		gadgetzanLegendaryIncrement = tracker.getGadgetzanLegendaryIncrement();
		oldGodsLegendaryIncrement = tracker.getOldGodsLegendaryIncrement();
		tournamentLegendaryIncrement = tracker.getTournamentLegendaryIncrement();
		goblinsLegendaryIncrement = tracker.getGoblinsLegendaryIncrement();
		classicLegendaryIncrement = tracker.getClassicLegendaryIncrement();
		
		// Total modify buttons
		stormwindTotalModify = tracker.getStormwindTotalModify();
		barrensTotalModify = tracker.getBarrensTotalModify();
		darkmoonTotalModify = tracker.getDarkmoonTotalModify();
		scholomanceTotalModify = tracker.getScholomanceTotalModify();
		outlandTotalModify = tracker.getOutlandTotalModify();
		dragonsTotalModify = tracker.getDragonsTotalModify();
		uldumTotalModify = tracker.getUldumTotalModify();
		shadowsTotalModify = tracker.getShadowsTotalModify();
		rumbleTotalModify = tracker.getRumbleTotalModify();
		boomsdayTotalModify = tracker.getBoomsdayTotalModify();
		witchwoodTotalModify = tracker.getWitchwoodTotalModify();
		koboldsTotalModify = tracker.getKoboldsTotalModify();
		knightsTotalModify = tracker.getKnightsTotalModify();
		ungoroTotalModify = tracker.getUngoroTotalModify();
		gadgetzanTotalModify = tracker.getGadgetzanTotalModify();
		oldGodsTotalModify = tracker.getOldGodsTotalModify();
		tournamentTotalModify = tracker.getTournamentTotalModify();
		goblinsTotalModify = tracker.getGoblinsTotalModify();
		classicTotalModify = tracker.getClassicTotalModify();
		
		totalModifyButtons = new ArrayList<ModifierButton>();
		
		totalModifyButtons.add(classicTotalModify);
		totalModifyButtons.add(goblinsTotalModify);
		totalModifyButtons.add(tournamentTotalModify);
		totalModifyButtons.add(oldGodsTotalModify);
		totalModifyButtons.add(gadgetzanTotalModify);
		totalModifyButtons.add(ungoroTotalModify);
		totalModifyButtons.add(knightsTotalModify);
		totalModifyButtons.add(koboldsTotalModify);
		totalModifyButtons.add(witchwoodTotalModify);
		totalModifyButtons.add(boomsdayTotalModify);
		totalModifyButtons.add(rumbleTotalModify);
		totalModifyButtons.add(shadowsTotalModify);
		totalModifyButtons.add(uldumTotalModify);
		totalModifyButtons.add(dragonsTotalModify);
		totalModifyButtons.add(outlandTotalModify);
		totalModifyButtons.add(scholomanceTotalModify);
		totalModifyButtons.add(darkmoonTotalModify);
		totalModifyButtons.add(barrensTotalModify);
		totalModifyButtons.add(stormwindTotalModify);
		
		// Total add buttons
		stormwindTotalAdd = tracker.getStormwindTotalAdd();
		barrensTotalAdd = tracker.getBarrensTotalAdd();
		darkmoonTotalAdd = tracker.getDarkmoonTotalAdd();
		scholomanceTotalAdd = tracker.getScholomanceTotalAdd();
		outlandTotalAdd = tracker.getOutlandTotalAdd();
		dragonsTotalAdd = tracker.getDragonsTotalAdd();
		uldumTotalAdd = tracker.getUldumTotalAdd();
		shadowsTotalAdd = tracker.getShadowsTotalAdd();
		rumbleTotalAdd = tracker.getRumbleTotalAdd();
		boomsdayTotalAdd = tracker.getBoomsdayTotalAdd();
		witchwoodTotalAdd = tracker.getWitchwoodTotalAdd();
		koboldsTotalAdd = tracker.getKoboldsTotalAdd();
		knightsTotalAdd = tracker.getKnightsTotalAdd();
		ungoroTotalAdd = tracker.getUngoroTotalAdd();
		gadgetzanTotalAdd = tracker.getGadgetzanTotalAdd();
		oldGodsTotalAdd = tracker.getOldGodsTotalAdd();
		tournamentTotalAdd = tracker.getTournamentTotalAdd();
		goblinsTotalAdd = tracker.getGoblinsTotalAdd();
		classicTotalAdd = tracker.getClassicTotalAdd();
		
		totalAddButtons = new ArrayList<RoundButton>();
		
		totalAddButtons.add(classicTotalAdd);
		totalAddButtons.add(goblinsTotalAdd);
		totalAddButtons.add(tournamentTotalAdd);
		totalAddButtons.add(oldGodsTotalAdd);
		totalAddButtons.add(gadgetzanTotalAdd);
		totalAddButtons.add(ungoroTotalAdd);
		totalAddButtons.add(knightsTotalAdd);
		totalAddButtons.add(koboldsTotalAdd);
		totalAddButtons.add(witchwoodTotalAdd);
		totalAddButtons.add(boomsdayTotalAdd);
		totalAddButtons.add(rumbleTotalAdd);
		totalAddButtons.add(shadowsTotalAdd);
		totalAddButtons.add(uldumTotalAdd);
		totalAddButtons.add(dragonsTotalAdd);
		totalAddButtons.add(outlandTotalAdd);
		totalAddButtons.add(scholomanceTotalAdd);
		totalAddButtons.add(darkmoonTotalAdd);
		totalAddButtons.add(barrensTotalAdd);
		totalAddButtons.add(stormwindTotalAdd);
		
		// Total increment fields
		stormwindTotalIncrement = tracker.getStormwindTotalIncrement();
		barrensTotalIncrement = tracker.getBarrensTotalIncrement();
		darkmoonTotalIncrement = tracker.getDarkmoonTotalIncrement();
		scholomanceTotalIncrement = tracker.getScholomanceTotalIncrement();
		outlandTotalIncrement = tracker.getOutlandTotalIncrement();
		dragonsTotalIncrement = tracker.getDragonsTotalIncrement();
		uldumTotalIncrement = tracker.getUldumTotalIncrement();
		shadowsTotalIncrement = tracker.getShadowsTotalIncrement();
		rumbleTotalIncrement = tracker.getRumbleTotalIncrement();
		boomsdayTotalIncrement = tracker.getBoomsdayTotalIncrement();
		witchwoodTotalIncrement = tracker.getWitchwoodTotalIncrement();
		koboldsTotalIncrement = tracker.getKoboldsTotalIncrement();
		knightsTotalIncrement = tracker.getKnightsTotalIncrement();
		ungoroTotalIncrement = tracker.getUngoroTotalIncrement();
		gadgetzanTotalIncrement = tracker.getGadgetzanTotalIncrement();
		oldGodsTotalIncrement = tracker.getOldGodsTotalIncrement();
		tournamentTotalIncrement = tracker.getTournamentTotalIncrement();
		goblinsTotalIncrement = tracker.getGoblinsTotalIncrement();
		classicTotalIncrement = tracker.getClassicTotalIncrement();
	}
	
	// Initializes the rarity buttons
	private void rarityButtonsInitialization() 
	{
		// Common buttons
		stormwindCommonButton = tracker.getStormwindCommonButton();
		barrensCommonButton = tracker.getBarrensCommonButton();
		darkmoonCommonButton = tracker.getDarkmoonCommonButton();
		scholomanceCommonButton = tracker.getScholomanceCommonButton();
		outlandCommonButton = tracker.getOutlandCommonButton();
		dragonsCommonButton = tracker.getDragonsCommonButton();
		uldumCommonButton = tracker.getUldumCommonButton();
		shadowsCommonButton = tracker.getShadowsCommonButton();
		rumbleCommonButton = tracker.getRumbleCommonButton();
		boomsdayCommonButton = tracker.getBoomsdayCommonButton();
		witchwoodCommonButton = tracker.getWitchwoodCommonButton();
		koboldsCommonButton = tracker.getKoboldsCommonButton();
		knightsCommonButton = tracker.getKnightsCommonButton();
		ungoroCommonButton = tracker.getUngoroCommonButton();
		gadgetzanCommonButton = tracker.getGadgetzanCommonButton();
		oldGodsCommonButton = tracker.getOldGodsCommonButton();
		tournamentCommonButton = tracker.getTournamentCommonButton();
		goblinsCommonButton = tracker.getGoblinsCommonButton();
		classicCommonButton = tracker.getClassicCommonButton();
		
		commonButtons = new ArrayList<IconButton>();
		
		commonButtons.add(classicCommonButton);
		commonButtons.add(goblinsCommonButton);
		commonButtons.add(tournamentCommonButton);
		commonButtons.add(oldGodsCommonButton);
		commonButtons.add(gadgetzanCommonButton);
		commonButtons.add(ungoroCommonButton);
		commonButtons.add(knightsCommonButton);
		commonButtons.add(koboldsCommonButton);
		commonButtons.add(witchwoodCommonButton);
		commonButtons.add(boomsdayCommonButton);
		commonButtons.add(rumbleCommonButton);
		commonButtons.add(shadowsCommonButton);
		commonButtons.add(uldumCommonButton);
		commonButtons.add(dragonsCommonButton);
		commonButtons.add(outlandCommonButton);
		commonButtons.add(scholomanceCommonButton);
		commonButtons.add(darkmoonCommonButton);
		commonButtons.add(barrensCommonButton);
		commonButtons.add(stormwindCommonButton);
		
		// Rare buttons
		stormwindRareButton = tracker.getStormwindRareButton();
		barrensRareButton = tracker.getBarrensRareButton();
		darkmoonRareButton = tracker.getDarkmoonRareButton();
		scholomanceRareButton = tracker.getScholomanceRareButton();
		outlandRareButton = tracker.getOutlandRareButton();
		dragonsRareButton = tracker.getDragonsRareButton();
		uldumRareButton = tracker.getUldumRareButton();
		shadowsRareButton = tracker.getShadowsRareButton();
		rumbleRareButton = tracker.getRumbleRareButton();
		boomsdayRareButton = tracker.getBoomsdayRareButton();
		witchwoodRareButton = tracker.getWitchwoodRareButton();
		koboldsRareButton = tracker.getKoboldsRareButton();
		knightsRareButton = tracker.getKnightsRareButton();
		ungoroRareButton = tracker.getUngoroRareButton();
		gadgetzanRareButton = tracker.getGadgetzanRareButton();
		oldGodsRareButton = tracker.getOldGodsRareButton();
		tournamentRareButton = tracker.getTournamentRareButton();
		goblinsRareButton = tracker.getGoblinsRareButton();
		classicRareButton = tracker.getClassicRareButton();
		
		rareButtons = new ArrayList<IconButton>();
		
		rareButtons.add(classicRareButton);
		rareButtons.add(goblinsRareButton);
		rareButtons.add(tournamentRareButton);
		rareButtons.add(oldGodsRareButton);
		rareButtons.add(gadgetzanRareButton);
		rareButtons.add(ungoroRareButton);
		rareButtons.add(knightsRareButton);
		rareButtons.add(koboldsRareButton);
		rareButtons.add(witchwoodRareButton);
		rareButtons.add(boomsdayRareButton);
		rareButtons.add(rumbleRareButton);
		rareButtons.add(shadowsRareButton);
		rareButtons.add(uldumRareButton);
		rareButtons.add(dragonsRareButton);
		rareButtons.add(outlandRareButton);
		rareButtons.add(scholomanceRareButton);
		rareButtons.add(darkmoonRareButton);
		rareButtons.add(barrensRareButton);
		rareButtons.add(stormwindRareButton);
		
		// Epic buttons
		stormwindEpicButton = tracker.getStormwindEpicButton();
		barrensEpicButton = tracker.getBarrensEpicButton();
		darkmoonEpicButton = tracker.getDarkmoonEpicButton();
		scholomanceEpicButton = tracker.getScholomanceEpicButton();
		outlandEpicButton = tracker.getOutlandEpicButton();
		dragonsEpicButton = tracker.getDragonsEpicButton();
		uldumEpicButton = tracker.getUldumEpicButton();
		shadowsEpicButton = tracker.getShadowsEpicButton();
		rumbleEpicButton = tracker.getRumbleEpicButton();
		boomsdayEpicButton = tracker.getBoomsdayEpicButton();
		witchwoodEpicButton = tracker.getWitchwoodEpicButton();
		koboldsEpicButton = tracker.getKoboldsEpicButton();
		knightsEpicButton = tracker.getKnightsEpicButton();
		ungoroEpicButton = tracker.getUngoroEpicButton();
		gadgetzanEpicButton = tracker.getGadgetzanEpicButton();
		oldGodsEpicButton = tracker.getOldGodsEpicButton();
		tournamentEpicButton = tracker.getTournamentEpicButton();
		goblinsEpicButton = tracker.getGoblinsEpicButton();
		classicEpicButton = tracker.getClassicEpicButton();
		
		epicButtons = new ArrayList<IconButton>();
		
		epicButtons.add(classicEpicButton);
		epicButtons.add(goblinsEpicButton);
		epicButtons.add(tournamentEpicButton);
		epicButtons.add(oldGodsEpicButton);
		epicButtons.add(gadgetzanEpicButton);
		epicButtons.add(ungoroEpicButton);
		epicButtons.add(knightsEpicButton);
		epicButtons.add(koboldsEpicButton);
		epicButtons.add(witchwoodEpicButton);
		epicButtons.add(boomsdayEpicButton);
		epicButtons.add(rumbleEpicButton);
		epicButtons.add(shadowsEpicButton);
		epicButtons.add(uldumEpicButton);
		epicButtons.add(dragonsEpicButton);
		epicButtons.add(outlandEpicButton);
		epicButtons.add(scholomanceEpicButton);
		epicButtons.add(darkmoonEpicButton);
		epicButtons.add(barrensEpicButton);
		epicButtons.add(stormwindEpicButton);
		
		// Legendary buttons
		stormwindLegendaryButton = tracker.getStormwindLegendaryButton();
		barrensLegendaryButton = tracker.getBarrensLegendaryButton();
		darkmoonLegendaryButton = tracker.getDarkmoonLegendaryButton();
		scholomanceLegendaryButton = tracker.getScholomanceLegendaryButton();
		outlandLegendaryButton = tracker.getOutlandLegendaryButton();
		dragonsLegendaryButton = tracker.getDragonsLegendaryButton();
		uldumLegendaryButton = tracker.getUldumLegendaryButton();
		shadowsLegendaryButton = tracker.getShadowsLegendaryButton();
		rumbleLegendaryButton = tracker.getRumbleLegendaryButton();
		boomsdayLegendaryButton = tracker.getBoomsdayLegendaryButton();
		witchwoodLegendaryButton = tracker.getWitchwoodLegendaryButton();
		koboldsLegendaryButton = tracker.getKoboldsLegendaryButton();
		knightsLegendaryButton = tracker.getKnightsLegendaryButton();
		ungoroLegendaryButton = tracker.getUngoroLegendaryButton();
		gadgetzanLegendaryButton = tracker.getGadgetzanLegendaryButton();
		oldGodsLegendaryButton = tracker.getOldGodsLegendaryButton();
		tournamentLegendaryButton = tracker.getTournamentLegendaryButton();
		goblinsLegendaryButton = tracker.getGoblinsLegendaryButton();
		classicLegendaryButton = tracker.getClassicLegendaryButton();
		
		legendaryButtons = new ArrayList<IconButton>();
		
		legendaryButtons.add(classicLegendaryButton);
		legendaryButtons.add(goblinsLegendaryButton);
		legendaryButtons.add(tournamentLegendaryButton);
		legendaryButtons.add(oldGodsLegendaryButton);
		legendaryButtons.add(gadgetzanLegendaryButton);
		legendaryButtons.add(ungoroLegendaryButton);
		legendaryButtons.add(knightsLegendaryButton);
		legendaryButtons.add(koboldsLegendaryButton);
		legendaryButtons.add(witchwoodLegendaryButton);
		legendaryButtons.add(boomsdayLegendaryButton);
		legendaryButtons.add(rumbleLegendaryButton);
		legendaryButtons.add(shadowsLegendaryButton);
		legendaryButtons.add(uldumLegendaryButton);
		legendaryButtons.add(dragonsLegendaryButton);
		legendaryButtons.add(outlandLegendaryButton);
		legendaryButtons.add(scholomanceLegendaryButton);
		legendaryButtons.add(darkmoonLegendaryButton);
		legendaryButtons.add(barrensLegendaryButton);
		legendaryButtons.add(stormwindLegendaryButton);
	}
	
	// Adds action listeners to the tracker buttons
	private void trackerActionListeners() 
	{
		// "Help" button
		help.addActionListener(this);
		
		// "Show save file" button
		showSaveFileFolder.addActionListener(this);
		
		// Game Modes button
		standardButton.addActionListener(this);
		wildButton.addActionListener(this);
		
		// Years shortcut buttons
		gryphonShortcut.addActionListener(this);
		phoenixShortcut.addActionListener(this);
		dragonShortcut.addActionListener(this);
		ravenShortcut.addActionListener(this);
		mammothShortcut.addActionListener(this);
		krakenShortcut.addActionListener(this);
		classicSetsShortcut.addActionListener(this);
		
		// Expansions image buttons
		for (int i = 0; i < imageButtons.size(); i++) {
			imageButtons.get(i).addActionListener(this);
		}
		
		// Epic reset buttons
		for (int i = 0; i < epicResetButtons.size(); i++) {
			epicResetButtons.get(i).addActionListener(this);
		}
		
		// Epic add buttons
		for (int i = 0; i < epicAddButtons.size(); i++) {
			epicAddButtons.get(i).addActionListener(this);
		}
		
		// Legendary reset buttons
		for (int i = 0; i < legendaryResetButtons.size(); i++) {
			legendaryResetButtons.get(i).addActionListener(this);
		}
		
		// Legendary add buttons
		for (int i = 0; i < legendaryAddButtons.size(); i++) {
			legendaryAddButtons.get(i).addActionListener(this);
		}
		
		// Total modify buttons
		for (int i = 0; i < totalModifyButtons.size(); i++) {
			totalModifyButtons.get(i).addActionListener(this);
		}
		
		// Total add buttons
		for (int i = 0; i < totalAddButtons.size(); i++) {
			totalAddButtons.get(i).addActionListener(this);
		}
		
		// Common buttons
		for (int i = 0; i < commonButtons.size(); i++) {
			commonButtons.get(i).addActionListener(this);
		}
		
		// Rare buttons
		for (int i = 0; i < rareButtons.size(); i++) {
			rareButtons.get(i).addActionListener(this);
		}
		
		// Epic buttons
		for (int i = 0; i < epicButtons.size(); i++) {
			epicButtons.get(i).addActionListener(this);
		}
		
		// Legendary buttons
		for (int i = 0; i < legendaryButtons.size(); i++) {
			legendaryButtons.get(i).addActionListener(this);
		}
	}
	
	// Actions performed when the tracker buttons are clicked
	@Override
	public void actionPerformed(ActionEvent e) 
	{
		// "Help" button
		if (e.getSource() == help)
			JOptionPane.showMessageDialog(contentPane, helpPanel, helpTitle, JOptionPane.INFORMATION_MESSAGE);
		
		// "Show save file" button
		if (e.getSource() == showSaveFileFolder) {
			try {
				Runtime.getRuntime().exec("explorer.exe /select," + saveFilePath);
			} catch (IOException ex) {
				ex.printStackTrace();
			}
		}
		
		// Game Modes buttons
		if (e.getSource() == standardButton) 
			standardAction();
		
		if (e.getSource() == wildButton) 
			wildAction();
		
		// Years shortcut buttons
		for (int i = 0; i < shortcutButtons.size(); i++) {
			if (e.getSource() == shortcutButtons.get(i))
				shortcutButtonAction(i);
		}
		
		// Image buttons
		for (int i = 0; i < imageButtons.size(); i++) {
			if (e.getSource() == imageButtons.get(i))
				openWebpage(imageButtonsUrls.get(i));
		}
		
		// Epic reset buttons
		for (int i = 0; i < epicResetButtons.size(); i++) {
			if (e.getSource() == epicResetButtons.get(i))
				epicResetAction(i);
		}
		
		// Epic add buttons
		for (int i = 0; i < epicAddButtons.size(); i++) {
			if (e.getSource() == epicAddButtons.get(i))
				epicAddAction(i);
		}
		
		// Legendary reset buttons
		for (int i = 0; i < legendaryResetButtons.size(); i++) {
			if (e.getSource() == legendaryResetButtons.get(i))
				legendaryResetAction(i);
		}
		
		// Legendary add buttons
		for (int i = 0; i < legendaryAddButtons.size(); i++) {
			if (e.getSource() == legendaryAddButtons.get(i))
				legendaryAddAction(i);
		}
		
		// Total modify buttons
		for (int i = 0; i < totalModifyButtons.size(); i++) {
			if (e.getSource() == totalModifyButtons.get(i))
				totalModifyAction(i);
		}
		
		// Total add buttons
		for (int i = 0; i < totalAddButtons.size(); i++) {
			if (e.getSource() == totalAddButtons.get(i))
				totalAddAction(i);
		}
		
		// Common buttons
		for (int i = 0; i < commonButtons.size(); i++) {
			if (e.getSource() == commonButtons.get(i))
				openWebpage(commonButtonsUrls.get(i));
		}
		
		// Rare buttons
		for (int i = 0; i < rareButtons.size(); i++) {
			if (e.getSource() == rareButtons.get(i))
				openWebpage(rareButtonsUrls.get(i));
		}
		
		// Epic buttons
		for (int i = 0; i < epicButtons.size(); i++) {
			if (e.getSource() == epicButtons.get(i))
				openWebpage(epicButtonsUrls.get(i));
		}
		
		// Legendary buttons
		for (int i = 0; i < legendaryButtons.size(); i++) {
			if (e.getSource() == legendaryButtons.get(i))
				openWebpage(legendaryButtonsUrls.get(i));
		}
	}
	
	// Action performed when the "Standard sets" button is pressed
	private void standardAction() 
	{
		// Show Standard sets
		standard.setVisible(true);
		
		// Hide Wild sets
		wild.setVisible(false);
		
		// Selected Mode button customization
		standardButton.setBackground(setsSelectedColor);
		standardButton.addMouseListener(new java.awt.event.MouseAdapter() {
			@Override
		    public void mouseEntered(java.awt.event.MouseEvent evt) {
				standardButton.setBackground(setsSelectedColor);
		    }
			
		    @Override
		    public void mouseExited(java.awt.event.MouseEvent evt) {
		    	standardButton.setBackground(setsSelectedColor);
		    }
		});
		
		// Unselected Mode button customization
		wildButton.setBackground(setsColor);
		wildButton.addMouseListener(new java.awt.event.MouseAdapter() {
			@Override
		    public void mouseEntered(java.awt.event.MouseEvent evt) {
				wildButton.setBackground(setsHoverColor);
		    }
			
		    @Override
		    public void mouseExited(java.awt.event.MouseEvent evt) {
		    	wildButton.setBackground(setsColor);
		    }
		});
		
		// Show Standard Years shortcut buttons panel
		standardYearsShortcutsPanel.setVisible(true);
		// Hide Wild Years shortcut buttons panel
		wildYearsShortcutsPanel.setVisible(false);
		
		// Move the scrollbar to the top
		tracker.getTrackerPanelScrollBar().getVerticalScrollBar().setValue(0);
	}
	
	// Action performed when the "Wild sets" button is pressed
	private void wildAction() 
	{
		// Hide Standard sets
		standard.setVisible(false);
		
		// Show Wild sets
		wild.setVisible(true);
		
		// Unselected Mode button customization
		standardButton.setBackground(setsColor);
		standardButton.addMouseListener(new java.awt.event.MouseAdapter() {
			@Override
		    public void mouseEntered(java.awt.event.MouseEvent evt) {
				standardButton.setBackground(setsHoverColor);
		    }
			
		    @Override
		    public void mouseExited(java.awt.event.MouseEvent evt) {
		    	standardButton.setBackground(setsColor);
		    }
		});
		
		// Selected Mode button customization
		wildButton.setBackground(setsSelectedColor);
		wildButton.addMouseListener(new java.awt.event.MouseAdapter() {
			@Override
		    public void mouseEntered(java.awt.event.MouseEvent evt) {
				wildButton.setBackground(setsSelectedColor);
		    }
			
		    @Override
		    public void mouseExited(java.awt.event.MouseEvent evt) {
		    	wildButton.setBackground(setsSelectedColor);
		    }
		});
		
		// Hide Standard Years shortcut buttons panel
		standardYearsShortcutsPanel.setVisible(false);
		// Show Wild Years shortcut buttons panel
		wildYearsShortcutsPanel.setVisible(true);
		
		// Move the scrollbar to the top
		tracker.getTrackerPanelScrollBar().getVerticalScrollBar().setValue(0);
	}
	
	// Action performed when a Year shortcut button is pressed
	private void shortcutButtonAction(int index) 
	{
		// "Classic Sets" shortcut button
		if (index == 0) {
			// Move the scrollbar to the start of this year's panel
			tracker.getTrackerPanelScrollBar().getVerticalScrollBar().setValue(classicSets.getY());
		}
		// "Year of the Kraken" shortcut button
		else if (index == 1) {
			// Move the scrollbar to the start of this year's panel
			tracker.getTrackerPanelScrollBar().getVerticalScrollBar().setValue(kraken.getY());
		}
		// "Year of the Mammoth" shortcut button
		else if (index == 2) {
			// Move the scrollbar to the start of this year's panel
			tracker.getTrackerPanelScrollBar().getVerticalScrollBar().setValue(mammoth.getY());
		}
		// "Year of the Raven" shortcut button
		else if (index == 3) {
			// Move the scrollbar to the start of this year's panel
			tracker.getTrackerPanelScrollBar().getVerticalScrollBar().setValue(raven.getY());
		}
		// "Year of the Dragon" shortcut button
		else if (index == 4) {
			// Move the scrollbar to the start of this year's panel
			tracker.getTrackerPanelScrollBar().getVerticalScrollBar().setValue(dragon.getY());
		}
		// "Year of the Phoenix" shortcut button
		else if (index == 5) {
			// Move the scrollbar to the start of this year's panel
			tracker.getTrackerPanelScrollBar().getVerticalScrollBar().setValue(phoenix.getY());
		}
		// "Year of the Gryphon" shortcut button
		else {
			// Move the scrollbar to the start of this year's panel
			tracker.getTrackerPanelScrollBar().getVerticalScrollBar().setValue(gryphon.getY());
		}
	}
	
	// Opens a link to a webpage
	private boolean openWebpage(URI uri) 
	{
	    Desktop desktop = Desktop.isDesktopSupported() ? Desktop.getDesktop() : null;
	    if (desktop != null && desktop.isSupported(Desktop.Action.BROWSE)) {
	        try {
	            desktop.browse(uri);
	            return true;
	        } catch (Exception e) {
	            e.printStackTrace();
	        }
	    }
	    return false;
	}
	
	// Action performed when an epic reset button is pressed
	private void epicResetAction(int index) 
	{
		// "Classic" epic reset button
		if (index == 0) {
			classicEpicCounter = 0;
			tracker.setClassicEpicCounter(Integer.toString(classicEpicCounter));
			
			// Reset the increment field to '1'
			classicEpicIncrement.setText("1");
			
			// Calculate probability
			classicEpicProbability = probabilityCalculator(classicEpicCounter, 10);
			tracker.setClassicEpicProbability(nf.format(classicEpicProbability));
		}
		// "Goblins vs Gnomes" epic reset button
		else if (index == 1) {
			goblinsEpicCounter = 0;
			tracker.setGoblinsEpicCounter(Integer.toString(goblinsEpicCounter));
			
			// Reset the increment field to '1'
			goblinsEpicIncrement.setText("1");
			
			// Calculate probability
			goblinsEpicProbability = probabilityCalculator(goblinsEpicCounter, 10);
			tracker.setGoblinsEpicProbability(nf.format(goblinsEpicProbability));
		}
		// "The Grand Tournament" epic reset button
		else if (index == 2) {
			tournamentEpicCounter = 0;
			tracker.setTournamentEpicCounter(Integer.toString(tournamentEpicCounter));
			
			// Reset the increment field to '1'
			tournamentEpicIncrement.setText("1");
			
			// Calculate probability
			tournamentEpicProbability = probabilityCalculator(tournamentEpicCounter, 10);
			tracker.setTournamentEpicProbability(nf.format(tournamentEpicProbability));
		}
		// "Whispers of the Old Gods" epic reset button
		else if (index == 3) {
			oldGodsEpicCounter = 0;
			tracker.setOldGodsEpicCounter(Integer.toString(oldGodsEpicCounter));
			
			// Reset the increment field to '1'
			oldGodsEpicIncrement.setText("1");
			
			// Calculate probability
			oldGodsEpicProbability = probabilityCalculator(oldGodsEpicCounter, 10);
			tracker.setOldGodsEpicProbability(nf.format(oldGodsEpicProbability));
		}
		// "Mean Streets of Gadzetzan" epic reset button
		else if (index == 4) {
			gadgetzanEpicCounter = 0;
			tracker.setGadgetzanEpicCounter(Integer.toString(gadgetzanEpicCounter));
			
			// Reset the increment field to '1'
			gadgetzanEpicIncrement.setText("1");
			
			// Calculate probability
			gadgetzanEpicProbability = probabilityCalculator(gadgetzanEpicCounter, 10);
			tracker.setGadgetzanEpicProbability(nf.format(gadgetzanEpicProbability));
		}
		// "Journey to Un'Goro" epic reset button
		else if (index == 5) {
			ungoroEpicCounter = 0;
			tracker.setUngoroEpicCounter(Integer.toString(ungoroEpicCounter));
			
			// Reset the increment field to '1'
			ungoroEpicIncrement.setText("1");
			
			// Calculate probability
			ungoroEpicProbability = probabilityCalculator(ungoroEpicCounter, 10);
			tracker.setUngoroEpicProbability(nf.format(ungoroEpicProbability));
		}
		// "Knights of the Frozen Throne" epic reset button
		else if (index == 6) {
			knightsEpicCounter = 0;
			tracker.setKnightsEpicCounter(Integer.toString(knightsEpicCounter));
			
			// Reset the increment field to '1'
			knightsEpicIncrement.setText("1");
			
			// Calculate probability
			knightsEpicProbability = probabilityCalculator(knightsEpicCounter, 10);
			tracker.setKnightsEpicProbability(nf.format(knightsEpicProbability));
		}
		// "Kobolds & Catacombs" epic reset button
		else if (index == 7) {
			koboldsEpicCounter = 0;
			tracker.setKoboldsEpicCounter(Integer.toString(koboldsEpicCounter));
			
			// Reset the increment field to '1'
			koboldsEpicIncrement.setText("1");
			
			// Calculate probability
			koboldsEpicProbability = probabilityCalculator(koboldsEpicCounter, 10);
			tracker.setKoboldsEpicProbability(nf.format(koboldsEpicProbability));
		}
		// "The Witchwood" epic reset button
		else if (index == 8) {
			witchwoodEpicCounter = 0;
			tracker.setWitchwoodEpicCounter(Integer.toString(witchwoodEpicCounter));
			
			// Reset the increment field to '1'
			witchwoodEpicIncrement.setText("1");
			
			// Calculate probability
			witchwoodEpicProbability = probabilityCalculator(witchwoodEpicCounter, 10);
			tracker.setWitchwoodEpicProbability(nf.format(witchwoodEpicProbability));
		}
		// "The Boomsday Project" epic reset button
		else if (index == 9) {
			boomsdayEpicCounter = 0;
			tracker.setBoomsdayEpicCounter(Integer.toString(boomsdayEpicCounter));
			
			// Reset the increment field to '1'
			boomsdayEpicIncrement.setText("1");
			
			// Calculate probability
			boomsdayEpicProbability = probabilityCalculator(boomsdayEpicCounter, 10);
			tracker.setBoomsdayEpicProbability(nf.format(boomsdayEpicProbability));
		}
		// "Rastakhan's Rumble" epic reset button
		else if (index == 10) {
			rumbleEpicCounter = 0;
			tracker.setRumbleEpicCounter(Integer.toString(rumbleEpicCounter));
			
			// Reset the increment field to '1'
			rumbleEpicIncrement.setText("1");
			
			// Calculate probability
			rumbleEpicProbability = probabilityCalculator(rumbleEpicCounter, 10);
			tracker.setRumbleEpicProbability(nf.format(rumbleEpicProbability));
		}
		// "Rise of Shadows" epic reset button
		else if (index == 11) {
			shadowsEpicCounter = 0;
			tracker.setShadowsEpicCounter(Integer.toString(shadowsEpicCounter));
			
			// Reset the increment field to '1'
			shadowsEpicIncrement.setText("1");
			
			// Calculate probability
			shadowsEpicProbability = probabilityCalculator(shadowsEpicCounter, 10);
			tracker.setShadowsEpicProbability(nf.format(shadowsEpicProbability));
		}
		// "Saviors of Uldum" epic reset button
		else if (index == 12) {
			uldumEpicCounter = 0;
			tracker.setUldumEpicCounter(Integer.toString(uldumEpicCounter));
			
			// Reset the increment field to '1'
			uldumEpicIncrement.setText("1");
			
			// Calculate probability
			uldumEpicProbability = probabilityCalculator(uldumEpicCounter, 10);
			tracker.setUldumEpicProbability(nf.format(uldumEpicProbability));
		}
		// "Descent of Dragons" epic reset button
		else if (index == 13) {
			dragonsEpicCounter = 0;
			tracker.setDragonsEpicCounter(Integer.toString(dragonsEpicCounter));
			
			// Reset the increment field to '1'
			dragonsEpicIncrement.setText("1");
			
			// Calculate probability
			dragonsEpicProbability = probabilityCalculator(dragonsEpicCounter, 10);
			tracker.setDragonsEpicProbability(nf.format(dragonsEpicProbability));
		}
		// "Ashes of Outland" epic reset button
		else if (index == 14) {
			outlandEpicCounter = 0;
			tracker.setOutlandEpicCounter(Integer.toString(outlandEpicCounter));
			
			// Reset the increment field to '1'
			outlandEpicIncrement.setText("1");
			
			// Calculate probability
			outlandEpicProbability = probabilityCalculator(outlandEpicCounter, 10);
			tracker.setOutlandEpicProbability(nf.format(outlandEpicProbability));
		}
		// "Scholomance Academy" epic reset button
		else if (index == 15) {
			scholomanceEpicCounter = 0;
			tracker.setScholomanceEpicCounter(Integer.toString(scholomanceEpicCounter));
			
			// Reset the increment field to '1'
			scholomanceEpicIncrement.setText("1");
			
			// Calculate probability
			scholomanceEpicProbability = probabilityCalculator(scholomanceEpicCounter, 10);
			tracker.setScholomanceEpicProbability(nf.format(scholomanceEpicProbability));
		}
		// "Madness at the Darkmoon Faire" epic reset button
		else if (index == 16) {
			darkmoonEpicCounter = 0;
			tracker.setDarkmoonEpicCounter(Integer.toString(darkmoonEpicCounter));
			
			// Reset the increment field to '1'
			darkmoonEpicIncrement.setText("1");
			
			// Calculate probability
			darkmoonEpicProbability = probabilityCalculator(darkmoonEpicCounter, 10);
			tracker.setDarkmoonEpicProbability(nf.format(darkmoonEpicProbability));
		}
		// "Forged in the Barrens" epic reset button
		else if (index == 17) {
			barrensEpicCounter = 0;
			tracker.setBarrensEpicCounter(Integer.toString(barrensEpicCounter));
			
			// Reset the increment field to '1'
			barrensEpicIncrement.setText("1");
			
			// Calculate probability
			barrensEpicProbability = probabilityCalculator(barrensEpicCounter, 10);
			tracker.setBarrensEpicProbability(nf.format(barrensEpicProbability));
		}
		// "United in Stormwind" epic reset button
		else {
			stormwindEpicCounter = 0;
			tracker.setStormwindEpicCounter(Integer.toString(stormwindEpicCounter));
			
			// Reset the increment field to '1'
			stormwindEpicIncrement.setText("1");
			
			// Calculate probability
			stormwindEpicProbability = probabilityCalculator(stormwindEpicCounter, 10);
			tracker.setStormwindEpicProbability(nf.format(stormwindEpicProbability));
		}
		
		// Update the save file
		updateSaveFile();
	}
	
	// Action performed when an epic add button is pressed
	private void epicAddAction(int index) 
	{
		// "Classic" epic add button
		if (index == 0) {
			// Check if the increment is valid, then add. Otherwise, show pop-up error message
			if (classicEpicCounter + Integer.valueOf(classicEpicIncrement.getText()) < 10) {
				classicEpicCounter = classicEpicCounter + Integer.valueOf(classicEpicIncrement.getText());
				
				// Reset the increment field to '1'
				classicEpicIncrement.setText("1");
			}
			else {
				java.awt.Toolkit.getDefaultToolkit().beep();
				JOptionPane.showMessageDialog(contentPane, incrementErrorMessage, incrementErrorTitle, JOptionPane.ERROR_MESSAGE);
			}
			tracker.setClassicEpicCounter(Integer.toString(classicEpicCounter));
			
			// Calculate probability
			classicEpicProbability = probabilityCalculator(classicEpicCounter, 10);
			tracker.setClassicEpicProbability(nf.format(classicEpicProbability));
		}
		// "Goblins vs Gnomes" epic add button
		else if (index == 1) {
			// Check if the increment is valid, then add. Otherwise, show pop-up error message
			if (goblinsEpicCounter + Integer.valueOf(goblinsEpicIncrement.getText()) < 10) {
				goblinsEpicCounter = goblinsEpicCounter + Integer.valueOf(goblinsEpicIncrement.getText());
				
				// Reset the increment field to '1'
				goblinsEpicIncrement.setText("1");
			}
			else {
				java.awt.Toolkit.getDefaultToolkit().beep();
				JOptionPane.showMessageDialog(contentPane, incrementErrorMessage, incrementErrorTitle, JOptionPane.ERROR_MESSAGE);
			}
			tracker.setGoblinsEpicCounter(Integer.toString(goblinsEpicCounter));
			
			// Calculate probability
			goblinsEpicProbability = probabilityCalculator(goblinsEpicCounter, 10);
			tracker.setGoblinsEpicProbability(nf.format(goblinsEpicProbability));
		}
		// "The Grand Tournament" epic add button
		else if (index == 2) {
			// Check if the increment is valid, then add. Otherwise, show pop-up error message
			if (tournamentEpicCounter + Integer.valueOf(tournamentEpicIncrement.getText()) < 10) {
				tournamentEpicCounter = tournamentEpicCounter + Integer.valueOf(tournamentEpicIncrement.getText());
				
				// Reset the increment field to '1'
				tournamentEpicIncrement.setText("1");
			}
			else {
				java.awt.Toolkit.getDefaultToolkit().beep();
				JOptionPane.showMessageDialog(contentPane, incrementErrorMessage, incrementErrorTitle, JOptionPane.ERROR_MESSAGE);
			}
			tracker.setTournamentEpicCounter(Integer.toString(tournamentEpicCounter));
			
			// Calculate probability
			tournamentEpicProbability = probabilityCalculator(tournamentEpicCounter, 10);
			tracker.setTournamentEpicProbability(nf.format(tournamentEpicProbability));
		}
		// "Whispers of the Old Gods" epic add button
		else if (index == 3) {
			// Check if the increment is valid, then add. Otherwise, show pop-up error message
			if (oldGodsEpicCounter + Integer.valueOf(oldGodsEpicIncrement.getText()) < 10) {
				oldGodsEpicCounter = oldGodsEpicCounter + Integer.valueOf(oldGodsEpicIncrement.getText());
				
				// Reset the increment field to '1'
				oldGodsEpicIncrement.setText("1");
			}
			else {
				java.awt.Toolkit.getDefaultToolkit().beep();
				JOptionPane.showMessageDialog(contentPane, incrementErrorMessage, incrementErrorTitle, JOptionPane.ERROR_MESSAGE);
			}
			tracker.setOldGodsEpicCounter(Integer.toString(oldGodsEpicCounter));
			
			// Calculate probability
			oldGodsEpicProbability = probabilityCalculator(oldGodsEpicCounter, 10);
			tracker.setOldGodsEpicProbability(nf.format(oldGodsEpicProbability));
		}
		// "Mean Streets of Gadzetzan" epic add button
		else if (index == 4) {
			// Check if the increment is valid, then add. Otherwise, show pop-up error message
			if (gadgetzanEpicCounter + Integer.valueOf(gadgetzanEpicIncrement.getText()) < 10) {
				gadgetzanEpicCounter = gadgetzanEpicCounter + Integer.valueOf(gadgetzanEpicIncrement.getText());
				
				// Reset the increment field to '1'
				gadgetzanEpicIncrement.setText("1");
			}
			else {
				java.awt.Toolkit.getDefaultToolkit().beep();
				JOptionPane.showMessageDialog(contentPane, incrementErrorMessage, incrementErrorTitle, JOptionPane.ERROR_MESSAGE);
			}
			tracker.setGadgetzanEpicCounter(Integer.toString(gadgetzanEpicCounter));
			
			// Calculate probability
			gadgetzanEpicProbability = probabilityCalculator(gadgetzanEpicCounter, 10);
			tracker.setGadgetzanEpicProbability(nf.format(gadgetzanEpicProbability));
		}
		// "Journey to Un'Goro" epic add button
		else if (index == 5) {
			// Check if the increment is valid, then add. Otherwise, show pop-up error message
			if (ungoroEpicCounter + Integer.valueOf(ungoroEpicIncrement.getText()) < 10) {
				ungoroEpicCounter = ungoroEpicCounter + Integer.valueOf(ungoroEpicIncrement.getText());
				
				// Reset the increment field to '1'
				ungoroEpicIncrement.setText("1");
			}
			else {
				java.awt.Toolkit.getDefaultToolkit().beep();
				JOptionPane.showMessageDialog(contentPane, incrementErrorMessage, incrementErrorTitle, JOptionPane.ERROR_MESSAGE);
			}
			tracker.setUngoroEpicCounter(Integer.toString(ungoroEpicCounter));
			
			// Calculate probability
			ungoroEpicProbability = probabilityCalculator(ungoroEpicCounter, 10);
			tracker.setUngoroEpicProbability(nf.format(ungoroEpicProbability));
		}
		// "Knights of the Frozen Throne" epic add button
		else if (index == 6) {
			// Check if the increment is valid, then add. Otherwise, show pop-up error message
			if (knightsEpicCounter + Integer.valueOf(knightsEpicIncrement.getText()) < 10) {
				knightsEpicCounter = knightsEpicCounter + Integer.valueOf(knightsEpicIncrement.getText());
				
				// Reset the increment field to '1'
				knightsEpicIncrement.setText("1");
			}
			else {
				java.awt.Toolkit.getDefaultToolkit().beep();
				JOptionPane.showMessageDialog(contentPane, incrementErrorMessage, incrementErrorTitle, JOptionPane.ERROR_MESSAGE);
			}
			tracker.setKnightsEpicCounter(Integer.toString(knightsEpicCounter));
			
			// Calculate probability
			knightsEpicProbability = probabilityCalculator(knightsEpicCounter, 10);
			tracker.setKnightsEpicProbability(nf.format(knightsEpicProbability));
		}
		// "Kobolds & Catacombs" epic add button
		else if (index == 7) {
			// Check if the increment is valid, then add. Otherwise, show pop-up error message
			if (koboldsEpicCounter + Integer.valueOf(koboldsEpicIncrement.getText()) < 10) {
				koboldsEpicCounter = koboldsEpicCounter + Integer.valueOf(koboldsEpicIncrement.getText());
				
				// Reset the increment field to '1'
				koboldsEpicIncrement.setText("1");
			}
			else {
				java.awt.Toolkit.getDefaultToolkit().beep();
				JOptionPane.showMessageDialog(contentPane, incrementErrorMessage, incrementErrorTitle, JOptionPane.ERROR_MESSAGE);
			}
			tracker.setKoboldsEpicCounter(Integer.toString(koboldsEpicCounter));
			
			// Calculate probability
			koboldsEpicProbability = probabilityCalculator(koboldsEpicCounter, 10);
			tracker.setKoboldsEpicProbability(nf.format(koboldsEpicProbability));
		}
		// "The Witchwood" epic add button
		else if (index == 8) {
			// Check if the increment is valid, then add. Otherwise, show pop-up error message
			if (witchwoodEpicCounter + Integer.valueOf(witchwoodEpicIncrement.getText()) < 10) {
				witchwoodEpicCounter = witchwoodEpicCounter + Integer.valueOf(witchwoodEpicIncrement.getText());
				
				// Reset the increment field to '1'
				witchwoodEpicIncrement.setText("1");
			}
			else {
				java.awt.Toolkit.getDefaultToolkit().beep();
				JOptionPane.showMessageDialog(contentPane, incrementErrorMessage, incrementErrorTitle, JOptionPane.ERROR_MESSAGE);
			}
			tracker.setWitchwoodEpicCounter(Integer.toString(witchwoodEpicCounter));
			
			// Calculate probability
			witchwoodEpicProbability = probabilityCalculator(witchwoodEpicCounter, 10);
			tracker.setWitchwoodEpicProbability(nf.format(witchwoodEpicProbability));
		}
		// "The Boomsday Project" epic add button
		else if (index == 9) {
			// Check if the increment is valid, then add. Otherwise, show pop-up error message
			if (boomsdayEpicCounter + Integer.valueOf(boomsdayEpicIncrement.getText()) < 10) {
				boomsdayEpicCounter = boomsdayEpicCounter + Integer.valueOf(boomsdayEpicIncrement.getText());
				
				// Reset the increment field to '1'
				boomsdayEpicIncrement.setText("1");
			}
			else {
				java.awt.Toolkit.getDefaultToolkit().beep();
				JOptionPane.showMessageDialog(contentPane, incrementErrorMessage, incrementErrorTitle, JOptionPane.ERROR_MESSAGE);
			}
			tracker.setBoomsdayEpicCounter(Integer.toString(boomsdayEpicCounter));
			
			// Calculate probability
			boomsdayEpicProbability = probabilityCalculator(boomsdayEpicCounter, 10);
			tracker.setBoomsdayEpicProbability(nf.format(boomsdayEpicProbability));
		}
		// "Rastakhan's Rumble" epic add button
		else if (index == 10) {
			// Check if the increment is valid, then add. Otherwise, show pop-up error message
			if (rumbleEpicCounter + Integer.valueOf(rumbleEpicIncrement.getText()) < 10) {
				rumbleEpicCounter = rumbleEpicCounter + Integer.valueOf(rumbleEpicIncrement.getText());
				
				// Reset the increment field to '1'
				rumbleEpicIncrement.setText("1");
			}
			else {
				java.awt.Toolkit.getDefaultToolkit().beep();
				JOptionPane.showMessageDialog(contentPane, incrementErrorMessage, incrementErrorTitle, JOptionPane.ERROR_MESSAGE);
			}
			tracker.setRumbleEpicCounter(Integer.toString(rumbleEpicCounter));
			
			// Calculate probability
			rumbleEpicProbability = probabilityCalculator(rumbleEpicCounter, 10);
			tracker.setRumbleEpicProbability(nf.format(rumbleEpicProbability));
		}
		// "Rise of Shadows" epic add button
		else if (index == 11) {
			// Check if the increment is valid, then add. Otherwise, show pop-up error message
			if (shadowsEpicCounter + Integer.valueOf(shadowsEpicIncrement.getText()) < 10) {
				shadowsEpicCounter = shadowsEpicCounter + Integer.valueOf(shadowsEpicIncrement.getText());
				
				// Reset the increment field to '1'
				shadowsEpicIncrement.setText("1");
			}
			else {
				java.awt.Toolkit.getDefaultToolkit().beep();
				JOptionPane.showMessageDialog(contentPane, incrementErrorMessage, incrementErrorTitle, JOptionPane.ERROR_MESSAGE);
			}
			tracker.setShadowsEpicCounter(Integer.toString(shadowsEpicCounter));
			
			// Calculate probability
			shadowsEpicProbability = probabilityCalculator(shadowsEpicCounter, 10);
			tracker.setShadowsEpicProbability(nf.format(shadowsEpicProbability));
		}
		// "Saviors of Uldum" epic add button
		else if (index == 12) {
			// Check if the increment is valid, then add. Otherwise, show pop-up error message
			if (uldumEpicCounter + Integer.valueOf(uldumEpicIncrement.getText()) < 10) {
				uldumEpicCounter = uldumEpicCounter + Integer.valueOf(uldumEpicIncrement.getText());
				
				// Reset the increment field to '1'
				uldumEpicIncrement.setText("1");
			}
			else {
				java.awt.Toolkit.getDefaultToolkit().beep();
				JOptionPane.showMessageDialog(contentPane, incrementErrorMessage, incrementErrorTitle, JOptionPane.ERROR_MESSAGE);
			}
			tracker.setUldumEpicCounter(Integer.toString(uldumEpicCounter));
			
			// Calculate probability
			uldumEpicProbability = probabilityCalculator(uldumEpicCounter, 10);
			tracker.setUldumEpicProbability(nf.format(uldumEpicProbability));
		}
		// "Descent of Dragons" epic add button
		else if (index == 13) {
			// Check if the increment is valid, then add. Otherwise, show pop-up error message
			if (dragonsEpicCounter + Integer.valueOf(dragonsEpicIncrement.getText()) < 10) {
				dragonsEpicCounter = dragonsEpicCounter + Integer.valueOf(dragonsEpicIncrement.getText());
				
				// Reset the increment field to '1'
				dragonsEpicIncrement.setText("1");
			}
			else {
				java.awt.Toolkit.getDefaultToolkit().beep();
				JOptionPane.showMessageDialog(contentPane, incrementErrorMessage, incrementErrorTitle, JOptionPane.ERROR_MESSAGE);
			}
			tracker.setDragonsEpicCounter(Integer.toString(dragonsEpicCounter));
			
			// Calculate probability
			dragonsEpicProbability = probabilityCalculator(dragonsEpicCounter, 10);
			tracker.setDragonsEpicProbability(nf.format(dragonsEpicProbability));
		}
		// "Ashes of Outland" epic add button
		else if (index == 14) {
			// Check if the increment is valid, then add. Otherwise, show pop-up error message
			if (outlandEpicCounter + Integer.valueOf(outlandEpicIncrement.getText()) < 10) {
				outlandEpicCounter = outlandEpicCounter + Integer.valueOf(outlandEpicIncrement.getText());
				
				// Reset the increment field to '1'
				outlandEpicIncrement.setText("1");
			}
			else {
				java.awt.Toolkit.getDefaultToolkit().beep();
				JOptionPane.showMessageDialog(contentPane, incrementErrorMessage, incrementErrorTitle, JOptionPane.ERROR_MESSAGE);
			}
			tracker.setOutlandEpicCounter(Integer.toString(outlandEpicCounter));
			
			// Calculate probability
			outlandEpicProbability = probabilityCalculator(outlandEpicCounter, 10);
			tracker.setOutlandEpicProbability(nf.format(outlandEpicProbability));
		}
		// "Scholomance Academy" epic add button
		else if (index == 15) {
			// Check if the increment is valid, then add. Otherwise, show pop-up error message
			if (scholomanceEpicCounter + Integer.valueOf(scholomanceEpicIncrement.getText()) < 10) {
				scholomanceEpicCounter = scholomanceEpicCounter + Integer.valueOf(scholomanceEpicIncrement.getText());
				
				// Reset the increment field to '1'
				scholomanceEpicIncrement.setText("1");
			}
			else {
				java.awt.Toolkit.getDefaultToolkit().beep();
				JOptionPane.showMessageDialog(contentPane, incrementErrorMessage, incrementErrorTitle, JOptionPane.ERROR_MESSAGE);
			}
			tracker.setScholomanceEpicCounter(Integer.toString(scholomanceEpicCounter));
			
			// Calculate probability
			scholomanceEpicProbability = probabilityCalculator(scholomanceEpicCounter, 10);
			tracker.setScholomanceEpicProbability(nf.format(scholomanceEpicProbability));
		}
		// "Madness at the Darkmoon Faire" epic add button
		else if (index == 16) {
			// Check if the increment is valid, then add. Otherwise, show pop-up error message
			if (darkmoonEpicCounter + Integer.valueOf(darkmoonEpicIncrement.getText()) < 10) {
				darkmoonEpicCounter = darkmoonEpicCounter + Integer.valueOf(darkmoonEpicIncrement.getText());
				
				// Reset the increment field to '1'
				darkmoonEpicIncrement.setText("1");
			}
			else {
				java.awt.Toolkit.getDefaultToolkit().beep();
				JOptionPane.showMessageDialog(contentPane, incrementErrorMessage, incrementErrorTitle, JOptionPane.ERROR_MESSAGE);
			}
			tracker.setDarkmoonEpicCounter(Integer.toString(darkmoonEpicCounter));
			
			// Calculate probability
			darkmoonEpicProbability = probabilityCalculator(darkmoonEpicCounter, 10);
			tracker.setDarkmoonEpicProbability(nf.format(darkmoonEpicProbability));
		}
		// "Forged in the Barrens" epic add button
		else if (index == 17) {
			// Check if the increment is valid, then add. Otherwise, show pop-up error message
			if (barrensEpicCounter + Integer.valueOf(barrensEpicIncrement.getText()) < 10) {
				barrensEpicCounter = barrensEpicCounter + Integer.valueOf(barrensEpicIncrement.getText());
				
				// Reset the increment field to '1'
				barrensEpicIncrement.setText("1");
			}
			else {
				java.awt.Toolkit.getDefaultToolkit().beep();
				JOptionPane.showMessageDialog(contentPane, incrementErrorMessage, incrementErrorTitle, JOptionPane.ERROR_MESSAGE);
			}
			tracker.setBarrensEpicCounter(Integer.toString(barrensEpicCounter));
			
			// Calculate probability
			barrensEpicProbability = probabilityCalculator(barrensEpicCounter, 10);
			tracker.setBarrensEpicProbability(nf.format(barrensEpicProbability));
		}
		// "United in Stormwind" epic add button
		else {
			// Check if the increment is valid, then add. Otherwise, show pop-up error message
			if (stormwindEpicCounter + Integer.valueOf(stormwindEpicIncrement.getText()) < 10) {
				stormwindEpicCounter = stormwindEpicCounter + Integer.valueOf(stormwindEpicIncrement.getText());
				
				// Reset the increment field to '1'
				stormwindEpicIncrement.setText("1");
			}
			else {
				java.awt.Toolkit.getDefaultToolkit().beep();
				JOptionPane.showMessageDialog(contentPane, incrementErrorMessage, incrementErrorTitle, JOptionPane.ERROR_MESSAGE);
			}
			tracker.setStormwindEpicCounter(Integer.toString(stormwindEpicCounter));
			
			// Calculate probability
			stormwindEpicProbability = probabilityCalculator(stormwindEpicCounter, 10);
			tracker.setStormwindEpicProbability(nf.format(stormwindEpicProbability));
		}
		
		// Update the save file
		updateSaveFile();
	}
	
	// Action performed when a legendary reset button is pressed
	private void legendaryResetAction(int index) 
	{
		// "Classic" legendary reset button
		if (index == 0) {
			classicLegendaryCounter = 0;
			tracker.setClassicLegendaryCounter(Integer.toString(classicLegendaryCounter));
			
			// Reset the increment field to '1'
			classicLegendaryIncrement.setText("1");
			
			// Calculate probability
			classicLegendaryProbability = probabilityCalculator(classicLegendaryCounter, 40);
			tracker.setClassicLegendaryProbability(nf.format(classicLegendaryProbability));
		}
		// "Goblins vs Gnomes" legendary reset button
		else if (index == 1) {
			goblinsLegendaryCounter = 0;
			tracker.setGoblinsLegendaryCounter(Integer.toString(goblinsLegendaryCounter));
			
			// Reset the increment field to '1'
			goblinsLegendaryIncrement.setText("1");
			
			// Calculate probability
			goblinsLegendaryProbability = probabilityCalculator(goblinsLegendaryCounter, 40);
			tracker.setGoblinsLegendaryProbability(nf.format(goblinsLegendaryProbability));
		}
		// "The Grand Tournament" legendary reset button
		else if (index == 2) {
			tournamentLegendaryCounter = 0;
			tracker.setTournamentLegendaryCounter(Integer.toString(tournamentLegendaryCounter));
			
			// Reset the increment field to '1'
			tournamentLegendaryIncrement.setText("1");
			
			// Calculate probability
			tournamentLegendaryProbability = probabilityCalculator(tournamentLegendaryCounter, 40);
			tracker.setTournamentLegendaryProbability(nf.format(tournamentLegendaryProbability));
		}
		// "Whispers of the Old Gods" legendary reset button
		else if (index == 3) {
			oldGodsLegendaryCounter = 0;
			tracker.setOldGodsLegendaryCounter(Integer.toString(oldGodsLegendaryCounter));
			
			// Reset the increment field to '1'
			oldGodsLegendaryIncrement.setText("1");
			
			// Calculate probability
			oldGodsLegendaryProbability = probabilityCalculator(oldGodsLegendaryCounter, 40);
			tracker.setOldGodsLegendaryProbability(nf.format(oldGodsLegendaryProbability));
		}
		// "Mean Streets of Gadzetzan" legendary reset button
		else if (index == 4) {
			gadgetzanLegendaryCounter = 0;
			tracker.setGadgetzanLegendaryCounter(Integer.toString(gadgetzanLegendaryCounter));
			
			// Reset the increment field to '1'
			gadgetzanLegendaryIncrement.setText("1");
			
			// Calculate probability
			gadgetzanLegendaryProbability = probabilityCalculator(gadgetzanLegendaryCounter, 40);
			tracker.setGadgetzanLegendaryProbability(nf.format(gadgetzanLegendaryProbability));
		}
		// "Journey to Un'Goro" legendary reset button
		else if (index == 5) {
			ungoroLegendaryCounter = 0;
			tracker.setUngoroLegendaryCounter(Integer.toString(ungoroLegendaryCounter));
			
			// Reset the increment field to '1'
			ungoroLegendaryIncrement.setText("1");
			
			// Calculate probability
			ungoroLegendaryProbability = probabilityCalculator(ungoroLegendaryCounter, 40);
			tracker.setUngoroLegendaryProbability(nf.format(ungoroLegendaryProbability));
		}
		// "Knights of the Frozen Throne" legendary reset button
		else if (index == 6) {
			knightsLegendaryCounter = 0;
			tracker.setKnightsLegendaryCounter(Integer.toString(knightsLegendaryCounter));
			
			// Reset the increment field to '1'
			knightsLegendaryIncrement.setText("1");
			
			// Calculate probability
			knightsLegendaryProbability = probabilityCalculator(knightsLegendaryCounter, 40);
			tracker.setKnightsLegendaryProbability(nf.format(knightsLegendaryProbability));
		}
		// "Kobolds & Catacombs" legendary reset button
		else if (index == 7) {
			koboldsLegendaryCounter = 0;
			tracker.setKoboldsLegendaryCounter(Integer.toString(koboldsLegendaryCounter));
			
			// Reset the increment field to '1'
			koboldsLegendaryIncrement.setText("1");
			
			// Calculate probability
			koboldsLegendaryProbability = probabilityCalculator(koboldsLegendaryCounter, 40);
			tracker.setKoboldsLegendaryProbability(nf.format(koboldsLegendaryProbability));
		}
		// "The Witchwood" legendary reset button
		else if (index == 8) {
			witchwoodLegendaryCounter = 0;
			tracker.setWitchwoodLegendaryCounter(Integer.toString(witchwoodLegendaryCounter));
			
			// Reset the increment field to '1'
			witchwoodLegendaryIncrement.setText("1");
			
			// Calculate probability
			witchwoodLegendaryProbability = probabilityCalculator(witchwoodLegendaryCounter, 40);
			tracker.setWitchwoodLegendaryProbability(nf.format(witchwoodLegendaryProbability));
		}
		// "The Boomsday Project" legendary reset button
		else if (index == 9) {
			boomsdayLegendaryCounter = 0;
			tracker.setBoomsdayLegendaryCounter(Integer.toString(boomsdayLegendaryCounter));
			
			// Reset the increment field to '1'
			boomsdayLegendaryIncrement.setText("1");
			
			// Calculate probability
			boomsdayLegendaryProbability = probabilityCalculator(boomsdayLegendaryCounter, 40);
			tracker.setBoomsdayLegendaryProbability(nf.format(boomsdayLegendaryProbability));
		}
		// "Rastakhan's Rumble" legendary reset button
		else if (index == 10) {
			rumbleLegendaryCounter = 0;
			tracker.setRumbleLegendaryCounter(Integer.toString(rumbleLegendaryCounter));
			
			// Reset the increment field to '1'
			rumbleLegendaryIncrement.setText("1");
			
			// Calculate probability
			rumbleLegendaryProbability = probabilityCalculator(rumbleLegendaryCounter, 40);
			tracker.setRumbleLegendaryProbability(nf.format(rumbleLegendaryProbability));
		}
		// "Rise of Shadows" legendary reset button
		else if (index == 11) {
			shadowsLegendaryCounter = 0;
			tracker.setShadowsLegendaryCounter(Integer.toString(shadowsLegendaryCounter));
			
			// Reset the increment field to '1'
			shadowsLegendaryIncrement.setText("1");
			
			// Calculate probability
			shadowsLegendaryProbability = probabilityCalculator(shadowsLegendaryCounter, 40);
			tracker.setShadowsLegendaryProbability(nf.format(shadowsLegendaryProbability));
		}
		// "Saviors of Uldum" legendary reset button
		else if (index == 12) {
			uldumLegendaryCounter = 0;
			tracker.setUldumLegendaryCounter(Integer.toString(uldumLegendaryCounter));
			
			// Reset the increment field to '1'
			uldumLegendaryIncrement.setText("1");
			
			// Calculate probability
			uldumLegendaryProbability = probabilityCalculator(uldumLegendaryCounter, 40);
			tracker.setUldumLegendaryProbability(nf.format(uldumLegendaryProbability));
		}
		// "Descent of Dragons" legendary reset button
		else if (index == 13) {
			dragonsLegendaryCounter = 0;
			tracker.setDragonsLegendaryCounter(Integer.toString(dragonsLegendaryCounter));
			
			// Reset the increment field to '1'
			dragonsLegendaryIncrement.setText("1");
			
			// Calculate probability
			dragonsLegendaryProbability = probabilityCalculator(dragonsLegendaryCounter, 40);
			tracker.setDragonsLegendaryProbability(nf.format(dragonsLegendaryProbability));
		}
		// "Ashes of Outland" legendary reset button
		else if (index == 14) {
			outlandLegendaryCounter = 0;
			tracker.setOutlandLegendaryCounter(Integer.toString(outlandLegendaryCounter));
			
			// Reset the increment field to '1'
			outlandLegendaryIncrement.setText("1");
			
			// Calculate probability
			outlandLegendaryProbability = probabilityCalculator(outlandLegendaryCounter, 40);
			tracker.setOutlandLegendaryProbability(nf.format(outlandLegendaryProbability));
		}
		// "Scholomance Academy" legendary reset button
		else if (index == 15) {
			scholomanceLegendaryCounter = 0;
			tracker.setScholomanceLegendaryCounter(Integer.toString(scholomanceLegendaryCounter));
			
			// Reset the increment field to '1'
			scholomanceLegendaryIncrement.setText("1");
			
			// Calculate probability
			scholomanceLegendaryProbability = probabilityCalculator(scholomanceLegendaryCounter, 40);
			tracker.setScholomanceLegendaryProbability(nf.format(scholomanceLegendaryProbability));
		}
		// "Madness at the Darkmoon Faire" legendary reset button
		else if (index == 16) {
			darkmoonLegendaryCounter = 0;
			tracker.setDarkmoonLegendaryCounter(Integer.toString(darkmoonLegendaryCounter));
			
			// Reset the increment field to '1'
			darkmoonLegendaryIncrement.setText("1");
			
			// Calculate probability
			darkmoonLegendaryProbability = probabilityCalculator(darkmoonLegendaryCounter, 40);
			tracker.setDarkmoonLegendaryProbability(nf.format(darkmoonLegendaryProbability));
		}
		// "Forged in the Barrens" legendary reset button
		else if (index == 17) {
			barrensLegendaryCounter = 0;
			tracker.setBarrensLegendaryCounter(Integer.toString(barrensLegendaryCounter));
			
			// Reset the increment field to '1'
			barrensLegendaryIncrement.setText("1");
			
			// Calculate probability
			barrensLegendaryProbability = probabilityCalculator(barrensLegendaryCounter, 40);
			tracker.setBarrensLegendaryProbability(nf.format(barrensLegendaryProbability));
		}
		// "United in Stormwind" legendary reset button
		else {
			stormwindLegendaryCounter = 0;
			tracker.setStormwindLegendaryCounter(Integer.toString(stormwindLegendaryCounter));
			
			// Reset the increment field to '1'
			stormwindLegendaryIncrement.setText("1");
			
			// Calculate probability
			stormwindLegendaryProbability = probabilityCalculator(stormwindLegendaryCounter, 40);
			tracker.setStormwindLegendaryProbability(nf.format(stormwindLegendaryProbability));
		}
		
		// Update the save file
		updateSaveFile();
	}
	
	// Action performed when a legendary add button is pressed
	private void legendaryAddAction(int index) 
	{
		// "Classic" legendary add button
		if (index == 0) {
			// Check if the increment is valid, then add. Otherwise, show pop-up error message
			if (classicLegendaryCounter + Integer.valueOf(classicLegendaryIncrement.getText()) < 40) {
				classicLegendaryCounter = classicLegendaryCounter + Integer.valueOf(classicLegendaryIncrement.getText());
				
				// Reset the increment field to '1'
				classicLegendaryIncrement.setText("1");
			}
			else {
				java.awt.Toolkit.getDefaultToolkit().beep();
				JOptionPane.showMessageDialog(contentPane, incrementErrorMessage, incrementErrorTitle, JOptionPane.ERROR_MESSAGE);
			}
			tracker.setClassicLegendaryCounter(Integer.toString(classicLegendaryCounter));
			
			// Calculate probability
			classicLegendaryProbability = probabilityCalculator(classicLegendaryCounter, 40);
			tracker.setClassicLegendaryProbability(nf.format(classicLegendaryProbability));
		}
		// "Goblins vs Gnomes" legendary add button
		else if (index == 1) {
			// Check if the increment is valid, then add. Otherwise, show pop-up error message
			if (goblinsLegendaryCounter + Integer.valueOf(goblinsLegendaryIncrement.getText()) < 40) {
				goblinsLegendaryCounter = goblinsLegendaryCounter + Integer.valueOf(goblinsLegendaryIncrement.getText());
				
				// Reset the increment field to '1'
				goblinsLegendaryIncrement.setText("1");
			}
			else {
				java.awt.Toolkit.getDefaultToolkit().beep();
				JOptionPane.showMessageDialog(contentPane, incrementErrorMessage, incrementErrorTitle, JOptionPane.ERROR_MESSAGE);
			}
			tracker.setGoblinsLegendaryCounter(Integer.toString(goblinsLegendaryCounter));
			
			// Calculate probability
			goblinsLegendaryProbability = probabilityCalculator(goblinsLegendaryCounter, 40);
			tracker.setGoblinsLegendaryProbability(nf.format(goblinsLegendaryProbability));
		}
		// "The Grand Tournament" legendary add button
		else if (index == 2) {
			// Check if the increment is valid, then add. Otherwise, show pop-up error message
			if (tournamentLegendaryCounter + Integer.valueOf(tournamentLegendaryIncrement.getText()) < 40) {
				tournamentLegendaryCounter = tournamentLegendaryCounter + Integer.valueOf(tournamentLegendaryIncrement.getText());
				
				// Reset the increment field to '1'
				tournamentLegendaryIncrement.setText("1");
			}
			else {
				java.awt.Toolkit.getDefaultToolkit().beep();
				JOptionPane.showMessageDialog(contentPane, incrementErrorMessage, incrementErrorTitle, JOptionPane.ERROR_MESSAGE);
			}
			tracker.setTournamentLegendaryCounter(Integer.toString(tournamentLegendaryCounter));
			
			// Calculate probability
			tournamentLegendaryProbability = probabilityCalculator(tournamentLegendaryCounter, 40);
			tracker.setTournamentLegendaryProbability(nf.format(tournamentLegendaryProbability));
		}
		// "Whispers of the Old Gods" legendary add button
		else if (index == 3) {
			// Check if the increment is valid, then add. Otherwise, show pop-up error message
			if (oldGodsLegendaryCounter + Integer.valueOf(oldGodsLegendaryIncrement.getText()) < 40) {
				oldGodsLegendaryCounter = oldGodsLegendaryCounter + Integer.valueOf(oldGodsLegendaryIncrement.getText());
				
				// Reset the increment field to '1'
				oldGodsLegendaryIncrement.setText("1");
			}
			else {
				java.awt.Toolkit.getDefaultToolkit().beep();
				JOptionPane.showMessageDialog(contentPane, incrementErrorMessage, incrementErrorTitle, JOptionPane.ERROR_MESSAGE);
			}
			tracker.setOldGodsLegendaryCounter(Integer.toString(oldGodsLegendaryCounter));
			
			// Calculate probability
			oldGodsLegendaryProbability = probabilityCalculator(oldGodsLegendaryCounter, 40);
			tracker.setOldGodsLegendaryProbability(nf.format(oldGodsLegendaryProbability));
		}
		// "Mean Streets of Gadzetzan" legendary add button
		else if (index == 4) {
			// Check if the increment is valid, then add. Otherwise, show pop-up error message
			if (gadgetzanLegendaryCounter + Integer.valueOf(gadgetzanLegendaryIncrement.getText()) < 40) {
				gadgetzanLegendaryCounter = gadgetzanLegendaryCounter + Integer.valueOf(gadgetzanLegendaryIncrement.getText());
				
				// Reset the increment field to '1'
				gadgetzanLegendaryIncrement.setText("1");
			}
			else {
				java.awt.Toolkit.getDefaultToolkit().beep();
				JOptionPane.showMessageDialog(contentPane, incrementErrorMessage, incrementErrorTitle, JOptionPane.ERROR_MESSAGE);
			}
			tracker.setGadgetzanLegendaryCounter(Integer.toString(gadgetzanLegendaryCounter));
			
			// Calculate probability
			gadgetzanLegendaryProbability = probabilityCalculator(gadgetzanLegendaryCounter, 40);
			tracker.setGadgetzanLegendaryProbability(nf.format(gadgetzanLegendaryProbability));
		}
		// "Journey to Un'Goro" legendary add button
		else if (index == 5) {
			// Check if the increment is valid, then add. Otherwise, show pop-up error message
			if (ungoroLegendaryCounter + Integer.valueOf(ungoroLegendaryIncrement.getText()) < 40) {
				ungoroLegendaryCounter = ungoroLegendaryCounter + Integer.valueOf(ungoroLegendaryIncrement.getText());
				
				// Reset the increment field to '1'
				ungoroLegendaryIncrement.setText("1");
			}
			else {
				java.awt.Toolkit.getDefaultToolkit().beep();
				JOptionPane.showMessageDialog(contentPane, incrementErrorMessage, incrementErrorTitle, JOptionPane.ERROR_MESSAGE);
			}
			tracker.setUngoroLegendaryCounter(Integer.toString(ungoroLegendaryCounter));
			
			// Calculate probability
			ungoroLegendaryProbability = probabilityCalculator(ungoroLegendaryCounter, 40);
			tracker.setUngoroLegendaryProbability(nf.format(ungoroLegendaryProbability));
		}
		// "Knights of the Frozen Throne" legendary add button
		else if (index == 6) {
			// Check if the increment is valid, then add. Otherwise, show pop-up error message
			if (knightsLegendaryCounter + Integer.valueOf(knightsLegendaryIncrement.getText()) < 40) {
				knightsLegendaryCounter = knightsLegendaryCounter + Integer.valueOf(knightsLegendaryIncrement.getText());
				
				// Reset the increment field to '1'
				knightsLegendaryIncrement.setText("1");
			}
			else {
				java.awt.Toolkit.getDefaultToolkit().beep();
				JOptionPane.showMessageDialog(contentPane, incrementErrorMessage, incrementErrorTitle, JOptionPane.ERROR_MESSAGE);
			}
			tracker.setKnightsLegendaryCounter(Integer.toString(knightsLegendaryCounter));
			
			// Calculate probability
			knightsLegendaryProbability = probabilityCalculator(knightsLegendaryCounter, 40);
			tracker.setKnightsLegendaryProbability(nf.format(knightsLegendaryProbability));
		}
		// "Kobolds & Catacombs" legendary add button
		else if (index == 7) {
			// Check if the increment is valid, then add. Otherwise, show pop-up error message
			if (koboldsLegendaryCounter + Integer.valueOf(koboldsLegendaryIncrement.getText()) < 40) {
				koboldsLegendaryCounter = koboldsLegendaryCounter + Integer.valueOf(koboldsLegendaryIncrement.getText());
				
				// Reset the increment field to '1'
				koboldsLegendaryIncrement.setText("1");
			}
			else {
				java.awt.Toolkit.getDefaultToolkit().beep();
				JOptionPane.showMessageDialog(contentPane, incrementErrorMessage, incrementErrorTitle, JOptionPane.ERROR_MESSAGE);
			}
			tracker.setKoboldsLegendaryCounter(Integer.toString(koboldsLegendaryCounter));
			
			// Calculate probability
			koboldsLegendaryProbability = probabilityCalculator(koboldsLegendaryCounter, 40);
			tracker.setKoboldsLegendaryProbability(nf.format(koboldsLegendaryProbability));
		}
		// "The Witchwood" legendary add button
		else if (index == 8) {
			// Check if the increment is valid, then add. Otherwise, show pop-up error message
			if (witchwoodLegendaryCounter + Integer.valueOf(witchwoodLegendaryIncrement.getText()) < 40) {
				witchwoodLegendaryCounter = witchwoodLegendaryCounter + Integer.valueOf(witchwoodLegendaryIncrement.getText());
				
				// Reset the increment field to '1'
				witchwoodLegendaryIncrement.setText("1");
			}
			else {
				java.awt.Toolkit.getDefaultToolkit().beep();
				JOptionPane.showMessageDialog(contentPane, incrementErrorMessage, incrementErrorTitle, JOptionPane.ERROR_MESSAGE);
			}
			tracker.setWitchwoodLegendaryCounter(Integer.toString(witchwoodLegendaryCounter));
			
			// Calculate probability
			witchwoodLegendaryProbability = probabilityCalculator(witchwoodLegendaryCounter, 40);
			tracker.setWitchwoodLegendaryProbability(nf.format(witchwoodLegendaryProbability));
		}
		// "The Boomsday Project" legendary add button
		else if (index == 9) {
			// Check if the increment is valid, then add. Otherwise, show pop-up error message
			if (boomsdayLegendaryCounter + Integer.valueOf(boomsdayLegendaryIncrement.getText()) < 40) {
				boomsdayLegendaryCounter = boomsdayLegendaryCounter + Integer.valueOf(boomsdayLegendaryIncrement.getText());
				
				// Reset the increment field to '1'
				boomsdayLegendaryIncrement.setText("1");
			}
			else {
				java.awt.Toolkit.getDefaultToolkit().beep();
				JOptionPane.showMessageDialog(contentPane, incrementErrorMessage, incrementErrorTitle, JOptionPane.ERROR_MESSAGE);
			}
			tracker.setBoomsdayLegendaryCounter(Integer.toString(boomsdayLegendaryCounter));
			
			// Calculate probability
			boomsdayLegendaryProbability = probabilityCalculator(boomsdayLegendaryCounter, 40);
			tracker.setBoomsdayLegendaryProbability(nf.format(boomsdayLegendaryProbability));
		}
		// "Rastakhan's Rumble" legendary add button
		else if (index == 10) {
			// Check if the increment is valid, then add. Otherwise, show pop-up error message
			if (rumbleLegendaryCounter + Integer.valueOf(rumbleLegendaryIncrement.getText()) < 40) {
				rumbleLegendaryCounter = rumbleLegendaryCounter + Integer.valueOf(rumbleLegendaryIncrement.getText());
				
				// Reset the increment field to '1'
				rumbleLegendaryIncrement.setText("1");
			}
			else {
				java.awt.Toolkit.getDefaultToolkit().beep();
				JOptionPane.showMessageDialog(contentPane, incrementErrorMessage, incrementErrorTitle, JOptionPane.ERROR_MESSAGE);
			}
			tracker.setRumbleLegendaryCounter(Integer.toString(rumbleLegendaryCounter));
			
			// Calculate probability
			rumbleLegendaryProbability = probabilityCalculator(rumbleLegendaryCounter, 40);
			tracker.setRumbleLegendaryProbability(nf.format(rumbleLegendaryProbability));
		}
		// "Rise of Shadows" legendary add button
		else if (index == 11) {
			// Check if the increment is valid, then add. Otherwise, show pop-up error message
			if (shadowsLegendaryCounter + Integer.valueOf(shadowsLegendaryIncrement.getText()) < 40) {
				shadowsLegendaryCounter = shadowsLegendaryCounter + Integer.valueOf(shadowsLegendaryIncrement.getText());
				
				// Reset the increment field to '1'
				shadowsLegendaryIncrement.setText("1");
			}
			else {
				java.awt.Toolkit.getDefaultToolkit().beep();
				JOptionPane.showMessageDialog(contentPane, incrementErrorMessage, incrementErrorTitle, JOptionPane.ERROR_MESSAGE);
			}
			tracker.setShadowsLegendaryCounter(Integer.toString(shadowsLegendaryCounter));
			
			// Calculate probability
			shadowsLegendaryProbability = probabilityCalculator(shadowsLegendaryCounter, 40);
			tracker.setShadowsLegendaryProbability(nf.format(shadowsLegendaryProbability));
		}
		// "Saviors of Uldum" legendary add button
		else if (index == 12) {
			// Check if the increment is valid, then add. Otherwise, show pop-up error message
			if (uldumLegendaryCounter + Integer.valueOf(uldumLegendaryIncrement.getText()) < 40) {
				uldumLegendaryCounter = uldumLegendaryCounter + Integer.valueOf(uldumLegendaryIncrement.getText());
				
				// Reset the increment field to '1'
				uldumLegendaryIncrement.setText("1");
			}
			else {
				java.awt.Toolkit.getDefaultToolkit().beep();
				JOptionPane.showMessageDialog(contentPane, incrementErrorMessage, incrementErrorTitle, JOptionPane.ERROR_MESSAGE);
			}
			tracker.setUldumLegendaryCounter(Integer.toString(uldumLegendaryCounter));
			
			// Calculate probability
			uldumLegendaryProbability = probabilityCalculator(uldumLegendaryCounter, 40);
			tracker.setUldumLegendaryProbability(nf.format(uldumLegendaryProbability));
		}
		// "Descent of Dragons" legendary add button
		else if (index == 13) {
			// Check if the increment is valid, then add. Otherwise, show pop-up error message
			if (dragonsLegendaryCounter + Integer.valueOf(dragonsLegendaryIncrement.getText()) < 40) {
				dragonsLegendaryCounter = dragonsLegendaryCounter + Integer.valueOf(dragonsLegendaryIncrement.getText());
				
				// Reset the increment field to '1'
				dragonsLegendaryIncrement.setText("1");
			}
			else {
				java.awt.Toolkit.getDefaultToolkit().beep();
				JOptionPane.showMessageDialog(contentPane, incrementErrorMessage, incrementErrorTitle, JOptionPane.ERROR_MESSAGE);
			}
			tracker.setDragonsLegendaryCounter(Integer.toString(dragonsLegendaryCounter));
			
			// Calculate probability
			dragonsLegendaryProbability = probabilityCalculator(dragonsLegendaryCounter, 40);
			tracker.setDragonsLegendaryProbability(nf.format(dragonsLegendaryProbability));
		}
		// "Ashes of Outland" legendary add button
		else if (index == 14) {
			// Check if the increment is valid, then add. Otherwise, show pop-up error message
			if (outlandLegendaryCounter + Integer.valueOf(outlandLegendaryIncrement.getText()) < 40) {
				outlandLegendaryCounter = outlandLegendaryCounter + Integer.valueOf(outlandLegendaryIncrement.getText());
				
				// Reset the increment field to '1'
				outlandLegendaryIncrement.setText("1");
			}
			else {
				java.awt.Toolkit.getDefaultToolkit().beep();
				JOptionPane.showMessageDialog(contentPane, incrementErrorMessage, incrementErrorTitle, JOptionPane.ERROR_MESSAGE);
			}
			tracker.setOutlandLegendaryCounter(Integer.toString(outlandLegendaryCounter));
			
			// Calculate probability
			outlandLegendaryProbability = probabilityCalculator(outlandLegendaryCounter, 40);
			tracker.setOutlandLegendaryProbability(nf.format(outlandLegendaryProbability));
		}
		// "Scholomance Academy" legendary add button
		else if (index == 15) {
			// Check if the increment is valid, then add. Otherwise, show pop-up error message
			if (scholomanceLegendaryCounter + Integer.valueOf(scholomanceLegendaryIncrement.getText()) < 40) {
				scholomanceLegendaryCounter = scholomanceLegendaryCounter + Integer.valueOf(scholomanceLegendaryIncrement.getText());
				
				// Reset the increment field to '1'
				scholomanceLegendaryIncrement.setText("1");
			}
			else {
				java.awt.Toolkit.getDefaultToolkit().beep();
				JOptionPane.showMessageDialog(contentPane, incrementErrorMessage, incrementErrorTitle, JOptionPane.ERROR_MESSAGE);
			}
			tracker.setScholomanceLegendaryCounter(Integer.toString(scholomanceLegendaryCounter));
			
			// Calculate probability
			scholomanceLegendaryProbability = probabilityCalculator(scholomanceLegendaryCounter, 40);
			tracker.setScholomanceLegendaryProbability(nf.format(scholomanceLegendaryProbability));
		}
		// "Madness at the Darkmoon Faire" legendary add button
		else if (index == 16) {
			// Check if the increment is valid, then add. Otherwise, show pop-up error message
			if (darkmoonLegendaryCounter + Integer.valueOf(darkmoonLegendaryIncrement.getText()) < 40) {
				darkmoonLegendaryCounter = darkmoonLegendaryCounter + Integer.valueOf(darkmoonLegendaryIncrement.getText());
				
				// Reset the increment field to '1'
				darkmoonLegendaryIncrement.setText("1");
			}
			else {
				java.awt.Toolkit.getDefaultToolkit().beep();
				JOptionPane.showMessageDialog(contentPane, incrementErrorMessage, incrementErrorTitle, JOptionPane.ERROR_MESSAGE);
			}
			tracker.setDarkmoonLegendaryCounter(Integer.toString(darkmoonLegendaryCounter));
			
			// Calculate probability
			darkmoonLegendaryProbability = probabilityCalculator(darkmoonLegendaryCounter, 40);
			tracker.setDarkmoonLegendaryProbability(nf.format(darkmoonLegendaryProbability));
		}
		// "Forged in the Barrens" legendary add button
		else if (index == 17) {
			// Check if the increment is valid, then add. Otherwise, show pop-up error message
			if (barrensLegendaryCounter + Integer.valueOf(barrensLegendaryIncrement.getText()) < 40) {
				barrensLegendaryCounter = barrensLegendaryCounter + Integer.valueOf(barrensLegendaryIncrement.getText());
				
				// Reset the increment field to '1'
				barrensLegendaryIncrement.setText("1");
			}
			else {
				java.awt.Toolkit.getDefaultToolkit().beep();
				JOptionPane.showMessageDialog(contentPane, incrementErrorMessage, incrementErrorTitle, JOptionPane.ERROR_MESSAGE);
			}
			tracker.setBarrensLegendaryCounter(Integer.toString(barrensLegendaryCounter));
			
			// Calculate probability
			barrensLegendaryProbability = probabilityCalculator(barrensLegendaryCounter, 40);
			tracker.setBarrensLegendaryProbability(nf.format(barrensLegendaryProbability));
		}
		// "United in Stormwind" legendary add button
		else {
			// Check if the increment is valid, then add. Otherwise, show pop-up error message
			if (stormwindLegendaryCounter + Integer.valueOf(stormwindLegendaryIncrement.getText()) < 40) {
				stormwindLegendaryCounter = stormwindLegendaryCounter + Integer.valueOf(stormwindLegendaryIncrement.getText());
				
				// Reset the increment field to '1'
				stormwindLegendaryIncrement.setText("1");
			}
			else {
				java.awt.Toolkit.getDefaultToolkit().beep();
				JOptionPane.showMessageDialog(contentPane, incrementErrorMessage, incrementErrorTitle, JOptionPane.ERROR_MESSAGE);
			}
			tracker.setStormwindLegendaryCounter(Integer.toString(stormwindLegendaryCounter));
			
			// Calculate probability
			stormwindLegendaryProbability = probabilityCalculator(stormwindLegendaryCounter, 40);
			tracker.setStormwindLegendaryProbability(nf.format(stormwindLegendaryProbability));
		}
		
		// Update the save file
		updateSaveFile();
	}
	
	// Calculates the probability of finding an epic or a legendary card in the next pack
	private double probabilityCalculator(int counter, int pity) 
	{
		double probability = 0;
		
		probability = 1.0 / (pity - counter);
		probability = probability * 100;
		
		return probability;
	}
	
	// Action performed when a total modify button is pressed
	private void totalModifyAction(int index) 
	{
		// "Classic" total modify button
		if (index == 0) {
			modifyValue = JOptionPane.showInputDialog(contentPane, modifyWindow, classicTotalCounter);
			if (isInteger(modifyValue) && Integer.valueOf(modifyValue) >= 0) 
				classicTotalCounter = Integer.valueOf(modifyValue);
			else
				java.awt.Toolkit.getDefaultToolkit().beep();
			tracker.setClassicTotalCounter(Integer.toString(classicTotalCounter));
			
			// Reset the increment field to '1'
			classicTotalIncrement.setText("1");
		}
		// "Goblins vs Gnomes" total modify button
		else if (index == 1) {
			modifyValue = JOptionPane.showInputDialog(contentPane, modifyWindow, goblinsTotalCounter);
			if (isInteger(modifyValue) && Integer.valueOf(modifyValue) >= 0) 
				goblinsTotalCounter = Integer.valueOf(modifyValue);
			else
				java.awt.Toolkit.getDefaultToolkit().beep();
			tracker.setGoblinsTotalCounter(Integer.toString(goblinsTotalCounter));
			
			// Reset the increment field to '1'
			goblinsTotalIncrement.setText("1");
		}
		// "The Grand Tournament" total modify button
		else if (index == 2) {
			modifyValue = JOptionPane.showInputDialog(contentPane, modifyWindow, tournamentTotalCounter);
			if (isInteger(modifyValue) && Integer.valueOf(modifyValue) >= 0) 
				tournamentTotalCounter = Integer.valueOf(modifyValue);
			else
				java.awt.Toolkit.getDefaultToolkit().beep();
			tracker.setTournamentTotalCounter(Integer.toString(tournamentTotalCounter));
			
			// Reset the increment field to '1'
			tournamentTotalIncrement.setText("1");
		}
		// "Whispers of the Old Gods" total modify button
		else if (index == 3) {
			modifyValue = JOptionPane.showInputDialog(contentPane, modifyWindow, oldGodsTotalCounter);
			if (isInteger(modifyValue) && Integer.valueOf(modifyValue) >= 0) 
				oldGodsTotalCounter = Integer.valueOf(modifyValue);
			else
				java.awt.Toolkit.getDefaultToolkit().beep();
			tracker.setOldGodsTotalCounter(Integer.toString(oldGodsTotalCounter));
			
			// Reset the increment field to '1'
			oldGodsTotalIncrement.setText("1");
		}
		// "Mean Streets of Gadzetzan" total modify button
		else if (index == 4) {
			modifyValue = JOptionPane.showInputDialog(contentPane, modifyWindow, gadgetzanTotalCounter);
			if (isInteger(modifyValue) && Integer.valueOf(modifyValue) >= 0) 
				gadgetzanTotalCounter = Integer.valueOf(modifyValue);
			else
				java.awt.Toolkit.getDefaultToolkit().beep();
			tracker.setGadgetzanTotalCounter(Integer.toString(gadgetzanTotalCounter));
			
			// Reset the increment field to '1'
			gadgetzanTotalIncrement.setText("1");
		}
		// "Journey to Un'Goro" total modify button
		else if (index == 5) {
			modifyValue = JOptionPane.showInputDialog(contentPane, modifyWindow, ungoroTotalCounter);
			if (isInteger(modifyValue) && Integer.valueOf(modifyValue) >= 0) 
				ungoroTotalCounter = Integer.valueOf(modifyValue);
			else
				java.awt.Toolkit.getDefaultToolkit().beep();
			tracker.setUngoroTotalCounter(Integer.toString(ungoroTotalCounter));
			
			// Reset the increment field to '1'
			ungoroTotalIncrement.setText("1");
		}
		// "Knights of the Frozen Throne" total modify button
		else if (index == 6) {
			modifyValue = JOptionPane.showInputDialog(contentPane, modifyWindow, knightsTotalCounter);
			if (isInteger(modifyValue) && Integer.valueOf(modifyValue) >= 0) 
				knightsTotalCounter = Integer.valueOf(modifyValue);
			else
				java.awt.Toolkit.getDefaultToolkit().beep();
			tracker.setKnightsTotalCounter(Integer.toString(knightsTotalCounter));
			
			// Reset the increment field to '1'
			knightsTotalIncrement.setText("1");
		}
		// "Kobolds & Catacombs" total modify button
		else if (index == 7) {
			modifyValue = JOptionPane.showInputDialog(contentPane, modifyWindow, koboldsTotalCounter);
			if (isInteger(modifyValue) && Integer.valueOf(modifyValue) >= 0) 
				koboldsTotalCounter = Integer.valueOf(modifyValue);
			else
				java.awt.Toolkit.getDefaultToolkit().beep();
			tracker.setKoboldsTotalCounter(Integer.toString(koboldsTotalCounter));
			
			// Reset the increment field to '1'
			koboldsTotalIncrement.setText("1");
		}
		// "The Witchwood" total modify button
		else if (index == 8) {
			modifyValue = JOptionPane.showInputDialog(contentPane, modifyWindow, witchwoodTotalCounter);
			if (isInteger(modifyValue) && Integer.valueOf(modifyValue) >= 0) 
				witchwoodTotalCounter = Integer.valueOf(modifyValue);
			else
				java.awt.Toolkit.getDefaultToolkit().beep();
			tracker.setWitchwoodTotalCounter(Integer.toString(witchwoodTotalCounter));
			
			// Reset the increment field to '1'
			witchwoodTotalIncrement.setText("1");
		}
		// "The Boomsday Project" total modify button
		else if (index == 9) {
			modifyValue = JOptionPane.showInputDialog(contentPane, modifyWindow, boomsdayTotalCounter);
			if (isInteger(modifyValue) && Integer.valueOf(modifyValue) >= 0) 
				boomsdayTotalCounter = Integer.valueOf(modifyValue);
			else
				java.awt.Toolkit.getDefaultToolkit().beep();
			tracker.setBoomsdayTotalCounter(Integer.toString(boomsdayTotalCounter));
			
			// Reset the increment field to '1'
			boomsdayTotalIncrement.setText("1");
		}
		// "Rastakhan's Rumble" total modify button
		else if (index == 10) {
			modifyValue = JOptionPane.showInputDialog(contentPane, modifyWindow, rumbleTotalCounter);
			if (isInteger(modifyValue) && Integer.valueOf(modifyValue) >= 0) 
				rumbleTotalCounter = Integer.valueOf(modifyValue);
			else
				java.awt.Toolkit.getDefaultToolkit().beep();
			tracker.setRumbleTotalCounter(Integer.toString(rumbleTotalCounter));
			
			// Reset the increment field to '1'
			rumbleTotalIncrement.setText("1");
		}
		// "Rise of Shadows" total modify button
		else if (index == 11) {
			modifyValue = JOptionPane.showInputDialog(contentPane, modifyWindow, shadowsTotalCounter);
			if (isInteger(modifyValue) && Integer.valueOf(modifyValue) >= 0) 
				shadowsTotalCounter = Integer.valueOf(modifyValue);
			else
				java.awt.Toolkit.getDefaultToolkit().beep();
			tracker.setShadowsTotalCounter(Integer.toString(shadowsTotalCounter));
			
			// Reset the increment field to '1'
			shadowsTotalIncrement.setText("1");
		}
		// "Saviors of Uldum" total modify button
		else if (index == 12) {
			modifyValue = JOptionPane.showInputDialog(contentPane, modifyWindow, uldumTotalCounter);
			if (isInteger(modifyValue) && Integer.valueOf(modifyValue) >= 0) 
				uldumTotalCounter = Integer.valueOf(modifyValue);
			else
				java.awt.Toolkit.getDefaultToolkit().beep();
			tracker.setUldumTotalCounter(Integer.toString(uldumTotalCounter));
			
			// Reset the increment field to '1'
			uldumTotalIncrement.setText("1");
		}
		// "Descent of Dragons" total modify button
		else if (index == 13) {
			modifyValue = JOptionPane.showInputDialog(contentPane, modifyWindow, dragonsTotalCounter);
			if (isInteger(modifyValue) && Integer.valueOf(modifyValue) >= 0) 
				dragonsTotalCounter = Integer.valueOf(modifyValue);
			else
				java.awt.Toolkit.getDefaultToolkit().beep();
			tracker.setDragonsTotalCounter(Integer.toString(dragonsTotalCounter));
			
			// Reset the increment field to '1'
			dragonsTotalIncrement.setText("1");
		}
		// "Ashes of Outland" total modify button
		else if (index == 14) {
			modifyValue = JOptionPane.showInputDialog(contentPane, modifyWindow, outlandTotalCounter);
			if (isInteger(modifyValue) && Integer.valueOf(modifyValue) >= 0) 
				outlandTotalCounter = Integer.valueOf(modifyValue);
			else
				java.awt.Toolkit.getDefaultToolkit().beep();
			tracker.setOutlandTotalCounter(Integer.toString(outlandTotalCounter));
			
			// Reset the increment field to '1'
			outlandTotalIncrement.setText("1");
		}
		// "Scholomance Academy" total modify button
		else if (index == 15) {
			modifyValue = JOptionPane.showInputDialog(contentPane, modifyWindow, scholomanceTotalCounter);
			if (isInteger(modifyValue) && Integer.valueOf(modifyValue) >= 0) 
				scholomanceTotalCounter = Integer.valueOf(modifyValue);
			else
				java.awt.Toolkit.getDefaultToolkit().beep();
			tracker.setScholomanceTotalCounter(Integer.toString(scholomanceTotalCounter));
			
			// Reset the increment field to '1'
			scholomanceTotalIncrement.setText("1");
		}
		// "Madness at the Darkmoon Faire" total modify button
		else if (index == 16) {
			modifyValue = JOptionPane.showInputDialog(contentPane, modifyWindow, darkmoonTotalCounter);
			if (isInteger(modifyValue) && Integer.valueOf(modifyValue) >= 0) 
				darkmoonTotalCounter = Integer.valueOf(modifyValue);
			else
				java.awt.Toolkit.getDefaultToolkit().beep();
			tracker.setDarkmoonTotalCounter(Integer.toString(darkmoonTotalCounter));
			
			// Reset the increment field to '1'
			darkmoonTotalIncrement.setText("1");
		}
		// "Forged in the Barrens" total modify button
		else if (index == 17) {
			modifyValue = JOptionPane.showInputDialog(contentPane, modifyWindow, barrensTotalCounter);
			if (isInteger(modifyValue) && Integer.valueOf(modifyValue) >= 0) 
				barrensTotalCounter = Integer.valueOf(modifyValue);
			else
				java.awt.Toolkit.getDefaultToolkit().beep();
			tracker.setBarrensTotalCounter(Integer.toString(barrensTotalCounter));
			
			// Reset the increment field to '1'
			barrensTotalIncrement.setText("1");
		}
		// "United in Stormwind" total modify button
		else {
			modifyValue = JOptionPane.showInputDialog(contentPane, modifyWindow, stormwindTotalCounter);
			if (isInteger(modifyValue) && Integer.valueOf(modifyValue) >= 0) 
				stormwindTotalCounter = Integer.valueOf(modifyValue);
			else
				java.awt.Toolkit.getDefaultToolkit().beep();
			tracker.setStormwindTotalCounter(Integer.toString(stormwindTotalCounter));
			
			// Reset the increment field to '1'
			stormwindTotalIncrement.setText("1");
		}
		
		// Update the save file
		updateSaveFile();
	}
	
	// Action performed when a total add button is pressed
	private void totalAddAction(int index) 
	{
		// "Classic" total add button
		if (index == 0) {
			classicTotalCounter = classicTotalCounter + Integer.valueOf(classicTotalIncrement.getText());
			tracker.setClassicTotalCounter(Integer.toString(classicTotalCounter));
			
			// Reset the increment field to '1'
			classicTotalIncrement.setText("1");
		}
		// "Goblins vs Gnomes" total add button
		else if (index == 1) {
			goblinsTotalCounter = goblinsTotalCounter + Integer.valueOf(goblinsTotalIncrement.getText());
			tracker.setGoblinsTotalCounter(Integer.toString(goblinsTotalCounter));
			
			// Reset the increment field to '1'
			goblinsTotalIncrement.setText("1");
		}
		// "The Grand Tournament" total add button
		else if (index == 2) {
			tournamentTotalCounter = tournamentTotalCounter + Integer.valueOf(tournamentTotalIncrement.getText());
			tracker.setTournamentTotalCounter(Integer.toString(tournamentTotalCounter));
			
			// Reset the increment field to '1'
			tournamentTotalIncrement.setText("1");
		}
		// "Whispers of the Old Gods" total add button
		else if (index == 3) {
			oldGodsTotalCounter = oldGodsTotalCounter + Integer.valueOf(oldGodsTotalIncrement.getText());
			tracker.setOldGodsTotalCounter(Integer.toString(oldGodsTotalCounter));
			
			// Reset the increment field to '1'
			oldGodsTotalIncrement.setText("1");
		}
		// "Mean Streets of Gadzetzan" total add button
		else if (index == 4) {
			gadgetzanTotalCounter = gadgetzanTotalCounter + Integer.valueOf(gadgetzanTotalIncrement.getText());
			tracker.setGadgetzanTotalCounter(Integer.toString(gadgetzanTotalCounter));
			
			// Reset the increment field to '1'
			gadgetzanTotalIncrement.setText("1");
		}
		// "Journey to Un'Goro" total add button
		else if (index == 5) {
			ungoroTotalCounter = ungoroTotalCounter + Integer.valueOf(ungoroTotalIncrement.getText());
			tracker.setUngoroTotalCounter(Integer.toString(ungoroTotalCounter));
			
			// Reset the increment field to '1'
			ungoroTotalIncrement.setText("1");
		}
		// "Knights of the Frozen Throne" total add button
		else if (index == 6) {
			knightsTotalCounter = knightsTotalCounter + Integer.valueOf(knightsTotalIncrement.getText());
			tracker.setKnightsTotalCounter(Integer.toString(knightsTotalCounter));
			
			// Reset the increment field to '1'
			knightsTotalIncrement.setText("1");
		}
		// "Kobolds & Catacombs" total add button
		else if (index == 7) {
			koboldsTotalCounter = koboldsTotalCounter + Integer.valueOf(koboldsTotalIncrement.getText());
			tracker.setKoboldsTotalCounter(Integer.toString(koboldsTotalCounter));
			
			// Reset the increment field to '1'
			koboldsTotalIncrement.setText("1");
		}
		// "The Witchwood" total add button
		else if (index == 8) {
			witchwoodTotalCounter = witchwoodTotalCounter + Integer.valueOf(witchwoodTotalIncrement.getText());
			tracker.setWitchwoodTotalCounter(Integer.toString(witchwoodTotalCounter));
			
			// Reset the increment field to '1'
			witchwoodTotalIncrement.setText("1");
		}
		// "The Boomsday Project" total add button
		else if (index == 9) {
			boomsdayTotalCounter = boomsdayTotalCounter + Integer.valueOf(boomsdayTotalIncrement.getText());
			tracker.setBoomsdayTotalCounter(Integer.toString(boomsdayTotalCounter));
			
			// Reset the increment field to '1'
			boomsdayTotalIncrement.setText("1");
		}
		// "Rastakhan's Rumble" total add button
		else if (index == 10) {
			rumbleTotalCounter = rumbleTotalCounter + Integer.valueOf(rumbleTotalIncrement.getText());
			tracker.setRumbleTotalCounter(Integer.toString(rumbleTotalCounter));
			
			// Reset the increment field to '1'
			rumbleTotalIncrement.setText("1");
		}
		// "Rise of Shadows" total add button
		else if (index == 11) {
			shadowsTotalCounter = shadowsTotalCounter + Integer.valueOf(shadowsTotalIncrement.getText());
			tracker.setShadowsTotalCounter(Integer.toString(shadowsTotalCounter));
			
			// Reset the increment field to '1'
			shadowsTotalIncrement.setText("1");
		}
		// "Saviors of Uldum" total add button
		else if (index == 12) {
			uldumTotalCounter = uldumTotalCounter + Integer.valueOf(uldumTotalIncrement.getText());
			tracker.setUldumTotalCounter(Integer.toString(uldumTotalCounter));
			
			// Reset the increment field to '1'
			uldumTotalIncrement.setText("1");
		}
		// "Descent of Dragons" total add button
		else if (index == 13) {
			dragonsTotalCounter = dragonsTotalCounter + Integer.valueOf(dragonsTotalIncrement.getText());
			tracker.setDragonsTotalCounter(Integer.toString(dragonsTotalCounter));
			
			// Reset the increment field to '1'
			dragonsTotalIncrement.setText("1");
		}
		// "Ashes of Outland" total add button
		else if (index == 14) {
			outlandTotalCounter = outlandTotalCounter + Integer.valueOf(outlandTotalIncrement.getText());
			tracker.setOutlandTotalCounter(Integer.toString(outlandTotalCounter));
			
			// Reset the increment field to '1'
			outlandTotalIncrement.setText("1");
		}
		// "Scholomance Academy" total add button
		else if (index == 15) {
			scholomanceTotalCounter = scholomanceTotalCounter + Integer.valueOf(scholomanceTotalIncrement.getText());
			tracker.setScholomanceTotalCounter(Integer.toString(scholomanceTotalCounter));
			
			// Reset the increment field to '1'
			scholomanceTotalIncrement.setText("1");
		}
		// "Madness at the Darkmoon Faire" total add button
		else if (index == 16) {
			darkmoonTotalCounter = darkmoonTotalCounter + Integer.valueOf(darkmoonTotalIncrement.getText());
			tracker.setDarkmoonTotalCounter(Integer.toString(darkmoonTotalCounter));
			
			// Reset the increment field to '1'
			darkmoonTotalIncrement.setText("1");
		}
		// "Forged in the Barrens" total add button
		else if (index == 17) {
			barrensTotalCounter = barrensTotalCounter + Integer.valueOf(barrensTotalIncrement.getText());
			tracker.setBarrensTotalCounter(Integer.toString(barrensTotalCounter));
			
			// Reset the increment field to '1'
			barrensTotalIncrement.setText("1");
		}
		// "United in Stormwind" total add button
		else {
			stormwindTotalCounter = stormwindTotalCounter + Integer.valueOf(stormwindTotalIncrement.getText());
			tracker.setStormwindTotalCounter(Integer.toString(stormwindTotalCounter));
			
			// Reset the increment field to '1'
			stormwindTotalIncrement.setText("1");
		}
		
		// Update the save file
		updateSaveFile();
	}
	
	// Updates the save file with new values from the counters
	private void updateSaveFile() 
	{
		// Update the save file data with the new values
		saveFileData = "(WARNING! DO NOT MODIFY THIS FILE BY YOURSELF OR THE PROGRAM MIGHT NOT WORK PROPERLY AND YOU MAY LOSE YOUR TRACKER'S DATA)" + nextLine + 
				nextLine + 
				"~ Hearthstone Pity Timer Tracker ~" + nextLine + 
				nextLine + 
				"- Expansions" + nextLine + 
				"United in Stormwind" + nextLine + 
				"Forged in the Barrens" + nextLine + 
				"Madness at the Darkmoon Faire" + nextLine + 
				"Scholomance Academy" + nextLine + 
				"Ashes of Outland" + nextLine + 
				"Descent of Dragons" + nextLine + 
				"Saviors of Uldum" + nextLine + 
				"Rise of Shadows" + nextLine + 
				"Rastakhan's Rumble" + nextLine + 
				"The Boomsday Project" + nextLine + 
				"The Witchwood" + nextLine + 
				"Kobolds & Catacombs" + nextLine + 
				"Knights of the Frozen Throne" + nextLine + 
				"Journey to Un'Goro" + nextLine + 
				"Mean Streets of Gadgetzan" + nextLine + 
				"Whispers of the Old Gods" + nextLine + 
				"The Grand Tournament" + nextLine + 
				"Goblins vs Gnomes" + nextLine + 
				"Classic" + nextLine + 
				nextLine + 
				"----------" + nextLine + 
				nextLine + 
				"- Epic counters" + nextLine + 
				"United in Stormwind: " + tracker.getStormwindEpicCounter() + nextLine + 
				"Forged in the Barrens: " + tracker.getBarrensEpicCounter() + nextLine + 
				"Madness at the Darkmoon Faire: " + tracker.getDarkmoonEpicCounter() + nextLine + 
				"Scholomance Academy: " + tracker.getScholomanceEpicCounter() + nextLine + 
				"Ashes of Outland: " + tracker.getOutlandEpicCounter() + nextLine + 
				"Descent of Dragons: " + tracker.getDragonsEpicCounter() + nextLine + 
				"Saviors of Uldum: " + tracker.getUldumEpicCounter() + nextLine + 
				"Rise of Shadows: " + tracker.getShadowsEpicCounter() + nextLine + 
				"Rastakhan's Rumble: " + tracker.getRumbleEpicCounter() + nextLine + 
				"The Boomsday Project: " + tracker.getBoomsdayEpicCounter() + nextLine + 
				"The Witchwood: " + tracker.getWitchwoodEpicCounter() + nextLine + 
				"Kobolds & Catacombs: " + tracker.getKoboldsEpicCounter() + nextLine + 
				"Knights of the Frozen Throne: " + tracker.getKnightsEpicCounter() + nextLine + 
				"Journey to Un'Goro: " + tracker.getUngoroEpicCounter() + nextLine + 
				"Mean Streets of Gadgetzan: " + tracker.getGadgetzanEpicCounter() + nextLine + 
				"Whispers of the Old Gods: " + tracker.getOldGodsEpicCounter() + nextLine + 
				"The Grand Tournament: " + tracker.getTournamentEpicCounter() + nextLine + 
				"Goblins vs Gnomes: " + tracker.getGoblinsEpicCounter() + nextLine + 
				"Classic: " + tracker.getClassicEpicCounter() + nextLine + 
				nextLine + 
				"- Epic probabilities" + nextLine + 
				"United in Stormwind: " + tracker.getStormwindEpicProbability() + nextLine + 
				"Forged in the Barrens: " + tracker.getBarrensEpicProbability() + nextLine + 
				"Madness at the Darkmoon Faire: " + tracker.getDarkmoonEpicProbability() + nextLine + 
				"Scholomance Academy: " + tracker.getScholomanceEpicProbability() + nextLine + 
				"Ashes of Outland: " + tracker.getOutlandEpicProbability() + nextLine + 
				"Descent of Dragons: " + tracker.getDragonsEpicProbability() + nextLine + 
				"Saviors of Uldum: " + tracker.getUldumEpicProbability() + nextLine + 
				"Rise of Shadows: " + tracker.getShadowsEpicProbability() + nextLine + 
				"Rastakhan's Rumble: " + tracker.getRumbleEpicProbability() + nextLine + 
				"The Boomsday Project: " + tracker.getBoomsdayEpicProbability() + nextLine + 
				"The Witchwood: " + tracker.getWitchwoodEpicProbability() + nextLine + 
				"Kobolds & Catacombs: " + tracker.getKoboldsEpicProbability() + nextLine + 
				"Knights of the Frozen Throne: " + tracker.getKnightsEpicProbability() + nextLine + 
				"Journey to Un'Goro: " + tracker.getUngoroEpicProbability() + nextLine + 
				"Mean Streets of Gadgetzan: " + tracker.getGadgetzanEpicProbability() + nextLine + 
				"Whispers of the Old Gods: " + tracker.getOldGodsEpicProbability() + nextLine + 
				"The Grand Tournament: " + tracker.getTournamentEpicProbability() + nextLine + 
				"Goblins vs Gnomes: " + tracker.getGoblinsEpicProbability() + nextLine + 
				"Classic: " + tracker.getClassicEpicProbability() + nextLine + 
				nextLine + 
				"----------" + nextLine + 
				nextLine + 
				"- Legendary counters" + nextLine + 
				"United in Stormwind: " + tracker.getStormwindLegendaryCounter() + nextLine + 
				"Forged in the Barrens: " + tracker.getBarrensLegendaryCounter() + nextLine + 
				"Madness at the Darkmoon Faire: " + tracker.getDarkmoonLegendaryCounter() + nextLine + 
				"Scholomance Academy: " + tracker.getScholomanceLegendaryCounter() + nextLine + 
				"Ashes of Outland: " + tracker.getOutlandLegendaryCounter() + nextLine + 
				"Descent of Dragons: " + tracker.getDragonsLegendaryCounter() + nextLine + 
				"Saviors of Uldum: " + tracker.getUldumLegendaryCounter() + nextLine + 
				"Rise of Shadows: " + tracker.getShadowsLegendaryCounter() + nextLine + 
				"Rastakhan's Rumble: " + tracker.getRumbleLegendaryCounter() + nextLine + 
				"The Boomsday Project: " + tracker.getBoomsdayLegendaryCounter() + nextLine + 
				"The Witchwood: " + tracker.getWitchwoodLegendaryCounter() + nextLine + 
				"Kobolds & Catacombs: " + tracker.getKoboldsLegendaryCounter() + nextLine + 
				"Knights of the Frozen Throne: " + tracker.getKnightsLegendaryCounter() + nextLine + 
				"Journey to Un'Goro: " + tracker.getUngoroLegendaryCounter() + nextLine + 
				"Mean Streets of Gadgetzan: " + tracker.getGadgetzanLegendaryCounter() + nextLine + 
				"Whispers of the Old Gods: " + tracker.getOldGodsLegendaryCounter() + nextLine + 
				"The Grand Tournament: " + tracker.getTournamentLegendaryCounter() + nextLine + 
				"Goblins vs Gnomes: " + tracker.getGoblinsLegendaryCounter() + nextLine + 
				"Classic: " + tracker.getClassicLegendaryCounter() + nextLine + 
				nextLine + 
				"- Legendary probabilities" + nextLine + 
				"United in Stormwind: " + tracker.getStormwindLegendaryProbability() + nextLine + 
				"Forged in the Barrens: " + tracker.getBarrensLegendaryProbability() + nextLine + 
				"Madness at the Darkmoon Faire: " + tracker.getDarkmoonLegendaryProbability() + nextLine + 
				"Scholomance Academy: " + tracker.getScholomanceLegendaryProbability() + nextLine + 
				"Ashes of Outland: " + tracker.getOutlandLegendaryProbability() + nextLine + 
				"Descent of Dragons: " + tracker.getDragonsLegendaryProbability() + nextLine + 
				"Saviors of Uldum: " + tracker.getUldumLegendaryProbability() + nextLine + 
				"Rise of Shadows: " + tracker.getShadowsLegendaryProbability() + nextLine + 
				"Rastakhan's Rumble: " + tracker.getRumbleLegendaryProbability() + nextLine + 
				"The Boomsday Project: " + tracker.getBoomsdayLegendaryProbability() + nextLine + 
				"The Witchwood: " + tracker.getWitchwoodLegendaryProbability() + nextLine + 
				"Kobolds & Catacombs: " + tracker.getKoboldsLegendaryProbability() + nextLine + 
				"Knights of the Frozen Throne: " + tracker.getKnightsLegendaryProbability() + nextLine + 
				"Journey to Un'Goro: " + tracker.getUngoroLegendaryProbability() + nextLine + 
				"Mean Streets of Gadgetzan: " + tracker.getGadgetzanLegendaryProbability() + nextLine + 
				"Whispers of the Old Gods: " + tracker.getOldGodsLegendaryProbability() + nextLine + 
				"The Grand Tournament: " + tracker.getTournamentLegendaryProbability() + nextLine + 
				"Goblins vs Gnomes: " + tracker.getGoblinsLegendaryProbability() + nextLine + 
				"Classic: " + tracker.getClassicLegendaryProbability() + nextLine + 
				nextLine + 
				"----------" + nextLine + 
				nextLine + 
				"- Total counters" + nextLine + 
				"United in Stormwind: " + tracker.getStormwindTotalCounter() + nextLine + 
				"Forged in the Barrens: " + tracker.getBarrensTotalCounter() + nextLine + 
				"Madness at the Darkmoon Faire: " + tracker.getDarkmoonTotalCounter() + nextLine + 
				"Scholomance Academy: " + tracker.getScholomanceTotalCounter() + nextLine + 
				"Ashes of Outland: " + tracker.getOutlandTotalCounter() + nextLine + 
				"Descent of Dragons: " + tracker.getDragonsTotalCounter() + nextLine + 
				"Saviors of Uldum: " + tracker.getUldumTotalCounter() + nextLine + 
				"Rise of Shadows: " + tracker.getShadowsTotalCounter() + nextLine + 
				"Rastakhan's Rumble: " + tracker.getRumbleTotalCounter() + nextLine + 
				"The Boomsday Project: " + tracker.getBoomsdayTotalCounter() + nextLine + 
				"The Witchwood: " + tracker.getWitchwoodTotalCounter() + nextLine + 
				"Kobolds & Catacombs: " + tracker.getKoboldsTotalCounter() + nextLine + 
				"Knights of the Frozen Throne: " + tracker.getKnightsTotalCounter() + nextLine + 
				"Journey to Un'Goro: " + tracker.getUngoroTotalCounter() + nextLine + 
				"Mean Streets of Gadgetzan: " + tracker.getGadgetzanTotalCounter() + nextLine + 
				"Whispers of the Old Gods: " + tracker.getOldGodsTotalCounter() + nextLine + 
				"The Grand Tournament: " + tracker.getTournamentTotalCounter() + nextLine + 
				"Goblins vs Gnomes: " + tracker.getGoblinsTotalCounter() + nextLine + 
				"Classic: " + tracker.getClassicTotalCounter();
		
		// Write the updated data in the save file
		saveFile.setWritable(true);
		writeSaveFile(saveFileData);
		saveFile.setReadOnly();
	}
	
	public static void main(String[] args) throws InterruptedException, InvocationTargetException 
	{
		// Windows style
		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		} catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException e) {
			e.printStackTrace();
		}
		
		// Tracker window
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				trackerWindow = new JFrame(trackerTitle);
				trackerIconURL = getClass().getClassLoader().getResource(trackerIconPath);
				try {
					trackerIcon = ImageIO.read(trackerIconURL);
				} catch (IOException e) {
				    e.printStackTrace();
				}
				trackerWindow.setIconImage(trackerIcon);
				trackerWindow.setMinimumSize(new Dimension(1200, 530));
				trackerWindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				trackerWindow.setResizable(true);
			}
		});
		
		tracker = new TrackerGUI();
		
		// Tracker window components
	    SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				trackerWindowContentPanel = tracker.getTrackerWindowContentPanel();
				
				contentPane = trackerWindow.getContentPane();
				contentPane.add(trackerWindowContentPanel);
				
				trackerWindow.pack();
				trackerWindow.setSize(1300, 730);
				trackerWindow.setLocationRelativeTo(null);
			}
	    });
	    
	    // Tracker functionality
	    new HSPityTimerTracker();
	    
	    // Show tracker
	    SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				trackerWindow.setVisible(true);
			}
	    });
	}
}
