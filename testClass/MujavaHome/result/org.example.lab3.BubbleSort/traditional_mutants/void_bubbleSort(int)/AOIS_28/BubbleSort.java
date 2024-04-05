// This is a mutant program.
// Author : ysma

package org.example.lab3;


public class BubbleSort
{

    public static  void main( java.lang.String[] args )
    {
        int[] arr = { 5, 3, 9, 1, 7 };
        bubbleSort( arr );
        System.out.println( "Sorted array: " );
        for (int value: arr) {
            System.out.print( value + " " );
        }
    }

    public static  void bubbleSort( int[] arr )
    {
        int n = arr.length;
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (arr[j] > arr[--j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
    }

}
