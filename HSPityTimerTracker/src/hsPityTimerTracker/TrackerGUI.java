package hsPityTimerTracker;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.URL;

import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextPane;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;
import javax.swing.text.BadLocationException;
import javax.swing.text.SimpleAttributeSet;
import javax.swing.text.StyleConstants;
import javax.swing.text.StyledDocument;

public class TrackerGUI 
{
	// Variables
	
	// Tracker Panel
	private ScrollablePanel trackerPanel;
	
	// Tracker header
	private JPanel trackerHeader;
	
	// "Help" button
	private JPanel helpButtonPanel;
	
	private JButton help;
	
	private BufferedImage helpIcon;
	private URL helpIconURL;
	private final String helpIconPath = "header_icons/help.png";
	
	private BufferedImage helpHoverIcon;
	private URL helpHoverIconURL;
	private final String helpHoverIconPath = "header_icons/help_hover.png";
	
	// Message displaying when hovering over the "Show save file" button
	private final String helpToolTipText = "Learn more about how this program works";
	
	// Tracker title
	private JPanel headerTitlePanel;
	
	private final String headerTitleText = "Hearthstone Pity Timer Tracker";
	private JLabel headerTitle;
	
	private JLabel headerImageLabel;
	private JLabel headerImageTwoLabel;	
	private BufferedImage headerImage;
	private URL headerImageURL;
	private final String headerImagePath = "header_icons/hearthstone_icon.png";
	
	// "Show save file" button
	private JPanel showSaveButtonPanel;
	
	private JButton showSaveFileFolder;
	
	private BufferedImage showSaveFileFolderIcon;
	private URL showSaveFileFolderIconURL;
	private final String showSaveFileFolderIconPath = "header_icons/show_save_folder.png";
	
	private BufferedImage  showSaveFileFolderHoverIcon;
	private URL  showSaveFileFolderHoverIconURL;
	private final String showSaveFileFolderHoverIconPath = "header_icons/show_save_folder_hover.png";
	
	// Message displaying when hovering over the "Show save file" button
	private final String showSaveFileFolderToolTipText = "Show the save file in the folder it is located";
	
	// Hearthstone Game Modes sets
	private JPanel standard;
	private JPanel wild;
	
	// Game Modes sets title headers
	private JPanel standardHeader;
	private JPanel wildHeader;
	
	// Game Modes sets titles
	private final String standardTitle = "Standard Sets";
	private final String wildTitle = "Wild Sets";
	
	private JLabel standardLabel;
	private JLabel wildLabel;
	
	// Game Modes sets logos
	private JLabel standardImageLabel;
	private BufferedImage standardImage;
	private URL standardImageURL;
	private final String standardImagePath = "hs_game_modes_icons/standard_mode.png";
	
	private JLabel wildImageLabel;
	private BufferedImage wildImage;
	private URL wildImageURL;
	private final String wildImagePath = "hs_game_modes_icons/wild_mode.png";
	
	// Checkbox toggling showing "Wild Sets"
	private JCheckBox showWild;
	private final String showWildToolTipText = "Show Wild Sets"; // Message displaying when hovering over the toggle "Wild Sets" button
	
	// Checkbox state icons
	private BufferedImage showWildUnselectedIcon;
	private URL showWildUnselectedIconURL;
	private final String showWildUnselectedIconPath = "wild_checkbox_icons/checkbox_unselected.png";
	
	private BufferedImage showWildSelectedIcon;
	private URL showWildSelectedIconURL;
	private final String showWildSelectedIconPath = "wild_checkbox_icons/checkbox_selected.png";
	
	private BufferedImage showWildUnselectedHoverIcon;
	private URL showWildUnselectedHoverIconURL;
	private final String showWildUnselectedHoverIconPath = "wild_checkbox_icons/checkbox_unselected_hover.png";
	
	private BufferedImage showWildSelectedHoverIcon;
	private URL showWildSelectedHoverIconURL;
	private final String showWildSelectedHoverIconPath = "wild_checkbox_icons/checkbox_selected_hover.png";
	
	// Hearthstone Years
	private JPanel gryphon; // Year of the Gryphon
	private JPanel phoenix; // Year of the Phoenix
	private JPanel dragon; // Year of the Dragon
	private JPanel raven; // Year of the Raven
	private JPanel mammoth; // Year of the Mammoth
	private JPanel kraken; // Year of the Kraken
	private JPanel classicSets; // Classic Sets
	
	// Years title headers
	private JPanel gryphonHeader;
	private JPanel phoenixHeader;
	private JPanel dragonHeader;
	private JPanel ravenHeader;
	private JPanel mammothHeader;
	private JPanel krakenHeader;
	private JPanel classicSetsHeader;
	
	// Years titles
	private final String gryphonTitle = "Year of the Gryphon (2021)";
	private final String phoenixTitle = "Year of the Phoenix (2020)";
	private final String dragonTitle = "Year of the Dragon (2019)";
	private final String ravenTitle = "Year of the Raven (2018)";
	private final String mammothTitle = "Year of the Mammoth (2017)";
	private final String krakenTitle = "Year of the Kraken (2016)";
	private final String classicSetsTitle = "Classic Sets (2014-2015)";
	
	private JLabel gryphonLabel;
	private JLabel phoenixLabel;
	private JLabel dragonLabel;
	private JLabel ravenLabel;
	private JLabel mammothLabel;
	private JLabel krakenLabel;
	private JLabel classicSetsLabel;
	
	// Years logos
	private JLabel gryphonImageLabel;
	private BufferedImage gryphonImage;
	private URL gryphonImageURL;
	private final String gryphonImagePath = "hs_years_icons/year_of_the_gryphon.png";
	
	private JLabel phoenixImageLabel;
	private BufferedImage phoenixImage;
	private URL phoenixImageURL;
	private final String phoenixImagePath = "hs_years_icons/year_of_the_phoenix.png";
	
	private JLabel dragonImageLabel;
	private BufferedImage dragonImage;
	private URL dragonImageURL;
	private final String dragonImagePath = "hs_years_icons/year_of_the_dragon.png";
	
	private JLabel ravenImageLabel;
	private BufferedImage ravenImage;
	private URL ravenImageURL;
	private final String ravenImagePath = "hs_years_icons/year_of_the_raven.png";
	
	private JLabel mammothImageLabel;
	private BufferedImage mammothImage;
	private URL mammothImageURL;
	private final String mammothImagePath = "hs_years_icons/year_of_the_mammoth.png";
	
	private JLabel krakenImageLabel;
	private BufferedImage krakenImage;
	private URL krakenImageURL;
	private final String krakenImagePath = "hs_years_icons/year_of_the_kraken.png";
	
	private JLabel classicSetsImageLabel;
	private BufferedImage classicSetsImage;
	private URL classicSetsImageURL;
	private final String classicSetsImagePath = "hs_years_icons/classic_sets.png";
	
	// Hearthstone Expansions
	// Year of the Gryphon
	private JPanel barrens; // Forged in the Barrens
	// Year of the Phoenix
	private JPanel darkmoon; // Madness at the Darkmoon Faire
	private JPanel scholomance; // Scholomance Academy
	private JPanel outland; // Ashes of Outland
	// Year of the Dragon
	private JPanel dragons; // Descent of Dragons
	private JPanel uldum; // Saviors of Uldum
	private JPanel shadows; // Rise of Shadows
	// Year of the Raven
	private JPanel rumble; // Rastakhan's Rumble
	private JPanel boomsday; // The Boomsday Project
	private JPanel witchwood; // The Witchwood
	// Year of the Mammoth
	private JPanel kobolds; // Kobolds & Catacombs
	private JPanel knights; // Knights of the Frozen Throne
	private JPanel ungoro; // Journey to Un'Goro
	// Year of the Mammoth
	private JPanel gadgetzan; // Mean Streets of Gadzetzan
	private JPanel oldGods; // Whispers of the Old Gods
	// Classic Sets
	private JPanel tournament; // The Grand Tournament
	private JPanel goblins; // Goblins vs Gnomes
	private JPanel classic; // Classic
	
	// Expansions logos	
	private JButton barrensImageButton;
	private BufferedImage barrensImage;
	private URL barrensImageURL;
	private final String barrensImagePath = "hs_expansions_icons/forged_in_the_barrens.png";
	
	private JButton darkmoonImageButton;
	private BufferedImage darkmoonImage;
	private URL darkmoonImageURL;
	private final String darkmoonImagePath = "hs_expansions_icons/madness_at_the_darkmoon_faire.png";
	
	private JButton scholomanceImageButton;
	private BufferedImage scholomanceImage;
	private URL scholomanceImageURL;
	private final String scholomanceImagePath = "hs_expansions_icons/scholomance_academy.png";
	
	private JButton outlandImageButton;
	private BufferedImage outlandImage;
	private URL outlandImageURL;
	private final String outlandImagePath = "hs_expansions_icons/ashes_of_outland.png";
	
	private JButton dragonsImageButton;
	private BufferedImage dragonsImage;
	private URL dragonsImageURL;
	private final String dragonsImagePath = "hs_expansions_icons/descent_of_dragons.png";
	
	private JButton uldumImageButton;
	private BufferedImage uldumImage;
	private URL uldumImageURL;
	private final String uldumImagePath = "hs_expansions_icons/saviors_of_uldum.png";
	
	private JButton shadowsImageButton;
	private BufferedImage shadowsImage;
	private URL shadowsImageURL;
	private final String shadowsImagePath = "hs_expansions_icons/rise_of_shadows.png";
	
	private JButton rumbleImageButton;
	private BufferedImage rumbleImage;
	private URL rumbleImageURL;
	private final String rumbleImagePath = "hs_expansions_icons/rastakhans_rumble.png";
	
	private JButton boomsdayImageButton;
	private BufferedImage boomsdayImage;
	private URL boomsdayImageURL;
	private final String boomsdayImagePath = "hs_expansions_icons/the_boomsday_project.png";
	
	private JButton witchwoodImageButton;
	private BufferedImage witchwoodImage;
	private URL witchwoodImageURL;
	private final String witchwoodImagePath = "hs_expansions_icons/the_witchwood.png";
	
	private JButton koboldsImageButton;
	private BufferedImage koboldsImage;
	private URL koboldsImageURL;
	private final String koboldsImagePath = "hs_expansions_icons/kobolds_and_catacombs.png";
	
	private JButton knightsImageButton;
	private BufferedImage knightsImage;
	private URL knightsImageURL;
	private final String knightsImagePath = "hs_expansions_icons/knights_of_the_frozen_throne.png";
	
	private JButton ungoroImageButton;
	private BufferedImage ungoroImage;
	private URL ungoroImageURL;
	private final String ungoroImagePath = "hs_expansions_icons/journey_to_ungoro.png";
	
	private JButton gadgetzanImageButton;
	private BufferedImage gadgetzanImage;
	private URL gadgetzanImageURL;
	private final String gadgetzanImagePath = "hs_expansions_icons/mean_streets_of_gadgetzan.png";
	
	private JButton oldGodsImageButton;
	private BufferedImage oldGodsImage;
	private URL oldGodsImageURL;
	private final String oldGodsImagePath = "hs_expansions_icons/whispers_of_the_old_gods.png";
	
	private JButton tournamentImageButton;
	private BufferedImage tournamentImage;
	private URL tournamentImageURL;
	private final String tournamentImagePath = "hs_expansions_icons/the_grand_tournament.png";
	
	private JButton goblinsImageButton;
	private BufferedImage goblinsImage;
	private URL goblinsImageURL;
	private final String goblinsImagePath = "hs_expansions_icons/goblins_vs_gnomes.png";
	
	private JLabel classicImageLabel;
	private BufferedImage classicImage;
	private URL classicImageURL;
	private final String classicImagePath = "hs_expansions_icons/classic.png";
	
	// Message displaying when hovering over an expansion logo
	private final String imageButtonToolTipText = "Go to the expansion's official webpage";
	
	private JPanel barrensImagePanel;
	private JPanel darkmoonImagePanel;
	private JPanel scholomanceImagePanel;
	private JPanel outlandImagePanel;
	private JPanel dragonsImagePanel;
	private JPanel uldumImagePanel;
	private JPanel shadowsImagePanel;
	private JPanel rumbleImagePanel;
	private JPanel boomsdayImagePanel;
	private JPanel witchwoodImagePanel;
	private JPanel koboldsImagePanel;
	private JPanel knightsImagePanel;
	private JPanel ungoroImagePanel;
	private JPanel gadgetzanImagePanel;
	private JPanel oldGodsImagePanel;
	private JPanel tournamentImagePanel;
	private JPanel goblinsImagePanel;
	private JPanel classicImagePanel;
/*	
	// Expansions title labels
	private final String barrensTitle = "Forged in the Barrens";
	private final String darkmoonTitle = "Madness at the Darkmoon Faire";
	private final String scholomanceTitle = "Scholomance Academy";
	private final String outlandTitle = "Ashes of Outland";
	private final String dragonsTitle = "Descent of Dragons";
	private final String uldumTitle = "Saviors of Uldum";
	private final String shadowsTitle = "Rise of Shadows";
	private final String rumbleTitle = "Rastakhan's Rumble";
	private final String boomsdayTitle = "The Boomsday Project";
	private final String witchwoodTitle = "The Witchwood";
	private final String koboldsTitle = "Kobolds & Catacombs";
	private final String knightsTitle = "Knights of the Frozen Throne";
	private final String ungoroTitle = "Journey to Un'Goro";
	private final String gadgetzanTitle = "Mean Streets of Gadgetzan";
	private final String oldGodsTitle = "Whispers of the Old Gods";
	private final String tournamentTitle = "The Grand Tournament";
	private final String goblinsTitle = "Goblins vs Gnomes";
	private final String classicTitle = "Classic";
	
	private JTextPane barrensTitleLabel;
	private JTextPane darkmoonTitleLabel;
	private JTextPane scholomanceTitleLabel;
	private JTextPane outlandTitleLabel;
	private JTextPane dragonsTitleLabel;
	private JTextPane uldumTitleLabel;
	private JTextPane shadowsTitleLabel;
	private JTextPane rumbleTitleLabel;
	private JTextPane boomsdayTitleLabel;
	private JTextPane witchwoodTitleLabel;
	private JTextPane koboldsTitleLabel;
	private JTextPane knightsTitleLabel;
	private JTextPane ungoroTitleLabel;
	private JTextPane gadgetzanTitleLabel;
	private JTextPane oldGodsTitleLabel;
	private JTextPane tournamentTitleLabel;
	private JTextPane goblinsTitleLabel;
	private JTextPane classicTitleLabel;
	
	// Expansions title labels
	private final String barrensDate = "(March 2021)";
	private final String darkmoonDate = "(November 2020)";
	private final String scholomanceDate = "(August 2020)";
	private final String outlandDate = "(April 2020)";
	private final String dragonsDate = "(December 2019)";
	private final String uldumDate = "(August 2019)";
	private final String shadowsDate = "(April 2019)";
	private final String rumbleDate = "(December 2018)";
	private final String boomsdayDate = "(July 2018)";
	private final String witchwoodDate = "(April 2018)";
	private final String koboldsDate = "(December 2017)";
	private final String knightsDate = "(August 2017)";
	private final String ungoroDate = "(April 2017)";
	private final String gadgetzanDate = "(December 2016)";
	private final String oldGodsDate = "(April 2016)";
	private final String tournamentDate = "(August 2015)";
	private final String goblinsDate = "(December 2014)";
	private final String classicDate = "(March 2014)";
	
	private JTextPane barrensDateLabel;
	private JTextPane darkmoonDateLabel;
	private JTextPane scholomanceDateLabel;
	private JTextPane outlandDateLabel;
	private JTextPane dragonsDateLabel;
	private JTextPane uldumDateLabel;
	private JTextPane shadowsDateLabel;
	private JTextPane rumbleDateLabel;
	private JTextPane boomsdayDateLabel;
	private JTextPane witchwoodDateLabel;
	private JTextPane koboldsDateLabel;
	private JTextPane knightsDateLabel;
	private JTextPane ungoroDateLabel;
	private JTextPane gadgetzanDateLabel;
	private JTextPane oldGodsDateLabel;
	private JTextPane tournamentDateLabel;
	private JTextPane goblinsDateLabel;
	private JTextPane classicDateLabel;
*/	
	// Epic counter panel title
	private final String epicPanelTitle = "Epic Pity Timer";
	private JTextPane epicPanelTitleLabel;
	
	// Packs without epic counter panels
	private JPanel barrensEpicPanel;
	private JPanel darkmoonEpicPanel;
	private JPanel scholomanceEpicPanel;
	private JPanel outlandEpicPanel;
	private JPanel dragonsEpicPanel;
	private JPanel uldumEpicPanel;
	private JPanel shadowsEpicPanel;
	private JPanel rumbleEpicPanel;
	private JPanel boomsdayEpicPanel;
	private JPanel witchwoodEpicPanel;
	private JPanel koboldsEpicPanel;
	private JPanel knightsEpicPanel;
	private JPanel ungoroEpicPanel;
	private JPanel gadgetzanEpicPanel;
	private JPanel oldGodsEpicPanel;
	private JPanel tournamentEpicPanel;
	private JPanel goblinsEpicPanel;
	private JPanel classicEpicPanel;
	
	// Message displaying the amount of packs opened without an epic card
	private final String epicCounterText = "Packs opened without an epic card:   ";
	
	private JTextPane barrensEpicCounterText;
	private JTextPane darkmoonEpicCounterText;
	private JTextPane scholomanceEpicCounterText;
	private JTextPane outlandEpicCounterText;
	private JTextPane dragonsEpicCounterText;
	private JTextPane uldumEpicCounterText;
	private JTextPane shadowsEpicCounterText;
	private JTextPane rumbleEpicCounterText;
	private JTextPane boomsdayEpicCounterText;
	private JTextPane witchwoodEpicCounterText;
	private JTextPane koboldsEpicCounterText;
	private JTextPane knightsEpicCounterText;
	private JTextPane ungoroEpicCounterText;
	private JTextPane gadgetzanEpicCounterText;
	private JTextPane oldGodsEpicCounterText;
	private JTextPane tournamentEpicCounterText;
	private JTextPane goblinsEpicCounterText;
	private JTextPane classicEpicCounterText;
	
	// Epic packs counters (Labels showing the current amount of packs opened without finding an epic card from each expansion)
	private String barrensEpicCounter;
	private String darkmoonEpicCounter;
	private String scholomanceEpicCounter;
	private String outlandEpicCounter;
	private String dragonsEpicCounter;
	private String uldumEpicCounter;
	private String shadowsEpicCounter;
	private String rumbleEpicCounter;
	private String boomsdayEpicCounter;
	private String witchwoodEpicCounter;
	private String koboldsEpicCounter;
	private String knightsEpicCounter;
	private String ungoroEpicCounter;
	private String gadgetzanEpicCounter;
	private String oldGodsEpicCounter;
	private String tournamentEpicCounter;
	private String goblinsEpicCounter;
	private String classicEpicCounter;
	
	// Epic counters modify buttons panels
	private JPanel barrensEpicModifyPanel;
	private JPanel darkmoonEpicModifyPanel;
	private JPanel scholomanceEpicModifyPanel;
	private JPanel outlandEpicModifyPanel;
	private JPanel dragonsEpicModifyPanel;
	private JPanel uldumEpicModifyPanel;
	private JPanel shadowsEpicModifyPanel;
	private JPanel rumbleEpicModifyPanel;
	private JPanel boomsdayEpicModifyPanel;
	private JPanel witchwoodEpicModifyPanel;
	private JPanel koboldsEpicModifyPanel;
	private JPanel knightsEpicModifyPanel;
	private JPanel ungoroEpicModifyPanel;
	private JPanel gadgetzanEpicModifyPanel;
	private JPanel oldGodsEpicModifyPanel;
	private JPanel tournamentEpicModifyPanel;
	private JPanel goblinsEpicModifyPanel;
	private JPanel classicEpicModifyPanel;
	
	// Epic counters modifiers
	// Reset buttons
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
	
	// Message displaying the probability of finding an epic card
	private final String epicProbabilityText = "Probability of finding an epic card in the next pack:   ";
	
	private JTextPane barrensEpicProbabilityText;
	private JTextPane darkmoonEpicProbabilityText;
	private JTextPane scholomanceEpicProbabilityText;
	private JTextPane outlandEpicProbabilityText;
	private JTextPane dragonsEpicProbabilityText;
	private JTextPane uldumEpicProbabilityText;
	private JTextPane shadowsEpicProbabilityText;
	private JTextPane rumbleEpicProbabilityText;
	private JTextPane boomsdayEpicProbabilityText;
	private JTextPane witchwoodEpicProbabilityText;
	private JTextPane koboldsEpicProbabilityText;
	private JTextPane knightsEpicProbabilityText;
	private JTextPane ungoroEpicProbabilityText;
	private JTextPane gadgetzanEpicProbabilityText;
	private JTextPane oldGodsEpicProbabilityText;
	private JTextPane tournamentEpicProbabilityText;
	private JTextPane goblinsEpicProbabilityText;
	private JTextPane classicEpicProbabilityText;
	
	// Epic probabilities (Labels showing the probability of finding an epic card from each expansion)
	private String barrensEpicProbability;
	private String darkmoonEpicProbability;
	private String scholomanceEpicProbability;
	private String outlandEpicProbability;
	private String dragonsEpicProbability;
	private String uldumEpicProbability;
	private String shadowsEpicProbability;
	private String rumbleEpicProbability;
	private String boomsdayEpicProbability;
	private String witchwoodEpicProbability;
	private String koboldsEpicProbability;
	private String knightsEpicProbability;
	private String ungoroEpicProbability;
	private String gadgetzanEpicProbability;
	private String oldGodsEpicProbability;
	private String tournamentEpicProbability;
	private String goblinsEpicProbability;
	private String classicEpicProbability;
	
	// Legendary counter panel title
	private final String legendaryPanelTitle = "Legendary Pity Timer";
	private JTextPane legendaryPanelTitleLabel;
	
	// Packs without legendary counter panels
	private JPanel barrensLegendaryPanel;
	private JPanel darkmoonLegendaryPanel;
	private JPanel scholomanceLegendaryPanel;
	private JPanel outlandLegendaryPanel;
	private JPanel dragonsLegendaryPanel;
	private JPanel uldumLegendaryPanel;
	private JPanel shadowsLegendaryPanel;
	private JPanel rumbleLegendaryPanel;
	private JPanel boomsdayLegendaryPanel;
	private JPanel witchwoodLegendaryPanel;
	private JPanel koboldsLegendaryPanel;
	private JPanel knightsLegendaryPanel;
	private JPanel ungoroLegendaryPanel;
	private JPanel gadgetzanLegendaryPanel;
	private JPanel oldGodsLegendaryPanel;
	private JPanel tournamentLegendaryPanel;
	private JPanel goblinsLegendaryPanel;
	private JPanel classicLegendaryPanel;
	
	// Message displaying the amount of packs opened without a legendary card
	private final String legendaryCounterText = "Packs opened without a legendary card:   ";
	
	private JTextPane barrensLegendaryCounterText;
	private JTextPane darkmoonLegendaryCounterText;
	private JTextPane scholomanceLegendaryCounterText;
	private JTextPane outlandLegendaryCounterText;
	private JTextPane dragonsLegendaryCounterText;
	private JTextPane uldumLegendaryCounterText;
	private JTextPane shadowsLegendaryCounterText;
	private JTextPane rumbleLegendaryCounterText;
	private JTextPane boomsdayLegendaryCounterText;
	private JTextPane witchwoodLegendaryCounterText;
	private JTextPane koboldsLegendaryCounterText;
	private JTextPane knightsLegendaryCounterText;
	private JTextPane ungoroLegendaryCounterText;
	private JTextPane gadgetzanLegendaryCounterText;
	private JTextPane oldGodsLegendaryCounterText;
	private JTextPane tournamentLegendaryCounterText;
	private JTextPane goblinsLegendaryCounterText;
	private JTextPane classicLegendaryCounterText;
	
	// Legendary packs counters (Labels showing the current amount of packs opened without finding a legendary card from each expansion)
	private String barrensLegendaryCounter;
	private String darkmoonLegendaryCounter;
	private String scholomanceLegendaryCounter;
	private String outlandLegendaryCounter;
	private String dragonsLegendaryCounter;
	private String uldumLegendaryCounter;
	private String shadowsLegendaryCounter;
	private String rumbleLegendaryCounter;
	private String boomsdayLegendaryCounter;
	private String witchwoodLegendaryCounter;
	private String koboldsLegendaryCounter;
	private String knightsLegendaryCounter;
	private String ungoroLegendaryCounter;
	private String gadgetzanLegendaryCounter;
	private String oldGodsLegendaryCounter;
	private String tournamentLegendaryCounter;
	private String goblinsLegendaryCounter;
	private String classicLegendaryCounter;
	
	// Legendary counters modify buttons panels
	private JPanel barrensLegendaryModifyPanel;
	private JPanel darkmoonLegendaryModifyPanel;
	private JPanel scholomanceLegendaryModifyPanel;
	private JPanel outlandLegendaryModifyPanel;
	private JPanel dragonsLegendaryModifyPanel;
	private JPanel uldumLegendaryModifyPanel;
	private JPanel shadowsLegendaryModifyPanel;
	private JPanel rumbleLegendaryModifyPanel;
	private JPanel boomsdayLegendaryModifyPanel;
	private JPanel witchwoodLegendaryModifyPanel;
	private JPanel koboldsLegendaryModifyPanel;
	private JPanel knightsLegendaryModifyPanel;
	private JPanel ungoroLegendaryModifyPanel;
	private JPanel gadgetzanLegendaryModifyPanel;
	private JPanel oldGodsLegendaryModifyPanel;
	private JPanel tournamentLegendaryModifyPanel;
	private JPanel goblinsLegendaryModifyPanel;
	private JPanel classicLegendaryModifyPanel;
	
	// Legendary counters modifiers
	// Reset buttons
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
	
	// Message displaying the probability of finding a legendary card
	private final String legendaryProbabilityText = "Probability of finding a legendary card in the next pack:   ";
	
	private JTextPane barrensLegendaryProbabilityText;
	private JTextPane darkmoonLegendaryProbabilityText;
	private JTextPane scholomanceLegendaryProbabilityText;
	private JTextPane outlandLegendaryProbabilityText;
	private JTextPane dragonsLegendaryProbabilityText;
	private JTextPane uldumLegendaryProbabilityText;
	private JTextPane shadowsLegendaryProbabilityText;
	private JTextPane rumbleLegendaryProbabilityText;
	private JTextPane boomsdayLegendaryProbabilityText;
	private JTextPane witchwoodLegendaryProbabilityText;
	private JTextPane koboldsLegendaryProbabilityText;
	private JTextPane knightsLegendaryProbabilityText;
	private JTextPane ungoroLegendaryProbabilityText;
	private JTextPane gadgetzanLegendaryProbabilityText;
	private JTextPane oldGodsLegendaryProbabilityText;
	private JTextPane tournamentLegendaryProbabilityText;
	private JTextPane goblinsLegendaryProbabilityText;
	private JTextPane classicLegendaryProbabilityText;
	
	// Legendary probabilities (Labels showing the probability of finding a legendary card from each expansion)
	private String barrensLegendaryProbability;
	private String darkmoonLegendaryProbability;
	private String scholomanceLegendaryProbability;
	private String outlandLegendaryProbability;
	private String dragonsLegendaryProbability;
	private String uldumLegendaryProbability;
	private String shadowsLegendaryProbability;
	private String rumbleLegendaryProbability;
	private String boomsdayLegendaryProbability;
	private String witchwoodLegendaryProbability;
	private String koboldsLegendaryProbability;
	private String knightsLegendaryProbability;
	private String ungoroLegendaryProbability;
	private String gadgetzanLegendaryProbability;
	private String oldGodsLegendaryProbability;
	private String tournamentLegendaryProbability;
	private String goblinsLegendaryProbability;
	private String classicLegendaryProbability;
	
	// Total packs counter panel title
	private final String totalPanelTitle = "Total Packs Counter";
	private JTextPane totalPanelTitleLabel;
	
	// Total packs counter panels
	private JPanel barrensTotalPanel;
	private JPanel darkmoonTotalPanel;
	private JPanel scholomanceTotalPanel;
	private JPanel outlandTotalPanel;
	private JPanel dragonsTotalPanel;
	private JPanel uldumTotalPanel;
	private JPanel shadowsTotalPanel;
	private JPanel rumbleTotalPanel;
	private JPanel boomsdayTotalPanel;
	private JPanel witchwoodTotalPanel;
	private JPanel koboldsTotalPanel;
	private JPanel knightsTotalPanel;
	private JPanel ungoroTotalPanel;
	private JPanel gadgetzanTotalPanel;
	private JPanel oldGodsTotalPanel;
	private JPanel tournamentTotalPanel;
	private JPanel goblinsTotalPanel;
	private JPanel classicTotalPanel;
	
	// Message displaying the total amount of packs opened from each expansion
	private final String totalCounterText = "Total amount of packs opened:   ";
	
	private JTextPane barrensTotalCounterText;
	private JTextPane darkmoonTotalCounterText;
	private JTextPane scholomanceTotalCounterText;
	private JTextPane outlandTotalCounterText;
	private JTextPane dragonsTotalCounterText;
	private JTextPane uldumTotalCounterText;
	private JTextPane shadowsTotalCounterText;
	private JTextPane rumbleTotalCounterText;
	private JTextPane boomsdayTotalCounterText;
	private JTextPane witchwoodTotalCounterText;
	private JTextPane koboldsTotalCounterText;
	private JTextPane knightsTotalCounterText;
	private JTextPane ungoroTotalCounterText;
	private JTextPane gadgetzanTotalCounterText;
	private JTextPane oldGodsTotalCounterText;
	private JTextPane tournamentTotalCounterText;
	private JTextPane goblinsTotalCounterText;
	private JTextPane classicTotalCounterText;
	
	// Total counters (Labels showing the total amount of packs opened from each expansion)
	private String barrensTotalCounter;
	private String darkmoonTotalCounter;
	private String scholomanceTotalCounter;
	private String outlandTotalCounter;
	private String dragonsTotalCounter;
	private String uldumTotalCounter;
	private String shadowsTotalCounter;
	private String rumbleTotalCounter;
	private String boomsdayTotalCounter;
	private String witchwoodTotalCounter;
	private String koboldsTotalCounter;
	private String knightsTotalCounter;
	private String ungoroTotalCounter;
	private String gadgetzanTotalCounter;
	private String oldGodsTotalCounter;
	private String tournamentTotalCounter;
	private String goblinsTotalCounter;
	private String classicTotalCounter;
	
	// Total counters modify buttons panels
	private JPanel barrensTotalModifyPanel;
	private JPanel darkmoonTotalModifyPanel;
	private JPanel scholomanceTotalModifyPanel;
	private JPanel outlandTotalModifyPanel;
	private JPanel dragonsTotalModifyPanel;
	private JPanel uldumTotalModifyPanel;
	private JPanel shadowsTotalModifyPanel;
	private JPanel rumbleTotalModifyPanel;
	private JPanel boomsdayTotalModifyPanel;
	private JPanel witchwoodTotalModifyPanel;
	private JPanel koboldsTotalModifyPanel;
	private JPanel knightsTotalModifyPanel;
	private JPanel ungoroTotalModifyPanel;
	private JPanel gadgetzanTotalModifyPanel;
	private JPanel oldGodsTotalModifyPanel;
	private JPanel tournamentTotalModifyPanel;
	private JPanel goblinsTotalModifyPanel;
	private JPanel classicTotalModifyPanel;
	
	// Total counters modifiers
	// Modify buttons
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
	
	// Messages displaying when hovering over a counter modify button
	private final String resetButtonToolTipText = "Reset the counter";
	private final String modifyButtonToolTipText = "Modify the counter";
	private final String addButtonToolTipText = "Add packs to the counter";
	private final String incrementToolTipText = "Number of packs to be added";
	
	// Blank label to add extra space between buttons
	private JLabel blank;
	
	// Rarity buttons panels
	private JPanel barrensRarityButtonsPanel;
	private JPanel darkmoonRarityButtonsPanel;
	private JPanel scholomanceRarityButtonsPanel;
	private JPanel outlandRarityButtonsPanel;
	private JPanel dragonsRarityButtonsPanel;
	private JPanel uldumRarityButtonsPanel;
	private JPanel shadowsRarityButtonsPanel;
	private JPanel rumbleRarityButtonsPanel;
	private JPanel boomsdayRarityButtonsPanel;
	private JPanel witchwoodRarityButtonsPanel;
	private JPanel koboldsRarityButtonsPanel;
	private JPanel knightsRarityButtonsPanel;
	private JPanel ungoroRarityButtonsPanel;
	private JPanel gadgetzanRarityButtonsPanel;
	private JPanel oldGodsRarityButtonsPanel;
	private JPanel tournamentRarityButtonsPanel;
	private JPanel goblinsRarityButtonsPanel;
	private JPanel classicRarityButtonsPanel;
	
	// Common buttons
	private JPanel barrensCommonButtonPanel;
	private JPanel darkmoonCommonButtonPanel;
	private JPanel scholomanceCommonButtonPanel;
	private JPanel outlandCommonButtonPanel;
	private JPanel dragonsCommonButtonPanel;
	private JPanel uldumCommonButtonPanel;
	private JPanel shadowsCommonButtonPanel;
	private JPanel rumbleCommonButtonPanel;
	private JPanel boomsdayCommonButtonPanel;
	private JPanel witchwoodCommonButtonPanel;
	private JPanel koboldsCommonButtonPanel;
	private JPanel knightsCommonButtonPanel;
	private JPanel ungoroCommonButtonPanel;
	private JPanel gadgetzanCommonButtonPanel;
	private JPanel oldGodsCommonButtonPanel;
	private JPanel tournamentCommonButtonPanel;
	private JPanel goblinsCommonButtonPanel;
	private JPanel classicCommonButtonPanel;
	
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
	
	// Message displaying when hovering over a common button
	private final String commonButtonToolTipText = "See the expansion's common cards";
	
	// Rare buttons
	private JPanel barrensRareButtonPanel;
	private JPanel darkmoonRareButtonPanel;
	private JPanel scholomanceRareButtonPanel;
	private JPanel outlandRareButtonPanel;
	private JPanel dragonsRareButtonPanel;
	private JPanel uldumRareButtonPanel;
	private JPanel shadowsRareButtonPanel;
	private JPanel rumbleRareButtonPanel;
	private JPanel boomsdayRareButtonPanel;
	private JPanel witchwoodRareButtonPanel;
	private JPanel koboldsRareButtonPanel;
	private JPanel knightsRareButtonPanel;
	private JPanel ungoroRareButtonPanel;
	private JPanel gadgetzanRareButtonPanel;
	private JPanel oldGodsRareButtonPanel;
	private JPanel tournamentRareButtonPanel;
	private JPanel goblinsRareButtonPanel;
	private JPanel classicRareButtonPanel;
	
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
	
	// Message displaying when hovering over a rare button
	private final String rareButtonToolTipText = "See the expansion's rare cards";
	
	// Epic buttons
	private JPanel barrensEpicButtonPanel;
	private JPanel darkmoonEpicButtonPanel;
	private JPanel scholomanceEpicButtonPanel;
	private JPanel outlandEpicButtonPanel;
	private JPanel dragonsEpicButtonPanel;
	private JPanel uldumEpicButtonPanel;
	private JPanel shadowsEpicButtonPanel;
	private JPanel rumbleEpicButtonPanel;
	private JPanel boomsdayEpicButtonPanel;
	private JPanel witchwoodEpicButtonPanel;
	private JPanel koboldsEpicButtonPanel;
	private JPanel knightsEpicButtonPanel;
	private JPanel ungoroEpicButtonPanel;
	private JPanel gadgetzanEpicButtonPanel;
	private JPanel oldGodsEpicButtonPanel;
	private JPanel tournamentEpicButtonPanel;
	private JPanel goblinsEpicButtonPanel;
	private JPanel classicEpicButtonPanel;
	
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
	
	// Message displaying when hovering over an epic button
	private final String epicButtonToolTipText = "See the expansion's epic cards";
	
	// Legendary buttons
	private JPanel barrensLegendaryButtonPanel;
	private JPanel darkmoonLegendaryButtonPanel;
	private JPanel scholomanceLegendaryButtonPanel;
	private JPanel outlandLegendaryButtonPanel;
	private JPanel dragonsLegendaryButtonPanel;
	private JPanel uldumLegendaryButtonPanel;
	private JPanel shadowsLegendaryButtonPanel;
	private JPanel rumbleLegendaryButtonPanel;
	private JPanel boomsdayLegendaryButtonPanel;
	private JPanel witchwoodLegendaryButtonPanel;
	private JPanel koboldsLegendaryButtonPanel;
	private JPanel knightsLegendaryButtonPanel;
	private JPanel ungoroLegendaryButtonPanel;
	private JPanel gadgetzanLegendaryButtonPanel;
	private JPanel oldGodsLegendaryButtonPanel;
	private JPanel tournamentLegendaryButtonPanel;
	private JPanel goblinsLegendaryButtonPanel;
	private JPanel classicLegendaryButtonPanel;
	
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
	
	// Message displaying when hovering over a legendary button
	private final String legendaryButtonToolTipText = "See the expansion's legendary cards";
	
	// Rarity buttons icons
	// Common
	private BufferedImage commonButtonIcon;
	private URL commonButtonIconURL;
	private final String commonButtonIconPath = "rarities_icons/common.png";
	
	private BufferedImage commonButtonHoverIcon;
	private URL commonButtonHoverIconURL;
	private final String commonButtonHoverIconPath = "rarities_icons/common_hover.png";
	
	private BufferedImage commonButtonDarkIcon;
	private URL commonButtonDarkIconURL;
	private final String commonButtonDarkIconPath = "rarities_icons/common_dark.png";
	
	private BufferedImage commonButtonDarkHoverIcon;
	private URL commonButtonDarkHoverIconURL;
	private final String commonButtonDarkHoverIconPath = "rarities_icons/common_dark_hover.png";
	
	// Rare
	private BufferedImage rareButtonIcon;
	private URL rareButtonIconURL;
	private final String rareButtonIconPath = "rarities_icons/rare.png";
	
	private BufferedImage rareButtonHoverIcon;
	private URL rareButtonHoverIconURL;
	private final String rareButtonHoverIconPath = "rarities_icons/rare_hover.png";
	
	private BufferedImage rareButtonDarkIcon;
	private URL rareButtonDarkIconURL;
	private final String rareButtonDarkIconPath = "rarities_icons/rare_dark.png";
	
	private BufferedImage rareButtonDarkHoverIcon;
	private URL rareButtonDarkHoverIconURL;
	private final String rareButtonDarkHoverIconPath = "rarities_icons/rare_dark_hover.png";
	
	// Epic
	private BufferedImage epicButtonIcon;
	private URL epicButtonIconURL;
	private final String epicButtonIconPath = "rarities_icons/epic.png";
	
	private BufferedImage epicButtonHoverIcon;
	private URL epicButtonHoverIconURL;
	private final String epicButtonHoverIconPath = "rarities_icons/epic_hover.png";
	
	private BufferedImage epicButtonDarkIcon;
	private URL epicButtonDarkIconURL;
	private final String epicButtonDarkIconPath = "rarities_icons/epic_dark.png";
	
	private BufferedImage epicButtonDarkHoverIcon;
	private URL epicButtonDarkHoverIconURL;
	private final String epicButtonDarkHoverIconPath = "rarities_icons/epic_dark_hover.png";
	
	// Legendary
	private BufferedImage legendaryButtonIcon;
	private URL legendaryButtonIconURL;
	private final String legendaryButtonIconPath = "rarities_icons/legendary.png";
	
	private BufferedImage legendaryButtonHoverIcon;
	private URL legendaryButtonHoverIconURL;
	private final String legendaryButtonHoverIconPath = "rarities_icons/legendary_hover.png";
	
	private BufferedImage legendaryButtonDarkIcon;
	private URL legendaryButtonDarkIconURL;
	private final String legendaryButtonDarkIconPath = "rarities_icons/legendary_dark.png";
	
	private BufferedImage legendaryButtonDarkHoverIcon;
	private URL legendaryButtonDarkHoverIconURL;
	private final String legendaryButtonDarkHoverIconPath = "rarities_icons/legendary_dark_hover.png";
	
	// Tracker colors
	private final Color titleFontColor;
	private final Color headerBGColor;
	private final Color setsColor;
	private final Color yearsColor;
	private final Color buttonsHoverColor;
	private final Color buttonsDarkHoverColor;
	
	private final Color barrensColor;
	private final Color darkmoonColor;
	private final Color scholomanceColor;
	private final Color outlandColor;
	private final Color dragonsColor;
	private final Color uldumColor;
	private final Color shadowsColor;
	private final Color rumbleColor;
	private final Color boomsdayColor;
	private final Color witchwoodColor;
	private final Color koboldsColor;
	private final Color knightsColor;
	private final Color ungoroColor;
	private final Color gadgetzanColor;
	private final Color oldGodsColor;
	private final Color tournamentColor;
	private final Color goblinsColor;
	private final Color classicColor;
	
	// Tracker fonts
	private final Font titleFont;
	private final Font modesFont;
	private final Font yearsFont;
	private final Font incrementFieldFont;
	private final Font buttonsTextFont;
	private final Font addButtonTextFont;	
	private final Font tooltipTextFont;
	
	// Variables for changing text style
	private StyledDocument doc;
	private SimpleAttributeSet set;
	
	// Constructor
	public TrackerGUI() 
	{
		// Colors
		headerBGColor = new Color(50, 50, 50);
		titleFontColor = new Color(255, 255, 255);
		setsColor = new Color(240, 200, 95);
		yearsColor = new Color(245, 220, 160);
		buttonsHoverColor = new Color(75, 75, 75);
		buttonsDarkHoverColor = new Color(225, 225, 225);
		
		classicColor = new Color(115, 165, 235);
		barrensColor = new Color(170, 20, 15);
		darkmoonColor = new Color(180, 200, 20);
		scholomanceColor = new Color(175, 55, 165);
		outlandColor = new Color(0, 60, 30);
		dragonsColor = new Color(235, 155, 20);
		uldumColor = new Color(10, 210, 220);
		shadowsColor = new Color(155, 45, 220);
		rumbleColor = new Color(10, 220, 185);
		boomsdayColor = new Color(220, 75, 50);
		witchwoodColor = new Color(115, 185, 165);
		koboldsColor = new Color(165, 115, 80);
		knightsColor = new Color(150, 190, 210);
		ungoroColor = new Color(240, 180, 0);
		gadgetzanColor = new Color(210, 165, 25);
		oldGodsColor = new Color(200, 130, 200);
		tournamentColor = new Color(95, 70, 50);
		goblinsColor = new Color(220, 95, 10);
		
		// Fonts
		titleFont = new Font("Comic Sans MS", Font.BOLD, 42);
		modesFont = new Font("Comic Sans MS", Font.BOLD, 32);
		yearsFont = new Font("Comic Sans MS", Font.BOLD, 28);
		incrementFieldFont = new Font("Comic Sans MS", Font.PLAIN, 24);
		buttonsTextFont = new Font("Comic Sans MS", Font.BOLD, 22);
		addButtonTextFont = new Font("Arial Black", Font.BOLD, 32);
		tooltipTextFont = new Font("Comic Sans MS", Font.PLAIN, 14);
		
		// Buttons tooltip style
		UIManager.put("ToolTip.background", titleFontColor);
		UIManager.put("ToolTip.font", tooltipTextFont);
		
		createImages();
		
		createWindowComponents();
	}
	
	// r images creator
	private void createImages() 
	{
		// "Help" icon
		helpIcon = imageURLReader(helpIconURL, helpIconPath);
		
		// Header image
		headerImage = imageURLReader(headerImageURL, headerImagePath);
		helpHoverIcon = imageURLReader(helpHoverIconURL, helpHoverIconPath);
		
		// "Show save file" icon
		showSaveFileFolderIcon = imageURLReader(showSaveFileFolderIconURL, showSaveFileFolderIconPath);
		showSaveFileFolderHoverIcon = imageURLReader(showSaveFileFolderHoverIconURL, showSaveFileFolderHoverIconPath);
		
		// Game modes icons
		standardImage = imageURLReader(standardImageURL, standardImagePath);
		wildImage = imageURLReader(wildImageURL, wildImagePath);
		
		// "Show wild" toggle button
		showWildUnselectedIcon = imageURLReader(showWildUnselectedIconURL, showWildUnselectedIconPath);
		showWildSelectedIcon = imageURLReader(showWildSelectedIconURL,showWildSelectedIconPath);
		showWildUnselectedHoverIcon = imageURLReader(showWildUnselectedHoverIconURL, showWildUnselectedHoverIconPath);
		showWildSelectedHoverIcon = imageURLReader(showWildSelectedHoverIconURL, showWildSelectedHoverIconPath);
		
		// Years images
		gryphonImage = imageURLReader(gryphonImageURL, gryphonImagePath);
		phoenixImage = imageURLReader(phoenixImageURL, phoenixImagePath);
		dragonImage = imageURLReader(dragonImageURL, dragonImagePath);
		ravenImage = imageURLReader(ravenImageURL, ravenImagePath);
		mammothImage = imageURLReader(mammothImageURL, mammothImagePath);
		krakenImage = imageURLReader(krakenImageURL, krakenImagePath);
		classicSetsImage = imageURLReader(classicSetsImageURL, classicSetsImagePath);
		
		// Expansions images
		classicImage = imageURLReader(classicImageURL, classicImagePath);
		barrensImage = imageURLReader(barrensImageURL, barrensImagePath);
		darkmoonImage = imageURLReader(darkmoonImageURL, darkmoonImagePath);
		scholomanceImage = imageURLReader(scholomanceImageURL, scholomanceImagePath);
		outlandImage = imageURLReader(outlandImageURL, outlandImagePath);
		dragonsImage = imageURLReader(dragonsImageURL, dragonsImagePath);
		uldumImage = imageURLReader(uldumImageURL, uldumImagePath);
		shadowsImage = imageURLReader(shadowsImageURL, shadowsImagePath);
		rumbleImage = imageURLReader(rumbleImageURL, rumbleImagePath);
		boomsdayImage = imageURLReader(boomsdayImageURL, boomsdayImagePath);
		witchwoodImage = imageURLReader(witchwoodImageURL, witchwoodImagePath);
		koboldsImage = imageURLReader(koboldsImageURL, koboldsImagePath);
		knightsImage = imageURLReader(knightsImageURL, knightsImagePath);
		ungoroImage = imageURLReader(ungoroImageURL, ungoroImagePath);
		gadgetzanImage = imageURLReader(gadgetzanImageURL, gadgetzanImagePath);
		oldGodsImage = imageURLReader(oldGodsImageURL, oldGodsImagePath);
		tournamentImage = imageURLReader(tournamentImageURL, tournamentImagePath);
		goblinsImage = imageURLReader(goblinsImageURL, goblinsImagePath);
		
		// Rarity buttons icons
		// Common
		commonButtonIcon = imageURLReader(commonButtonIconURL, commonButtonIconPath);
		commonButtonHoverIcon = imageURLReader(commonButtonHoverIconURL, commonButtonHoverIconPath);
		commonButtonDarkIcon = imageURLReader(commonButtonDarkIconURL, commonButtonDarkIconPath);
		commonButtonDarkHoverIcon = imageURLReader(commonButtonDarkHoverIconURL, commonButtonDarkHoverIconPath);
		
		// Rare
		rareButtonIcon = imageURLReader(rareButtonIconURL, rareButtonIconPath);
		rareButtonHoverIcon = imageURLReader(rareButtonHoverIconURL, rareButtonHoverIconPath);
		rareButtonDarkIcon = imageURLReader(rareButtonDarkIconURL, rareButtonDarkIconPath);
		rareButtonDarkHoverIcon = imageURLReader(rareButtonDarkHoverIconURL, rareButtonDarkHoverIconPath);
		
		// Epic
		epicButtonIcon = imageURLReader(epicButtonIconURL, epicButtonIconPath);
		epicButtonHoverIcon = imageURLReader(epicButtonHoverIconURL, epicButtonHoverIconPath);
		epicButtonDarkIcon = imageURLReader(epicButtonDarkIconURL, epicButtonDarkIconPath);
		epicButtonDarkHoverIcon = imageURLReader(epicButtonDarkHoverIconURL, epicButtonDarkHoverIconPath);
		
		// Legendary
		legendaryButtonIcon = imageURLReader(legendaryButtonIconURL, legendaryButtonIconPath);
		legendaryButtonHoverIcon = imageURLReader(legendaryButtonHoverIconURL, legendaryButtonHoverIconPath);
		legendaryButtonDarkIcon = imageURLReader(legendaryButtonDarkIconURL, legendaryButtonDarkIconPath);
		legendaryButtonDarkHoverIcon = imageURLReader(legendaryButtonDarkHoverIconURL, legendaryButtonDarkHoverIconPath);
	}
	
	// Creates an image using the URL to the image path
	private BufferedImage imageURLReader(URL imageURL, String imagePath) 
	{
		BufferedImage image = null;
		
		imageURL = getClass().getClassLoader().getResource(imagePath);
		try {
			image = ImageIO.read(imageURL);
		} catch (IOException e) {
		    e.printStackTrace();
		}
		
		return image;
	}
	
	// Tracker window components creator
	private void createWindowComponents() 
	{
		// Tracker panel
		trackerPanel = new ScrollablePanel();
		trackerPanel.setScrollableWidth(ScrollablePanel.ScrollableSizeHint.FIT);
		trackerPanel.setLayout(new BoxLayout(trackerPanel, BoxLayout.Y_AXIS));
		
		// Tracker header
		createHeader();
		
		// Game Modes sets panels
		createStandardPanel();
		createWildPanel();
		
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				trackerPanel.add(trackerHeader);
				trackerPanel.add(standard);
				trackerPanel.add(wild);
			}
		});
	}
	
	// Tracker header creator
	private void createHeader() 
	{
		// Tracker header
		trackerHeader = new JPanel(new BorderLayout());
		trackerHeader.setBackground(headerBGColor);
		
		// "Help" button panel
		helpButtonPanel = new JPanel();
		helpButtonPanel.setBackground(headerBGColor);
		helpButtonPanel.setBorder(new EmptyBorder(15, 20, 0, 0));
		
		// "Help" button
		help = new JButton("");
		help.setIcon(new ImageIcon(helpIcon));
		help.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 0));
		help.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		help.setToolTipText(helpToolTipText);
		help.setFocusPainted(false);
		help.setContentAreaFilled(false);
		help.addMouseListener(new java.awt.event.MouseAdapter() {
			@Override
		    public void mouseEntered(java.awt.event.MouseEvent evt) {
				help.setIcon(new ImageIcon(helpHoverIcon));
		    }
			
		    @Override
		    public void mouseExited(java.awt.event.MouseEvent evt) {
		    	help.setIcon(new ImageIcon(helpIcon));
		    }
		});
		
		helpButtonPanel.add(help);
		
		// Title panel
		headerTitlePanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
		headerTitlePanel.setBackground(headerBGColor);
		
		// Title image
		headerImageLabel = new JLabel(new ImageIcon(headerImage));
		headerImageLabel.setBorder(new EmptyBorder(5, 5, 5, 5));
		
		// Title
		headerTitle = new JLabel(headerTitleText);
		headerTitle.setFont(titleFont);
		headerTitle.setForeground(titleFontColor);
		headerTitle.setBorder(new EmptyBorder(5, 5, 5, 5));
		
		// Title image #2
		headerImageTwoLabel = new JLabel(new ImageIcon(headerImage));
		headerImageTwoLabel.setBorder(new EmptyBorder(5, 5, 5, 5));
		
		headerTitlePanel.add(headerImageLabel);
		headerTitlePanel.add(headerTitle);
		headerTitlePanel.add(headerImageTwoLabel);
		
		// "Show save file" button panel
		showSaveButtonPanel = new JPanel();
		showSaveButtonPanel.setBackground(headerBGColor);
		showSaveButtonPanel.setBorder(new EmptyBorder(15, 0, 0, 20));
		
		// "Show save file" button
		showSaveFileFolder = new JButton("");
		showSaveFileFolder.setIcon(new ImageIcon(showSaveFileFolderIcon));
		showSaveFileFolder.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 0));
		showSaveFileFolder.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		showSaveFileFolder.setToolTipText(showSaveFileFolderToolTipText);
		showSaveFileFolder.setFocusPainted(false);
		showSaveFileFolder.setContentAreaFilled(false);
		showSaveFileFolder.addMouseListener(new java.awt.event.MouseAdapter() {
			@Override
		    public void mouseEntered(java.awt.event.MouseEvent evt) {
				showSaveFileFolder.setIcon(new ImageIcon(showSaveFileFolderHoverIcon));
		    }
			
		    @Override
		    public void mouseExited(java.awt.event.MouseEvent evt) {
		    	showSaveFileFolder.setIcon(new ImageIcon(showSaveFileFolderIcon));
		    }
		});
		
		showSaveButtonPanel.add(showSaveFileFolder);
		
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				trackerHeader.add(helpButtonPanel, BorderLayout.WEST);
				trackerHeader.add(headerTitlePanel, BorderLayout.CENTER);
				trackerHeader.add(showSaveButtonPanel, BorderLayout.EAST);
			}
		});
	}
	
	// "Standard" sets panel creator
	private void createStandardPanel() 
	{
		// "Standard" sets panel
		standard = new JPanel();
		standard.setLayout(new BoxLayout(standard, BoxLayout.Y_AXIS));
		
		// "Standard" sets title header
		standardHeader = new JPanel(new FlowLayout(FlowLayout.LEFT));
		standardHeader.setBackground(setsColor);
		
		standardImageLabel = new JLabel(new ImageIcon(standardImage));
		standardImageLabel.setBorder(new EmptyBorder(5, 5, 5, 5));
		
		standardLabel = new JLabel(standardTitle);
		standardLabel.setFont(modesFont);
		standardLabel.setBorder(new EmptyBorder(5, 25, 5, 5));
		
		standardHeader.add(standardImageLabel);
		standardHeader.add(standardLabel);
		
		// "Standard" sets panels
		createYearOfTheGryphonPanel();
		createYearOfThePhoenixPanel();
		
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				standard.add(standardHeader);
				standard.add(gryphon);
				standard.add(phoenix);
			}
		});
	}
	
	// "Wild" sets panel creator
	private void createWildPanel() 
	{
		// "Wild" sets panel
		wild = new JPanel();
		wild.setLayout(new BoxLayout(wild, BoxLayout.Y_AXIS));
		
		// "Wild" sets title header
		wildHeader = new JPanel(new FlowLayout(FlowLayout.LEFT));
		wildHeader.setBackground(setsColor);
		
		wildImageLabel = new JLabel(new ImageIcon(wildImage));
		wildImageLabel.setBorder(new EmptyBorder(5, 5, 5, 5));
		
		wildLabel = new JLabel(wildTitle);
		wildLabel.setFont(modesFont);
		wildLabel.setBorder(new EmptyBorder(5, 25, 5, 25));
		
		// "Show wild" toggle button
		showWild = new JCheckBox();
		showWild.setIcon(new ImageIcon(showWildUnselectedIcon));
		showWild.setSelectedIcon(new ImageIcon(showWildSelectedIcon));
		showWild.setBackground(setsColor);
		showWild.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 0));
		showWild.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		showWild.setToolTipText(showWildToolTipText);
		showWild.addMouseListener(new java.awt.event.MouseAdapter() {
			@Override
		    public void mouseEntered(java.awt.event.MouseEvent evt) {
				showWild.setIcon(new ImageIcon(showWildUnselectedHoverIcon));
				showWild.setSelectedIcon(new ImageIcon(showWildSelectedHoverIcon));
		    }
		    
		    @Override
		    public void mouseExited(java.awt.event.MouseEvent evt) {
		    	showWild.setIcon(new ImageIcon(showWildUnselectedIcon));
				showWild.setSelectedIcon(new ImageIcon(showWildSelectedIcon));
		    }
		});
		
		wildHeader.add(wildImageLabel);
		wildHeader.add(wildLabel);
		wildHeader.add(showWild);
		
		// "Wild" sets panels
		createYearOfTheDragonPanel();
		createYearOfTheRavenPanel();
		createYearOfTheMammothPanel();
		createYearOfTheKrakenPanel();
		createClassicSetsPanel();
		createClassicPanel();
		
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				wild.add(wildHeader);
				wild.add(dragon);
				wild.add(raven);
				wild.add(mammoth);
				wild.add(kraken);
				wild.add(classicSets);
				wild.add(classic);
			}
		});
	}
	
	// "Year of the Gryphon" panel creator
	private void createYearOfTheGryphonPanel() 
	{
		// "Year of the Gryphon" panel
		gryphon = new JPanel();
		gryphon.setLayout(new BoxLayout(gryphon, BoxLayout.Y_AXIS));
		
		// "Year of the Gryphon" title header
		gryphonHeader = new JPanel(new FlowLayout(FlowLayout.LEFT));
		gryphonHeader.setBackground(yearsColor);
		
		gryphonImageLabel = new JLabel(new ImageIcon(gryphonImage));
		gryphonImageLabel.setBorder(new EmptyBorder(5, 5, 5, 5));
		
		gryphonLabel = new JLabel(gryphonTitle);
		gryphonLabel.setFont(yearsFont);
		gryphonLabel.setBorder(new EmptyBorder(5, 25, 5, 5));
		
		gryphonHeader.add(gryphonImageLabel);
		gryphonHeader.add(gryphonLabel);
		
		// "Year of the Gryphon" expansions
		createForgedInTheBarrensPanel();
		
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				gryphon.add(gryphonHeader);
				gryphon.add(barrens);
			}
		});
	}
	
	// "Forged in the Barrens" panel creator
	private void createForgedInTheBarrensPanel() 
	{
		// "Forged in the Barrens" panel
		barrens = new JPanel();
		barrens.setBackground(barrensColor);
		barrens.setLayout(new GridLayout(1, 4, 10, 0));
		barrens.setBorder(new EmptyBorder(10, 10, 10, 10));
		
		// "Forged in the Barrens" logo
		barrensImagePanel = new JPanel(new GridBagLayout());
		barrensImagePanel.setBackground(barrens.getBackground());
		
		barrensImageButton = new JButton(new ImageIcon(barrensImage));
		barrensImageButton.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 0));
		barrensImageButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		barrensImageButton.setToolTipText(imageButtonToolTipText);
		barrensImageButton.setContentAreaFilled(false);
		barrensImageButton.setFocusPainted(false);
		
		barrensImagePanel.add(barrensImageButton);
		
		// Packs without epic counter panel
		barrensEpicPanel = new JPanel();
		barrensEpicPanel.setBackground(barrens.getBackground());
		barrensEpicPanel.setLayout(new GridLayout(4, 1));
		
		// Packs without epic counter panel title
		epicPanelTitleLabel = new JTextPane();
		doc = epicPanelTitleLabel.getStyledDocument();
		changePanelTitleStyle(barrens, epicPanelTitleLabel, epicPanelTitle);
		epicPanelTitleLabel.setForeground(titleFontColor);
		
		// Packs without epic counter
		barrensEpicCounterText = new JTextPane();
		doc = barrensEpicCounterText.getStyledDocument();
		changePanelTextStyle(barrens, barrensEpicCounterText, epicCounterText, barrensEpicCounter);
		barrensEpicCounterText.setForeground(titleFontColor);
		
		// Packs without epic counter modify buttons panel
		barrensEpicModifyPanel = new JPanel();
		
		// Reset button
		barrensEpicReset = new ModifierButton("Reset", titleFontColor, buttonsDarkHoverColor);
		barrensEpicReset.setToolTipText(resetButtonToolTipText);
		barrensEpicReset.setBackground(titleFontColor);
		barrensEpicReset.setForeground(headerBGColor);
		
		// Blank space between reset and add buttons
		blank = new JLabel();
		blank.setBackground(barrens.getBackground());
		blank.setBorder(new EmptyBorder(0, 20, 0, 20));
		
		// Add button
		barrensEpicAdd = new RoundButton("+", titleFontColor, buttonsDarkHoverColor);
		barrensEpicAdd.setBackground(titleFontColor);
		barrensEpicAdd.setForeground(headerBGColor);
		
		// Increment field
		barrensEpicIncrement = new JTextArea(1, 1);
		barrensEpicIncrement.setDocument(new IncrementLimit(1));
		barrensEpicIncrement.setBackground(titleFontColor);
		barrensEpicIncrement.setForeground(headerBGColor);
		barrensEpicIncrement.setCaretColor(headerBGColor);
		barrensEpicIncrement.setBorder(new EmptyBorder(0, 9, 0, 6));
		
		createModifyButtonsPanel(barrens, barrensEpicModifyPanel, barrensEpicReset, barrensEpicAdd, barrensEpicIncrement);
		
		// Probability of finding an epic calculator
		barrensEpicProbabilityText = new JTextPane();
		doc = barrensEpicProbabilityText.getStyledDocument();
		changePanelTextStyle(barrens, barrensEpicProbabilityText, epicProbabilityText, barrensEpicProbability);
		barrensEpicProbabilityText.setForeground(titleFontColor);
		
		barrensEpicPanel.add(epicPanelTitleLabel);
		barrensEpicPanel.add(barrensEpicCounterText);
		barrensEpicPanel.add(barrensEpicModifyPanel);
		barrensEpicPanel.add(barrensEpicProbabilityText);
		
		// Packs without legendary counter panel
		barrensLegendaryPanel = new JPanel();
		barrensLegendaryPanel.setBackground(barrens.getBackground());
		barrensLegendaryPanel.setLayout(new GridLayout(4, 1));
		
		// Packs without legendary counter panel title
		legendaryPanelTitleLabel = new JTextPane();
		doc = legendaryPanelTitleLabel.getStyledDocument();
		changePanelTitleStyle(barrens, legendaryPanelTitleLabel, legendaryPanelTitle);
		legendaryPanelTitleLabel.setForeground(titleFontColor);
		
		// Packs without legendary counter
		barrensLegendaryCounterText = new JTextPane();
		doc = barrensLegendaryCounterText.getStyledDocument();
		changePanelTextStyle(barrens, barrensLegendaryCounterText, legendaryCounterText, barrensLegendaryCounter);
		barrensLegendaryCounterText.setForeground(titleFontColor);
		
		// Packs without legendary counter modify buttons panel
		barrensLegendaryModifyPanel = new JPanel();
		
		// Reset button
		barrensLegendaryReset = new ModifierButton("Reset", titleFontColor, buttonsDarkHoverColor);
		barrensLegendaryReset.setToolTipText(resetButtonToolTipText);
		barrensLegendaryReset.setBackground(titleFontColor);
		barrensLegendaryReset.setForeground(headerBGColor);
		
		// Blank space between reset and add buttons
		blank = new JLabel();
		blank.setBackground(barrens.getBackground());
		blank.setBorder(new EmptyBorder(0, 20, 0, 20));
		
		// Add button
		barrensLegendaryAdd = new RoundButton("+", titleFontColor, buttonsDarkHoverColor);
		barrensLegendaryAdd.setBackground(titleFontColor);
		barrensLegendaryAdd.setForeground(headerBGColor);
		
		// Increment field
		barrensLegendaryIncrement = new JTextArea(1, 2);
		barrensLegendaryIncrement.setDocument(new IncrementLimit(2));
		barrensLegendaryIncrement.setBackground(titleFontColor);
		barrensLegendaryIncrement.setForeground(headerBGColor);
		barrensLegendaryIncrement.setCaretColor(headerBGColor);
		barrensLegendaryIncrement.setBorder(new EmptyBorder(0, 9, 0, 3));
		
		createModifyButtonsPanel(barrens, barrensLegendaryModifyPanel, barrensLegendaryReset, barrensLegendaryAdd, barrensLegendaryIncrement);
		
		// Probability of finding a legendary calculator
		barrensLegendaryProbabilityText = new JTextPane();
		doc = barrensLegendaryProbabilityText.getStyledDocument();
		changePanelTextStyle(barrens, barrensLegendaryProbabilityText, legendaryProbabilityText, barrensLegendaryProbability);
		barrensLegendaryProbabilityText.setForeground(titleFontColor);
		
		barrensLegendaryPanel.add(legendaryPanelTitleLabel);
		barrensLegendaryPanel.add(barrensLegendaryCounterText);
		barrensLegendaryPanel.add(barrensLegendaryModifyPanel);
		barrensLegendaryPanel.add(barrensLegendaryProbabilityText);
		
		// Total amount of packs opened counter panel
		barrensTotalPanel = new JPanel();
		barrensTotalPanel.setBackground(barrens.getBackground());
		barrensTotalPanel.setLayout(new GridLayout(4, 1));
		
		// Total amount of packs opened counter panel title
		totalPanelTitleLabel = new JTextPane();
		doc = totalPanelTitleLabel.getStyledDocument();
		changePanelTitleStyle(barrens, totalPanelTitleLabel,totalPanelTitle);
		totalPanelTitleLabel.setForeground(titleFontColor);
		
		// Total amount of packs opened counter
		barrensTotalCounterText = new JTextPane();
		doc = barrensTotalCounterText.getStyledDocument();
		changePanelTextStyle(barrens, barrensTotalCounterText, totalCounterText, barrensTotalCounter);
		barrensTotalCounterText.setForeground(titleFontColor);
		
		// Total amount of packs opened modify buttons panel
		barrensTotalModifyPanel = new JPanel();
		
		// Modify button
		barrensTotalModify = new ModifierButton("Modify", titleFontColor, buttonsDarkHoverColor);
		barrensTotalModify.setToolTipText(modifyButtonToolTipText);
		barrensTotalModify.setBackground(titleFontColor);
		barrensTotalModify.setForeground(headerBGColor);
		
		// Blank space between modify and add buttons
		blank = new JLabel();
		blank.setBackground(barrens.getBackground());
		blank.setBorder(new EmptyBorder(0, 5, 0, 5));
		
		// Add button
		barrensTotalAdd = new RoundButton("+", titleFontColor, buttonsDarkHoverColor);
		barrensTotalAdd.setBackground(titleFontColor);
		barrensTotalAdd.setForeground(headerBGColor);
		
		// Increment field
		barrensTotalIncrement = new JTextArea(1, 3);
		barrensTotalIncrement.setDocument(new IncrementLimit(3));
		barrensTotalIncrement.setBackground(titleFontColor);
		barrensTotalIncrement.setForeground(headerBGColor);
		barrensTotalIncrement.setCaretColor(headerBGColor);
		barrensTotalIncrement.setBorder(new EmptyBorder(0, 9, 0, 0));
		
		createModifyButtonsPanel(barrens, barrensTotalModifyPanel, barrensTotalModify, barrensTotalAdd, barrensTotalIncrement);
		
		// Rarity buttons panel
		barrensRarityButtonsPanel = new JPanel();
		
		// Common button
		barrensCommonButtonPanel = new JPanel(new GridBagLayout());
		barrensCommonButton = new IconButton(new ImageIcon(commonButtonDarkIcon), new ImageIcon(commonButtonDarkHoverIcon));
		
		// Rare button
		barrensRareButtonPanel = new JPanel(new GridBagLayout());
		barrensRareButton = new IconButton(new ImageIcon(rareButtonDarkIcon), new ImageIcon(rareButtonDarkHoverIcon));
		
		// Epic button
		barrensEpicButtonPanel = new JPanel(new GridBagLayout());
		barrensEpicButton = new IconButton(new ImageIcon(epicButtonDarkIcon), new ImageIcon(epicButtonDarkHoverIcon));
		
		// Legendary button
		barrensLegendaryButtonPanel = new JPanel(new GridBagLayout());
		barrensLegendaryButton = new IconButton(new ImageIcon(legendaryButtonDarkIcon), new ImageIcon(legendaryButtonDarkHoverIcon));
		
		createRarityButtonsPanel(barrens, barrensRarityButtonsPanel, 
				barrensCommonButtonPanel, barrensCommonButton, barrensRareButtonPanel, barrensRareButton, 
				barrensEpicButtonPanel, barrensEpicButton, barrensLegendaryButtonPanel, barrensLegendaryButton);
		
		barrensTotalPanel.add(totalPanelTitleLabel);
		barrensTotalPanel.add(barrensTotalCounterText);
		barrensTotalPanel.add(barrensTotalModifyPanel);
		barrensTotalPanel.add(barrensRarityButtonsPanel);
		
		barrens.add(barrensImagePanel);
		barrens.add(barrensEpicPanel);
		barrens.add(barrensLegendaryPanel);
		barrens.add(barrensTotalPanel);
	}
	
	// "Year of the Phoenix" panel creator
	private void createYearOfThePhoenixPanel() 
	{
		// "Year of the Phoenix" panel
		phoenix = new JPanel();
		phoenix.setLayout(new BoxLayout(phoenix, BoxLayout.Y_AXIS));
		
		// "Year of the Phoenix" title header
		phoenixHeader = new JPanel(new FlowLayout(FlowLayout.LEFT));
		phoenixHeader.setBackground(yearsColor);
		
		phoenixImageLabel = new JLabel(new ImageIcon(phoenixImage));
		phoenixImageLabel.setBorder(new EmptyBorder(5, 5, 5, 5));
		
		phoenixLabel = new JLabel(phoenixTitle);
		phoenixLabel.setFont(yearsFont);
		phoenixLabel.setBorder(new EmptyBorder(5, 25, 5, 5));
		
		phoenixHeader.add(phoenixImageLabel);
		phoenixHeader.add(phoenixLabel);
		
		// "Year of the Phoenix" expansions
		createMadnessAtTheDarkmoonFairePanel();
		createScholomanceAcademyPanel();
		createAshesOfOutlandPanel();
		
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				phoenix.add(phoenixHeader);
				phoenix.add(darkmoon);
				phoenix.add(scholomance);
				phoenix.add(outland);
			}
		});
	}
	
	// "Madness at the Darkmoon Faire" panel creator
	private void createMadnessAtTheDarkmoonFairePanel() 
	{
		// "Madness at the Darkmoon Faire" panel
		darkmoon = new JPanel();
		darkmoon.setBackground(darkmoonColor);
		darkmoon.setLayout(new GridLayout(1, 4, 10, 0));
		darkmoon.setBorder(new EmptyBorder(10, 10, 10, 10));
		
		// "Madness at the Darkmoon Faire" logo
		darkmoonImagePanel = new JPanel(new GridBagLayout());
		darkmoonImagePanel.setBackground(darkmoon.getBackground());
		
		darkmoonImageButton = new JButton(new ImageIcon(darkmoonImage));
		darkmoonImageButton.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 0));
		darkmoonImageButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		darkmoonImageButton.setToolTipText(imageButtonToolTipText);
		darkmoonImageButton.setContentAreaFilled(false);
		darkmoonImageButton.setFocusPainted(false);
		
		darkmoonImagePanel.add(darkmoonImageButton);
		
		// Packs without epic counter panel
		darkmoonEpicPanel = new JPanel();
		darkmoonEpicPanel.setBackground(darkmoon.getBackground());
		darkmoonEpicPanel.setLayout(new GridLayout(4, 1));
		
		// Packs without epic counter panel title
		epicPanelTitleLabel = new JTextPane();
		doc = epicPanelTitleLabel.getStyledDocument();
		changePanelTitleStyle(darkmoon, epicPanelTitleLabel, epicPanelTitle);
		
		// Packs without epic counter
		darkmoonEpicCounterText = new JTextPane();
		doc = darkmoonEpicCounterText.getStyledDocument();
		changePanelTextStyle(darkmoon, darkmoonEpicCounterText, epicCounterText, darkmoonEpicCounter);
		
		// Packs without epic counter modify buttons panel
		darkmoonEpicModifyPanel = new JPanel();
		
		// Reset button
		darkmoonEpicReset = new ModifierButton("Reset", headerBGColor, buttonsHoverColor);
		darkmoonEpicReset.setToolTipText(resetButtonToolTipText);
		darkmoonEpicReset.setBackground(headerBGColor);
		darkmoonEpicReset.setForeground(titleFontColor);
		
		// Blank space between reset and add buttons
		blank = new JLabel();
		blank.setBackground(darkmoon.getBackground());
		blank.setBorder(new EmptyBorder(0, 20, 0, 20));
		
		// Add button
		darkmoonEpicAdd = new RoundButton("+", headerBGColor, buttonsHoverColor);
		darkmoonEpicAdd.setBackground(headerBGColor);
		darkmoonEpicAdd.setForeground(titleFontColor);
		
		// Increment field
		darkmoonEpicIncrement = new JTextArea(1, 1);
		darkmoonEpicIncrement.setDocument(new IncrementLimit(1));
		darkmoonEpicIncrement.setBackground(headerBGColor);
		darkmoonEpicIncrement.setForeground(titleFontColor);
		darkmoonEpicIncrement.setCaretColor(titleFontColor);
		darkmoonEpicIncrement.setBorder(new EmptyBorder(0, 9, 0, 6));
		
		createModifyButtonsPanel(darkmoon, darkmoonEpicModifyPanel, darkmoonEpicReset, darkmoonEpicAdd, darkmoonEpicIncrement);
		
		// Probability of finding an epic calculator
		darkmoonEpicProbabilityText = new JTextPane();
		doc = darkmoonEpicProbabilityText.getStyledDocument();
		changePanelTextStyle(darkmoon, darkmoonEpicProbabilityText, epicProbabilityText, darkmoonEpicProbability);
		
		darkmoonEpicPanel.add(epicPanelTitleLabel);
		darkmoonEpicPanel.add(darkmoonEpicCounterText);
		darkmoonEpicPanel.add(darkmoonEpicModifyPanel);
		darkmoonEpicPanel.add(darkmoonEpicProbabilityText);
		
		// Packs without legendary counter panel
		darkmoonLegendaryPanel = new JPanel();
		darkmoonLegendaryPanel.setBackground(darkmoon.getBackground());
		darkmoonLegendaryPanel.setLayout(new GridLayout(4, 1));
		
		// Packs without legendary counter panel title
		legendaryPanelTitleLabel = new JTextPane();
		doc = legendaryPanelTitleLabel.getStyledDocument();
		changePanelTitleStyle(darkmoon, legendaryPanelTitleLabel, legendaryPanelTitle);
		
		// Packs without legendary counter
		darkmoonLegendaryCounterText = new JTextPane();
		doc = darkmoonLegendaryCounterText.getStyledDocument();
		changePanelTextStyle(darkmoon, darkmoonLegendaryCounterText, legendaryCounterText, darkmoonLegendaryCounter);
		
		// Packs without legendary counter modify buttons panel
		darkmoonLegendaryModifyPanel = new JPanel();
		
		// Reset button
		darkmoonLegendaryReset = new ModifierButton("Reset", headerBGColor, buttonsHoverColor);
		darkmoonLegendaryReset.setToolTipText(resetButtonToolTipText);
		darkmoonLegendaryReset.setBackground(headerBGColor);
		darkmoonLegendaryReset.setForeground(titleFontColor);
		
		// Blank space between reset and add buttons
		blank = new JLabel();
		blank.setBackground(darkmoon.getBackground());
		blank.setBorder(new EmptyBorder(0, 20, 0, 20));
		
		// Add button
		darkmoonLegendaryAdd = new RoundButton("+", headerBGColor, buttonsHoverColor);
		darkmoonLegendaryAdd.setBackground(headerBGColor);
		darkmoonLegendaryAdd.setForeground(titleFontColor);
		
		// Increment field
		darkmoonLegendaryIncrement = new JTextArea(1, 2);
		darkmoonLegendaryIncrement.setDocument(new IncrementLimit(2));
		darkmoonLegendaryIncrement.setBackground(headerBGColor);
		darkmoonLegendaryIncrement.setForeground(titleFontColor);
		darkmoonLegendaryIncrement.setCaretColor(titleFontColor);
		darkmoonLegendaryIncrement.setBorder(new EmptyBorder(0, 9, 0, 3));
		
		createModifyButtonsPanel(darkmoon, darkmoonLegendaryModifyPanel, darkmoonLegendaryReset, darkmoonLegendaryAdd, darkmoonLegendaryIncrement);
		
		// Probability of finding a legendary calculator
		darkmoonLegendaryProbabilityText = new JTextPane();
		doc = darkmoonLegendaryProbabilityText.getStyledDocument();
		changePanelTextStyle(darkmoon, darkmoonLegendaryProbabilityText, legendaryProbabilityText, darkmoonLegendaryProbability);
		
		darkmoonLegendaryPanel.add(legendaryPanelTitleLabel);
		darkmoonLegendaryPanel.add(darkmoonLegendaryCounterText);
		darkmoonLegendaryPanel.add(darkmoonLegendaryModifyPanel);
		darkmoonLegendaryPanel.add(darkmoonLegendaryProbabilityText);
		
		// Total amount of packs opened counter panel
		darkmoonTotalPanel = new JPanel();
		darkmoonTotalPanel.setBackground(darkmoon.getBackground());
		darkmoonTotalPanel.setLayout(new GridLayout(4, 1));
		
		// Total amount of packs opened counter panel title
		totalPanelTitleLabel = new JTextPane();
		doc = totalPanelTitleLabel.getStyledDocument();
		changePanelTitleStyle(darkmoon, totalPanelTitleLabel,totalPanelTitle);
		
		// Total amount of packs opened counter
		darkmoonTotalCounterText = new JTextPane();
		doc = darkmoonTotalCounterText.getStyledDocument();
		changePanelTextStyle(darkmoon, darkmoonTotalCounterText, totalCounterText, darkmoonTotalCounter);
		
		// Total amount of packs opened modify buttons panel
		darkmoonTotalModifyPanel = new JPanel();
		
		// Modify button
		darkmoonTotalModify = new ModifierButton("Modify", headerBGColor, buttonsHoverColor);
		darkmoonTotalModify.setToolTipText(modifyButtonToolTipText);
		darkmoonTotalModify.setBackground(headerBGColor);
		darkmoonTotalModify.setForeground(titleFontColor);
		
		// Blank space between modify and add buttons
		blank = new JLabel();
		blank.setBackground(darkmoon.getBackground());
		blank.setBorder(new EmptyBorder(0, 5, 0, 5));
		
		// Add button
		darkmoonTotalAdd = new RoundButton("+", headerBGColor, buttonsHoverColor);
		darkmoonTotalAdd.setBackground(headerBGColor);
		darkmoonTotalAdd.setForeground(titleFontColor);
		
		// Increment field
		darkmoonTotalIncrement = new JTextArea(1, 3);
		darkmoonTotalIncrement.setDocument(new IncrementLimit(3));
		darkmoonTotalIncrement.setBackground(headerBGColor);
		darkmoonTotalIncrement.setForeground(titleFontColor);
		darkmoonTotalIncrement.setCaretColor(titleFontColor);
		darkmoonTotalIncrement.setBorder(new EmptyBorder(0, 9, 0, 0));
		
		createModifyButtonsPanel(darkmoon, darkmoonTotalModifyPanel, darkmoonTotalModify, darkmoonTotalAdd, darkmoonTotalIncrement);
		
		// Rarity buttons panel
		darkmoonRarityButtonsPanel = new JPanel();
		
		// Common button
		darkmoonCommonButtonPanel = new JPanel(new GridBagLayout());
		darkmoonCommonButton = new IconButton(new ImageIcon(commonButtonIcon), new ImageIcon(commonButtonHoverIcon));
		
		// Rare button
		darkmoonRareButtonPanel = new JPanel(new GridBagLayout());
		darkmoonRareButton = new IconButton(new ImageIcon(rareButtonIcon), new ImageIcon(rareButtonHoverIcon));
		
		// Epic button
		darkmoonEpicButtonPanel = new JPanel(new GridBagLayout());
		darkmoonEpicButton = new IconButton(new ImageIcon(epicButtonIcon), new ImageIcon(epicButtonHoverIcon));
		
		// Legendary button
		darkmoonLegendaryButtonPanel = new JPanel(new GridBagLayout());
		darkmoonLegendaryButton = new IconButton(new ImageIcon(legendaryButtonIcon), new ImageIcon(legendaryButtonHoverIcon));
		
		createRarityButtonsPanel(darkmoon, darkmoonRarityButtonsPanel, 
				darkmoonCommonButtonPanel, darkmoonCommonButton, darkmoonRareButtonPanel, darkmoonRareButton, 
				darkmoonEpicButtonPanel, darkmoonEpicButton, darkmoonLegendaryButtonPanel, darkmoonLegendaryButton);
		
		darkmoonTotalPanel.add(totalPanelTitleLabel);
		darkmoonTotalPanel.add(darkmoonTotalCounterText);
		darkmoonTotalPanel.add(darkmoonTotalModifyPanel);
		darkmoonTotalPanel.add(darkmoonRarityButtonsPanel);
		
		darkmoon.add(darkmoonImagePanel);
		darkmoon.add(darkmoonEpicPanel);
		darkmoon.add(darkmoonLegendaryPanel);
		darkmoon.add(darkmoonTotalPanel);
	}
	
	// "Scholomance Academy" panel creator
	private void createScholomanceAcademyPanel() 
	{
		// "Scholomance Academy" panel
		scholomance = new JPanel();
		scholomance.setBackground(scholomanceColor);
		scholomance.setLayout(new GridLayout(1, 4, 10, 0));
		scholomance.setBorder(new EmptyBorder(10, 10, 10, 10));
		
		// "Scholomance Academy" logo
		scholomanceImagePanel = new JPanel(new GridBagLayout());
		scholomanceImagePanel.setBackground(scholomance.getBackground());
		
		scholomanceImageButton = new JButton(new ImageIcon(scholomanceImage));
		scholomanceImageButton.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 0));
		scholomanceImageButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		scholomanceImageButton.setToolTipText(imageButtonToolTipText);
		scholomanceImageButton.setContentAreaFilled(false);
		scholomanceImageButton.setFocusPainted(false);
		
		scholomanceImagePanel.add(scholomanceImageButton);
		
		// Packs without epic counter panel
		scholomanceEpicPanel = new JPanel();
		scholomanceEpicPanel.setBackground(scholomance.getBackground());
		scholomanceEpicPanel.setLayout(new GridLayout(4, 1));
		
		// Packs without epic counter panel title
		epicPanelTitleLabel = new JTextPane();
		doc = epicPanelTitleLabel.getStyledDocument();
		changePanelTitleStyle(scholomance, epicPanelTitleLabel, epicPanelTitle);
		epicPanelTitleLabel.setForeground(titleFontColor);
		
		// Packs without epic counter
		scholomanceEpicCounterText = new JTextPane();
		doc = scholomanceEpicCounterText.getStyledDocument();
		changePanelTextStyle(scholomance, scholomanceEpicCounterText, epicCounterText, scholomanceEpicCounter);
		scholomanceEpicCounterText.setForeground(titleFontColor);
		
		// Packs without epic counter modify buttons panel
		scholomanceEpicModifyPanel = new JPanel();
		
		// Reset button
		scholomanceEpicReset = new ModifierButton("Reset", titleFontColor, buttonsDarkHoverColor);
		scholomanceEpicReset.setToolTipText(resetButtonToolTipText);
		scholomanceEpicReset.setBackground(titleFontColor);
		scholomanceEpicReset.setForeground(headerBGColor);
		
		// Blank space between reset and add buttons
		blank = new JLabel();
		blank.setBackground(scholomance.getBackground());
		blank.setBorder(new EmptyBorder(0, 20, 0, 20));
		
		// Add button
		scholomanceEpicAdd = new RoundButton("+", titleFontColor, buttonsDarkHoverColor);
		scholomanceEpicAdd.setBackground(titleFontColor);
		scholomanceEpicAdd.setForeground(headerBGColor);
		
		// Increment field
		scholomanceEpicIncrement = new JTextArea(1, 1);
		scholomanceEpicIncrement.setDocument(new IncrementLimit(1));
		scholomanceEpicIncrement.setBackground(titleFontColor);
		scholomanceEpicIncrement.setForeground(headerBGColor);
		scholomanceEpicIncrement.setCaretColor(headerBGColor);
		scholomanceEpicIncrement.setBorder(new EmptyBorder(0, 9, 0, 6));
		
		createModifyButtonsPanel(scholomance, scholomanceEpicModifyPanel, scholomanceEpicReset, scholomanceEpicAdd, scholomanceEpicIncrement);
		
		// Probability of finding an epic calculator
		scholomanceEpicProbabilityText = new JTextPane();
		doc = scholomanceEpicProbabilityText.getStyledDocument();
		changePanelTextStyle(scholomance, scholomanceEpicProbabilityText, epicProbabilityText, scholomanceEpicProbability);
		scholomanceEpicProbabilityText.setForeground(titleFontColor);
		
		scholomanceEpicPanel.add(epicPanelTitleLabel);
		scholomanceEpicPanel.add(scholomanceEpicCounterText);
		scholomanceEpicPanel.add(scholomanceEpicModifyPanel);
		scholomanceEpicPanel.add(scholomanceEpicProbabilityText);
		
		// Packs without legendary counter panel
		scholomanceLegendaryPanel = new JPanel();
		scholomanceLegendaryPanel.setBackground(scholomance.getBackground());
		scholomanceLegendaryPanel.setLayout(new GridLayout(4, 1));
		
		// Packs without legendary counter panel title
		legendaryPanelTitleLabel = new JTextPane();
		doc = legendaryPanelTitleLabel.getStyledDocument();
		changePanelTitleStyle(scholomance, legendaryPanelTitleLabel, legendaryPanelTitle);
		legendaryPanelTitleLabel.setForeground(titleFontColor);
		
		// Packs without legendary counter
		scholomanceLegendaryCounterText = new JTextPane();
		doc = scholomanceLegendaryCounterText.getStyledDocument();
		changePanelTextStyle(scholomance, scholomanceLegendaryCounterText, legendaryCounterText, scholomanceLegendaryCounter);
		scholomanceLegendaryCounterText.setForeground(titleFontColor);
		
		// Packs without legendary counter modify buttons panel
		scholomanceLegendaryModifyPanel = new JPanel();
		
		// Reset button
		scholomanceLegendaryReset = new ModifierButton("Reset", titleFontColor, buttonsDarkHoverColor);
		scholomanceLegendaryReset.setToolTipText(resetButtonToolTipText);
		scholomanceLegendaryReset.setBackground(titleFontColor);
		scholomanceLegendaryReset.setForeground(headerBGColor);
		
		// Blank space between reset and add buttons
		blank = new JLabel();
		blank.setBackground(scholomance.getBackground());
		blank.setBorder(new EmptyBorder(0, 20, 0, 20));
		
		// Add button
		scholomanceLegendaryAdd = new RoundButton("+", titleFontColor, buttonsDarkHoverColor);
		scholomanceLegendaryAdd.setBackground(titleFontColor);
		scholomanceLegendaryAdd.setForeground(headerBGColor);
		
		// Increment field
		scholomanceLegendaryIncrement = new JTextArea(1, 2);
		scholomanceLegendaryIncrement.setDocument(new IncrementLimit(2));
		scholomanceLegendaryIncrement.setBackground(titleFontColor);
		scholomanceLegendaryIncrement.setForeground(headerBGColor);
		scholomanceLegendaryIncrement.setCaretColor(headerBGColor);
		scholomanceLegendaryIncrement.setBorder(new EmptyBorder(0, 9, 0, 3));
		
		createModifyButtonsPanel(scholomance, scholomanceLegendaryModifyPanel, scholomanceLegendaryReset, scholomanceLegendaryAdd, scholomanceLegendaryIncrement);
		
		// Probability of finding a legendary calculator
		scholomanceLegendaryProbabilityText = new JTextPane();
		doc = scholomanceLegendaryProbabilityText.getStyledDocument();
		changePanelTextStyle(scholomance, scholomanceLegendaryProbabilityText, legendaryProbabilityText, scholomanceLegendaryProbability);
		scholomanceLegendaryProbabilityText.setForeground(titleFontColor);
		
		scholomanceLegendaryPanel.add(legendaryPanelTitleLabel);
		scholomanceLegendaryPanel.add(scholomanceLegendaryCounterText);
		scholomanceLegendaryPanel.add(scholomanceLegendaryModifyPanel);
		scholomanceLegendaryPanel.add(scholomanceLegendaryProbabilityText);
		
		// Total amount of packs opened counter panel
		scholomanceTotalPanel = new JPanel();
		scholomanceTotalPanel.setBackground(scholomance.getBackground());
		scholomanceTotalPanel.setLayout(new GridLayout(4, 1));
		
		// Total amount of packs opened counter panel title
		totalPanelTitleLabel = new JTextPane();
		doc = totalPanelTitleLabel.getStyledDocument();
		changePanelTitleStyle(scholomance, totalPanelTitleLabel,totalPanelTitle);
		totalPanelTitleLabel.setForeground(titleFontColor);
		
		// Total amount of packs opened counter
		scholomanceTotalCounterText = new JTextPane();
		doc = scholomanceTotalCounterText.getStyledDocument();
		changePanelTextStyle(scholomance, scholomanceTotalCounterText, totalCounterText, scholomanceTotalCounter);
		scholomanceTotalCounterText.setForeground(titleFontColor);
		
		// Total amount of packs opened modify buttons panel
		scholomanceTotalModifyPanel = new JPanel();
		
		// Modify button
		scholomanceTotalModify = new ModifierButton("Modify", titleFontColor, buttonsDarkHoverColor);
		scholomanceTotalModify.setToolTipText(modifyButtonToolTipText);
		scholomanceTotalModify.setBackground(titleFontColor);
		scholomanceTotalModify.setForeground(headerBGColor);
		
		// Blank space between modify and add buttons
		blank = new JLabel();
		blank.setBackground(scholomance.getBackground());
		blank.setBorder(new EmptyBorder(0, 5, 0, 5));
		
		// Add button
		scholomanceTotalAdd = new RoundButton("+", titleFontColor, buttonsDarkHoverColor);
		scholomanceTotalAdd.setBackground(titleFontColor);
		scholomanceTotalAdd.setForeground(headerBGColor);
		
		// Increment field
		scholomanceTotalIncrement = new JTextArea(1, 3);
		scholomanceTotalIncrement.setDocument(new IncrementLimit(3));
		scholomanceTotalIncrement.setBackground(titleFontColor);
		scholomanceTotalIncrement.setForeground(headerBGColor);
		scholomanceTotalIncrement.setCaretColor(headerBGColor);
		scholomanceTotalIncrement.setBorder(new EmptyBorder(0, 9, 0, 0));
		
		createModifyButtonsPanel(scholomance, scholomanceTotalModifyPanel, scholomanceTotalModify, scholomanceTotalAdd, scholomanceTotalIncrement);
		
		// Rarity buttons panel
		scholomanceRarityButtonsPanel = new JPanel();
		
		// Common button
		scholomanceCommonButtonPanel = new JPanel(new GridBagLayout());
		scholomanceCommonButton = new IconButton(new ImageIcon(commonButtonDarkIcon), new ImageIcon(commonButtonDarkHoverIcon));
		
		// Rare button
		scholomanceRareButtonPanel = new JPanel(new GridBagLayout());
		scholomanceRareButton = new IconButton(new ImageIcon(rareButtonDarkIcon), new ImageIcon(rareButtonDarkHoverIcon));
		
		// Epic button
		scholomanceEpicButtonPanel = new JPanel(new GridBagLayout());
		scholomanceEpicButton = new IconButton(new ImageIcon(epicButtonDarkIcon), new ImageIcon(epicButtonDarkHoverIcon));
		
		// Legendary button
		scholomanceLegendaryButtonPanel = new JPanel(new GridBagLayout());
		scholomanceLegendaryButton = new IconButton(new ImageIcon(legendaryButtonDarkIcon), new ImageIcon(legendaryButtonDarkHoverIcon));
		
		createRarityButtonsPanel(scholomance, scholomanceRarityButtonsPanel, 
				scholomanceCommonButtonPanel, scholomanceCommonButton, scholomanceRareButtonPanel, scholomanceRareButton, 
				scholomanceEpicButtonPanel, scholomanceEpicButton, scholomanceLegendaryButtonPanel, scholomanceLegendaryButton);
		
		scholomanceTotalPanel.add(totalPanelTitleLabel);
		scholomanceTotalPanel.add(scholomanceTotalCounterText);
		scholomanceTotalPanel.add(scholomanceTotalModifyPanel);
		scholomanceTotalPanel.add(scholomanceRarityButtonsPanel);
		
		scholomance.add(scholomanceImagePanel);
		scholomance.add(scholomanceEpicPanel);
		scholomance.add(scholomanceLegendaryPanel);
		scholomance.add(scholomanceTotalPanel);
	}
	
	// "Ashes of Outland" panel creator
	private void createAshesOfOutlandPanel() 
	{
		// "Ashes of Outland" panel
		outland = new JPanel();
		outland.setBackground(outlandColor);
		outland.setLayout(new GridLayout(1, 4, 10, 0));
		outland.setBorder(new EmptyBorder(10, 10, 10, 10));
		
		// "Ashes of Outland" logo
		outlandImagePanel = new JPanel(new GridBagLayout());
		outlandImagePanel.setBackground(outland.getBackground());
		
		outlandImageButton = new JButton(new ImageIcon(outlandImage));
		outlandImageButton.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 0));
		outlandImageButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		outlandImageButton.setToolTipText(imageButtonToolTipText);
		outlandImageButton.setContentAreaFilled(false);
		outlandImageButton.setFocusPainted(false);
		
		outlandImagePanel.add(outlandImageButton);
		
		// Packs without epic counter panel
		outlandEpicPanel = new JPanel();
		outlandEpicPanel.setBackground(outland.getBackground());
		outlandEpicPanel.setLayout(new GridLayout(4, 1));
		
		// Packs without epic counter panel title
		epicPanelTitleLabel = new JTextPane();
		doc = epicPanelTitleLabel.getStyledDocument();
		changePanelTitleStyle(outland, epicPanelTitleLabel, epicPanelTitle);
		epicPanelTitleLabel.setForeground(titleFontColor);
		
		// Packs without epic counter
		outlandEpicCounterText = new JTextPane();
		doc = outlandEpicCounterText.getStyledDocument();
		changePanelTextStyle(outland, outlandEpicCounterText, epicCounterText, outlandEpicCounter);
		outlandEpicCounterText.setForeground(titleFontColor);
		
		// Packs without epic counter modify buttons panel
		outlandEpicModifyPanel = new JPanel();
		
		// Reset button
		outlandEpicReset = new ModifierButton("Reset", titleFontColor, buttonsDarkHoverColor);
		outlandEpicReset.setToolTipText(resetButtonToolTipText);
		outlandEpicReset.setBackground(titleFontColor);
		outlandEpicReset.setForeground(headerBGColor);
		
		// Blank space between reset and add buttons
		blank = new JLabel();
		blank.setBackground(outland.getBackground());
		blank.setBorder(new EmptyBorder(0, 20, 0, 20));
		
		// Add button
		outlandEpicAdd = new RoundButton("+", titleFontColor, buttonsDarkHoverColor);
		outlandEpicAdd.setBackground(titleFontColor);
		outlandEpicAdd.setForeground(headerBGColor);
		
		// Increment field
		outlandEpicIncrement = new JTextArea(1, 1);
		outlandEpicIncrement.setDocument(new IncrementLimit(1));
		outlandEpicIncrement.setBackground(titleFontColor);
		outlandEpicIncrement.setForeground(headerBGColor);
		outlandEpicIncrement.setCaretColor(headerBGColor);
		outlandEpicIncrement.setBorder(new EmptyBorder(0, 9, 0, 6));
		
		createModifyButtonsPanel(outland, outlandEpicModifyPanel, outlandEpicReset, outlandEpicAdd, outlandEpicIncrement);
		
		// Probability of finding an epic calculator
		outlandEpicProbabilityText = new JTextPane();
		doc = outlandEpicProbabilityText.getStyledDocument();
		changePanelTextStyle(outland, outlandEpicProbabilityText, epicProbabilityText, outlandEpicProbability);
		outlandEpicProbabilityText.setForeground(titleFontColor);
		
		outlandEpicPanel.add(epicPanelTitleLabel);
		outlandEpicPanel.add(outlandEpicCounterText);
		outlandEpicPanel.add(outlandEpicModifyPanel);
		outlandEpicPanel.add(outlandEpicProbabilityText);
		
		// Packs without legendary counter panel
		outlandLegendaryPanel = new JPanel();
		outlandLegendaryPanel.setBackground(outland.getBackground());
		outlandLegendaryPanel.setLayout(new GridLayout(4, 1));
		
		// Packs without legendary counter panel title
		legendaryPanelTitleLabel = new JTextPane();
		doc = legendaryPanelTitleLabel.getStyledDocument();
		changePanelTitleStyle(outland, legendaryPanelTitleLabel, legendaryPanelTitle);
		legendaryPanelTitleLabel.setForeground(titleFontColor);
		
		// Packs without legendary counter
		outlandLegendaryCounterText = new JTextPane();
		doc = outlandLegendaryCounterText.getStyledDocument();
		changePanelTextStyle(outland, outlandLegendaryCounterText, legendaryCounterText, outlandLegendaryCounter);
		outlandLegendaryCounterText.setForeground(titleFontColor);
		
		// Packs without legendary counter modify buttons panel
		outlandLegendaryModifyPanel = new JPanel();
		
		// Reset button
		outlandLegendaryReset = new ModifierButton("Reset", titleFontColor, buttonsDarkHoverColor);
		outlandLegendaryReset.setToolTipText(resetButtonToolTipText);
		outlandLegendaryReset.setBackground(titleFontColor);
		outlandLegendaryReset.setForeground(headerBGColor);
		
		// Blank space between reset and add buttons
		blank = new JLabel();
		blank.setBackground(outland.getBackground());
		blank.setBorder(new EmptyBorder(0, 20, 0, 20));
		
		// Add button
		outlandLegendaryAdd = new RoundButton("+", titleFontColor, buttonsDarkHoverColor);
		outlandLegendaryAdd.setBackground(titleFontColor);
		outlandLegendaryAdd.setForeground(headerBGColor);
		
		// Increment field
		outlandLegendaryIncrement = new JTextArea(1, 2);
		outlandLegendaryIncrement.setDocument(new IncrementLimit(2));
		outlandLegendaryIncrement.setBackground(titleFontColor);
		outlandLegendaryIncrement.setForeground(headerBGColor);
		outlandLegendaryIncrement.setCaretColor(headerBGColor);
		outlandLegendaryIncrement.setBorder(new EmptyBorder(0, 9, 0, 3));
		
		createModifyButtonsPanel(outland, outlandLegendaryModifyPanel, outlandLegendaryReset, outlandLegendaryAdd, outlandLegendaryIncrement);
		
		// Probability of finding a legendary calculator
		outlandLegendaryProbabilityText = new JTextPane();
		doc = outlandLegendaryProbabilityText.getStyledDocument();
		changePanelTextStyle(outland, outlandLegendaryProbabilityText, legendaryProbabilityText, outlandLegendaryProbability);
		outlandLegendaryProbabilityText.setForeground(titleFontColor);
		
		outlandLegendaryPanel.add(legendaryPanelTitleLabel);
		outlandLegendaryPanel.add(outlandLegendaryCounterText);
		outlandLegendaryPanel.add(outlandLegendaryModifyPanel);
		outlandLegendaryPanel.add(outlandLegendaryProbabilityText);
		
		// Total amount of packs opened counter panel
		outlandTotalPanel = new JPanel();
		outlandTotalPanel.setBackground(outland.getBackground());
		outlandTotalPanel.setLayout(new GridLayout(4, 1));
		
		// Total amount of packs opened counter panel title
		totalPanelTitleLabel = new JTextPane();
		doc = totalPanelTitleLabel.getStyledDocument();
		changePanelTitleStyle(outland, totalPanelTitleLabel,totalPanelTitle);
		totalPanelTitleLabel.setForeground(titleFontColor);
		
		// Total amount of packs opened counter
		outlandTotalCounterText = new JTextPane();
		doc = outlandTotalCounterText.getStyledDocument();
		changePanelTextStyle(outland, outlandTotalCounterText, totalCounterText, outlandTotalCounter);
		outlandTotalCounterText.setForeground(titleFontColor);
		
		// Total amount of packs opened modify buttons panel
		outlandTotalModifyPanel = new JPanel();
		
		// Modify button
		outlandTotalModify = new ModifierButton("Modify", titleFontColor, buttonsDarkHoverColor);
		outlandTotalModify.setToolTipText(modifyButtonToolTipText);
		outlandTotalModify.setBackground(titleFontColor);
		outlandTotalModify.setForeground(headerBGColor);
		
		// Blank space between modify and add buttons
		blank = new JLabel();
		blank.setBackground(outland.getBackground());
		blank.setBorder(new EmptyBorder(0, 5, 0, 5));
		
		// Add button
		outlandTotalAdd = new RoundButton("+", titleFontColor, buttonsDarkHoverColor);
		outlandTotalAdd.setBackground(titleFontColor);
		outlandTotalAdd.setForeground(headerBGColor);
		
		// Increment field
		outlandTotalIncrement = new JTextArea(1, 3);
		outlandTotalIncrement.setDocument(new IncrementLimit(3));
		outlandTotalIncrement.setBackground(titleFontColor);
		outlandTotalIncrement.setForeground(headerBGColor);
		outlandTotalIncrement.setCaretColor(headerBGColor);
		outlandTotalIncrement.setBorder(new EmptyBorder(0, 9, 0, 0));
		
		createModifyButtonsPanel(outland, outlandTotalModifyPanel, outlandTotalModify, outlandTotalAdd, outlandTotalIncrement);
		
		// Rarity buttons panel
		outlandRarityButtonsPanel = new JPanel();
		
		// Common button
		outlandCommonButtonPanel = new JPanel(new GridBagLayout());
		outlandCommonButton = new IconButton(new ImageIcon(commonButtonDarkIcon), new ImageIcon(commonButtonDarkHoverIcon));
		
		// Rare button
		outlandRareButtonPanel = new JPanel(new GridBagLayout());
		outlandRareButton = new IconButton(new ImageIcon(rareButtonDarkIcon), new ImageIcon(rareButtonDarkHoverIcon));
		
		// Epic button
		outlandEpicButtonPanel = new JPanel(new GridBagLayout());
		outlandEpicButton = new IconButton(new ImageIcon(epicButtonDarkIcon), new ImageIcon(epicButtonDarkHoverIcon));
		
		// Legendary button
		outlandLegendaryButtonPanel = new JPanel(new GridBagLayout());
		outlandLegendaryButton = new IconButton(new ImageIcon(legendaryButtonDarkIcon), new ImageIcon(legendaryButtonDarkHoverIcon));
		
		createRarityButtonsPanel(outland, outlandRarityButtonsPanel, 
				outlandCommonButtonPanel, outlandCommonButton, outlandRareButtonPanel, outlandRareButton, 
				outlandEpicButtonPanel, outlandEpicButton, outlandLegendaryButtonPanel, outlandLegendaryButton);
		
		outlandTotalPanel.add(totalPanelTitleLabel);
		outlandTotalPanel.add(outlandTotalCounterText);
		outlandTotalPanel.add(outlandTotalModifyPanel);
		outlandTotalPanel.add(outlandRarityButtonsPanel);
		
		outland.add(outlandImagePanel);
		outland.add(outlandEpicPanel);
		outland.add(outlandLegendaryPanel);
		outland.add(outlandTotalPanel);
	}
	
	// "Year of the Dragon" panel creator
	private void createYearOfTheDragonPanel() 
	{
		// "Year of the Dragon" panel
		dragon = new JPanel();
		dragon.setLayout(new BoxLayout(dragon, BoxLayout.Y_AXIS));
		
		// "Year of the Dragon" title header
		dragonHeader = new JPanel(new FlowLayout(FlowLayout.LEFT));
		dragonHeader.setBackground(yearsColor);
		
		dragonImageLabel = new JLabel(new ImageIcon(dragonImage));
		dragonImageLabel.setBorder(new EmptyBorder(5, 5, 5, 5));
		
		dragonLabel = new JLabel(dragonTitle);
		dragonLabel.setFont(yearsFont);
		dragonLabel.setBorder(new EmptyBorder(5, 25, 5, 5));
		
		dragonHeader.add(dragonImageLabel);
		dragonHeader.add(dragonLabel);
				
		// "Year of the Dragon" expansions
		createDescentOfDragonsPanel();
		createSaviorsOfUldumPanel();
		createRiseOfShadowsPanel();
		
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				dragon.add(dragonHeader);
				dragon.add(dragons);
				dragon.add(uldum);
				dragon.add(shadows);
				
				dragon.setVisible(false);
			}
		});
	}
	
	// "Descent of Dragons" panel creator
	private void createDescentOfDragonsPanel() 
	{
		// "Descent of Dragons" panel
		dragons = new JPanel();
		dragons.setBackground(dragonsColor);
		dragons.setLayout(new GridLayout(1, 4, 10, 0));
		dragons.setBorder(new EmptyBorder(10, 10, 10, 10));
		
		// "Descent of Dragons" logo
		dragonsImagePanel = new JPanel(new GridBagLayout());
		dragonsImagePanel.setBackground(dragons.getBackground());
		
		dragonsImageButton = new JButton(new ImageIcon(dragonsImage));
		dragonsImageButton.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 0));
		dragonsImageButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		dragonsImageButton.setToolTipText(imageButtonToolTipText);
		dragonsImageButton.setContentAreaFilled(false);
		dragonsImageButton.setFocusPainted(false);
		
		dragonsImagePanel.add(dragonsImageButton);
		
		// Packs without epic counter panel
		dragonsEpicPanel = new JPanel();
		dragonsEpicPanel.setBackground(dragons.getBackground());
		dragonsEpicPanel.setLayout(new GridLayout(4, 1));
		
		// Packs without epic counter panel title
		epicPanelTitleLabel = new JTextPane();
		doc = epicPanelTitleLabel.getStyledDocument();
		changePanelTitleStyle(dragons, epicPanelTitleLabel, epicPanelTitle);
		
		// Packs without epic counter
		dragonsEpicCounterText = new JTextPane();
		doc = dragonsEpicCounterText.getStyledDocument();
		changePanelTextStyle(dragons, dragonsEpicCounterText, epicCounterText, dragonsEpicCounter);
		
		// Packs without epic counter modify buttons panel
		dragonsEpicModifyPanel = new JPanel();
		
		// Reset button
		dragonsEpicReset = new ModifierButton("Reset", headerBGColor, buttonsHoverColor);
		dragonsEpicReset.setToolTipText(resetButtonToolTipText);
		dragonsEpicReset.setBackground(headerBGColor);
		dragonsEpicReset.setForeground(titleFontColor);
		
		// Blank space between reset and add buttons
		blank = new JLabel();
		blank.setBackground(dragons.getBackground());
		blank.setBorder(new EmptyBorder(0, 20, 0, 20));
		
		// Add button
		dragonsEpicAdd = new RoundButton("+", headerBGColor, buttonsHoverColor);
		dragonsEpicAdd.setBackground(headerBGColor);
		dragonsEpicAdd.setForeground(titleFontColor);
		
		// Increment field
		dragonsEpicIncrement = new JTextArea(1, 1);
		dragonsEpicIncrement.setDocument(new IncrementLimit(1));
		dragonsEpicIncrement.setBackground(headerBGColor);
		dragonsEpicIncrement.setForeground(titleFontColor);
		dragonsEpicIncrement.setCaretColor(titleFontColor);
		dragonsEpicIncrement.setBorder(new EmptyBorder(0, 9, 0, 6));
		
		createModifyButtonsPanel(dragons, dragonsEpicModifyPanel, dragonsEpicReset, dragonsEpicAdd, dragonsEpicIncrement);
		
		// Probability of finding an epic calculator
		dragonsEpicProbabilityText = new JTextPane();
		doc = dragonsEpicProbabilityText.getStyledDocument();
		changePanelTextStyle(dragons, dragonsEpicProbabilityText, epicProbabilityText, dragonsEpicProbability);
		
		dragonsEpicPanel.add(epicPanelTitleLabel);
		dragonsEpicPanel.add(dragonsEpicCounterText);
		dragonsEpicPanel.add(dragonsEpicModifyPanel);
		dragonsEpicPanel.add(dragonsEpicProbabilityText);
		
		// Packs without legendary counter panel
		dragonsLegendaryPanel = new JPanel();
		dragonsLegendaryPanel.setBackground(dragons.getBackground());
		dragonsLegendaryPanel.setLayout(new GridLayout(4, 1));
		
		// Packs without legendary counter panel title
		legendaryPanelTitleLabel = new JTextPane();
		doc = legendaryPanelTitleLabel.getStyledDocument();
		changePanelTitleStyle(dragons, legendaryPanelTitleLabel, legendaryPanelTitle);
		
		// Packs without legendary counter
		dragonsLegendaryCounterText = new JTextPane();
		doc = dragonsLegendaryCounterText.getStyledDocument();
		changePanelTextStyle(dragons, dragonsLegendaryCounterText, legendaryCounterText, dragonsLegendaryCounter);
		
		// Packs without legendary counter modify buttons panel
		dragonsLegendaryModifyPanel = new JPanel();
		
		// Reset button
		dragonsLegendaryReset = new ModifierButton("Reset", headerBGColor, buttonsHoverColor);
		dragonsLegendaryReset.setToolTipText(resetButtonToolTipText);
		dragonsLegendaryReset.setBackground(headerBGColor);
		dragonsLegendaryReset.setForeground(titleFontColor);
		
		// Blank space between reset and add buttons
		blank = new JLabel();
		blank.setBackground(dragons.getBackground());
		blank.setBorder(new EmptyBorder(0, 20, 0, 20));
		
		// Add button
		dragonsLegendaryAdd = new RoundButton("+", headerBGColor, buttonsHoverColor);
		dragonsLegendaryAdd.setBackground(headerBGColor);
		dragonsLegendaryAdd.setForeground(titleFontColor);
		
		// Increment field
		dragonsLegendaryIncrement = new JTextArea(1, 2);
		dragonsLegendaryIncrement.setDocument(new IncrementLimit(2));
		dragonsLegendaryIncrement.setBackground(headerBGColor);
		dragonsLegendaryIncrement.setForeground(titleFontColor);
		dragonsLegendaryIncrement.setCaretColor(titleFontColor);
		dragonsLegendaryIncrement.setBorder(new EmptyBorder(0, 9, 0, 3));
		
		createModifyButtonsPanel(dragons, dragonsLegendaryModifyPanel, dragonsLegendaryReset, dragonsLegendaryAdd, dragonsLegendaryIncrement);
		
		// Probability of finding a legendary calculator
		dragonsLegendaryProbabilityText = new JTextPane();
		doc = dragonsLegendaryProbabilityText.getStyledDocument();
		changePanelTextStyle(dragons, dragonsLegendaryProbabilityText, legendaryProbabilityText, dragonsLegendaryProbability);
		
		dragonsLegendaryPanel.add(legendaryPanelTitleLabel);
		dragonsLegendaryPanel.add(dragonsLegendaryCounterText);
		dragonsLegendaryPanel.add(dragonsLegendaryModifyPanel);
		dragonsLegendaryPanel.add(dragonsLegendaryProbabilityText);
		
		// Total amount of packs opened counter panel
		dragonsTotalPanel = new JPanel();
		dragonsTotalPanel.setBackground(dragons.getBackground());
		dragonsTotalPanel.setLayout(new GridLayout(4, 1));
		
		// Total amount of packs opened counter panel title
		totalPanelTitleLabel = new JTextPane();
		doc = totalPanelTitleLabel.getStyledDocument();
		changePanelTitleStyle(dragons, totalPanelTitleLabel,totalPanelTitle);
		
		// Total amount of packs opened counter
		dragonsTotalCounterText = new JTextPane();
		doc = dragonsTotalCounterText.getStyledDocument();
		changePanelTextStyle(dragons, dragonsTotalCounterText, totalCounterText, dragonsTotalCounter);
		
		// Total amount of packs opened modify buttons panel
		dragonsTotalModifyPanel = new JPanel();
		
		// Modify button
		dragonsTotalModify = new ModifierButton("Modify", headerBGColor, buttonsHoverColor);
		dragonsTotalModify.setToolTipText(modifyButtonToolTipText);
		dragonsTotalModify.setBackground(headerBGColor);
		dragonsTotalModify.setForeground(titleFontColor);
		
		// Blank space between modify and add buttons
		blank = new JLabel();
		blank.setBackground(dragons.getBackground());
		blank.setBorder(new EmptyBorder(0, 5, 0, 5));
		
		// Add button
		dragonsTotalAdd = new RoundButton("+", headerBGColor, buttonsHoverColor);
		dragonsTotalAdd.setBackground(headerBGColor);
		dragonsTotalAdd.setForeground(titleFontColor);
		
		// Increment field
		dragonsTotalIncrement = new JTextArea(1, 3);
		dragonsTotalIncrement.setDocument(new IncrementLimit(3));
		dragonsTotalIncrement.setBackground(headerBGColor);
		dragonsTotalIncrement.setForeground(titleFontColor);
		dragonsTotalIncrement.setCaretColor(titleFontColor);
		dragonsTotalIncrement.setBorder(new EmptyBorder(0, 9, 0, 0));
		
		createModifyButtonsPanel(dragons, dragonsTotalModifyPanel, dragonsTotalModify, dragonsTotalAdd, dragonsTotalIncrement);
		
		// Rarity buttons panel
		dragonsRarityButtonsPanel = new JPanel();
		
		// Common button
		dragonsCommonButtonPanel = new JPanel(new GridBagLayout());
		dragonsCommonButton = new IconButton(new ImageIcon(commonButtonIcon), new ImageIcon(commonButtonHoverIcon));
		
		// Rare button
		dragonsRareButtonPanel = new JPanel(new GridBagLayout());
		dragonsRareButton = new IconButton(new ImageIcon(rareButtonIcon), new ImageIcon(rareButtonHoverIcon));
		
		// Epic button
		dragonsEpicButtonPanel = new JPanel(new GridBagLayout());
		dragonsEpicButton = new IconButton(new ImageIcon(epicButtonIcon), new ImageIcon(epicButtonHoverIcon));
		
		// Legendary button
		dragonsLegendaryButtonPanel = new JPanel(new GridBagLayout());
		dragonsLegendaryButton = new IconButton(new ImageIcon(legendaryButtonIcon), new ImageIcon(legendaryButtonHoverIcon));
		
		createRarityButtonsPanel(dragons, dragonsRarityButtonsPanel, 
				dragonsCommonButtonPanel, dragonsCommonButton, dragonsRareButtonPanel, dragonsRareButton, 
				dragonsEpicButtonPanel, dragonsEpicButton, dragonsLegendaryButtonPanel, dragonsLegendaryButton);
		
		dragonsTotalPanel.add(totalPanelTitleLabel);
		dragonsTotalPanel.add(dragonsTotalCounterText);
		dragonsTotalPanel.add(dragonsTotalModifyPanel);
		dragonsTotalPanel.add(dragonsRarityButtonsPanel);
		
		dragons.add(dragonsImagePanel);
		dragons.add(dragonsEpicPanel);
		dragons.add(dragonsLegendaryPanel);
		dragons.add(dragonsTotalPanel);
	}
	
	// "Saviors of Uldum" panel creator
	private void createSaviorsOfUldumPanel() 
	{
		// "Saviors of Uldum" panel
		uldum = new JPanel();
		uldum.setBackground(uldumColor);
		uldum.setLayout(new GridLayout(1, 4, 10, 0));
		uldum.setBorder(new EmptyBorder(10, 10, 10, 10));
		
		// "Saviors of Uldum" logo
		uldumImagePanel = new JPanel(new GridBagLayout());
		uldumImagePanel.setBackground(uldum.getBackground());
		
		uldumImageButton = new JButton(new ImageIcon(uldumImage));
		uldumImageButton.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 0));
		uldumImageButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		uldumImageButton.setToolTipText(imageButtonToolTipText);
		uldumImageButton.setContentAreaFilled(false);
		uldumImageButton.setFocusPainted(false);
		
		uldumImagePanel.add(uldumImageButton);
				
		// Packs without epic counter panel
		uldumEpicPanel = new JPanel();
		uldumEpicPanel.setBackground(uldum.getBackground());
		uldumEpicPanel.setLayout(new GridLayout(4, 1));
		
		// Packs without epic counter panel title
		epicPanelTitleLabel = new JTextPane();
		doc = epicPanelTitleLabel.getStyledDocument();
		changePanelTitleStyle(uldum, epicPanelTitleLabel, epicPanelTitle);
				
		// Packs without epic counter
		uldumEpicCounterText = new JTextPane();
		doc = uldumEpicCounterText.getStyledDocument();
		changePanelTextStyle(uldum, uldumEpicCounterText, epicCounterText, uldumEpicCounter);
		
		// Packs without epic counter modify buttons panel
		uldumEpicModifyPanel = new JPanel();
		
		// Reset button
		uldumEpicReset = new ModifierButton("Reset", headerBGColor, buttonsHoverColor);
		uldumEpicReset.setToolTipText(resetButtonToolTipText);
		uldumEpicReset.setBackground(headerBGColor);
		uldumEpicReset.setForeground(titleFontColor);
		
		// Blank space between reset and add buttons
		blank = new JLabel();
		blank.setBackground(uldum.getBackground());
		blank.setBorder(new EmptyBorder(0, 20, 0, 20));
		
		// Add button
		uldumEpicAdd = new RoundButton("+", headerBGColor, buttonsHoverColor);
		uldumEpicAdd.setBackground(headerBGColor);
		uldumEpicAdd.setForeground(titleFontColor);
		
		// Increment field
		uldumEpicIncrement = new JTextArea(1, 1);
		uldumEpicIncrement.setDocument(new IncrementLimit(1));
		uldumEpicIncrement.setBackground(headerBGColor);
		uldumEpicIncrement.setForeground(titleFontColor);
		uldumEpicIncrement.setCaretColor(titleFontColor);
		uldumEpicIncrement.setBorder(new EmptyBorder(0, 9, 0, 6));
		
		createModifyButtonsPanel(uldum, uldumEpicModifyPanel, uldumEpicReset, uldumEpicAdd, uldumEpicIncrement);
		
		// Probability of finding an epic calculator
		uldumEpicProbabilityText = new JTextPane();
		doc = uldumEpicProbabilityText.getStyledDocument();
		changePanelTextStyle(uldum, uldumEpicProbabilityText, epicProbabilityText, uldumEpicProbability);
		
		uldumEpicPanel.add(epicPanelTitleLabel);
		uldumEpicPanel.add(uldumEpicCounterText);
		uldumEpicPanel.add(uldumEpicModifyPanel);
		uldumEpicPanel.add(uldumEpicProbabilityText);
		
		// Packs without legendary counter panel
		uldumLegendaryPanel = new JPanel();
		uldumLegendaryPanel.setBackground(uldum.getBackground());
		uldumLegendaryPanel.setLayout(new GridLayout(4, 1));
		
		// Packs without legendary counter panel title
		legendaryPanelTitleLabel = new JTextPane();
		doc = legendaryPanelTitleLabel.getStyledDocument();
		changePanelTitleStyle(uldum, legendaryPanelTitleLabel, legendaryPanelTitle);
		
		// Packs without legendary counter
		uldumLegendaryCounterText = new JTextPane();
		doc = uldumLegendaryCounterText.getStyledDocument();
		changePanelTextStyle(uldum, uldumLegendaryCounterText, legendaryCounterText, uldumLegendaryCounter);
		
		// Packs without legendary counter modify buttons panel
		uldumLegendaryModifyPanel = new JPanel();
		
		// Reset button
		uldumLegendaryReset = new ModifierButton("Reset", headerBGColor, buttonsHoverColor);
		uldumLegendaryReset.setToolTipText(resetButtonToolTipText);
		uldumLegendaryReset.setBackground(headerBGColor);
		uldumLegendaryReset.setForeground(titleFontColor);
		
		// Blank space between reset and add buttons
		blank = new JLabel();
		blank.setBackground(uldum.getBackground());
		blank.setBorder(new EmptyBorder(0, 20, 0, 20));
		
		// Add button
		uldumLegendaryAdd = new RoundButton("+", headerBGColor, buttonsHoverColor);
		uldumLegendaryAdd.setBackground(headerBGColor);
		uldumLegendaryAdd.setForeground(titleFontColor);
		
		// Increment field
		uldumLegendaryIncrement = new JTextArea(1, 2);
		uldumLegendaryIncrement.setDocument(new IncrementLimit(2));
		uldumLegendaryIncrement.setBackground(headerBGColor);
		uldumLegendaryIncrement.setForeground(titleFontColor);
		uldumLegendaryIncrement.setCaretColor(titleFontColor);
		uldumLegendaryIncrement.setBorder(new EmptyBorder(0, 9, 0, 3));
		
		createModifyButtonsPanel(uldum, uldumLegendaryModifyPanel, uldumLegendaryReset, uldumLegendaryAdd, uldumLegendaryIncrement);
		
		// Probability of finding a legendary calculator
		uldumLegendaryProbabilityText = new JTextPane();
		doc = uldumLegendaryProbabilityText.getStyledDocument();
		changePanelTextStyle(uldum, uldumLegendaryProbabilityText, legendaryProbabilityText, uldumLegendaryProbability);
		
		uldumLegendaryPanel.add(legendaryPanelTitleLabel);
		uldumLegendaryPanel.add(uldumLegendaryCounterText);
		uldumLegendaryPanel.add(uldumLegendaryModifyPanel);
		uldumLegendaryPanel.add(uldumLegendaryProbabilityText);
		
		// Total amount of packs opened counter panel
		uldumTotalPanel = new JPanel();
		uldumTotalPanel.setBackground(uldum.getBackground());
		uldumTotalPanel.setLayout(new GridLayout(4, 1));
		
		// Total amount of packs opened counter panel title
		totalPanelTitleLabel = new JTextPane();
		doc = totalPanelTitleLabel.getStyledDocument();
		changePanelTitleStyle(uldum, totalPanelTitleLabel,totalPanelTitle);
		
		// Total amount of packs opened counter
		uldumTotalCounterText = new JTextPane();
		doc = uldumTotalCounterText.getStyledDocument();
		changePanelTextStyle(uldum, uldumTotalCounterText, totalCounterText, uldumTotalCounter);
		
		// Total amount of packs opened modify buttons panel
		uldumTotalModifyPanel = new JPanel();
		
		// Modify button
		uldumTotalModify = new ModifierButton("Modify", headerBGColor, buttonsHoverColor);
		uldumTotalModify.setToolTipText(modifyButtonToolTipText);
		uldumTotalModify.setBackground(headerBGColor);
		uldumTotalModify.setForeground(titleFontColor);
		
		// Blank space between modify and add buttons
		blank = new JLabel();
		blank.setBackground(uldum.getBackground());
		blank.setBorder(new EmptyBorder(0, 5, 0, 5));
		
		// Add button
		uldumTotalAdd = new RoundButton("+", headerBGColor, buttonsHoverColor);
		uldumTotalAdd.setBackground(headerBGColor);
		uldumTotalAdd.setForeground(titleFontColor);
		
		// Increment field
		uldumTotalIncrement = new JTextArea(1, 3);
		uldumTotalIncrement.setDocument(new IncrementLimit(3));
		uldumTotalIncrement.setBackground(headerBGColor);
		uldumTotalIncrement.setForeground(titleFontColor);
		uldumTotalIncrement.setCaretColor(titleFontColor);
		uldumTotalIncrement.setBorder(new EmptyBorder(0, 9, 0, 0));
		
		createModifyButtonsPanel(uldum, uldumTotalModifyPanel, uldumTotalModify, uldumTotalAdd, uldumTotalIncrement);
		
		// Rarity buttons panel
		uldumRarityButtonsPanel = new JPanel();
		
		// Common button
		uldumCommonButtonPanel = new JPanel(new GridBagLayout());
		uldumCommonButton = new IconButton(new ImageIcon(commonButtonIcon), new ImageIcon(commonButtonHoverIcon));
		
		// Rare button
		uldumRareButtonPanel = new JPanel(new GridBagLayout());
		uldumRareButton = new IconButton(new ImageIcon(rareButtonIcon), new ImageIcon(rareButtonHoverIcon));
		
		// Epic button
		uldumEpicButtonPanel = new JPanel(new GridBagLayout());
		uldumEpicButton = new IconButton(new ImageIcon(epicButtonIcon), new ImageIcon(epicButtonHoverIcon));
		
		// Legendary button
		uldumLegendaryButtonPanel = new JPanel(new GridBagLayout());
		uldumLegendaryButton = new IconButton(new ImageIcon(legendaryButtonIcon), new ImageIcon(legendaryButtonHoverIcon));
		
		createRarityButtonsPanel(uldum, uldumRarityButtonsPanel, 
				uldumCommonButtonPanel, uldumCommonButton, uldumRareButtonPanel, uldumRareButton, 
				uldumEpicButtonPanel, uldumEpicButton, uldumLegendaryButtonPanel, uldumLegendaryButton);
		
		uldumTotalPanel.add(totalPanelTitleLabel);
		uldumTotalPanel.add(uldumTotalCounterText);
		uldumTotalPanel.add(uldumTotalModifyPanel);
		uldumTotalPanel.add(uldumRarityButtonsPanel);
		
		uldum.add(uldumImagePanel);
		uldum.add(uldumEpicPanel);
		uldum.add(uldumLegendaryPanel);
		uldum.add(uldumTotalPanel);
	}
	
	// "Rise of Shadows" panel creator
	private void createRiseOfShadowsPanel() 
	{
		// "Rise of Shadows" panel
		shadows = new JPanel();
		shadows.setBackground(shadowsColor);
		shadows.setLayout(new GridLayout(1, 4, 10, 0));
		shadows.setBorder(new EmptyBorder(10, 10, 10, 10));
		
		// "Rise of Shadows" logo
		shadowsImagePanel = new JPanel(new GridBagLayout());
		shadowsImagePanel.setBackground(shadows.getBackground());
		
		shadowsImageButton = new JButton(new ImageIcon(shadowsImage));
		shadowsImageButton.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 0));
		shadowsImageButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		shadowsImageButton.setToolTipText(imageButtonToolTipText);
		shadowsImageButton.setContentAreaFilled(false);
		shadowsImageButton.setFocusPainted(false);
		
		shadowsImagePanel.add(shadowsImageButton);
		
		// Packs without epic counter panel
		shadowsEpicPanel = new JPanel();
		shadowsEpicPanel.setBackground(shadows.getBackground());
		shadowsEpicPanel.setLayout(new GridLayout(4, 1));
		
		// Packs without epic counter panel title
		epicPanelTitleLabel = new JTextPane();
		doc = epicPanelTitleLabel.getStyledDocument();
		changePanelTitleStyle(shadows, epicPanelTitleLabel, epicPanelTitle);
		epicPanelTitleLabel.setForeground(titleFontColor);
		
		// Packs without epic counter
		shadowsEpicCounterText = new JTextPane();
		doc = shadowsEpicCounterText.getStyledDocument();
		changePanelTextStyle(shadows, shadowsEpicCounterText, epicCounterText, shadowsEpicCounter);
		shadowsEpicCounterText.setForeground(titleFontColor);
		
		// Packs without epic counter modify buttons panel
		shadowsEpicModifyPanel = new JPanel();
		
		// Reset button
		shadowsEpicReset = new ModifierButton("Reset", titleFontColor, buttonsDarkHoverColor);
		shadowsEpicReset.setToolTipText(resetButtonToolTipText);
		shadowsEpicReset.setBackground(titleFontColor);
		shadowsEpicReset.setForeground(headerBGColor);
		
		// Blank space between reset and add buttons
		blank = new JLabel();
		blank.setBackground(shadows.getBackground());
		blank.setBorder(new EmptyBorder(0, 20, 0, 20));
		
		// Add button
		shadowsEpicAdd = new RoundButton("+", titleFontColor, buttonsDarkHoverColor);
		shadowsEpicAdd.setBackground(titleFontColor);
		shadowsEpicAdd.setForeground(headerBGColor);
		
		// Increment field
		shadowsEpicIncrement = new JTextArea(1, 1);
		shadowsEpicIncrement.setDocument(new IncrementLimit(1));
		shadowsEpicIncrement.setBackground(titleFontColor);
		shadowsEpicIncrement.setForeground(headerBGColor);
		shadowsEpicIncrement.setCaretColor(headerBGColor);
		shadowsEpicIncrement.setBorder(new EmptyBorder(0, 9, 0, 6));
		
		createModifyButtonsPanel(shadows, shadowsEpicModifyPanel, shadowsEpicReset, shadowsEpicAdd, shadowsEpicIncrement);
		
		// Probability of finding an epic calculator
		shadowsEpicProbabilityText = new JTextPane();
		doc = shadowsEpicProbabilityText.getStyledDocument();
		changePanelTextStyle(shadows, shadowsEpicProbabilityText, epicProbabilityText, shadowsEpicProbability);
		shadowsEpicProbabilityText.setForeground(titleFontColor);
		
		shadowsEpicPanel.add(epicPanelTitleLabel);
		shadowsEpicPanel.add(shadowsEpicCounterText);
		shadowsEpicPanel.add(shadowsEpicModifyPanel);
		shadowsEpicPanel.add(shadowsEpicProbabilityText);
		
		// Packs without legendary counter panel
		shadowsLegendaryPanel = new JPanel();
		shadowsLegendaryPanel.setBackground(shadows.getBackground());
		shadowsLegendaryPanel.setLayout(new GridLayout(4, 1));
		
		// Packs without legendary counter panel title
		legendaryPanelTitleLabel = new JTextPane();
		doc = legendaryPanelTitleLabel.getStyledDocument();
		changePanelTitleStyle(shadows, legendaryPanelTitleLabel, legendaryPanelTitle);
		legendaryPanelTitleLabel.setForeground(titleFontColor);
		
		// Packs without legendary counter
		shadowsLegendaryCounterText = new JTextPane();
		doc = shadowsLegendaryCounterText.getStyledDocument();
		changePanelTextStyle(shadows, shadowsLegendaryCounterText, legendaryCounterText, shadowsLegendaryCounter);
		shadowsLegendaryCounterText.setForeground(titleFontColor);
		
		// Packs without legendary counter modify buttons panel
		shadowsLegendaryModifyPanel = new JPanel();
		
		// Reset button
		shadowsLegendaryReset = new ModifierButton("Reset", titleFontColor, buttonsDarkHoverColor);
		shadowsLegendaryReset.setToolTipText(resetButtonToolTipText);
		shadowsLegendaryReset.setBackground(titleFontColor);
		shadowsLegendaryReset.setForeground(headerBGColor);
		
		// Blank space between reset and add buttons
		blank = new JLabel();
		blank.setBackground(shadows.getBackground());
		blank.setBorder(new EmptyBorder(0, 20, 0, 20));
		
		// Add button
		shadowsLegendaryAdd = new RoundButton("+", titleFontColor, buttonsDarkHoverColor);
		shadowsLegendaryAdd.setBackground(titleFontColor);
		shadowsLegendaryAdd.setForeground(headerBGColor);
		
		// Increment field
		shadowsLegendaryIncrement = new JTextArea(1, 2);
		shadowsLegendaryIncrement.setDocument(new IncrementLimit(2));
		shadowsLegendaryIncrement.setBackground(titleFontColor);
		shadowsLegendaryIncrement.setForeground(headerBGColor);
		shadowsLegendaryIncrement.setCaretColor(headerBGColor);
		shadowsLegendaryIncrement.setBorder(new EmptyBorder(0, 9, 0, 3));
		
		createModifyButtonsPanel(shadows, shadowsLegendaryModifyPanel, shadowsLegendaryReset, shadowsLegendaryAdd, shadowsLegendaryIncrement);
		
		// Probability of finding a legendary calculator
		shadowsLegendaryProbabilityText = new JTextPane();
		doc = shadowsLegendaryProbabilityText.getStyledDocument();
		changePanelTextStyle(shadows, shadowsLegendaryProbabilityText, legendaryProbabilityText, shadowsLegendaryProbability);
		shadowsLegendaryProbabilityText.setForeground(titleFontColor);
		
		shadowsLegendaryPanel.add(legendaryPanelTitleLabel);
		shadowsLegendaryPanel.add(shadowsLegendaryCounterText);
		shadowsLegendaryPanel.add(shadowsLegendaryModifyPanel);
		shadowsLegendaryPanel.add(shadowsLegendaryProbabilityText);
		
		// Total amount of packs opened counter panel
		shadowsTotalPanel = new JPanel();
		shadowsTotalPanel.setBackground(shadows.getBackground());
		shadowsTotalPanel.setLayout(new GridLayout(4, 1));
		
		// Total amount of packs opened counter panel title
		totalPanelTitleLabel = new JTextPane();
		doc = totalPanelTitleLabel.getStyledDocument();
		changePanelTitleStyle(shadows, totalPanelTitleLabel,totalPanelTitle);
		totalPanelTitleLabel.setForeground(titleFontColor);
		
		// Total amount of packs opened counter
		shadowsTotalCounterText = new JTextPane();
		doc = shadowsTotalCounterText.getStyledDocument();
		changePanelTextStyle(shadows, shadowsTotalCounterText, totalCounterText, shadowsTotalCounter);
		shadowsTotalCounterText.setForeground(titleFontColor);
		
		// Total amount of packs opened modify buttons panel
		shadowsTotalModifyPanel = new JPanel();
		
		// Modify button
		shadowsTotalModify = new ModifierButton("Modify", titleFontColor, buttonsDarkHoverColor);
		shadowsTotalModify.setToolTipText(modifyButtonToolTipText);
		shadowsTotalModify.setBackground(titleFontColor);
		shadowsTotalModify.setForeground(headerBGColor);
		
		// Blank space between modify and add buttons
		blank = new JLabel();
		blank.setBackground(shadows.getBackground());
		blank.setBorder(new EmptyBorder(0, 5, 0, 5));
		
		// Add button
		shadowsTotalAdd = new RoundButton("+", titleFontColor, buttonsDarkHoverColor);
		shadowsTotalAdd.setBackground(titleFontColor);
		shadowsTotalAdd.setForeground(headerBGColor);
		
		// Increment field
		shadowsTotalIncrement = new JTextArea(1, 3);
		shadowsTotalIncrement.setDocument(new IncrementLimit(3));
		shadowsTotalIncrement.setBackground(titleFontColor);
		shadowsTotalIncrement.setForeground(headerBGColor);
		shadowsTotalIncrement.setCaretColor(headerBGColor);
		shadowsTotalIncrement.setBorder(new EmptyBorder(0, 9, 0, 0));
		
		createModifyButtonsPanel(shadows, shadowsTotalModifyPanel, shadowsTotalModify, shadowsTotalAdd, shadowsTotalIncrement);
		
		// Rarity buttons panel
		shadowsRarityButtonsPanel = new JPanel();
		
		// Common button
		shadowsCommonButtonPanel = new JPanel(new GridBagLayout());
		shadowsCommonButton = new IconButton(new ImageIcon(commonButtonDarkIcon), new ImageIcon(commonButtonDarkHoverIcon));
		
		// Rare button
		shadowsRareButtonPanel = new JPanel(new GridBagLayout());
		shadowsRareButton = new IconButton(new ImageIcon(rareButtonDarkIcon), new ImageIcon(rareButtonDarkHoverIcon));
		
		// Epic button
		shadowsEpicButtonPanel = new JPanel(new GridBagLayout());
		shadowsEpicButton = new IconButton(new ImageIcon(epicButtonDarkIcon), new ImageIcon(epicButtonDarkHoverIcon));
		
		// Legendary button
		shadowsLegendaryButtonPanel = new JPanel(new GridBagLayout());
		shadowsLegendaryButton = new IconButton(new ImageIcon(legendaryButtonDarkIcon), new ImageIcon(legendaryButtonDarkHoverIcon));
		
		createRarityButtonsPanel(shadows, shadowsRarityButtonsPanel, 
				shadowsCommonButtonPanel, shadowsCommonButton, shadowsRareButtonPanel, shadowsRareButton, 
				shadowsEpicButtonPanel, shadowsEpicButton, shadowsLegendaryButtonPanel, shadowsLegendaryButton);
		
		shadowsTotalPanel.add(totalPanelTitleLabel);
		shadowsTotalPanel.add(shadowsTotalCounterText);
		shadowsTotalPanel.add(shadowsTotalModifyPanel);
		shadowsTotalPanel.add(shadowsRarityButtonsPanel);
		
		shadows.add(shadowsImagePanel);
		shadows.add(shadowsEpicPanel);
		shadows.add(shadowsLegendaryPanel);
		shadows.add(shadowsTotalPanel);
	}
	
	// "Year of the Raven" panel creator
	private void createYearOfTheRavenPanel() 
	{
		// "Year of the Raven" panel
		raven = new JPanel();
		raven.setLayout(new BoxLayout(raven, BoxLayout.Y_AXIS));
		
		// "Year of the Raven" title header
		ravenHeader = new JPanel(new FlowLayout(FlowLayout.LEFT));
		ravenHeader.setBackground(yearsColor);
		
		ravenImageLabel = new JLabel(new ImageIcon(ravenImage));
		ravenImageLabel.setBorder(new EmptyBorder(5, 5, 5, 5));
		
		ravenLabel = new JLabel(ravenTitle);
		ravenLabel.setFont(yearsFont);
		ravenLabel.setBorder(new EmptyBorder(5, 25, 5, 5));
		
		ravenHeader.add(ravenImageLabel);
		ravenHeader.add(ravenLabel);
				
		// "Year of the Raven" expansions
		createRastakhansRumblePanel();
		createTheBoomsdayProjectPanel();
		createTheWitchwoodPanel();
		
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				raven.add(ravenHeader);
				raven.add(rumble);
				raven.add(boomsday);
				raven.add(witchwood);
				
				raven.setVisible(false);
			}
		});
	}
	
	// "Rastakhan's Rumble" panel creator
	private void createRastakhansRumblePanel() 
	{
		// "Rastakhan's Rumble" panel
		rumble = new JPanel();
		rumble.setBackground(rumbleColor);
		rumble.setLayout(new GridLayout(1, 4, 10, 0));
		rumble.setBorder(new EmptyBorder(10, 10, 10, 10));
		
		// "Rastakhan's Rumble" logo
		rumbleImagePanel = new JPanel(new GridBagLayout());
		rumbleImagePanel.setBackground(rumble.getBackground());
		
		rumbleImageButton = new JButton(new ImageIcon(rumbleImage));
		rumbleImageButton.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 0));
		rumbleImageButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		rumbleImageButton.setToolTipText(imageButtonToolTipText);
		rumbleImageButton.setContentAreaFilled(false);
		rumbleImageButton.setFocusPainted(false);
		
		rumbleImagePanel.add(rumbleImageButton);
		
		// Packs without epic counter panel
		rumbleEpicPanel = new JPanel();
		rumbleEpicPanel.setBackground(rumble.getBackground());
		rumbleEpicPanel.setLayout(new GridLayout(4, 1));
		
		// Packs without epic counter panel title
		epicPanelTitleLabel = new JTextPane();
		doc = epicPanelTitleLabel.getStyledDocument();
		changePanelTitleStyle(rumble, epicPanelTitleLabel, epicPanelTitle);
		
		// Packs without epic counter
		rumbleEpicCounterText = new JTextPane();
		doc = rumbleEpicCounterText.getStyledDocument();
		changePanelTextStyle(rumble, rumbleEpicCounterText, epicCounterText, rumbleEpicCounter);
		
		// Packs without epic counter modify buttons panel
		rumbleEpicModifyPanel = new JPanel();
		
		// Reset button
		rumbleEpicReset = new ModifierButton("Reset", headerBGColor, buttonsHoverColor);
		rumbleEpicReset.setToolTipText(resetButtonToolTipText);
		rumbleEpicReset.setBackground(headerBGColor);
		rumbleEpicReset.setForeground(titleFontColor);
		
		// Blank space between reset and add buttons
		blank = new JLabel();
		blank.setBackground(rumble.getBackground());
		blank.setBorder(new EmptyBorder(0, 20, 0, 20));
		
		// Add button
		rumbleEpicAdd = new RoundButton("+", headerBGColor, buttonsHoverColor);
		rumbleEpicAdd.setBackground(headerBGColor);
		rumbleEpicAdd.setForeground(titleFontColor);
		
		// Increment field
		rumbleEpicIncrement = new JTextArea(1, 1);
		rumbleEpicIncrement.setDocument(new IncrementLimit(1));
		rumbleEpicIncrement.setBackground(headerBGColor);
		rumbleEpicIncrement.setForeground(titleFontColor);
		rumbleEpicIncrement.setCaretColor(titleFontColor);
		rumbleEpicIncrement.setBorder(new EmptyBorder(0, 9, 0, 6));
		
		createModifyButtonsPanel(rumble, rumbleEpicModifyPanel, rumbleEpicReset, rumbleEpicAdd, rumbleEpicIncrement);
		
		// Probability of finding an epic calculator
		rumbleEpicProbabilityText = new JTextPane();
		doc = rumbleEpicProbabilityText.getStyledDocument();
		changePanelTextStyle(rumble, rumbleEpicProbabilityText, epicProbabilityText, rumbleEpicProbability);
		
		rumbleEpicPanel.add(epicPanelTitleLabel);
		rumbleEpicPanel.add(rumbleEpicCounterText);
		rumbleEpicPanel.add(rumbleEpicModifyPanel);
		rumbleEpicPanel.add(rumbleEpicProbabilityText);
		
		// Packs without legendary counter panel
		rumbleLegendaryPanel = new JPanel();
		rumbleLegendaryPanel.setBackground(rumble.getBackground());
		rumbleLegendaryPanel.setLayout(new GridLayout(4, 1));
		
		// Packs without legendary counter panel title
		legendaryPanelTitleLabel = new JTextPane();
		doc = legendaryPanelTitleLabel.getStyledDocument();
		changePanelTitleStyle(rumble, legendaryPanelTitleLabel, legendaryPanelTitle);
		
		// Packs without legendary counter
		rumbleLegendaryCounterText = new JTextPane();
		doc = rumbleLegendaryCounterText.getStyledDocument();
		changePanelTextStyle(rumble, rumbleLegendaryCounterText, legendaryCounterText, rumbleLegendaryCounter);
		
		// Packs without legendary counter modify buttons panel
		rumbleLegendaryModifyPanel = new JPanel();
		
		// Reset button
		rumbleLegendaryReset = new ModifierButton("Reset", headerBGColor, buttonsHoverColor);
		rumbleLegendaryReset.setToolTipText(resetButtonToolTipText);
		rumbleLegendaryReset.setBackground(headerBGColor);
		rumbleLegendaryReset.setForeground(titleFontColor);
		
		// Blank space between reset and add buttons
		blank = new JLabel();
		blank.setBackground(rumble.getBackground());
		blank.setBorder(new EmptyBorder(0, 20, 0, 20));
		
		// Add button
		rumbleLegendaryAdd = new RoundButton("+", headerBGColor, buttonsHoverColor);
		rumbleLegendaryAdd.setBackground(headerBGColor);
		rumbleLegendaryAdd.setForeground(titleFontColor);
		
		// Increment field
		rumbleLegendaryIncrement = new JTextArea(1, 2);
		rumbleLegendaryIncrement.setDocument(new IncrementLimit(2));
		rumbleLegendaryIncrement.setBackground(headerBGColor);
		rumbleLegendaryIncrement.setForeground(titleFontColor);
		rumbleLegendaryIncrement.setCaretColor(titleFontColor);
		rumbleLegendaryIncrement.setBorder(new EmptyBorder(0, 9, 0, 3));
		
		createModifyButtonsPanel(rumble, rumbleLegendaryModifyPanel, rumbleLegendaryReset, rumbleLegendaryAdd, rumbleLegendaryIncrement);
		
		// Probability of finding a legendary calculator
		rumbleLegendaryProbabilityText = new JTextPane();
		doc = rumbleLegendaryProbabilityText.getStyledDocument();
		changePanelTextStyle(rumble, rumbleLegendaryProbabilityText, legendaryProbabilityText, rumbleLegendaryProbability);
		
		rumbleLegendaryPanel.add(legendaryPanelTitleLabel);
		rumbleLegendaryPanel.add(rumbleLegendaryCounterText);
		rumbleLegendaryPanel.add(rumbleLegendaryModifyPanel);
		rumbleLegendaryPanel.add(rumbleLegendaryProbabilityText);
		
		// Total amount of packs opened counter panel
		rumbleTotalPanel = new JPanel();
		rumbleTotalPanel.setBackground(rumble.getBackground());
		rumbleTotalPanel.setLayout(new GridLayout(4, 1));
		
		// Total amount of packs opened counter panel title
		totalPanelTitleLabel = new JTextPane();
		doc = totalPanelTitleLabel.getStyledDocument();
		changePanelTitleStyle(rumble, totalPanelTitleLabel,totalPanelTitle);
		
		// Total amount of packs opened counter
		rumbleTotalCounterText = new JTextPane();
		doc = rumbleTotalCounterText.getStyledDocument();
		changePanelTextStyle(rumble, rumbleTotalCounterText, totalCounterText, rumbleTotalCounter);
		
		// Total amount of packs opened modify buttons panel
		rumbleTotalModifyPanel = new JPanel();
		
		// Modify button
		rumbleTotalModify = new ModifierButton("Modify", headerBGColor, buttonsHoverColor);
		rumbleTotalModify.setToolTipText(modifyButtonToolTipText);
		rumbleTotalModify.setBackground(headerBGColor);
		rumbleTotalModify.setForeground(titleFontColor);
		
		// Blank space between modify and add buttons
		blank = new JLabel();
		blank.setBackground(rumble.getBackground());
		blank.setBorder(new EmptyBorder(0, 5, 0, 5));
		
		// Add button
		rumbleTotalAdd = new RoundButton("+", headerBGColor, buttonsHoverColor);
		rumbleTotalAdd.setBackground(headerBGColor);
		rumbleTotalAdd.setForeground(titleFontColor);
		
		// Increment field
		rumbleTotalIncrement = new JTextArea(1, 3);
		rumbleTotalIncrement.setDocument(new IncrementLimit(3));
		rumbleTotalIncrement.setBackground(headerBGColor);
		rumbleTotalIncrement.setForeground(titleFontColor);
		rumbleTotalIncrement.setCaretColor(titleFontColor);
		rumbleTotalIncrement.setBorder(new EmptyBorder(0, 9, 0, 0));
		
		createModifyButtonsPanel(rumble, rumbleTotalModifyPanel, rumbleTotalModify, rumbleTotalAdd, rumbleTotalIncrement);
		
		// Rarity buttons panel
		rumbleRarityButtonsPanel = new JPanel();
		
		// Common button
		rumbleCommonButtonPanel = new JPanel(new GridBagLayout());
		rumbleCommonButton = new IconButton(new ImageIcon(commonButtonIcon), new ImageIcon(commonButtonHoverIcon));
		
		// Rare button
		rumbleRareButtonPanel = new JPanel(new GridBagLayout());
		rumbleRareButton = new IconButton(new ImageIcon(rareButtonIcon), new ImageIcon(rareButtonHoverIcon));
		
		// Epic button
		rumbleEpicButtonPanel = new JPanel(new GridBagLayout());
		rumbleEpicButton = new IconButton(new ImageIcon(epicButtonIcon), new ImageIcon(epicButtonHoverIcon));
		
		// Legendary button
		rumbleLegendaryButtonPanel = new JPanel(new GridBagLayout());
		rumbleLegendaryButton = new IconButton(new ImageIcon(legendaryButtonIcon), new ImageIcon(legendaryButtonHoverIcon));
		
		createRarityButtonsPanel(rumble, rumbleRarityButtonsPanel, 
				rumbleCommonButtonPanel, rumbleCommonButton, rumbleRareButtonPanel, rumbleRareButton, 
				rumbleEpicButtonPanel, rumbleEpicButton, rumbleLegendaryButtonPanel, rumbleLegendaryButton);
		
		rumbleTotalPanel.add(totalPanelTitleLabel);
		rumbleTotalPanel.add(rumbleTotalCounterText);
		rumbleTotalPanel.add(rumbleTotalModifyPanel);
		rumbleTotalPanel.add(rumbleRarityButtonsPanel);
		
		rumble.add(rumbleImagePanel);
		rumble.add(rumbleEpicPanel);
		rumble.add(rumbleLegendaryPanel);
		rumble.add(rumbleTotalPanel);
	}
	
	// "The Boomsday Project" panel creator
	private void createTheBoomsdayProjectPanel() 
	{
		// "The Boomsday Project" panel
		boomsday = new JPanel();
		boomsday.setBackground(boomsdayColor);
		boomsday.setLayout(new GridLayout(1, 4, 10, 0));
		boomsday.setBorder(new EmptyBorder(10, 10, 10, 10));
		
		// "The Boomsday Project" logo
		boomsdayImagePanel = new JPanel(new GridBagLayout());
		boomsdayImagePanel.setBackground(boomsday.getBackground());
		
		boomsdayImageButton = new JButton(new ImageIcon(boomsdayImage));
		boomsdayImageButton.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 0));
		boomsdayImageButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		boomsdayImageButton.setToolTipText(imageButtonToolTipText);
		boomsdayImageButton.setContentAreaFilled(false);
		boomsdayImageButton.setFocusPainted(false);
		
		boomsdayImagePanel.add(boomsdayImageButton);
		
		// Packs without epic counter panel
		boomsdayEpicPanel = new JPanel();
		boomsdayEpicPanel.setBackground(boomsday.getBackground());
		boomsdayEpicPanel.setLayout(new GridLayout(4, 1));
		
		// Packs without epic counter panel title
		epicPanelTitleLabel = new JTextPane();
		doc = epicPanelTitleLabel.getStyledDocument();
		changePanelTitleStyle(boomsday, epicPanelTitleLabel, epicPanelTitle);
		epicPanelTitleLabel.setForeground(titleFontColor);
		
		// Packs without epic counter
		boomsdayEpicCounterText = new JTextPane();
		doc = boomsdayEpicCounterText.getStyledDocument();
		changePanelTextStyle(boomsday, boomsdayEpicCounterText, epicCounterText, boomsdayEpicCounter);
		boomsdayEpicCounterText.setForeground(titleFontColor);
		
		// Packs without epic counter modify buttons panel
		boomsdayEpicModifyPanel = new JPanel();
		
		// Reset button
		boomsdayEpicReset = new ModifierButton("Reset", titleFontColor, buttonsDarkHoverColor);
		boomsdayEpicReset.setToolTipText(resetButtonToolTipText);
		boomsdayEpicReset.setBackground(titleFontColor);
		boomsdayEpicReset.setForeground(headerBGColor);
		
		// Blank space between reset and add buttons
		blank = new JLabel();
		blank.setBackground(boomsday.getBackground());
		blank.setBorder(new EmptyBorder(0, 20, 0, 20));
		
		// Add button
		boomsdayEpicAdd = new RoundButton("+", titleFontColor, buttonsDarkHoverColor);
		boomsdayEpicAdd.setBackground(titleFontColor);
		boomsdayEpicAdd.setForeground(headerBGColor);
		
		// Increment field
		boomsdayEpicIncrement = new JTextArea(1, 1);
		boomsdayEpicIncrement.setDocument(new IncrementLimit(1));
		boomsdayEpicIncrement.setBackground(titleFontColor);
		boomsdayEpicIncrement.setForeground(headerBGColor);
		boomsdayEpicIncrement.setCaretColor(headerBGColor);
		boomsdayEpicIncrement.setBorder(new EmptyBorder(0, 9, 0, 6));
		
		createModifyButtonsPanel(boomsday, boomsdayEpicModifyPanel, boomsdayEpicReset, boomsdayEpicAdd, boomsdayEpicIncrement);
		
		// Probability of finding an epic calculator
		boomsdayEpicProbabilityText = new JTextPane();
		doc = boomsdayEpicProbabilityText.getStyledDocument();
		changePanelTextStyle(boomsday, boomsdayEpicProbabilityText, epicProbabilityText, boomsdayEpicProbability);
		boomsdayEpicProbabilityText.setForeground(titleFontColor);
		
		boomsdayEpicPanel.add(epicPanelTitleLabel);
		boomsdayEpicPanel.add(boomsdayEpicCounterText);
		boomsdayEpicPanel.add(boomsdayEpicModifyPanel);
		boomsdayEpicPanel.add(boomsdayEpicProbabilityText);
		
		// Packs without legendary counter panel
		boomsdayLegendaryPanel = new JPanel();
		boomsdayLegendaryPanel.setBackground(boomsday.getBackground());
		boomsdayLegendaryPanel.setLayout(new GridLayout(4, 1));
		
		// Packs without legendary counter panel title
		legendaryPanelTitleLabel = new JTextPane();
		doc = legendaryPanelTitleLabel.getStyledDocument();
		changePanelTitleStyle(boomsday, legendaryPanelTitleLabel, legendaryPanelTitle);
		legendaryPanelTitleLabel.setForeground(titleFontColor);
		
		// Packs without legendary counter
		boomsdayLegendaryCounterText = new JTextPane();
		doc = boomsdayLegendaryCounterText.getStyledDocument();
		changePanelTextStyle(boomsday, boomsdayLegendaryCounterText, legendaryCounterText, boomsdayLegendaryCounter);
		boomsdayLegendaryCounterText.setForeground(titleFontColor);
		
		// Packs without legendary counter modify buttons panel
		boomsdayLegendaryModifyPanel = new JPanel();
		
		// Reset button
		boomsdayLegendaryReset = new ModifierButton("Reset", titleFontColor, buttonsDarkHoverColor);
		boomsdayLegendaryReset.setToolTipText(resetButtonToolTipText);
		boomsdayLegendaryReset.setBackground(titleFontColor);
		boomsdayLegendaryReset.setForeground(headerBGColor);
		
		// Blank space between reset and add buttons
		blank = new JLabel();
		blank.setBackground(boomsday.getBackground());
		blank.setBorder(new EmptyBorder(0, 20, 0, 20));
		
		// Add button
		boomsdayLegendaryAdd = new RoundButton("+", titleFontColor, buttonsDarkHoverColor);
		boomsdayLegendaryAdd.setBackground(titleFontColor);
		boomsdayLegendaryAdd.setForeground(headerBGColor);
		
		// Increment field
		boomsdayLegendaryIncrement = new JTextArea(1, 2);
		boomsdayLegendaryIncrement.setDocument(new IncrementLimit(2));
		boomsdayLegendaryIncrement.setBackground(titleFontColor);
		boomsdayLegendaryIncrement.setForeground(headerBGColor);
		boomsdayLegendaryIncrement.setCaretColor(headerBGColor);
		boomsdayLegendaryIncrement.setBorder(new EmptyBorder(0, 9, 0, 3));
		
		createModifyButtonsPanel(boomsday, boomsdayLegendaryModifyPanel, boomsdayLegendaryReset, boomsdayLegendaryAdd, boomsdayLegendaryIncrement);
		
		// Probability of finding a legendary calculator
		boomsdayLegendaryProbabilityText = new JTextPane();
		doc = boomsdayLegendaryProbabilityText.getStyledDocument();
		changePanelTextStyle(boomsday, boomsdayLegendaryProbabilityText, legendaryProbabilityText, boomsdayLegendaryProbability);
		boomsdayLegendaryProbabilityText.setForeground(titleFontColor);
		
		boomsdayLegendaryPanel.add(legendaryPanelTitleLabel);
		boomsdayLegendaryPanel.add(boomsdayLegendaryCounterText);
		boomsdayLegendaryPanel.add(boomsdayLegendaryModifyPanel);
		boomsdayLegendaryPanel.add(boomsdayLegendaryProbabilityText);
		
		// Total amount of packs opened counter panel
		boomsdayTotalPanel = new JPanel();
		boomsdayTotalPanel.setBackground(boomsday.getBackground());
		boomsdayTotalPanel.setLayout(new GridLayout(4, 1));
		
		// Total amount of packs opened counter panel title
		totalPanelTitleLabel = new JTextPane();
		doc = totalPanelTitleLabel.getStyledDocument();
		changePanelTitleStyle(boomsday, totalPanelTitleLabel,totalPanelTitle);
		totalPanelTitleLabel.setForeground(titleFontColor);
		
		// Total amount of packs opened counter
		boomsdayTotalCounterText = new JTextPane();
		doc = boomsdayTotalCounterText.getStyledDocument();
		changePanelTextStyle(boomsday, boomsdayTotalCounterText, totalCounterText, boomsdayTotalCounter);
		boomsdayTotalCounterText.setForeground(titleFontColor);
		
		// Total amount of packs opened modify buttons panel
		boomsdayTotalModifyPanel = new JPanel();
		
		// Modify button
		boomsdayTotalModify = new ModifierButton("Modify", titleFontColor, buttonsDarkHoverColor);
		boomsdayTotalModify.setToolTipText(modifyButtonToolTipText);
		boomsdayTotalModify.setBackground(titleFontColor);
		boomsdayTotalModify.setForeground(headerBGColor);
		
		// Blank space between modify and add buttons
		blank = new JLabel();
		blank.setBackground(boomsday.getBackground());
		blank.setBorder(new EmptyBorder(0, 5, 0, 5));
		
		// Add button
		boomsdayTotalAdd = new RoundButton("+", titleFontColor, buttonsDarkHoverColor);
		boomsdayTotalAdd.setBackground(titleFontColor);
		boomsdayTotalAdd.setForeground(headerBGColor);
		
		// Increment field
		boomsdayTotalIncrement = new JTextArea(1, 3);
		boomsdayTotalIncrement.setDocument(new IncrementLimit(3));
		boomsdayTotalIncrement.setBackground(titleFontColor);
		boomsdayTotalIncrement.setForeground(headerBGColor);
		boomsdayTotalIncrement.setCaretColor(headerBGColor);
		boomsdayTotalIncrement.setBorder(new EmptyBorder(0, 9, 0, 0));
		
		createModifyButtonsPanel(boomsday, boomsdayTotalModifyPanel, boomsdayTotalModify, boomsdayTotalAdd, boomsdayTotalIncrement);
		
		// Rarity buttons panel
		boomsdayRarityButtonsPanel = new JPanel();
		
		// Common button
		boomsdayCommonButtonPanel = new JPanel(new GridBagLayout());
		boomsdayCommonButton = new IconButton(new ImageIcon(commonButtonDarkIcon), new ImageIcon(commonButtonDarkHoverIcon));
		
		// Rare button
		boomsdayRareButtonPanel = new JPanel(new GridBagLayout());
		boomsdayRareButton = new IconButton(new ImageIcon(rareButtonDarkIcon), new ImageIcon(rareButtonDarkHoverIcon));
		
		// Epic button
		boomsdayEpicButtonPanel = new JPanel(new GridBagLayout());
		boomsdayEpicButton = new IconButton(new ImageIcon(epicButtonDarkIcon), new ImageIcon(epicButtonDarkHoverIcon));
		
		// Legendary button
		boomsdayLegendaryButtonPanel = new JPanel(new GridBagLayout());
		boomsdayLegendaryButton = new IconButton(new ImageIcon(legendaryButtonDarkIcon), new ImageIcon(legendaryButtonDarkHoverIcon));
		
		createRarityButtonsPanel(boomsday, boomsdayRarityButtonsPanel, 
				boomsdayCommonButtonPanel, boomsdayCommonButton, boomsdayRareButtonPanel, boomsdayRareButton, 
				boomsdayEpicButtonPanel, boomsdayEpicButton, boomsdayLegendaryButtonPanel, boomsdayLegendaryButton);
		
		boomsdayTotalPanel.add(totalPanelTitleLabel);
		boomsdayTotalPanel.add(boomsdayTotalCounterText);
		boomsdayTotalPanel.add(boomsdayTotalModifyPanel);
		boomsdayTotalPanel.add(boomsdayRarityButtonsPanel);
		
		boomsday.add(boomsdayImagePanel);
		boomsday.add(boomsdayEpicPanel);
		boomsday.add(boomsdayLegendaryPanel);
		boomsday.add(boomsdayTotalPanel);
	}
	
	// "The Witchwood" panel creator
	private void createTheWitchwoodPanel() 
	{
		// "The Witchwood" panel
		witchwood = new JPanel();
		witchwood.setBackground(witchwoodColor);
		witchwood.setLayout(new GridLayout(1, 4, 10, 0));
		witchwood.setBorder(new EmptyBorder(10, 10, 10, 10));
		
		// "The Witchwood" logo
		witchwoodImagePanel = new JPanel(new GridBagLayout());
		witchwoodImagePanel.setBackground(witchwood.getBackground());
		
		witchwoodImageButton = new JButton(new ImageIcon(witchwoodImage));
		witchwoodImageButton.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 0));
		witchwoodImageButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		witchwoodImageButton.setToolTipText(imageButtonToolTipText);
		witchwoodImageButton.setContentAreaFilled(false);
		witchwoodImageButton.setFocusPainted(false);
		
		witchwoodImagePanel.add(witchwoodImageButton);
				
		// Packs without epic counter panel
		witchwoodEpicPanel = new JPanel();
		witchwoodEpicPanel.setBackground(witchwood.getBackground());
		witchwoodEpicPanel.setLayout(new GridLayout(4, 1));
		
		// Packs without epic counter panel title
		epicPanelTitleLabel = new JTextPane();
		doc = epicPanelTitleLabel.getStyledDocument();
		changePanelTitleStyle(witchwood, epicPanelTitleLabel, epicPanelTitle);
		
		// Packs without epic counter
		witchwoodEpicCounterText = new JTextPane();
		doc = witchwoodEpicCounterText.getStyledDocument();
		changePanelTextStyle(witchwood, witchwoodEpicCounterText, epicCounterText, witchwoodEpicCounter);
		
		// Packs without epic counter modify buttons panel
		witchwoodEpicModifyPanel = new JPanel();
		
		// Reset button
		witchwoodEpicReset = new ModifierButton("Reset", headerBGColor, buttonsHoverColor);
		witchwoodEpicReset.setToolTipText(resetButtonToolTipText);
		witchwoodEpicReset.setBackground(headerBGColor);
		witchwoodEpicReset.setForeground(titleFontColor);
		
		// Blank space between reset and add buttons
		blank = new JLabel();
		blank.setBackground(witchwood.getBackground());
		blank.setBorder(new EmptyBorder(0, 20, 0, 20));
		
		// Add button
		witchwoodEpicAdd = new RoundButton("+", headerBGColor, buttonsHoverColor);
		witchwoodEpicAdd.setBackground(headerBGColor);
		witchwoodEpicAdd.setForeground(titleFontColor);
		
		// Increment field
		witchwoodEpicIncrement = new JTextArea(1, 1);
		witchwoodEpicIncrement.setDocument(new IncrementLimit(1));
		witchwoodEpicIncrement.setBackground(headerBGColor);
		witchwoodEpicIncrement.setForeground(titleFontColor);
		witchwoodEpicIncrement.setCaretColor(titleFontColor);
		witchwoodEpicIncrement.setBorder(new EmptyBorder(0, 9, 0, 6));
		
		createModifyButtonsPanel(witchwood, witchwoodEpicModifyPanel, witchwoodEpicReset, witchwoodEpicAdd, witchwoodEpicIncrement);
		
		// Probability of finding an epic calculator
		witchwoodEpicProbabilityText = new JTextPane();
		doc = witchwoodEpicProbabilityText.getStyledDocument();
		changePanelTextStyle(witchwood, witchwoodEpicProbabilityText, epicProbabilityText, witchwoodEpicProbability);
		
		witchwoodEpicPanel.add(epicPanelTitleLabel);
		witchwoodEpicPanel.add(witchwoodEpicCounterText);
		witchwoodEpicPanel.add(witchwoodEpicModifyPanel);
		witchwoodEpicPanel.add(witchwoodEpicProbabilityText);
		
		// Packs without legendary counter panel
		witchwoodLegendaryPanel = new JPanel();
		witchwoodLegendaryPanel.setBackground(witchwood.getBackground());
		witchwoodLegendaryPanel.setLayout(new GridLayout(4, 1));
		
		// Packs without legendary counter panel title
		legendaryPanelTitleLabel = new JTextPane();
		doc = legendaryPanelTitleLabel.getStyledDocument();
		changePanelTitleStyle(witchwood, legendaryPanelTitleLabel, legendaryPanelTitle);
		
		// Packs without legendary counter
		witchwoodLegendaryCounterText = new JTextPane();
		doc = witchwoodLegendaryCounterText.getStyledDocument();
		changePanelTextStyle(witchwood, witchwoodLegendaryCounterText, legendaryCounterText, witchwoodLegendaryCounter);
		
		// Packs without legendary counter modify buttons panel
		witchwoodLegendaryModifyPanel = new JPanel();
		
		// Reset button
		witchwoodLegendaryReset = new ModifierButton("Reset", headerBGColor, buttonsHoverColor);
		witchwoodLegendaryReset.setToolTipText(resetButtonToolTipText);
		witchwoodLegendaryReset.setBackground(headerBGColor);
		witchwoodLegendaryReset.setForeground(titleFontColor);
		
		// Blank space between reset and add buttons
		blank = new JLabel();
		blank.setBackground(witchwood.getBackground());
		blank.setBorder(new EmptyBorder(0, 20, 0, 20));
		
		// Add button
		witchwoodLegendaryAdd = new RoundButton("+", headerBGColor, buttonsHoverColor);
		witchwoodLegendaryAdd.setBackground(headerBGColor);
		witchwoodLegendaryAdd.setForeground(titleFontColor);
		
		// Increment field
		witchwoodLegendaryIncrement = new JTextArea(1, 2);
		witchwoodLegendaryIncrement.setDocument(new IncrementLimit(2));
		witchwoodLegendaryIncrement.setBackground(headerBGColor);
		witchwoodLegendaryIncrement.setForeground(titleFontColor);
		witchwoodLegendaryIncrement.setCaretColor(titleFontColor);
		witchwoodLegendaryIncrement.setBorder(new EmptyBorder(0, 9, 0, 3));
		
		createModifyButtonsPanel(witchwood, witchwoodLegendaryModifyPanel, witchwoodLegendaryReset, witchwoodLegendaryAdd, witchwoodLegendaryIncrement);
		
		// Probability of finding a legendary calculator
		witchwoodLegendaryProbabilityText = new JTextPane();
		doc = witchwoodLegendaryProbabilityText.getStyledDocument();
		changePanelTextStyle(witchwood, witchwoodLegendaryProbabilityText, legendaryProbabilityText, witchwoodLegendaryProbability);
		
		witchwoodLegendaryPanel.add(legendaryPanelTitleLabel);
		witchwoodLegendaryPanel.add(witchwoodLegendaryCounterText);
		witchwoodLegendaryPanel.add(witchwoodLegendaryModifyPanel);
		witchwoodLegendaryPanel.add(witchwoodLegendaryProbabilityText);
		
		// Total amount of packs opened counter panel
		witchwoodTotalPanel = new JPanel();
		witchwoodTotalPanel.setBackground(witchwood.getBackground());
		witchwoodTotalPanel.setLayout(new GridLayout(4, 1));
		
		// Total amount of packs opened counter panel title
		totalPanelTitleLabel = new JTextPane();
		doc = totalPanelTitleLabel.getStyledDocument();
		changePanelTitleStyle(witchwood, totalPanelTitleLabel,totalPanelTitle);
		
		// Total amount of packs opened counter
		witchwoodTotalCounterText = new JTextPane();
		doc = witchwoodTotalCounterText.getStyledDocument();
		changePanelTextStyle(witchwood, witchwoodTotalCounterText, totalCounterText, witchwoodTotalCounter);
		
		// Total amount of packs opened modify buttons panel
		witchwoodTotalModifyPanel = new JPanel();
		
		// Modify button
		witchwoodTotalModify = new ModifierButton("Modify", headerBGColor, buttonsHoverColor);
		witchwoodTotalModify.setToolTipText(modifyButtonToolTipText);
		witchwoodTotalModify.setBackground(headerBGColor);
		witchwoodTotalModify.setForeground(titleFontColor);
		
		// Blank space between modify and add buttons
		blank = new JLabel();
		blank.setBackground(witchwood.getBackground());
		blank.setBorder(new EmptyBorder(0, 5, 0, 5));
		
		// Add button
		witchwoodTotalAdd = new RoundButton("+", headerBGColor, buttonsHoverColor);
		witchwoodTotalAdd.setBackground(headerBGColor);
		witchwoodTotalAdd.setForeground(titleFontColor);
		
		// Increment field
		witchwoodTotalIncrement = new JTextArea(1, 3);
		witchwoodTotalIncrement.setDocument(new IncrementLimit(3));
		witchwoodTotalIncrement.setBackground(headerBGColor);
		witchwoodTotalIncrement.setForeground(titleFontColor);
		witchwoodTotalIncrement.setCaretColor(titleFontColor);
		witchwoodTotalIncrement.setBorder(new EmptyBorder(0, 9, 0, 0));
		
		createModifyButtonsPanel(witchwood, witchwoodTotalModifyPanel, witchwoodTotalModify, witchwoodTotalAdd, witchwoodTotalIncrement);
		
		// Rarity buttons panel
		witchwoodRarityButtonsPanel = new JPanel();
		
		// Common button
		witchwoodCommonButtonPanel = new JPanel(new GridBagLayout());
		witchwoodCommonButton = new IconButton(new ImageIcon(commonButtonIcon), new ImageIcon(commonButtonHoverIcon));
		
		// Rare button
		witchwoodRareButtonPanel = new JPanel(new GridBagLayout());
		witchwoodRareButton = new IconButton(new ImageIcon(rareButtonIcon), new ImageIcon(rareButtonHoverIcon));
		
		// Epic button
		witchwoodEpicButtonPanel = new JPanel(new GridBagLayout());
		witchwoodEpicButton = new IconButton(new ImageIcon(epicButtonIcon), new ImageIcon(epicButtonHoverIcon));
		
		// Legendary button
		witchwoodLegendaryButtonPanel = new JPanel(new GridBagLayout());
		witchwoodLegendaryButton = new IconButton(new ImageIcon(legendaryButtonIcon), new ImageIcon(legendaryButtonHoverIcon));
		
		createRarityButtonsPanel(witchwood, witchwoodRarityButtonsPanel, 
				witchwoodCommonButtonPanel, witchwoodCommonButton, witchwoodRareButtonPanel, witchwoodRareButton, 
				witchwoodEpicButtonPanel, witchwoodEpicButton, witchwoodLegendaryButtonPanel, witchwoodLegendaryButton);
		
		witchwoodTotalPanel.add(totalPanelTitleLabel);
		witchwoodTotalPanel.add(witchwoodTotalCounterText);
		witchwoodTotalPanel.add(witchwoodTotalModifyPanel);
		witchwoodTotalPanel.add(witchwoodRarityButtonsPanel);
		
		witchwood.add(witchwoodImagePanel);
		witchwood.add(witchwoodEpicPanel);
		witchwood.add(witchwoodLegendaryPanel);
		witchwood.add(witchwoodTotalPanel);
	}
	
	// "Year of the Mammoth" panel creator
	private void createYearOfTheMammothPanel() 
	{
		// "Year of the Mammoth" panel
		mammoth = new JPanel();
		mammoth.setLayout(new BoxLayout(mammoth, BoxLayout.Y_AXIS));
		
		// "Year of the Mammoth" title header
		mammothHeader = new JPanel(new FlowLayout(FlowLayout.LEFT));
		mammothHeader.setBackground(yearsColor);
		
		mammothImageLabel = new JLabel(new ImageIcon(mammothImage));
		mammothImageLabel.setBorder(new EmptyBorder(5, 5, 5, 5));
		
		mammothLabel = new JLabel(mammothTitle);
		mammothLabel.setFont(yearsFont);
		mammothLabel.setBorder(new EmptyBorder(5, 25, 5, 5));
		
		mammothHeader.add(mammothImageLabel);
		mammothHeader.add(mammothLabel);
				
		// "Year of the Mammoth" expansions
		createKoboldsAndCatacombsPanel();
		createKnightsOfTheFrozenThronePanel();
		createJourneyToUngoroPanel();
		
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				mammoth.add(mammothHeader);
				mammoth.add(kobolds);
				mammoth.add(knights);
				mammoth.add(ungoro);
				
				mammoth.setVisible(false);
			}
		});
	}
	
	// "Kobolds & Catacombs" panel creator
	private void createKoboldsAndCatacombsPanel() 
	{
		// "Kobolds & Catacombs" panel
		kobolds = new JPanel();
		kobolds.setBackground(koboldsColor);
		kobolds.setLayout(new GridLayout(1, 4, 10, 0));
		kobolds.setBorder(new EmptyBorder(10, 10, 10, 10));
		
		// "Kobolds & Catacombs" logo
		koboldsImagePanel = new JPanel(new GridBagLayout());
		koboldsImagePanel.setBackground(kobolds.getBackground());
		
		koboldsImageButton = new JButton(new ImageIcon(koboldsImage));
		koboldsImageButton.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 0));
		koboldsImageButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		koboldsImageButton.setToolTipText(imageButtonToolTipText);
		koboldsImageButton.setContentAreaFilled(false);
		koboldsImageButton.setFocusPainted(false);
		
		koboldsImagePanel.add(koboldsImageButton);
		
		// Packs without epic counter panel
		koboldsEpicPanel = new JPanel();
		koboldsEpicPanel.setBackground(kobolds.getBackground());
		koboldsEpicPanel.setLayout(new GridLayout(4, 1));
		
		// Packs without epic counter panel title
		epicPanelTitleLabel = new JTextPane();
		doc = epicPanelTitleLabel.getStyledDocument();
		changePanelTitleStyle(kobolds, epicPanelTitleLabel, epicPanelTitle);
		
		// Packs without epic counter
		koboldsEpicCounterText = new JTextPane();
		doc = koboldsEpicCounterText.getStyledDocument();
		changePanelTextStyle(kobolds, koboldsEpicCounterText, epicCounterText, koboldsEpicCounter);
		
		// Packs without epic counter modify buttons panel
		koboldsEpicModifyPanel = new JPanel();
		
		// Reset button
		koboldsEpicReset = new ModifierButton("Reset", headerBGColor, buttonsHoverColor);
		koboldsEpicReset.setToolTipText(resetButtonToolTipText);
		koboldsEpicReset.setBackground(headerBGColor);
		koboldsEpicReset.setForeground(titleFontColor);
		
		// Blank space between reset and add buttons
		blank = new JLabel();
		blank.setBackground(kobolds.getBackground());
		blank.setBorder(new EmptyBorder(0, 20, 0, 20));
		
		// Add button
		koboldsEpicAdd = new RoundButton("+", headerBGColor, buttonsHoverColor);
		koboldsEpicAdd.setBackground(headerBGColor);
		koboldsEpicAdd.setForeground(titleFontColor);
		
		// Increment field
		koboldsEpicIncrement = new JTextArea(1, 1);
		koboldsEpicIncrement.setDocument(new IncrementLimit(1));
		koboldsEpicIncrement.setBackground(headerBGColor);
		koboldsEpicIncrement.setForeground(titleFontColor);
		koboldsEpicIncrement.setCaretColor(titleFontColor);
		koboldsEpicIncrement.setBorder(new EmptyBorder(0, 9, 0, 6));
		
		createModifyButtonsPanel(kobolds, koboldsEpicModifyPanel, koboldsEpicReset, koboldsEpicAdd, koboldsEpicIncrement);
		
		// Probability of finding an epic calculator
		koboldsEpicProbabilityText = new JTextPane();
		doc = koboldsEpicProbabilityText.getStyledDocument();
		changePanelTextStyle(kobolds, koboldsEpicProbabilityText, epicProbabilityText, koboldsEpicProbability);
		
		koboldsEpicPanel.add(epicPanelTitleLabel);
		koboldsEpicPanel.add(koboldsEpicCounterText);
		koboldsEpicPanel.add(koboldsEpicModifyPanel);
		koboldsEpicPanel.add(koboldsEpicProbabilityText);
		
		// Packs without legendary counter panel
		koboldsLegendaryPanel = new JPanel();
		koboldsLegendaryPanel.setBackground(kobolds.getBackground());
		koboldsLegendaryPanel.setLayout(new GridLayout(4, 1));
		
		// Packs without legendary counter panel title
		legendaryPanelTitleLabel = new JTextPane();
		doc = legendaryPanelTitleLabel.getStyledDocument();
		changePanelTitleStyle(kobolds, legendaryPanelTitleLabel, legendaryPanelTitle);
		
		// Packs without legendary counter
		koboldsLegendaryCounterText = new JTextPane();
		doc = koboldsLegendaryCounterText.getStyledDocument();
		changePanelTextStyle(kobolds, koboldsLegendaryCounterText, legendaryCounterText, koboldsLegendaryCounter);
		
		// Packs without legendary counter modify buttons panel
		koboldsLegendaryModifyPanel = new JPanel();
		
		// Reset button
		koboldsLegendaryReset = new ModifierButton("Reset", headerBGColor, buttonsHoverColor);
		koboldsLegendaryReset.setToolTipText(resetButtonToolTipText);
		koboldsLegendaryReset.setBackground(headerBGColor);
		koboldsLegendaryReset.setForeground(titleFontColor);
		
		// Blank space between reset and add buttons
		blank = new JLabel();
		blank.setBackground(kobolds.getBackground());
		blank.setBorder(new EmptyBorder(0, 20, 0, 20));
		
		// Add button
		koboldsLegendaryAdd = new RoundButton("+", headerBGColor, buttonsHoverColor);
		koboldsLegendaryAdd.setBackground(headerBGColor);
		koboldsLegendaryAdd.setForeground(titleFontColor);
		
		// Increment field
		koboldsLegendaryIncrement = new JTextArea(1, 2);
		koboldsLegendaryIncrement.setDocument(new IncrementLimit(2));
		koboldsLegendaryIncrement.setBackground(headerBGColor);
		koboldsLegendaryIncrement.setForeground(titleFontColor);
		koboldsLegendaryIncrement.setCaretColor(titleFontColor);
		koboldsLegendaryIncrement.setBorder(new EmptyBorder(0, 9, 0, 3));
		
		createModifyButtonsPanel(kobolds, koboldsLegendaryModifyPanel, koboldsLegendaryReset, koboldsLegendaryAdd, koboldsLegendaryIncrement);
		
		// Probability of finding a legendary calculator
		koboldsLegendaryProbabilityText = new JTextPane();
		doc = koboldsLegendaryProbabilityText.getStyledDocument();
		changePanelTextStyle(kobolds, koboldsLegendaryProbabilityText, legendaryProbabilityText, koboldsLegendaryProbability);
		
		koboldsLegendaryPanel.add(legendaryPanelTitleLabel);
		koboldsLegendaryPanel.add(koboldsLegendaryCounterText);
		koboldsLegendaryPanel.add(koboldsLegendaryModifyPanel);
		koboldsLegendaryPanel.add(koboldsLegendaryProbabilityText);
		
		// Total amount of packs opened counter panel
		koboldsTotalPanel = new JPanel();
		koboldsTotalPanel.setBackground(kobolds.getBackground());
		koboldsTotalPanel.setLayout(new GridLayout(4, 1));
		
		// Total amount of packs opened counter panel title
		totalPanelTitleLabel = new JTextPane();
		doc = totalPanelTitleLabel.getStyledDocument();
		changePanelTitleStyle(kobolds, totalPanelTitleLabel,totalPanelTitle);
		
		// Total amount of packs opened counter
		koboldsTotalCounterText = new JTextPane();
		doc = koboldsTotalCounterText.getStyledDocument();
		changePanelTextStyle(kobolds, koboldsTotalCounterText, totalCounterText, koboldsTotalCounter);
		
		// Total amount of packs opened modify buttons panel
		koboldsTotalModifyPanel = new JPanel();
		
		// Modify button
		koboldsTotalModify = new ModifierButton("Modify", headerBGColor, buttonsHoverColor);
		koboldsTotalModify.setToolTipText(modifyButtonToolTipText);
		koboldsTotalModify.setBackground(headerBGColor);
		koboldsTotalModify.setForeground(titleFontColor);
		
		// Blank space between modify and add buttons
		blank = new JLabel();
		blank.setBackground(kobolds.getBackground());
		blank.setBorder(new EmptyBorder(0, 5, 0, 5));
		
		// Add button
		koboldsTotalAdd = new RoundButton("+", headerBGColor, buttonsHoverColor);
		koboldsTotalAdd.setBackground(headerBGColor);
		koboldsTotalAdd.setForeground(titleFontColor);
		
		// Increment field
		koboldsTotalIncrement = new JTextArea(1, 3);
		koboldsTotalIncrement.setDocument(new IncrementLimit(3));
		koboldsTotalIncrement.setBackground(headerBGColor);
		koboldsTotalIncrement.setForeground(titleFontColor);
		koboldsTotalIncrement.setCaretColor(titleFontColor);
		koboldsTotalIncrement.setBorder(new EmptyBorder(0, 9, 0, 0));
		
		createModifyButtonsPanel(kobolds, koboldsTotalModifyPanel, koboldsTotalModify, koboldsTotalAdd, koboldsTotalIncrement);
		
		// Rarity buttons panel
		koboldsRarityButtonsPanel = new JPanel();
		
		// Common button
		koboldsCommonButtonPanel = new JPanel(new GridBagLayout());
		koboldsCommonButton = new IconButton(new ImageIcon(commonButtonIcon), new ImageIcon(commonButtonHoverIcon));
		
		// Rare button
		koboldsRareButtonPanel = new JPanel(new GridBagLayout());
		koboldsRareButton = new IconButton(new ImageIcon(rareButtonIcon), new ImageIcon(rareButtonHoverIcon));
		
		// Epic button
		koboldsEpicButtonPanel = new JPanel(new GridBagLayout());
		koboldsEpicButton = new IconButton(new ImageIcon(epicButtonIcon), new ImageIcon(epicButtonHoverIcon));
		
		// Legendary button
		koboldsLegendaryButtonPanel = new JPanel(new GridBagLayout());
		koboldsLegendaryButton = new IconButton(new ImageIcon(legendaryButtonIcon), new ImageIcon(legendaryButtonHoverIcon));
		
		createRarityButtonsPanel(kobolds, koboldsRarityButtonsPanel, 
				koboldsCommonButtonPanel, koboldsCommonButton, koboldsRareButtonPanel, koboldsRareButton, 
				koboldsEpicButtonPanel, koboldsEpicButton, koboldsLegendaryButtonPanel, koboldsLegendaryButton);
		
		koboldsTotalPanel.add(totalPanelTitleLabel);
		koboldsTotalPanel.add(koboldsTotalCounterText);
		koboldsTotalPanel.add(koboldsTotalModifyPanel);
		koboldsTotalPanel.add(koboldsRarityButtonsPanel);
		
		kobolds.add(koboldsImagePanel);
		kobolds.add(koboldsEpicPanel);
		kobolds.add(koboldsLegendaryPanel);
		kobolds.add(koboldsTotalPanel);
	}
	
	// "Knights of the Frozen Throne" panel creator
	private void createKnightsOfTheFrozenThronePanel() 
	{
		// "Knights of the Frozen Throne" panel
		knights = new JPanel();
		knights.setBackground(knightsColor);
		knights.setLayout(new GridLayout(1, 4, 10, 0));
		knights.setBorder(new EmptyBorder(10, 10, 10, 10));
		
		// "Knights of the Frozen Throne" logo
		knightsImagePanel = new JPanel(new GridBagLayout());
		knightsImagePanel.setBackground(knights.getBackground());
		
		knightsImageButton = new JButton(new ImageIcon(knightsImage));
		knightsImageButton.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 0));
		knightsImageButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		knightsImageButton.setToolTipText(imageButtonToolTipText);
		knightsImageButton.setContentAreaFilled(false);
		knightsImageButton.setFocusPainted(false);
		
		knightsImagePanel.add(knightsImageButton);
		
		// Packs without epic counter panel
		knightsEpicPanel = new JPanel();
		knightsEpicPanel.setBackground(knights.getBackground());
		knightsEpicPanel.setLayout(new GridLayout(4, 1));
		
		// Packs without epic counter panel title
		epicPanelTitleLabel = new JTextPane();
		doc = epicPanelTitleLabel.getStyledDocument();
		changePanelTitleStyle(knights, epicPanelTitleLabel, epicPanelTitle);
		
		// Packs without epic counter
		knightsEpicCounterText = new JTextPane();
		doc = knightsEpicCounterText.getStyledDocument();
		changePanelTextStyle(knights, knightsEpicCounterText, epicCounterText, knightsEpicCounter);
		
		// Packs without epic counter modify buttons panel
		knightsEpicModifyPanel = new JPanel();
		
		// Reset button
		knightsEpicReset = new ModifierButton("Reset", headerBGColor, buttonsHoverColor);
		knightsEpicReset.setToolTipText(resetButtonToolTipText);
		knightsEpicReset.setBackground(headerBGColor);
		knightsEpicReset.setForeground(titleFontColor);
		
		// Blank space between reset and add buttons
		blank = new JLabel();
		blank.setBackground(knights.getBackground());
		blank.setBorder(new EmptyBorder(0, 20, 0, 20));
		
		// Add button
		knightsEpicAdd = new RoundButton("+", headerBGColor, buttonsHoverColor);
		knightsEpicAdd.setBackground(headerBGColor);
		knightsEpicAdd.setForeground(titleFontColor);
		
		// Increment field
		knightsEpicIncrement = new JTextArea(1, 1);
		knightsEpicIncrement.setDocument(new IncrementLimit(1));
		knightsEpicIncrement.setBackground(headerBGColor);
		knightsEpicIncrement.setForeground(titleFontColor);
		knightsEpicIncrement.setCaretColor(titleFontColor);
		knightsEpicIncrement.setBorder(new EmptyBorder(0, 9, 0, 6));
		
		createModifyButtonsPanel(knights, knightsEpicModifyPanel, knightsEpicReset, knightsEpicAdd, knightsEpicIncrement);
		
		// Probability of finding an epic calculator
		knightsEpicProbabilityText = new JTextPane();
		doc = knightsEpicProbabilityText.getStyledDocument();
		changePanelTextStyle(knights, knightsEpicProbabilityText,epicProbabilityText, knightsEpicProbability);
		
		knightsEpicPanel.add(epicPanelTitleLabel);
		knightsEpicPanel.add(knightsEpicCounterText);
		knightsEpicPanel.add(knightsEpicModifyPanel);
		knightsEpicPanel.add(knightsEpicProbabilityText);
		
		// Packs without legendary counter panel
		knightsLegendaryPanel = new JPanel();
		knightsLegendaryPanel.setBackground(knights.getBackground());
		knightsLegendaryPanel.setLayout(new GridLayout(4, 1));
		
		// Packs without legendary counter panel title
		legendaryPanelTitleLabel = new JTextPane();
		doc = legendaryPanelTitleLabel.getStyledDocument();
		changePanelTitleStyle(knights, legendaryPanelTitleLabel, legendaryPanelTitle);
				
		// Packs without legendary counter
		knightsLegendaryCounterText = new JTextPane();
		doc = knightsLegendaryCounterText.getStyledDocument();
		changePanelTextStyle(knights, knightsLegendaryCounterText, legendaryCounterText, knightsLegendaryCounter);
		
		// Packs without legendary counter modify buttons panel
		knightsLegendaryModifyPanel = new JPanel();
		
		// Reset button
		knightsLegendaryReset = new ModifierButton("Reset", headerBGColor, buttonsHoverColor);
		knightsLegendaryReset.setToolTipText(resetButtonToolTipText);
		knightsLegendaryReset.setBackground(headerBGColor);
		knightsLegendaryReset.setForeground(titleFontColor);
		
		// Blank space between reset and add buttons
		blank = new JLabel();
		blank.setBackground(knights.getBackground());
		blank.setBorder(new EmptyBorder(0, 20, 0, 20));
		
		// Add button
		knightsLegendaryAdd = new RoundButton("+", headerBGColor, buttonsHoverColor);
		knightsLegendaryAdd.setBackground(headerBGColor);
		knightsLegendaryAdd.setForeground(titleFontColor);
		
		// Increment field
		knightsLegendaryIncrement = new JTextArea(1, 2);
		knightsLegendaryIncrement.setDocument(new IncrementLimit(2));
		knightsLegendaryIncrement.setBackground(headerBGColor);
		knightsLegendaryIncrement.setForeground(titleFontColor);
		knightsLegendaryIncrement.setCaretColor(titleFontColor);
		knightsLegendaryIncrement.setBorder(new EmptyBorder(0, 9, 0, 3));
		
		createModifyButtonsPanel(knights, knightsLegendaryModifyPanel, knightsLegendaryReset, knightsLegendaryAdd, knightsLegendaryIncrement);
		
		// Probability of finding a legendary calculator
		knightsLegendaryProbabilityText = new JTextPane();
		doc = knightsLegendaryProbabilityText.getStyledDocument();
		changePanelTextStyle(knights, knightsLegendaryProbabilityText, legendaryProbabilityText, knightsLegendaryProbability);
		
		knightsLegendaryPanel.add(legendaryPanelTitleLabel);
		knightsLegendaryPanel.add(knightsLegendaryCounterText);
		knightsLegendaryPanel.add(knightsLegendaryModifyPanel);
		knightsLegendaryPanel.add(knightsLegendaryProbabilityText);
		
		// Total amount of packs opened counter panel
		knightsTotalPanel = new JPanel();
		knightsTotalPanel.setBackground(knights.getBackground());
		knightsTotalPanel.setLayout(new GridLayout(4, 1));
		
		// Total amount of packs opened counter panel title
		totalPanelTitleLabel = new JTextPane();
		doc = totalPanelTitleLabel.getStyledDocument();
		changePanelTitleStyle(knights, totalPanelTitleLabel,totalPanelTitle);
		
		// Total amount of packs opened counter
		knightsTotalCounterText = new JTextPane();
		doc = knightsTotalCounterText.getStyledDocument();
		changePanelTextStyle(knights, knightsTotalCounterText, totalCounterText, knightsTotalCounter);
		
		// Total amount of packs opened modify buttons panel
		knightsTotalModifyPanel = new JPanel();
		
		// Modify button
		knightsTotalModify = new ModifierButton("Modify", headerBGColor, buttonsHoverColor);
		knightsTotalModify.setToolTipText(modifyButtonToolTipText);
		knightsTotalModify.setBackground(headerBGColor);
		knightsTotalModify.setForeground(titleFontColor);
		
		// Blank space between modify and add buttons
		blank = new JLabel();
		blank.setBackground(knights.getBackground());
		blank.setBorder(new EmptyBorder(0, 5, 0, 5));
		
		// Add button
		knightsTotalAdd = new RoundButton("+", headerBGColor, buttonsHoverColor);
		knightsTotalAdd.setBackground(headerBGColor);
		knightsTotalAdd.setForeground(titleFontColor);
		
		// Increment field
		knightsTotalIncrement = new JTextArea(1, 3);
		knightsTotalIncrement.setDocument(new IncrementLimit(3));
		knightsTotalIncrement.setBackground(headerBGColor);
		knightsTotalIncrement.setForeground(titleFontColor);
		knightsTotalIncrement.setCaretColor(titleFontColor);
		knightsTotalIncrement.setBorder(new EmptyBorder(0, 9, 0, 0));
		
		createModifyButtonsPanel(knights, knightsTotalModifyPanel, knightsTotalModify, knightsTotalAdd, knightsTotalIncrement);
		
		// Rarity buttons panel
		knightsRarityButtonsPanel = new JPanel();
		
		// Common button
		knightsCommonButtonPanel = new JPanel(new GridBagLayout());
		knightsCommonButton = new IconButton(new ImageIcon(commonButtonIcon), new ImageIcon(commonButtonHoverIcon));
		
		// Rare button
		knightsRareButtonPanel = new JPanel(new GridBagLayout());
		knightsRareButton = new IconButton(new ImageIcon(rareButtonIcon), new ImageIcon(rareButtonHoverIcon));
		
		// Epic button
		knightsEpicButtonPanel = new JPanel(new GridBagLayout());
		knightsEpicButton = new IconButton(new ImageIcon(epicButtonIcon), new ImageIcon(epicButtonHoverIcon));
		
		// Legendary button
		knightsLegendaryButtonPanel = new JPanel(new GridBagLayout());
		knightsLegendaryButton = new IconButton(new ImageIcon(legendaryButtonIcon), new ImageIcon(legendaryButtonHoverIcon));
		
		createRarityButtonsPanel(knights, knightsRarityButtonsPanel, 
				knightsCommonButtonPanel, knightsCommonButton, knightsRareButtonPanel, knightsRareButton, 
				knightsEpicButtonPanel, knightsEpicButton, knightsLegendaryButtonPanel, knightsLegendaryButton);
		
		knightsTotalPanel.add(totalPanelTitleLabel);
		knightsTotalPanel.add(knightsTotalCounterText);
		knightsTotalPanel.add(knightsTotalModifyPanel);
		knightsTotalPanel.add(knightsRarityButtonsPanel);
		
		knights.add(knightsImagePanel);
		knights.add(knightsEpicPanel);
		knights.add(knightsLegendaryPanel);
		knights.add(knightsTotalPanel);
	}
	
	// "Journey to Un'Goro" panel creator
	private void createJourneyToUngoroPanel() 
	{
		// "Journey to Un'Goro" panel
		ungoro = new JPanel();
		ungoro.setBackground(ungoroColor);
		ungoro.setLayout(new GridLayout(1, 4, 10, 0));
		ungoro.setBorder(new EmptyBorder(10, 10, 10, 10));
		
		// "Journey to Un'Goro" logo
		ungoroImagePanel = new JPanel(new GridBagLayout());
		ungoroImagePanel.setBackground(ungoro.getBackground());
		
		ungoroImageButton = new JButton(new ImageIcon(ungoroImage));
		ungoroImageButton.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 0));
		ungoroImageButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		ungoroImageButton.setToolTipText(imageButtonToolTipText);
		ungoroImageButton.setContentAreaFilled(false);
		ungoroImageButton.setFocusPainted(false);
		
		ungoroImagePanel.add(ungoroImageButton);
		
		// Packs without epic counter panel
		ungoroEpicPanel = new JPanel();
		ungoroEpicPanel.setBackground(ungoro.getBackground());
		ungoroEpicPanel.setLayout(new GridLayout(4, 1));
		
		// Packs without epic counter panel title
		epicPanelTitleLabel = new JTextPane();
		doc = epicPanelTitleLabel.getStyledDocument();
		changePanelTitleStyle(ungoro, epicPanelTitleLabel, epicPanelTitle);
		
		// Packs without epic counter
		ungoroEpicCounterText = new JTextPane();
		doc = ungoroEpicCounterText.getStyledDocument();
		changePanelTextStyle(ungoro, ungoroEpicCounterText, epicCounterText, ungoroEpicCounter);
		
		// Packs without epic counter modify buttons panel
		ungoroEpicModifyPanel = new JPanel();
		
		// Reset button
		ungoroEpicReset = new ModifierButton("Reset", headerBGColor, buttonsHoverColor);
		ungoroEpicReset.setToolTipText(resetButtonToolTipText);
		ungoroEpicReset.setBackground(headerBGColor);
		ungoroEpicReset.setForeground(titleFontColor);
		
		// Blank space between reset and add buttons
		blank = new JLabel();
		blank.setBackground(ungoro.getBackground());
		blank.setBorder(new EmptyBorder(0, 20, 0, 20));
		
		// Add button
		ungoroEpicAdd = new RoundButton("+", headerBGColor, buttonsHoverColor);
		ungoroEpicAdd.setBackground(headerBGColor);
		ungoroEpicAdd.setForeground(titleFontColor);
		
		// Increment field
		ungoroEpicIncrement = new JTextArea(1, 1);
		ungoroEpicIncrement.setDocument(new IncrementLimit(1));
		ungoroEpicIncrement.setBackground(headerBGColor);
		ungoroEpicIncrement.setForeground(titleFontColor);
		ungoroEpicIncrement.setCaretColor(titleFontColor);
		ungoroEpicIncrement.setBorder(new EmptyBorder(0, 9, 0, 6));
		
		createModifyButtonsPanel(ungoro, ungoroEpicModifyPanel, ungoroEpicReset, ungoroEpicAdd, ungoroEpicIncrement);
		
		// Probability of finding an epic calculator
		ungoroEpicProbabilityText = new JTextPane();
		doc = ungoroEpicProbabilityText.getStyledDocument();
		changePanelTextStyle(ungoro, ungoroEpicProbabilityText, epicProbabilityText, ungoroEpicProbability);
		
		ungoroEpicPanel.add(epicPanelTitleLabel);
		ungoroEpicPanel.add(ungoroEpicCounterText);
		ungoroEpicPanel.add(ungoroEpicModifyPanel);
		ungoroEpicPanel.add(ungoroEpicProbabilityText);
		
		// Packs without legendary counter panel
		ungoroLegendaryPanel = new JPanel();
		ungoroLegendaryPanel.setBackground(ungoro.getBackground());
		ungoroLegendaryPanel.setLayout(new GridLayout(4, 1));
		
		// Packs without legendary counter panel title
		legendaryPanelTitleLabel = new JTextPane();
		doc = legendaryPanelTitleLabel.getStyledDocument();
		changePanelTitleStyle(ungoro, legendaryPanelTitleLabel, legendaryPanelTitle);
		
		// Packs without legendary counter
		ungoroLegendaryCounterText = new JTextPane();
		doc = ungoroLegendaryCounterText.getStyledDocument();
		changePanelTextStyle(ungoro, ungoroLegendaryCounterText, legendaryCounterText, ungoroLegendaryCounter);
		
		// Packs without legendary counter modify buttons panel
		ungoroLegendaryModifyPanel = new JPanel();
		
		// Reset button
		ungoroLegendaryReset = new ModifierButton("Reset", headerBGColor, buttonsHoverColor);
		ungoroLegendaryReset.setToolTipText(resetButtonToolTipText);
		ungoroLegendaryReset.setBackground(headerBGColor);
		ungoroLegendaryReset.setForeground(titleFontColor);
		
		// Blank space between reset and add buttons
		blank = new JLabel();
		blank.setBackground(ungoro.getBackground());
		blank.setBorder(new EmptyBorder(0, 20, 0, 20));
		
		// Add button
		ungoroLegendaryAdd = new RoundButton("+", headerBGColor, buttonsHoverColor);
		ungoroLegendaryAdd.setBackground(headerBGColor);
		ungoroLegendaryAdd.setForeground(titleFontColor);
		
		// Increment field
		ungoroLegendaryIncrement = new JTextArea(1, 2);
		ungoroLegendaryIncrement.setDocument(new IncrementLimit(2));
		ungoroLegendaryIncrement.setBackground(headerBGColor);
		ungoroLegendaryIncrement.setForeground(titleFontColor);
		ungoroLegendaryIncrement.setCaretColor(titleFontColor);
		ungoroLegendaryIncrement.setBorder(new EmptyBorder(0, 9, 0, 3));
		
		createModifyButtonsPanel(ungoro, ungoroLegendaryModifyPanel, ungoroLegendaryReset, ungoroLegendaryAdd, ungoroLegendaryIncrement);
		
		// Probability of finding a legendary calculator
		ungoroLegendaryProbabilityText = new JTextPane();
		doc = ungoroLegendaryProbabilityText.getStyledDocument();
		changePanelTextStyle(ungoro, ungoroLegendaryProbabilityText, legendaryProbabilityText, ungoroLegendaryProbability);
		
		ungoroLegendaryPanel.add(legendaryPanelTitleLabel);
		ungoroLegendaryPanel.add(ungoroLegendaryCounterText);
		ungoroLegendaryPanel.add(ungoroLegendaryModifyPanel);
		ungoroLegendaryPanel.add(ungoroLegendaryProbabilityText);
		
		// Total amount of packs opened counter panel
		ungoroTotalPanel = new JPanel();
		ungoroTotalPanel.setBackground(ungoro.getBackground());
		ungoroTotalPanel.setLayout(new GridLayout(4, 1));
		
		// Total amount of packs opened counter panel title
		totalPanelTitleLabel = new JTextPane();
		doc = totalPanelTitleLabel.getStyledDocument();
		changePanelTitleStyle(ungoro, totalPanelTitleLabel,totalPanelTitle);
		
		// Total amount of packs opened counter
		ungoroTotalCounterText = new JTextPane();
		doc = ungoroTotalCounterText.getStyledDocument();
		changePanelTextStyle(ungoro, ungoroTotalCounterText, totalCounterText, ungoroTotalCounter);
		
		// Total amount of packs opened modify buttons panel
		ungoroTotalModifyPanel = new JPanel();
		
		// Modify button
		ungoroTotalModify = new ModifierButton("Modify", headerBGColor, buttonsHoverColor);
		ungoroTotalModify.setToolTipText(modifyButtonToolTipText);
		ungoroTotalModify.setBackground(headerBGColor);
		ungoroTotalModify.setForeground(titleFontColor);
		
		// Blank space between modify and add buttons
		blank = new JLabel();
		blank.setBackground(ungoro.getBackground());
		blank.setBorder(new EmptyBorder(0, 5, 0, 5));
		
		// Add button
		ungoroTotalAdd = new RoundButton("+", headerBGColor, buttonsHoverColor);
		ungoroTotalAdd.setBackground(headerBGColor);
		ungoroTotalAdd.setForeground(titleFontColor);
		
		// Increment field
		ungoroTotalIncrement = new JTextArea(1, 3);
		ungoroTotalIncrement.setDocument(new IncrementLimit(3));
		ungoroTotalIncrement.setBackground(headerBGColor);
		ungoroTotalIncrement.setForeground(titleFontColor);
		ungoroTotalIncrement.setCaretColor(titleFontColor);
		ungoroTotalIncrement.setBorder(new EmptyBorder(0, 9, 0, 0));
		
		createModifyButtonsPanel(ungoro, ungoroTotalModifyPanel, ungoroTotalModify, ungoroTotalAdd, ungoroTotalIncrement);
		
		// Rarity buttons panel
		ungoroRarityButtonsPanel = new JPanel();
		
		// Common button
		ungoroCommonButtonPanel = new JPanel(new GridBagLayout());
		ungoroCommonButton = new IconButton(new ImageIcon(commonButtonIcon), new ImageIcon(commonButtonHoverIcon));
		
		// Rare button
		ungoroRareButtonPanel = new JPanel(new GridBagLayout());
		ungoroRareButton = new IconButton(new ImageIcon(rareButtonIcon), new ImageIcon(rareButtonHoverIcon));
		
		// Epic button
		ungoroEpicButtonPanel = new JPanel(new GridBagLayout());
		ungoroEpicButton = new IconButton(new ImageIcon(epicButtonIcon), new ImageIcon(epicButtonHoverIcon));
		
		// Legendary button
		ungoroLegendaryButtonPanel = new JPanel(new GridBagLayout());
		ungoroLegendaryButton = new IconButton(new ImageIcon(legendaryButtonIcon), new ImageIcon(legendaryButtonHoverIcon));
		
		createRarityButtonsPanel(ungoro, ungoroRarityButtonsPanel, 
				ungoroCommonButtonPanel, ungoroCommonButton, ungoroRareButtonPanel, ungoroRareButton, 
				ungoroEpicButtonPanel, ungoroEpicButton, ungoroLegendaryButtonPanel, ungoroLegendaryButton);
		
		ungoroTotalPanel.add(totalPanelTitleLabel);
		ungoroTotalPanel.add(ungoroTotalCounterText);
		ungoroTotalPanel.add(ungoroTotalModifyPanel);
		ungoroTotalPanel.add(ungoroRarityButtonsPanel);
		
		ungoro.add(ungoroImagePanel);
		ungoro.add(ungoroEpicPanel);
		ungoro.add(ungoroLegendaryPanel);
		ungoro.add(ungoroTotalPanel);
	}
	
	// "Year of the Kraken" panel creator
	private void createYearOfTheKrakenPanel() 
	{
		// "Year of the Kraken" panel
		kraken = new JPanel();
		kraken.setLayout(new BoxLayout(kraken, BoxLayout.Y_AXIS));
		
		// "Year of the Kraken" title header
		krakenHeader = new JPanel(new FlowLayout(FlowLayout.LEFT));
		krakenHeader.setBackground(yearsColor);
		
		krakenImageLabel = new JLabel(new ImageIcon(krakenImage));
		krakenImageLabel.setBorder(new EmptyBorder(5, 5, 5, 5));
		
		krakenLabel = new JLabel(krakenTitle);
		krakenLabel.setFont(yearsFont);
		krakenLabel.setBorder(new EmptyBorder(5, 25, 5, 5));
		
		krakenHeader.add(krakenImageLabel);
		krakenHeader.add(krakenLabel);
				
		// "Year of the Kraken" expansions
		createMeanStreetsOfGadgetzanPanel();
		createWhispersOfTheOldGodsPanel();
		
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				kraken.add(krakenHeader);
				kraken.add(gadgetzan);
				kraken.add(oldGods);
				
				kraken.setVisible(false);
			}
		});
	}
	
	// "Mean Streets of Gadgetzan" panel creator
	private void createMeanStreetsOfGadgetzanPanel() 
	{
		// "Mean Streets of Gadgetzan" panel
		gadgetzan = new JPanel();
		gadgetzan.setBackground(gadgetzanColor);
		gadgetzan.setLayout(new GridLayout(1, 4, 10, 0));
		gadgetzan.setBorder(new EmptyBorder(10, 10, 10, 10));
		
		// "Mean Streets of Gadgetzan" logo
		gadgetzanImagePanel = new JPanel(new GridBagLayout());
		gadgetzanImagePanel.setBackground(gadgetzan.getBackground());
		
		gadgetzanImageButton = new JButton(new ImageIcon(gadgetzanImage));
		gadgetzanImageButton.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 0));
		gadgetzanImageButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		gadgetzanImageButton.setToolTipText(imageButtonToolTipText);
		gadgetzanImageButton.setContentAreaFilled(false);
		gadgetzanImageButton.setFocusPainted(false);
		
		gadgetzanImagePanel.add(gadgetzanImageButton);
		
		// Packs without epic counter panel
		gadgetzanEpicPanel = new JPanel();
		gadgetzanEpicPanel.setBackground(gadgetzan.getBackground());
		gadgetzanEpicPanel.setLayout(new GridLayout(4, 1));
		
		// Packs without epic counter panel title
		epicPanelTitleLabel = new JTextPane();
		doc = epicPanelTitleLabel.getStyledDocument();
		changePanelTitleStyle(gadgetzan, epicPanelTitleLabel, epicPanelTitle);
		
		// Packs without epic counter
		gadgetzanEpicCounterText = new JTextPane();
		doc = gadgetzanEpicCounterText.getStyledDocument();
		changePanelTextStyle(gadgetzan, gadgetzanEpicCounterText, epicCounterText, gadgetzanEpicCounter);
		
		// Packs without epic counter modify buttons panel
		gadgetzanEpicModifyPanel = new JPanel();
		
		// Reset button
		gadgetzanEpicReset = new ModifierButton("Reset", headerBGColor, buttonsHoverColor);
		gadgetzanEpicReset.setToolTipText(resetButtonToolTipText);
		gadgetzanEpicReset.setBackground(headerBGColor);
		gadgetzanEpicReset.setForeground(titleFontColor);
		
		// Blank space between reset and add buttons
		blank = new JLabel();
		blank.setBackground(gadgetzan.getBackground());
		blank.setBorder(new EmptyBorder(0, 20, 0, 20));
		
		// Add button
		gadgetzanEpicAdd = new RoundButton("+", headerBGColor, buttonsHoverColor);
		gadgetzanEpicAdd.setBackground(headerBGColor);
		gadgetzanEpicAdd.setForeground(titleFontColor);
		
		// Increment field
		gadgetzanEpicIncrement = new JTextArea(1, 1);
		gadgetzanEpicIncrement.setDocument(new IncrementLimit(1));
		gadgetzanEpicIncrement.setBackground(headerBGColor);
		gadgetzanEpicIncrement.setForeground(titleFontColor);
		gadgetzanEpicIncrement.setCaretColor(titleFontColor);
		gadgetzanEpicIncrement.setBorder(new EmptyBorder(0, 9, 0, 6));
		
		createModifyButtonsPanel(gadgetzan, gadgetzanEpicModifyPanel, gadgetzanEpicReset, gadgetzanEpicAdd, gadgetzanEpicIncrement);
		
		// Probability of finding an epic calculator
		gadgetzanEpicProbabilityText = new JTextPane();
		doc = gadgetzanEpicProbabilityText.getStyledDocument();
		changePanelTextStyle(gadgetzan, gadgetzanEpicProbabilityText, epicProbabilityText, gadgetzanEpicProbability);
		
		gadgetzanEpicPanel.add(epicPanelTitleLabel);
		gadgetzanEpicPanel.add(gadgetzanEpicCounterText);
		gadgetzanEpicPanel.add(gadgetzanEpicModifyPanel);
		gadgetzanEpicPanel.add(gadgetzanEpicProbabilityText);
		
		// Packs without legendary counter panel
		gadgetzanLegendaryPanel = new JPanel();
		gadgetzanLegendaryPanel.setBackground(gadgetzan.getBackground());
		gadgetzanLegendaryPanel.setLayout(new GridLayout(4, 1));
		
		// Packs without legendary counter panel title
		legendaryPanelTitleLabel = new JTextPane();
		doc = legendaryPanelTitleLabel.getStyledDocument();
		changePanelTitleStyle(gadgetzan, legendaryPanelTitleLabel, legendaryPanelTitle);
		
		// Packs without legendary counter
		gadgetzanLegendaryCounterText = new JTextPane();
		doc = gadgetzanLegendaryCounterText.getStyledDocument();
		changePanelTextStyle(gadgetzan, gadgetzanLegendaryCounterText, legendaryCounterText, gadgetzanLegendaryCounter);
		
		// Packs without legendary counter modify buttons panel
		gadgetzanLegendaryModifyPanel = new JPanel();
		
		// Reset button
		gadgetzanLegendaryReset = new ModifierButton("Reset", headerBGColor, buttonsHoverColor);
		gadgetzanLegendaryReset.setToolTipText(resetButtonToolTipText);
		gadgetzanLegendaryReset.setBackground(headerBGColor);
		gadgetzanLegendaryReset.setForeground(titleFontColor);
		
		// Blank space between reset and add buttons
		blank = new JLabel();
		blank.setBackground(gadgetzan.getBackground());
		blank.setBorder(new EmptyBorder(0, 20, 0, 20));
		
		// Add button
		gadgetzanLegendaryAdd = new RoundButton("+", headerBGColor, buttonsHoverColor);
		gadgetzanLegendaryAdd.setBackground(headerBGColor);
		gadgetzanLegendaryAdd.setForeground(titleFontColor);
		
		// Increment field
		gadgetzanLegendaryIncrement = new JTextArea(1, 2);
		gadgetzanLegendaryIncrement.setDocument(new IncrementLimit(2));
		gadgetzanLegendaryIncrement.setBackground(headerBGColor);
		gadgetzanLegendaryIncrement.setForeground(titleFontColor);
		gadgetzanLegendaryIncrement.setCaretColor(titleFontColor);
		gadgetzanLegendaryIncrement.setBorder(new EmptyBorder(0, 9, 0, 3));
		
		createModifyButtonsPanel(gadgetzan, gadgetzanLegendaryModifyPanel, gadgetzanLegendaryReset, gadgetzanLegendaryAdd, gadgetzanLegendaryIncrement);
		
		// Probability of finding a legendary calculator
		gadgetzanLegendaryProbabilityText = new JTextPane();
		doc = gadgetzanLegendaryProbabilityText.getStyledDocument();
		changePanelTextStyle(gadgetzan, gadgetzanLegendaryProbabilityText, legendaryProbabilityText, gadgetzanLegendaryProbability);
		
		gadgetzanLegendaryPanel.add(legendaryPanelTitleLabel);
		gadgetzanLegendaryPanel.add(gadgetzanLegendaryCounterText);
		gadgetzanLegendaryPanel.add(gadgetzanLegendaryModifyPanel);
		gadgetzanLegendaryPanel.add(gadgetzanLegendaryProbabilityText);
		
		// Total amount of packs opened counter panel
		gadgetzanTotalPanel = new JPanel();
		gadgetzanTotalPanel.setBackground(gadgetzan.getBackground());
		gadgetzanTotalPanel.setLayout(new GridLayout(4, 1));
		
		// Total amount of packs opened counter panel title
		totalPanelTitleLabel = new JTextPane();
		doc = totalPanelTitleLabel.getStyledDocument();
		changePanelTitleStyle(gadgetzan, totalPanelTitleLabel,totalPanelTitle);
		
		// Total amount of packs opened counter
		gadgetzanTotalCounterText = new JTextPane();
		doc = gadgetzanTotalCounterText.getStyledDocument();
		changePanelTextStyle(gadgetzan, gadgetzanTotalCounterText, totalCounterText, gadgetzanTotalCounter);
		
		// Total amount of packs opened modify buttons panel
		gadgetzanTotalModifyPanel = new JPanel();
		
		// Modify button
		gadgetzanTotalModify = new ModifierButton("Modify", headerBGColor, buttonsHoverColor);
		gadgetzanTotalModify.setToolTipText(modifyButtonToolTipText);
		gadgetzanTotalModify.setBackground(headerBGColor);
		gadgetzanTotalModify.setForeground(titleFontColor);
		
		// Blank space between modify and add buttons
		blank = new JLabel();
		blank.setBackground(gadgetzan.getBackground());
		blank.setBorder(new EmptyBorder(0, 5, 0, 5));
		
		// Add button
		gadgetzanTotalAdd = new RoundButton("+", headerBGColor, buttonsHoverColor);
		gadgetzanTotalAdd.setBackground(headerBGColor);
		gadgetzanTotalAdd.setForeground(titleFontColor);
		
		// Increment field
		gadgetzanTotalIncrement = new JTextArea(1, 3);
		gadgetzanTotalIncrement.setDocument(new IncrementLimit(3));
		gadgetzanTotalIncrement.setBackground(headerBGColor);
		gadgetzanTotalIncrement.setForeground(titleFontColor);
		gadgetzanTotalIncrement.setCaretColor(titleFontColor);
		gadgetzanTotalIncrement.setBorder(new EmptyBorder(0, 9, 0, 0));
		
		createModifyButtonsPanel(gadgetzan, gadgetzanTotalModifyPanel, gadgetzanTotalModify, gadgetzanTotalAdd, gadgetzanTotalIncrement);
		
		// Rarity buttons panel
		gadgetzanRarityButtonsPanel = new JPanel();
		
		// Common button
		gadgetzanCommonButtonPanel = new JPanel(new GridBagLayout());
		gadgetzanCommonButton = new IconButton(new ImageIcon(commonButtonIcon), new ImageIcon(commonButtonHoverIcon));
		
		// Rare button
		gadgetzanRareButtonPanel = new JPanel(new GridBagLayout());
		gadgetzanRareButton = new IconButton(new ImageIcon(rareButtonIcon), new ImageIcon(rareButtonHoverIcon));
		
		// Epic button
		gadgetzanEpicButtonPanel = new JPanel(new GridBagLayout());
		gadgetzanEpicButton = new IconButton(new ImageIcon(epicButtonIcon), new ImageIcon(epicButtonHoverIcon));
		
		// Legendary button
		gadgetzanLegendaryButtonPanel = new JPanel(new GridBagLayout());
		gadgetzanLegendaryButton = new IconButton(new ImageIcon(legendaryButtonIcon), new ImageIcon(legendaryButtonHoverIcon));
		
		createRarityButtonsPanel(gadgetzan, gadgetzanRarityButtonsPanel, 
				gadgetzanCommonButtonPanel, gadgetzanCommonButton, gadgetzanRareButtonPanel, gadgetzanRareButton, 
				gadgetzanEpicButtonPanel, gadgetzanEpicButton, gadgetzanLegendaryButtonPanel, gadgetzanLegendaryButton);
		
		gadgetzanTotalPanel.add(totalPanelTitleLabel);
		gadgetzanTotalPanel.add(gadgetzanTotalCounterText);
		gadgetzanTotalPanel.add(gadgetzanTotalModifyPanel);
		gadgetzanTotalPanel.add(gadgetzanRarityButtonsPanel);
		
		gadgetzan.add(gadgetzanImagePanel);
		gadgetzan.add(gadgetzanEpicPanel);
		gadgetzan.add(gadgetzanLegendaryPanel);
		gadgetzan.add(gadgetzanTotalPanel);
	}
	
	// "Whispers of the Old Gods" panel creator
	private void createWhispersOfTheOldGodsPanel() 
	{
		// "Whispers of the Old Gods" panel
		oldGods = new JPanel();
		oldGods.setBackground(oldGodsColor);
		oldGods.setLayout(new GridLayout(1, 4, 10, 0));
		oldGods.setBorder(new EmptyBorder(10, 10, 10, 10));
		
		// "Whispers of the Old Gods" logo
		oldGodsImagePanel = new JPanel(new GridBagLayout());
		oldGodsImagePanel.setBackground(oldGods.getBackground());
		
		oldGodsImageButton = new JButton(new ImageIcon(oldGodsImage));
		oldGodsImageButton.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 0));
		oldGodsImageButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		oldGodsImageButton.setToolTipText(imageButtonToolTipText);
		oldGodsImageButton.setContentAreaFilled(false);
		oldGodsImageButton.setFocusPainted(false);
		
		oldGodsImagePanel.add(oldGodsImageButton);
		
		// Packs without epic counter panel
		oldGodsEpicPanel = new JPanel();
		oldGodsEpicPanel.setBackground(oldGods.getBackground());
		oldGodsEpicPanel.setLayout(new GridLayout(4, 1));
		
		// Packs without epic counter panel title
		epicPanelTitleLabel = new JTextPane();
		doc = epicPanelTitleLabel.getStyledDocument();
		changePanelTitleStyle(oldGods, epicPanelTitleLabel, epicPanelTitle);
		
		// Packs without epic counter
		oldGodsEpicCounterText = new JTextPane();
		doc = oldGodsEpicCounterText.getStyledDocument();
		changePanelTextStyle(oldGods, oldGodsEpicCounterText, epicCounterText, oldGodsEpicCounter);
		
		// Packs without epic counter modify buttons panel
		oldGodsEpicModifyPanel = new JPanel();
		
		// Reset button
		oldGodsEpicReset = new ModifierButton("Reset", headerBGColor, buttonsHoverColor);
		oldGodsEpicReset.setToolTipText(resetButtonToolTipText);
		oldGodsEpicReset.setBackground(headerBGColor);
		oldGodsEpicReset.setForeground(titleFontColor);
		
		// Blank space between reset and add buttons
		blank = new JLabel();
		blank.setBackground(oldGods.getBackground());
		blank.setBorder(new EmptyBorder(0, 20, 0, 20));
		
		// Add button
		oldGodsEpicAdd = new RoundButton("+", headerBGColor, buttonsHoverColor);
		oldGodsEpicAdd.setBackground(headerBGColor);
		oldGodsEpicAdd.setForeground(titleFontColor);
		
		// Increment field
		oldGodsEpicIncrement = new JTextArea(1, 1);
		oldGodsEpicIncrement.setDocument(new IncrementLimit(1));
		oldGodsEpicIncrement.setBackground(headerBGColor);
		oldGodsEpicIncrement.setForeground(titleFontColor);
		oldGodsEpicIncrement.setCaretColor(titleFontColor);
		oldGodsEpicIncrement.setBorder(new EmptyBorder(0, 9, 0, 6));
		
		createModifyButtonsPanel(oldGods, oldGodsEpicModifyPanel, oldGodsEpicReset, oldGodsEpicAdd, oldGodsEpicIncrement);
		
		// Probability of finding an epic calculator
		oldGodsEpicProbabilityText = new JTextPane();
		doc = oldGodsEpicProbabilityText.getStyledDocument();
		changePanelTextStyle(oldGods, oldGodsEpicProbabilityText, epicProbabilityText, oldGodsEpicProbability);
		
		oldGodsEpicPanel.add(epicPanelTitleLabel);
		oldGodsEpicPanel.add(oldGodsEpicCounterText);
		oldGodsEpicPanel.add(oldGodsEpicModifyPanel);
		oldGodsEpicPanel.add(oldGodsEpicProbabilityText);
		
		// Packs without legendary counter panel
		oldGodsLegendaryPanel = new JPanel();
		oldGodsLegendaryPanel.setBackground(oldGods.getBackground());
		oldGodsLegendaryPanel.setLayout(new GridLayout(4, 1));
		
		// Packs without legendary counter panel title
		legendaryPanelTitleLabel = new JTextPane();
		doc = legendaryPanelTitleLabel.getStyledDocument();
		changePanelTitleStyle(oldGods, legendaryPanelTitleLabel, legendaryPanelTitle);
		
		// Packs without legendary counter
		oldGodsLegendaryCounterText = new JTextPane();
		doc = oldGodsLegendaryCounterText.getStyledDocument();
		changePanelTextStyle(oldGods, oldGodsLegendaryCounterText, legendaryCounterText, oldGodsLegendaryCounter);
		
		// Packs without legendary counter modify buttons panel
		oldGodsLegendaryModifyPanel = new JPanel();
		
		// Reset button
		oldGodsLegendaryReset = new ModifierButton("Reset", headerBGColor, buttonsHoverColor);
		oldGodsLegendaryReset.setToolTipText(resetButtonToolTipText);
		oldGodsLegendaryReset.setBackground(headerBGColor);
		oldGodsLegendaryReset.setForeground(titleFontColor);
		
		// Blank space between reset and add buttons
		blank = new JLabel();
		blank.setBackground(oldGods.getBackground());
		blank.setBorder(new EmptyBorder(0, 20, 0, 20));
		
		// Add button
		oldGodsLegendaryAdd = new RoundButton("+", headerBGColor, buttonsHoverColor);
		oldGodsLegendaryAdd.setBackground(headerBGColor);
		oldGodsLegendaryAdd.setForeground(titleFontColor);
		
		// Increment field
		oldGodsLegendaryIncrement = new JTextArea(1, 2);
		oldGodsLegendaryIncrement.setDocument(new IncrementLimit(2));
		oldGodsLegendaryIncrement.setBackground(headerBGColor);
		oldGodsLegendaryIncrement.setForeground(titleFontColor);
		oldGodsLegendaryIncrement.setCaretColor(titleFontColor);
		oldGodsLegendaryIncrement.setBorder(new EmptyBorder(0, 9, 0, 3));
		
		createModifyButtonsPanel(oldGods, oldGodsLegendaryModifyPanel, oldGodsLegendaryReset, oldGodsLegendaryAdd, oldGodsLegendaryIncrement);
		
		// Probability of finding a legendary calculator
		oldGodsLegendaryProbabilityText = new JTextPane();
		doc = oldGodsLegendaryProbabilityText.getStyledDocument();
		changePanelTextStyle(oldGods, oldGodsLegendaryProbabilityText, legendaryProbabilityText, oldGodsLegendaryProbability);
		
		oldGodsLegendaryPanel.add(legendaryPanelTitleLabel);
		oldGodsLegendaryPanel.add(oldGodsLegendaryCounterText);
		oldGodsLegendaryPanel.add(oldGodsLegendaryModifyPanel);
		oldGodsLegendaryPanel.add(oldGodsLegendaryProbabilityText);
		
		// Total amount of packs opened counter panel
		oldGodsTotalPanel = new JPanel();
		oldGodsTotalPanel.setBackground(oldGods.getBackground());
		oldGodsTotalPanel.setLayout(new GridLayout(4, 1));
		
		// Total amount of packs opened counter panel title
		totalPanelTitleLabel = new JTextPane();
		doc = totalPanelTitleLabel.getStyledDocument();
		changePanelTitleStyle(oldGods, totalPanelTitleLabel,totalPanelTitle);
		
		// Total amount of packs opened counter
		oldGodsTotalCounterText = new JTextPane();
		doc = oldGodsTotalCounterText.getStyledDocument();
		changePanelTextStyle(oldGods, oldGodsTotalCounterText, totalCounterText, oldGodsTotalCounter);
		
		// Total amount of packs opened modify buttons panel
		oldGodsTotalModifyPanel = new JPanel();
		
		// Modify button
		oldGodsTotalModify = new ModifierButton("Modify", headerBGColor, buttonsHoverColor);
		oldGodsTotalModify.setToolTipText(modifyButtonToolTipText);
		oldGodsTotalModify.setBackground(headerBGColor);
		oldGodsTotalModify.setForeground(titleFontColor);
		
		// Blank space between modify and add buttons
		blank = new JLabel();
		blank.setBackground(oldGods.getBackground());
		blank.setBorder(new EmptyBorder(0, 5, 0, 5));
		
		// Add button
		oldGodsTotalAdd = new RoundButton("+", headerBGColor, buttonsHoverColor);
		oldGodsTotalAdd.setBackground(headerBGColor);
		oldGodsTotalAdd.setForeground(titleFontColor);
		
		// Increment field
		oldGodsTotalIncrement = new JTextArea(1, 3);
		oldGodsTotalIncrement.setDocument(new IncrementLimit(3));
		oldGodsTotalIncrement.setBackground(headerBGColor);
		oldGodsTotalIncrement.setForeground(titleFontColor);
		oldGodsTotalIncrement.setCaretColor(titleFontColor);
		oldGodsTotalIncrement.setBorder(new EmptyBorder(0, 9, 0, 0));
		
		createModifyButtonsPanel(oldGods, oldGodsTotalModifyPanel, oldGodsTotalModify, oldGodsTotalAdd, oldGodsTotalIncrement);
		
		// Rarity buttons panel
		oldGodsRarityButtonsPanel = new JPanel();
		
		// Common button
		oldGodsCommonButtonPanel = new JPanel(new GridBagLayout());
		oldGodsCommonButton = new IconButton(new ImageIcon(commonButtonIcon), new ImageIcon(commonButtonHoverIcon));
		
		// Rare button
		oldGodsRareButtonPanel = new JPanel(new GridBagLayout());
		oldGodsRareButton = new IconButton(new ImageIcon(rareButtonIcon), new ImageIcon(rareButtonHoverIcon));
		
		// Epic button
		oldGodsEpicButtonPanel = new JPanel(new GridBagLayout());
		oldGodsEpicButton = new IconButton(new ImageIcon(epicButtonIcon), new ImageIcon(epicButtonHoverIcon));
		
		// Legendary button
		oldGodsLegendaryButtonPanel = new JPanel(new GridBagLayout());
		oldGodsLegendaryButton = new IconButton(new ImageIcon(legendaryButtonIcon), new ImageIcon(legendaryButtonHoverIcon));
		
		createRarityButtonsPanel(oldGods, oldGodsRarityButtonsPanel, 
				oldGodsCommonButtonPanel, oldGodsCommonButton, oldGodsRareButtonPanel, oldGodsRareButton, 
				oldGodsEpicButtonPanel, oldGodsEpicButton, oldGodsLegendaryButtonPanel, oldGodsLegendaryButton);
		
		oldGodsTotalPanel.add(totalPanelTitleLabel);
		oldGodsTotalPanel.add(oldGodsTotalCounterText);
		oldGodsTotalPanel.add(oldGodsTotalModifyPanel);
		oldGodsTotalPanel.add(oldGodsRarityButtonsPanel);
		
		oldGods.add(oldGodsImagePanel);
		oldGods.add(oldGodsEpicPanel);
		oldGods.add(oldGodsLegendaryPanel);
		oldGods.add(oldGodsTotalPanel);
	}
	
	// "Classic Sets" panel creator
	private void createClassicSetsPanel() 
	{
		// "Classic Sets" panel
		classicSets = new JPanel();
		classicSets.setLayout(new BoxLayout(classicSets, BoxLayout.Y_AXIS));
		
		// "Classic Sets" title header
		classicSetsHeader = new JPanel(new FlowLayout(FlowLayout.LEFT));
		classicSetsHeader.setBackground(yearsColor);
		
		classicSetsImageLabel = new JLabel(new ImageIcon(classicSetsImage));
		classicSetsImageLabel.setBorder(new EmptyBorder(5, 5, 5, 5));
		
		classicSetsLabel = new JLabel(classicSetsTitle);
		classicSetsLabel.setFont(yearsFont);
		classicSetsLabel.setBorder(new EmptyBorder(5, 25, 5, 5));
		
		classicSetsHeader.add(classicSetsImageLabel);
		classicSetsHeader.add(classicSetsLabel);
				
		// "Classic Sets" expansions
		createTheGrandTournamentPanel();
		createGoblinsVsGnomesPanel();
		
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				classicSets.add(classicSetsHeader);
				classicSets.add(tournament);
				classicSets.add(goblins);
				
				classicSets.setVisible(false);
			}
		});
	}
	
	// "The Grand Tournament" panel creator
	private void createTheGrandTournamentPanel() 
	{
		// "The Grand Tournament" panel
		tournament = new JPanel();
		tournament.setBackground(tournamentColor);
		tournament.setLayout(new GridLayout(1, 4, 10, 0));
		tournament.setBorder(new EmptyBorder(10, 10, 10, 10));
		
		// "The Grand Tournament" logo
		tournamentImagePanel = new JPanel(new GridBagLayout());
		tournamentImagePanel.setBackground(tournament.getBackground());
		
		tournamentImageButton = new JButton(new ImageIcon(tournamentImage));
		tournamentImageButton.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 0));
		tournamentImageButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		tournamentImageButton.setToolTipText(imageButtonToolTipText);
		tournamentImageButton.setContentAreaFilled(false);
		tournamentImageButton.setFocusPainted(false);
		
		tournamentImagePanel.add(tournamentImageButton);
		
		// Packs without epic counter panel
		tournamentEpicPanel = new JPanel();
		tournamentEpicPanel.setBackground(tournament.getBackground());
		tournamentEpicPanel.setLayout(new GridLayout(4, 1));
		
		// Packs without epic counter panel title
		epicPanelTitleLabel = new JTextPane();
		doc = epicPanelTitleLabel.getStyledDocument();
		changePanelTitleStyle(tournament, epicPanelTitleLabel, epicPanelTitle);
		epicPanelTitleLabel.setForeground(titleFontColor);
		
		// Packs without epic counter
		tournamentEpicCounterText = new JTextPane();
		doc = tournamentEpicCounterText.getStyledDocument();
		changePanelTextStyle(tournament, tournamentEpicCounterText, epicCounterText, tournamentEpicCounter);
		tournamentEpicCounterText.setForeground(titleFontColor);
		
		// Packs without epic counter modify buttons panel
		tournamentEpicModifyPanel = new JPanel();
		
		// Reset button
		tournamentEpicReset = new ModifierButton("Reset", titleFontColor, buttonsDarkHoverColor);
		tournamentEpicReset.setToolTipText(resetButtonToolTipText);
		tournamentEpicReset.setBackground(titleFontColor);
		tournamentEpicReset.setForeground(headerBGColor);
		
		// Blank space between reset and add buttons
		blank = new JLabel();
		blank.setBackground(tournament.getBackground());
		blank.setBorder(new EmptyBorder(0, 20, 0, 20));
		
		// Add button
		tournamentEpicAdd = new RoundButton("+", titleFontColor, buttonsDarkHoverColor);
		tournamentEpicAdd.setBackground(titleFontColor);
		tournamentEpicAdd.setForeground(headerBGColor);
		
		// Increment field
		tournamentEpicIncrement = new JTextArea(1, 1);
		tournamentEpicIncrement.setDocument(new IncrementLimit(1));
		tournamentEpicIncrement.setBackground(titleFontColor);
		tournamentEpicIncrement.setForeground(headerBGColor);
		tournamentEpicIncrement.setCaretColor(headerBGColor);
		tournamentEpicIncrement.setBorder(new EmptyBorder(0, 9, 0, 6));
		
		createModifyButtonsPanel(tournament, tournamentEpicModifyPanel, tournamentEpicReset, tournamentEpicAdd, tournamentEpicIncrement);
		
		// Probability of finding an epic calculator
		tournamentEpicProbabilityText = new JTextPane();
		doc = tournamentEpicProbabilityText.getStyledDocument();
		changePanelTextStyle(tournament, tournamentEpicProbabilityText, epicProbabilityText, tournamentEpicProbability);
		tournamentEpicProbabilityText.setForeground(titleFontColor);
		
		tournamentEpicPanel.add(epicPanelTitleLabel);
		tournamentEpicPanel.add(tournamentEpicCounterText);
		tournamentEpicPanel.add(tournamentEpicModifyPanel);
		tournamentEpicPanel.add(tournamentEpicProbabilityText);
		
		// Packs without legendary counter panel
		tournamentLegendaryPanel = new JPanel();
		tournamentLegendaryPanel.setBackground(tournament.getBackground());
		tournamentLegendaryPanel.setLayout(new GridLayout(4, 1));
		
		// Packs without legendary counter panel title
		legendaryPanelTitleLabel = new JTextPane();
		doc = legendaryPanelTitleLabel.getStyledDocument();
		changePanelTitleStyle(tournament, legendaryPanelTitleLabel, legendaryPanelTitle);
		legendaryPanelTitleLabel.setForeground(titleFontColor);
		
		// Packs without legendary counter
		tournamentLegendaryCounterText = new JTextPane();
		doc = tournamentLegendaryCounterText.getStyledDocument();
		changePanelTextStyle(tournament, tournamentLegendaryCounterText, legendaryCounterText, tournamentLegendaryCounter);
		tournamentLegendaryCounterText.setForeground(titleFontColor);
		
		// Packs without legendary counter modify buttons panel
		tournamentLegendaryModifyPanel = new JPanel();
		
		// Reset button
		tournamentLegendaryReset = new ModifierButton("Reset", titleFontColor, buttonsDarkHoverColor);
		tournamentLegendaryReset.setToolTipText(resetButtonToolTipText);
		tournamentLegendaryReset.setBackground(titleFontColor);
		tournamentLegendaryReset.setForeground(headerBGColor);
		
		// Blank space between reset and add buttons
		blank = new JLabel();
		blank.setBackground(tournament.getBackground());
		blank.setBorder(new EmptyBorder(0, 20, 0, 20));
		
		// Add button
		tournamentLegendaryAdd = new RoundButton("+", titleFontColor, buttonsDarkHoverColor);
		tournamentLegendaryAdd.setBackground(titleFontColor);
		tournamentLegendaryAdd.setForeground(headerBGColor);
		
		// Increment field
		tournamentLegendaryIncrement = new JTextArea(1, 2);
		tournamentLegendaryIncrement.setDocument(new IncrementLimit(2));
		tournamentLegendaryIncrement.setBackground(titleFontColor);
		tournamentLegendaryIncrement.setForeground(headerBGColor);
		tournamentLegendaryIncrement.setCaretColor(headerBGColor);
		tournamentLegendaryIncrement.setBorder(new EmptyBorder(0, 9, 0, 3));
		
		createModifyButtonsPanel(tournament, tournamentLegendaryModifyPanel, tournamentLegendaryReset, tournamentLegendaryAdd, tournamentLegendaryIncrement);
		
		// Probability of finding a legendary calculator
		tournamentLegendaryProbabilityText = new JTextPane();
		doc = tournamentLegendaryProbabilityText.getStyledDocument();
		changePanelTextStyle(tournament, tournamentLegendaryProbabilityText, legendaryProbabilityText, tournamentLegendaryProbability);
		tournamentLegendaryProbabilityText.setForeground(titleFontColor);
		
		tournamentLegendaryPanel.add(legendaryPanelTitleLabel);
		tournamentLegendaryPanel.add(tournamentLegendaryCounterText);
		tournamentLegendaryPanel.add(tournamentLegendaryModifyPanel);
		tournamentLegendaryPanel.add(tournamentLegendaryProbabilityText);
		
		// Total amount of packs opened counter panel
		tournamentTotalPanel = new JPanel();
		tournamentTotalPanel.setBackground(tournament.getBackground());
		tournamentTotalPanel.setLayout(new GridLayout(4, 1));
		
		// Total amount of packs opened counter panel title
		totalPanelTitleLabel = new JTextPane();
		doc = totalPanelTitleLabel.getStyledDocument();
		changePanelTitleStyle(tournament, totalPanelTitleLabel,totalPanelTitle);
		totalPanelTitleLabel.setForeground(titleFontColor);
		
		// Total amount of packs opened counter
		tournamentTotalCounterText = new JTextPane();
		doc = tournamentTotalCounterText.getStyledDocument();
		changePanelTextStyle(tournament, tournamentTotalCounterText, totalCounterText, tournamentTotalCounter);
		tournamentTotalCounterText.setForeground(titleFontColor);
		
		// Total amount of packs opened modify buttons panel
		tournamentTotalModifyPanel = new JPanel();
		
		// Modify button
		tournamentTotalModify = new ModifierButton("Modify", titleFontColor, buttonsDarkHoverColor);
		tournamentTotalModify.setToolTipText(modifyButtonToolTipText);
		tournamentTotalModify.setBackground(titleFontColor);
		tournamentTotalModify.setForeground(headerBGColor);
		
		// Blank space between modify and add buttons
		blank = new JLabel();
		blank.setBackground(tournament.getBackground());
		blank.setBorder(new EmptyBorder(0, 5, 0, 5));
		
		// Add button
		tournamentTotalAdd = new RoundButton("+", titleFontColor, buttonsDarkHoverColor);
		tournamentTotalAdd.setBackground(titleFontColor);
		tournamentTotalAdd.setForeground(headerBGColor);
		
		// Increment field
		tournamentTotalIncrement = new JTextArea(1, 3);
		tournamentTotalIncrement.setDocument(new IncrementLimit(3));
		tournamentTotalIncrement.setBackground(titleFontColor);
		tournamentTotalIncrement.setForeground(headerBGColor);
		tournamentTotalIncrement.setCaretColor(headerBGColor);
		tournamentTotalIncrement.setBorder(new EmptyBorder(0, 9, 0, 0));
		
		createModifyButtonsPanel(tournament, tournamentTotalModifyPanel, tournamentTotalModify, tournamentTotalAdd, tournamentTotalIncrement);
		
		// Rarity buttons panel
		tournamentRarityButtonsPanel = new JPanel();
		
		// Common button
		tournamentCommonButtonPanel = new JPanel(new GridBagLayout());
		tournamentCommonButton = new IconButton(new ImageIcon(commonButtonDarkIcon), new ImageIcon(commonButtonDarkHoverIcon));
		
		// Rare button
		tournamentRareButtonPanel = new JPanel(new GridBagLayout());
		tournamentRareButton = new IconButton(new ImageIcon(rareButtonDarkIcon), new ImageIcon(rareButtonDarkHoverIcon));
		
		// Epic button
		tournamentEpicButtonPanel = new JPanel(new GridBagLayout());
		tournamentEpicButton = new IconButton(new ImageIcon(epicButtonDarkIcon), new ImageIcon(epicButtonDarkHoverIcon));
		
		// Legendary button
		tournamentLegendaryButtonPanel = new JPanel(new GridBagLayout());
		tournamentLegendaryButton = new IconButton(new ImageIcon(legendaryButtonDarkIcon), new ImageIcon(legendaryButtonDarkHoverIcon));
		
		createRarityButtonsPanel(tournament, tournamentRarityButtonsPanel, 
				tournamentCommonButtonPanel, tournamentCommonButton, tournamentRareButtonPanel, tournamentRareButton, 
				tournamentEpicButtonPanel, tournamentEpicButton, tournamentLegendaryButtonPanel, tournamentLegendaryButton);
		
		tournamentTotalPanel.add(totalPanelTitleLabel);
		tournamentTotalPanel.add(tournamentTotalCounterText);
		tournamentTotalPanel.add(tournamentTotalModifyPanel);
		tournamentTotalPanel.add(tournamentRarityButtonsPanel);
		
		tournament.add(tournamentImagePanel);
		tournament.add(tournamentEpicPanel);
		tournament.add(tournamentLegendaryPanel);
		tournament.add(tournamentTotalPanel);
	}
	
	// "Goblins vs Gnomes" panel creator
	private void createGoblinsVsGnomesPanel() 
	{
		// "Goblins vs Gnomes" panel
		goblins = new JPanel();
		goblins.setBackground(goblinsColor);
		goblins.setLayout(new GridLayout(1, 4, 10, 0));
		goblins.setBorder(new EmptyBorder(10, 10, 10, 10));
		
		// "Goblins vs Gnomes" logo
		goblinsImagePanel = new JPanel(new GridBagLayout());
		goblinsImagePanel.setBackground(goblins.getBackground());
		
		goblinsImageButton = new JButton(new ImageIcon(goblinsImage));
		goblinsImageButton.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 0));
		goblinsImageButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		goblinsImageButton.setToolTipText(imageButtonToolTipText);
		goblinsImageButton.setContentAreaFilled(false);
		goblinsImageButton.setFocusPainted(false);
		
		goblinsImagePanel.add(goblinsImageButton);
		
		// Packs without epic counter panel
		goblinsEpicPanel = new JPanel();
		goblinsEpicPanel.setBackground(goblins.getBackground());
		goblinsEpicPanel.setLayout(new GridLayout(4, 1));
		
		// Packs without epic counter panel title
		epicPanelTitleLabel = new JTextPane();
		doc = epicPanelTitleLabel.getStyledDocument();
		changePanelTitleStyle(goblins, epicPanelTitleLabel, epicPanelTitle);
		
		// Packs without epic counter
		goblinsEpicCounterText = new JTextPane();
		doc = goblinsEpicCounterText.getStyledDocument();
		changePanelTextStyle(goblins, goblinsEpicCounterText, epicCounterText, goblinsEpicCounter);
		
		// Packs without epic counter modify buttons panel
		goblinsEpicModifyPanel = new JPanel();
		
		// Reset button
		goblinsEpicReset = new ModifierButton("Reset", headerBGColor, buttonsHoverColor);
		goblinsEpicReset.setToolTipText(resetButtonToolTipText);
		goblinsEpicReset.setBackground(headerBGColor);
		goblinsEpicReset.setForeground(titleFontColor);
		
		// Blank space between reset and add buttons
		blank = new JLabel();
		blank.setBackground(goblins.getBackground());
		blank.setBorder(new EmptyBorder(0, 20, 0, 20));
		
		// Add button
		goblinsEpicAdd = new RoundButton("+", headerBGColor, buttonsHoverColor);
		goblinsEpicAdd.setBackground(headerBGColor);
		goblinsEpicAdd.setForeground(titleFontColor);
		
		// Increment field
		goblinsEpicIncrement = new JTextArea(1, 1);
		goblinsEpicIncrement.setDocument(new IncrementLimit(1));
		goblinsEpicIncrement.setBackground(headerBGColor);
		goblinsEpicIncrement.setForeground(titleFontColor);
		goblinsEpicIncrement.setCaretColor(titleFontColor);
		goblinsEpicIncrement.setBorder(new EmptyBorder(0, 9, 0, 6));
		
		createModifyButtonsPanel(goblins, goblinsEpicModifyPanel, goblinsEpicReset, goblinsEpicAdd, goblinsEpicIncrement);
		
		// Probability of finding an epic calculator
		goblinsEpicProbabilityText = new JTextPane();
		doc = goblinsEpicProbabilityText.getStyledDocument();
		changePanelTextStyle(goblins, goblinsEpicProbabilityText, epicProbabilityText, goblinsEpicProbability);
		
		goblinsEpicPanel.add(epicPanelTitleLabel);
		goblinsEpicPanel.add(goblinsEpicCounterText);
		goblinsEpicPanel.add(goblinsEpicModifyPanel);
		goblinsEpicPanel.add(goblinsEpicProbabilityText);
		
		// Packs without legendary counter panel
		goblinsLegendaryPanel = new JPanel();
		goblinsLegendaryPanel.setBackground(goblins.getBackground());
		goblinsLegendaryPanel.setLayout(new GridLayout(4, 1));
		
		// Packs without legendary counter panel title
		legendaryPanelTitleLabel = new JTextPane();
		doc = legendaryPanelTitleLabel.getStyledDocument();
		changePanelTitleStyle(goblins, legendaryPanelTitleLabel, legendaryPanelTitle);
		
		// Packs without legendary counter
		goblinsLegendaryCounterText = new JTextPane();
		doc = goblinsLegendaryCounterText.getStyledDocument();
		changePanelTextStyle(goblins, goblinsLegendaryCounterText, legendaryCounterText, goblinsLegendaryCounter);
		
		// Packs without legendary counter modify buttons panel
		goblinsLegendaryModifyPanel = new JPanel();
		
		// Reset button
		goblinsLegendaryReset = new ModifierButton("Reset", headerBGColor, buttonsHoverColor);
		goblinsLegendaryReset.setToolTipText(resetButtonToolTipText);
		goblinsLegendaryReset.setBackground(headerBGColor);
		goblinsLegendaryReset.setForeground(titleFontColor);
		
		// Blank space between reset and add buttons
		blank = new JLabel();
		blank.setBackground(goblins.getBackground());
		blank.setBorder(new EmptyBorder(0, 20, 0, 20));
		
		// Add button
		goblinsLegendaryAdd = new RoundButton("+", headerBGColor, buttonsHoverColor);
		goblinsLegendaryAdd.setBackground(headerBGColor);
		goblinsLegendaryAdd.setForeground(titleFontColor);
		
		// Increment field
		goblinsLegendaryIncrement = new JTextArea(1, 2);
		goblinsLegendaryIncrement.setDocument(new IncrementLimit(2));
		goblinsLegendaryIncrement.setBackground(headerBGColor);
		goblinsLegendaryIncrement.setForeground(titleFontColor);
		goblinsLegendaryIncrement.setCaretColor(titleFontColor);
		goblinsLegendaryIncrement.setBorder(new EmptyBorder(0, 9, 0, 3));
		
		createModifyButtonsPanel(goblins, goblinsLegendaryModifyPanel, goblinsLegendaryReset, goblinsLegendaryAdd, goblinsLegendaryIncrement);
		
		// Probability of finding a legendary calculator
		goblinsLegendaryProbabilityText = new JTextPane();
		doc = goblinsLegendaryProbabilityText.getStyledDocument();
		changePanelTextStyle(goblins, goblinsLegendaryProbabilityText, legendaryProbabilityText, goblinsLegendaryProbability);
		
		goblinsLegendaryPanel.add(legendaryPanelTitleLabel);
		goblinsLegendaryPanel.add(goblinsLegendaryCounterText);
		goblinsLegendaryPanel.add(goblinsLegendaryModifyPanel);
		goblinsLegendaryPanel.add(goblinsLegendaryProbabilityText);
		
		// Total amount of packs opened counter panel
		goblinsTotalPanel = new JPanel();
		goblinsTotalPanel.setBackground(goblins.getBackground());
		goblinsTotalPanel.setLayout(new GridLayout(4, 1));
		
		// Total amount of packs opened counter panel title
		totalPanelTitleLabel = new JTextPane();
		doc = totalPanelTitleLabel.getStyledDocument();
		changePanelTitleStyle(goblins, totalPanelTitleLabel,totalPanelTitle);
		
		// Total amount of packs opened counter
		goblinsTotalCounterText = new JTextPane();
		doc = goblinsTotalCounterText.getStyledDocument();
		changePanelTextStyle(goblins, goblinsTotalCounterText, totalCounterText, goblinsTotalCounter);
		
		// Total amount of packs opened modify buttons panel
		goblinsTotalModifyPanel = new JPanel();
		
		// Modify button
		goblinsTotalModify = new ModifierButton("Modify", headerBGColor, buttonsHoverColor);
		goblinsTotalModify.setToolTipText(modifyButtonToolTipText);
		goblinsTotalModify.setBackground(headerBGColor);
		goblinsTotalModify.setForeground(titleFontColor);
		
		// Blank space between modify and add buttons
		blank = new JLabel();
		blank.setBackground(goblins.getBackground());
		blank.setBorder(new EmptyBorder(0, 5, 0, 5));
		
		// Add button
		goblinsTotalAdd = new RoundButton("+", headerBGColor, buttonsHoverColor);
		goblinsTotalAdd.setBackground(headerBGColor);
		goblinsTotalAdd.setForeground(titleFontColor);
		
		// Increment field
		goblinsTotalIncrement = new JTextArea(1, 3);
		goblinsTotalIncrement.setDocument(new IncrementLimit(3));
		goblinsTotalIncrement.setBackground(headerBGColor);
		goblinsTotalIncrement.setForeground(titleFontColor);
		goblinsTotalIncrement.setCaretColor(titleFontColor);
		goblinsTotalIncrement.setBorder(new EmptyBorder(0, 9, 0, 0));
		
		createModifyButtonsPanel(goblins, goblinsTotalModifyPanel, goblinsTotalModify, goblinsTotalAdd, goblinsTotalIncrement);
		
		// Rarity buttons panel
		goblinsRarityButtonsPanel = new JPanel();
		
		// Common button
		goblinsCommonButtonPanel = new JPanel(new GridBagLayout());
		goblinsCommonButton = new IconButton(new ImageIcon(commonButtonIcon), new ImageIcon(commonButtonHoverIcon));
		
		// Rare button
		goblinsRareButtonPanel = new JPanel(new GridBagLayout());
		goblinsRareButton = new IconButton(new ImageIcon(rareButtonIcon), new ImageIcon(rareButtonHoverIcon));
		
		// Epic button
		goblinsEpicButtonPanel = new JPanel(new GridBagLayout());
		goblinsEpicButton = new IconButton(new ImageIcon(epicButtonIcon), new ImageIcon(epicButtonHoverIcon));
		
		// Legendary button
		goblinsLegendaryButtonPanel = new JPanel(new GridBagLayout());
		goblinsLegendaryButton = new IconButton(new ImageIcon(legendaryButtonIcon), new ImageIcon(legendaryButtonHoverIcon));
		
		createRarityButtonsPanel(goblins, goblinsRarityButtonsPanel, 
				goblinsCommonButtonPanel, goblinsCommonButton, goblinsRareButtonPanel, goblinsRareButton, 
				goblinsEpicButtonPanel, goblinsEpicButton, goblinsLegendaryButtonPanel, goblinsLegendaryButton);
		
		goblinsTotalPanel.add(totalPanelTitleLabel);
		goblinsTotalPanel.add(goblinsTotalCounterText);
		goblinsTotalPanel.add(goblinsTotalModifyPanel);
		goblinsTotalPanel.add(goblinsRarityButtonsPanel);
		
		goblins.add(goblinsImagePanel);
		goblins.add(goblinsEpicPanel);
		goblins.add(goblinsLegendaryPanel);
		goblins.add(goblinsTotalPanel);
	}
	
	// "Classic" panel creator
	private void createClassicPanel() 
	{
		// "Classic" panel
		classic = new JPanel();
		classic.setBackground(classicColor);
		classic.setLayout(new GridLayout(1, 4, 10, 0));
		classic.setBorder(new EmptyBorder(10, 10, 10, 10));
		
		// "Classic" logo
		classicImagePanel = new JPanel(new GridBagLayout());
		classicImagePanel.setBackground(classic.getBackground());
		
		classicImageLabel = new JLabel(new ImageIcon(classicImage));
		
		classicImagePanel.add(classicImageLabel);
		
		// Packs without epic counter panel
		classicEpicPanel = new JPanel();
		classicEpicPanel.setBackground(classic.getBackground());
		classicEpicPanel.setLayout(new GridLayout(4, 1));
		
		// Packs without epic counter panel title
		epicPanelTitleLabel = new JTextPane();
		doc = epicPanelTitleLabel.getStyledDocument();
		changePanelTitleStyle(classic, epicPanelTitleLabel, epicPanelTitle);
		
		// Packs without epic counter
		classicEpicCounterText = new JTextPane();
		doc = classicEpicCounterText.getStyledDocument();
		changePanelTextStyle(classic, classicEpicCounterText, epicCounterText, classicEpicCounter);
		
		// Packs without epic counter modify buttons panel
		classicEpicModifyPanel = new JPanel();
		
		// Reset button
		classicEpicReset = new ModifierButton("Reset", headerBGColor, buttonsHoverColor);
		classicEpicReset.setToolTipText(resetButtonToolTipText);
		classicEpicReset.setBackground(headerBGColor);
		classicEpicReset.setForeground(titleFontColor);
		
		// Blank space between reset and add buttons
		blank = new JLabel();
		blank.setBackground(classic.getBackground());
		blank.setBorder(new EmptyBorder(0, 20, 0, 20));
		
		// Add button
		classicEpicAdd = new RoundButton("+", headerBGColor, buttonsHoverColor);
		classicEpicAdd.setBackground(headerBGColor);
		classicEpicAdd.setForeground(titleFontColor);
		
		// Increment field
		classicEpicIncrement = new JTextArea(1, 1);
		classicEpicIncrement.setDocument(new IncrementLimit(1));
		classicEpicIncrement.setBackground(headerBGColor);
		classicEpicIncrement.setForeground(titleFontColor);
		classicEpicIncrement.setCaretColor(titleFontColor);
		classicEpicIncrement.setBorder(new EmptyBorder(0, 9, 0, 6));
		
		createModifyButtonsPanel(classic, classicEpicModifyPanel, classicEpicReset, classicEpicAdd, classicEpicIncrement);
		
		// Probability of finding an epic calculator
		classicEpicProbabilityText = new JTextPane();
		doc = classicEpicProbabilityText.getStyledDocument();
		changePanelTextStyle(classic, classicEpicProbabilityText, epicProbabilityText, classicEpicProbability);
		
		classicEpicPanel.add(epicPanelTitleLabel);
		classicEpicPanel.add(classicEpicCounterText);
		classicEpicPanel.add(classicEpicModifyPanel);
		classicEpicPanel.add(classicEpicProbabilityText);
		
		// Packs without legendary counter panel
		classicLegendaryPanel = new JPanel();
		classicLegendaryPanel.setBackground(classic.getBackground());
		classicLegendaryPanel.setLayout(new GridLayout(4, 1));
		
		// Packs without legendary counter panel title
		legendaryPanelTitleLabel = new JTextPane();
		doc = legendaryPanelTitleLabel.getStyledDocument();
		changePanelTitleStyle(classic, legendaryPanelTitleLabel, legendaryPanelTitle);
		
		// Packs without legendary counter
		classicLegendaryCounterText = new JTextPane();
		doc = classicLegendaryCounterText.getStyledDocument();
		changePanelTextStyle(classic, classicLegendaryCounterText, legendaryCounterText, classicLegendaryCounter);
		
		// Packs without legendary counter modify buttons panel
		classicLegendaryModifyPanel = new JPanel();
		
		// Reset button
		classicLegendaryReset = new ModifierButton("Reset", headerBGColor, buttonsHoverColor);
		classicLegendaryReset.setToolTipText(resetButtonToolTipText);
		classicLegendaryReset.setBackground(headerBGColor);
		classicLegendaryReset.setForeground(titleFontColor);
		
		// Blank space between reset and add buttons
		blank = new JLabel();
		blank.setBackground(classic.getBackground());
		blank.setBorder(new EmptyBorder(0, 20, 0, 20));
		
		// Add button
		classicLegendaryAdd = new RoundButton("+", headerBGColor, buttonsHoverColor);
		classicLegendaryAdd.setBackground(headerBGColor);
		classicLegendaryAdd.setForeground(titleFontColor);
		
		// Increment field
		classicLegendaryIncrement = new JTextArea(1, 2);
		classicLegendaryIncrement.setDocument(new IncrementLimit(2));
		classicLegendaryIncrement.setBackground(headerBGColor);
		classicLegendaryIncrement.setForeground(titleFontColor);
		classicLegendaryIncrement.setCaretColor(titleFontColor);
		classicLegendaryIncrement.setBorder(new EmptyBorder(0, 9, 0, 3));
		
		createModifyButtonsPanel(classic, classicLegendaryModifyPanel, classicLegendaryReset, classicLegendaryAdd, classicLegendaryIncrement);
		
		// Probability of finding a legendary calculator
		classicLegendaryProbabilityText = new JTextPane();
		doc = classicLegendaryProbabilityText.getStyledDocument();
		changePanelTextStyle(classic, classicLegendaryProbabilityText, legendaryProbabilityText, classicLegendaryProbability);
		
		classicLegendaryPanel.add(legendaryPanelTitleLabel);
		classicLegendaryPanel.add(classicLegendaryCounterText);
		classicLegendaryPanel.add(classicLegendaryModifyPanel);
		classicLegendaryPanel.add(classicLegendaryProbabilityText);
		
		// Total amount of packs opened counter panel
		classicTotalPanel = new JPanel();
		classicTotalPanel.setBackground(classic.getBackground());
		classicTotalPanel.setLayout(new GridLayout(4, 1));
		
		// Total amount of packs opened counter panel title
		totalPanelTitleLabel = new JTextPane();
		doc = totalPanelTitleLabel.getStyledDocument();
		changePanelTitleStyle(classic, totalPanelTitleLabel,totalPanelTitle);
		
		// Total amount of packs opened counter
		classicTotalCounterText = new JTextPane();
		doc = classicTotalCounterText.getStyledDocument();
		changePanelTextStyle(classic, classicTotalCounterText, totalCounterText, classicTotalCounter);
		
		// Total amount of packs opened modify buttons panel
		classicTotalModifyPanel = new JPanel();
		
		// Modify button
		classicTotalModify = new ModifierButton("Modify", headerBGColor, buttonsHoverColor);
		classicTotalModify.setToolTipText(modifyButtonToolTipText);
		classicTotalModify.setBackground(headerBGColor);
		classicTotalModify.setForeground(titleFontColor);
		
		// Blank space between modify and add buttons
		blank = new JLabel();
		blank.setBackground(classic.getBackground());
		blank.setBorder(new EmptyBorder(0, 5, 0, 5));
		
		// Add button
		classicTotalAdd = new RoundButton("+", headerBGColor, buttonsHoverColor);
		classicTotalAdd.setBackground(headerBGColor);
		classicTotalAdd.setForeground(titleFontColor);
		
		// Increment field
		classicTotalIncrement = new JTextArea(1, 3);
		classicTotalIncrement.setDocument(new IncrementLimit(3));
		classicTotalIncrement.setBackground(headerBGColor);
		classicTotalIncrement.setForeground(titleFontColor);
		classicTotalIncrement.setCaretColor(titleFontColor);
		classicTotalIncrement.setBorder(new EmptyBorder(0, 9, 0, 0));
		
		createModifyButtonsPanel(classic, classicTotalModifyPanel, classicTotalModify, classicTotalAdd, classicTotalIncrement);
		
		// Rarity buttons panel
		classicRarityButtonsPanel = new JPanel();
		
		// Common button
		classicCommonButtonPanel = new JPanel(new GridBagLayout());
		classicCommonButton = new IconButton(new ImageIcon(commonButtonIcon), new ImageIcon(commonButtonHoverIcon));
		
		// Rare button
		classicRareButtonPanel = new JPanel(new GridBagLayout());
		classicRareButton = new IconButton(new ImageIcon(rareButtonIcon), new ImageIcon(rareButtonHoverIcon));
		
		// Epic button
		classicEpicButtonPanel = new JPanel(new GridBagLayout());
		classicEpicButton = new IconButton(new ImageIcon(epicButtonIcon), new ImageIcon(epicButtonHoverIcon));
		
		// Legendary button
		classicLegendaryButtonPanel = new JPanel(new GridBagLayout());
		classicLegendaryButton = new IconButton(new ImageIcon(legendaryButtonIcon), new ImageIcon(legendaryButtonHoverIcon));
		
		 createRarityButtonsPanel(classic, classicRarityButtonsPanel, 
				classicCommonButtonPanel, classicCommonButton, classicRareButtonPanel, classicRareButton, 
				classicEpicButtonPanel, classicEpicButton, classicLegendaryButtonPanel, classicLegendaryButton);
		
		classicTotalPanel.add(totalPanelTitleLabel);
		classicTotalPanel.add(classicTotalCounterText);
		classicTotalPanel.add(classicTotalModifyPanel);
		classicTotalPanel.add(classicRarityButtonsPanel);
		
		classic.add(classicImagePanel);
		classic.add(classicEpicPanel);
		classic.add(classicLegendaryPanel);
		classic.add(classicTotalPanel);
	}
	
	// Modify buttons panel creator
	private void createModifyButtonsPanel(JPanel expansion, JPanel modifiersPanel, ModifierButton resModButton, RoundButton addButton, JTextArea numField) 
	{
		// Modifiers panel
		modifiersPanel.setBackground(expansion.getBackground());
		modifiersPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 15, 0));
		
		// "Reset" / "Modify" button
		resModButton.setBorder(new EmptyBorder(5, 10, 5, 10));
		resModButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		resModButton.setFont(buttonsTextFont);
		resModButton.setFocusPainted(false);
		
		// "Add" button
		addButton.setIcon(new ImageIcon(getClass().getResource(""))); // Centers the "+" symbol in the button
		addButton.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 0));
		addButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		addButton.setToolTipText(addButtonToolTipText);
		addButton.setFont(addButtonTextFont);
		addButton.setFocusPainted(false);
		
		// Increment field
		numField.getDocument().putProperty("filterNewlines", Boolean.TRUE);
		numField.setText("1");
		numField.setFont(incrementFieldFont);
		numField.setToolTipText(incrementToolTipText);
		
		modifiersPanel.add(resModButton);
		modifiersPanel.add(blank);
		modifiersPanel.add(addButton);
		modifiersPanel.add(numField);
	}
	
	// Rarity buttons panel creator
	private void createRarityButtonsPanel(JPanel expansion, JPanel buttonsPanel, 
			JPanel commonPanel, IconButton commonButton, 
			JPanel rarePanel, IconButton rareButton, 
			JPanel epicPanel, IconButton epicButton, 
			JPanel legendaryPanel, IconButton legendaryButton) 
	{
		// Rarity buttons panel
		buttonsPanel.setBackground(expansion.getBackground());
		buttonsPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 25, 0));
		
		// Common button
		commonPanel.setBackground(expansion.getBackground());
		
		commonButton.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 0));
		commonButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		commonButton.setToolTipText(commonButtonToolTipText);
		commonButton.setContentAreaFilled(false);
		commonButton.setFocusPainted(false);
		
		commonPanel.add(commonButton);
		
		// Rare button
		rarePanel.setBackground(expansion.getBackground());
		
		rareButton.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 0));
		rareButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		rareButton.setToolTipText(rareButtonToolTipText);
		rareButton.setContentAreaFilled(false);
		rareButton.setFocusPainted(false);
		
		rarePanel.add(rareButton);
		
		// Epic button
		epicPanel.setBackground(expansion.getBackground());
		
		epicButton.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 0));
		epicButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		epicButton.setToolTipText(epicButtonToolTipText);
		epicButton.setContentAreaFilled(false);
		epicButton.setFocusPainted(false);
		
		epicPanel.add(epicButton);
		
		// Legendary button
		legendaryPanel.setBackground(expansion.getBackground());
		
		legendaryButton.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 0));
		legendaryButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		legendaryButton.setToolTipText(legendaryButtonToolTipText);
		legendaryButton.setContentAreaFilled(false);
		legendaryButton.setFocusPainted(false);
		
		legendaryPanel.add(legendaryButton);
		
		buttonsPanel.add(commonPanel);
		buttonsPanel.add(rarePanel);
		buttonsPanel.add(epicPanel);
		buttonsPanel.add(legendaryPanel);
	}
	
	// Expansions panels text style modifier
	private void changePanelTitleStyle(JPanel expansion, JTextPane titleLabel, String text) 
	{
		titleLabel.setBackground(expansion.getBackground());
		
		set = new SimpleAttributeSet();
		StyleConstants.setFontSize(set, 26);
		StyleConstants.setFontFamily(set, "Comic Sans MS");
		StyleConstants.setBold(set, true);
		StyleConstants.setAlignment(set, StyleConstants.ALIGN_CENTER);
		titleLabel.setCharacterAttributes(set, true);
		try {
			doc.insertString(doc.getLength(), text, set);
		} catch (BadLocationException e) {
			e.printStackTrace();
		}
		
		doc.setParagraphAttributes(0, doc.getLength(), set, false);
		
		titleLabel.setEditable(false);
		titleLabel.setHighlighter(null);
	}
	
	// Expansions panels text style modifier
	private void changePanelTextStyle(JPanel expansion, JTextPane field, String text, String number) 
	{
		field.setBackground(expansion.getBackground());
		
		set = new SimpleAttributeSet();
		StyleConstants.setFontSize(set, 20);
		field.setCharacterAttributes(set, true);
		try {
			doc.insertString(doc.getLength(), text, set);
		} catch (BadLocationException e) {
			e.printStackTrace();
		}
		
		set = new SimpleAttributeSet();
		StyleConstants.setBold(set, true);
		StyleConstants.setFontSize(set, 28);
		field.setCharacterAttributes(set, true);
		try {
			doc.insertString(doc.getLength(), number, set);
		} catch (BadLocationException e) {
			e.printStackTrace();
		}
		set = new SimpleAttributeSet();
		StyleConstants.setFontFamily(set, "Comic Sans MS");
		StyleConstants.setAlignment(set, StyleConstants.ALIGN_CENTER);
		
		doc.setParagraphAttributes(0, doc.getLength(), set, false);
		
		field.setEditable(false);
		field.setCursor(Cursor.getPredefinedCursor(Cursor.TEXT_CURSOR));
	}
	
	public ScrollablePanel getTrackerPanel() 
	{
		return trackerPanel;
	}
	
	// Returns the "Help" button
	public JButton getHelp() 
	{
		return help;
	}
	
	// Returns the "Show save file" button
	public JButton getShowSaveFileFolder() 
	{
		return showSaveFileFolder;
	}
	
	// Returns the "Wild sets" toggle button
	public JCheckBox getShowWild() 
	{
		return showWild;
	}
	
	// Returns the "Year of the Gryphon" panel
	public JPanel getYearOfTheGryphon() 
	{
		return gryphon;
	}
	
	// Returns the "Year of the Phoenix" panel
	public JPanel getYearOfThePhoenix() 
	{
		return phoenix;
	}
	
	// Returns the "Year of the Dragon" panel
	public JPanel getYearOfTheDragon() 
	{
		return dragon;
	}
	
	// Returns the "Year of the Raven" panel
	public JPanel getYearOfTheRaven() 
	{
		return raven;
	}
	
	// Returns the "Year of the Mammoth" panel
	public JPanel getYearOfTheMammoth() 
	{
		return mammoth;
	}
		
	// Returns the "Year of the Kraken" panel
	public JPanel getYearOfTheKraken() 
	{
		return kraken;
	}
	
	// Returns the "Classic Sets" panel
	public JPanel getClassicSets() 
	{
		return classicSets;
	}
	
	//Returns the "Forged in the Barrens" image button
	public JButton getBarrensImage() {
		return barrensImageButton;
	}
	
	//Returns the "Madness at the Darkmoon Faire" image button
	public JButton getDarkmoonImage() {
		return darkmoonImageButton;
	}
	
	//Returns the "Scholomance Academy" image button
	public JButton getScholomanceImage() {
		return scholomanceImageButton;
	}
	
	//Returns the "Ashes of Outland" image button
	public JButton getOutlandImage() {
		return outlandImageButton;
	}
	
	//Returns the "Descent of Dragons" image button
	public JButton getDragonsImage() {
		return dragonsImageButton;
	}
	
	//Returns the "Saviors of Uldum" image button
	public JButton getUldumImage() {
		return uldumImageButton;
	}
	
	//Returns the "Rise of Shadows" image button
	public JButton getShadowsImage() {
		return shadowsImageButton;
	}
	
	//Returns the "Rastakhan's Rumble" image button
	public JButton getRumbleImage() {
		return rumbleImageButton;
	}
	
	//Returns the "The Boomsday Project" image button
	public JButton getBoomsdayImage() {
		return boomsdayImageButton;
	}
	
	//Returns the "The Witchwood" image button
	public JButton getWitchwoodImage() {
		return witchwoodImageButton;
	}
	
	//Returns the "Kobolds & Catacombs" image button
	public JButton getKoboldsImage() {
		return koboldsImageButton;
	}
	
	//Returns the "Knights of the Frozen Throne" image button
	public JButton getKnightsImage() {
		return knightsImageButton;
	}
	
	//Returns the "Journey to Un'Goro" image button
	public JButton getUngoroImage() {
		return ungoroImageButton;
	}
	
	//Returns the "Mean Streets of Gadgetzan" image button
	public JButton getGadgetzanImage() {
		return gadgetzanImageButton;
	}
	
	//Returns the "Whispers of the Old Gods" image button
	public JButton getOldGodsImage() {
		return oldGodsImageButton;
	}
	
	//Returns the "The Grand Tournament" image button
	public JButton getTournamentImage() {
		return tournamentImageButton;
	}
	
	//Returns the "Goblins vs Gnomes" image button
	public JButton getGoblinsImage() {
		return goblinsImageButton;
	}
	
	// Returns the value of "Forged in the Barrens" epic counter
	public String getBarrensEpicCounter() 
	{
		return barrensEpicCounter;
	}
	
	// Returns the value of "Madness at the Darkmoon Faire" epic counter
	public String getDarkmoonEpicCounter() 
	{
		return darkmoonEpicCounter;
	}
	
	// Returns the value of "Scholomance Academy" epic counter
	public String getScholomanceEpicCounter() 
	{
		return scholomanceEpicCounter;
	}
	
	// Returns the value of "Ashes of Outland" epic counter
	public String getOutlandEpicCounter() 
	{
		return outlandEpicCounter;
	}
	
	// Returns the value of "Descent of Dragons" epic counter
	public String getDragonsEpicCounter() 
	{
		return dragonsEpicCounter;
	}
	
	// Returns the value of "Saviors of Uldum" epic counter
	public String getUldumEpicCounter() 
	{
		return uldumEpicCounter;
	}
	
	// Returns the value of "Rise of Shadows" epic counter
	public String getShadowsEpicCounter() 
	{
		return shadowsEpicCounter;
	}
	
	// Returns the value of "Rastakhan's Rumble" epic counter
	public String getRumbleEpicCounter() 
	{
		return rumbleEpicCounter;
	}
	
	// Returns the value of "The Boomsday Project" epic counter
	public String getBoomsdayEpicCounter() 
	{
		return boomsdayEpicCounter;
	}
	
	// Returns the value of "The Witchwood" epic counter
	public String getWitchwoodEpicCounter() 
	{
		return witchwoodEpicCounter;
	}
	
	// Returns the value of "Kobolds & Catacombs" epic counter
	public String getKoboldsEpicCounter() 
	{
		return koboldsEpicCounter;
	}
	
	// Returns the value of "Knights of the Frozen Throne" epic counter
	public String getKnightsEpicCounter() 
	{
		return knightsEpicCounter;
	}
	
	// Returns the value of "Journey to Un'Goro" epic counter
	public String getUngoroEpicCounter() 
	{
		return ungoroEpicCounter;
	}
	
	// Returns the value of "Mean Streets of Gadgetzan" epic counter
	public String getGadgetzanEpicCounter() 
	{
		return gadgetzanEpicCounter;
	}
	
	// Returns the value of "Whispers of the Old Gods" epic counter
	public String getOldGodsEpicCounter() 
	{
		return oldGodsEpicCounter;
	}
	
	// Returns the value of "The Grand Tournament" epic counter
	public String getTournamentEpicCounter() 
	{
		return tournamentEpicCounter;
	}
	
	// Returns the value of "Goblins vs Gnomes" epic counter
	public String getGoblinsEpicCounter() 
	{
		return goblinsEpicCounter;
	}
	
	// Returns the value of "Classic" epic counter
	public String getClassicEpicCounter() 
	{
		return classicEpicCounter;
	}
	
	// Sets the value of "Forged in the Barrens" epic counter
	public void setBarrensEpicCounter(String value) 
	{
		barrensEpicCounter = value;
		barrensEpicCounterText.setText("");
		doc = barrensEpicCounterText.getStyledDocument();
		changePanelTextStyle(barrens, barrensEpicCounterText, epicCounterText, barrensEpicCounter);
	}
	
	// Sets the value of "Madness at the Darkmoon Faire" epic counter
	public void setDarkmoonEpicCounter(String value) 
	{
		darkmoonEpicCounter = value;
		darkmoonEpicCounterText.setText("");
		doc = darkmoonEpicCounterText.getStyledDocument();
		changePanelTextStyle(darkmoon, darkmoonEpicCounterText, epicCounterText, darkmoonEpicCounter);
	}
	
	// Sets the value of "Scholomance Academy" epic counter
	public void setScholomanceEpicCounter(String value) 
	{
		scholomanceEpicCounter = value;
		scholomanceEpicCounterText.setText("");
		doc = scholomanceEpicCounterText.getStyledDocument();
		changePanelTextStyle(scholomance, scholomanceEpicCounterText, epicCounterText, scholomanceEpicCounter);
	}
	
	// Sets the value of "Ashes of Outland" epic counter
	public void setOutlandEpicCounter(String value) 
	{
		outlandEpicCounter = value;
		outlandEpicCounterText.setText("");
		doc = outlandEpicCounterText.getStyledDocument();
		changePanelTextStyle(outland, outlandEpicCounterText, epicCounterText, outlandEpicCounter);
	}
	
	// Sets the value of "Descent of Dragons" epic counter
	public void setDragonsEpicCounter(String value) 
	{
		dragonsEpicCounter = value;
		dragonsEpicCounterText.setText("");
		doc = dragonsEpicCounterText.getStyledDocument();
		changePanelTextStyle(dragons, dragonsEpicCounterText, epicCounterText, dragonsEpicCounter);
	}
	
	// Sets the value of "Saviors of Uldum" epic counter
	public void setUldumEpicCounter(String value) 
	{
		uldumEpicCounter = value;
		uldumEpicCounterText.setText("");
		doc = uldumEpicCounterText.getStyledDocument();
		changePanelTextStyle(uldum, uldumEpicCounterText, epicCounterText, uldumEpicCounter);
	}
	
	// Sets the value of "Rise of Shadows" epic counter
	public void setShadowsEpicCounter(String value) 
	{
		shadowsEpicCounter = value;
		shadowsEpicCounterText.setText("");
		doc = shadowsEpicCounterText.getStyledDocument();
		changePanelTextStyle(shadows, shadowsEpicCounterText, epicCounterText, shadowsEpicCounter);
	}
	
	// Sets the value of "Rastakhan's Rumble" epic counter
	public void setRumbleEpicCounter(String value) 
	{
		rumbleEpicCounter = value;
		rumbleEpicCounterText.setText("");
		doc = rumbleEpicCounterText.getStyledDocument();
		changePanelTextStyle(rumble, rumbleEpicCounterText, epicCounterText, rumbleEpicCounter);
	}
	
	// Sets the value of "The Boomsday Project" epic counter
	public void setBoomsdayEpicCounter(String value) 
	{
		boomsdayEpicCounter = value;
		boomsdayEpicCounterText.setText("");
		doc = boomsdayEpicCounterText.getStyledDocument();
		changePanelTextStyle(boomsday, boomsdayEpicCounterText, epicCounterText, boomsdayEpicCounter);
	}
	
	// Sets the value of "The Witchwood" epic counter
	public void setWitchwoodEpicCounter(String value) 
	{
		witchwoodEpicCounter = value;
		witchwoodEpicCounterText.setText("");
		doc = witchwoodEpicCounterText.getStyledDocument();
		changePanelTextStyle(witchwood, witchwoodEpicCounterText, epicCounterText, witchwoodEpicCounter);
	}
	
	// Sets the value of "Kobolds & Catacombs" epic counter
	public void setKoboldsEpicCounter(String value) 
	{
		koboldsEpicCounter = value;
		koboldsEpicCounterText.setText("");
		doc = koboldsEpicCounterText.getStyledDocument();
		changePanelTextStyle(kobolds, koboldsEpicCounterText, epicCounterText, koboldsEpicCounter);
	}
	
	// Sets the value of "Knights of the Frozen Throne" epic counter
	public void setKnightsEpicCounter(String value) 
	{
		knightsEpicCounter = value;
		knightsEpicCounterText.setText("");
		doc = knightsEpicCounterText.getStyledDocument();
		changePanelTextStyle(knights, knightsEpicCounterText, epicCounterText, knightsEpicCounter);
	}
	
	// Sets the value of "Journey to Un'Goro" epic counter
	public void setUngoroEpicCounter(String value) 
	{
		ungoroEpicCounter = value;
		ungoroEpicCounterText.setText("");
		doc = ungoroEpicCounterText.getStyledDocument();
		changePanelTextStyle(ungoro, ungoroEpicCounterText, epicCounterText, ungoroEpicCounter);
	}
	
	// Sets the value of "Mean Streets of Gadgetzan" epic counter
	public void setGadgetzanEpicCounter(String value) 
	{
		gadgetzanEpicCounter = value;
		gadgetzanEpicCounterText.setText("");
		doc = gadgetzanEpicCounterText.getStyledDocument();
		changePanelTextStyle(gadgetzan, gadgetzanEpicCounterText, epicCounterText, gadgetzanEpicCounter);
	}
	
	// Sets the value of "Whispers of the Old Gods" epic counter
	public void setOldGodsEpicCounter(String value) 
	{
		oldGodsEpicCounter = value;
		oldGodsEpicCounterText.setText("");
		doc = oldGodsEpicCounterText.getStyledDocument();
		changePanelTextStyle(oldGods, oldGodsEpicCounterText, epicCounterText, oldGodsEpicCounter);
	}
	
	// Sets the value of "The Grand Tournament" epic counter
	public void setTournamentEpicCounter(String value) 
	{
		tournamentEpicCounter = value;
		tournamentEpicCounterText.setText("");
		doc = tournamentEpicCounterText.getStyledDocument();
		changePanelTextStyle(tournament, tournamentEpicCounterText, epicCounterText, tournamentEpicCounter);
	}
	
	// Sets the value of "Goblins vs Gnomes" epic counter
	public void setGoblinsEpicCounter(String value) 
	{
		goblinsEpicCounter = value;
		goblinsEpicCounterText.setText("");
		doc = goblinsEpicCounterText.getStyledDocument();
		changePanelTextStyle(goblins, goblinsEpicCounterText, epicCounterText, goblinsEpicCounter);
	}
	
	// Sets the value of "Classic" epic counter
	public void setClassicEpicCounter(String value) 
	{
		classicEpicCounter = value;
		classicEpicCounterText.setText("");
		doc = classicEpicCounterText.getStyledDocument();
		changePanelTextStyle(classic, classicEpicCounterText, epicCounterText, classicEpicCounter);
	}
	
	// Returns the "Forged in the Barrens" epic reset button
	public ModifierButton getBarrensEpicReset() 
	{
		return barrensEpicReset;
	}
	
	// Returns the "Madness at the Darkmoon Faire" epic reset button
	public ModifierButton getDarkmoonEpicReset() 
	{
		return darkmoonEpicReset;
	}
	
	// Returns the "Scholomance Academy" epic reset button
	public ModifierButton getScholomanceEpicReset() 
	{
		return scholomanceEpicReset;
	}
	
	// Returns the "Ashes of Outland" epic reset button
	public ModifierButton getOutlandEpicReset() 
	{
		return outlandEpicReset;
	}
	
	// Returns the "Descent of Dragons" epic reset button
	public ModifierButton getDragonsEpicReset() 
	{
		return dragonsEpicReset;
	}
	
	// Returns the "Saviors of Uldum" epic reset button
	public ModifierButton getUldumEpicReset() 
	{
		return uldumEpicReset;
	}
	
	// Returns the "Rise of Shadows" epic reset button
	public ModifierButton getShadowsEpicReset() 
	{
		return shadowsEpicReset;
	}
	
	// Returns the "Rastakhan's Rumble" epic reset button
	public ModifierButton getRumbleEpicReset() 
	{
		return rumbleEpicReset;
	}
	
	// Returns the "The Boomsday Project" epic reset button
	public ModifierButton getBoomsdayEpicReset() 
	{
		return boomsdayEpicReset;
	}
	
	// Returns the "The Witchwood" epic reset button
	public ModifierButton getWitchwoodEpicReset() 
	{
		return witchwoodEpicReset;
	}
	
	// Returns the "Kobolds & Catacombs" epic reset button
	public ModifierButton getKoboldsEpicReset() 
	{
		return koboldsEpicReset;
	}
	
	// Returns the "Knights of the Frozen Throne" epic reset button
	public ModifierButton getKnightsEpicReset() 
	{
		return knightsEpicReset;
	}
	
	// Returns the "Journey to Un'Goro" epic reset button
	public ModifierButton getUngoroEpicReset() 
	{
		return ungoroEpicReset;
	}
	
	// Returns the "Mean Streets of Gadgetzan" epic reset button
	public ModifierButton getGadgetzanEpicReset() 
	{
		return gadgetzanEpicReset;
	}
	
	// Returns the "Whispers of the Old Gods" epic reset button
	public ModifierButton getOldGodsEpicReset() 
	{
		return oldGodsEpicReset;
	}
	
	// Returns the "The Grand Tournament" epic reset button
	public ModifierButton getTournamentEpicReset() 
	{
		return tournamentEpicReset;
	}
	
	// Returns the "Goblins vs Gnomes" epic reset button
	public ModifierButton getGoblinsEpicReset() 
	{
		return goblinsEpicReset;
	}
	
	// Returns the "Classic" epic reset button
	public ModifierButton getClassicEpicReset() 
	{
		return classicEpicReset;
	}
	
	// Returns the "Forged in the Barrens" epic add button
	public RoundButton getBarrensEpicAdd() 
	{
		return barrensEpicAdd;
	}
	
	// Returns the "Madness at the Darkmoon Faire" epic add button
	public RoundButton getDarkmoonEpicAdd() 
	{
		return darkmoonEpicAdd;
	}
	
	// Returns the "Scholomance Academy" epic add button
	public RoundButton getScholomanceEpicAdd() 
	{
		return scholomanceEpicAdd;
	}
	
	// Returns the "Ashes of Outland" epic add button
	public RoundButton getOutlandEpicAdd() 
	{
		return outlandEpicAdd;
	}
	
	// Returns the "Descent of Dragons" epic add button
	public RoundButton getDragonsEpicAdd() 
	{
		return dragonsEpicAdd;
	}
	
	// Returns the "Saviors of Uldum" epic add button
	public RoundButton getUldumEpicAdd() 
	{
		return uldumEpicAdd;
	}
	
	// Returns the "Rise of Shadows" epic add button
	public RoundButton getShadowsEpicAdd() 
	{
		return shadowsEpicAdd;
	}
	
	// Returns the "Rastakhan's Rumble" epic add button
	public RoundButton getRumbleEpicAdd() 
	{
		return rumbleEpicAdd;
	}
	
	// Returns the "The Boomsday Project" epic add button
	public RoundButton getBoomsdayEpicAdd() 
	{
		return boomsdayEpicAdd;
	}
	
	// Returns the "The Witchwood" epic add button
	public RoundButton getWitchwoodEpicAdd() 
	{
		return witchwoodEpicAdd;
	}
	
	// Returns the "Kobolds & Catacombs" epic add button
	public RoundButton getKoboldsEpicAdd() 
	{
		return koboldsEpicAdd;
	}
	
	// Returns the "Knights of the Frozen Throne" epic add button
	public RoundButton getKnightsEpicAdd() 
	{
		return knightsEpicAdd;
	}
	
	// Returns the "Journey to Un'Goro" epic add button
	public RoundButton getUngoroEpicAdd() 
	{
		return ungoroEpicAdd;
	}
	
	// Returns the "Mean Streets of Gadgetzan" epic add button
	public RoundButton getGadgetzanEpicAdd() 
	{
		return gadgetzanEpicAdd;
	}
	
	// Returns the "Whispers of the Old Gods" epic add button
	public RoundButton getOldGodsEpicAdd() 
	{
		return oldGodsEpicAdd;
	}
	
	// Returns the "The Grand Tournament" epic add button
	public RoundButton getTournamentEpicAdd() 
	{
		return tournamentEpicAdd;
	}
	
	// Returns the "Goblins vs Gnomes" epic add button
	public RoundButton getGoblinsEpicAdd() 
	{
		return goblinsEpicAdd;
	}
	
	// Returns the "Classic" epic add button
	public RoundButton getClassicEpicAdd() 
	{
		return classicEpicAdd;
	}
	
	// Returns the "Forged in the Barrens" epic increment field
	public JTextArea getBarrensEpicIncrement() 
	{
		return barrensEpicIncrement;
	}
	
	// Returns the "Madness at the Darkmoon Faire" epic increment field
	public JTextArea getDarkmoonEpicIncrement() 
	{
		return darkmoonEpicIncrement;
	}
	
	// Returns the "Scholomance Academy" epic increment field
	public JTextArea getScholomanceEpicIncrement() 
	{
		return scholomanceEpicIncrement;
	}
	
	// Returns the "Ashes of Outland" epic increment field
	public JTextArea getOutlandEpicIncrement() 
	{
		return outlandEpicIncrement;
	}
	
	// Returns the "Descent of Dragons" epic increment field
	public JTextArea getDragonsEpicIncrement() 
	{
		return dragonsEpicIncrement;
	}
	
	// Returns the "Saviors of Uldum" epic increment field
	public JTextArea getUldumEpicIncrement() 
	{
		return uldumEpicIncrement;
	}
	
	// Returns the "Rise of Shadows" epic increment field
	public JTextArea getShadowsEpicIncrement() 
	{
		return shadowsEpicIncrement;
	}
	
	// Returns the "Rastakhan's Rumble" epic increment field
	public JTextArea getRumbleEpicIncrement() 
	{
		return rumbleEpicIncrement;
	}
	
	// Returns the "The Boomsday Project" epic increment field
	public JTextArea getBoomsdayEpicIncrement() 
	{
		return boomsdayEpicIncrement;
	}
	
	// Returns the "The Witchwood" epic increment field
	public JTextArea getWitchwoodEpicIncrement() 
	{
		return witchwoodEpicIncrement;
	}
	
	// Returns the "Kobolds & Catacombs" epic increment field
	public JTextArea getKoboldsEpicIncrement() 
	{
		return koboldsEpicIncrement;
	}
	
	// Returns the "Knights of the Frozen Throne" epic increment field
	public JTextArea getKnightsEpicIncrement() 
	{
		return knightsEpicIncrement;
	}
	
	// Returns the "Journey to Un'Goro" epic increment field
	public JTextArea getUngoroEpicIncrement() 
	{
		return ungoroEpicIncrement;
	}
	
	// Returns the "Mean Streets of Gadgetzan" epic increment field
	public JTextArea getGadgetzanEpicIncrement() 
	{
		return gadgetzanEpicIncrement;
	}
	
	// Returns the "Whispers of the Old Gods" epic increment field
	public JTextArea getOldGodsEpicIncrement() 
	{
		return oldGodsEpicIncrement;
	}
	
	// Returns the "The Grand Tournament" epic increment field
	public JTextArea getTournamentEpicIncrement() 
	{
		return tournamentEpicIncrement;
	}
	
	// Returns the "Goblins vs Gnomes" epic increment field
	public JTextArea getGoblinsEpicIncrement() 
	{
		return goblinsEpicIncrement;
	}
	
	// Returns the "Classic" epic increment field
	public JTextArea getClassicEpicIncrement() 
	{
		return classicEpicIncrement;
	}
	
	// Returns the value of "Forged in the Barrens" epic probability
	public String getBarrensEpicProbability() 
	{
		return barrensEpicProbability.replace("%", "").replace(",", ".");
	}
	
	// Returns the value of "Madness at the Darkmoon Faire" epic probability
	public String getDarkmoonEpicProbability() 
	{
		return darkmoonEpicProbability.replace("%", "").replace(",", ".");
	}
	
	// Returns the value of "Scholomance Academy" epic probability
	public String getScholomanceEpicProbability() 
	{
		return scholomanceEpicProbability.replace("%", "").replace(",", ".");
	}
	
	// Returns the value of "Ashes of Outland" epic probability
	public String getOutlandEpicProbability() 
	{
		return outlandEpicProbability.replace("%", "").replace(",", ".");
	}
	
	// Returns the value of "Descent of Dragons" epic probability
	public String getDragonsEpicProbability() 
	{
		return dragonsEpicProbability.replace("%", "").replace(",", ".");
	}
	
	// Returns the value of "Saviors of Uldum" epic probability
	public String getUldumEpicProbability() 
	{
		return uldumEpicProbability.replace("%", "").replace(",", ".");
	}
	
	// Returns the value of "Rise of Shadows" epic probability
	public String getShadowsEpicProbability() 
	{
		return shadowsEpicProbability.replace("%", "").replace(",", ".");
	}
	
	// Returns the value of "Rastakhan's Rumble" epic probability
	public String getRumbleEpicProbability() 
	{
		return rumbleEpicProbability.replace("%", "").replace(",", ".");
	}
	
	// Returns the value of "The Boomsday Project" epic probability
	public String getBoomsdayEpicProbability() 
	{
		return boomsdayEpicProbability.replace("%", "").replace(",", ".");
	}
	
	// Returns the value of "The Witchwood" epic probability
	public String getWitchwoodEpicProbability() 
	{
		return witchwoodEpicProbability.replace("%", "").replace(",", ".");
	}
	
	// Returns the value of "Kobolds & Catacombs" epic probability
	public String getKoboldsEpicProbability() 
	{
		return koboldsEpicProbability.replace("%", "").replace(",", ".");
	}
	
	// Returns the value of "Knights of the Frozen Throne" epic probability
	public String getKnightsEpicProbability() 
	{
		return knightsEpicProbability.replace("%", "").replace(",", ".");
	}
	
	// Returns the value of "Journey to Un'Goro" epic probability
	public String getUngoroEpicProbability() 
	{
		return ungoroEpicProbability.replace("%", "").replace(",", ".");
	}
	
	// Returns the value of "Mean Streets of Gadgetzan" epic probability
	public String getGadgetzanEpicProbability() 
	{
		return gadgetzanEpicProbability.replace("%", "").replace(",", ".");
	}
	
	// Returns the value of "Whispers of the Old Gods" epic probability
	public String getOldGodsEpicProbability() 
	{
		return oldGodsEpicProbability.replace("%", "").replace(",", ".");
	}
	
	// Returns the value of "The Grand Tournament" epic probability
	public String getTournamentEpicProbability() 
	{
		return tournamentEpicProbability.replace("%", "").replace(",", ".");
	}
	
	// Returns the value of "Goblins vs Gnomes" epic probability
	public String getGoblinsEpicProbability() 
	{
		return goblinsEpicProbability.replace("%", "").replace(",", ".");
	}
	
	// Returns the value of "Classic" epic probability
	public String getClassicEpicProbability() 
	{
		return classicEpicProbability.replace("%", "").replace(",", ".");
	}
	
	// Sets the value of "Forged in the Barrens" epic probability
	public void setBarrensEpicProbability(String value) 
	{
		barrensEpicProbability = value + "%";
		barrensEpicProbabilityText.setText("");
		doc = barrensEpicProbabilityText.getStyledDocument();
		changePanelTextStyle(barrens, barrensEpicProbabilityText, epicProbabilityText, barrensEpicProbability);
	}
	
	// Sets the value of "Madness at the Darkmoon Faire" epic probability
	public void setDarkmoonEpicProbability(String value) 
	{
		darkmoonEpicProbability = value + "%";
		darkmoonEpicProbabilityText.setText("");
		doc = darkmoonEpicProbabilityText.getStyledDocument();
		changePanelTextStyle(darkmoon, darkmoonEpicProbabilityText, epicProbabilityText, darkmoonEpicProbability);
	}
	
	// Sets the value of "Scholomance Academy" epic probability
	public void setScholomanceEpicProbability(String value) 
	{
		scholomanceEpicProbability = value + "%";
		scholomanceEpicProbabilityText.setText("");
		doc = scholomanceEpicProbabilityText.getStyledDocument();
		changePanelTextStyle(scholomance, scholomanceEpicProbabilityText, epicProbabilityText, scholomanceEpicProbability);
	}
	
	// Sets the value of "Ashes of Outland" epic probability
	public void setOutlandEpicProbability(String value) 
	{
		outlandEpicProbability = value + "%";
		outlandEpicProbabilityText.setText("");
		doc = outlandEpicProbabilityText.getStyledDocument();
		changePanelTextStyle(outland, outlandEpicProbabilityText, epicProbabilityText, outlandEpicProbability);
	}
	
	// Sets the value of "Descent of Dragons" epic probability
	public void setDragonsEpicProbability(String value) 
	{
		dragonsEpicProbability = value + "%";
		dragonsEpicProbabilityText.setText("");
		doc = dragonsEpicProbabilityText.getStyledDocument();
		changePanelTextStyle(dragons, dragonsEpicProbabilityText, epicProbabilityText, dragonsEpicProbability);
	}
	
	// Sets the value of "Saviors of Uldum" epic probability
	public void setUldumEpicProbability(String value) 
	{
		uldumEpicProbability = value + "%";
		uldumEpicProbabilityText.setText("");
		doc = uldumEpicProbabilityText.getStyledDocument();
		changePanelTextStyle(uldum, uldumEpicProbabilityText, epicProbabilityText, uldumEpicProbability);
	}
	
	// Sets the value of "Rise of Shadows" epic probability
	public void setShadowsEpicProbability(String value) 
	{
		shadowsEpicProbability = value + "%";
		shadowsEpicProbabilityText.setText("");
		doc = shadowsEpicProbabilityText.getStyledDocument();
		changePanelTextStyle(shadows, shadowsEpicProbabilityText, epicProbabilityText, shadowsEpicProbability);
	}
	
	// Sets the value of "Rastakhan's Rumble" epic probability
	public void setRumbleEpicProbability(String value) 
	{
		rumbleEpicProbability = value + "%";
		rumbleEpicProbabilityText.setText("");
		doc = rumbleEpicProbabilityText.getStyledDocument();
		changePanelTextStyle(rumble, rumbleEpicProbabilityText, epicProbabilityText, rumbleEpicProbability);
	}
	
	// Sets the value of "The Boomsday Project" epic probability
	public void setBoomsdayEpicProbability(String value) 
	{
		boomsdayEpicProbability = value + "%";
		boomsdayEpicProbabilityText.setText("");
		doc = boomsdayEpicProbabilityText.getStyledDocument();
		changePanelTextStyle(boomsday, boomsdayEpicProbabilityText, epicProbabilityText, boomsdayEpicProbability);
	}
	
	// Sets the value of "The Witchwood" epic probability
	public void setWitchwoodEpicProbability(String value) 
	{
		witchwoodEpicProbability = value + "%";
		witchwoodEpicProbabilityText.setText("");
		doc = witchwoodEpicProbabilityText.getStyledDocument();
		changePanelTextStyle(witchwood, witchwoodEpicProbabilityText, epicProbabilityText, witchwoodEpicProbability);
	}
	
	// Sets the value of "Kobolds & Catacombs" epic probability
	public void setKoboldsEpicProbability(String value) 
	{
		koboldsEpicProbability = value + "%";
		koboldsEpicProbabilityText.setText("");
		doc = koboldsEpicProbabilityText.getStyledDocument();
		changePanelTextStyle(kobolds, koboldsEpicProbabilityText, epicProbabilityText, koboldsEpicProbability);
	}
	
	// Sets the value of "Knights of the Frozen Throne" epic probability
	public void setKnightsEpicProbability(String value) 
	{
		knightsEpicProbability = value + "%";
		knightsEpicProbabilityText.setText("");
		doc = knightsEpicProbabilityText.getStyledDocument();
		changePanelTextStyle(knights, knightsEpicProbabilityText, epicProbabilityText, knightsEpicProbability);
	}
	
	// Sets the value of "Journey to Un'Goro" epic probability
	public void setUngoroEpicProbability(String value) 
	{
		ungoroEpicProbability = value + "%";
		ungoroEpicProbabilityText.setText("");
		doc = ungoroEpicProbabilityText.getStyledDocument();
		changePanelTextStyle(ungoro, ungoroEpicProbabilityText, epicProbabilityText, ungoroEpicProbability);
	}
	
	// Sets the value of "Mean Streets of Gadgetzan" epic probability
	public void setGadgetzanEpicProbability(String value) 
	{
		gadgetzanEpicProbability = value + "%";
		gadgetzanEpicProbabilityText.setText("");
		doc = gadgetzanEpicProbabilityText.getStyledDocument();
		changePanelTextStyle(gadgetzan, gadgetzanEpicProbabilityText, epicProbabilityText, gadgetzanEpicProbability);
	}
	
	// Sets the value of "Whispers of the Old Gods" epic probability
	public void setOldGodsEpicProbability(String value) 
	{
		oldGodsEpicProbability = value + "%";
		oldGodsEpicProbabilityText.setText("");
		doc = oldGodsEpicProbabilityText.getStyledDocument();
		changePanelTextStyle(oldGods, oldGodsEpicProbabilityText, epicProbabilityText, oldGodsEpicProbability);
	}
	
	// Sets the value of "The Grand Tournament" epic probability
	public void setTournamentEpicProbability(String value) 
	{
		tournamentEpicProbability = value + "%";
		tournamentEpicProbabilityText.setText("");
		doc = tournamentEpicProbabilityText.getStyledDocument();
		changePanelTextStyle(tournament, tournamentEpicProbabilityText, epicProbabilityText, tournamentEpicProbability);
	}
	
	// Sets the value of "Goblins vs Gnomes" epic probability
	public void setGoblinsEpicProbability(String value) 
	{
		goblinsEpicProbability = value + "%";
		goblinsEpicProbabilityText.setText("");
		doc = goblinsEpicProbabilityText.getStyledDocument();
		changePanelTextStyle(goblins, goblinsEpicProbabilityText, epicProbabilityText, goblinsEpicProbability);
	}
	
	// Sets the value of "Classic" epic probability
	public void setClassicEpicProbability(String value) 
	{
		classicEpicProbability = value + "%";
		classicEpicProbabilityText.setText("");
		doc = classicEpicProbabilityText.getStyledDocument();
		changePanelTextStyle(classic, classicEpicProbabilityText, epicProbabilityText, classicEpicProbability);
	}
	
	// Returns the value of "Forged in the Barrens" legendary counter
	public String getBarrensLegendaryCounter() 
	{
		return barrensLegendaryCounter;
	}
	
	// Returns the value of "Madness at the Darkmoon Faire" legendary counter
	public String getDarkmoonLegendaryCounter() 
	{
		return darkmoonLegendaryCounter;
	}
	
	// Returns the value of "Scholomance Academy" legendary counter
	public String getScholomanceLegendaryCounter() 
	{
		return scholomanceLegendaryCounter;
	}
	
	// Returns the value of "Ashes of Outland" legendary counter
	public String getOutlandLegendaryCounter() 
	{
		return outlandLegendaryCounter;
	}
	
	// Returns the value of "Descent of Dragons" legendary counter
	public String getDragonsLegendaryCounter() 
	{
		return dragonsLegendaryCounter;
	}
	
	// Returns the value of "Saviors of Uldum" legendary counter
	public String getUldumLegendaryCounter() 
	{
		return uldumLegendaryCounter;
	}
	
	// Returns the value of "Rise of Shadows" legendary counter
	public String getShadowsLegendaryCounter() 
	{
		return shadowsLegendaryCounter;
	}
	
	// Returns the value of "Rastakhan's Rumble" legendary counter
	public String getRumbleLegendaryCounter() 
	{
		return rumbleLegendaryCounter;
	}
	
	// Returns the value of "The Boomsday Project" legendary counter
	public String getBoomsdayLegendaryCounter() 
	{
		return boomsdayLegendaryCounter;
	}
	
	// Returns the value of "The Witchwood" legendary counter
	public String getWitchwoodLegendaryCounter() 
	{
		return witchwoodLegendaryCounter;
	}
	
	// Returns the value of "Kobolds & Catacombs" legendary counter
	public String getKoboldsLegendaryCounter() 
	{
		return koboldsLegendaryCounter;
	}
	
	// Returns the value of "Knights of the Frozen Throne" legendary counter
	public String getKnightsLegendaryCounter() 
	{
		return knightsLegendaryCounter;
	}
	
	// Returns the value of "Journey to Un'Goro" legendary counter
	public String getUngoroLegendaryCounter() 
	{
		return ungoroLegendaryCounter;
	}
	
	// Returns the value of "Mean Streets of Gadgetzan" legendary counter
	public String getGadgetzanLegendaryCounter() 
	{
		return gadgetzanLegendaryCounter;
	}
	
	// Returns the value of "Whispers of the Old Gods" legendary counter
	public String getOldGodsLegendaryCounter() 
	{
		return oldGodsLegendaryCounter;
	}
	
	// Returns the value of "The Grand Tournament" legendary counter
	public String getTournamentLegendaryCounter() 
	{
		return tournamentLegendaryCounter;
	}
	
	// Returns the value of "Goblins vs Gnomes" legendary counter
	public String getGoblinsLegendaryCounter() 
	{
		return goblinsLegendaryCounter;
	}
	
	// Returns the value of "Classic" legendary counter
	public String getClassicLegendaryCounter() 
	{
		return classicLegendaryCounter;
	}
	
	// Sets the value of "Forged in the Barrens" legendary counter
	public void setBarrensLegendaryCounter(String value) 
	{
		barrensLegendaryCounter = value;
		barrensLegendaryCounterText.setText("");
		doc = barrensLegendaryCounterText.getStyledDocument();
		changePanelTextStyle(barrens, barrensLegendaryCounterText, legendaryCounterText, barrensLegendaryCounter);
	}
	
	// Sets the value of "Madness at the Darkmoon Faire" legendary counter
	public void setDarkmoonLegendaryCounter(String value) 
	{
		darkmoonLegendaryCounter = value;
		darkmoonLegendaryCounterText.setText("");
		doc = darkmoonLegendaryCounterText.getStyledDocument();
		changePanelTextStyle(darkmoon, darkmoonLegendaryCounterText, legendaryCounterText, darkmoonLegendaryCounter);
	}
	
	// Sets the value of "Scholomance Academy" legendary counter
	public void setScholomanceLegendaryCounter(String value) 
	{
		scholomanceLegendaryCounter = value;
		scholomanceLegendaryCounterText.setText("");
		doc = scholomanceLegendaryCounterText.getStyledDocument();
		changePanelTextStyle(scholomance, scholomanceLegendaryCounterText, legendaryCounterText, scholomanceLegendaryCounter);
	}
	
	// Sets the value of "Ashes of Outland" legendary counter
	public void setOutlandLegendaryCounter(String value) 
	{
		outlandLegendaryCounter = value;
		outlandLegendaryCounterText.setText("");
		doc = outlandLegendaryCounterText.getStyledDocument();
		changePanelTextStyle(outland, outlandLegendaryCounterText, legendaryCounterText, outlandLegendaryCounter);
	}
	
	// Sets the value of "Descent of Dragons" legendary counter
	public void setDragonsLegendaryCounter(String value) 
	{
		dragonsLegendaryCounter = value;
		dragonsLegendaryCounterText.setText("");
		doc = dragonsLegendaryCounterText.getStyledDocument();
		changePanelTextStyle(dragons, dragonsLegendaryCounterText, legendaryCounterText, dragonsLegendaryCounter);
	}
	
	// Sets the value of "Saviors of Uldum" legendary counter
	public void setUldumLegendaryCounter(String value) 
	{
		uldumLegendaryCounter = value;
		uldumLegendaryCounterText.setText("");
		doc = uldumLegendaryCounterText.getStyledDocument();
		changePanelTextStyle(uldum, uldumLegendaryCounterText, legendaryCounterText, uldumLegendaryCounter);
	}
	
	// Sets the value of "Rise of Shadows" legendary counter
	public void setShadowsLegendaryCounter(String value) 
	{
		shadowsLegendaryCounter = value;
		shadowsLegendaryCounterText.setText("");
		doc = shadowsLegendaryCounterText.getStyledDocument();
		changePanelTextStyle(shadows, shadowsLegendaryCounterText, legendaryCounterText, shadowsLegendaryCounter);
	}
	
	// Sets the value of "Rastakhan's Rumble" legendary counter
	public void setRumbleLegendaryCounter(String value) 
	{
		rumbleLegendaryCounter = value;
		rumbleLegendaryCounterText.setText("");
		doc = rumbleLegendaryCounterText.getStyledDocument();
		changePanelTextStyle(rumble, rumbleLegendaryCounterText, legendaryCounterText, rumbleLegendaryCounter);
	}
	
	// Sets the value of "The Boomsday Project" legendary counter
	public void setBoomsdayLegendaryCounter(String value) 
	{
		boomsdayLegendaryCounter = value;
		boomsdayLegendaryCounterText.setText("");
		doc = boomsdayLegendaryCounterText.getStyledDocument();
		changePanelTextStyle(boomsday, boomsdayLegendaryCounterText, legendaryCounterText, boomsdayLegendaryCounter);
	}
	
	// Sets the value of "The Witchwood" legendary counter
	public void setWitchwoodLegendaryCounter(String value) 
	{
		witchwoodLegendaryCounter = value;
		witchwoodLegendaryCounterText.setText("");
		doc = witchwoodLegendaryCounterText.getStyledDocument();
		changePanelTextStyle(witchwood, witchwoodLegendaryCounterText, legendaryCounterText, witchwoodLegendaryCounter);
	}
	
	// Sets the value of "Kobolds & Catacombs" legendary counter
	public void setKoboldsLegendaryCounter(String value) 
	{
		koboldsLegendaryCounter = value;
		koboldsLegendaryCounterText.setText("");
		doc = koboldsLegendaryCounterText.getStyledDocument();
		changePanelTextStyle(kobolds, koboldsLegendaryCounterText, legendaryCounterText, koboldsLegendaryCounter);
	}
	
	// Sets the value of "Knights of the Frozen Throne" legendary counter
	public void setKnightsLegendaryCounter(String value) 
	{
		knightsLegendaryCounter = value;
		knightsLegendaryCounterText.setText("");
		doc = knightsLegendaryCounterText.getStyledDocument();
		changePanelTextStyle(knights, knightsLegendaryCounterText, legendaryCounterText, knightsLegendaryCounter);
	}
	
	// Sets the value of "Journey to Un'Goro" legendary counter
	public void setUngoroLegendaryCounter(String value) 
	{
		ungoroLegendaryCounter = value;
		ungoroLegendaryCounterText.setText("");
		doc = ungoroLegendaryCounterText.getStyledDocument();
		changePanelTextStyle(ungoro, ungoroLegendaryCounterText, legendaryCounterText, ungoroLegendaryCounter);
	}
	
	// Sets the value of "Mean Streets of Gadgetzan" legendary counter
	public void setGadgetzanLegendaryCounter(String value) 
	{
		gadgetzanLegendaryCounter = value;
		gadgetzanLegendaryCounterText.setText("");
		doc = gadgetzanLegendaryCounterText.getStyledDocument();
		changePanelTextStyle(gadgetzan, gadgetzanLegendaryCounterText, legendaryCounterText, gadgetzanLegendaryCounter);
	}
	
	// Sets the value of "Whispers of the Old Gods" legendary counter
	public void setOldGodsLegendaryCounter(String value) 
	{
		oldGodsLegendaryCounter = value;
		oldGodsLegendaryCounterText.setText("");
		doc = oldGodsLegendaryCounterText.getStyledDocument();
		changePanelTextStyle(oldGods, oldGodsLegendaryCounterText, legendaryCounterText, oldGodsLegendaryCounter);
	}
	
	// Sets the value of "The Grand Tournament" legendary counter
	public void setTournamentLegendaryCounter(String value) 
	{
		tournamentLegendaryCounter = value;
		tournamentLegendaryCounterText.setText("");
		doc = tournamentLegendaryCounterText.getStyledDocument();
		changePanelTextStyle(tournament, tournamentLegendaryCounterText, legendaryCounterText, tournamentLegendaryCounter);
	}
	
	// Sets the value of "Goblins vs Gnomes" legendary counter
	public void setGoblinsLegendaryCounter(String value) 
	{
		goblinsLegendaryCounter = value;
		goblinsLegendaryCounterText.setText("");
		doc = goblinsLegendaryCounterText.getStyledDocument();
		changePanelTextStyle(goblins, goblinsLegendaryCounterText, legendaryCounterText, goblinsLegendaryCounter);
	}
	
	// Sets the value of "Classic" legendary counter
	public void setClassicLegendaryCounter(String value) 
	{
		classicLegendaryCounter = value;
		classicLegendaryCounterText.setText("");
		doc = classicLegendaryCounterText.getStyledDocument();
		changePanelTextStyle(classic, classicLegendaryCounterText, legendaryCounterText, classicLegendaryCounter);
	}
	
	// Returns the "Forged in the Barrens" legendary reset button
	public ModifierButton getBarrensLegendaryReset() 
	{
		return barrensLegendaryReset;
	}
	
	// Returns the "Madness at the Darkmoon Faire" legendary reset button
	public ModifierButton getDarkmoonLegendaryReset() 
	{
		return darkmoonLegendaryReset;
	}
	
	// Returns the "Scholomance Academy" legendary reset button
	public ModifierButton getScholomanceLegendaryReset() 
	{
		return scholomanceLegendaryReset;
	}
	
	// Returns the "Ashes of Outland" legendary reset button
	public ModifierButton getOutlandLegendaryReset() 
	{
		return outlandLegendaryReset;
	}
	
	// Returns the "Descent of Dragons" legendary reset button
	public ModifierButton getDragonsLegendaryReset() 
	{
		return dragonsLegendaryReset;
	}
	
	// Returns the "Saviors of Uldum" legendary reset button
	public ModifierButton getUldumLegendaryReset() 
	{
		return uldumLegendaryReset;
	}
	
	// Returns the "Rise of Shadows" legendary reset button
	public ModifierButton getShadowsLegendaryReset() 
	{
		return shadowsLegendaryReset;
	}
	
	// Returns the "Rastakhan's Rumble" legendary reset button
	public ModifierButton getRumbleLegendaryReset() 
	{
		return rumbleLegendaryReset;
	}
	
	// Returns the "The Boomsday Project" legendary reset button
	public ModifierButton getBoomsdayLegendaryReset() 
	{
		return boomsdayLegendaryReset;
	}
	
	// Returns the "The Witchwood" legendary reset button
	public ModifierButton getWitchwoodLegendaryReset() 
	{
		return witchwoodLegendaryReset;
	}
	
	// Returns the "Kobolds & Catacombs" legendary reset button
	public ModifierButton getKoboldsLegendaryReset() 
	{
		return koboldsLegendaryReset;
	}
	
	// Returns the "Knights of the Frozen Throne" legendary reset button
	public ModifierButton getKnightsLegendaryReset() 
	{
		return knightsLegendaryReset;
	}
	
	// Returns the "Journey to Un'Goro" legendary reset button
	public ModifierButton getUngoroLegendaryReset() 
	{
		return ungoroLegendaryReset;
	}
	
	// Returns the "Mean Streets of Gadgetzan" legendary reset button
	public ModifierButton getGadgetzanLegendaryReset() 
	{
		return gadgetzanLegendaryReset;
	}
	
	// Returns the "Whispers of the Old Gods" legendary reset button
	public ModifierButton getOldGodsLegendaryReset() 
	{
		return oldGodsLegendaryReset;
	}
	
	// Returns the "The Grand Tournament" legendary reset button
	public ModifierButton getTournamentLegendaryReset() 
	{
		return tournamentLegendaryReset;
	}
	
	// Returns the "Goblins vs Gnomes" legendary reset button
	public ModifierButton getGoblinsLegendaryReset() 
	{
		return goblinsLegendaryReset;
	}
	
	// Returns the "Classic" legendary reset button
	public ModifierButton getClassicLegendaryReset() 
	{
		return classicLegendaryReset;
	}
	
	// Returns the "Forged in the Barrens" legendary add button
	public RoundButton getBarrensLegendaryAdd() 
	{
		return barrensLegendaryAdd;
	}
	
	// Returns the "Madness at the Darkmoon Faire" legendary add button
	public RoundButton getDarkmoonLegendaryAdd() 
	{
		return darkmoonLegendaryAdd;
	}
	
	// Returns the "Scholomance Academy" legendary add button
	public RoundButton getScholomanceLegendaryAdd() 
	{
		return scholomanceLegendaryAdd;
	}
	
	// Returns the "Ashes of Outland" legendary add button
	public RoundButton getOutlandLegendaryAdd() 
	{
		return outlandLegendaryAdd;
	}
	
	// Returns the "Descent of Dragons" legendary add button
	public RoundButton getDragonsLegendaryAdd() 
	{
		return dragonsLegendaryAdd;
	}
	
	// Returns the "Saviors of Uldum" legendary add button
	public RoundButton getUldumLegendaryAdd() 
	{
		return uldumLegendaryAdd;
	}
	
	// Returns the "Rise of Shadows" legendary add button
	public RoundButton getShadowsLegendaryAdd() 
	{
		return shadowsLegendaryAdd;
	}
	
	// Returns the "Rastakhan's Rumble" legendary add button
	public RoundButton getRumbleLegendaryAdd() 
	{
		return rumbleLegendaryAdd;
	}
	
	// Returns the "The Boomsday Project" legendary add button
	public RoundButton getBoomsdayLegendaryAdd() 
	{
		return boomsdayLegendaryAdd;
	}
	
	// Returns the "The Witchwood" legendary add button
	public RoundButton getWitchwoodLegendaryAdd() 
	{
		return witchwoodLegendaryAdd;
	}
	
	// Returns the "Kobolds & Catacombs" legendary add button
	public RoundButton getKoboldsLegendaryAdd() 
	{
		return koboldsLegendaryAdd;
	}
	
	// Returns the "Knights of the Frozen Throne" legendary add button
	public RoundButton getKnightsLegendaryAdd() 
	{
		return knightsLegendaryAdd;
	}
	
	// Returns the "Journey to Un'Goro" legendary add button
	public RoundButton getUngoroLegendaryAdd() 
	{
		return ungoroLegendaryAdd;
	}
	
	// Returns the "Mean Streets of Gadgetzan" legendary add button
	public RoundButton getGadgetzanLegendaryAdd() 
	{
		return gadgetzanLegendaryAdd;
	}
	
	// Returns the "Whispers of the Old Gods" legendary add button
	public RoundButton getOldGodsLegendaryAdd() 
	{
		return oldGodsLegendaryAdd;
	}
	
	// Returns the "The Grand Tournament" legendary add button
	public RoundButton getTournamentLegendaryAdd() 
	{
		return tournamentLegendaryAdd;
	}
	
	// Returns the "Goblins vs Gnomes" legendary add button
	public RoundButton getGoblinsLegendaryAdd() 
	{
		return goblinsLegendaryAdd;
	}
	
	// Returns the "Classic" legendary add button
	public RoundButton getClassicLegendaryAdd() 
	{
		return classicLegendaryAdd;
	}
	
	// Returns the "Forged in the Barrens" legendary increment field
	public JTextArea getBarrensLegendaryIncrement() 
	{
		return barrensLegendaryIncrement;
	}
	
	// Returns the "Madness at the Darkmoon Faire" legendary increment field
	public JTextArea getDarkmoonLegendaryIncrement() 
	{
		return darkmoonLegendaryIncrement;
	}
	
	// Returns the "Scholomance Academy" legendary increment field
	public JTextArea getScholomanceLegendaryIncrement() 
	{
		return scholomanceLegendaryIncrement;
	}
	
	// Returns the "Ashes of Outland" legendary increment field
	public JTextArea getOutlandLegendaryIncrement() 
	{
		return outlandLegendaryIncrement;
	}
	
	// Returns the "Descent of Dragons" legendary increment field
	public JTextArea getDragonsLegendaryIncrement() 
	{
		return dragonsLegendaryIncrement;
	}
	
	// Returns the "Saviors of Uldum" legendary increment field
	public JTextArea getUldumLegendaryIncrement() 
	{
		return uldumLegendaryIncrement;
	}
	
	// Returns the "Rise of Shadows" legendary increment field
	public JTextArea getShadowsLegendaryIncrement() 
	{
		return shadowsLegendaryIncrement;
	}
	
	// Returns the "Rastakhan's Rumble" legendary increment field
	public JTextArea getRumbleLegendaryIncrement() 
	{
		return rumbleLegendaryIncrement;
	}
	
	// Returns the "The Boomsday Project" legendary increment field
	public JTextArea getBoomsdayLegendaryIncrement() 
	{
		return boomsdayLegendaryIncrement;
	}
	
	// Returns the "The Witchwood" legendary increment field
	public JTextArea getWitchwoodLegendaryIncrement() 
	{
		return witchwoodLegendaryIncrement;
	}
	
	// Returns the "Kobolds & Catacombs" legendary increment field
	public JTextArea getKoboldsLegendaryIncrement() 
	{
		return koboldsLegendaryIncrement;
	}
	
	// Returns the "Knights of the Frozen Throne" legendary increment field
	public JTextArea getKnightsLegendaryIncrement() 
	{
		return knightsLegendaryIncrement;
	}
	
	// Returns the "Journey to Un'Goro" legendary increment field
	public JTextArea getUngoroLegendaryIncrement() 
	{
		return ungoroLegendaryIncrement;
	}
	
	// Returns the "Mean Streets of Gadgetzan" legendary increment field
	public JTextArea getGadgetzanLegendaryIncrement() 
	{
		return gadgetzanLegendaryIncrement;
	}
	
	// Returns the "Whispers of the Old Gods" legendary increment field
	public JTextArea getOldGodsLegendaryIncrement() 
	{
		return oldGodsLegendaryIncrement;
	}
	
	// Returns the "The Grand Tournament" legendary increment field
	public JTextArea getTournamentLegendaryIncrement() 
	{
		return tournamentLegendaryIncrement;
	}
	
	// Returns the "Goblins vs Gnomes" legendary increment field
	public JTextArea getGoblinsLegendaryIncrement() 
	{
		return goblinsLegendaryIncrement;
	}
	
	// Returns the "Classic" legendary increment field
	public JTextArea getClassicLegendaryIncrement() 
	{
		return classicLegendaryIncrement;
	}
	
	// Returns the value of "Forged in the Barrens" legendary probability
	public String getBarrensLegendaryProbability() 
	{
		return barrensLegendaryProbability.replace("%", "").replace(",", ".");
	}
	
	// Returns the value of "Madness at the Darkmoon Faire" legendary probability
	public String getDarkmoonLegendaryProbability() 
	{
		return darkmoonLegendaryProbability.replace("%", "").replace(",", ".");
	}
	
	// Returns the value of "Scholomance Academy" legendary probability
	public String getScholomanceLegendaryProbability() 
	{
		return scholomanceLegendaryProbability.replace("%", "").replace(",", ".");
	}
	
	// Returns the value of "Ashes of Outland" legendary probability
	public String getOutlandLegendaryProbability() 
	{
		return outlandLegendaryProbability.replace("%", "").replace(",", ".");
	}
	
	// Returns the value of "Descent of Dragons" legendary probability
	public String getDragonsLegendaryProbability() 
	{
		return dragonsLegendaryProbability.replace("%", "").replace(",", ".");
	}
	
	// Returns the value of "Saviors of Uldum" legendary probability
	public String getUldumLegendaryProbability() 
	{
		return uldumLegendaryProbability.replace("%", "").replace(",", ".");
	}
	
	// Returns the value of "Rise of Shadows" legendary probability
	public String getShadowsLegendaryProbability() 
	{
		return shadowsLegendaryProbability.replace("%", "").replace(",", ".");
	}
	
	// Returns the value of "Rastakhan's Rumble" legendary probability
	public String getRumbleLegendaryProbability() 
	{
		return rumbleLegendaryProbability.replace("%", "").replace(",", ".");
	}
	
	// Returns the value of "The Boomsday Project" legendary probability
	public String getBoomsdayLegendaryProbability() 
	{
		return boomsdayLegendaryProbability.replace("%", "").replace(",", ".");
	}
	
	// Returns the value of "The Witchwood" legendary probability
	public String getWitchwoodLegendaryProbability() 
	{
		return witchwoodLegendaryProbability.replace("%", "").replace(",", ".");
	}
	
	// Returns the value of "Kobolds & Catacombs" legendary probability
	public String getKoboldsLegendaryProbability() 
	{
		return koboldsLegendaryProbability.replace("%", "").replace(",", ".");
	}
	
	// Returns the value of "Knights of the Frozen Throne" legendary probability
	public String getKnightsLegendaryProbability() 
	{
		return knightsLegendaryProbability.replace("%", "").replace(",", ".");
	}
	
	// Returns the value of "Journey to Un'Goro" legendary probability
	public String getUngoroLegendaryProbability() 
	{
		return ungoroLegendaryProbability.replace("%", "").replace(",", ".");
	}
	
	// Returns the value of "Mean Streets of Gadgetzan" legendary probability
	public String getGadgetzanLegendaryProbability() 
	{
		return gadgetzanLegendaryProbability.replace("%", "").replace(",", ".");
	}
	
	// Returns the value of "Whispers of the Old Gods" legendary probability
	public String getOldGodsLegendaryProbability() 
	{
		return oldGodsLegendaryProbability.replace("%", "").replace(",", ".");
	}
	
	// Returns the value of "The Grand Tournament" legendary probability
	public String getTournamentLegendaryProbability() 
	{
		return tournamentLegendaryProbability.replace("%", "").replace(",", ".");
	}
	
	// Returns the value of "Goblins vs Gnomes" legendary probability
	public String getGoblinsLegendaryProbability() 
	{
		return goblinsLegendaryProbability.replace("%", "").replace(",", ".");
	}
	
	// Returns the value of "Classic" legendary probability
	public String getClassicLegendaryProbability() 
	{
		return classicLegendaryProbability.replace("%", "").replace(",", ".");
	}
	
	// Sets the value of "Forged in the Barrens" legendary probability
	public void setBarrensLegendaryProbability(String value) 
	{
		barrensLegendaryProbability = value + "%";
		barrensLegendaryProbabilityText.setText("");
		doc = barrensLegendaryProbabilityText.getStyledDocument();
		changePanelTextStyle(barrens, barrensLegendaryProbabilityText, legendaryProbabilityText, barrensLegendaryProbability);
	}
	
	// Sets the value of "Madness at the Darkmoon Faire" legendary probability
	public void setDarkmoonLegendaryProbability(String value) 
	{
		darkmoonLegendaryProbability = value + "%";
		darkmoonLegendaryProbabilityText.setText("");
		doc = darkmoonLegendaryProbabilityText.getStyledDocument();
		changePanelTextStyle(darkmoon, darkmoonLegendaryProbabilityText, legendaryProbabilityText, darkmoonLegendaryProbability);
	}
	
	// Sets the value of "Scholomance Academy" legendary probability
	public void setScholomanceLegendaryProbability(String value) 
	{
		scholomanceLegendaryProbability = value + "%";
		scholomanceLegendaryProbabilityText.setText("");
		doc = scholomanceLegendaryProbabilityText.getStyledDocument();
		changePanelTextStyle(scholomance, scholomanceLegendaryProbabilityText, legendaryProbabilityText, scholomanceLegendaryProbability);
	}
	
	// Sets the value of "Ashes of Outland" legendary probability
	public void setOutlandLegendaryProbability(String value) 
	{
		outlandLegendaryProbability = value + "%";
		outlandLegendaryProbabilityText.setText("");
		doc = outlandLegendaryProbabilityText.getStyledDocument();
		changePanelTextStyle(outland, outlandLegendaryProbabilityText, legendaryProbabilityText, outlandLegendaryProbability);
	}
	
	// Sets the value of "Descent of Dragons" legendary probability
	public void setDragonsLegendaryProbability(String value) 
	{
		dragonsLegendaryProbability = value + "%";
		dragonsLegendaryProbabilityText.setText("");
		doc = dragonsLegendaryProbabilityText.getStyledDocument();
		changePanelTextStyle(dragons, dragonsLegendaryProbabilityText, legendaryProbabilityText, dragonsLegendaryProbability);
	}
	
	// Sets the value of "Saviors of Uldum" legendary probability
	public void setUldumLegendaryProbability(String value) 
	{
		uldumLegendaryProbability = value + "%";
		uldumLegendaryProbabilityText.setText("");
		doc = uldumLegendaryProbabilityText.getStyledDocument();
		changePanelTextStyle(uldum, uldumLegendaryProbabilityText, legendaryProbabilityText, uldumLegendaryProbability);
	}
	
	// Sets the value of "Rise of Shadows" legendary probability
	public void setShadowsLegendaryProbability(String value) 
	{
		shadowsLegendaryProbability = value + "%";
		shadowsLegendaryProbabilityText.setText("");
		doc = shadowsLegendaryProbabilityText.getStyledDocument();
		changePanelTextStyle(shadows, shadowsLegendaryProbabilityText, legendaryProbabilityText, shadowsLegendaryProbability);
	}
	
	// Sets the value of "Rastakhan's Rumble" legendary probability
	public void setRumbleLegendaryProbability(String value) 
	{
		rumbleLegendaryProbability = value + "%";
		rumbleLegendaryProbabilityText.setText("");
		doc = rumbleLegendaryProbabilityText.getStyledDocument();
		changePanelTextStyle(rumble, rumbleLegendaryProbabilityText, legendaryProbabilityText, rumbleLegendaryProbability);
	}
	
	// Sets the value of "The Boomsday Project" legendary probability
	public void setBoomsdayLegendaryProbability(String value) 
	{
		boomsdayLegendaryProbability = value + "%";
		boomsdayLegendaryProbabilityText.setText("");
		doc = boomsdayLegendaryProbabilityText.getStyledDocument();
		changePanelTextStyle(boomsday, boomsdayLegendaryProbabilityText, legendaryProbabilityText, boomsdayLegendaryProbability);
	}
	
	// Sets the value of "The Witchwood" legendary probability
	public void setWitchwoodLegendaryProbability(String value) 
	{
		witchwoodLegendaryProbability = value + "%";
		witchwoodLegendaryProbabilityText.setText("");
		doc = witchwoodLegendaryProbabilityText.getStyledDocument();
		changePanelTextStyle(witchwood, witchwoodLegendaryProbabilityText, legendaryProbabilityText, witchwoodLegendaryProbability);
	}
	
	// Sets the value of "Kobolds & Catacombs" legendary probability
	public void setKoboldsLegendaryProbability(String value) 
	{
		koboldsLegendaryProbability = value + "%";
		koboldsLegendaryProbabilityText.setText("");
		doc = koboldsLegendaryProbabilityText.getStyledDocument();
		changePanelTextStyle(kobolds, koboldsLegendaryProbabilityText, legendaryProbabilityText, koboldsLegendaryProbability);
	}
	
	// Sets the value of "Knights of the Frozen Throne" legendary probability
	public void setKnightsLegendaryProbability(String value) 
	{
		knightsLegendaryProbability = value + "%";
		knightsLegendaryProbabilityText.setText("");
		doc = knightsLegendaryProbabilityText.getStyledDocument();
		changePanelTextStyle(knights, knightsLegendaryProbabilityText, legendaryProbabilityText, knightsLegendaryProbability);
	}
	
	// Sets the value of "Journey to Un'Goro" legendary probability
	public void setUngoroLegendaryProbability(String value) 
	{
		ungoroLegendaryProbability = value + "%";
		ungoroLegendaryProbabilityText.setText("");
		doc = ungoroLegendaryProbabilityText.getStyledDocument();
		changePanelTextStyle(ungoro, ungoroLegendaryProbabilityText, legendaryProbabilityText, ungoroLegendaryProbability);
	}
	
	// Sets the value of "Mean Streets of Gadgetzan" legendary probability
	public void setGadgetzanLegendaryProbability(String value) 
	{
		gadgetzanLegendaryProbability = value + "%";
		gadgetzanLegendaryProbabilityText.setText("");
		doc = gadgetzanLegendaryProbabilityText.getStyledDocument();
		changePanelTextStyle(gadgetzan, gadgetzanLegendaryProbabilityText, legendaryProbabilityText, gadgetzanLegendaryProbability);
	}
	
	// Sets the value of "Whispers of the Old Gods" legendary probability
	public void setOldGodsLegendaryProbability(String value) 
	{
		oldGodsLegendaryProbability = value + "%";
		oldGodsLegendaryProbabilityText.setText("");
		doc = oldGodsLegendaryProbabilityText.getStyledDocument();
		changePanelTextStyle(oldGods, oldGodsLegendaryProbabilityText, legendaryProbabilityText, oldGodsLegendaryProbability);
	}
	
	// Sets the value of "The Grand Tournament" legendary probability
	public void setTournamentLegendaryProbability(String value) 
	{
		tournamentLegendaryProbability = value + "%";
		tournamentLegendaryProbabilityText.setText("");
		doc = tournamentLegendaryProbabilityText.getStyledDocument();
		changePanelTextStyle(tournament, tournamentLegendaryProbabilityText, legendaryProbabilityText, tournamentLegendaryProbability);
	}
	
	// Sets the value of "Goblins vs Gnomes" legendary probability
	public void setGoblinsLegendaryProbability(String value) 
	{
		goblinsLegendaryProbability = value + "%";
		goblinsLegendaryProbabilityText.setText("");
		doc = goblinsLegendaryProbabilityText.getStyledDocument();
		changePanelTextStyle(goblins, goblinsLegendaryProbabilityText, legendaryProbabilityText, goblinsLegendaryProbability);
	}
	
	// Sets the value of "Classic" legendary probability
	public void setClassicLegendaryProbability(String value) 
	{
		classicLegendaryProbability = value + "%";
		classicLegendaryProbabilityText.setText("");
		doc = classicLegendaryProbabilityText.getStyledDocument();
		changePanelTextStyle(classic, classicLegendaryProbabilityText, legendaryProbabilityText, classicLegendaryProbability);
	}
	
	// Returns the value of "Forged in the Barrens" total counter
	public String getBarrensTotalCounter() 
	{
		return barrensTotalCounter;
	}
	
	// Returns the value of "Madness at the Darkmoon Faire" total counter
	public String getDarkmoonTotalCounter() 
	{
		return darkmoonTotalCounter;
	}
	
	// Returns the value of "Scholomance Academy" total counter
	public String getScholomanceTotalCounter() 
	{
		return scholomanceTotalCounter;
	}
	
	// Returns the value of "Ashes of Outland" total counter
	public String getOutlandTotalCounter() 
	{
		return outlandTotalCounter;
	}
	
	// Returns the value of "Descent of Dragons" total counter
	public String getDragonsTotalCounter() 
	{
		return dragonsTotalCounter;
	}
	
	// Returns the value of "Saviors of Uldum" total counter
	public String getUldumTotalCounter() 
	{
		return uldumTotalCounter;
	}
	
	// Returns the value of "Rise of Shadows" total counter
	public String getShadowsTotalCounter() 
	{
		return shadowsTotalCounter;
	}
	
	// Returns the value of "Rastakhan's Rumble" total counter
	public String getRumbleTotalCounter() 
	{
		return rumbleTotalCounter;
	}
	
	// Returns the value of "The Boomsday Project" total counter
	public String getBoomsdayTotalCounter() 
	{
		return boomsdayTotalCounter;
	}
	
	// Returns the value of "The Witchwood" total counter
	public String getWitchwoodTotalCounter() 
	{
		return witchwoodTotalCounter;
	}
	
	// Returns the value of "Kobolds & Catacombs" total counter
	public String getKoboldsTotalCounter() 
	{
		return koboldsTotalCounter;
	}
	
	// Returns the value of "Knights of the Frozen Throne" total counter
	public String getKnightsTotalCounter() 
	{
		return knightsTotalCounter;
	}
	
	// Returns the value of "Journey to Un'Goro" total counter
	public String getUngoroTotalCounter() 
	{
		return ungoroTotalCounter;
	}
	
	// Returns the value of "Mean Streets of Gadgetzan" total counter
	public String getGadgetzanTotalCounter() 
	{
		return gadgetzanTotalCounter;
	}
	
	// Returns the value of "Whispers of the Old Gods" total counter
	public String getOldGodsTotalCounter() 
	{
		return oldGodsTotalCounter;
	}
	
	// Returns the value of "The Grand Tournament" total counter
	public String getTournamentTotalCounter() 
	{
		return tournamentTotalCounter;
	}
	
	// Returns the value of "Goblins vs Gnomes" total counter
	public String getGoblinsTotalCounter() 
	{
		return goblinsTotalCounter;
	}
	
	// Returns the value of "Classic" total counter
	public String getClassicTotalCounter() 
	{
		return classicTotalCounter;
	}
	
	// Sets the value of "Forged in the Barrens" total counter
	public void setBarrensTotalCounter(String value) 
	{
		barrensTotalCounter = value;
		barrensTotalCounterText.setText("");
		doc = barrensTotalCounterText.getStyledDocument();
		changePanelTextStyle(barrens, barrensTotalCounterText, totalCounterText, barrensTotalCounter);
	}
	
	// Sets the value of "Madness at the Darkmoon Faire" total counter
	public void setDarkmoonTotalCounter(String value) 
	{
		darkmoonTotalCounter = value;
		darkmoonTotalCounterText.setText("");
		doc = darkmoonTotalCounterText.getStyledDocument();
		changePanelTextStyle(darkmoon, darkmoonTotalCounterText, totalCounterText, darkmoonTotalCounter);
	}
	
	// Sets the value of "Scholomance Academy" total counter
	public void setScholomanceTotalCounter(String value) 
	{
		scholomanceTotalCounter = value;
		scholomanceTotalCounterText.setText("");
		doc = scholomanceTotalCounterText.getStyledDocument();
		changePanelTextStyle(scholomance, scholomanceTotalCounterText, totalCounterText, scholomanceTotalCounter);
	}
	
	// Sets the value of "Ashes of Outland" total counter
	public void setOutlandTotalCounter(String value) 
	{
		outlandTotalCounter = value;
		outlandTotalCounterText.setText("");
		doc = outlandTotalCounterText.getStyledDocument();
		changePanelTextStyle(outland, outlandTotalCounterText, totalCounterText, outlandTotalCounter);
	}
	
	// Sets the value of "Descent of Dragons" total counter
	public void setDragonsTotalCounter(String value) 
	{
		dragonsTotalCounter = value;
		dragonsTotalCounterText.setText("");
		doc = dragonsTotalCounterText.getStyledDocument();
		changePanelTextStyle(dragons, dragonsTotalCounterText, totalCounterText, dragonsTotalCounter);
	}
	
	// Sets the value of "Saviors of Uldum" total counter
	public void setUldumTotalCounter(String value) 
	{
		uldumTotalCounter = value;
		uldumTotalCounterText.setText("");
		doc = uldumTotalCounterText.getStyledDocument();
		changePanelTextStyle(uldum, uldumTotalCounterText, totalCounterText, uldumTotalCounter);
	}
	
	// Sets the value of "Rise of Shadows" total counter
	public void setShadowsTotalCounter(String value) 
	{
		shadowsTotalCounter = value;
		shadowsTotalCounterText.setText("");
		doc = shadowsTotalCounterText.getStyledDocument();
		changePanelTextStyle(shadows, shadowsTotalCounterText, totalCounterText, shadowsTotalCounter);
	}
	
	// Sets the value of "Rastakhan's Rumble" total counter
	public void setRumbleTotalCounter(String value) 
	{
		rumbleTotalCounter = value;
		rumbleTotalCounterText.setText("");
		doc = rumbleTotalCounterText.getStyledDocument();
		changePanelTextStyle(rumble, rumbleTotalCounterText, totalCounterText, rumbleTotalCounter);
	}
	
	// Sets the value of "The Boomsday Project" total counter
	public void setBoomsdayTotalCounter(String value) 
	{
		boomsdayTotalCounter = value;
		boomsdayTotalCounterText.setText("");
		doc = boomsdayTotalCounterText.getStyledDocument();
		changePanelTextStyle(boomsday, boomsdayTotalCounterText, totalCounterText, boomsdayTotalCounter);
	}
	
	// Sets the value of "The Witchwood" total counter
	public void setWitchwoodTotalCounter(String value) 
	{
		witchwoodTotalCounter = value;
		witchwoodTotalCounterText.setText("");
		doc = witchwoodTotalCounterText.getStyledDocument();
		changePanelTextStyle(witchwood, witchwoodTotalCounterText, totalCounterText, witchwoodTotalCounter);
	}
	
	// Sets the value of "Kobolds & Catacombs" total counter
	public void setKoboldsTotalCounter(String value) 
	{
		koboldsTotalCounter = value;
		koboldsTotalCounterText.setText("");
		doc = koboldsTotalCounterText.getStyledDocument();
		changePanelTextStyle(kobolds, koboldsTotalCounterText, totalCounterText, koboldsTotalCounter);
	}
	
	// Sets the value of "Knights of the Frozen Throne" total counter
	public void setKnightsTotalCounter(String value) 
	{
		knightsTotalCounter = value;
		knightsTotalCounterText.setText("");
		doc = knightsTotalCounterText.getStyledDocument();
		changePanelTextStyle(knights, knightsTotalCounterText, totalCounterText, knightsTotalCounter);
	}
	
	// Sets the value of "Journey to Un'Goro" total counter
	public void setUngoroTotalCounter(String value) 
	{
		ungoroTotalCounter = value;
		ungoroTotalCounterText.setText("");
		doc = ungoroTotalCounterText.getStyledDocument();
		changePanelTextStyle(ungoro, ungoroTotalCounterText, totalCounterText, ungoroTotalCounter);
	}
	
	// Sets the value of "Mean Streets of Gadgetzan" total counter
	public void setGadgetzanTotalCounter(String value) 
	{
		gadgetzanTotalCounter = value;
		gadgetzanTotalCounterText.setText("");
		doc = gadgetzanTotalCounterText.getStyledDocument();
		changePanelTextStyle(gadgetzan, gadgetzanTotalCounterText, totalCounterText, gadgetzanTotalCounter);
	}
	
	// Sets the value of "Whispers of the Old Gods" total counter
	public void setOldGodsTotalCounter(String value) 
	{
		oldGodsTotalCounter = value;
		oldGodsTotalCounterText.setText("");
		doc = oldGodsTotalCounterText.getStyledDocument();
		changePanelTextStyle(oldGods, oldGodsTotalCounterText, totalCounterText, oldGodsTotalCounter);
	}
	
	// Sets the value of "The Grand Tournament" total counter
	public void setTournamentTotalCounter(String value) 
	{
		tournamentTotalCounter = value;
		tournamentTotalCounterText.setText("");
		doc = tournamentTotalCounterText.getStyledDocument();
		changePanelTextStyle(tournament, tournamentTotalCounterText, totalCounterText, tournamentTotalCounter);
	}
	
	// Sets the value of "Goblins vs Gnomes" total counter
	public void setGoblinsTotalCounter(String value) 
	{
		goblinsTotalCounter = value;
		goblinsTotalCounterText.setText("");
		doc = goblinsTotalCounterText.getStyledDocument();
		changePanelTextStyle(goblins, goblinsTotalCounterText, totalCounterText, goblinsTotalCounter);
	}
	
	// Sets the value of "Classic" total counter
	public void setClassicTotalCounter(String value) 
	{
		classicTotalCounter = value;
		classicTotalCounterText.setText("");
		doc = classicTotalCounterText.getStyledDocument();
		changePanelTextStyle(classic, classicTotalCounterText, totalCounterText, classicTotalCounter);
	}
	
	// Returns the "Forged in the Barrens" total modify button
	public ModifierButton getBarrensTotalModify() 
	{
		return barrensTotalModify;
	}
	
	// Returns the "Madness at the Darkmoon Faire" total modify button
	public ModifierButton getDarkmoonTotalModify() 
	{
		return darkmoonTotalModify;
	}
	
	// Returns the "Scholomance Academy" total modify button
	public ModifierButton getScholomanceTotalModify() 
	{
		return scholomanceTotalModify;
	}
	
	// Returns the "Ashes of Outland" total modify button
	public ModifierButton getOutlandTotalModify() 
	{
		return outlandTotalModify;
	}
	
	// Returns the "Descent of Dragons" total modify button
	public ModifierButton getDragonsTotalModify() 
	{
		return dragonsTotalModify;
	}
	
	// Returns the "Saviors of Uldum" total modify button
	public ModifierButton getUldumTotalModify() 
	{
		return uldumTotalModify;
	}
	
	// Returns the "Rise of Shadows" total modify button
	public ModifierButton getShadowsTotalModify() 
	{
		return shadowsTotalModify;
	}
	
	// Returns the "Rastakhan's Rumble" total modify button
	public ModifierButton getRumbleTotalModify() 
	{
		return rumbleTotalModify;
	}
	
	// Returns the "The Boomsday Project" total modify button
	public ModifierButton getBoomsdayTotalModify() 
	{
		return boomsdayTotalModify;
	}
	
	// Returns the "The Witchwood" total modify button
	public ModifierButton getWitchwoodTotalModify() 
	{
		return witchwoodTotalModify;
	}
	
	// Returns the "Kobolds & Catacombs" total modify button
	public ModifierButton getKoboldsTotalModify() 
	{
		return koboldsTotalModify;
	}
	
	// Returns the "Knights of the Frozen Throne" total modify button
	public ModifierButton getKnightsTotalModify() 
	{
		return knightsTotalModify;
	}
	
	// Returns the "Journey to Un'Goro" total modify button
	public ModifierButton getUngoroTotalModify() 
	{
		return ungoroTotalModify;
	}
	
	// Returns the "Mean Streets of Gadgetzan" total modify button
	public ModifierButton getGadgetzanTotalModify() 
	{
		return gadgetzanTotalModify;
	}
	
	// Returns the "Whispers of the Old Gods" total modify button
	public ModifierButton getOldGodsTotalModify() 
	{
		return oldGodsTotalModify;
	}
	
	// Returns the "The Grand Tournament" total modify button
	public ModifierButton getTournamentTotalModify() 
	{
		return tournamentTotalModify;
	}
	
	// Returns the "Goblins vs Gnomes" total modify button
	public ModifierButton getGoblinsTotalModify() 
	{
		return goblinsTotalModify;
	}
	
	// Returns the "Classic" total modify button
	public ModifierButton getClassicTotalModify() 
	{
		return classicTotalModify;
	}
	
	// Returns the "Forged in the Barrens" total add button
	public RoundButton getBarrensTotalAdd() 
	{
		return barrensTotalAdd;
	}
	
	// Returns the "Madness at the Darkmoon Faire" total add button
	public RoundButton getDarkmoonTotalAdd() 
	{
		return darkmoonTotalAdd;
	}
	
	// Returns the "Scholomance Academy" total add button
	public RoundButton getScholomanceTotalAdd() 
	{
		return scholomanceTotalAdd;
	}
	
	// Returns the "Ashes of Outland" total add button
	public RoundButton getOutlandTotalAdd() 
	{
		return outlandTotalAdd;
	}
	
	// Returns the "Descent of Dragons" total add button
	public RoundButton getDragonsTotalAdd() 
	{
		return dragonsTotalAdd;
	}
	
	// Returns the "Saviors of Uldum" total add button
	public RoundButton getUldumTotalAdd() 
	{
		return uldumTotalAdd;
	}
	
	// Returns the "Rise of Shadows" total add button
	public RoundButton getShadowsTotalAdd() 
	{
		return shadowsTotalAdd;
	}
	
	// Returns the "Rastakhan's Rumble" total add button
	public RoundButton getRumbleTotalAdd() 
	{
		return rumbleTotalAdd;
	}
	
	// Returns the "The Boomsday Project" total add button
	public RoundButton getBoomsdayTotalAdd() 
	{
		return boomsdayTotalAdd;
	}
	
	// Returns the "The Witchwood" total add button
	public RoundButton getWitchwoodTotalAdd() 
	{
		return witchwoodTotalAdd;
	}
	
	// Returns the "Kobolds & Catacombs" total add button
	public RoundButton getKoboldsTotalAdd() 
	{
		return koboldsTotalAdd;
	}
	
	// Returns the "Knights of the Frozen Throne" total add button
	public RoundButton getKnightsTotalAdd() 
	{
		return knightsTotalAdd;
	}
	
	// Returns the "Journey to Un'Goro" total add button
	public RoundButton getUngoroTotalAdd() 
	{
		return ungoroTotalAdd;
	}
	
	// Returns the "Mean Streets of Gadgetzan" total add button
	public RoundButton getGadgetzanTotalAdd() 
	{
		return gadgetzanTotalAdd;
	}
	
	// Returns the "Whispers of the Old Gods" total add button
	public RoundButton getOldGodsTotalAdd() 
	{
		return oldGodsTotalAdd;
	}
	
	// Returns the "The Grand Tournament" total add button
	public RoundButton getTournamentTotalAdd() 
	{
		return tournamentTotalAdd;
	}
	
	// Returns the "Goblins vs Gnomes" total add button
	public RoundButton getGoblinsTotalAdd() 
	{
		return goblinsTotalAdd;
	}
	
	// Returns the "Classic" total add button
	public RoundButton getClassicTotalAdd() 
	{
		return classicTotalAdd;
	}
	
	// Returns the "Forged in the Barrens" total increment field
	public JTextArea getBarrensTotalIncrement() 
	{
		return barrensTotalIncrement;
	}
	
	// Returns the "Madness at the Darkmoon Faire" total increment field
	public JTextArea getDarkmoonTotalIncrement() 
	{
		return darkmoonTotalIncrement;
	}
	
	// Returns the "Scholomance Academy" total increment field
	public JTextArea getScholomanceTotalIncrement() 
	{
		return scholomanceTotalIncrement;
	}
	
	// Returns the "Ashes of Outland" total increment field
	public JTextArea getOutlandTotalIncrement() 
	{
		return outlandTotalIncrement;
	}
	
	// Returns the "Descent of Dragons" total increment field
	public JTextArea getDragonsTotalIncrement() 
	{
		return dragonsTotalIncrement;
	}
	
	// Returns the "Saviors of Uldum" total increment field
	public JTextArea getUldumTotalIncrement() 
	{
		return uldumTotalIncrement;
	}
	
	// Returns the "Rise of Shadows" total increment field
	public JTextArea getShadowsTotalIncrement() 
	{
		return shadowsTotalIncrement;
	}
	
	// Returns the "Rastakhan's Rumble" total increment field
	public JTextArea getRumbleTotalIncrement() 
	{
		return rumbleTotalIncrement;
	}
	
	// Returns the "The Boomsday Project" total increment field
	public JTextArea getBoomsdayTotalIncrement() 
	{
		return boomsdayTotalIncrement;
	}
	
	// Returns the "The Witchwood" total increment field
	public JTextArea getWitchwoodTotalIncrement() 
	{
		return witchwoodTotalIncrement;
	}
	
	// Returns the "Kobolds & Catacombs" total increment field
	public JTextArea getKoboldsTotalIncrement() 
	{
		return koboldsTotalIncrement;
	}
	
	// Returns the "Knights of the Frozen Throne" total increment field
	public JTextArea getKnightsTotalIncrement() 
	{
		return knightsTotalIncrement;
	}
	
	// Returns the "Journey to Un'Goro" total increment field
	public JTextArea getUngoroTotalIncrement() 
	{
		return ungoroTotalIncrement;
	}
	
	// Returns the "Mean Streets of Gadgetzan" total increment field
	public JTextArea getGadgetzanTotalIncrement() 
	{
		return gadgetzanTotalIncrement;
	}
	
	// Returns the "Whispers of the Old Gods" total increment field
	public JTextArea getOldGodsTotalIncrement() 
	{
		return oldGodsTotalIncrement;
	}
	
	// Returns the "The Grand Tournament" total increment field
	public JTextArea getTournamentTotalIncrement() 
	{
		return tournamentTotalIncrement;
	}
	
	// Returns the "Goblins vs Gnomes" total increment field
	public JTextArea getGoblinsTotalIncrement() 
	{
		return goblinsTotalIncrement;
	}
	
	// Returns the "Classic" total increment field
	public JTextArea getClassicTotalIncrement() 
	{
		return classicTotalIncrement;
	}
	
	// Returns the "Forged in the Barrens" common button
	public IconButton getBarrensCommonButton() 
	{
		return barrensCommonButton;
	}
	
	// Returns the "Madness at the Darkmoon Faire" common button
	public IconButton getDarkmoonCommonButton() 
	{
		return darkmoonCommonButton;
	}
	
	// Returns the "Scholomance Academy" common button
	public IconButton getScholomanceCommonButton() 
	{
		return scholomanceCommonButton;
	}
	
	// Returns the "Ashes of Outland" common button
	public IconButton getOutlandCommonButton() 
	{
		return outlandCommonButton;
	}
	
	// Returns the "Descent of Dragons" common button
	public IconButton getDragonsCommonButton() 
	{
		return dragonsCommonButton;
	}
	
	// Returns the "Saviors of Uldum" common button
	public IconButton getUldumCommonButton() 
	{
		return uldumCommonButton;
	}
	
	// Returns the "Rise of Shadows" common button
	public IconButton getShadowsCommonButton() 
	{
		return shadowsCommonButton;
	}
	
	// Returns the "Rastakhan's Rumble" common button
	public IconButton getRumbleCommonButton() 
	{
		return rumbleCommonButton;
	}
	
	// Returns the "The Boomsday Project" common button
	public IconButton getBoomsdayCommonButton() 
	{
		return boomsdayCommonButton;
	}
	
	// Returns the "The Witchwood" common button
	public IconButton getWitchwoodCommonButton() 
	{
		return witchwoodCommonButton;
	}
	
	// Returns the "Kobolds & Catacombs" common button
	public IconButton getKoboldsCommonButton() 
	{
		return koboldsCommonButton;
	}
	
	// Returns the "Knights of the Frozen Throne" common button
	public IconButton getKnightsCommonButton() 
	{
		return knightsCommonButton;
	}
	
	// Returns the "Journey to Un'Goro" common button
	public IconButton getUngoroCommonButton() 
	{
		return ungoroCommonButton;
	}
	
	// Returns the "Mean Streets of Gadgetzan" common button
	public IconButton getGadgetzanCommonButton() 
	{
		return gadgetzanCommonButton;
	}
	
	// Returns the "Whispers of the Old Gods" common button
	public IconButton getOldGodsCommonButton() 
	{
		return oldGodsCommonButton;
	}
	
	// Returns the "The Grand Tournament" common button
	public IconButton getTournamentCommonButton() 
	{
		return tournamentCommonButton;
	}
	
	// Returns the "Goblins vs Gnomes" common button
	public IconButton getGoblinsCommonButton() 
	{
		return goblinsCommonButton;
	}
	
	// Returns the "Classic" common button
	public IconButton getClassicCommonButton() 
	{
		return classicCommonButton;
	}
	
	// Returns the "Forged in the Barrens" rare button
	public IconButton getBarrensRareButton() 
	{
		return barrensRareButton;
	}
	
	// Returns the "Madness at the Darkmoon Faire" rare button
	public IconButton getDarkmoonRareButton() 
	{
		return darkmoonRareButton;
	}
	
	// Returns the "Scholomance Academy" rare button
	public IconButton getScholomanceRareButton() 
	{
		return scholomanceRareButton;
	}
	
	// Returns the "Ashes of Outland" rare button
	public IconButton getOutlandRareButton() 
	{
		return outlandRareButton;
	}
	
	// Returns the "Descent of Dragons" rare button
	public IconButton getDragonsRareButton() 
	{
		return dragonsRareButton;
	}
	
	// Returns the "Saviors of Uldum" rare button
	public IconButton getUldumRareButton() 
	{
		return uldumRareButton;
	}
	
	// Returns the "Rise of Shadows" rare button
	public IconButton getShadowsRareButton() 
	{
		return shadowsRareButton;
	}
	
	// Returns the "Rastakhan's Rumble" rare button
	public IconButton getRumbleRareButton() 
	{
		return rumbleRareButton;
	}
	
	// Returns the "The Boomsday Project" rare button
	public IconButton getBoomsdayRareButton() 
	{
		return boomsdayRareButton;
	}
	
	// Returns the "The Witchwood" rare button
	public IconButton getWitchwoodRareButton() 
	{
		return witchwoodRareButton;
	}
	
	// Returns the "Kobolds & Catacombs" rare button
	public IconButton getKoboldsRareButton() 
	{
		return koboldsRareButton;
	}
	
	// Returns the "Knights of the Frozen Throne" rare button
	public IconButton getKnightsRareButton() 
	{
		return knightsRareButton;
	}
	
	// Returns the "Journey to Un'Goro" rare button
	public IconButton getUngoroRareButton() 
	{
		return ungoroRareButton;
	}
	
	// Returns the "Mean Streets of Gadgetzan" rare button
	public IconButton getGadgetzanRareButton() 
	{
		return gadgetzanRareButton;
	}
	
	// Returns the "Whispers of the Old Gods" rare button
	public IconButton getOldGodsRareButton() 
	{
		return oldGodsRareButton;
	}
	
	// Returns the "The Grand Tournament" rare button
	public IconButton getTournamentRareButton() 
	{
		return tournamentRareButton;
	}
	
	// Returns the "Goblins vs Gnomes" rare button
	public IconButton getGoblinsRareButton() 
	{
		return goblinsRareButton;
	}
	
	// Returns the "Classic" rare button
	public IconButton getClassicRareButton() 
	{
		return classicRareButton;
	}
	
	// Returns the "Forged in the Barrens" epic button
	public IconButton getBarrensEpicButton() 
	{
		return barrensEpicButton;
	}
	
	// Returns the "Madness at the Darkmoon Faire" epic button
	public IconButton getDarkmoonEpicButton() 
	{
		return darkmoonEpicButton;
	}
	
	// Returns the "Scholomance Academy" epic button
	public IconButton getScholomanceEpicButton() 
	{
		return scholomanceEpicButton;
	}
	
	// Returns the "Ashes of Outland" epic button
	public IconButton getOutlandEpicButton() 
	{
		return outlandEpicButton;
	}
	
	// Returns the "Descent of Dragons" epic button
	public IconButton getDragonsEpicButton() 
	{
		return dragonsEpicButton;
	}
	
	// Returns the "Saviors of Uldum" epic button
	public IconButton getUldumEpicButton() 
	{
		return uldumEpicButton;
	}
	
	// Returns the "Rise of Shadows" epic button
	public IconButton getShadowsEpicButton() 
	{
		return shadowsEpicButton;
	}
	
	// Returns the "Rastakhan's Rumble" epic button
	public IconButton getRumbleEpicButton() 
	{
		return rumbleEpicButton;
	}
	
	// Returns the "The Boomsday Project" epic button
	public IconButton getBoomsdayEpicButton() 
	{
		return boomsdayEpicButton;
	}
	
	// Returns the "The Witchwood" epic button
	public IconButton getWitchwoodEpicButton() 
	{
		return witchwoodEpicButton;
	}
	
	// Returns the "Kobolds & Catacombs" epic button
	public IconButton getKoboldsEpicButton() 
	{
		return koboldsEpicButton;
	}
	
	// Returns the "Knights of the Frozen Throne" epic button
	public IconButton getKnightsEpicButton() 
	{
		return knightsEpicButton;
	}
	
	// Returns the "Journey to Un'Goro" epic button
	public IconButton getUngoroEpicButton() 
	{
		return ungoroEpicButton;
	}
	
	// Returns the "Mean Streets of Gadgetzan" epic button
	public IconButton getGadgetzanEpicButton() 
	{
		return gadgetzanEpicButton;
	}
	
	// Returns the "Whispers of the Old Gods" epic button
	public IconButton getOldGodsEpicButton() 
	{
		return oldGodsEpicButton;
	}
	
	// Returns the "The Grand Tournament" epic button
	public IconButton getTournamentEpicButton() 
	{
		return tournamentEpicButton;
	}
	
	// Returns the "Goblins vs Gnomes" epic button
	public IconButton getGoblinsEpicButton() 
	{
		return goblinsEpicButton;
	}
	
	// Returns the "Classic" epic button
	public IconButton getClassicEpicButton() 
	{
		return classicEpicButton;
	}
	
	// Returns the "Forged in the Barrens" legendary button
	public IconButton getBarrensLegendaryButton() 
	{
		return barrensLegendaryButton;
	}
	
	// Returns the "Madness at the Darkmoon Faire" legendary button
	public IconButton getDarkmoonLegendaryButton() 
	{
		return darkmoonLegendaryButton;
	}
	
	// Returns the "Scholomance Academy" legendary button
	public IconButton getScholomanceLegendaryButton() 
	{
		return scholomanceLegendaryButton;
	}
	
	// Returns the "Ashes of Outland" legendary button
	public IconButton getOutlandLegendaryButton() 
	{
		return outlandLegendaryButton;
	}
	
	// Returns the "Descent of Dragons" legendary button
	public IconButton getDragonsLegendaryButton() 
	{
		return dragonsLegendaryButton;
	}
	
	// Returns the "Saviors of Uldum" legendary button
	public IconButton getUldumLegendaryButton() 
	{
		return uldumLegendaryButton;
	}
	
	// Returns the "Rise of Shadows" legendary button
	public IconButton getShadowsLegendaryButton() 
	{
		return shadowsLegendaryButton;
	}
	
	// Returns the "Rastakhan's Rumble" legendary button
	public IconButton getRumbleLegendaryButton() 
	{
		return rumbleLegendaryButton;
	}
	
	// Returns the "The Boomsday Project" legendary button
	public IconButton getBoomsdayLegendaryButton() 
	{
		return boomsdayLegendaryButton;
	}
	
	// Returns the "The Witchwood" legendary button
	public IconButton getWitchwoodLegendaryButton() 
	{
		return witchwoodLegendaryButton;
	}
	
	// Returns the "Kobolds & Catacombs" legendary button
	public IconButton getKoboldsLegendaryButton() 
	{
		return koboldsLegendaryButton;
	}
	
	// Returns the "Knights of the Frozen Throne" legendary button
	public IconButton getKnightsLegendaryButton() 
	{
		return knightsLegendaryButton;
	}
	
	// Returns the "Journey to Un'Goro" legendary button
	public IconButton getUngoroLegendaryButton() 
	{
		return ungoroLegendaryButton;
	}
	
	// Returns the "Mean Streets of Gadgetzan" legendary button
	public IconButton getGadgetzanLegendaryButton() 
	{
		return gadgetzanLegendaryButton;
	}
	
	// Returns the "Whispers of the Old Gods" legendary button
	public IconButton getOldGodsLegendaryButton() 
	{
		return oldGodsLegendaryButton;
	}
	
	// Returns the "The Grand Tournament" legendary button
	public IconButton getTournamentLegendaryButton() 
	{
		return tournamentLegendaryButton;
	}
	
	// Returns the "Goblins vs Gnomes" legendary button
	public IconButton getGoblinsLegendaryButton() 
	{
		return goblinsLegendaryButton;
	}
	
	// Returns the "Classtotaldary button
	public IconButton getClassicLegendaryButton() 
	{
		return classicLegendaryButton;
	}
}
