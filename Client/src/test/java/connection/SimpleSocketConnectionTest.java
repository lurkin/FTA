package connection;

import org.junit.Test;

import javax.swing.*;

import static org.junit.Assert.*;

public class SimpleSocketConnectionTest {

    @Test
    public void testConnection() {
        SimpleSocketConnection socketConnection = new
                SimpleSocketConnection("localhost", 20000);

        socketConnection.connect();

        while (true) {
            socketConnection.write(JOptionPane.showInputDialog(null));
        }
    }

}