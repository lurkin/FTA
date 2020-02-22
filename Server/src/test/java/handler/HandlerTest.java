package handler;

import org.junit.BeforeClass;
import org.junit.Test;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

public class HandlerTest {
    private static Handler handler;
    private static Method evalaute;

    @BeforeClass
    public static void init() throws NoSuchMethodException {
        handler = new Handler(new Socket());
        evalaute = Handler.class.getDeclaredMethod("evaluateRequest", String.class);
        evalaute.setAccessible(true);
    }

    @Test
    public void listTest() {
        List<String> list = new ArrayList<>(Arrays.asList("ABC"));
        String line = "";
        for (String s : list) line = line.concat(s);
        assertTrue(line.equals("ABC"));
    }


    @Test
    public void unknownMsg() throws InvocationTargetException, IllegalAccessException {
        assertTrue(evalaute.invoke(Handler.class,"Abc").equals("Unknown command."));
    }

    @Test
    public void echoMsg() throws InvocationTargetException, IllegalAccessException {
        assertTrue(evalaute.invoke(Handler.class,"ECHO ABC").equals("ABC"));
    }

}