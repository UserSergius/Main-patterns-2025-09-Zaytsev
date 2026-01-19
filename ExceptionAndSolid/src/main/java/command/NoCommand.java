package command;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class NoCommand implements Command {

    private final Command command;

    private final Exception exception;

    @Override
    public void execute() {
        System.out.printf("Нет обработчика для команды - %s с исключением %s.",
                command.getClass().getSimpleName(), exception.getClass().getSimpleName());
    }
}
