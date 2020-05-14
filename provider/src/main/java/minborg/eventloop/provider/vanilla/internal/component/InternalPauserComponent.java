package minborg.eventloop.provider.vanilla.internal.component;

import minborg.eventloop.Pauser;
import minborg.eventloop.component.PauserComponent;
import minborg.eventloop.provider.vanilla.internal.pauser.BusyPauser;
import minborg.eventloop.provider.vanilla.internal.pauser.YieldingPauser;

public class InternalPauserComponent implements PauserComponent {

    @Override
    public Pauser createBusy() {
        return new BusyPauser();
    }

    @Override
    public Pauser createYielding() {
        return new YieldingPauser();
    }
}
