package org.example.lab6;

import org.junit.Test;

import static org.junit.Assert.assertArrayEquals;


public class lab6Test4BubbleSort {

    @Test
    public void testBubbleSort() {
        int[] array = {5, 3, 1, 4, 2, 6};
        BubbleSort.bubbleSort(array);
        assertArrayEquals(new int[]{1, 2, 3, 4, 5, 6}, array);
    }


    @Test
    public void testSingleElement() {
        int[] array = {1};
        BubbleSort.bubbleSort(array);
        assertArrayEquals(new int[]{1}, array);
    }

    @Test
    public void testTwoElementsSorted() {
        int[] array = {1, 2};
        BubbleSort.bubbleSort(array);
        assertArrayEquals(new int[]{1, 2}, array);
    }

    @Test
    public void testTwoElementsUnsorted() {
        int[] array = {2, 1};
        BubbleSort.bubbleSort(array);
        assertArrayEquals(new int[]{1, 2}, array);
    }

    @Test
    public void testMultipleElementsSorted() {
        int[] array = {1, 2, 3, 4, 5};
        BubbleSort.bubbleSort(array);
        assertArrayEquals(new int[]{1, 2, 3, 4, 5}, array);
    }

    @Test
    public void testMultipleElementsReverse() {
        int[] array = {5, 4, 3, 2, 1};
        BubbleSort.bubbleSort(array);
        assertArrayEquals(new int[]{1, 2, 3, 4, 5}, array);
    }

    @Test
    public void testDuplicates() {
        int[] array = {3, 3, 2, 1, 2};
        BubbleSort.bubbleSort(array);
        assertArrayEquals(new int[]{1, 2, 2, 3, 3}, array);
    }

    @Test
    public void testLargeArray() {
        int[] array = new int[100];
        int[] expected = new int[100];
        for (int i = 0; i < 100; i++) {
            array[i] = 100 - i;
            expected[i] = i+1;
        }
        BubbleSort.bubbleSort(array);
        assertArrayEquals(expected, array);
    }

    @Test
    public void testMixedPositiveAndNegative() {
        int[] array = {-1, 2, -3, 4, 0};
        BubbleSort.bubbleSort(array);
        assertArrayEquals(new int[]{-3, -1, 0, 2, 4}, array);
    }

    @Test
    public void testWithZeros() {
        int[] array = {0, -1, 1, 0};
        BubbleSort.bubbleSort(array);
        assertArrayEquals(new int[]{-1, 0, 0, 1}, array);
    }

    @Test
    public void testExtremeValues() {
        int[] array = {Integer.MAX_VALUE, Integer.MIN_VALUE, 0};
        BubbleSort.bubbleSort(array);
        assertArrayEquals(new int[]{Integer.MIN_VALUE, 0, Integer.MAX_VALUE}, array);
    }

    @Test
    public void testNearlySortedArray() {
        int[] array = {1, 3, 2, 4, 5};
        BubbleSort.bubbleSort(array);
        assertArrayEquals(new int[]{1, 2, 3, 4, 5}, array);
    }

    @Test
    public void testLargeDuplicateElements() {
        int[] array = new int[100];
        for (int i = 0; i < 100; i++) {
            array[i] = 1;
        }
        BubbleSort.bubbleSort(array);
        int[] expected = new int[100];
        for (int i = 0; i < 100; i++) {
            expected[i] = 1;
        }
        assertArrayEquals(expected, array);
    }

    @Test
    public void testRandomOrder() {
        int[] array = {5, 8, 6, 2, 3, 4, 7, 1};
        BubbleSort.bubbleSort(array);
        assertArrayEquals(new int[]{1, 2, 3, 4, 5, 6, 7, 8}, array);
    }
    @Test
    public void testBubbleSortWithIncrement() {
        int[] array = {5, 1, 4, 2, 8};
        BubbleSort.bubbleSort(array);
        assertArrayEquals(new int[]{1, 2, 4, 5, 8}, array);
    }


}
