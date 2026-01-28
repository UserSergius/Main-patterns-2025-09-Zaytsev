package MovementClass;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Location {

    private int x;
    private int y;

    public Location() {
        this.x = 0;
        this.y = 0;
    }

    public Location getLocation() {
       return new Location(x, y);
    }

    public void setLocation(int x, int y) {
        this.x += x;
        this.y += y;
    }
}
