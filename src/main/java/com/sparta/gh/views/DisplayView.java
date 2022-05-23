package com.sparta.gh.views;

import com.sparta.gh.interfaces.SortAlgorithm;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class DisplayView {
  private static Logger logger = LogManager.getLogger( DisplayView.class.getSimpleName() );

  public static void displayMenu() {
    System.out.println( "\n\n\n\n\n\n\t\t   ================" );
    System.out.println( "\t\t   | A Handy Sort |" );
    System.out.println( "\t\t   ================\n\n" );

    System.out.println( menuItems() );
  }

  public static void displayCompareMenu() {
    System.out.println( "\n\n\n\n\n\n\n\n\n\n\n   =========================" );
    System.out.println( "   | A Handy Sort Comparer |" );
    System.out.println( "   =========================\n\n" );

    System.out.println( algorithmChoices() );
  }

  public static void initialAlgorithmChoicePrompt() {
    System.out.println( "\nPlease select an algorithm to compare against: " );
  }

  public static void secondAlgorithmChoicePrompt() {
    System.out.println( "\nPlease select a second algorithm to compare against: " );
  }

  private static String menuItems() {
    return "Bubble Sorter                (1)\n" +
            "Binary Sorter                (2)\n" +
            "Merge Sorter                 (3)\n" +
            "Insertion Sorter             (4)\n" +
            "JDK Sorter                   (5)\n\n" +
            "Algorithm Speed Comparer     (6)\n" +
            "Algorithm Speed Compare ALL  (7)";
  }

  private static String algorithmChoices() {
    return "Bubble Sorter                (1)\n" +
            "Binary Sorter                (2)\n" +
            "Merge Sorter                 (3)\n" +
            "Insertion Sorter             (4)\n" +
            "JDK Sorter                   (5)";
  }

  public static void printBeforeSort( SortAlgorithm sorter, int[] arrayToSort ) {
    System.out.println( "\nUsing the " + sorter.getClass().getSimpleName() + " method" );
    System.out.println( "\nArray before sorting: \n" + Arrays.toString( arrayToSort ) );
  }

  public static void printResult( SortAlgorithm sorter, int[] arrayToSort ) {
    long start = System.nanoTime();
    int[] sortedArray = sorter.sorter( arrayToSort );
    long end = System.nanoTime();
    System.out.println( "\nArray After sorting: \n" + Arrays.toString( sortedArray ) );
    System.out.println( "\nTime Taken: " + ( end - start ) + " nanoseconds." );
  }

  public static void printBeforeCompare( SortAlgorithm sorterOne, SortAlgorithm sorterTwo, int[] arr ) {
    System.out.println( "\nArray before sorting: \n" + Arrays.toString( arr ) );
    System.out.println( "\n\n<----------|------------>" );
    System.out.println( "|Comparing |" + sorterOne.getClass().getSimpleName() );
    System.out.println( "<----------|------------>" );
    System.out.println( "|Against   |" + sorterTwo.getClass().getSimpleName() );
    System.out.println( "<----------|------------>" );
    System.out.println( "|Array size| " + arr.length );
    System.out.println( "<----------|------------>" );
  }

  public static void printAfterCompare( SortAlgorithm sorterOne, SortAlgorithm sorterTwo, int[] arr ) {
    long startOne = System.nanoTime();
    int[] sortedArray = sorterOne.sorter( arr );
    long endOne = System.nanoTime();
    long startTwo = System.nanoTime();
    sortedArray = sorterTwo.sorter( arr );
    long endTwo = System.nanoTime();

    System.out.print( "\n====================================" );
    System.out.println( "\n|" + sorterOne.getClass().getSimpleName() + "\n          |Finished in: " + ( endOne - startOne ) + "ns" );
    System.out.println( "====================================" );
    System.out.println( "|" + sorterTwo.getClass().getSimpleName() + "\n          |Finished in: " + ( endTwo - startTwo ) + "ns" );
    System.out.println( "====================================" );

    if ( ( endOne - startOne ) < ( endTwo - startTwo ) ) {
      System.out.println( sorterOne.getClass().getSimpleName() + " was " + ( ( endTwo - startTwo ) - ( endOne - startOne ) ) + "ns quicker\n" );
    } else {
      System.out.println( sorterTwo.getClass().getSimpleName() + " was " + ( ( endOne - startOne ) - ( endTwo - startTwo ) ) + "ns quicker\n" );
    }

    logger.info( "\nArray size : " + arr.length + "\nSorted in  : " + ( endOne - startOne ) + "ns" + "\nMethod     : " + sorterOne.getClass().getSimpleName());
    logger.info( "\nArray size : " + arr.length + "\nSorted in  : " + ( endTwo - startTwo ) + "ns" + "\nMethod     : " + sorterTwo.getClass().getSimpleName());
    long one = ( endOne - startOne );
    long two = ( endTwo - startTwo );

    if (one > two){
      logger.info( "\nDifference between methods: " + (one - two) + "ns " + sorterTwo.getClass().getSimpleName() + "(Fastest) \n====================");
    } else {
      logger.info( "\nDifference between methods: " + (two - one) + "ns " + sorterOne.getClass().getSimpleName() + "(Fastest)\n====================");
    }
  }

  public static void printBeforeCompareAll( int[] arr ) {
    System.out.println( "\nArray before sorting: \n" + Arrays.toString( arr ) );
    System.out.println( "\n\n<----------|------------>" );
    System.out.println( "|Comparing | All");
    System.out.println( "<----------|------------>" );
    System.out.println( "|Against   | All");
    System.out.println( "<----------|------------>" );
    System.out.println( "|Array size| " + arr.length );
    System.out.println( "<----------|------------>" );
  }

  public static void printAfterCompareAll( SortAlgorithm sorterOne, SortAlgorithm sorterTwo, SortAlgorithm sorterThree,
                                           SortAlgorithm sorterFour, SortAlgorithm sorterFive, int[] arr ) {
    long startOne = System.nanoTime();
    int[] sortedArray = sorterOne.sorter( arr );
    long endOne = System.nanoTime();
    long startTwo = System.nanoTime();
    sortedArray = sorterTwo.sorter( arr );
    long endTwo = System.nanoTime();
    long startThree = System.nanoTime();
    sortedArray = sorterThree.sorter( arr );
    long endThree = System.nanoTime();
    long startFour = System.nanoTime();
    sortedArray = sorterFour.sorter( arr );
    long endFour = System.nanoTime();
    long startFive = System.nanoTime();
    sortedArray = sorterFive.sorter( arr );
    long endFive = System.nanoTime();

    long one = ( endOne - startOne );
    long two = ( endTwo - startTwo );
    long three = ( endThree - startThree );
    long four = ( endFour - startFour );
    long five = ( endFive - startFive );

    ArrayList<Long> resultsInOrder = new ArrayList<>();
    resultsInOrder.add( one );
    resultsInOrder.add( two );
    resultsInOrder.add( three );
    resultsInOrder.add( four );
    resultsInOrder.add( five );

    Collections.sort( resultsInOrder );

    String slowest = "";
    if ( resultsInOrder.get( 4 ) == one ) {
      slowest = sorterOne.getClass().getSimpleName();
    } else if ( resultsInOrder.get( 4 ) == two ) {
      slowest = sorterTwo.getClass().getSimpleName();
    } else if ( resultsInOrder.get( 4 ) == three ) {
      slowest = sorterThree.getClass().getSimpleName();
    } else if ( resultsInOrder.get( 4 ) == four ) {
      slowest = sorterFour.getClass().getSimpleName();
    } else if ( resultsInOrder.get( 4 ) == five ) {
      slowest = sorterFive.getClass().getSimpleName();
    }

    System.out.print( "\n====================================" );
    System.out.println( "\n|" + sorterOne.getClass().getSimpleName() + "\n          |Finished in: " + one + "ns" );
    System.out.println( "====================================" );
    System.out.println( "|" + sorterTwo.getClass().getSimpleName() + "\n          |Finished in: " + two + "ns" );
    System.out.println( "====================================" );
    System.out.println( "|" + sorterThree.getClass().getSimpleName() + "\n          |Finished in: " + three + "ns" );
    System.out.println( "====================================" );
    System.out.println( "|" + sorterFour.getClass().getSimpleName() + "\n          |Finished in: " + four + "ns" );
    System.out.println( "====================================" );
    System.out.println( "|" + sorterFive.getClass().getSimpleName() + "\n          |Finished in: " + five + "ns" );
    System.out.println( "====================================" );

    if ( one == resultsInOrder.get( 0 ) ) {
      System.out.println( sorterOne.getClass().getSimpleName() + " was " + (resultsInOrder.get( 4 ) - resultsInOrder.get( 0 )) + "ns quicker\n" );
    } else if (two == resultsInOrder.get( 0 )){
      System.out.println( sorterTwo.getClass().getSimpleName() + " was " + (resultsInOrder.get( 4 ) - resultsInOrder.get( 0 )) + "ns quicker\n" );
    } else if (three == resultsInOrder.get( 0 )){
      System.out.println( sorterThree.getClass().getSimpleName() + " was " + (resultsInOrder.get( 4 ) - resultsInOrder.get( 0 )) + "ns quicker\n" );
    } else if (four == resultsInOrder.get( 0 )){
      System.out.println( sorterFour.getClass().getSimpleName() + " was " + (resultsInOrder.get( 4 ) - resultsInOrder.get( 0 )) + "ns quicker\n" );
    }else {
      System.out.println( sorterFive.getClass().getSimpleName() + " was " + (resultsInOrder.get( 4 ) - resultsInOrder.get( 0 )) + "ns quicker than the slowest method: " + slowest + "\n");
    }

    logger.info( "\nArray size : " + arr.length + "\nSorted in  : " + one + "ns" + "\nMethod     : " + sorterOne.getClass().getSimpleName());
    logger.info( "\nArray size : " + arr.length + "\nSorted in  : " + two + "ns" + "\nMethod     : " + sorterTwo.getClass().getSimpleName());
    logger.info( "\nArray size : " + arr.length + "\nSorted in  : " + three + "ns" + "\nMethod     : " + sorterThree.getClass().getSimpleName());
    logger.info( "\nArray size : " + arr.length + "\nSorted in  : " + four + "ns" + "\nMethod     : " + sorterFour.getClass().getSimpleName());
    logger.info( "\nArray size : " + arr.length + "\nSorted in  : " + five + "ns" + "\nMethod     : " + sorterFive.getClass().getSimpleName());

    if ( one == resultsInOrder.get( 0 ) ) {
      logger.info( "\nDifference between fastest and slowest methods: " + (resultsInOrder.get( 4 ) - resultsInOrder.get( 0 )) + "ns " + sorterOne.getClass().getSimpleName() + "(Fastest) \n====================");
    } else if (two == resultsInOrder.get( 0 )){
      logger.info( "\nDifference between fastest and slowest methods: " + (resultsInOrder.get( 4 ) - resultsInOrder.get( 0 )) + "ns " + sorterTwo.getClass().getSimpleName() + "(Fastest)\n====================");
    } else if (three == resultsInOrder.get( 0 )){
      logger.info( "\nDifference between fastest and slowest methods: " + (resultsInOrder.get( 4 ) - resultsInOrder.get( 0 )) + "ns " + sorterThree.getClass().getSimpleName() + "(Fastest)\n====================");
    } else if (four == resultsInOrder.get( 0 )){
      logger.info( "\nDifference between fastest and slowest methods: " + (resultsInOrder.get( 4 ) - resultsInOrder.get( 0 )) + "ns " + sorterFour.getClass().getSimpleName() + "(Fastest)\n====================");
    }else {
      logger.info( "\nDifference between fastest and slowest methods: " + (resultsInOrder.get( 4 ) - resultsInOrder.get( 0 )) + "ns " + sorterFive.getClass().getSimpleName() + "(Fastest)\n====================");
    }
  }
}