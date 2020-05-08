package pl.pjatk.s13242.fileshare.client;

import java.io.File;
import java.io.IOException;
import java.nio.file.*;

public class WatchServiceThread implements Runnable {
    private ClientApp appClient;

    public WatchServiceThread(ClientApp app) {
        this.appClient = app;
    }

    @Override
    public void run() {
        // TODO Auto-generated method stub

        //File directory = appClient.rootDirectory;
        File directory = new File("");

        try {
            WatchService watchService = FileSystems.getDefault().newWatchService();

            Path path = directory.toPath();

            path.register(watchService, StandardWatchEventKinds.ENTRY_CREATE, StandardWatchEventKinds.ENTRY_DELETE,
                    StandardWatchEventKinds.ENTRY_MODIFY);

            WatchKey key;


            System.out.println("Wacher is on");

            try {
                while ((key = watchService.take()) != null) {
                    for (WatchEvent<?> event : key.pollEvents()) {
                        System.out.println("Event kind:" + event.kind() + ". File affected: " + event.context() + ".");
                    }
                    key.reset();

                }
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }

        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }

}