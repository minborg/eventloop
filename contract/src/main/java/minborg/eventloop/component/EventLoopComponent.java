package minborg.eventloop.component;

import minborg.eventloop.EventLoop;

public interface EventLoopComponent {

    EventLoop create();

    EventLoop createBlocking();

    EventLoop createGrouping();

}
