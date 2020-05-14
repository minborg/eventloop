package minborg.eventloop.demo;

import minborg.eventloop.EventLoop;
import minborg.eventloop.component.EventLoopComponent;
import minborg.eventloop.provider.vanilla.VanillaEventLoopComponent;

public final class DirectMain {

    private static final EventLoopComponent EVENT_LOOP_COMPONENT = new VanillaEventLoopComponent();

    public static void main(String[] args) {
        final EventLoop eventLoop = EVENT_LOOP_COMPONENT.create();
        System.out.println("eventLoop = " + eventLoop);
    }
}
