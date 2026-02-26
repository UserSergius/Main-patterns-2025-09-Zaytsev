package command;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Fuel {

    private int capacity;

    public void checkEnoughFuel(int requiredValue) {
        if (capacity < requiredValue) {
            throw new IllegalStateException("Невозможно продолжить движения недостаточно топлива. В баке осталось: %d л."
                    .formatted(capacity));
        }
    }
}
