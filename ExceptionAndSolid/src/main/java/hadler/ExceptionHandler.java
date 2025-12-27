package hadler;

import command.Command;

public interface ExceptionHandler {

    void handler (Command command, Exception exception);
}
