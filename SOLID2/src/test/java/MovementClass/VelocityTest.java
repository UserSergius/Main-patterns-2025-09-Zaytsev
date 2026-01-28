package MovementClass;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;


class VelocityTest {

    @Test
    void setterAndGetter() {

        var velocity = new Velocity(2, 3);

        Assertions.assertEquals(2, velocity.getVx());
        Assertions.assertEquals(3, velocity.getVy());
    }

    @Test
    void getVelocity() {

        var velocity = new Velocity(4, 5);

        Assertions.assertEquals(velocity, velocity.getVelocity());
    }

    @Test
    void createDefaultConstructor() {

        var velocity = new Velocity();

        Assertions.assertEquals(0, velocity.getVx());
        Assertions.assertEquals(0, velocity.getVy());
    }
}