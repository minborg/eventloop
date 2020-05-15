package net.openhft.chronicle.threads.internal;

import minborg.eventloop.EventLoop;
import minborg.eventloop.component.EventLoopComponent;
import minborg.eventloop.provider.standard.StandardEventLoopComponent;

public enum InternalEventLoopComponent implements EventLoopComponent {
    INSTANCE;

    private final EventLoopComponent delegate = new StandardEventLoopComponent();

    @Override
    public EventLoop create() {
        return delegate.create();
    }

    @Override
    public EventLoop createBlocking() {
        return delegate.createBlocking();
    }

    @Override
    public EventLoop createGrouping() {
        return delegate.createGrouping();
    }


}