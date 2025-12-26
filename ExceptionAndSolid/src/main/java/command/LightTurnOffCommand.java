package command;


import lombok.RequiredArgsConstructor;import command.device.Light;

@RequiredArgsConstructor
public class LightTurnOffCommand implements Command {

    private final Light light;

    @Override
    public void execute() {

        if (light.isTurnOn()) {
            light.off();
            light.setTurnOn(false);
        } else {
            throw new IllegalStateException("Невозможно повторно выключить свет, он уже выключен!");
        }
    }
}
