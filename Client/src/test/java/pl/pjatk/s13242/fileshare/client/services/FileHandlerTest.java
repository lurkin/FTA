package pl.pjatk.s13242.fileshare.client.services;

import org.junit.jupiter.api.Test;
import pl.pjatk.s13242.fileshare.client.dto.FileTree;

import static org.junit.jupiter.api.Assertions.*;

class FileHandlerTest {

    @Test
    void compareFileTrees() {

        for (FileTree f : FileHandler.getFileToUpload())
            FileConnection.send(f);
    }
}