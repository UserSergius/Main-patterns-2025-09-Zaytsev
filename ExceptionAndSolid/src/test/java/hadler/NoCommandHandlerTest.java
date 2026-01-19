package hadler;

import command.Command;
import command.ExceptionCommand;
import command.NoCommand;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Deque;
import java.util.LinkedList;

class NoCommandHandlerTest {

    @Test
    void handler() {

        Deque<Command> listCommand = new LinkedList<>();
        var noCommandHandler = new NoCommandHandler(listCommand);

        noCommandHandler.handler(new ExceptionCommand(), new RuntimeException());

        Assertions.assertFalse(listCommand.isEmpty());
        Assertions.assertInstanceOf(NoCommand.class, listCommand.getFirst());
    }
}