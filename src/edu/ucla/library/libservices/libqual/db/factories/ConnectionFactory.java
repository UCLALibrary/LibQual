package edu.ucla.library.libservices.libqual.db.factories;

import java.util.Properties;

import org.springframework.jdbc.datasource.DriverManagerDataSource;

public class ConnectionFactory
{
  public static DriverManagerDataSource createConnection(Properties props)
  {
    DriverManagerDataSource ds;

    ds = new DriverManagerDataSource();
    ds.setDriverClassName( props.getProperty("db.driver") );
    ds.setUrl( props.getProperty("db.url") );
    ds.setUsername( props.getProperty("db.user") );
    ds.setPassword( props.getProperty("db.pwd") );

    return ds;
  }
}
