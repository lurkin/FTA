package pl.pjatk.s13242.fileshare.server.dto;

import java.util.List;
import java.util.Set;

public class FileTree {

    private String fileName;
    private boolean isDirectory;
    private List<FileTree> children;

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public boolean isDirectory() {
        return isDirectory;
    }

    public void setDirectory(boolean directory) {
        isDirectory = directory;
    }


    public List<FileTree> getChildren() {
        return children;
    }

    public void setChildren(List<FileTree> children) {
        this.children = children;
    }
}
