package pl.pjatk.s13242.fileshare.client.services;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.http.HttpHeaders;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import pl.pjatk.s13242.fileshare.client.dto.FileTree;

import java.io.IOException;

public class ConnectionServiceImpl implements ConnectionService{

    private static String hostname = "http://localhost:8080/";



    @Override
    public FileTree getRootFileTree() {


        FileTree tree = null;
        CloseableHttpClient httpclient = HttpClients.createDefault();
        HttpGet request = new HttpGet(hostname + "tree");


        request.addHeader(HttpHeaders.USER_AGENT, "Googlebot");
        ObjectMapper objectMapper = new ObjectMapper();
        try (CloseableHttpResponse response = httpclient.execute(request)) {




            tree =
                    objectMapper.readValue(response.getEntity().getContent(), FileTree.class);

        } catch (IOException e) {
            System.err.println(e);
        }


        return tree;

    }

    @Override
    public void downloadFile() {

    }

    @Override
    public void uploadFile() {

    }

    @Override
    public void login() {

    }

    @Override
    public void logout() {

    }

    private void executeRequest() {

    }

}
