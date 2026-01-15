package hadler;

import command.Command;
import command.LoggingCommand;
import lombok.RequiredArgsConstructor;

import java.util.Deque;

@RequiredArgsConstructor
public class LoggingHandler implements ExceptionHandler {

    private final Deque<Command> listCommand;

    @Override
    public void handler(Command command, Exception exception) {
        listCommand.add(new LoggingCommand(exception, command));
    }
}
