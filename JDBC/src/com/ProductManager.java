package com;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;

public class ProductManager {

	public static void main(String[] args) {

		// createProduct("HP Laptop", 56000);
		// createProduct_PS("Dell Laptop", 61000);
		// updateProductName(1, "HP Envy");
		fetchAllProduct();
		

	}

	

	private static void fetchAllProduct() {
		
		try (Connection connection = DriverManager.getConnection("jdbc:derby://localhost:1527/ProductDB")) {
		
			
			//name= 1; drop products;
			String query = "select * from products" ;
			PreparedStatement preparedStatement = connection.prepareStatement(query);
			ResultSet resultSet =  preparedStatement.executeQuery();
			ResultSetMetaData  resultSetMetaData =  resultSet.getMetaData();
			System.out.println("Table Name: " + resultSetMetaData.getTableName(1));
			System.out.println("Column Count: " + resultSetMetaData.getColumnCount());
			
			
			for (int i = 1; i <= resultSetMetaData.getColumnCount(); i++) {
				System.out.print(resultSetMetaData.getColumnName(i) + "\t\t");
			}
			System.out.println();
			System.out.println("---------------------------------------------------");
			
			while(resultSet.next())
			{
				//System.out.println(resultSet.getInt(1) + "\t\t" + resultSet.getString(2) + "\t\t" + resultSet.getDouble(3));
				System.out.println(resultSet.getInt("id") + "\t\t" + resultSet.getString("name") + "\t\t" + resultSet.getDouble("price"));
			}
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		
	}



	private static void updateProductName(int productID, String name) {

		try (Connection connection = DriverManager.getConnection("jdbc:derby://localhost:1527/ProductDB")) {
			
			String updateStatement = "update products set name=? where id=?";
			PreparedStatement preparedStatement = connection.prepareStatement(updateStatement);
			preparedStatement.setString(1, name);
			preparedStatement.setInt(2, productID);
			
			int rowsAffected = preparedStatement.executeUpdate();
			if(rowsAffected == 1) {
				System.out.println("Product updated");
			}
			else {
				System.out.println("Failed to update");
			}
			
		} catch (SQLException e) {
			
			e.printStackTrace();
		}

	}

	private static void createProduct_PS(String name, double price) {

		try (Connection connection = DriverManager.getConnection("jdbc:derby://localhost:1527/ProductDB")) {

			String insertStatement = "insert into products (name, price) values(?, ?)";// ? -->Position parameter

			PreparedStatement preparedStatement = connection.prepareStatement(insertStatement,
					Statement.RETURN_GENERATED_KEYS);
			preparedStatement.setString(1, name);
			preparedStatement.setDouble(2, price);

			int rowsAffected = preparedStatement.executeUpdate();
			if (rowsAffected == 1) {
				System.out.println("Inserted the product");
				ResultSet resultSet = preparedStatement.getGeneratedKeys();
				if (resultSet.next()) {
					System.out.println("Generated ID: " + resultSet.getInt(1));
				}
			}

		} catch (SQLException e) {

			e.printStackTrace();
		}
	}

	private static void createProduct(String name, double price) {

		try {
			// Load the driver(not required from Java 1.5)
			Class.forName("org.apache.derby.client.ClientAutoloadedDriver");

		} catch (ClassNotFoundException e1) {

			e1.printStackTrace();
		}
		try (Connection connection = DriverManager.getConnection("jdbc:derby://localhost:1527/ProductDB")) {

			Statement st = connection.createStatement();
			String insertStatement = String.format("insert into products (name, price) values('%s', %f)", name, price);
			int rowsAffected = st.executeUpdate(insertStatement, Statement.RETURN_GENERATED_KEYS);
			if (rowsAffected == 1) {
				System.out.println("Inserted the product");
				ResultSet resultSet = st.getGeneratedKeys();
				if (resultSet.next()) {
					System.out.println("Generated ID: " + resultSet.getInt(1));
				}
			}

		} catch (SQLException e) {

			e.printStackTrace();
		}
	}

}
