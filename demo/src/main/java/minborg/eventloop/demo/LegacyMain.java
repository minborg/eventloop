package minborg.eventloop.demo;

import net.openhft.chronicle.threads.VanillaEventLoop;

public final class LegacyMain {

    public static void main(String[] args) {
        VanillaEventLoop eventLoop = new VanillaEventLoop();

        System.out.println("eventLoop = " + eventLoop);
    }

}
