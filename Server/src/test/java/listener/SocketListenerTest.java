package listener;

import org.junit.Test;

import static org.junit.Assert.*;

public class SocketListenerTest {
    @Test
    public void testConnection() {
        Listenable listener = new SocketListener();

        listener.listen(20000);

    }
}