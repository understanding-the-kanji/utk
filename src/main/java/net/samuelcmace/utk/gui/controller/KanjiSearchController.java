package net.samuelcmace.utk.gui.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import net.samuelcmace.utk.gui.ControllerManager;
import net.samuelcmace.utk.gui.Controllers;
import net.samuelcmace.utk.logic.DBConnectionPool;
import net.samuelcmace.utk.logic.Logger;

/**
 * The controller that corresponds to the Quiz view.
 */
public class KanjiSearchController {

    /**
     * Singleton instance of the database connection pool associated with the KanjiSearchController.
     */
    private DBConnectionPool dbConnectionPool;

    /**
     * FXML Object in which the user enters the Kanji Character.
     */
    @FXML
    private TextField searchByCharacterTextField;

    /**
     * FXML Object in which the user enters the 5th edition Heisig index.
     */
    @FXML
    private TextField searchBy5thEditionHeisigIndexTextField;

    /**
     * FXML Object in which the user enters the 6th edition Heisig index.
     */
    @FXML
    private TextField searchBy6thEditionHeisigIndexTextField;

    /**
     * FXML Object in which the user enters the 5th edition Heisig keyword.
     */
    @FXML
    private TextField searchBy5thEditionHeisigKeywordTextField;

    /**
     * FXML Object in which the user enters the 6th edition Heisig keyword.
     */
    @FXML
    private TextField searchBy6thEditionHeisigKeywordTextField;

    /**
     * Initializes a new instance of KanjiSearchController.
     */
    public KanjiSearchController() {
        try {
            this.dbConnectionPool = DBConnectionPool.GetInstance();
        } catch (Exception e) {
            Logger.Error(e.getLocalizedMessage());
        }
    }

    /**
     * Called when the return button is pressed.
     *
     * @param actionEvent The default arguments passed to the event.
     */
    public void onClick_returnButton(ActionEvent actionEvent) {
        ControllerManager.SwitchScene(Controllers.LOAD);
    }

    /**
     * The click event to search for the Kanji character information by Kanji character input.
     *
     * @param actionEvent The action that called the event.
     */
    public void searchByCharacterButton_onClick(ActionEvent actionEvent) {
        this.dbConnectionPool.KanjiSearchConnection.getCardByKanji(this.searchByCharacterTextField.getText());
        ControllerManager.SwitchScene(Controllers.KANJI_VIEW);
    }

    /**
     * The click event to search for the Kanji character by the 5th edition Heisig index.
     *
     * @param actionEvent The action that called the event.
     */
    public void searchBy5thEditionHeisigIndexButton_onClick(ActionEvent actionEvent) {
        try {
            this.dbConnectionPool.KanjiSearchConnection.getCardBy5thEditionIndex(Integer.valueOf(this.searchBy5thEditionHeisigIndexTextField.getText()));
            ControllerManager.SwitchScene(Controllers.KANJI_VIEW);
        } catch (NumberFormatException e) {
            Logger.Error("Your Inputted Heisig Index Was Not Formatted Properly: " + e.getLocalizedMessage());
        }
    }

    /**
     * The click event to search for the Kanji character by the 6th edition Heisig index.
     *
     * @param actionEvent The action that called the event.
     */
    public void searchBy6thEditionHeisigIndexButton_onClick(ActionEvent actionEvent) {
        try {
            this.dbConnectionPool.KanjiSearchConnection.getCardBy6thEditionIndex(Integer.valueOf(this.searchBy6thEditionHeisigIndexTextField.getText()));
            ControllerManager.SwitchScene(Controllers.KANJI_VIEW);
        } catch (NumberFormatException e) {
            Logger.Error("Your Inputted Heisig Index Was Not Formatted Properly: " + e.getLocalizedMessage());
        }
    }

    /**
     * The click event to search for the Kanji character by the 5th edition Heisig keyword.
     *
     * @param actionEvent The action that called the event.
     */
    public void searchBy5thEditionHeisigKeywordButton_onClick(ActionEvent actionEvent) {
        this.dbConnectionPool.KanjiSearchConnection.getCardBy5thEditionKeyword(this.searchBy5thEditionHeisigKeywordTextField.getText());
        ControllerManager.SwitchScene(Controllers.KANJI_VIEW);
    }

    /**
     * The click event to search for the Kanji character by the 6th edition Heisig keyword.
     *
     * @param actionEvent The action that called the event.
     */
    public void searchBy6thEditionHeisigKeywordButton_onClick(ActionEvent actionEvent) {
        this.dbConnectionPool.KanjiSearchConnection.getCardBy6thEditionKeyword(this.searchBy6thEditionHeisigKeywordTextField.getText());
        ControllerManager.SwitchScene(Controllers.KANJI_VIEW);
    }
}