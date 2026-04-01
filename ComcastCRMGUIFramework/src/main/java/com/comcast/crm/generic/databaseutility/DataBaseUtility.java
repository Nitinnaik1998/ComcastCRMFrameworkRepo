package com.comcast.crm.generic.databaseutility;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;

import java.sql.Statement;

import com.mysql.cj.jdbc.Driver;

public class DataBaseUtility
{

	Connection con;
	public void getDbconnection(String Url,String userName,String Password) throws Throwable
	{
		try {
		Driver driver=new Driver();
		DriverManager.registerDriver(driver);
		con=DriverManager.getConnection(Url,userName,Password) ;
	}
		catch(Exception e) {
		    e.printStackTrace();
		}
}
	public void getDbconnection() throws Throwable
	{
		try {
		Driver driver=new Driver();
		DriverManager.registerDriver(driver);
		con=DriverManager.getConnection("jdbc:mysql://49.249.28.218:3307/ninza_hrm", "root@%", "root") ;
	}
		catch(Exception e) {}
}
	public void connectToDB() throws Throwable {
	    Driver driver = new Driver();
	    DriverManager.registerDriver(driver);
	    con = DriverManager.getConnection(
	        "jdbc:mysql://49.249.28.218:3307/ninza_hrm",
	        "root@%",
	        "root"
	    );
	}
public void closeDbconnection() throws Throwable
{
	try
	{
		con.close();
	}
	catch(Exception e) {
	    e.printStackTrace();
	}
	
}
public ResultSet executeConSelectQuery(String query) throws Throwable
{
	ResultSet result=null;
	try {
	Statement stat=con.createStatement();
	result =stat.executeQuery(query);
	}
	catch(Exception e) {}
	return result;
}

public int executeNonSelectQuery(String query) throws Throwable
{
	int result=0;
	try {
	Statement stat=con.createStatement();
	result =stat.executeUpdate(query);
	}
	catch(Exception e) {}
	return result;
}


}
