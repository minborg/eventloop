module eventloop.demo {

    requires eventloop;
    requires eventloop.provider.vanilla;

    // Enable service discovery
    uses minborg.eventloop.component.EventLoopComponent;

    // A dependency injection library. Could be any
    requires com.speedment.common.injector;

    exports minborg.eventloop.demo;
}