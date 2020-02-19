package listener;

public abstract class Listener implements Listenable{
    protected boolean isListening = false;

    @Override
    public void stop() {
        isListening = false;
    }
}
