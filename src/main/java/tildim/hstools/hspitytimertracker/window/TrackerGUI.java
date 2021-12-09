package tildim.hstools.hspitytimertracker.window;

import tildim.hstools.hspitytimertracker.modifiers.*;

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
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextPane;
import javax.swing.ScrollPaneConstants;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;
import javax.swing.text.BadLocationException;
import javax.swing.text.SimpleAttributeSet;
import javax.swing.text.StyleConstants;
import javax.swing.text.StyledDocument;

public class TrackerGUI 
{
	// Tracker Panel
	private JPanel trackerWindowContentPanel;
	private ScrollablePanel trackerPanel;
	private JScrollPane trackerPanelScrollBar;
	
	// Tracker header
	private JPanel trackerHeader;
	
	// "Help" button
	private JPanel helpButtonPanel;
	
	private JButton help;
	
	private BufferedImage helpIcon;
	private static final String HELP_ICON_PATH = "images/header_icons/help.png";
	
	private BufferedImage helpHoverIcon;
	private static final String HELP_HOVER_ICON_PATH = "images/header_icons/help_hover.png";
	
	// Message displaying when hovering over the "Show save file" button
	private static final String HELP_TOOLTIP_TEXT = "Learn more about how this program works";
	
	// Tracker title
	private JPanel headerTitlePanel;
	
	private static final String HEADER_TITLE_TEXT = "Hearthstone Pity Timer Tracker";

	private BufferedImage headerImage;
	private static final String HEADER_IMAGE_PATH = "images/header_icons/hearthstone_icon.png";
	
	// "Show save file" button
	private JPanel showSaveButtonPanel;
	
	private JButton showSaveFileFolder;
	
	private BufferedImage showSaveFileFolderIcon;
	private static final String SHOW_SAVE_FILE_FOLDER_ICON_PATH = "images/header_icons/show_save_folder.png";
	
	private BufferedImage  showSaveFileFolderHoverIcon;
	private static final String SHOW_SAVE_FILE_FOLDER_HOVER_ICON_PATH = "images/header_icons/show_save_folder_hover.png";
	
	// Message displaying when hovering over the "Show save file" button
	private static final String SHOW_SAVE_FILE_FOLDER_TOOLTIP_TEXT = "Show the save file in the folder it is located";
	
	// Hearthstone Game Modes buttons panel
	private JPanel modeButtonsPanel;
	
	// Hearthstone Game Modes panels
	private JPanel standard;
	private JPanel wild;
	
	// Standard button
	private JButton standardButton;
	
	// Standard button label
	private static final String STANDARD_TITLE = "Standard Sets";
	
	// Standard button image
	private BufferedImage standardImage;
	private static final String STANDARD_IMAGE_PATH = "images/hs_game_modes_icons/standard_mode.png";
	
	// Message displayed when hovering over the "Standard Sets" button
	private static final String STANDARD_BUTTON_TOOLTIP_TEXT = "Show Standard Sets";
	
	// Wild button
	private JButton wildButton;
	
	// Wild button label
	private static final String WILD_TITLE = "Wild Sets";
	
	// Wild button image
	private BufferedImage wildImage;
	private static final String WILD_IMAGE_PATH = "images/hs_game_modes_icons/wild_mode.png";
	
	// Message displayed when hovering over the "Wild Sets" button
	private static final String WILD_BUTTON_TOOLTIP_TEXT = "Show Wild Sets";
		
	// Hearthstone Years shortcut buttons panels
	private JPanel standardYearsShortcutsPanel;
	private JPanel wildYearsShortcutsPanel;
	
	// Years shortcut buttons
	private JButton gryphonShortcut;
	private JButton phoenixShortcut;
	private JButton dragonShortcut;
	private JButton ravenShortcut;
	private JButton mammothShortcut;
	private JButton krakenShortcut;
	private JButton classicSetsShortcut;
	
	// Years shortcut buttons images
	private BufferedImage gryphonShortcutImage;
	private static final String GRYPHON_SHORTCUT_IMAGE_PATH = "images/hs_years_icons/shortcuts/year_of_the_gryphon_s.png";
	
	private BufferedImage phoenixShortcutImage;
	private static final String PHOENIX_SHORTCUT_IMAGE_PATH = "images/hs_years_icons/shortcuts/year_of_the_phoenix_s.png";
	
	private BufferedImage dragonShortcutImage;
	private static final String DRAGON_SHORTCUT_IMAGE_PATH = "images/hs_years_icons/shortcuts/year_of_the_dragon_s.png";
	
	private BufferedImage ravenShortcutImage;
	private static final String RAVEN_SHORTCUT_IMAGE_PATH = "images/hs_years_icons/shortcuts/year_of_the_raven_s.png";
	
	private BufferedImage mammothShortcutImage;
	private static final String MAMMOTH_SHORTCUT_IMAGE_PATH = "images/hs_years_icons/shortcuts/year_of_the_mammoth_s.png";
	
	private BufferedImage krakenShortcutImage;
	private static final String KRAKEN_SHORTCUT_IMAGE_PATH = "images/hs_years_icons/shortcuts/year_of_the_kraken_s.png";
	
	private BufferedImage classicSetsShortcutImage;
	private static final String CLASSICSETS_SHORTCUT_IMAGE_PATH = "images/hs_years_icons/shortcuts/classic_sets_s.png";
	
	// Messages displayed when hovering over the Years shortcut buttons
	private static final String GRYPHON_SHORTCUT_TOOLTIP_TEXT = "Go to 'Year of the Gryphon'";
	private static final String PHOENIX_SHORTCUT_TOOLTIP_TEXT = "Go to 'Year of the Phoenix'";
	private static final String DRAGON_SHORTCUT_TOOLTIP_TEXT = "Go to 'Year of the Dragon'";
	private static final String RAVEN_SHORTCUT_TOOLTIP_TEXT = "Go to 'Year of the Raven'";
	private static final String MAMMOTH_SHORTCUT_TOOLTIP_TEXT = "Go to 'Year of the Mammoth'";
	private static final String KRAKEN_SHORTCUT_TOOLTIP_TEXT = "Go to 'Year of the Kraken'";
	private static final String CLASSICSETS_SHORTCUT_TOOLTIP_TEXT = "Go to 'Classic Sets'";
	
	// Hearthstone Years panels
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

	private static final String GRYPHON_TITLE = "Year of the Gryphon (2021)";
	private static final String PHOENIX_TITLE = "Year of the Phoenix (2020)";
	private static final String DRAGON_TITLE = "Year of the Dragon (2019)";
	private static final String RAVEN_TITLE = "Year of the Raven (2018)";
	private static final String MAMMOTH_TITLE = "Year of the Mammoth (2017)";
	private static final String KRAKEN_TITLE = "Year of the Kraken (2016)";
	private static final String CLASSICSETS_TITLE = "Classic Sets (2014-2015)";

	private BufferedImage gryphonImage;
	private static final String GRYPHON_IMAGE_PATH = "images/hs_years_icons/year_of_the_gryphon.png";

	private BufferedImage phoenixImage;
	private static final String PHOENIX_IMAGE_PATH = "images/hs_years_icons/year_of_the_phoenix.png";

	private BufferedImage dragonImage;
	private static final String DRAGON_IMAGE_PATH = "images/hs_years_icons/year_of_the_dragon.png";

	private BufferedImage ravenImage;
	private static final String RAVEN_IMAGE_PATH = "images/hs_years_icons/year_of_the_raven.png";

	private BufferedImage mammothImage;
	private static final String MAMMOTH_IMAGE_PATH = "images/hs_years_icons/year_of_the_mammoth.png";

	private BufferedImage krakenImage;
	private static final String KRAKEN_IMAGE_PATH = "images/hs_years_icons/year_of_the_kraken.png";

	private BufferedImage classicSetsImage;
	private static final String CLASSICSETS_IMAGE_PATH = "images/hs_years_icons/classic_sets.png";
	
	// Hearthstone Expansions panels
	// Year of the Gryphon
	private JPanel alterac; // Fractured in Alterac Valley
	private JPanel stormwind; // United in Stormwind
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
	private JButton alteracImageButton;
	private BufferedImage alteracImage;
	private static final String ALTERAC_IMAGE_PATH = "images/hs_expansions_icons/fractured_in_alterac_valley.png";
	
	private JButton stormwindImageButton;
	private BufferedImage stormwindImage;
	private static final String STORMWIND_IMAGE_PATH = "images/hs_expansions_icons/united_in_stormwind.png";
	
	private JButton barrensImageButton;
	private BufferedImage barrensImage;
	private static final String BARRENS_IMAGE_PATH = "images/hs_expansions_icons/forged_in_the_barrens.png";
	
	private JButton darkmoonImageButton;
	private BufferedImage darkmoonImage;
	private static final String DARKMOON_IMAGE_PATH = "images/hs_expansions_icons/madness_at_the_darkmoon_faire.png";
	
	private JButton scholomanceImageButton;
	private BufferedImage scholomanceImage;
	private static final String SCHOLOMANCE_IMAGE_PATH = "images/hs_expansions_icons/scholomance_academy.png";
	
	private JButton outlandImageButton;
	private BufferedImage outlandImage;
	private static final String OUTLAND_IMAGE_PATH = "images/hs_expansions_icons/ashes_of_outland.png";
	
	private JButton dragonsImageButton;
	private BufferedImage dragonsImage;
	private static final String DRAGONS_IMAGE_PATH = "images/hs_expansions_icons/descent_of_dragons.png";
	
	private JButton uldumImageButton;
	private BufferedImage uldumImage;
	private static final String ULDUM_IMAGE_PATH = "images/hs_expansions_icons/saviors_of_uldum.png";
	
	private JButton shadowsImageButton;
	private BufferedImage shadowsImage;
	private static final String SHADOWS_IMAGE_PATH = "images/hs_expansions_icons/rise_of_shadows.png";
	
	private JButton rumbleImageButton;
	private BufferedImage rumbleImage;
	private static final String RUMBLE_IMAGE_PATH = "images/hs_expansions_icons/rastakhan's_rumble.png";
	
	private JButton boomsdayImageButton;
	private BufferedImage boomsdayImage;
	private static final String BOOMSDAY_IMAGE_PATH = "images/hs_expansions_icons/the_boomsday_project.png";
	
	private JButton witchwoodImageButton;
	private BufferedImage witchwoodImage;
	private static final String WITCHWOOD_IMAGE_PATH = "images/hs_expansions_icons/the_witchwood.png";
	
	private JButton koboldsImageButton;
	private BufferedImage koboldsImage;
	private static final String KOBOLDS_IMAGE_PATH = "images/hs_expansions_icons/kobolds_&_catacombs.png";
	
	private JButton knightsImageButton;
	private BufferedImage knightsImage;
	private static final String KNIGHTS_IMAGE_PATH = "images/hs_expansions_icons/knights_of_the_frozen_throne.png";
	
	private JButton ungoroImageButton;
	private BufferedImage ungoroImage;
	private static final String UNGORO_IMAGE_PATH = "images/hs_expansions_icons/journey_to_un'goro.png";
	
	private JButton gadgetzanImageButton;
	private BufferedImage gadgetzanImage;
	private static final String GADGETZAN_IMAGE_PATH = "images/hs_expansions_icons/mean_streets_of_gadgetzan.png";
	
	private JButton oldGodsImageButton;
	private BufferedImage oldGodsImage;
	private static final String OLDGODS_IMAGE_PATH = "images/hs_expansions_icons/whispers_of_the_old_gods.png";
	
	private JButton tournamentImageButton;
	private BufferedImage tournamentImage;
	private static final String TOURNAMENT_IMAGE_PATH = "images/hs_expansions_icons/the_grand_tournament.png";
	
	private JButton goblinsImageButton;
	private BufferedImage goblinsImage;
	private static final String GOBLINS_IMAGE_PATH = "images/hs_expansions_icons/goblins_vs_gnomes.png";

	private JLabel classicImageLabel;
	private BufferedImage classicImage;
	private static final String CLASSIC_IMAGE_PATH = "images/hs_expansions_icons/classic.png";
	
	// Message displayed when hovering over an expansion logo
	private static final String IMAGE_BUTTON_TOOLTIP_TEXT = "Go to the expansion's official webpage";

	// Packs without epic panel title
	private JTextPane epicPanelTitleLabel;
	private static final String EPIC_PANEL_TITLE = "Epic Pity Timer";

	// Packs without epic panels
	private JTextPane alteracEpicCounterPanel;
	private JTextPane stormwindEpicCounterPanel;
	private JTextPane barrensEpicCounterPanel;
	private JTextPane darkmoonEpicCounterPanel;
	private JTextPane scholomanceEpicCounterPanel;
	private JTextPane outlandEpicCounterPanel;
	private JTextPane dragonsEpicCounterPanel;
	private JTextPane uldumEpicCounterPanel;
	private JTextPane shadowsEpicCounterPanel;
	private JTextPane rumbleEpicCounterPanel;
	private JTextPane boomsdayEpicCounterPanel;
	private JTextPane witchwoodEpicCounterPanel;
	private JTextPane koboldsEpicCounterPanel;
	private JTextPane knightsEpicCounterPanel;
	private JTextPane ungoroEpicCounterPanel;
	private JTextPane gadgetzanEpicCounterPanel;
	private JTextPane oldGodsEpicCounterPanel;
	private JTextPane tournamentEpicCounterPanel;
	private JTextPane goblinsEpicCounterPanel;
	private JTextPane classicEpicCounterPanel;
	
	// Message displayed for the amount of packs opened without an epic card
	private static final String EPIC_COUNTER_TEXT = "Card packs opened without an epic card:   ";
	
	// Epic counters (Labels showing the current amount of packs opened without finding an epic card from each expansion)
	private String alteracEpicCounter;
	private String stormwindEpicCounter;
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

	// Epic counters modifiers
	// Reset buttons
	private ModifierButton alteracEpicReset;
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
	private RoundButton alteracEpicAdd;
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
	private JTextArea alteracEpicIncrement;
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
	
	// Packs without epic probability panels
	private JTextPane alteracEpicProbabilityPanel;
	private JTextPane stormwindEpicProbabilityPanel;
	private JTextPane barrensEpicProbabilityPanel;
	private JTextPane darkmoonEpicProbabilityPanel;
	private JTextPane scholomanceEpicProbabilityPanel;
	private JTextPane outlandEpicProbabilityPanel;
	private JTextPane dragonsEpicProbabilityPanel;
	private JTextPane uldumEpicProbabilityPanel;
	private JTextPane shadowsEpicProbabilityPanel;
	private JTextPane rumbleEpicProbabilityPanel;
	private JTextPane boomsdayEpicProbabilityPanel;
	private JTextPane witchwoodEpicProbabilityPanel;
	private JTextPane koboldsEpicProbabilityPanel;
	private JTextPane knightsEpicProbabilityPanel;
	private JTextPane ungoroEpicProbabilityPanel;
	private JTextPane gadgetzanEpicProbabilityPanel;
	private JTextPane oldGodsEpicProbabilityPanel;
	private JTextPane tournamentEpicProbabilityPanel;
	private JTextPane goblinsEpicProbabilityPanel;
	private JTextPane classicEpicProbabilityPanel;
	
	// Message displayed for the probability of finding an epic card
	private static final String EPIC_PROBABILITY_TEXT = "Probability of finding an epic card in the next card pack:   ";
	
	// Epic probabilities (Labels showing the probability of finding an epic card from each expansion)
	private String alteracEpicProbability;
	private String stormwindEpicProbability;
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
	
	// Packs without legendary panel title
	private JTextPane legendaryPanelTitleLabel;
	private static final String LEGENDARY_PANEL_TITLE = "Legendary Pity Timer";

	// Packs without legendary panels
	private JTextPane alteracLegendaryCounterPanel;
	private JTextPane stormwindLegendaryCounterPanel;
	private JTextPane barrensLegendaryCounterPanel;
	private JTextPane darkmoonLegendaryCounterPanel;
	private JTextPane scholomanceLegendaryCounterPanel;
	private JTextPane outlandLegendaryCounterPanel;
	private JTextPane dragonsLegendaryCounterPanel;
	private JTextPane uldumLegendaryCounterPanel;
	private JTextPane shadowsLegendaryCounterPanel;
	private JTextPane rumbleLegendaryCounterPanel;
	private JTextPane boomsdayLegendaryCounterPanel;
	private JTextPane witchwoodLegendaryCounterPanel;
	private JTextPane koboldsLegendaryCounterPanel;
	private JTextPane knightsLegendaryCounterPanel;
	private JTextPane ungoroLegendaryCounterPanel;
	private JTextPane gadgetzanLegendaryCounterPanel;
	private JTextPane oldGodsLegendaryCounterPanel;
	private JTextPane tournamentLegendaryCounterPanel;
	private JTextPane goblinsLegendaryCounterPanel;
	private JTextPane classicLegendaryCounterPanel;
	
	// Message displayed for the amount of packs opened without a legendary card
	private static final String LEGENDARY_COUNTER_TEXT = "Card packs opened without a legendary card:   ";
	
	// Legendary counters (Labels showing the current amount of packs opened without finding a legendary card from each expansion)
	private String alteracLegendaryCounter;
	private String stormwindLegendaryCounter;
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

	// Legendary counters modifiers
	// Reset buttons
	private ModifierButton alteracLegendaryReset;
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
	private RoundButton alteracLegendaryAdd;
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
	private JTextArea alteracLegendaryIncrement;
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
	
	// Packs without legendary probability panels
	private JTextPane alteracLegendaryProbabilityPanel;
	private JTextPane stormwindLegendaryProbabilityPanel;
	private JTextPane barrensLegendaryProbabilityPanel;
	private JTextPane darkmoonLegendaryProbabilityPanel;
	private JTextPane scholomanceLegendaryProbabilityPanel;
	private JTextPane outlandLegendaryProbabilityPanel;
	private JTextPane dragonsLegendaryProbabilityPanel;
	private JTextPane uldumLegendaryProbabilityPanel;
	private JTextPane shadowsLegendaryProbabilityPanel;
	private JTextPane rumbleLegendaryProbabilityPanel;
	private JTextPane boomsdayLegendaryProbabilityPanel;
	private JTextPane witchwoodLegendaryProbabilityPanel;
	private JTextPane koboldsLegendaryProbabilityPanel;
	private JTextPane knightsLegendaryProbabilityPanel;
	private JTextPane ungoroLegendaryProbabilityPanel;
	private JTextPane gadgetzanLegendaryProbabilityPanel;
	private JTextPane oldGodsLegendaryProbabilityPanel;
	private JTextPane tournamentLegendaryProbabilityPanel;
	private JTextPane goblinsLegendaryProbabilityPanel;
	private JTextPane classicLegendaryProbabilityPanel;
	
	// Message displayed for the probability of finding a legendary card
	private static final String LEGENDARY_PROBABILITY_TEXT = "Probability of finding a legendary card in the next card pack:   ";
	
	// Legendary probabilities (Labels showing the probability of finding a legendary card from each expansion)
	private String alteracLegendaryProbability;
	private String stormwindLegendaryProbability;
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
	
	// Total packs panel title
	private JTextPane totalPanelTitleLabel;
	private static final String TOTAL_PANEL_TITLE = "Total Card Packs";

	// Total packs counter panels
	private JTextPane alteracTotalCounterPanel;
	private JTextPane stormwindTotalCounterPanel;
	private JTextPane barrensTotalCounterPanel;
	private JTextPane darkmoonTotalCounterPanel;
	private JTextPane scholomanceTotalCounterPanel;
	private JTextPane outlandTotalCounterPanel;
	private JTextPane dragonsTotalCounterPanel;
	private JTextPane uldumTotalCounterPanel;
	private JTextPane shadowsTotalCounterPanel;
	private JTextPane rumbleTotalCounterPanel;
	private JTextPane boomsdayTotalCounterPanel;
	private JTextPane witchwoodTotalCounterPanel;
	private JTextPane koboldsTotalCounterPanel;
	private JTextPane knightsTotalCounterPanel;
	private JTextPane ungoroTotalCounterPanel;
	private JTextPane gadgetzanTotalCounterPanel;
	private JTextPane oldGodsTotalCounterPanel;
	private JTextPane tournamentTotalCounterPanel;
	private JTextPane goblinsTotalCounterPanel;
	private JTextPane classicTotalCounterPanel;
	
	// Message displayed for the total amount of packs opened from each expansion
	private static final String TOTAL_COUNTER_TEXT = "Total amount of card packs opened:   ";
	
	// Total counters (Labels showing the total amount of packs opened from each expansion)
	private String alteracTotalCounter;
	private String stormwindTotalCounter;
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

	// Total counters modifiers
	// Modify buttons
	private ModifierButton alteracTotalModify;
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
	private RoundButton alteracTotalAdd;
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
	private JTextArea alteracTotalIncrement;
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

	// Button labels
	private static final String RESET = "Reset";
	private static final String ADD = "+";
	private static final String MODIFY = "Modify";
	
	// Messages displayed when hovering over a counter modify button
	private static final String RESET_BUTTON_TOOLTIP_TEXT = "Reset the counter";
	private static final String MODIFY_BUTTON_TOOLTIP_TEXT = "Modify the counter";
	private static final String ADD_BUTTON_TOOLTIP_TEXT = "Add packs to the counter";
	private static final String INCREMENT_BUTTON_TOOLTIP_TEXT = "Number of packs to be added";
	
	// Blank label to add extra space between buttons
	private JLabel blank;

	// Common buttons
	private IconButton alteracCommonButton;
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
	
	// Message displayed when hovering over a common button
	private static final String COMMON_BUTTON_TOOLTIP_TEXT = "See the expansion's common cards";
	
	// Rare buttons
	private IconButton alteracRareButton;
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
	
	// Message displayed when hovering over a rare button
	private static final String RARE_BUTTON_TOOLTIP_TEXT = "See the expansion's rare cards";
	
	// Epic buttons
	private IconButton alteracEpicButton;
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
	
	// Message displayed when hovering over an epic button
	private static final String EPIC_BUTTON_TOOLTIP_TEXT = "See the expansion's epic cards";
	
	// Legendary buttons
	private IconButton alteracLegendaryButton;
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
	
	// Message displayed when hovering over a legendary button
	private static final String LEGENDARY_BUTTON_TOOLTIP_TEXT = "See the expansion's legendary cards";
	
	// Rarity buttons icons
	// Common
	private BufferedImage commonButtonIcon;
	private static final String COMMON_BUTTON_ICON_PATH = "images/rarities_icons/common.png";
	
	private BufferedImage commonButtonHoverIcon;
	private static final String COMMON_BUTTON_HOVER_ICON_PATH = "images/rarities_icons/common_hover.png";
	
	private BufferedImage commonButtonDarkIcon;
	private static final String COMMON_BUTTON_DARK_ICON_PATH = "images/rarities_icons/common_dark.png";
	
	private BufferedImage commonButtonDarkHoverIcon;
	private static final String COMMON_BUTTON_DARK_HOVER_ICON_PATH = "images/rarities_icons/common_dark_hover.png";
	
	// Rare
	private BufferedImage rareButtonIcon;
	private static final String RARE_BUTTON_ICON_PATH = "images/rarities_icons/rare.png";
	
	private BufferedImage rareButtonHoverIcon;
	private static final String RARE_BUTTON_HOVER_ICON_PATH = "images/rarities_icons/rare_hover.png";
	
	private BufferedImage rareButtonDarkIcon;
	private static final String RARE_BUTTON_DARK_ICON_PATH = "images/rarities_icons/rare_dark.png";
	
	private BufferedImage rareButtonDarkHoverIcon;
	private static final String RARE_BUTTON_DARK_HOVER_ICON_PATH = "images/rarities_icons/rare_dark_hover.png";
	
	// Epic
	private BufferedImage epicButtonIcon;
	private static final String EPIC_BUTTON_ICON_PATH = "images/rarities_icons/epic.png";
	
	private BufferedImage epicButtonHoverIcon;
	private static final String EPIC_BUTTON_HOVER_ICON_PATH = "images/rarities_icons/epic_hover.png";
	
	private BufferedImage epicButtonDarkIcon;
	private static final String EPIC_BUTTON_DARK_ICON_PATH = "images/rarities_icons/epic_dark.png";
	
	private BufferedImage epicButtonDarkHoverIcon;
	private static final String EPIC_BUTTON_DARK_HOVER_ICON_PATH = "images/rarities_icons/epic_dark_hover.png";
	
	// Legendary
	private BufferedImage legendaryButtonIcon;
	private static final String LEGENDARY_BUTTON_ICON_PATH = "images/rarities_icons/legendary.png";
	
	private BufferedImage legendaryButtonHoverIcon;
	private static final String LEGENDARY_BUTTON_HOVER_ICON_PATH = "images/rarities_icons/legendary_hover.png";
	
	private BufferedImage legendaryButtonDarkIcon;
	private static final String LEGENDARY_BUTTON_DARK_ICON_PATH = "images/rarities_icons/legendary_dark.png";
	
	private BufferedImage legendaryButtonDarkHoverIcon;
	private static final String LEGENDARY_BUTTON_DARK_HOVER_ICON_PATH = "images/rarities_icons/legendary_dark_hover.png";
	
	// Tracker colors
	private Color headerTitleColor;
	private Color headerBGColor;
	private Color setsColor;
	private Color setsHoverColor;
	private Color setsSelectedColor;
	private Color yearsColor;
	private Color buttonsHoverColor;
	private Color buttonsDarkHoverColor;
	
	private Color alteracColor;
	private Color stormwindColor;
	private Color barrensColor;
	private Color darkmoonColor;
	private Color scholomanceColor;
	private Color outlandColor;
	private Color dragonsColor;
	private Color uldumColor;
	private Color shadowsColor;
	private Color rumbleColor;
	private Color boomsdayColor;
	private Color witchwoodColor;
	private Color koboldsColor;
	private Color knightsColor;
	private Color ungoroColor;
	private Color gadgetzanColor;
	private Color oldGodsColor;
	private Color tournamentColor;
	private Color goblinsColor;
	private Color classicColor;
	
	// Tracker fonts
	private Font titleFont;
	private Font modesFont;
	private Font yearsFont;
	private Font incrementFieldFont;
	private Font buttonsTextFont;
	private Font addButtonTextFont;
	private static final String PRIMARY_FONT = "Comic Sans MS";
	
	// Variables for changing text style
	private StyledDocument doc;
	private SimpleAttributeSet set;
	
	// Constructor
	public TrackerGUI() throws IOException {
		setColorsAndFonts();
		
		createImages();
		
		createWindowComponents();
	}
	
	// Tracker colors and fonts
	private void setColorsAndFonts() 
	{
		// Colors
		headerBGColor = new Color(50, 50, 50);
		headerTitleColor = new Color(255, 255, 255);
		setsColor = new Color(240, 215, 105);
		setsHoverColor = new Color(240, 200, 95);
		setsSelectedColor = new Color(220, 170, 85);
		yearsColor = new Color(245, 220, 160);
		buttonsHoverColor = new Color(75, 75, 75);
		buttonsDarkHoverColor = new Color(225, 225, 225);
		
		alteracColor = new Color(245, 245, 250);
		stormwindColor = new Color(0, 0, 180);
		barrensColor = new Color(175, 0, 0);
		darkmoonColor = new Color(175, 200, 20);
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
		ungoroColor = new Color(95, 115, 40);
		gadgetzanColor = new Color(210, 165, 25);
		oldGodsColor = new Color(190, 120, 190);
		tournamentColor = new Color(95, 70, 50);
		goblinsColor = new Color(220, 95, 10);
		classicColor = new Color(115, 165, 235);
		
		// Fonts
		titleFont = new Font(PRIMARY_FONT, Font.BOLD, 36);
		modesFont = new Font(PRIMARY_FONT, Font.BOLD, 30);
		yearsFont = new Font(PRIMARY_FONT, Font.BOLD, 26);
		incrementFieldFont = new Font(PRIMARY_FONT, Font.PLAIN, 24);
		buttonsTextFont = new Font(PRIMARY_FONT, Font.BOLD, 22);
		addButtonTextFont = new Font("Arial Black", Font.BOLD, 32);
		
		// Buttons tooltip style
		UIManager.put("ToolTip.background", headerTitleColor);
		UIManager.put("ToolTip.font", new Font(PRIMARY_FONT, Font.PLAIN, 14));
	}
	
	// Tracker images creator
	private void createImages() throws IOException {
		// Header image
		headerImage = imageURLReader(HEADER_IMAGE_PATH);

		// "Help" icon
		helpIcon = imageURLReader(HELP_ICON_PATH);
		helpHoverIcon = imageURLReader(HELP_HOVER_ICON_PATH);
		
		// "Show save file" icon
		showSaveFileFolderIcon = imageURLReader(SHOW_SAVE_FILE_FOLDER_ICON_PATH);
		showSaveFileFolderHoverIcon = imageURLReader(SHOW_SAVE_FILE_FOLDER_HOVER_ICON_PATH);
		
		// Game modes icons
		standardImage = imageURLReader(STANDARD_IMAGE_PATH);
		wildImage = imageURLReader(WILD_IMAGE_PATH);
		
		// Years shortcut buttons images
		gryphonShortcutImage = imageURLReader(GRYPHON_SHORTCUT_IMAGE_PATH);
		phoenixShortcutImage = imageURLReader(PHOENIX_SHORTCUT_IMAGE_PATH);
		dragonShortcutImage = imageURLReader(DRAGON_SHORTCUT_IMAGE_PATH);
		ravenShortcutImage = imageURLReader(RAVEN_SHORTCUT_IMAGE_PATH);
		mammothShortcutImage = imageURLReader(MAMMOTH_SHORTCUT_IMAGE_PATH);
		krakenShortcutImage = imageURLReader(KRAKEN_SHORTCUT_IMAGE_PATH);
		classicSetsShortcutImage = imageURLReader(CLASSICSETS_SHORTCUT_IMAGE_PATH);
		
		// Years images
		gryphonImage = imageURLReader(GRYPHON_IMAGE_PATH);
		phoenixImage = imageURLReader(PHOENIX_IMAGE_PATH);
		dragonImage = imageURLReader(DRAGON_IMAGE_PATH);
		ravenImage = imageURLReader(RAVEN_IMAGE_PATH);
		mammothImage = imageURLReader(MAMMOTH_IMAGE_PATH);
		krakenImage = imageURLReader(KRAKEN_IMAGE_PATH);
		classicSetsImage = imageURLReader(CLASSICSETS_IMAGE_PATH);
		
		// Expansions images
		alteracImage = imageURLReader(ALTERAC_IMAGE_PATH);
		stormwindImage = imageURLReader(STORMWIND_IMAGE_PATH);
		barrensImage = imageURLReader(BARRENS_IMAGE_PATH);
		darkmoonImage = imageURLReader(DARKMOON_IMAGE_PATH);
		scholomanceImage = imageURLReader(SCHOLOMANCE_IMAGE_PATH);
		outlandImage = imageURLReader(OUTLAND_IMAGE_PATH);
		dragonsImage = imageURLReader(DRAGONS_IMAGE_PATH);
		uldumImage = imageURLReader(ULDUM_IMAGE_PATH);
		shadowsImage = imageURLReader(SHADOWS_IMAGE_PATH);
		rumbleImage = imageURLReader(RUMBLE_IMAGE_PATH);
		boomsdayImage = imageURLReader(BOOMSDAY_IMAGE_PATH);
		witchwoodImage = imageURLReader(WITCHWOOD_IMAGE_PATH);
		koboldsImage = imageURLReader(KOBOLDS_IMAGE_PATH);
		knightsImage = imageURLReader(KNIGHTS_IMAGE_PATH);
		ungoroImage = imageURLReader(UNGORO_IMAGE_PATH);
		gadgetzanImage = imageURLReader(GADGETZAN_IMAGE_PATH);
		oldGodsImage = imageURLReader(OLDGODS_IMAGE_PATH);
		tournamentImage = imageURLReader(TOURNAMENT_IMAGE_PATH);
		goblinsImage = imageURLReader(GOBLINS_IMAGE_PATH);
		classicImage = imageURLReader(CLASSIC_IMAGE_PATH);
		
		// Rarity buttons icons
		// Common
		commonButtonIcon = imageURLReader(COMMON_BUTTON_ICON_PATH);
		commonButtonHoverIcon = imageURLReader(COMMON_BUTTON_HOVER_ICON_PATH);
		commonButtonDarkIcon = imageURLReader(COMMON_BUTTON_DARK_ICON_PATH);
		commonButtonDarkHoverIcon = imageURLReader(COMMON_BUTTON_DARK_HOVER_ICON_PATH);
		
		// Rare
		rareButtonIcon = imageURLReader(RARE_BUTTON_ICON_PATH);
		rareButtonHoverIcon = imageURLReader(RARE_BUTTON_HOVER_ICON_PATH);
		rareButtonDarkIcon = imageURLReader(RARE_BUTTON_DARK_ICON_PATH);
		rareButtonDarkHoverIcon = imageURLReader(RARE_BUTTON_DARK_HOVER_ICON_PATH);
		
		// Epic
		epicButtonIcon = imageURLReader(EPIC_BUTTON_ICON_PATH);
		epicButtonHoverIcon = imageURLReader(EPIC_BUTTON_HOVER_ICON_PATH);
		epicButtonDarkIcon = imageURLReader(EPIC_BUTTON_DARK_ICON_PATH);
		epicButtonDarkHoverIcon = imageURLReader(EPIC_BUTTON_DARK_HOVER_ICON_PATH);
		
		// Legendary
		legendaryButtonIcon = imageURLReader(LEGENDARY_BUTTON_ICON_PATH);
		legendaryButtonHoverIcon = imageURLReader(LEGENDARY_BUTTON_HOVER_ICON_PATH);
		legendaryButtonDarkIcon = imageURLReader(LEGENDARY_BUTTON_DARK_ICON_PATH);
		legendaryButtonDarkHoverIcon = imageURLReader(LEGENDARY_BUTTON_DARK_HOVER_ICON_PATH);
	}
	
	// Creates an image using the URL to the image path
	private BufferedImage imageURLReader(String imagePath) throws IOException
	{
		URL imageURL = getClass().getClassLoader().getResource(imagePath);
		if (imageURL != null) {
			return ImageIO.read(imageURL);
		}
		return null;
	}

	// Tracker window components creator
	private void createWindowComponents()
	{
		// Tracker Window Content panel
		trackerWindowContentPanel = new JPanel();
		trackerWindowContentPanel.setLayout(new BoxLayout(trackerWindowContentPanel, BoxLayout.Y_AXIS));
		
		// Tracker panel
		trackerPanel = new ScrollablePanel();
		trackerPanel.setScrollableWidth(ScrollablePanel.ScrollableSizeHint.FIT);
		trackerPanel.setLayout(new BoxLayout(trackerPanel, BoxLayout.Y_AXIS));
		
		// Tracker header
		createHeader();
		
		// Modes buttons panel
		createModeButtonsPanel();
		
		// Years shortcut buttons panels
		createStandardYearsShortcutButtonsPanel();
		createWildYearsShortcutButtonsPanel();
		
		// Game Modes sets panels
		createStandardPanel();
		createWildPanel();
		
		SwingUtilities.invokeLater(() -> {
			trackerPanel.add(standard);
			trackerPanel.add(wild);
		});
		
		// Window Scroll Bar
		trackerPanelScrollBar = new JScrollPane(trackerPanel, ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED, ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		trackerPanelScrollBar.getVerticalScrollBar().setUnitIncrement(25);
		trackerPanelScrollBar.setBorder(BorderFactory.createEmptyBorder());
		trackerPanelScrollBar.getVerticalScrollBar().setValue(0);
		
		SwingUtilities.invokeLater(() -> {
			trackerWindowContentPanel.add(trackerHeader);
			trackerWindowContentPanel.add(modeButtonsPanel);
			trackerWindowContentPanel.add(standardYearsShortcutsPanel);
			trackerWindowContentPanel.add(wildYearsShortcutsPanel);
			wildYearsShortcutsPanel.setVisible(false);
			trackerWindowContentPanel.add(trackerPanelScrollBar);
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
		helpButtonPanel.setBorder(new EmptyBorder(10, 15, 0, 0));
		
		// "Help" button
		help = new JButton("");
		help.setIcon(new ImageIcon(helpIcon));
		help.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 0));
		help.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		help.setToolTipText(HELP_TOOLTIP_TEXT);
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
		JLabel headerImageLabel = new JLabel(new ImageIcon(headerImage));
		headerImageLabel.setBorder(new EmptyBorder(0, 5, 0, 5));
		
		// Title
		JLabel headerTitle = new JLabel(HEADER_TITLE_TEXT);
		headerTitle.setFont(titleFont);
		headerTitle.setForeground(headerTitleColor);
		headerTitle.setBorder(new EmptyBorder(0, 5, 0, 5));
		
		// Title image #2
		JLabel headerImageTwoLabel = new JLabel(new ImageIcon(headerImage));
		headerImageTwoLabel.setBorder(new EmptyBorder(0, 5, 0, 5));
		
		headerTitlePanel.add(headerImageLabel);
		headerTitlePanel.add(headerTitle);
		headerTitlePanel.add(headerImageTwoLabel);
		
		// "Show save file" button panel
		showSaveButtonPanel = new JPanel();
		showSaveButtonPanel.setBackground(headerBGColor);
		showSaveButtonPanel.setBorder(new EmptyBorder(10, 0, 0, 15));
		
		// "Show save file" button
		showSaveFileFolder = new JButton("");
		showSaveFileFolder.setIcon(new ImageIcon(showSaveFileFolderIcon));
		showSaveFileFolder.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 0));
		showSaveFileFolder.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		showSaveFileFolder.setToolTipText(SHOW_SAVE_FILE_FOLDER_TOOLTIP_TEXT);
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
		
		SwingUtilities.invokeLater(() -> {
			trackerHeader.add(helpButtonPanel, BorderLayout.WEST);
			trackerHeader.add(headerTitlePanel, BorderLayout.CENTER);
			trackerHeader.add(showSaveButtonPanel, BorderLayout.EAST);
		});
	}
	
	// Mode buttons panel creator
	private void createModeButtonsPanel() 
	{
		// Mode buttons panel
		modeButtonsPanel = new JPanel(new GridLayout(1, 2, 0, 0));
		modeButtonsPanel.setBackground(setsColor);
		
		// "Standard" sets button
		standardButton = new ModeButton(" " + STANDARD_TITLE, modesFont);
		standardButton.setIcon(new ImageIcon(standardImage));
		standardButton.setToolTipText(STANDARD_BUTTON_TOOLTIP_TEXT);
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
		
		// "Wild" sets button
		wildButton = new ModeButton(" " + WILD_TITLE, modesFont);
		wildButton.setIcon(new ImageIcon(wildImage));
		wildButton.setToolTipText(WILD_BUTTON_TOOLTIP_TEXT);
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
		
		SwingUtilities.invokeLater(() -> {
			modeButtonsPanel.add(standardButton);
			modeButtonsPanel.add(wildButton);
		});
	}
	
	// Standard Years shortcut buttons panel creator
	private void createStandardYearsShortcutButtonsPanel() 
	{
		// Standard Years shortcut buttons panel
		standardYearsShortcutsPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 20, 3));
		standardYearsShortcutsPanel.setBackground(setsSelectedColor);
		
		// "Year of the Gryphon" shortcut button
		gryphonShortcut = new ShortcutButton(setsSelectedColor, setsColor);
		gryphonShortcut.setIcon(new ImageIcon(gryphonShortcutImage));
		gryphonShortcut.setToolTipText(GRYPHON_SHORTCUT_TOOLTIP_TEXT);
		
		// "Year of the Phoenix" shortcut button
		phoenixShortcut = new ShortcutButton(setsSelectedColor, setsColor);
		phoenixShortcut.setIcon(new ImageIcon(phoenixShortcutImage));
		phoenixShortcut.setToolTipText(PHOENIX_SHORTCUT_TOOLTIP_TEXT);
		
		SwingUtilities.invokeLater(() -> {
			standardYearsShortcutsPanel.add(gryphonShortcut);
			standardYearsShortcutsPanel.add(phoenixShortcut);
		});
	}
	
	// Wild Years shortcut buttons panel creator
	private void createWildYearsShortcutButtonsPanel() 
	{
		// Standard Years shortcut buttons panel
		wildYearsShortcutsPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 20, 3));
		wildYearsShortcutsPanel.setBackground(setsSelectedColor);
		
		// "Year of the Dragon" shortcut button
		dragonShortcut = new ShortcutButton(setsSelectedColor, setsColor);
		dragonShortcut.setIcon(new ImageIcon(dragonShortcutImage));
		dragonShortcut.setToolTipText(DRAGON_SHORTCUT_TOOLTIP_TEXT);
		
		// "Year of the Raven" shortcut button
		ravenShortcut = new ShortcutButton(setsSelectedColor, setsColor);
		ravenShortcut.setIcon(new ImageIcon(ravenShortcutImage));
		ravenShortcut.setToolTipText(RAVEN_SHORTCUT_TOOLTIP_TEXT);
		
		// "Year of the Mammoth" shortcut button
		mammothShortcut = new ShortcutButton(setsSelectedColor, setsColor);
		mammothShortcut.setIcon(new ImageIcon(mammothShortcutImage));
		mammothShortcut.setToolTipText(MAMMOTH_SHORTCUT_TOOLTIP_TEXT);
		
		// "Year of the Kraken" shortcut button
		krakenShortcut = new ShortcutButton(setsSelectedColor, setsColor);
		krakenShortcut.setIcon(new ImageIcon(krakenShortcutImage));
		krakenShortcut.setToolTipText(KRAKEN_SHORTCUT_TOOLTIP_TEXT);
		
		// "Classic Sets" shortcut button
		classicSetsShortcut = new ShortcutButton(setsSelectedColor, setsColor);
		classicSetsShortcut.setIcon(new ImageIcon(classicSetsShortcutImage));
		classicSetsShortcut.setToolTipText(CLASSICSETS_SHORTCUT_TOOLTIP_TEXT);
		
		SwingUtilities.invokeLater(() -> {
			wildYearsShortcutsPanel.add(dragonShortcut);
			wildYearsShortcutsPanel.add(ravenShortcut);
			wildYearsShortcutsPanel.add(mammothShortcut);
			wildYearsShortcutsPanel.add(krakenShortcut);
			wildYearsShortcutsPanel.add(classicSetsShortcut);
		});
	}
	
	// "Standard" sets panel creator
	private void createStandardPanel() 
	{
		// "Standard" sets panel
		standard = new JPanel();
		standard.setLayout(new BoxLayout(standard, BoxLayout.Y_AXIS));
		
		// "Standard" sets panels
		createYearOfTheGryphonPanel();
		createYearOfThePhoenixPanel();
		
		SwingUtilities.invokeLater(() -> {
			standard.add(gryphon);
			standard.add(phoenix);
		});
	}
	
	// "Wild" sets panel creator
	private void createWildPanel() 
	{
		// "Wild" sets panel
		wild = new JPanel();
		wild.setLayout(new BoxLayout(wild, BoxLayout.Y_AXIS));
		
		// "Wild" sets panels
		createYearOfTheDragonPanel();
		createYearOfTheRavenPanel();
		createYearOfTheMammothPanel();
		createYearOfTheKrakenPanel();
		createClassicSetsPanel();		
		
		SwingUtilities.invokeLater(() -> {
			wild.add(dragon);
			wild.add(raven);
			wild.add(mammoth);
			wild.add(kraken);
			wild.add(classicSets);

			wild.setVisible(false);
		});
	}
	
	// "Year of the Gryphon" panel creator
	private void createYearOfTheGryphonPanel() 
	{
		// "Year of the Gryphon" panel
		gryphon = new JPanel();
		gryphon.setLayout(new BoxLayout(gryphon, BoxLayout.Y_AXIS));
		
		// "Year of the Gryphon" title header
		gryphonHeader = new JPanel(new FlowLayout(FlowLayout.CENTER));
		gryphonHeader.setBackground(yearsColor);

		// Years logos
		JLabel gryphonImageLabel = new JLabel(new ImageIcon(gryphonImage));
		gryphonImageLabel.setBorder(new EmptyBorder(0, 5, 0, 5));

		// Years titles
		JLabel gryphonLabel = new JLabel(GRYPHON_TITLE);
		gryphonLabel.setFont(yearsFont);
		gryphonLabel.setBorder(new EmptyBorder(5, 10, 5, 5));
		
		gryphonHeader.add(gryphonImageLabel);
		gryphonHeader.add(gryphonLabel);
		
		// "Year of the Gryphon" expansions
		createFracturedInAlteracValleyPanel();
		createUnitedInStormwindPanel();
		createForgedInTheBarrensPanel();
		
		SwingUtilities.invokeLater(() -> {
			gryphon.add(gryphonHeader);
			gryphon.add(alterac);
			gryphon.add(stormwind);
			gryphon.add(barrens);
		});
	}
	
	// "Fractured in Alterac Valley" panel creator
	private void createFracturedInAlteracValleyPanel() 
	{
		// "Fractured in Alterac Valley" panel
		alterac = new JPanel();
		alterac.setBackground(alteracColor);
		alterac.setLayout(new GridLayout(1, 4, 10, 0));
		alterac.setBorder(new EmptyBorder(10, 10, 10, 10));
		
		// "Fractured in Alterac Valley" logo
		JPanel alteracImagePanel = new JPanel(new GridBagLayout());
		alteracImagePanel.setBackground(alterac.getBackground());
		
		alteracImageButton = new JButton(new ImageIcon(alteracImage));
		alteracImageButton.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 0));
		alteracImageButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		alteracImageButton.setToolTipText(IMAGE_BUTTON_TOOLTIP_TEXT);
		alteracImageButton.setContentAreaFilled(false);
		alteracImageButton.setFocusPainted(false);
		
		alteracImagePanel.add(alteracImageButton);
		
		// Packs without epic panel
		JPanel alteracEpicPanel = new JPanel();
		alteracEpicPanel.setBackground(alterac.getBackground());
		alteracEpicPanel.setLayout(new GridLayout(4, 1));
		
		// Packs without epic panel title
		epicPanelTitleLabel = new JTextPane();
		doc = epicPanelTitleLabel.getStyledDocument();
		changePanelTitleStyle(alterac, epicPanelTitleLabel, EPIC_PANEL_TITLE);
		
		// Packs without epic counter panel
		alteracEpicCounterPanel = new JTextPane();
		doc = alteracEpicCounterPanel.getStyledDocument();
		changePanelTextStyle(alterac, alteracEpicCounterPanel, EPIC_COUNTER_TEXT, alteracEpicCounter);
		
		// Packs without epic counter modify buttons panel
		JPanel alteracEpicModifyPanel = new JPanel();
		
		// Reset button
		alteracEpicReset = new ModifierButton(RESET, headerBGColor, buttonsHoverColor);
		alteracEpicReset.setToolTipText(RESET_BUTTON_TOOLTIP_TEXT);
		alteracEpicReset.setBackground(headerBGColor);
		alteracEpicReset.setForeground(headerTitleColor);
		
		// Blank space between reset and add buttons
		blank = new JLabel();
		blank.setBackground(alterac.getBackground());
		blank.setBorder(new EmptyBorder(0, 20, 0, 20));
		
		// Add button
		alteracEpicAdd = new RoundButton(ADD, headerBGColor, buttonsHoverColor);
		alteracEpicAdd.setBackground(headerBGColor);
		alteracEpicAdd.setForeground(headerTitleColor);
		
		// Increment field
		alteracEpicIncrement = new JTextArea(1, 1);
		alteracEpicIncrement.setDocument(new LimitedIncrement(1));
		alteracEpicIncrement.setBackground(headerBGColor);
		alteracEpicIncrement.setForeground(headerTitleColor);
		alteracEpicIncrement.setCaretColor(headerTitleColor);
		alteracEpicIncrement.setBorder(new EmptyBorder(0, 9, 0, 6));
		
		createModifyButtonsPanel(alterac, alteracEpicModifyPanel, alteracEpicReset, alteracEpicAdd, alteracEpicIncrement);
		
		// Packs without epic probability panel
		alteracEpicProbabilityPanel = new JTextPane();
		doc = alteracEpicProbabilityPanel.getStyledDocument();
		changePanelTextStyle(alterac, alteracEpicProbabilityPanel, EPIC_PROBABILITY_TEXT, alteracEpicProbability);
		
		alteracEpicPanel.add(epicPanelTitleLabel);
		alteracEpicPanel.add(alteracEpicCounterPanel);
		alteracEpicPanel.add(alteracEpicModifyPanel);
		alteracEpicPanel.add(alteracEpicProbabilityPanel);
		
		// Packs without legendary panel
		JPanel alteracLegendaryPanel = new JPanel();
		alteracLegendaryPanel.setBackground(alterac.getBackground());
		alteracLegendaryPanel.setLayout(new GridLayout(4, 1));
		
		// Packs without legendary panel title
		legendaryPanelTitleLabel = new JTextPane();
		doc = legendaryPanelTitleLabel.getStyledDocument();
		changePanelTitleStyle(alterac, legendaryPanelTitleLabel, LEGENDARY_PANEL_TITLE);
		
		// Packs without legendary counter panel
		alteracLegendaryCounterPanel = new JTextPane();
		doc = alteracLegendaryCounterPanel.getStyledDocument();
		changePanelTextStyle(alterac, alteracLegendaryCounterPanel, LEGENDARY_COUNTER_TEXT, alteracLegendaryCounter);
		
		// Packs without legendary counter modify buttons panel
		JPanel alteracLegendaryModifyPanel = new JPanel();
		
		// Reset button
		alteracLegendaryReset = new ModifierButton(RESET, headerBGColor, buttonsHoverColor);
		alteracLegendaryReset.setToolTipText(RESET_BUTTON_TOOLTIP_TEXT);
		alteracLegendaryReset.setBackground(headerBGColor);
		alteracLegendaryReset.setForeground(headerTitleColor);
		
		// Blank space between reset and add buttons
		blank = new JLabel();
		blank.setBackground(alterac.getBackground());
		blank.setBorder(new EmptyBorder(0, 20, 0, 20));
		
		// Add button
		alteracLegendaryAdd = new RoundButton(ADD, headerBGColor, buttonsHoverColor);
		alteracLegendaryAdd.setBackground(headerBGColor);
		alteracLegendaryAdd.setForeground(headerTitleColor);
		
		// Increment field
		alteracLegendaryIncrement = new JTextArea(1, 2);
		alteracLegendaryIncrement.setDocument(new LimitedIncrement(2));
		alteracLegendaryIncrement.setBackground(headerBGColor);
		alteracLegendaryIncrement.setForeground(headerTitleColor);
		alteracLegendaryIncrement.setCaretColor(headerTitleColor);
		alteracLegendaryIncrement.setBorder(new EmptyBorder(0, 9, 0, 3));
		
		createModifyButtonsPanel(alterac, alteracLegendaryModifyPanel, alteracLegendaryReset, alteracLegendaryAdd, alteracLegendaryIncrement);
		
		// Packs without legendary probability panel
		alteracLegendaryProbabilityPanel = new JTextPane();
		doc = alteracLegendaryProbabilityPanel.getStyledDocument();
		changePanelTextStyle(alterac, alteracLegendaryProbabilityPanel, LEGENDARY_PROBABILITY_TEXT, alteracLegendaryProbability);
		
		alteracLegendaryPanel.add(legendaryPanelTitleLabel);
		alteracLegendaryPanel.add(alteracLegendaryCounterPanel);
		alteracLegendaryPanel.add(alteracLegendaryModifyPanel);
		alteracLegendaryPanel.add(alteracLegendaryProbabilityPanel);
		
		// Total amount of packs opened panel
		JPanel alteracTotalPanel = new JPanel();
		alteracTotalPanel.setBackground(alterac.getBackground());
		alteracTotalPanel.setLayout(new GridLayout(4, 1));
		
		// Total amount of packs opened panel title
		totalPanelTitleLabel = new JTextPane();
		doc = totalPanelTitleLabel.getStyledDocument();
		changePanelTitleStyle(alterac, totalPanelTitleLabel,TOTAL_PANEL_TITLE);
		
		// Total amount of packs opened counter panel panel
		alteracTotalCounterPanel = new JTextPane();
		doc = alteracTotalCounterPanel.getStyledDocument();
		changePanelTextStyle(alterac, alteracTotalCounterPanel, TOTAL_COUNTER_TEXT, alteracTotalCounter);
		
		// Total amount of packs opened counter modify buttons panel
		JPanel alteracTotalModifyPanel = new JPanel();
		
		// Modify button
		alteracTotalModify = new ModifierButton(MODIFY, headerBGColor, buttonsHoverColor);
		alteracTotalModify.setToolTipText(MODIFY_BUTTON_TOOLTIP_TEXT);
		alteracTotalModify.setBackground(headerBGColor);
		alteracTotalModify.setForeground(headerTitleColor);
		
		// Blank space between modify and add buttons
		blank = new JLabel();
		blank.setBackground(alterac.getBackground());
		blank.setBorder(new EmptyBorder(0, 5, 0, 5));
		
		// Add button
		alteracTotalAdd = new RoundButton(ADD, headerBGColor, buttonsHoverColor);
		alteracTotalAdd.setBackground(headerBGColor);
		alteracTotalAdd.setForeground(headerTitleColor);
		
		// Increment field
		alteracTotalIncrement = new JTextArea(1, 3);
		alteracTotalIncrement.setDocument(new LimitedIncrement(3));
		alteracTotalIncrement.setBackground(headerBGColor);
		alteracTotalIncrement.setForeground(headerTitleColor);
		alteracTotalIncrement.setCaretColor(headerTitleColor);
		alteracTotalIncrement.setBorder(new EmptyBorder(0, 9, 0, 0));
		
		createModifyButtonsPanel(alterac, alteracTotalModifyPanel, alteracTotalModify, alteracTotalAdd, alteracTotalIncrement);
		
		// Common button
		JPanel alteracCommonButtonPanel = new JPanel(new GridBagLayout());
		alteracCommonButton = new IconButton(new ImageIcon(commonButtonIcon), new ImageIcon(commonButtonHoverIcon));
		
		// Rare button
		JPanel alteracRareButtonPanel = new JPanel(new GridBagLayout());
		alteracRareButton = new IconButton(new ImageIcon(rareButtonIcon), new ImageIcon(rareButtonHoverIcon));
		
		// Epic button
		JPanel alteracEpicButtonPanel = new JPanel(new GridBagLayout());
		alteracEpicButton = new IconButton(new ImageIcon(epicButtonIcon), new ImageIcon(epicButtonHoverIcon));
		
		// Legendary button
		JPanel alteracLegendaryButtonPanel = new JPanel(new GridBagLayout());
		alteracLegendaryButton = new IconButton(new ImageIcon(legendaryButtonIcon), new ImageIcon(legendaryButtonHoverIcon));

		// Rarity buttons panel
		JPanel alteracRarityButtonsPanel = new JPanel();
		alteracRarityButtonsPanel.setBackground(alterac.getBackground());
		alteracRarityButtonsPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 25, 0));
		createCommonButtonPanel(alterac, alteracCommonButtonPanel, alteracCommonButton);
		createRareButtonPanel(alterac, alteracRareButtonPanel, alteracRareButton);
		createEpicButtonPanel(alterac, alteracEpicButtonPanel, alteracEpicButton);
		createLegendaryButtonPanel(alterac, alteracLegendaryButtonPanel, alteracLegendaryButton);
		alteracRarityButtonsPanel.add(alteracCommonButtonPanel);
		alteracRarityButtonsPanel.add(alteracRareButtonPanel);
		alteracRarityButtonsPanel.add(alteracEpicButtonPanel);
		alteracRarityButtonsPanel.add(alteracLegendaryButtonPanel);
		
		alteracTotalPanel.add(totalPanelTitleLabel);
		alteracTotalPanel.add(alteracTotalCounterPanel);
		alteracTotalPanel.add(alteracTotalModifyPanel);
		alteracTotalPanel.add(alteracRarityButtonsPanel);
		
		alterac.add(alteracImagePanel);
		alterac.add(alteracEpicPanel);
		alterac.add(alteracLegendaryPanel);
		alterac.add(alteracTotalPanel);
	}
	
	// "United in Stormwind" panel creator
	private void createUnitedInStormwindPanel() 
	{
		// "United in Stormwind" panel
		stormwind = new JPanel();
		stormwind.setBackground(stormwindColor);
		stormwind.setLayout(new GridLayout(1, 4, 10, 0));
		stormwind.setBorder(new EmptyBorder(10, 10, 10, 10));
		
		// "United in Stormwind" logo
		JPanel stormwindImagePanel = new JPanel(new GridBagLayout());
		stormwindImagePanel.setBackground(stormwind.getBackground());
		
		stormwindImageButton = new JButton(new ImageIcon(stormwindImage));
		stormwindImageButton.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 0));
		stormwindImageButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		stormwindImageButton.setToolTipText(IMAGE_BUTTON_TOOLTIP_TEXT);
		stormwindImageButton.setContentAreaFilled(false);
		stormwindImageButton.setFocusPainted(false);
		
		stormwindImagePanel.add(stormwindImageButton);
		
		// Packs without epic panel
		JPanel stormwindEpicPanel = new JPanel();
		stormwindEpicPanel.setBackground(stormwind.getBackground());
		stormwindEpicPanel.setLayout(new GridLayout(4, 1));
		
		// Packs without epic panel title
		epicPanelTitleLabel = new JTextPane();
		doc = epicPanelTitleLabel.getStyledDocument();
		changePanelTitleStyle(stormwind, epicPanelTitleLabel, EPIC_PANEL_TITLE);
		epicPanelTitleLabel.setForeground(headerTitleColor);
		
		// Packs without epic counter panel
		stormwindEpicCounterPanel = new JTextPane();
		doc = stormwindEpicCounterPanel.getStyledDocument();
		changePanelTextStyle(stormwind, stormwindEpicCounterPanel, EPIC_COUNTER_TEXT, stormwindEpicCounter);
		stormwindEpicCounterPanel.setForeground(headerTitleColor);
		
		// Packs without epic counter modify buttons panel
		JPanel stormwindEpicModifyPanel = new JPanel();
		
		// Reset button
		stormwindEpicReset = new ModifierButton(RESET, headerTitleColor, buttonsDarkHoverColor);
		stormwindEpicReset.setToolTipText(RESET_BUTTON_TOOLTIP_TEXT);
		stormwindEpicReset.setBackground(headerTitleColor);
		
		// Blank space between reset and add buttons
		blank = new JLabel();
		blank.setBackground(stormwind.getBackground());
		blank.setBorder(new EmptyBorder(0, 20, 0, 20));
		
		// Add button
		stormwindEpicAdd = new RoundButton(ADD, headerTitleColor, buttonsDarkHoverColor);
		stormwindEpicAdd.setBackground(headerTitleColor);
		
		// Increment field
		stormwindEpicIncrement = new JTextArea(1, 1);
		stormwindEpicIncrement.setDocument(new LimitedIncrement(1));
		stormwindEpicIncrement.setBackground(headerTitleColor);
		stormwindEpicIncrement.setBorder(new EmptyBorder(0, 9, 0, 6));
		
		createModifyButtonsPanel(stormwind, stormwindEpicModifyPanel, stormwindEpicReset, stormwindEpicAdd, stormwindEpicIncrement);
		
		// Packs without epic probability panel
		stormwindEpicProbabilityPanel = new JTextPane();
		doc = stormwindEpicProbabilityPanel.getStyledDocument();
		changePanelTextStyle(stormwind, stormwindEpicProbabilityPanel, EPIC_PROBABILITY_TEXT, stormwindEpicProbability);
		stormwindEpicProbabilityPanel.setForeground(headerTitleColor);
		
		stormwindEpicPanel.add(epicPanelTitleLabel);
		stormwindEpicPanel.add(stormwindEpicCounterPanel);
		stormwindEpicPanel.add(stormwindEpicModifyPanel);
		stormwindEpicPanel.add(stormwindEpicProbabilityPanel);
		
		// Packs without legendary panel
		JPanel stormwindLegendaryPanel = new JPanel();
		stormwindLegendaryPanel.setBackground(stormwind.getBackground());
		stormwindLegendaryPanel.setLayout(new GridLayout(4, 1));
		
		// Packs without legendary panel title
		legendaryPanelTitleLabel = new JTextPane();
		doc = legendaryPanelTitleLabel.getStyledDocument();
		changePanelTitleStyle(stormwind, legendaryPanelTitleLabel, LEGENDARY_PANEL_TITLE);
		legendaryPanelTitleLabel.setForeground(headerTitleColor);
		
		// Packs without legendary counter panel
		stormwindLegendaryCounterPanel = new JTextPane();
		doc = stormwindLegendaryCounterPanel.getStyledDocument();
		changePanelTextStyle(stormwind, stormwindLegendaryCounterPanel, LEGENDARY_COUNTER_TEXT, stormwindLegendaryCounter);
		stormwindLegendaryCounterPanel.setForeground(headerTitleColor);
		
		// Packs without legendary counter modify buttons panel
		JPanel stormwindLegendaryModifyPanel = new JPanel();
		
		// Reset button
		stormwindLegendaryReset = new ModifierButton(RESET, headerTitleColor, buttonsDarkHoverColor);
		stormwindLegendaryReset.setToolTipText(RESET_BUTTON_TOOLTIP_TEXT);
		stormwindLegendaryReset.setBackground(headerTitleColor);
		
		// Blank space between reset and add buttons
		blank = new JLabel();
		blank.setBackground(stormwind.getBackground());
		blank.setBorder(new EmptyBorder(0, 20, 0, 20));
		
		// Add button
		stormwindLegendaryAdd = new RoundButton(ADD, headerTitleColor, buttonsDarkHoverColor);
		stormwindLegendaryAdd.setBackground(headerTitleColor);
		
		// Increment field
		stormwindLegendaryIncrement = new JTextArea(1, 2);
		stormwindLegendaryIncrement.setDocument(new LimitedIncrement(2));
		stormwindLegendaryIncrement.setBackground(headerTitleColor);
		stormwindLegendaryIncrement.setBorder(new EmptyBorder(0, 9, 0, 3));
		
		createModifyButtonsPanel(stormwind, stormwindLegendaryModifyPanel, stormwindLegendaryReset, stormwindLegendaryAdd, stormwindLegendaryIncrement);
		
		// Packs without legendary probability panel
		stormwindLegendaryProbabilityPanel = new JTextPane();
		doc = stormwindLegendaryProbabilityPanel.getStyledDocument();
		changePanelTextStyle(stormwind, stormwindLegendaryProbabilityPanel, LEGENDARY_PROBABILITY_TEXT, stormwindLegendaryProbability);
		stormwindLegendaryProbabilityPanel.setForeground(headerTitleColor);
		
		stormwindLegendaryPanel.add(legendaryPanelTitleLabel);
		stormwindLegendaryPanel.add(stormwindLegendaryCounterPanel);
		stormwindLegendaryPanel.add(stormwindLegendaryModifyPanel);
		stormwindLegendaryPanel.add(stormwindLegendaryProbabilityPanel);
		
		// Total amount of packs opened panel
		JPanel stormwindTotalPanel = new JPanel();
		stormwindTotalPanel.setBackground(stormwind.getBackground());
		stormwindTotalPanel.setLayout(new GridLayout(4, 1));
		
		// Total amount of packs opened panel title
		totalPanelTitleLabel = new JTextPane();
		doc = totalPanelTitleLabel.getStyledDocument();
		changePanelTitleStyle(stormwind, totalPanelTitleLabel,TOTAL_PANEL_TITLE);
		totalPanelTitleLabel.setForeground(headerTitleColor);
		
		// Total amount of packs opened counter panel panel
		stormwindTotalCounterPanel = new JTextPane();
		doc = stormwindTotalCounterPanel.getStyledDocument();
		changePanelTextStyle(stormwind, stormwindTotalCounterPanel, TOTAL_COUNTER_TEXT, stormwindTotalCounter);
		stormwindTotalCounterPanel.setForeground(headerTitleColor);
		
		// Total amount of packs opened counter modify buttons panel
		JPanel stormwindTotalModifyPanel = new JPanel();
		
		// Modify button
		stormwindTotalModify = new ModifierButton(MODIFY, headerTitleColor, buttonsDarkHoverColor);
		stormwindTotalModify.setToolTipText(MODIFY_BUTTON_TOOLTIP_TEXT);
		stormwindTotalModify.setBackground(headerTitleColor);
		
		// Blank space between modify and add buttons
		blank = new JLabel();
		blank.setBackground(stormwind.getBackground());
		blank.setBorder(new EmptyBorder(0, 5, 0, 5));
		
		// Add button
		stormwindTotalAdd = new RoundButton(ADD, headerTitleColor, buttonsDarkHoverColor);
		stormwindTotalAdd.setBackground(headerTitleColor);
		
		// Increment field
		stormwindTotalIncrement = new JTextArea(1, 3);
		stormwindTotalIncrement.setDocument(new LimitedIncrement(3));
		stormwindTotalIncrement.setBackground(headerTitleColor);
		stormwindTotalIncrement.setBorder(new EmptyBorder(0, 9, 0, 0));
		
		createModifyButtonsPanel(stormwind, stormwindTotalModifyPanel, stormwindTotalModify, stormwindTotalAdd, stormwindTotalIncrement);
		
		// Common button
		JPanel stormwindCommonButtonPanel = new JPanel(new GridBagLayout());
		stormwindCommonButton = new IconButton(new ImageIcon(commonButtonDarkIcon), new ImageIcon(commonButtonDarkHoverIcon));
		
		// Rare button
		JPanel stormwindRareButtonPanel = new JPanel(new GridBagLayout());
		stormwindRareButton = new IconButton(new ImageIcon(rareButtonDarkIcon), new ImageIcon(rareButtonDarkHoverIcon));
		
		// Epic button
		JPanel stormwindEpicButtonPanel = new JPanel(new GridBagLayout());
		stormwindEpicButton = new IconButton(new ImageIcon(epicButtonDarkIcon), new ImageIcon(epicButtonDarkHoverIcon));
		
		// Legendary button
		JPanel stormwindLegendaryButtonPanel = new JPanel(new GridBagLayout());
		stormwindLegendaryButton = new IconButton(new ImageIcon(legendaryButtonDarkIcon), new ImageIcon(legendaryButtonDarkHoverIcon));

		// Rarity buttons panel
		JPanel stormwindRarityButtonsPanel = new JPanel();
		stormwindRarityButtonsPanel.setBackground(stormwind.getBackground());
		stormwindRarityButtonsPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 25, 0));
		createCommonButtonPanel(stormwind, stormwindCommonButtonPanel, stormwindCommonButton);
		createRareButtonPanel(stormwind, stormwindRareButtonPanel, stormwindRareButton);
		createEpicButtonPanel(stormwind, stormwindEpicButtonPanel, stormwindEpicButton);
		createLegendaryButtonPanel(stormwind, stormwindLegendaryButtonPanel, stormwindLegendaryButton);
		stormwindRarityButtonsPanel.add(stormwindCommonButtonPanel);
		stormwindRarityButtonsPanel.add(stormwindRareButtonPanel);
		stormwindRarityButtonsPanel.add(stormwindEpicButtonPanel);
		stormwindRarityButtonsPanel.add(stormwindLegendaryButtonPanel);
		
		stormwindTotalPanel.add(totalPanelTitleLabel);
		stormwindTotalPanel.add(stormwindTotalCounterPanel);
		stormwindTotalPanel.add(stormwindTotalModifyPanel);
		stormwindTotalPanel.add(stormwindRarityButtonsPanel);
		
		stormwind.add(stormwindImagePanel);
		stormwind.add(stormwindEpicPanel);
		stormwind.add(stormwindLegendaryPanel);
		stormwind.add(stormwindTotalPanel);
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
		JPanel barrensImagePanel = new JPanel(new GridBagLayout());
		barrensImagePanel.setBackground(barrens.getBackground());
		
		barrensImageButton = new JButton(new ImageIcon(barrensImage));
		barrensImageButton.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 0));
		barrensImageButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		barrensImageButton.setToolTipText(IMAGE_BUTTON_TOOLTIP_TEXT);
		barrensImageButton.setContentAreaFilled(false);
		barrensImageButton.setFocusPainted(false);
		
		barrensImagePanel.add(barrensImageButton);
		
		// Packs without epic panel
		JPanel barrensEpicPanel = new JPanel();
		barrensEpicPanel.setBackground(barrens.getBackground());
		barrensEpicPanel.setLayout(new GridLayout(4, 1));
		
		// Packs without epic panel title
		epicPanelTitleLabel = new JTextPane();
		doc = epicPanelTitleLabel.getStyledDocument();
		changePanelTitleStyle(barrens, epicPanelTitleLabel, EPIC_PANEL_TITLE);
		epicPanelTitleLabel.setForeground(headerTitleColor);
		
		// Packs without epic counter panel
		barrensEpicCounterPanel = new JTextPane();
		doc = barrensEpicCounterPanel.getStyledDocument();
		changePanelTextStyle(barrens, barrensEpicCounterPanel, EPIC_COUNTER_TEXT, barrensEpicCounter);
		barrensEpicCounterPanel.setForeground(headerTitleColor);
		
		// Packs without epic counter modify buttons panel
		JPanel barrensEpicModifyPanel = new JPanel();
		
		// Reset button
		barrensEpicReset = new ModifierButton(RESET, headerTitleColor, buttonsDarkHoverColor);
		barrensEpicReset.setToolTipText(RESET_BUTTON_TOOLTIP_TEXT);
		barrensEpicReset.setBackground(headerTitleColor);
		
		// Blank space between reset and add buttons
		blank = new JLabel();
		blank.setBackground(barrens.getBackground());
		blank.setBorder(new EmptyBorder(0, 20, 0, 20));
		
		// Add button
		barrensEpicAdd = new RoundButton(ADD, headerTitleColor, buttonsDarkHoverColor);
		barrensEpicAdd.setBackground(headerTitleColor);
		
		// Increment field
		barrensEpicIncrement = new JTextArea(1, 1);
		barrensEpicIncrement.setDocument(new LimitedIncrement(1));
		barrensEpicIncrement.setBackground(headerTitleColor);
		barrensEpicIncrement.setBorder(new EmptyBorder(0, 9, 0, 6));
		
		createModifyButtonsPanel(barrens, barrensEpicModifyPanel, barrensEpicReset, barrensEpicAdd, barrensEpicIncrement);
		
		// Packs without epic probability panel
		barrensEpicProbabilityPanel = new JTextPane();
		doc = barrensEpicProbabilityPanel.getStyledDocument();
		changePanelTextStyle(barrens, barrensEpicProbabilityPanel, EPIC_PROBABILITY_TEXT, barrensEpicProbability);
		barrensEpicProbabilityPanel.setForeground(headerTitleColor);
		
		barrensEpicPanel.add(epicPanelTitleLabel);
		barrensEpicPanel.add(barrensEpicCounterPanel);
		barrensEpicPanel.add(barrensEpicModifyPanel);
		barrensEpicPanel.add(barrensEpicProbabilityPanel);
		
		// Packs without legendary panel
		JPanel barrensLegendaryPanel = new JPanel();
		barrensLegendaryPanel.setBackground(barrens.getBackground());
		barrensLegendaryPanel.setLayout(new GridLayout(4, 1));
		
		// Packs without legendary panel title
		legendaryPanelTitleLabel = new JTextPane();
		doc = legendaryPanelTitleLabel.getStyledDocument();
		changePanelTitleStyle(barrens, legendaryPanelTitleLabel, LEGENDARY_PANEL_TITLE);
		legendaryPanelTitleLabel.setForeground(headerTitleColor);
		
		// Packs without legendary counter panel
		barrensLegendaryCounterPanel = new JTextPane();
		doc = barrensLegendaryCounterPanel.getStyledDocument();
		changePanelTextStyle(barrens, barrensLegendaryCounterPanel, LEGENDARY_COUNTER_TEXT, barrensLegendaryCounter);
		barrensLegendaryCounterPanel.setForeground(headerTitleColor);
		
		// Packs without legendary counter modify buttons panel
		JPanel barrensLegendaryModifyPanel = new JPanel();
		
		// Reset button
		barrensLegendaryReset = new ModifierButton(RESET, headerTitleColor, buttonsDarkHoverColor);
		barrensLegendaryReset.setToolTipText(RESET_BUTTON_TOOLTIP_TEXT);
		barrensLegendaryReset.setBackground(headerTitleColor);
		
		// Blank space between reset and add buttons
		blank = new JLabel();
		blank.setBackground(barrens.getBackground());
		blank.setBorder(new EmptyBorder(0, 20, 0, 20));
		
		// Add button
		barrensLegendaryAdd = new RoundButton(ADD, headerTitleColor, buttonsDarkHoverColor);
		barrensLegendaryAdd.setBackground(headerTitleColor);
		
		// Increment field
		barrensLegendaryIncrement = new JTextArea(1, 2);
		barrensLegendaryIncrement.setDocument(new LimitedIncrement(2));
		barrensLegendaryIncrement.setBackground(headerTitleColor);
		barrensLegendaryIncrement.setBorder(new EmptyBorder(0, 9, 0, 3));
		
		createModifyButtonsPanel(barrens, barrensLegendaryModifyPanel, barrensLegendaryReset, barrensLegendaryAdd, barrensLegendaryIncrement);
		
		// Packs without legendary probability panel
		barrensLegendaryProbabilityPanel = new JTextPane();
		doc = barrensLegendaryProbabilityPanel.getStyledDocument();
		changePanelTextStyle(barrens, barrensLegendaryProbabilityPanel, LEGENDARY_PROBABILITY_TEXT, barrensLegendaryProbability);
		barrensLegendaryProbabilityPanel.setForeground(headerTitleColor);
		
		barrensLegendaryPanel.add(legendaryPanelTitleLabel);
		barrensLegendaryPanel.add(barrensLegendaryCounterPanel);
		barrensLegendaryPanel.add(barrensLegendaryModifyPanel);
		barrensLegendaryPanel.add(barrensLegendaryProbabilityPanel);
		
		// Total amount of packs opened panel
		JPanel barrensTotalPanel = new JPanel();
		barrensTotalPanel.setBackground(barrens.getBackground());
		barrensTotalPanel.setLayout(new GridLayout(4, 1));
		
		// Total amount of packs opened panel title
		totalPanelTitleLabel = new JTextPane();
		doc = totalPanelTitleLabel.getStyledDocument();
		changePanelTitleStyle(barrens, totalPanelTitleLabel,TOTAL_PANEL_TITLE);
		totalPanelTitleLabel.setForeground(headerTitleColor);
		
		// Total amount of packs opened counter panel panel
		barrensTotalCounterPanel = new JTextPane();
		doc = barrensTotalCounterPanel.getStyledDocument();
		changePanelTextStyle(barrens, barrensTotalCounterPanel, TOTAL_COUNTER_TEXT, barrensTotalCounter);
		barrensTotalCounterPanel.setForeground(headerTitleColor);
		
		// Total amount of packs opened counter modify buttons panel
		JPanel barrensTotalModifyPanel = new JPanel();
		
		// Modify button
		barrensTotalModify = new ModifierButton(MODIFY, headerTitleColor, buttonsDarkHoverColor);
		barrensTotalModify.setToolTipText(MODIFY_BUTTON_TOOLTIP_TEXT);
		barrensTotalModify.setBackground(headerTitleColor);
		
		// Blank space between modify and add buttons
		blank = new JLabel();
		blank.setBackground(barrens.getBackground());
		blank.setBorder(new EmptyBorder(0, 5, 0, 5));
		
		// Add button
		barrensTotalAdd = new RoundButton(ADD, headerTitleColor, buttonsDarkHoverColor);
		barrensTotalAdd.setBackground(headerTitleColor);
		
		// Increment field
		barrensTotalIncrement = new JTextArea(1, 3);
		barrensTotalIncrement.setDocument(new LimitedIncrement(3));
		barrensTotalIncrement.setBackground(headerTitleColor);
		barrensTotalIncrement.setBorder(new EmptyBorder(0, 9, 0, 0));
		
		createModifyButtonsPanel(barrens, barrensTotalModifyPanel, barrensTotalModify, barrensTotalAdd, barrensTotalIncrement);
		
		// Common button
		JPanel barrensCommonButtonPanel = new JPanel(new GridBagLayout());
		barrensCommonButton = new IconButton(new ImageIcon(commonButtonDarkIcon), new ImageIcon(commonButtonDarkHoverIcon));
		
		// Rare button
		JPanel barrensRareButtonPanel = new JPanel(new GridBagLayout());
		barrensRareButton = new IconButton(new ImageIcon(rareButtonDarkIcon), new ImageIcon(rareButtonDarkHoverIcon));
		
		// Epic button
		JPanel barrensEpicButtonPanel = new JPanel(new GridBagLayout());
		barrensEpicButton = new IconButton(new ImageIcon(epicButtonDarkIcon), new ImageIcon(epicButtonDarkHoverIcon));
		
		// Legendary button
		JPanel barrensLegendaryButtonPanel = new JPanel(new GridBagLayout());
		barrensLegendaryButton = new IconButton(new ImageIcon(legendaryButtonDarkIcon), new ImageIcon(legendaryButtonDarkHoverIcon));
		
		// Rarity buttons panel
		JPanel barrensRarityButtonsPanel = new JPanel();
		barrensRarityButtonsPanel.setBackground(barrens.getBackground());
		barrensRarityButtonsPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 25, 0));
		createCommonButtonPanel(barrens, barrensCommonButtonPanel, barrensCommonButton);
		createRareButtonPanel(barrens, barrensRareButtonPanel, barrensRareButton);
		createEpicButtonPanel(barrens, barrensEpicButtonPanel, barrensEpicButton);
		createLegendaryButtonPanel(barrens, barrensLegendaryButtonPanel, barrensLegendaryButton);
		barrensRarityButtonsPanel.add(barrensCommonButtonPanel);
		barrensRarityButtonsPanel.add(barrensRareButtonPanel);
		barrensRarityButtonsPanel.add(barrensEpicButtonPanel);
		barrensRarityButtonsPanel.add(barrensLegendaryButtonPanel);
		
		barrensTotalPanel.add(totalPanelTitleLabel);
		barrensTotalPanel.add(barrensTotalCounterPanel);
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
		phoenixHeader = new JPanel(new FlowLayout(FlowLayout.CENTER));
		phoenixHeader.setBackground(yearsColor);

		JLabel phoenixImageLabel = new JLabel(new ImageIcon(phoenixImage));
		phoenixImageLabel.setBorder(new EmptyBorder(0, 5, 0, 5));

		JLabel phoenixLabel = new JLabel(PHOENIX_TITLE);
		phoenixLabel.setFont(yearsFont);
		phoenixLabel.setBorder(new EmptyBorder(5, 10, 5, 5));
		
		phoenixHeader.add(phoenixImageLabel);
		phoenixHeader.add(phoenixLabel);
		
		// "Year of the Phoenix" expansions
		createMadnessAtTheDarkmoonFairePanel();
		createScholomanceAcademyPanel();
		createAshesOfOutlandPanel();
		
		SwingUtilities.invokeLater(() -> {
			phoenix.add(phoenixHeader);
			phoenix.add(darkmoon);
			phoenix.add(scholomance);
			phoenix.add(outland);
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
		JPanel darkmoonImagePanel = new JPanel(new GridBagLayout());
		darkmoonImagePanel.setBackground(darkmoon.getBackground());
		
		darkmoonImageButton = new JButton(new ImageIcon(darkmoonImage));
		darkmoonImageButton.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 0));
		darkmoonImageButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		darkmoonImageButton.setToolTipText(IMAGE_BUTTON_TOOLTIP_TEXT);
		darkmoonImageButton.setContentAreaFilled(false);
		darkmoonImageButton.setFocusPainted(false);
		
		darkmoonImagePanel.add(darkmoonImageButton);
		
		// Packs without epic panel
		JPanel darkmoonEpicPanel = new JPanel();
		darkmoonEpicPanel.setBackground(darkmoon.getBackground());
		darkmoonEpicPanel.setLayout(new GridLayout(4, 1));
		
		// Packs without epic panel title
		epicPanelTitleLabel = new JTextPane();
		doc = epicPanelTitleLabel.getStyledDocument();
		changePanelTitleStyle(darkmoon, epicPanelTitleLabel, EPIC_PANEL_TITLE);
		
		// Packs without epic counter panel
		darkmoonEpicCounterPanel = new JTextPane();
		doc = darkmoonEpicCounterPanel.getStyledDocument();
		changePanelTextStyle(darkmoon, darkmoonEpicCounterPanel, EPIC_COUNTER_TEXT, darkmoonEpicCounter);
		
		// Packs without epic counter modify buttons panel
		JPanel darkmoonEpicModifyPanel = new JPanel();
		
		// Reset button
		darkmoonEpicReset = new ModifierButton(RESET, headerBGColor, buttonsHoverColor);
		darkmoonEpicReset.setToolTipText(RESET_BUTTON_TOOLTIP_TEXT);
		darkmoonEpicReset.setBackground(headerBGColor);
		darkmoonEpicReset.setForeground(headerTitleColor);
		
		// Blank space between reset and add buttons
		blank = new JLabel();
		blank.setBackground(darkmoon.getBackground());
		blank.setBorder(new EmptyBorder(0, 20, 0, 20));
		
		// Add button
		darkmoonEpicAdd = new RoundButton(ADD, headerBGColor, buttonsHoverColor);
		darkmoonEpicAdd.setBackground(headerBGColor);
		darkmoonEpicAdd.setForeground(headerTitleColor);
		
		// Increment field
		darkmoonEpicIncrement = new JTextArea(1, 1);
		darkmoonEpicIncrement.setDocument(new LimitedIncrement(1));
		darkmoonEpicIncrement.setBackground(headerBGColor);
		darkmoonEpicIncrement.setForeground(headerTitleColor);
		darkmoonEpicIncrement.setCaretColor(headerTitleColor);
		darkmoonEpicIncrement.setBorder(new EmptyBorder(0, 9, 0, 6));
		
		createModifyButtonsPanel(darkmoon, darkmoonEpicModifyPanel, darkmoonEpicReset, darkmoonEpicAdd, darkmoonEpicIncrement);
		
		// Packs without epic probability panel
		darkmoonEpicProbabilityPanel = new JTextPane();
		doc = darkmoonEpicProbabilityPanel.getStyledDocument();
		changePanelTextStyle(darkmoon, darkmoonEpicProbabilityPanel, EPIC_PROBABILITY_TEXT, darkmoonEpicProbability);
		
		darkmoonEpicPanel.add(epicPanelTitleLabel);
		darkmoonEpicPanel.add(darkmoonEpicCounterPanel);
		darkmoonEpicPanel.add(darkmoonEpicModifyPanel);
		darkmoonEpicPanel.add(darkmoonEpicProbabilityPanel);
		
		// Packs without legendary panel
		JPanel darkmoonLegendaryPanel = new JPanel();
		darkmoonLegendaryPanel.setBackground(darkmoon.getBackground());
		darkmoonLegendaryPanel.setLayout(new GridLayout(4, 1));
		
		// Packs without legendary panel title
		legendaryPanelTitleLabel = new JTextPane();
		doc = legendaryPanelTitleLabel.getStyledDocument();
		changePanelTitleStyle(darkmoon, legendaryPanelTitleLabel, LEGENDARY_PANEL_TITLE);
		
		// Packs without legendary counter panel
		darkmoonLegendaryCounterPanel = new JTextPane();
		doc = darkmoonLegendaryCounterPanel.getStyledDocument();
		changePanelTextStyle(darkmoon, darkmoonLegendaryCounterPanel, LEGENDARY_COUNTER_TEXT, darkmoonLegendaryCounter);
		
		// Packs without legendary counter modify buttons panel
		JPanel darkmoonLegendaryModifyPanel = new JPanel();
		
		// Reset button
		darkmoonLegendaryReset = new ModifierButton(RESET, headerBGColor, buttonsHoverColor);
		darkmoonLegendaryReset.setToolTipText(RESET_BUTTON_TOOLTIP_TEXT);
		darkmoonLegendaryReset.setBackground(headerBGColor);
		darkmoonLegendaryReset.setForeground(headerTitleColor);
		
		// Blank space between reset and add buttons
		blank = new JLabel();
		blank.setBackground(darkmoon.getBackground());
		blank.setBorder(new EmptyBorder(0, 20, 0, 20));
		
		// Add button
		darkmoonLegendaryAdd = new RoundButton(ADD, headerBGColor, buttonsHoverColor);
		darkmoonLegendaryAdd.setBackground(headerBGColor);
		darkmoonLegendaryAdd.setForeground(headerTitleColor);
		
		// Increment field
		darkmoonLegendaryIncrement = new JTextArea(1, 2);
		darkmoonLegendaryIncrement.setDocument(new LimitedIncrement(2));
		darkmoonLegendaryIncrement.setBackground(headerBGColor);
		darkmoonLegendaryIncrement.setForeground(headerTitleColor);
		darkmoonLegendaryIncrement.setCaretColor(headerTitleColor);
		darkmoonLegendaryIncrement.setBorder(new EmptyBorder(0, 9, 0, 3));
		
		createModifyButtonsPanel(darkmoon, darkmoonLegendaryModifyPanel, darkmoonLegendaryReset, darkmoonLegendaryAdd, darkmoonLegendaryIncrement);
		
		// Packs without legendary probability panel
		darkmoonLegendaryProbabilityPanel = new JTextPane();
		doc = darkmoonLegendaryProbabilityPanel.getStyledDocument();
		changePanelTextStyle(darkmoon, darkmoonLegendaryProbabilityPanel, LEGENDARY_PROBABILITY_TEXT, darkmoonLegendaryProbability);
		
		darkmoonLegendaryPanel.add(legendaryPanelTitleLabel);
		darkmoonLegendaryPanel.add(darkmoonLegendaryCounterPanel);
		darkmoonLegendaryPanel.add(darkmoonLegendaryModifyPanel);
		darkmoonLegendaryPanel.add(darkmoonLegendaryProbabilityPanel);
		
		// Total amount of packs opened panel
		JPanel darkmoonTotalPanel = new JPanel();
		darkmoonTotalPanel.setBackground(darkmoon.getBackground());
		darkmoonTotalPanel.setLayout(new GridLayout(4, 1));
		
		// Total amount of packs opened panel title
		totalPanelTitleLabel = new JTextPane();
		doc = totalPanelTitleLabel.getStyledDocument();
		changePanelTitleStyle(darkmoon, totalPanelTitleLabel,TOTAL_PANEL_TITLE);
		
		// Total amount of packs opened counter panel
		darkmoonTotalCounterPanel = new JTextPane();
		doc = darkmoonTotalCounterPanel.getStyledDocument();
		changePanelTextStyle(darkmoon, darkmoonTotalCounterPanel, TOTAL_COUNTER_TEXT, darkmoonTotalCounter);
		
		// Total amount of packs opened counter modify buttons panel
		JPanel darkmoonTotalModifyPanel = new JPanel();
		
		// Modify button
		darkmoonTotalModify = new ModifierButton(MODIFY, headerBGColor, buttonsHoverColor);
		darkmoonTotalModify.setToolTipText(MODIFY_BUTTON_TOOLTIP_TEXT);
		darkmoonTotalModify.setBackground(headerBGColor);
		darkmoonTotalModify.setForeground(headerTitleColor);
		
		// Blank space between modify and add buttons
		blank = new JLabel();
		blank.setBackground(darkmoon.getBackground());
		blank.setBorder(new EmptyBorder(0, 5, 0, 5));
		
		// Add button
		darkmoonTotalAdd = new RoundButton(ADD, headerBGColor, buttonsHoverColor);
		darkmoonTotalAdd.setBackground(headerBGColor);
		darkmoonTotalAdd.setForeground(headerTitleColor);
		
		// Increment field
		darkmoonTotalIncrement = new JTextArea(1, 3);
		darkmoonTotalIncrement.setDocument(new LimitedIncrement(3));
		darkmoonTotalIncrement.setBackground(headerBGColor);
		darkmoonTotalIncrement.setForeground(headerTitleColor);
		darkmoonTotalIncrement.setCaretColor(headerTitleColor);
		darkmoonTotalIncrement.setBorder(new EmptyBorder(0, 9, 0, 0));
		
		createModifyButtonsPanel(darkmoon, darkmoonTotalModifyPanel, darkmoonTotalModify, darkmoonTotalAdd, darkmoonTotalIncrement);
		
		// Common button
		JPanel darkmoonCommonButtonPanel = new JPanel(new GridBagLayout());
		darkmoonCommonButton = new IconButton(new ImageIcon(commonButtonIcon), new ImageIcon(commonButtonHoverIcon));
		
		// Rare button
		JPanel darkmoonRareButtonPanel = new JPanel(new GridBagLayout());
		darkmoonRareButton = new IconButton(new ImageIcon(rareButtonIcon), new ImageIcon(rareButtonHoverIcon));
		
		// Epic button
		JPanel darkmoonEpicButtonPanel = new JPanel(new GridBagLayout());
		darkmoonEpicButton = new IconButton(new ImageIcon(epicButtonIcon), new ImageIcon(epicButtonHoverIcon));
		
		// Legendary button
		JPanel darkmoonLegendaryButtonPanel = new JPanel(new GridBagLayout());
		darkmoonLegendaryButton = new IconButton(new ImageIcon(legendaryButtonIcon), new ImageIcon(legendaryButtonHoverIcon));
		
		// Rarity buttons panel
		JPanel darkmoonRarityButtonsPanel = new JPanel();
		darkmoonRarityButtonsPanel.setBackground(darkmoon.getBackground());
		darkmoonRarityButtonsPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 25, 0));
		createCommonButtonPanel(darkmoon, darkmoonCommonButtonPanel, darkmoonCommonButton);
		createRareButtonPanel(darkmoon, darkmoonRareButtonPanel, darkmoonRareButton);
		createEpicButtonPanel(darkmoon, darkmoonEpicButtonPanel, darkmoonEpicButton);
		createLegendaryButtonPanel(darkmoon, darkmoonLegendaryButtonPanel, darkmoonLegendaryButton);
		darkmoonRarityButtonsPanel.add(darkmoonCommonButtonPanel);
		darkmoonRarityButtonsPanel.add(darkmoonRareButtonPanel);
		darkmoonRarityButtonsPanel.add(darkmoonEpicButtonPanel);
		darkmoonRarityButtonsPanel.add(darkmoonLegendaryButtonPanel);
		
		darkmoonTotalPanel.add(totalPanelTitleLabel);
		darkmoonTotalPanel.add(darkmoonTotalCounterPanel);
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
		JPanel scholomanceImagePanel = new JPanel(new GridBagLayout());
		scholomanceImagePanel.setBackground(scholomance.getBackground());
		
		scholomanceImageButton = new JButton(new ImageIcon(scholomanceImage));
		scholomanceImageButton.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 0));
		scholomanceImageButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		scholomanceImageButton.setToolTipText(IMAGE_BUTTON_TOOLTIP_TEXT);
		scholomanceImageButton.setContentAreaFilled(false);
		scholomanceImageButton.setFocusPainted(false);
		
		scholomanceImagePanel.add(scholomanceImageButton);
		
		// Packs without epic panel
		JPanel scholomanceEpicPanel = new JPanel();
		scholomanceEpicPanel.setBackground(scholomance.getBackground());
		scholomanceEpicPanel.setLayout(new GridLayout(4, 1));
		
		// Packs without epic panel title
		epicPanelTitleLabel = new JTextPane();
		doc = epicPanelTitleLabel.getStyledDocument();
		changePanelTitleStyle(scholomance, epicPanelTitleLabel, EPIC_PANEL_TITLE);
		epicPanelTitleLabel.setForeground(headerTitleColor);
		
		// Packs without epic counter panel
		scholomanceEpicCounterPanel = new JTextPane();
		doc = scholomanceEpicCounterPanel.getStyledDocument();
		changePanelTextStyle(scholomance, scholomanceEpicCounterPanel, EPIC_COUNTER_TEXT, scholomanceEpicCounter);
		scholomanceEpicCounterPanel.setForeground(headerTitleColor);
		
		// Packs without epic counter modify buttons panel
		JPanel scholomanceEpicModifyPanel = new JPanel();
		
		// Reset button
		scholomanceEpicReset = new ModifierButton(RESET, headerTitleColor, buttonsDarkHoverColor);
		scholomanceEpicReset.setToolTipText(RESET_BUTTON_TOOLTIP_TEXT);
		scholomanceEpicReset.setBackground(headerTitleColor);
		
		// Blank space between reset and add buttons
		blank = new JLabel();
		blank.setBackground(scholomance.getBackground());
		blank.setBorder(new EmptyBorder(0, 20, 0, 20));
		
		// Add button
		scholomanceEpicAdd = new RoundButton(ADD, headerTitleColor, buttonsDarkHoverColor);
		scholomanceEpicAdd.setBackground(headerTitleColor);
		
		// Increment field
		scholomanceEpicIncrement = new JTextArea(1, 1);
		scholomanceEpicIncrement.setDocument(new LimitedIncrement(1));
		scholomanceEpicIncrement.setBackground(headerTitleColor);
		scholomanceEpicIncrement.setBorder(new EmptyBorder(0, 9, 0, 6));
		
		createModifyButtonsPanel(scholomance, scholomanceEpicModifyPanel, scholomanceEpicReset, scholomanceEpicAdd, scholomanceEpicIncrement);
		
		// Packs without epic probability panel
		scholomanceEpicProbabilityPanel = new JTextPane();
		doc = scholomanceEpicProbabilityPanel.getStyledDocument();
		changePanelTextStyle(scholomance, scholomanceEpicProbabilityPanel, EPIC_PROBABILITY_TEXT, scholomanceEpicProbability);
		scholomanceEpicProbabilityPanel.setForeground(headerTitleColor);
		
		scholomanceEpicPanel.add(epicPanelTitleLabel);
		scholomanceEpicPanel.add(scholomanceEpicCounterPanel);
		scholomanceEpicPanel.add(scholomanceEpicModifyPanel);
		scholomanceEpicPanel.add(scholomanceEpicProbabilityPanel);
		
		// Packs without legendary panel
		JPanel scholomanceLegendaryPanel = new JPanel();
		scholomanceLegendaryPanel.setBackground(scholomance.getBackground());
		scholomanceLegendaryPanel.setLayout(new GridLayout(4, 1));
		
		// Packs without legendary panel title
		legendaryPanelTitleLabel = new JTextPane();
		doc = legendaryPanelTitleLabel.getStyledDocument();
		changePanelTitleStyle(scholomance, legendaryPanelTitleLabel, LEGENDARY_PANEL_TITLE);
		legendaryPanelTitleLabel.setForeground(headerTitleColor);
		
		// Packs without legendary counter panel
		scholomanceLegendaryCounterPanel = new JTextPane();
		doc = scholomanceLegendaryCounterPanel.getStyledDocument();
		changePanelTextStyle(scholomance, scholomanceLegendaryCounterPanel, LEGENDARY_COUNTER_TEXT, scholomanceLegendaryCounter);
		scholomanceLegendaryCounterPanel.setForeground(headerTitleColor);
		
		// Packs without legendary counter modify buttons panel
		JPanel scholomanceLegendaryModifyPanel = new JPanel();
		
		// Reset button
		scholomanceLegendaryReset = new ModifierButton(RESET, headerTitleColor, buttonsDarkHoverColor);
		scholomanceLegendaryReset.setToolTipText(RESET_BUTTON_TOOLTIP_TEXT);
		scholomanceLegendaryReset.setBackground(headerTitleColor);
		
		// Blank space between reset and add buttons
		blank = new JLabel();
		blank.setBackground(scholomance.getBackground());
		blank.setBorder(new EmptyBorder(0, 20, 0, 20));
		
		// Add button
		scholomanceLegendaryAdd = new RoundButton(ADD, headerTitleColor, buttonsDarkHoverColor);
		scholomanceLegendaryAdd.setBackground(headerTitleColor);
		
		// Increment field
		scholomanceLegendaryIncrement = new JTextArea(1, 2);
		scholomanceLegendaryIncrement.setDocument(new LimitedIncrement(2));
		scholomanceLegendaryIncrement.setBackground(headerTitleColor);
		scholomanceLegendaryIncrement.setBorder(new EmptyBorder(0, 9, 0, 3));
		
		createModifyButtonsPanel(scholomance, scholomanceLegendaryModifyPanel, scholomanceLegendaryReset, scholomanceLegendaryAdd, scholomanceLegendaryIncrement);
		
		// Packs without legendary probability panel
		scholomanceLegendaryProbabilityPanel = new JTextPane();
		doc = scholomanceLegendaryProbabilityPanel.getStyledDocument();
		changePanelTextStyle(scholomance, scholomanceLegendaryProbabilityPanel, LEGENDARY_PROBABILITY_TEXT, scholomanceLegendaryProbability);
		scholomanceLegendaryProbabilityPanel.setForeground(headerTitleColor);
		
		scholomanceLegendaryPanel.add(legendaryPanelTitleLabel);
		scholomanceLegendaryPanel.add(scholomanceLegendaryCounterPanel);
		scholomanceLegendaryPanel.add(scholomanceLegendaryModifyPanel);
		scholomanceLegendaryPanel.add(scholomanceLegendaryProbabilityPanel);
		
		// Total amount of packs opened panel
		JPanel scholomanceTotalPanel = new JPanel();
		scholomanceTotalPanel.setBackground(scholomance.getBackground());
		scholomanceTotalPanel.setLayout(new GridLayout(4, 1));
		
		// Total amount of packs opened panel title
		totalPanelTitleLabel = new JTextPane();
		doc = totalPanelTitleLabel.getStyledDocument();
		changePanelTitleStyle(scholomance, totalPanelTitleLabel,TOTAL_PANEL_TITLE);
		totalPanelTitleLabel.setForeground(headerTitleColor);
		
		// Total amount of packs opened counter panel
		scholomanceTotalCounterPanel = new JTextPane();
		doc = scholomanceTotalCounterPanel.getStyledDocument();
		changePanelTextStyle(scholomance, scholomanceTotalCounterPanel, TOTAL_COUNTER_TEXT, scholomanceTotalCounter);
		scholomanceTotalCounterPanel.setForeground(headerTitleColor);
		
		// Total amount of packs opened counter modify buttons panel
		JPanel scholomanceTotalModifyPanel = new JPanel();
		
		// Modify button
		scholomanceTotalModify = new ModifierButton(MODIFY, headerTitleColor, buttonsDarkHoverColor);
		scholomanceTotalModify.setToolTipText(MODIFY_BUTTON_TOOLTIP_TEXT);
		scholomanceTotalModify.setBackground(headerTitleColor);
		
		// Blank space between modify and add buttons
		blank = new JLabel();
		blank.setBackground(scholomance.getBackground());
		blank.setBorder(new EmptyBorder(0, 5, 0, 5));
		
		// Add button
		scholomanceTotalAdd = new RoundButton(ADD, headerTitleColor, buttonsDarkHoverColor);
		scholomanceTotalAdd.setBackground(headerTitleColor);
		
		// Increment field
		scholomanceTotalIncrement = new JTextArea(1, 3);
		scholomanceTotalIncrement.setDocument(new LimitedIncrement(3));
		scholomanceTotalIncrement.setBackground(headerTitleColor);
		scholomanceTotalIncrement.setBorder(new EmptyBorder(0, 9, 0, 0));
		
		createModifyButtonsPanel(scholomance, scholomanceTotalModifyPanel, scholomanceTotalModify, scholomanceTotalAdd, scholomanceTotalIncrement);
		
		// Common button
		JPanel scholomanceCommonButtonPanel = new JPanel(new GridBagLayout());
		scholomanceCommonButton = new IconButton(new ImageIcon(commonButtonDarkIcon), new ImageIcon(commonButtonDarkHoverIcon));
		
		// Rare button
		JPanel scholomanceRareButtonPanel = new JPanel(new GridBagLayout());
		scholomanceRareButton = new IconButton(new ImageIcon(rareButtonDarkIcon), new ImageIcon(rareButtonDarkHoverIcon));
		
		// Epic button
		JPanel scholomanceEpicButtonPanel = new JPanel(new GridBagLayout());
		scholomanceEpicButton = new IconButton(new ImageIcon(epicButtonDarkIcon), new ImageIcon(epicButtonDarkHoverIcon));
		
		// Legendary button
		JPanel scholomanceLegendaryButtonPanel = new JPanel(new GridBagLayout());
		scholomanceLegendaryButton = new IconButton(new ImageIcon(legendaryButtonDarkIcon), new ImageIcon(legendaryButtonDarkHoverIcon));
		
		// Rarity buttons panel
		JPanel scholomanceRarityButtonsPanel = new JPanel();
		scholomanceRarityButtonsPanel.setBackground(scholomance.getBackground());
		scholomanceRarityButtonsPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 25, 0));
		createCommonButtonPanel(scholomance, scholomanceCommonButtonPanel, scholomanceCommonButton);
		createRareButtonPanel(scholomance, scholomanceRareButtonPanel, scholomanceRareButton);
		createEpicButtonPanel(scholomance, scholomanceEpicButtonPanel, scholomanceEpicButton);
		createLegendaryButtonPanel(scholomance, scholomanceLegendaryButtonPanel, scholomanceLegendaryButton);
		scholomanceRarityButtonsPanel.add(scholomanceCommonButtonPanel);
		scholomanceRarityButtonsPanel.add(scholomanceRareButtonPanel);
		scholomanceRarityButtonsPanel.add(scholomanceEpicButtonPanel);
		scholomanceRarityButtonsPanel.add(scholomanceLegendaryButtonPanel);
		
		scholomanceTotalPanel.add(totalPanelTitleLabel);
		scholomanceTotalPanel.add(scholomanceTotalCounterPanel);
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
		JPanel outlandImagePanel = new JPanel(new GridBagLayout());
		outlandImagePanel.setBackground(outland.getBackground());
		
		outlandImageButton = new JButton(new ImageIcon(outlandImage));
		outlandImageButton.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 0));
		outlandImageButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		outlandImageButton.setToolTipText(IMAGE_BUTTON_TOOLTIP_TEXT);
		outlandImageButton.setContentAreaFilled(false);
		outlandImageButton.setFocusPainted(false);
		
		outlandImagePanel.add(outlandImageButton);
		
		// Packs without epic panel
		JPanel outlandEpicPanel = new JPanel();
		outlandEpicPanel.setBackground(outland.getBackground());
		outlandEpicPanel.setLayout(new GridLayout(4, 1));
		
		// Packs without epic panel title
		epicPanelTitleLabel = new JTextPane();
		doc = epicPanelTitleLabel.getStyledDocument();
		changePanelTitleStyle(outland, epicPanelTitleLabel, EPIC_PANEL_TITLE);
		epicPanelTitleLabel.setForeground(headerTitleColor);
		
		// Packs without epic counter panel
		outlandEpicCounterPanel = new JTextPane();
		doc = outlandEpicCounterPanel.getStyledDocument();
		changePanelTextStyle(outland, outlandEpicCounterPanel, EPIC_COUNTER_TEXT, outlandEpicCounter);
		outlandEpicCounterPanel.setForeground(headerTitleColor);
		
		// Packs without epic counter modify buttons panel
		JPanel outlandEpicModifyPanel = new JPanel();
		
		// Reset button
		outlandEpicReset = new ModifierButton(RESET, headerTitleColor, buttonsDarkHoverColor);
		outlandEpicReset.setToolTipText(RESET_BUTTON_TOOLTIP_TEXT);
		outlandEpicReset.setBackground(headerTitleColor);
		
		// Blank space between reset and add buttons
		blank = new JLabel();
		blank.setBackground(outland.getBackground());
		blank.setBorder(new EmptyBorder(0, 20, 0, 20));
		
		// Add button
		outlandEpicAdd = new RoundButton(ADD, headerTitleColor, buttonsDarkHoverColor);
		outlandEpicAdd.setBackground(headerTitleColor);
		
		// Increment field
		outlandEpicIncrement = new JTextArea(1, 1);
		outlandEpicIncrement.setDocument(new LimitedIncrement(1));
		outlandEpicIncrement.setBackground(headerTitleColor);
		outlandEpicIncrement.setBorder(new EmptyBorder(0, 9, 0, 6));
		
		createModifyButtonsPanel(outland, outlandEpicModifyPanel, outlandEpicReset, outlandEpicAdd, outlandEpicIncrement);
		
		// Packs without epic probability panel
		outlandEpicProbabilityPanel = new JTextPane();
		doc = outlandEpicProbabilityPanel.getStyledDocument();
		changePanelTextStyle(outland, outlandEpicProbabilityPanel, EPIC_PROBABILITY_TEXT, outlandEpicProbability);
		outlandEpicProbabilityPanel.setForeground(headerTitleColor);
		
		outlandEpicPanel.add(epicPanelTitleLabel);
		outlandEpicPanel.add(outlandEpicCounterPanel);
		outlandEpicPanel.add(outlandEpicModifyPanel);
		outlandEpicPanel.add(outlandEpicProbabilityPanel);
		
		// Packs without legendary panel
		JPanel outlandLegendaryPanel = new JPanel();
		outlandLegendaryPanel.setBackground(outland.getBackground());
		outlandLegendaryPanel.setLayout(new GridLayout(4, 1));
		
		// Packs without legendary panel title
		legendaryPanelTitleLabel = new JTextPane();
		doc = legendaryPanelTitleLabel.getStyledDocument();
		changePanelTitleStyle(outland, legendaryPanelTitleLabel, LEGENDARY_PANEL_TITLE);
		legendaryPanelTitleLabel.setForeground(headerTitleColor);
		
		// Packs without legendary counter panel
		outlandLegendaryCounterPanel = new JTextPane();
		doc = outlandLegendaryCounterPanel.getStyledDocument();
		changePanelTextStyle(outland, outlandLegendaryCounterPanel, LEGENDARY_COUNTER_TEXT, outlandLegendaryCounter);
		outlandLegendaryCounterPanel.setForeground(headerTitleColor);
		
		// Packs without legendary counter modify buttons panel
		JPanel outlandLegendaryModifyPanel = new JPanel();
		
		// Reset button
		outlandLegendaryReset = new ModifierButton(RESET, headerTitleColor, buttonsDarkHoverColor);
		outlandLegendaryReset.setToolTipText(RESET_BUTTON_TOOLTIP_TEXT);
		outlandLegendaryReset.setBackground(headerTitleColor);
		
		// Blank space between reset and add buttons
		blank = new JLabel();
		blank.setBackground(outland.getBackground());
		blank.setBorder(new EmptyBorder(0, 20, 0, 20));
		
		// Add button
		outlandLegendaryAdd = new RoundButton(ADD, headerTitleColor, buttonsDarkHoverColor);
		outlandLegendaryAdd.setBackground(headerTitleColor);
		
		// Increment field
		outlandLegendaryIncrement = new JTextArea(1, 2);
		outlandLegendaryIncrement.setDocument(new LimitedIncrement(2));
		outlandLegendaryIncrement.setBackground(headerTitleColor);
		outlandLegendaryIncrement.setBorder(new EmptyBorder(0, 9, 0, 3));
		
		createModifyButtonsPanel(outland, outlandLegendaryModifyPanel, outlandLegendaryReset, outlandLegendaryAdd, outlandLegendaryIncrement);
		
		// Packs without legendary probability panel
		outlandLegendaryProbabilityPanel = new JTextPane();
		doc = outlandLegendaryProbabilityPanel.getStyledDocument();
		changePanelTextStyle(outland, outlandLegendaryProbabilityPanel, LEGENDARY_PROBABILITY_TEXT, outlandLegendaryProbability);
		outlandLegendaryProbabilityPanel.setForeground(headerTitleColor);
		
		outlandLegendaryPanel.add(legendaryPanelTitleLabel);
		outlandLegendaryPanel.add(outlandLegendaryCounterPanel);
		outlandLegendaryPanel.add(outlandLegendaryModifyPanel);
		outlandLegendaryPanel.add(outlandLegendaryProbabilityPanel);
		
		// Total amount of packs opened panel
		JPanel outlandTotalPanel = new JPanel();
		outlandTotalPanel.setBackground(outland.getBackground());
		outlandTotalPanel.setLayout(new GridLayout(4, 1));
		
		// Total amount of packs opened panel title
		totalPanelTitleLabel = new JTextPane();
		doc = totalPanelTitleLabel.getStyledDocument();
		changePanelTitleStyle(outland, totalPanelTitleLabel,TOTAL_PANEL_TITLE);
		totalPanelTitleLabel.setForeground(headerTitleColor);
		
		// Total amount of packs opened counter panel
		outlandTotalCounterPanel = new JTextPane();
		doc = outlandTotalCounterPanel.getStyledDocument();
		changePanelTextStyle(outland, outlandTotalCounterPanel, TOTAL_COUNTER_TEXT, outlandTotalCounter);
		outlandTotalCounterPanel.setForeground(headerTitleColor);
		
		// Total amount of packs opened counter modify buttons panel
		JPanel outlandTotalModifyPanel = new JPanel();
		
		// Modify button
		outlandTotalModify = new ModifierButton(MODIFY, headerTitleColor, buttonsDarkHoverColor);
		outlandTotalModify.setToolTipText(MODIFY_BUTTON_TOOLTIP_TEXT);
		outlandTotalModify.setBackground(headerTitleColor);
		
		// Blank space between modify and add buttons
		blank = new JLabel();
		blank.setBackground(outland.getBackground());
		blank.setBorder(new EmptyBorder(0, 5, 0, 5));
		
		// Add button
		outlandTotalAdd = new RoundButton(ADD, headerTitleColor, buttonsDarkHoverColor);
		outlandTotalAdd.setBackground(headerTitleColor);
		
		// Increment field
		outlandTotalIncrement = new JTextArea(1, 3);
		outlandTotalIncrement.setDocument(new LimitedIncrement(3));
		outlandTotalIncrement.setBackground(headerTitleColor);
		outlandTotalIncrement.setBorder(new EmptyBorder(0, 9, 0, 0));
		
		createModifyButtonsPanel(outland, outlandTotalModifyPanel, outlandTotalModify, outlandTotalAdd, outlandTotalIncrement);
		
		// Common button
		JPanel outlandCommonButtonPanel = new JPanel(new GridBagLayout());
		outlandCommonButton = new IconButton(new ImageIcon(commonButtonDarkIcon), new ImageIcon(commonButtonDarkHoverIcon));
		
		// Rare button
		JPanel outlandRareButtonPanel = new JPanel(new GridBagLayout());
		outlandRareButton = new IconButton(new ImageIcon(rareButtonDarkIcon), new ImageIcon(rareButtonDarkHoverIcon));
		
		// Epic button
		JPanel outlandEpicButtonPanel = new JPanel(new GridBagLayout());
		outlandEpicButton = new IconButton(new ImageIcon(epicButtonDarkIcon), new ImageIcon(epicButtonDarkHoverIcon));
		
		// Legendary button
		JPanel outlandLegendaryButtonPanel = new JPanel(new GridBagLayout());
		outlandLegendaryButton = new IconButton(new ImageIcon(legendaryButtonDarkIcon), new ImageIcon(legendaryButtonDarkHoverIcon));
		
		// Rarity buttons panel
		JPanel outlandRarityButtonsPanel = new JPanel();
		outlandRarityButtonsPanel.setBackground(outland.getBackground());
		outlandRarityButtonsPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 25, 0));
		createCommonButtonPanel(outland, outlandCommonButtonPanel, outlandCommonButton);
		createRareButtonPanel(outland, outlandRareButtonPanel, outlandRareButton);
		createEpicButtonPanel(outland, outlandEpicButtonPanel, outlandEpicButton);
		createLegendaryButtonPanel(outland, outlandLegendaryButtonPanel, outlandLegendaryButton);
		outlandRarityButtonsPanel.add(outlandCommonButtonPanel);
		outlandRarityButtonsPanel.add(outlandRareButtonPanel);
		outlandRarityButtonsPanel.add(outlandEpicButtonPanel);
		outlandRarityButtonsPanel.add(outlandLegendaryButtonPanel);
		
		outlandTotalPanel.add(totalPanelTitleLabel);
		outlandTotalPanel.add(outlandTotalCounterPanel);
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
		dragonHeader = new JPanel(new FlowLayout(FlowLayout.CENTER));
		dragonHeader.setBackground(yearsColor);

		JLabel dragonImageLabel = new JLabel(new ImageIcon(dragonImage));
		dragonImageLabel.setBorder(new EmptyBorder(0, 5, 0, 5));

		JLabel dragonLabel = new JLabel(DRAGON_TITLE);
		dragonLabel.setFont(yearsFont);
		dragonLabel.setBorder(new EmptyBorder(5, 10, 5, 5));
		
		dragonHeader.add(dragonImageLabel);
		dragonHeader.add(dragonLabel);
				
		// "Year of the Dragon" expansions
		createDescentOfDragonsPanel();
		createSaviorsOfUldumPanel();
		createRiseOfShadowsPanel();
		
		SwingUtilities.invokeLater(() -> {
			dragon.add(dragonHeader);
			dragon.add(dragons);
			dragon.add(uldum);
			dragon.add(shadows);
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
		JPanel dragonsImagePanel = new JPanel(new GridBagLayout());
		dragonsImagePanel.setBackground(dragons.getBackground());
		
		dragonsImageButton = new JButton(new ImageIcon(dragonsImage));
		dragonsImageButton.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 0));
		dragonsImageButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		dragonsImageButton.setToolTipText(IMAGE_BUTTON_TOOLTIP_TEXT);
		dragonsImageButton.setContentAreaFilled(false);
		dragonsImageButton.setFocusPainted(false);
		
		dragonsImagePanel.add(dragonsImageButton);
		
		// Packs without epic panel
		JPanel dragonsEpicPanel = new JPanel();
		dragonsEpicPanel.setBackground(dragons.getBackground());
		dragonsEpicPanel.setLayout(new GridLayout(4, 1));
		
		// Packs without epic panel title
		epicPanelTitleLabel = new JTextPane();
		doc = epicPanelTitleLabel.getStyledDocument();
		changePanelTitleStyle(dragons, epicPanelTitleLabel, EPIC_PANEL_TITLE);
		
		// Packs without epic counter panel
		dragonsEpicCounterPanel = new JTextPane();
		doc = dragonsEpicCounterPanel.getStyledDocument();
		changePanelTextStyle(dragons, dragonsEpicCounterPanel, EPIC_COUNTER_TEXT, dragonsEpicCounter);
		
		// Packs without epic counter modify buttons panel
		JPanel dragonsEpicModifyPanel = new JPanel();
		
		// Reset button
		dragonsEpicReset = new ModifierButton(RESET, headerBGColor, buttonsHoverColor);
		dragonsEpicReset.setToolTipText(RESET_BUTTON_TOOLTIP_TEXT);
		dragonsEpicReset.setBackground(headerBGColor);
		dragonsEpicReset.setForeground(headerTitleColor);
		
		// Blank space between reset and add buttons
		blank = new JLabel();
		blank.setBackground(dragons.getBackground());
		blank.setBorder(new EmptyBorder(0, 20, 0, 20));
		
		// Add button
		dragonsEpicAdd = new RoundButton(ADD, headerBGColor, buttonsHoverColor);
		dragonsEpicAdd.setBackground(headerBGColor);
		dragonsEpicAdd.setForeground(headerTitleColor);
		
		// Increment field
		dragonsEpicIncrement = new JTextArea(1, 1);
		dragonsEpicIncrement.setDocument(new LimitedIncrement(1));
		dragonsEpicIncrement.setBackground(headerBGColor);
		dragonsEpicIncrement.setForeground(headerTitleColor);
		dragonsEpicIncrement.setCaretColor(headerTitleColor);
		dragonsEpicIncrement.setBorder(new EmptyBorder(0, 9, 0, 6));
		
		createModifyButtonsPanel(dragons, dragonsEpicModifyPanel, dragonsEpicReset, dragonsEpicAdd, dragonsEpicIncrement);
		
		// Packs without epic probability panel
		dragonsEpicProbabilityPanel = new JTextPane();
		doc = dragonsEpicProbabilityPanel.getStyledDocument();
		changePanelTextStyle(dragons, dragonsEpicProbabilityPanel, EPIC_PROBABILITY_TEXT, dragonsEpicProbability);
		
		dragonsEpicPanel.add(epicPanelTitleLabel);
		dragonsEpicPanel.add(dragonsEpicCounterPanel);
		dragonsEpicPanel.add(dragonsEpicModifyPanel);
		dragonsEpicPanel.add(dragonsEpicProbabilityPanel);
		
		// Packs without legendary panel
		JPanel dragonsLegendaryPanel = new JPanel();
		dragonsLegendaryPanel.setBackground(dragons.getBackground());
		dragonsLegendaryPanel.setLayout(new GridLayout(4, 1));
		
		// Packs without legendary panel title
		legendaryPanelTitleLabel = new JTextPane();
		doc = legendaryPanelTitleLabel.getStyledDocument();
		changePanelTitleStyle(dragons, legendaryPanelTitleLabel, LEGENDARY_PANEL_TITLE);
		
		// Packs without legendary counter panel
		dragonsLegendaryCounterPanel = new JTextPane();
		doc = dragonsLegendaryCounterPanel.getStyledDocument();
		changePanelTextStyle(dragons, dragonsLegendaryCounterPanel, LEGENDARY_COUNTER_TEXT, dragonsLegendaryCounter);
		
		// Packs without legendary counter modify buttons panel
		JPanel dragonsLegendaryModifyPanel = new JPanel();
		
		// Reset button
		dragonsLegendaryReset = new ModifierButton(RESET, headerBGColor, buttonsHoverColor);
		dragonsLegendaryReset.setToolTipText(RESET_BUTTON_TOOLTIP_TEXT);
		dragonsLegendaryReset.setBackground(headerBGColor);
		dragonsLegendaryReset.setForeground(headerTitleColor);
		
		// Blank space between reset and add buttons
		blank = new JLabel();
		blank.setBackground(dragons.getBackground());
		blank.setBorder(new EmptyBorder(0, 20, 0, 20));
		
		// Add button
		dragonsLegendaryAdd = new RoundButton(ADD, headerBGColor, buttonsHoverColor);
		dragonsLegendaryAdd.setBackground(headerBGColor);
		dragonsLegendaryAdd.setForeground(headerTitleColor);
		
		// Increment field
		dragonsLegendaryIncrement = new JTextArea(1, 2);
		dragonsLegendaryIncrement.setDocument(new LimitedIncrement(2));
		dragonsLegendaryIncrement.setBackground(headerBGColor);
		dragonsLegendaryIncrement.setForeground(headerTitleColor);
		dragonsLegendaryIncrement.setCaretColor(headerTitleColor);
		dragonsLegendaryIncrement.setBorder(new EmptyBorder(0, 9, 0, 3));
		
		createModifyButtonsPanel(dragons, dragonsLegendaryModifyPanel, dragonsLegendaryReset, dragonsLegendaryAdd, dragonsLegendaryIncrement);
		
		// Packs without legendary probability panel
		dragonsLegendaryProbabilityPanel = new JTextPane();
		doc = dragonsLegendaryProbabilityPanel.getStyledDocument();
		changePanelTextStyle(dragons, dragonsLegendaryProbabilityPanel, LEGENDARY_PROBABILITY_TEXT, dragonsLegendaryProbability);
		
		dragonsLegendaryPanel.add(legendaryPanelTitleLabel);
		dragonsLegendaryPanel.add(dragonsLegendaryCounterPanel);
		dragonsLegendaryPanel.add(dragonsLegendaryModifyPanel);
		dragonsLegendaryPanel.add(dragonsLegendaryProbabilityPanel);
		
		// Total amount of packs opened panel
		JPanel dragonsTotalPanel = new JPanel();
		dragonsTotalPanel.setBackground(dragons.getBackground());
		dragonsTotalPanel.setLayout(new GridLayout(4, 1));
		
		// Total amount of packs opened panel title
		totalPanelTitleLabel = new JTextPane();
		doc = totalPanelTitleLabel.getStyledDocument();
		changePanelTitleStyle(dragons, totalPanelTitleLabel,TOTAL_PANEL_TITLE);
		
		// Total amount of packs opened counter panel
		dragonsTotalCounterPanel = new JTextPane();
		doc = dragonsTotalCounterPanel.getStyledDocument();
		changePanelTextStyle(dragons, dragonsTotalCounterPanel, TOTAL_COUNTER_TEXT, dragonsTotalCounter);
		
		// Total amount of packs opened counter modify buttons panel
		JPanel dragonsTotalModifyPanel = new JPanel();
		
		// Modify button
		dragonsTotalModify = new ModifierButton(MODIFY, headerBGColor, buttonsHoverColor);
		dragonsTotalModify.setToolTipText(MODIFY_BUTTON_TOOLTIP_TEXT);
		dragonsTotalModify.setBackground(headerBGColor);
		dragonsTotalModify.setForeground(headerTitleColor);
		
		// Blank space between modify and add buttons
		blank = new JLabel();
		blank.setBackground(dragons.getBackground());
		blank.setBorder(new EmptyBorder(0, 5, 0, 5));
		
		// Add button
		dragonsTotalAdd = new RoundButton(ADD, headerBGColor, buttonsHoverColor);
		dragonsTotalAdd.setBackground(headerBGColor);
		dragonsTotalAdd.setForeground(headerTitleColor);
		
		// Increment field
		dragonsTotalIncrement = new JTextArea(1, 3);
		dragonsTotalIncrement.setDocument(new LimitedIncrement(3));
		dragonsTotalIncrement.setBackground(headerBGColor);
		dragonsTotalIncrement.setForeground(headerTitleColor);
		dragonsTotalIncrement.setCaretColor(headerTitleColor);
		dragonsTotalIncrement.setBorder(new EmptyBorder(0, 9, 0, 0));
		
		createModifyButtonsPanel(dragons, dragonsTotalModifyPanel, dragonsTotalModify, dragonsTotalAdd, dragonsTotalIncrement);
		
		// Common button
		JPanel dragonsCommonButtonPanel = new JPanel(new GridBagLayout());
		dragonsCommonButton = new IconButton(new ImageIcon(commonButtonIcon), new ImageIcon(commonButtonHoverIcon));
		
		// Rare button
		JPanel dragonsRareButtonPanel = new JPanel(new GridBagLayout());
		dragonsRareButton = new IconButton(new ImageIcon(rareButtonIcon), new ImageIcon(rareButtonHoverIcon));
		
		// Epic button
		JPanel dragonsEpicButtonPanel = new JPanel(new GridBagLayout());
		dragonsEpicButton = new IconButton(new ImageIcon(epicButtonIcon), new ImageIcon(epicButtonHoverIcon));
		
		// Legendary button
		JPanel dragonsLegendaryButtonPanel = new JPanel(new GridBagLayout());
		dragonsLegendaryButton = new IconButton(new ImageIcon(legendaryButtonIcon), new ImageIcon(legendaryButtonHoverIcon));
		
		// Rarity buttons panel
		JPanel dragonsRarityButtonsPanel = new JPanel();
		dragonsRarityButtonsPanel.setBackground(dragons.getBackground());
		dragonsRarityButtonsPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 25, 0));
		createCommonButtonPanel(dragons, dragonsCommonButtonPanel, dragonsCommonButton);
		createRareButtonPanel(dragons, dragonsRareButtonPanel, dragonsRareButton);
		createEpicButtonPanel(dragons, dragonsEpicButtonPanel, dragonsEpicButton);
		createLegendaryButtonPanel(dragons, dragonsLegendaryButtonPanel, dragonsLegendaryButton);
		dragonsRarityButtonsPanel.add(dragonsCommonButtonPanel);
		dragonsRarityButtonsPanel.add(dragonsRareButtonPanel);
		dragonsRarityButtonsPanel.add(dragonsEpicButtonPanel);
		dragonsRarityButtonsPanel.add(dragonsLegendaryButtonPanel);
		
		dragonsTotalPanel.add(totalPanelTitleLabel);
		dragonsTotalPanel.add(dragonsTotalCounterPanel);
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
		JPanel uldumImagePanel = new JPanel(new GridBagLayout());
		uldumImagePanel.setBackground(uldum.getBackground());
		
		uldumImageButton = new JButton(new ImageIcon(uldumImage));
		uldumImageButton.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 0));
		uldumImageButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		uldumImageButton.setToolTipText(IMAGE_BUTTON_TOOLTIP_TEXT);
		uldumImageButton.setContentAreaFilled(false);
		uldumImageButton.setFocusPainted(false);
		
		uldumImagePanel.add(uldumImageButton);
				
		// Packs without epic panel
		JPanel uldumEpicPanel = new JPanel();
		uldumEpicPanel.setBackground(uldum.getBackground());
		uldumEpicPanel.setLayout(new GridLayout(4, 1));
		
		// Packs without epic panel title
		epicPanelTitleLabel = new JTextPane();
		doc = epicPanelTitleLabel.getStyledDocument();
		changePanelTitleStyle(uldum, epicPanelTitleLabel, EPIC_PANEL_TITLE);
				
		// Packs without epic counter panel
		uldumEpicCounterPanel = new JTextPane();
		doc = uldumEpicCounterPanel.getStyledDocument();
		changePanelTextStyle(uldum, uldumEpicCounterPanel, EPIC_COUNTER_TEXT, uldumEpicCounter);
		
		// Packs without epic counter modify buttons panel
		JPanel uldumEpicModifyPanel = new JPanel();
		
		// Reset button
		uldumEpicReset = new ModifierButton(RESET, headerBGColor, buttonsHoverColor);
		uldumEpicReset.setToolTipText(RESET_BUTTON_TOOLTIP_TEXT);
		uldumEpicReset.setBackground(headerBGColor);
		uldumEpicReset.setForeground(headerTitleColor);
		
		// Blank space between reset and add buttons
		blank = new JLabel();
		blank.setBackground(uldum.getBackground());
		blank.setBorder(new EmptyBorder(0, 20, 0, 20));
		
		// Add button
		uldumEpicAdd = new RoundButton(ADD, headerBGColor, buttonsHoverColor);
		uldumEpicAdd.setBackground(headerBGColor);
		uldumEpicAdd.setForeground(headerTitleColor);
		
		// Increment field
		uldumEpicIncrement = new JTextArea(1, 1);
		uldumEpicIncrement.setDocument(new LimitedIncrement(1));
		uldumEpicIncrement.setBackground(headerBGColor);
		uldumEpicIncrement.setForeground(headerTitleColor);
		uldumEpicIncrement.setCaretColor(headerTitleColor);
		uldumEpicIncrement.setBorder(new EmptyBorder(0, 9, 0, 6));
		
		createModifyButtonsPanel(uldum, uldumEpicModifyPanel, uldumEpicReset, uldumEpicAdd, uldumEpicIncrement);
		
		// Packs without epic probability panel
		uldumEpicProbabilityPanel = new JTextPane();
		doc = uldumEpicProbabilityPanel.getStyledDocument();
		changePanelTextStyle(uldum, uldumEpicProbabilityPanel, EPIC_PROBABILITY_TEXT, uldumEpicProbability);
		
		uldumEpicPanel.add(epicPanelTitleLabel);
		uldumEpicPanel.add(uldumEpicCounterPanel);
		uldumEpicPanel.add(uldumEpicModifyPanel);
		uldumEpicPanel.add(uldumEpicProbabilityPanel);
		
		// Packs without legendary panel
		JPanel uldumLegendaryPanel = new JPanel();
		uldumLegendaryPanel.setBackground(uldum.getBackground());
		uldumLegendaryPanel.setLayout(new GridLayout(4, 1));
		
		// Packs without legendary panel title
		legendaryPanelTitleLabel = new JTextPane();
		doc = legendaryPanelTitleLabel.getStyledDocument();
		changePanelTitleStyle(uldum, legendaryPanelTitleLabel, LEGENDARY_PANEL_TITLE);
		
		// Packs without legendary counter panel
		uldumLegendaryCounterPanel = new JTextPane();
		doc = uldumLegendaryCounterPanel.getStyledDocument();
		changePanelTextStyle(uldum, uldumLegendaryCounterPanel, LEGENDARY_COUNTER_TEXT, uldumLegendaryCounter);
		
		// Packs without legendary counter modify buttons panel
		JPanel uldumLegendaryModifyPanel = new JPanel();
		
		// Reset button
		uldumLegendaryReset = new ModifierButton(RESET, headerBGColor, buttonsHoverColor);
		uldumLegendaryReset.setToolTipText(RESET_BUTTON_TOOLTIP_TEXT);
		uldumLegendaryReset.setBackground(headerBGColor);
		uldumLegendaryReset.setForeground(headerTitleColor);
		
		// Blank space between reset and add buttons
		blank = new JLabel();
		blank.setBackground(uldum.getBackground());
		blank.setBorder(new EmptyBorder(0, 20, 0, 20));
		
		// Add button
		uldumLegendaryAdd = new RoundButton(ADD, headerBGColor, buttonsHoverColor);
		uldumLegendaryAdd.setBackground(headerBGColor);
		uldumLegendaryAdd.setForeground(headerTitleColor);
		
		// Increment field
		uldumLegendaryIncrement = new JTextArea(1, 2);
		uldumLegendaryIncrement.setDocument(new LimitedIncrement(2));
		uldumLegendaryIncrement.setBackground(headerBGColor);
		uldumLegendaryIncrement.setForeground(headerTitleColor);
		uldumLegendaryIncrement.setCaretColor(headerTitleColor);
		uldumLegendaryIncrement.setBorder(new EmptyBorder(0, 9, 0, 3));
		
		createModifyButtonsPanel(uldum, uldumLegendaryModifyPanel, uldumLegendaryReset, uldumLegendaryAdd, uldumLegendaryIncrement);
		
		// Packs without legendary probability panel
		uldumLegendaryProbabilityPanel = new JTextPane();
		doc = uldumLegendaryProbabilityPanel.getStyledDocument();
		changePanelTextStyle(uldum, uldumLegendaryProbabilityPanel, LEGENDARY_PROBABILITY_TEXT, uldumLegendaryProbability);
		
		uldumLegendaryPanel.add(legendaryPanelTitleLabel);
		uldumLegendaryPanel.add(uldumLegendaryCounterPanel);
		uldumLegendaryPanel.add(uldumLegendaryModifyPanel);
		uldumLegendaryPanel.add(uldumLegendaryProbabilityPanel);
		
		// Total amount of packs opened panel
		JPanel uldumTotalPanel = new JPanel();
		uldumTotalPanel.setBackground(uldum.getBackground());
		uldumTotalPanel.setLayout(new GridLayout(4, 1));
		
		// Total amount of packs opened panel title
		totalPanelTitleLabel = new JTextPane();
		doc = totalPanelTitleLabel.getStyledDocument();
		changePanelTitleStyle(uldum, totalPanelTitleLabel,TOTAL_PANEL_TITLE);
		
		// Total amount of packs opened counter panel
		uldumTotalCounterPanel = new JTextPane();
		doc = uldumTotalCounterPanel.getStyledDocument();
		changePanelTextStyle(uldum, uldumTotalCounterPanel, TOTAL_COUNTER_TEXT, uldumTotalCounter);
		
		// Total amount of packs opened counter modify buttons panel
		JPanel uldumTotalModifyPanel = new JPanel();
		
		// Modify button
		uldumTotalModify = new ModifierButton(MODIFY, headerBGColor, buttonsHoverColor);
		uldumTotalModify.setToolTipText(MODIFY_BUTTON_TOOLTIP_TEXT);
		uldumTotalModify.setBackground(headerBGColor);
		uldumTotalModify.setForeground(headerTitleColor);
		
		// Blank space between modify and add buttons
		blank = new JLabel();
		blank.setBackground(uldum.getBackground());
		blank.setBorder(new EmptyBorder(0, 5, 0, 5));
		
		// Add button
		uldumTotalAdd = new RoundButton(ADD, headerBGColor, buttonsHoverColor);
		uldumTotalAdd.setBackground(headerBGColor);
		uldumTotalAdd.setForeground(headerTitleColor);
		
		// Increment field
		uldumTotalIncrement = new JTextArea(1, 3);
		uldumTotalIncrement.setDocument(new LimitedIncrement(3));
		uldumTotalIncrement.setBackground(headerBGColor);
		uldumTotalIncrement.setForeground(headerTitleColor);
		uldumTotalIncrement.setCaretColor(headerTitleColor);
		uldumTotalIncrement.setBorder(new EmptyBorder(0, 9, 0, 0));
		
		createModifyButtonsPanel(uldum, uldumTotalModifyPanel, uldumTotalModify, uldumTotalAdd, uldumTotalIncrement);
		
		// Common button
		JPanel uldumCommonButtonPanel = new JPanel(new GridBagLayout());
		uldumCommonButton = new IconButton(new ImageIcon(commonButtonIcon), new ImageIcon(commonButtonHoverIcon));
		
		// Rare button
		JPanel uldumRareButtonPanel = new JPanel(new GridBagLayout());
		uldumRareButton = new IconButton(new ImageIcon(rareButtonIcon), new ImageIcon(rareButtonHoverIcon));
		
		// Epic button
		JPanel uldumEpicButtonPanel = new JPanel(new GridBagLayout());
		uldumEpicButton = new IconButton(new ImageIcon(epicButtonIcon), new ImageIcon(epicButtonHoverIcon));
		
		// Legendary button
		JPanel uldumLegendaryButtonPanel = new JPanel(new GridBagLayout());
		uldumLegendaryButton = new IconButton(new ImageIcon(legendaryButtonIcon), new ImageIcon(legendaryButtonHoverIcon));
		
		// Rarity buttons panel
		JPanel uldumRarityButtonsPanel = new JPanel();
		uldumRarityButtonsPanel.setBackground(uldum.getBackground());
		uldumRarityButtonsPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 25, 0));
		createCommonButtonPanel(uldum, uldumCommonButtonPanel, uldumCommonButton);
		createRareButtonPanel(uldum, uldumRareButtonPanel, uldumRareButton);
		createEpicButtonPanel(uldum, uldumEpicButtonPanel, uldumEpicButton);
		createLegendaryButtonPanel(uldum, uldumLegendaryButtonPanel, uldumLegendaryButton);
		uldumRarityButtonsPanel.add(uldumCommonButtonPanel);
		uldumRarityButtonsPanel.add(uldumRareButtonPanel);
		uldumRarityButtonsPanel.add(uldumEpicButtonPanel);
		uldumRarityButtonsPanel.add(uldumLegendaryButtonPanel);
		
		uldumTotalPanel.add(totalPanelTitleLabel);
		uldumTotalPanel.add(uldumTotalCounterPanel);
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
		JPanel shadowsImagePanel = new JPanel(new GridBagLayout());
		shadowsImagePanel.setBackground(shadows.getBackground());
		
		shadowsImageButton = new JButton(new ImageIcon(shadowsImage));
		shadowsImageButton.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 0));
		shadowsImageButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		shadowsImageButton.setToolTipText(IMAGE_BUTTON_TOOLTIP_TEXT);
		shadowsImageButton.setContentAreaFilled(false);
		shadowsImageButton.setFocusPainted(false);
		
		shadowsImagePanel.add(shadowsImageButton);
		
		// Packs without epic panel
		JPanel shadowsEpicPanel = new JPanel();
		shadowsEpicPanel.setBackground(shadows.getBackground());
		shadowsEpicPanel.setLayout(new GridLayout(4, 1));
		
		// Packs without epic panel title
		epicPanelTitleLabel = new JTextPane();
		doc = epicPanelTitleLabel.getStyledDocument();
		changePanelTitleStyle(shadows, epicPanelTitleLabel, EPIC_PANEL_TITLE);
		epicPanelTitleLabel.setForeground(headerTitleColor);
		
		// Packs without epic counter panel
		shadowsEpicCounterPanel = new JTextPane();
		doc = shadowsEpicCounterPanel.getStyledDocument();
		changePanelTextStyle(shadows, shadowsEpicCounterPanel, EPIC_COUNTER_TEXT, shadowsEpicCounter);
		shadowsEpicCounterPanel.setForeground(headerTitleColor);
		
		// Packs without epic counter modify buttons panel
		JPanel shadowsEpicModifyPanel = new JPanel();
		
		// Reset button
		shadowsEpicReset = new ModifierButton(RESET, headerTitleColor, buttonsDarkHoverColor);
		shadowsEpicReset.setToolTipText(RESET_BUTTON_TOOLTIP_TEXT);
		shadowsEpicReset.setBackground(headerTitleColor);
		
		// Blank space between reset and add buttons
		blank = new JLabel();
		blank.setBackground(shadows.getBackground());
		blank.setBorder(new EmptyBorder(0, 20, 0, 20));
		
		// Add button
		shadowsEpicAdd = new RoundButton(ADD, headerTitleColor, buttonsDarkHoverColor);
		shadowsEpicAdd.setBackground(headerTitleColor);
		
		// Increment field
		shadowsEpicIncrement = new JTextArea(1, 1);
		shadowsEpicIncrement.setDocument(new LimitedIncrement(1));
		shadowsEpicIncrement.setBackground(headerTitleColor);
		shadowsEpicIncrement.setBorder(new EmptyBorder(0, 9, 0, 6));
		
		createModifyButtonsPanel(shadows, shadowsEpicModifyPanel, shadowsEpicReset, shadowsEpicAdd, shadowsEpicIncrement);
		
		// Packs without epic probability panel
		shadowsEpicProbabilityPanel = new JTextPane();
		doc = shadowsEpicProbabilityPanel.getStyledDocument();
		changePanelTextStyle(shadows, shadowsEpicProbabilityPanel, EPIC_PROBABILITY_TEXT, shadowsEpicProbability);
		shadowsEpicProbabilityPanel.setForeground(headerTitleColor);
		
		shadowsEpicPanel.add(epicPanelTitleLabel);
		shadowsEpicPanel.add(shadowsEpicCounterPanel);
		shadowsEpicPanel.add(shadowsEpicModifyPanel);
		shadowsEpicPanel.add(shadowsEpicProbabilityPanel);
		
		// Packs without legendary panel
		JPanel shadowsLegendaryPanel = new JPanel();
		shadowsLegendaryPanel.setBackground(shadows.getBackground());
		shadowsLegendaryPanel.setLayout(new GridLayout(4, 1));
		
		// Packs without legendary panel title
		legendaryPanelTitleLabel = new JTextPane();
		doc = legendaryPanelTitleLabel.getStyledDocument();
		changePanelTitleStyle(shadows, legendaryPanelTitleLabel, LEGENDARY_PANEL_TITLE);
		legendaryPanelTitleLabel.setForeground(headerTitleColor);
		
		// Packs without legendary counter panel
		shadowsLegendaryCounterPanel = new JTextPane();
		doc = shadowsLegendaryCounterPanel.getStyledDocument();
		changePanelTextStyle(shadows, shadowsLegendaryCounterPanel, LEGENDARY_COUNTER_TEXT, shadowsLegendaryCounter);
		shadowsLegendaryCounterPanel.setForeground(headerTitleColor);
		
		// Packs without legendary counter modify buttons panel
		JPanel shadowsLegendaryModifyPanel = new JPanel();
		
		// Reset button
		shadowsLegendaryReset = new ModifierButton(RESET, headerTitleColor, buttonsDarkHoverColor);
		shadowsLegendaryReset.setToolTipText(RESET_BUTTON_TOOLTIP_TEXT);
		shadowsLegendaryReset.setBackground(headerTitleColor);
		
		// Blank space between reset and add buttons
		blank = new JLabel();
		blank.setBackground(shadows.getBackground());
		blank.setBorder(new EmptyBorder(0, 20, 0, 20));
		
		// Add button
		shadowsLegendaryAdd = new RoundButton(ADD, headerTitleColor, buttonsDarkHoverColor);
		shadowsLegendaryAdd.setBackground(headerTitleColor);
		
		// Increment field
		shadowsLegendaryIncrement = new JTextArea(1, 2);
		shadowsLegendaryIncrement.setDocument(new LimitedIncrement(2));
		shadowsLegendaryIncrement.setBackground(headerTitleColor);
		shadowsLegendaryIncrement.setBorder(new EmptyBorder(0, 9, 0, 3));
		
		createModifyButtonsPanel(shadows, shadowsLegendaryModifyPanel, shadowsLegendaryReset, shadowsLegendaryAdd, shadowsLegendaryIncrement);
		
		// Packs without legendary probability panel
		shadowsLegendaryProbabilityPanel = new JTextPane();
		doc = shadowsLegendaryProbabilityPanel.getStyledDocument();
		changePanelTextStyle(shadows, shadowsLegendaryProbabilityPanel, LEGENDARY_PROBABILITY_TEXT, shadowsLegendaryProbability);
		shadowsLegendaryProbabilityPanel.setForeground(headerTitleColor);
		
		shadowsLegendaryPanel.add(legendaryPanelTitleLabel);
		shadowsLegendaryPanel.add(shadowsLegendaryCounterPanel);
		shadowsLegendaryPanel.add(shadowsLegendaryModifyPanel);
		shadowsLegendaryPanel.add(shadowsLegendaryProbabilityPanel);
		
		// Total amount of packs opened panel
		JPanel shadowsTotalPanel = new JPanel();
		shadowsTotalPanel.setBackground(shadows.getBackground());
		shadowsTotalPanel.setLayout(new GridLayout(4, 1));
		
		// Total amount of packs opened panel title
		totalPanelTitleLabel = new JTextPane();
		doc = totalPanelTitleLabel.getStyledDocument();
		changePanelTitleStyle(shadows, totalPanelTitleLabel,TOTAL_PANEL_TITLE);
		totalPanelTitleLabel.setForeground(headerTitleColor);
		
		// Total amount of packs opened counter panel
		shadowsTotalCounterPanel = new JTextPane();
		doc = shadowsTotalCounterPanel.getStyledDocument();
		changePanelTextStyle(shadows, shadowsTotalCounterPanel, TOTAL_COUNTER_TEXT, shadowsTotalCounter);
		shadowsTotalCounterPanel.setForeground(headerTitleColor);
		
		// Total amount of packs opened counter modify buttons panel
		JPanel shadowsTotalModifyPanel = new JPanel();
		
		// Modify button
		shadowsTotalModify = new ModifierButton(MODIFY, headerTitleColor, buttonsDarkHoverColor);
		shadowsTotalModify.setToolTipText(MODIFY_BUTTON_TOOLTIP_TEXT);
		shadowsTotalModify.setBackground(headerTitleColor);
		
		// Blank space between modify and add buttons
		blank = new JLabel();
		blank.setBackground(shadows.getBackground());
		blank.setBorder(new EmptyBorder(0, 5, 0, 5));
		
		// Add button
		shadowsTotalAdd = new RoundButton(ADD, headerTitleColor, buttonsDarkHoverColor);
		shadowsTotalAdd.setBackground(headerTitleColor);
		
		// Increment field
		shadowsTotalIncrement = new JTextArea(1, 3);
		shadowsTotalIncrement.setDocument(new LimitedIncrement(3));
		shadowsTotalIncrement.setBackground(headerTitleColor);
		shadowsTotalIncrement.setBorder(new EmptyBorder(0, 9, 0, 0));
		
		createModifyButtonsPanel(shadows, shadowsTotalModifyPanel, shadowsTotalModify, shadowsTotalAdd, shadowsTotalIncrement);
		
		// Common button
		JPanel shadowsCommonButtonPanel = new JPanel(new GridBagLayout());
		shadowsCommonButton = new IconButton(new ImageIcon(commonButtonDarkIcon), new ImageIcon(commonButtonDarkHoverIcon));
		
		// Rare button
		JPanel shadowsRareButtonPanel = new JPanel(new GridBagLayout());
		shadowsRareButton = new IconButton(new ImageIcon(rareButtonDarkIcon), new ImageIcon(rareButtonDarkHoverIcon));
		
		// Epic button
		JPanel shadowsEpicButtonPanel = new JPanel(new GridBagLayout());
		shadowsEpicButton = new IconButton(new ImageIcon(epicButtonDarkIcon), new ImageIcon(epicButtonDarkHoverIcon));
		
		// Legendary button
		JPanel shadowsLegendaryButtonPanel = new JPanel(new GridBagLayout());
		shadowsLegendaryButton = new IconButton(new ImageIcon(legendaryButtonDarkIcon), new ImageIcon(legendaryButtonDarkHoverIcon));
		
		// Rarity buttons panel
		JPanel shadowsRarityButtonsPanel = new JPanel();
		shadowsRarityButtonsPanel.setBackground(shadows.getBackground());
		shadowsRarityButtonsPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 25, 0));
		createCommonButtonPanel(shadows, shadowsCommonButtonPanel, shadowsCommonButton);
		createRareButtonPanel(shadows, shadowsRareButtonPanel, shadowsRareButton);
		createEpicButtonPanel(shadows, shadowsEpicButtonPanel, shadowsEpicButton);
		createLegendaryButtonPanel(shadows, shadowsLegendaryButtonPanel, shadowsLegendaryButton);
		shadowsRarityButtonsPanel.add(shadowsCommonButtonPanel);
		shadowsRarityButtonsPanel.add(shadowsRareButtonPanel);
		shadowsRarityButtonsPanel.add(shadowsEpicButtonPanel);
		shadowsRarityButtonsPanel.add(shadowsLegendaryButtonPanel);
		
		shadowsTotalPanel.add(totalPanelTitleLabel);
		shadowsTotalPanel.add(shadowsTotalCounterPanel);
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
		ravenHeader = new JPanel(new FlowLayout(FlowLayout.CENTER));
		ravenHeader.setBackground(yearsColor);

		JLabel ravenImageLabel = new JLabel(new ImageIcon(ravenImage));
		ravenImageLabel.setBorder(new EmptyBorder(0, 5, 0, 5));

		JLabel ravenLabel = new JLabel(RAVEN_TITLE);
		ravenLabel.setFont(yearsFont);
		ravenLabel.setBorder(new EmptyBorder(5, 10, 5, 5));
		
		ravenHeader.add(ravenImageLabel);
		ravenHeader.add(ravenLabel);
				
		// "Year of the Raven" expansions
		createRastakhansRumblePanel();
		createTheBoomsdayProjectPanel();
		createTheWitchwoodPanel();
		
		SwingUtilities.invokeLater(() -> {
			raven.add(ravenHeader);
			raven.add(rumble);
			raven.add(boomsday);
			raven.add(witchwood);
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
		JPanel rumbleImagePanel = new JPanel(new GridBagLayout());
		rumbleImagePanel.setBackground(rumble.getBackground());
		
		rumbleImageButton = new JButton(new ImageIcon(rumbleImage));
		rumbleImageButton.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 0));
		rumbleImageButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		rumbleImageButton.setToolTipText(IMAGE_BUTTON_TOOLTIP_TEXT);
		rumbleImageButton.setContentAreaFilled(false);
		rumbleImageButton.setFocusPainted(false);
		
		rumbleImagePanel.add(rumbleImageButton);
		
		// Packs without epic panel
		JPanel rumbleEpicPanel = new JPanel();
		rumbleEpicPanel.setBackground(rumble.getBackground());
		rumbleEpicPanel.setLayout(new GridLayout(4, 1));
		
		// Packs without epic panel title
		epicPanelTitleLabel = new JTextPane();
		doc = epicPanelTitleLabel.getStyledDocument();
		changePanelTitleStyle(rumble, epicPanelTitleLabel, EPIC_PANEL_TITLE);
		
		// Packs without epic counter panel
		rumbleEpicCounterPanel = new JTextPane();
		doc = rumbleEpicCounterPanel.getStyledDocument();
		changePanelTextStyle(rumble, rumbleEpicCounterPanel, EPIC_COUNTER_TEXT, rumbleEpicCounter);
		
		// Packs without epic counter modify buttons panel
		JPanel rumbleEpicModifyPanel = new JPanel();
		
		// Reset button
		rumbleEpicReset = new ModifierButton(RESET, headerBGColor, buttonsHoverColor);
		rumbleEpicReset.setToolTipText(RESET_BUTTON_TOOLTIP_TEXT);
		rumbleEpicReset.setBackground(headerBGColor);
		rumbleEpicReset.setForeground(headerTitleColor);
		
		// Blank space between reset and add buttons
		blank = new JLabel();
		blank.setBackground(rumble.getBackground());
		blank.setBorder(new EmptyBorder(0, 20, 0, 20));
		
		// Add button
		rumbleEpicAdd = new RoundButton(ADD, headerBGColor, buttonsHoverColor);
		rumbleEpicAdd.setBackground(headerBGColor);
		rumbleEpicAdd.setForeground(headerTitleColor);
		
		// Increment field
		rumbleEpicIncrement = new JTextArea(1, 1);
		rumbleEpicIncrement.setDocument(new LimitedIncrement(1));
		rumbleEpicIncrement.setBackground(headerBGColor);
		rumbleEpicIncrement.setForeground(headerTitleColor);
		rumbleEpicIncrement.setCaretColor(headerTitleColor);
		rumbleEpicIncrement.setBorder(new EmptyBorder(0, 9, 0, 6));
		
		createModifyButtonsPanel(rumble, rumbleEpicModifyPanel, rumbleEpicReset, rumbleEpicAdd, rumbleEpicIncrement);
		
		// Packs without epic probability panel
		rumbleEpicProbabilityPanel = new JTextPane();
		doc = rumbleEpicProbabilityPanel.getStyledDocument();
		changePanelTextStyle(rumble, rumbleEpicProbabilityPanel, EPIC_PROBABILITY_TEXT, rumbleEpicProbability);
		
		rumbleEpicPanel.add(epicPanelTitleLabel);
		rumbleEpicPanel.add(rumbleEpicCounterPanel);
		rumbleEpicPanel.add(rumbleEpicModifyPanel);
		rumbleEpicPanel.add(rumbleEpicProbabilityPanel);
		
		// Packs without legendary panel
		JPanel rumbleLegendaryPanel = new JPanel();
		rumbleLegendaryPanel.setBackground(rumble.getBackground());
		rumbleLegendaryPanel.setLayout(new GridLayout(4, 1));
		
		// Packs without legendary panel title
		legendaryPanelTitleLabel = new JTextPane();
		doc = legendaryPanelTitleLabel.getStyledDocument();
		changePanelTitleStyle(rumble, legendaryPanelTitleLabel, LEGENDARY_PANEL_TITLE);
		
		// Packs without legendary counter panel
		rumbleLegendaryCounterPanel = new JTextPane();
		doc = rumbleLegendaryCounterPanel.getStyledDocument();
		changePanelTextStyle(rumble, rumbleLegendaryCounterPanel, LEGENDARY_COUNTER_TEXT, rumbleLegendaryCounter);
		
		// Packs without legendary counter modify buttons panel
		JPanel rumbleLegendaryModifyPanel = new JPanel();
		
		// Reset button
		rumbleLegendaryReset = new ModifierButton(RESET, headerBGColor, buttonsHoverColor);
		rumbleLegendaryReset.setToolTipText(RESET_BUTTON_TOOLTIP_TEXT);
		rumbleLegendaryReset.setBackground(headerBGColor);
		rumbleLegendaryReset.setForeground(headerTitleColor);
		
		// Blank space between reset and add buttons
		blank = new JLabel();
		blank.setBackground(rumble.getBackground());
		blank.setBorder(new EmptyBorder(0, 20, 0, 20));
		
		// Add button
		rumbleLegendaryAdd = new RoundButton(ADD, headerBGColor, buttonsHoverColor);
		rumbleLegendaryAdd.setBackground(headerBGColor);
		rumbleLegendaryAdd.setForeground(headerTitleColor);
		
		// Increment field
		rumbleLegendaryIncrement = new JTextArea(1, 2);
		rumbleLegendaryIncrement.setDocument(new LimitedIncrement(2));
		rumbleLegendaryIncrement.setBackground(headerBGColor);
		rumbleLegendaryIncrement.setForeground(headerTitleColor);
		rumbleLegendaryIncrement.setCaretColor(headerTitleColor);
		rumbleLegendaryIncrement.setBorder(new EmptyBorder(0, 9, 0, 3));
		
		createModifyButtonsPanel(rumble, rumbleLegendaryModifyPanel, rumbleLegendaryReset, rumbleLegendaryAdd, rumbleLegendaryIncrement);
		
		// Packs without legendary probability panel
		rumbleLegendaryProbabilityPanel = new JTextPane();
		doc = rumbleLegendaryProbabilityPanel.getStyledDocument();
		changePanelTextStyle(rumble, rumbleLegendaryProbabilityPanel, LEGENDARY_PROBABILITY_TEXT, rumbleLegendaryProbability);
		
		rumbleLegendaryPanel.add(legendaryPanelTitleLabel);
		rumbleLegendaryPanel.add(rumbleLegendaryCounterPanel);
		rumbleLegendaryPanel.add(rumbleLegendaryModifyPanel);
		rumbleLegendaryPanel.add(rumbleLegendaryProbabilityPanel);
		
		// Total amount of packs opened panel
		JPanel rumbleTotalPanel = new JPanel();
		rumbleTotalPanel.setBackground(rumble.getBackground());
		rumbleTotalPanel.setLayout(new GridLayout(4, 1));
		
		// Total amount of packs opened panel title
		totalPanelTitleLabel = new JTextPane();
		doc = totalPanelTitleLabel.getStyledDocument();
		changePanelTitleStyle(rumble, totalPanelTitleLabel,TOTAL_PANEL_TITLE);
		
		// Total amount of packs opened counter panel
		rumbleTotalCounterPanel = new JTextPane();
		doc = rumbleTotalCounterPanel.getStyledDocument();
		changePanelTextStyle(rumble, rumbleTotalCounterPanel, TOTAL_COUNTER_TEXT, rumbleTotalCounter);
		
		// Total amount of packs opened counter modify buttons panel
		JPanel rumbleTotalModifyPanel = new JPanel();
		
		// Modify button
		rumbleTotalModify = new ModifierButton(MODIFY, headerBGColor, buttonsHoverColor);
		rumbleTotalModify.setToolTipText(MODIFY_BUTTON_TOOLTIP_TEXT);
		rumbleTotalModify.setBackground(headerBGColor);
		rumbleTotalModify.setForeground(headerTitleColor);
		
		// Blank space between modify and add buttons
		blank = new JLabel();
		blank.setBackground(rumble.getBackground());
		blank.setBorder(new EmptyBorder(0, 5, 0, 5));
		
		// Add button
		rumbleTotalAdd = new RoundButton(ADD, headerBGColor, buttonsHoverColor);
		rumbleTotalAdd.setBackground(headerBGColor);
		rumbleTotalAdd.setForeground(headerTitleColor);
		
		// Increment field
		rumbleTotalIncrement = new JTextArea(1, 3);
		rumbleTotalIncrement.setDocument(new LimitedIncrement(3));
		rumbleTotalIncrement.setBackground(headerBGColor);
		rumbleTotalIncrement.setForeground(headerTitleColor);
		rumbleTotalIncrement.setCaretColor(headerTitleColor);
		rumbleTotalIncrement.setBorder(new EmptyBorder(0, 9, 0, 0));
		
		createModifyButtonsPanel(rumble, rumbleTotalModifyPanel, rumbleTotalModify, rumbleTotalAdd, rumbleTotalIncrement);
		
		// Common button
		JPanel rumbleCommonButtonPanel = new JPanel(new GridBagLayout());
		rumbleCommonButton = new IconButton(new ImageIcon(commonButtonIcon), new ImageIcon(commonButtonHoverIcon));
		
		// Rare button
		JPanel rumbleRareButtonPanel = new JPanel(new GridBagLayout());
		rumbleRareButton = new IconButton(new ImageIcon(rareButtonIcon), new ImageIcon(rareButtonHoverIcon));
		
		// Epic button
		JPanel rumbleEpicButtonPanel = new JPanel(new GridBagLayout());
		rumbleEpicButton = new IconButton(new ImageIcon(epicButtonIcon), new ImageIcon(epicButtonHoverIcon));
		
		// Legendary button
		JPanel rumbleLegendaryButtonPanel = new JPanel(new GridBagLayout());
		rumbleLegendaryButton = new IconButton(new ImageIcon(legendaryButtonIcon), new ImageIcon(legendaryButtonHoverIcon));
		
		// Rarity buttons panel
		JPanel rumbleRarityButtonsPanel = new JPanel();
		rumbleRarityButtonsPanel.setBackground(rumble.getBackground());
		rumbleRarityButtonsPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 25, 0));
		createCommonButtonPanel(rumble, rumbleCommonButtonPanel, rumbleCommonButton);
		createRareButtonPanel(rumble, rumbleRareButtonPanel, rumbleRareButton);
		createEpicButtonPanel(rumble, rumbleEpicButtonPanel, rumbleEpicButton);
		createLegendaryButtonPanel(rumble, rumbleLegendaryButtonPanel, rumbleLegendaryButton);
		rumbleRarityButtonsPanel.add(rumbleCommonButtonPanel);
		rumbleRarityButtonsPanel.add(rumbleRareButtonPanel);
		rumbleRarityButtonsPanel.add(rumbleEpicButtonPanel);
		rumbleRarityButtonsPanel.add(rumbleLegendaryButtonPanel);
		
		rumbleTotalPanel.add(totalPanelTitleLabel);
		rumbleTotalPanel.add(rumbleTotalCounterPanel);
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
		JPanel boomsdayImagePanel = new JPanel(new GridBagLayout());
		boomsdayImagePanel.setBackground(boomsday.getBackground());
		
		boomsdayImageButton = new JButton(new ImageIcon(boomsdayImage));
		boomsdayImageButton.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 0));
		boomsdayImageButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		boomsdayImageButton.setToolTipText(IMAGE_BUTTON_TOOLTIP_TEXT);
		boomsdayImageButton.setContentAreaFilled(false);
		boomsdayImageButton.setFocusPainted(false);
		
		boomsdayImagePanel.add(boomsdayImageButton);
		
		// Packs without epic panel
		JPanel boomsdayEpicPanel = new JPanel();
		boomsdayEpicPanel.setBackground(boomsday.getBackground());
		boomsdayEpicPanel.setLayout(new GridLayout(4, 1));
		
		// Packs without epic panel title
		epicPanelTitleLabel = new JTextPane();
		doc = epicPanelTitleLabel.getStyledDocument();
		changePanelTitleStyle(boomsday, epicPanelTitleLabel, EPIC_PANEL_TITLE);
		epicPanelTitleLabel.setForeground(headerTitleColor);
		
		// Packs without epic counter panel
		boomsdayEpicCounterPanel = new JTextPane();
		doc = boomsdayEpicCounterPanel.getStyledDocument();
		changePanelTextStyle(boomsday, boomsdayEpicCounterPanel, EPIC_COUNTER_TEXT, boomsdayEpicCounter);
		boomsdayEpicCounterPanel.setForeground(headerTitleColor);
		
		// Packs without epic counter modify buttons panel
		JPanel boomsdayEpicModifyPanel = new JPanel();
		
		// Reset button
		boomsdayEpicReset = new ModifierButton(RESET, headerTitleColor, buttonsDarkHoverColor);
		boomsdayEpicReset.setToolTipText(RESET_BUTTON_TOOLTIP_TEXT);
		boomsdayEpicReset.setBackground(headerTitleColor);
		
		// Blank space between reset and add buttons
		blank = new JLabel();
		blank.setBackground(boomsday.getBackground());
		blank.setBorder(new EmptyBorder(0, 20, 0, 20));
		
		// Add button
		boomsdayEpicAdd = new RoundButton(ADD, headerTitleColor, buttonsDarkHoverColor);
		boomsdayEpicAdd.setBackground(headerTitleColor);
		
		// Increment field
		boomsdayEpicIncrement = new JTextArea(1, 1);
		boomsdayEpicIncrement.setDocument(new LimitedIncrement(1));
		boomsdayEpicIncrement.setBackground(headerTitleColor);
		boomsdayEpicIncrement.setBorder(new EmptyBorder(0, 9, 0, 6));
		
		createModifyButtonsPanel(boomsday, boomsdayEpicModifyPanel, boomsdayEpicReset, boomsdayEpicAdd, boomsdayEpicIncrement);
		
		// Packs without epic probability panel
		boomsdayEpicProbabilityPanel = new JTextPane();
		doc = boomsdayEpicProbabilityPanel.getStyledDocument();
		changePanelTextStyle(boomsday, boomsdayEpicProbabilityPanel, EPIC_PROBABILITY_TEXT, boomsdayEpicProbability);
		boomsdayEpicProbabilityPanel.setForeground(headerTitleColor);
		
		boomsdayEpicPanel.add(epicPanelTitleLabel);
		boomsdayEpicPanel.add(boomsdayEpicCounterPanel);
		boomsdayEpicPanel.add(boomsdayEpicModifyPanel);
		boomsdayEpicPanel.add(boomsdayEpicProbabilityPanel);
		
		// Packs without legendary panel
		JPanel boomsdayLegendaryPanel = new JPanel();
		boomsdayLegendaryPanel.setBackground(boomsday.getBackground());
		boomsdayLegendaryPanel.setLayout(new GridLayout(4, 1));
		
		// Packs without legendary panel title
		legendaryPanelTitleLabel = new JTextPane();
		doc = legendaryPanelTitleLabel.getStyledDocument();
		changePanelTitleStyle(boomsday, legendaryPanelTitleLabel, LEGENDARY_PANEL_TITLE);
		legendaryPanelTitleLabel.setForeground(headerTitleColor);
		
		// Packs without legendary counter panel
		boomsdayLegendaryCounterPanel = new JTextPane();
		doc = boomsdayLegendaryCounterPanel.getStyledDocument();
		changePanelTextStyle(boomsday, boomsdayLegendaryCounterPanel, LEGENDARY_COUNTER_TEXT, boomsdayLegendaryCounter);
		boomsdayLegendaryCounterPanel.setForeground(headerTitleColor);
		
		// Packs without legendary counter modify buttons panel
		JPanel boomsdayLegendaryModifyPanel = new JPanel();
		
		// Reset button
		boomsdayLegendaryReset = new ModifierButton(RESET, headerTitleColor, buttonsDarkHoverColor);
		boomsdayLegendaryReset.setToolTipText(RESET_BUTTON_TOOLTIP_TEXT);
		boomsdayLegendaryReset.setBackground(headerTitleColor);
		
		// Blank space between reset and add buttons
		blank = new JLabel();
		blank.setBackground(boomsday.getBackground());
		blank.setBorder(new EmptyBorder(0, 20, 0, 20));
		
		// Add button
		boomsdayLegendaryAdd = new RoundButton(ADD, headerTitleColor, buttonsDarkHoverColor);
		boomsdayLegendaryAdd.setBackground(headerTitleColor);
		
		// Increment field
		boomsdayLegendaryIncrement = new JTextArea(1, 2);
		boomsdayLegendaryIncrement.setDocument(new LimitedIncrement(2));
		boomsdayLegendaryIncrement.setBackground(headerTitleColor);
		boomsdayLegendaryIncrement.setBorder(new EmptyBorder(0, 9, 0, 3));
		
		createModifyButtonsPanel(boomsday, boomsdayLegendaryModifyPanel, boomsdayLegendaryReset, boomsdayLegendaryAdd, boomsdayLegendaryIncrement);
		
		// Packs without legendary probability panel
		boomsdayLegendaryProbabilityPanel = new JTextPane();
		doc = boomsdayLegendaryProbabilityPanel.getStyledDocument();
		changePanelTextStyle(boomsday, boomsdayLegendaryProbabilityPanel, LEGENDARY_PROBABILITY_TEXT, boomsdayLegendaryProbability);
		boomsdayLegendaryProbabilityPanel.setForeground(headerTitleColor);
		
		boomsdayLegendaryPanel.add(legendaryPanelTitleLabel);
		boomsdayLegendaryPanel.add(boomsdayLegendaryCounterPanel);
		boomsdayLegendaryPanel.add(boomsdayLegendaryModifyPanel);
		boomsdayLegendaryPanel.add(boomsdayLegendaryProbabilityPanel);
		
		// Total amount of packs opened panel
		JPanel boomsdayTotalPanel = new JPanel();
		boomsdayTotalPanel.setBackground(boomsday.getBackground());
		boomsdayTotalPanel.setLayout(new GridLayout(4, 1));
		
		// Total amount of packs opened panel title
		totalPanelTitleLabel = new JTextPane();
		doc = totalPanelTitleLabel.getStyledDocument();
		changePanelTitleStyle(boomsday, totalPanelTitleLabel,TOTAL_PANEL_TITLE);
		totalPanelTitleLabel.setForeground(headerTitleColor);
		
		// Total amount of packs opened counter panel
		boomsdayTotalCounterPanel = new JTextPane();
		doc = boomsdayTotalCounterPanel.getStyledDocument();
		changePanelTextStyle(boomsday, boomsdayTotalCounterPanel, TOTAL_COUNTER_TEXT, boomsdayTotalCounter);
		boomsdayTotalCounterPanel.setForeground(headerTitleColor);
		
		// Total amount of packs opened counter modify buttons panel
		JPanel boomsdayTotalModifyPanel = new JPanel();
		
		// Modify button
		boomsdayTotalModify = new ModifierButton(MODIFY, headerTitleColor, buttonsDarkHoverColor);
		boomsdayTotalModify.setToolTipText(MODIFY_BUTTON_TOOLTIP_TEXT);
		boomsdayTotalModify.setBackground(headerTitleColor);
		
		// Blank space between modify and add buttons
		blank = new JLabel();
		blank.setBackground(boomsday.getBackground());
		blank.setBorder(new EmptyBorder(0, 5, 0, 5));
		
		// Add button
		boomsdayTotalAdd = new RoundButton(ADD, headerTitleColor, buttonsDarkHoverColor);
		boomsdayTotalAdd.setBackground(headerTitleColor);
		
		// Increment field
		boomsdayTotalIncrement = new JTextArea(1, 3);
		boomsdayTotalIncrement.setDocument(new LimitedIncrement(3));
		boomsdayTotalIncrement.setBackground(headerTitleColor);
		boomsdayTotalIncrement.setBorder(new EmptyBorder(0, 9, 0, 0));
		
		createModifyButtonsPanel(boomsday, boomsdayTotalModifyPanel, boomsdayTotalModify, boomsdayTotalAdd, boomsdayTotalIncrement);
		
		// Common button
		JPanel boomsdayCommonButtonPanel = new JPanel(new GridBagLayout());
		boomsdayCommonButton = new IconButton(new ImageIcon(commonButtonDarkIcon), new ImageIcon(commonButtonDarkHoverIcon));
		
		// Rare button
		JPanel boomsdayRareButtonPanel = new JPanel(new GridBagLayout());
		boomsdayRareButton = new IconButton(new ImageIcon(rareButtonDarkIcon), new ImageIcon(rareButtonDarkHoverIcon));
		
		// Epic button
		JPanel boomsdayEpicButtonPanel = new JPanel(new GridBagLayout());
		boomsdayEpicButton = new IconButton(new ImageIcon(epicButtonDarkIcon), new ImageIcon(epicButtonDarkHoverIcon));
		
		// Legendary button
		JPanel boomsdayLegendaryButtonPanel = new JPanel(new GridBagLayout());
		boomsdayLegendaryButton = new IconButton(new ImageIcon(legendaryButtonDarkIcon), new ImageIcon(legendaryButtonDarkHoverIcon));
		
		// Rarity buttons panel
		JPanel boomsdayRarityButtonsPanel = new JPanel();
		boomsdayRarityButtonsPanel.setBackground(boomsday.getBackground());
		boomsdayRarityButtonsPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 25, 0));
		createCommonButtonPanel(boomsday, boomsdayCommonButtonPanel, boomsdayCommonButton);
		createRareButtonPanel(boomsday, boomsdayRareButtonPanel, boomsdayRareButton);
		createEpicButtonPanel(boomsday, boomsdayEpicButtonPanel, boomsdayEpicButton);
		createLegendaryButtonPanel(boomsday, boomsdayLegendaryButtonPanel, boomsdayLegendaryButton);
		boomsdayRarityButtonsPanel.add(boomsdayCommonButtonPanel);
		boomsdayRarityButtonsPanel.add(boomsdayRareButtonPanel);
		boomsdayRarityButtonsPanel.add(boomsdayEpicButtonPanel);
		boomsdayRarityButtonsPanel.add(boomsdayLegendaryButtonPanel);
		
		boomsdayTotalPanel.add(totalPanelTitleLabel);
		boomsdayTotalPanel.add(boomsdayTotalCounterPanel);
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
		JPanel witchwoodImagePanel = new JPanel(new GridBagLayout());
		witchwoodImagePanel.setBackground(witchwood.getBackground());
		
		witchwoodImageButton = new JButton(new ImageIcon(witchwoodImage));
		witchwoodImageButton.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 0));
		witchwoodImageButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		witchwoodImageButton.setToolTipText(IMAGE_BUTTON_TOOLTIP_TEXT);
		witchwoodImageButton.setContentAreaFilled(false);
		witchwoodImageButton.setFocusPainted(false);
		
		witchwoodImagePanel.add(witchwoodImageButton);
				
		// Packs without epic panel
		JPanel witchwoodEpicPanel = new JPanel();
		witchwoodEpicPanel.setBackground(witchwood.getBackground());
		witchwoodEpicPanel.setLayout(new GridLayout(4, 1));
		
		// Packs without epic panel title
		epicPanelTitleLabel = new JTextPane();
		doc = epicPanelTitleLabel.getStyledDocument();
		changePanelTitleStyle(witchwood, epicPanelTitleLabel, EPIC_PANEL_TITLE);
		
		// Packs without epic counter panel
		witchwoodEpicCounterPanel = new JTextPane();
		doc = witchwoodEpicCounterPanel.getStyledDocument();
		changePanelTextStyle(witchwood, witchwoodEpicCounterPanel, EPIC_COUNTER_TEXT, witchwoodEpicCounter);
		
		// Packs without epic counter modify buttons panel
		JPanel witchwoodEpicModifyPanel = new JPanel();
		
		// Reset button
		witchwoodEpicReset = new ModifierButton(RESET, headerBGColor, buttonsHoverColor);
		witchwoodEpicReset.setToolTipText(RESET_BUTTON_TOOLTIP_TEXT);
		witchwoodEpicReset.setBackground(headerBGColor);
		witchwoodEpicReset.setForeground(headerTitleColor);
		
		// Blank space between reset and add buttons
		blank = new JLabel();
		blank.setBackground(witchwood.getBackground());
		blank.setBorder(new EmptyBorder(0, 20, 0, 20));
		
		// Add button
		witchwoodEpicAdd = new RoundButton(ADD, headerBGColor, buttonsHoverColor);
		witchwoodEpicAdd.setBackground(headerBGColor);
		witchwoodEpicAdd.setForeground(headerTitleColor);
		
		// Increment field
		witchwoodEpicIncrement = new JTextArea(1, 1);
		witchwoodEpicIncrement.setDocument(new LimitedIncrement(1));
		witchwoodEpicIncrement.setBackground(headerBGColor);
		witchwoodEpicIncrement.setForeground(headerTitleColor);
		witchwoodEpicIncrement.setCaretColor(headerTitleColor);
		witchwoodEpicIncrement.setBorder(new EmptyBorder(0, 9, 0, 6));
		
		createModifyButtonsPanel(witchwood, witchwoodEpicModifyPanel, witchwoodEpicReset, witchwoodEpicAdd, witchwoodEpicIncrement);
		
		// Packs without epic probability panel
		witchwoodEpicProbabilityPanel = new JTextPane();
		doc = witchwoodEpicProbabilityPanel.getStyledDocument();
		changePanelTextStyle(witchwood, witchwoodEpicProbabilityPanel, EPIC_PROBABILITY_TEXT, witchwoodEpicProbability);
		
		witchwoodEpicPanel.add(epicPanelTitleLabel);
		witchwoodEpicPanel.add(witchwoodEpicCounterPanel);
		witchwoodEpicPanel.add(witchwoodEpicModifyPanel);
		witchwoodEpicPanel.add(witchwoodEpicProbabilityPanel);
		
		// Packs without legendary panel
		JPanel witchwoodLegendaryPanel = new JPanel();
		witchwoodLegendaryPanel.setBackground(witchwood.getBackground());
		witchwoodLegendaryPanel.setLayout(new GridLayout(4, 1));
		
		// Packs without legendary panel title
		legendaryPanelTitleLabel = new JTextPane();
		doc = legendaryPanelTitleLabel.getStyledDocument();
		changePanelTitleStyle(witchwood, legendaryPanelTitleLabel, LEGENDARY_PANEL_TITLE);
		
		// Packs without legendary counter panel
		witchwoodLegendaryCounterPanel = new JTextPane();
		doc = witchwoodLegendaryCounterPanel.getStyledDocument();
		changePanelTextStyle(witchwood, witchwoodLegendaryCounterPanel, LEGENDARY_COUNTER_TEXT, witchwoodLegendaryCounter);
		
		// Packs without legendary counter modify buttons panel
		JPanel witchwoodLegendaryModifyPanel = new JPanel();
		
		// Reset button
		witchwoodLegendaryReset = new ModifierButton(RESET, headerBGColor, buttonsHoverColor);
		witchwoodLegendaryReset.setToolTipText(RESET_BUTTON_TOOLTIP_TEXT);
		witchwoodLegendaryReset.setBackground(headerBGColor);
		witchwoodLegendaryReset.setForeground(headerTitleColor);
		
		// Blank space between reset and add buttons
		blank = new JLabel();
		blank.setBackground(witchwood.getBackground());
		blank.setBorder(new EmptyBorder(0, 20, 0, 20));
		
		// Add button
		witchwoodLegendaryAdd = new RoundButton(ADD, headerBGColor, buttonsHoverColor);
		witchwoodLegendaryAdd.setBackground(headerBGColor);
		witchwoodLegendaryAdd.setForeground(headerTitleColor);
		
		// Increment field
		witchwoodLegendaryIncrement = new JTextArea(1, 2);
		witchwoodLegendaryIncrement.setDocument(new LimitedIncrement(2));
		witchwoodLegendaryIncrement.setBackground(headerBGColor);
		witchwoodLegendaryIncrement.setForeground(headerTitleColor);
		witchwoodLegendaryIncrement.setCaretColor(headerTitleColor);
		witchwoodLegendaryIncrement.setBorder(new EmptyBorder(0, 9, 0, 3));
		
		createModifyButtonsPanel(witchwood, witchwoodLegendaryModifyPanel, witchwoodLegendaryReset, witchwoodLegendaryAdd, witchwoodLegendaryIncrement);
		
		// Packs without legendary probability panel
		witchwoodLegendaryProbabilityPanel = new JTextPane();
		doc = witchwoodLegendaryProbabilityPanel.getStyledDocument();
		changePanelTextStyle(witchwood, witchwoodLegendaryProbabilityPanel, LEGENDARY_PROBABILITY_TEXT, witchwoodLegendaryProbability);
		
		witchwoodLegendaryPanel.add(legendaryPanelTitleLabel);
		witchwoodLegendaryPanel.add(witchwoodLegendaryCounterPanel);
		witchwoodLegendaryPanel.add(witchwoodLegendaryModifyPanel);
		witchwoodLegendaryPanel.add(witchwoodLegendaryProbabilityPanel);
		
		// Total amount of packs opened panel
		JPanel witchwoodTotalPanel = new JPanel();
		witchwoodTotalPanel.setBackground(witchwood.getBackground());
		witchwoodTotalPanel.setLayout(new GridLayout(4, 1));
		
		// Total amount of packs opened panel title
		totalPanelTitleLabel = new JTextPane();
		doc = totalPanelTitleLabel.getStyledDocument();
		changePanelTitleStyle(witchwood, totalPanelTitleLabel,TOTAL_PANEL_TITLE);
		
		// Total amount of packs opened counter panel
		witchwoodTotalCounterPanel = new JTextPane();
		doc = witchwoodTotalCounterPanel.getStyledDocument();
		changePanelTextStyle(witchwood, witchwoodTotalCounterPanel, TOTAL_COUNTER_TEXT, witchwoodTotalCounter);
		
		// Total amount of packs opened counter modify buttons panel
		JPanel witchwoodTotalModifyPanel = new JPanel();
		
		// Modify button
		witchwoodTotalModify = new ModifierButton(MODIFY, headerBGColor, buttonsHoverColor);
		witchwoodTotalModify.setToolTipText(MODIFY_BUTTON_TOOLTIP_TEXT);
		witchwoodTotalModify.setBackground(headerBGColor);
		witchwoodTotalModify.setForeground(headerTitleColor);
		
		// Blank space between modify and add buttons
		blank = new JLabel();
		blank.setBackground(witchwood.getBackground());
		blank.setBorder(new EmptyBorder(0, 5, 0, 5));
		
		// Add button
		witchwoodTotalAdd = new RoundButton(ADD, headerBGColor, buttonsHoverColor);
		witchwoodTotalAdd.setBackground(headerBGColor);
		witchwoodTotalAdd.setForeground(headerTitleColor);
		
		// Increment field
		witchwoodTotalIncrement = new JTextArea(1, 3);
		witchwoodTotalIncrement.setDocument(new LimitedIncrement(3));
		witchwoodTotalIncrement.setBackground(headerBGColor);
		witchwoodTotalIncrement.setForeground(headerTitleColor);
		witchwoodTotalIncrement.setCaretColor(headerTitleColor);
		witchwoodTotalIncrement.setBorder(new EmptyBorder(0, 9, 0, 0));
		
		createModifyButtonsPanel(witchwood, witchwoodTotalModifyPanel, witchwoodTotalModify, witchwoodTotalAdd, witchwoodTotalIncrement);
		
		// Common button
		JPanel witchwoodCommonButtonPanel = new JPanel(new GridBagLayout());
		witchwoodCommonButton = new IconButton(new ImageIcon(commonButtonIcon), new ImageIcon(commonButtonHoverIcon));
		
		// Rare button
		JPanel witchwoodRareButtonPanel = new JPanel(new GridBagLayout());
		witchwoodRareButton = new IconButton(new ImageIcon(rareButtonIcon), new ImageIcon(rareButtonHoverIcon));
		
		// Epic button
		JPanel witchwoodEpicButtonPanel = new JPanel(new GridBagLayout());
		witchwoodEpicButton = new IconButton(new ImageIcon(epicButtonIcon), new ImageIcon(epicButtonHoverIcon));
		
		// Legendary button
		JPanel witchwoodLegendaryButtonPanel = new JPanel(new GridBagLayout());
		witchwoodLegendaryButton = new IconButton(new ImageIcon(legendaryButtonIcon), new ImageIcon(legendaryButtonHoverIcon));
		
		// Rarity buttons panel
		JPanel witchwoodRarityButtonsPanel = new JPanel();
		witchwoodRarityButtonsPanel.setBackground(witchwood.getBackground());
		witchwoodRarityButtonsPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 25, 0));
		createCommonButtonPanel(witchwood, witchwoodCommonButtonPanel, witchwoodCommonButton);
		createRareButtonPanel(witchwood, witchwoodRareButtonPanel, witchwoodRareButton);
		createEpicButtonPanel(witchwood, witchwoodEpicButtonPanel, witchwoodEpicButton);
		createLegendaryButtonPanel(witchwood, witchwoodLegendaryButtonPanel, witchwoodLegendaryButton);
		witchwoodRarityButtonsPanel.add(witchwoodCommonButtonPanel);
		witchwoodRarityButtonsPanel.add(witchwoodRareButtonPanel);
		witchwoodRarityButtonsPanel.add(witchwoodEpicButtonPanel);
		witchwoodRarityButtonsPanel.add(witchwoodLegendaryButtonPanel);
		
		witchwoodTotalPanel.add(totalPanelTitleLabel);
		witchwoodTotalPanel.add(witchwoodTotalCounterPanel);
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
		mammothHeader = new JPanel(new FlowLayout(FlowLayout.CENTER));
		mammothHeader.setBackground(yearsColor);

		JLabel mammothImageLabel = new JLabel(new ImageIcon(mammothImage));
		mammothImageLabel.setBorder(new EmptyBorder(0, 5, 0, 5));

		JLabel mammothLabel = new JLabel(MAMMOTH_TITLE);
		mammothLabel.setFont(yearsFont);
		mammothLabel.setBorder(new EmptyBorder(5, 10, 5, 5));
		
		mammothHeader.add(mammothImageLabel);
		mammothHeader.add(mammothLabel);
				
		// "Year of the Mammoth" expansions
		createKoboldsAndCatacombsPanel();
		createKnightsOfTheFrozenThronePanel();
		createJourneyToUngoroPanel();
		
		SwingUtilities.invokeLater(() -> {
			mammoth.add(mammothHeader);
			mammoth.add(kobolds);
			mammoth.add(knights);
			mammoth.add(ungoro);
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
		JPanel koboldsImagePanel = new JPanel(new GridBagLayout());
		koboldsImagePanel.setBackground(kobolds.getBackground());
		
		koboldsImageButton = new JButton(new ImageIcon(koboldsImage));
		koboldsImageButton.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 0));
		koboldsImageButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		koboldsImageButton.setToolTipText(IMAGE_BUTTON_TOOLTIP_TEXT);
		koboldsImageButton.setContentAreaFilled(false);
		koboldsImageButton.setFocusPainted(false);
		
		koboldsImagePanel.add(koboldsImageButton);
		
		// Packs without epic panel
		JPanel koboldsEpicPanel = new JPanel();
		koboldsEpicPanel.setBackground(kobolds.getBackground());
		koboldsEpicPanel.setLayout(new GridLayout(4, 1));
		
		// Packs without epic panel title
		epicPanelTitleLabel = new JTextPane();
		doc = epicPanelTitleLabel.getStyledDocument();
		changePanelTitleStyle(kobolds, epicPanelTitleLabel, EPIC_PANEL_TITLE);
		
		// Packs without epic counter panel
		koboldsEpicCounterPanel = new JTextPane();
		doc = koboldsEpicCounterPanel.getStyledDocument();
		changePanelTextStyle(kobolds, koboldsEpicCounterPanel, EPIC_COUNTER_TEXT, koboldsEpicCounter);
		
		// Packs without epic counter modify buttons panel
		JPanel koboldsEpicModifyPanel = new JPanel();
		
		// Reset button
		koboldsEpicReset = new ModifierButton(RESET, headerBGColor, buttonsHoverColor);
		koboldsEpicReset.setToolTipText(RESET_BUTTON_TOOLTIP_TEXT);
		koboldsEpicReset.setBackground(headerBGColor);
		koboldsEpicReset.setForeground(headerTitleColor);
		
		// Blank space between reset and add buttons
		blank = new JLabel();
		blank.setBackground(kobolds.getBackground());
		blank.setBorder(new EmptyBorder(0, 20, 0, 20));
		
		// Add button
		koboldsEpicAdd = new RoundButton(ADD, headerBGColor, buttonsHoverColor);
		koboldsEpicAdd.setBackground(headerBGColor);
		koboldsEpicAdd.setForeground(headerTitleColor);
		
		// Increment field
		koboldsEpicIncrement = new JTextArea(1, 1);
		koboldsEpicIncrement.setDocument(new LimitedIncrement(1));
		koboldsEpicIncrement.setBackground(headerBGColor);
		koboldsEpicIncrement.setForeground(headerTitleColor);
		koboldsEpicIncrement.setCaretColor(headerTitleColor);
		koboldsEpicIncrement.setBorder(new EmptyBorder(0, 9, 0, 6));
		
		createModifyButtonsPanel(kobolds, koboldsEpicModifyPanel, koboldsEpicReset, koboldsEpicAdd, koboldsEpicIncrement);
		
		// Packs without epic probability panel
		koboldsEpicProbabilityPanel = new JTextPane();
		doc = koboldsEpicProbabilityPanel.getStyledDocument();
		changePanelTextStyle(kobolds, koboldsEpicProbabilityPanel, EPIC_PROBABILITY_TEXT, koboldsEpicProbability);
		
		koboldsEpicPanel.add(epicPanelTitleLabel);
		koboldsEpicPanel.add(koboldsEpicCounterPanel);
		koboldsEpicPanel.add(koboldsEpicModifyPanel);
		koboldsEpicPanel.add(koboldsEpicProbabilityPanel);
		
		// Packs without legendary panel
		JPanel koboldsLegendaryPanel = new JPanel();
		koboldsLegendaryPanel.setBackground(kobolds.getBackground());
		koboldsLegendaryPanel.setLayout(new GridLayout(4, 1));
		
		// Packs without legendary panel title
		legendaryPanelTitleLabel = new JTextPane();
		doc = legendaryPanelTitleLabel.getStyledDocument();
		changePanelTitleStyle(kobolds, legendaryPanelTitleLabel, LEGENDARY_PANEL_TITLE);
		
		// Packs without legendary counter panel
		koboldsLegendaryCounterPanel = new JTextPane();
		doc = koboldsLegendaryCounterPanel.getStyledDocument();
		changePanelTextStyle(kobolds, koboldsLegendaryCounterPanel, LEGENDARY_COUNTER_TEXT, koboldsLegendaryCounter);
		
		// Packs without legendary counter modify buttons panel
		JPanel koboldsLegendaryModifyPanel = new JPanel();
		
		// Reset button
		koboldsLegendaryReset = new ModifierButton(RESET, headerBGColor, buttonsHoverColor);
		koboldsLegendaryReset.setToolTipText(RESET_BUTTON_TOOLTIP_TEXT);
		koboldsLegendaryReset.setBackground(headerBGColor);
		koboldsLegendaryReset.setForeground(headerTitleColor);
		
		// Blank space between reset and add buttons
		blank = new JLabel();
		blank.setBackground(kobolds.getBackground());
		blank.setBorder(new EmptyBorder(0, 20, 0, 20));
		
		// Add button
		koboldsLegendaryAdd = new RoundButton(ADD, headerBGColor, buttonsHoverColor);
		koboldsLegendaryAdd.setBackground(headerBGColor);
		koboldsLegendaryAdd.setForeground(headerTitleColor);
		
		// Increment field
		koboldsLegendaryIncrement = new JTextArea(1, 2);
		koboldsLegendaryIncrement.setDocument(new LimitedIncrement(2));
		koboldsLegendaryIncrement.setBackground(headerBGColor);
		koboldsLegendaryIncrement.setForeground(headerTitleColor);
		koboldsLegendaryIncrement.setCaretColor(headerTitleColor);
		koboldsLegendaryIncrement.setBorder(new EmptyBorder(0, 9, 0, 3));
		
		createModifyButtonsPanel(kobolds, koboldsLegendaryModifyPanel, koboldsLegendaryReset, koboldsLegendaryAdd, koboldsLegendaryIncrement);
		
		// Packs without legendary probability panel
		koboldsLegendaryProbabilityPanel = new JTextPane();
		doc = koboldsLegendaryProbabilityPanel.getStyledDocument();
		changePanelTextStyle(kobolds, koboldsLegendaryProbabilityPanel, LEGENDARY_PROBABILITY_TEXT, koboldsLegendaryProbability);
		
		koboldsLegendaryPanel.add(legendaryPanelTitleLabel);
		koboldsLegendaryPanel.add(koboldsLegendaryCounterPanel);
		koboldsLegendaryPanel.add(koboldsLegendaryModifyPanel);
		koboldsLegendaryPanel.add(koboldsLegendaryProbabilityPanel);
		
		// Total amount of packs opened panel
		JPanel koboldsTotalPanel = new JPanel();
		koboldsTotalPanel.setBackground(kobolds.getBackground());
		koboldsTotalPanel.setLayout(new GridLayout(4, 1));
		
		// Total amount of packs opened panel title
		totalPanelTitleLabel = new JTextPane();
		doc = totalPanelTitleLabel.getStyledDocument();
		changePanelTitleStyle(kobolds, totalPanelTitleLabel,TOTAL_PANEL_TITLE);
		
		// Total amount of packs opened counter panel
		koboldsTotalCounterPanel = new JTextPane();
		doc = koboldsTotalCounterPanel.getStyledDocument();
		changePanelTextStyle(kobolds, koboldsTotalCounterPanel, TOTAL_COUNTER_TEXT, koboldsTotalCounter);
		
		// Total amount of packs opened counter modify buttons panel
		JPanel koboldsTotalModifyPanel = new JPanel();
		
		// Modify button
		koboldsTotalModify = new ModifierButton(MODIFY, headerBGColor, buttonsHoverColor);
		koboldsTotalModify.setToolTipText(MODIFY_BUTTON_TOOLTIP_TEXT);
		koboldsTotalModify.setBackground(headerBGColor);
		koboldsTotalModify.setForeground(headerTitleColor);
		
		// Blank space between modify and add buttons
		blank = new JLabel();
		blank.setBackground(kobolds.getBackground());
		blank.setBorder(new EmptyBorder(0, 5, 0, 5));
		
		// Add button
		koboldsTotalAdd = new RoundButton(ADD, headerBGColor, buttonsHoverColor);
		koboldsTotalAdd.setBackground(headerBGColor);
		koboldsTotalAdd.setForeground(headerTitleColor);
		
		// Increment field
		koboldsTotalIncrement = new JTextArea(1, 3);
		koboldsTotalIncrement.setDocument(new LimitedIncrement(3));
		koboldsTotalIncrement.setBackground(headerBGColor);
		koboldsTotalIncrement.setForeground(headerTitleColor);
		koboldsTotalIncrement.setCaretColor(headerTitleColor);
		koboldsTotalIncrement.setBorder(new EmptyBorder(0, 9, 0, 0));
		
		createModifyButtonsPanel(kobolds, koboldsTotalModifyPanel, koboldsTotalModify, koboldsTotalAdd, koboldsTotalIncrement);
		
		// Common button
		JPanel koboldsCommonButtonPanel = new JPanel(new GridBagLayout());
		koboldsCommonButton = new IconButton(new ImageIcon(commonButtonIcon), new ImageIcon(commonButtonHoverIcon));
		
		// Rare button
		JPanel koboldsRareButtonPanel = new JPanel(new GridBagLayout());
		koboldsRareButton = new IconButton(new ImageIcon(rareButtonIcon), new ImageIcon(rareButtonHoverIcon));
		
		// Epic button
		JPanel koboldsEpicButtonPanel = new JPanel(new GridBagLayout());
		koboldsEpicButton = new IconButton(new ImageIcon(epicButtonIcon), new ImageIcon(epicButtonHoverIcon));
		
		// Legendary button
		JPanel koboldsLegendaryButtonPanel = new JPanel(new GridBagLayout());
		koboldsLegendaryButton = new IconButton(new ImageIcon(legendaryButtonIcon), new ImageIcon(legendaryButtonHoverIcon));
		
		// Rarity buttons panel
		JPanel koboldsRarityButtonsPanel = new JPanel();
		koboldsRarityButtonsPanel.setBackground(kobolds.getBackground());
		koboldsRarityButtonsPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 25, 0));
		createCommonButtonPanel(kobolds, koboldsCommonButtonPanel, koboldsCommonButton);
		createRareButtonPanel(kobolds, koboldsRareButtonPanel, koboldsRareButton);
		createEpicButtonPanel(kobolds, koboldsEpicButtonPanel, koboldsEpicButton);
		createLegendaryButtonPanel(kobolds, koboldsLegendaryButtonPanel, koboldsLegendaryButton);
		koboldsRarityButtonsPanel.add(koboldsCommonButtonPanel);
		koboldsRarityButtonsPanel.add(koboldsRareButtonPanel);
		koboldsRarityButtonsPanel.add(koboldsEpicButtonPanel);
		koboldsRarityButtonsPanel.add(koboldsLegendaryButtonPanel);
		
		koboldsTotalPanel.add(totalPanelTitleLabel);
		koboldsTotalPanel.add(koboldsTotalCounterPanel);
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
		JPanel knightsImagePanel = new JPanel(new GridBagLayout());
		knightsImagePanel.setBackground(knights.getBackground());
		
		knightsImageButton = new JButton(new ImageIcon(knightsImage));
		knightsImageButton.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 0));
		knightsImageButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		knightsImageButton.setToolTipText(IMAGE_BUTTON_TOOLTIP_TEXT);
		knightsImageButton.setContentAreaFilled(false);
		knightsImageButton.setFocusPainted(false);
		
		knightsImagePanel.add(knightsImageButton);
		
		// Packs without epic panel
		JPanel knightsEpicPanel = new JPanel();
		knightsEpicPanel.setBackground(knights.getBackground());
		knightsEpicPanel.setLayout(new GridLayout(4, 1));
		
		// Packs without epic panel title
		epicPanelTitleLabel = new JTextPane();
		doc = epicPanelTitleLabel.getStyledDocument();
		changePanelTitleStyle(knights, epicPanelTitleLabel, EPIC_PANEL_TITLE);
		
		// Packs without epic counter panel
		knightsEpicCounterPanel = new JTextPane();
		doc = knightsEpicCounterPanel.getStyledDocument();
		changePanelTextStyle(knights, knightsEpicCounterPanel, EPIC_COUNTER_TEXT, knightsEpicCounter);
		
		// Packs without epic counter modify buttons panel
		JPanel knightsEpicModifyPanel = new JPanel();
		
		// Reset button
		knightsEpicReset = new ModifierButton(RESET, headerBGColor, buttonsHoverColor);
		knightsEpicReset.setToolTipText(RESET_BUTTON_TOOLTIP_TEXT);
		knightsEpicReset.setBackground(headerBGColor);
		knightsEpicReset.setForeground(headerTitleColor);
		
		// Blank space between reset and add buttons
		blank = new JLabel();
		blank.setBackground(knights.getBackground());
		blank.setBorder(new EmptyBorder(0, 20, 0, 20));
		
		// Add button
		knightsEpicAdd = new RoundButton(ADD, headerBGColor, buttonsHoverColor);
		knightsEpicAdd.setBackground(headerBGColor);
		knightsEpicAdd.setForeground(headerTitleColor);
		
		// Increment field
		knightsEpicIncrement = new JTextArea(1, 1);
		knightsEpicIncrement.setDocument(new LimitedIncrement(1));
		knightsEpicIncrement.setBackground(headerBGColor);
		knightsEpicIncrement.setForeground(headerTitleColor);
		knightsEpicIncrement.setCaretColor(headerTitleColor);
		knightsEpicIncrement.setBorder(new EmptyBorder(0, 9, 0, 6));
		
		createModifyButtonsPanel(knights, knightsEpicModifyPanel, knightsEpicReset, knightsEpicAdd, knightsEpicIncrement);
		
		// Packs without epic probability panel
		knightsEpicProbabilityPanel = new JTextPane();
		doc = knightsEpicProbabilityPanel.getStyledDocument();
		changePanelTextStyle(knights, knightsEpicProbabilityPanel,EPIC_PROBABILITY_TEXT, knightsEpicProbability);
		
		knightsEpicPanel.add(epicPanelTitleLabel);
		knightsEpicPanel.add(knightsEpicCounterPanel);
		knightsEpicPanel.add(knightsEpicModifyPanel);
		knightsEpicPanel.add(knightsEpicProbabilityPanel);
		
		// Packs without legendary panel
		JPanel knightsLegendaryPanel = new JPanel();
		knightsLegendaryPanel.setBackground(knights.getBackground());
		knightsLegendaryPanel.setLayout(new GridLayout(4, 1));
		
		// Packs without legendary panel title
		legendaryPanelTitleLabel = new JTextPane();
		doc = legendaryPanelTitleLabel.getStyledDocument();
		changePanelTitleStyle(knights, legendaryPanelTitleLabel, LEGENDARY_PANEL_TITLE);
				
		// Packs without legendary counter panel
		knightsLegendaryCounterPanel = new JTextPane();
		doc = knightsLegendaryCounterPanel.getStyledDocument();
		changePanelTextStyle(knights, knightsLegendaryCounterPanel, LEGENDARY_COUNTER_TEXT, knightsLegendaryCounter);
		
		// Packs without legendary counter modify buttons panel
		JPanel knightsLegendaryModifyPanel = new JPanel();
		
		// Reset button
		knightsLegendaryReset = new ModifierButton(RESET, headerBGColor, buttonsHoverColor);
		knightsLegendaryReset.setToolTipText(RESET_BUTTON_TOOLTIP_TEXT);
		knightsLegendaryReset.setBackground(headerBGColor);
		knightsLegendaryReset.setForeground(headerTitleColor);
		
		// Blank space between reset and add buttons
		blank = new JLabel();
		blank.setBackground(knights.getBackground());
		blank.setBorder(new EmptyBorder(0, 20, 0, 20));
		
		// Add button
		knightsLegendaryAdd = new RoundButton(ADD, headerBGColor, buttonsHoverColor);
		knightsLegendaryAdd.setBackground(headerBGColor);
		knightsLegendaryAdd.setForeground(headerTitleColor);
		
		// Increment field
		knightsLegendaryIncrement = new JTextArea(1, 2);
		knightsLegendaryIncrement.setDocument(new LimitedIncrement(2));
		knightsLegendaryIncrement.setBackground(headerBGColor);
		knightsLegendaryIncrement.setForeground(headerTitleColor);
		knightsLegendaryIncrement.setCaretColor(headerTitleColor);
		knightsLegendaryIncrement.setBorder(new EmptyBorder(0, 9, 0, 3));
		
		createModifyButtonsPanel(knights, knightsLegendaryModifyPanel, knightsLegendaryReset, knightsLegendaryAdd, knightsLegendaryIncrement);
		
		// Packs without legendary probability panel
		knightsLegendaryProbabilityPanel = new JTextPane();
		doc = knightsLegendaryProbabilityPanel.getStyledDocument();
		changePanelTextStyle(knights, knightsLegendaryProbabilityPanel, LEGENDARY_PROBABILITY_TEXT, knightsLegendaryProbability);
		
		knightsLegendaryPanel.add(legendaryPanelTitleLabel);
		knightsLegendaryPanel.add(knightsLegendaryCounterPanel);
		knightsLegendaryPanel.add(knightsLegendaryModifyPanel);
		knightsLegendaryPanel.add(knightsLegendaryProbabilityPanel);
		
		// Total amount of packs opened panel
		JPanel knightsTotalPanel = new JPanel();
		knightsTotalPanel.setBackground(knights.getBackground());
		knightsTotalPanel.setLayout(new GridLayout(4, 1));
		
		// Total amount of packs opened panel title
		totalPanelTitleLabel = new JTextPane();
		doc = totalPanelTitleLabel.getStyledDocument();
		changePanelTitleStyle(knights, totalPanelTitleLabel,TOTAL_PANEL_TITLE);
		
		// Total amount of packs opened counter panel
		knightsTotalCounterPanel = new JTextPane();
		doc = knightsTotalCounterPanel.getStyledDocument();
		changePanelTextStyle(knights, knightsTotalCounterPanel, TOTAL_COUNTER_TEXT, knightsTotalCounter);
		
		// Total amount of packs opened counter modify buttons panel
		JPanel knightsTotalModifyPanel = new JPanel();
		
		// Modify button
		knightsTotalModify = new ModifierButton(MODIFY, headerBGColor, buttonsHoverColor);
		knightsTotalModify.setToolTipText(MODIFY_BUTTON_TOOLTIP_TEXT);
		knightsTotalModify.setBackground(headerBGColor);
		knightsTotalModify.setForeground(headerTitleColor);
		
		// Blank space between modify and add buttons
		blank = new JLabel();
		blank.setBackground(knights.getBackground());
		blank.setBorder(new EmptyBorder(0, 5, 0, 5));
		
		// Add button
		knightsTotalAdd = new RoundButton(ADD, headerBGColor, buttonsHoverColor);
		knightsTotalAdd.setBackground(headerBGColor);
		knightsTotalAdd.setForeground(headerTitleColor);
		
		// Increment field
		knightsTotalIncrement = new JTextArea(1, 3);
		knightsTotalIncrement.setDocument(new LimitedIncrement(3));
		knightsTotalIncrement.setBackground(headerBGColor);
		knightsTotalIncrement.setForeground(headerTitleColor);
		knightsTotalIncrement.setCaretColor(headerTitleColor);
		knightsTotalIncrement.setBorder(new EmptyBorder(0, 9, 0, 0));
		
		createModifyButtonsPanel(knights, knightsTotalModifyPanel, knightsTotalModify, knightsTotalAdd, knightsTotalIncrement);
		
		// Common button
		JPanel knightsCommonButtonPanel = new JPanel(new GridBagLayout());
		knightsCommonButton = new IconButton(new ImageIcon(commonButtonIcon), new ImageIcon(commonButtonHoverIcon));
		
		// Rare button
		JPanel knightsRareButtonPanel = new JPanel(new GridBagLayout());
		knightsRareButton = new IconButton(new ImageIcon(rareButtonIcon), new ImageIcon(rareButtonHoverIcon));
		
		// Epic button
		JPanel knightsEpicButtonPanel = new JPanel(new GridBagLayout());
		knightsEpicButton = new IconButton(new ImageIcon(epicButtonIcon), new ImageIcon(epicButtonHoverIcon));
		
		// Legendary button
		JPanel knightsLegendaryButtonPanel = new JPanel(new GridBagLayout());
		knightsLegendaryButton = new IconButton(new ImageIcon(legendaryButtonIcon), new ImageIcon(legendaryButtonHoverIcon));
		
		// Rarity buttons panel
		JPanel knightsRarityButtonsPanel = new JPanel();
		knightsRarityButtonsPanel.setBackground(knights.getBackground());
		knightsRarityButtonsPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 25, 0));
		createCommonButtonPanel(knights, knightsCommonButtonPanel, knightsCommonButton);
		createRareButtonPanel(knights, knightsRareButtonPanel, knightsRareButton);
		createEpicButtonPanel(knights, knightsEpicButtonPanel, knightsEpicButton);
		createLegendaryButtonPanel(knights, knightsLegendaryButtonPanel, knightsLegendaryButton);
		knightsRarityButtonsPanel.add(knightsCommonButtonPanel);
		knightsRarityButtonsPanel.add(knightsRareButtonPanel);
		knightsRarityButtonsPanel.add(knightsEpicButtonPanel);
		knightsRarityButtonsPanel.add(knightsLegendaryButtonPanel);
		
		knightsTotalPanel.add(totalPanelTitleLabel);
		knightsTotalPanel.add(knightsTotalCounterPanel);
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
		JPanel ungoroImagePanel = new JPanel(new GridBagLayout());
		ungoroImagePanel.setBackground(ungoro.getBackground());
		
		ungoroImageButton = new JButton(new ImageIcon(ungoroImage));
		ungoroImageButton.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 0));
		ungoroImageButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		ungoroImageButton.setToolTipText(IMAGE_BUTTON_TOOLTIP_TEXT);
		ungoroImageButton.setContentAreaFilled(false);
		ungoroImageButton.setFocusPainted(false);
		
		ungoroImagePanel.add(ungoroImageButton);
		
		// Packs without epic panel
		JPanel ungoroEpicPanel = new JPanel();
		ungoroEpicPanel.setBackground(ungoro.getBackground());
		ungoroEpicPanel.setLayout(new GridLayout(4, 1));
		
		// Packs without epic panel title
		epicPanelTitleLabel = new JTextPane();
		doc = epicPanelTitleLabel.getStyledDocument();
		changePanelTitleStyle(ungoro, epicPanelTitleLabel, EPIC_PANEL_TITLE);
		
		// Packs without epic counter panel
		ungoroEpicCounterPanel = new JTextPane();
		doc = ungoroEpicCounterPanel.getStyledDocument();
		changePanelTextStyle(ungoro, ungoroEpicCounterPanel, EPIC_COUNTER_TEXT, ungoroEpicCounter);
		
		// Packs without epic counter modify buttons panel
		JPanel ungoroEpicModifyPanel = new JPanel();
		
		// Reset button
		ungoroEpicReset = new ModifierButton(RESET, headerBGColor, buttonsHoverColor);
		ungoroEpicReset.setToolTipText(RESET_BUTTON_TOOLTIP_TEXT);
		ungoroEpicReset.setBackground(headerBGColor);
		ungoroEpicReset.setForeground(headerTitleColor);
		
		// Blank space between reset and add buttons
		blank = new JLabel();
		blank.setBackground(ungoro.getBackground());
		blank.setBorder(new EmptyBorder(0, 20, 0, 20));
		
		// Add button
		ungoroEpicAdd = new RoundButton(ADD, headerBGColor, buttonsHoverColor);
		ungoroEpicAdd.setBackground(headerBGColor);
		ungoroEpicAdd.setForeground(headerTitleColor);
		
		// Increment field
		ungoroEpicIncrement = new JTextArea(1, 1);
		ungoroEpicIncrement.setDocument(new LimitedIncrement(1));
		ungoroEpicIncrement.setBackground(headerBGColor);
		ungoroEpicIncrement.setForeground(headerTitleColor);
		ungoroEpicIncrement.setCaretColor(headerTitleColor);
		ungoroEpicIncrement.setBorder(new EmptyBorder(0, 9, 0, 6));
		
		createModifyButtonsPanel(ungoro, ungoroEpicModifyPanel, ungoroEpicReset, ungoroEpicAdd, ungoroEpicIncrement);
		
		// Packs without epic probability panel
		ungoroEpicProbabilityPanel = new JTextPane();
		doc = ungoroEpicProbabilityPanel.getStyledDocument();
		changePanelTextStyle(ungoro, ungoroEpicProbabilityPanel, EPIC_PROBABILITY_TEXT, ungoroEpicProbability);
		
		ungoroEpicPanel.add(epicPanelTitleLabel);
		ungoroEpicPanel.add(ungoroEpicCounterPanel);
		ungoroEpicPanel.add(ungoroEpicModifyPanel);
		ungoroEpicPanel.add(ungoroEpicProbabilityPanel);
		
		// Packs without legendary panel
		JPanel ungoroLegendaryPanel = new JPanel();
		ungoroLegendaryPanel.setBackground(ungoro.getBackground());
		ungoroLegendaryPanel.setLayout(new GridLayout(4, 1));
		
		// Packs without legendary panel title
		legendaryPanelTitleLabel = new JTextPane();
		doc = legendaryPanelTitleLabel.getStyledDocument();
		changePanelTitleStyle(ungoro, legendaryPanelTitleLabel, LEGENDARY_PANEL_TITLE);
		
		// Packs without legendary counter panel
		ungoroLegendaryCounterPanel = new JTextPane();
		doc = ungoroLegendaryCounterPanel.getStyledDocument();
		changePanelTextStyle(ungoro, ungoroLegendaryCounterPanel, LEGENDARY_COUNTER_TEXT, ungoroLegendaryCounter);
		
		// Packs without legendary counter modify buttons panel
		JPanel ungoroLegendaryModifyPanel = new JPanel();
		
		// Reset button
		ungoroLegendaryReset = new ModifierButton(RESET, headerBGColor, buttonsHoverColor);
		ungoroLegendaryReset.setToolTipText(RESET_BUTTON_TOOLTIP_TEXT);
		ungoroLegendaryReset.setBackground(headerBGColor);
		ungoroLegendaryReset.setForeground(headerTitleColor);
		
		// Blank space between reset and add buttons
		blank = new JLabel();
		blank.setBackground(ungoro.getBackground());
		blank.setBorder(new EmptyBorder(0, 20, 0, 20));
		
		// Add button
		ungoroLegendaryAdd = new RoundButton(ADD, headerBGColor, buttonsHoverColor);
		ungoroLegendaryAdd.setBackground(headerBGColor);
		ungoroLegendaryAdd.setForeground(headerTitleColor);
		
		// Increment field
		ungoroLegendaryIncrement = new JTextArea(1, 2);
		ungoroLegendaryIncrement.setDocument(new LimitedIncrement(2));
		ungoroLegendaryIncrement.setBackground(headerBGColor);
		ungoroLegendaryIncrement.setForeground(headerTitleColor);
		ungoroLegendaryIncrement.setCaretColor(headerTitleColor);
		ungoroLegendaryIncrement.setBorder(new EmptyBorder(0, 9, 0, 3));
		
		createModifyButtonsPanel(ungoro, ungoroLegendaryModifyPanel, ungoroLegendaryReset, ungoroLegendaryAdd, ungoroLegendaryIncrement);
		
		// Packs without legendary probability panel
		ungoroLegendaryProbabilityPanel = new JTextPane();
		doc = ungoroLegendaryProbabilityPanel.getStyledDocument();
		changePanelTextStyle(ungoro, ungoroLegendaryProbabilityPanel, LEGENDARY_PROBABILITY_TEXT, ungoroLegendaryProbability);
		
		ungoroLegendaryPanel.add(legendaryPanelTitleLabel);
		ungoroLegendaryPanel.add(ungoroLegendaryCounterPanel);
		ungoroLegendaryPanel.add(ungoroLegendaryModifyPanel);
		ungoroLegendaryPanel.add(ungoroLegendaryProbabilityPanel);
		
		// Total amount of packs opened panel
		JPanel ungoroTotalPanel = new JPanel();
		ungoroTotalPanel.setBackground(ungoro.getBackground());
		ungoroTotalPanel.setLayout(new GridLayout(4, 1));
		
		// Total amount of packs opened panel title
		totalPanelTitleLabel = new JTextPane();
		doc = totalPanelTitleLabel.getStyledDocument();
		changePanelTitleStyle(ungoro, totalPanelTitleLabel,TOTAL_PANEL_TITLE);
		
		// Total amount of packs opened counter panel
		ungoroTotalCounterPanel = new JTextPane();
		doc = ungoroTotalCounterPanel.getStyledDocument();
		changePanelTextStyle(ungoro, ungoroTotalCounterPanel, TOTAL_COUNTER_TEXT, ungoroTotalCounter);
		
		// Total amount of packs opened counter modify buttons panel
		JPanel ungoroTotalModifyPanel = new JPanel();
		
		// Modify button
		ungoroTotalModify = new ModifierButton(MODIFY, headerBGColor, buttonsHoverColor);
		ungoroTotalModify.setToolTipText(MODIFY_BUTTON_TOOLTIP_TEXT);
		ungoroTotalModify.setBackground(headerBGColor);
		ungoroTotalModify.setForeground(headerTitleColor);
		
		// Blank space between modify and add buttons
		blank = new JLabel();
		blank.setBackground(ungoro.getBackground());
		blank.setBorder(new EmptyBorder(0, 5, 0, 5));
		
		// Add button
		ungoroTotalAdd = new RoundButton(ADD, headerBGColor, buttonsHoverColor);
		ungoroTotalAdd.setBackground(headerBGColor);
		ungoroTotalAdd.setForeground(headerTitleColor);
		
		// Increment field
		ungoroTotalIncrement = new JTextArea(1, 3);
		ungoroTotalIncrement.setDocument(new LimitedIncrement(3));
		ungoroTotalIncrement.setBackground(headerBGColor);
		ungoroTotalIncrement.setForeground(headerTitleColor);
		ungoroTotalIncrement.setCaretColor(headerTitleColor);
		ungoroTotalIncrement.setBorder(new EmptyBorder(0, 9, 0, 0));
		
		createModifyButtonsPanel(ungoro, ungoroTotalModifyPanel, ungoroTotalModify, ungoroTotalAdd, ungoroTotalIncrement);
		
		// Common button
		JPanel ungoroCommonButtonPanel = new JPanel(new GridBagLayout());
		ungoroCommonButton = new IconButton(new ImageIcon(commonButtonIcon), new ImageIcon(commonButtonHoverIcon));
		
		// Rare button
		JPanel ungoroRareButtonPanel = new JPanel(new GridBagLayout());
		ungoroRareButton = new IconButton(new ImageIcon(rareButtonIcon), new ImageIcon(rareButtonHoverIcon));
		
		// Epic button
		JPanel ungoroEpicButtonPanel = new JPanel(new GridBagLayout());
		ungoroEpicButton = new IconButton(new ImageIcon(epicButtonIcon), new ImageIcon(epicButtonHoverIcon));
		
		// Legendary button
		JPanel ungoroLegendaryButtonPanel = new JPanel(new GridBagLayout());
		ungoroLegendaryButton = new IconButton(new ImageIcon(legendaryButtonIcon), new ImageIcon(legendaryButtonHoverIcon));
		
		// Rarity buttons panel
		JPanel ungoroRarityButtonsPanel = new JPanel();
		ungoroRarityButtonsPanel.setBackground(ungoro.getBackground());
		ungoroRarityButtonsPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 25, 0));
		createCommonButtonPanel(ungoro, ungoroCommonButtonPanel, ungoroCommonButton);
		createRareButtonPanel(ungoro, ungoroRareButtonPanel, ungoroRareButton);
		createEpicButtonPanel(ungoro, ungoroEpicButtonPanel, ungoroEpicButton);
		createLegendaryButtonPanel(ungoro, ungoroLegendaryButtonPanel, ungoroLegendaryButton);
		ungoroRarityButtonsPanel.add(ungoroCommonButtonPanel);
		ungoroRarityButtonsPanel.add(ungoroRareButtonPanel);
		ungoroRarityButtonsPanel.add(ungoroEpicButtonPanel);
		ungoroRarityButtonsPanel.add(ungoroLegendaryButtonPanel);
		
		ungoroTotalPanel.add(totalPanelTitleLabel);
		ungoroTotalPanel.add(ungoroTotalCounterPanel);
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
		krakenHeader = new JPanel(new FlowLayout(FlowLayout.CENTER));
		krakenHeader.setBackground(yearsColor);

		JLabel krakenImageLabel = new JLabel(new ImageIcon(krakenImage));
		krakenImageLabel.setBorder(new EmptyBorder(0, 5, 0, 5));

		JLabel krakenLabel = new JLabel(KRAKEN_TITLE);
		krakenLabel.setFont(yearsFont);
		krakenLabel.setBorder(new EmptyBorder(5, 10, 5, 5));
		
		krakenHeader.add(krakenImageLabel);
		krakenHeader.add(krakenLabel);
				
		// "Year of the Kraken" expansions
		createMeanStreetsOfGadgetzanPanel();
		createWhispersOfTheOldGodsPanel();
		
		SwingUtilities.invokeLater(() -> {
			kraken.add(krakenHeader);
			kraken.add(gadgetzan);
			kraken.add(oldGods);
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
		JPanel gadgetzanImagePanel = new JPanel(new GridBagLayout());
		gadgetzanImagePanel.setBackground(gadgetzan.getBackground());
		
		gadgetzanImageButton = new JButton(new ImageIcon(gadgetzanImage));
		gadgetzanImageButton.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 0));
		gadgetzanImageButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		gadgetzanImageButton.setToolTipText(IMAGE_BUTTON_TOOLTIP_TEXT);
		gadgetzanImageButton.setContentAreaFilled(false);
		gadgetzanImageButton.setFocusPainted(false);
		
		gadgetzanImagePanel.add(gadgetzanImageButton);
		
		// Packs without epic panel
		JPanel gadgetzanEpicPanel = new JPanel();
		gadgetzanEpicPanel.setBackground(gadgetzan.getBackground());
		gadgetzanEpicPanel.setLayout(new GridLayout(4, 1));
		
		// Packs without epic panel title
		epicPanelTitleLabel = new JTextPane();
		doc = epicPanelTitleLabel.getStyledDocument();
		changePanelTitleStyle(gadgetzan, epicPanelTitleLabel, EPIC_PANEL_TITLE);
		
		// Packs without epic counter panel
		gadgetzanEpicCounterPanel = new JTextPane();
		doc = gadgetzanEpicCounterPanel.getStyledDocument();
		changePanelTextStyle(gadgetzan, gadgetzanEpicCounterPanel, EPIC_COUNTER_TEXT, gadgetzanEpicCounter);
		
		// Packs without epic counter modify buttons panel
		JPanel gadgetzanEpicModifyPanel = new JPanel();
		
		// Reset button
		gadgetzanEpicReset = new ModifierButton(RESET, headerBGColor, buttonsHoverColor);
		gadgetzanEpicReset.setToolTipText(RESET_BUTTON_TOOLTIP_TEXT);
		gadgetzanEpicReset.setBackground(headerBGColor);
		gadgetzanEpicReset.setForeground(headerTitleColor);
		
		// Blank space between reset and add buttons
		blank = new JLabel();
		blank.setBackground(gadgetzan.getBackground());
		blank.setBorder(new EmptyBorder(0, 20, 0, 20));
		
		// Add button
		gadgetzanEpicAdd = new RoundButton(ADD, headerBGColor, buttonsHoverColor);
		gadgetzanEpicAdd.setBackground(headerBGColor);
		gadgetzanEpicAdd.setForeground(headerTitleColor);
		
		// Increment field
		gadgetzanEpicIncrement = new JTextArea(1, 1);
		gadgetzanEpicIncrement.setDocument(new LimitedIncrement(1));
		gadgetzanEpicIncrement.setBackground(headerBGColor);
		gadgetzanEpicIncrement.setForeground(headerTitleColor);
		gadgetzanEpicIncrement.setCaretColor(headerTitleColor);
		gadgetzanEpicIncrement.setBorder(new EmptyBorder(0, 9, 0, 6));
		
		createModifyButtonsPanel(gadgetzan, gadgetzanEpicModifyPanel, gadgetzanEpicReset, gadgetzanEpicAdd, gadgetzanEpicIncrement);
		
		// Packs without epic probability panel
		gadgetzanEpicProbabilityPanel = new JTextPane();
		doc = gadgetzanEpicProbabilityPanel.getStyledDocument();
		changePanelTextStyle(gadgetzan, gadgetzanEpicProbabilityPanel, EPIC_PROBABILITY_TEXT, gadgetzanEpicProbability);
		
		gadgetzanEpicPanel.add(epicPanelTitleLabel);
		gadgetzanEpicPanel.add(gadgetzanEpicCounterPanel);
		gadgetzanEpicPanel.add(gadgetzanEpicModifyPanel);
		gadgetzanEpicPanel.add(gadgetzanEpicProbabilityPanel);
		
		// Packs without legendary panel
		JPanel gadgetzanLegendaryPanel = new JPanel();
		gadgetzanLegendaryPanel.setBackground(gadgetzan.getBackground());
		gadgetzanLegendaryPanel.setLayout(new GridLayout(4, 1));
		
		// Packs without legendary panel title
		legendaryPanelTitleLabel = new JTextPane();
		doc = legendaryPanelTitleLabel.getStyledDocument();
		changePanelTitleStyle(gadgetzan, legendaryPanelTitleLabel, LEGENDARY_PANEL_TITLE);
		
		// Packs without legendary counter panel
		gadgetzanLegendaryCounterPanel = new JTextPane();
		doc = gadgetzanLegendaryCounterPanel.getStyledDocument();
		changePanelTextStyle(gadgetzan, gadgetzanLegendaryCounterPanel, LEGENDARY_COUNTER_TEXT, gadgetzanLegendaryCounter);
		
		// Packs without legendary counter modify buttons panel
		JPanel gadgetzanLegendaryModifyPanel = new JPanel();
		
		// Reset button
		gadgetzanLegendaryReset = new ModifierButton(RESET, headerBGColor, buttonsHoverColor);
		gadgetzanLegendaryReset.setToolTipText(RESET_BUTTON_TOOLTIP_TEXT);
		gadgetzanLegendaryReset.setBackground(headerBGColor);
		gadgetzanLegendaryReset.setForeground(headerTitleColor);
		
		// Blank space between reset and add buttons
		blank = new JLabel();
		blank.setBackground(gadgetzan.getBackground());
		blank.setBorder(new EmptyBorder(0, 20, 0, 20));
		
		// Add button
		gadgetzanLegendaryAdd = new RoundButton(ADD, headerBGColor, buttonsHoverColor);
		gadgetzanLegendaryAdd.setBackground(headerBGColor);
		gadgetzanLegendaryAdd.setForeground(headerTitleColor);
		
		// Increment field
		gadgetzanLegendaryIncrement = new JTextArea(1, 2);
		gadgetzanLegendaryIncrement.setDocument(new LimitedIncrement(2));
		gadgetzanLegendaryIncrement.setBackground(headerBGColor);
		gadgetzanLegendaryIncrement.setForeground(headerTitleColor);
		gadgetzanLegendaryIncrement.setCaretColor(headerTitleColor);
		gadgetzanLegendaryIncrement.setBorder(new EmptyBorder(0, 9, 0, 3));
		
		createModifyButtonsPanel(gadgetzan, gadgetzanLegendaryModifyPanel, gadgetzanLegendaryReset, gadgetzanLegendaryAdd, gadgetzanLegendaryIncrement);
		
		// Packs without legendary probability panel
		gadgetzanLegendaryProbabilityPanel = new JTextPane();
		doc = gadgetzanLegendaryProbabilityPanel.getStyledDocument();
		changePanelTextStyle(gadgetzan, gadgetzanLegendaryProbabilityPanel, LEGENDARY_PROBABILITY_TEXT, gadgetzanLegendaryProbability);
		
		gadgetzanLegendaryPanel.add(legendaryPanelTitleLabel);
		gadgetzanLegendaryPanel.add(gadgetzanLegendaryCounterPanel);
		gadgetzanLegendaryPanel.add(gadgetzanLegendaryModifyPanel);
		gadgetzanLegendaryPanel.add(gadgetzanLegendaryProbabilityPanel);
		
		// Total amount of packs opened panel
		JPanel gadgetzanTotalPanel = new JPanel();
		gadgetzanTotalPanel.setBackground(gadgetzan.getBackground());
		gadgetzanTotalPanel.setLayout(new GridLayout(4, 1));
		
		// Total amount of packs opened panel title
		totalPanelTitleLabel = new JTextPane();
		doc = totalPanelTitleLabel.getStyledDocument();
		changePanelTitleStyle(gadgetzan, totalPanelTitleLabel,TOTAL_PANEL_TITLE);
		
		// Total amount of packs opened counter panel
		gadgetzanTotalCounterPanel = new JTextPane();
		doc = gadgetzanTotalCounterPanel.getStyledDocument();
		changePanelTextStyle(gadgetzan, gadgetzanTotalCounterPanel, TOTAL_COUNTER_TEXT, gadgetzanTotalCounter);
		
		// Total amount of packs opened counter modify buttons panel
		JPanel gadgetzanTotalModifyPanel = new JPanel();
		
		// Modify button
		gadgetzanTotalModify = new ModifierButton(MODIFY, headerBGColor, buttonsHoverColor);
		gadgetzanTotalModify.setToolTipText(MODIFY_BUTTON_TOOLTIP_TEXT);
		gadgetzanTotalModify.setBackground(headerBGColor);
		gadgetzanTotalModify.setForeground(headerTitleColor);
		
		// Blank space between modify and add buttons
		blank = new JLabel();
		blank.setBackground(gadgetzan.getBackground());
		blank.setBorder(new EmptyBorder(0, 5, 0, 5));
		
		// Add button
		gadgetzanTotalAdd = new RoundButton(ADD, headerBGColor, buttonsHoverColor);
		gadgetzanTotalAdd.setBackground(headerBGColor);
		gadgetzanTotalAdd.setForeground(headerTitleColor);
		
		// Increment field
		gadgetzanTotalIncrement = new JTextArea(1, 3);
		gadgetzanTotalIncrement.setDocument(new LimitedIncrement(3));
		gadgetzanTotalIncrement.setBackground(headerBGColor);
		gadgetzanTotalIncrement.setForeground(headerTitleColor);
		gadgetzanTotalIncrement.setCaretColor(headerTitleColor);
		gadgetzanTotalIncrement.setBorder(new EmptyBorder(0, 9, 0, 0));
		
		createModifyButtonsPanel(gadgetzan, gadgetzanTotalModifyPanel, gadgetzanTotalModify, gadgetzanTotalAdd, gadgetzanTotalIncrement);
		
		// Common button
		JPanel gadgetzanCommonButtonPanel = new JPanel(new GridBagLayout());
		gadgetzanCommonButton = new IconButton(new ImageIcon(commonButtonIcon), new ImageIcon(commonButtonHoverIcon));
		
		// Rare button
		JPanel gadgetzanRareButtonPanel = new JPanel(new GridBagLayout());
		gadgetzanRareButton = new IconButton(new ImageIcon(rareButtonIcon), new ImageIcon(rareButtonHoverIcon));
		
		// Epic button
		JPanel gadgetzanEpicButtonPanel = new JPanel(new GridBagLayout());
		gadgetzanEpicButton = new IconButton(new ImageIcon(epicButtonIcon), new ImageIcon(epicButtonHoverIcon));
		
		// Legendary button
		JPanel gadgetzanLegendaryButtonPanel = new JPanel(new GridBagLayout());
		gadgetzanLegendaryButton = new IconButton(new ImageIcon(legendaryButtonIcon), new ImageIcon(legendaryButtonHoverIcon));
		
		// Rarity buttons panel
		JPanel gadgetzanRarityButtonsPanel = new JPanel();
		gadgetzanRarityButtonsPanel.setBackground(gadgetzan.getBackground());
		gadgetzanRarityButtonsPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 25, 0));
		createCommonButtonPanel(gadgetzan, gadgetzanCommonButtonPanel, gadgetzanCommonButton);
		createRareButtonPanel(gadgetzan, gadgetzanRareButtonPanel, gadgetzanRareButton);
		createEpicButtonPanel(gadgetzan, gadgetzanEpicButtonPanel, gadgetzanEpicButton);
		createLegendaryButtonPanel(gadgetzan, gadgetzanLegendaryButtonPanel, gadgetzanLegendaryButton);
		gadgetzanRarityButtonsPanel.add(gadgetzanCommonButtonPanel);
		gadgetzanRarityButtonsPanel.add(gadgetzanRareButtonPanel);
		gadgetzanRarityButtonsPanel.add(gadgetzanEpicButtonPanel);
		gadgetzanRarityButtonsPanel.add(gadgetzanLegendaryButtonPanel);
		
		gadgetzanTotalPanel.add(totalPanelTitleLabel);
		gadgetzanTotalPanel.add(gadgetzanTotalCounterPanel);
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
		JPanel oldGodsImagePanel = new JPanel(new GridBagLayout());
		oldGodsImagePanel.setBackground(oldGods.getBackground());
		
		oldGodsImageButton = new JButton(new ImageIcon(oldGodsImage));
		oldGodsImageButton.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 0));
		oldGodsImageButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		oldGodsImageButton.setToolTipText(IMAGE_BUTTON_TOOLTIP_TEXT);
		oldGodsImageButton.setContentAreaFilled(false);
		oldGodsImageButton.setFocusPainted(false);
		
		oldGodsImagePanel.add(oldGodsImageButton);
		
		// Packs without epic panel
		JPanel oldGodsEpicPanel = new JPanel();
		oldGodsEpicPanel.setBackground(oldGods.getBackground());
		oldGodsEpicPanel.setLayout(new GridLayout(4, 1));
		
		// Packs without epic panel title
		epicPanelTitleLabel = new JTextPane();
		doc = epicPanelTitleLabel.getStyledDocument();
		changePanelTitleStyle(oldGods, epicPanelTitleLabel, EPIC_PANEL_TITLE);
		
		// Packs without epic counter panel
		oldGodsEpicCounterPanel = new JTextPane();
		doc = oldGodsEpicCounterPanel.getStyledDocument();
		changePanelTextStyle(oldGods, oldGodsEpicCounterPanel, EPIC_COUNTER_TEXT, oldGodsEpicCounter);
		
		// Packs without epic counter modify buttons panel
		JPanel oldGodsEpicModifyPanel = new JPanel();
		
		// Reset button
		oldGodsEpicReset = new ModifierButton(RESET, headerBGColor, buttonsHoverColor);
		oldGodsEpicReset.setToolTipText(RESET_BUTTON_TOOLTIP_TEXT);
		oldGodsEpicReset.setBackground(headerBGColor);
		oldGodsEpicReset.setForeground(headerTitleColor);
		
		// Blank space between reset and add buttons
		blank = new JLabel();
		blank.setBackground(oldGods.getBackground());
		blank.setBorder(new EmptyBorder(0, 20, 0, 20));
		
		// Add button
		oldGodsEpicAdd = new RoundButton(ADD, headerBGColor, buttonsHoverColor);
		oldGodsEpicAdd.setBackground(headerBGColor);
		oldGodsEpicAdd.setForeground(headerTitleColor);
		
		// Increment field
		oldGodsEpicIncrement = new JTextArea(1, 1);
		oldGodsEpicIncrement.setDocument(new LimitedIncrement(1));
		oldGodsEpicIncrement.setBackground(headerBGColor);
		oldGodsEpicIncrement.setForeground(headerTitleColor);
		oldGodsEpicIncrement.setCaretColor(headerTitleColor);
		oldGodsEpicIncrement.setBorder(new EmptyBorder(0, 9, 0, 6));
		
		createModifyButtonsPanel(oldGods, oldGodsEpicModifyPanel, oldGodsEpicReset, oldGodsEpicAdd, oldGodsEpicIncrement);
		
		// Packs without epic probability panel
		oldGodsEpicProbabilityPanel = new JTextPane();
		doc = oldGodsEpicProbabilityPanel.getStyledDocument();
		changePanelTextStyle(oldGods, oldGodsEpicProbabilityPanel, EPIC_PROBABILITY_TEXT, oldGodsEpicProbability);
		
		oldGodsEpicPanel.add(epicPanelTitleLabel);
		oldGodsEpicPanel.add(oldGodsEpicCounterPanel);
		oldGodsEpicPanel.add(oldGodsEpicModifyPanel);
		oldGodsEpicPanel.add(oldGodsEpicProbabilityPanel);
		
		// Packs without legendary panel
		JPanel oldGodsLegendaryPanel = new JPanel();
		oldGodsLegendaryPanel.setBackground(oldGods.getBackground());
		oldGodsLegendaryPanel.setLayout(new GridLayout(4, 1));
		
		// Packs without legendary panel title
		legendaryPanelTitleLabel = new JTextPane();
		doc = legendaryPanelTitleLabel.getStyledDocument();
		changePanelTitleStyle(oldGods, legendaryPanelTitleLabel, LEGENDARY_PANEL_TITLE);
		
		// Packs without legendary counter panel
		oldGodsLegendaryCounterPanel = new JTextPane();
		doc = oldGodsLegendaryCounterPanel.getStyledDocument();
		changePanelTextStyle(oldGods, oldGodsLegendaryCounterPanel, LEGENDARY_COUNTER_TEXT, oldGodsLegendaryCounter);
		
		// Packs without legendary counter modify buttons panel
		JPanel oldGodsLegendaryModifyPanel = new JPanel();
		
		// Reset button
		oldGodsLegendaryReset = new ModifierButton(RESET, headerBGColor, buttonsHoverColor);
		oldGodsLegendaryReset.setToolTipText(RESET_BUTTON_TOOLTIP_TEXT);
		oldGodsLegendaryReset.setBackground(headerBGColor);
		oldGodsLegendaryReset.setForeground(headerTitleColor);
		
		// Blank space between reset and add buttons
		blank = new JLabel();
		blank.setBackground(oldGods.getBackground());
		blank.setBorder(new EmptyBorder(0, 20, 0, 20));
		
		// Add button
		oldGodsLegendaryAdd = new RoundButton(ADD, headerBGColor, buttonsHoverColor);
		oldGodsLegendaryAdd.setBackground(headerBGColor);
		oldGodsLegendaryAdd.setForeground(headerTitleColor);
		
		// Increment field
		oldGodsLegendaryIncrement = new JTextArea(1, 2);
		oldGodsLegendaryIncrement.setDocument(new LimitedIncrement(2));
		oldGodsLegendaryIncrement.setBackground(headerBGColor);
		oldGodsLegendaryIncrement.setForeground(headerTitleColor);
		oldGodsLegendaryIncrement.setCaretColor(headerTitleColor);
		oldGodsLegendaryIncrement.setBorder(new EmptyBorder(0, 9, 0, 3));
		
		createModifyButtonsPanel(oldGods, oldGodsLegendaryModifyPanel, oldGodsLegendaryReset, oldGodsLegendaryAdd, oldGodsLegendaryIncrement);
		
		// Packs without legendary probability panel
		oldGodsLegendaryProbabilityPanel = new JTextPane();
		doc = oldGodsLegendaryProbabilityPanel.getStyledDocument();
		changePanelTextStyle(oldGods, oldGodsLegendaryProbabilityPanel, LEGENDARY_PROBABILITY_TEXT, oldGodsLegendaryProbability);
		
		oldGodsLegendaryPanel.add(legendaryPanelTitleLabel);
		oldGodsLegendaryPanel.add(oldGodsLegendaryCounterPanel);
		oldGodsLegendaryPanel.add(oldGodsLegendaryModifyPanel);
		oldGodsLegendaryPanel.add(oldGodsLegendaryProbabilityPanel);
		
		// Total amount of packs opened panel
		JPanel oldGodsTotalPanel = new JPanel();
		oldGodsTotalPanel.setBackground(oldGods.getBackground());
		oldGodsTotalPanel.setLayout(new GridLayout(4, 1));
		
		// Total amount of packs opened panel title
		totalPanelTitleLabel = new JTextPane();
		doc = totalPanelTitleLabel.getStyledDocument();
		changePanelTitleStyle(oldGods, totalPanelTitleLabel,TOTAL_PANEL_TITLE);
		
		// Total amount of packs opened counter panel
		oldGodsTotalCounterPanel = new JTextPane();
		doc = oldGodsTotalCounterPanel.getStyledDocument();
		changePanelTextStyle(oldGods, oldGodsTotalCounterPanel, TOTAL_COUNTER_TEXT, oldGodsTotalCounter);
		
		// Total amount of packs opened counter modify buttons panel
		JPanel oldGodsTotalModifyPanel = new JPanel();
		
		// Modify button
		oldGodsTotalModify = new ModifierButton(MODIFY, headerBGColor, buttonsHoverColor);
		oldGodsTotalModify.setToolTipText(MODIFY_BUTTON_TOOLTIP_TEXT);
		oldGodsTotalModify.setBackground(headerBGColor);
		oldGodsTotalModify.setForeground(headerTitleColor);
		
		// Blank space between modify and add buttons
		blank = new JLabel();
		blank.setBackground(oldGods.getBackground());
		blank.setBorder(new EmptyBorder(0, 5, 0, 5));
		
		// Add button
		oldGodsTotalAdd = new RoundButton(ADD, headerBGColor, buttonsHoverColor);
		oldGodsTotalAdd.setBackground(headerBGColor);
		oldGodsTotalAdd.setForeground(headerTitleColor);
		
		// Increment field
		oldGodsTotalIncrement = new JTextArea(1, 3);
		oldGodsTotalIncrement.setDocument(new LimitedIncrement(3));
		oldGodsTotalIncrement.setBackground(headerBGColor);
		oldGodsTotalIncrement.setForeground(headerTitleColor);
		oldGodsTotalIncrement.setCaretColor(headerTitleColor);
		oldGodsTotalIncrement.setBorder(new EmptyBorder(0, 9, 0, 0));
		
		createModifyButtonsPanel(oldGods, oldGodsTotalModifyPanel, oldGodsTotalModify, oldGodsTotalAdd, oldGodsTotalIncrement);
		
		// Common button
		JPanel oldGodsCommonButtonPanel = new JPanel(new GridBagLayout());
		oldGodsCommonButton = new IconButton(new ImageIcon(commonButtonIcon), new ImageIcon(commonButtonHoverIcon));
		
		// Rare button
		JPanel oldGodsRareButtonPanel = new JPanel(new GridBagLayout());
		oldGodsRareButton = new IconButton(new ImageIcon(rareButtonIcon), new ImageIcon(rareButtonHoverIcon));
		
		// Epic button
		JPanel oldGodsEpicButtonPanel = new JPanel(new GridBagLayout());
		oldGodsEpicButton = new IconButton(new ImageIcon(epicButtonIcon), new ImageIcon(epicButtonHoverIcon));
		
		// Legendary button
		JPanel oldGodsLegendaryButtonPanel = new JPanel(new GridBagLayout());
		oldGodsLegendaryButton = new IconButton(new ImageIcon(legendaryButtonIcon), new ImageIcon(legendaryButtonHoverIcon));
		
		// Rarity buttons panel
		JPanel oldGodsRarityButtonsPanel = new JPanel();
		oldGodsRarityButtonsPanel.setBackground(oldGods.getBackground());
		oldGodsRarityButtonsPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 25, 0));
		createCommonButtonPanel(oldGods, oldGodsCommonButtonPanel, oldGodsCommonButton);
		createRareButtonPanel(oldGods, oldGodsRareButtonPanel, oldGodsRareButton);
		createEpicButtonPanel(oldGods, oldGodsEpicButtonPanel, oldGodsEpicButton);
		createLegendaryButtonPanel(oldGods, oldGodsLegendaryButtonPanel, oldGodsLegendaryButton);
		oldGodsRarityButtonsPanel.add(oldGodsCommonButtonPanel);
		oldGodsRarityButtonsPanel.add(oldGodsRareButtonPanel);
		oldGodsRarityButtonsPanel.add(oldGodsEpicButtonPanel);
		oldGodsRarityButtonsPanel.add(oldGodsLegendaryButtonPanel);
		
		oldGodsTotalPanel.add(totalPanelTitleLabel);
		oldGodsTotalPanel.add(oldGodsTotalCounterPanel);
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
		classicSetsHeader = new JPanel(new FlowLayout(FlowLayout.CENTER));
		classicSetsHeader.setBackground(yearsColor);

		JLabel classicSetsImageLabel = new JLabel(new ImageIcon(classicSetsImage));
		classicSetsImageLabel.setBorder(new EmptyBorder(0, 5, 0, 5));

		JLabel classicSetsLabel = new JLabel(CLASSICSETS_TITLE);
		classicSetsLabel.setFont(yearsFont);
		classicSetsLabel.setBorder(new EmptyBorder(5, 10, 5, 5));
		
		classicSetsHeader.add(classicSetsImageLabel);
		classicSetsHeader.add(classicSetsLabel);
				
		// "Classic Sets" expansions
		createTheGrandTournamentPanel();
		createGoblinsVsGnomesPanel();
		createClassicPanel();
		
		SwingUtilities.invokeLater(() -> {
			classicSets.add(classicSetsHeader);
			classicSets.add(tournament);
			classicSets.add(goblins);
			classicSets.add(classic);
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
		JPanel tournamentImagePanel = new JPanel(new GridBagLayout());
		tournamentImagePanel.setBackground(tournament.getBackground());
		
		tournamentImageButton = new JButton(new ImageIcon(tournamentImage));
		tournamentImageButton.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 0));
		tournamentImageButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		tournamentImageButton.setToolTipText(IMAGE_BUTTON_TOOLTIP_TEXT);
		tournamentImageButton.setContentAreaFilled(false);
		tournamentImageButton.setFocusPainted(false);
		
		tournamentImagePanel.add(tournamentImageButton);
		
		// Packs without epic panel
		JPanel tournamentEpicPanel = new JPanel();
		tournamentEpicPanel.setBackground(tournament.getBackground());
		tournamentEpicPanel.setLayout(new GridLayout(4, 1));
		
		// Packs without epic panel title
		epicPanelTitleLabel = new JTextPane();
		doc = epicPanelTitleLabel.getStyledDocument();
		changePanelTitleStyle(tournament, epicPanelTitleLabel, EPIC_PANEL_TITLE);
		epicPanelTitleLabel.setForeground(headerTitleColor);
		
		// Packs without epic counter panel
		tournamentEpicCounterPanel = new JTextPane();
		doc = tournamentEpicCounterPanel.getStyledDocument();
		changePanelTextStyle(tournament, tournamentEpicCounterPanel, EPIC_COUNTER_TEXT, tournamentEpicCounter);
		tournamentEpicCounterPanel.setForeground(headerTitleColor);
		
		// Packs without epic counter modify buttons panel
		JPanel tournamentEpicModifyPanel = new JPanel();
		
		// Reset button
		tournamentEpicReset = new ModifierButton(RESET, headerTitleColor, buttonsDarkHoverColor);
		tournamentEpicReset.setToolTipText(RESET_BUTTON_TOOLTIP_TEXT);
		tournamentEpicReset.setBackground(headerTitleColor);
		
		// Blank space between reset and add buttons
		blank = new JLabel();
		blank.setBackground(tournament.getBackground());
		blank.setBorder(new EmptyBorder(0, 20, 0, 20));
		
		// Add button
		tournamentEpicAdd = new RoundButton(ADD, headerTitleColor, buttonsDarkHoverColor);
		tournamentEpicAdd.setBackground(headerTitleColor);
		
		// Increment field
		tournamentEpicIncrement = new JTextArea(1, 1);
		tournamentEpicIncrement.setDocument(new LimitedIncrement(1));
		tournamentEpicIncrement.setBackground(headerTitleColor);
		tournamentEpicIncrement.setBorder(new EmptyBorder(0, 9, 0, 6));
		
		createModifyButtonsPanel(tournament, tournamentEpicModifyPanel, tournamentEpicReset, tournamentEpicAdd, tournamentEpicIncrement);
		
		// Packs without epic probability panel
		tournamentEpicProbabilityPanel = new JTextPane();
		doc = tournamentEpicProbabilityPanel.getStyledDocument();
		changePanelTextStyle(tournament, tournamentEpicProbabilityPanel, EPIC_PROBABILITY_TEXT, tournamentEpicProbability);
		tournamentEpicProbabilityPanel.setForeground(headerTitleColor);
		
		tournamentEpicPanel.add(epicPanelTitleLabel);
		tournamentEpicPanel.add(tournamentEpicCounterPanel);
		tournamentEpicPanel.add(tournamentEpicModifyPanel);
		tournamentEpicPanel.add(tournamentEpicProbabilityPanel);
		
		// Packs without legendary panel
		JPanel tournamentLegendaryPanel = new JPanel();
		tournamentLegendaryPanel.setBackground(tournament.getBackground());
		tournamentLegendaryPanel.setLayout(new GridLayout(4, 1));
		
		// Packs without legendary panel title
		legendaryPanelTitleLabel = new JTextPane();
		doc = legendaryPanelTitleLabel.getStyledDocument();
		changePanelTitleStyle(tournament, legendaryPanelTitleLabel, LEGENDARY_PANEL_TITLE);
		legendaryPanelTitleLabel.setForeground(headerTitleColor);
		
		// Packs without legendary counter panel
		tournamentLegendaryCounterPanel = new JTextPane();
		doc = tournamentLegendaryCounterPanel.getStyledDocument();
		changePanelTextStyle(tournament, tournamentLegendaryCounterPanel, LEGENDARY_COUNTER_TEXT, tournamentLegendaryCounter);
		tournamentLegendaryCounterPanel.setForeground(headerTitleColor);
		
		// Packs without legendary counter modify buttons panel
		JPanel tournamentLegendaryModifyPanel = new JPanel();
		
		// Reset button
		tournamentLegendaryReset = new ModifierButton(RESET, headerTitleColor, buttonsDarkHoverColor);
		tournamentLegendaryReset.setToolTipText(RESET_BUTTON_TOOLTIP_TEXT);
		tournamentLegendaryReset.setBackground(headerTitleColor);
		
		// Blank space between reset and add buttons
		blank = new JLabel();
		blank.setBackground(tournament.getBackground());
		blank.setBorder(new EmptyBorder(0, 20, 0, 20));
		
		// Add button
		tournamentLegendaryAdd = new RoundButton(ADD, headerTitleColor, buttonsDarkHoverColor);
		tournamentLegendaryAdd.setBackground(headerTitleColor);
		
		// Increment field
		tournamentLegendaryIncrement = new JTextArea(1, 2);
		tournamentLegendaryIncrement.setDocument(new LimitedIncrement(2));
		tournamentLegendaryIncrement.setBackground(headerTitleColor);
		tournamentLegendaryIncrement.setBorder(new EmptyBorder(0, 9, 0, 3));
		
		createModifyButtonsPanel(tournament, tournamentLegendaryModifyPanel, tournamentLegendaryReset, tournamentLegendaryAdd, tournamentLegendaryIncrement);
		
		// Packs without legendary probability panel
		tournamentLegendaryProbabilityPanel = new JTextPane();
		doc = tournamentLegendaryProbabilityPanel.getStyledDocument();
		changePanelTextStyle(tournament, tournamentLegendaryProbabilityPanel, LEGENDARY_PROBABILITY_TEXT, tournamentLegendaryProbability);
		tournamentLegendaryProbabilityPanel.setForeground(headerTitleColor);
		
		tournamentLegendaryPanel.add(legendaryPanelTitleLabel);
		tournamentLegendaryPanel.add(tournamentLegendaryCounterPanel);
		tournamentLegendaryPanel.add(tournamentLegendaryModifyPanel);
		tournamentLegendaryPanel.add(tournamentLegendaryProbabilityPanel);
		
		// Total amount of packs opened panel
		JPanel tournamentTotalPanel = new JPanel();
		tournamentTotalPanel.setBackground(tournament.getBackground());
		tournamentTotalPanel.setLayout(new GridLayout(4, 1));
		
		// Total amount of packs opened panel title
		totalPanelTitleLabel = new JTextPane();
		doc = totalPanelTitleLabel.getStyledDocument();
		changePanelTitleStyle(tournament, totalPanelTitleLabel,TOTAL_PANEL_TITLE);
		totalPanelTitleLabel.setForeground(headerTitleColor);
		
		// Total amount of packs opened counter panel
		tournamentTotalCounterPanel = new JTextPane();
		doc = tournamentTotalCounterPanel.getStyledDocument();
		changePanelTextStyle(tournament, tournamentTotalCounterPanel, TOTAL_COUNTER_TEXT, tournamentTotalCounter);
		tournamentTotalCounterPanel.setForeground(headerTitleColor);
		
		// Total amount of packs opened counter modify buttons panel
		JPanel tournamentTotalModifyPanel = new JPanel();
		
		// Modify button
		tournamentTotalModify = new ModifierButton(MODIFY, headerTitleColor, buttonsDarkHoverColor);
		tournamentTotalModify.setToolTipText(MODIFY_BUTTON_TOOLTIP_TEXT);
		tournamentTotalModify.setBackground(headerTitleColor);
		
		// Blank space between modify and add buttons
		blank = new JLabel();
		blank.setBackground(tournament.getBackground());
		blank.setBorder(new EmptyBorder(0, 5, 0, 5));
		
		// Add button
		tournamentTotalAdd = new RoundButton(ADD, headerTitleColor, buttonsDarkHoverColor);
		tournamentTotalAdd.setBackground(headerTitleColor);
		
		// Increment field
		tournamentTotalIncrement = new JTextArea(1, 3);
		tournamentTotalIncrement.setDocument(new LimitedIncrement(3));
		tournamentTotalIncrement.setBackground(headerTitleColor);
		tournamentTotalIncrement.setBorder(new EmptyBorder(0, 9, 0, 0));
		
		createModifyButtonsPanel(tournament, tournamentTotalModifyPanel, tournamentTotalModify, tournamentTotalAdd, tournamentTotalIncrement);
		
		// Common button
		JPanel tournamentCommonButtonPanel = new JPanel(new GridBagLayout());
		tournamentCommonButton = new IconButton(new ImageIcon(commonButtonDarkIcon), new ImageIcon(commonButtonDarkHoverIcon));
		
		// Rare button
		JPanel tournamentRareButtonPanel = new JPanel(new GridBagLayout());
		tournamentRareButton = new IconButton(new ImageIcon(rareButtonDarkIcon), new ImageIcon(rareButtonDarkHoverIcon));
		
		// Epic button
		JPanel tournamentEpicButtonPanel = new JPanel(new GridBagLayout());
		tournamentEpicButton = new IconButton(new ImageIcon(epicButtonDarkIcon), new ImageIcon(epicButtonDarkHoverIcon));
		
		// Legendary button
		JPanel tournamentLegendaryButtonPanel = new JPanel(new GridBagLayout());
		tournamentLegendaryButton = new IconButton(new ImageIcon(legendaryButtonDarkIcon), new ImageIcon(legendaryButtonDarkHoverIcon));
		
		// Rarity buttons panel
		JPanel tournamentRarityButtonsPanel = new JPanel();
		tournamentRarityButtonsPanel.setBackground(tournament.getBackground());
		tournamentRarityButtonsPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 25, 0));
		createCommonButtonPanel(tournament, tournamentCommonButtonPanel, tournamentCommonButton);
		createRareButtonPanel(tournament, tournamentRareButtonPanel, tournamentRareButton);
		createEpicButtonPanel(tournament, tournamentEpicButtonPanel, tournamentEpicButton);
		createLegendaryButtonPanel(tournament, tournamentLegendaryButtonPanel, tournamentLegendaryButton);
		tournamentRarityButtonsPanel.add(tournamentCommonButtonPanel);
		tournamentRarityButtonsPanel.add(tournamentRareButtonPanel);
		tournamentRarityButtonsPanel.add(tournamentEpicButtonPanel);
		tournamentRarityButtonsPanel.add(tournamentLegendaryButtonPanel);
		
		tournamentTotalPanel.add(totalPanelTitleLabel);
		tournamentTotalPanel.add(tournamentTotalCounterPanel);
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
		JPanel goblinsImagePanel = new JPanel(new GridBagLayout());
		goblinsImagePanel.setBackground(goblins.getBackground());
		
		goblinsImageButton = new JButton(new ImageIcon(goblinsImage));
		goblinsImageButton.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 0));
		goblinsImageButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		goblinsImageButton.setToolTipText(IMAGE_BUTTON_TOOLTIP_TEXT);
		goblinsImageButton.setContentAreaFilled(false);
		goblinsImageButton.setFocusPainted(false);
		
		goblinsImagePanel.add(goblinsImageButton);
		
		// Packs without epic panel
		JPanel goblinsEpicPanel = new JPanel();
		goblinsEpicPanel.setBackground(goblins.getBackground());
		goblinsEpicPanel.setLayout(new GridLayout(4, 1));
		
		// Packs without epic panel title
		epicPanelTitleLabel = new JTextPane();
		doc = epicPanelTitleLabel.getStyledDocument();
		changePanelTitleStyle(goblins, epicPanelTitleLabel, EPIC_PANEL_TITLE);
		
		// Packs without epic counter panel
		goblinsEpicCounterPanel = new JTextPane();
		doc = goblinsEpicCounterPanel.getStyledDocument();
		changePanelTextStyle(goblins, goblinsEpicCounterPanel, EPIC_COUNTER_TEXT, goblinsEpicCounter);
		
		// Packs without epic counter modify buttons panel
		JPanel goblinsEpicModifyPanel = new JPanel();
		
		// Reset button
		goblinsEpicReset = new ModifierButton(RESET, headerBGColor, buttonsHoverColor);
		goblinsEpicReset.setToolTipText(RESET_BUTTON_TOOLTIP_TEXT);
		goblinsEpicReset.setBackground(headerBGColor);
		goblinsEpicReset.setForeground(headerTitleColor);
		
		// Blank space between reset and add buttons
		blank = new JLabel();
		blank.setBackground(goblins.getBackground());
		blank.setBorder(new EmptyBorder(0, 20, 0, 20));
		
		// Add button
		goblinsEpicAdd = new RoundButton(ADD, headerBGColor, buttonsHoverColor);
		goblinsEpicAdd.setBackground(headerBGColor);
		goblinsEpicAdd.setForeground(headerTitleColor);
		
		// Increment field
		goblinsEpicIncrement = new JTextArea(1, 1);
		goblinsEpicIncrement.setDocument(new LimitedIncrement(1));
		goblinsEpicIncrement.setBackground(headerBGColor);
		goblinsEpicIncrement.setForeground(headerTitleColor);
		goblinsEpicIncrement.setCaretColor(headerTitleColor);
		goblinsEpicIncrement.setBorder(new EmptyBorder(0, 9, 0, 6));
		
		createModifyButtonsPanel(goblins, goblinsEpicModifyPanel, goblinsEpicReset, goblinsEpicAdd, goblinsEpicIncrement);
		
		// Packs without epic probability panel
		goblinsEpicProbabilityPanel = new JTextPane();
		doc = goblinsEpicProbabilityPanel.getStyledDocument();
		changePanelTextStyle(goblins, goblinsEpicProbabilityPanel, EPIC_PROBABILITY_TEXT, goblinsEpicProbability);
		
		goblinsEpicPanel.add(epicPanelTitleLabel);
		goblinsEpicPanel.add(goblinsEpicCounterPanel);
		goblinsEpicPanel.add(goblinsEpicModifyPanel);
		goblinsEpicPanel.add(goblinsEpicProbabilityPanel);
		
		// Packs without legendary panel
		JPanel goblinsLegendaryPanel = new JPanel();
		goblinsLegendaryPanel.setBackground(goblins.getBackground());
		goblinsLegendaryPanel.setLayout(new GridLayout(4, 1));
		
		// Packs without legendary panel title
		legendaryPanelTitleLabel = new JTextPane();
		doc = legendaryPanelTitleLabel.getStyledDocument();
		changePanelTitleStyle(goblins, legendaryPanelTitleLabel, LEGENDARY_PANEL_TITLE);
		
		// Packs without legendary counter panel
		goblinsLegendaryCounterPanel = new JTextPane();
		doc = goblinsLegendaryCounterPanel.getStyledDocument();
		changePanelTextStyle(goblins, goblinsLegendaryCounterPanel, LEGENDARY_COUNTER_TEXT, goblinsLegendaryCounter);
		
		// Packs without legendary counter modify buttons panel
		JPanel goblinsLegendaryModifyPanel = new JPanel();
		
		// Reset button
		goblinsLegendaryReset = new ModifierButton(RESET, headerBGColor, buttonsHoverColor);
		goblinsLegendaryReset.setToolTipText(RESET_BUTTON_TOOLTIP_TEXT);
		goblinsLegendaryReset.setBackground(headerBGColor);
		goblinsLegendaryReset.setForeground(headerTitleColor);
		
		// Blank space between reset and add buttons
		blank = new JLabel();
		blank.setBackground(goblins.getBackground());
		blank.setBorder(new EmptyBorder(0, 20, 0, 20));
		
		// Add button
		goblinsLegendaryAdd = new RoundButton(ADD, headerBGColor, buttonsHoverColor);
		goblinsLegendaryAdd.setBackground(headerBGColor);
		goblinsLegendaryAdd.setForeground(headerTitleColor);
		
		// Increment field
		goblinsLegendaryIncrement = new JTextArea(1, 2);
		goblinsLegendaryIncrement.setDocument(new LimitedIncrement(2));
		goblinsLegendaryIncrement.setBackground(headerBGColor);
		goblinsLegendaryIncrement.setForeground(headerTitleColor);
		goblinsLegendaryIncrement.setCaretColor(headerTitleColor);
		goblinsLegendaryIncrement.setBorder(new EmptyBorder(0, 9, 0, 3));
		
		createModifyButtonsPanel(goblins, goblinsLegendaryModifyPanel, goblinsLegendaryReset, goblinsLegendaryAdd, goblinsLegendaryIncrement);
		
		// Packs without legendary probability panel
		goblinsLegendaryProbabilityPanel = new JTextPane();
		doc = goblinsLegendaryProbabilityPanel.getStyledDocument();
		changePanelTextStyle(goblins, goblinsLegendaryProbabilityPanel, LEGENDARY_PROBABILITY_TEXT, goblinsLegendaryProbability);
		
		goblinsLegendaryPanel.add(legendaryPanelTitleLabel);
		goblinsLegendaryPanel.add(goblinsLegendaryCounterPanel);
		goblinsLegendaryPanel.add(goblinsLegendaryModifyPanel);
		goblinsLegendaryPanel.add(goblinsLegendaryProbabilityPanel);
		
		// Total amount of packs opened panel
		JPanel goblinsTotalPanel = new JPanel();
		goblinsTotalPanel.setBackground(goblins.getBackground());
		goblinsTotalPanel.setLayout(new GridLayout(4, 1));
		
		// Total amount of packs opened panel title
		totalPanelTitleLabel = new JTextPane();
		doc = totalPanelTitleLabel.getStyledDocument();
		changePanelTitleStyle(goblins, totalPanelTitleLabel,TOTAL_PANEL_TITLE);
		
		// Total amount of packs opened counter panel
		goblinsTotalCounterPanel = new JTextPane();
		doc = goblinsTotalCounterPanel.getStyledDocument();
		changePanelTextStyle(goblins, goblinsTotalCounterPanel, TOTAL_COUNTER_TEXT, goblinsTotalCounter);
		
		// Total amount of packs opened counter modify buttons panel
		JPanel goblinsTotalModifyPanel = new JPanel();
		
		// Modify button
		goblinsTotalModify = new ModifierButton(MODIFY, headerBGColor, buttonsHoverColor);
		goblinsTotalModify.setToolTipText(MODIFY_BUTTON_TOOLTIP_TEXT);
		goblinsTotalModify.setBackground(headerBGColor);
		goblinsTotalModify.setForeground(headerTitleColor);
		
		// Blank space between modify and add buttons
		blank = new JLabel();
		blank.setBackground(goblins.getBackground());
		blank.setBorder(new EmptyBorder(0, 5, 0, 5));
		
		// Add button
		goblinsTotalAdd = new RoundButton(ADD, headerBGColor, buttonsHoverColor);
		goblinsTotalAdd.setBackground(headerBGColor);
		goblinsTotalAdd.setForeground(headerTitleColor);
		
		// Increment field
		goblinsTotalIncrement = new JTextArea(1, 3);
		goblinsTotalIncrement.setDocument(new LimitedIncrement(3));
		goblinsTotalIncrement.setBackground(headerBGColor);
		goblinsTotalIncrement.setForeground(headerTitleColor);
		goblinsTotalIncrement.setCaretColor(headerTitleColor);
		goblinsTotalIncrement.setBorder(new EmptyBorder(0, 9, 0, 0));
		
		createModifyButtonsPanel(goblins, goblinsTotalModifyPanel, goblinsTotalModify, goblinsTotalAdd, goblinsTotalIncrement);
		
		// Common button
		JPanel goblinsCommonButtonPanel = new JPanel(new GridBagLayout());
		goblinsCommonButton = new IconButton(new ImageIcon(commonButtonIcon), new ImageIcon(commonButtonHoverIcon));
		
		// Rare button
		JPanel goblinsRareButtonPanel = new JPanel(new GridBagLayout());
		goblinsRareButton = new IconButton(new ImageIcon(rareButtonIcon), new ImageIcon(rareButtonHoverIcon));
		
		// Epic button
		JPanel goblinsEpicButtonPanel = new JPanel(new GridBagLayout());
		goblinsEpicButton = new IconButton(new ImageIcon(epicButtonIcon), new ImageIcon(epicButtonHoverIcon));
		
		// Legendary button
		JPanel goblinsLegendaryButtonPanel = new JPanel(new GridBagLayout());
		goblinsLegendaryButton = new IconButton(new ImageIcon(legendaryButtonIcon), new ImageIcon(legendaryButtonHoverIcon));
		
		// Rarity buttons panel
		JPanel goblinsRarityButtonsPanel = new JPanel();
		goblinsRarityButtonsPanel.setBackground(goblins.getBackground());
		goblinsRarityButtonsPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 25, 0));
		createCommonButtonPanel(goblins, goblinsCommonButtonPanel, goblinsCommonButton);
		createRareButtonPanel(goblins, goblinsRareButtonPanel, goblinsRareButton);
		createEpicButtonPanel(goblins, goblinsEpicButtonPanel, goblinsEpicButton);
		createLegendaryButtonPanel(goblins, goblinsLegendaryButtonPanel, goblinsLegendaryButton);
		goblinsRarityButtonsPanel.add(goblinsCommonButtonPanel);
		goblinsRarityButtonsPanel.add(goblinsRareButtonPanel);
		goblinsRarityButtonsPanel.add(goblinsEpicButtonPanel);
		goblinsRarityButtonsPanel.add(goblinsLegendaryButtonPanel);
		
		goblinsTotalPanel.add(totalPanelTitleLabel);
		goblinsTotalPanel.add(goblinsTotalCounterPanel);
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
		JPanel classicImagePanel = new JPanel(new GridBagLayout());
		classicImagePanel.setBackground(classic.getBackground());

		classicImageLabel = new JLabel(new ImageIcon(classicImage));
		
		classicImagePanel.add(classicImageLabel);
		
		// Packs without epic panel
		JPanel classicEpicPanel = new JPanel();
		classicEpicPanel.setBackground(classic.getBackground());
		classicEpicPanel.setLayout(new GridLayout(4, 1));
		
		// Packs without epic panel title
		epicPanelTitleLabel = new JTextPane();
		doc = epicPanelTitleLabel.getStyledDocument();
		changePanelTitleStyle(classic, epicPanelTitleLabel, EPIC_PANEL_TITLE);
		
		// Packs without epic counter panel
		classicEpicCounterPanel = new JTextPane();
		doc = classicEpicCounterPanel.getStyledDocument();
		changePanelTextStyle(classic, classicEpicCounterPanel, EPIC_COUNTER_TEXT, classicEpicCounter);
		
		// Packs without epic counter modify buttons panel
		JPanel classicEpicModifyPanel = new JPanel();
		
		// Reset button
		classicEpicReset = new ModifierButton(RESET, headerBGColor, buttonsHoverColor);
		classicEpicReset.setToolTipText(RESET_BUTTON_TOOLTIP_TEXT);
		classicEpicReset.setBackground(headerBGColor);
		classicEpicReset.setForeground(headerTitleColor);
		
		// Blank space between reset and add buttons
		blank = new JLabel();
		blank.setBackground(classic.getBackground());
		blank.setBorder(new EmptyBorder(0, 20, 0, 20));
		
		// Add button
		classicEpicAdd = new RoundButton(ADD, headerBGColor, buttonsHoverColor);
		classicEpicAdd.setBackground(headerBGColor);
		classicEpicAdd.setForeground(headerTitleColor);
		
		// Increment field
		classicEpicIncrement = new JTextArea(1, 1);
		classicEpicIncrement.setDocument(new LimitedIncrement(1));
		classicEpicIncrement.setBackground(headerBGColor);
		classicEpicIncrement.setForeground(headerTitleColor);
		classicEpicIncrement.setCaretColor(headerTitleColor);
		classicEpicIncrement.setBorder(new EmptyBorder(0, 9, 0, 6));
		
		createModifyButtonsPanel(classic, classicEpicModifyPanel, classicEpicReset, classicEpicAdd, classicEpicIncrement);
		
		// Packs without epic probability panel
		classicEpicProbabilityPanel = new JTextPane();
		doc = classicEpicProbabilityPanel.getStyledDocument();
		changePanelTextStyle(classic, classicEpicProbabilityPanel, EPIC_PROBABILITY_TEXT, classicEpicProbability);
		
		classicEpicPanel.add(epicPanelTitleLabel);
		classicEpicPanel.add(classicEpicCounterPanel);
		classicEpicPanel.add(classicEpicModifyPanel);
		classicEpicPanel.add(classicEpicProbabilityPanel);
		
		// Packs without legendary panel
		JPanel classicLegendaryPanel = new JPanel();
		classicLegendaryPanel.setBackground(classic.getBackground());
		classicLegendaryPanel.setLayout(new GridLayout(4, 1));
		
		// Packs without legendary panel title
		legendaryPanelTitleLabel = new JTextPane();
		doc = legendaryPanelTitleLabel.getStyledDocument();
		changePanelTitleStyle(classic, legendaryPanelTitleLabel, LEGENDARY_PANEL_TITLE);
		
		// Packs without legendary counter panel
		classicLegendaryCounterPanel = new JTextPane();
		doc = classicLegendaryCounterPanel.getStyledDocument();
		changePanelTextStyle(classic, classicLegendaryCounterPanel, LEGENDARY_COUNTER_TEXT, classicLegendaryCounter);
		
		// Packs without legendary counter modify buttons panel
		JPanel classicLegendaryModifyPanel = new JPanel();
		
		// Reset button
		classicLegendaryReset = new ModifierButton(RESET, headerBGColor, buttonsHoverColor);
		classicLegendaryReset.setToolTipText(RESET_BUTTON_TOOLTIP_TEXT);
		classicLegendaryReset.setBackground(headerBGColor);
		classicLegendaryReset.setForeground(headerTitleColor);
		
		// Blank space between reset and add buttons
		blank = new JLabel();
		blank.setBackground(classic.getBackground());
		blank.setBorder(new EmptyBorder(0, 20, 0, 20));
		
		// Add button
		classicLegendaryAdd = new RoundButton(ADD, headerBGColor, buttonsHoverColor);
		classicLegendaryAdd.setBackground(headerBGColor);
		classicLegendaryAdd.setForeground(headerTitleColor);
		
		// Increment field
		classicLegendaryIncrement = new JTextArea(1, 2);
		classicLegendaryIncrement.setDocument(new LimitedIncrement(2));
		classicLegendaryIncrement.setBackground(headerBGColor);
		classicLegendaryIncrement.setForeground(headerTitleColor);
		classicLegendaryIncrement.setCaretColor(headerTitleColor);
		classicLegendaryIncrement.setBorder(new EmptyBorder(0, 9, 0, 3));
		
		createModifyButtonsPanel(classic, classicLegendaryModifyPanel, classicLegendaryReset, classicLegendaryAdd, classicLegendaryIncrement);
		
		// Packs without legendary probability panel
		classicLegendaryProbabilityPanel = new JTextPane();
		doc = classicLegendaryProbabilityPanel.getStyledDocument();
		changePanelTextStyle(classic, classicLegendaryProbabilityPanel, LEGENDARY_PROBABILITY_TEXT, classicLegendaryProbability);
		
		classicLegendaryPanel.add(legendaryPanelTitleLabel);
		classicLegendaryPanel.add(classicLegendaryCounterPanel);
		classicLegendaryPanel.add(classicLegendaryModifyPanel);
		classicLegendaryPanel.add(classicLegendaryProbabilityPanel);
		
		// Total amount of packs opened panel
		JPanel classicTotalPanel = new JPanel();
		classicTotalPanel.setBackground(classic.getBackground());
		classicTotalPanel.setLayout(new GridLayout(4, 1));
		
		// Total amount of packs opened panel title
		totalPanelTitleLabel = new JTextPane();
		doc = totalPanelTitleLabel.getStyledDocument();
		changePanelTitleStyle(classic, totalPanelTitleLabel,TOTAL_PANEL_TITLE);
		
		// Total amount of packs opened counter panel
		classicTotalCounterPanel = new JTextPane();
		doc = classicTotalCounterPanel.getStyledDocument();
		changePanelTextStyle(classic, classicTotalCounterPanel, TOTAL_COUNTER_TEXT, classicTotalCounter);
		
		// Total amount of packs opened counter modify buttons panel
		JPanel classicTotalModifyPanel = new JPanel();
		
		// Modify button
		classicTotalModify = new ModifierButton(MODIFY, headerBGColor, buttonsHoverColor);
		classicTotalModify.setToolTipText(MODIFY_BUTTON_TOOLTIP_TEXT);
		classicTotalModify.setBackground(headerBGColor);
		classicTotalModify.setForeground(headerTitleColor);
		
		// Blank space between modify and add buttons
		blank = new JLabel();
		blank.setBackground(classic.getBackground());
		blank.setBorder(new EmptyBorder(0, 5, 0, 5));
		
		// Add button
		classicTotalAdd = new RoundButton(ADD, headerBGColor, buttonsHoverColor);
		classicTotalAdd.setBackground(headerBGColor);
		classicTotalAdd.setForeground(headerTitleColor);
		
		// Increment field
		classicTotalIncrement = new JTextArea(1, 3);
		classicTotalIncrement.setDocument(new LimitedIncrement(3));
		classicTotalIncrement.setBackground(headerBGColor);
		classicTotalIncrement.setForeground(headerTitleColor);
		classicTotalIncrement.setCaretColor(headerTitleColor);
		classicTotalIncrement.setBorder(new EmptyBorder(0, 9, 0, 0));
		
		createModifyButtonsPanel(classic, classicTotalModifyPanel, classicTotalModify, classicTotalAdd, classicTotalIncrement);
		
		// Common button
		JPanel classicCommonButtonPanel = new JPanel(new GridBagLayout());
		classicCommonButton = new IconButton(new ImageIcon(commonButtonIcon), new ImageIcon(commonButtonHoverIcon));
		
		// Rare button
		JPanel classicRareButtonPanel = new JPanel(new GridBagLayout());
		classicRareButton = new IconButton(new ImageIcon(rareButtonIcon), new ImageIcon(rareButtonHoverIcon));
		
		// Epic button
		JPanel classicEpicButtonPanel = new JPanel(new GridBagLayout());
		classicEpicButton = new IconButton(new ImageIcon(epicButtonIcon), new ImageIcon(epicButtonHoverIcon));
		
		// Legendary button
		JPanel classicLegendaryButtonPanel = new JPanel(new GridBagLayout());
		classicLegendaryButton = new IconButton(new ImageIcon(legendaryButtonIcon), new ImageIcon(legendaryButtonHoverIcon));
		
		// Rarity buttons panel
		JPanel classicRarityButtonsPanel = new JPanel();
		classicRarityButtonsPanel.setBackground(classic.getBackground());
		classicRarityButtonsPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 25, 0));
		createCommonButtonPanel(classic, classicCommonButtonPanel, classicCommonButton);
		createRareButtonPanel(classic, classicRareButtonPanel, classicRareButton);
		createEpicButtonPanel(classic, classicEpicButtonPanel, classicEpicButton);
		createLegendaryButtonPanel(classic, classicLegendaryButtonPanel, classicLegendaryButton);
		classicRarityButtonsPanel.add(classicCommonButtonPanel);
		classicRarityButtonsPanel.add(classicRareButtonPanel);
		classicRarityButtonsPanel.add(classicEpicButtonPanel);
		classicRarityButtonsPanel.add(classicLegendaryButtonPanel);
		
		classicTotalPanel.add(totalPanelTitleLabel);
		classicTotalPanel.add(classicTotalCounterPanel);
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
		addButton.setIcon(new ImageIcon()); // Centers the "+" symbol in the button
		addButton.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 0));
		addButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		addButton.setToolTipText(ADD_BUTTON_TOOLTIP_TEXT);
		addButton.setFont(addButtonTextFont);
		addButton.setFocusPainted(false);
		
		// Increment field
		numField.getDocument().putProperty("filterNewlines", Boolean.TRUE);
		numField.setText("1");
		numField.setFont(incrementFieldFont);
		numField.setToolTipText(INCREMENT_BUTTON_TOOLTIP_TEXT);
		
		modifiersPanel.add(resModButton);
		modifiersPanel.add(blank);
		modifiersPanel.add(addButton);
		modifiersPanel.add(numField);
	}
	
	// Common button panel creator
	private void createCommonButtonPanel(JPanel expansion, JPanel commonPanel, IconButton commonButton) 
	{
		commonPanel.setBackground(expansion.getBackground());
		
		commonButton.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 0));
		commonButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		commonButton.setToolTipText(COMMON_BUTTON_TOOLTIP_TEXT);
		commonButton.setContentAreaFilled(false);
		commonButton.setFocusPainted(false);
		
		commonPanel.add(commonButton);
	}

	// Rare button panel creator
	private void createRareButtonPanel(JPanel expansion, JPanel rarePanel, IconButton rareButton) 
	{
		rarePanel.setBackground(expansion.getBackground());
		
		rareButton.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 0));
		rareButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		rareButton.setToolTipText(RARE_BUTTON_TOOLTIP_TEXT);
		rareButton.setContentAreaFilled(false);
		rareButton.setFocusPainted(false);
		
		rarePanel.add(rareButton);
	}

	// Epic button panel creator
	private void createEpicButtonPanel(JPanel expansion, JPanel epicPanel, IconButton epicButton) 
	{
		epicPanel.setBackground(expansion.getBackground());
		
		epicButton.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 0));
		epicButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		epicButton.setToolTipText(EPIC_BUTTON_TOOLTIP_TEXT);
		epicButton.setContentAreaFilled(false);
		epicButton.setFocusPainted(false);
		
		epicPanel.add(epicButton);
	}

	// Legendary buttons panel creator
	private void createLegendaryButtonPanel(JPanel expansion, JPanel legendaryPanel, IconButton legendaryButton) 
	{
		legendaryPanel.setBackground(expansion.getBackground());
		
		legendaryButton.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 0));
		legendaryButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		legendaryButton.setToolTipText(LEGENDARY_BUTTON_TOOLTIP_TEXT);
		legendaryButton.setContentAreaFilled(false);
		legendaryButton.setFocusPainted(false);
		
		legendaryPanel.add(legendaryButton);
	}
	
	// Expansions panels text style modifier
	private void changePanelTitleStyle(JPanel expansion, JTextPane titleLabel, String text) 
	{
		titleLabel.setBackground(expansion.getBackground());
		
		set = new SimpleAttributeSet();
		StyleConstants.setFontSize(set, 26);
		StyleConstants.setFontFamily(set, PRIMARY_FONT);
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
		StyleConstants.setFontFamily(set, PRIMARY_FONT);
		StyleConstants.setAlignment(set, StyleConstants.ALIGN_CENTER);
		
		doc.setParagraphAttributes(0, doc.getLength(), set, false);
		
		field.setEditable(false);
		field.setCursor(Cursor.getPredefinedCursor(Cursor.TEXT_CURSOR));
	}
	
	// Returns the tracker window content panel
	public JPanel getTrackerWindowContentPanel() 
	{
		return trackerWindowContentPanel;
	}
	
	// Returns the tracker panel scroll bar
	public JScrollPane getTrackerPanelScrollBar() 
	{
		return trackerPanelScrollBar;
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
	
	// Returns the "Standard Sets" panel
	public JPanel getStandard() 
	{
		return standard;
	}
	
	// Returns the "Wild Sets" panel
	public JPanel getWild() 
	{
		return wild;
	}
	
	// Returns the "Standard sets" button
	public JButton getStandardButton() 
	{
		return standardButton;
	}
	
	// Returns the "Wild sets" button
	public JButton getWildButton() 
	{
		return wildButton;
	}
	
	// Returns the Standard years shortcut buttons panel
	public JPanel getStandardYearsShortcutsPanel() 
	{
		return standardYearsShortcutsPanel;
	}
	
	// Returns the Wild years shortcut buttons panel
	public JPanel getWildYearsShortcutsPanel() 
	{
		return wildYearsShortcutsPanel;
	}
	
	// Returns the "Year of the Gryphon" shortcut button
	public JButton getGryphonShortcut() 
	{
		return gryphonShortcut;
	}
	
	// Returns the "Year of the Phoenix" shortcut button
	public JButton getPhoenixShortcut() 
	{
		return phoenixShortcut;
	}
	
	// Returns the "Year of the Dragon" shortcut button
	public JButton getDragonShortcut() 
	{
		return dragonShortcut;
	}
	
	// Returns the "Year of the Raven" shortcut button
	public JButton getRavenShortcut() 
	{
		return ravenShortcut;
	}
	
	// Returns the "Year of the Mammoth" shortcut button
	public JButton getMammothShortcut() 
	{
		return mammothShortcut;
	}
	
	// Returns the "Year of the Kraken" shortcut button
	public JButton getKrakenShortcut() 
	{
		return krakenShortcut;
	}
	
	// Returns the "Classic Sets" shortcut button
	public JButton getClassicSetsShortcut() 
	{
		return classicSetsShortcut;
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
	
	//Returns the "Fractured in Alterac Valley" image button
	public JButton getAlteracImage() {
		return alteracImageButton;
	}
	
	//Returns the "United in Stormwind" image button
	public JButton getStormwindImage() {
		return stormwindImageButton;
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
	
	// Returns the value of "Fractured in Alterac Valley" epic counter
	public String getAlteracEpicCounter() 
	{
		return alteracEpicCounter;
	}
	
	// Returns the value of "United in Stormwind" epic counter
	public String getStormwindEpicCounter() 
	{
		return stormwindEpicCounter;
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
	
	// Sets the value of "Fractured in Alterac Valley" epic counter
	public void setAlteracEpicCounter(String value) 
	{
		alteracEpicCounter = value;
		alteracEpicCounterPanel.setText("");
		doc = alteracEpicCounterPanel.getStyledDocument();
		changePanelTextStyle(alterac, alteracEpicCounterPanel, EPIC_COUNTER_TEXT, alteracEpicCounter);
	}
	
	// Sets the value of "United in Stormwind" epic counter
	public void setStormwindEpicCounter(String value) 
	{
		stormwindEpicCounter = value;
		stormwindEpicCounterPanel.setText("");
		doc = stormwindEpicCounterPanel.getStyledDocument();
		changePanelTextStyle(stormwind, stormwindEpicCounterPanel, EPIC_COUNTER_TEXT, stormwindEpicCounter);
	}
	
	// Sets the value of "Forged in the Barrens" epic counter
	public void setBarrensEpicCounter(String value) 
	{
		barrensEpicCounter = value;
		barrensEpicCounterPanel.setText("");
		doc = barrensEpicCounterPanel.getStyledDocument();
		changePanelTextStyle(barrens, barrensEpicCounterPanel, EPIC_COUNTER_TEXT, barrensEpicCounter);
	}
	
	// Sets the value of "Madness at the Darkmoon Faire" epic counter
	public void setDarkmoonEpicCounter(String value) 
	{
		darkmoonEpicCounter = value;
		darkmoonEpicCounterPanel.setText("");
		doc = darkmoonEpicCounterPanel.getStyledDocument();
		changePanelTextStyle(darkmoon, darkmoonEpicCounterPanel, EPIC_COUNTER_TEXT, darkmoonEpicCounter);
	}
	
	// Sets the value of "Scholomance Academy" epic counter
	public void setScholomanceEpicCounter(String value) 
	{
		scholomanceEpicCounter = value;
		scholomanceEpicCounterPanel.setText("");
		doc = scholomanceEpicCounterPanel.getStyledDocument();
		changePanelTextStyle(scholomance, scholomanceEpicCounterPanel, EPIC_COUNTER_TEXT, scholomanceEpicCounter);
	}
	
	// Sets the value of "Ashes of Outland" epic counter
	public void setOutlandEpicCounter(String value) 
	{
		outlandEpicCounter = value;
		outlandEpicCounterPanel.setText("");
		doc = outlandEpicCounterPanel.getStyledDocument();
		changePanelTextStyle(outland, outlandEpicCounterPanel, EPIC_COUNTER_TEXT, outlandEpicCounter);
	}
	
	// Sets the value of "Descent of Dragons" epic counter
	public void setDragonsEpicCounter(String value) 
	{
		dragonsEpicCounter = value;
		dragonsEpicCounterPanel.setText("");
		doc = dragonsEpicCounterPanel.getStyledDocument();
		changePanelTextStyle(dragons, dragonsEpicCounterPanel, EPIC_COUNTER_TEXT, dragonsEpicCounter);
	}
	
	// Sets the value of "Saviors of Uldum" epic counter
	public void setUldumEpicCounter(String value) 
	{
		uldumEpicCounter = value;
		uldumEpicCounterPanel.setText("");
		doc = uldumEpicCounterPanel.getStyledDocument();
		changePanelTextStyle(uldum, uldumEpicCounterPanel, EPIC_COUNTER_TEXT, uldumEpicCounter);
	}
	
	// Sets the value of "Rise of Shadows" epic counter
	public void setShadowsEpicCounter(String value) 
	{
		shadowsEpicCounter = value;
		shadowsEpicCounterPanel.setText("");
		doc = shadowsEpicCounterPanel.getStyledDocument();
		changePanelTextStyle(shadows, shadowsEpicCounterPanel, EPIC_COUNTER_TEXT, shadowsEpicCounter);
	}
	
	// Sets the value of "Rastakhan's Rumble" epic counter
	public void setRumbleEpicCounter(String value) 
	{
		rumbleEpicCounter = value;
		rumbleEpicCounterPanel.setText("");
		doc = rumbleEpicCounterPanel.getStyledDocument();
		changePanelTextStyle(rumble, rumbleEpicCounterPanel, EPIC_COUNTER_TEXT, rumbleEpicCounter);
	}
	
	// Sets the value of "The Boomsday Project" epic counter
	public void setBoomsdayEpicCounter(String value) 
	{
		boomsdayEpicCounter = value;
		boomsdayEpicCounterPanel.setText("");
		doc = boomsdayEpicCounterPanel.getStyledDocument();
		changePanelTextStyle(boomsday, boomsdayEpicCounterPanel, EPIC_COUNTER_TEXT, boomsdayEpicCounter);
	}
	
	// Sets the value of "The Witchwood" epic counter
	public void setWitchwoodEpicCounter(String value) 
	{
		witchwoodEpicCounter = value;
		witchwoodEpicCounterPanel.setText("");
		doc = witchwoodEpicCounterPanel.getStyledDocument();
		changePanelTextStyle(witchwood, witchwoodEpicCounterPanel, EPIC_COUNTER_TEXT, witchwoodEpicCounter);
	}
	
	// Sets the value of "Kobolds & Catacombs" epic counter
	public void setKoboldsEpicCounter(String value) 
	{
		koboldsEpicCounter = value;
		koboldsEpicCounterPanel.setText("");
		doc = koboldsEpicCounterPanel.getStyledDocument();
		changePanelTextStyle(kobolds, koboldsEpicCounterPanel, EPIC_COUNTER_TEXT, koboldsEpicCounter);
	}
	
	// Sets the value of "Knights of the Frozen Throne" epic counter
	public void setKnightsEpicCounter(String value) 
	{
		knightsEpicCounter = value;
		knightsEpicCounterPanel.setText("");
		doc = knightsEpicCounterPanel.getStyledDocument();
		changePanelTextStyle(knights, knightsEpicCounterPanel, EPIC_COUNTER_TEXT, knightsEpicCounter);
	}
	
	// Sets the value of "Journey to Un'Goro" epic counter
	public void setUngoroEpicCounter(String value) 
	{
		ungoroEpicCounter = value;
		ungoroEpicCounterPanel.setText("");
		doc = ungoroEpicCounterPanel.getStyledDocument();
		changePanelTextStyle(ungoro, ungoroEpicCounterPanel, EPIC_COUNTER_TEXT, ungoroEpicCounter);
	}
	
	// Sets the value of "Mean Streets of Gadgetzan" epic counter
	public void setGadgetzanEpicCounter(String value) 
	{
		gadgetzanEpicCounter = value;
		gadgetzanEpicCounterPanel.setText("");
		doc = gadgetzanEpicCounterPanel.getStyledDocument();
		changePanelTextStyle(gadgetzan, gadgetzanEpicCounterPanel, EPIC_COUNTER_TEXT, gadgetzanEpicCounter);
	}
	
	// Sets the value of "Whispers of the Old Gods" epic counter
	public void setOldGodsEpicCounter(String value) 
	{
		oldGodsEpicCounter = value;
		oldGodsEpicCounterPanel.setText("");
		doc = oldGodsEpicCounterPanel.getStyledDocument();
		changePanelTextStyle(oldGods, oldGodsEpicCounterPanel, EPIC_COUNTER_TEXT, oldGodsEpicCounter);
	}
	
	// Sets the value of "The Grand Tournament" epic counter
	public void setTournamentEpicCounter(String value) 
	{
		tournamentEpicCounter = value;
		tournamentEpicCounterPanel.setText("");
		doc = tournamentEpicCounterPanel.getStyledDocument();
		changePanelTextStyle(tournament, tournamentEpicCounterPanel, EPIC_COUNTER_TEXT, tournamentEpicCounter);
	}
	
	// Sets the value of "Goblins vs Gnomes" epic counter
	public void setGoblinsEpicCounter(String value) 
	{
		goblinsEpicCounter = value;
		goblinsEpicCounterPanel.setText("");
		doc = goblinsEpicCounterPanel.getStyledDocument();
		changePanelTextStyle(goblins, goblinsEpicCounterPanel, EPIC_COUNTER_TEXT, goblinsEpicCounter);
	}
	
	// Sets the value of "Classic" epic counter
	public void setClassicEpicCounter(String value) 
	{
		classicEpicCounter = value;
		classicEpicCounterPanel.setText("");
		doc = classicEpicCounterPanel.getStyledDocument();
		changePanelTextStyle(classic, classicEpicCounterPanel, EPIC_COUNTER_TEXT, classicEpicCounter);
	}
	
	// Returns the "Fractured in Alterac Valley" epic reset button
	public ModifierButton getAlteracEpicReset() 
	{
		return alteracEpicReset;
	}
	
	// Returns the "United in Stormwind" epic reset button
	public ModifierButton getStormwindEpicReset() 
	{
		return stormwindEpicReset;
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
	
	// Returns the "Fractured in Alterac Valley" epic add button
	public RoundButton getAlteracEpicAdd() 
	{
		return alteracEpicAdd;
	}
	
	// Returns the "United in Stormwind" epic add button
	public RoundButton getStormwindEpicAdd() 
	{
		return stormwindEpicAdd;
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
	
	// Returns the "Fractured in Alterac Valley" epic increment field
	public JTextArea getAlteracEpicIncrement() 
	{
		return alteracEpicIncrement;
	}
	
	// Returns the "United in Stormwind" epic increment field
	public JTextArea getStormwindEpicIncrement() 
	{
		return stormwindEpicIncrement;
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
	
	// Returns the value of "Fractured in Alterac Valley" epic probability
	public String getAlteracEpicProbability() 
	{
		return alteracEpicProbability.replace("%", "").replace(",", ".");
	}
	
	// Returns the value of "United in Stormwind" epic probability
	public String getStormwindEpicProbability() 
	{
		return stormwindEpicProbability.replace("%", "").replace(",", ".");
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
	
	// Sets the value of "Fractured in Alterac Valley" epic probability
	public void setAlteracEpicProbability(String value) 
	{
		alteracEpicProbability = value + "%";
		alteracEpicProbabilityPanel.setText("");
		doc = alteracEpicProbabilityPanel.getStyledDocument();
		changePanelTextStyle(alterac, alteracEpicProbabilityPanel, EPIC_PROBABILITY_TEXT, alteracEpicProbability);
	}
	
	// Sets the value of "United in Stormwind" epic probability
	public void setStormwindEpicProbability(String value) 
	{
		stormwindEpicProbability = value + "%";
		stormwindEpicProbabilityPanel.setText("");
		doc = stormwindEpicProbabilityPanel.getStyledDocument();
		changePanelTextStyle(stormwind, stormwindEpicProbabilityPanel, EPIC_PROBABILITY_TEXT, stormwindEpicProbability);
	}
	
	// Sets the value of "Forged in the Barrens" epic probability
	public void setBarrensEpicProbability(String value) 
	{
		barrensEpicProbability = value + "%";
		barrensEpicProbabilityPanel.setText("");
		doc = barrensEpicProbabilityPanel.getStyledDocument();
		changePanelTextStyle(barrens, barrensEpicProbabilityPanel, EPIC_PROBABILITY_TEXT, barrensEpicProbability);
	}
	
	// Sets the value of "Madness at the Darkmoon Faire" epic probability
	public void setDarkmoonEpicProbability(String value) 
	{
		darkmoonEpicProbability = value + "%";
		darkmoonEpicProbabilityPanel.setText("");
		doc = darkmoonEpicProbabilityPanel.getStyledDocument();
		changePanelTextStyle(darkmoon, darkmoonEpicProbabilityPanel, EPIC_PROBABILITY_TEXT, darkmoonEpicProbability);
	}
	
	// Sets the value of "Scholomance Academy" epic probability
	public void setScholomanceEpicProbability(String value) 
	{
		scholomanceEpicProbability = value + "%";
		scholomanceEpicProbabilityPanel.setText("");
		doc = scholomanceEpicProbabilityPanel.getStyledDocument();
		changePanelTextStyle(scholomance, scholomanceEpicProbabilityPanel, EPIC_PROBABILITY_TEXT, scholomanceEpicProbability);
	}
	
	// Sets the value of "Ashes of Outland" epic probability
	public void setOutlandEpicProbability(String value) 
	{
		outlandEpicProbability = value + "%";
		outlandEpicProbabilityPanel.setText("");
		doc = outlandEpicProbabilityPanel.getStyledDocument();
		changePanelTextStyle(outland, outlandEpicProbabilityPanel, EPIC_PROBABILITY_TEXT, outlandEpicProbability);
	}
	
	// Sets the value of "Descent of Dragons" epic probability
	public void setDragonsEpicProbability(String value) 
	{
		dragonsEpicProbability = value + "%";
		dragonsEpicProbabilityPanel.setText("");
		doc = dragonsEpicProbabilityPanel.getStyledDocument();
		changePanelTextStyle(dragons, dragonsEpicProbabilityPanel, EPIC_PROBABILITY_TEXT, dragonsEpicProbability);
	}
	
	// Sets the value of "Saviors of Uldum" epic probability
	public void setUldumEpicProbability(String value) 
	{
		uldumEpicProbability = value + "%";
		uldumEpicProbabilityPanel.setText("");
		doc = uldumEpicProbabilityPanel.getStyledDocument();
		changePanelTextStyle(uldum, uldumEpicProbabilityPanel, EPIC_PROBABILITY_TEXT, uldumEpicProbability);
	}
	
	// Sets the value of "Rise of Shadows" epic probability
	public void setShadowsEpicProbability(String value) 
	{
		shadowsEpicProbability = value + "%";
		shadowsEpicProbabilityPanel.setText("");
		doc = shadowsEpicProbabilityPanel.getStyledDocument();
		changePanelTextStyle(shadows, shadowsEpicProbabilityPanel, EPIC_PROBABILITY_TEXT, shadowsEpicProbability);
	}
	
	// Sets the value of "Rastakhan's Rumble" epic probability
	public void setRumbleEpicProbability(String value) 
	{
		rumbleEpicProbability = value + "%";
		rumbleEpicProbabilityPanel.setText("");
		doc = rumbleEpicProbabilityPanel.getStyledDocument();
		changePanelTextStyle(rumble, rumbleEpicProbabilityPanel, EPIC_PROBABILITY_TEXT, rumbleEpicProbability);
	}
	
	// Sets the value of "The Boomsday Project" epic probability
	public void setBoomsdayEpicProbability(String value) 
	{
		boomsdayEpicProbability = value + "%";
		boomsdayEpicProbabilityPanel.setText("");
		doc = boomsdayEpicProbabilityPanel.getStyledDocument();
		changePanelTextStyle(boomsday, boomsdayEpicProbabilityPanel, EPIC_PROBABILITY_TEXT, boomsdayEpicProbability);
	}
	
	// Sets the value of "The Witchwood" epic probability
	public void setWitchwoodEpicProbability(String value) 
	{
		witchwoodEpicProbability = value + "%";
		witchwoodEpicProbabilityPanel.setText("");
		doc = witchwoodEpicProbabilityPanel.getStyledDocument();
		changePanelTextStyle(witchwood, witchwoodEpicProbabilityPanel, EPIC_PROBABILITY_TEXT, witchwoodEpicProbability);
	}
	
	// Sets the value of "Kobolds & Catacombs" epic probability
	public void setKoboldsEpicProbability(String value) 
	{
		koboldsEpicProbability = value + "%";
		koboldsEpicProbabilityPanel.setText("");
		doc = koboldsEpicProbabilityPanel.getStyledDocument();
		changePanelTextStyle(kobolds, koboldsEpicProbabilityPanel, EPIC_PROBABILITY_TEXT, koboldsEpicProbability);
	}
	
	// Sets the value of "Knights of the Frozen Throne" epic probability
	public void setKnightsEpicProbability(String value) 
	{
		knightsEpicProbability = value + "%";
		knightsEpicProbabilityPanel.setText("");
		doc = knightsEpicProbabilityPanel.getStyledDocument();
		changePanelTextStyle(knights, knightsEpicProbabilityPanel, EPIC_PROBABILITY_TEXT, knightsEpicProbability);
	}
	
	// Sets the value of "Journey to Un'Goro" epic probability
	public void setUngoroEpicProbability(String value) 
	{
		ungoroEpicProbability = value + "%";
		ungoroEpicProbabilityPanel.setText("");
		doc = ungoroEpicProbabilityPanel.getStyledDocument();
		changePanelTextStyle(ungoro, ungoroEpicProbabilityPanel, EPIC_PROBABILITY_TEXT, ungoroEpicProbability);
	}
	
	// Sets the value of "Mean Streets of Gadgetzan" epic probability
	public void setGadgetzanEpicProbability(String value) 
	{
		gadgetzanEpicProbability = value + "%";
		gadgetzanEpicProbabilityPanel.setText("");
		doc = gadgetzanEpicProbabilityPanel.getStyledDocument();
		changePanelTextStyle(gadgetzan, gadgetzanEpicProbabilityPanel, EPIC_PROBABILITY_TEXT, gadgetzanEpicProbability);
	}
	
	// Sets the value of "Whispers of the Old Gods" epic probability
	public void setOldGodsEpicProbability(String value) 
	{
		oldGodsEpicProbability = value + "%";
		oldGodsEpicProbabilityPanel.setText("");
		doc = oldGodsEpicProbabilityPanel.getStyledDocument();
		changePanelTextStyle(oldGods, oldGodsEpicProbabilityPanel, EPIC_PROBABILITY_TEXT, oldGodsEpicProbability);
	}
	
	// Sets the value of "The Grand Tournament" epic probability
	public void setTournamentEpicProbability(String value) 
	{
		tournamentEpicProbability = value + "%";
		tournamentEpicProbabilityPanel.setText("");
		doc = tournamentEpicProbabilityPanel.getStyledDocument();
		changePanelTextStyle(tournament, tournamentEpicProbabilityPanel, EPIC_PROBABILITY_TEXT, tournamentEpicProbability);
	}
	
	// Sets the value of "Goblins vs Gnomes" epic probability
	public void setGoblinsEpicProbability(String value) 
	{
		goblinsEpicProbability = value + "%";
		goblinsEpicProbabilityPanel.setText("");
		doc = goblinsEpicProbabilityPanel.getStyledDocument();
		changePanelTextStyle(goblins, goblinsEpicProbabilityPanel, EPIC_PROBABILITY_TEXT, goblinsEpicProbability);
	}
	
	// Sets the value of "Classic" epic probability
	public void setClassicEpicProbability(String value) 
	{
		classicEpicProbability = value + "%";
		classicEpicProbabilityPanel.setText("");
		doc = classicEpicProbabilityPanel.getStyledDocument();
		changePanelTextStyle(classic, classicEpicProbabilityPanel, EPIC_PROBABILITY_TEXT, classicEpicProbability);
	}
	
	// Returns the value of "Fractured in Alterac Valley" legendary counter
	public String getAlteracLegendaryCounter() 
	{
		return alteracLegendaryCounter;
	}
	
	// Returns the value of "United in Stormwind" legendary counter
	public String getStormwindLegendaryCounter() 
	{
		return stormwindLegendaryCounter;
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
	
	// Sets the value of "Fractured in Alterac Valley" legendary counter
	public void setAlteracLegendaryCounter(String value) 
	{
		alteracLegendaryCounter = value;
		alteracLegendaryCounterPanel.setText("");
		doc = alteracLegendaryCounterPanel.getStyledDocument();
		changePanelTextStyle(alterac, alteracLegendaryCounterPanel, LEGENDARY_COUNTER_TEXT, alteracLegendaryCounter);
	}
	
	// Sets the value of "United in Stormwind" legendary counter
	public void setStormwindLegendaryCounter(String value) 
	{
		stormwindLegendaryCounter = value;
		stormwindLegendaryCounterPanel.setText("");
		doc = stormwindLegendaryCounterPanel.getStyledDocument();
		changePanelTextStyle(stormwind, stormwindLegendaryCounterPanel, LEGENDARY_COUNTER_TEXT, stormwindLegendaryCounter);
	}
	
	// Sets the value of "Forged in the Barrens" legendary counter
	public void setBarrensLegendaryCounter(String value) 
	{
		barrensLegendaryCounter = value;
		barrensLegendaryCounterPanel.setText("");
		doc = barrensLegendaryCounterPanel.getStyledDocument();
		changePanelTextStyle(barrens, barrensLegendaryCounterPanel, LEGENDARY_COUNTER_TEXT, barrensLegendaryCounter);
	}
	
	// Sets the value of "Madness at the Darkmoon Faire" legendary counter
	public void setDarkmoonLegendaryCounter(String value) 
	{
		darkmoonLegendaryCounter = value;
		darkmoonLegendaryCounterPanel.setText("");
		doc = darkmoonLegendaryCounterPanel.getStyledDocument();
		changePanelTextStyle(darkmoon, darkmoonLegendaryCounterPanel, LEGENDARY_COUNTER_TEXT, darkmoonLegendaryCounter);
	}
	
	// Sets the value of "Scholomance Academy" legendary counter
	public void setScholomanceLegendaryCounter(String value) 
	{
		scholomanceLegendaryCounter = value;
		scholomanceLegendaryCounterPanel.setText("");
		doc = scholomanceLegendaryCounterPanel.getStyledDocument();
		changePanelTextStyle(scholomance, scholomanceLegendaryCounterPanel, LEGENDARY_COUNTER_TEXT, scholomanceLegendaryCounter);
	}
	
	// Sets the value of "Ashes of Outland" legendary counter
	public void setOutlandLegendaryCounter(String value) 
	{
		outlandLegendaryCounter = value;
		outlandLegendaryCounterPanel.setText("");
		doc = outlandLegendaryCounterPanel.getStyledDocument();
		changePanelTextStyle(outland, outlandLegendaryCounterPanel, LEGENDARY_COUNTER_TEXT, outlandLegendaryCounter);
	}
	
	// Sets the value of "Descent of Dragons" legendary counter
	public void setDragonsLegendaryCounter(String value) 
	{
		dragonsLegendaryCounter = value;
		dragonsLegendaryCounterPanel.setText("");
		doc = dragonsLegendaryCounterPanel.getStyledDocument();
		changePanelTextStyle(dragons, dragonsLegendaryCounterPanel, LEGENDARY_COUNTER_TEXT, dragonsLegendaryCounter);
	}
	
	// Sets the value of "Saviors of Uldum" legendary counter
	public void setUldumLegendaryCounter(String value) 
	{
		uldumLegendaryCounter = value;
		uldumLegendaryCounterPanel.setText("");
		doc = uldumLegendaryCounterPanel.getStyledDocument();
		changePanelTextStyle(uldum, uldumLegendaryCounterPanel, LEGENDARY_COUNTER_TEXT, uldumLegendaryCounter);
	}
	
	// Sets the value of "Rise of Shadows" legendary counter
	public void setShadowsLegendaryCounter(String value) 
	{
		shadowsLegendaryCounter = value;
		shadowsLegendaryCounterPanel.setText("");
		doc = shadowsLegendaryCounterPanel.getStyledDocument();
		changePanelTextStyle(shadows, shadowsLegendaryCounterPanel, LEGENDARY_COUNTER_TEXT, shadowsLegendaryCounter);
	}
	
	// Sets the value of "Rastakhan's Rumble" legendary counter
	public void setRumbleLegendaryCounter(String value) 
	{
		rumbleLegendaryCounter = value;
		rumbleLegendaryCounterPanel.setText("");
		doc = rumbleLegendaryCounterPanel.getStyledDocument();
		changePanelTextStyle(rumble, rumbleLegendaryCounterPanel, LEGENDARY_COUNTER_TEXT, rumbleLegendaryCounter);
	}
	
	// Sets the value of "The Boomsday Project" legendary counter
	public void setBoomsdayLegendaryCounter(String value) 
	{
		boomsdayLegendaryCounter = value;
		boomsdayLegendaryCounterPanel.setText("");
		doc = boomsdayLegendaryCounterPanel.getStyledDocument();
		changePanelTextStyle(boomsday, boomsdayLegendaryCounterPanel, LEGENDARY_COUNTER_TEXT, boomsdayLegendaryCounter);
	}
	
	// Sets the value of "The Witchwood" legendary counter
	public void setWitchwoodLegendaryCounter(String value) 
	{
		witchwoodLegendaryCounter = value;
		witchwoodLegendaryCounterPanel.setText("");
		doc = witchwoodLegendaryCounterPanel.getStyledDocument();
		changePanelTextStyle(witchwood, witchwoodLegendaryCounterPanel, LEGENDARY_COUNTER_TEXT, witchwoodLegendaryCounter);
	}
	
	// Sets the value of "Kobolds & Catacombs" legendary counter
	public void setKoboldsLegendaryCounter(String value) 
	{
		koboldsLegendaryCounter = value;
		koboldsLegendaryCounterPanel.setText("");
		doc = koboldsLegendaryCounterPanel.getStyledDocument();
		changePanelTextStyle(kobolds, koboldsLegendaryCounterPanel, LEGENDARY_COUNTER_TEXT, koboldsLegendaryCounter);
	}
	
	// Sets the value of "Knights of the Frozen Throne" legendary counter
	public void setKnightsLegendaryCounter(String value) 
	{
		knightsLegendaryCounter = value;
		knightsLegendaryCounterPanel.setText("");
		doc = knightsLegendaryCounterPanel.getStyledDocument();
		changePanelTextStyle(knights, knightsLegendaryCounterPanel, LEGENDARY_COUNTER_TEXT, knightsLegendaryCounter);
	}
	
	// Sets the value of "Journey to Un'Goro" legendary counter
	public void setUngoroLegendaryCounter(String value) 
	{
		ungoroLegendaryCounter = value;
		ungoroLegendaryCounterPanel.setText("");
		doc = ungoroLegendaryCounterPanel.getStyledDocument();
		changePanelTextStyle(ungoro, ungoroLegendaryCounterPanel, LEGENDARY_COUNTER_TEXT, ungoroLegendaryCounter);
	}
	
	// Sets the value of "Mean Streets of Gadgetzan" legendary counter
	public void setGadgetzanLegendaryCounter(String value) 
	{
		gadgetzanLegendaryCounter = value;
		gadgetzanLegendaryCounterPanel.setText("");
		doc = gadgetzanLegendaryCounterPanel.getStyledDocument();
		changePanelTextStyle(gadgetzan, gadgetzanLegendaryCounterPanel, LEGENDARY_COUNTER_TEXT, gadgetzanLegendaryCounter);
	}
	
	// Sets the value of "Whispers of the Old Gods" legendary counter
	public void setOldGodsLegendaryCounter(String value) 
	{
		oldGodsLegendaryCounter = value;
		oldGodsLegendaryCounterPanel.setText("");
		doc = oldGodsLegendaryCounterPanel.getStyledDocument();
		changePanelTextStyle(oldGods, oldGodsLegendaryCounterPanel, LEGENDARY_COUNTER_TEXT, oldGodsLegendaryCounter);
	}
	
	// Sets the value of "The Grand Tournament" legendary counter
	public void setTournamentLegendaryCounter(String value) 
	{
		tournamentLegendaryCounter = value;
		tournamentLegendaryCounterPanel.setText("");
		doc = tournamentLegendaryCounterPanel.getStyledDocument();
		changePanelTextStyle(tournament, tournamentLegendaryCounterPanel, LEGENDARY_COUNTER_TEXT, tournamentLegendaryCounter);
	}
	
	// Sets the value of "Goblins vs Gnomes" legendary counter
	public void setGoblinsLegendaryCounter(String value) 
	{
		goblinsLegendaryCounter = value;
		goblinsLegendaryCounterPanel.setText("");
		doc = goblinsLegendaryCounterPanel.getStyledDocument();
		changePanelTextStyle(goblins, goblinsLegendaryCounterPanel, LEGENDARY_COUNTER_TEXT, goblinsLegendaryCounter);
	}
	
	// Sets the value of "Classic" legendary counter
	public void setClassicLegendaryCounter(String value) 
	{
		classicLegendaryCounter = value;
		classicLegendaryCounterPanel.setText("");
		doc = classicLegendaryCounterPanel.getStyledDocument();
		changePanelTextStyle(classic, classicLegendaryCounterPanel, LEGENDARY_COUNTER_TEXT, classicLegendaryCounter);
	}
	
	// Returns the "Fractured in Alterac Valley" legendary reset button
	public ModifierButton getAlteracLegendaryReset() 
	{
		return alteracLegendaryReset;
	}
	
	// Returns the "United in Stormwind" legendary reset button
	public ModifierButton getStormwindLegendaryReset() 
	{
		return stormwindLegendaryReset;
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
	
	// Returns the "Fractured in Alterac Valley" legendary add button
	public RoundButton getAlteracLegendaryAdd() 
	{
		return alteracLegendaryAdd;
	}
	
	// Returns the "United in Stormwind" legendary add button
	public RoundButton getStormwindLegendaryAdd() 
	{
		return stormwindLegendaryAdd;
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
	
	// Returns the "Fractured in Alterac Valley" legendary increment field
	public JTextArea getAlteracLegendaryIncrement() 
	{
		return alteracLegendaryIncrement;
	}
	
	// Returns the "United in Stormwind" legendary increment field
	public JTextArea getStormwindLegendaryIncrement() 
	{
		return stormwindLegendaryIncrement;
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
	
	// Returns the value of "Fractured in Alterac Valley" legendary probability
	public String getAlteracLegendaryProbability() 
	{
		return alteracLegendaryProbability.replace("%", "").replace(",", ".");
	}
	
	// Returns the value of "United in Stormwind" legendary probability
	public String getStormwindLegendaryProbability() 
	{
		return stormwindLegendaryProbability.replace("%", "").replace(",", ".");
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
	
	// Sets the value of "Fractured in Alterac Valley" legendary probability
	public void setAlteracLegendaryProbability(String value) 
	{
		alteracLegendaryProbability = value + "%";
		alteracLegendaryProbabilityPanel.setText("");
		doc = alteracLegendaryProbabilityPanel.getStyledDocument();
		changePanelTextStyle(alterac, alteracLegendaryProbabilityPanel, LEGENDARY_PROBABILITY_TEXT, alteracLegendaryProbability);
	}
	
	// Sets the value of "United in Stormwind" legendary probability
	public void setStormwindLegendaryProbability(String value) 
	{
		stormwindLegendaryProbability = value + "%";
		stormwindLegendaryProbabilityPanel.setText("");
		doc = stormwindLegendaryProbabilityPanel.getStyledDocument();
		changePanelTextStyle(stormwind, stormwindLegendaryProbabilityPanel, LEGENDARY_PROBABILITY_TEXT, stormwindLegendaryProbability);
	}
	
	// Sets the value of "Forged in the Barrens" legendary probability
	public void setBarrensLegendaryProbability(String value) 
	{
		barrensLegendaryProbability = value + "%";
		barrensLegendaryProbabilityPanel.setText("");
		doc = barrensLegendaryProbabilityPanel.getStyledDocument();
		changePanelTextStyle(barrens, barrensLegendaryProbabilityPanel, LEGENDARY_PROBABILITY_TEXT, barrensLegendaryProbability);
	}
	
	// Sets the value of "Madness at the Darkmoon Faire" legendary probability
	public void setDarkmoonLegendaryProbability(String value) 
	{
		darkmoonLegendaryProbability = value + "%";
		darkmoonLegendaryProbabilityPanel.setText("");
		doc = darkmoonLegendaryProbabilityPanel.getStyledDocument();
		changePanelTextStyle(darkmoon, darkmoonLegendaryProbabilityPanel, LEGENDARY_PROBABILITY_TEXT, darkmoonLegendaryProbability);
	}
	
	// Sets the value of "Scholomance Academy" legendary probability
	public void setScholomanceLegendaryProbability(String value) 
	{
		scholomanceLegendaryProbability = value + "%";
		scholomanceLegendaryProbabilityPanel.setText("");
		doc = scholomanceLegendaryProbabilityPanel.getStyledDocument();
		changePanelTextStyle(scholomance, scholomanceLegendaryProbabilityPanel, LEGENDARY_PROBABILITY_TEXT, scholomanceLegendaryProbability);
	}
	
	// Sets the value of "Ashes of Outland" legendary probability
	public void setOutlandLegendaryProbability(String value) 
	{
		outlandLegendaryProbability = value + "%";
		outlandLegendaryProbabilityPanel.setText("");
		doc = outlandLegendaryProbabilityPanel.getStyledDocument();
		changePanelTextStyle(outland, outlandLegendaryProbabilityPanel, LEGENDARY_PROBABILITY_TEXT, outlandLegendaryProbability);
	}
	
	// Sets the value of "Descent of Dragons" legendary probability
	public void setDragonsLegendaryProbability(String value) 
	{
		dragonsLegendaryProbability = value + "%";
		dragonsLegendaryProbabilityPanel.setText("");
		doc = dragonsLegendaryProbabilityPanel.getStyledDocument();
		changePanelTextStyle(dragons, dragonsLegendaryProbabilityPanel, LEGENDARY_PROBABILITY_TEXT, dragonsLegendaryProbability);
	}
	
	// Sets the value of "Saviors of Uldum" legendary probability
	public void setUldumLegendaryProbability(String value) 
	{
		uldumLegendaryProbability = value + "%";
		uldumLegendaryProbabilityPanel.setText("");
		doc = uldumLegendaryProbabilityPanel.getStyledDocument();
		changePanelTextStyle(uldum, uldumLegendaryProbabilityPanel, LEGENDARY_PROBABILITY_TEXT, uldumLegendaryProbability);
	}
	
	// Sets the value of "Rise of Shadows" legendary probability
	public void setShadowsLegendaryProbability(String value) 
	{
		shadowsLegendaryProbability = value + "%";
		shadowsLegendaryProbabilityPanel.setText("");
		doc = shadowsLegendaryProbabilityPanel.getStyledDocument();
		changePanelTextStyle(shadows, shadowsLegendaryProbabilityPanel, LEGENDARY_PROBABILITY_TEXT, shadowsLegendaryProbability);
	}
	
	// Sets the value of "Rastakhan's Rumble" legendary probability
	public void setRumbleLegendaryProbability(String value) 
	{
		rumbleLegendaryProbability = value + "%";
		rumbleLegendaryProbabilityPanel.setText("");
		doc = rumbleLegendaryProbabilityPanel.getStyledDocument();
		changePanelTextStyle(rumble, rumbleLegendaryProbabilityPanel, LEGENDARY_PROBABILITY_TEXT, rumbleLegendaryProbability);
	}
	
	// Sets the value of "The Boomsday Project" legendary probability
	public void setBoomsdayLegendaryProbability(String value) 
	{
		boomsdayLegendaryProbability = value + "%";
		boomsdayLegendaryProbabilityPanel.setText("");
		doc = boomsdayLegendaryProbabilityPanel.getStyledDocument();
		changePanelTextStyle(boomsday, boomsdayLegendaryProbabilityPanel, LEGENDARY_PROBABILITY_TEXT, boomsdayLegendaryProbability);
	}
	
	// Sets the value of "The Witchwood" legendary probability
	public void setWitchwoodLegendaryProbability(String value) 
	{
		witchwoodLegendaryProbability = value + "%";
		witchwoodLegendaryProbabilityPanel.setText("");
		doc = witchwoodLegendaryProbabilityPanel.getStyledDocument();
		changePanelTextStyle(witchwood, witchwoodLegendaryProbabilityPanel, LEGENDARY_PROBABILITY_TEXT, witchwoodLegendaryProbability);
	}
	
	// Sets the value of "Kobolds & Catacombs" legendary probability
	public void setKoboldsLegendaryProbability(String value) 
	{
		koboldsLegendaryProbability = value + "%";
		koboldsLegendaryProbabilityPanel.setText("");
		doc = koboldsLegendaryProbabilityPanel.getStyledDocument();
		changePanelTextStyle(kobolds, koboldsLegendaryProbabilityPanel, LEGENDARY_PROBABILITY_TEXT, koboldsLegendaryProbability);
	}
	
	// Sets the value of "Knights of the Frozen Throne" legendary probability
	public void setKnightsLegendaryProbability(String value) 
	{
		knightsLegendaryProbability = value + "%";
		knightsLegendaryProbabilityPanel.setText("");
		doc = knightsLegendaryProbabilityPanel.getStyledDocument();
		changePanelTextStyle(knights, knightsLegendaryProbabilityPanel, LEGENDARY_PROBABILITY_TEXT, knightsLegendaryProbability);
	}
	
	// Sets the value of "Journey to Un'Goro" legendary probability
	public void setUngoroLegendaryProbability(String value) 
	{
		ungoroLegendaryProbability = value + "%";
		ungoroLegendaryProbabilityPanel.setText("");
		doc = ungoroLegendaryProbabilityPanel.getStyledDocument();
		changePanelTextStyle(ungoro, ungoroLegendaryProbabilityPanel, LEGENDARY_PROBABILITY_TEXT, ungoroLegendaryProbability);
	}
	
	// Sets the value of "Mean Streets of Gadgetzan" legendary probability
	public void setGadgetzanLegendaryProbability(String value) 
	{
		gadgetzanLegendaryProbability = value + "%";
		gadgetzanLegendaryProbabilityPanel.setText("");
		doc = gadgetzanLegendaryProbabilityPanel.getStyledDocument();
		changePanelTextStyle(gadgetzan, gadgetzanLegendaryProbabilityPanel, LEGENDARY_PROBABILITY_TEXT, gadgetzanLegendaryProbability);
	}
	
	// Sets the value of "Whispers of the Old Gods" legendary probability
	public void setOldGodsLegendaryProbability(String value) 
	{
		oldGodsLegendaryProbability = value + "%";
		oldGodsLegendaryProbabilityPanel.setText("");
		doc = oldGodsLegendaryProbabilityPanel.getStyledDocument();
		changePanelTextStyle(oldGods, oldGodsLegendaryProbabilityPanel, LEGENDARY_PROBABILITY_TEXT, oldGodsLegendaryProbability);
	}
	
	// Sets the value of "The Grand Tournament" legendary probability
	public void setTournamentLegendaryProbability(String value) 
	{
		tournamentLegendaryProbability = value + "%";
		tournamentLegendaryProbabilityPanel.setText("");
		doc = tournamentLegendaryProbabilityPanel.getStyledDocument();
		changePanelTextStyle(tournament, tournamentLegendaryProbabilityPanel, LEGENDARY_PROBABILITY_TEXT, tournamentLegendaryProbability);
	}
	
	// Sets the value of "Goblins vs Gnomes" legendary probability
	public void setGoblinsLegendaryProbability(String value) 
	{
		goblinsLegendaryProbability = value + "%";
		goblinsLegendaryProbabilityPanel.setText("");
		doc = goblinsLegendaryProbabilityPanel.getStyledDocument();
		changePanelTextStyle(goblins, goblinsLegendaryProbabilityPanel, LEGENDARY_PROBABILITY_TEXT, goblinsLegendaryProbability);
	}
	
	// Sets the value of "Classic" legendary probability
	public void setClassicLegendaryProbability(String value) 
	{
		classicLegendaryProbability = value + "%";
		classicLegendaryProbabilityPanel.setText("");
		doc = classicLegendaryProbabilityPanel.getStyledDocument();
		changePanelTextStyle(classic, classicLegendaryProbabilityPanel, LEGENDARY_PROBABILITY_TEXT, classicLegendaryProbability);
	}
	
	// Returns the value of "Fractured in Alterac Valley" total counter
	public String getAlteracTotalCounter() 
	{
		return alteracTotalCounter;
	}
	
	// Returns the value of "United in Stormwind" total counter
	public String getStormwindTotalCounter() 
	{
		return stormwindTotalCounter;
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
	
	// Sets the value of "Fractured in Alterac Valley" total counter
	public void setAlteracTotalCounter(String value) 
	{
		alteracTotalCounter = value;
		alteracTotalCounterPanel.setText("");
		doc = alteracTotalCounterPanel.getStyledDocument();
		changePanelTextStyle(alterac, alteracTotalCounterPanel, TOTAL_COUNTER_TEXT, alteracTotalCounter);
	}
	
	// Sets the value of "United in Stormwind" total counter
	public void setStormwindTotalCounter(String value) 
	{
		stormwindTotalCounter = value;
		stormwindTotalCounterPanel.setText("");
		doc = stormwindTotalCounterPanel.getStyledDocument();
		changePanelTextStyle(stormwind, stormwindTotalCounterPanel, TOTAL_COUNTER_TEXT, stormwindTotalCounter);
	}
	
	// Sets the value of "Forged in the Barrens" total counter
	public void setBarrensTotalCounter(String value) 
	{
		barrensTotalCounter = value;
		barrensTotalCounterPanel.setText("");
		doc = barrensTotalCounterPanel.getStyledDocument();
		changePanelTextStyle(barrens, barrensTotalCounterPanel, TOTAL_COUNTER_TEXT, barrensTotalCounter);
	}
	
	// Sets the value of "Madness at the Darkmoon Faire" total counter
	public void setDarkmoonTotalCounter(String value) 
	{
		darkmoonTotalCounter = value;
		darkmoonTotalCounterPanel.setText("");
		doc = darkmoonTotalCounterPanel.getStyledDocument();
		changePanelTextStyle(darkmoon, darkmoonTotalCounterPanel, TOTAL_COUNTER_TEXT, darkmoonTotalCounter);
	}
	
	// Sets the value of "Scholomance Academy" total counter
	public void setScholomanceTotalCounter(String value) 
	{
		scholomanceTotalCounter = value;
		scholomanceTotalCounterPanel.setText("");
		doc = scholomanceTotalCounterPanel.getStyledDocument();
		changePanelTextStyle(scholomance, scholomanceTotalCounterPanel, TOTAL_COUNTER_TEXT, scholomanceTotalCounter);
	}
	
	// Sets the value of "Ashes of Outland" total counter
	public void setOutlandTotalCounter(String value) 
	{
		outlandTotalCounter = value;
		outlandTotalCounterPanel.setText("");
		doc = outlandTotalCounterPanel.getStyledDocument();
		changePanelTextStyle(outland, outlandTotalCounterPanel, TOTAL_COUNTER_TEXT, outlandTotalCounter);
	}
	
	// Sets the value of "Descent of Dragons" total counter
	public void setDragonsTotalCounter(String value) 
	{
		dragonsTotalCounter = value;
		dragonsTotalCounterPanel.setText("");
		doc = dragonsTotalCounterPanel.getStyledDocument();
		changePanelTextStyle(dragons, dragonsTotalCounterPanel, TOTAL_COUNTER_TEXT, dragonsTotalCounter);
	}
	
	// Sets the value of "Saviors of Uldum" total counter
	public void setUldumTotalCounter(String value) 
	{
		uldumTotalCounter = value;
		uldumTotalCounterPanel.setText("");
		doc = uldumTotalCounterPanel.getStyledDocument();
		changePanelTextStyle(uldum, uldumTotalCounterPanel, TOTAL_COUNTER_TEXT, uldumTotalCounter);
	}
	
	// Sets the value of "Rise of Shadows" total counter
	public void setShadowsTotalCounter(String value) 
	{
		shadowsTotalCounter = value;
		shadowsTotalCounterPanel.setText("");
		doc = shadowsTotalCounterPanel.getStyledDocument();
		changePanelTextStyle(shadows, shadowsTotalCounterPanel, TOTAL_COUNTER_TEXT, shadowsTotalCounter);
	}
	
	// Sets the value of "Rastakhan's Rumble" total counter
	public void setRumbleTotalCounter(String value) 
	{
		rumbleTotalCounter = value;
		rumbleTotalCounterPanel.setText("");
		doc = rumbleTotalCounterPanel.getStyledDocument();
		changePanelTextStyle(rumble, rumbleTotalCounterPanel, TOTAL_COUNTER_TEXT, rumbleTotalCounter);
	}
	
	// Sets the value of "The Boomsday Project" total counter
	public void setBoomsdayTotalCounter(String value) 
	{
		boomsdayTotalCounter = value;
		boomsdayTotalCounterPanel.setText("");
		doc = boomsdayTotalCounterPanel.getStyledDocument();
		changePanelTextStyle(boomsday, boomsdayTotalCounterPanel, TOTAL_COUNTER_TEXT, boomsdayTotalCounter);
	}
	
	// Sets the value of "The Witchwood" total counter
	public void setWitchwoodTotalCounter(String value) 
	{
		witchwoodTotalCounter = value;
		witchwoodTotalCounterPanel.setText("");
		doc = witchwoodTotalCounterPanel.getStyledDocument();
		changePanelTextStyle(witchwood, witchwoodTotalCounterPanel, TOTAL_COUNTER_TEXT, witchwoodTotalCounter);
	}
	
	// Sets the value of "Kobolds & Catacombs" total counter
	public void setKoboldsTotalCounter(String value) 
	{
		koboldsTotalCounter = value;
		koboldsTotalCounterPanel.setText("");
		doc = koboldsTotalCounterPanel.getStyledDocument();
		changePanelTextStyle(kobolds, koboldsTotalCounterPanel, TOTAL_COUNTER_TEXT, koboldsTotalCounter);
	}
	
	// Sets the value of "Knights of the Frozen Throne" total counter
	public void setKnightsTotalCounter(String value) 
	{
		knightsTotalCounter = value;
		knightsTotalCounterPanel.setText("");
		doc = knightsTotalCounterPanel.getStyledDocument();
		changePanelTextStyle(knights, knightsTotalCounterPanel, TOTAL_COUNTER_TEXT, knightsTotalCounter);
	}
	
	// Sets the value of "Journey to Un'Goro" total counter
	public void setUngoroTotalCounter(String value) 
	{
		ungoroTotalCounter = value;
		ungoroTotalCounterPanel.setText("");
		doc = ungoroTotalCounterPanel.getStyledDocument();
		changePanelTextStyle(ungoro, ungoroTotalCounterPanel, TOTAL_COUNTER_TEXT, ungoroTotalCounter);
	}
	
	// Sets the value of "Mean Streets of Gadgetzan" total counter
	public void setGadgetzanTotalCounter(String value) 
	{
		gadgetzanTotalCounter = value;
		gadgetzanTotalCounterPanel.setText("");
		doc = gadgetzanTotalCounterPanel.getStyledDocument();
		changePanelTextStyle(gadgetzan, gadgetzanTotalCounterPanel, TOTAL_COUNTER_TEXT, gadgetzanTotalCounter);
	}
	
	// Sets the value of "Whispers of the Old Gods" total counter
	public void setOldGodsTotalCounter(String value) 
	{
		oldGodsTotalCounter = value;
		oldGodsTotalCounterPanel.setText("");
		doc = oldGodsTotalCounterPanel.getStyledDocument();
		changePanelTextStyle(oldGods, oldGodsTotalCounterPanel, TOTAL_COUNTER_TEXT, oldGodsTotalCounter);
	}
	
	// Sets the value of "The Grand Tournament" total counter
	public void setTournamentTotalCounter(String value) 
	{
		tournamentTotalCounter = value;
		tournamentTotalCounterPanel.setText("");
		doc = tournamentTotalCounterPanel.getStyledDocument();
		changePanelTextStyle(tournament, tournamentTotalCounterPanel, TOTAL_COUNTER_TEXT, tournamentTotalCounter);
	}
	
	// Sets the value of "Goblins vs Gnomes" total counter
	public void setGoblinsTotalCounter(String value) 
	{
		goblinsTotalCounter = value;
		goblinsTotalCounterPanel.setText("");
		doc = goblinsTotalCounterPanel.getStyledDocument();
		changePanelTextStyle(goblins, goblinsTotalCounterPanel, TOTAL_COUNTER_TEXT, goblinsTotalCounter);
	}
	
	// Sets the value of "Classic" total counter
	public void setClassicTotalCounter(String value) 
	{
		classicTotalCounter = value;
		classicTotalCounterPanel.setText("");
		doc = classicTotalCounterPanel.getStyledDocument();
		changePanelTextStyle(classic, classicTotalCounterPanel, TOTAL_COUNTER_TEXT, classicTotalCounter);
	}
	
	// Returns the "Fractured in Alterac Valley" total modify button
	public ModifierButton getAlteracTotalModify() 
	{
		return alteracTotalModify;
	}
	
	// Returns the "United in Stormwind" total modify button
	public ModifierButton getStormwindTotalModify() 
	{
		return stormwindTotalModify;
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
	
	// Returns the "Fractured in Alterac Valley" total add button
	public RoundButton getAlteracTotalAdd() 
	{
		return alteracTotalAdd;
	}
	
	// Returns the "United in Stormwind" total add button
	public RoundButton getStormwindTotalAdd() 
	{
		return stormwindTotalAdd;
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
	
	// Returns the "Fractured in Alterac Valley" total increment field
	public JTextArea getAlteracTotalIncrement() 
	{
		return alteracTotalIncrement;
	}
	
	// Returns the "United in Stormwind" total increment field
	public JTextArea getStormwindTotalIncrement() 
	{
		return stormwindTotalIncrement;
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
	
	// Returns the "Fractured in Alterac Valley" common button
	public IconButton getAlteracCommonButton() 
	{
		return alteracCommonButton;
	}
	
	// Returns the "United in Stormwind" common button
	public IconButton getStormwindCommonButton() 
	{
		return stormwindCommonButton;
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
	
	// Returns the "Fractured in Alterac Valley" rare button
	public IconButton getAlteracRareButton() 
	{
		return alteracRareButton;
	}
	
	// Returns the "United in Stormwind" rare button
	public IconButton getStormwindRareButton() 
	{
		return stormwindRareButton;
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
	
	// Returns the "Fractured in Alterac Valley" epic button
	public IconButton getAlteracEpicButton() 
	{
		return alteracEpicButton;
	}
	
	// Returns the "United in Stormwind" epic button
	public IconButton getStormwindEpicButton() 
	{
		return stormwindEpicButton;
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
	
	// Returns the "Fractured in Alterac Valley" legendary button
	public IconButton getAlteracLegendaryButton() 
	{
		return alteracLegendaryButton;
	}
	
	// Returns the "United in Stormwind" legendary button
	public IconButton getStormwindLegendaryButton() 
	{
		return stormwindLegendaryButton;
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
	
	// Returns the "Classic" legendary button
	public IconButton getClassicLegendaryButton() 
	{
		return classicLegendaryButton;
	}
}
