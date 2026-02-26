package command;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class MovingForward implements Command {

    private final MacroCommand commands;

    @Override
    public void execute() {
        commands.execute();
    }
}
