import minborg.eventloop.provider.standard.StandardEventLoopComponent;
import minborg.eventloop.provider.standard.StandardPauserComponent;

module eventloop.provider.standard {
    requires eventloop;

    exports minborg.eventloop.provider.standard;

    provides minborg.eventloop.component.EventLoopComponent with StandardEventLoopComponent;
    provides minborg.eventloop.component.PauserComponent with StandardPauserComponent;

}