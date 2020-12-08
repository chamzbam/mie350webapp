package com.mie.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import com.mie.model.Post;
import com.mie.model.Student;
import com.mie.model.Textbook;
import com.mie.util.DbUtil;

public class TextbookDao {

	private Connection connection;
	
	public TextbookDao() {
		/**
		 * Get the database connection.
		 */
		connection = DbUtil.getConnection();
	}

	public void addPost(Textbook textbook) {
		/**
		 * This method adds a new student to the database.
		 */
		try {
			PreparedStatement preparedStatement = connection
					.prepareStatement("insert into Textbooks(TextBook,Description,Price) values (?, ?, ?)");
			// Parameters start with 1
			preparedStatement.setString(1, textbook.getTitle());
			preparedStatement.setString(2, textbook.getBody());
			preparedStatement.setInt(3, textbook.getPrice());
			
			preparedStatement.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	
	
	
	
	
	
	
	public List<Textbook> getAllPosts() {
		/**
		 * This method returns the list of all students in the form of a List
		 * object.
		 */
		List<Textbook> textbooks = new ArrayList<Textbook>();
		try {
			Statement statement = connection.createStatement();
			// System.out.println("getting students from table");
			ResultSet rs = statement.executeQuery("select * from Textbooks");
			while (rs.next()) {
				Textbook textbook = new Textbook();
				textbook.setTitle(rs.getString("TextBook"));
				textbook.setBody(rs.getString("Description"));
				
				textbook.setPrice(rs.getInt("Price"));
				
				
				textbooks.add(textbook);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return textbooks;
	}
	
	

	
	
}
