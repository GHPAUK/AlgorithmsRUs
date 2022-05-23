package com.sparta.gh.algorithms;

import com.sparta.gh.interfaces.SortAlgorithm;

public class MergeSorter implements SortAlgorithm {
  @Override
  public int[] sorter( int[] array ) {
    int n = array.length;
    int[] sorted;

    sorted = mergeSort( array, n );

    return sorted;
  }

  public int[] mergeSort( int[] a, int n ) {
    if ( n < 2 ) {
      return a;
    }

    int mid = n / 2;
    int[] l = new int[ mid ];
    int[] r = new int[ n - mid ];

    for ( int i = 0; i < mid; i++ ) {
      l[ i ] = a[ i ];
    }
    for ( int i = mid; i < n; i++ ) {
      r[ i - mid ] = a[ i ];
    }
    mergeSort( l, mid );
    mergeSort( r, n - mid );

    return merge( a, l, r, mid, n - mid );
  }

  public int[] merge( int[] a, int[] l, int[] r, int left, int right ) {

    int i = 0;
    int j = 0;
    int k = 0;

    while ( i < left && j < right ) {
      if ( l[ i ] <= r[ j ] ) {
        a[ k++ ] = l[ i++ ];
      } else {
        a[ k++ ] = r[ j++ ];
      }
    }
    while ( i < left ) {
      a[ k++ ] = l[ i++ ];
    }
    while ( j < right ) {
      a[ k++ ] = r[ j++ ];
    }
    return a;
  }
}
