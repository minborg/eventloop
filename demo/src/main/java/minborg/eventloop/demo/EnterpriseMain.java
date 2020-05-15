package minborg.eventloop.demo;

import minborg.eventloop.EventLoop;
import minborg.eventloop.component.EventLoopComponent;
import minborg.eventloop.demo.util.ServiceLoaderUtil;

public final class EnterpriseMain {

    public static void main(String[] args) {

        // This assumes that there is an additional provider
        // (e.g. via `requires eventloop.provider.enterprise;`) on the module path.

        // This is not done in this demo but could be easily done.

        final EventLoopComponent eventLoopComponent = ServiceLoaderUtil.getOrThrow(EventLoopComponent.class);

        final EventLoop eventLoop = eventLoopComponent.create();
        System.out.println("eventLoop = " + eventLoop);

    }

}