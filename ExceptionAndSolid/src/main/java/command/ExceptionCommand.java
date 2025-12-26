package command;

public class ExceptionCommand implements Command {

    @Override
    public void execute() {
        throw new IllegalArgumentException("Test");
    }
}
