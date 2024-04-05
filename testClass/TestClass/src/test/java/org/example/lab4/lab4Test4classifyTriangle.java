package org.example.lab4;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class lab4Test4classifyTriangle {
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
        assertEquals("INVALID", UpgradedTriangle.classifyTriangle(-1, 2, 2)); // 存在负边长
        assertEquals("INVALID", UpgradedTriangle.classifyTriangle(0, 2, 2)); // 存在边长为0
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
}

