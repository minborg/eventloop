package minborg.eventloop.demo;

import minborg.eventloop.EventLoop;
import minborg.eventloop.component.EventLoopComponent;
import minborg.eventloop.demo.util.ServiceLoaderUtil;

public final class ServiceMain {

    public static void main(String[] args) {

        final EventLoopComponent eventLoopComponent = ServiceLoaderUtil.getOrThrow(EventLoopComponent.class);

        final EventLoop eventLoop = eventLoopComponent.create();
        System.out.println("eventLoop = " + eventLoop);

    }

}