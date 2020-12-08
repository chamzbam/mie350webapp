package com.mie.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import com.mie.model.Comment;
import com.mie.model.Post;
import com.mie.model.Student;
import com.mie.util.DbUtil;

public class CommentDao {

	private Connection connection;
	
	public CommentDao() {
		/**
		 * Get the database connection.
		 */
		connection = DbUtil.getConnection();
	}

	public void addComment(Comment comment) {
		/**
		 * This method adds a new student to the database.
		 */
		try {
			PreparedStatement preparedStatement = connection
					.prepareStatement("insert into Comments(POSTID,Comment,Date) values (?, ?, ?)");
			// Parameters start with 1
			preparedStatement.setInt(1, comment.getID());
			preparedStatement.setString(2, comment.getBody());
			
			java.sql.Date sDate = new java.sql.Date(comment.getDate().getTime());		
			preparedStatement.setDate(3, sDate);
			
			preparedStatement.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	
	public List<Comment> getAllComments() {
		/**
		 * This method returns the list of all students in the form of a List
		 * object.
		 */
		List<Comment> comments = new ArrayList<Comment>();
		try {
			Statement statement = connection.createStatement();
			// System.out.println("getting students from table");
			ResultSet rs = statement.executeQuery("select * from Comments");
			while (rs.next()) {
				Comment	comment = new Comment();
				comment.setID(rs.getInt("POSTID"));
				comment.setBody(rs.getString("Comment"));
				comment.setDate(rs.getDate("Date"));
				
				comments.add(comment);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return comments;
	}

	
	
}
