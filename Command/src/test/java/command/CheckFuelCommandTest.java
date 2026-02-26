package command;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class CheckFuelCommandTest {

    @Mock
    private Fuel fuel;

    @Test
    void execute() {
        var requiredValue = 10;
        var checkFuelCommand = new CheckFuelCommand(fuel, requiredValue);
        checkFuelCommand.execute();

        Mockito.verify(fuel, Mockito.times(1)).checkEnoughFuel(requiredValue);
    }
}