/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.bank_management_system;

import java.sql.*;

/**
 *
 * @author Kusal Saraf
 */
public class DBConnection {
	public static Connection getConnection() {
		try {
			// step1 load the driver class
			Class.forName("oracle.jdbc.driver.OracleDriver");

			// step2 create the connection object
			Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "system", "1998");

			return con;
			/*
			 * //step3 create the statement object PreparedStatement sql =
			 * con.prepareStatement("select * from bank");
			 * 
			 * //step4 execute query ResultSet rs=sql.executeQuery(); while(rs.next())
			 * System.out.println(rs.getInt(1)+"  "+rs.getString(2)+"  "+rs.getInt(3));
			 * 
			 * //step5 close the connection object con.close();
			 */

		} catch (Exception e) {
			System.out.println(e);
		}
		return null;
	}
}
