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

    @FXML
    public Label cardHeisigKeyword6thEditionContents;

    @FXML
    public Label cardOnReadingContents;

    @FXML
    public Label cardKunReadingContents;

    @FXML
    public Label cardNoteContents;

    @FXML
    private Label cardIDContents;

    @FXML
    private Label cardKanjiContents;

    @FXML
    private Label cardHeisigIndex5thEditionContents;

    @FXML
    private Label cardHeisigIndex6thEditionContents;

    @FXML
    private Label cardHeisigKeyword5thEditionContents;

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
            while (this.dbConnectionPool.dbConnection.ActiveResultSet.next()) {
                this.cardIDContents.setText(this.dbConnectionPool.dbConnection.ActiveResultSet.getString("CARD_ID"));
                this.cardKanjiContents.setText(this.dbConnectionPool.dbConnection.ActiveResultSet.getString("CARD_KANJI"));
                this.cardHeisigIndex5thEditionContents.setText(this.dbConnectionPool.dbConnection.ActiveResultSet.getString("HEISIG_INDEX_5_EDITION"));
                this.cardHeisigIndex6thEditionContents.setText(this.dbConnectionPool.dbConnection.ActiveResultSet.getString("HEISIG_INDEX_6_EDITION"));
                this.cardHeisigKeyword5thEditionContents.setText(this.dbConnectionPool.dbConnection.ActiveResultSet.getString("KEYWORD_5_EDITION"));
                this.cardHeisigKeyword6thEditionContents.setText(this.dbConnectionPool.dbConnection.ActiveResultSet.getString("KEYWORD_6_EDITION"));
                this.cardOnReadingContents.setText(this.dbConnectionPool.dbConnection.ActiveResultSet.getString("ON_READING"));
                this.cardKunReadingContents.setText(this.dbConnectionPool.dbConnection.ActiveResultSet.getString("KUN_READING"));
                this.cardNoteContents.setText(this.dbConnectionPool.dbConnection.ActiveResultSet.getString("NOTE"));
            }
        } catch (SQLException e) {
            Logger.Error("There was an error in connecting to the database: " + e.getLocalizedMessage());
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

}