package dbpack;
import java.sql.*;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.DataInputStream;


import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;

import beans.MinistryDetails;

public class MyDBClass  extends MinistryDetails
{
	Connection con,con1;
	PreparedStatement ps,ps1;
	ResultSet rs,rs1;
	
	String strEmail="";
	public MyDBClass()
	{
		try
		{
			Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
			con=DriverManager.getConnection("jdbc:odbc:District");
		}
		catch(Exception ee)
		{
			System.out.println("Connection Error : "+ee);
		}
	}
	
	public MinistryDetails checkUserLogin(String username, String password)
	{
		MinistryDetails ud=null;
		try {
			ps=con.prepareStatement("select * from MinistryDetails where username=? and password=?");
			ps.setString(1, username);
			ps.setString(2, password);
			ResultSet rs=ps.executeQuery();
			if(rs.next())
			{
				ud=new MinistryDetails();
				ud.setId(rs.getString(1));
				ud.setUsername(rs.getString(2));
				ud.setMinistry(rs.getString(3));
				ud.setPassword(rs.getString(4));
				
				
			}
		} catch (Exception e) {
			System.out.println("Error in Login :"+e);
		}
		return ud;
	}
	
	
	public int registerUser(MinistryDetails ud)
	{
		int ret=0;
		try {
			ps=con.prepareStatement("insert into MinistryDetails(username ,ministry, password) values(?, ?, ?)");
			ps.setString(1, ud.getUsername());
			ps.setString(2, ud.getMinistry());
			ps.setString(3, ud.getPassword());
			
			ret=ps.executeUpdate();
			
		} catch (Exception e) {
			System.out.println("Error in Login :"+e);
		}
		return ret;
	}
	
	
}
	
	

