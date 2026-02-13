package com.develop;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class QuickSortTest {

    @Test
    void testSortIntArray() {
        int[] arr = {9, 4, 6, 2, 7};
        QuickSort.sort(arr);
        assertArrayEquals(new int[]{2, 4, 6, 7, 9}, arr);
    }
}
