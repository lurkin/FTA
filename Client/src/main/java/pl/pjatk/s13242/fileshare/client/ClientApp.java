package pl.pjatk.s13242.fileshare.client;

import pl.pjatk.s13242.fileshare.client.dto.FileTree;
import pl.pjatk.s13242.fileshare.client.dto.Request;
import pl.pjatk.s13242.fileshare.client.services.ConnectionService;
import pl.pjatk.s13242.fileshare.client.services.ConnectionServiceImpl;
import pl.pjatk.s13242.fileshare.client.utils.FileUtil;

import pl.pjatk.s13242.fileshare.client.utils.FileUtilImpl;

import java.io.IOException;
import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.prefs.Preferences;

public class ClientApp {

    private Preferences prefs;

    private BlockingQueue<Request> requestQueue;

    static public final String pathRootDirectory = "E:\\Maciej\\Inne\\FileTransfer\\Client";

    static public boolean isRunning;

    public static void main(String[] args) throws IOException {

        ClientApp app = new ClientApp();
        app.startup();

    }

    public void startup() throws IOException {

        FileUtilImpl fileUtil = new FileUtilImpl();
        ConnectionService connectionService = new ConnectionServiceImpl();

        requestQueue = new LinkedBlockingQueue<Request>();

        FileTree userFileTree = fileUtil.getLocalFileTree(pathRootDirectory);
        FileTree serverFileTree =  fileUtil.getLocalFileTree("E:\\Maciej\\Inne\\FileTransfer\\Server");
                //connectionService.getRootFileTree();


        fileUtil.compareFileTrees(userFileTree, serverFileTree);

        Thread watchService = new Thread(new WatchServiceThread(this));
        watchService.setDaemon(true);
        watchService.start();

        Thread requestThread = new Thread(new RequestManagerThread(this.getRequestQueue()));
        requestThread.setDaemon(true);
        requestThread.start();


        Thread uiThread = new Thread(new UiThread(this));
        uiThread.setDaemon(true);
        uiThread.start();

        isRunning = true;

        while (isRunning)
        {
            if(!uiThread.isAlive())
            {
                isRunning = false;
            }

            if(!requestThread.isAlive())
            {
                isRunning = false;
            }



        }



    }


    public BlockingQueue<Request> getRequestQueue() {
        return requestQueue;
    }

    public void stopRunning() {
        isRunning = false;
    }

}
