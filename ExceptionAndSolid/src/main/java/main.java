import command.CheckRepeatCommand;
import command.Command;
import command.Test;
import hadler.LoggingHandler;
import hadler.RegistrationHandler;
import hadler.RepeatHandler;
import lombok.RequiredArgsConstructor;

import java.util.Deque;
import java.util.LinkedList;

@RequiredArgsConstructor
public class main {

    public static void main(String[] args) {


        Deque<Command> listCommands = getCommands();
        var exceptionHandler = new RegistrationHandler(listCommands);
        exceptionHandler.registryHandler(Test.class, NullPointerException.class, (cmd, except) -> new LoggingHandler(listCommands));
        exceptionHandler.registryHandler(CheckRepeatCommand.class, RuntimeException.class, (cmd, except) -> new RepeatHandler(listCommands));

        while (!listCommands.isEmpty()) {

            var command = listCommands.pollFirst();
            try {
                System.out.println("Выполнение команды - " + command.getClass().getSimpleName());
                command.execute();
            } catch (Exception exception) {
               var handler = exceptionHandler.getHandler(command, exception);
               handler.handler(command, exception);
            }
        }
    }

    private static Deque<Command> getCommands() {
        Deque<Command> listCommands = new LinkedList<>();

//        var exceptionRepeat = new ExceptionCommand();
        var test = new Test();
        var checkRepeatCommand = new CheckRepeatCommand();

        listCommands.add(checkRepeatCommand);
//        listCommands.add(test);
//        listCommands.add(exceptionRepeat);

        return listCommands;
    }
}
