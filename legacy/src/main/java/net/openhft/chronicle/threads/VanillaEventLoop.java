package net.openhft.chronicle.threads;

import minborg.eventloop.EventHandler;
import minborg.eventloop.EventLoop;
import net.openhft.chronicle.threads.internal.InternalEventLoopComponent;

import java.io.IOException;

@Deprecated(forRemoval = true)
public final class VanillaEventLoop implements EventLoop {

    private final EventLoop delegate = InternalEventLoopComponent.INSTANCE.create();

    @Override
    public String name() {
        return delegate.name();
    }

    @Override
    public void add(EventHandler handler) {
        delegate.add(handler);
    }

    @Override
    public void start() {
        delegate.start();
    }

    @Override
    public void unpause() {
        delegate.unpause();
    }

    @Override
    public void stop() {
        delegate.stop();
    }

    @Override
    public boolean isClosed() {
        return delegate.isClosed();
    }

    @Override
    public boolean isAlive() {
        return delegate.isAlive();
    }

    @Override
    public void awaitTermination() {
        delegate.awaitTermination();
    }

    @Override
    public void close() throws IOException {
        delegate.close();
    }

}