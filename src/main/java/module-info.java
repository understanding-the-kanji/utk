module net.samuelcmace.utk {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;
    requires java.desktop;

    opens net.samuelcmace.utk to javafx.fxml;
    exports net.samuelcmace.utk;
    exports net.samuelcmace.utk.logic;
    opens net.samuelcmace.utk.logic to javafx.fxml;
    exports net.samuelcmace.utk.gui.controller;
    opens net.samuelcmace.utk.gui.controller to javafx.fxml;
    exports net.samuelcmace.utk.gui;
    opens net.samuelcmace.utk.gui to javafx.fxml;
}