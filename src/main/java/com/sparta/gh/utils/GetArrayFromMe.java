package com.sparta.gh.utils;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;

public class GetArrayFromMe {
  private static final Logger logger = LogManager.getLogger( GetArrayFromMe.class.getSimpleName() );

  public GetArrayFromMe() {
  }

  public int[] getArray() {
    System.out.println( "\nInput a size for the array to be sorted: " );
    Scanner input = new Scanner( System.in );
    int size = 0;

    try {
      size = input.nextInt();
    } catch ( InputMismatchException ime ) {
      System.out.println( "\nInvalid input\n\n\n" );
      logger.error( "GetArrayFromMe.getArray() -> InputMismatchException - input from scanner is invalid" );
      getArray();
    }

    Random r = new Random();
    int[] generated = new int[ size ];

    for ( int i = 0; i < generated.length; i++ ) {
      generated[ i ] = r.nextInt( 1000 );
    }

    return generated;
  }
}
