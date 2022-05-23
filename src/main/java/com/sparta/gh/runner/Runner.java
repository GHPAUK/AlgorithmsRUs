package com.sparta.gh.runner;

import com.sparta.gh.exceptions.SortLoaderException;
import com.sparta.gh.managers.SortManager;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Runner {
  private static final Logger logger = LogManager.getLogger( Runner.class.getSimpleName() );

  public static void main( String[] args ) throws SortLoaderException {
    SortManager sm = new SortManager();
    sm.start();
  }
}
