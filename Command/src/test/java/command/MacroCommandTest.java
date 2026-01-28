package command;

import exception.CommandException;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertInstanceOf;
import static org.junit.jupiter.api.Assertions.assertThrows;

class MacroCommandTest {

    @Test
    void execute() {

        Command[] listCommand = {new CheckFuelCommand(new Fuel(10), 1)};
        var commands = new MacroCommand(listCommand);

        assertDoesNotThrow(commands::execute);
    }

    @Test
    void execute_exceptio() {

        Command[] listCommand = {new CheckFuelCommand(new Fuel(1), 2)};
        var commands = new MacroCommand(listCommand);

        var exception = assertThrows(CommandException.class, commands::execute);
        assertInstanceOf(CommandException.class, exception);
    }
}