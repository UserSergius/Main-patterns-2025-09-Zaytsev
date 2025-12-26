package command;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;

import java.util.Deque;

@RequiredArgsConstructor
@Log4j2
public class PutInQueueCommand implements Command {

    private final Deque<Command> listCommand;
    private final Command command;

    @Override
    public void execute() {
        log.info("Добавление команды {} в очередь.", command.getClass().getSimpleName());
        listCommand.add(command);
    }
}
