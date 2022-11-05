package net.samuelcmace.utk.gui.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.Label;
import javafx.scene.layout.Border;
import net.samuelcmace.utk.gui.ControllerManager;
import net.samuelcmace.utk.gui.Controllers;
import net.samuelcmace.utk.logic.DBConnectionPool;
import net.samuelcmace.utk.logic.Logger;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.sql.SQLException;

import java.awt.Desktop;

/**
 * The controller that corresponds to the KanjiBrowser view.
 */
public class KanjiViewController {

    /**
     * The FXML Label containing the contents of the card ID.
     */
    @FXML
    private Label cardIDContents;

    /**
     * The FXML Label containing the contents of the card's Kanji character.
     */
    @FXML
    private Hyperlink cardKanjiContents;

    /**
     * The FXML Label containing the contents of the 5th edition Heisig index.
     */
    @FXML
    private Label cardHeisigIndex5thEditionContents;

    /**
     * The FXML Label containing the contents of the 6th edition Heisig index.
     */
    @FXML
    private Label cardHeisigIndex6thEditionContents;

    /**
     * The FXML Label containing the contents of the 5th edition Heisig keyword.
     */
    @FXML
    private Hyperlink cardHeisigKeyword5thEditionContents;

    /**
     * The FXML Label containing the contents of the Heisig 6th edition keyword.
     */
    @FXML
    public Hyperlink cardHeisigKeyword6thEditionContents;

    /**
     * The FXML Label containing the Chinese (On) Reading of the Kanji character.
     */
    @FXML
    public Label cardOnReadingContents;

    /**
     * The FXML Label containing the Japanese (Kun) Reading of the Kanji character.
     */
    @FXML
    public Label cardKunReadingContents;

    /**
     * The FXML Label containing the user-entered note contents associated with the character (if any).
     */
    @FXML
    public Label cardNoteContents;

    /**
     * The FXML Button that allows the user to edit the note.
     */
    @FXML
    public Button editNoteButton;

    /**
     * The DBConnectionPool singleton instance associated with KanjiBrowserController.
     */
    private DBConnectionPool dbConnectionPool;

    /**
     * Initializes a new instance of KanjiBrowserController.
     */
    public KanjiViewController() {
    }

    /**
     * Enables the lookup hyperlinks and edit note button upon the completion of a successful database query.
     */
    private void enableFields()
    {
        this.cardKanjiContents.setDisable(false);
        this.cardHeisigKeyword5thEditionContents.setDisable(false);
        this.cardHeisigKeyword6thEditionContents.setDisable(false);
        this.editNoteButton.setDisable(false);
    }

    /**
     * Sets up the default styling for the hyperlinks.
     */
    private void setupHyperlinkStyling()
    {
        this.cardKanjiContents.setBorder(Border.EMPTY);
        this.cardKanjiContents.setPadding(new Insets(4, 0, 4, 0));

        this.cardHeisigKeyword5thEditionContents.setBorder(Border.EMPTY);
        this.cardHeisigKeyword5thEditionContents.setPadding(new Insets(4, 0, 4, 0));

        this.cardHeisigKeyword6thEditionContents.setBorder(Border.EMPTY);
        this.cardHeisigKeyword6thEditionContents.setPadding(new Insets(4, 0, 4, 0));
    }

