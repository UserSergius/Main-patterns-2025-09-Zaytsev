package GameObject;

import MovementClass.Location;
import MovementClass.Velocity;
import RotationClasses.AngularVelocity;
import RotationClasses.Direction;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class SpaceShipTest {

    private Location location;
    private Velocity velocity;
    private Direction direction;
    private AngularVelocity angularVelocity;

    @BeforeEach
    void init() {
        location = new Location();
        velocity = new Velocity();
        direction = new Direction(2, 4);
        angularVelocity = new AngularVelocity(3);
    }

    @Test
    void getLocation() {

        var ship = new SpaceShip(location, velocity, direction, angularVelocity);

        Assertions.assertEquals(location, ship.getLocation());
    }

    @Test
    void getVelocity() {

        var ship = new SpaceShip(location, velocity, direction, angularVelocity);

        Assertions.assertEquals(velocity, ship.getVelocity());
    }
}