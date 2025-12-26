package command;

import lombok.extern.log4j.Log4j2;

@Log4j2
public class RepeatAfterExceptionCommand implements Command {

    private boolean toggle = true;

    @Override
    public void execute() {

        if (toggle) {
            toggle = false;
            throw new NullPointerException("При выбросе данного исключения, команда должна повториться.");
        } else {
            log.info("Повторное выполнение класса RepeatAfterException, после получения ошибки.");
            toggle = true;
        }
    }
}
