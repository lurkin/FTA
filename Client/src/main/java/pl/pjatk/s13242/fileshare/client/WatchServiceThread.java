package pl.pjatk.s13242.fileshare.client;

import pl.pjatk.s13242.fileshare.client.dto.FileTree;
import pl.pjatk.s13242.fileshare.client.dto.Request;
import pl.pjatk.s13242.fileshare.client.enums.RequestAction;

import java.io.File;
import java.io.IOException;
import java.nio.file.*;
import java.util.concurrent.BlockingQueue;

import static com.sun.nio.file.ExtendedWatchEventModifier.FILE_TREE;
import static java.nio.file.StandardWatchEventKinds.ENTRY_CREATE;
import static java.nio.file.StandardWatchEventKinds.ENTRY_DELETE;
import static java.nio.file.StandardWatchEventKinds.ENTRY_MODIFY;


public class WatchServiceThread implements Runnable {

    private BlockingQueue<Request> queue;

    private ClientApp appClient;



    public WatchServiceThread(ClientApp app) {

        this.appClient = app;
        this.queue = app.getRequestQueue();
    }

    @Override
    public void run() {


        File directory = new File(appClient.pathRootDirectory);

        try {
            WatchService watchService = FileSystems.getDefault().newWatchService();

            Path path = directory.toPath();

            path.register(watchService,  new WatchEvent.Kind[] {ENTRY_MODIFY, ENTRY_CREATE, ENTRY_DELETE}, FILE_TREE);

            WatchKey key;


            System.out.println("Watcher is on");

            try {
                while ((key = watchService.take()) != null) {
                    for (WatchEvent<?> event : key.pollEvents()) {
                        System.out.println("Event kind:" + event.kind() + ". File affected: " + event.context() + ".");



                        // TODO
                        Request request = new Request(RequestAction.CREATE, new FileTree());


                        appClient.getRequestQueue().put(request);



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