package hadler;

import command.Command;
import command.NoCommand;

import java.util.HashMap;
import java.util.Map;
import java.util.function.BiFunction;

public class ExceptionHandler {

    private final Map<Class<? extends Command>, Map<Class<? extends Exception>, BiFunction<Command, Exception, Command>>> store = new HashMap<>();

    public Command handler(Command cmd, Exception exc) {

        Map<Class<? extends Exception>, BiFunction<Command, Exception, Command>> handlers = store.get(cmd.getClass());

        if (handlers == null) {
            return new NoCommand(cmd, exc);
        }

//        for (var entry : handlers.entrySet()) {
//            Class<? extends Exception> registeredException = entry.getKey();
//
//            if (registeredException.isAssignableFrom(exc.getClass())) {
//                return entry.getValue().apply(cmd, exc);
//            }
//        }

//        return new NoCommand();

        BiFunction<Command, Exception, Command> commandHandler = handlers.get(exc.getClass());

        if (commandHandler != null) {
            return commandHandler.apply(cmd, exc);
        }

        return new NoCommand(cmd, exc);
    }

    public <C extends Command, E extends Exception> void registryHandler(
            Class<C> commandType,
            Class<E> excType,
            BiFunction<Command, Exception, Command> handler
    ) {
        store.computeIfAbsent(commandType, k -> new HashMap<>()).put(excType, handler);
    }
}
