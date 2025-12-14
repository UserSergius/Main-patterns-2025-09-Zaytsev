package MovementClass;

import GameObject.SpaceShip;
import RotationClasses.AngularVelocity;
import RotationClasses.Direction;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class MoveTest {

    @Mock
    private MovingObject movingObject;

    @Mock
    private Location location;

    @Mock
    private Velocity velocity;

    private Move move;

    @BeforeEach
    void init() {
        move = new Move();
    }

    @Test
    void movement() {

        var location = new Location(12, 5);
        var velocity = new Velocity(-7, 3);
        var direction = new Direction(4, 8);
        var angularVelocity = new AngularVelocity(4);
        var ship = new SpaceShip(location, velocity, direction, angularVelocity);

        move.movement(ship);

        Assertions.assertEquals(5, ship.getLocation().getX());
        Assertions.assertEquals(8, ship.getLocation().getY());
    }

    @Test
    void movement_error_getLocation() {

        Mockito.when(movingObject.getLocation()).thenThrow(new IllegalStateException("cannot read location"));

        var ex = Assertions.assertThrows(IllegalStateException.class, () -> move.movement(movingObject));

        Assertions.assertEquals("cannot read location", ex.getMessage());
    }

    @Test
    void movement_error_getVelocity() {

        Mockito.when(movingObject.getVelocity())
                .thenThrow(new IllegalStateException("cannot read velocity"));

        var ex = Assertions.assertThrows(IllegalStateException.class,() -> move.movement(movingObject));

        Assertions.assertEquals("cannot read velocity", ex.getMessage());
    }

    @Test
    void movement_error_setLocation() {

        Mockito.when(movingObject.getLocation()).thenReturn(location);
        Mockito.when(movingObject.getVelocity()).thenReturn(velocity);

        Mockito.when(velocity.getVx()).thenReturn(1);
        Mockito.when(velocity.getVy()).thenReturn(1);

        Mockito.doThrow(new IllegalStateException("cannot change location")).when(location).setLocation(1, 1);

        var ex = Assertions.assertThrows(IllegalStateException.class, () -> move.movement(movingObject));

        Assertions.assertEquals("cannot change location", ex.getMessage());
    }
}
