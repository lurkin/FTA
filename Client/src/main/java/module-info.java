module Client {
    exports pl.pjatk.s13242.fileshare.client;
    exports pl.pjatk.s13242.fileshare.client.ui;

    opens pl.pjatk.s13242.fileshare.client.ui to javafx.fxml;

    requires org.apache.commons.codec;
    requires javafx.base;
    requires javafx.controls;
    requires javafx.graphics;
    requires javafx.fxml;
    requires com.fasterxml.jackson.databind;
    requires org.apache.httpcomponents.httpcore;
    requires jdk.unsupported;
    requires org.apache.commons.io;
    requires org.apache.httpcomponents.httpclient;
    requires java.prefs;
    requires jpathwatch;
}