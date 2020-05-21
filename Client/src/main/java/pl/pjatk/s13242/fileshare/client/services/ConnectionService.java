package pl.pjatk.s13242.fileshare.client.services;

import pl.pjatk.s13242.fileshare.client.dto.FileTree;

import java.io.IOException;

public interface ConnectionService {

    public  FileTree getRootFileTree();

    public void downloadFile();

    public void uploadFile();

    public void login();

    public void logout();

}
