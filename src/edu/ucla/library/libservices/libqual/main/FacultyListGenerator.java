package edu.ucla.library.libservices.libqual.main;

import edu.ucla.library.libservices.libqual.beans.Patron;
import edu.ucla.library.libservices.libqual.db.factories.ConnectionFactory;
import edu.ucla.library.libservices.libqual.db.mappers.PatronMapper;
import edu.ucla.library.libservices.libqual.util.NumberGenerator;

import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;

import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import java.util.Set;

import org.springframework.jdbc.core.JdbcTemplate;

public class FacultyListGenerator
{
  private static List<Patron> allPatrons;
  private static List<Patron> selected;
  private static Properties props;
  private static Set<Integer> theNumbers;
  private static final String SET_SIZE = "1000";

  public FacultyListGenerator()
  {
  }

  public static void main( String[] args )
  {
    loadProperties( args[ 0 ] );

    getAllPatrons();
    populateNumbers();

    selectPatrons();

    try
    {
      printPatrons();
    }
    catch ( IOException ioe )
    {
      ioe.printStackTrace();
    }
  }

  private static void loadProperties( String propsFilename )
  {
    props = new Properties();
    try
    {
      props.load( new FileInputStream( propsFilename ) );
    }
    catch ( IOException ioe )
    {
      System.err.println( "Unable to open properties file: " + 
                          propsFilename );
      ioe.printStackTrace();
      System.exit( 1 );
    }
  }

  private static void getAllPatrons()
  {
    allPatrons = 
        new JdbcTemplate( ConnectionFactory.createConnection( props ) ).query( props.getProperty( "sql.allpatrons" ), 
                                                                               new PatronMapper() );
  }

  private static void populateNumbers()
  {
    NumberGenerator ng;

    ng = new NumberGenerator();
    ng.setMax( allPatrons.size() );
    ng.setSize( Integer.parseInt( props.getProperty( "patrons.count", 
                                                     SET_SIZE ) ) );

    theNumbers = ng.generateNumbers();
  }

  private static void selectPatrons()
  {
    selected = new ArrayList<Patron>();

    for ( Integer index: theNumbers )
    {
      selected.add( allPatrons.get( index ) );
    }
  }

  private static void printPatrons()
    throws IOException
  {
    BufferedWriter writer;

    writer = 
        new BufferedWriter( new FileWriter( props.getProperty( "file.name" ) ) );

    writer.write( "\"type\",\"patron_group\",\"email\",\"first_name\",\"middle_name\",\"last_name\",\"address_line1\",\"address_line2\",\"mail_code\"" );
    writer.newLine();

    for ( Patron thePatron: selected )
    {
      writer.write( "\"Faculty\",\"" + thePatron.getGroup() + "\"," );
      writer.write( "\"" + 
                    ( isEmpty( thePatron.getEmail() ) ? "" : thePatron.getEmail() ) + 
                    "\"," );
      writer.write( "\"" + 
                    ( isEmpty( thePatron.getFirst_name() ) ? "" : thePatron.getFirst_name() ) + 
                    "\"," );
      writer.write( "\"" + 
                    ( isEmpty( thePatron.getMiddle_name() ) ? "" : thePatron.getMiddle_name() ) + 
                    "\"," );
      writer.write( "\"" + 
                    ( isEmpty( thePatron.getLast_name() ) ? "" : thePatron.getLast_name() ) + 
                    "\"," );
      writer.write( "\"" + 
                    ( isEmpty( thePatron.getAddress_line1() ) ? "" : thePatron.getAddress_line1() ) + 
                    "\"," );
      writer.write( "\"" + 
                    ( isEmpty( thePatron.getAddress_line2() ) ? "" : thePatron.getAddress_line2() ) + 
                    "\"," );
      writer.write( "\"" + 
                    ( isEmpty( thePatron.getMail_code() ) ? "" : thePatron.getMail_code() ) + 
                    "\"" );
      writer.newLine();
    }

    writer.flush();
    writer.close();
  }

  private static boolean isEmpty( String value )
  {
    return ( value == null || value.equals( "" ) || value.length() == 0 || 
             value.equalsIgnoreCase( "null" ) );
  }
}
