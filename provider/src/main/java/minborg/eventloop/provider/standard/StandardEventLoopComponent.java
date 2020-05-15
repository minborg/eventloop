package minborg.eventloop.provider.standard;

import minborg.eventloop.EventLoop;
import minborg.eventloop.component.EventLoopComponent;
import minborg.eventloop.provider.standard.internal.component.InternalEventLoopComponent;

public final class StandardEventLoopComponent implements EventLoopComponent {

    private final EventLoopComponent delegate = new InternalEventLoopComponent();

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