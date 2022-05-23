package com.sparta.gh.managers;

import com.sparta.gh.algorithms.*;
import com.sparta.gh.exceptions.SortLoaderException;
import com.sparta.gh.interfaces.SortAlgorithm;
import com.sparta.gh.utils.GetArrayFromMe;
import com.sparta.gh.utils.GetMenuInput;
import com.sparta.gh.views.DisplayView;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class SortManager {
  private static final Logger logger = LogManager.getLogger( SortManager.class.getSimpleName() );
  public GetArrayFromMe getArray = new GetArrayFromMe();

  public void start() throws SortLoaderException {
    DisplayView.displayMenu();
    try {
      int choice = GetMenuInput.getMenuInput();

      if ( choice > 0 && choice < 6 ) {
        SortAlgorithm sorter = chosenSort( choice );
        int[] arr = getArray.getArray();
        DisplayView.printBeforeSort( sorter, arr );
        DisplayView.printResult( sorter, arr );
      }

      if ( choice == 6 ) {
        startCompare();
      }

      if (choice == 7){
        startCompareAll();
      }

    } catch ( SortLoaderException sle ) {
      sle.printStackTrace();
      logger.error( "SortManager.start() -> getMenuInput() evaluates SortLoaderException" );
    } catch ( NullPointerException npe ) {
      logger.error( "SortManager.start() -> chosenSort() evaluates NullPointerException" );
    }
  }

  public void startCompare() throws SortLoaderException {
    DisplayView.displayCompareMenu();
    DisplayView.initialAlgorithmChoicePrompt();

    SortAlgorithm sorterOne = chosenSort( GetMenuInput.getCompareMenuInput() );

    DisplayView.secondAlgorithmChoicePrompt();
    SortAlgorithm sorterTwo = chosenSort( GetMenuInput.getCompareMenuInput() );

    int[] arr = getArray.getArray();

    DisplayView.printBeforeCompare( sorterOne, sorterTwo, arr );
    DisplayView.printAfterCompare( sorterOne, sorterTwo, arr );
  }

  public void startCompareAll() throws SortLoaderException {
    int[] arr = getArray.getArray();

    DisplayView.printBeforeCompareAll( arr );
    DisplayView.printAfterCompareAll( chosenSort( 1), chosenSort( 2 ), chosenSort( 3 ),
            chosenSort( 4 ), chosenSort( 5 ), arr);
  }

  public static SortAlgorithm chosenSort( int num ) {
    return switch ( num ) {
      case 1 -> new BubbleSorter();
      case 2 -> new BinarySorter();
      case 3 -> new MergeSorter();
      case 4 -> new InsertionSort();
      case 5 -> new JDKSorter();
      default -> null;
    };
  }
}