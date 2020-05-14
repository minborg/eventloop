package minborg.eventloop.demo;

import minborg.eventloop.EventLoop;
import minborg.eventloop.component.EventLoopComponent;

import java.util.NoSuchElementException;
import java.util.ServiceLoader;

public final class ServiceMain {

    public static void main(String[] args) {

        final EventLoopComponent eventLoopComponent = ServiceLoader.load(EventLoopComponent.class).stream()
                .findFirst()
                .map(ServiceLoader.Provider::get)
                .orElseThrow(NoSuchElementException::new);

        final EventLoop eventLoop = eventLoopComponent.create();
        System.out.println("eventLoop = " + eventLoop);

    }

}
