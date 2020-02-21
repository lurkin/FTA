package connection;

import javax.swing.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class SimpleSocketConnection implements Connectable {
    private String host;
    private Integer port;
    private Socket socket;

    private BufferedReader msgServerToClient;
    private PrintWriter msgClientToServer;

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
            msgServerToClient = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            msgClientToServer = new PrintWriter(socket.getOutputStream(), true);
        } catch (IOException e) {
            System.out.println("Some error occurred during initialization connection.");
        }
        connected = true;

        new Thread(() -> {
            while (connected) {
                try {
                    System.out.println(msgServerToClient.readLine());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }).start();
    }

    @Override
    public void write(String msg) {
        Scanner scanner = new Scanner(System.in);
        while (connected) {
            msgClientToServer.println(JOptionPane.showInputDialog(null));
//            try {
//                System.out.println(msgServerToClient.readLine());
//            } catch (IOException e) {
//                e.printStackTrace();
//            }
        }
    }
}
