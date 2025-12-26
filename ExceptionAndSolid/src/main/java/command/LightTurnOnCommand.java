package command;

import lombok.RequiredArgsConstructor;
import command.device.Light;


@RequiredArgsConstructor
public class LightTurnOnCommand implements Command {

    private final Light light;

    @Override
    public void execute() {

        if (!light.isTurnOn()) {
            light.on();
            light.setTurnOn(true);
        } else {
            throw new IllegalStateException("Свет уже включен, зачем включать повторно!");
        }
    }
}
