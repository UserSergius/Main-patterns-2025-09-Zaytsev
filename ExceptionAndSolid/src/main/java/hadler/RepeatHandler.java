package hadler;

import command.Command;
import command.RetryCommand;
import lombok.RequiredArgsConstructor;

import java.util.Deque;

@RequiredArgsConstructor
public class RepeatHandler implements ExceptionHandler {

    private final Deque<Command> listCommand;

    @Override
    public void handler(Command command, Exception exception) {
        listCommand.add(new RetryCommand(command, listCommand, 0));
    }
}
