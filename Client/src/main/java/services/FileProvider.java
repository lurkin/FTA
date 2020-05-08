package services;


import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FileProvider {

    private static String WORKING_PATH = ".";

    public static List<File> getFiles(String path) {
        File root = new File(path);
        List<File> list = new ArrayList(Arrays.asList(root.listFiles()));
        List<File> tmp = new ArrayList<>();

        if (list == null) return null;

        for (File f : list) {
            if (f.isDirectory()) {
                tmp.addAll(getFiles(f.getAbsolutePath()));
            } else {
                tmp.add(f);
            }
        }
        return tmp;
    }

    public static String getWorkingPath() {
        return WORKING_PATH;
    }

    public static void setWorkingPath(String workingPath) {
        WORKING_PATH = workingPath;
    }
}


