package hadler;

import command.Command;
import command.ExceptionCommand;
import command.LoggingCommand;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Deque;
import java.util.LinkedList;

class LoggingHandlerTest {

    @Test
    void handler() {

        Deque<Command> listCommand = new LinkedList<>();
        var loggingHandler = new LoggingHandler(listCommand);

        loggingHandler.handler(new ExceptionCommand(), new RuntimeException());

        Assertions.assertFalse(listCommand.isEmpty());
        Assertions.assertInstanceOf(LoggingCommand.class, listCommand.getFirst());
    }
}