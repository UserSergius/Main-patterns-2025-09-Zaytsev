package MovementClass;

public class Move {

  public void movement(MovingObject obj) {
    Location location = obj.getLocation();
    Velocity velocity = obj.getVelocity();
    location.setLocation(velocity.getVx(), velocity.getVy());
  }
}
