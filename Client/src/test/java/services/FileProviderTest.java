package services;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.IOException;
import java.util.List;


public class FileProviderTest {

    @Test
    void getFiles() throws IOException {


        List<File> files = new FileProvider().getFiles("./");

        for (File f : files)
            System.out.println(f.getCanonicalPath());


        Assertions.assertNotNull(files);

    }
}