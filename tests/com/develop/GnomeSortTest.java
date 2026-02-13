package com.develop;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class GnomeSortTest {

    @Test
    void testSortIntArray() {
        int[] arr = {5, 3, 8, 1, 2};
        GnomeSort.sort(arr);
        assertArrayEquals(new int[]{1, 2, 3, 5, 8}, arr);
    }
}
