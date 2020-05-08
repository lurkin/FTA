package pl.pjatk.s13242.fileshare.client.services;


import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.http.HttpHeaders;
import org.apache.http.client.fluent.Request;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import pl.pjatk.s13242.fileshare.client.dto.FileTree;
import pl.pjatk.s13242.fileshare.client.entities.FileObject;

import java.io.File;
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

        CloseableHttpResponse response = httpclient.execute(request);
        try {


            newFile =
                    objectMapper.readValue(response.getEntity().getContent(), FileObject.class);


        } finally {
            response.close();
        }

        return newFile;



//        try {
//            Request.Get("http://localhost:8080/download?id=" + String.valueOf(id))
//                    .execute().saveContent(newFile);
//
//        } catch (IOException e) {
//
//            e.printStackTrace();
//        }

       return newFile;

    }

    public static FileTree getFileTree() throws IOException {

        FileTree tree = new FileTree();

        CloseableHttpClient httpclient = HttpClients.createDefault();

        HttpGet request = new HttpGet(hostname + "tree");


        request.addHeader(HttpHeaders.USER_AGENT, "Googlebot");

        ObjectMapper objectMapper = new ObjectMapper();

        CloseableHttpResponse response = httpclient.execute(request);
        try {

//            System.out.println(response.getProtocolVersion());              // HTTP/1.1
//            System.out.println(response.getStatusLine().getStatusCode());   // 200
//            System.out.println(response.getStatusLine().getReasonPhrase()); // OK
//            System.out.println(response.getStatusLine().toString());        // HTTP/1.1 200 OK

            tree =
                    objectMapper.readValue(response.getEntity().getContent(), FileTree.class);





        } finally {
            response.close();
        }

        return tree;
    }

}
