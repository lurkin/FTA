package database;

import java.io.File;

public interface DAO {
    public boolean doPost(File file);

    public File doGet(String fileName);

    public String doCheckCurrentHashCodeOfFile(File file);

    public String doCheckCurrentHashCodeOfFile(String fileName);

    public boolean doPost(byte[] bytes);
}
