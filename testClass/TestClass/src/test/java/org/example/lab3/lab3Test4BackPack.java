package org.example.lab3;

import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class lab3Test4BackPack {

    @Test
    public void testEmptyBackPackAndItems() {
        assertEquals(0, BackPack.backPack(new int[0], new int[0], 0));
    }

    @Test
    public void testZeroCapacity() {
        assertEquals(0, BackPack.backPack(new int[]{1, 2, 3}, new int[]{10, 20, 30}, 0));
    }

    @Test
    public void testSingleItemFitsExactly() {
        assertEquals(10, BackPack.backPack(new int[]{5}, new int[]{10}, 5));
    }

    @Test
    public void testSingleItemTooLarge() {
        assertEquals(0, BackPack.backPack(new int[]{6}, new int[]{10}, 5));
    }

    @Test
    public void testSingleItemSmallerThanCapacity() {
        assertEquals(10, BackPack.backPack(new int[]{4}, new int[]{10}, 5));
    }

    @Test
    public void testTwoItemsFitExactly() {
        assertEquals(30, BackPack.backPack(new int[]{2, 3}, new int[]{10, 20}, 5));
    }

    @Test
    public void testTwoItemsExceedCapacity() {
        assertEquals(20, BackPack.backPack(new int[]{3, 4}, new int[]{10, 20}, 5));
    }

    @Test
    public void testTwoItemsBothTooLarge() {
        assertEquals(0, BackPack.backPack(new int[]{6, 7}, new int[]{10, 20}, 5));
    }

    @Test
    public void testMultipleItemsFitExactly() {
        assertEquals(6, BackPack.backPack(new int[]{1, 2, 3}, new int[]{1, 2, 3}, 6));
    }

    @Test
    public void testMultipleItemsLessThanCapacity() {
        assertEquals(6, BackPack.backPack(new int[]{1, 2, 3}, new int[]{1, 2, 3}, 7));
    }

    @Test
    public void testMultipleItemsExceedCapacity() {
        assertEquals(9, BackPack.backPack(new int[]{2, 3, 4}, new int[]{3, 4, 5}, 7));
    }

    @Test
    public void testItemsWithSameWeightDifferentValues() {
        assertEquals(20, BackPack.backPack(new int[]{5, 5}, new int[]{10, 20}, 5));
    }

    @Test
    public void testItemsWithDifferentWeightsSameValue() {
        assertEquals(2, BackPack.backPack(new int[]{1, 2}, new int[]{1, 1}, 3));
    }

    @Test
    public void testMaxValueCombination() {
        assertEquals(220, BackPack.backPack(new int[]{10, 20, 30}, new int[]{60, 100, 120}, 50));
    }

    @Test
    public void testAllItemsTooHeavy() {
        assertEquals(0, BackPack.backPack(new int[]{8, 9, 10}, new int[]{10, 20, 30}, 7));
    }

    @Test
    public void testLargeCapacity() {
        assertEquals(15, BackPack.backPack(new int[]{1, 2, 3}, new int[]{5, 5, 5}, 100));
    }

    @Test
    public void testLargeNumberOfItems() {
        int[] weights = new int[100];
        int[] values = new int[100];
        for (int i = 0; i < 100; i++) {
            weights[i] = i + 1;
            values[i] = i + 1;
        }
        assertEquals(5050, BackPack.backPack(weights, values, 10000));
    }

    @Test
    public void testRandomValues() {
        assertEquals(180, BackPack.backPack(new int[]{10, 40, 30, 50}, new int[]{60, 40, 100, 120}, 60));
    }

    @Test
    public void testMultipleOptimalSolutions() {
        assertEquals(15, BackPack.backPack(new int[]{5, 5, 5}, new int[]{10, 5, 5}, 10));
    }

    @Test
    public void testItemWithZeroWeightAndValue() {
        assertEquals(0, BackPack.backPack(new int[]{0}, new int[]{0}, 10));
    }

    @Test
    public void testCapacityJustEnoughForAllItems() {
        assertEquals(10, BackPack.backPack(new int[]{1, 2, 3}, new int[]{4, 3, 3}, 6));
    }

    @Test
    public void testItemsWithDescendingValuesAndAscendingWeights() {
        assertEquals(170, BackPack.backPack(new int[]{1, 2, 3, 4}, new int[]{100, 50, 20, 10}, 7));
    }

    @Test
    public void testSingleHeavyItem() {
        assertEquals(0, BackPack.backPack(new int[]{100}, new int[]{1000}, 50));
    }

    @Test
    public void testExactMatchForAllItems() {
        assertEquals(10, BackPack.backPack(new int[]{1, 2, 3, 4}, new int[]{1, 2, 3, 4}, 10));
    }

    @Test
    public void testWithIncreasingWeightsAndValues() {
        assertEquals(11, BackPack.backPack(new int[]{1, 2, 3, 4}, new int[]{1, 3, 6, 10}, 5));
    }

    @Test
    public void testWithDecreasingWeightsAndValues() {
        assertEquals(11, BackPack.backPack(new int[]{4, 3, 2, 1}, new int[]{10, 6, 3, 1}, 5));
    }

    @Test
    public void testForUnreachableItems() {
        assertEquals(0, BackPack.backPack(new int[]{100, 200, 300}, new int[]{1000, 2000, 3000}, 50));
    }
}
