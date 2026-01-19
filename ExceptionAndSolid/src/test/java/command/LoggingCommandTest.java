package command;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

class LoggingCommandTest {

    private final PrintStream originalOut = System.out;
    private ByteArrayOutputStream outContent;

    @BeforeEach
    void setUp() {
        outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));
    }

    @AfterEach
    void tearDown() {
        System.setOut(originalOut);
    }

    @Test
    void shouldPrintExceptionInfoToConsole() {

        Exception exception = new IllegalStateException("test error");
        Command command = () -> {};

        LoggingCommand loggingCommand =
                new LoggingCommand(exception, command);

        loggingCommand.execute();

        String output = outContent.toString();

        Assertions.assertAll(
                () -> Assertions.assertTrue(output.contains("test error")),
                () -> Assertions.assertTrue(output.contains("LoggingCommandTest")));
    }
}