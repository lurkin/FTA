package listener;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class SocketListener extends Listener {
    @Override
    public void listen(Integer port) {
        ServerSocket serverSocket=null;
        try {
            serverSocket = new ServerSocket(port);
        } catch (IOException e) {
            System.out.println("Filed to start listening.");
        }

        isListening = true;

        while (isListening) {
            try {
                Socket socket= serverSocket.accept();
            } catch (IOException e) {
                System.out.println("Failed to establish connection with client.");
            }


        }
    }

}
