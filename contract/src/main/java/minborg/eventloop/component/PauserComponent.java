package minborg.eventloop.component;

import minborg.eventloop.Pauser;

public interface PauserComponent {

    Pauser createBusy();

    Pauser createYielding();

}
