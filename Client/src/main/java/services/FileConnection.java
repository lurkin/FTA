package services;

import entities.FileDTO;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;

public class FileConnection {

    public FileDTO getFile(Long id) {
        CloseableHttpClient httpclient = HttpClients.createDefault();
        HttpGet httpget = new HttpGet("http://127.0.0.1:8080/get?id=" + id);
//        try (CloseableHttpResponse response = httpclient.execute(httpget)) {
//
//
//        } catch (ClientProtocolException e) {
//            e.printStackTrace();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
        //TODO
        return null;
    }

}
