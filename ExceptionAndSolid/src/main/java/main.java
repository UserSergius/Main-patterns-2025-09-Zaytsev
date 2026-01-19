import command.CheckRepeatCommand;
import command.Command;
import command.ExceptionCommand;
import hadler.LoggingHandler;
import hadler.RegistrationHandler;
import hadler.RepeatHandler;
import hadler.UnifyingHandler;
import lombok.RequiredArgsConstructor;

import java.util.Deque;
import java.util.LinkedList;

@RequiredArgsConstructor
public class main {

    public static void main(String[] args) {

        Deque<Command> listCommands = getCommands();

        var exceptionHandler = new RegistrationHandler(listCommands);
        exceptionHandler.registryHandler(CheckRepeatCommand.class, RuntimeException.class, (cmd, except) -> new LoggingHandler(listCommands));
        exceptionHandler.registryHandler(ExceptionCommand.class, IllegalArgumentException.class,
                (cmd, except) -> new UnifyingHandler(new RepeatHandler(listCommands), new LoggingHandler(listCommands)));

        while (!listCommands.isEmpty()) {

            var command = listCommands.pollFirst();
            try {
                System.out.printf("Command execute: %s%n", command.getClass().getSimpleName());
                command.execute();
            } catch (Exception exception) {
               var errorHandler = exceptionHandler.getHandler(command, exception);
                errorHandler.handler(command, exception);
            }
        }
    }

    private static Deque<Command> getCommands() {
        Deque<Command> listCommands = new LinkedList<>();

        var checkRepeatCommand = new CheckRepeatCommand();
        var exceptionCommand = new ExceptionCommand();

        listCommands.add(checkRepeatCommand);
        listCommands.add(exceptionCommand);
        return listCommands;
    }
}
