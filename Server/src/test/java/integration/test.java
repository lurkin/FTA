package integration;

import listener.SocketListener;
import org.junit.Test;

public class test {

    @Test
    public void test(){
        new SocketListener().listen(20000);
    }

}
