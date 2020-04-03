package com.save;

import java.io.File;
import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class InsertImage 
{
	public static void main(String[] args) throws Exception
	{
        	Class.forName("org.postgresql.Driver");
        	Connection con =    DriverManager.getConnection("jdbc:postgresql://localhost:5432/student","postgres","postgres");
            PreparedStatement pstmt =  con.prepareStatement("update app_user set signature = ? where user_name = 'admin'");
            File blob = new File("/home/atul/Add_Img/images/sign1.jpg");
            FileInputStream in = new FileInputStream(blob);

            pstmt.setBinaryStream(1,in,(int)blob.length()); 

            pstmt.executeUpdate();
            pstmt.close();
            System.out.println("done");
     }
}