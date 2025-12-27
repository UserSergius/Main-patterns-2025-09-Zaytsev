package command;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;

@RequiredArgsConstructor
@Log4j2
public class LoggingCommand implements Command {

    private final Exception exception;

    @Override
    public void execute() {
        log.warn("Было выбрашено исключение - {}, ошибка - {}",
                exception.getClass().getSimpleName(), exception.getMessage());
    }
}
