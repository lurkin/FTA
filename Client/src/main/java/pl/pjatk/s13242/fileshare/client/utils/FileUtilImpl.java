package pl.pjatk.s13242.fileshare.client.utils;


import javafx.scene.control.TreeItem;
import org.apache.commons.io.FileUtils;
import pl.pjatk.s13242.fileshare.client.dto.FileTree;
import pl.pjatk.s13242.fileshare.client.dto.FileTreeComp;
import pl.pjatk.s13242.fileshare.client.entities.FileObject;
import pl.pjatk.s13242.fileshare.client.enums.Comparision;

import java.io.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class FileUtilImpl  {


    public FileTree getLocalFileTree(String pathToDirectory) throws IOException {

        FileTree fileTree = new FileTree();
        File rootFile = new File(pathToDirectory);

        fileTree.setDirectory(true);
        fileTree.setFileName(rootFile.getName());

        List<FileTree> treeList = new ArrayList<>();

        for (File file : rootFile.listFiles()) {

            FileTree nodeTree = new FileTree();
            if (file.isDirectory()) {
                nodeTree = getLocalFileTree(file.getPath());
            } else {
                nodeTree.setFileName(file.getName());
                nodeTree.setFileHash(getFileHash(file));
            }
            treeList.add(nodeTree);
        }
        fileTree.setChildren(treeList);

        return fileTree;
    }


    public FileTreeComp compareFileTrees(FileTree localTree, FileTree serverTree) {

        FileTreeComp comp = new FileTreeComp();

        comp.setComparision(Comparision.NONE);

        if (localTree.isDirectory() == serverTree.isDirectory()) {

        }

        Set<FileTree> clientFiles = new HashSet<FileTree>(localTree.getChildren());
        Set<FileTree> serverFiles = new HashSet<FileTree>(serverTree.getChildren());

        for (FileTree ft : clientFiles) {

        }


        if (localTree.getFileName() == serverTree.getFileName()) {


        }

        for (FileTree tree : localTree.getChildren()) {

        }
        ;


        return comp;

    }

    public static String getFileHash(File file) throws IOException {
        try (InputStream is = new FileInputStream(file);) {
            return org.apache.commons.codec.digest.DigestUtils.md5Hex(is);
        } catch (IOException e) {
            throw new IOException("There was some problem during calculation of hash from file");
        }
    }
}
