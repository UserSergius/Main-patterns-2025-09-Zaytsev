package command.device;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@RequiredArgsConstructor
@Getter
@Setter
public class Light {

    private boolean isTurnOn = false;

    public void on() {
        System.out.println("Включили свет в спальне");
    }

    public void off() {
        System.out.println("Выключили свет в спальне");
    }
}
