package com.sparta.gh.algorithms;

import com.sparta.gh.interfaces.SortAlgorithm;

public class InsertionSort implements SortAlgorithm {
  @Override
  public int[] sorter( int[] array ) {

    int n = array.length;
    for ( int i = 1; i < n; i++ ) {
      int key = array[ i ];
      int index = i - 1;
      while ( ( index > -1 ) && ( array[ index ] > key ) ) {
        array[ index + 1 ] = array[ index ];
        index--;
      }
      array[ index + 1 ] = key;
    }
    return array;
  }
}
