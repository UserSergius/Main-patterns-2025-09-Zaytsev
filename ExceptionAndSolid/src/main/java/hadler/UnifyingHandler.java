package hadler;

import command.Command;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class UnifyingHandler implements ExceptionHandler {

    private final RepeatHandler repeatHandler;
    private final LoggingHandler loggingHandler;


    @Override
    public void handler(Command command, Exception exception) {
        repeatHandler.handler(command, exception);
        loggingHandler.handler(command, exception);
    }
}
