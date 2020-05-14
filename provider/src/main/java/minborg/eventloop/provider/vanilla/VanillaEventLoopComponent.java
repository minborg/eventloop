package minborg.eventloop.provider.vanilla;

import minborg.eventloop.EventLoop;
import minborg.eventloop.component.EventLoopComponent;
import minborg.eventloop.provider.vanilla.internal.component.InternalEventLoopComponent;

public final class VanillaEventLoopComponent implements EventLoopComponent {

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