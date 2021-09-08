/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.bank_management_system;

//import com.sun.javafx.font.FontConstants;
import java.sql.*;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Kusal Saraf
 */
public class Methods {

	public Connection con = DBConnection.getConnection();
	public static Customer_Details obj = null;
    /*public static long currectBal() {
    	PreparedStatement sql,
		try {
			sql = con.prepareStatement("select balance from bank where username = ?");
			sql.setString(1, obj.getName());
			ResultSet rs1 = sql.executeQuery();
			if (rs1.next()) {
				long bal = rs1.getLong(1);
				obj.setBalance(bal);
			}
			if (rs == 1) {
				System.out.println("Balance have been updated");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
    }*/
	public boolean checkLoginDetails(String username, String password) {
		PreparedStatement sql;
		try {
			sql = con.prepareStatement("select * from bank where username=? and password =?");
			sql.setString(1, username);
			sql.setString(2, password);
			ResultSet rs = sql.executeQuery();
			if (rs.next()) {
				obj = new Customer_Details(rs.getString(1), rs.getString(2), rs.getString(3), rs.getLong(4),
						rs.getString(5), rs.getString(6), rs.getString(7), rs.getString(8));
				return true;
			}
		} catch (SQLException e) {
			return false;
		}
		return false;

	}

	public boolean withdrawBalance(long amount) {
		PreparedStatement sql, sql1, sql2;
		try {
			sql1 = con.prepareStatement("select balance from bank where username =?");
			sql1.setString(1, obj.getName());
			ResultSet rs1 = sql1.executeQuery();
			if (rs1.next()) {
				long bal = rs1.getLong(1);
				if ((bal - 500) < amount) {
					return false;
				} else {
					sql = con.prepareStatement("update bank set balance=balance - ? where username = ?");

					sql.setLong(1, amount);
					sql.setString(2, obj.getName());
					int rs = sql.executeUpdate();
					sql2 = con.prepareStatement("select balance from bank where username =?");
					sql2.setString(1, obj.getName());
					ResultSet rs2 = sql2.executeQuery();
					if (rs2.next()) {
						obj.setBalance(rs2.getLong(1));
					}
					if (rs == 1) {
						System.out.println("Balance have been updated");
						return true;
					}

				}
			}

		} catch (SQLException e) {
			return false;
		}
		return false;
	}

