import command.Command;
import command.ExceptionCommand;
import command.LightTurnOffCommand;
import command.LightTurnOnCommand;
import command.LoggingCommand;
import command.PutInQueueCommand;
import command.RepeatAfterExceptionCommand;
import command.RepeatCommand;
import command.device.Light;
import hadler.ExceptionHandler;
import lombok.RequiredArgsConstructor;

import java.util.Deque;
import java.util.LinkedList;

@RequiredArgsConstructor
public class main {

    public static void main(String[] args) {


        Deque<Command> listCommands = getCommands();
        var exceptionHandler = new ExceptionHandler();
        exceptionHandler.registryHandler(LightTurnOffCommand.class, IllegalStateException.class, (cmd, except) -> new LoggingCommand(except));
        exceptionHandler.registryHandler(LightTurnOnCommand.class, IllegalStateException.class, (cmd, except) -> new LoggingCommand(except));
        exceptionHandler.registryHandler(RepeatAfterExceptionCommand.class, RuntimeException.class, (cmd, except) -> new RepeatCommand(cmd));
        exceptionHandler.registryHandler(ExceptionCommand.class, IllegalArgumentException.class, (cmd, except) -> new PutInQueueCommand(listCommands, cmd));

        while (!listCommands.isEmpty()) {

            var command = listCommands.pollFirst();
            try {
                command.execute();
            } catch (Exception exception) {
                exceptionHandler.handler(command, exception).execute();
            }
        }
    }

    private static Deque<Command> getCommands() {
        Deque<Command> listCommands = new LinkedList<>();

        var light = new Light();

        var turnOnLight = new LightTurnOnCommand(light);
        var turnOffLight = new LightTurnOffCommand(light);
        var repeatAfterException = new RepeatAfterExceptionCommand();
        var exceptionRepeat = new ExceptionCommand();

//        listCommands.add(repeatAfterException);
        listCommands.add(exceptionRepeat);

        return listCommands;
    }
}
