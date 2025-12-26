package command;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class RepeatAndLogCommand implements Command {

    private final PutInQueueCommand putInQueueCommand;

    private final LoggingCommand logCommand;

    @Override
    public void execute() {
        putInQueueCommand.execute();

    }
}
