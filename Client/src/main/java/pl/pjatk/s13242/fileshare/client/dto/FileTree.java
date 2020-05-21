package pl.pjatk.s13242.fileshare.client.dto;

import java.util.List;

public class FileTree {

    private String fileName;
    private boolean isDirectory;
    private List<FileTree> children;
    private String fileHash;
    private FileTree parent;

    public void setParent(FileTree fileTree) {
        this.parent = fileTree;
        if (children != null)
            for (FileTree child : children)
                child.setParent(this);

    }

    public FileTree() {

    }

    public FileTree(String fileName) {
        this.fileName = fileName;
    }

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

    public String getFileHash() {
        return fileHash;
    }

    public void setFileHash(String fileHash) {
        this.fileHash = fileHash;
    }

    @Override
    public String toString() {
        String name = null;
        if (parent == null)
            name = "null";
        else
            name = parent.getFileName();

        return "FileTree{" +
                "fileName='" + fileName + '\'' +
                ", isDirectory=" + isDirectory +
                ", fileHash='" + fileHash + '\'' +
                ", parent=" + name +
                ", children=" + children +
                '}';
    }
}
