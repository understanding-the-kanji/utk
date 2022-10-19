package net.samuelcmace.utk.gui.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import net.samuelcmace.utk.gui.ControllerManager;
import net.samuelcmace.utk.gui.Controllers;
import net.samuelcmace.utk.logic.DBConnectionPool;
import net.samuelcmace.utk.logic.Logger;

import java.sql.SQLException;

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
    private Label cardKanjiContents;

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
    private Label cardHeisigKeyword5thEditionContents;

    /**
     * The FXML Label containing the contents of the Heisig 6th edition keyword.
     */
    @FXML
    public Label cardHeisigKeyword6thEditionContents;

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
     * The DBConnectionPool singleton instance associated with KanjiBrowserController.
     */
    private DBConnectionPool dbConnectionPool;

    /**
     * Initializes a new instance of KanjiBrowserController.
     */
    public KanjiViewController() {
    }

    /**
     * Method called by FXML after the view is loaded.
     */
    public void initialize() {
        try {
            this.dbConnectionPool = DBConnectionPool.GetInstance();
            this.dbConnectionPool.KanjiSearchConnection.RunActiveQuery();
            while (this.dbConnectionPool.KanjiSearchConnection.ActiveResultSet.next()) {
                this.dbConnectionPool.ActivePrimaryKey = Integer.parseInt(this.dbConnectionPool.KanjiSearchConnection.ActiveResultSet.getString("CARD_ID"));
                this.cardIDContents.setText(String.valueOf(this.dbConnectionPool.ActivePrimaryKey));
                this.cardKanjiContents.setText(this.dbConnectionPool.KanjiSearchConnection.ActiveResultSet.getString("CARD_KANJI"));
                this.cardHeisigIndex5thEditionContents.setText(this.dbConnectionPool.KanjiSearchConnection.ActiveResultSet.getString("HEISIG_INDEX_5_EDITION"));
                this.cardHeisigIndex6thEditionContents.setText(this.dbConnectionPool.KanjiSearchConnection.ActiveResultSet.getString("HEISIG_INDEX_6_EDITION"));
                this.cardHeisigKeyword5thEditionContents.setText(this.dbConnectionPool.KanjiSearchConnection.ActiveResultSet.getString("KEYWORD_5_EDITION"));
                this.cardHeisigKeyword6thEditionContents.setText(this.dbConnectionPool.KanjiSearchConnection.ActiveResultSet.getString("KEYWORD_6_EDITION"));
                this.cardOnReadingContents.setText(this.dbConnectionPool.KanjiSearchConnection.ActiveResultSet.getString("ON_READING"));
                this.cardKunReadingContents.setText(this.dbConnectionPool.KanjiSearchConnection.ActiveResultSet.getString("KUN_READING"));
                this.cardNoteContents.setText(this.dbConnectionPool.KanjiSearchConnection.ActiveResultSet.getString("NOTE"));
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
}