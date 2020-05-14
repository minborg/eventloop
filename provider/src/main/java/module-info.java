module eventloop.provider.vanilla {
    requires eventloop;

    exports minborg.eventloop.provider.vanilla;

    provides minborg.eventloop.component.EventLoopComponent with minborg.eventloop.provider.vanilla.VanillaEventLoopComponent;
    provides minborg.eventloop.component.PauserComponent with minborg.eventloop.provider.vanilla.VanillaPauserComponent;

}