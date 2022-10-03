package net.samuelcmace.utk.gui;

public enum Controllers {
    LOAD,
    QUIZ,
    ABOUT,
    KANJI_BROWSER,
    KANJI_EDITOR;

    // Static method to retrieve the file path that corresponds to the enum's value.
    public static String FilePath(Controllers m_controller)
    {
        String filePath;

        switch(m_controller)
        {
            case LOAD:
                filePath = "fxml/Load.fxml";
                break;
            case QUIZ:
                filePath = "fxml/Quiz.fxml";
                break;
            case ABOUT:
                filePath = "fxml/About.fxml";
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
