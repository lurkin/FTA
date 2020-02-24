package connection;

import java.io.File;

public interface Connectable {
    public boolean connect();

    public String write(String msg);

    public boolean sendFile(File file);

    public File receiveFile();

    public boolean disconnect();

}
