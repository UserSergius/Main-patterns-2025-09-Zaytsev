package MovementClass;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Velocity {

    private int vx;
    private int vy;

    public Velocity() {
        this.vx = 0;
        this.vy = 0;
    }

    public int getSummaryVelocity() {
        return vx + vy;
    }

    public Velocity getVelocity() {
        return new Velocity(vx, vy);
    }
}
