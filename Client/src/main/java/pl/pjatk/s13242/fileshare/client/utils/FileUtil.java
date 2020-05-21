package pl.pjatk.s13242.fileshare.client.utils;

import pl.pjatk.s13242.fileshare.client.dto.FileTree;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

public class FileUtil {

    public static FileTree getLocalFileTree(String pathToDirectory) throws IOException {

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


    public static String getFileHash(File file) throws IOException {
        try (InputStream is = new FileInputStream(file);) {
            return org.apache.commons.codec.digest.DigestUtils.md5Hex(is);
        } catch (IOException e) {
            throw new IOException("There was some problem during calculation of hash from file");
        }
    }
}
