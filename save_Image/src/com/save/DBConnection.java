package com.save;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class DBConnection
{
	public static void main(String[] args)
	{
		try {
			Class.forName("org.postgresql.Driver");
			Connection con = DriverManager.getConnection("jdbc:postgresql://localhost:5432/test","postgres","postgres");
			PreparedStatement pstmt = con.prepareStatement("select Name, age,address, mobile from student");
			ResultSet rs = pstmt.executeQuery();
			while (rs.next()){
				System.out.println(rs.getString(1)+ " "+ rs.getInt(2)+ " "+rs.getString(3)+" "+ rs.getString(4));
				
			}
		} catch(Exception ex) {
			ex.printStackTrace();
		}
		System.out.println("Done");
	}
}
