package command;

import lombok.RequiredArgsConstructor;
import exception.CommandException;

@RequiredArgsConstructor
public class MacroCommand implements Command {

    final private Command[] commands;

    @Override
    public void execute() {
        try {
            for (Command command : commands) {
                System.out.println("Выполняется команда: " + command.getClass().getSimpleName());
                command.execute();
            }
        } catch (Exception e) {
            throw new CommandException(e.getMessage());
        }
    }
}
