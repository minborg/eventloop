package minborg.eventloop.demo;

import com.speedment.common.injector.Injector;
import minborg.eventloop.EventLoop;
import minborg.eventloop.component.EventLoopComponent;
import minborg.eventloop.provider.vanilla.VanillaEventLoopComponent;

public class InjectorMain {

    public static void main(String[] args) throws InstantiationException {

        final Injector injector = Injector.builder()
                .withComponent(VanillaEventLoopComponent.class)
                .withComponent(MyRunnable.class)
                .build();

        injector.getOrThrow(MyRunnable.class).run();
    }
    
    
    public static final class MyRunnable implements Runnable {

        private final EventLoopComponent eventLoopComponent; 
        
        public MyRunnable(final EventLoopComponent eventLoopComponent) {
            this.eventLoopComponent = eventLoopComponent;
        }

        @Override
        public void run() {
            final EventLoop eventLoop = eventLoopComponent.create();
            System.out.println("eventLoop = " + eventLoop);
        }
    }

}