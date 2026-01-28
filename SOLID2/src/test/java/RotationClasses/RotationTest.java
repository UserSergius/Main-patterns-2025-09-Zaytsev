package RotationClasses;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)

class RotationTest {

    @Mock
    private RotatingObject rotatingObject;

    @Mock
    private Direction direction;

    @Mock
    private AngularVelocity angularVelocity;

    private Rotation rotation;

    @BeforeEach
    void init() {
        rotation = new Rotation();
    }

    @Test
    void execute() {

        var direction = new Direction(0, 8);
        var angularVelocity = new AngularVelocity(1);

        Mockito.when(rotatingObject.getDirection()).thenReturn(direction);
        Mockito.when(rotatingObject.getAngularVelocity()).thenReturn(angularVelocity);

        rotation.execute(rotatingObject);

        assertEquals(1, direction.getAngle());
    }

    @Test
    void execute_error_getDirection() {

        Mockito.when(rotatingObject.getDirection()).thenThrow(IllegalStateException.class);

        assertThrows(IllegalStateException.class, () -> rotation.execute(rotatingObject));
    }

    @Test
    void execute_error_getAngularVelocity() {

       Mockito.when(rotatingObject.getAngularVelocity()).thenThrow(new IllegalStateException());

       assertThrows(IllegalStateException.class, () -> rotation.execute(rotatingObject));
    }

    @Test
    void execute_error_setDirection() {

        var angularVelocity = new AngularVelocity(1);

        Mockito.when(direction.getAngle()).thenReturn(0);
        Mockito.when(direction.getDirectionNumber()).thenReturn(8);
        Mockito.doThrow(UnsupportedOperationException.class)
                .when(direction).setAngle(Mockito.anyInt());

        Mockito.when(rotatingObject.getDirection()).thenReturn(direction);
        Mockito.when(rotatingObject.getAngularVelocity()).thenReturn(angularVelocity);

        Rotation rotation = new Rotation();

        assertThrows(UnsupportedOperationException.class, () -> rotation.execute(rotatingObject));
    }
}