package com.develop;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class MergeSortTest {

    @Test
    void testSortIntArray() {
        int[] arr = {12, 5, 9, 1, 6};
        MergeSort.sort(arr);
        assertArrayEquals(new int[]{1, 5, 6, 9, 12}, arr);
    }
}
