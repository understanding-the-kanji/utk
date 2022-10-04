package net.samuelcmace.utk.gui;

/**
 * Defines the Controllers and their corresponding FXML files.
 */
public enum Controllers {
    LOAD, QUIZ, ABOUT, ABOUT_LICENSES, KANJI_BROWSER, KANJI_EDITOR;

    /**
     * Retrieve the file path that corresponds to the corresponding controller.
     *
     * @param m_controller The controller in question.
     * @return The file path that corresponds to the controller.
     */
    public static String FilePath(Controllers m_controller) {
        String filePath;

        switch (m_controller) {
            case LOAD:
                filePath = "fxml/Load.fxml";
                break;
            case QUIZ:
                filePath = "fxml/Quiz.fxml";
                break;
            case ABOUT:
                filePath = "fxml/About.fxml";
                break;
            case ABOUT_LICENSES:
                filePath = "fxml/AboutLicenses.fxml";
                break;
            case KANJI_BROWSER:
                filePath = "fxml/KanjiBrowser.fxml";
                break;
            case KANJI_EDITOR:
                filePath = "fxml/KanjiEditor.fxml";
                break;
            default:
                filePath = "";
                break;
        }

        return filePath;
    }
}
