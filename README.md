# EventLoop - Migrating to a modern API 

## Highlights
This project demonstrates how an existing library can be re-structured so that it:

* Provides a minimum of API exposure
* Supports a component based architecture
* Can optionally be used under various dependency injection frameworks
* Can optionally be used with Java's ServiceLoader
* Retains full compatibility with old legacy code
* Adheres to the Java Platform Module System (JPMS) (optional to use)
* Protects internal classes from deep reflection under JPMS 
* Retains functionality in one place
* Runs under Java 9 and upwards (but can be made to run under Java 8 too with minor changes)
* Supports a business model where more sophisticated components may be offered at a premium price

## Modules
There are several modules in the project:

* "contract" containing the contracts for the eventloop functionality (i.e. interfaces like `EventLoop`)
* "provider' containing a standard internal set of implementations of the "contract" interfaces
* "legacy" containing wrapper classes that provides backward compatibility for old user-land implementations
* "demo" showing the usage of the above modules
* "enterprise" that is vaporware in this version
 
## Application/test usage
Applications only interact using the very slim "contract" module and remain unaware of any and all implementations.
For testing, custom components that provide mockups can be used.  

## Examples

### Service Loader
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
eventLoop = minborg.eventloop.provider.standard.internal.eventloop.StandardEventLoop@b97c004
```

### Direct Use
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
eventLoop = minborg.eventloop.provider.standard.internal.eventloop.StandardEventLoop@3dd3bcd
```

### Dependency Injection
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
eventLoop = minborg.eventloop.provider.standard.internal.eventloop.StandardEventLoop@58c1670b
```

### Legacy
Old code that just instantiates an implementing class can co-exist and continue to work. The (would be `@Depricated`) `VanillaEventLoop` shown hereunder is just a facade that delegates to an implementation obtained from a proper component. 

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

### Enterprise Features
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