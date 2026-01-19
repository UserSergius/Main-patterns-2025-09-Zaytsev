package hadler;

import command.Command;
import command.ExceptionCommand;
import command.LoggingCommand;
import command.RetryCommand;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Deque;
import java.util.LinkedList;

class UnifyingHandlerTest {

    @Test
    void handler() {

        Deque<Command> listCommand = new LinkedList<>();
        var unifyingHandler = new UnifyingHandler(new RepeatHandler(listCommand), new LoggingHandler(listCommand));

        unifyingHandler.handler(new ExceptionCommand(), new RuntimeException());

        Assertions.assertFalse(listCommand.isEmpty());
        Assertions.assertInstanceOf(RetryCommand.class, listCommand.getFirst());
        Assertions.assertInstanceOf(LoggingCommand.class, listCommand.getLast());
     }
}