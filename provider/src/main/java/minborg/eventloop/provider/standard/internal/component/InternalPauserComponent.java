package minborg.eventloop.provider.standard.internal.component;

import minborg.eventloop.Pauser;
import minborg.eventloop.component.PauserComponent;
import minborg.eventloop.provider.standard.internal.pauser.BusyPauser;
import minborg.eventloop.provider.standard.internal.pauser.YieldingPauser;

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
