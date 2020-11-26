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
import com.mie.util.DbUtil;

public class PostDao {

	private Connection connection;
	
	public PostDao() {
		/**
		 * Get the database connection.
		 */
		connection = DbUtil.getConnection();
	}

	public void addPost(Post post) {
		/**
		 * This method adds a new student to the database.
		 */
		try {
			PreparedStatement preparedStatement = connection
					.prepareStatement("insert into Posts(PostTitle,PostBody,Date) values (?, ?, ?)");
			// Parameters start with 1
			preparedStatement.setString(1, post.getTitle());
			preparedStatement.setString(2, post.getBody());
			
			java.sql.Date sDate = new java.sql.Date(post.getDate().getTime());		
			preparedStatement.setDate(3, sDate);
			
			preparedStatement.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	
	public List<Post> getAllPosts() {
		/**
		 * This method returns the list of all students in the form of a List
		 * object.
		 */
		List<Post> posts = new ArrayList<Post>();
		try {
			Statement statement = connection.createStatement();
			// System.out.println("getting students from table");
			ResultSet rs = statement.executeQuery("select * from Posts");
			while (rs.next()) {
				Post post = new Post();
				post.setTitle(rs.getString("PostTitle"));
				post.setBody(rs.getString("PostBody"));
				post.setDate(rs.getDate("Date"));
				
				posts.add(post);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return posts;
	}

	
	
}
