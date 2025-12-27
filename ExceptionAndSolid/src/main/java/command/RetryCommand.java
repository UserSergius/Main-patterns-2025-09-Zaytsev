package command;

import lombok.RequiredArgsConstructor;

import java.util.Deque;

@RequiredArgsConstructor
public class RetryCommand implements Command {

    private final Command command;
    private final Deque<Command> listCommand;
    private int retriesLeft;

    public RetryCommand(Command commandToRetry, Deque<Command> queue, int retries) {
        this.command = commandToRetry;
        this.listCommand = queue;
        this.retriesLeft = retries;
    }

    @Override
    public void execute() {
        if (retriesLeft-- > 0) {
            listCommand.add(command);
        }
    }
}
