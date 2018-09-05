package com.ComITProject;

public class UserProfile {String username;
String password;
String firstName;
String lastName;
String emailID;

public UserProfile (String username, String password, String firstName, String lastName, String emailID)
{
	this.username = username;
	this.password = password;
	this.firstName = firstName;
	this.lastName = lastName;
	this.emailID = emailID;
}

public String getUsername()
{
	return username;
}

public String getPassword()
{
	return password;
}

public String getFirstName()
{
	return firstName;
}

public String getLastName()
{
	return lastName;
}
public String emailID()
{
	return emailID;
}

public void setUsername(String username)
{
	this.username = username;
}

public void setPassword(String password)
{
	this.password = password;
}

public void setFirstName(String firstName)
{
	this.firstName = firstName;
}

public void setLastName(String lastName)
{
	this.lastName = lastName;
}
public void setEmailID(String emailID)
{
	this.emailID = emailID;
}
}