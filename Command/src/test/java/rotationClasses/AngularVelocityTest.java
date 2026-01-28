package rotationClasses;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class AngularVelocityTest {

    @Test
    void setterAndGetter() {
        var angularVelocity = new AngularVelocity(2);

        Assertions.assertEquals(2, angularVelocity.getAngularVelocity());
    }

}