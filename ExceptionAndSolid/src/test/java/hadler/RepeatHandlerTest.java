package hadler;

import command.Command;
import command.ExceptionCommand;
import command.RetryCommand;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Deque;
import java.util.LinkedList;

class RepeatHandlerTest {

    @Test
    void handler() {

        Deque<Command> listCommand = new LinkedList<>();
        var loggingHandler = new RepeatHandler(listCommand);

        loggingHandler.handler(new ExceptionCommand(), new RuntimeException());

        Assertions.assertFalse(listCommand.isEmpty());
        Assertions.assertInstanceOf(RetryCommand.class, listCommand.getFirst());
    }
}