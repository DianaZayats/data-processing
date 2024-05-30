package servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import crud.Lab2CrudInterface;
import entity.Entity;

/**
 * Servlet implementation class EntityServlet1
 */
@WebServlet("/Servlet1")
public class EntityServlet1 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
	ServletConfigInterface servletConfig;
	Lab2CrudInterface lab2Crud;

	public EntityServlet1() {
		super();
		this.servletConfig = new ServletConfig();
		this.lab2Crud = servletConfig.getCrud();
	}
	/**
	* @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	*/
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws
	ServletException, IOException {

		response.setContentType("application/json");
		
		PrintWriter out = response.getWriter();
		out.println("["+lab2Crud.readEntity()+"]");
	}

	protected void doPut(HttpServletRequest request, HttpServletResponse response) throws ServletException{
		String title = request.getParameter("title");
		int age = Integer.parseInt(request.getParameter("age"));
		float width = Float.parseFloat(request.getParameter("width"));
		
		lab2Crud.updateEntity(new Entity(title, age, width));
	}
	}