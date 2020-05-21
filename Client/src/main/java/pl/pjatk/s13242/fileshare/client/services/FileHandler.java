package pl.pjatk.s13242.fileshare.client.services;

import pl.pjatk.s13242.fileshare.client.dto.FileTree;
import pl.pjatk.s13242.fileshare.client.dto.FileTreeComp;
import pl.pjatk.s13242.fileshare.client.enums.Comparision;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class FileHandler {

    private static List<FileTree> fileToDownload,
            fileToUpload,
            fileToDeleteLoc,
            FileToDeleteSer;


    public FileTreeComp compareFileTrees(FileTree localTree, FileTree serverTree) throws Exception {

        FileTreeComp comp = new FileTreeComp();
        comp.setComparision(Comparision.NONE);
        List<FileTreeComp> nodes = new ArrayList<>();
        comp.setCompChildren(nodes);

        if (localTree.isDirectory() == serverTree.isDirectory() == true) {

        }

        Set<FileTree> clientFiles = new HashSet<>(localTree.getChildren());
        Set<FileTree> serverFiles = new HashSet<>(serverTree.getChildren());


        for (FileTree loc : localTree.getChildren())
            for (FileTree ser : serverTree.getChildren())
                if (loc.getFileName() == ser.getFileName()) {

                    evaluateState(loc,ser);

                    if (loc.isDirectory() == ser.isDirectory() == true) {

                        nodes.add(compareFileTrees(loc, ser));
                    } else if (loc.isDirectory() == ser.isDirectory() == false)
                        //TODO oba pliki

//                        if(loc.getFileHash() == ser.getFileHash())
                        ;
                    else
                        throw new Exception("There was problem during comparing: " + loc.getFileName() + " and :" + ser.getFileName());
                }


//        for (FileTree ft : clientFiles) {
//        }
//        if (localTree.getFileName() == serverTree.getFileName()) {
//        }
//        for (FileTree tree : localTree.getChildren()) {
//        }

        return comp;

    }

    private void evaluateState(FileTree loc, FileTree ser) {

        loc.getFileName();
//                switch ()


    }

    public static List<FileTree> getFileToDownload() {
        return fileToDownload;
    }

    public static List<FileTree> getFileToUpload() {
        return fileToUpload;
    }

    public static List<FileTree> getFileToDeleteLoc() {
        return fileToDeleteLoc;
    }

    public static List<FileTree> getFileToDeleteSer() {
        return FileToDeleteSer;
    }
}
