package handler;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Handler implements Runnable {

    private static final Integer FILEPORT = 20001;

    //Socket to communication
    private Socket msgSocket;

    //Socket to transferring file
    private ServerSocket fileSocket;

    private Boolean active;

    public Handler(Socket socket) {
        this.msgSocket = socket;
        active = true;
        try {
            fileSocket = new ServerSocket(FILEPORT);
        } catch (IOException e) {
            System.out.println("Can't create file socket.");
        }
    }

    @Override
    public void run() {

        try (BufferedReader msgClientToServer = new BufferedReader(new InputStreamReader(msgSocket.getInputStream()));
             PrintWriter msgServerToClient = new PrintWriter(msgSocket.getOutputStream(), true)) {
            String line;
            while (active) {
                line = msgClientToServer.readLine();
                System.out.println(msgSocket.getLocalAddress() + " : " + line);
                msgServerToClient.println(evaluateRequest(line));
            }
        } catch (IOException e) {
            System.out.println("Something want wrong during opening communication streams.");
        }
    }

    private String evaluateRequest(String request) {
        List<String> splittedRequest = new ArrayList<>(Arrays.asList(request.split(" ", 2)));
        String req;
        switch (req = splittedRequest.remove(0)) {
            case "ECHO":
                String finalLine = "";
                for (String s : splittedRequest) finalLine = finalLine.concat(s).concat(" ");
                return finalLine.substring(0, finalLine.length() - 1);
            case "POST":
                receiveFile(splittedRequest.remove(0));
            default:
                return "Unknown command.";
        }
    }

    private void receiveFile(String path) {
        try {
            Socket socket = fileSocket.accept();
            try (InputStream in = socket.getInputStream();
                 OutputStream out = socket.getOutputStream()) {

            } catch (IOException e) {
                System.out.println("Some error occurred during file transferring. ");
            }
        } catch (IOException e) {
            System.out.println("Something want wrong during opening file socket.");
        } finally {
            try {
                fileSocket.close();
            } catch (IOException e) {
                System.out.println("Error occurred during closing file socket.");
            }
        }


    }
}
