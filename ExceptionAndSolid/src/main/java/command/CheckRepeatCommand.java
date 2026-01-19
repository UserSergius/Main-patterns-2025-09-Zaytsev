package command;

public class CheckRepeatCommand implements Command {

    @Override
    public void execute() {
        throw new RuntimeException("Repeat checkRepeatCommand");
    }
}
