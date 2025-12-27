package command;

public class Test implements Command {

    @Override
    public void execute() {
        throw new NullPointerException("Testing exception");
    }
}
