package hadler;

import command.Command;
import command.NoCommand;
import lombok.RequiredArgsConstructor;

import java.util.Deque;

@RequiredArgsConstructor
public class NoCommandHandler implements ExceptionHandler {

    private final Deque<Command> listCommand;

    @Override
    public void handler(Command command, Exception exception) {
        listCommand.add(new NoCommand(command, exception));
    }
}
