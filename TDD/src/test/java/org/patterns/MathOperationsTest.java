package org.patterns;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class MathOperationsTest {

    MathOperations mathOperations = new MathOperations();

    @Test
    void getSquareRoots_zeroRoots() {

        double[] testRoots = new double[0];
        var roots = mathOperations.getSquareRoots(1, 0, 1);

        Assertions.assertArrayEquals(testRoots, roots, 1e-9);
    }

    @Test
    void getSquareRoots_twoRoots() {

        var roots = mathOperations.getSquareRoots(1, 0 ,-1);

        Assertions.assertEquals(2, roots.length);
        Assertions.assertEquals(-1.0, roots[0]);
        Assertions.assertEquals(1.0, roots[1]);
    }

    @Test
    void getSquareRoots_oneRoot() {

        var root = mathOperations.getSquareRoots(1, 4, 4);

        Assertions.assertEquals(1, root.length);
        Assertions.assertEquals(-2.0, root[0]);
    }

    @Test
    void getSquareRoots_argument_a_isZero() {

       var exception = Assertions.assertThrows(IllegalArgumentException.class, () -> mathOperations.getSquareRoots(0, 1,1));

       Assertions.assertEquals("Аргумент \"a\" не может быть нулем!", exception.getMessage());
    }

    @Test
    void getSquareRoots_haveNaN() {

        Assertions.assertThrows(IllegalArgumentException.class, () -> mathOperations.getSquareRoots(Double.NaN, 3, 5));
    }

    @Test
    void getSquareRoots_infinity() {

        Assertions.assertThrows(IllegalArgumentException.class, () -> mathOperations.getSquareRoots(1, Double.POSITIVE_INFINITY, 5));
    }
}