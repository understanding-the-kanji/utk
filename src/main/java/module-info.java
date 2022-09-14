module net.samuelcmace.utk {
    requires javafx.controls;
    requires javafx.fxml;


    opens net.samuelcmace.utk to javafx.fxml;
    exports net.samuelcmace.utk;
    exports net.samuelcmace.utk.util;
    opens net.samuelcmace.utk.util to javafx.fxml;
    exports net.samuelcmace.utk.gui.controller;
    opens net.samuelcmace.utk.gui.controller to javafx.fxml;
}