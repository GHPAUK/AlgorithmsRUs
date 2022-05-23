package com.sparta.gh.algorithms;

import com.sparta.gh.interfaces.SortAlgorithm;

import java.util.Arrays;

public class JDKSorter implements SortAlgorithm {
  @Override
  public int[] sorter( int[] array ) {
    Arrays.sort(array);
    return array;
  }
}
