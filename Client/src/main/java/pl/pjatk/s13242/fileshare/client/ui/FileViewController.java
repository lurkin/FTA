package pl.pjatk.s13242.fileshare.client.ui;

import javafx.fxml.FXML;
import javafx.scene.control.TreeItem;
import javafx.scene.control.TreeView;
import javafx.scene.input.MouseEvent;

import java.io.File;

public class FileViewController {
    @FXML
    private TreeView fileTree;



    private TreeItem<String> getNodesForDirectory(File directory) { //Returns a TreeItem representation of the specified directory
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


    public void onMouseClicked(MouseEvent mouseEvent) {
    }

    public void initModel() {

        fileTree = new TreeView();
        fileTree.setRoot(getNodesForDirectory(new File("E:\\Maciej\\Inne\\FileTransfer\\Client")));

    }
}
