package org.example.lab4;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class lab4Test {
    @Test
    public void testScalene() {
        // 测试Scalene三角形（各边长不等）
        assertEquals("SCALENE", UpgradedTriangle.classifyTriangle(3, 4, 5));
        assertEquals("SCALENE", UpgradedTriangle.classifyTriangle(5, 6, 7));
    }

    @Test
    public void testIsosceles() {
        // 测试Isosceles三角形（两边等长）
        assertEquals("ISOSCELES", UpgradedTriangle.classifyTriangle(2, 2, 3));
        assertEquals("ISOSCELES", UpgradedTriangle.classifyTriangle(4, 4, 6));
    }

    @Test
    public void testEquilateral() {
        // 测试Equilateral三角形（三边等长）
        assertEquals("EQUILATERAL", UpgradedTriangle.classifyTriangle(3, 3, 3));
        assertEquals("EQUILATERAL", UpgradedTriangle.classifyTriangle(4, 4, 4));
    }

    @Test
    public void testInvalid() {
        // 测试无效的三角形情况
        assertEquals("INVALID", UpgradedTriangle.classifyTriangle(1, 2, 3)); // 两边之和等于第三边
        assertEquals("INVALID", UpgradedTriangle.classifyTriangle(2, 1, 3)); // 两边之和等于第三边
        assertEquals("INVALID", UpgradedTriangle.classifyTriangle(3, 2, 1)); // 两边之和等于第三边
        assertEquals("INVALID", UpgradedTriangle.classifyTriangle(-1, 2, 3)); // 存在负边长
        assertEquals("INVALID", UpgradedTriangle.classifyTriangle(2, -1, 3)); // 存在负边长
        assertEquals("INVALID", UpgradedTriangle.classifyTriangle(2, 3, -1)); // 存在负边长

        assertEquals("INVALID", UpgradedTriangle.classifyTriangle(0, 2, 2)); // 存在边长为0
        assertEquals("INVALID", UpgradedTriangle.classifyTriangle(2, 0, 2)); // 存在边长为0
        assertEquals("INVALID", UpgradedTriangle.classifyTriangle(2, 2, 0)); // 存在边长为0
    }

    @Test
    public void testMCDC() {
        // MC/DC测试用例
        assertEquals("INVALID", UpgradedTriangle.classifyTriangle(1, 1, 2)); // 测试a + c <= b
        assertEquals("INVALID", UpgradedTriangle.classifyTriangle(1, 2, 3)); // 测试a + b <= c
        assertEquals("INVALID", UpgradedTriangle.classifyTriangle(2, 3, 1)); // 测试b + c <= a
        assertEquals("INVALID", UpgradedTriangle.classifyTriangle(0, 1, 1)); // 测试a <= 0
        assertEquals("ISOSCELES", UpgradedTriangle.classifyTriangle(2, 2, 3)); // 测试a == b
        assertEquals("ISOSCELES", UpgradedTriangle.classifyTriangle(3, 2, 3)); // 测试a == c
        assertEquals("EQUILATERAL", UpgradedTriangle.classifyTriangle(3, 3, 3)); // 测试a == b == c
    }

    @Test
    public void testBoundary() {
        // 边界测试用例
        assertEquals("INVALID", UpgradedTriangle.classifyTriangle(1, 1, 2)); // 两边之和等于第三边
        assertEquals("INVALID", UpgradedTriangle.classifyTriangle(0, 2, 2)); // 一边为0
    }

    //下面是第二个函数的测试用例
    private static final double DELTA = 0.0001;

    @Test
    public void testValidScalene() {
        assertEquals(6.0, UpgradedTriangle.calculateArea(3, 4, 5), DELTA);
        assertEquals(9.9216, UpgradedTriangle.calculateArea(4, 5, 6), DELTA);
        assertEquals(0.433, UpgradedTriangle.calculateArea(1, 1, 1), DELTA);
    }

    @Test
    public void testValidIsosceles() {
        assertEquals(4.4721, UpgradedTriangle.calculateArea(3, 3, 4), DELTA);
        assertEquals(5.5621, UpgradedTriangle.calculateArea(3, 4, 4), DELTA);
        assertEquals(5.5621, UpgradedTriangle.calculateArea(4, 3, 4), DELTA);
        assertEquals(5.5621, UpgradedTriangle.calculateArea(4, 4, 3), DELTA);
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
        assertEquals(0.0, UpgradedTriangle.calculateArea(4, 2, 2), DELTA);
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
