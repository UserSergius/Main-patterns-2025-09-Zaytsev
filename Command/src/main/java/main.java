import command.BurnFuelCommand;
import command.CheckFuelCommand;
import command.Command;
import command.Fuel;
import command.MacroCommand;
import command.MoveCommand;
import command.MovingForward;
import gameObject.SpaceShip;
import movementClass.Location;
import movementClass.Velocity;
import rotationClasses.AngularVelocity;
import rotationClasses.Direction;

public class main {

    public static void main(String[] args) {

        var ship = new SpaceShip(
                new Location(12,5),
                new Velocity(14, 6),
                new Direction(4, 3),
                new AngularVelocity(6),
                new Fuel(100)
        );
        var velocity = ship.getVelocity().getSummaryVelocity();
        var checkFuel = new CheckFuelCommand(ship.getFuel(), velocity);
        var burnFuel = new BurnFuelCommand(ship.getFuel(), ship);
        var move = new MoveCommand(ship);
        Command[] commands = {checkFuel, move, burnFuel};
        MacroCommand macroCommand = new MacroCommand(commands);

        var movingForward = new MovingForward(macroCommand);
        System.out.printf("Количество топлива в баке: %d%n", ship.getFuel().getCapacity());
        movingForward.execute();
        System.out.printf("Количество топлива в баке после движения по прямой: %d%n", ship.getFuel().getCapacity());
    }
}
