package database;

import java.io.File;

public class FileSystemDAO implements DAO{
    @Override
    public boolean doPost(File file) {
        return false;
    }

    @Override
    public File doGet(String fileName) {
        return null;
    }

    @Override
    public String doCheckCurrentHashCodeOfFile(File file) {
        return null;
    }

    @Override
    public String doCheckCurrentHashCodeOfFile(String fileName) {
        return null;
    }

    @Override
    public boolean doPost(byte[] bytes) {
        return false;
    }
}