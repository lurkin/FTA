package pl.pjatk.s13242.fileshare.client.ui;


import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TreeItem;
import javafx.scene.control.TreeView;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import pl.pjatk.s13242.fileshare.client.ClientApp;

import java.io.File;

public class DirectoryViewer extends Application {

    private ClientApp clientApp;

    public DirectoryViewer(){}

    public  DirectoryViewer(ClientApp app) {
        this.clientApp = app;
    }


    @Override
    public void start(Stage primaryStage) throws Exception {

        //FXMLLoader loader = FXMLLoader.load(getClass().getClassLoader().getResource("fileView.fxml"));
        //Parent root = (Parent) loader.load();
        //FileViewController controller = loader.getController();

        //controller.initModel();

        Parent root = FXMLLoader.<Parent>load(getClass().getClassLoader().getResource("fileView.fxml"));

       // FileViewController controller = loader.getController();


        primaryStage.setTitle("FTA Client");
        primaryStage.setScene(new Scene(root));
        primaryStage.show();



    }

}
