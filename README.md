# EventLoop 

This project demonstrates how an existing library can be re-structured so that it:

* Provides a minimum of API exposure
* Adhered to the Java Platform Module System
* Protects internal classes from deep reflection 
* Supports a component based architecture
* Can optionally be used under various dependency injection frameworks
* Can optionally be used with Java's ServiceLoader
* Retains full compatibility with old legacy code
* Retains functionality in one place
* Runs under Java 9 and upwards (but can be made to run under Java 8 too with changes)
* Supports a business model where more sophisticated components may be offered at a premium price. 

# Service Loader
Via a utility method, the desired component can be directly acquired and new instances can be created:

```java
public final class ServiceMain {

    public static void main(String[] args) {

        final EventLoopComponent eventLoopComponent = ServiceLoaderUtil.getOrThrow(EventLoopComponent.class);

        final EventLoop eventLoop = eventLoopComponent.create();
        System.out.println("eventLoop = " + eventLoop);

    }

}
```

This might produce:

```text
eventLoop = minborg.eventloop.provider.standard.internal.eventloop.VanillaEventLoop@b97c004
```

# Direct Use
The component can also be explicitly created but this does not allow for a pluggable architecture.

```java
public final class DirectMain {

    private static final EventLoopComponent EVENT_LOOP_COMPONENT = new StandardEventLoopComponent();

    public static void main(String[] args) {
        final EventLoop eventLoop = EVENT_LOOP_COMPONENT.create();
        System.out.println("eventLoop = " + eventLoop);
    }
}
```

This might produce:

```text
eventLoop = minborg.eventloop.provider.standard.internal.eventloop.VanillaEventLoop@3dd3bcd
```

# Dependency Injection
The example below is using Speedment's dependency injection library even though any dependency injection framework can be used.

```java
public class InjectorMain {

    public static void main(String[] args) throws InstantiationException {

        final Injector injector = Injector.builder()
                .withComponent(StandardEventLoopComponent.class)
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
```

This might produce:

```text
eventLoop = minborg.eventloop.provider.standard.internal.eventloop.VanillaEventLoop@58c1670b
```

# Legacy
Old code that just instantiates an implementing class can co-exist and continue to work. The (would be `@Depricated`) `VanillaEventLoop` shown hereunder is just a facade that delegates to an implementation obtained from a component. 

```java
public final class LegacyMain {

    public static void main(String[] args) {
        VanillaEventLoop eventLoop = new VanillaEventLoop();

        System.out.println("eventLoop = " + eventLoop);
    }

}
```

This might produce:

```text
eventLoop = net.openhft.chronicle.threads.VanillaEventLoop@153f5a29
```

# Enterprise Features
Premium components can be plugged in to support a business model where users who pay more gain access to components that produces more sophisticated implementations:

```java
public final class EnterpriseMain {

    public static void main(String[] args) {

        // This assumes that there is an additional provider
        // (e.g. via `requires eventloop.provider.enterprise;`) on the module path.
 
        final EventLoopComponent eventLoopComponent = ServiceLoaderUtil.getOrThrow(EventLoopComponent.class);

        final EventLoop eventLoop = eventLoopComponent.create();
        System.out.println("eventLoop = " + eventLoop);

    }

}
```
This might produce:
```text
eventLoop = minborg.eventloop.provider.enterprise.internal.eventloop.EnterpriseEventLoop@b97c004
```
