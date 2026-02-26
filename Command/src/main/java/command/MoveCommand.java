package command;

import lombok.RequiredArgsConstructor;
import MovementClass.Location;
import MovementClass.MovingObject;
import MovementClass.Velocity;

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
