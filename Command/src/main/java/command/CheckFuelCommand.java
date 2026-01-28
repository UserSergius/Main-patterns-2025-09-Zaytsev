package command;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class CheckFuelCommand implements Command {

    final private Fuel fuel;
    final private int requiredValue;

    @Override
    public void execute() {
        fuel.checkEnoughFuel(requiredValue);
    }
}
