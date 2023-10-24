package net.samuelcmace.utk.gui;

import java.awt.*;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;

public final class UIHelperMethods {

    /**
     * Private class to prevent instantiation
     */
    private UIHelperMethods() {
    }

    /**
     * Helper method to open a URL in the default web browser in an operating system independent fashion.
     *
     * @param mainUrl     The URL that corresponds to the search engine.
     * @param searchQuery Search query to be sent to the search engine.
     * @throws IOException        Thrown if there is an issue in opening the web link on Linux-based platforms.
     * @throws URISyntaxException Thrown if there is an issue in opening the web link on Windows, macOS, or other non-Linux platforms.
     */
    public static void OpenWebLink(String mainUrl, String searchQuery) throws IOException, URISyntaxException {
        String encodedQuery = URLEncoder.encode(searchQuery, StandardCharsets.UTF_8);
        if (System.getProperty("os.name").equals("Linux")) {
            Runtime.getRuntime().exec(new String[]{"xdg-open", mainUrl + encodedQuery});
        } else {
            Desktop.getDesktop().browse(new URI(mainUrl + encodedQuery));
        }
    }

}
