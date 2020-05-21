package pl.pjatk.s13242.fileshare.client.utils;

import javafx.scene.Scene;
import org.junit.Before;
import org.junit.jupiter.api.Test;
import pl.pjatk.s13242.fileshare.client.dto.FileTree;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.function.BiPredicate;
import java.util.function.Predicate;

import static org.junit.jupiter.api.Assertions.assertNotNull;

class FileUtilImplTest {

    private FileUtil fileUtil;

    @Before
    public void as() {

        fileUtil = new FileUtil();

    }

    @Test
    public void getNamePath() throws IOException {
        File rootFile = new File("E:\\Maciej\\Inne\\FileTransfer\\Server");
        System.out.println(rootFile.getName());
    }

    @Test
    public void getLocalFileTree() throws IOException {


        FileTree localFileTree = fileUtil.getLocalFileTree("./");
        System.out.println(localFileTree.toString());
        assertNotNull(localFileTree);

    }

    @Test
    public void list() {
        List<FileTree> e = new ArrayList(),
                r = new ArrayList();

        BiPredicate<FileTree, FileTree> predicate = new BiPredicate<FileTree, FileTree>() {
            @Override
            public boolean test(FileTree ft1, FileTree ft2) {

                if (ft1.getFileName() == ft2.getFileName())
                    return true;
                else
                    return false;
            }
        };

        for (FileTree s : e)
            for(FileTree s2:r)
                if(s.getFileName()==s2.getFileName())
                    return;


//            r.stream().filter(fileTree -> s.getFileName() == fileTree.getFileName());


    }
}