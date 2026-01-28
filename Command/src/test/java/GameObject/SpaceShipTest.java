package GameObject;

import command.Fuel;
import MovementClass.Location;
import MovementClass.Velocity;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import RotationClasses.AngularVelocity;
import RotationClasses.Direction;

class SpaceShipTest {

    private Location location;
    private Velocity velocity;
    private Direction direction;
    private AngularVelocity angularVelocity;
    private Fuel fuel;

    @BeforeEach
    void init() {
        location = new Location();
        velocity = new Velocity();
        direction = new Direction(2, 4);
        angularVelocity = new AngularVelocity(3);
        fuel = new Fuel(10);
    }

    @Test
    void getLocation() {

        var ship = new SpaceShip(location, velocity, direction, angularVelocity, fuel);

        Assertions.assertEquals(location, ship.getLocation());
    }

    @Test
    void getVelocity() {

        var ship = new SpaceShip(location, velocity, direction, angularVelocity, fuel);

        Assertions.assertEquals(velocity, ship.getVelocity());
    }
}