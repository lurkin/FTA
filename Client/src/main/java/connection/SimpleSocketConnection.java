package connection;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class SimpleSocketConnection implements Connectable {
    private String host;
    private Integer port;
    private Socket socket;

    private BufferedReader msgIn;
    private PrintWriter msgOut;

    private boolean connected = false;

    public SimpleSocketConnection(String host, Integer port) {
        this.host = host;
        this.port = port;
    }

    @Override
    public void connect() {
        try {
            socket = new Socket(host, port);
        } catch (IOException e) {
            System.out.println("Couldn't connect to: " + host + ":" + port + ".");
        }

        try {
            msgIn = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            msgOut = new PrintWriter(socket.getOutputStream(), true);
        } catch (IOException e) {
            System.out.println("Some error occurred during initialization connection.");
        }
        connected = true;

    }

    @Override
    public void write(String msg) {
        if (!connected)
            System.out.println("No connection available.");
        else {

            msgOut.println(msg);
            try {
                String line;
                System.out.println(line = msgIn.readLine());
            } catch (IOException e) {
                System.out.println("No message received.");
            }
        }


    }

    public void disconnect() {
        if (socket.isConnected()) {
            try {
                socket.close();
            } catch (IOException e) {
                System.out.println("Something want wrong during socket closing.");
            }
        }

        connected = false;
    }
}
