package com.sparta.gh.algorithms;

import com.sparta.gh.interfaces.SortAlgorithm;

public class BubbleSorter implements SortAlgorithm {
  @Override
  public int[] sorter( int[] array ) {

    for ( int iteration = 0; iteration < array.length - 1; iteration++ ) {
      int endOfArrayIndex = array.length - iteration;
      boolean swapped = false;

      for ( int currentIndex = 0; currentIndex < endOfArrayIndex - 1; ++currentIndex ) {
        if ( array[ currentIndex ] > array[ currentIndex + 1 ] ) {
          int tmp = array[ currentIndex + 1 ];
          array[ currentIndex + 1 ] = array[ currentIndex ];
          array[ currentIndex ] = tmp;
          swapped = true;
        }
      }

      if ( !swapped ) {
        break;
      }
    }

    return array;
  }
}
