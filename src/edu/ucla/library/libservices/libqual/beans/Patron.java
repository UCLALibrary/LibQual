package edu.ucla.library.libservices.libqual.beans;

public class Patron
{
  private String address_line1;
  private String address_line2;
  private String email;
  private String first_name;
  private String group;
  private String last_name;
  private String mail_code;
  private String middle_name;

  public Patron()
  {
  }

  public void setAddress_line1( String address_line1 )
  {
    this.address_line1 = address_line1;
  }

  public String getAddress_line1()
  {
    return address_line1;
  }

  public void setAddress_line2( String address_line2 )
  {
    this.address_line2 = address_line2;
  }

  public String getAddress_line2()
  {
    return address_line2;
  }

  public void setEmail( String email )
  {
    this.email = email;
  }

  public String getEmail()
  {
    return email;
  }

  public void setFirst_name( String first_name )
  {
    this.first_name = first_name;
  }

  public String getFirst_name()
  {
    return first_name;
  }

  public void setGroup( String group )
  {
    this.group = group;
  }

  public String getGroup()
  {
    return group;
  }

  public void setLast_name( String last_name )
  {
    this.last_name = last_name;
  }

  public String getLast_name()
  {
    return last_name;
  }

  public void setMail_code( String mail_code )
  {
    this.mail_code = mail_code;
  }

  public String getMail_code()
  {
    return mail_code;
  }

  public void setMiddle_name( String middle_name )
  {
    this.middle_name = middle_name;
  }

  public String getMiddle_name()
  {
    return middle_name;
  }
}
