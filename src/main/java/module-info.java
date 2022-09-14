module net.samuelcmace.demo {
    requires javafx.controls;
    requires javafx.fxml;


    opens net.samuelcmace.demo to javafx.fxml;
    exports net.samuelcmace.demo;
    exports net.samuelcmace.demo.util;
    opens net.samuelcmace.demo.util to javafx.fxml;
}