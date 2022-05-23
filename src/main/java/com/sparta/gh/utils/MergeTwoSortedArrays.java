package com.sparta.gh.utils;

public class MergeTwoSortedArrays {
  public static int[] mergeSortedArrays( int[] arrayOne, int[] arrayTwo ) {
    int[] arr = new int[ arrayOne.length + arrayTwo.length ];
    int left = 0;
    int right = 0;
    int merged = 0;

    while (left < arrayOne.length && right < arrayTwo.length){
      if (arrayOne[left] <= arrayTwo[ right ]){
        arr[merged++] = arrayOne[left++];
      } else {
        arr[merged++] = arrayTwo[ right++ ];
      }
    }
    while ( left < arrayOne.length ) {
      arr[ merged++ ] = arrayOne[ left++ ];
    }
    while ( right < arrayTwo.length) {
      arr[merged++ ] = arrayTwo[ right++ ];
    }

    return arr;
  }
}
