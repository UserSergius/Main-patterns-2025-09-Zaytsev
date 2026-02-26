package command;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FuelTest {

    @Test
    void constructor() {

        var fuel = new Fuel(100);

        assertEquals(100, fuel.getCapacity());
    }

    @Test
    void checkEnoughFuel_exception_notEnoughFuel() {

        var fuel = new Fuel(2);

        var exception = assertThrows(IllegalStateException.class, () -> fuel.checkEnoughFuel(4));
        assertEquals("Невозможно продолжить движения недостаточно топлива. В баке осталось: 2 л.",
                exception.getMessage());
    }
}