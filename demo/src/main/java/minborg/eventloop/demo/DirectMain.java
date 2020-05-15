package minborg.eventloop.demo;

import minborg.eventloop.EventLoop;
import minborg.eventloop.component.EventLoopComponent;
import minborg.eventloop.provider.standard.StandardEventLoopComponent;

public final class DirectMain {

    private static final EventLoopComponent EVENT_LOOP_COMPONENT = new StandardEventLoopComponent();

    public static void main(String[] args) {
        final EventLoop eventLoop = EVENT_LOOP_COMPONENT.create();
        System.out.println("eventLoop = " + eventLoop);
    }
}