    /**
     * Method called by FXML after the view is loaded.
     */
    public void initialize() {
        try {
            this.dbConnectionPool = DBConnectionPool.GetInstance();
            this.dbConnectionPool.KanjiSearchConnection.RunActiveQuery();
            while (this.dbConnectionPool.KanjiSearchConnection.ActiveResultSet.next()) {
                String activePrimaryKeyString = this.dbConnectionPool.KanjiSearchConnection.ActiveResultSet.getString("CARD_ID");
                if(activePrimaryKeyString != null)
                {
                    this.dbConnectionPool.ActivePrimaryKey = Integer.parseInt(activePrimaryKeyString);
                    this.cardIDContents.setText(String.valueOf(this.dbConnectionPool.ActivePrimaryKey));
                    this.cardKanjiContents.setText(this.dbConnectionPool.KanjiSearchConnection.ActiveResultSet.getString("CARD_KANJI"));
                    this.cardHeisigIndex5thEditionContents.setText(this.dbConnectionPool.KanjiSearchConnection.ActiveResultSet.getString("HEISIG_INDEX_5_EDITION"));
                    this.cardHeisigIndex6thEditionContents.setText(this.dbConnectionPool.KanjiSearchConnection.ActiveResultSet.getString("HEISIG_INDEX_6_EDITION"));
                    this.cardHeisigKeyword5thEditionContents.setText(this.dbConnectionPool.KanjiSearchConnection.ActiveResultSet.getString("KEYWORD_5_EDITION"));
                    this.cardHeisigKeyword6thEditionContents.setText(this.dbConnectionPool.KanjiSearchConnection.ActiveResultSet.getString("KEYWORD_6_EDITION"));
                    this.cardOnReadingContents.setText(this.dbConnectionPool.KanjiSearchConnection.ActiveResultSet.getString("ON_READING"));
                    this.cardKunReadingContents.setText(this.dbConnectionPool.KanjiSearchConnection.ActiveResultSet.getString("KUN_READING"));
                    this.cardNoteContents.setText(this.dbConnectionPool.KanjiSearchConnection.ActiveResultSet.getString("NOTE"));
                    this.enableFields();
                    this.setupHyperlinkStyling();
                }
            }
        } catch (SQLException e) {
            Logger.Error("There was an error in connecting to the database: " + e.getLocalizedMessage());
        } catch (Exception e) {
            Logger.Error("There was an error in retrieving the database file path: " + e.getLocalizedMessage());
        }
    }

    /**
     * Called when the return button is pressed.
     *
     * @param actionEvent The default arguments passed to the event.
     */
    public void onClick_returnButton(ActionEvent actionEvent) {
        ControllerManager.SwitchScene(Controllers.KANJI_SEARCH);
    }

    /**
     * Called when the edit button is pressed.
     *
     * @param actionEvent The default arguments passed to the event.
     */
    public void onClick_editNoteButton(ActionEvent actionEvent) {
        ControllerManager.SwitchScene(Controllers.KANJI_EDITOR);
    }

    /**
     * Called when the Kanji Card Contents hyperlink is clicked.
     * Opens a new browser window to the JapanDict Kanji Lookup tool.
     *
     * @param actionEvent The default arguments passed to the event.
     */
    public void onClick_cardKanjiContents(ActionEvent actionEvent) {
        try {
            Desktop.getDesktop().browse(new URI("https://japandict.com/kanji/" + this.cardKanjiContents.getText()));
        } catch (IOException e) {
            Logger.Error("There was an Input-Output Exception: " + e.getLocalizedMessage());
        } catch (URISyntaxException e) {
            Logger.Error("There was an Error in the URL Syntax: " + e.getLocalizedMessage());
        }
    }

    /**
     * Called when the Kanji 5th Edition Keyword hyperlink is clicked.
     * Opens a new browser window to the Merriam-Webster's Dictionary with the keyword.
     *
     * @param actionEvent The default arguments passed to the event.
     */
    public void onClick_cardHeisigKeyword5thEditionContents(ActionEvent actionEvent) {
        try {
            Desktop.getDesktop().browse(new URI("https://www.merriam-webster.com/dictionary/" + this.cardHeisigKeyword5thEditionContents.getText()));
        } catch (IOException e) {
            Logger.Error("There was an Input-Output Exception: " + e.getLocalizedMessage());
        } catch (URISyntaxException e) {
            Logger.Error("There was an Error in the URL Syntax: " + e.getLocalizedMessage());
        }
    }

    /**
     * Called when the Kanji 6th Edition Keyword hyperlink is clicked.
     * Opens a new browser window to the Merriam-Webster's Dictionary with the keyword.
     *
     * @param actionEvent The default arguments passed to the event.
     */
    public void onClick_cardHeisigKeyword6thEditionContents(ActionEvent actionEvent) {
        try {
            Desktop.getDesktop().browse(new URI("https://www.merriam-webster.com/dictionary/" + this.cardHeisigKeyword6thEditionContents.getText()));
        } catch (IOException e) {
            Logger.Error("There was an Input-Output Exception: " + e.getLocalizedMessage());
        } catch (URISyntaxException e) {
            Logger.Error("There was an Error in the URL Syntax: " + e.getLocalizedMessage());
        }
    }
}