package com.sparta.gh.algorithms;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;


class BinarySorterTest {
  @Test
  void bstSortShortArray() {
    // Given
    int[] arr = new int[]{ 13, 3, 11, 2, 4, 6, 7, 9, 10, 14, 8, 12, 5, 1 };
    int[] expected = new int[]{ 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14 };
    BinarySorter bst = new BinarySorter();

    // When
    int[] result = bst.sorter( arr );
    // Then
    Assertions.assertArrayEquals(expected, result);
  }

  @Test
  void bstNoDupesAllowedInHereTonight() {
    // Given
    int[] arr = new int[]{ 2, -4, 1, 7, 8, 3, 3, -9, 6, 6, 5, -10, -10, 11, 11, -10 };
    int[] expected = new int[]{ -10, -10, -10, -9, -4, 1, 2, 3, 3, 5, 6, 6, 7, 8, 11, 11 };
    BinarySorter bst = new BinarySorter();

    // When
    int[] result = bst.sorter( arr );
    // Then
    Assertions.assertArrayEquals(expected, result);
  }
}