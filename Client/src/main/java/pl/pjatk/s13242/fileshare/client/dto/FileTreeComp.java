package pl.pjatk.s13242.fileshare.client.dto;

import pl.pjatk.s13242.fileshare.client.enums.Comparision;

import java.util.List;

public class FileTreeComp extends FileTree {

    private Comparision comparision;
    private List<FileTreeComp> compChildren;

    public Comparision getComparision() {
        return comparision;
    }

    public void setComparision(Comparision comparision) {
        this.comparision = comparision;
    }

    public List<FileTreeComp> getCompChildren() {
        return compChildren;
    }

    public void setCompChildren(List<FileTreeComp> compChildren) {
        this.compChildren = compChildren;
    }
}
