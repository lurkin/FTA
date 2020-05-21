package pl.pjatk.s13242.fileshare.client;

import pl.pjatk.s13242.fileshare.client.dto.Request;

import java.util.Queue;
import java.util.concurrent.BlockingQueue;

public class RequestManagerThread implements Runnable {

    private BlockingQueue<Request> queue;

    public RequestManagerThread(BlockingQueue<Request> queue)
    {
        this.queue = queue;
    }

    public void run() {

        while (true) {
            try {
                Request request = queue.take();

                System.out.println("Change");

            } catch (InterruptedException e) {
                // Exception handling.
            }
        }

    }

}

