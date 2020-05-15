package minborg.eventloop.demo.util;

import java.util.NoSuchElementException;
import java.util.Optional;
import java.util.ServiceLoader;

public final class ServiceLoaderUtil {
    private ServiceLoaderUtil(){}

    // Todo: internalise components

    public static <T> T getOrThrow(final Class<T> classToken) {
        return get(classToken)
                .orElseThrow(NoSuchElementException::new);
    }

    public static <T> Optional<T> get(final Class<T> classToken) {
        return ServiceLoader.load(classToken).stream()
                .findFirst()
                .map(ServiceLoader.Provider::get);
    }


}
