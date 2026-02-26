package command;

import GameObject.SpaceShip;
import MovementClass.Location;
import MovementClass.Velocity;
import RotationClasses.AngularVelocity;
import RotationClasses.Direction;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BurnFuelCommandTest {
    @Test
    void excecute() {

        var ship = new SpaceShip(new Location(1,2),
                new Velocity(5,5),
                new Direction(4, 8),
                new AngularVelocity(10),
                new Fuel(20));
        var burnFuelCommand = new BurnFuelCommand(ship.getFuel(), ship);

        burnFuelCommand.execute();

        assertEquals(10, ship.getFuel().getCapacity());
    }
}