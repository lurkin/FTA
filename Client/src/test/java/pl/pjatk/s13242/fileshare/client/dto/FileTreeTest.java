package pl.pjatk.s13242.fileshare.client.dto;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class FileTreeTest {

    @Test
    public void setParent() {

        FileTree root = new FileTree("root");
        List<FileTree> children = Arrays.asList(new FileTree("aa"), new FileTree("bb"), new FileTree("cc"));
        root.setChildren(children);
        root.setParent(null);
        System.out.println(root);

    }
}

//Post ../root/ab/asd/asd.txt
//101010