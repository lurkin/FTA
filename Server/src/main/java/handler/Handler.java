package handler;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Handler implements Runnable {

    //Configuration of file transferring method
    private static final Integer FILE_PORT = 20001;
    public final static int FILE_SIZE = 204800; //Limited up to 25MB

    //Socket to communication
    private Socket msgSocket;

    //Socket to transferring file
    private ServerSocket fileSocket;

    private Boolean active;

    public Handler(Socket socket) {
        this.msgSocket = socket;
        active = true;
        try {
            fileSocket = new ServerSocket(FILE_PORT);
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

        //Byte array for received file
        byte[] byteArray = new byte[FILE_SIZE];

        //Int to mange bytes loop
        int bytesRead, current = 0;

        //Streams and socket
        FileOutputStream fos = null;
        Socket socket = null;


        try {
            socket = fileSocket.accept();

            //Reading file from input stream
            try (InputStream in = socket.getInputStream()) {
                do {
                    bytesRead =
                            in.read(byteArray, current, (byteArray.length - current));
                    if (bytesRead >= 0) current += bytesRead;
                } while (bytesRead > -1);
            } catch (IOException e) {
                System.out.println("Some error occurred during file transferring. ");
            }

            //Saving File
            try (BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(path))) {
                bos.write(byteArray, 0, current);
                bos.flush();
            } catch (IOException e) {
                System.out.println("Some error occurred during saving file.");
            }
        } catch (IOException e) {
            System.out.println("Something want wrong during opening file socket.");
        } finally {
            try {
                if (socket != null)
                    socket.close();
            } catch (IOException e) {
                System.out.println("Error occurred during closing file socket.");
            }
        }
    }
}