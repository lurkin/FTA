package connection;

import java.io.*;
import java.net.Socket;

public class SimpleSocketConnection implements Connectable {
    private final String host;
    private final Integer port;
    private Socket socket;

    private BufferedReader msgIn;
    private PrintWriter msgOut;

    private boolean connected = false;

    public SimpleSocketConnection(String host, Integer port) {
        this.host = host;
        this.port = port;
    }

    @Override
    public boolean connect() {
        try {
            socket = new Socket(host, port);
        } catch (IOException e) {
            System.out.println("Couldn't connect to: " + host + ":" + port + ".");
            return false;
        }

        try {
            msgIn = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            msgOut = new PrintWriter(socket.getOutputStream(), true);
        } catch (IOException e) {
            System.out.println("Some error occurred during initialization connection.");
            return false;
        }
        return connected = true;
    }

    @Override
    public String write(String msg) {
        if (!connected)
            return "No connection available.";
        else {

            msgOut.println(msg);
            try {
                String line;
                return line = msgIn.readLine();
            } catch (IOException e) {
                return "No message received.";
            }
        }
    }

    @Override
    public boolean sendFile(File file) {
        return false;
    }

    @Override
    public File receiveFile() {
        return null;
    }

    @Override
    public boolean disconnect() {
        try {
            socket.close();
        } catch (IOException e) {
            System.out.println("Something want wrong during socket closing.");
            return true;
        }

        return connected = false;
    }
}
