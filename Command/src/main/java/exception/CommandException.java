package exception;

public class CommandException extends IllegalStateException {

    public CommandException(String s) {
        super(s);
    }
}
