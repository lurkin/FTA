package handler;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Arrays;
import java.util.List;
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

            evaluateRequest(msgClientToServer.readLine());


        }


        return null;
    }

    public void evaluateRequest(String request) {
        List<String> splittedRequest = Arrays.asList(request.split(" "));
        switch (splittedRequest.remove(0)){

        }
    }
}
