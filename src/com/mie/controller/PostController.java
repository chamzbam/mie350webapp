package com.mie.controller;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mie.dao.PostDao;
import com.mie.dao.StudentDao;
import com.mie.model.Post;
import com.mie.model.Student;

public class PostController extends HttpServlet {
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
	private static String LIST_POST = "/listPost.jsp";
	private static String LIST_POST_ADMIN = "/listPostAdmin.jsp";

	private PostDao dao;

	/**
	 * Constructor for this class.
	 */
	public PostController() {
		super();
		dao = new PostDao();
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

		  if (action.equalsIgnoreCase("listPost")) {
			forward = LIST_POST;
			request.setAttribute("posts", dao.getAllPosts());
			
		} else if  (action.equalsIgnoreCase("listPostAdmin")) {
			forward = LIST_POST_ADMIN;
			request.setAttribute("posts", dao.getAllPosts());
			
		}else if (action.equalsIgnoreCase("insert")) {
			forward = INSERT;
			
		}
		  
		  else {
			forward = LIST_POST;
			request.setAttribute("posts", dao.getAllPosts());
		}

		RequestDispatcher view = request.getRequestDispatcher(forward);
		view.forward(request, response);
	}
	
	protected void doPost(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException {

		/**
		 * This method retrieves all of the information entered in the form on
		 * the addStudent.jsp or the editStudent.jsp pages.
		 */
		Post post = new Post();
		post.setTitle(request.getParameter("title"));
		post.setBody(request.getParameter("body"));
		post.setDate(new java.util.Date());
		
		
		
		
		/**
		 * If the 'studentid' field in the form is empty, the new student will
		 * be added to the list of Student objects.
		 */
		
			dao.addPost(post);
		
			/**
			 * Otherwise, if the field is already filled (this occurs when the
			 * user is trying to Edit A Student), then the student's information
			 * will be updated accordingly.
			 */
			RequestDispatcher view = request.getRequestDispatcher(LIST_POST);
			
			view.forward(request, response);
		}
		/**
		 * Once the student has been added or updated, the page will redirect to
		 * the listing of students.
		 */
		
	

}