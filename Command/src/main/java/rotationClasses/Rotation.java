package rotationClasses;

public class Rotation {

    public void execute(RotatingObject object) {

        var direction = object.getDirection();
        var angularVelocity = object.getAngularVelocity();

        direction.setAngle((direction.getAngle() + angularVelocity.getAngularVelocity()) % direction.getDirectionNumber());
    }
}
