package command;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class MovingForwardTest {

    @Mock
    private MacroCommand macroCommand;

    @Test
    void movement() {

        var movingForward = new MovingForward(macroCommand);
        movingForward.execute();

        Mockito.verify(macroCommand, Mockito.times(1)).execute();
    }
}