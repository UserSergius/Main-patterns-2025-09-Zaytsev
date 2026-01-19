package command;

import lombok.RequiredArgsConstructor;

import java.util.Deque;

@RequiredArgsConstructor
public class RetryCommand implements Command {

    private final Command command;
    private final Deque<Command> listCommand;
    private int countRetries;

    public RetryCommand(Command commandToRetry, Deque<Command> queue, int retries) {
        this.command = commandToRetry;
        this.listCommand = queue;
        this.countRetries = retries;
    }

    @Override
    public void execute() {
        if (0 < countRetries--) {
            listCommand.add(command);
        }
    }
}