	public void addBalance(long balance) {
		PreparedStatement sql, sql1;
		try {
			sql = con.prepareStatement("update bank set balance=balance + ? where username = ?");
			sql1 = con.prepareStatement("select balance from bank where username = ?");
			sql.setLong(1, balance);
			sql.setString(2, obj.getName());
			sql1.setString(1, obj.getName());
			int rs = sql.executeUpdate();
			ResultSet rs1 = sql1.executeQuery();
			if (rs1.next()) {
				long bal = rs1.getLong(1);
				obj.setBalance(bal);
			}
			if (rs == 1) {
				System.out.println("Balance have been updated");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void transferBalance(String accnumber, long amount) {
		PreparedStatement sql, sql2;
		try {

			sql = con.prepareStatement("update bank set balance=balance + ? where accnumber = ?");
			sql2 = con.prepareStatement("update bank set balance=balance - ? where accnumber = ?");
			sql.setLong(1, amount);
			sql.setString(2, accnumber);
			sql2.setLong(1, amount);
			sql2.setString(2, obj.getAccNumber());
			int rs = sql.executeUpdate();
			sql2.executeUpdate();
			if (rs == 1) {
				System.out.println("Balance have been sent");
				obj.setBalance(obj.getBalance()-amount);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public boolean phonenumberVerification(String phonenumber) {
		PreparedStatement sql;
		String tph = "";
		try {
			if (phonenumber.length() != 10) {
				return false;
			}
			sql = con.prepareStatement("select mobilenumber from bank where username=?");
			sql.setString(1, obj.getName());
			ResultSet rs = sql.executeQuery();
			if (rs.next()) {
				tph = rs.getString(1);
			}
			if (phonenumber.equals(tph)) {
				return true;
			} else {
				return false;
			}
		} catch (SQLException e) {
			return false;
		}
	}

	public void updatePhone(String phonenumber) {
		PreparedStatement sql;
		try {
			sql = con.prepareStatement("update bank set mobilenumber = ? where username = ?");
			sql.setString(1, phonenumber);
			sql.setString(2, obj.getName());
			int rs = sql.executeUpdate();
			if (rs == 1) {
				System.out.println("PhoneNumber have been updated");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public boolean checkAddhar(String addhar) {
		PreparedStatement sql;
		String tph = "";
		try {
			if (addhar.length() != 12) {
				return false;
			}
			sql = con.prepareStatement("select ADDHARNUMBER from bank where username=?");
			sql.setString(1, obj.getName());
			ResultSet rs = sql.executeQuery();
			if (rs.next()) {
				tph = rs.getString(1);
			}
			if (addhar.equals(tph)) {
				return true;
			} else {
				return false;
			}
		} catch (SQLException e) {
			return false;
		}
	}

	public void updatePassword(String password) {
		PreparedStatement sql;
		try {
			sql = con.prepareStatement("update bank set password = ? where username = ?");
			sql.setString(1, password);
			sql.setString(2, obj.getName());
			int rs = sql.executeUpdate();
			if (rs == 1) {
				System.out.println("Password have been updated");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public boolean freezAcc(String username) {
		PreparedStatement sql;
		try {
			sql = con.prepareStatement("update bank set ACTIVATION = '0' where username = ?");
			sql.setString(1, username);
			int rs = sql.executeUpdate();
			if (rs == 1) {
				System.out.println("Account  have been freez");
				return true;
			}
			return false;
		} catch (SQLException e) {
			return false;
		}
	}

	public boolean checkFreez(String username) {
		PreparedStatement sql;
		String tph = "";
		try {

			sql = con.prepareStatement("select ACTIVATION from bank where username=?");
			sql.setString(1, username);
			ResultSet rs = sql.executeQuery();
			if (rs.next()) {
				tph = rs.getString(1);
			}
			if (tph.equals("0")) {
				return true;
			} else {
				return false;
			}
		} catch (SQLException e) {
			return false;
		}
	}

	public boolean accExist(String num) {
		PreparedStatement sql;
		try {
			sql = con.prepareStatement("select * from bank where accnumber=?");
			sql.setString(1, num);
			ResultSet rs = sql.executeQuery();
			if (rs.next()) {
				return true;
			} else {
				return false;
			}
		} catch (SQLException e) {
			return false;
		}
	}
	public boolean validUser(String num) {
		PreparedStatement sql;
		try {
			sql = con.prepareStatement("select * from bank where username=?");
			sql.setString(1, num);
			ResultSet rs = sql.executeQuery();
			if (rs.next()) {
				return true;
			} else {
				return false;
			}
		} catch (SQLException e) {
			return false;
		}
	}

	public boolean balChk(long amont) {
		if ((obj.getBalance() - 500) < amont) {
			return false;
		}
		return true;
	}

	public boolean chkDetails(String name, String accnumber, String addhar, String password) {
		PreparedStatement sql, sql1;
		try {
			sql = con.prepareStatement("select * from bank where username=? and accnumber=? and ADDHARNUMBER =?");
			sql.setString(1, name);
			sql.setString(2, accnumber);
			sql.setString(3, addhar);
			ResultSet rs = sql.executeQuery();
			if (rs.next()) {
				sql1 = con.prepareStatement("update bank set password = ? where username = ?");
				sql1.setString(1, password);
				sql1.setString(2, name);
				int rs1 = sql1.executeUpdate();
				if (rs1 == 1) {
					System.out.println("pass has been changed");
					return true;
				}

			} else {
				return false;
			}
		} catch (SQLException e) {
			return false;
		}
		return false;
	}

	public void addDetails(String username, String accnumber, String address, long balance, String password,
			String mobilenumber, String addharnumber) {

		try {

			// System.out.println(username + " "+ accnumber + " "+address + " "+balance+"
			// "+password+" "+ mobilenumber + " "+addharnumber) ;
			PreparedStatement preparedStmt = con.prepareStatement("insert into bank values(?,?,?,?,?,?,?,'1')");

			preparedStmt.setString(1, username);
			preparedStmt.setString(2, accnumber);
			preparedStmt.setString(3, address);
			preparedStmt.setLong(4, balance);
			preparedStmt.setString(5, password);
			preparedStmt.setString(6, mobilenumber);
			preparedStmt.setString(7, addharnumber);

			int c = preparedStmt.executeUpdate();
			if (c == 1)
				System.out.println("Account  created successfully");

		} catch (SQLException e) {
			System.out.println(e.toString());

		}

	}
   
	public void retriveDetails() {
		PreparedStatement sql;
		try {
			sql = con.prepareStatement("select * from bank");
			ResultSet rs = sql.executeQuery();
			while (rs.next()) {
				String[] arr = new String[8];
				arr[0] = rs.getString(1);
				arr[1] = rs.getString(2);
				arr[2] = rs.getString(3);
				arr[3] = String.valueOf(rs.getLong(4));
				arr[4] = rs.getString(5);
				arr[5] = rs.getString(6);
				arr[6] = rs.getString(7);
				arr[7] = rs.getString(8);

			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
