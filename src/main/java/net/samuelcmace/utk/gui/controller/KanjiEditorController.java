package net.samuelcmace.utk.gui.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextArea;
import net.samuelcmace.utk.gui.ControllerManager;
import net.samuelcmace.utk.gui.Controllers;
import net.samuelcmace.utk.gui.MessageBox;
import net.samuelcmace.utk.logic.DBConnectionPool;
import net.samuelcmace.utk.logic.Logger;

import java.sql.SQLException;

/**
 * The controller that corresponds to the KanjiEditor view.
 */
public class KanjiEditorController {

    /**
     * The note contents at the time of the last save.
     */
    private String originalNoteContents;

    /**
     * Singleton instance of dbConnectionPool associated with the KanjiEditorController object.
     */
    private DBConnectionPool dbConnectionPool;

    /**
     * Initializes a new instance of KanjiEditorController.
     */
    public KanjiEditorController()
    {
        try {
            this.dbConnectionPool = DBConnectionPool.GetInstance();
        } catch (Exception e) {
            Logger.Error(e.getLocalizedMessage());
        }
    }

    /**
     * FXML GUI object containing the text that the user is entering.
     */
    @FXML
    private TextArea noteEditor;

    /**
     * Method called by the FXML Loader when the view is loaded.
     */
    public void initialize()
    {
        try {
            this.loadContentsFromDisk();
        } catch (SQLException e) {
            Logger.Error("There was an error in connecting to the database: " + e.getLocalizedMessage());
        }
    }

    /**
     * Internal method to write contents to the hard disk database.
     */
    private void writeContentsToDisk() throws SQLException {
        // Use the custom query method to set the currently active card (from the KanjiViewController) to the modified note contents.
        this.dbConnectionPool.KanjiEditorConnection.setNote(this.dbConnectionPool.ActivePrimaryKey, this.noteEditor.getText());

        // Re-set the original note contents to what was modified (to see if it was modified in other areas of the class).
        this.originalNoteContents = this.noteEditor.getText();
    }

    /**
     * Internal method to read contents from the hard disk database.
     */
    private void loadContentsFromDisk() throws SQLException {
        this.dbConnectionPool.KanjiSearchConnection.RunActiveQuery();
        while (this.dbConnectionPool.KanjiSearchConnection.ActiveResultSet.next()) {
            String noteContents = this.dbConnectionPool.KanjiSearchConnection.ActiveResultSet.getString("NOTE");
            if (noteContents != null) this.originalNoteContents = noteContents;
            else this.originalNoteContents = "";
            this.noteEditor.setText(this.originalNoteContents);
        }
    }

    /**
     * Called when the return button is pressed.
     *
     * @param actionEvent The default arguments passed to the event.
     */
    public void onClick_returnButton(ActionEvent actionEvent) {
        // If the note contents in the note editor differ from the last save, prompt the user to save
        if (!this.originalNoteContents.equals(this.noteEditor.getText())) {
            boolean response = MessageBox.ShowInfoPrompt("Would you like to save before you exit?");
            if (response == true) {
                try {
                    this.writeContentsToDisk();
                } catch (SQLException e) {
                    Logger.Error("There was an error in writing the contents to the database: " + e.getLocalizedMessage());
                }
            }
        }
        ControllerManager.SwitchScene(Controllers.KANJI_VIEW);
    }

    /**
     * Called when the reset button is pressed.
     *
     * @param actionEvent The default arguments passed to the event.
     */
    public void onClick_resetButton(ActionEvent actionEvent) {
        boolean response = MessageBox.ShowInfoPrompt("Are you sure you want to reset?");
        if(response == true)
        {
            try {
                this.loadContentsFromDisk();
            } catch (SQLException e) {
                Logger.Error("There was an error in loading the database contents from the disk: " + e.getLocalizedMessage());
            }
        }
    }

    /**
     * Called when the save button is pressed.
     *
     * @param actionEvent The default arguments passed to the event.
     */
    public void onClick_saveButton(ActionEvent actionEvent)
    {
        try {
            this.writeContentsToDisk();
            Logger.Information("Your notes have been saved.");
        } catch (SQLException e) {
            Logger.Error("There was an error in writing the contents to the database: " + e.getLocalizedMessage());
        }
    }
}