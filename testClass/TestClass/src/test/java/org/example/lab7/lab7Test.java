package org.example.lab7;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

import org.junit.jupiter.api.Test;

class lab7Test {

    @Test
    public void testEmptyArray() {
        int[] array = {};
        Quicksort.sort(array);
        assertArrayEquals(new int[] {}, array);
    }

    @Test
    public void testSingleElement() {
        int[] array = {1};
        Quicksort.sort(array);
        assertArrayEquals(new int[] {1}, array);
    }

    @Test
    public void testTwoElementsSorted() {
        int[] array = {1, 2};
        Quicksort.sort(array);
        assertArrayEquals(new int[] {1, 2}, array);
    }

    @Test
    public void testTwoElementsUnsorted() {
        int[] array = {2, 1};
        Quicksort.sort(array);
        assertArrayEquals(new int[] {1, 2}, array);
    }

    @Test
    public void testMultipleElementsSorted() {
        int[] array = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        Quicksort.sort(array);
        assertArrayEquals(new int[] {1, 2, 3, 4, 5, 6, 7, 8, 9, 10}, array);
    }

    @Test
    public void testReverseOrder() {
        int[] array = {10, 9, 8, 7, 6, 5, 4, 3, 2, 1};
        Quicksort.sort(array);
        assertArrayEquals(new int[] {1, 2, 3, 4, 5, 6, 7, 8, 9, 10}, array);
    }

    @Test
    public void testArrayWithNegatives() {
        int[] array = {-3, -1, -2, 0, 2, 1};
        Quicksort.sort(array);
        assertArrayEquals(new int[] {-3, -2, -1, 0, 1, 2}, array);
    }

    @Test
    public void testArrayWithDuplicates() {
        int[] array = {4, 5, 5, 1, 2, 1, 3};
        Quicksort.sort(array);
        assertArrayEquals(new int[] {1, 1, 2, 3, 4, 5, 5}, array);
    }

    @Test
    public void testArrayWithAllDuplicates() {
        int[] array = {2, 2, 2, 2, 2, 3, 2, 2, 2, 2};
        Quicksort.sort(array);
        assertArrayEquals(new int[] {2, 2, 2, 2, 2, 2, 2, 2, 2, 3}, array);
    }

    @Test
    public void testRandomElements() {
        int[] array = {5, 9, 3, 8, 2, 1, 4, 7, 6};
        Quicksort.sort(array);
        assertArrayEquals(new int[] {1, 2, 3, 4, 5, 6, 7, 8, 9}, array);
    }

    @Test
    public void testLargeArray() {
        int[] array = new int[100];
        for (int i = 0; i < 100; i++) {
            array[i] = (int) (Math.random() * 100);
        }
        int[] sortedArray = array.clone();
        java.util.Arrays.sort(sortedArray);
        Quicksort.sort(array);
        assertArrayEquals(sortedArray, array);
    }

    @Test
    public void testArrayWithExtremes() {
        int[] array = {Integer.MAX_VALUE, 0, Integer.MIN_VALUE, 100, -100};
        Quicksort.sort(array);
        assertArrayEquals(new int[] {Integer.MIN_VALUE, -100, 0, 100, Integer.MAX_VALUE}, array);
    }

    @Test
    public void testVeryLargeArray() {
        int[] array = new int[1000];
        for (int i = 0; i < 1000; i++) {
            array[i] = (int) (Math.random() * 1000) - 500;
        }
        int[] sortedArray = array.clone();
        java.util.Arrays.sort(sortedArray);
        Quicksort.sort(array);
        assertArrayEquals(sortedArray, array);
    }

    @Test
    public void testArrayWithZeros() {
        int[] array = {0, 0, 0, 0, 0};
        Quicksort.sort(array);
        assertArrayEquals(new int[] {0, 0, 0, 0, 0}, array);
    }

    @Test
    public void testArrayWithUniqueValues() {
        int[] array = {10, 23, 51, 18, 4};
        Quicksort.sort(array);
        assertArrayEquals(new int[] {4, 10, 18, 23, 51}, array);
    }

    @Test
    public void testArrayWithOddAndEvenNumbers() {
        int[] array = {2, 4, 1, 7, 6, 9, 8, 5, 3};
        Quicksort.sort(array);
        assertArrayEquals(new int[] {1, 2, 3, 4, 5, 6, 7, 8, 9}, array);
    }

    @Test
    public void testArrayWithNegativeAndPositiveValues() {
        int[] array = {-3, -1, 2, 0, -4, 5, -2, 3, 1};
        Quicksort.sort(array);
        assertArrayEquals(new int[] {-4, -3, -2, -1, 0, 1, 2, 3, 5}, array);
    }
}

