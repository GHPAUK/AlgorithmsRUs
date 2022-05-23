package com.sparta.gh.algorithms;


import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class MergeSorterTest {
  MergeSorter mergeSorter = new MergeSorter();

  @Test
  void evenNumberOfElements() {
    // Given
    int[] array = new int[]{ 2, 4, 1, 7, 8, 3, 9, 6, 5, 10 };
    int[] expected = new int[]{ 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 };
    // When
    int[] result = mergeSorter.sorter( array );
    // Then
    assertThat( result ).isEqualTo( expected );
  }

  @Test
  void evenNumberOfElementsDuplicateElementAtEndOfArrayTest() {
    // Given
    int[] array = new int[]{ 2, 4, 1, 7, 8, 3, 9, 6, 5, 10, 12, 14, 11, 17, 81, 13, 19, 61, 15, 15 };
    int[] expected = new int[]{ 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 15, 17, 19, 61, 81 };
    // When
    int[] result = mergeSorter.sorter( array );
    // Then
    assertThat( result ).isEqualTo( expected );
  }

  @Test
  void evenNumberOfElementsWithDuplicateValuesAtTheStartAndEnd() {
    // Given

    int[] array = new int[]{ 2, 2, 4, 1, 7, 8, 3, 9, 6, 5, 10, 12, 14, 11, 17, 5, 81, 13, 19, 61, 15, 15 };
    int[] expected = new int[]{ 1, 2, 2, 3, 4, 5, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 15, 17, 19, 61, 81 };
    // When
    int[] result = mergeSorter.sorter( array );
    // Then
    assertThat( result ).isEqualTo( expected );
  }

  @Test
  void oddNumberOfElementsDuplicateValueAtTheStart() {
    // Given
    int[] array = new int[]{ 2, 2, 4, 1, 7, 8, 3, 9, 6, 5, 10, 12, 14, 11, 17, 5, 81, 13, 19, 61, 15 };
    int[] expected = new int[]{ 1, 2, 2, 3, 4, 5, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 17, 19, 61, 81 };
    // When
    int[] result = mergeSorter.sorter( array );
    // Then
    assertThat( result ).isEqualTo( expected );
  }

  @Test
  void oddNumberOfElementsDuplicateValueAtTheStartAndEnd() {
    // Given
    int[] array = new int[]{ 2, 2, 4, 1, 7, 8, 3, 9, 6, 5, 10, 12, 14, 11, 5, 81, 13, 19, 61, 15, 15 };
    int[] expected = new int[]{ 1, 2, 2, 3, 4, 5, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 15, 19, 61, 81 };
    // When
    int[] result = mergeSorter.sorter( array );
    // Then
    assertThat( result ).isEqualTo( expected );
  }

  @Test
  void oddNumberOfElementsSmallDuplicateValueAtTheStart() {
    // Given
    int[] array = new int[]{ 2, 2, 5, 9, 7, 1, 3, 1, 4 };
    int[] expected = new int[]{ 1, 1, 2, 2, 3, 4, 5, 7, 9 };
    // When
    int[] result = mergeSorter.sorter( array );
    // Then
    assertThat( result ).isEqualTo( expected );
  }

  @Test
  void twoElementArray() {
    // Given
    int[] array = new int[]{ 2, 1, };
    int[] expected = new int[]{ 1, 2 };
    // When
    int[] result = mergeSorter.sorter( array );
    // Then
    assertThat( result ).isEqualTo( expected );
  }

  @Test
  void emptyArray() {
    // Given
    int[] array = new int[]{};
    int[] expected = new int[]{};
    // When
    int[] result = mergeSorter.sorter( array );
    // Then
    assertThat( result ).isEqualTo( expected );
  }

  @Test
  void singleElementArray() {
    // Given
    int[] array = new int[]{ 1 };
    int[] expected = new int[]{ 1 };
    // When
    int[] result = mergeSorter.sorter( array );
    // Then
    assertThat( result ).isEqualTo( expected );
  }

  @Test
  void evenNumberOfElementsDuplicateInTheMiddle() {
    // Given
    int[] array = new int[]{ 2, 4, 1, 7, 8, 3, 3, 9, 6, 11, 5, 10, };
    int[] expected = new int[]{ 1, 2, 3, 3, 4, 5, 6, 7, 8, 9, 10, 11 };
    // When
    int[] result = mergeSorter.sorter( array );
    // Then
    assertThat( result ).isEqualTo( expected );
  }

  @Test
  void oddNumberOfElementsDuplicateInTheMiddle() {
    // Given
    int[] array = new int[]{ 2, 4, 1, 7, 8, 3, 3, 9, 6, 5, 10, };
    int[] expected = new int[]{ 1, 2, 3, 3, 4, 5, 6, 7, 8, 9, 10 };
    // When
    int[] result = mergeSorter.sorter( array );
    // Then
    assertThat( result ).isEqualTo( expected );
  }

  @Test
  void oddNumberOfElementsMultipleDuplicatesThroughout() {
    // Given
    int[] array = new int[]{ 2, 3, 4, 3, 4, 4, 4, 5, 6, 6, 6, 7, 7, 4, 3, 2, 2, 1, 7, 8, 3, 3, 9, 6, 5, 10, 1 };
    int[] expected = new int[]{ 1, 1, 2, 2, 2, 3, 3, 3, 3, 3, 4, 4, 4, 4, 4, 5, 5, 6, 6, 6, 6, 7, 7, 7, 8, 9, 10 };
    // When
    int[] result = mergeSorter.sorter( array );
    // Then
    assertThat( result ).isEqualTo( expected );
  }

  @Test
  void evenNumberOfElementsMultipleDuplicatesThroughout() {
    // Given
    int[] array = new int[]{ 2, 3, 4, 3, 4, 4, 4, 5, 6, 6, 6, 7, 7, 4, 3, 2, 2, 1, 7, 8, 3, 3, 9, 6, 5, 10, };
    int[] expected = new int[]{ 1, 2, 2, 2, 3, 3, 3, 3, 3, 4, 4, 4, 4, 4, 5, 5, 6, 6, 6, 6, 7, 7, 7, 8, 9, 10 };
    // When
    int[] result = mergeSorter.sorter( array );
    // Then
    assertThat( result ).isEqualTo( expected );
  }

  @Test
  void evenNumberOfElementsOnlyTwoDifferentDigits() {
    // Given
    int[] array = new int[]{ 1, 1, 1, 1, 1, 1, 2, 2, 2, 2, 2, 2, 2, 1, 1, 1, 1, 1, 1, 2, 2, 2, 2, 2, 2, 2 };
    int[] expected = new int[]{ 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2 };
    // When
    int[] result = mergeSorter.sorter( array );
    // Then
    assertThat( result ).isEqualTo( expected );
  }

  @Test
  void oddNumberOfElementsOnlyTwoDifferentDigits() {
    // Given
    int[] array = new int[]{ 1, 1, 1, 1, 1, 1, 2, 2, 2, 2, 2, 2, 2, 1, 1, 1, 1, 1, 1, 2, 2, 2, 2, 2, 2 };
    int[] expected = new int[]{ 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2 };
    // When
    int[] result = mergeSorter.sorter( array );
    // Then
    assertThat( result ).isEqualTo( expected );
  }

  @Test
  void oddNumberOfElementsOnlyOneTypeOfDigit() {
    // Given
    int[] array = new int[]{ 1, 1, 1 };
    int[] expected = new int[]{ 1, 1, 1 };
    // When
    int[] result = mergeSorter.sorter( array );
    // Then
    assertThat( result ).isEqualTo( expected );
  }

  @Test
  void evenNumberOfElementsOnlyOneTypeOfDigit() {
    // Given
    int[] array = new int[]{ 1, 1, 1, 1 };
    int[] expected = new int[]{ 1, 1, 1, 1 };
    // When
    int[] result = mergeSorter.sorter( array );
    // Then
    assertThat( result ).isEqualTo( expected );
  }

  @Test
  void minusNumbersInArray() {
    // Given
    int[] array = new int[]{ 2, -4, 1, 7, 8, 3, 3, -9, 6, 5, -10, };
    int[] expected = new int[]{ -10, -9, -4, 1, 2, 3, 3, 5, 6, 7, 8 };
    // When
    int[] result = mergeSorter.sorter( array );
    // Then
    assertThat( result ).isEqualTo( expected );
  }

  @Test
  void minusNumbersInArrayDuplicateDigits() {
    // Given
    int[] array = new int[]{ 2, -4, 1, 7, 8, 3, 3, -9, 6, 6, 5, -10, -10, 11 };
    int[] expected = new int[]{ -10, -10, -9, -4, 1, 2, 3, 3, 5, 6, 6, 7, 8, 11 };
    // When
    int[] result = mergeSorter.sorter( array );
    // Then
    assertThat( result ).isEqualTo( expected );
  }

  @Test
  void minusNumbersInArrayDuplicateDigitsAtTheStartAndEnd() {
    // Given
    int[] array = new int[]{ 2, -4, 1, 7, 8, 3, 3, -9, 6, 6, 5, -10, -10, 11, 11, -10 };
    int[] expected = new int[]{ -10, -10, -10, -9, -4, 1, 2, 3, 3, 5, 6, 6, 7, 8, 11, 11 };
    // When
    int[] result = mergeSorter.sorter( array );
    // Then
    assertThat( result ).isEqualTo( expected );
  }
}