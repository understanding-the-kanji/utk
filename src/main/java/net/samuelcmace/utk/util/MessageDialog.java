package net.samuelcmace.utk.util;

import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;

public class MessageDialog
{
    /**
     * Displays a basic modal info dialog.
     * @param message The message to be displayed to the user.
     */
    public static void ShowInfoDialog(String message)
    {
        Alert dialog = new Alert(AlertType.INFORMATION);
        dialog.setTitle("Information");
        dialog.setHeaderText(null);
        dialog.setContentText(message);
        dialog.showAndWait();
    }

    /**
     * Displays a basic modal info dialog with a custom title.
     * @param message The message to be displayed to the user.
     * @param title The title of the message box.
     */
    public static void ShowInfoDialog(String message, String title)
    {
        Alert dialog = new Alert(AlertType.INFORMATION);
        dialog.setTitle(title);
        dialog.setHeaderText(null);
        dialog.setContentText(message);
        dialog.showAndWait();
    }

    /**
     * Displays a basic modal info dialog with a custom title and header content.
     * @param message The message to be displayed to the user.
     * @param title The title of the message box.
     * @param headerContent The header content of the message box.
     */
    public static void ShowInfoDialog(String message, String title, String headerContent)
    {
        Alert dialog = new Alert(AlertType.INFORMATION);
        dialog.setTitle(title);
        dialog.setHeaderText(headerContent);
        dialog.setContentText(message);
        dialog.showAndWait();
    }

    /**
     * Displays a basic info dialog with a custom title and header content. Allows non-modal dialogs.
     * @param message The message to be displayed to the user.
     * @param title The title of the message box.
     * @param headerContent The header content of the message box.
     * @param isModal Specifies whether or not the message box is modal. The default value is true.
     */
    public static void ShowInfoDialog(String message, String title, String headerContent, boolean isModal)
    {
        Alert dialog = new Alert(AlertType.INFORMATION);
        dialog.setTitle(title);
        dialog.setHeaderText(headerContent);
        dialog.setContentText(message);
        if(isModal == false)
            dialog.show();
        else
            dialog.showAndWait();
    }

    /**
     * Displays a basic modal warning dialog.
     * @param message The message to be displayed to the user.
     */
    public static void ShowWarningDialog(String message)
    {
        Alert dialog = new Alert(AlertType.WARNING);
        dialog.setTitle("Warning");
        dialog.setHeaderText(null);
        dialog.setContentText(message);
        dialog.showAndWait();
    }

    /**
     * Displays a basic warning info dialog with a custom title.
     * @param message The message to be displayed to the user.
     * @param title The title of the message box.
     */
    public static void ShowWarningDialog(String message, String title)
    {
        Alert dialog = new Alert(AlertType.WARNING);
        dialog.setTitle(title);
        dialog.setHeaderText(null);
        dialog.setContentText(message);
        dialog.showAndWait();
    }

    /**
     * Displays a basic modal warning dialog with a custom title and header content.
     * @param message The message to be displayed to the user.
     * @param title The title of the message box.
     * @param headerContent The header content of the message box.
     */
    public static void ShowWarningDialog(String message, String title, String headerContent)
    {
        Alert dialog = new Alert(AlertType.WARNING);
        dialog.setTitle(title);
        dialog.setHeaderText(headerContent);
        dialog.setContentText(message);
        dialog.showAndWait();
    }

    /**
     * Displays a basic warning dialog with a custom title and header content. Allows non-modal dialogs.
     * @param message The message to be displayed to the user.
     * @param title The title of the message box.
     * @param headerContent The header content of the message box.
     * @param isModal Specifies whether or not the message box is modal. The default value is true.
     */
    public static void ShowWarningDialog(String message, String title, String headerContent, boolean isModal)
    {
        Alert dialog = new Alert(AlertType.WARNING);
        dialog.setTitle(title);
        dialog.setHeaderText(headerContent);
        dialog.setContentText(message);
        if(isModal == false)
            dialog.show();
        else
            dialog.showAndWait();
    }

    /**
     * Displays a basic modal error dialog.
     * @param message The message to be displayed to the user.
     */
    public static void ShowErrorDialog(String message)
    {
        Alert dialog = new Alert(AlertType.ERROR);
        dialog.setTitle("Error");
        dialog.setHeaderText(null);
        dialog.setContentText(message);
        dialog.showAndWait();
    }

    /**
     * Displays a basic error info dialog with a custom title.
     * @param message The message to be displayed to the user.
     * @param title The title of the message box.
     */
    public static void ShowErrorDialog(String message, String title)
    {
        Alert dialog = new Alert(AlertType.ERROR);
        dialog.setTitle(title);
        dialog.setHeaderText(null);
        dialog.setContentText(message);
        dialog.showAndWait();
    }

    /**
     * Displays a basic modal error dialog with a custom title and header content.
     * @param message The message to be displayed to the user.
     * @param title The title of the message box.
     * @param headerContent The header content of the message box.
     */
    public static void ShowErrorDialog(String message, String title, String headerContent)
    {
        Alert dialog = new Alert(AlertType.ERROR);
        dialog.setTitle(title);
        dialog.setHeaderText(headerContent);
        dialog.setContentText(message);
        dialog.showAndWait();
    }

    /**
     * Displays a basic error dialog with a custom title and header content. Allows non-modal dialogs.
     * @param message The message to be displayed to the user.
     * @param title The title of the message box.
     * @param headerContent The header content of the message box.
     * @param isModal Specifies whether or not the message box is modal. The default value is true.
     */
    public static void ShowErrorDialog(String message, String title, String headerContent, boolean isModal)
    {
        Alert dialog = new Alert(AlertType.ERROR);
        dialog.setTitle(title);
        dialog.setHeaderText(headerContent);
        dialog.setContentText(message);
        if(isModal == false)
            dialog.show();
        else
            dialog.showAndWait();
    }
}
