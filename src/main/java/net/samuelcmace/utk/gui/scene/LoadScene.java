package net.samuelcmace.utk.gui.scene;

import javafx.scene.Parent;
import javafx.scene.Scene;

import net.samuelcmace.utk.util.Logger;

public class LoadScene extends Scene {

    private Logger logger;

    public LoadScene(Parent parent, double width, double height, Logger m_logger)
    {
        super(parent, width, height);
        this.logger = m_logger;
    }
}
