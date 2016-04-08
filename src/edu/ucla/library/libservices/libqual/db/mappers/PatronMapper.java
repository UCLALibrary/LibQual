package edu.ucla.library.libservices.libqual.db.mappers;

import edu.ucla.library.libservices.libqual.beans.Patron;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

public class PatronMapper
  implements RowMapper
{
  public PatronMapper()
  {
  }

  public Object mapRow( ResultSet rs, int i )
    throws SQLException
  {
    Patron patron;

    patron = new Patron();

    patron.setAddress_line1( rs.getString( "address_line1" ) );
    patron.setAddress_line2( rs.getString( "address_line2" ) );
    patron.setEmail( rs.getString( "email" ) );
    patron.setFirst_name( rs.getString( "first_name" ) );
    patron.setGroup( rs.getString( "patron_group" ) );
    patron.setLast_name( rs.getString( "last_name" ) );
    patron.setMail_code( rs.getString( "mail_code" ) );
    patron.setMiddle_name( rs.getString( "middle_name" ) );

    return patron;
  }
}
