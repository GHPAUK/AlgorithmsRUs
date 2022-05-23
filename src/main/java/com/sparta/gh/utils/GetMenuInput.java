package com.sparta.gh.utils;

import com.sparta.gh.exceptions.SortLoaderException;
import com.sparta.gh.managers.SortManager;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Scanner;

public class GetMenuInput {
  private static final Logger logger = LogManager.getLogger( GetMenuInput.class.getSimpleName() );
  public static int getMenuInput() throws SortLoaderException {
    System.out.println( "\nChoose a sorting method: " );
    Scanner input = new Scanner( System.in );

    try {
      int choice = input.nextInt();

      switch ( choice ) {
        case 1:
          return 1;
        case 2:
          return 2;
        case 3:
          return 3;
        case 4:
          return 4;
        case 5:
          return 5;
        case 6:
          return 6;
        case 7:
          return 7;
        default:
          SortManager sm = new SortManager();
          sm.start();
      }
    } catch ( SortLoaderException e ) {
      logger.error( "GetMenuInput.getMenuInput() -> input invalid" );
      System.out.println( "Error try again" );
      SortManager sm = new SortManager();
      sm.start();
    }
    return 0;
  }

  public static int getCompareMenuInput() throws SortLoaderException {
    Scanner input = new Scanner( System.in );

    try {
      int choice = input.nextInt();

      switch ( choice ) {
        case 1:
          return 1;
        case 2:
          return 2;
        case 3:
          return 3;
        case 4:
          return 4;
        case 5:
          return 5;
        default:
          SortManager sm = new SortManager();
          sm.start();
      }
    } catch ( SortLoaderException e ) {
      logger.error( "GetMenuInput.getCompareMenuInput() -> input invalid" );
      System.out.println( "Error try again" );
      SortManager sm = new SortManager();
      sm.start();
    }
    return 0;
  }

}
