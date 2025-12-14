import GameObject.SpaceShip;
import MovementClass.Location;
import MovementClass.Move;
import MovementClass.Velocity;
import RotationClasses.AngularVelocity;
import RotationClasses.Direction;
import RotationClasses.Rotation;

public class main {

    public static void main(String[] args) {

        var ship = new SpaceShip(
                new Location(12,5),
                new Velocity(-7, 3),
                new Direction(4, 3),
                new AngularVelocity(6)
        );
        var move = new Move();
        var rotation = new Rotation();
        System.out.println("Ship location: " + ship.getLocation().toString());
        move.movement(ship);
        System.out.println("Ship location after movement: " + ship.getLocation().toString());

        System.out.println("++++++++++++++++++++++++++++++++++++++++++++++++");

        System.out.println("Current direction ship: " + ship.getDirection().getAngle());
        rotation.execute(ship);
        System.out.println("Direction ship after change: " + ship.getDirection().getAngle());
    }
}
