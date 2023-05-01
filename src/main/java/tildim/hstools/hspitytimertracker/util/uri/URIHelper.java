package tildim.hstools.hspitytimertracker.util.uri;

import java.awt.Desktop;
import java.io.IOException;
import java.net.URI;
import java.util.ArrayList;
import java.util.List;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

/**
 * {@code URIHelper} is a utility class that contains all the necessary methods to process the URIs used by the program.
 *
 * @author Tilemachos Dimos
 * @see URI
 * @see URIs
 */
@Slf4j
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class URIHelper {

    /**
     * Creates the expansion URIs and adds them to a list.
     *
     * @return a list of all the expansion URIs
     */
    public static List<URI> getExpansionURIs() {
        List<URI> expansionURIs = new ArrayList<>();

        expansionURIs.add(URI.create(URIs.FESTIVAL_EXPANSION_URI));
        expansionURIs.add(URI.create(URIs.LICHKING_EXPANSION_URI));
        expansionURIs.add(URI.create(URIs.NATHRIA_EXPANSION_URI));
        expansionURIs.add(URI.create(URIs.SUNKEN_EXPANSION_URI));
        expansionURIs.add(URI.create(URIs.ALTERAC_EXPANSION_URI));
        expansionURIs.add(URI.create(URIs.STORMWIND_EXPANSION_URI));
        expansionURIs.add(URI.create(URIs.BARRENS_EXPANSION_URI));
        expansionURIs.add(URI.create(URIs.DARKMOON_EXPANSION_URI));
        expansionURIs.add(URI.create(URIs.SCHOLOMANCE_EXPANSION_URI));
        expansionURIs.add(URI.create(URIs.OUTLAND_EXPANSION_URI));
        expansionURIs.add(URI.create(URIs.DRAGONS_EXPANSION_URI));
        expansionURIs.add(URI.create(URIs.ULDUM_EXPANSION_URI));
        expansionURIs.add(URI.create(URIs.SHADOWS_EXPANSION_URI));
        expansionURIs.add(URI.create(URIs.RUMBLE_EXPANSION_URI));
        expansionURIs.add(URI.create(URIs.BOOMSDAY_EXPANSION_URI));
        expansionURIs.add(URI.create(URIs.WITCHWOOD_EXPANSION_URI));
        expansionURIs.add(URI.create(URIs.KOBOLDS_EXPANSION_URI));
        expansionURIs.add(URI.create(URIs.KNIGHTS_EXPANSION_URI));
        expansionURIs.add(URI.create(URIs.UNGORO_EXPANSION_URI));
        expansionURIs.add(URI.create(URIs.GADGETZAN_EXPANSION_URI));
        expansionURIs.add(URI.create(URIs.OLDGODS_EXPANSION_URI));
        expansionURIs.add(URI.create(URIs.TOURNAMENT_EXPANSION_URI));
        expansionURIs.add(URI.create(URIs.GOBLINS_EXPANSION_URI));
        expansionURIs.add(null);

        return expansionURIs;
    }

    /**
     * Creates the card pack URIs and adds them to a list.
     *
     * @return a list of all the card pack URIs
     */
    public static List<URI> getCardPackURIs() {
        List<URI> cardPackURIs = new ArrayList<>();

        cardPackURIs.add(URI.create(URIs.FESTIVAL_CARD_PACK_URI));
        cardPackURIs.add(URI.create(URIs.LICHKING_CARD_PACK_URI));
        cardPackURIs.add(URI.create(URIs.NATHRIA_CARD_PACK_URI));
        cardPackURIs.add(URI.create(URIs.SUNKEN_CARD_PACK_URI));
        cardPackURIs.add(URI.create(URIs.ALTERAC_CARD_PACK_URI));
        cardPackURIs.add(URI.create(URIs.STORMWIND_CARD_PACK_URI));
        cardPackURIs.add(URI.create(URIs.BARRENS_CARD_PACK_URI));
        cardPackURIs.add(URI.create(URIs.DARKMOON_CARD_PACK_URI));
        cardPackURIs.add(URI.create(URIs.SCHOLOMANCE_CARD_PACK_URI));
        cardPackURIs.add(URI.create(URIs.OUTLAND_CARD_PACK_URI));
        cardPackURIs.add(URI.create(URIs.DRAGONS_CARD_PACK_URI));
        cardPackURIs.add(URI.create(URIs.ULDUM_CARD_PACK_URI));
        cardPackURIs.add(URI.create(URIs.SHADOWS_CARD_PACK_URI));
        cardPackURIs.add(URI.create(URIs.RUMBLE_CARD_PACK_URI));
        cardPackURIs.add(URI.create(URIs.BOOMSDAY_CARD_PACK_URI));
        cardPackURIs.add(URI.create(URIs.WITCHWOOD_CARD_PACK_URI));
        cardPackURIs.add(URI.create(URIs.KOBOLDS_CARD_PACK_URI));
        cardPackURIs.add(URI.create(URIs.KNIGHTS_CARD_PACK_URI));
        cardPackURIs.add(URI.create(URIs.UNGORO_CARD_PACK_URI));
        cardPackURIs.add(URI.create(URIs.GADGETZAN_CARD_PACK_URI));
        cardPackURIs.add(URI.create(URIs.OLDGODS_CARD_PACK_URI));
        cardPackURIs.add(URI.create(URIs.TOURNAMENT_CARD_PACK_URI));
        cardPackURIs.add(URI.create(URIs.GOBLINS_CARD_PACK_URI));
        cardPackURIs.add(URI.create(URIs.CLASSIC_CARD_PACK_URI));

        return cardPackURIs;
    }

    /**
     * Launches the user-default browser to show a specific URI.
     *
     * @param uri the URI to be shown
     */
    public static void showURI(URI uri) {
        Desktop desktop = Desktop.isDesktopSupported() ? Desktop.getDesktop() : null;

        if (desktop != null && desktop.isSupported(Desktop.Action.BROWSE)) {
            try {
                desktop.browse(uri);
            } catch (IOException e) {
                log.error("Can't show URI");
                e.printStackTrace();
            }
        }
    }

}
