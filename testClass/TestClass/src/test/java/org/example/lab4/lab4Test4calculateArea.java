package org.example.lab4;

import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class lab4Test4calculateArea {
    // 设置一个小的误差范围，用于浮点数比较
    private static final double DELTA = 0.0001;

    @Test
    public void testValidScalene() {
        assertEquals(6.0, UpgradedTriangle.calculateArea(3, 4, 5), DELTA);
        assertEquals(9.9216, UpgradedTriangle.calculateArea(4, 5, 6), DELTA);
    }

    @Test
    public void testValidIsosceles() {
        assertEquals(4.4721, UpgradedTriangle.calculateArea(3, 3, 4), DELTA);
        assertEquals(5.5621, UpgradedTriangle.calculateArea(3, 4, 4), DELTA);
    }

    @Test
    public void testValidEquilateral() {
        assertEquals(15.5885, UpgradedTriangle.calculateArea(6, 6, 6), DELTA);
    }

    @Test
    public void testInvalidTriangleZero() {
        assertEquals(0.0, UpgradedTriangle.calculateArea(0, 5, 5), DELTA);
        assertEquals(0.0, UpgradedTriangle.calculateArea(5, 0, 5), DELTA);
    }

    @Test
    public void testInvalidTriangleNegative() {
        assertEquals(0.0, UpgradedTriangle.calculateArea(-1, 5, 5), DELTA);
        assertEquals(0.0, UpgradedTriangle.calculateArea(5, -1, 5), DELTA);
    }

    @Test
    public void testInvalidTriangleSumOfSides() {
        assertEquals(0.0, UpgradedTriangle.calculateArea(1, 2, 3), DELTA);
        assertEquals(0.0, UpgradedTriangle.calculateArea(2, 3, 5), DELTA);
    }

    @Test
    public void testLargeScalene() {
        assertEquals(44.8999, UpgradedTriangle.calculateArea(9, 10, 13), DELTA);
    }

    @Test
    public void testLargeIsosceles() {
        assertEquals(31.7490, UpgradedTriangle.calculateArea(8, 8, 12), DELTA);
    }

    @Test
    public void testLargeEquilateral() {
        assertEquals(27.7128, UpgradedTriangle.calculateArea(8, 8, 8), DELTA);
    }

    @Test
    public void testBoundaryCase1() {
        assertEquals(0.0, UpgradedTriangle.calculateArea(2, 2, 4), DELTA);
        assertEquals(0.0, UpgradedTriangle.calculateArea(2, 4, 2), DELTA);
        assertEquals(0.0, UpgradedTriangle.calculateArea(4, 2, 4), DELTA);
        assertEquals(0.0, UpgradedTriangle.calculateArea(5, 9, 15), DELTA);
        assertEquals(0.0, UpgradedTriangle.calculateArea(9, 5, 15), DELTA);
        assertEquals(0.0, UpgradedTriangle.calculateArea(5, 15, 9), DELTA);
        assertEquals(0.0, UpgradedTriangle.calculateArea(9, 15, 5), DELTA);
        assertEquals(0.0, UpgradedTriangle.calculateArea(15, 5, 9), DELTA);
        assertEquals(0.0, UpgradedTriangle.calculateArea(15, 9, 5), DELTA);
        assertEquals(0.0, UpgradedTriangle.calculateArea(3, 7, 10), DELTA);
    }

    @Test
    public void testMediumScalene() {
        assertEquals(34.9777, UpgradedTriangle.calculateArea(7, 10, 12), DELTA);
    }
}
