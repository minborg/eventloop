package minborg.eventloop;

import java.io.Closeable;

public interface EventLoop extends Closeable {

    String name();

    void add(EventHandler handler);

    void start();

    void unpause();

    void stop();

    boolean isClosed();

    boolean isAlive();

    void awaitTermination();
}
