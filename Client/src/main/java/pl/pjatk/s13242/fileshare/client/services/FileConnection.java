package pl.pjatk.s13242.fileshare.client.services;


import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.http.HttpHeaders;
import org.apache.http.HttpStatus;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import pl.pjatk.s13242.fileshare.client.dto.FileTree;
import pl.pjatk.s13242.fileshare.client.entities.FileObject;

import java.io.IOException;

public class FileConnection {

    private static String hostname = "http://localhost:8080/";

    private static String sourceDirectory = "E:\\Maciej\\Inne\\FileTransfer\\Client";

    public FileObject getFile(Long id) throws IOException {

        FileObject newFile = new FileObject();
        CloseableHttpClient httpclient = HttpClients.createDefault();
        HttpGet request = new HttpGet(hostname + "tree");

        request.addHeader(HttpHeaders.USER_AGENT, "Googlebot");
        ObjectMapper objectMapper = new ObjectMapper();

        try (CloseableHttpResponse response = httpclient.execute(request);) {
            if (response.getStatusLine().getStatusCode() == HttpStatus.SC_OK)
                newFile =
                        objectMapper.readValue(response.getEntity().getContent(), FileObject.class);
//            else if (response.getStatusLine().getStatusCode() == HttpStatus.SC_NOT_FOUND)
        } catch (ClientProtocolException e) {
            throw new ClientProtocolException("");
        } catch (IOException e) {
            throw new IOException("");
        }
        return newFile;
    }

    public FileTree getRootFileTree() {

        FileTree tree = null;
        CloseableHttpClient httpclient = HttpClients.createDefault();
        HttpGet request = new HttpGet(hostname + "tree");

        request.addHeader(HttpHeaders.USER_AGENT, "Googlebot");
        ObjectMapper objectMapper = new ObjectMapper();

//
        CloseableHttpResponse response2 = send(request);
//
        try (CloseableHttpResponse response = httpclient.execute(request)) {
            tree =
                    objectMapper.readValue(response.getEntity().getContent(), FileTree.class);
        } catch (IOException e) {
            System.err.println(e);
        }
        return tree;
    }

    public static void send(FileTree fileTree) {

    }

    //KUBA
//
    private CloseableHttpResponse send(HttpGet req) {
        try (CloseableHttpResponse response = httpclient.execute(req);) {
            if (response.getStatusLine().getStatusCode() == HttpStatus.SC_OK)
                return response;
//            else if (response.getStatusLine().getStatusCode() == HttpStatus.SC_NOT_FOUND)
        } catch (ClientProtocolException e) {
            throw new ClientProtocolException("");
        } catch (IOException e) {
            throw new IOException("");
        }
    }
}
