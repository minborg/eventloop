package minborg.eventloop.provider.vanilla;

import minborg.eventloop.Pauser;
import minborg.eventloop.component.PauserComponent;
import minborg.eventloop.provider.vanilla.internal.component.InternalPauserComponent;

public final class VanillaPauserComponent implements PauserComponent {

    private final PauserComponent delegate = new InternalPauserComponent();

    @Override
    public Pauser createBusy() {
        return delegate.createBusy();
    }

    @Override
    public Pauser createYielding() {
        return delegate.createYielding();
    }

}