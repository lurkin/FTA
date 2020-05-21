package pl.pjatk.s13242.fileshare.client;

import javafx.application.Application;
import pl.pjatk.s13242.fileshare.client.ui.DirectoryViewer;

public class UiThread implements Runnable{

    private ClientApp appClient;

    public UiThread(ClientApp app) {
        this.appClient = app;
    }

    @Override
    public void run() {
        DirectoryViewer dv = new DirectoryViewer(this.appClient);

        dv.launch(DirectoryViewer.class);
    }
}
