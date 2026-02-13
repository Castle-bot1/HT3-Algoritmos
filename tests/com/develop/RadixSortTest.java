package com.develop;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class RadixSortTest {

    @Test
    void testSortPositiveNumbers() {
        int[] arr = {170, 45, 75, 90, 802, 24, 2, 66};
        RadixSort.sort(arr);
        assertArrayEquals(new int[]{2, 24, 45, 66, 75, 90, 170, 802}, arr);
    }

    @Test
    void testSortWithNegatives() {
        int[] arr = {-5, 3, -1, 7, -2, 0};
        RadixSort.sortWithNegatives(arr);
        assertArrayEquals(new int[]{-5, -2, -1, 0, 3, 7}, arr);
    }

    @Test
    void testOnlyNegatives() {
        int[] arr = {-9, -3, -7, -1};
        RadixSort.sortWithNegatives(arr);
        assertArrayEquals(new int[]{-9, -7, -3, -1}, arr);
    }

    @Test
    void testEmptyArray() {
        int[] arr = {};
        RadixSort.sort(arr);
        assertArrayEquals(new int[]{}, arr);
    }
}
