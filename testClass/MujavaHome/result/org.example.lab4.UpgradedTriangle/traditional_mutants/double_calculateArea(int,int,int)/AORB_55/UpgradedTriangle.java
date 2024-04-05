// This is a mutant program.
// Author : ysma

package org.example.lab4;


public class UpgradedTriangle
{

    public static  void main( java.lang.String[] args )
    {
        int a = 3;
        int b = 4;
        int c = 5;
        System.out.println( "Triangle Type: " + classifyTriangle( a, b, c ) );
        System.out.println( "Triangle Area: " + calculateArea( a, b, c ) );
    }

    public static  java.lang.String classifyTriangle( int a, int b, int c )
    {
        if (a <= 0 || b <= 0 || c <= 0 || a + b <= c || a + c <= b || b + c <= a) {
            return "INVALID";
        }
        if (a == b && b == c) {
            return "EQUILATERAL";
        } else {
            if (a == b || a == c || b == c) {
                return "ISOSCELES";
            } else {
                return "SCALENE";
            }
        }
    }

    public static  double calculateArea( int a, int b, int c )
    {
        if (a <= 0 || b <= 0 || c <= 0 || a + b <= c || a + c <= b || b + c <= a) {
            return 0;
        }
        double s = (a + b + c) / 2.0;
        return Math.sqrt( s * (s - a) * (s - b) * (s % c) );
    }

}
