package com.sparta.gh.algorithms;

import com.sparta.gh.interfaces.SortAlgorithm;
import java.util.ArrayList;

public class BinarySorter implements SortAlgorithm {
  public ArrayList< Integer > sorted = new ArrayList<>();
  public Node root;

  static class Node {
    int key;
    Node leftChild;
    Node rightChild;

    public Node( int data ) {
      key = data;
      leftChild = null;
      rightChild = null;
    }
  }

  public BinarySorter() {
    root = null;
  }

  @Override
  public int[] sorter( int[] arr ) {
    for ( int j : arr ) {
      insert( j );
    }

    inorder();
    int[] convertedReturn = new int[ sorted.size() ];
    for ( int i = 0; i < sorted.size(); i++ ) {
      if ( i == sorted.size() ) {
        break;
      }
      convertedReturn[ i ] = sorted.get( i );
    }

    return convertedReturn;
  }

  void insert( int key ) {
    root = insert_Recursive( root, key );
  }

  Node insert_Recursive( Node root, int key ) {
    if ( root == null ) {
      root = new Node( key );
      return root;
    }

    if ( key <= root.key )
      root.leftChild = insert_Recursive( root.leftChild, key );
    else if ( key > root.key )
      root.rightChild = insert_Recursive( root.rightChild, key );
    return root;
  }

  void inorder() {
    inorder_Recursive( root );
  }

  void inorder_Recursive( Node root ) {
    if ( root != null ) {
      inorder_Recursive( root.leftChild );
      sorted.add( root.key );
      inorder_Recursive( root.rightChild );
    }
  }
}
