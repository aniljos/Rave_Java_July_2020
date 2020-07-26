package com;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Transactions {

	
	private static void transfer(int fromId, int toId, double amt) {
		
		Connection connection = null;
		try {
			
			connection = DriverManager.getConnection("jdbc:derby://localhost:1527/ProductDB");
			connection.setAutoCommit(false);
			
			String withdrawStatement = "update accounts set balance = balance - ? where id = ? and balance >= ?";
			String depositStatement = "update accounts set balance = balance + ? where id = ?";
			
			PreparedStatement withdraw_PS = connection.prepareStatement(withdrawStatement);
			withdraw_PS.setDouble(1, amt);
			withdraw_PS.setInt(2, fromId);
			withdraw_PS.setDouble(3, amt);
			int rowsAffected = withdraw_PS.executeUpdate();
			
			if(rowsAffected == 1) {
				
				System.out.println("Withdraw successful");
				PreparedStatement deposit_PS = connection.prepareStatement(depositStatement);
				deposit_PS.setDouble(1, amt);
				deposit_PS.setInt(2, toId);
				rowsAffected =  deposit_PS.executeUpdate();
				if(rowsAffected ==1) {
					System.out.println("Deposit Successfull");
					System.out.println("Transfer Done!!");
					connection.commit();
				}
				else {
					System.out.println("Deposit failed");
					System.out.println("Transfer failed!!");
					connection.rollback();
				}
			}
			else {
				System.out.println("Withdraw failed");
				System.out.println("Transfer failed!!");
				connection.rollback();
			}
		} catch (SQLException e) {
			
			//e.printStackTrace();
			System.out.println("Transfer failed!!" + e.getMessage());
			try {
				connection.rollback();
			} catch (SQLException e1) {
				
				e1.printStackTrace();
			}
		}
		finally {
			try {
				connection.close();
			} catch (SQLException e) {
				
				e.printStackTrace();
			}
		}
		
		
	}
	
	
	public static void main(String[] args) {
		
		//transfer(1, 2, 100);
		//transfer(1, 2, 1_00_000);
		transfer(1, 3, 100);
		
	}

}







