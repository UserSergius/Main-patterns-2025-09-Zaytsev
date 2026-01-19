package command;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class LoggingCommand implements Command {

    private final Exception exception;
    private final Command command;

    @Override
    public void execute() {
        System.out.printf("Выбрашено исключение - %s, в классе - %s",
                exception.getMessage(),
                command.getClass().getSimpleName()
        );
    }
}
