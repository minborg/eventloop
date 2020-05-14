package minborg.eventloop;

public interface EventHandler {

    boolean action();

    void onAdded();

    void onRemoved();

}