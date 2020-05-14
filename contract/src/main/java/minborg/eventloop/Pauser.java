package minborg.eventloop;

public interface Pauser {

    void reset();

    void pause();

    void unpause();

}