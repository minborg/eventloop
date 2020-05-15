package minborg.eventloop.provider.standard.internal.eventloop;

import minborg.eventloop.EventHandler;
import minborg.eventloop.EventLoop;

import java.io.IOException;

public final class StandardEventLoop implements EventLoop {

    @Override
    public String name() {
        return null;
    }

    @Override
    public void add(EventHandler handler) {

    }

    @Override
    public void start() {

    }

    @Override
    public void unpause() {

    }

    @Override
    public void stop() {

    }

    @Override
    public boolean isClosed() {
        return false;
    }

    @Override
    public boolean isAlive() {
        return false;
    }

    @Override
    public void awaitTermination() {

    }

    @Override
    public void close() throws IOException {

    }
}
