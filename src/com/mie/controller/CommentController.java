package com.mie.controller;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mie.dao.CommentDao;
import com.mie.dao.PostDao;
import com.mie.dao.StudentDao;
import com.mie.model.Comment;
import com.mie.model.Member;
import com.mie.model.Post;
import com.mie.model.Student;

public class CommentController extends HttpServlet {
	/**
	 * This class handles all insert/edit/list functions of the servlet.
	 * 
	 * These are variables that lead to the appropriate JSP pages. INSERT leads
	 * to the Add A Student page. EDIT leads to the Edit A Student page.
	 * LIST_STUDENT_PUBLIC leads to the public listing of students.
	 * LIST_STUDENT_ADMIN leads to the admin-only listing of students (for them
	 * to modify student information).
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private static String INSERT = "/addPost.jsp";
	private static String EDIT = "/editStudent.jsp";
	private static String LIST_COMMENTS = "/listComments.jsp";
	private static String LIST_POST_ADMIN = "/listPostAdmin.jsp";
	private static String LIST_COMMENTS_ADMIN = "/listPostAdmin.jsp";

	private CommentDao daoC;
	private PostDao    daoP;

	/**
	 * Constructor for this class.
	 */
	public CommentController() {
		super();
		daoC = new CommentDao();
		daoP = new PostDao();
	}
	
	
	
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		/**
		 * This class retrieves the appropriate 'action' found on the JSP pages:
		 * 
		 * - delete will direct the servlet to let the user delete a student in
		 * the database. - insert will direct the servlet to let the user add a
		 * new student to the database. - edit will direct the servlet to let
		 * the user edit student information in the database. - listStudent will
		 * direct the servlet to the public listing of all students in the
		 * database. - listStudentAdmin will direct the servlet to the admin
		 * listing of all students in the database.
		 */
		String forward = "";
		String action = request.getParameter("action");

		 
			
			  String postID_S = (String) request.getParameter("ID");
			  Integer postID = Integer.parseInt(postID_S);
			 
			  ArrayList postComments = null;
			  
			  Iterator<Post> posts = daoP.getAllPosts().iterator(); 
				
				while(posts.hasNext()){
					
					Post p=posts.next();
					
					Iterator<Comment> comments = p.getComments().iterator(); 
					while(comments.hasNext()){
						
						Comment c= comments.next();
						System.out.print(c.getBody());
					}
					
					
					
					
					if(p.getID()==postID){
						
						postComments=new ArrayList(p.getComments());
						
					}
					
										
				}
				
				
				
				
				
			  
			  
			  
			  
			  
			  
			forward = LIST_COMMENTS;
			
			request.setAttribute("comments", postComments);
			
			//request.setAttribute("comments", dao.getAllComments());
			
		
			
		
		  
		  

		RequestDispatcher view = request.getRequestDispatcher(forward);
		view.forward(request, response);
	}


	
	protected void doPost(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException {

		/**
		 * This method retrieves all of the information entered in the form on
		 * the addStudent.jsp or the editStudent.jsp pages.
		 */
		Comment comment = new Comment();
		comment.setBody(request.getParameter("comment"));
		
		String postID_S = request.getParameter("postID");
		comment.setDate(new java.util.Date());
		
		int postID = Integer.parseInt(postID_S);
		comment.setID(postID);
		
		
		
		Iterator<Post> posts = daoP.getAllPosts().iterator(); 
		
		while(posts.hasNext()){
			
			Post p=posts.next();
			
			if(p.getID()==postID){
				
				
				p.addComment(comment);
				daoC.addComment(comment);
				
			}
			
			
			
			
		}
		
		
		
		
		
		/**
		 * If the 'studentid' field in the form is empty, the new student will
		 * be added to the list of Student objects.
		 */
		
		
		
			/**
			 * Otherwise, if the field is already filled (this occurs when the
			 * user is trying to Edit A Student), then the student's information
			 * will be updated accordingly.
			 */
			RequestDispatcher view = request.getRequestDispatcher(LIST_POST_ADMIN);
			
			view.forward(request, response);
		}
		/**
		 * Once the student has been added or updated, the page will redirect to
		 * the listing of students.
		 */
		
	

}