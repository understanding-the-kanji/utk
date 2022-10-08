package net.samuelcmace.utk.gui;

import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.ButtonBar;
import javafx.scene.control.ButtonType;
import javafx.scene.layout.Region;

import java.util.Optional;

/**
 * Utility class to create and display message boxes to the user (without any logging).
 */
public class MessageBox {
    /**
     * Displays a basic modal info dialog.
     *
     * @param message The message to be displayed to the user.
     */
    public static void ShowInfoDialog(String message) {
        Alert dialog = new Alert(AlertType.INFORMATION);
        dialog.setTitle("Information");
        dialog.setHeaderText(null);
        dialog.setContentText(message);
        dialog.showAndWait();
    }

    /**
     * Displays a basic modal info dialog with a custom title.
     *
     * @param message The message to be displayed to the user.
     * @param title   The title of the message box.
     */
    public static void ShowInfoDialog(String message, String title) {
        Alert dialog = new Alert(AlertType.INFORMATION);
        dialog.setTitle(title);
        dialog.setHeaderText(null);
        dialog.setContentText(message);
        dialog.showAndWait();
    }

    /**
     * Displays a basic modal info dialog with a custom title and header content.
     *
     * @param message       The message to be displayed to the user.
     * @param title         The title of the message box.
     * @param headerContent The header content of the message box.
     */
    public static void ShowInfoDialog(String message, String title, String headerContent) {
        Alert dialog = new Alert(AlertType.INFORMATION);
        dialog.setTitle(title);
        dialog.setHeaderText(headerContent);
        dialog.setContentText(message);
        dialog.showAndWait();
    }

    /**
     * Displays a basic info dialog with a custom title and header content. Allows non-modal dialogs.
     *
     * @param message       The message to be displayed to the user.
     * @param title         The title of the message box.
     * @param headerContent The header content of the message box.
     * @param isModal       Specifies whether or not the message box is modal. The default value is true.
     */
    public static void ShowInfoDialog(String message, String title, String headerContent, boolean isModal) {
        Alert dialog = new Alert(AlertType.INFORMATION);
        dialog.setTitle(title);
        dialog.setHeaderText(headerContent);
        dialog.setContentText(message);
        if (isModal == false) dialog.show();
        else dialog.showAndWait();
    }

    /**
     * Displays a basic modal warning dialog.
     *
     * @param message The message to be displayed to the user.
     */
    public static void ShowWarningDialog(String message) {
        Alert dialog = new Alert(AlertType.WARNING);
        dialog.setTitle("Warning");
        dialog.setHeaderText(null);
        dialog.setContentText(message);
        dialog.showAndWait();
    }

    /**
     * Displays a basic warning info dialog with a custom title.
     *
     * @param message The message to be displayed to the user.
     * @param title   The title of the message box.
     */
    public static void ShowWarningDialog(String message, String title) {
        Alert dialog = new Alert(AlertType.WARNING);
        dialog.setTitle(title);
        dialog.setHeaderText(null);
        dialog.setContentText(message);
        dialog.showAndWait();
    }

    /**
     * Displays a basic modal warning dialog with a custom title and header content.
     *
     * @param message       The message to be displayed to the user.
     * @param title         The title of the message box.
     * @param headerContent The header content of the message box.
     */
    public static void ShowWarningDialog(String message, String title, String headerContent) {
        Alert dialog = new Alert(AlertType.WARNING);
        dialog.setTitle(title);
        dialog.setHeaderText(headerContent);
        dialog.setContentText(message);
        dialog.showAndWait();
    }

    /**
     * Displays a basic warning dialog with a custom title and header content. Allows non-modal dialogs.
     *
     * @param message       The message to be displayed to the user.
     * @param title         The title of the message box.
     * @param headerContent The header content of the message box.
     * @param isModal       Specifies whether or not the message box is modal. The default value is true.
     */
    public static void ShowWarningDialog(String message, String title, String headerContent, boolean isModal) {
        Alert dialog = new Alert(AlertType.WARNING);
        dialog.setTitle(title);
        dialog.setHeaderText(headerContent);
        dialog.setContentText(message);
        if (isModal == false) dialog.show();
        else dialog.showAndWait();
    }

    /**
     * Displays a basic modal error dialog.
     *
     * @param message The message to be displayed to the user.
     */
    public static void ShowErrorDialog(String message) {
        Alert dialog = new Alert(AlertType.ERROR);
        dialog.setTitle("Error");
        dialog.setHeaderText(null);
        dialog.setContentText(message);
        dialog.showAndWait();
    }

    /**
     * Displays a basic error info dialog with a custom title.
     *
     * @param message The message to be displayed to the user.
     * @param title   The title of the message box.
     */
    public static void ShowErrorDialog(String message, String title) {
        Alert dialog = new Alert(AlertType.ERROR);
        dialog.setTitle(title);
        dialog.setHeaderText(null);
        dialog.setContentText(message);
        dialog.showAndWait();
    }

    /**
     * Displays a basic modal error dialog with a custom title and header content.
     *
     * @param message       The message to be displayed to the user.
     * @param title         The title of the message box.
     * @param headerContent The header content of the message box.
     */
    public static void ShowErrorDialog(String message, String title, String headerContent) {
        Alert dialog = new Alert(AlertType.ERROR);
        dialog.setTitle(title);
        dialog.setHeaderText(headerContent);
        dialog.setContentText(message);
        dialog.showAndWait();
    }

    /**
     * Displays a basic error dialog with a custom title and header content. Allows non-modal dialogs.
     *
     * @param message       The message to be displayed to the user.
     * @param title         The title of the message box.
     * @param headerContent The header content of the message box.
     * @param isModal       Specifies whether the message box is modal. The default value is true.
     */
    public static void ShowErrorDialog(String message, String title, String headerContent, boolean isModal) {
        Alert dialog = new Alert(AlertType.ERROR);
        dialog.setTitle(title);
        dialog.setHeaderText(headerContent);
        dialog.setContentText(message);
        if (isModal == false) dialog.show();
        else dialog.showAndWait();
    }

    /**
     * Displays a basic yes/no prompt to the user.
     *
     * @param message The message to be promoted to the user.
     * @return Returns true if the user selected YES, otherwise FALSE.
     */
    public static boolean ShowInfoPrompt(String message)
    {
        Alert dialog = new Alert(AlertType.CONFIRMATION);
        dialog.setTitle("Confirmation");
        dialog.setHeaderText(null);
        dialog.setContentText(message);
        dialog.getDialogPane().setMaxHeight(Region.USE_PREF_SIZE);

        // Create two new button types to deal with the yes/no response.
        ButtonType yesButton = new ButtonType("Yes", ButtonBar.ButtonData.YES);
        ButtonType noButton = new ButtonType("No", ButtonBar.ButtonData.NO);

        // Add the buttons to the dialog object, and wait for a response.
        dialog.getButtonTypes().setAll(yesButton, noButton);
        Optional<ButtonType> response = dialog.showAndWait();

        // If the response was OK, then return true. Otherwise, return false.
        if(response.isPresent() && response.get().getButtonData() == ButtonBar.ButtonData.YES)
        {
            return true;
        }
        else
        {
            return false;
        }
    }
}
