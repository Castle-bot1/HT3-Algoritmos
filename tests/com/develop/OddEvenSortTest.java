package com.develop;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class OddEvenSortTest {

    @Test
    void testSortIntArray() {
        int[] arr = {10, 3, 5, 1, 8};
        OddEvenSort.sort(arr);
        assertArrayEquals(new int[]{1, 3, 5, 8, 10}, arr);
    }
}
