package MovementClass;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class LocationTest {

    @Test
    void getterAndSetter() {

        var location = new Location(3, 4);

        Assertions.assertEquals(3, location.getX());
        Assertions.assertEquals(4, location.getY());
    }

    @Test
    void setLocation() {

        var location = new Location(3, 5);
        location.setLocation(7, 9);

        Assertions.assertEquals(10, location.getX());
        Assertions.assertEquals(14, location.getY());
    }

    @Test
    void createDefaultConstructor() {

        var location = new Location();

        Assertions.assertEquals(0, location.getX());
        Assertions.assertEquals(0, location.getY());
    }

    @Test
    void getLocation() {

        var location = new Location(1,2);

        Assertions.assertEquals(location, location.getLocation());
    }
}