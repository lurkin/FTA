package pl.pjatk.s13242.fileshare.client.dto;

import pl.pjatk.s13242.fileshare.client.enums.RequestAction;

public class Request {

    private RequestAction action;

    private FileTree fileTree;

    public Request(RequestAction action, FileTree fileTree) {
        this.action = action;
        this.fileTree = fileTree;
    }

    public RequestAction getAction() {
        return action;
    }

    public void setAction(RequestAction action) {
        this.action = action;
    }

    public FileTree getFileTree() {
        return fileTree;
    }

    public void setFileTree(FileTree fileTree) {
        this.fileTree = fileTree;
    }

    @Override
    public String toString() {
        return "Request{" +
                "action=" + action +
                ", fileTree=" + fileTree +
                '}';
    }
}
