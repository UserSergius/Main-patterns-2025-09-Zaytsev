package org.patterns;

public class MathOperations {

    public double[] getSquareRoots(double a, double b, double c) {

        double x1, x2;
        double discriminant = getDiscriminant(a, b, c);

        if(discriminant > 0) {
            x1 = (-b - Math.sqrt(discriminant)) / (2 * a);
            x2 = (-b + Math.sqrt(discriminant)) / (2 * a);

            return new double[] {x1, x2};
        } else if(isZero(discriminant)) {

            x1 = -b / (2 * a);

            return new double[] {x1};
        }
        return new double[0];
    }

    private boolean isZero(double y) {
        return Math.abs(y) < 1e-5;
    }

    private double getDiscriminant(double a, double b, double c) {
        if(isZero(a)) {
            throw new IllegalArgumentException("Аргумент \"a\" не может быть нулем!");
        }
        return b*b - 4*a*c;
    }
}
