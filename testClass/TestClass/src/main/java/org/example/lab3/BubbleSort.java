package org.example.lab3;

public class BubbleSort {
    public static void main(String[] args) {
        int[] arr = {5, 3, 9, 1, 7};  // Example input
        bubbleSort(arr);
        System.out.println("Sorted array: ");
        for (int value : arr) {
            System.out.print(value + " ");
        }
    }

    public static void bubbleSort(int[] arr) {
        int n = arr.length;
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    // Swap arr[j+1] and arr[j]
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
    }
}
