package minborg.eventloop.provider.standard.internal.component;

import minborg.eventloop.EventLoop;
import minborg.eventloop.component.EventLoopComponent;
import minborg.eventloop.provider.standard.internal.eventloop.BlockingEventLoop;
import minborg.eventloop.provider.standard.internal.eventloop.VanillaEventLoop;

public final class InternalEventLoopComponent implements EventLoopComponent {

    @Override
    public EventLoop create() {
        return new VanillaEventLoop();
    }

    @Override
    public EventLoop createBlocking() {
        return new BlockingEventLoop();
    }

    @Override
    public EventLoop createGrouping() {
        return null;
    }
}
