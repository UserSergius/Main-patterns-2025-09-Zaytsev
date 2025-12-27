package hadler;

import command.Command;
import lombok.RequiredArgsConstructor;

import java.util.Deque;
import java.util.HashMap;
import java.util.Map;
import java.util.function.BiFunction;

@RequiredArgsConstructor
public class RegistrationHandler {

    private final Deque<Command> listCommand;
    private final Map<Class<? extends Command>, Map<Class<? extends Exception>, BiFunction<Command, Exception, ExceptionHandler>>> store = new HashMap<>();

    public ExceptionHandler getHandler(Command cmd, Exception exc) {

        Map<Class<? extends Exception>, BiFunction<Command, Exception, ExceptionHandler>> handlers = store.get(cmd.getClass());

        if (handlers == null) {
            return new NoCommandHandler(listCommand);
        }

        BiFunction<Command, Exception, ExceptionHandler> commandHandler = handlers.get(exc.getClass());

        if (commandHandler != null) {
            return commandHandler.apply(cmd, exc);
        }

        return new NoCommandHandler(listCommand);
    }

    public <C extends Command, E extends Exception> void registryHandler(
            Class<C> commandType,
            Class<E> excType,
            BiFunction<Command, Exception, ExceptionHandler> handler
    ) {
        store.computeIfAbsent(commandType, k -> new HashMap<>()).put(excType, handler);
    }
}
