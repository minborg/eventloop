package minborg.eventloop.provider.standard;

import minborg.eventloop.Pauser;
import minborg.eventloop.component.PauserComponent;
import minborg.eventloop.provider.standard.internal.component.InternalPauserComponent;

public final class StandardPauserComponent implements PauserComponent {

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