package command;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class PutInQueueLogCommand implements Command {

    private final LoggingCommand log;

    private final PutInQueueCommand putInQueue;

    @Override
    public void execute() {
        putInQueue.execute();
    }
}
