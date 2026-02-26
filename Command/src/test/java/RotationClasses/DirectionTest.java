package RotationClasses;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DirectionTest {

    private Direction direction;

    @BeforeEach
    void init() {
        direction = new Direction(1,3);
    }

    @Test
    void getAngle() {
        assertEquals(1, direction.getAngle());
    }

    @Test
    void getDirectionNumber() {
        assertEquals(3, direction.getDirectionNumber());
    }

    @Test
    void setAngle() {
        direction.setAngle(8);
        assertEquals(8, direction.getAngle());
    }

    @Test
    void setDirectionNumber() {
        direction.setDirectionNumber(10);
        assertEquals(10, direction.getDirectionNumber());
    }
}