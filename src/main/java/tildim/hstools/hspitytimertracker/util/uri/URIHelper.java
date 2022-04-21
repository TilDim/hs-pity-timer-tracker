package tildim.hstools.hspitytimertracker.util.uri;

import tildim.hstools.hspitytimertracker.exception.URIBrowsingException;

import java.awt.*;
import java.io.IOException;
import java.net.URI;
import java.util.ArrayList;
import java.util.List;

/**
 *
 */
public class URIHelper {

    /**
     * @return
     */
    public static List<URI> getExpansionURIs() {
        List<URI> expansionURIs = new ArrayList<>();

        expansionURIs.add(null);
        expansionURIs.add(URI.create(URIs.GOBLINS_EXPANSION_URI));
        expansionURIs.add(URI.create(URIs.TOURNAMENT_EXPANSION_URI));
        expansionURIs.add(URI.create(URIs.OLDGODS_EXPANSION_URI));
        expansionURIs.add(URI.create(URIs.GADGETZAN_EXPANSION_URI));
        expansionURIs.add(URI.create(URIs.UNGORO_EXPANSION_URI));
        expansionURIs.add(URI.create(URIs.KNIGHTS_EXPANSION_URI));
        expansionURIs.add(URI.create(URIs.KOBOLDS_EXPANSION_URI));
        expansionURIs.add(URI.create(URIs.WITCHWOOD_EXPANSION_URI));
        expansionURIs.add(URI.create(URIs.BOOMSDAY_EXPANSION_URI));
        expansionURIs.add(URI.create(URIs.RUMBLE_EXPANSION_URI));
        expansionURIs.add(URI.create(URIs.SHADOWS_EXPANSION_URI));
        expansionURIs.add(URI.create(URIs.ULDUM_EXPANSION_URI));
        expansionURIs.add(URI.create(URIs.DRAGONS_EXPANSION_URI));
        expansionURIs.add(URI.create(URIs.OUTLAND_EXPANSION_URI));
        expansionURIs.add(URI.create(URIs.SCHOLOMANCE_EXPANSION_URI));
        expansionURIs.add(URI.create(URIs.DARKMOON_EXPANSION_URI));
        expansionURIs.add(URI.create(URIs.BARRENS_EXPANSION_URI));
        expansionURIs.add(URI.create(URIs.STORMWIND_EXPANSION_URI));
        expansionURIs.add(URI.create(URIs.ALTERAC_EXPANSION_URI));
        expansionURIs.add(URI.create(URIs.SUNKEN_EXPANSION_URI));

        return expansionURIs;
    }

    /**
     * @return
     */
    public static List<URI> getCardPackURIs() {
        List<URI> cardPackURIs = new ArrayList<>();

        cardPackURIs.add(URI.create(URIs.CLASSIC_CARD_PACK_URI));
        cardPackURIs.add(URI.create(URIs.GOBLINS_CARD_PACK_URI));
        cardPackURIs.add(URI.create(URIs.TOURNAMENT_CARD_PACK_URI));
        cardPackURIs.add(URI.create(URIs.OLDGODS_CARD_PACK_URI));
        cardPackURIs.add(URI.create(URIs.GADGETZAN_CARD_PACK_URI));
        cardPackURIs.add(URI.create(URIs.UNGORO_CARD_PACK_URI));
        cardPackURIs.add(URI.create(URIs.KNIGHTS_CARD_PACK_URI));
        cardPackURIs.add(URI.create(URIs.KOBOLDS_CARD_PACK_URI));
        cardPackURIs.add(URI.create(URIs.WITCHWOOD_CARD_PACK_URI));
        cardPackURIs.add(URI.create(URIs.BOOMSDAY_CARD_PACK_URI));
        cardPackURIs.add(URI.create(URIs.RUMBLE_CARD_PACK_URI));
        cardPackURIs.add(URI.create(URIs.SHADOWS_CARD_PACK_URI));
        cardPackURIs.add(URI.create(URIs.ULDUM_CARD_PACK_URI));
        cardPackURIs.add(URI.create(URIs.DRAGONS_CARD_PACK_URI));
        cardPackURIs.add(URI.create(URIs.OUTLAND_CARD_PACK_URI));
        cardPackURIs.add(URI.create(URIs.SCHOLOMANCE_CARD_PACK_URI));
        cardPackURIs.add(URI.create(URIs.DARKMOON_CARD_PACK_URI));
        cardPackURIs.add(URI.create(URIs.BARRENS_CARD_PACK_URI));
        cardPackURIs.add(URI.create(URIs.STORMWIND_CARD_PACK_URI));
        cardPackURIs.add(URI.create(URIs.ALTERAC_CARD_PACK_URI));
        cardPackURIs.add(URI.create(URIs.SUNKEN_CARD_PACK_URI));

        return cardPackURIs;
    }

    /**
     * Opens the URI of a webpage
     *
     * @param uri is the URI of the webpage to be opened by a browser
     */
    public static void openURI(URI uri) {
        Desktop desktop = Desktop.isDesktopSupported() ? Desktop.getDesktop() : null;

        if (desktop != null && desktop.isSupported(Desktop.Action.BROWSE)) {
            try {
                desktop.browse(uri);
            } catch (IOException e) {
                throw new URIBrowsingException("Can't open this webpage", e.getCause());
            }
        }
    }

    /**
     * Private constructor to hide the default public one
     */
    private URIHelper() {
    }
}
