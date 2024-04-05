package org.example.lab4;

public class UpgradedTriangle {

    public static void main(String[] args) {
        // Test the program with some values
        int a = 3, b = 4, c = 5; // Change these values to test different triangles
        System.out.println("Triangle Type: " + classifyTriangle(a, b, c));
        System.out.println("Triangle Area: " + calculateArea(a, b, c));
    }

    public static String classifyTriangle(int a, int b, int c) {
        // Check if the sides form a valid triangle
        if (a <= 0 || b <= 0 || c <= 0 || a + b <= c || a + c <= b || b + c <= a) {
            return "INVALID";
        }

        // Determine the type of triangle
        if (a == b && b == c) {
            return "EQUILATERAL";
        } else if (a == b || a == c || b == c) {
            return "ISOSCELES";
        } else {
            return "SCALENE";
        }
    }

    public static double calculateArea(int a, int b, int c) {
        if (a <= 0 || b <= 0 || c <= 0 || a + b <= c || a + c <= b || b + c <= a) {
            return 0;
        }

        // Heron's formula for calculating the area of a triangle
        double s = (a + b + c) / 2.0;
        return Math.sqrt(s * (s - a) * (s - b) * (s - c));
    }
}

