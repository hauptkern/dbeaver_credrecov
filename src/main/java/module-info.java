module com.hauptkern.dbeaver_credrecov {
    requires javafx.controls;
    requires javafx.fxml;
    requires com.google.gson;


    opens com.hauptkern.dbeaver_credrecov to javafx.fxml;
    opens com.hauptkern.dbeaver_credrecov.utils to javafx.base;
    exports com.hauptkern.dbeaver_credrecov;
    exports com.hauptkern.dbeaver_credrecov.utils;
}