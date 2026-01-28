package GameObject;

import MovementClass.Location;
import MovementClass.MovingObject;
import MovementClass.Velocity;
import RotationClasses.AngularVelocity;
import RotationClasses.Direction;
import RotationClasses.RotatingObject;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class SpaceShip implements MovingObject, RotatingObject {

    private Location location;
    private Velocity velocity;
    private Direction direction;
    private AngularVelocity angularVelocity;

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
