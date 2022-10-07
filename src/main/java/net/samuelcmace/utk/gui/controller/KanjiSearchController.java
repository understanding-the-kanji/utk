package net.samuelcmace.utk.gui.controller;

import javafx.event.ActionEvent;
import net.samuelcmace.utk.gui.ControllerManager;
import net.samuelcmace.utk.gui.Controllers;
import net.samuelcmace.utk.gui.MessageBox;
import net.samuelcmace.utk.logic.DBConnectionPool;

/**
 * The controller that corresponds to the Quiz view.
 */
public class KanjiSearchController {

    private DBConnectionPool DBConnectionPool;

    /**
     * Initializes a new instance of KanjiSearchController.
     */
    public KanjiSearchController()
    {
        this.DBConnectionPool = DBConnectionPool.GetInstance();
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
     * @param actionEvent The action that called the event.
     */
    public void searchByCharacterButton_onClick(ActionEvent actionEvent) {
        MessageBox.ShowInfoDialog("You clicked on searchByCharacterButton_onClick.");
    }

    /**
     * The click event to search for the Kanji character by the 5th edition Heisig index.
     * @param actionEvent The action that called the event.
     */
    public void searchBy5thEditionHeisigIndexButton_onClick(ActionEvent actionEvent) {
        MessageBox.ShowInfoDialog("You clicked on searchBy5thEditionHeisigIndexButton_onClick.");
    }

    /**
     * The click event to search for the Kanji character by the 6th edition Heisig index.
     * @param actionEvent The action that called the event.
     */
    public void searchBy6thEditionHeisigIndexButton_onClick(ActionEvent actionEvent) {
        MessageBox.ShowInfoDialog("You clicked on searchBy6thEditionHeisigIndexButton_onClick.");
    }

    /**
     * The click event to search for the Kanji character by the 5th edition Heisig keyword.
     * @param actionEvent The action that called the event.
     */
    public void searchBy5thEditionHeisigKeywordButton_onClick(ActionEvent actionEvent) {
        MessageBox.ShowInfoDialog("You clicked on searchBy5thEditionHeisigKeywordButton_onClick.");
    }

    /**
     * The click event to search for the Kanji character by the 6th edition Heisig keyword.
     * @param actionEvent The action that called the event.
     */
    public void searchBy6thEditionHeisigKeywordButton_onClick(ActionEvent actionEvent) {
        MessageBox.ShowInfoDialog("You clicked on searchBy6thEditionHeisigKeywordButton_onClick.");
    }
}