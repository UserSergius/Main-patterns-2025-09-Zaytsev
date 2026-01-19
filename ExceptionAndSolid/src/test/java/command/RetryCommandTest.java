package command;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Deque;
import java.util.LinkedList;

class RetryCommandTest {

    @Test
    void execute() {

        Deque<Command> listCommand = new LinkedList<>();
        Command command = new ExceptionCommand();
        var retryCommand = new RetryCommand(command, listCommand,1);

        retryCommand.execute();

        Assertions.assertFalse(listCommand.isEmpty());
        Assertions.assertEquals(command, listCommand.getFirst());
    }
}