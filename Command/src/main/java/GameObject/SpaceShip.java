package GameObject;

import command.Fuel;
import lombok.AllArgsConstructor;
import lombok.Data;
import MovementClass.Location;
import MovementClass.MovingObject;
import MovementClass.Velocity;
import RotationClasses.AngularVelocity;
import RotationClasses.Direction;
import RotationClasses.RotatingObject;

@Data
@AllArgsConstructor
public class SpaceShip implements MovingObject, RotatingObject {

    private Location location;
    private Velocity velocity;
    private Direction direction;
    private AngularVelocity angularVelocity;
    private Fuel fuel;

    @Override
    public Location getLocation() {
        return location;
    }

    @Override
    public Velocity getVelocity() {
        return velocity;
    }

    @Override
    public Direction getDirection() {
        return direction;
    }

    @Override
    public AngularVelocity getAngularVelocity() {
        return angularVelocity;
    }
}
