package org.example.lab6;

import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.*;


public class lab6Test4BubbleSortLab6 {

    @Test
    public void testBubbleSort() {
        int[] array = {5, 3, 1, 4, 2, 6};
        BubbleSortLab6.bubbleSort(array);
        assertArrayEquals(new int[]{1, 2, 3, 4, 5, 6}, array);
    }


    @Test
    public void testSingleElement() {
        int[] array = {1};
        BubbleSortLab6.bubbleSort(array);
        assertArrayEquals(new int[]{1}, array);
    }

    @Test
    public void testTwoElementsSorted() {
        int[] array = {1, 2};
        BubbleSortLab6.bubbleSort(array);
        assertArrayEquals(new int[]{1, 2}, array);
    }

    @Test
    public void testTwoElementsUnsorted() {
        int[] array = {2, 1};
        BubbleSortLab6.bubbleSort(array);
        assertArrayEquals(new int[]{1, 2}, array);
    }

    @Test
    public void testMultipleElementsSorted() {
        int[] array = {1, 2, 3, 4, 5};
        BubbleSortLab6.bubbleSort(array);
        assertArrayEquals(new int[]{1, 2, 3, 4, 5}, array);
    }

    @Test
    public void testMultipleElementsReverse() {
        int[] array = {5, 4, 3, 2, 1};
        BubbleSortLab6.bubbleSort(array);
        assertArrayEquals(new int[]{1, 2, 3, 4, 5}, array);
    }

    @Test
    public void testDuplicates() {
        int[] array = {3, 3, 2, 1, 2};
        BubbleSortLab6.bubbleSort(array);
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
        BubbleSortLab6.bubbleSort(array);
        assertArrayEquals(expected, array);
    }

    @Test
    public void testMixedPositiveAndNegative() {
        int[] array = {-1, 2, -3, 4, 0};
        BubbleSortLab6.bubbleSort(array);
        assertArrayEquals(new int[]{-3, -1, 0, 2, 4}, array);
    }

    @Test
    public void testWithZeros() {
        int[] array = {0, -1, 1, 0};
        BubbleSortLab6.bubbleSort(array);
        assertArrayEquals(new int[]{-1, 0, 0, 1}, array);
    }

    @Test
    public void testExtremeValues() {
        int[] array = {Integer.MAX_VALUE, Integer.MIN_VALUE, 0};
        BubbleSortLab6.bubbleSort(array);
        assertArrayEquals(new int[]{Integer.MIN_VALUE, 0, Integer.MAX_VALUE}, array);
    }

    @Test
    public void testNearlySortedArray() {
        int[] array = {1, 3, 2, 4, 5};
        BubbleSortLab6.bubbleSort(array);
        assertArrayEquals(new int[]{1, 2, 3, 4, 5}, array);
    }

    @Test
    public void testLargeDuplicateElements() {
        int[] array = new int[100];
        for (int i = 0; i < 100; i++) {
            array[i] = 1;
        }
        BubbleSortLab6.bubbleSort(array);
        int[] expected = new int[100];
        for (int i = 0; i < 100; i++) {
            expected[i] = 1;
        }
        assertArrayEquals(expected, array);
    }

    @Test
    public void testRandomOrder() {
        int[] array = {5, 8, 6, 2, 3, 4, 7, 1};
        BubbleSortLab6.bubbleSort(array);
        assertArrayEquals(new int[]{1, 2, 3, 4, 5, 6, 7, 8}, array);
    }
    @Test
    public void testBubbleSortWithIncrement() {
        int[] array = {5, 1, 4, 2, 8};
        BubbleSortLab6.bubbleSort(array);
        assertArrayEquals(new int[]{1, 2, 4, 5, 8}, array);
    }


    //新增
    @Test
    public void testEmptyArray() {
        int[] array = {};
        BubbleSortLab6.bubbleSort(array);
        assertArrayEquals(new int[]{}, array); // 确认空数组处理正确
    }

    @Test
    public void testAllElementsSame() {
        int[] array = {2, 2, 2, 2};
        BubbleSortLab6.bubbleSort(array);
        assertArrayEquals(new int[]{2, 2, 2, 2}, array); // 测试所有元素相同时的边界条件
    }

    @Test
    public void testMaximumIntegers() {
        int[] array = {Integer.MAX_VALUE, Integer.MAX_VALUE};
        BubbleSortLab6.bubbleSort(array);
        assertArrayEquals(new int[]{Integer.MAX_VALUE, Integer.MAX_VALUE}, array); // 测试极值是否处理正确
    }

    @Test
    public void testSortedArray() {
        int[] array = {1, 2, 3, 4, 5};
        BubbleSortLab6.bubbleSort(array);
        assertArrayEquals(new int[]{1, 2, 3, 4, 5}, array); // 测试已排序数组是否会错误排序
    }

    @Test
    public void testLastElementUnchanged() {
        int[] array = {1, 3, 2, 4, 6, 5};
        BubbleSortLab6.bubbleSort(array);
        assertEquals(6, array[array.length - 1]); // 确认最后一个元素为5
    }

    @Test
    public void testIncrementDecrementCondition() {
        int[] array = {1, 3, 5, 4, 2};
        int[] original = Arrays.copyOf(array, array.length);
        BubbleSortLab6.bubbleSort(array);
        for (int i = 0; i < array.length - 1; i++) {
            assertTrue(array[i] <= array[i+1]); // 确认每个元素都小于等于下一个元素
        }
    }


    @Test
    public void testNegatedConditions() {
        int[] array = {3, 2, 5, 1, 4};
        BubbleSortLab6.bubbleSort(array);
        for (int i = 0; i < array.length - 1; i++) {
            assertFalse(array[i] > array[i+1]); // 检查没有元素大于其后的元素
        }
    }

    @Test
    public void testArrayBounds() {
        int[] array = new int[1000]; // 极大数组测试
        for (int i = 0; i < array.length; i++) {
            array[i] = (int) (Math.random() * 1000);
        }
        BubbleSortLab6.bubbleSort(array);
        for (int i = 0; i < array.length - 1; i++) {
            assertTrue(array[i] <= array[i+1]);
        }
    }


}
