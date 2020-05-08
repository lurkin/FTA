package pl.pjatk.s13242.fileshare.client.services;

import static org.junit.jupiter.api.Assertions.*;

class FileConnectionTest {

    @org.junit.jupiter.api.Test
    void getFile() {
        assertNotNull(new FileConnection().getFile(1l));
    }
}