package command;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class RepeatCommand implements Command {

    private final Command command;

    @Override
    public void execute() {
        command.execute();
    }
}
