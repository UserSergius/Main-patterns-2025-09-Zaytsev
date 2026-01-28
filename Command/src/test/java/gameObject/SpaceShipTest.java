package gameObject;

import command.Fuel;
import movementClass.Location;
import movementClass.Velocity;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import rotationClasses.AngularVelocity;
import rotationClasses.Direction;

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