package command;

import lombok.RequiredArgsConstructor;
import movementClass.Location;
import movementClass.MovingObject;
import movementClass.Velocity;

@RequiredArgsConstructor
public class MoveCommand implements Command {

    private final MovingObject obj;

    @Override
    public void execute() {
        Location location = obj.getLocation();
        Velocity velocity = obj.getVelocity();
        location.setLocation(velocity.getVx(), velocity.getVy());
    }
}
