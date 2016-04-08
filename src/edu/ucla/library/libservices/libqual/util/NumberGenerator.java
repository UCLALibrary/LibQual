package edu.ucla.library.libservices.libqual.util;

import java.util.Random;
import java.util.Set;
import java.util.TreeSet;

public class NumberGenerator
{
  private int max;
  private int size;

  public NumberGenerator()
  {
  }

  public void setMax( int max )
  {
    this.max = max;
  }

  private int getMax()
  {
    return max;
  }

  public void setSize( int size )
  {
    this.size = size;
  }

  private int getSize()
  {
    return size;
  }

  public Set<Integer> generateNumbers()
  {
    Random generator;
    Set<Integer> theNumbers;

    generator = new Random( System.currentTimeMillis() );
    theNumbers = new TreeSet<Integer>();

    while ( theNumbers.size() < getSize() )
    {
      theNumbers.add( generator.nextInt( getMax() ) );
    }

    return theNumbers;
  }
}
