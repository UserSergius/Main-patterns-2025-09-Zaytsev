package command;


import movementClass.MovingObject;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class BurnFuelCommand implements Command {

    private final Fuel fuel;
    private final MovingObject move;

    @Override
    public void execute() {

        var capacity = fuel.getCapacity();
        var velocity = move.getVelocity().getVy() + move.getVelocity().getVx();

        fuel.setCapacity(capacity - velocity);
    }
}
