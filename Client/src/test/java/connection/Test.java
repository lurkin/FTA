package connection;

public class Test {

    @org.junit.Test
    public void test(){
        SimpleSocketConnection s=new SimpleSocketConnection("localhost",20000);
        s.connect();
        System.out.println("Here");
        s.write("abc");
    }

}
