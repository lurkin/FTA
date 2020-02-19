package handler;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.concurrent.Callable;

public class Handler implements Callable<Boolean> {

    private Socket socket;

    public Handler(Socket socket) {
        this.socket = socket;
    }

    @Override
    public Boolean call() throws Exception {

        try (BufferedReader msgClientToServer = new BufferedReader(new InputStreamReader(socket.getInputStream()));
             PrintWriter msgServerToClient = new PrintWriter(socket.getOutputStream(), true)) {

            msgServerToClient.write("Proper listening appeared.");

            msgClientToServer.readLine();



        }


        return null;
    }
}
