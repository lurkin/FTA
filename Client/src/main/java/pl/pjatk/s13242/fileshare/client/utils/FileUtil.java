package pl.pjatk.s13242.fileshare.client.utils;


import org.apache.commons.io.FileUtils;
import pl.pjatk.s13242.fileshare.client.entities.FileObject;

import java.io.*;

public class FileUtil {




    public String getFileHash(File file) throws FileNotFoundException {
        String md5 = null;
        InputStream is = new FileInputStream(file);
        try {
            md5 = org.apache.commons.codec.digest.DigestUtils.md5Hex(is);
        } catch (IOException e) {
            e.printStackTrace();
            // TODO
        }

        return md5;

    }

    public File fileObjectToFile(FileObject fo) throws IOException {

        String path = fo.getName();
        File newFile = new File(path);
        FileUtils.writeByteArrayToFile(newFile, fo.getData());


        return newFile;
    }

}
