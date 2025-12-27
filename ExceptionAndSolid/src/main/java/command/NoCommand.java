package command;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;

@Log4j2
@RequiredArgsConstructor
public class NoCommand implements Command {

    private final Command command;

    private final Exception exception;

    @Override
    public void execute() {
        log.warn("Нет обработчика для команды - {} с исключением {}.",
                command.getClass().getSimpleName(), exception.getClass().getSimpleName());
    }
}
