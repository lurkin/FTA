package pl.pjatk.s13242.fileshare.client;


import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.TreeItem;
import javafx.scene.control.TreeView;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

import java.io.File;

public class DirectoryViewer extends Application {
    @Override
    public void start(Stage primaryStage) throws Exception {
        TreeView<String> treeView = new TreeView<String>();

        BorderPane b = new BorderPane();

        treeView.setRoot(getNodesForDirectory(new File("E:\\Maciej\\Inne\\FileTransfer\\Client")));

        b.setCenter(treeView);
        primaryStage.setScene(new Scene(b, 600, 400));
        primaryStage.setTitle("FTA Client");
        primaryStage.show();
    }

    public TreeItem<String> getNodesForDirectory(File directory) { //Returns a TreeItem representation of the specified directory
        TreeItem<String> root = new TreeItem<String>(directory.getName());
        for(File f : directory.listFiles()) {
            System.out.println("Loading " + f.getName());
            if(f.isDirectory()) { //Then we call the function recursively
                root.getChildren().add(getNodesForDirectory(f));
            } else {
                root.getChildren().add(new TreeItem<String>(f.getName()));
            }
        }
        return root;
    }
}
